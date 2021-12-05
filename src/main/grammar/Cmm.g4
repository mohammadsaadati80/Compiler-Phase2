grammar Cmm;

@header{
     import main.ast.nodes.*;
     import main.ast.nodes.declaration.*;
     import main.ast.nodes.declaration.struct.*;
     import main.ast.nodes.expression.*;
     import main.ast.nodes.expression.operators.*;
     import main.ast.nodes.expression.values.*;
     import main.ast.nodes.expression.values.primitive.*;
     import main.ast.nodes.statement.*;
     import main.ast.types.*;
     import main.ast.types.primitives.*;
     import java.util.*;
 }

cmm returns[Program cmmProgram]:
    NEWLINE* p = program {$cmmProgram = $p.programRet;} NEWLINE* EOF;

program returns[Program programRet]:
    {$programRet = new Program();
     int line = 1;
     $programRet.setLine(line);}
    (s = structDeclaration {$programRet.addStruct($s.structDeclarationRet);})*
    (f = functionDeclaration {$programRet.addFunction($f.functionDeclarationRet);})*
    m = main {$programRet.setMain($m.mainRet);};

main returns[MainDeclaration mainRet]:
	{$mainRet = new MainDeclaration();}
    MAIN LPAR RPAR {$mainRet.setLine($MAIN.getLine());}
    b = body {$mainRet.setBody($b.bodyRet);};

structDeclaration returns[StructDeclaration structDeclarationRet]:
	{$structDeclarationRet = new StructDeclaration();}
    s = STRUCT i = identifier {$structDeclarationRet.setStructName($i.identifierRet);}
    ((ll = BEGIN sb = structBody {$structDeclarationRet.setBody($sb.bodyRet); $sb.bodyRet.setLine($ll.getLine());}
    NEWLINE+ END)
    | (NEWLINE+ sbs = singleStatementStructBody {$structDeclarationRet.setBody($sbs.stm);} SEMICOLON?)) NEWLINE+
    {$structDeclarationRet.setLine($s.getLine());};

singleVarWithGetAndSet returns[SetGetVarDeclaration sgvd]:
	{$sgvd = new SetGetVarDeclaration();}
    t = type i = identifier arg = functionArgsDec BEGIN NEWLINE+ s = setBody g = getBody END
    {$sgvd.setVarName($i.identifierRet);
	 $sgvd.setVarType($t.typeRet);
	 $sgvd.setArgs($arg.funcArgDecRet);
	 $sgvd.setSetterBody($s.bodyRet);
	 $sgvd.setGetterBody($g.bodyRet);
	 $sgvd.setLine($i.identifierRet.getLine());
    };

singleStatementStructBody returns[Statement stm]:
    vs = varDecStatement {$stm = $vs.vds;}
    | s = singleVarWithGetAndSet {$stm = $s.sgvd;};

structBody returns [BlockStmt bodyRet]:
	{$bodyRet = new BlockStmt();}
    (NEWLINE+ (ss_ = singleStatementStructBody {$bodyRet.addStatement($ss_.stm);} SEMICOLON)*
    ss = singleStatementStructBody {$bodyRet.addStatement($ss.stm);} SEMICOLON?)+;

getBody returns[Statement bodyRet]:
    GET b = body {$bodyRet = $b.bodyRet;} NEWLINE+;

setBody returns[Statement bodyRet]:
    SET b = body {$bodyRet = $b.bodyRet;} NEWLINE+;

functionDeclaration returns[FunctionDeclaration functionDeclarationRet]:
	{$functionDeclarationRet = new FunctionDeclaration();}
    (r = type {$functionDeclarationRet.setReturnType($r.typeRet);}
    | VOID {$functionDeclarationRet.setReturnType(new VoidType());})
    i = identifier arg = functionArgsDec b = body NEWLINE+
    {$functionDeclarationRet.setFunctionName($i.identifierRet);
     $functionDeclarationRet.setArgs($arg.funcArgDecRet);
     $functionDeclarationRet.setBody($b.bodyRet);
     $functionDeclarationRet.setLine($i.identifierRet.getLine());};

functionArgsDec returns[ArrayList<VariableDeclaration> funcArgDecRet] locals[VariableDeclaration var]:
	{$funcArgDecRet = new ArrayList<>();}
    LPAR (tf = type if_ = identifier
    {$var = new VariableDeclaration($if_.identifierRet,$tf.typeRet);
     $var.setLine($if_.identifierRet.getLine());
     $funcArgDecRet.add($var);}
    (COMMA ts = type is = identifier
    {$var = new VariableDeclaration($is.identifierRet,$ts.typeRet);
	 $var.setLine($if_.identifierRet.getLine());
	 $funcArgDecRet.add($var);})*)? RPAR;

functionArguments returns[ExprInPar exp]  locals[ArrayList<Expression> arg]:
	{$arg = new ArrayList<>();}
    (ef = expression {$arg.add($ef.expRet);} (COMMA es = expression {$arg.add($es.expRet);})*)?
    {$exp = new ExprInPar($arg);};

body returns[Statement bodyRet]:
     (b = blockStatement {$bodyRet = $b.stm;}
     | (NEWLINE+ s = singleStatement {$bodyRet = $s.stm;} (SEMICOLON)?));

loopCondBody returns[Statement bodyRet]:
     (b = blockStatement {$bodyRet = $b.stm;}
     | (NEWLINE+ s = singleStatement {$bodyRet = $s.stm;}));

blockStatement returns[BlockStmt stm]:
	{$stm = new BlockStmt();}
	ll = BEGIN (NEWLINE+ (ss_ = singleStatement {$stm.addStatement($ss_.stm);} SEMICOLON)*
	ss = singleStatement {$stm.addStatement($ss.stm);} (SEMICOLON)?)+ NEWLINE+ END
	{$stm.setLine($ll.getLine());};

varDecStatement returns[VarDecStmt vds] locals[VariableDeclaration vd]:
	{$vds = new VarDecStmt();}
    t = type i = identifier {$vd = new VariableDeclaration($i.identifierRet,$t.typeRet);
    $vd.setLine($i.identifierRet.getLine());}
    (ASSIGN exp = orExpression {$vd.setDefaultValue($exp.exp);})? {$vds.addVar($vd);}
    (COMMA im = identifier {$vd = new VariableDeclaration($im.identifierRet,$t.typeRet);
    $vd.setLine($im.identifierRet.getLine());}
    (ASSIGN expm = orExpression {$vd.setDefaultValue($expm.exp);})? {$vds.addVar($vd);})*
    {$vds.setLine($i.identifierRet.getLine());};

functionCallStmt returns[FunctionCallStmt funcCallRet] locals[Expression exp , FunctionCall funcCall]:
     e = otherExpression {$exp = $e.expRet;}
     ((ll1 = LPAR fa = functionArguments {$exp = new FunctionCall($exp, $fa.exp.getInputs());
     $fa.exp.setLine($ll1.getLine()); $exp.setLine($ll1.getLine());} RPAR)
     | (ll3 = DOT i = identifier {$exp = new StructAccess($exp, $i.identifierRet);
     $exp.setLine($ll3.getLine());}))*
     (ll2 = LPAR fa2 = functionArguments {$funcCall = new FunctionCall($exp,$fa2.exp.getInputs());
     $funcCall.setLine($ll2.getLine());
     $funcCallRet = new FunctionCallStmt($funcCall);
     $fa2.exp.setLine($ll2.getLine());
     $funcCallRet.setLine($ll2.getLine());} RPAR);

returnStatement returns[ReturnStmt stm]:
	{$stm = new ReturnStmt();}
    ll = RETURN (e = expression {$stm.setReturnedExpr($e.expRet);})?
    {$stm.setLine($ll.getLine());};

ifStatement returns[ConditionalStmt stm]:
    ll = IF e = expression {$stm = new ConditionalStmt($e.expRet);}
    (l = loopCondBody {$stm.setThenBody($l.bodyRet);}
    | b = body el = elseStatement {$stm.setThenBody($b.bodyRet); $stm.setElseBody($el.stm);})
    {$stm.setLine($ll.getLine());};

elseStatement returns[Statement stm]:
     NEWLINE* ELSE l = loopCondBody {$stm = $l.bodyRet;};

loopStatement returns[LoopStmt loop]:
    w = whileLoopStatement {$loop = $w.loop;} | d = doWhileLoopStatement {$loop = $d.loop;};

whileLoopStatement returns[LoopStmt loop]:
	{$loop = new LoopStmt();}
    ll = WHILE c = expression b = loopCondBody
    {$loop.setCondition($c.expRet);
     $loop.setBody($b.bodyRet);}
     {$loop.setLine($ll.getLine());};

doWhileLoopStatement returns[LoopStmt loop]:
	{$loop = new LoopStmt();}
    ll = DO b = body NEWLINE* WHILE c = expression
    {$loop.setCondition($c.expRet);
     $loop.setBody($b.bodyRet);}
     {$loop.setLine($ll.getLine());};

displayStatement returns[DisplayStmt display]:
  ll = DISPLAY LPAR e = expression RPAR
  {$display = new DisplayStmt($e.expRet);}
  {$display.setLine($ll.getLine());};

assignmentStatement returns[AssignmentStmt assign]:
    l = orExpression ll = ASSIGN r = expression
    {$assign = new AssignmentStmt($l.exp,$r.expRet);}
    {$assign.setLine($ll.getLine());};

singleStatement returns[Statement stm]:
    is = ifStatement {$stm = $is.stm;}
    | ds = displayStatement {$stm = $ds.display;}
    | fs = functionCallStmt {$stm = $fs.funcCallRet;}
    | rs = returnStatement {$stm = $rs.stm;}
    | as = assignmentStatement {$stm = $as.assign;}
    | vds = varDecStatement {$stm = $vds.vds;}
    | ls = loopStatement {$stm = $ls.loop;}
    | s = size {$stm = $s.sizeRet;}
    | a = append {$stm = $a.apRet;};

expression returns[Expression expRet]:
    exp1 = orExpression {$expRet = $exp1.exp;}
    (op = ASSIGN exp2 = expression {$expRet = new BinaryExpression($exp1.exp,$exp2.expRet,BinaryOperator.assign);
    $expRet.setLine($op.getLine());})?;

orExpression returns[Expression exp]:
    exp1 = andExpression {$exp = $exp1.exp;}
    (op = OR exp2 = andExpression {$exp = new BinaryExpression($exp1.exp,$exp2.exp,BinaryOperator.or);
    $exp.setLine($op.getLine());})*;

andExpression returns[Expression exp]:
    exp1 = equalityExpression {$exp = $exp1.exp;}
    (op = AND exp2 = equalityExpression {$exp = new BinaryExpression($exp1.exp,$exp2.exp,BinaryOperator.and);
    $exp.setLine($op.getLine());})*;

equalityExpression returns[Expression exp]:
    exp1 = relationalExpression {$exp = $exp1.exp;}
    (op = EQUAL exp2 = relationalExpression {$exp = new BinaryExpression($exp1.exp,$exp2.exp,BinaryOperator.eq);
    $exp.setLine($op.getLine());})*;

relationalExpression returns[Expression exp] locals[BinaryOperator op]:
    exp1 = additiveExpression {$exp = $exp1.exp;}
    ((ll = GREATER_THAN {$op = BinaryOperator.gt;} | ll = LESS_THAN {$op = BinaryOperator.lt;}) exp2 = additiveExpression
    {$exp = new BinaryExpression($exp1.exp,$exp2.exp,$op); $exp.setLine($ll.getLine());})*;

additiveExpression returns[Expression exp] locals[BinaryOperator op]:
    exp1 = multiplicativeExpression {$exp = $exp1.exp;}
    ((ll = PLUS {$op = BinaryOperator.add;} | ll = MINUS {$op = BinaryOperator.sub;}) exp2 = multiplicativeExpression
    {$exp = new BinaryExpression($exp1.exp,$exp2.exp,$op); $exp.setLine($ll.getLine());})*;

multiplicativeExpression returns[Expression exp]  locals[BinaryOperator op]:
    exp1 = preUnaryExpression {$exp = $exp1.expRet;}
    ((ll = MULT {$op = BinaryOperator.mult;} | ll = DIVIDE {$op = BinaryOperator.div;}) exp2 = preUnaryExpression
    {$exp = new BinaryExpression($exp1.expRet,$exp2.expRet,$op); $exp.setLine($ll.getLine());})*;

preUnaryExpression returns[Expression expRet] locals[UnaryOperator op]:
    ((ll = NOT {$op = UnaryOperator.not;} | ll = MINUS {$op = UnaryOperator.minus;}) e = preUnaryExpression)
    {$expRet = new UnaryExpression($e.expRet,$op); $expRet.setLine($ll.getLine());}
    | ae = accessExpression {$expRet = $ae.expRet;};

accessExpression returns[Expression expRet]:
	exp1 = otherExpression {$expRet = $exp1.expRet;}
	((ll = LPAR arg = functionArguments {$expRet = $arg.exp; $arg.exp.setLine($ll.getLine());} RPAR)
	| (ll = DOT i = identifier {$expRet = new StructAccess($expRet,$i.identifierRet);
	$expRet.setLine($ll.getLine());}))*
	((ll = LBRACK exp2 = expression {$expRet = new ListAccessByIndex($expRet,$exp2.expRet);
	$expRet.setLine($ll.getLine());} RBRACK)
	| (ll = DOT i = identifier {$expRet = new StructAccess($expRet,$i.identifierRet);
	$expRet.setLine($ll.getLine());}))*;

otherExpression returns[Expression expRet]:
    v = value {$expRet = $v.valRet;}
    | i = identifier {$expRet = $i.identifierRet;}
    | ll = LPAR (ar = functionArguments) RPAR {$expRet = $ar.exp; $ar.exp.setLine($ll.getLine());}
    | s = size {$expRet = $s.sizeRet.getListSizeExpr();}
    | a = append {$expRet = $a.apRet.getListAppendExpr();};

size returns[ListSizeStmt sizeRet] locals[ListSize ls]:
    ll = SIZE LPAR e = expression RPAR
    {$ls = new ListSize($e.expRet);
     $ls.setLine($ll.getLine());
     $sizeRet = new ListSizeStmt($ls);};

append returns[ListAppendStmt apRet] locals[ListAppend la]:
    ll = APPEND LPAR l = expression COMMA r = expression RPAR
    {$la = new ListAppend($l.expRet,$r.expRet);
     $la.setLine($ll.getLine());
     $apRet = new ListAppendStmt($la);
     $apRet.setLine($ll.getLine());};

value returns[Value valRet]:
    bv = boolValue {$valRet = $bv.boolValRet;}
    | iv = INT_VALUE {$valRet = new IntValue(Integer.parseInt($iv.getText()));}
    {$valRet.setLine($iv.getLine());};

boolValue returns[BoolValue boolValRet]:
    ll = TRUE {$boolValRet = new BoolValue(true); $boolValRet.setLine($ll.getLine());}
    | ll = FALSE {$boolValRet = new BoolValue(false); $boolValRet.setLine($ll.getLine());};

identifier returns[Identifier identifierRet]:
    IDENTIFIER {$identifierRet = new Identifier($IDENTIFIER.getText());
    			$identifierRet.setLine($IDENTIFIER.getLine());};

type returns[Type typeRet]:
    INT {$typeRet = new IntType();}
    | BOOL {$typeRet = new BoolType();}
    | LIST SHARP t = type {$typeRet = new ListType($t.typeRet);}
    | STRUCT i = identifier {$typeRet = new StructType($i.identifierRet);}
    | ft = fptrType {$typeRet = $ft.fptrTypeRet;};

fptrType returns[FptrType fptrTypeRet] locals [ArrayList<Type> list]:
	{$list = new ArrayList<>();}
    FPTR LESS_THAN (VOID | (o = type {$list.add($o.typeRet);}(COMMA m = type {$list.add($m.typeRet);})*))
    ARROW (t = type {$fptrTypeRet = new FptrType($list,$t.typeRet);}
    | VOID {$fptrTypeRet = new FptrType($list,new VoidType());}) GREATER_THAN;

MAIN: 'main';
RETURN: 'return';
VOID: 'void';

SIZE: 'size';
DISPLAY: 'display';
APPEND: 'append';

IF: 'if';
ELSE: 'else';

PLUS: '+';
MINUS: '-';
MULT: '*';
DIVIDE: '/';


EQUAL: '==';
ARROW: '->';
GREATER_THAN: '>';
LESS_THAN: '<';


AND: '&';
OR: '|';
NOT: '~';

TRUE: 'true';
FALSE: 'false';

BEGIN: 'begin';
END: 'end';

INT: 'int';
BOOL: 'bool';
LIST: 'list';
STRUCT: 'struct';
FPTR: 'fptr';
GET: 'get';
SET: 'set';
WHILE: 'while';
DO: 'do';

ASSIGN: '=';
SHARP: '#';
LPAR: '(';
RPAR: ')';
LBRACK: '[';
RBRACK: ']';

COMMA: ',';
DOT: '.';
SEMICOLON: ';';
NEWLINE: '\n';

INT_VALUE: '0' | [1-9][0-9]*;
IDENTIFIER: [a-zA-Z_][A-Za-z0-9_]*;


COMMENT: ('/*' .*? '*/') -> skip;
WS: ([ \t\r]) -> skip;