// Generated from java-escape by ANTLR 4.11.1
package parser;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue"})
public class AssemblyParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.11.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, OPCODE_SIMPLE=6, OPCODE_COMPOUND=7, 
		SPACE=8, DECIMAL_LITERAL=9, HEX_LITERAL=10, BINARY_LITERAL=11, IDENTIFIER=12, 
		NEWLINE=13, WS=14;
	public static final int
		RULE_program = 0, RULE_statement = 1, RULE_simple_instruction = 2, RULE_compound_instruction = 3, 
		RULE_label = 4, RULE_literal = 5, RULE_constant = 6, RULE_variable = 7;
	private static String[] makeRuleNames() {
		return new String[] {
			"program", "statement", "simple_instruction", "compound_instruction", 
			"label", "literal", "constant", "variable"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'$'", "':'", "'const'", "'='", "'var'", null, null, "' '"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, "OPCODE_SIMPLE", "OPCODE_COMPOUND", 
			"SPACE", "DECIMAL_LITERAL", "HEX_LITERAL", "BINARY_LITERAL", "IDENTIFIER", 
			"NEWLINE", "WS"
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
	public String getGrammarFileName() { return "java-escape"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public AssemblyParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ProgramContext extends ParserRuleContext {
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public List<TerminalNode> NEWLINE() { return getTokens(AssemblyParser.NEWLINE); }
		public TerminalNode NEWLINE(int i) {
			return getToken(AssemblyParser.NEWLINE, i);
		}
		public ProgramContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_program; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AssemblyVisitor ) return ((AssemblyVisitor<? extends T>)visitor).visitProgram(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ProgramContext program() throws RecognitionException {
		ProgramContext _localctx = new ProgramContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_program);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(25);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (((_la) & ~0x3f) == 0 && ((1L << _la) & 4328L) != 0) {
				{
				{
				setState(16);
				statement();
				setState(20);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==NEWLINE) {
					{
					{
					setState(17);
					match(NEWLINE);
					}
					}
					setState(22);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				}
				setState(27);
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

	@SuppressWarnings("CheckReturnValue")
	public static class StatementContext extends ParserRuleContext {
		public LabelContext label() {
			return getRuleContext(LabelContext.class,0);
		}
		public VariableContext variable() {
			return getRuleContext(VariableContext.class,0);
		}
		public ConstantContext constant() {
			return getRuleContext(ConstantContext.class,0);
		}
		public Simple_instructionContext simple_instruction() {
			return getRuleContext(Simple_instructionContext.class,0);
		}
		public Compound_instructionContext compound_instruction() {
			return getRuleContext(Compound_instructionContext.class,0);
		}
		public StatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statement; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AssemblyVisitor ) return ((AssemblyVisitor<? extends T>)visitor).visitStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StatementContext statement() throws RecognitionException {
		StatementContext _localctx = new StatementContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_statement);
		try {
			setState(33);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case IDENTIFIER:
				enterOuterAlt(_localctx, 1);
				{
				setState(28);
				label();
				}
				break;
			case T__4:
				enterOuterAlt(_localctx, 2);
				{
				setState(29);
				variable();
				}
				break;
			case T__2:
				enterOuterAlt(_localctx, 3);
				{
				setState(30);
				constant();
				}
				break;
			case OPCODE_SIMPLE:
				enterOuterAlt(_localctx, 4);
				{
				setState(31);
				simple_instruction();
				}
				break;
			case OPCODE_COMPOUND:
				enterOuterAlt(_localctx, 5);
				{
				setState(32);
				compound_instruction();
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

	@SuppressWarnings("CheckReturnValue")
	public static class Simple_instructionContext extends ParserRuleContext {
		public TerminalNode OPCODE_SIMPLE() { return getToken(AssemblyParser.OPCODE_SIMPLE, 0); }
		public Simple_instructionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_simple_instruction; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AssemblyVisitor ) return ((AssemblyVisitor<? extends T>)visitor).visitSimple_instruction(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Simple_instructionContext simple_instruction() throws RecognitionException {
		Simple_instructionContext _localctx = new Simple_instructionContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_simple_instruction);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(35);
			match(OPCODE_SIMPLE);
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

	@SuppressWarnings("CheckReturnValue")
	public static class Compound_instructionContext extends ParserRuleContext {
		public TerminalNode OPCODE_COMPOUND() { return getToken(AssemblyParser.OPCODE_COMPOUND, 0); }
		public TerminalNode SPACE() { return getToken(AssemblyParser.SPACE, 0); }
		public LiteralContext literal() {
			return getRuleContext(LiteralContext.class,0);
		}
		public TerminalNode IDENTIFIER() { return getToken(AssemblyParser.IDENTIFIER, 0); }
		public Compound_instructionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_compound_instruction; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AssemblyVisitor ) return ((AssemblyVisitor<? extends T>)visitor).visitCompound_instruction(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Compound_instructionContext compound_instruction() throws RecognitionException {
		Compound_instructionContext _localctx = new Compound_instructionContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_compound_instruction);
		try {
			setState(47);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(37);
				match(OPCODE_COMPOUND);
				setState(38);
				match(SPACE);
				setState(39);
				literal();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(40);
				match(OPCODE_COMPOUND);
				setState(41);
				match(SPACE);
				setState(42);
				match(IDENTIFIER);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(43);
				match(OPCODE_COMPOUND);
				setState(44);
				match(SPACE);
				setState(45);
				match(T__0);
				setState(46);
				match(IDENTIFIER);
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

	@SuppressWarnings("CheckReturnValue")
	public static class LabelContext extends ParserRuleContext {
		public TerminalNode IDENTIFIER() { return getToken(AssemblyParser.IDENTIFIER, 0); }
		public LabelContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_label; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AssemblyVisitor ) return ((AssemblyVisitor<? extends T>)visitor).visitLabel(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LabelContext label() throws RecognitionException {
		LabelContext _localctx = new LabelContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_label);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(49);
			match(IDENTIFIER);
			setState(50);
			match(T__1);
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

	@SuppressWarnings("CheckReturnValue")
	public static class LiteralContext extends ParserRuleContext {
		public TerminalNode DECIMAL_LITERAL() { return getToken(AssemblyParser.DECIMAL_LITERAL, 0); }
		public TerminalNode HEX_LITERAL() { return getToken(AssemblyParser.HEX_LITERAL, 0); }
		public TerminalNode BINARY_LITERAL() { return getToken(AssemblyParser.BINARY_LITERAL, 0); }
		public LiteralContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_literal; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AssemblyVisitor ) return ((AssemblyVisitor<? extends T>)visitor).visitLiteral(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LiteralContext literal() throws RecognitionException {
		LiteralContext _localctx = new LiteralContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_literal);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(52);
			_la = _input.LA(1);
			if ( !(((_la) & ~0x3f) == 0 && ((1L << _la) & 3584L) != 0) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
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

	@SuppressWarnings("CheckReturnValue")
	public static class ConstantContext extends ParserRuleContext {
		public List<TerminalNode> SPACE() { return getTokens(AssemblyParser.SPACE); }
		public TerminalNode SPACE(int i) {
			return getToken(AssemblyParser.SPACE, i);
		}
		public TerminalNode IDENTIFIER() { return getToken(AssemblyParser.IDENTIFIER, 0); }
		public LiteralContext literal() {
			return getRuleContext(LiteralContext.class,0);
		}
		public ConstantContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_constant; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AssemblyVisitor ) return ((AssemblyVisitor<? extends T>)visitor).visitConstant(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ConstantContext constant() throws RecognitionException {
		ConstantContext _localctx = new ConstantContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_constant);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(54);
			match(T__2);
			setState(55);
			match(SPACE);
			setState(56);
			match(IDENTIFIER);
			setState(57);
			match(SPACE);
			setState(58);
			match(T__3);
			setState(62);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==SPACE) {
				{
				{
				setState(59);
				match(SPACE);
				}
				}
				setState(64);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(65);
			literal();
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

	@SuppressWarnings("CheckReturnValue")
	public static class VariableContext extends ParserRuleContext {
		public TerminalNode SPACE() { return getToken(AssemblyParser.SPACE, 0); }
		public TerminalNode IDENTIFIER() { return getToken(AssemblyParser.IDENTIFIER, 0); }
		public VariableContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_variable; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AssemblyVisitor ) return ((AssemblyVisitor<? extends T>)visitor).visitVariable(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VariableContext variable() throws RecognitionException {
		VariableContext _localctx = new VariableContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_variable);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(67);
			match(T__4);
			setState(68);
			match(SPACE);
			setState(69);
			match(IDENTIFIER);
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
		"\u0004\u0001\u000eH\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0001"+
		"\u0000\u0001\u0000\u0005\u0000\u0013\b\u0000\n\u0000\f\u0000\u0016\t\u0000"+
		"\u0005\u0000\u0018\b\u0000\n\u0000\f\u0000\u001b\t\u0000\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0003\u0001\"\b\u0001\u0001"+
		"\u0002\u0001\u0002\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001"+
		"\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0003"+
		"\u00030\b\u0003\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0005\u0001"+
		"\u0005\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001"+
		"\u0006\u0005\u0006=\b\u0006\n\u0006\f\u0006@\t\u0006\u0001\u0006\u0001"+
		"\u0006\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0000"+
		"\u0000\b\u0000\u0002\u0004\u0006\b\n\f\u000e\u0000\u0001\u0001\u0000\t"+
		"\u000bH\u0000\u0019\u0001\u0000\u0000\u0000\u0002!\u0001\u0000\u0000\u0000"+
		"\u0004#\u0001\u0000\u0000\u0000\u0006/\u0001\u0000\u0000\u0000\b1\u0001"+
		"\u0000\u0000\u0000\n4\u0001\u0000\u0000\u0000\f6\u0001\u0000\u0000\u0000"+
		"\u000eC\u0001\u0000\u0000\u0000\u0010\u0014\u0003\u0002\u0001\u0000\u0011"+
		"\u0013\u0005\r\u0000\u0000\u0012\u0011\u0001\u0000\u0000\u0000\u0013\u0016"+
		"\u0001\u0000\u0000\u0000\u0014\u0012\u0001\u0000\u0000\u0000\u0014\u0015"+
		"\u0001\u0000\u0000\u0000\u0015\u0018\u0001\u0000\u0000\u0000\u0016\u0014"+
		"\u0001\u0000\u0000\u0000\u0017\u0010\u0001\u0000\u0000\u0000\u0018\u001b"+
		"\u0001\u0000\u0000\u0000\u0019\u0017\u0001\u0000\u0000\u0000\u0019\u001a"+
		"\u0001\u0000\u0000\u0000\u001a\u0001\u0001\u0000\u0000\u0000\u001b\u0019"+
		"\u0001\u0000\u0000\u0000\u001c\"\u0003\b\u0004\u0000\u001d\"\u0003\u000e"+
		"\u0007\u0000\u001e\"\u0003\f\u0006\u0000\u001f\"\u0003\u0004\u0002\u0000"+
		" \"\u0003\u0006\u0003\u0000!\u001c\u0001\u0000\u0000\u0000!\u001d\u0001"+
		"\u0000\u0000\u0000!\u001e\u0001\u0000\u0000\u0000!\u001f\u0001\u0000\u0000"+
		"\u0000! \u0001\u0000\u0000\u0000\"\u0003\u0001\u0000\u0000\u0000#$\u0005"+
		"\u0006\u0000\u0000$\u0005\u0001\u0000\u0000\u0000%&\u0005\u0007\u0000"+
		"\u0000&\'\u0005\b\u0000\u0000\'0\u0003\n\u0005\u0000()\u0005\u0007\u0000"+
		"\u0000)*\u0005\b\u0000\u0000*0\u0005\f\u0000\u0000+,\u0005\u0007\u0000"+
		"\u0000,-\u0005\b\u0000\u0000-.\u0005\u0001\u0000\u0000.0\u0005\f\u0000"+
		"\u0000/%\u0001\u0000\u0000\u0000/(\u0001\u0000\u0000\u0000/+\u0001\u0000"+
		"\u0000\u00000\u0007\u0001\u0000\u0000\u000012\u0005\f\u0000\u000023\u0005"+
		"\u0002\u0000\u00003\t\u0001\u0000\u0000\u000045\u0007\u0000\u0000\u0000"+
		"5\u000b\u0001\u0000\u0000\u000067\u0005\u0003\u0000\u000078\u0005\b\u0000"+
		"\u000089\u0005\f\u0000\u00009:\u0005\b\u0000\u0000:>\u0005\u0004\u0000"+
		"\u0000;=\u0005\b\u0000\u0000<;\u0001\u0000\u0000\u0000=@\u0001\u0000\u0000"+
		"\u0000><\u0001\u0000\u0000\u0000>?\u0001\u0000\u0000\u0000?A\u0001\u0000"+
		"\u0000\u0000@>\u0001\u0000\u0000\u0000AB\u0003\n\u0005\u0000B\r\u0001"+
		"\u0000\u0000\u0000CD\u0005\u0005\u0000\u0000DE\u0005\b\u0000\u0000EF\u0005"+
		"\f\u0000\u0000F\u000f\u0001\u0000\u0000\u0000\u0005\u0014\u0019!/>";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}