// Generated from src/parser/PLp1.g4 by ANTLR 4.7.2

package parser;

import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class PLp1Lexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.7.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		FUNCTION=1, IF=2, THEN=3, ELSE=4, ENDIF=5, LAMBDA=6, LET=7, SWITCH=8, 
		CASE=9, DEFAULT=10, TRUE=11, FALSE=12, NULL=13, INVOKE=14, EQ=15, NE=16, 
		LE=17, GE=18, MULT=19, DIV=20, ADD=21, SUB=22, LT=23, GT=24, NOT=25, OR=26, 
		AND=27, ASSIGN=28, LP=29, RP=30, LB=31, RB=32, LK=33, RK=34, COMMA=35, 
		COLON=36, ID=37, INTNUM=38, FLOATNUM=39, STRING=40, NEWLINE=41, WS=42;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"FUNCTION", "IF", "THEN", "ELSE", "ENDIF", "LAMBDA", "LET", "SWITCH", 
			"CASE", "DEFAULT", "TRUE", "FALSE", "NULL", "INVOKE", "EQ", "NE", "LE", 
			"GE", "MULT", "DIV", "ADD", "SUB", "LT", "GT", "NOT", "OR", "AND", "ASSIGN", 
			"LP", "RP", "LB", "RB", "LK", "RK", "COMMA", "COLON", "ALPHA", "DIGIT", 
			"ID", "POSITIVE", "INTNUM", "EXPONENT", "FLOATNUM", "STRING", "NEWLINE", 
			"WS"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'function'", "'if'", "'then'", "'else'", "'endif'", "'lambda'", 
			"'let'", "'switch'", "'case'", "'default'", "'true'", "'false'", "'null'", 
			"'->'", "'=='", "'!='", "'<='", "'>='", "'*'", "'/'", "'+'", "'-'", "'<'", 
			"'>'", "'!'", "'|'", "'&'", "'='", "'('", "')'", "'{'", "'}'", "'['", 
			"']'", "','", "':'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "FUNCTION", "IF", "THEN", "ELSE", "ENDIF", "LAMBDA", "LET", "SWITCH", 
			"CASE", "DEFAULT", "TRUE", "FALSE", "NULL", "INVOKE", "EQ", "NE", "LE", 
			"GE", "MULT", "DIV", "ADD", "SUB", "LT", "GT", "NOT", "OR", "AND", "ASSIGN", 
			"LP", "RP", "LB", "RB", "LK", "RK", "COMMA", "COLON", "ID", "INTNUM", 
			"FLOATNUM", "STRING", "NEWLINE", "WS"
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


	public PLp1Lexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "PLp1.g4"; }

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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2,\u011d\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\4.\t.\4/\t/\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\3\3\3\3\3"+
		"\3\4\3\4\3\4\3\4\3\4\3\5\3\5\3\5\3\5\3\5\3\6\3\6\3\6\3\6\3\6\3\6\3\7\3"+
		"\7\3\7\3\7\3\7\3\7\3\7\3\b\3\b\3\b\3\b\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\n"+
		"\3\n\3\n\3\n\3\n\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\f\3\f\3\f\3"+
		"\f\3\f\3\r\3\r\3\r\3\r\3\r\3\r\3\16\3\16\3\16\3\16\3\16\3\17\3\17\3\17"+
		"\3\20\3\20\3\20\3\21\3\21\3\21\3\22\3\22\3\22\3\23\3\23\3\23\3\24\3\24"+
		"\3\25\3\25\3\26\3\26\3\27\3\27\3\30\3\30\3\31\3\31\3\32\3\32\3\33\3\33"+
		"\3\34\3\34\3\35\3\35\3\36\3\36\3\37\3\37\3 \3 \3!\3!\3\"\3\"\3#\3#\3$"+
		"\3$\3%\3%\3&\3&\3\'\3\'\3(\3(\3(\7(\u00e5\n(\f(\16(\u00e8\13(\3)\3)\3"+
		"*\3*\7*\u00ee\n*\f*\16*\u00f1\13*\3*\5*\u00f4\n*\3+\3+\5+\u00f8\n+\3+"+
		"\6+\u00fb\n+\r+\16+\u00fc\3,\3,\3,\6,\u0102\n,\r,\16,\u0103\3,\5,\u0107"+
		"\n,\3-\3-\7-\u010b\n-\f-\16-\u010e\13-\3-\3-\3.\5.\u0113\n.\3.\3.\3/\6"+
		"/\u0118\n/\r/\16/\u0119\3/\3/\2\2\60\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21"+
		"\n\23\13\25\f\27\r\31\16\33\17\35\20\37\21!\22#\23%\24\'\25)\26+\27-\30"+
		"/\31\61\32\63\33\65\34\67\359\36;\37= ?!A\"C#E$G%I&K\2M\2O\'Q\2S(U\2W"+
		")Y*[+],\3\2\t\4\2C\\c|\3\2\62;\3\2\63;\4\2GGgg\4\2--//\5\2\f\f\17\17)"+
		")\4\2\13\13\"\"\2\u0123\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2"+
		"\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25"+
		"\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2"+
		"\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2"+
		"\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2\2\2\65\3\2\2\2\2\67\3"+
		"\2\2\2\29\3\2\2\2\2;\3\2\2\2\2=\3\2\2\2\2?\3\2\2\2\2A\3\2\2\2\2C\3\2\2"+
		"\2\2E\3\2\2\2\2G\3\2\2\2\2I\3\2\2\2\2O\3\2\2\2\2S\3\2\2\2\2W\3\2\2\2\2"+
		"Y\3\2\2\2\2[\3\2\2\2\2]\3\2\2\2\3_\3\2\2\2\5h\3\2\2\2\7k\3\2\2\2\tp\3"+
		"\2\2\2\13u\3\2\2\2\r{\3\2\2\2\17\u0082\3\2\2\2\21\u0086\3\2\2\2\23\u008d"+
		"\3\2\2\2\25\u0092\3\2\2\2\27\u009a\3\2\2\2\31\u009f\3\2\2\2\33\u00a5\3"+
		"\2\2\2\35\u00aa\3\2\2\2\37\u00ad\3\2\2\2!\u00b0\3\2\2\2#\u00b3\3\2\2\2"+
		"%\u00b6\3\2\2\2\'\u00b9\3\2\2\2)\u00bb\3\2\2\2+\u00bd\3\2\2\2-\u00bf\3"+
		"\2\2\2/\u00c1\3\2\2\2\61\u00c3\3\2\2\2\63\u00c5\3\2\2\2\65\u00c7\3\2\2"+
		"\2\67\u00c9\3\2\2\29\u00cb\3\2\2\2;\u00cd\3\2\2\2=\u00cf\3\2\2\2?\u00d1"+
		"\3\2\2\2A\u00d3\3\2\2\2C\u00d5\3\2\2\2E\u00d7\3\2\2\2G\u00d9\3\2\2\2I"+
		"\u00db\3\2\2\2K\u00dd\3\2\2\2M\u00df\3\2\2\2O\u00e1\3\2\2\2Q\u00e9\3\2"+
		"\2\2S\u00f3\3\2\2\2U\u00f5\3\2\2\2W\u00fe\3\2\2\2Y\u0108\3\2\2\2[\u0112"+
		"\3\2\2\2]\u0117\3\2\2\2_`\7h\2\2`a\7w\2\2ab\7p\2\2bc\7e\2\2cd\7v\2\2d"+
		"e\7k\2\2ef\7q\2\2fg\7p\2\2g\4\3\2\2\2hi\7k\2\2ij\7h\2\2j\6\3\2\2\2kl\7"+
		"v\2\2lm\7j\2\2mn\7g\2\2no\7p\2\2o\b\3\2\2\2pq\7g\2\2qr\7n\2\2rs\7u\2\2"+
		"st\7g\2\2t\n\3\2\2\2uv\7g\2\2vw\7p\2\2wx\7f\2\2xy\7k\2\2yz\7h\2\2z\f\3"+
		"\2\2\2{|\7n\2\2|}\7c\2\2}~\7o\2\2~\177\7d\2\2\177\u0080\7f\2\2\u0080\u0081"+
		"\7c\2\2\u0081\16\3\2\2\2\u0082\u0083\7n\2\2\u0083\u0084\7g\2\2\u0084\u0085"+
		"\7v\2\2\u0085\20\3\2\2\2\u0086\u0087\7u\2\2\u0087\u0088\7y\2\2\u0088\u0089"+
		"\7k\2\2\u0089\u008a\7v\2\2\u008a\u008b\7e\2\2\u008b\u008c\7j\2\2\u008c"+
		"\22\3\2\2\2\u008d\u008e\7e\2\2\u008e\u008f\7c\2\2\u008f\u0090\7u\2\2\u0090"+
		"\u0091\7g\2\2\u0091\24\3\2\2\2\u0092\u0093\7f\2\2\u0093\u0094\7g\2\2\u0094"+
		"\u0095\7h\2\2\u0095\u0096\7c\2\2\u0096\u0097\7w\2\2\u0097\u0098\7n\2\2"+
		"\u0098\u0099\7v\2\2\u0099\26\3\2\2\2\u009a\u009b\7v\2\2\u009b\u009c\7"+
		"t\2\2\u009c\u009d\7w\2\2\u009d\u009e\7g\2\2\u009e\30\3\2\2\2\u009f\u00a0"+
		"\7h\2\2\u00a0\u00a1\7c\2\2\u00a1\u00a2\7n\2\2\u00a2\u00a3\7u\2\2\u00a3"+
		"\u00a4\7g\2\2\u00a4\32\3\2\2\2\u00a5\u00a6\7p\2\2\u00a6\u00a7\7w\2\2\u00a7"+
		"\u00a8\7n\2\2\u00a8\u00a9\7n\2\2\u00a9\34\3\2\2\2\u00aa\u00ab\7/\2\2\u00ab"+
		"\u00ac\7@\2\2\u00ac\36\3\2\2\2\u00ad\u00ae\7?\2\2\u00ae\u00af\7?\2\2\u00af"+
		" \3\2\2\2\u00b0\u00b1\7#\2\2\u00b1\u00b2\7?\2\2\u00b2\"\3\2\2\2\u00b3"+
		"\u00b4\7>\2\2\u00b4\u00b5\7?\2\2\u00b5$\3\2\2\2\u00b6\u00b7\7@\2\2\u00b7"+
		"\u00b8\7?\2\2\u00b8&\3\2\2\2\u00b9\u00ba\7,\2\2\u00ba(\3\2\2\2\u00bb\u00bc"+
		"\7\61\2\2\u00bc*\3\2\2\2\u00bd\u00be\7-\2\2\u00be,\3\2\2\2\u00bf\u00c0"+
		"\7/\2\2\u00c0.\3\2\2\2\u00c1\u00c2\7>\2\2\u00c2\60\3\2\2\2\u00c3\u00c4"+
		"\7@\2\2\u00c4\62\3\2\2\2\u00c5\u00c6\7#\2\2\u00c6\64\3\2\2\2\u00c7\u00c8"+
		"\7~\2\2\u00c8\66\3\2\2\2\u00c9\u00ca\7(\2\2\u00ca8\3\2\2\2\u00cb\u00cc"+
		"\7?\2\2\u00cc:\3\2\2\2\u00cd\u00ce\7*\2\2\u00ce<\3\2\2\2\u00cf\u00d0\7"+
		"+\2\2\u00d0>\3\2\2\2\u00d1\u00d2\7}\2\2\u00d2@\3\2\2\2\u00d3\u00d4\7\177"+
		"\2\2\u00d4B\3\2\2\2\u00d5\u00d6\7]\2\2\u00d6D\3\2\2\2\u00d7\u00d8\7_\2"+
		"\2\u00d8F\3\2\2\2\u00d9\u00da\7.\2\2\u00daH\3\2\2\2\u00db\u00dc\7<\2\2"+
		"\u00dcJ\3\2\2\2\u00dd\u00de\t\2\2\2\u00deL\3\2\2\2\u00df\u00e0\t\3\2\2"+
		"\u00e0N\3\2\2\2\u00e1\u00e6\5K&\2\u00e2\u00e5\5K&\2\u00e3\u00e5\5M\'\2"+
		"\u00e4\u00e2\3\2\2\2\u00e4\u00e3\3\2\2\2\u00e5\u00e8\3\2\2\2\u00e6\u00e4"+
		"\3\2\2\2\u00e6\u00e7\3\2\2\2\u00e7P\3\2\2\2\u00e8\u00e6\3\2\2\2\u00e9"+
		"\u00ea\t\4\2\2\u00eaR\3\2\2\2\u00eb\u00ef\5Q)\2\u00ec\u00ee\5M\'\2\u00ed"+
		"\u00ec\3\2\2\2\u00ee\u00f1\3\2\2\2\u00ef\u00ed\3\2\2\2\u00ef\u00f0\3\2"+
		"\2\2\u00f0\u00f4\3\2\2\2\u00f1\u00ef\3\2\2\2\u00f2\u00f4\7\62\2\2\u00f3"+
		"\u00eb\3\2\2\2\u00f3\u00f2\3\2\2\2\u00f4T\3\2\2\2\u00f5\u00f7\t\5\2\2"+
		"\u00f6\u00f8\t\6\2\2\u00f7\u00f6\3\2\2\2\u00f7\u00f8\3\2\2\2\u00f8\u00fa"+
		"\3\2\2\2\u00f9\u00fb\5M\'\2\u00fa\u00f9\3\2\2\2\u00fb\u00fc\3\2\2\2\u00fc"+
		"\u00fa\3\2\2\2\u00fc\u00fd\3\2\2\2\u00fdV\3\2\2\2\u00fe\u00ff\5S*\2\u00ff"+
		"\u0101\7\60\2\2\u0100\u0102\5M\'\2\u0101\u0100\3\2\2\2\u0102\u0103\3\2"+
		"\2\2\u0103\u0101\3\2\2\2\u0103\u0104\3\2\2\2\u0104\u0106\3\2\2\2\u0105"+
		"\u0107\5U+\2\u0106\u0105\3\2\2\2\u0106\u0107\3\2\2\2\u0107X\3\2\2\2\u0108"+
		"\u010c\7)\2\2\u0109\u010b\n\7\2\2\u010a\u0109\3\2\2\2\u010b\u010e\3\2"+
		"\2\2\u010c\u010a\3\2\2\2\u010c\u010d\3\2\2\2\u010d\u010f\3\2\2\2\u010e"+
		"\u010c\3\2\2\2\u010f\u0110\7)\2\2\u0110Z\3\2\2\2\u0111\u0113\7\17\2\2"+
		"\u0112\u0111\3\2\2\2\u0112\u0113\3\2\2\2\u0113\u0114\3\2\2\2\u0114\u0115"+
		"\7\f\2\2\u0115\\\3\2\2\2\u0116\u0118\t\b\2\2\u0117\u0116\3\2\2\2\u0118"+
		"\u0119\3\2\2\2\u0119\u0117\3\2\2\2\u0119\u011a\3\2\2\2\u011a\u011b\3\2"+
		"\2\2\u011b\u011c\b/\2\2\u011c^\3\2\2\2\16\2\u00e4\u00e6\u00ef\u00f3\u00f7"+
		"\u00fc\u0103\u0106\u010c\u0112\u0119\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}