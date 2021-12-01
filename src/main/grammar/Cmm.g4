grammar Cmm;
// todo setLine hame monde va bayad check beshe
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
    ((BEGIN sb = structBody {$structDeclarationRet.setBody($sb.bodyRet);} NEWLINE+ END)
    | (NEWLINE+ sbs = singleStatementStructBody {$structDeclarationRet.setBody($sbs.stm);} SEMICOLON?)) NEWLINE+;

singleVarWithGetAndSet returns[SetGetVarDeclaration sgvd]:
	{$sgvd = new SetGetVarDeclaration();}
    t = type i = identifier arg = functionArgsDec BEGIN NEWLINE+ s = setBody g = getBody END
    {$sgvd.setVarName($i.identifierRet);
	 $sgvd.setVarType($t.typeRet);
	 $sgvd.setArgs($arg.funcArgDecRet);
	 $sgvd.setSetterBody($s.bodyRet);
	 $sgvd.setGetterBody($g.bodyRet);
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
     $functionDeclarationRet.setBody($b.bodyRet);};

functionArgsDec returns[ArrayList<VariableDeclaration> funcArgDecRet]:
	{$funcArgDecRet = new ArrayList<>();}
    LPAR (tf = type if_ = identifier {$funcArgDecRet.add(new VariableDeclaration($if_.identifierRet,$tf.typeRet));}
    (COMMA ts = type is = identifier {$funcArgDecRet.add(new VariableDeclaration($is.identifierRet,$ts.typeRet));})*)?
    RPAR;

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
	BEGIN (NEWLINE+ (ss_ = singleStatement {$stm.addStatement($ss_.stm);} SEMICOLON)*
	ss = singleStatement {$stm.addStatement($ss.stm);} (SEMICOLON)?)+ NEWLINE+ END;

varDecStatement returns[VarDecStmt vds] locals[VariableDeclaration vd]:
	{$vds = new VarDecStmt();}
    t = type i = identifier {$vd = new VariableDeclaration($i.identifierRet,$t.typeRet);}
    (ASSIGN exp = orExpression {$vd.setDefaultValue($exp.exp);})? {$vds.addVar($vd);}
    (COMMA im = identifier {$vd = new VariableDeclaration($im.identifierRet,$t.typeRet);}
    (ASSIGN expm = orExpression {$vd.setDefaultValue($expm.exp);})? {$vds.addVar($vd);})*;

// todo mashkok
functionCallStmt returns[FunctionCallStmt funcCallRet] locals[Expression exp , FunctionCall funcCall]:
     e = otherExpression {$exp = $e.expRet;}
     ((LPAR fa = functionArguments {$exp = new FunctionCall($exp, $fa.exp.getInputs());} RPAR)
     | (DOT i = identifier {$exp = new StructAccess($exp, $i.identifierRet);}))*
     (LPAR fa2 = functionArguments {$funcCallRet = new FunctionCallStmt($funcCall);} RPAR);

returnStatement returns[ReturnStmt stm]:
	{$stm = new ReturnStmt();}
    RETURN (e = expression {$stm.setReturnedExpr($e.expRet);})?;

ifStatement returns[ConditionalStmt stm]:
    IF e = expression {$stm = new ConditionalStmt($e.expRet);}
    (l = loopCondBody {$stm.setThenBody($l.bodyRet);}
    | b = body el = elseStatement {$stm.setThenBody($b.bodyRet); $stm.setElseBody($el.stm);});

elseStatement returns[Statement stm]:
     NEWLINE* ELSE l = loopCondBody {$stm = $l.bodyRet;};

loopStatement returns[LoopStmt loop]:
    w = whileLoopStatement {$loop = $w.loop;} | d = doWhileLoopStatement {$loop = $d.loop;};

whileLoopStatement returns[LoopStmt loop]:
	{$loop = new LoopStmt();}
    WHILE c = expression b = loopCondBody
    {$loop.setCondition($c.expRet);
     $loop.setBody($b.bodyRet);};

doWhileLoopStatement returns[LoopStmt loop]:
	{$loop = new LoopStmt();}
    DO b = body NEWLINE* WHILE c = expression
    {$loop.setCondition($c.expRet);
     $loop.setBody($b.bodyRet);};

//todo
displayStatement :
  DISPLAY LPAR expression RPAR;

//todo
assignmentStatement :
    orExpression ASSIGN expression;

//todo
singleStatement returns[Statement stm]:
    ifStatement | displayStatement | functionCallStmt | returnStatement | assignmentStatement
    | varDecStatement | loopStatement | append | size;

//todo
expression returns[Expression expRet]:
    orExpression (op = ASSIGN expression )? ;

//todo
orExpression returns[Expression exp]:
    andExpression (op = OR andExpression )*;

//todo
andExpression:
    equalityExpression (op = AND equalityExpression )*;

//todo
equalityExpression:
    relationalExpression (op = EQUAL relationalExpression )*;

//todo
relationalExpression:
    additiveExpression ((op = GREATER_THAN | op = LESS_THAN) additiveExpression )*;

//todo
additiveExpression:
    multiplicativeExpression ((op = PLUS | op = MINUS) multiplicativeExpression )*;

//todo
multiplicativeExpression:
    preUnaryExpression ((op = MULT | op = DIVIDE) preUnaryExpression )*;

preUnaryExpression returns[Expression expRet]:
    (op = (NOT |MINUS) e = preUnaryExpression)
    {$expRet = new UnaryExpression($e.expRet,UnaryOperator.valueOf($op.getText()));}
    | ae = accessExpression {$expRet = $ae.expRet;};

accessExpression returns[Expression expRet]:
    f = otherExpression ((LPAR functionArguments RPAR) | (DOT identifier))* ((LBRACK expression RBRACK) | (DOT identifier))*
    /*{$expRet = new BinaryExpression($f.expRet,,BinaryOperator.assign);}*/; // todo nemidonam

otherExpression returns[Expression expRet]:
    v = value {$expRet = $v.valRet;}
    | i = identifier {$expRet = $i.identifierRet;}
    | LPAR (ar = functionArguments) RPAR {$expRet = $ar.exp;}
    | s = size /*{$expRet = $s.sizeRet;}*/ // todo bayad exp bashe
    | a = append /*{$expRet = $a.apRet;}*/; // todo bayad exp bashe

// todo mitone ham stmt bash ham exp
size returns[ListSizeStmt sizeRet] locals[ListSize ls]:
    SIZE LPAR e = expression RPAR
    {$ls = new ListSize($e.expRet);
     $sizeRet = new ListSizeStmt($ls);};

// todo mitone ham stmt bash ham exp
append returns[ListAppendStmt apRet] locals[ListAppend la]:
    APPEND LPAR l = expression COMMA r = expression RPAR
    {$la = new ListAppend($l.expRet,$r.expRet);
     $apRet = new ListAppendStmt($la);};

value returns[Value valRet]:
    bv = boolValue {$valRet = $bv.boolValRet;}
    | iv = INT_VALUE {$valRet = new IntValue(Integer.parseInt($iv.getText()));};

boolValue returns[BoolValue boolValRet]:
    TRUE {$boolValRet = new BoolValue(true);} | FALSE {$boolValRet = new BoolValue(false);};

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