// Generated from java-escape by ANTLR 4.11.1
package parser;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue"})
public class AssemblyLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.11.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, SPACE=3, DECIMAL_LITERAL=4, HEX_LITERAL=5, BINARY_LITERAL=6, 
		IDENTIFIER=7, NEWLINE=8, WS=9, OPCODE_SIMPLE=10, OPCODE_COMPOUND=11;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "T__1", "SPACE", "DECIMAL_LITERAL", "HEX_LITERAL", "BINARY_LITERAL", 
			"IDENTIFIER", "NEWLINE", "WS", "OPCODE_SIMPLE", "OPCODE_COMPOUND"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "':'", "'='", "' '"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, "SPACE", "DECIMAL_LITERAL", "HEX_LITERAL", "BINARY_LITERAL", 
			"IDENTIFIER", "NEWLINE", "WS", "OPCODE_SIMPLE", "OPCODE_COMPOUND"
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


	public AssemblyLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "Assembly.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\u0004\u0000\u000b\u009d\u0006\uffff\uffff\u0002\u0000\u0007\u0000\u0002"+
		"\u0001\u0007\u0001\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002"+
		"\u0004\u0007\u0004\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002"+
		"\u0007\u0007\u0007\u0002\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0001"+
		"\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0001\u0002\u0001\u0002\u0001"+
		"\u0003\u0001\u0003\u0003\u0003 \b\u0003\u0001\u0003\u0001\u0003\u0005"+
		"\u0003$\b\u0003\n\u0003\f\u0003\'\t\u0003\u0001\u0004\u0001\u0004\u0001"+
		"\u0004\u0001\u0004\u0001\u0004\u0005\u0004.\b\u0004\n\u0004\f\u00041\t"+
		"\u0004\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0005"+
		"\u00058\b\u0005\n\u0005\f\u0005;\t\u0005\u0001\u0006\u0001\u0006\u0005"+
		"\u0006?\b\u0006\n\u0006\f\u0006B\t\u0006\u0001\u0007\u0003\u0007E\b\u0007"+
		"\u0001\u0007\u0001\u0007\u0003\u0007I\b\u0007\u0001\b\u0001\b\u0001\t"+
		"\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001"+
		"\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001"+
		"\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001"+
		"\t\u0001\t\u0001\t\u0003\tk\b\t\u0001\n\u0001\n\u0001\n\u0001\n\u0001"+
		"\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001"+
		"\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001"+
		"\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001"+
		"\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001"+
		"\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0003\n\u009c\b\n\u0000"+
		"\u0000\u000b\u0001\u0001\u0003\u0002\u0005\u0003\u0007\u0004\t\u0005\u000b"+
		"\u0006\r\u0007\u000f\b\u0011\t\u0013\n\u0015\u000b\u0001\u0000\t\u0001"+
		"\u000009\u0002\u000009__\u0003\u000009AFaf\u0004\u000009AF__af\u0001\u0000"+
		"01\u0002\u000001__\u0003\u0000AZ__az\u0004\u000009AZ__az\u0002\u0000\t"+
		"\t  \u00b9\u0000\u0001\u0001\u0000\u0000\u0000\u0000\u0003\u0001\u0000"+
		"\u0000\u0000\u0000\u0005\u0001\u0000\u0000\u0000\u0000\u0007\u0001\u0000"+
		"\u0000\u0000\u0000\t\u0001\u0000\u0000\u0000\u0000\u000b\u0001\u0000\u0000"+
		"\u0000\u0000\r\u0001\u0000\u0000\u0000\u0000\u000f\u0001\u0000\u0000\u0000"+
		"\u0000\u0011\u0001\u0000\u0000\u0000\u0000\u0013\u0001\u0000\u0000\u0000"+
		"\u0000\u0015\u0001\u0000\u0000\u0000\u0001\u0017\u0001\u0000\u0000\u0000"+
		"\u0003\u0019\u0001\u0000\u0000\u0000\u0005\u001b\u0001\u0000\u0000\u0000"+
		"\u0007\u001f\u0001\u0000\u0000\u0000\t(\u0001\u0000\u0000\u0000\u000b"+
		"2\u0001\u0000\u0000\u0000\r<\u0001\u0000\u0000\u0000\u000fH\u0001\u0000"+
		"\u0000\u0000\u0011J\u0001\u0000\u0000\u0000\u0013j\u0001\u0000\u0000\u0000"+
		"\u0015\u009b\u0001\u0000\u0000\u0000\u0017\u0018\u0005:\u0000\u0000\u0018"+
		"\u0002\u0001\u0000\u0000\u0000\u0019\u001a\u0005=\u0000\u0000\u001a\u0004"+
		"\u0001\u0000\u0000\u0000\u001b\u001c\u0005 \u0000\u0000\u001c\u0006\u0001"+
		"\u0000\u0000\u0000\u001d\u001e\u00050\u0000\u0000\u001e \u0005d\u0000"+
		"\u0000\u001f\u001d\u0001\u0000\u0000\u0000\u001f \u0001\u0000\u0000\u0000"+
		" !\u0001\u0000\u0000\u0000!%\u0007\u0000\u0000\u0000\"$\u0007\u0001\u0000"+
		"\u0000#\"\u0001\u0000\u0000\u0000$\'\u0001\u0000\u0000\u0000%#\u0001\u0000"+
		"\u0000\u0000%&\u0001\u0000\u0000\u0000&\b\u0001\u0000\u0000\u0000\'%\u0001"+
		"\u0000\u0000\u0000()\u00050\u0000\u0000)*\u0005x\u0000\u0000*+\u0001\u0000"+
		"\u0000\u0000+/\u0007\u0002\u0000\u0000,.\u0007\u0003\u0000\u0000-,\u0001"+
		"\u0000\u0000\u0000.1\u0001\u0000\u0000\u0000/-\u0001\u0000\u0000\u0000"+
		"/0\u0001\u0000\u0000\u00000\n\u0001\u0000\u0000\u00001/\u0001\u0000\u0000"+
		"\u000023\u00050\u0000\u000034\u0005b\u0000\u000045\u0001\u0000\u0000\u0000"+
		"59\u0007\u0004\u0000\u000068\u0007\u0005\u0000\u000076\u0001\u0000\u0000"+
		"\u00008;\u0001\u0000\u0000\u000097\u0001\u0000\u0000\u00009:\u0001\u0000"+
		"\u0000\u0000:\f\u0001\u0000\u0000\u0000;9\u0001\u0000\u0000\u0000<@\u0007"+
		"\u0006\u0000\u0000=?\u0007\u0007\u0000\u0000>=\u0001\u0000\u0000\u0000"+
		"?B\u0001\u0000\u0000\u0000@>\u0001\u0000\u0000\u0000@A\u0001\u0000\u0000"+
		"\u0000A\u000e\u0001\u0000\u0000\u0000B@\u0001\u0000\u0000\u0000CE\u0005"+
		"\r\u0000\u0000DC\u0001\u0000\u0000\u0000DE\u0001\u0000\u0000\u0000EF\u0001"+
		"\u0000\u0000\u0000FI\u0005\n\u0000\u0000GI\u0005\r\u0000\u0000HD\u0001"+
		"\u0000\u0000\u0000HG\u0001\u0000\u0000\u0000I\u0010\u0001\u0000\u0000"+
		"\u0000JK\u0007\b\u0000\u0000K\u0012\u0001\u0000\u0000\u0000LM\u0005N\u0000"+
		"\u0000MN\u0005O\u0000\u0000Nk\u0005P\u0000\u0000OP\u0005A\u0000\u0000"+
		"PQ\u0005D\u0000\u0000QR\u0005D\u0000\u0000Rk\u0005A\u0000\u0000ST\u0005"+
		"A\u0000\u0000TU\u0005D\u0000\u0000UV\u0005D\u0000\u0000Vk\u0005B\u0000"+
		"\u0000WX\u0005S\u0000\u0000XY\u0005U\u0000\u0000YZ\u0005B\u0000\u0000"+
		"Zk\u0005A\u0000\u0000[\\\u0005S\u0000\u0000\\]\u0005U\u0000\u0000]^\u0005"+
		"B\u0000\u0000^k\u0005B\u0000\u0000_`\u0005H\u0000\u0000`a\u0005L\u0000"+
		"\u0000ak\u0005T\u0000\u0000bc\u0005X\u0000\u0000cd\u0005O\u0000\u0000"+
		"dk\u0005R\u0000\u0000ef\u0005A\u0000\u0000fg\u0005N\u0000\u0000gk\u0005"+
		"D\u0000\u0000hi\u0005O\u0000\u0000ik\u0005R\u0000\u0000jL\u0001\u0000"+
		"\u0000\u0000jO\u0001\u0000\u0000\u0000jS\u0001\u0000\u0000\u0000jW\u0001"+
		"\u0000\u0000\u0000j[\u0001\u0000\u0000\u0000j_\u0001\u0000\u0000\u0000"+
		"jb\u0001\u0000\u0000\u0000je\u0001\u0000\u0000\u0000jh\u0001\u0000\u0000"+
		"\u0000k\u0014\u0001\u0000\u0000\u0000lm\u0005A\u0000\u0000mn\u0005D\u0000"+
		"\u0000n\u009c\u0005D\u0000\u0000op\u0005A\u0000\u0000pq\u0005D\u0000\u0000"+
		"qr\u0005D\u0000\u0000r\u009c\u0005I\u0000\u0000st\u0005S\u0000\u0000t"+
		"u\u0005U\u0000\u0000u\u009c\u0005B\u0000\u0000vw\u0005S\u0000\u0000wx"+
		"\u0005U\u0000\u0000xy\u0005B\u0000\u0000y\u009c\u0005I\u0000\u0000z{\u0005"+
		"L\u0000\u0000{|\u0005D\u0000\u0000|\u009c\u0005A\u0000\u0000}~\u0005L"+
		"\u0000\u0000~\u007f\u0005D\u0000\u0000\u007f\u0080\u0005A\u0000\u0000"+
		"\u0080\u009c\u0005I\u0000\u0000\u0081\u0082\u0005L\u0000\u0000\u0082\u0083"+
		"\u0005D\u0000\u0000\u0083\u009c\u0005B\u0000\u0000\u0084\u0085\u0005L"+
		"\u0000\u0000\u0085\u0086\u0005D\u0000\u0000\u0086\u0087\u0005B\u0000\u0000"+
		"\u0087\u009c\u0005I\u0000\u0000\u0088\u0089\u0005S\u0000\u0000\u0089\u008a"+
		"\u0005T\u0000\u0000\u008a\u009c\u0005A\u0000\u0000\u008b\u008c\u0005S"+
		"\u0000\u0000\u008c\u008d\u0005T\u0000\u0000\u008d\u009c\u0005B\u0000\u0000"+
		"\u008e\u008f\u0005J\u0000\u0000\u008f\u0090\u0005M\u0000\u0000\u0090\u009c"+
		"\u0005P\u0000\u0000\u0091\u0092\u0005J\u0000\u0000\u0092\u009c\u0005C"+
		"\u0000\u0000\u0093\u0094\u0005J\u0000\u0000\u0094\u009c\u0005Z\u0000\u0000"+
		"\u0095\u0096\u0005J\u0000\u0000\u0096\u0097\u0005N\u0000\u0000\u0097\u009c"+
		"\u0005C\u0000\u0000\u0098\u0099\u0005J\u0000\u0000\u0099\u009a\u0005N"+
		"\u0000\u0000\u009a\u009c\u0005Z\u0000\u0000\u009bl\u0001\u0000\u0000\u0000"+
		"\u009bo\u0001\u0000\u0000\u0000\u009bs\u0001\u0000\u0000\u0000\u009bv"+
		"\u0001\u0000\u0000\u0000\u009bz\u0001\u0000\u0000\u0000\u009b}\u0001\u0000"+
		"\u0000\u0000\u009b\u0081\u0001\u0000\u0000\u0000\u009b\u0084\u0001\u0000"+
		"\u0000\u0000\u009b\u0088\u0001\u0000\u0000\u0000\u009b\u008b\u0001\u0000"+
		"\u0000\u0000\u009b\u008e\u0001\u0000\u0000\u0000\u009b\u0091\u0001\u0000"+
		"\u0000\u0000\u009b\u0093\u0001\u0000\u0000\u0000\u009b\u0095\u0001\u0000"+
		"\u0000\u0000\u009b\u0098\u0001\u0000\u0000\u0000\u009c\u0016\u0001\u0000"+
		"\u0000\u0000\n\u0000\u001f%/9@DHj\u009b\u0000";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}