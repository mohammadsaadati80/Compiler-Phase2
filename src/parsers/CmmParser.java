// Generated from C:/Users/SM2A/IdeaProjects/PLC_P2/src/main/grammar\Cmm.g4 by ANTLR 4.9.2
package parsers;

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
 
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class CmmParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.9.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		MAIN=1, RETURN=2, VOID=3, SIZE=4, DISPLAY=5, APPEND=6, IF=7, ELSE=8, PLUS=9, 
		MINUS=10, MULT=11, DIVIDE=12, EQUAL=13, ARROW=14, GREATER_THAN=15, LESS_THAN=16, 
		AND=17, OR=18, NOT=19, TRUE=20, FALSE=21, BEGIN=22, END=23, INT=24, BOOL=25, 
		LIST=26, STRUCT=27, FPTR=28, GET=29, SET=30, WHILE=31, DO=32, ASSIGN=33, 
		SHARP=34, LPAR=35, RPAR=36, LBRACK=37, RBRACK=38, COMMA=39, DOT=40, SEMICOLON=41, 
		NEWLINE=42, INT_VALUE=43, IDENTIFIER=44, COMMENT=45, WS=46;
	public static final int
		RULE_cmm = 0, RULE_program = 1, RULE_main = 2, RULE_structDeclaration = 3, 
		RULE_singleVarWithGetAndSet = 4, RULE_singleStatementStructBody = 5, RULE_structBody = 6, 
		RULE_getBody = 7, RULE_setBody = 8, RULE_functionDeclaration = 9, RULE_functionArgsDec = 10, 
		RULE_functionArguments = 11, RULE_body = 12, RULE_loopCondBody = 13, RULE_blockStatement = 14, 
		RULE_varDecStatement = 15, RULE_functionCallStmt = 16, RULE_returnStatement = 17, 
		RULE_ifStatement = 18, RULE_elseStatement = 19, RULE_loopStatement = 20, 
		RULE_whileLoopStatement = 21, RULE_doWhileLoopStatement = 22, RULE_displayStatement = 23, 
		RULE_assignmentStatement = 24, RULE_singleStatement = 25, RULE_expression = 26, 
		RULE_orExpression = 27, RULE_andExpression = 28, RULE_equalityExpression = 29, 
		RULE_relationalExpression = 30, RULE_additiveExpression = 31, RULE_multiplicativeExpression = 32, 
		RULE_preUnaryExpression = 33, RULE_accessExpression = 34, RULE_otherExpression = 35, 
		RULE_size = 36, RULE_append = 37, RULE_value = 38, RULE_boolValue = 39, 
		RULE_identifier = 40, RULE_type = 41, RULE_fptrType = 42;
	private static String[] makeRuleNames() {
		return new String[] {
			"cmm", "program", "main", "structDeclaration", "singleVarWithGetAndSet", 
			"singleStatementStructBody", "structBody", "getBody", "setBody", "functionDeclaration", 
			"functionArgsDec", "functionArguments", "body", "loopCondBody", "blockStatement", 
			"varDecStatement", "functionCallStmt", "returnStatement", "ifStatement", 
			"elseStatement", "loopStatement", "whileLoopStatement", "doWhileLoopStatement", 
			"displayStatement", "assignmentStatement", "singleStatement", "expression", 
			"orExpression", "andExpression", "equalityExpression", "relationalExpression", 
			"additiveExpression", "multiplicativeExpression", "preUnaryExpression", 
			"accessExpression", "otherExpression", "size", "append", "value", "boolValue", 
			"identifier", "type", "fptrType"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'main'", "'return'", "'void'", "'size'", "'display'", "'append'", 
			"'if'", "'else'", "'+'", "'-'", "'*'", "'/'", "'=='", "'->'", "'>'", 
			"'<'", "'&'", "'|'", "'~'", "'true'", "'false'", "'begin'", "'end'", 
			"'int'", "'bool'", "'list'", "'struct'", "'fptr'", "'get'", "'set'", 
			"'while'", "'do'", "'='", "'#'", "'('", "')'", "'['", "']'", "','", "'.'", 
			"';'", "'\n'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "MAIN", "RETURN", "VOID", "SIZE", "DISPLAY", "APPEND", "IF", "ELSE", 
			"PLUS", "MINUS", "MULT", "DIVIDE", "EQUAL", "ARROW", "GREATER_THAN", 
			"LESS_THAN", "AND", "OR", "NOT", "TRUE", "FALSE", "BEGIN", "END", "INT", 
			"BOOL", "LIST", "STRUCT", "FPTR", "GET", "SET", "WHILE", "DO", "ASSIGN", 
			"SHARP", "LPAR", "RPAR", "LBRACK", "RBRACK", "COMMA", "DOT", "SEMICOLON", 
			"NEWLINE", "INT_VALUE", "IDENTIFIER", "COMMENT", "WS"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "Cmm.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public CmmParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class CmmContext extends ParserRuleContext {
		public Program cmmProgram;
		public ProgramContext p;
		public TerminalNode EOF() { return getToken(CmmParser.EOF, 0); }
		public ProgramContext program() {
			return getRuleContext(ProgramContext.class,0);
		}
		public List<TerminalNode> NEWLINE() { return getTokens(CmmParser.NEWLINE); }
		public TerminalNode NEWLINE(int i) {
			return getToken(CmmParser.NEWLINE, i);
		}
		public CmmContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cmm; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CmmListener ) ((CmmListener)listener).enterCmm(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CmmListener ) ((CmmListener)listener).exitCmm(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CmmVisitor ) return ((CmmVisitor<? extends T>)visitor).visitCmm(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CmmContext cmm() throws RecognitionException {
		CmmContext _localctx = new CmmContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_cmm);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(89);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==NEWLINE) {
				{
				{
				setState(86);
				match(NEWLINE);
				}
				}
				setState(91);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(92);
			((CmmContext)_localctx).p = program();
			((CmmContext)_localctx).cmmProgram =  ((CmmContext)_localctx).p.programRet;
			setState(97);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==NEWLINE) {
				{
				{
				setState(94);
				match(NEWLINE);
				}
				}
				setState(99);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(100);
			match(EOF);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ProgramContext extends ParserRuleContext {
		public Program programRet;
		public StructDeclarationContext s;
		public FunctionDeclarationContext f;
		public MainContext m;
		public MainContext main() {
			return getRuleContext(MainContext.class,0);
		}
		public List<StructDeclarationContext> structDeclaration() {
			return getRuleContexts(StructDeclarationContext.class);
		}
		public StructDeclarationContext structDeclaration(int i) {
			return getRuleContext(StructDeclarationContext.class,i);
		}
		public List<FunctionDeclarationContext> functionDeclaration() {
			return getRuleContexts(FunctionDeclarationContext.class);
		}
		public FunctionDeclarationContext functionDeclaration(int i) {
			return getRuleContext(FunctionDeclarationContext.class,i);
		}
		public ProgramContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_program; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CmmListener ) ((CmmListener)listener).enterProgram(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CmmListener ) ((CmmListener)listener).exitProgram(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CmmVisitor ) return ((CmmVisitor<? extends T>)visitor).visitProgram(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ProgramContext program() throws RecognitionException {
		ProgramContext _localctx = new ProgramContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_program);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			((ProgramContext)_localctx).programRet =  new Program();
			     int line = 1;
			     _localctx.programRet.setLine(line);
			setState(108);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,2,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(103);
					((ProgramContext)_localctx).s = structDeclaration();
					_localctx.programRet.addStruct(((ProgramContext)_localctx).s.structDeclarationRet);
					}
					} 
				}
				setState(110);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,2,_ctx);
			}
			setState(116);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << VOID) | (1L << INT) | (1L << BOOL) | (1L << LIST) | (1L << STRUCT) | (1L << FPTR))) != 0)) {
				{
				{
				setState(111);
				((ProgramContext)_localctx).f = functionDeclaration();
				_localctx.programRet.addFunction(((ProgramContext)_localctx).f.functionDeclarationRet);
				}
				}
				setState(118);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(119);
			((ProgramContext)_localctx).m = main();
			_localctx.programRet.setMain(((ProgramContext)_localctx).m.mainRet);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class MainContext extends ParserRuleContext {
		public MainDeclaration mainRet;
		public Token MAIN;
		public BodyContext b;
		public TerminalNode MAIN() { return getToken(CmmParser.MAIN, 0); }
		public TerminalNode LPAR() { return getToken(CmmParser.LPAR, 0); }
		public TerminalNode RPAR() { return getToken(CmmParser.RPAR, 0); }
		public BodyContext body() {
			return getRuleContext(BodyContext.class,0);
		}
		public MainContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_main; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CmmListener ) ((CmmListener)listener).enterMain(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CmmListener ) ((CmmListener)listener).exitMain(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CmmVisitor ) return ((CmmVisitor<? extends T>)visitor).visitMain(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MainContext main() throws RecognitionException {
		MainContext _localctx = new MainContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_main);
		try {
			enterOuterAlt(_localctx, 1);
			{
			((MainContext)_localctx).mainRet =  new MainDeclaration();
			setState(123);
			((MainContext)_localctx).MAIN = match(MAIN);
			setState(124);
			match(LPAR);
			setState(125);
			match(RPAR);
			_localctx.mainRet.setLine(((MainContext)_localctx).MAIN.getLine());
			setState(127);
			((MainContext)_localctx).b = body();
			_localctx.mainRet.setBody(((MainContext)_localctx).b.bodyRet);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class StructDeclarationContext extends ParserRuleContext {
		public StructDeclaration structDeclarationRet;
		public Token s;
		public IdentifierContext i;
		public Token ll;
		public StructBodyContext sb;
		public SingleStatementStructBodyContext sbs;
		public TerminalNode STRUCT() { return getToken(CmmParser.STRUCT, 0); }
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public List<TerminalNode> NEWLINE() { return getTokens(CmmParser.NEWLINE); }
		public TerminalNode NEWLINE(int i) {
			return getToken(CmmParser.NEWLINE, i);
		}
		public TerminalNode END() { return getToken(CmmParser.END, 0); }
		public TerminalNode BEGIN() { return getToken(CmmParser.BEGIN, 0); }
		public StructBodyContext structBody() {
			return getRuleContext(StructBodyContext.class,0);
		}
		public SingleStatementStructBodyContext singleStatementStructBody() {
			return getRuleContext(SingleStatementStructBodyContext.class,0);
		}
		public TerminalNode SEMICOLON() { return getToken(CmmParser.SEMICOLON, 0); }
		public StructDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_structDeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CmmListener ) ((CmmListener)listener).enterStructDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CmmListener ) ((CmmListener)listener).exitStructDeclaration(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CmmVisitor ) return ((CmmVisitor<? extends T>)visitor).visitStructDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StructDeclarationContext structDeclaration() throws RecognitionException {
		StructDeclarationContext _localctx = new StructDeclarationContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_structDeclaration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			((StructDeclarationContext)_localctx).structDeclarationRet =  new StructDeclaration();
			setState(131);
			((StructDeclarationContext)_localctx).s = match(STRUCT);
			setState(132);
			((StructDeclarationContext)_localctx).i = identifier();
			_localctx.structDeclarationRet.setStructName(((StructDeclarationContext)_localctx).i.identifierRet);
			setState(154);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case BEGIN:
				{
				{
				setState(134);
				((StructDeclarationContext)_localctx).ll = match(BEGIN);
				setState(135);
				((StructDeclarationContext)_localctx).sb = structBody();
				_localctx.structDeclarationRet.setBody(((StructDeclarationContext)_localctx).sb.bodyRet); ((StructDeclarationContext)_localctx).sb.bodyRet.setLine(((StructDeclarationContext)_localctx).ll.getLine());
				setState(138); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(137);
					match(NEWLINE);
					}
					}
					setState(140); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==NEWLINE );
				setState(142);
				match(END);
				}
				}
				break;
			case NEWLINE:
				{
				{
				setState(145); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(144);
					match(NEWLINE);
					}
					}
					setState(147); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==NEWLINE );
				setState(149);
				((StructDeclarationContext)_localctx).sbs = singleStatementStructBody();
				_localctx.structDeclarationRet.setBody(((StructDeclarationContext)_localctx).sbs.stm);
				setState(152);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==SEMICOLON) {
					{
					setState(151);
					match(SEMICOLON);
					}
				}

				}
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(157); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(156);
				match(NEWLINE);
				}
				}
				setState(159); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==NEWLINE );
			_localctx.structDeclarationRet.setLine(((StructDeclarationContext)_localctx).s.getLine());
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SingleVarWithGetAndSetContext extends ParserRuleContext {
		public SetGetVarDeclaration sgvd;
		public TypeContext t;
		public IdentifierContext i;
		public FunctionArgsDecContext arg;
		public SetBodyContext s;
		public GetBodyContext g;
		public TerminalNode BEGIN() { return getToken(CmmParser.BEGIN, 0); }
		public TerminalNode END() { return getToken(CmmParser.END, 0); }
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public FunctionArgsDecContext functionArgsDec() {
			return getRuleContext(FunctionArgsDecContext.class,0);
		}
		public SetBodyContext setBody() {
			return getRuleContext(SetBodyContext.class,0);
		}
		public GetBodyContext getBody() {
			return getRuleContext(GetBodyContext.class,0);
		}
		public List<TerminalNode> NEWLINE() { return getTokens(CmmParser.NEWLINE); }
		public TerminalNode NEWLINE(int i) {
			return getToken(CmmParser.NEWLINE, i);
		}
		public SingleVarWithGetAndSetContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_singleVarWithGetAndSet; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CmmListener ) ((CmmListener)listener).enterSingleVarWithGetAndSet(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CmmListener ) ((CmmListener)listener).exitSingleVarWithGetAndSet(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CmmVisitor ) return ((CmmVisitor<? extends T>)visitor).visitSingleVarWithGetAndSet(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SingleVarWithGetAndSetContext singleVarWithGetAndSet() throws RecognitionException {
		SingleVarWithGetAndSetContext _localctx = new SingleVarWithGetAndSetContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_singleVarWithGetAndSet);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			((SingleVarWithGetAndSetContext)_localctx).sgvd =  new SetGetVarDeclaration();
			setState(164);
			((SingleVarWithGetAndSetContext)_localctx).t = type();
			setState(165);
			((SingleVarWithGetAndSetContext)_localctx).i = identifier();
			setState(166);
			((SingleVarWithGetAndSetContext)_localctx).arg = functionArgsDec();
			setState(167);
			match(BEGIN);
			setState(169); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(168);
				match(NEWLINE);
				}
				}
				setState(171); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==NEWLINE );
			setState(173);
			((SingleVarWithGetAndSetContext)_localctx).s = setBody();
			setState(174);
			((SingleVarWithGetAndSetContext)_localctx).g = getBody();
			setState(175);
			match(END);
			_localctx.sgvd.setVarName(((SingleVarWithGetAndSetContext)_localctx).i.identifierRet);
				 _localctx.sgvd.setVarType(((SingleVarWithGetAndSetContext)_localctx).t.typeRet);
				 _localctx.sgvd.setArgs(((SingleVarWithGetAndSetContext)_localctx).arg.funcArgDecRet);
				 _localctx.sgvd.setSetterBody(((SingleVarWithGetAndSetContext)_localctx).s.bodyRet);
				 _localctx.sgvd.setGetterBody(((SingleVarWithGetAndSetContext)_localctx).g.bodyRet);
				 _localctx.sgvd.setLine(((SingleVarWithGetAndSetContext)_localctx).i.identifierRet.getLine());
			    
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SingleStatementStructBodyContext extends ParserRuleContext {
		public Statement stm;
		public VarDecStatementContext vs;
		public SingleVarWithGetAndSetContext s;
		public VarDecStatementContext varDecStatement() {
			return getRuleContext(VarDecStatementContext.class,0);
		}
		public SingleVarWithGetAndSetContext singleVarWithGetAndSet() {
			return getRuleContext(SingleVarWithGetAndSetContext.class,0);
		}
		public SingleStatementStructBodyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_singleStatementStructBody; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CmmListener ) ((CmmListener)listener).enterSingleStatementStructBody(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CmmListener ) ((CmmListener)listener).exitSingleStatementStructBody(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CmmVisitor ) return ((CmmVisitor<? extends T>)visitor).visitSingleStatementStructBody(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SingleStatementStructBodyContext singleStatementStructBody() throws RecognitionException {
		SingleStatementStructBodyContext _localctx = new SingleStatementStructBodyContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_singleStatementStructBody);
		try {
			setState(184);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,10,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(178);
				((SingleStatementStructBodyContext)_localctx).vs = varDecStatement();
				((SingleStatementStructBodyContext)_localctx).stm =  ((SingleStatementStructBodyContext)_localctx).vs.vds;
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(181);
				((SingleStatementStructBodyContext)_localctx).s = singleVarWithGetAndSet();
				((SingleStatementStructBodyContext)_localctx).stm =  ((SingleStatementStructBodyContext)_localctx).s.sgvd;
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class StructBodyContext extends ParserRuleContext {
		public BlockStmt bodyRet;
		public SingleStatementStructBodyContext ss_;
		public SingleStatementStructBodyContext ss;
		public List<SingleStatementStructBodyContext> singleStatementStructBody() {
			return getRuleContexts(SingleStatementStructBodyContext.class);
		}
		public SingleStatementStructBodyContext singleStatementStructBody(int i) {
			return getRuleContext(SingleStatementStructBodyContext.class,i);
		}
		public List<TerminalNode> NEWLINE() { return getTokens(CmmParser.NEWLINE); }
		public TerminalNode NEWLINE(int i) {
			return getToken(CmmParser.NEWLINE, i);
		}
		public List<TerminalNode> SEMICOLON() { return getTokens(CmmParser.SEMICOLON); }
		public TerminalNode SEMICOLON(int i) {
			return getToken(CmmParser.SEMICOLON, i);
		}
		public StructBodyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_structBody; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CmmListener ) ((CmmListener)listener).enterStructBody(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CmmListener ) ((CmmListener)listener).exitStructBody(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CmmVisitor ) return ((CmmVisitor<? extends T>)visitor).visitStructBody(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StructBodyContext structBody() throws RecognitionException {
		StructBodyContext _localctx = new StructBodyContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_structBody);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			((StructBodyContext)_localctx).bodyRet =  new BlockStmt();
			setState(206); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(188); 
					_errHandler.sync(this);
					_la = _input.LA(1);
					do {
						{
						{
						setState(187);
						match(NEWLINE);
						}
						}
						setState(190); 
						_errHandler.sync(this);
						_la = _input.LA(1);
					} while ( _la==NEWLINE );
					setState(198);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,12,_ctx);
					while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
						if ( _alt==1 ) {
							{
							{
							setState(192);
							((StructBodyContext)_localctx).ss_ = singleStatementStructBody();
							_localctx.bodyRet.addStatement(((StructBodyContext)_localctx).ss_.stm);
							setState(194);
							match(SEMICOLON);
							}
							} 
						}
						setState(200);
						_errHandler.sync(this);
						_alt = getInterpreter().adaptivePredict(_input,12,_ctx);
					}
					setState(201);
					((StructBodyContext)_localctx).ss = singleStatementStructBody();
					_localctx.bodyRet.addStatement(((StructBodyContext)_localctx).ss.stm);
					setState(204);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if (_la==SEMICOLON) {
						{
						setState(203);
						match(SEMICOLON);
						}
					}

					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(208); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,14,_ctx);
			} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class GetBodyContext extends ParserRuleContext {
		public Statement bodyRet;
		public BodyContext b;
		public TerminalNode GET() { return getToken(CmmParser.GET, 0); }
		public BodyContext body() {
			return getRuleContext(BodyContext.class,0);
		}
		public List<TerminalNode> NEWLINE() { return getTokens(CmmParser.NEWLINE); }
		public TerminalNode NEWLINE(int i) {
			return getToken(CmmParser.NEWLINE, i);
		}
		public GetBodyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_getBody; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CmmListener ) ((CmmListener)listener).enterGetBody(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CmmListener ) ((CmmListener)listener).exitGetBody(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CmmVisitor ) return ((CmmVisitor<? extends T>)visitor).visitGetBody(this);
			else return visitor.visitChildren(this);
		}
	}

	public final GetBodyContext getBody() throws RecognitionException {
		GetBodyContext _localctx = new GetBodyContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_getBody);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(210);
			match(GET);
			setState(211);
			((GetBodyContext)_localctx).b = body();
			((GetBodyContext)_localctx).bodyRet =  ((GetBodyContext)_localctx).b.bodyRet;
			setState(214); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(213);
				match(NEWLINE);
				}
				}
				setState(216); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==NEWLINE );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SetBodyContext extends ParserRuleContext {
		public Statement bodyRet;
		public BodyContext b;
		public TerminalNode SET() { return getToken(CmmParser.SET, 0); }
		public BodyContext body() {
			return getRuleContext(BodyContext.class,0);
		}
		public List<TerminalNode> NEWLINE() { return getTokens(CmmParser.NEWLINE); }
		public TerminalNode NEWLINE(int i) {
			return getToken(CmmParser.NEWLINE, i);
		}
		public SetBodyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_setBody; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CmmListener ) ((CmmListener)listener).enterSetBody(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CmmListener ) ((CmmListener)listener).exitSetBody(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CmmVisitor ) return ((CmmVisitor<? extends T>)visitor).visitSetBody(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SetBodyContext setBody() throws RecognitionException {
		SetBodyContext _localctx = new SetBodyContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_setBody);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(218);
			match(SET);
			setState(219);
			((SetBodyContext)_localctx).b = body();
			((SetBodyContext)_localctx).bodyRet =  ((SetBodyContext)_localctx).b.bodyRet;
			setState(222); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(221);
				match(NEWLINE);
				}
				}
				setState(224); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==NEWLINE );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FunctionDeclarationContext extends ParserRuleContext {
		public FunctionDeclaration functionDeclarationRet;
		public TypeContext r;
		public IdentifierContext i;
		public FunctionArgsDecContext arg;
		public BodyContext b;
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public FunctionArgsDecContext functionArgsDec() {
			return getRuleContext(FunctionArgsDecContext.class,0);
		}
		public BodyContext body() {
			return getRuleContext(BodyContext.class,0);
		}
		public TerminalNode VOID() { return getToken(CmmParser.VOID, 0); }
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public List<TerminalNode> NEWLINE() { return getTokens(CmmParser.NEWLINE); }
		public TerminalNode NEWLINE(int i) {
			return getToken(CmmParser.NEWLINE, i);
		}
		public FunctionDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_functionDeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CmmListener ) ((CmmListener)listener).enterFunctionDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CmmListener ) ((CmmListener)listener).exitFunctionDeclaration(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CmmVisitor ) return ((CmmVisitor<? extends T>)visitor).visitFunctionDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FunctionDeclarationContext functionDeclaration() throws RecognitionException {
		FunctionDeclarationContext _localctx = new FunctionDeclarationContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_functionDeclaration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			((FunctionDeclarationContext)_localctx).functionDeclarationRet =  new FunctionDeclaration();
			setState(232);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case INT:
			case BOOL:
			case LIST:
			case STRUCT:
			case FPTR:
				{
				setState(227);
				((FunctionDeclarationContext)_localctx).r = type();
				_localctx.functionDeclarationRet.setReturnType(((FunctionDeclarationContext)_localctx).r.typeRet);
				}
				break;
			case VOID:
				{
				setState(230);
				match(VOID);
				_localctx.functionDeclarationRet.setReturnType(new VoidType());
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(234);
			((FunctionDeclarationContext)_localctx).i = identifier();
			setState(235);
			((FunctionDeclarationContext)_localctx).arg = functionArgsDec();
			setState(236);
			((FunctionDeclarationContext)_localctx).b = body();
			setState(238); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(237);
				match(NEWLINE);
				}
				}
				setState(240); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==NEWLINE );
			_localctx.functionDeclarationRet.setFunctionName(((FunctionDeclarationContext)_localctx).i.identifierRet);
			     _localctx.functionDeclarationRet.setArgs(((FunctionDeclarationContext)_localctx).arg.funcArgDecRet);
			     _localctx.functionDeclarationRet.setBody(((FunctionDeclarationContext)_localctx).b.bodyRet);
			     _localctx.functionDeclarationRet.setLine(((FunctionDeclarationContext)_localctx).i.identifierRet.getLine());
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FunctionArgsDecContext extends ParserRuleContext {
		public ArrayList<VariableDeclaration> funcArgDecRet;
		public VariableDeclaration var;
		public TypeContext tf;
		public IdentifierContext if_;
		public TypeContext ts;
		public IdentifierContext is;
		public TerminalNode LPAR() { return getToken(CmmParser.LPAR, 0); }
		public TerminalNode RPAR() { return getToken(CmmParser.RPAR, 0); }
		public List<TypeContext> type() {
			return getRuleContexts(TypeContext.class);
		}
		public TypeContext type(int i) {
			return getRuleContext(TypeContext.class,i);
		}
		public List<IdentifierContext> identifier() {
			return getRuleContexts(IdentifierContext.class);
		}
		public IdentifierContext identifier(int i) {
			return getRuleContext(IdentifierContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(CmmParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(CmmParser.COMMA, i);
		}
		public FunctionArgsDecContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_functionArgsDec; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CmmListener ) ((CmmListener)listener).enterFunctionArgsDec(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CmmListener ) ((CmmListener)listener).exitFunctionArgsDec(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CmmVisitor ) return ((CmmVisitor<? extends T>)visitor).visitFunctionArgsDec(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FunctionArgsDecContext functionArgsDec() throws RecognitionException {
		FunctionArgsDecContext _localctx = new FunctionArgsDecContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_functionArgsDec);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			((FunctionArgsDecContext)_localctx).funcArgDecRet =  new ArrayList<>();
			setState(245);
			match(LPAR);
			setState(259);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << INT) | (1L << BOOL) | (1L << LIST) | (1L << STRUCT) | (1L << FPTR))) != 0)) {
				{
				setState(246);
				((FunctionArgsDecContext)_localctx).tf = type();
				setState(247);
				((FunctionArgsDecContext)_localctx).if_ = identifier();
				((FunctionArgsDecContext)_localctx).var =  new VariableDeclaration(((FunctionArgsDecContext)_localctx).if_.identifierRet,((FunctionArgsDecContext)_localctx).tf.typeRet);
				     _localctx.var.setLine(((FunctionArgsDecContext)_localctx).if_.identifierRet.getLine());
				     _localctx.funcArgDecRet.add(_localctx.var);
				setState(256);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(249);
					match(COMMA);
					setState(250);
					((FunctionArgsDecContext)_localctx).ts = type();
					setState(251);
					((FunctionArgsDecContext)_localctx).is = identifier();
					((FunctionArgsDecContext)_localctx).var =  new VariableDeclaration(((FunctionArgsDecContext)_localctx).is.identifierRet,((FunctionArgsDecContext)_localctx).ts.typeRet);
						 _localctx.var.setLine(((FunctionArgsDecContext)_localctx).if_.identifierRet.getLine());
						 _localctx.funcArgDecRet.add(_localctx.var);
					}
					}
					setState(258);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(261);
			match(RPAR);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FunctionArgumentsContext extends ParserRuleContext {
		public ExprInPar exp;
		public ArrayList<Expression> arg;
		public ExpressionContext ef;
		public ExpressionContext es;
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(CmmParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(CmmParser.COMMA, i);
		}
		public FunctionArgumentsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_functionArguments; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CmmListener ) ((CmmListener)listener).enterFunctionArguments(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CmmListener ) ((CmmListener)listener).exitFunctionArguments(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CmmVisitor ) return ((CmmVisitor<? extends T>)visitor).visitFunctionArguments(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FunctionArgumentsContext functionArguments() throws RecognitionException {
		FunctionArgumentsContext _localctx = new FunctionArgumentsContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_functionArguments);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			((FunctionArgumentsContext)_localctx).arg =  new ArrayList<>();
			setState(275);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << SIZE) | (1L << APPEND) | (1L << MINUS) | (1L << NOT) | (1L << TRUE) | (1L << FALSE) | (1L << LPAR) | (1L << INT_VALUE) | (1L << IDENTIFIER))) != 0)) {
				{
				setState(264);
				((FunctionArgumentsContext)_localctx).ef = expression();
				_localctx.arg.add(((FunctionArgumentsContext)_localctx).ef.expRet);
				setState(272);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(266);
					match(COMMA);
					setState(267);
					((FunctionArgumentsContext)_localctx).es = expression();
					_localctx.arg.add(((FunctionArgumentsContext)_localctx).es.expRet);
					}
					}
					setState(274);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			((FunctionArgumentsContext)_localctx).exp =  new ExprInPar(_localctx.arg);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class BodyContext extends ParserRuleContext {
		public Statement bodyRet;
		public BlockStatementContext b;
		public SingleStatementContext s;
		public BlockStatementContext blockStatement() {
			return getRuleContext(BlockStatementContext.class,0);
		}
		public SingleStatementContext singleStatement() {
			return getRuleContext(SingleStatementContext.class,0);
		}
		public List<TerminalNode> NEWLINE() { return getTokens(CmmParser.NEWLINE); }
		public TerminalNode NEWLINE(int i) {
			return getToken(CmmParser.NEWLINE, i);
		}
		public TerminalNode SEMICOLON() { return getToken(CmmParser.SEMICOLON, 0); }
		public BodyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_body; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CmmListener ) ((CmmListener)listener).enterBody(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CmmListener ) ((CmmListener)listener).exitBody(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CmmVisitor ) return ((CmmVisitor<? extends T>)visitor).visitBody(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BodyContext body() throws RecognitionException {
		BodyContext _localctx = new BodyContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_body);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(292);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case BEGIN:
				{
				setState(279);
				((BodyContext)_localctx).b = blockStatement();
				((BodyContext)_localctx).bodyRet =  ((BodyContext)_localctx).b.stm;
				}
				break;
			case NEWLINE:
				{
				{
				setState(283); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(282);
					match(NEWLINE);
					}
					}
					setState(285); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==NEWLINE );
				setState(287);
				((BodyContext)_localctx).s = singleStatement();
				((BodyContext)_localctx).bodyRet =  ((BodyContext)_localctx).s.stm;
				setState(290);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==SEMICOLON) {
					{
					setState(289);
					match(SEMICOLON);
					}
				}

				}
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class LoopCondBodyContext extends ParserRuleContext {
		public Statement bodyRet;
		public BlockStatementContext b;
		public SingleStatementContext s;
		public BlockStatementContext blockStatement() {
			return getRuleContext(BlockStatementContext.class,0);
		}
		public SingleStatementContext singleStatement() {
			return getRuleContext(SingleStatementContext.class,0);
		}
		public List<TerminalNode> NEWLINE() { return getTokens(CmmParser.NEWLINE); }
		public TerminalNode NEWLINE(int i) {
			return getToken(CmmParser.NEWLINE, i);
		}
		public LoopCondBodyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_loopCondBody; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CmmListener ) ((CmmListener)listener).enterLoopCondBody(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CmmListener ) ((CmmListener)listener).exitLoopCondBody(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CmmVisitor ) return ((CmmVisitor<? extends T>)visitor).visitLoopCondBody(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LoopCondBodyContext loopCondBody() throws RecognitionException {
		LoopCondBodyContext _localctx = new LoopCondBodyContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_loopCondBody);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(305);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case BEGIN:
				{
				setState(294);
				((LoopCondBodyContext)_localctx).b = blockStatement();
				((LoopCondBodyContext)_localctx).bodyRet =  ((LoopCondBodyContext)_localctx).b.stm;
				}
				break;
			case NEWLINE:
				{
				{
				setState(298); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(297);
					match(NEWLINE);
					}
					}
					setState(300); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==NEWLINE );
				setState(302);
				((LoopCondBodyContext)_localctx).s = singleStatement();
				((LoopCondBodyContext)_localctx).bodyRet =  ((LoopCondBodyContext)_localctx).s.stm;
				}
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class BlockStatementContext extends ParserRuleContext {
		public BlockStmt stm;
		public Token ll;
		public SingleStatementContext ss_;
		public SingleStatementContext ss;
		public TerminalNode END() { return getToken(CmmParser.END, 0); }
		public TerminalNode BEGIN() { return getToken(CmmParser.BEGIN, 0); }
		public List<TerminalNode> NEWLINE() { return getTokens(CmmParser.NEWLINE); }
		public TerminalNode NEWLINE(int i) {
			return getToken(CmmParser.NEWLINE, i);
		}
		public List<SingleStatementContext> singleStatement() {
			return getRuleContexts(SingleStatementContext.class);
		}
		public SingleStatementContext singleStatement(int i) {
			return getRuleContext(SingleStatementContext.class,i);
		}
		public List<TerminalNode> SEMICOLON() { return getTokens(CmmParser.SEMICOLON); }
		public TerminalNode SEMICOLON(int i) {
			return getToken(CmmParser.SEMICOLON, i);
		}
		public BlockStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_blockStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CmmListener ) ((CmmListener)listener).enterBlockStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CmmListener ) ((CmmListener)listener).exitBlockStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CmmVisitor ) return ((CmmVisitor<? extends T>)visitor).visitBlockStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BlockStatementContext blockStatement() throws RecognitionException {
		BlockStatementContext _localctx = new BlockStatementContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_blockStatement);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			((BlockStatementContext)_localctx).stm =  new BlockStmt();
			setState(308);
			((BlockStatementContext)_localctx).ll = match(BEGIN);
			setState(328); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(310); 
					_errHandler.sync(this);
					_la = _input.LA(1);
					do {
						{
						{
						setState(309);
						match(NEWLINE);
						}
						}
						setState(312); 
						_errHandler.sync(this);
						_la = _input.LA(1);
					} while ( _la==NEWLINE );
					setState(320);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,29,_ctx);
					while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
						if ( _alt==1 ) {
							{
							{
							setState(314);
							((BlockStatementContext)_localctx).ss_ = singleStatement();
							_localctx.stm.addStatement(((BlockStatementContext)_localctx).ss_.stm);
							setState(316);
							match(SEMICOLON);
							}
							} 
						}
						setState(322);
						_errHandler.sync(this);
						_alt = getInterpreter().adaptivePredict(_input,29,_ctx);
					}
					setState(323);
					((BlockStatementContext)_localctx).ss = singleStatement();
					_localctx.stm.addStatement(((BlockStatementContext)_localctx).ss.stm);
					setState(326);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if (_la==SEMICOLON) {
						{
						setState(325);
						match(SEMICOLON);
						}
					}

					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(330); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,31,_ctx);
			} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
			setState(333); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(332);
				match(NEWLINE);
				}
				}
				setState(335); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==NEWLINE );
			setState(337);
			match(END);
			_localctx.stm.setLine(((BlockStatementContext)_localctx).ll.getLine());
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class VarDecStatementContext extends ParserRuleContext {
		public VarDecStmt vds;
		public VariableDeclaration vd;
		public TypeContext t;
		public IdentifierContext i;
		public OrExpressionContext exp;
		public IdentifierContext im;
		public OrExpressionContext expm;
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public List<IdentifierContext> identifier() {
			return getRuleContexts(IdentifierContext.class);
		}
		public IdentifierContext identifier(int i) {
			return getRuleContext(IdentifierContext.class,i);
		}
		public List<TerminalNode> ASSIGN() { return getTokens(CmmParser.ASSIGN); }
		public TerminalNode ASSIGN(int i) {
			return getToken(CmmParser.ASSIGN, i);
		}
		public List<TerminalNode> COMMA() { return getTokens(CmmParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(CmmParser.COMMA, i);
		}
		public List<OrExpressionContext> orExpression() {
			return getRuleContexts(OrExpressionContext.class);
		}
		public OrExpressionContext orExpression(int i) {
			return getRuleContext(OrExpressionContext.class,i);
		}
		public VarDecStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_varDecStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CmmListener ) ((CmmListener)listener).enterVarDecStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CmmListener ) ((CmmListener)listener).exitVarDecStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CmmVisitor ) return ((CmmVisitor<? extends T>)visitor).visitVarDecStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VarDecStatementContext varDecStatement() throws RecognitionException {
		VarDecStatementContext _localctx = new VarDecStatementContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_varDecStatement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			((VarDecStatementContext)_localctx).vds =  new VarDecStmt();
			setState(341);
			((VarDecStatementContext)_localctx).t = type();
			setState(342);
			((VarDecStatementContext)_localctx).i = identifier();
			((VarDecStatementContext)_localctx).vd =  new VariableDeclaration(((VarDecStatementContext)_localctx).i.identifierRet,((VarDecStatementContext)_localctx).t.typeRet);
			    _localctx.vd.setLine(((VarDecStatementContext)_localctx).i.identifierRet.getLine());
			setState(348);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ASSIGN) {
				{
				setState(344);
				match(ASSIGN);
				setState(345);
				((VarDecStatementContext)_localctx).exp = orExpression();
				_localctx.vd.setDefaultValue(((VarDecStatementContext)_localctx).exp.exp);
				}
			}

			_localctx.vds.addVar(_localctx.vd);
			setState(364);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(351);
				match(COMMA);
				setState(352);
				((VarDecStatementContext)_localctx).im = identifier();
				((VarDecStatementContext)_localctx).vd =  new VariableDeclaration(((VarDecStatementContext)_localctx).im.identifierRet,((VarDecStatementContext)_localctx).t.typeRet);
				    _localctx.vd.setLine(((VarDecStatementContext)_localctx).im.identifierRet.getLine());
				setState(358);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==ASSIGN) {
					{
					setState(354);
					match(ASSIGN);
					setState(355);
					((VarDecStatementContext)_localctx).expm = orExpression();
					_localctx.vd.setDefaultValue(((VarDecStatementContext)_localctx).expm.exp);
					}
				}

				_localctx.vds.addVar(_localctx.vd);
				}
				}
				setState(366);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			_localctx.vds.setLine(((VarDecStatementContext)_localctx).i.identifierRet.getLine());
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FunctionCallStmtContext extends ParserRuleContext {
		public FunctionCallStmt funcCallRet;
		public Expression exp;
		public FunctionCall funcCall;
		public OtherExpressionContext e;
		public Token ll1;
		public FunctionArgumentsContext fa;
		public Token ll3;
		public IdentifierContext i;
		public Token ll2;
		public FunctionArgumentsContext fa2;
		public OtherExpressionContext otherExpression() {
			return getRuleContext(OtherExpressionContext.class,0);
		}
		public List<TerminalNode> RPAR() { return getTokens(CmmParser.RPAR); }
		public TerminalNode RPAR(int i) {
			return getToken(CmmParser.RPAR, i);
		}
		public List<TerminalNode> LPAR() { return getTokens(CmmParser.LPAR); }
		public TerminalNode LPAR(int i) {
			return getToken(CmmParser.LPAR, i);
		}
		public List<FunctionArgumentsContext> functionArguments() {
			return getRuleContexts(FunctionArgumentsContext.class);
		}
		public FunctionArgumentsContext functionArguments(int i) {
			return getRuleContext(FunctionArgumentsContext.class,i);
		}
		public List<TerminalNode> DOT() { return getTokens(CmmParser.DOT); }
		public TerminalNode DOT(int i) {
			return getToken(CmmParser.DOT, i);
		}
		public List<IdentifierContext> identifier() {
			return getRuleContexts(IdentifierContext.class);
		}
		public IdentifierContext identifier(int i) {
			return getRuleContext(IdentifierContext.class,i);
		}
		public FunctionCallStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_functionCallStmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CmmListener ) ((CmmListener)listener).enterFunctionCallStmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CmmListener ) ((CmmListener)listener).exitFunctionCallStmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CmmVisitor ) return ((CmmVisitor<? extends T>)visitor).visitFunctionCallStmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FunctionCallStmtContext functionCallStmt() throws RecognitionException {
		FunctionCallStmtContext _localctx = new FunctionCallStmtContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_functionCallStmt);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(369);
			((FunctionCallStmtContext)_localctx).e = otherExpression();
			((FunctionCallStmtContext)_localctx).exp =  ((FunctionCallStmtContext)_localctx).e.expRet;
			setState(382);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,37,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					setState(380);
					_errHandler.sync(this);
					switch (_input.LA(1)) {
					case LPAR:
						{
						{
						setState(371);
						((FunctionCallStmtContext)_localctx).ll1 = match(LPAR);
						setState(372);
						((FunctionCallStmtContext)_localctx).fa = functionArguments();
						((FunctionCallStmtContext)_localctx).exp =  new FunctionCall(_localctx.exp, ((FunctionCallStmtContext)_localctx).fa.exp.getInputs());
						     ((FunctionCallStmtContext)_localctx).fa.exp.setLine(((FunctionCallStmtContext)_localctx).ll1.getLine()); _localctx.exp.setLine(((FunctionCallStmtContext)_localctx).ll1.getLine());
						setState(374);
						match(RPAR);
						}
						}
						break;
					case DOT:
						{
						{
						setState(376);
						((FunctionCallStmtContext)_localctx).ll3 = match(DOT);
						setState(377);
						((FunctionCallStmtContext)_localctx).i = identifier();
						((FunctionCallStmtContext)_localctx).exp =  new StructAccess(_localctx.exp, ((FunctionCallStmtContext)_localctx).i.identifierRet);
						     _localctx.exp.setLine(((FunctionCallStmtContext)_localctx).ll3.getLine());
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					} 
				}
				setState(384);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,37,_ctx);
			}
			{
			setState(385);
			((FunctionCallStmtContext)_localctx).ll2 = match(LPAR);
			setState(386);
			((FunctionCallStmtContext)_localctx).fa2 = functionArguments();
			((FunctionCallStmtContext)_localctx).funcCall =  new FunctionCall(_localctx.exp,((FunctionCallStmtContext)_localctx).fa2.exp.getInputs());
			     _localctx.funcCall.setLine(((FunctionCallStmtContext)_localctx).ll2.getLine());
			     ((FunctionCallStmtContext)_localctx).funcCallRet =  new FunctionCallStmt(_localctx.funcCall);
			     ((FunctionCallStmtContext)_localctx).fa2.exp.setLine(((FunctionCallStmtContext)_localctx).ll2.getLine());
			     _localctx.funcCallRet.setLine(((FunctionCallStmtContext)_localctx).ll2.getLine());
			setState(388);
			match(RPAR);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ReturnStatementContext extends ParserRuleContext {
		public ReturnStmt stm;
		public Token ll;
		public ExpressionContext e;
		public TerminalNode RETURN() { return getToken(CmmParser.RETURN, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public ReturnStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_returnStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CmmListener ) ((CmmListener)listener).enterReturnStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CmmListener ) ((CmmListener)listener).exitReturnStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CmmVisitor ) return ((CmmVisitor<? extends T>)visitor).visitReturnStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ReturnStatementContext returnStatement() throws RecognitionException {
		ReturnStatementContext _localctx = new ReturnStatementContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_returnStatement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			((ReturnStatementContext)_localctx).stm =  new ReturnStmt();
			setState(391);
			((ReturnStatementContext)_localctx).ll = match(RETURN);
			setState(395);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << SIZE) | (1L << APPEND) | (1L << MINUS) | (1L << NOT) | (1L << TRUE) | (1L << FALSE) | (1L << LPAR) | (1L << INT_VALUE) | (1L << IDENTIFIER))) != 0)) {
				{
				setState(392);
				((ReturnStatementContext)_localctx).e = expression();
				_localctx.stm.setReturnedExpr(((ReturnStatementContext)_localctx).e.expRet);
				}
			}

			_localctx.stm.setLine(((ReturnStatementContext)_localctx).ll.getLine());
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class IfStatementContext extends ParserRuleContext {
		public ConditionalStmt stm;
		public Token ll;
		public ExpressionContext e;
		public LoopCondBodyContext l;
		public BodyContext b;
		public ElseStatementContext el;
		public TerminalNode IF() { return getToken(CmmParser.IF, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public LoopCondBodyContext loopCondBody() {
			return getRuleContext(LoopCondBodyContext.class,0);
		}
		public BodyContext body() {
			return getRuleContext(BodyContext.class,0);
		}
		public ElseStatementContext elseStatement() {
			return getRuleContext(ElseStatementContext.class,0);
		}
		public IfStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ifStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CmmListener ) ((CmmListener)listener).enterIfStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CmmListener ) ((CmmListener)listener).exitIfStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CmmVisitor ) return ((CmmVisitor<? extends T>)visitor).visitIfStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IfStatementContext ifStatement() throws RecognitionException {
		IfStatementContext _localctx = new IfStatementContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_ifStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(399);
			((IfStatementContext)_localctx).ll = match(IF);
			setState(400);
			((IfStatementContext)_localctx).e = expression();
			((IfStatementContext)_localctx).stm =  new ConditionalStmt(((IfStatementContext)_localctx).e.expRet);
			setState(409);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,39,_ctx) ) {
			case 1:
				{
				setState(402);
				((IfStatementContext)_localctx).l = loopCondBody();
				_localctx.stm.setThenBody(((IfStatementContext)_localctx).l.bodyRet);
				}
				break;
			case 2:
				{
				setState(405);
				((IfStatementContext)_localctx).b = body();
				setState(406);
				((IfStatementContext)_localctx).el = elseStatement();
				_localctx.stm.setThenBody(((IfStatementContext)_localctx).b.bodyRet); _localctx.stm.setElseBody(((IfStatementContext)_localctx).el.stm);
				}
				break;
			}
			_localctx.stm.setLine(((IfStatementContext)_localctx).ll.getLine());
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ElseStatementContext extends ParserRuleContext {
		public Statement stm;
		public LoopCondBodyContext l;
		public TerminalNode ELSE() { return getToken(CmmParser.ELSE, 0); }
		public LoopCondBodyContext loopCondBody() {
			return getRuleContext(LoopCondBodyContext.class,0);
		}
		public List<TerminalNode> NEWLINE() { return getTokens(CmmParser.NEWLINE); }
		public TerminalNode NEWLINE(int i) {
			return getToken(CmmParser.NEWLINE, i);
		}
		public ElseStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_elseStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CmmListener ) ((CmmListener)listener).enterElseStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CmmListener ) ((CmmListener)listener).exitElseStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CmmVisitor ) return ((CmmVisitor<? extends T>)visitor).visitElseStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ElseStatementContext elseStatement() throws RecognitionException {
		ElseStatementContext _localctx = new ElseStatementContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_elseStatement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(416);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==NEWLINE) {
				{
				{
				setState(413);
				match(NEWLINE);
				}
				}
				setState(418);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(419);
			match(ELSE);
			setState(420);
			((ElseStatementContext)_localctx).l = loopCondBody();
			((ElseStatementContext)_localctx).stm =  ((ElseStatementContext)_localctx).l.bodyRet;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class LoopStatementContext extends ParserRuleContext {
		public LoopStmt loop;
		public WhileLoopStatementContext w;
		public DoWhileLoopStatementContext d;
		public WhileLoopStatementContext whileLoopStatement() {
			return getRuleContext(WhileLoopStatementContext.class,0);
		}
		public DoWhileLoopStatementContext doWhileLoopStatement() {
			return getRuleContext(DoWhileLoopStatementContext.class,0);
		}
		public LoopStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_loopStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CmmListener ) ((CmmListener)listener).enterLoopStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CmmListener ) ((CmmListener)listener).exitLoopStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CmmVisitor ) return ((CmmVisitor<? extends T>)visitor).visitLoopStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LoopStatementContext loopStatement() throws RecognitionException {
		LoopStatementContext _localctx = new LoopStatementContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_loopStatement);
		try {
			setState(429);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case WHILE:
				enterOuterAlt(_localctx, 1);
				{
				setState(423);
				((LoopStatementContext)_localctx).w = whileLoopStatement();
				((LoopStatementContext)_localctx).loop =  ((LoopStatementContext)_localctx).w.loop;
				}
				break;
			case DO:
				enterOuterAlt(_localctx, 2);
				{
				setState(426);
				((LoopStatementContext)_localctx).d = doWhileLoopStatement();
				((LoopStatementContext)_localctx).loop =  ((LoopStatementContext)_localctx).d.loop;
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class WhileLoopStatementContext extends ParserRuleContext {
		public LoopStmt loop;
		public Token ll;
		public ExpressionContext c;
		public LoopCondBodyContext b;
		public TerminalNode WHILE() { return getToken(CmmParser.WHILE, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public LoopCondBodyContext loopCondBody() {
			return getRuleContext(LoopCondBodyContext.class,0);
		}
		public WhileLoopStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_whileLoopStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CmmListener ) ((CmmListener)listener).enterWhileLoopStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CmmListener ) ((CmmListener)listener).exitWhileLoopStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CmmVisitor ) return ((CmmVisitor<? extends T>)visitor).visitWhileLoopStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final WhileLoopStatementContext whileLoopStatement() throws RecognitionException {
		WhileLoopStatementContext _localctx = new WhileLoopStatementContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_whileLoopStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			((WhileLoopStatementContext)_localctx).loop =  new LoopStmt();
			setState(432);
			((WhileLoopStatementContext)_localctx).ll = match(WHILE);
			setState(433);
			((WhileLoopStatementContext)_localctx).c = expression();
			setState(434);
			((WhileLoopStatementContext)_localctx).b = loopCondBody();
			_localctx.loop.setCondition(((WhileLoopStatementContext)_localctx).c.expRet);
			     _localctx.loop.setBody(((WhileLoopStatementContext)_localctx).b.bodyRet);
			_localctx.loop.setLine(((WhileLoopStatementContext)_localctx).ll.getLine());
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DoWhileLoopStatementContext extends ParserRuleContext {
		public LoopStmt loop;
		public Token ll;
		public BodyContext b;
		public ExpressionContext c;
		public TerminalNode WHILE() { return getToken(CmmParser.WHILE, 0); }
		public TerminalNode DO() { return getToken(CmmParser.DO, 0); }
		public BodyContext body() {
			return getRuleContext(BodyContext.class,0);
		}
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public List<TerminalNode> NEWLINE() { return getTokens(CmmParser.NEWLINE); }
		public TerminalNode NEWLINE(int i) {
			return getToken(CmmParser.NEWLINE, i);
		}
		public DoWhileLoopStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_doWhileLoopStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CmmListener ) ((CmmListener)listener).enterDoWhileLoopStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CmmListener ) ((CmmListener)listener).exitDoWhileLoopStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CmmVisitor ) return ((CmmVisitor<? extends T>)visitor).visitDoWhileLoopStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DoWhileLoopStatementContext doWhileLoopStatement() throws RecognitionException {
		DoWhileLoopStatementContext _localctx = new DoWhileLoopStatementContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_doWhileLoopStatement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			((DoWhileLoopStatementContext)_localctx).loop =  new LoopStmt();
			setState(439);
			((DoWhileLoopStatementContext)_localctx).ll = match(DO);
			setState(440);
			((DoWhileLoopStatementContext)_localctx).b = body();
			setState(444);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==NEWLINE) {
				{
				{
				setState(441);
				match(NEWLINE);
				}
				}
				setState(446);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(447);
			match(WHILE);
			setState(448);
			((DoWhileLoopStatementContext)_localctx).c = expression();
			_localctx.loop.setCondition(((DoWhileLoopStatementContext)_localctx).c.expRet);
			     _localctx.loop.setBody(((DoWhileLoopStatementContext)_localctx).b.bodyRet);
			_localctx.loop.setLine(((DoWhileLoopStatementContext)_localctx).ll.getLine());
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DisplayStatementContext extends ParserRuleContext {
		public DisplayStmt display;
		public Token ll;
		public ExpressionContext e;
		public TerminalNode LPAR() { return getToken(CmmParser.LPAR, 0); }
		public TerminalNode RPAR() { return getToken(CmmParser.RPAR, 0); }
		public TerminalNode DISPLAY() { return getToken(CmmParser.DISPLAY, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public DisplayStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_displayStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CmmListener ) ((CmmListener)listener).enterDisplayStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CmmListener ) ((CmmListener)listener).exitDisplayStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CmmVisitor ) return ((CmmVisitor<? extends T>)visitor).visitDisplayStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DisplayStatementContext displayStatement() throws RecognitionException {
		DisplayStatementContext _localctx = new DisplayStatementContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_displayStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(452);
			((DisplayStatementContext)_localctx).ll = match(DISPLAY);
			setState(453);
			match(LPAR);
			setState(454);
			((DisplayStatementContext)_localctx).e = expression();
			setState(455);
			match(RPAR);
			((DisplayStatementContext)_localctx).display =  new DisplayStmt(((DisplayStatementContext)_localctx).e.expRet);
			_localctx.display.setLine(((DisplayStatementContext)_localctx).ll.getLine());
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AssignmentStatementContext extends ParserRuleContext {
		public AssignmentStmt assign;
		public OrExpressionContext l;
		public Token ll;
		public ExpressionContext r;
		public OrExpressionContext orExpression() {
			return getRuleContext(OrExpressionContext.class,0);
		}
		public TerminalNode ASSIGN() { return getToken(CmmParser.ASSIGN, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public AssignmentStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assignmentStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CmmListener ) ((CmmListener)listener).enterAssignmentStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CmmListener ) ((CmmListener)listener).exitAssignmentStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CmmVisitor ) return ((CmmVisitor<? extends T>)visitor).visitAssignmentStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AssignmentStatementContext assignmentStatement() throws RecognitionException {
		AssignmentStatementContext _localctx = new AssignmentStatementContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_assignmentStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(459);
			((AssignmentStatementContext)_localctx).l = orExpression();
			setState(460);
			((AssignmentStatementContext)_localctx).ll = match(ASSIGN);
			setState(461);
			((AssignmentStatementContext)_localctx).r = expression();
			((AssignmentStatementContext)_localctx).assign =  new AssignmentStmt(((AssignmentStatementContext)_localctx).l.exp,((AssignmentStatementContext)_localctx).r.expRet);
			_localctx.assign.setLine(((AssignmentStatementContext)_localctx).ll.getLine());
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SingleStatementContext extends ParserRuleContext {
		public Statement stm;
		public IfStatementContext is;
		public DisplayStatementContext ds;
		public FunctionCallStmtContext fs;
		public ReturnStatementContext rs;
		public AssignmentStatementContext as;
		public VarDecStatementContext vds;
		public LoopStatementContext ls;
		public SizeContext s;
		public AppendContext a;
		public IfStatementContext ifStatement() {
			return getRuleContext(IfStatementContext.class,0);
		}
		public DisplayStatementContext displayStatement() {
			return getRuleContext(DisplayStatementContext.class,0);
		}
		public FunctionCallStmtContext functionCallStmt() {
			return getRuleContext(FunctionCallStmtContext.class,0);
		}
		public ReturnStatementContext returnStatement() {
			return getRuleContext(ReturnStatementContext.class,0);
		}
		public AssignmentStatementContext assignmentStatement() {
			return getRuleContext(AssignmentStatementContext.class,0);
		}
		public VarDecStatementContext varDecStatement() {
			return getRuleContext(VarDecStatementContext.class,0);
		}
		public LoopStatementContext loopStatement() {
			return getRuleContext(LoopStatementContext.class,0);
		}
		public SizeContext size() {
			return getRuleContext(SizeContext.class,0);
		}
		public AppendContext append() {
			return getRuleContext(AppendContext.class,0);
		}
		public SingleStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_singleStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CmmListener ) ((CmmListener)listener).enterSingleStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CmmListener ) ((CmmListener)listener).exitSingleStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CmmVisitor ) return ((CmmVisitor<? extends T>)visitor).visitSingleStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SingleStatementContext singleStatement() throws RecognitionException {
		SingleStatementContext _localctx = new SingleStatementContext(_ctx, getState());
		enterRule(_localctx, 50, RULE_singleStatement);
		try {
			setState(492);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,43,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(465);
				((SingleStatementContext)_localctx).is = ifStatement();
				((SingleStatementContext)_localctx).stm =  ((SingleStatementContext)_localctx).is.stm;
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(468);
				((SingleStatementContext)_localctx).ds = displayStatement();
				((SingleStatementContext)_localctx).stm =  ((SingleStatementContext)_localctx).ds.display;
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(471);
				((SingleStatementContext)_localctx).fs = functionCallStmt();
				((SingleStatementContext)_localctx).stm =  ((SingleStatementContext)_localctx).fs.funcCallRet;
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(474);
				((SingleStatementContext)_localctx).rs = returnStatement();
				((SingleStatementContext)_localctx).stm =  ((SingleStatementContext)_localctx).rs.stm;
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(477);
				((SingleStatementContext)_localctx).as = assignmentStatement();
				((SingleStatementContext)_localctx).stm =  ((SingleStatementContext)_localctx).as.assign;
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(480);
				((SingleStatementContext)_localctx).vds = varDecStatement();
				((SingleStatementContext)_localctx).stm =  ((SingleStatementContext)_localctx).vds.vds;
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(483);
				((SingleStatementContext)_localctx).ls = loopStatement();
				((SingleStatementContext)_localctx).stm =  ((SingleStatementContext)_localctx).ls.loop;
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(486);
				((SingleStatementContext)_localctx).s = size();
				((SingleStatementContext)_localctx).stm =  ((SingleStatementContext)_localctx).s.sizeRet;
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(489);
				((SingleStatementContext)_localctx).a = append();
				((SingleStatementContext)_localctx).stm =  ((SingleStatementContext)_localctx).a.apRet;
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExpressionContext extends ParserRuleContext {
		public Expression expRet;
		public OrExpressionContext exp1;
		public Token op;
		public ExpressionContext exp2;
		public OrExpressionContext orExpression() {
			return getRuleContext(OrExpressionContext.class,0);
		}
		public TerminalNode ASSIGN() { return getToken(CmmParser.ASSIGN, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public ExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CmmListener ) ((CmmListener)listener).enterExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CmmListener ) ((CmmListener)listener).exitExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CmmVisitor ) return ((CmmVisitor<? extends T>)visitor).visitExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExpressionContext expression() throws RecognitionException {
		ExpressionContext _localctx = new ExpressionContext(_ctx, getState());
		enterRule(_localctx, 52, RULE_expression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(494);
			((ExpressionContext)_localctx).exp1 = orExpression();
			((ExpressionContext)_localctx).expRet =  ((ExpressionContext)_localctx).exp1.exp;
			setState(500);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ASSIGN) {
				{
				setState(496);
				((ExpressionContext)_localctx).op = match(ASSIGN);
				setState(497);
				((ExpressionContext)_localctx).exp2 = expression();
				((ExpressionContext)_localctx).expRet =  new BinaryExpression(_localctx.expRet,((ExpressionContext)_localctx).exp2.expRet,BinaryOperator.assign);
				    _localctx.expRet.setLine(((ExpressionContext)_localctx).op.getLine());
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class OrExpressionContext extends ParserRuleContext {
		public Expression exp;
		public AndExpressionContext exp1;
		public Token op;
		public AndExpressionContext exp2;
		public List<AndExpressionContext> andExpression() {
			return getRuleContexts(AndExpressionContext.class);
		}
		public AndExpressionContext andExpression(int i) {
			return getRuleContext(AndExpressionContext.class,i);
		}
		public List<TerminalNode> OR() { return getTokens(CmmParser.OR); }
		public TerminalNode OR(int i) {
			return getToken(CmmParser.OR, i);
		}
		public OrExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_orExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CmmListener ) ((CmmListener)listener).enterOrExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CmmListener ) ((CmmListener)listener).exitOrExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CmmVisitor ) return ((CmmVisitor<? extends T>)visitor).visitOrExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final OrExpressionContext orExpression() throws RecognitionException {
		OrExpressionContext _localctx = new OrExpressionContext(_ctx, getState());
		enterRule(_localctx, 54, RULE_orExpression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(502);
			((OrExpressionContext)_localctx).exp1 = andExpression();
			((OrExpressionContext)_localctx).exp =  ((OrExpressionContext)_localctx).exp1.exp;
			setState(510);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==OR) {
				{
				{
				setState(504);
				((OrExpressionContext)_localctx).op = match(OR);
				setState(505);
				((OrExpressionContext)_localctx).exp2 = andExpression();
				((OrExpressionContext)_localctx).exp =  new BinaryExpression(_localctx.exp,((OrExpressionContext)_localctx).exp2.exp,BinaryOperator.or);
				    _localctx.exp.setLine(((OrExpressionContext)_localctx).op.getLine());
				}
				}
				setState(512);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AndExpressionContext extends ParserRuleContext {
		public Expression exp;
		public EqualityExpressionContext exp1;
		public Token op;
		public EqualityExpressionContext exp2;
		public List<EqualityExpressionContext> equalityExpression() {
			return getRuleContexts(EqualityExpressionContext.class);
		}
		public EqualityExpressionContext equalityExpression(int i) {
			return getRuleContext(EqualityExpressionContext.class,i);
		}
		public List<TerminalNode> AND() { return getTokens(CmmParser.AND); }
		public TerminalNode AND(int i) {
			return getToken(CmmParser.AND, i);
		}
		public AndExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_andExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CmmListener ) ((CmmListener)listener).enterAndExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CmmListener ) ((CmmListener)listener).exitAndExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CmmVisitor ) return ((CmmVisitor<? extends T>)visitor).visitAndExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AndExpressionContext andExpression() throws RecognitionException {
		AndExpressionContext _localctx = new AndExpressionContext(_ctx, getState());
		enterRule(_localctx, 56, RULE_andExpression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(513);
			((AndExpressionContext)_localctx).exp1 = equalityExpression();
			((AndExpressionContext)_localctx).exp =  ((AndExpressionContext)_localctx).exp1.exp;
			setState(521);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==AND) {
				{
				{
				setState(515);
				((AndExpressionContext)_localctx).op = match(AND);
				setState(516);
				((AndExpressionContext)_localctx).exp2 = equalityExpression();
				((AndExpressionContext)_localctx).exp =  new BinaryExpression(_localctx.exp,((AndExpressionContext)_localctx).exp2.exp,BinaryOperator.and);
				    _localctx.exp.setLine(((AndExpressionContext)_localctx).op.getLine());
				}
				}
				setState(523);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class EqualityExpressionContext extends ParserRuleContext {
		public Expression exp;
		public RelationalExpressionContext exp1;
		public Token op;
		public RelationalExpressionContext exp2;
		public List<RelationalExpressionContext> relationalExpression() {
			return getRuleContexts(RelationalExpressionContext.class);
		}
		public RelationalExpressionContext relationalExpression(int i) {
			return getRuleContext(RelationalExpressionContext.class,i);
		}
		public List<TerminalNode> EQUAL() { return getTokens(CmmParser.EQUAL); }
		public TerminalNode EQUAL(int i) {
			return getToken(CmmParser.EQUAL, i);
		}
		public EqualityExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_equalityExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CmmListener ) ((CmmListener)listener).enterEqualityExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CmmListener ) ((CmmListener)listener).exitEqualityExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CmmVisitor ) return ((CmmVisitor<? extends T>)visitor).visitEqualityExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final EqualityExpressionContext equalityExpression() throws RecognitionException {
		EqualityExpressionContext _localctx = new EqualityExpressionContext(_ctx, getState());
		enterRule(_localctx, 58, RULE_equalityExpression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(524);
			((EqualityExpressionContext)_localctx).exp1 = relationalExpression();
			((EqualityExpressionContext)_localctx).exp =  ((EqualityExpressionContext)_localctx).exp1.exp;
			setState(532);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==EQUAL) {
				{
				{
				setState(526);
				((EqualityExpressionContext)_localctx).op = match(EQUAL);
				setState(527);
				((EqualityExpressionContext)_localctx).exp2 = relationalExpression();
				((EqualityExpressionContext)_localctx).exp =  new BinaryExpression(_localctx.exp,((EqualityExpressionContext)_localctx).exp2.exp,BinaryOperator.eq);
				    _localctx.exp.setLine(((EqualityExpressionContext)_localctx).op.getLine());
				}
				}
				setState(534);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class RelationalExpressionContext extends ParserRuleContext {
		public Expression exp;
		public BinaryOperator op;
		public AdditiveExpressionContext exp1;
		public Token ll;
		public AdditiveExpressionContext exp2;
		public List<AdditiveExpressionContext> additiveExpression() {
			return getRuleContexts(AdditiveExpressionContext.class);
		}
		public AdditiveExpressionContext additiveExpression(int i) {
			return getRuleContext(AdditiveExpressionContext.class,i);
		}
		public List<TerminalNode> GREATER_THAN() { return getTokens(CmmParser.GREATER_THAN); }
		public TerminalNode GREATER_THAN(int i) {
			return getToken(CmmParser.GREATER_THAN, i);
		}
		public List<TerminalNode> LESS_THAN() { return getTokens(CmmParser.LESS_THAN); }
		public TerminalNode LESS_THAN(int i) {
			return getToken(CmmParser.LESS_THAN, i);
		}
		public RelationalExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_relationalExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CmmListener ) ((CmmListener)listener).enterRelationalExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CmmListener ) ((CmmListener)listener).exitRelationalExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CmmVisitor ) return ((CmmVisitor<? extends T>)visitor).visitRelationalExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RelationalExpressionContext relationalExpression() throws RecognitionException {
		RelationalExpressionContext _localctx = new RelationalExpressionContext(_ctx, getState());
		enterRule(_localctx, 60, RULE_relationalExpression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(535);
			((RelationalExpressionContext)_localctx).exp1 = additiveExpression();
			((RelationalExpressionContext)_localctx).exp =  ((RelationalExpressionContext)_localctx).exp1.exp;
			setState(548);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==GREATER_THAN || _la==LESS_THAN) {
				{
				{
				setState(541);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case GREATER_THAN:
					{
					setState(537);
					((RelationalExpressionContext)_localctx).ll = match(GREATER_THAN);
					((RelationalExpressionContext)_localctx).op =  BinaryOperator.gt;
					}
					break;
				case LESS_THAN:
					{
					setState(539);
					((RelationalExpressionContext)_localctx).ll = match(LESS_THAN);
					((RelationalExpressionContext)_localctx).op =  BinaryOperator.lt;
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(543);
				((RelationalExpressionContext)_localctx).exp2 = additiveExpression();
				((RelationalExpressionContext)_localctx).exp =  new BinaryExpression(_localctx.exp,((RelationalExpressionContext)_localctx).exp2.exp,_localctx.op); _localctx.exp.setLine(((RelationalExpressionContext)_localctx).ll.getLine());
				}
				}
				setState(550);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AdditiveExpressionContext extends ParserRuleContext {
		public Expression exp;
		public BinaryOperator op;
		public MultiplicativeExpressionContext exp1;
		public Token ll;
		public MultiplicativeExpressionContext exp2;
		public List<MultiplicativeExpressionContext> multiplicativeExpression() {
			return getRuleContexts(MultiplicativeExpressionContext.class);
		}
		public MultiplicativeExpressionContext multiplicativeExpression(int i) {
			return getRuleContext(MultiplicativeExpressionContext.class,i);
		}
		public List<TerminalNode> PLUS() { return getTokens(CmmParser.PLUS); }
		public TerminalNode PLUS(int i) {
			return getToken(CmmParser.PLUS, i);
		}
		public List<TerminalNode> MINUS() { return getTokens(CmmParser.MINUS); }
		public TerminalNode MINUS(int i) {
			return getToken(CmmParser.MINUS, i);
		}
		public AdditiveExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_additiveExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CmmListener ) ((CmmListener)listener).enterAdditiveExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CmmListener ) ((CmmListener)listener).exitAdditiveExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CmmVisitor ) return ((CmmVisitor<? extends T>)visitor).visitAdditiveExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AdditiveExpressionContext additiveExpression() throws RecognitionException {
		AdditiveExpressionContext _localctx = new AdditiveExpressionContext(_ctx, getState());
		enterRule(_localctx, 62, RULE_additiveExpression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(551);
			((AdditiveExpressionContext)_localctx).exp1 = multiplicativeExpression();
			((AdditiveExpressionContext)_localctx).exp =  ((AdditiveExpressionContext)_localctx).exp1.exp;
			setState(564);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==PLUS || _la==MINUS) {
				{
				{
				setState(557);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case PLUS:
					{
					setState(553);
					((AdditiveExpressionContext)_localctx).ll = match(PLUS);
					((AdditiveExpressionContext)_localctx).op =  BinaryOperator.add;
					}
					break;
				case MINUS:
					{
					setState(555);
					((AdditiveExpressionContext)_localctx).ll = match(MINUS);
					((AdditiveExpressionContext)_localctx).op =  BinaryOperator.sub;
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(559);
				((AdditiveExpressionContext)_localctx).exp2 = multiplicativeExpression();
				((AdditiveExpressionContext)_localctx).exp =  new BinaryExpression(_localctx.exp,((AdditiveExpressionContext)_localctx).exp2.exp,_localctx.op); _localctx.exp.setLine(((AdditiveExpressionContext)_localctx).ll.getLine());
				}
				}
				setState(566);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class MultiplicativeExpressionContext extends ParserRuleContext {
		public Expression exp;
		public BinaryOperator op;
		public PreUnaryExpressionContext exp1;
		public Token ll;
		public PreUnaryExpressionContext exp2;
		public List<PreUnaryExpressionContext> preUnaryExpression() {
			return getRuleContexts(PreUnaryExpressionContext.class);
		}
		public PreUnaryExpressionContext preUnaryExpression(int i) {
			return getRuleContext(PreUnaryExpressionContext.class,i);
		}
		public List<TerminalNode> MULT() { return getTokens(CmmParser.MULT); }
		public TerminalNode MULT(int i) {
			return getToken(CmmParser.MULT, i);
		}
		public List<TerminalNode> DIVIDE() { return getTokens(CmmParser.DIVIDE); }
		public TerminalNode DIVIDE(int i) {
			return getToken(CmmParser.DIVIDE, i);
		}
		public MultiplicativeExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_multiplicativeExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CmmListener ) ((CmmListener)listener).enterMultiplicativeExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CmmListener ) ((CmmListener)listener).exitMultiplicativeExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CmmVisitor ) return ((CmmVisitor<? extends T>)visitor).visitMultiplicativeExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MultiplicativeExpressionContext multiplicativeExpression() throws RecognitionException {
		MultiplicativeExpressionContext _localctx = new MultiplicativeExpressionContext(_ctx, getState());
		enterRule(_localctx, 64, RULE_multiplicativeExpression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(567);
			((MultiplicativeExpressionContext)_localctx).exp1 = preUnaryExpression();
			((MultiplicativeExpressionContext)_localctx).exp =  ((MultiplicativeExpressionContext)_localctx).exp1.expRet;
			setState(580);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==MULT || _la==DIVIDE) {
				{
				{
				setState(573);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case MULT:
					{
					setState(569);
					((MultiplicativeExpressionContext)_localctx).ll = match(MULT);
					((MultiplicativeExpressionContext)_localctx).op =  BinaryOperator.mult;
					}
					break;
				case DIVIDE:
					{
					setState(571);
					((MultiplicativeExpressionContext)_localctx).ll = match(DIVIDE);
					((MultiplicativeExpressionContext)_localctx).op =  BinaryOperator.div;
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(575);
				((MultiplicativeExpressionContext)_localctx).exp2 = preUnaryExpression();
				((MultiplicativeExpressionContext)_localctx).exp =  new BinaryExpression(_localctx.exp,((MultiplicativeExpressionContext)_localctx).exp2.expRet,_localctx.op); _localctx.exp.setLine(((MultiplicativeExpressionContext)_localctx).ll.getLine());
				}
				}
				setState(582);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class PreUnaryExpressionContext extends ParserRuleContext {
		public Expression expRet;
		public UnaryOperator op;
		public Token ll;
		public PreUnaryExpressionContext e;
		public AccessExpressionContext ae;
		public PreUnaryExpressionContext preUnaryExpression() {
			return getRuleContext(PreUnaryExpressionContext.class,0);
		}
		public TerminalNode NOT() { return getToken(CmmParser.NOT, 0); }
		public TerminalNode MINUS() { return getToken(CmmParser.MINUS, 0); }
		public AccessExpressionContext accessExpression() {
			return getRuleContext(AccessExpressionContext.class,0);
		}
		public PreUnaryExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_preUnaryExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CmmListener ) ((CmmListener)listener).enterPreUnaryExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CmmListener ) ((CmmListener)listener).exitPreUnaryExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CmmVisitor ) return ((CmmVisitor<? extends T>)visitor).visitPreUnaryExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PreUnaryExpressionContext preUnaryExpression() throws RecognitionException {
		PreUnaryExpressionContext _localctx = new PreUnaryExpressionContext(_ctx, getState());
		enterRule(_localctx, 66, RULE_preUnaryExpression);
		try {
			setState(596);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case MINUS:
			case NOT:
				enterOuterAlt(_localctx, 1);
				{
				{
				setState(587);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case NOT:
					{
					setState(583);
					((PreUnaryExpressionContext)_localctx).ll = match(NOT);
					((PreUnaryExpressionContext)_localctx).op =  UnaryOperator.not;
					}
					break;
				case MINUS:
					{
					setState(585);
					((PreUnaryExpressionContext)_localctx).ll = match(MINUS);
					((PreUnaryExpressionContext)_localctx).op =  UnaryOperator.minus;
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(589);
				((PreUnaryExpressionContext)_localctx).e = preUnaryExpression();
				}
				((PreUnaryExpressionContext)_localctx).expRet =  new UnaryExpression(_localctx.expRet,_localctx.op); _localctx.expRet.setLine(((PreUnaryExpressionContext)_localctx).ll.getLine());
				}
				break;
			case SIZE:
			case APPEND:
			case TRUE:
			case FALSE:
			case LPAR:
			case INT_VALUE:
			case IDENTIFIER:
				enterOuterAlt(_localctx, 2);
				{
				setState(593);
				((PreUnaryExpressionContext)_localctx).ae = accessExpression();
				((PreUnaryExpressionContext)_localctx).expRet =  ((PreUnaryExpressionContext)_localctx).ae.expRet;
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AccessExpressionContext extends ParserRuleContext {
		public Expression expRet;
		public OtherExpressionContext exp1;
		public Token ll;
		public FunctionArgumentsContext arg;
		public IdentifierContext i;
		public ExpressionContext exp2;
		public OtherExpressionContext otherExpression() {
			return getRuleContext(OtherExpressionContext.class,0);
		}
		public List<TerminalNode> RPAR() { return getTokens(CmmParser.RPAR); }
		public TerminalNode RPAR(int i) {
			return getToken(CmmParser.RPAR, i);
		}
		public List<TerminalNode> RBRACK() { return getTokens(CmmParser.RBRACK); }
		public TerminalNode RBRACK(int i) {
			return getToken(CmmParser.RBRACK, i);
		}
		public List<TerminalNode> LPAR() { return getTokens(CmmParser.LPAR); }
		public TerminalNode LPAR(int i) {
			return getToken(CmmParser.LPAR, i);
		}
		public List<FunctionArgumentsContext> functionArguments() {
			return getRuleContexts(FunctionArgumentsContext.class);
		}
		public FunctionArgumentsContext functionArguments(int i) {
			return getRuleContext(FunctionArgumentsContext.class,i);
		}
		public List<TerminalNode> DOT() { return getTokens(CmmParser.DOT); }
		public TerminalNode DOT(int i) {
			return getToken(CmmParser.DOT, i);
		}
		public List<IdentifierContext> identifier() {
			return getRuleContexts(IdentifierContext.class);
		}
		public IdentifierContext identifier(int i) {
			return getRuleContext(IdentifierContext.class,i);
		}
		public List<TerminalNode> LBRACK() { return getTokens(CmmParser.LBRACK); }
		public TerminalNode LBRACK(int i) {
			return getToken(CmmParser.LBRACK, i);
		}
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public AccessExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_accessExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CmmListener ) ((CmmListener)listener).enterAccessExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CmmListener ) ((CmmListener)listener).exitAccessExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CmmVisitor ) return ((CmmVisitor<? extends T>)visitor).visitAccessExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AccessExpressionContext accessExpression() throws RecognitionException {
		AccessExpressionContext _localctx = new AccessExpressionContext(_ctx, getState());
		enterRule(_localctx, 68, RULE_accessExpression);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(598);
			((AccessExpressionContext)_localctx).exp1 = otherExpression();
			((AccessExpressionContext)_localctx).expRet =  ((AccessExpressionContext)_localctx).exp1.expRet;
			setState(611);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,57,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					setState(609);
					_errHandler.sync(this);
					switch (_input.LA(1)) {
					case LPAR:
						{
						{
						setState(600);
						((AccessExpressionContext)_localctx).ll = match(LPAR);
						setState(601);
						((AccessExpressionContext)_localctx).arg = functionArguments();
						((AccessExpressionContext)_localctx).expRet =  ((AccessExpressionContext)_localctx).arg.exp; ((AccessExpressionContext)_localctx).arg.exp.setLine(((AccessExpressionContext)_localctx).ll.getLine());
						setState(603);
						match(RPAR);
						}
						}
						break;
					case DOT:
						{
						{
						setState(605);
						((AccessExpressionContext)_localctx).ll = match(DOT);
						setState(606);
						((AccessExpressionContext)_localctx).i = identifier();
						((AccessExpressionContext)_localctx).expRet =  new StructAccess(_localctx.expRet,((AccessExpressionContext)_localctx).i.identifierRet);
							_localctx.expRet.setLine(((AccessExpressionContext)_localctx).ll.getLine());
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					} 
				}
				setState(613);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,57,_ctx);
			}
			setState(625);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==LBRACK || _la==DOT) {
				{
				setState(623);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case LBRACK:
					{
					{
					setState(614);
					((AccessExpressionContext)_localctx).ll = match(LBRACK);
					setState(615);
					((AccessExpressionContext)_localctx).exp2 = expression();
					((AccessExpressionContext)_localctx).expRet =  new ListAccessByIndex(_localctx.expRet,((AccessExpressionContext)_localctx).exp2.expRet);
						_localctx.expRet.setLine(((AccessExpressionContext)_localctx).ll.getLine());
					setState(617);
					match(RBRACK);
					}
					}
					break;
				case DOT:
					{
					{
					setState(619);
					((AccessExpressionContext)_localctx).ll = match(DOT);
					setState(620);
					((AccessExpressionContext)_localctx).i = identifier();
					((AccessExpressionContext)_localctx).expRet =  new StructAccess(_localctx.expRet,((AccessExpressionContext)_localctx).i.identifierRet);
						_localctx.expRet.setLine(((AccessExpressionContext)_localctx).ll.getLine());
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(627);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class OtherExpressionContext extends ParserRuleContext {
		public Expression expRet;
		public ValueContext v;
		public IdentifierContext i;
		public Token ll;
		public FunctionArgumentsContext ar;
		public SizeContext s;
		public AppendContext a;
		public ValueContext value() {
			return getRuleContext(ValueContext.class,0);
		}
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public TerminalNode RPAR() { return getToken(CmmParser.RPAR, 0); }
		public TerminalNode LPAR() { return getToken(CmmParser.LPAR, 0); }
		public FunctionArgumentsContext functionArguments() {
			return getRuleContext(FunctionArgumentsContext.class,0);
		}
		public SizeContext size() {
			return getRuleContext(SizeContext.class,0);
		}
		public AppendContext append() {
			return getRuleContext(AppendContext.class,0);
		}
		public OtherExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_otherExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CmmListener ) ((CmmListener)listener).enterOtherExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CmmListener ) ((CmmListener)listener).exitOtherExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CmmVisitor ) return ((CmmVisitor<? extends T>)visitor).visitOtherExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final OtherExpressionContext otherExpression() throws RecognitionException {
		OtherExpressionContext _localctx = new OtherExpressionContext(_ctx, getState());
		enterRule(_localctx, 70, RULE_otherExpression);
		try {
			setState(645);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case TRUE:
			case FALSE:
			case INT_VALUE:
				enterOuterAlt(_localctx, 1);
				{
				setState(628);
				((OtherExpressionContext)_localctx).v = value();
				((OtherExpressionContext)_localctx).expRet =  ((OtherExpressionContext)_localctx).v.valRet;
				}
				break;
			case IDENTIFIER:
				enterOuterAlt(_localctx, 2);
				{
				setState(631);
				((OtherExpressionContext)_localctx).i = identifier();
				((OtherExpressionContext)_localctx).expRet =  ((OtherExpressionContext)_localctx).i.identifierRet;
				}
				break;
			case LPAR:
				enterOuterAlt(_localctx, 3);
				{
				setState(634);
				((OtherExpressionContext)_localctx).ll = match(LPAR);
				{
				setState(635);
				((OtherExpressionContext)_localctx).ar = functionArguments();
				}
				setState(636);
				match(RPAR);
				((OtherExpressionContext)_localctx).expRet =  ((OtherExpressionContext)_localctx).ar.exp; ((OtherExpressionContext)_localctx).ar.exp.setLine(((OtherExpressionContext)_localctx).ll.getLine());
				}
				break;
			case SIZE:
				enterOuterAlt(_localctx, 4);
				{
				setState(639);
				((OtherExpressionContext)_localctx).s = size();
				((OtherExpressionContext)_localctx).expRet =  ((OtherExpressionContext)_localctx).s.sizeRet.getListSizeExpr();
				}
				break;
			case APPEND:
				enterOuterAlt(_localctx, 5);
				{
				setState(642);
				((OtherExpressionContext)_localctx).a = append();
				((OtherExpressionContext)_localctx).expRet =  ((OtherExpressionContext)_localctx).a.apRet.getListAppendExpr();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SizeContext extends ParserRuleContext {
		public ListSizeStmt sizeRet;
		public ListSize ls;
		public Token ll;
		public ExpressionContext e;
		public TerminalNode LPAR() { return getToken(CmmParser.LPAR, 0); }
		public TerminalNode RPAR() { return getToken(CmmParser.RPAR, 0); }
		public TerminalNode SIZE() { return getToken(CmmParser.SIZE, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public SizeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_size; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CmmListener ) ((CmmListener)listener).enterSize(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CmmListener ) ((CmmListener)listener).exitSize(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CmmVisitor ) return ((CmmVisitor<? extends T>)visitor).visitSize(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SizeContext size() throws RecognitionException {
		SizeContext _localctx = new SizeContext(_ctx, getState());
		enterRule(_localctx, 72, RULE_size);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(647);
			((SizeContext)_localctx).ll = match(SIZE);
			setState(648);
			match(LPAR);
			setState(649);
			((SizeContext)_localctx).e = expression();
			setState(650);
			match(RPAR);
			((SizeContext)_localctx).ls =  new ListSize(((SizeContext)_localctx).e.expRet);
			     _localctx.ls.setLine(((SizeContext)_localctx).ll.getLine());
			     ((SizeContext)_localctx).sizeRet =  new ListSizeStmt(_localctx.ls);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AppendContext extends ParserRuleContext {
		public ListAppendStmt apRet;
		public ListAppend la;
		public Token ll;
		public ExpressionContext l;
		public ExpressionContext r;
		public TerminalNode LPAR() { return getToken(CmmParser.LPAR, 0); }
		public TerminalNode COMMA() { return getToken(CmmParser.COMMA, 0); }
		public TerminalNode RPAR() { return getToken(CmmParser.RPAR, 0); }
		public TerminalNode APPEND() { return getToken(CmmParser.APPEND, 0); }
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public AppendContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_append; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CmmListener ) ((CmmListener)listener).enterAppend(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CmmListener ) ((CmmListener)listener).exitAppend(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CmmVisitor ) return ((CmmVisitor<? extends T>)visitor).visitAppend(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AppendContext append() throws RecognitionException {
		AppendContext _localctx = new AppendContext(_ctx, getState());
		enterRule(_localctx, 74, RULE_append);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(653);
			((AppendContext)_localctx).ll = match(APPEND);
			setState(654);
			match(LPAR);
			setState(655);
			((AppendContext)_localctx).l = expression();
			setState(656);
			match(COMMA);
			setState(657);
			((AppendContext)_localctx).r = expression();
			setState(658);
			match(RPAR);
			((AppendContext)_localctx).la =  new ListAppend(((AppendContext)_localctx).l.expRet,((AppendContext)_localctx).r.expRet);
			     _localctx.la.setLine(((AppendContext)_localctx).ll.getLine());
			     ((AppendContext)_localctx).apRet =  new ListAppendStmt(_localctx.la);
			     _localctx.apRet.setLine(((AppendContext)_localctx).ll.getLine());
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ValueContext extends ParserRuleContext {
		public Value valRet;
		public BoolValueContext bv;
		public Token iv;
		public BoolValueContext boolValue() {
			return getRuleContext(BoolValueContext.class,0);
		}
		public TerminalNode INT_VALUE() { return getToken(CmmParser.INT_VALUE, 0); }
		public ValueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_value; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CmmListener ) ((CmmListener)listener).enterValue(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CmmListener ) ((CmmListener)listener).exitValue(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CmmVisitor ) return ((CmmVisitor<? extends T>)visitor).visitValue(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ValueContext value() throws RecognitionException {
		ValueContext _localctx = new ValueContext(_ctx, getState());
		enterRule(_localctx, 76, RULE_value);
		try {
			setState(667);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case TRUE:
			case FALSE:
				enterOuterAlt(_localctx, 1);
				{
				setState(661);
				((ValueContext)_localctx).bv = boolValue();
				((ValueContext)_localctx).valRet =  ((ValueContext)_localctx).bv.boolValRet;
				}
				break;
			case INT_VALUE:
				enterOuterAlt(_localctx, 2);
				{
				setState(664);
				((ValueContext)_localctx).iv = match(INT_VALUE);
				((ValueContext)_localctx).valRet =  new IntValue(Integer.parseInt(((ValueContext)_localctx).iv.getText()));
				_localctx.valRet.setLine(((ValueContext)_localctx).iv.getLine());
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class BoolValueContext extends ParserRuleContext {
		public BoolValue boolValRet;
		public Token ll;
		public TerminalNode TRUE() { return getToken(CmmParser.TRUE, 0); }
		public TerminalNode FALSE() { return getToken(CmmParser.FALSE, 0); }
		public BoolValueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_boolValue; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CmmListener ) ((CmmListener)listener).enterBoolValue(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CmmListener ) ((CmmListener)listener).exitBoolValue(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CmmVisitor ) return ((CmmVisitor<? extends T>)visitor).visitBoolValue(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BoolValueContext boolValue() throws RecognitionException {
		BoolValueContext _localctx = new BoolValueContext(_ctx, getState());
		enterRule(_localctx, 78, RULE_boolValue);
		try {
			setState(673);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case TRUE:
				enterOuterAlt(_localctx, 1);
				{
				setState(669);
				((BoolValueContext)_localctx).ll = match(TRUE);
				((BoolValueContext)_localctx).boolValRet =  new BoolValue(true); _localctx.boolValRet.setLine(((BoolValueContext)_localctx).ll.getLine());
				}
				break;
			case FALSE:
				enterOuterAlt(_localctx, 2);
				{
				setState(671);
				((BoolValueContext)_localctx).ll = match(FALSE);
				((BoolValueContext)_localctx).boolValRet =  new BoolValue(false); _localctx.boolValRet.setLine(((BoolValueContext)_localctx).ll.getLine());
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class IdentifierContext extends ParserRuleContext {
		public Identifier identifierRet;
		public Token IDENTIFIER;
		public TerminalNode IDENTIFIER() { return getToken(CmmParser.IDENTIFIER, 0); }
		public IdentifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_identifier; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CmmListener ) ((CmmListener)listener).enterIdentifier(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CmmListener ) ((CmmListener)listener).exitIdentifier(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CmmVisitor ) return ((CmmVisitor<? extends T>)visitor).visitIdentifier(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IdentifierContext identifier() throws RecognitionException {
		IdentifierContext _localctx = new IdentifierContext(_ctx, getState());
		enterRule(_localctx, 80, RULE_identifier);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(675);
			((IdentifierContext)_localctx).IDENTIFIER = match(IDENTIFIER);
			((IdentifierContext)_localctx).identifierRet =  new Identifier(((IdentifierContext)_localctx).IDENTIFIER.getText());
			    			_localctx.identifierRet.setLine(((IdentifierContext)_localctx).IDENTIFIER.getLine());
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TypeContext extends ParserRuleContext {
		public Type typeRet;
		public TypeContext t;
		public IdentifierContext i;
		public FptrTypeContext ft;
		public TerminalNode INT() { return getToken(CmmParser.INT, 0); }
		public TerminalNode BOOL() { return getToken(CmmParser.BOOL, 0); }
		public TerminalNode LIST() { return getToken(CmmParser.LIST, 0); }
		public TerminalNode SHARP() { return getToken(CmmParser.SHARP, 0); }
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode STRUCT() { return getToken(CmmParser.STRUCT, 0); }
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public FptrTypeContext fptrType() {
			return getRuleContext(FptrTypeContext.class,0);
		}
		public TypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CmmListener ) ((CmmListener)listener).enterType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CmmListener ) ((CmmListener)listener).exitType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CmmVisitor ) return ((CmmVisitor<? extends T>)visitor).visitType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TypeContext type() throws RecognitionException {
		TypeContext _localctx = new TypeContext(_ctx, getState());
		enterRule(_localctx, 82, RULE_type);
		try {
			setState(694);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case INT:
				enterOuterAlt(_localctx, 1);
				{
				setState(678);
				match(INT);
				((TypeContext)_localctx).typeRet =  new IntType();
				}
				break;
			case BOOL:
				enterOuterAlt(_localctx, 2);
				{
				setState(680);
				match(BOOL);
				((TypeContext)_localctx).typeRet =  new BoolType();
				}
				break;
			case LIST:
				enterOuterAlt(_localctx, 3);
				{
				setState(682);
				match(LIST);
				setState(683);
				match(SHARP);
				setState(684);
				((TypeContext)_localctx).t = type();
				((TypeContext)_localctx).typeRet =  new ListType(((TypeContext)_localctx).t.typeRet);
				}
				break;
			case STRUCT:
				enterOuterAlt(_localctx, 4);
				{
				setState(687);
				match(STRUCT);
				setState(688);
				((TypeContext)_localctx).i = identifier();
				((TypeContext)_localctx).typeRet =  new StructType(((TypeContext)_localctx).i.identifierRet);
				}
				break;
			case FPTR:
				enterOuterAlt(_localctx, 5);
				{
				setState(691);
				((TypeContext)_localctx).ft = fptrType();
				((TypeContext)_localctx).typeRet =  ((TypeContext)_localctx).ft.fptrTypeRet;
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FptrTypeContext extends ParserRuleContext {
		public FptrType fptrTypeRet;
		public ArrayList<Type> list;
		public TypeContext o;
		public TypeContext m;
		public TypeContext t;
		public TerminalNode FPTR() { return getToken(CmmParser.FPTR, 0); }
		public TerminalNode LESS_THAN() { return getToken(CmmParser.LESS_THAN, 0); }
		public TerminalNode ARROW() { return getToken(CmmParser.ARROW, 0); }
		public TerminalNode GREATER_THAN() { return getToken(CmmParser.GREATER_THAN, 0); }
		public List<TerminalNode> VOID() { return getTokens(CmmParser.VOID); }
		public TerminalNode VOID(int i) {
			return getToken(CmmParser.VOID, i);
		}
		public List<TypeContext> type() {
			return getRuleContexts(TypeContext.class);
		}
		public TypeContext type(int i) {
			return getRuleContext(TypeContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(CmmParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(CmmParser.COMMA, i);
		}
		public FptrTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_fptrType; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CmmListener ) ((CmmListener)listener).enterFptrType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CmmListener ) ((CmmListener)listener).exitFptrType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CmmVisitor ) return ((CmmVisitor<? extends T>)visitor).visitFptrType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FptrTypeContext fptrType() throws RecognitionException {
		FptrTypeContext _localctx = new FptrTypeContext(_ctx, getState());
		enterRule(_localctx, 84, RULE_fptrType);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			((FptrTypeContext)_localctx).list =  new ArrayList<>();
			setState(697);
			match(FPTR);
			setState(698);
			match(LESS_THAN);
			setState(711);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case VOID:
				{
				setState(699);
				match(VOID);
				}
				break;
			case INT:
			case BOOL:
			case LIST:
			case STRUCT:
			case FPTR:
				{
				{
				setState(700);
				((FptrTypeContext)_localctx).o = type();
				_localctx.list.add(((FptrTypeContext)_localctx).o.typeRet);
				setState(708);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(702);
					match(COMMA);
					setState(703);
					((FptrTypeContext)_localctx).m = type();
					_localctx.list.add(((FptrTypeContext)_localctx).m.typeRet);
					}
					}
					setState(710);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(713);
			match(ARROW);
			setState(719);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case INT:
			case BOOL:
			case LIST:
			case STRUCT:
			case FPTR:
				{
				setState(714);
				((FptrTypeContext)_localctx).t = type();
				((FptrTypeContext)_localctx).fptrTypeRet =  new FptrType(_localctx.list,((FptrTypeContext)_localctx).t.typeRet);
				}
				break;
			case VOID:
				{
				setState(717);
				match(VOID);
				((FptrTypeContext)_localctx).fptrTypeRet =  new FptrType(_localctx.list,new VoidType());
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(721);
			match(GREATER_THAN);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\60\u02d6\4\2\t\2"+
		"\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\3\2\7\2Z\n\2\f\2\16\2]\13\2\3\2\3\2\3\2\7\2b\n\2\f\2\16\2e\13\2\3"+
		"\2\3\2\3\3\3\3\3\3\3\3\7\3m\n\3\f\3\16\3p\13\3\3\3\3\3\3\3\7\3u\n\3\f"+
		"\3\16\3x\13\3\3\3\3\3\3\3\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\5\3\5\3\5"+
		"\3\5\3\5\3\5\3\5\3\5\6\5\u008d\n\5\r\5\16\5\u008e\3\5\3\5\3\5\6\5\u0094"+
		"\n\5\r\5\16\5\u0095\3\5\3\5\3\5\5\5\u009b\n\5\5\5\u009d\n\5\3\5\6\5\u00a0"+
		"\n\5\r\5\16\5\u00a1\3\5\3\5\3\6\3\6\3\6\3\6\3\6\3\6\6\6\u00ac\n\6\r\6"+
		"\16\6\u00ad\3\6\3\6\3\6\3\6\3\6\3\7\3\7\3\7\3\7\3\7\3\7\5\7\u00bb\n\7"+
		"\3\b\3\b\6\b\u00bf\n\b\r\b\16\b\u00c0\3\b\3\b\3\b\3\b\7\b\u00c7\n\b\f"+
		"\b\16\b\u00ca\13\b\3\b\3\b\3\b\5\b\u00cf\n\b\6\b\u00d1\n\b\r\b\16\b\u00d2"+
		"\3\t\3\t\3\t\3\t\6\t\u00d9\n\t\r\t\16\t\u00da\3\n\3\n\3\n\3\n\6\n\u00e1"+
		"\n\n\r\n\16\n\u00e2\3\13\3\13\3\13\3\13\3\13\3\13\5\13\u00eb\n\13\3\13"+
		"\3\13\3\13\3\13\6\13\u00f1\n\13\r\13\16\13\u00f2\3\13\3\13\3\f\3\f\3\f"+
		"\3\f\3\f\3\f\3\f\3\f\3\f\3\f\7\f\u0101\n\f\f\f\16\f\u0104\13\f\5\f\u0106"+
		"\n\f\3\f\3\f\3\r\3\r\3\r\3\r\3\r\3\r\3\r\7\r\u0111\n\r\f\r\16\r\u0114"+
		"\13\r\5\r\u0116\n\r\3\r\3\r\3\16\3\16\3\16\3\16\6\16\u011e\n\16\r\16\16"+
		"\16\u011f\3\16\3\16\3\16\5\16\u0125\n\16\5\16\u0127\n\16\3\17\3\17\3\17"+
		"\3\17\6\17\u012d\n\17\r\17\16\17\u012e\3\17\3\17\3\17\5\17\u0134\n\17"+
		"\3\20\3\20\3\20\6\20\u0139\n\20\r\20\16\20\u013a\3\20\3\20\3\20\3\20\7"+
		"\20\u0141\n\20\f\20\16\20\u0144\13\20\3\20\3\20\3\20\5\20\u0149\n\20\6"+
		"\20\u014b\n\20\r\20\16\20\u014c\3\20\6\20\u0150\n\20\r\20\16\20\u0151"+
		"\3\20\3\20\3\20\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\5\21\u015f\n\21"+
		"\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\5\21\u0169\n\21\3\21\3\21\7\21"+
		"\u016d\n\21\f\21\16\21\u0170\13\21\3\21\3\21\3\22\3\22\3\22\3\22\3\22"+
		"\3\22\3\22\3\22\3\22\3\22\3\22\7\22\u017f\n\22\f\22\16\22\u0182\13\22"+
		"\3\22\3\22\3\22\3\22\3\22\3\23\3\23\3\23\3\23\3\23\5\23\u018e\n\23\3\23"+
		"\3\23\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\5\24\u019c\n\24"+
		"\3\24\3\24\3\25\7\25\u01a1\n\25\f\25\16\25\u01a4\13\25\3\25\3\25\3\25"+
		"\3\25\3\26\3\26\3\26\3\26\3\26\3\26\5\26\u01b0\n\26\3\27\3\27\3\27\3\27"+
		"\3\27\3\27\3\27\3\30\3\30\3\30\3\30\7\30\u01bd\n\30\f\30\16\30\u01c0\13"+
		"\30\3\30\3\30\3\30\3\30\3\30\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\32\3"+
		"\32\3\32\3\32\3\32\3\32\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3"+
		"\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3"+
		"\33\3\33\3\33\3\33\5\33\u01ef\n\33\3\34\3\34\3\34\3\34\3\34\3\34\5\34"+
		"\u01f7\n\34\3\35\3\35\3\35\3\35\3\35\3\35\7\35\u01ff\n\35\f\35\16\35\u0202"+
		"\13\35\3\36\3\36\3\36\3\36\3\36\3\36\7\36\u020a\n\36\f\36\16\36\u020d"+
		"\13\36\3\37\3\37\3\37\3\37\3\37\3\37\7\37\u0215\n\37\f\37\16\37\u0218"+
		"\13\37\3 \3 \3 \3 \3 \3 \5 \u0220\n \3 \3 \3 \7 \u0225\n \f \16 \u0228"+
		"\13 \3!\3!\3!\3!\3!\3!\5!\u0230\n!\3!\3!\3!\7!\u0235\n!\f!\16!\u0238\13"+
		"!\3\"\3\"\3\"\3\"\3\"\3\"\5\"\u0240\n\"\3\"\3\"\3\"\7\"\u0245\n\"\f\""+
		"\16\"\u0248\13\"\3#\3#\3#\3#\5#\u024e\n#\3#\3#\3#\3#\3#\3#\3#\5#\u0257"+
		"\n#\3$\3$\3$\3$\3$\3$\3$\3$\3$\3$\3$\7$\u0264\n$\f$\16$\u0267\13$\3$\3"+
		"$\3$\3$\3$\3$\3$\3$\3$\7$\u0272\n$\f$\16$\u0275\13$\3%\3%\3%\3%\3%\3%"+
		"\3%\3%\3%\3%\3%\3%\3%\3%\3%\3%\3%\5%\u0288\n%\3&\3&\3&\3&\3&\3&\3\'\3"+
		"\'\3\'\3\'\3\'\3\'\3\'\3\'\3(\3(\3(\3(\3(\3(\5(\u029e\n(\3)\3)\3)\3)\5"+
		")\u02a4\n)\3*\3*\3*\3+\3+\3+\3+\3+\3+\3+\3+\3+\3+\3+\3+\3+\3+\3+\3+\5"+
		"+\u02b9\n+\3,\3,\3,\3,\3,\3,\3,\3,\3,\3,\7,\u02c5\n,\f,\16,\u02c8\13,"+
		"\5,\u02ca\n,\3,\3,\3,\3,\3,\3,\5,\u02d2\n,\3,\3,\3,\2\2-\2\4\6\b\n\f\16"+
		"\20\22\24\26\30\32\34\36 \"$&(*,.\60\62\64\668:<>@BDFHJLNPRTV\2\2\2\u02fa"+
		"\2[\3\2\2\2\4h\3\2\2\2\6|\3\2\2\2\b\u0084\3\2\2\2\n\u00a5\3\2\2\2\f\u00ba"+
		"\3\2\2\2\16\u00bc\3\2\2\2\20\u00d4\3\2\2\2\22\u00dc\3\2\2\2\24\u00e4\3"+
		"\2\2\2\26\u00f6\3\2\2\2\30\u0109\3\2\2\2\32\u0126\3\2\2\2\34\u0133\3\2"+
		"\2\2\36\u0135\3\2\2\2 \u0156\3\2\2\2\"\u0173\3\2\2\2$\u0188\3\2\2\2&\u0191"+
		"\3\2\2\2(\u01a2\3\2\2\2*\u01af\3\2\2\2,\u01b1\3\2\2\2.\u01b8\3\2\2\2\60"+
		"\u01c6\3\2\2\2\62\u01cd\3\2\2\2\64\u01ee\3\2\2\2\66\u01f0\3\2\2\28\u01f8"+
		"\3\2\2\2:\u0203\3\2\2\2<\u020e\3\2\2\2>\u0219\3\2\2\2@\u0229\3\2\2\2B"+
		"\u0239\3\2\2\2D\u0256\3\2\2\2F\u0258\3\2\2\2H\u0287\3\2\2\2J\u0289\3\2"+
		"\2\2L\u028f\3\2\2\2N\u029d\3\2\2\2P\u02a3\3\2\2\2R\u02a5\3\2\2\2T\u02b8"+
		"\3\2\2\2V\u02ba\3\2\2\2XZ\7,\2\2YX\3\2\2\2Z]\3\2\2\2[Y\3\2\2\2[\\\3\2"+
		"\2\2\\^\3\2\2\2][\3\2\2\2^_\5\4\3\2_c\b\2\1\2`b\7,\2\2a`\3\2\2\2be\3\2"+
		"\2\2ca\3\2\2\2cd\3\2\2\2df\3\2\2\2ec\3\2\2\2fg\7\2\2\3g\3\3\2\2\2hn\b"+
		"\3\1\2ij\5\b\5\2jk\b\3\1\2km\3\2\2\2li\3\2\2\2mp\3\2\2\2nl\3\2\2\2no\3"+
		"\2\2\2ov\3\2\2\2pn\3\2\2\2qr\5\24\13\2rs\b\3\1\2su\3\2\2\2tq\3\2\2\2u"+
		"x\3\2\2\2vt\3\2\2\2vw\3\2\2\2wy\3\2\2\2xv\3\2\2\2yz\5\6\4\2z{\b\3\1\2"+
		"{\5\3\2\2\2|}\b\4\1\2}~\7\3\2\2~\177\7%\2\2\177\u0080\7&\2\2\u0080\u0081"+
		"\b\4\1\2\u0081\u0082\5\32\16\2\u0082\u0083\b\4\1\2\u0083\7\3\2\2\2\u0084"+
		"\u0085\b\5\1\2\u0085\u0086\7\35\2\2\u0086\u0087\5R*\2\u0087\u009c\b\5"+
		"\1\2\u0088\u0089\7\30\2\2\u0089\u008a\5\16\b\2\u008a\u008c\b\5\1\2\u008b"+
		"\u008d\7,\2\2\u008c\u008b\3\2\2\2\u008d\u008e\3\2\2\2\u008e\u008c\3\2"+
		"\2\2\u008e\u008f\3\2\2\2\u008f\u0090\3\2\2\2\u0090\u0091\7\31\2\2\u0091"+
		"\u009d\3\2\2\2\u0092\u0094\7,\2\2\u0093\u0092\3\2\2\2\u0094\u0095\3\2"+
		"\2\2\u0095\u0093\3\2\2\2\u0095\u0096\3\2\2\2\u0096\u0097\3\2\2\2\u0097"+
		"\u0098\5\f\7\2\u0098\u009a\b\5\1\2\u0099\u009b\7+\2\2\u009a\u0099\3\2"+
		"\2\2\u009a\u009b\3\2\2\2\u009b\u009d\3\2\2\2\u009c\u0088\3\2\2\2\u009c"+
		"\u0093\3\2\2\2\u009d\u009f\3\2\2\2\u009e\u00a0\7,\2\2\u009f\u009e\3\2"+
		"\2\2\u00a0\u00a1\3\2\2\2\u00a1\u009f\3\2\2\2\u00a1\u00a2\3\2\2\2\u00a2"+
		"\u00a3\3\2\2\2\u00a3\u00a4\b\5\1\2\u00a4\t\3\2\2\2\u00a5\u00a6\b\6\1\2"+
		"\u00a6\u00a7\5T+\2\u00a7\u00a8\5R*\2\u00a8\u00a9\5\26\f\2\u00a9\u00ab"+
		"\7\30\2\2\u00aa\u00ac\7,\2\2\u00ab\u00aa\3\2\2\2\u00ac\u00ad\3\2\2\2\u00ad"+
		"\u00ab\3\2\2\2\u00ad\u00ae\3\2\2\2\u00ae\u00af\3\2\2\2\u00af\u00b0\5\22"+
		"\n\2\u00b0\u00b1\5\20\t\2\u00b1\u00b2\7\31\2\2\u00b2\u00b3\b\6\1\2\u00b3"+
		"\13\3\2\2\2\u00b4\u00b5\5 \21\2\u00b5\u00b6\b\7\1\2\u00b6\u00bb\3\2\2"+
		"\2\u00b7\u00b8\5\n\6\2\u00b8\u00b9\b\7\1\2\u00b9\u00bb\3\2\2\2\u00ba\u00b4"+
		"\3\2\2\2\u00ba\u00b7\3\2\2\2\u00bb\r\3\2\2\2\u00bc\u00d0\b\b\1\2\u00bd"+
		"\u00bf\7,\2\2\u00be\u00bd\3\2\2\2\u00bf\u00c0\3\2\2\2\u00c0\u00be\3\2"+
		"\2\2\u00c0\u00c1\3\2\2\2\u00c1\u00c8\3\2\2\2\u00c2\u00c3\5\f\7\2\u00c3"+
		"\u00c4\b\b\1\2\u00c4\u00c5\7+\2\2\u00c5\u00c7\3\2\2\2\u00c6\u00c2\3\2"+
		"\2\2\u00c7\u00ca\3\2\2\2\u00c8\u00c6\3\2\2\2\u00c8\u00c9\3\2\2\2\u00c9"+
		"\u00cb\3\2\2\2\u00ca\u00c8\3\2\2\2\u00cb\u00cc\5\f\7\2\u00cc\u00ce\b\b"+
		"\1\2\u00cd\u00cf\7+\2\2\u00ce\u00cd\3\2\2\2\u00ce\u00cf\3\2\2\2\u00cf"+
		"\u00d1\3\2\2\2\u00d0\u00be\3\2\2\2\u00d1\u00d2\3\2\2\2\u00d2\u00d0\3\2"+
		"\2\2\u00d2\u00d3\3\2\2\2\u00d3\17\3\2\2\2\u00d4\u00d5\7\37\2\2\u00d5\u00d6"+
		"\5\32\16\2\u00d6\u00d8\b\t\1\2\u00d7\u00d9\7,\2\2\u00d8\u00d7\3\2\2\2"+
		"\u00d9\u00da\3\2\2\2\u00da\u00d8\3\2\2\2\u00da\u00db\3\2\2\2\u00db\21"+
		"\3\2\2\2\u00dc\u00dd\7 \2\2\u00dd\u00de\5\32\16\2\u00de\u00e0\b\n\1\2"+
		"\u00df\u00e1\7,\2\2\u00e0\u00df\3\2\2\2\u00e1\u00e2\3\2\2\2\u00e2\u00e0"+
		"\3\2\2\2\u00e2\u00e3\3\2\2\2\u00e3\23\3\2\2\2\u00e4\u00ea\b\13\1\2\u00e5"+
		"\u00e6\5T+\2\u00e6\u00e7\b\13\1\2\u00e7\u00eb\3\2\2\2\u00e8\u00e9\7\5"+
		"\2\2\u00e9\u00eb\b\13\1\2\u00ea\u00e5\3\2\2\2\u00ea\u00e8\3\2\2\2\u00eb"+
		"\u00ec\3\2\2\2\u00ec\u00ed\5R*\2\u00ed\u00ee\5\26\f\2\u00ee\u00f0\5\32"+
		"\16\2\u00ef\u00f1\7,\2\2\u00f0\u00ef\3\2\2\2\u00f1\u00f2\3\2\2\2\u00f2"+
		"\u00f0\3\2\2\2\u00f2\u00f3\3\2\2\2\u00f3\u00f4\3\2\2\2\u00f4\u00f5\b\13"+
		"\1\2\u00f5\25\3\2\2\2\u00f6\u00f7\b\f\1\2\u00f7\u0105\7%\2\2\u00f8\u00f9"+
		"\5T+\2\u00f9\u00fa\5R*\2\u00fa\u0102\b\f\1\2\u00fb\u00fc\7)\2\2\u00fc"+
		"\u00fd\5T+\2\u00fd\u00fe\5R*\2\u00fe\u00ff\b\f\1\2\u00ff\u0101\3\2\2\2"+
		"\u0100\u00fb\3\2\2\2\u0101\u0104\3\2\2\2\u0102\u0100\3\2\2\2\u0102\u0103"+
		"\3\2\2\2\u0103\u0106\3\2\2\2\u0104\u0102\3\2\2\2\u0105\u00f8\3\2\2\2\u0105"+
		"\u0106\3\2\2\2\u0106\u0107\3\2\2\2\u0107\u0108\7&\2\2\u0108\27\3\2\2\2"+
		"\u0109\u0115\b\r\1\2\u010a\u010b\5\66\34\2\u010b\u0112\b\r\1\2\u010c\u010d"+
		"\7)\2\2\u010d\u010e\5\66\34\2\u010e\u010f\b\r\1\2\u010f\u0111\3\2\2\2"+
		"\u0110\u010c\3\2\2\2\u0111\u0114\3\2\2\2\u0112\u0110\3\2\2\2\u0112\u0113"+
		"\3\2\2\2\u0113\u0116\3\2\2\2\u0114\u0112\3\2\2\2\u0115\u010a\3\2\2\2\u0115"+
		"\u0116\3\2\2\2\u0116\u0117\3\2\2\2\u0117\u0118\b\r\1\2\u0118\31\3\2\2"+
		"\2\u0119\u011a\5\36\20\2\u011a\u011b\b\16\1\2\u011b\u0127\3\2\2\2\u011c"+
		"\u011e\7,\2\2\u011d\u011c\3\2\2\2\u011e\u011f\3\2\2\2\u011f\u011d\3\2"+
		"\2\2\u011f\u0120\3\2\2\2\u0120\u0121\3\2\2\2\u0121\u0122\5\64\33\2\u0122"+
		"\u0124\b\16\1\2\u0123\u0125\7+\2\2\u0124\u0123\3\2\2\2\u0124\u0125\3\2"+
		"\2\2\u0125\u0127\3\2\2\2\u0126\u0119\3\2\2\2\u0126\u011d\3\2\2\2\u0127"+
		"\33\3\2\2\2\u0128\u0129\5\36\20\2\u0129\u012a\b\17\1\2\u012a\u0134\3\2"+
		"\2\2\u012b\u012d\7,\2\2\u012c\u012b\3\2\2\2\u012d\u012e\3\2\2\2\u012e"+
		"\u012c\3\2\2\2\u012e\u012f\3\2\2\2\u012f\u0130\3\2\2\2\u0130\u0131\5\64"+
		"\33\2\u0131\u0132\b\17\1\2\u0132\u0134\3\2\2\2\u0133\u0128\3\2\2\2\u0133"+
		"\u012c\3\2\2\2\u0134\35\3\2\2\2\u0135\u0136\b\20\1\2\u0136\u014a\7\30"+
		"\2\2\u0137\u0139\7,\2\2\u0138\u0137\3\2\2\2\u0139\u013a\3\2\2\2\u013a"+
		"\u0138\3\2\2\2\u013a\u013b\3\2\2\2\u013b\u0142\3\2\2\2\u013c\u013d\5\64"+
		"\33\2\u013d\u013e\b\20\1\2\u013e\u013f\7+\2\2\u013f\u0141\3\2\2\2\u0140"+
		"\u013c\3\2\2\2\u0141\u0144\3\2\2\2\u0142\u0140\3\2\2\2\u0142\u0143\3\2"+
		"\2\2\u0143\u0145\3\2\2\2\u0144\u0142\3\2\2\2\u0145\u0146\5\64\33\2\u0146"+
		"\u0148\b\20\1\2\u0147\u0149\7+\2\2\u0148\u0147\3\2\2\2\u0148\u0149\3\2"+
		"\2\2\u0149\u014b\3\2\2\2\u014a\u0138\3\2\2\2\u014b\u014c\3\2\2\2\u014c"+
		"\u014a\3\2\2\2\u014c\u014d\3\2\2\2\u014d\u014f\3\2\2\2\u014e\u0150\7,"+
		"\2\2\u014f\u014e\3\2\2\2\u0150\u0151\3\2\2\2\u0151\u014f\3\2\2\2\u0151"+
		"\u0152\3\2\2\2\u0152\u0153\3\2\2\2\u0153\u0154\7\31\2\2\u0154\u0155\b"+
		"\20\1\2\u0155\37\3\2\2\2\u0156\u0157\b\21\1\2\u0157\u0158\5T+\2\u0158"+
		"\u0159\5R*\2\u0159\u015e\b\21\1\2\u015a\u015b\7#\2\2\u015b\u015c\58\35"+
		"\2\u015c\u015d\b\21\1\2\u015d\u015f\3\2\2\2\u015e\u015a\3\2\2\2\u015e"+
		"\u015f\3\2\2\2\u015f\u0160\3\2\2\2\u0160\u016e\b\21\1\2\u0161\u0162\7"+
		")\2\2\u0162\u0163\5R*\2\u0163\u0168\b\21\1\2\u0164\u0165\7#\2\2\u0165"+
		"\u0166\58\35\2\u0166\u0167\b\21\1\2\u0167\u0169\3\2\2\2\u0168\u0164\3"+
		"\2\2\2\u0168\u0169\3\2\2\2\u0169\u016a\3\2\2\2\u016a\u016b\b\21\1\2\u016b"+
		"\u016d\3\2\2\2\u016c\u0161\3\2\2\2\u016d\u0170\3\2\2\2\u016e\u016c\3\2"+
		"\2\2\u016e\u016f\3\2\2\2\u016f\u0171\3\2\2\2\u0170\u016e\3\2\2\2\u0171"+
		"\u0172\b\21\1\2\u0172!\3\2\2\2\u0173\u0174\5H%\2\u0174\u0180\b\22\1\2"+
		"\u0175\u0176\7%\2\2\u0176\u0177\5\30\r\2\u0177\u0178\b\22\1\2\u0178\u0179"+
		"\7&\2\2\u0179\u017f\3\2\2\2\u017a\u017b\7*\2\2\u017b\u017c\5R*\2\u017c"+
		"\u017d\b\22\1\2\u017d\u017f\3\2\2\2\u017e\u0175\3\2\2\2\u017e\u017a\3"+
		"\2\2\2\u017f\u0182\3\2\2\2\u0180\u017e\3\2\2\2\u0180\u0181\3\2\2\2\u0181"+
		"\u0183\3\2\2\2\u0182\u0180\3\2\2\2\u0183\u0184\7%\2\2\u0184\u0185\5\30"+
		"\r\2\u0185\u0186\b\22\1\2\u0186\u0187\7&\2\2\u0187#\3\2\2\2\u0188\u0189"+
		"\b\23\1\2\u0189\u018d\7\4\2\2\u018a\u018b\5\66\34\2\u018b\u018c\b\23\1"+
		"\2\u018c\u018e\3\2\2\2\u018d\u018a\3\2\2\2\u018d\u018e\3\2\2\2\u018e\u018f"+
		"\3\2\2\2\u018f\u0190\b\23\1\2\u0190%\3\2\2\2\u0191\u0192\7\t\2\2\u0192"+
		"\u0193\5\66\34\2\u0193\u019b\b\24\1\2\u0194\u0195\5\34\17\2\u0195\u0196"+
		"\b\24\1\2\u0196\u019c\3\2\2\2\u0197\u0198\5\32\16\2\u0198\u0199\5(\25"+
		"\2\u0199\u019a\b\24\1\2\u019a\u019c\3\2\2\2\u019b\u0194\3\2\2\2\u019b"+
		"\u0197\3\2\2\2\u019c\u019d\3\2\2\2\u019d\u019e\b\24\1\2\u019e\'\3\2\2"+
		"\2\u019f\u01a1\7,\2\2\u01a0\u019f\3\2\2\2\u01a1\u01a4\3\2\2\2\u01a2\u01a0"+
		"\3\2\2\2\u01a2\u01a3\3\2\2\2\u01a3\u01a5\3\2\2\2\u01a4\u01a2\3\2\2\2\u01a5"+
		"\u01a6\7\n\2\2\u01a6\u01a7\5\34\17\2\u01a7\u01a8\b\25\1\2\u01a8)\3\2\2"+
		"\2\u01a9\u01aa\5,\27\2\u01aa\u01ab\b\26\1\2\u01ab\u01b0\3\2\2\2\u01ac"+
		"\u01ad\5.\30\2\u01ad\u01ae\b\26\1\2\u01ae\u01b0\3\2\2\2\u01af\u01a9\3"+
		"\2\2\2\u01af\u01ac\3\2\2\2\u01b0+\3\2\2\2\u01b1\u01b2\b\27\1\2\u01b2\u01b3"+
		"\7!\2\2\u01b3\u01b4\5\66\34\2\u01b4\u01b5\5\34\17\2\u01b5\u01b6\b\27\1"+
		"\2\u01b6\u01b7\b\27\1\2\u01b7-\3\2\2\2\u01b8\u01b9\b\30\1\2\u01b9\u01ba"+
		"\7\"\2\2\u01ba\u01be\5\32\16\2\u01bb\u01bd\7,\2\2\u01bc\u01bb\3\2\2\2"+
		"\u01bd\u01c0\3\2\2\2\u01be\u01bc\3\2\2\2\u01be\u01bf\3\2\2\2\u01bf\u01c1"+
		"\3\2\2\2\u01c0\u01be\3\2\2\2\u01c1\u01c2\7!\2\2\u01c2\u01c3\5\66\34\2"+
		"\u01c3\u01c4\b\30\1\2\u01c4\u01c5\b\30\1\2\u01c5/\3\2\2\2\u01c6\u01c7"+
		"\7\7\2\2\u01c7\u01c8\7%\2\2\u01c8\u01c9\5\66\34\2\u01c9\u01ca\7&\2\2\u01ca"+
		"\u01cb\b\31\1\2\u01cb\u01cc\b\31\1\2\u01cc\61\3\2\2\2\u01cd\u01ce\58\35"+
		"\2\u01ce\u01cf\7#\2\2\u01cf\u01d0\5\66\34\2\u01d0\u01d1\b\32\1\2\u01d1"+
		"\u01d2\b\32\1\2\u01d2\63\3\2\2\2\u01d3\u01d4\5&\24\2\u01d4\u01d5\b\33"+
		"\1\2\u01d5\u01ef\3\2\2\2\u01d6\u01d7\5\60\31\2\u01d7\u01d8\b\33\1\2\u01d8"+
		"\u01ef\3\2\2\2\u01d9\u01da\5\"\22\2\u01da\u01db\b\33\1\2\u01db\u01ef\3"+
		"\2\2\2\u01dc\u01dd\5$\23\2\u01dd\u01de\b\33\1\2\u01de\u01ef\3\2\2\2\u01df"+
		"\u01e0\5\62\32\2\u01e0\u01e1\b\33\1\2\u01e1\u01ef\3\2\2\2\u01e2\u01e3"+
		"\5 \21\2\u01e3\u01e4\b\33\1\2\u01e4\u01ef\3\2\2\2\u01e5\u01e6\5*\26\2"+
		"\u01e6\u01e7\b\33\1\2\u01e7\u01ef\3\2\2\2\u01e8\u01e9\5J&\2\u01e9\u01ea"+
		"\b\33\1\2\u01ea\u01ef\3\2\2\2\u01eb\u01ec\5L\'\2\u01ec\u01ed\b\33\1\2"+
		"\u01ed\u01ef\3\2\2\2\u01ee\u01d3\3\2\2\2\u01ee\u01d6\3\2\2\2\u01ee\u01d9"+
		"\3\2\2\2\u01ee\u01dc\3\2\2\2\u01ee\u01df\3\2\2\2\u01ee\u01e2\3\2\2\2\u01ee"+
		"\u01e5\3\2\2\2\u01ee\u01e8\3\2\2\2\u01ee\u01eb\3\2\2\2\u01ef\65\3\2\2"+
		"\2\u01f0\u01f1\58\35\2\u01f1\u01f6\b\34\1\2\u01f2\u01f3\7#\2\2\u01f3\u01f4"+
		"\5\66\34\2\u01f4\u01f5\b\34\1\2\u01f5\u01f7\3\2\2\2\u01f6\u01f2\3\2\2"+
		"\2\u01f6\u01f7\3\2\2\2\u01f7\67\3\2\2\2\u01f8\u01f9\5:\36\2\u01f9\u0200"+
		"\b\35\1\2\u01fa\u01fb\7\24\2\2\u01fb\u01fc\5:\36\2\u01fc\u01fd\b\35\1"+
		"\2\u01fd\u01ff\3\2\2\2\u01fe\u01fa\3\2\2\2\u01ff\u0202\3\2\2\2\u0200\u01fe"+
		"\3\2\2\2\u0200\u0201\3\2\2\2\u02019\3\2\2\2\u0202\u0200\3\2\2\2\u0203"+
		"\u0204\5<\37\2\u0204\u020b\b\36\1\2\u0205\u0206\7\23\2\2\u0206\u0207\5"+
		"<\37\2\u0207\u0208\b\36\1\2\u0208\u020a\3\2\2\2\u0209\u0205\3\2\2\2\u020a"+
		"\u020d\3\2\2\2\u020b\u0209\3\2\2\2\u020b\u020c\3\2\2\2\u020c;\3\2\2\2"+
		"\u020d\u020b\3\2\2\2\u020e\u020f\5> \2\u020f\u0216\b\37\1\2\u0210\u0211"+
		"\7\17\2\2\u0211\u0212\5> \2\u0212\u0213\b\37\1\2\u0213\u0215\3\2\2\2\u0214"+
		"\u0210\3\2\2\2\u0215\u0218\3\2\2\2\u0216\u0214\3\2\2\2\u0216\u0217\3\2"+
		"\2\2\u0217=\3\2\2\2\u0218\u0216\3\2\2\2\u0219\u021a\5@!\2\u021a\u0226"+
		"\b \1\2\u021b\u021c\7\21\2\2\u021c\u0220\b \1\2\u021d\u021e\7\22\2\2\u021e"+
		"\u0220\b \1\2\u021f\u021b\3\2\2\2\u021f\u021d\3\2\2\2\u0220\u0221\3\2"+
		"\2\2\u0221\u0222\5@!\2\u0222\u0223\b \1\2\u0223\u0225\3\2\2\2\u0224\u021f"+
		"\3\2\2\2\u0225\u0228\3\2\2\2\u0226\u0224\3\2\2\2\u0226\u0227\3\2\2\2\u0227"+
		"?\3\2\2\2\u0228\u0226\3\2\2\2\u0229\u022a\5B\"\2\u022a\u0236\b!\1\2\u022b"+
		"\u022c\7\13\2\2\u022c\u0230\b!\1\2\u022d\u022e\7\f\2\2\u022e\u0230\b!"+
		"\1\2\u022f\u022b\3\2\2\2\u022f\u022d\3\2\2\2\u0230\u0231\3\2\2\2\u0231"+
		"\u0232\5B\"\2\u0232\u0233\b!\1\2\u0233\u0235\3\2\2\2\u0234\u022f\3\2\2"+
		"\2\u0235\u0238\3\2\2\2\u0236\u0234\3\2\2\2\u0236\u0237\3\2\2\2\u0237A"+
		"\3\2\2\2\u0238\u0236\3\2\2\2\u0239\u023a\5D#\2\u023a\u0246\b\"\1\2\u023b"+
		"\u023c\7\r\2\2\u023c\u0240\b\"\1\2\u023d\u023e\7\16\2\2\u023e\u0240\b"+
		"\"\1\2\u023f\u023b\3\2\2\2\u023f\u023d\3\2\2\2\u0240\u0241\3\2\2\2\u0241"+
		"\u0242\5D#\2\u0242\u0243\b\"\1\2\u0243\u0245\3\2\2\2\u0244\u023f\3\2\2"+
		"\2\u0245\u0248\3\2\2\2\u0246\u0244\3\2\2\2\u0246\u0247\3\2\2\2\u0247C"+
		"\3\2\2\2\u0248\u0246\3\2\2\2\u0249\u024a\7\25\2\2\u024a\u024e\b#\1\2\u024b"+
		"\u024c\7\f\2\2\u024c\u024e\b#\1\2\u024d\u0249\3\2\2\2\u024d\u024b\3\2"+
		"\2\2\u024e\u024f\3\2\2\2\u024f\u0250\5D#\2\u0250\u0251\3\2\2\2\u0251\u0252"+
		"\b#\1\2\u0252\u0257\3\2\2\2\u0253\u0254\5F$\2\u0254\u0255\b#\1\2\u0255"+
		"\u0257\3\2\2\2\u0256\u024d\3\2\2\2\u0256\u0253\3\2\2\2\u0257E\3\2\2\2"+
		"\u0258\u0259\5H%\2\u0259\u0265\b$\1\2\u025a\u025b\7%\2\2\u025b\u025c\5"+
		"\30\r\2\u025c\u025d\b$\1\2\u025d\u025e\7&\2\2\u025e\u0264\3\2\2\2\u025f"+
		"\u0260\7*\2\2\u0260\u0261\5R*\2\u0261\u0262\b$\1\2\u0262\u0264\3\2\2\2"+
		"\u0263\u025a\3\2\2\2\u0263\u025f\3\2\2\2\u0264\u0267\3\2\2\2\u0265\u0263"+
		"\3\2\2\2\u0265\u0266\3\2\2\2\u0266\u0273\3\2\2\2\u0267\u0265\3\2\2\2\u0268"+
		"\u0269\7\'\2\2\u0269\u026a\5\66\34\2\u026a\u026b\b$\1\2\u026b\u026c\7"+
		"(\2\2\u026c\u0272\3\2\2\2\u026d\u026e\7*\2\2\u026e\u026f\5R*\2\u026f\u0270"+
		"\b$\1\2\u0270\u0272\3\2\2\2\u0271\u0268\3\2\2\2\u0271\u026d\3\2\2\2\u0272"+
		"\u0275\3\2\2\2\u0273\u0271\3\2\2\2\u0273\u0274\3\2\2\2\u0274G\3\2\2\2"+
		"\u0275\u0273\3\2\2\2\u0276\u0277\5N(\2\u0277\u0278\b%\1\2\u0278\u0288"+
		"\3\2\2\2\u0279\u027a\5R*\2\u027a\u027b\b%\1\2\u027b\u0288\3\2\2\2\u027c"+
		"\u027d\7%\2\2\u027d\u027e\5\30\r\2\u027e\u027f\7&\2\2\u027f\u0280\b%\1"+
		"\2\u0280\u0288\3\2\2\2\u0281\u0282\5J&\2\u0282\u0283\b%\1\2\u0283\u0288"+
		"\3\2\2\2\u0284\u0285\5L\'\2\u0285\u0286\b%\1\2\u0286\u0288\3\2\2\2\u0287"+
		"\u0276\3\2\2\2\u0287\u0279\3\2\2\2\u0287\u027c\3\2\2\2\u0287\u0281\3\2"+
		"\2\2\u0287\u0284\3\2\2\2\u0288I\3\2\2\2\u0289\u028a\7\6\2\2\u028a\u028b"+
		"\7%\2\2\u028b\u028c\5\66\34\2\u028c\u028d\7&\2\2\u028d\u028e\b&\1\2\u028e"+
		"K\3\2\2\2\u028f\u0290\7\b\2\2\u0290\u0291\7%\2\2\u0291\u0292\5\66\34\2"+
		"\u0292\u0293\7)\2\2\u0293\u0294\5\66\34\2\u0294\u0295\7&\2\2\u0295\u0296"+
		"\b\'\1\2\u0296M\3\2\2\2\u0297\u0298\5P)\2\u0298\u0299\b(\1\2\u0299\u029e"+
		"\3\2\2\2\u029a\u029b\7-\2\2\u029b\u029c\b(\1\2\u029c\u029e\b(\1\2\u029d"+
		"\u0297\3\2\2\2\u029d\u029a\3\2\2\2\u029eO\3\2\2\2\u029f\u02a0\7\26\2\2"+
		"\u02a0\u02a4\b)\1\2\u02a1\u02a2\7\27\2\2\u02a2\u02a4\b)\1\2\u02a3\u029f"+
		"\3\2\2\2\u02a3\u02a1\3\2\2\2\u02a4Q\3\2\2\2\u02a5\u02a6\7.\2\2\u02a6\u02a7"+
		"\b*\1\2\u02a7S\3\2\2\2\u02a8\u02a9\7\32\2\2\u02a9\u02b9\b+\1\2\u02aa\u02ab"+
		"\7\33\2\2\u02ab\u02b9\b+\1\2\u02ac\u02ad\7\34\2\2\u02ad\u02ae\7$\2\2\u02ae"+
		"\u02af\5T+\2\u02af\u02b0\b+\1\2\u02b0\u02b9\3\2\2\2\u02b1\u02b2\7\35\2"+
		"\2\u02b2\u02b3\5R*\2\u02b3\u02b4\b+\1\2\u02b4\u02b9\3\2\2\2\u02b5\u02b6"+
		"\5V,\2\u02b6\u02b7\b+\1\2\u02b7\u02b9\3\2\2\2\u02b8\u02a8\3\2\2\2\u02b8"+
		"\u02aa\3\2\2\2\u02b8\u02ac\3\2\2\2\u02b8\u02b1\3\2\2\2\u02b8\u02b5\3\2"+
		"\2\2\u02b9U\3\2\2\2\u02ba\u02bb\b,\1\2\u02bb\u02bc\7\36\2\2\u02bc\u02c9"+
		"\7\22\2\2\u02bd\u02ca\7\5\2\2\u02be\u02bf\5T+\2\u02bf\u02c6\b,\1\2\u02c0"+
		"\u02c1\7)\2\2\u02c1\u02c2\5T+\2\u02c2\u02c3\b,\1\2\u02c3\u02c5\3\2\2\2"+
		"\u02c4\u02c0\3\2\2\2\u02c5\u02c8\3\2\2\2\u02c6\u02c4\3\2\2\2\u02c6\u02c7"+
		"\3\2\2\2\u02c7\u02ca\3\2\2\2\u02c8\u02c6\3\2\2\2\u02c9\u02bd\3\2\2\2\u02c9"+
		"\u02be\3\2\2\2\u02ca\u02cb\3\2\2\2\u02cb\u02d1\7\20\2\2\u02cc\u02cd\5"+
		"T+\2\u02cd\u02ce\b,\1\2\u02ce\u02d2\3\2\2\2\u02cf\u02d0\7\5\2\2\u02d0"+
		"\u02d2\b,\1\2\u02d1\u02cc\3\2\2\2\u02d1\u02cf\3\2\2\2\u02d2\u02d3\3\2"+
		"\2\2\u02d3\u02d4\7\21\2\2\u02d4W\3\2\2\2E[cnv\u008e\u0095\u009a\u009c"+
		"\u00a1\u00ad\u00ba\u00c0\u00c8\u00ce\u00d2\u00da\u00e2\u00ea\u00f2\u0102"+
		"\u0105\u0112\u0115\u011f\u0124\u0126\u012e\u0133\u013a\u0142\u0148\u014c"+
		"\u0151\u015e\u0168\u016e\u017e\u0180\u018d\u019b\u01a2\u01af\u01be\u01ee"+
		"\u01f6\u0200\u020b\u0216\u021f\u0226\u022f\u0236\u023f\u0246\u024d\u0256"+
		"\u0263\u0265\u0271\u0273\u0287\u029d\u02a3\u02b8\u02c6\u02c9\u02d1";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}