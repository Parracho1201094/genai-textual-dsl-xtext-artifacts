package org.example.lts.parser.antlr.internal;

import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.common.util.Enumerator;
import org.eclipse.xtext.parser.antlr.AbstractInternalAntlrParser;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.parser.antlr.AntlrDatatypeRuleToken;
import org.example.lts.services.LtsGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalLtsParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_STRING", "RULE_INT", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'process'", "'{'", "'steps'", "'}'", "'input'", "'from'", "'table'", "'csv'", "'separator'", "'header'", "':'", "'required'", "'format'", "';'", "'output'", "'to'", "'log'", "'levels'", "','", "'external'", "'function'", "'('", "')'", "'implemented'", "'by'", "'load'", "'create'", "'empty'", "'append'", "'rows'", "'map'", "'filter'", "'where'", "'sort'", "'group'", "'into'", "'aggregate'", "'compute'", "'join'", "'with'", "'on'", "'select'", "'insert'", "'column'", "'.'", "'='", "'remove'", "'columns'", "'calculate'", "'lookup'", "'match'", "'return'", "'default'", "'duplicates'", "'save'", "'or'", "'and'", "'!='", "'<'", "'<='", "'>'", "'>='", "'+'", "'-'", "'&'", "'*'", "'/'", "'not'", "'null'", "'true'", "'false'", "'warnings'", "'errors'", "'ascending'", "'descending'", "'inner'", "'left'", "'string'", "'integer'", "'decimal'", "'boolean'", "'date'", "'datetime'"
    };
    public static final int T__50=50;
    public static final int T__59=59;
    public static final int T__55=55;
    public static final int T__56=56;
    public static final int T__57=57;
    public static final int T__58=58;
    public static final int T__51=51;
    public static final int T__52=52;
    public static final int T__53=53;
    public static final int T__54=54;
    public static final int T__60=60;
    public static final int T__61=61;
    public static final int RULE_ID=4;
    public static final int RULE_INT=6;
    public static final int T__66=66;
    public static final int RULE_ML_COMMENT=7;
    public static final int T__67=67;
    public static final int T__68=68;
    public static final int T__69=69;
    public static final int T__62=62;
    public static final int T__63=63;
    public static final int T__64=64;
    public static final int T__65=65;
    public static final int T__37=37;
    public static final int T__38=38;
    public static final int T__39=39;
    public static final int T__33=33;
    public static final int T__34=34;
    public static final int T__35=35;
    public static final int T__36=36;
    public static final int T__30=30;
    public static final int T__31=31;
    public static final int T__32=32;
    public static final int T__48=48;
    public static final int T__49=49;
    public static final int T__44=44;
    public static final int T__45=45;
    public static final int T__46=46;
    public static final int T__47=47;
    public static final int T__40=40;
    public static final int T__41=41;
    public static final int T__42=42;
    public static final int T__43=43;
    public static final int T__91=91;
    public static final int T__92=92;
    public static final int T__93=93;
    public static final int T__90=90;
    public static final int T__19=19;
    public static final int T__15=15;
    public static final int T__16=16;
    public static final int T__17=17;
    public static final int T__18=18;
    public static final int T__11=11;
    public static final int T__12=12;
    public static final int T__13=13;
    public static final int T__14=14;
    public static final int T__26=26;
    public static final int T__27=27;
    public static final int T__28=28;
    public static final int T__29=29;
    public static final int T__22=22;
    public static final int T__23=23;
    public static final int T__24=24;
    public static final int T__25=25;
    public static final int T__20=20;
    public static final int T__21=21;
    public static final int T__70=70;
    public static final int T__71=71;
    public static final int T__72=72;
    public static final int RULE_STRING=5;
    public static final int RULE_SL_COMMENT=8;
    public static final int T__77=77;
    public static final int T__78=78;
    public static final int T__79=79;
    public static final int T__73=73;
    public static final int EOF=-1;
    public static final int T__74=74;
    public static final int T__75=75;
    public static final int T__76=76;
    public static final int T__80=80;
    public static final int T__81=81;
    public static final int T__82=82;
    public static final int T__83=83;
    public static final int RULE_WS=9;
    public static final int RULE_ANY_OTHER=10;
    public static final int T__88=88;
    public static final int T__89=89;
    public static final int T__84=84;
    public static final int T__85=85;
    public static final int T__86=86;
    public static final int T__87=87;

    // delegates
    // delegators


        public InternalLtsParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalLtsParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalLtsParser.tokenNames; }
    public String getGrammarFileName() { return "InternalLts.g"; }



     	private LtsGrammarAccess grammarAccess;

        public InternalLtsParser(TokenStream input, LtsGrammarAccess grammarAccess) {
            this(input);
            this.grammarAccess = grammarAccess;
            registerRules(grammarAccess.getGrammar());
        }

        @Override
        protected String getFirstRuleName() {
        	return "Model";
       	}

       	@Override
       	protected LtsGrammarAccess getGrammarAccess() {
       		return grammarAccess;
       	}




    // $ANTLR start "entryRuleModel"
    // InternalLts.g:63:1: entryRuleModel returns [EObject current=null] : iv_ruleModel= ruleModel EOF ;
    public final EObject entryRuleModel() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleModel = null;


        try {
            // InternalLts.g:63:46: (iv_ruleModel= ruleModel EOF )
            // InternalLts.g:64:2: iv_ruleModel= ruleModel EOF
            {
             newCompositeNode(grammarAccess.getModelRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleModel=ruleModel();

            state._fsp--;

             current =iv_ruleModel; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleModel"


    // $ANTLR start "ruleModel"
    // InternalLts.g:70:1: ruleModel returns [EObject current=null] : ( (lv_process_0_0= ruleProcess ) ) ;
    public final EObject ruleModel() throws RecognitionException {
        EObject current = null;

        EObject lv_process_0_0 = null;



        	enterRule();

        try {
            // InternalLts.g:76:2: ( ( (lv_process_0_0= ruleProcess ) ) )
            // InternalLts.g:77:2: ( (lv_process_0_0= ruleProcess ) )
            {
            // InternalLts.g:77:2: ( (lv_process_0_0= ruleProcess ) )
            // InternalLts.g:78:3: (lv_process_0_0= ruleProcess )
            {
            // InternalLts.g:78:3: (lv_process_0_0= ruleProcess )
            // InternalLts.g:79:4: lv_process_0_0= ruleProcess
            {

            				newCompositeNode(grammarAccess.getModelAccess().getProcessProcessParserRuleCall_0());
            			
            pushFollow(FOLLOW_2);
            lv_process_0_0=ruleProcess();

            state._fsp--;


            				if (current==null) {
            					current = createModelElementForParent(grammarAccess.getModelRule());
            				}
            				set(
            					current,
            					"process",
            					lv_process_0_0,
            					"org.example.lts.Lts.Process");
            				afterParserOrEnumRuleCall();
            			

            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleModel"


    // $ANTLR start "entryRuleProcess"
    // InternalLts.g:99:1: entryRuleProcess returns [EObject current=null] : iv_ruleProcess= ruleProcess EOF ;
    public final EObject entryRuleProcess() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleProcess = null;


        try {
            // InternalLts.g:99:48: (iv_ruleProcess= ruleProcess EOF )
            // InternalLts.g:100:2: iv_ruleProcess= ruleProcess EOF
            {
             newCompositeNode(grammarAccess.getProcessRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleProcess=ruleProcess();

            state._fsp--;

             current =iv_ruleProcess; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleProcess"


    // $ANTLR start "ruleProcess"
    // InternalLts.g:106:1: ruleProcess returns [EObject current=null] : (otherlv_0= 'process' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_declarations_3_0= ruleDeclaration ) )* otherlv_4= 'steps' otherlv_5= '{' ( (lv_steps_6_0= ruleOperation ) )* otherlv_7= '}' otherlv_8= '}' ) ;
    public final EObject ruleProcess() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        Token otherlv_8=null;
        EObject lv_declarations_3_0 = null;

        EObject lv_steps_6_0 = null;



        	enterRule();

        try {
            // InternalLts.g:112:2: ( (otherlv_0= 'process' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_declarations_3_0= ruleDeclaration ) )* otherlv_4= 'steps' otherlv_5= '{' ( (lv_steps_6_0= ruleOperation ) )* otherlv_7= '}' otherlv_8= '}' ) )
            // InternalLts.g:113:2: (otherlv_0= 'process' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_declarations_3_0= ruleDeclaration ) )* otherlv_4= 'steps' otherlv_5= '{' ( (lv_steps_6_0= ruleOperation ) )* otherlv_7= '}' otherlv_8= '}' )
            {
            // InternalLts.g:113:2: (otherlv_0= 'process' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_declarations_3_0= ruleDeclaration ) )* otherlv_4= 'steps' otherlv_5= '{' ( (lv_steps_6_0= ruleOperation ) )* otherlv_7= '}' otherlv_8= '}' )
            // InternalLts.g:114:3: otherlv_0= 'process' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_declarations_3_0= ruleDeclaration ) )* otherlv_4= 'steps' otherlv_5= '{' ( (lv_steps_6_0= ruleOperation ) )* otherlv_7= '}' otherlv_8= '}'
            {
            otherlv_0=(Token)match(input,11,FOLLOW_3); 

            			newLeafNode(otherlv_0, grammarAccess.getProcessAccess().getProcessKeyword_0());
            		
            // InternalLts.g:118:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalLts.g:119:4: (lv_name_1_0= RULE_ID )
            {
            // InternalLts.g:119:4: (lv_name_1_0= RULE_ID )
            // InternalLts.g:120:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_4); 

            					newLeafNode(lv_name_1_0, grammarAccess.getProcessAccess().getNameIDTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getProcessRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_1_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }

            otherlv_2=(Token)match(input,12,FOLLOW_5); 

            			newLeafNode(otherlv_2, grammarAccess.getProcessAccess().getLeftCurlyBracketKeyword_2());
            		
            // InternalLts.g:140:3: ( (lv_declarations_3_0= ruleDeclaration ) )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==15||LA1_0==17||LA1_0==25||LA1_0==27||LA1_0==30) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // InternalLts.g:141:4: (lv_declarations_3_0= ruleDeclaration )
            	    {
            	    // InternalLts.g:141:4: (lv_declarations_3_0= ruleDeclaration )
            	    // InternalLts.g:142:5: lv_declarations_3_0= ruleDeclaration
            	    {

            	    					newCompositeNode(grammarAccess.getProcessAccess().getDeclarationsDeclarationParserRuleCall_3_0());
            	    				
            	    pushFollow(FOLLOW_5);
            	    lv_declarations_3_0=ruleDeclaration();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getProcessRule());
            	    					}
            	    					add(
            	    						current,
            	    						"declarations",
            	    						lv_declarations_3_0,
            	    						"org.example.lts.Lts.Declaration");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);

            otherlv_4=(Token)match(input,13,FOLLOW_4); 

            			newLeafNode(otherlv_4, grammarAccess.getProcessAccess().getStepsKeyword_4());
            		
            otherlv_5=(Token)match(input,12,FOLLOW_6); 

            			newLeafNode(otherlv_5, grammarAccess.getProcessAccess().getLeftCurlyBracketKeyword_5());
            		
            // InternalLts.g:167:3: ( (lv_steps_6_0= ruleOperation ) )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( ((LA2_0>=36 && LA2_0<=37)||LA2_0==39||LA2_0==42||(LA2_0>=44 && LA2_0<=45)||LA2_0==47||LA2_0==49||LA2_0==53||LA2_0==57||(LA2_0>=59 && LA2_0<=60)||LA2_0==65) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // InternalLts.g:168:4: (lv_steps_6_0= ruleOperation )
            	    {
            	    // InternalLts.g:168:4: (lv_steps_6_0= ruleOperation )
            	    // InternalLts.g:169:5: lv_steps_6_0= ruleOperation
            	    {

            	    					newCompositeNode(grammarAccess.getProcessAccess().getStepsOperationParserRuleCall_6_0());
            	    				
            	    pushFollow(FOLLOW_6);
            	    lv_steps_6_0=ruleOperation();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getProcessRule());
            	    					}
            	    					add(
            	    						current,
            	    						"steps",
            	    						lv_steps_6_0,
            	    						"org.example.lts.Lts.Operation");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop2;
                }
            } while (true);

            otherlv_7=(Token)match(input,14,FOLLOW_7); 

            			newLeafNode(otherlv_7, grammarAccess.getProcessAccess().getRightCurlyBracketKeyword_7());
            		
            otherlv_8=(Token)match(input,14,FOLLOW_2); 

            			newLeafNode(otherlv_8, grammarAccess.getProcessAccess().getRightCurlyBracketKeyword_8());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleProcess"


    // $ANTLR start "entryRuleDeclaration"
    // InternalLts.g:198:1: entryRuleDeclaration returns [EObject current=null] : iv_ruleDeclaration= ruleDeclaration EOF ;
    public final EObject entryRuleDeclaration() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDeclaration = null;


        try {
            // InternalLts.g:198:52: (iv_ruleDeclaration= ruleDeclaration EOF )
            // InternalLts.g:199:2: iv_ruleDeclaration= ruleDeclaration EOF
            {
             newCompositeNode(grammarAccess.getDeclarationRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleDeclaration=ruleDeclaration();

            state._fsp--;

             current =iv_ruleDeclaration; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleDeclaration"


    // $ANTLR start "ruleDeclaration"
    // InternalLts.g:205:1: ruleDeclaration returns [EObject current=null] : (this_TableDeclaration_0= ruleTableDeclaration | this_CsvSink_1= ruleCsvSink | this_LogSink_2= ruleLogSink | this_ExternalFunction_3= ruleExternalFunction ) ;
    public final EObject ruleDeclaration() throws RecognitionException {
        EObject current = null;

        EObject this_TableDeclaration_0 = null;

        EObject this_CsvSink_1 = null;

        EObject this_LogSink_2 = null;

        EObject this_ExternalFunction_3 = null;



        	enterRule();

        try {
            // InternalLts.g:211:2: ( (this_TableDeclaration_0= ruleTableDeclaration | this_CsvSink_1= ruleCsvSink | this_LogSink_2= ruleLogSink | this_ExternalFunction_3= ruleExternalFunction ) )
            // InternalLts.g:212:2: (this_TableDeclaration_0= ruleTableDeclaration | this_CsvSink_1= ruleCsvSink | this_LogSink_2= ruleLogSink | this_ExternalFunction_3= ruleExternalFunction )
            {
            // InternalLts.g:212:2: (this_TableDeclaration_0= ruleTableDeclaration | this_CsvSink_1= ruleCsvSink | this_LogSink_2= ruleLogSink | this_ExternalFunction_3= ruleExternalFunction )
            int alt3=4;
            switch ( input.LA(1) ) {
            case 15:
            case 17:
                {
                alt3=1;
                }
                break;
            case 25:
                {
                alt3=2;
                }
                break;
            case 27:
                {
                alt3=3;
                }
                break;
            case 30:
                {
                alt3=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 3, 0, input);

                throw nvae;
            }

            switch (alt3) {
                case 1 :
                    // InternalLts.g:213:3: this_TableDeclaration_0= ruleTableDeclaration
                    {

                    			newCompositeNode(grammarAccess.getDeclarationAccess().getTableDeclarationParserRuleCall_0());
                    		
                    pushFollow(FOLLOW_2);
                    this_TableDeclaration_0=ruleTableDeclaration();

                    state._fsp--;


                    			current = this_TableDeclaration_0;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 2 :
                    // InternalLts.g:222:3: this_CsvSink_1= ruleCsvSink
                    {

                    			newCompositeNode(grammarAccess.getDeclarationAccess().getCsvSinkParserRuleCall_1());
                    		
                    pushFollow(FOLLOW_2);
                    this_CsvSink_1=ruleCsvSink();

                    state._fsp--;


                    			current = this_CsvSink_1;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 3 :
                    // InternalLts.g:231:3: this_LogSink_2= ruleLogSink
                    {

                    			newCompositeNode(grammarAccess.getDeclarationAccess().getLogSinkParserRuleCall_2());
                    		
                    pushFollow(FOLLOW_2);
                    this_LogSink_2=ruleLogSink();

                    state._fsp--;


                    			current = this_LogSink_2;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 4 :
                    // InternalLts.g:240:3: this_ExternalFunction_3= ruleExternalFunction
                    {

                    			newCompositeNode(grammarAccess.getDeclarationAccess().getExternalFunctionParserRuleCall_3());
                    		
                    pushFollow(FOLLOW_2);
                    this_ExternalFunction_3=ruleExternalFunction();

                    state._fsp--;


                    			current = this_ExternalFunction_3;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleDeclaration"


    // $ANTLR start "entryRuleTableDeclaration"
    // InternalLts.g:252:1: entryRuleTableDeclaration returns [EObject current=null] : iv_ruleTableDeclaration= ruleTableDeclaration EOF ;
    public final EObject entryRuleTableDeclaration() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTableDeclaration = null;


        try {
            // InternalLts.g:252:57: (iv_ruleTableDeclaration= ruleTableDeclaration EOF )
            // InternalLts.g:253:2: iv_ruleTableDeclaration= ruleTableDeclaration EOF
            {
             newCompositeNode(grammarAccess.getTableDeclarationRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleTableDeclaration=ruleTableDeclaration();

            state._fsp--;

             current =iv_ruleTableDeclaration; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleTableDeclaration"


    // $ANTLR start "ruleTableDeclaration"
    // InternalLts.g:259:1: ruleTableDeclaration returns [EObject current=null] : ( ( (otherlv_0= 'input' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= 'from' ( (lv_source_3_0= ruleCsvSource ) ) ) | (otherlv_4= 'table' ( (lv_name_5_0= RULE_ID ) ) ) ) otherlv_6= '{' ( (lv_columns_7_0= ruleColumn ) )* otherlv_8= '}' ) ;
    public final EObject ruleTableDeclaration() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token lv_name_5_0=null;
        Token otherlv_6=null;
        Token otherlv_8=null;
        EObject lv_source_3_0 = null;

        EObject lv_columns_7_0 = null;



        	enterRule();

        try {
            // InternalLts.g:265:2: ( ( ( (otherlv_0= 'input' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= 'from' ( (lv_source_3_0= ruleCsvSource ) ) ) | (otherlv_4= 'table' ( (lv_name_5_0= RULE_ID ) ) ) ) otherlv_6= '{' ( (lv_columns_7_0= ruleColumn ) )* otherlv_8= '}' ) )
            // InternalLts.g:266:2: ( ( (otherlv_0= 'input' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= 'from' ( (lv_source_3_0= ruleCsvSource ) ) ) | (otherlv_4= 'table' ( (lv_name_5_0= RULE_ID ) ) ) ) otherlv_6= '{' ( (lv_columns_7_0= ruleColumn ) )* otherlv_8= '}' )
            {
            // InternalLts.g:266:2: ( ( (otherlv_0= 'input' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= 'from' ( (lv_source_3_0= ruleCsvSource ) ) ) | (otherlv_4= 'table' ( (lv_name_5_0= RULE_ID ) ) ) ) otherlv_6= '{' ( (lv_columns_7_0= ruleColumn ) )* otherlv_8= '}' )
            // InternalLts.g:267:3: ( (otherlv_0= 'input' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= 'from' ( (lv_source_3_0= ruleCsvSource ) ) ) | (otherlv_4= 'table' ( (lv_name_5_0= RULE_ID ) ) ) ) otherlv_6= '{' ( (lv_columns_7_0= ruleColumn ) )* otherlv_8= '}'
            {
            // InternalLts.g:267:3: ( (otherlv_0= 'input' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= 'from' ( (lv_source_3_0= ruleCsvSource ) ) ) | (otherlv_4= 'table' ( (lv_name_5_0= RULE_ID ) ) ) )
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==15) ) {
                alt4=1;
            }
            else if ( (LA4_0==17) ) {
                alt4=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 4, 0, input);

                throw nvae;
            }
            switch (alt4) {
                case 1 :
                    // InternalLts.g:268:4: (otherlv_0= 'input' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= 'from' ( (lv_source_3_0= ruleCsvSource ) ) )
                    {
                    // InternalLts.g:268:4: (otherlv_0= 'input' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= 'from' ( (lv_source_3_0= ruleCsvSource ) ) )
                    // InternalLts.g:269:5: otherlv_0= 'input' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= 'from' ( (lv_source_3_0= ruleCsvSource ) )
                    {
                    otherlv_0=(Token)match(input,15,FOLLOW_3); 

                    					newLeafNode(otherlv_0, grammarAccess.getTableDeclarationAccess().getInputKeyword_0_0_0());
                    				
                    // InternalLts.g:273:5: ( (lv_name_1_0= RULE_ID ) )
                    // InternalLts.g:274:6: (lv_name_1_0= RULE_ID )
                    {
                    // InternalLts.g:274:6: (lv_name_1_0= RULE_ID )
                    // InternalLts.g:275:7: lv_name_1_0= RULE_ID
                    {
                    lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_8); 

                    							newLeafNode(lv_name_1_0, grammarAccess.getTableDeclarationAccess().getNameIDTerminalRuleCall_0_0_1_0());
                    						

                    							if (current==null) {
                    								current = createModelElement(grammarAccess.getTableDeclarationRule());
                    							}
                    							setWithLastConsumed(
                    								current,
                    								"name",
                    								lv_name_1_0,
                    								"org.eclipse.xtext.common.Terminals.ID");
                    						

                    }


                    }

                    otherlv_2=(Token)match(input,16,FOLLOW_9); 

                    					newLeafNode(otherlv_2, grammarAccess.getTableDeclarationAccess().getFromKeyword_0_0_2());
                    				
                    // InternalLts.g:295:5: ( (lv_source_3_0= ruleCsvSource ) )
                    // InternalLts.g:296:6: (lv_source_3_0= ruleCsvSource )
                    {
                    // InternalLts.g:296:6: (lv_source_3_0= ruleCsvSource )
                    // InternalLts.g:297:7: lv_source_3_0= ruleCsvSource
                    {

                    							newCompositeNode(grammarAccess.getTableDeclarationAccess().getSourceCsvSourceParserRuleCall_0_0_3_0());
                    						
                    pushFollow(FOLLOW_4);
                    lv_source_3_0=ruleCsvSource();

                    state._fsp--;


                    							if (current==null) {
                    								current = createModelElementForParent(grammarAccess.getTableDeclarationRule());
                    							}
                    							set(
                    								current,
                    								"source",
                    								lv_source_3_0,
                    								"org.example.lts.Lts.CsvSource");
                    							afterParserOrEnumRuleCall();
                    						

                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalLts.g:316:4: (otherlv_4= 'table' ( (lv_name_5_0= RULE_ID ) ) )
                    {
                    // InternalLts.g:316:4: (otherlv_4= 'table' ( (lv_name_5_0= RULE_ID ) ) )
                    // InternalLts.g:317:5: otherlv_4= 'table' ( (lv_name_5_0= RULE_ID ) )
                    {
                    otherlv_4=(Token)match(input,17,FOLLOW_3); 

                    					newLeafNode(otherlv_4, grammarAccess.getTableDeclarationAccess().getTableKeyword_0_1_0());
                    				
                    // InternalLts.g:321:5: ( (lv_name_5_0= RULE_ID ) )
                    // InternalLts.g:322:6: (lv_name_5_0= RULE_ID )
                    {
                    // InternalLts.g:322:6: (lv_name_5_0= RULE_ID )
                    // InternalLts.g:323:7: lv_name_5_0= RULE_ID
                    {
                    lv_name_5_0=(Token)match(input,RULE_ID,FOLLOW_4); 

                    							newLeafNode(lv_name_5_0, grammarAccess.getTableDeclarationAccess().getNameIDTerminalRuleCall_0_1_1_0());
                    						

                    							if (current==null) {
                    								current = createModelElement(grammarAccess.getTableDeclarationRule());
                    							}
                    							setWithLastConsumed(
                    								current,
                    								"name",
                    								lv_name_5_0,
                    								"org.eclipse.xtext.common.Terminals.ID");
                    						

                    }


                    }


                    }


                    }
                    break;

            }

            otherlv_6=(Token)match(input,12,FOLLOW_10); 

            			newLeafNode(otherlv_6, grammarAccess.getTableDeclarationAccess().getLeftCurlyBracketKeyword_1());
            		
            // InternalLts.g:345:3: ( (lv_columns_7_0= ruleColumn ) )*
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( (LA5_0==RULE_ID) ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // InternalLts.g:346:4: (lv_columns_7_0= ruleColumn )
            	    {
            	    // InternalLts.g:346:4: (lv_columns_7_0= ruleColumn )
            	    // InternalLts.g:347:5: lv_columns_7_0= ruleColumn
            	    {

            	    					newCompositeNode(grammarAccess.getTableDeclarationAccess().getColumnsColumnParserRuleCall_2_0());
            	    				
            	    pushFollow(FOLLOW_10);
            	    lv_columns_7_0=ruleColumn();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getTableDeclarationRule());
            	    					}
            	    					add(
            	    						current,
            	    						"columns",
            	    						lv_columns_7_0,
            	    						"org.example.lts.Lts.Column");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop5;
                }
            } while (true);

            otherlv_8=(Token)match(input,14,FOLLOW_2); 

            			newLeafNode(otherlv_8, grammarAccess.getTableDeclarationAccess().getRightCurlyBracketKeyword_3());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleTableDeclaration"


    // $ANTLR start "entryRuleCsvSource"
    // InternalLts.g:372:1: entryRuleCsvSource returns [EObject current=null] : iv_ruleCsvSource= ruleCsvSource EOF ;
    public final EObject entryRuleCsvSource() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCsvSource = null;


        try {
            // InternalLts.g:372:50: (iv_ruleCsvSource= ruleCsvSource EOF )
            // InternalLts.g:373:2: iv_ruleCsvSource= ruleCsvSource EOF
            {
             newCompositeNode(grammarAccess.getCsvSourceRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleCsvSource=ruleCsvSource();

            state._fsp--;

             current =iv_ruleCsvSource; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleCsvSource"


    // $ANTLR start "ruleCsvSource"
    // InternalLts.g:379:1: ruleCsvSource returns [EObject current=null] : (otherlv_0= 'csv' ( (lv_path_1_0= RULE_STRING ) ) (otherlv_2= 'separator' ( (lv_separator_3_0= RULE_STRING ) ) )? (otherlv_4= 'header' ( (lv_header_5_0= ruleBooleanLiteral ) ) )? ) ;
    public final EObject ruleCsvSource() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_path_1_0=null;
        Token otherlv_2=null;
        Token lv_separator_3_0=null;
        Token otherlv_4=null;
        AntlrDatatypeRuleToken lv_header_5_0 = null;



        	enterRule();

        try {
            // InternalLts.g:385:2: ( (otherlv_0= 'csv' ( (lv_path_1_0= RULE_STRING ) ) (otherlv_2= 'separator' ( (lv_separator_3_0= RULE_STRING ) ) )? (otherlv_4= 'header' ( (lv_header_5_0= ruleBooleanLiteral ) ) )? ) )
            // InternalLts.g:386:2: (otherlv_0= 'csv' ( (lv_path_1_0= RULE_STRING ) ) (otherlv_2= 'separator' ( (lv_separator_3_0= RULE_STRING ) ) )? (otherlv_4= 'header' ( (lv_header_5_0= ruleBooleanLiteral ) ) )? )
            {
            // InternalLts.g:386:2: (otherlv_0= 'csv' ( (lv_path_1_0= RULE_STRING ) ) (otherlv_2= 'separator' ( (lv_separator_3_0= RULE_STRING ) ) )? (otherlv_4= 'header' ( (lv_header_5_0= ruleBooleanLiteral ) ) )? )
            // InternalLts.g:387:3: otherlv_0= 'csv' ( (lv_path_1_0= RULE_STRING ) ) (otherlv_2= 'separator' ( (lv_separator_3_0= RULE_STRING ) ) )? (otherlv_4= 'header' ( (lv_header_5_0= ruleBooleanLiteral ) ) )?
            {
            otherlv_0=(Token)match(input,18,FOLLOW_11); 

            			newLeafNode(otherlv_0, grammarAccess.getCsvSourceAccess().getCsvKeyword_0());
            		
            // InternalLts.g:391:3: ( (lv_path_1_0= RULE_STRING ) )
            // InternalLts.g:392:4: (lv_path_1_0= RULE_STRING )
            {
            // InternalLts.g:392:4: (lv_path_1_0= RULE_STRING )
            // InternalLts.g:393:5: lv_path_1_0= RULE_STRING
            {
            lv_path_1_0=(Token)match(input,RULE_STRING,FOLLOW_12); 

            					newLeafNode(lv_path_1_0, grammarAccess.getCsvSourceAccess().getPathSTRINGTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getCsvSourceRule());
            					}
            					setWithLastConsumed(
            						current,
            						"path",
            						lv_path_1_0,
            						"org.eclipse.xtext.common.Terminals.STRING");
            				

            }


            }

            // InternalLts.g:409:3: (otherlv_2= 'separator' ( (lv_separator_3_0= RULE_STRING ) ) )?
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==19) ) {
                alt6=1;
            }
            switch (alt6) {
                case 1 :
                    // InternalLts.g:410:4: otherlv_2= 'separator' ( (lv_separator_3_0= RULE_STRING ) )
                    {
                    otherlv_2=(Token)match(input,19,FOLLOW_11); 

                    				newLeafNode(otherlv_2, grammarAccess.getCsvSourceAccess().getSeparatorKeyword_2_0());
                    			
                    // InternalLts.g:414:4: ( (lv_separator_3_0= RULE_STRING ) )
                    // InternalLts.g:415:5: (lv_separator_3_0= RULE_STRING )
                    {
                    // InternalLts.g:415:5: (lv_separator_3_0= RULE_STRING )
                    // InternalLts.g:416:6: lv_separator_3_0= RULE_STRING
                    {
                    lv_separator_3_0=(Token)match(input,RULE_STRING,FOLLOW_13); 

                    						newLeafNode(lv_separator_3_0, grammarAccess.getCsvSourceAccess().getSeparatorSTRINGTerminalRuleCall_2_1_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getCsvSourceRule());
                    						}
                    						setWithLastConsumed(
                    							current,
                    							"separator",
                    							lv_separator_3_0,
                    							"org.eclipse.xtext.common.Terminals.STRING");
                    					

                    }


                    }


                    }
                    break;

            }

            // InternalLts.g:433:3: (otherlv_4= 'header' ( (lv_header_5_0= ruleBooleanLiteral ) ) )?
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==20) ) {
                alt7=1;
            }
            switch (alt7) {
                case 1 :
                    // InternalLts.g:434:4: otherlv_4= 'header' ( (lv_header_5_0= ruleBooleanLiteral ) )
                    {
                    otherlv_4=(Token)match(input,20,FOLLOW_14); 

                    				newLeafNode(otherlv_4, grammarAccess.getCsvSourceAccess().getHeaderKeyword_3_0());
                    			
                    // InternalLts.g:438:4: ( (lv_header_5_0= ruleBooleanLiteral ) )
                    // InternalLts.g:439:5: (lv_header_5_0= ruleBooleanLiteral )
                    {
                    // InternalLts.g:439:5: (lv_header_5_0= ruleBooleanLiteral )
                    // InternalLts.g:440:6: lv_header_5_0= ruleBooleanLiteral
                    {

                    						newCompositeNode(grammarAccess.getCsvSourceAccess().getHeaderBooleanLiteralParserRuleCall_3_1_0());
                    					
                    pushFollow(FOLLOW_2);
                    lv_header_5_0=ruleBooleanLiteral();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getCsvSourceRule());
                    						}
                    						set(
                    							current,
                    							"header",
                    							lv_header_5_0,
                    							"org.example.lts.Lts.BooleanLiteral");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;

            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleCsvSource"


    // $ANTLR start "entryRuleColumn"
    // InternalLts.g:462:1: entryRuleColumn returns [EObject current=null] : iv_ruleColumn= ruleColumn EOF ;
    public final EObject entryRuleColumn() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleColumn = null;


        try {
            // InternalLts.g:462:47: (iv_ruleColumn= ruleColumn EOF )
            // InternalLts.g:463:2: iv_ruleColumn= ruleColumn EOF
            {
             newCompositeNode(grammarAccess.getColumnRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleColumn=ruleColumn();

            state._fsp--;

             current =iv_ruleColumn; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleColumn"


    // $ANTLR start "ruleColumn"
    // InternalLts.g:469:1: ruleColumn returns [EObject current=null] : ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= ':' ( (lv_type_2_0= ruleDataType ) ) ( (lv_required_3_0= 'required' ) )? (otherlv_4= 'format' ( (lv_format_5_0= RULE_STRING ) ) )? otherlv_6= ';' ) ;
    public final EObject ruleColumn() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;
        Token otherlv_1=null;
        Token lv_required_3_0=null;
        Token otherlv_4=null;
        Token lv_format_5_0=null;
        Token otherlv_6=null;
        Enumerator lv_type_2_0 = null;



        	enterRule();

        try {
            // InternalLts.g:475:2: ( ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= ':' ( (lv_type_2_0= ruleDataType ) ) ( (lv_required_3_0= 'required' ) )? (otherlv_4= 'format' ( (lv_format_5_0= RULE_STRING ) ) )? otherlv_6= ';' ) )
            // InternalLts.g:476:2: ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= ':' ( (lv_type_2_0= ruleDataType ) ) ( (lv_required_3_0= 'required' ) )? (otherlv_4= 'format' ( (lv_format_5_0= RULE_STRING ) ) )? otherlv_6= ';' )
            {
            // InternalLts.g:476:2: ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= ':' ( (lv_type_2_0= ruleDataType ) ) ( (lv_required_3_0= 'required' ) )? (otherlv_4= 'format' ( (lv_format_5_0= RULE_STRING ) ) )? otherlv_6= ';' )
            // InternalLts.g:477:3: ( (lv_name_0_0= RULE_ID ) ) otherlv_1= ':' ( (lv_type_2_0= ruleDataType ) ) ( (lv_required_3_0= 'required' ) )? (otherlv_4= 'format' ( (lv_format_5_0= RULE_STRING ) ) )? otherlv_6= ';'
            {
            // InternalLts.g:477:3: ( (lv_name_0_0= RULE_ID ) )
            // InternalLts.g:478:4: (lv_name_0_0= RULE_ID )
            {
            // InternalLts.g:478:4: (lv_name_0_0= RULE_ID )
            // InternalLts.g:479:5: lv_name_0_0= RULE_ID
            {
            lv_name_0_0=(Token)match(input,RULE_ID,FOLLOW_15); 

            					newLeafNode(lv_name_0_0, grammarAccess.getColumnAccess().getNameIDTerminalRuleCall_0_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getColumnRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_0_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }

            otherlv_1=(Token)match(input,21,FOLLOW_16); 

            			newLeafNode(otherlv_1, grammarAccess.getColumnAccess().getColonKeyword_1());
            		
            // InternalLts.g:499:3: ( (lv_type_2_0= ruleDataType ) )
            // InternalLts.g:500:4: (lv_type_2_0= ruleDataType )
            {
            // InternalLts.g:500:4: (lv_type_2_0= ruleDataType )
            // InternalLts.g:501:5: lv_type_2_0= ruleDataType
            {

            					newCompositeNode(grammarAccess.getColumnAccess().getTypeDataTypeEnumRuleCall_2_0());
            				
            pushFollow(FOLLOW_17);
            lv_type_2_0=ruleDataType();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getColumnRule());
            					}
            					set(
            						current,
            						"type",
            						lv_type_2_0,
            						"org.example.lts.Lts.DataType");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalLts.g:518:3: ( (lv_required_3_0= 'required' ) )?
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==22) ) {
                alt8=1;
            }
            switch (alt8) {
                case 1 :
                    // InternalLts.g:519:4: (lv_required_3_0= 'required' )
                    {
                    // InternalLts.g:519:4: (lv_required_3_0= 'required' )
                    // InternalLts.g:520:5: lv_required_3_0= 'required'
                    {
                    lv_required_3_0=(Token)match(input,22,FOLLOW_18); 

                    					newLeafNode(lv_required_3_0, grammarAccess.getColumnAccess().getRequiredRequiredKeyword_3_0());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getColumnRule());
                    					}
                    					setWithLastConsumed(current, "required", lv_required_3_0 != null, "required");
                    				

                    }


                    }
                    break;

            }

            // InternalLts.g:532:3: (otherlv_4= 'format' ( (lv_format_5_0= RULE_STRING ) ) )?
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==23) ) {
                alt9=1;
            }
            switch (alt9) {
                case 1 :
                    // InternalLts.g:533:4: otherlv_4= 'format' ( (lv_format_5_0= RULE_STRING ) )
                    {
                    otherlv_4=(Token)match(input,23,FOLLOW_11); 

                    				newLeafNode(otherlv_4, grammarAccess.getColumnAccess().getFormatKeyword_4_0());
                    			
                    // InternalLts.g:537:4: ( (lv_format_5_0= RULE_STRING ) )
                    // InternalLts.g:538:5: (lv_format_5_0= RULE_STRING )
                    {
                    // InternalLts.g:538:5: (lv_format_5_0= RULE_STRING )
                    // InternalLts.g:539:6: lv_format_5_0= RULE_STRING
                    {
                    lv_format_5_0=(Token)match(input,RULE_STRING,FOLLOW_19); 

                    						newLeafNode(lv_format_5_0, grammarAccess.getColumnAccess().getFormatSTRINGTerminalRuleCall_4_1_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getColumnRule());
                    						}
                    						setWithLastConsumed(
                    							current,
                    							"format",
                    							lv_format_5_0,
                    							"org.eclipse.xtext.common.Terminals.STRING");
                    					

                    }


                    }


                    }
                    break;

            }

            otherlv_6=(Token)match(input,24,FOLLOW_2); 

            			newLeafNode(otherlv_6, grammarAccess.getColumnAccess().getSemicolonKeyword_5());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleColumn"


    // $ANTLR start "entryRuleCsvSink"
    // InternalLts.g:564:1: entryRuleCsvSink returns [EObject current=null] : iv_ruleCsvSink= ruleCsvSink EOF ;
    public final EObject entryRuleCsvSink() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCsvSink = null;


        try {
            // InternalLts.g:564:48: (iv_ruleCsvSink= ruleCsvSink EOF )
            // InternalLts.g:565:2: iv_ruleCsvSink= ruleCsvSink EOF
            {
             newCompositeNode(grammarAccess.getCsvSinkRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleCsvSink=ruleCsvSink();

            state._fsp--;

             current =iv_ruleCsvSink; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleCsvSink"


    // $ANTLR start "ruleCsvSink"
    // InternalLts.g:571:1: ruleCsvSink returns [EObject current=null] : (otherlv_0= 'output' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= 'table' ( (otherlv_3= RULE_ID ) ) otherlv_4= 'to' otherlv_5= 'csv' ( (lv_path_6_0= RULE_STRING ) ) (otherlv_7= 'separator' ( (lv_separator_8_0= RULE_STRING ) ) )? (otherlv_9= 'header' ( (lv_header_10_0= ruleBooleanLiteral ) ) )? otherlv_11= ';' ) ;
    public final EObject ruleCsvSink() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token otherlv_5=null;
        Token lv_path_6_0=null;
        Token otherlv_7=null;
        Token lv_separator_8_0=null;
        Token otherlv_9=null;
        Token otherlv_11=null;
        AntlrDatatypeRuleToken lv_header_10_0 = null;



        	enterRule();

        try {
            // InternalLts.g:577:2: ( (otherlv_0= 'output' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= 'table' ( (otherlv_3= RULE_ID ) ) otherlv_4= 'to' otherlv_5= 'csv' ( (lv_path_6_0= RULE_STRING ) ) (otherlv_7= 'separator' ( (lv_separator_8_0= RULE_STRING ) ) )? (otherlv_9= 'header' ( (lv_header_10_0= ruleBooleanLiteral ) ) )? otherlv_11= ';' ) )
            // InternalLts.g:578:2: (otherlv_0= 'output' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= 'table' ( (otherlv_3= RULE_ID ) ) otherlv_4= 'to' otherlv_5= 'csv' ( (lv_path_6_0= RULE_STRING ) ) (otherlv_7= 'separator' ( (lv_separator_8_0= RULE_STRING ) ) )? (otherlv_9= 'header' ( (lv_header_10_0= ruleBooleanLiteral ) ) )? otherlv_11= ';' )
            {
            // InternalLts.g:578:2: (otherlv_0= 'output' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= 'table' ( (otherlv_3= RULE_ID ) ) otherlv_4= 'to' otherlv_5= 'csv' ( (lv_path_6_0= RULE_STRING ) ) (otherlv_7= 'separator' ( (lv_separator_8_0= RULE_STRING ) ) )? (otherlv_9= 'header' ( (lv_header_10_0= ruleBooleanLiteral ) ) )? otherlv_11= ';' )
            // InternalLts.g:579:3: otherlv_0= 'output' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= 'table' ( (otherlv_3= RULE_ID ) ) otherlv_4= 'to' otherlv_5= 'csv' ( (lv_path_6_0= RULE_STRING ) ) (otherlv_7= 'separator' ( (lv_separator_8_0= RULE_STRING ) ) )? (otherlv_9= 'header' ( (lv_header_10_0= ruleBooleanLiteral ) ) )? otherlv_11= ';'
            {
            otherlv_0=(Token)match(input,25,FOLLOW_3); 

            			newLeafNode(otherlv_0, grammarAccess.getCsvSinkAccess().getOutputKeyword_0());
            		
            // InternalLts.g:583:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalLts.g:584:4: (lv_name_1_0= RULE_ID )
            {
            // InternalLts.g:584:4: (lv_name_1_0= RULE_ID )
            // InternalLts.g:585:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_20); 

            					newLeafNode(lv_name_1_0, grammarAccess.getCsvSinkAccess().getNameIDTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getCsvSinkRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_1_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }

            otherlv_2=(Token)match(input,17,FOLLOW_3); 

            			newLeafNode(otherlv_2, grammarAccess.getCsvSinkAccess().getTableKeyword_2());
            		
            // InternalLts.g:605:3: ( (otherlv_3= RULE_ID ) )
            // InternalLts.g:606:4: (otherlv_3= RULE_ID )
            {
            // InternalLts.g:606:4: (otherlv_3= RULE_ID )
            // InternalLts.g:607:5: otherlv_3= RULE_ID
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getCsvSinkRule());
            					}
            				
            otherlv_3=(Token)match(input,RULE_ID,FOLLOW_21); 

            					newLeafNode(otherlv_3, grammarAccess.getCsvSinkAccess().getTableTableDeclarationCrossReference_3_0());
            				

            }


            }

            otherlv_4=(Token)match(input,26,FOLLOW_9); 

            			newLeafNode(otherlv_4, grammarAccess.getCsvSinkAccess().getToKeyword_4());
            		
            otherlv_5=(Token)match(input,18,FOLLOW_11); 

            			newLeafNode(otherlv_5, grammarAccess.getCsvSinkAccess().getCsvKeyword_5());
            		
            // InternalLts.g:626:3: ( (lv_path_6_0= RULE_STRING ) )
            // InternalLts.g:627:4: (lv_path_6_0= RULE_STRING )
            {
            // InternalLts.g:627:4: (lv_path_6_0= RULE_STRING )
            // InternalLts.g:628:5: lv_path_6_0= RULE_STRING
            {
            lv_path_6_0=(Token)match(input,RULE_STRING,FOLLOW_22); 

            					newLeafNode(lv_path_6_0, grammarAccess.getCsvSinkAccess().getPathSTRINGTerminalRuleCall_6_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getCsvSinkRule());
            					}
            					setWithLastConsumed(
            						current,
            						"path",
            						lv_path_6_0,
            						"org.eclipse.xtext.common.Terminals.STRING");
            				

            }


            }

            // InternalLts.g:644:3: (otherlv_7= 'separator' ( (lv_separator_8_0= RULE_STRING ) ) )?
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==19) ) {
                alt10=1;
            }
            switch (alt10) {
                case 1 :
                    // InternalLts.g:645:4: otherlv_7= 'separator' ( (lv_separator_8_0= RULE_STRING ) )
                    {
                    otherlv_7=(Token)match(input,19,FOLLOW_11); 

                    				newLeafNode(otherlv_7, grammarAccess.getCsvSinkAccess().getSeparatorKeyword_7_0());
                    			
                    // InternalLts.g:649:4: ( (lv_separator_8_0= RULE_STRING ) )
                    // InternalLts.g:650:5: (lv_separator_8_0= RULE_STRING )
                    {
                    // InternalLts.g:650:5: (lv_separator_8_0= RULE_STRING )
                    // InternalLts.g:651:6: lv_separator_8_0= RULE_STRING
                    {
                    lv_separator_8_0=(Token)match(input,RULE_STRING,FOLLOW_23); 

                    						newLeafNode(lv_separator_8_0, grammarAccess.getCsvSinkAccess().getSeparatorSTRINGTerminalRuleCall_7_1_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getCsvSinkRule());
                    						}
                    						setWithLastConsumed(
                    							current,
                    							"separator",
                    							lv_separator_8_0,
                    							"org.eclipse.xtext.common.Terminals.STRING");
                    					

                    }


                    }


                    }
                    break;

            }

            // InternalLts.g:668:3: (otherlv_9= 'header' ( (lv_header_10_0= ruleBooleanLiteral ) ) )?
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0==20) ) {
                alt11=1;
            }
            switch (alt11) {
                case 1 :
                    // InternalLts.g:669:4: otherlv_9= 'header' ( (lv_header_10_0= ruleBooleanLiteral ) )
                    {
                    otherlv_9=(Token)match(input,20,FOLLOW_14); 

                    				newLeafNode(otherlv_9, grammarAccess.getCsvSinkAccess().getHeaderKeyword_8_0());
                    			
                    // InternalLts.g:673:4: ( (lv_header_10_0= ruleBooleanLiteral ) )
                    // InternalLts.g:674:5: (lv_header_10_0= ruleBooleanLiteral )
                    {
                    // InternalLts.g:674:5: (lv_header_10_0= ruleBooleanLiteral )
                    // InternalLts.g:675:6: lv_header_10_0= ruleBooleanLiteral
                    {

                    						newCompositeNode(grammarAccess.getCsvSinkAccess().getHeaderBooleanLiteralParserRuleCall_8_1_0());
                    					
                    pushFollow(FOLLOW_19);
                    lv_header_10_0=ruleBooleanLiteral();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getCsvSinkRule());
                    						}
                    						set(
                    							current,
                    							"header",
                    							lv_header_10_0,
                    							"org.example.lts.Lts.BooleanLiteral");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;

            }

            otherlv_11=(Token)match(input,24,FOLLOW_2); 

            			newLeafNode(otherlv_11, grammarAccess.getCsvSinkAccess().getSemicolonKeyword_9());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleCsvSink"


    // $ANTLR start "entryRuleLogSink"
    // InternalLts.g:701:1: entryRuleLogSink returns [EObject current=null] : iv_ruleLogSink= ruleLogSink EOF ;
    public final EObject entryRuleLogSink() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLogSink = null;


        try {
            // InternalLts.g:701:48: (iv_ruleLogSink= ruleLogSink EOF )
            // InternalLts.g:702:2: iv_ruleLogSink= ruleLogSink EOF
            {
             newCompositeNode(grammarAccess.getLogSinkRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleLogSink=ruleLogSink();

            state._fsp--;

             current =iv_ruleLogSink; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleLogSink"


    // $ANTLR start "ruleLogSink"
    // InternalLts.g:708:1: ruleLogSink returns [EObject current=null] : (otherlv_0= 'log' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= 'to' ( (lv_path_3_0= RULE_STRING ) ) otherlv_4= 'levels' ( (lv_levels_5_0= ruleLogLevel ) ) (otherlv_6= ',' ( (lv_levels_7_0= ruleLogLevel ) ) )* otherlv_8= ';' ) ;
    public final EObject ruleLogSink() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token lv_path_3_0=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        Token otherlv_8=null;
        Enumerator lv_levels_5_0 = null;

        Enumerator lv_levels_7_0 = null;



        	enterRule();

        try {
            // InternalLts.g:714:2: ( (otherlv_0= 'log' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= 'to' ( (lv_path_3_0= RULE_STRING ) ) otherlv_4= 'levels' ( (lv_levels_5_0= ruleLogLevel ) ) (otherlv_6= ',' ( (lv_levels_7_0= ruleLogLevel ) ) )* otherlv_8= ';' ) )
            // InternalLts.g:715:2: (otherlv_0= 'log' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= 'to' ( (lv_path_3_0= RULE_STRING ) ) otherlv_4= 'levels' ( (lv_levels_5_0= ruleLogLevel ) ) (otherlv_6= ',' ( (lv_levels_7_0= ruleLogLevel ) ) )* otherlv_8= ';' )
            {
            // InternalLts.g:715:2: (otherlv_0= 'log' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= 'to' ( (lv_path_3_0= RULE_STRING ) ) otherlv_4= 'levels' ( (lv_levels_5_0= ruleLogLevel ) ) (otherlv_6= ',' ( (lv_levels_7_0= ruleLogLevel ) ) )* otherlv_8= ';' )
            // InternalLts.g:716:3: otherlv_0= 'log' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= 'to' ( (lv_path_3_0= RULE_STRING ) ) otherlv_4= 'levels' ( (lv_levels_5_0= ruleLogLevel ) ) (otherlv_6= ',' ( (lv_levels_7_0= ruleLogLevel ) ) )* otherlv_8= ';'
            {
            otherlv_0=(Token)match(input,27,FOLLOW_3); 

            			newLeafNode(otherlv_0, grammarAccess.getLogSinkAccess().getLogKeyword_0());
            		
            // InternalLts.g:720:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalLts.g:721:4: (lv_name_1_0= RULE_ID )
            {
            // InternalLts.g:721:4: (lv_name_1_0= RULE_ID )
            // InternalLts.g:722:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_21); 

            					newLeafNode(lv_name_1_0, grammarAccess.getLogSinkAccess().getNameIDTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getLogSinkRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_1_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }

            otherlv_2=(Token)match(input,26,FOLLOW_11); 

            			newLeafNode(otherlv_2, grammarAccess.getLogSinkAccess().getToKeyword_2());
            		
            // InternalLts.g:742:3: ( (lv_path_3_0= RULE_STRING ) )
            // InternalLts.g:743:4: (lv_path_3_0= RULE_STRING )
            {
            // InternalLts.g:743:4: (lv_path_3_0= RULE_STRING )
            // InternalLts.g:744:5: lv_path_3_0= RULE_STRING
            {
            lv_path_3_0=(Token)match(input,RULE_STRING,FOLLOW_24); 

            					newLeafNode(lv_path_3_0, grammarAccess.getLogSinkAccess().getPathSTRINGTerminalRuleCall_3_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getLogSinkRule());
            					}
            					setWithLastConsumed(
            						current,
            						"path",
            						lv_path_3_0,
            						"org.eclipse.xtext.common.Terminals.STRING");
            				

            }


            }

            otherlv_4=(Token)match(input,28,FOLLOW_25); 

            			newLeafNode(otherlv_4, grammarAccess.getLogSinkAccess().getLevelsKeyword_4());
            		
            // InternalLts.g:764:3: ( (lv_levels_5_0= ruleLogLevel ) )
            // InternalLts.g:765:4: (lv_levels_5_0= ruleLogLevel )
            {
            // InternalLts.g:765:4: (lv_levels_5_0= ruleLogLevel )
            // InternalLts.g:766:5: lv_levels_5_0= ruleLogLevel
            {

            					newCompositeNode(grammarAccess.getLogSinkAccess().getLevelsLogLevelEnumRuleCall_5_0());
            				
            pushFollow(FOLLOW_26);
            lv_levels_5_0=ruleLogLevel();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getLogSinkRule());
            					}
            					add(
            						current,
            						"levels",
            						lv_levels_5_0,
            						"org.example.lts.Lts.LogLevel");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalLts.g:783:3: (otherlv_6= ',' ( (lv_levels_7_0= ruleLogLevel ) ) )*
            loop12:
            do {
                int alt12=2;
                int LA12_0 = input.LA(1);

                if ( (LA12_0==29) ) {
                    alt12=1;
                }


                switch (alt12) {
            	case 1 :
            	    // InternalLts.g:784:4: otherlv_6= ',' ( (lv_levels_7_0= ruleLogLevel ) )
            	    {
            	    otherlv_6=(Token)match(input,29,FOLLOW_25); 

            	    				newLeafNode(otherlv_6, grammarAccess.getLogSinkAccess().getCommaKeyword_6_0());
            	    			
            	    // InternalLts.g:788:4: ( (lv_levels_7_0= ruleLogLevel ) )
            	    // InternalLts.g:789:5: (lv_levels_7_0= ruleLogLevel )
            	    {
            	    // InternalLts.g:789:5: (lv_levels_7_0= ruleLogLevel )
            	    // InternalLts.g:790:6: lv_levels_7_0= ruleLogLevel
            	    {

            	    						newCompositeNode(grammarAccess.getLogSinkAccess().getLevelsLogLevelEnumRuleCall_6_1_0());
            	    					
            	    pushFollow(FOLLOW_26);
            	    lv_levels_7_0=ruleLogLevel();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getLogSinkRule());
            	    						}
            	    						add(
            	    							current,
            	    							"levels",
            	    							lv_levels_7_0,
            	    							"org.example.lts.Lts.LogLevel");
            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop12;
                }
            } while (true);

            otherlv_8=(Token)match(input,24,FOLLOW_2); 

            			newLeafNode(otherlv_8, grammarAccess.getLogSinkAccess().getSemicolonKeyword_7());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleLogSink"


    // $ANTLR start "entryRuleExternalFunction"
    // InternalLts.g:816:1: entryRuleExternalFunction returns [EObject current=null] : iv_ruleExternalFunction= ruleExternalFunction EOF ;
    public final EObject entryRuleExternalFunction() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExternalFunction = null;


        try {
            // InternalLts.g:816:57: (iv_ruleExternalFunction= ruleExternalFunction EOF )
            // InternalLts.g:817:2: iv_ruleExternalFunction= ruleExternalFunction EOF
            {
             newCompositeNode(grammarAccess.getExternalFunctionRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleExternalFunction=ruleExternalFunction();

            state._fsp--;

             current =iv_ruleExternalFunction; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleExternalFunction"


    // $ANTLR start "ruleExternalFunction"
    // InternalLts.g:823:1: ruleExternalFunction returns [EObject current=null] : (otherlv_0= 'external' otherlv_1= 'function' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '(' ( ( (lv_parameters_4_0= ruleParameter ) ) (otherlv_5= ',' ( (lv_parameters_6_0= ruleParameter ) ) )* )? otherlv_7= ')' otherlv_8= ':' ( (lv_returnType_9_0= ruleDataType ) ) otherlv_10= 'implemented' otherlv_11= 'by' ( (lv_implementation_12_0= RULE_STRING ) ) otherlv_13= ';' ) ;
    public final EObject ruleExternalFunction() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token lv_name_2_0=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        Token otherlv_8=null;
        Token otherlv_10=null;
        Token otherlv_11=null;
        Token lv_implementation_12_0=null;
        Token otherlv_13=null;
        EObject lv_parameters_4_0 = null;

        EObject lv_parameters_6_0 = null;

        Enumerator lv_returnType_9_0 = null;



        	enterRule();

        try {
            // InternalLts.g:829:2: ( (otherlv_0= 'external' otherlv_1= 'function' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '(' ( ( (lv_parameters_4_0= ruleParameter ) ) (otherlv_5= ',' ( (lv_parameters_6_0= ruleParameter ) ) )* )? otherlv_7= ')' otherlv_8= ':' ( (lv_returnType_9_0= ruleDataType ) ) otherlv_10= 'implemented' otherlv_11= 'by' ( (lv_implementation_12_0= RULE_STRING ) ) otherlv_13= ';' ) )
            // InternalLts.g:830:2: (otherlv_0= 'external' otherlv_1= 'function' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '(' ( ( (lv_parameters_4_0= ruleParameter ) ) (otherlv_5= ',' ( (lv_parameters_6_0= ruleParameter ) ) )* )? otherlv_7= ')' otherlv_8= ':' ( (lv_returnType_9_0= ruleDataType ) ) otherlv_10= 'implemented' otherlv_11= 'by' ( (lv_implementation_12_0= RULE_STRING ) ) otherlv_13= ';' )
            {
            // InternalLts.g:830:2: (otherlv_0= 'external' otherlv_1= 'function' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '(' ( ( (lv_parameters_4_0= ruleParameter ) ) (otherlv_5= ',' ( (lv_parameters_6_0= ruleParameter ) ) )* )? otherlv_7= ')' otherlv_8= ':' ( (lv_returnType_9_0= ruleDataType ) ) otherlv_10= 'implemented' otherlv_11= 'by' ( (lv_implementation_12_0= RULE_STRING ) ) otherlv_13= ';' )
            // InternalLts.g:831:3: otherlv_0= 'external' otherlv_1= 'function' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '(' ( ( (lv_parameters_4_0= ruleParameter ) ) (otherlv_5= ',' ( (lv_parameters_6_0= ruleParameter ) ) )* )? otherlv_7= ')' otherlv_8= ':' ( (lv_returnType_9_0= ruleDataType ) ) otherlv_10= 'implemented' otherlv_11= 'by' ( (lv_implementation_12_0= RULE_STRING ) ) otherlv_13= ';'
            {
            otherlv_0=(Token)match(input,30,FOLLOW_27); 

            			newLeafNode(otherlv_0, grammarAccess.getExternalFunctionAccess().getExternalKeyword_0());
            		
            otherlv_1=(Token)match(input,31,FOLLOW_3); 

            			newLeafNode(otherlv_1, grammarAccess.getExternalFunctionAccess().getFunctionKeyword_1());
            		
            // InternalLts.g:839:3: ( (lv_name_2_0= RULE_ID ) )
            // InternalLts.g:840:4: (lv_name_2_0= RULE_ID )
            {
            // InternalLts.g:840:4: (lv_name_2_0= RULE_ID )
            // InternalLts.g:841:5: lv_name_2_0= RULE_ID
            {
            lv_name_2_0=(Token)match(input,RULE_ID,FOLLOW_28); 

            					newLeafNode(lv_name_2_0, grammarAccess.getExternalFunctionAccess().getNameIDTerminalRuleCall_2_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getExternalFunctionRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_2_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }

            otherlv_3=(Token)match(input,32,FOLLOW_29); 

            			newLeafNode(otherlv_3, grammarAccess.getExternalFunctionAccess().getLeftParenthesisKeyword_3());
            		
            // InternalLts.g:861:3: ( ( (lv_parameters_4_0= ruleParameter ) ) (otherlv_5= ',' ( (lv_parameters_6_0= ruleParameter ) ) )* )?
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( (LA14_0==RULE_ID) ) {
                alt14=1;
            }
            switch (alt14) {
                case 1 :
                    // InternalLts.g:862:4: ( (lv_parameters_4_0= ruleParameter ) ) (otherlv_5= ',' ( (lv_parameters_6_0= ruleParameter ) ) )*
                    {
                    // InternalLts.g:862:4: ( (lv_parameters_4_0= ruleParameter ) )
                    // InternalLts.g:863:5: (lv_parameters_4_0= ruleParameter )
                    {
                    // InternalLts.g:863:5: (lv_parameters_4_0= ruleParameter )
                    // InternalLts.g:864:6: lv_parameters_4_0= ruleParameter
                    {

                    						newCompositeNode(grammarAccess.getExternalFunctionAccess().getParametersParameterParserRuleCall_4_0_0());
                    					
                    pushFollow(FOLLOW_30);
                    lv_parameters_4_0=ruleParameter();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getExternalFunctionRule());
                    						}
                    						add(
                    							current,
                    							"parameters",
                    							lv_parameters_4_0,
                    							"org.example.lts.Lts.Parameter");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    // InternalLts.g:881:4: (otherlv_5= ',' ( (lv_parameters_6_0= ruleParameter ) ) )*
                    loop13:
                    do {
                        int alt13=2;
                        int LA13_0 = input.LA(1);

                        if ( (LA13_0==29) ) {
                            alt13=1;
                        }


                        switch (alt13) {
                    	case 1 :
                    	    // InternalLts.g:882:5: otherlv_5= ',' ( (lv_parameters_6_0= ruleParameter ) )
                    	    {
                    	    otherlv_5=(Token)match(input,29,FOLLOW_3); 

                    	    					newLeafNode(otherlv_5, grammarAccess.getExternalFunctionAccess().getCommaKeyword_4_1_0());
                    	    				
                    	    // InternalLts.g:886:5: ( (lv_parameters_6_0= ruleParameter ) )
                    	    // InternalLts.g:887:6: (lv_parameters_6_0= ruleParameter )
                    	    {
                    	    // InternalLts.g:887:6: (lv_parameters_6_0= ruleParameter )
                    	    // InternalLts.g:888:7: lv_parameters_6_0= ruleParameter
                    	    {

                    	    							newCompositeNode(grammarAccess.getExternalFunctionAccess().getParametersParameterParserRuleCall_4_1_1_0());
                    	    						
                    	    pushFollow(FOLLOW_30);
                    	    lv_parameters_6_0=ruleParameter();

                    	    state._fsp--;


                    	    							if (current==null) {
                    	    								current = createModelElementForParent(grammarAccess.getExternalFunctionRule());
                    	    							}
                    	    							add(
                    	    								current,
                    	    								"parameters",
                    	    								lv_parameters_6_0,
                    	    								"org.example.lts.Lts.Parameter");
                    	    							afterParserOrEnumRuleCall();
                    	    						

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop13;
                        }
                    } while (true);


                    }
                    break;

            }

            otherlv_7=(Token)match(input,33,FOLLOW_15); 

            			newLeafNode(otherlv_7, grammarAccess.getExternalFunctionAccess().getRightParenthesisKeyword_5());
            		
            otherlv_8=(Token)match(input,21,FOLLOW_16); 

            			newLeafNode(otherlv_8, grammarAccess.getExternalFunctionAccess().getColonKeyword_6());
            		
            // InternalLts.g:915:3: ( (lv_returnType_9_0= ruleDataType ) )
            // InternalLts.g:916:4: (lv_returnType_9_0= ruleDataType )
            {
            // InternalLts.g:916:4: (lv_returnType_9_0= ruleDataType )
            // InternalLts.g:917:5: lv_returnType_9_0= ruleDataType
            {

            					newCompositeNode(grammarAccess.getExternalFunctionAccess().getReturnTypeDataTypeEnumRuleCall_7_0());
            				
            pushFollow(FOLLOW_31);
            lv_returnType_9_0=ruleDataType();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getExternalFunctionRule());
            					}
            					set(
            						current,
            						"returnType",
            						lv_returnType_9_0,
            						"org.example.lts.Lts.DataType");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_10=(Token)match(input,34,FOLLOW_32); 

            			newLeafNode(otherlv_10, grammarAccess.getExternalFunctionAccess().getImplementedKeyword_8());
            		
            otherlv_11=(Token)match(input,35,FOLLOW_11); 

            			newLeafNode(otherlv_11, grammarAccess.getExternalFunctionAccess().getByKeyword_9());
            		
            // InternalLts.g:942:3: ( (lv_implementation_12_0= RULE_STRING ) )
            // InternalLts.g:943:4: (lv_implementation_12_0= RULE_STRING )
            {
            // InternalLts.g:943:4: (lv_implementation_12_0= RULE_STRING )
            // InternalLts.g:944:5: lv_implementation_12_0= RULE_STRING
            {
            lv_implementation_12_0=(Token)match(input,RULE_STRING,FOLLOW_19); 

            					newLeafNode(lv_implementation_12_0, grammarAccess.getExternalFunctionAccess().getImplementationSTRINGTerminalRuleCall_10_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getExternalFunctionRule());
            					}
            					setWithLastConsumed(
            						current,
            						"implementation",
            						lv_implementation_12_0,
            						"org.eclipse.xtext.common.Terminals.STRING");
            				

            }


            }

            otherlv_13=(Token)match(input,24,FOLLOW_2); 

            			newLeafNode(otherlv_13, grammarAccess.getExternalFunctionAccess().getSemicolonKeyword_11());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleExternalFunction"


    // $ANTLR start "entryRuleParameter"
    // InternalLts.g:968:1: entryRuleParameter returns [EObject current=null] : iv_ruleParameter= ruleParameter EOF ;
    public final EObject entryRuleParameter() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParameter = null;


        try {
            // InternalLts.g:968:50: (iv_ruleParameter= ruleParameter EOF )
            // InternalLts.g:969:2: iv_ruleParameter= ruleParameter EOF
            {
             newCompositeNode(grammarAccess.getParameterRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleParameter=ruleParameter();

            state._fsp--;

             current =iv_ruleParameter; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleParameter"


    // $ANTLR start "ruleParameter"
    // InternalLts.g:975:1: ruleParameter returns [EObject current=null] : ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= ':' ( (lv_type_2_0= ruleDataType ) ) ) ;
    public final EObject ruleParameter() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;
        Token otherlv_1=null;
        Enumerator lv_type_2_0 = null;



        	enterRule();

        try {
            // InternalLts.g:981:2: ( ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= ':' ( (lv_type_2_0= ruleDataType ) ) ) )
            // InternalLts.g:982:2: ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= ':' ( (lv_type_2_0= ruleDataType ) ) )
            {
            // InternalLts.g:982:2: ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= ':' ( (lv_type_2_0= ruleDataType ) ) )
            // InternalLts.g:983:3: ( (lv_name_0_0= RULE_ID ) ) otherlv_1= ':' ( (lv_type_2_0= ruleDataType ) )
            {
            // InternalLts.g:983:3: ( (lv_name_0_0= RULE_ID ) )
            // InternalLts.g:984:4: (lv_name_0_0= RULE_ID )
            {
            // InternalLts.g:984:4: (lv_name_0_0= RULE_ID )
            // InternalLts.g:985:5: lv_name_0_0= RULE_ID
            {
            lv_name_0_0=(Token)match(input,RULE_ID,FOLLOW_15); 

            					newLeafNode(lv_name_0_0, grammarAccess.getParameterAccess().getNameIDTerminalRuleCall_0_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getParameterRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_0_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }

            otherlv_1=(Token)match(input,21,FOLLOW_16); 

            			newLeafNode(otherlv_1, grammarAccess.getParameterAccess().getColonKeyword_1());
            		
            // InternalLts.g:1005:3: ( (lv_type_2_0= ruleDataType ) )
            // InternalLts.g:1006:4: (lv_type_2_0= ruleDataType )
            {
            // InternalLts.g:1006:4: (lv_type_2_0= ruleDataType )
            // InternalLts.g:1007:5: lv_type_2_0= ruleDataType
            {

            					newCompositeNode(grammarAccess.getParameterAccess().getTypeDataTypeEnumRuleCall_2_0());
            				
            pushFollow(FOLLOW_2);
            lv_type_2_0=ruleDataType();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getParameterRule());
            					}
            					set(
            						current,
            						"type",
            						lv_type_2_0,
            						"org.example.lts.Lts.DataType");
            					afterParserOrEnumRuleCall();
            				

            }


            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleParameter"


    // $ANTLR start "entryRuleOperation"
    // InternalLts.g:1028:1: entryRuleOperation returns [EObject current=null] : iv_ruleOperation= ruleOperation EOF ;
    public final EObject entryRuleOperation() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleOperation = null;


        try {
            // InternalLts.g:1028:50: (iv_ruleOperation= ruleOperation EOF )
            // InternalLts.g:1029:2: iv_ruleOperation= ruleOperation EOF
            {
             newCompositeNode(grammarAccess.getOperationRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleOperation=ruleOperation();

            state._fsp--;

             current =iv_ruleOperation; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleOperation"


    // $ANTLR start "ruleOperation"
    // InternalLts.g:1035:1: ruleOperation returns [EObject current=null] : (this_LoadOperation_0= ruleLoadOperation | this_CreateTableOperation_1= ruleCreateTableOperation | this_AppendRowsOperation_2= ruleAppendRowsOperation | this_FilterOperation_3= ruleFilterOperation | this_SortOperation_4= ruleSortOperation | this_GroupOperation_5= ruleGroupOperation | this_AggregateOperation_6= ruleAggregateOperation | this_JoinOperation_7= ruleJoinOperation | this_InsertColumnOperation_8= ruleInsertColumnOperation | this_RemoveColumnOperation_9= ruleRemoveColumnOperation | this_CalculateColumnOperation_10= ruleCalculateColumnOperation | this_LookupOperation_11= ruleLookupOperation | this_RemoveDuplicatesOperation_12= ruleRemoveDuplicatesOperation | this_SaveTableOperation_13= ruleSaveTableOperation | this_SaveLogOperation_14= ruleSaveLogOperation ) ;
    public final EObject ruleOperation() throws RecognitionException {
        EObject current = null;

        EObject this_LoadOperation_0 = null;

        EObject this_CreateTableOperation_1 = null;

        EObject this_AppendRowsOperation_2 = null;

        EObject this_FilterOperation_3 = null;

        EObject this_SortOperation_4 = null;

        EObject this_GroupOperation_5 = null;

        EObject this_AggregateOperation_6 = null;

        EObject this_JoinOperation_7 = null;

        EObject this_InsertColumnOperation_8 = null;

        EObject this_RemoveColumnOperation_9 = null;

        EObject this_CalculateColumnOperation_10 = null;

        EObject this_LookupOperation_11 = null;

        EObject this_RemoveDuplicatesOperation_12 = null;

        EObject this_SaveTableOperation_13 = null;

        EObject this_SaveLogOperation_14 = null;



        	enterRule();

        try {
            // InternalLts.g:1041:2: ( (this_LoadOperation_0= ruleLoadOperation | this_CreateTableOperation_1= ruleCreateTableOperation | this_AppendRowsOperation_2= ruleAppendRowsOperation | this_FilterOperation_3= ruleFilterOperation | this_SortOperation_4= ruleSortOperation | this_GroupOperation_5= ruleGroupOperation | this_AggregateOperation_6= ruleAggregateOperation | this_JoinOperation_7= ruleJoinOperation | this_InsertColumnOperation_8= ruleInsertColumnOperation | this_RemoveColumnOperation_9= ruleRemoveColumnOperation | this_CalculateColumnOperation_10= ruleCalculateColumnOperation | this_LookupOperation_11= ruleLookupOperation | this_RemoveDuplicatesOperation_12= ruleRemoveDuplicatesOperation | this_SaveTableOperation_13= ruleSaveTableOperation | this_SaveLogOperation_14= ruleSaveLogOperation ) )
            // InternalLts.g:1042:2: (this_LoadOperation_0= ruleLoadOperation | this_CreateTableOperation_1= ruleCreateTableOperation | this_AppendRowsOperation_2= ruleAppendRowsOperation | this_FilterOperation_3= ruleFilterOperation | this_SortOperation_4= ruleSortOperation | this_GroupOperation_5= ruleGroupOperation | this_AggregateOperation_6= ruleAggregateOperation | this_JoinOperation_7= ruleJoinOperation | this_InsertColumnOperation_8= ruleInsertColumnOperation | this_RemoveColumnOperation_9= ruleRemoveColumnOperation | this_CalculateColumnOperation_10= ruleCalculateColumnOperation | this_LookupOperation_11= ruleLookupOperation | this_RemoveDuplicatesOperation_12= ruleRemoveDuplicatesOperation | this_SaveTableOperation_13= ruleSaveTableOperation | this_SaveLogOperation_14= ruleSaveLogOperation )
            {
            // InternalLts.g:1042:2: (this_LoadOperation_0= ruleLoadOperation | this_CreateTableOperation_1= ruleCreateTableOperation | this_AppendRowsOperation_2= ruleAppendRowsOperation | this_FilterOperation_3= ruleFilterOperation | this_SortOperation_4= ruleSortOperation | this_GroupOperation_5= ruleGroupOperation | this_AggregateOperation_6= ruleAggregateOperation | this_JoinOperation_7= ruleJoinOperation | this_InsertColumnOperation_8= ruleInsertColumnOperation | this_RemoveColumnOperation_9= ruleRemoveColumnOperation | this_CalculateColumnOperation_10= ruleCalculateColumnOperation | this_LookupOperation_11= ruleLookupOperation | this_RemoveDuplicatesOperation_12= ruleRemoveDuplicatesOperation | this_SaveTableOperation_13= ruleSaveTableOperation | this_SaveLogOperation_14= ruleSaveLogOperation )
            int alt15=15;
            alt15 = dfa15.predict(input);
            switch (alt15) {
                case 1 :
                    // InternalLts.g:1043:3: this_LoadOperation_0= ruleLoadOperation
                    {

                    			newCompositeNode(grammarAccess.getOperationAccess().getLoadOperationParserRuleCall_0());
                    		
                    pushFollow(FOLLOW_2);
                    this_LoadOperation_0=ruleLoadOperation();

                    state._fsp--;


                    			current = this_LoadOperation_0;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 2 :
                    // InternalLts.g:1052:3: this_CreateTableOperation_1= ruleCreateTableOperation
                    {

                    			newCompositeNode(grammarAccess.getOperationAccess().getCreateTableOperationParserRuleCall_1());
                    		
                    pushFollow(FOLLOW_2);
                    this_CreateTableOperation_1=ruleCreateTableOperation();

                    state._fsp--;


                    			current = this_CreateTableOperation_1;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 3 :
                    // InternalLts.g:1061:3: this_AppendRowsOperation_2= ruleAppendRowsOperation
                    {

                    			newCompositeNode(grammarAccess.getOperationAccess().getAppendRowsOperationParserRuleCall_2());
                    		
                    pushFollow(FOLLOW_2);
                    this_AppendRowsOperation_2=ruleAppendRowsOperation();

                    state._fsp--;


                    			current = this_AppendRowsOperation_2;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 4 :
                    // InternalLts.g:1070:3: this_FilterOperation_3= ruleFilterOperation
                    {

                    			newCompositeNode(grammarAccess.getOperationAccess().getFilterOperationParserRuleCall_3());
                    		
                    pushFollow(FOLLOW_2);
                    this_FilterOperation_3=ruleFilterOperation();

                    state._fsp--;


                    			current = this_FilterOperation_3;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 5 :
                    // InternalLts.g:1079:3: this_SortOperation_4= ruleSortOperation
                    {

                    			newCompositeNode(grammarAccess.getOperationAccess().getSortOperationParserRuleCall_4());
                    		
                    pushFollow(FOLLOW_2);
                    this_SortOperation_4=ruleSortOperation();

                    state._fsp--;


                    			current = this_SortOperation_4;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 6 :
                    // InternalLts.g:1088:3: this_GroupOperation_5= ruleGroupOperation
                    {

                    			newCompositeNode(grammarAccess.getOperationAccess().getGroupOperationParserRuleCall_5());
                    		
                    pushFollow(FOLLOW_2);
                    this_GroupOperation_5=ruleGroupOperation();

                    state._fsp--;


                    			current = this_GroupOperation_5;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 7 :
                    // InternalLts.g:1097:3: this_AggregateOperation_6= ruleAggregateOperation
                    {

                    			newCompositeNode(grammarAccess.getOperationAccess().getAggregateOperationParserRuleCall_6());
                    		
                    pushFollow(FOLLOW_2);
                    this_AggregateOperation_6=ruleAggregateOperation();

                    state._fsp--;


                    			current = this_AggregateOperation_6;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 8 :
                    // InternalLts.g:1106:3: this_JoinOperation_7= ruleJoinOperation
                    {

                    			newCompositeNode(grammarAccess.getOperationAccess().getJoinOperationParserRuleCall_7());
                    		
                    pushFollow(FOLLOW_2);
                    this_JoinOperation_7=ruleJoinOperation();

                    state._fsp--;


                    			current = this_JoinOperation_7;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 9 :
                    // InternalLts.g:1115:3: this_InsertColumnOperation_8= ruleInsertColumnOperation
                    {

                    			newCompositeNode(grammarAccess.getOperationAccess().getInsertColumnOperationParserRuleCall_8());
                    		
                    pushFollow(FOLLOW_2);
                    this_InsertColumnOperation_8=ruleInsertColumnOperation();

                    state._fsp--;


                    			current = this_InsertColumnOperation_8;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 10 :
                    // InternalLts.g:1124:3: this_RemoveColumnOperation_9= ruleRemoveColumnOperation
                    {

                    			newCompositeNode(grammarAccess.getOperationAccess().getRemoveColumnOperationParserRuleCall_9());
                    		
                    pushFollow(FOLLOW_2);
                    this_RemoveColumnOperation_9=ruleRemoveColumnOperation();

                    state._fsp--;


                    			current = this_RemoveColumnOperation_9;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 11 :
                    // InternalLts.g:1133:3: this_CalculateColumnOperation_10= ruleCalculateColumnOperation
                    {

                    			newCompositeNode(grammarAccess.getOperationAccess().getCalculateColumnOperationParserRuleCall_10());
                    		
                    pushFollow(FOLLOW_2);
                    this_CalculateColumnOperation_10=ruleCalculateColumnOperation();

                    state._fsp--;


                    			current = this_CalculateColumnOperation_10;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 12 :
                    // InternalLts.g:1142:3: this_LookupOperation_11= ruleLookupOperation
                    {

                    			newCompositeNode(grammarAccess.getOperationAccess().getLookupOperationParserRuleCall_11());
                    		
                    pushFollow(FOLLOW_2);
                    this_LookupOperation_11=ruleLookupOperation();

                    state._fsp--;


                    			current = this_LookupOperation_11;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 13 :
                    // InternalLts.g:1151:3: this_RemoveDuplicatesOperation_12= ruleRemoveDuplicatesOperation
                    {

                    			newCompositeNode(grammarAccess.getOperationAccess().getRemoveDuplicatesOperationParserRuleCall_12());
                    		
                    pushFollow(FOLLOW_2);
                    this_RemoveDuplicatesOperation_12=ruleRemoveDuplicatesOperation();

                    state._fsp--;


                    			current = this_RemoveDuplicatesOperation_12;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 14 :
                    // InternalLts.g:1160:3: this_SaveTableOperation_13= ruleSaveTableOperation
                    {

                    			newCompositeNode(grammarAccess.getOperationAccess().getSaveTableOperationParserRuleCall_13());
                    		
                    pushFollow(FOLLOW_2);
                    this_SaveTableOperation_13=ruleSaveTableOperation();

                    state._fsp--;


                    			current = this_SaveTableOperation_13;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 15 :
                    // InternalLts.g:1169:3: this_SaveLogOperation_14= ruleSaveLogOperation
                    {

                    			newCompositeNode(grammarAccess.getOperationAccess().getSaveLogOperationParserRuleCall_14());
                    		
                    pushFollow(FOLLOW_2);
                    this_SaveLogOperation_14=ruleSaveLogOperation();

                    state._fsp--;


                    			current = this_SaveLogOperation_14;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleOperation"


    // $ANTLR start "entryRuleLoadOperation"
    // InternalLts.g:1181:1: entryRuleLoadOperation returns [EObject current=null] : iv_ruleLoadOperation= ruleLoadOperation EOF ;
    public final EObject entryRuleLoadOperation() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLoadOperation = null;


        try {
            // InternalLts.g:1181:54: (iv_ruleLoadOperation= ruleLoadOperation EOF )
            // InternalLts.g:1182:2: iv_ruleLoadOperation= ruleLoadOperation EOF
            {
             newCompositeNode(grammarAccess.getLoadOperationRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleLoadOperation=ruleLoadOperation();

            state._fsp--;

             current =iv_ruleLoadOperation; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleLoadOperation"


    // $ANTLR start "ruleLoadOperation"
    // InternalLts.g:1188:1: ruleLoadOperation returns [EObject current=null] : (otherlv_0= 'load' ( (otherlv_1= RULE_ID ) ) otherlv_2= ';' ) ;
    public final EObject ruleLoadOperation() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;


        	enterRule();

        try {
            // InternalLts.g:1194:2: ( (otherlv_0= 'load' ( (otherlv_1= RULE_ID ) ) otherlv_2= ';' ) )
            // InternalLts.g:1195:2: (otherlv_0= 'load' ( (otherlv_1= RULE_ID ) ) otherlv_2= ';' )
            {
            // InternalLts.g:1195:2: (otherlv_0= 'load' ( (otherlv_1= RULE_ID ) ) otherlv_2= ';' )
            // InternalLts.g:1196:3: otherlv_0= 'load' ( (otherlv_1= RULE_ID ) ) otherlv_2= ';'
            {
            otherlv_0=(Token)match(input,36,FOLLOW_3); 

            			newLeafNode(otherlv_0, grammarAccess.getLoadOperationAccess().getLoadKeyword_0());
            		
            // InternalLts.g:1200:3: ( (otherlv_1= RULE_ID ) )
            // InternalLts.g:1201:4: (otherlv_1= RULE_ID )
            {
            // InternalLts.g:1201:4: (otherlv_1= RULE_ID )
            // InternalLts.g:1202:5: otherlv_1= RULE_ID
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getLoadOperationRule());
            					}
            				
            otherlv_1=(Token)match(input,RULE_ID,FOLLOW_19); 

            					newLeafNode(otherlv_1, grammarAccess.getLoadOperationAccess().getTableTableDeclarationCrossReference_1_0());
            				

            }


            }

            otherlv_2=(Token)match(input,24,FOLLOW_2); 

            			newLeafNode(otherlv_2, grammarAccess.getLoadOperationAccess().getSemicolonKeyword_2());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleLoadOperation"


    // $ANTLR start "entryRuleCreateTableOperation"
    // InternalLts.g:1221:1: entryRuleCreateTableOperation returns [EObject current=null] : iv_ruleCreateTableOperation= ruleCreateTableOperation EOF ;
    public final EObject entryRuleCreateTableOperation() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCreateTableOperation = null;


        try {
            // InternalLts.g:1221:61: (iv_ruleCreateTableOperation= ruleCreateTableOperation EOF )
            // InternalLts.g:1222:2: iv_ruleCreateTableOperation= ruleCreateTableOperation EOF
            {
             newCompositeNode(grammarAccess.getCreateTableOperationRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleCreateTableOperation=ruleCreateTableOperation();

            state._fsp--;

             current =iv_ruleCreateTableOperation; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleCreateTableOperation"


    // $ANTLR start "ruleCreateTableOperation"
    // InternalLts.g:1228:1: ruleCreateTableOperation returns [EObject current=null] : (otherlv_0= 'create' otherlv_1= 'empty' ( (otherlv_2= RULE_ID ) ) otherlv_3= ';' ) ;
    public final EObject ruleCreateTableOperation() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_3=null;


        	enterRule();

        try {
            // InternalLts.g:1234:2: ( (otherlv_0= 'create' otherlv_1= 'empty' ( (otherlv_2= RULE_ID ) ) otherlv_3= ';' ) )
            // InternalLts.g:1235:2: (otherlv_0= 'create' otherlv_1= 'empty' ( (otherlv_2= RULE_ID ) ) otherlv_3= ';' )
            {
            // InternalLts.g:1235:2: (otherlv_0= 'create' otherlv_1= 'empty' ( (otherlv_2= RULE_ID ) ) otherlv_3= ';' )
            // InternalLts.g:1236:3: otherlv_0= 'create' otherlv_1= 'empty' ( (otherlv_2= RULE_ID ) ) otherlv_3= ';'
            {
            otherlv_0=(Token)match(input,37,FOLLOW_33); 

            			newLeafNode(otherlv_0, grammarAccess.getCreateTableOperationAccess().getCreateKeyword_0());
            		
            otherlv_1=(Token)match(input,38,FOLLOW_3); 

            			newLeafNode(otherlv_1, grammarAccess.getCreateTableOperationAccess().getEmptyKeyword_1());
            		
            // InternalLts.g:1244:3: ( (otherlv_2= RULE_ID ) )
            // InternalLts.g:1245:4: (otherlv_2= RULE_ID )
            {
            // InternalLts.g:1245:4: (otherlv_2= RULE_ID )
            // InternalLts.g:1246:5: otherlv_2= RULE_ID
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getCreateTableOperationRule());
            					}
            				
            otherlv_2=(Token)match(input,RULE_ID,FOLLOW_19); 

            					newLeafNode(otherlv_2, grammarAccess.getCreateTableOperationAccess().getTableTableDeclarationCrossReference_2_0());
            				

            }


            }

            otherlv_3=(Token)match(input,24,FOLLOW_2); 

            			newLeafNode(otherlv_3, grammarAccess.getCreateTableOperationAccess().getSemicolonKeyword_3());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleCreateTableOperation"


    // $ANTLR start "entryRuleAppendRowsOperation"
    // InternalLts.g:1265:1: entryRuleAppendRowsOperation returns [EObject current=null] : iv_ruleAppendRowsOperation= ruleAppendRowsOperation EOF ;
    public final EObject entryRuleAppendRowsOperation() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAppendRowsOperation = null;


        try {
            // InternalLts.g:1265:60: (iv_ruleAppendRowsOperation= ruleAppendRowsOperation EOF )
            // InternalLts.g:1266:2: iv_ruleAppendRowsOperation= ruleAppendRowsOperation EOF
            {
             newCompositeNode(grammarAccess.getAppendRowsOperationRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleAppendRowsOperation=ruleAppendRowsOperation();

            state._fsp--;

             current =iv_ruleAppendRowsOperation; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleAppendRowsOperation"


    // $ANTLR start "ruleAppendRowsOperation"
    // InternalLts.g:1272:1: ruleAppendRowsOperation returns [EObject current=null] : (otherlv_0= 'append' otherlv_1= 'rows' otherlv_2= 'from' ( (otherlv_3= RULE_ID ) ) otherlv_4= 'to' ( (otherlv_5= RULE_ID ) ) (otherlv_6= 'map' otherlv_7= '{' ( (lv_mappings_8_0= ruleColumnAssignment ) )+ otherlv_9= '}' )? otherlv_10= ';' ) ;
    public final EObject ruleAppendRowsOperation() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token otherlv_5=null;
        Token otherlv_6=null;
        Token otherlv_7=null;
        Token otherlv_9=null;
        Token otherlv_10=null;
        EObject lv_mappings_8_0 = null;



        	enterRule();

        try {
            // InternalLts.g:1278:2: ( (otherlv_0= 'append' otherlv_1= 'rows' otherlv_2= 'from' ( (otherlv_3= RULE_ID ) ) otherlv_4= 'to' ( (otherlv_5= RULE_ID ) ) (otherlv_6= 'map' otherlv_7= '{' ( (lv_mappings_8_0= ruleColumnAssignment ) )+ otherlv_9= '}' )? otherlv_10= ';' ) )
            // InternalLts.g:1279:2: (otherlv_0= 'append' otherlv_1= 'rows' otherlv_2= 'from' ( (otherlv_3= RULE_ID ) ) otherlv_4= 'to' ( (otherlv_5= RULE_ID ) ) (otherlv_6= 'map' otherlv_7= '{' ( (lv_mappings_8_0= ruleColumnAssignment ) )+ otherlv_9= '}' )? otherlv_10= ';' )
            {
            // InternalLts.g:1279:2: (otherlv_0= 'append' otherlv_1= 'rows' otherlv_2= 'from' ( (otherlv_3= RULE_ID ) ) otherlv_4= 'to' ( (otherlv_5= RULE_ID ) ) (otherlv_6= 'map' otherlv_7= '{' ( (lv_mappings_8_0= ruleColumnAssignment ) )+ otherlv_9= '}' )? otherlv_10= ';' )
            // InternalLts.g:1280:3: otherlv_0= 'append' otherlv_1= 'rows' otherlv_2= 'from' ( (otherlv_3= RULE_ID ) ) otherlv_4= 'to' ( (otherlv_5= RULE_ID ) ) (otherlv_6= 'map' otherlv_7= '{' ( (lv_mappings_8_0= ruleColumnAssignment ) )+ otherlv_9= '}' )? otherlv_10= ';'
            {
            otherlv_0=(Token)match(input,39,FOLLOW_34); 

            			newLeafNode(otherlv_0, grammarAccess.getAppendRowsOperationAccess().getAppendKeyword_0());
            		
            otherlv_1=(Token)match(input,40,FOLLOW_8); 

            			newLeafNode(otherlv_1, grammarAccess.getAppendRowsOperationAccess().getRowsKeyword_1());
            		
            otherlv_2=(Token)match(input,16,FOLLOW_3); 

            			newLeafNode(otherlv_2, grammarAccess.getAppendRowsOperationAccess().getFromKeyword_2());
            		
            // InternalLts.g:1292:3: ( (otherlv_3= RULE_ID ) )
            // InternalLts.g:1293:4: (otherlv_3= RULE_ID )
            {
            // InternalLts.g:1293:4: (otherlv_3= RULE_ID )
            // InternalLts.g:1294:5: otherlv_3= RULE_ID
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getAppendRowsOperationRule());
            					}
            				
            otherlv_3=(Token)match(input,RULE_ID,FOLLOW_21); 

            					newLeafNode(otherlv_3, grammarAccess.getAppendRowsOperationAccess().getSourceTableDeclarationCrossReference_3_0());
            				

            }


            }

            otherlv_4=(Token)match(input,26,FOLLOW_3); 

            			newLeafNode(otherlv_4, grammarAccess.getAppendRowsOperationAccess().getToKeyword_4());
            		
            // InternalLts.g:1309:3: ( (otherlv_5= RULE_ID ) )
            // InternalLts.g:1310:4: (otherlv_5= RULE_ID )
            {
            // InternalLts.g:1310:4: (otherlv_5= RULE_ID )
            // InternalLts.g:1311:5: otherlv_5= RULE_ID
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getAppendRowsOperationRule());
            					}
            				
            otherlv_5=(Token)match(input,RULE_ID,FOLLOW_35); 

            					newLeafNode(otherlv_5, grammarAccess.getAppendRowsOperationAccess().getTargetTableDeclarationCrossReference_5_0());
            				

            }


            }

            // InternalLts.g:1322:3: (otherlv_6= 'map' otherlv_7= '{' ( (lv_mappings_8_0= ruleColumnAssignment ) )+ otherlv_9= '}' )?
            int alt17=2;
            int LA17_0 = input.LA(1);

            if ( (LA17_0==41) ) {
                alt17=1;
            }
            switch (alt17) {
                case 1 :
                    // InternalLts.g:1323:4: otherlv_6= 'map' otherlv_7= '{' ( (lv_mappings_8_0= ruleColumnAssignment ) )+ otherlv_9= '}'
                    {
                    otherlv_6=(Token)match(input,41,FOLLOW_4); 

                    				newLeafNode(otherlv_6, grammarAccess.getAppendRowsOperationAccess().getMapKeyword_6_0());
                    			
                    otherlv_7=(Token)match(input,12,FOLLOW_3); 

                    				newLeafNode(otherlv_7, grammarAccess.getAppendRowsOperationAccess().getLeftCurlyBracketKeyword_6_1());
                    			
                    // InternalLts.g:1331:4: ( (lv_mappings_8_0= ruleColumnAssignment ) )+
                    int cnt16=0;
                    loop16:
                    do {
                        int alt16=2;
                        int LA16_0 = input.LA(1);

                        if ( (LA16_0==RULE_ID) ) {
                            alt16=1;
                        }


                        switch (alt16) {
                    	case 1 :
                    	    // InternalLts.g:1332:5: (lv_mappings_8_0= ruleColumnAssignment )
                    	    {
                    	    // InternalLts.g:1332:5: (lv_mappings_8_0= ruleColumnAssignment )
                    	    // InternalLts.g:1333:6: lv_mappings_8_0= ruleColumnAssignment
                    	    {

                    	    						newCompositeNode(grammarAccess.getAppendRowsOperationAccess().getMappingsColumnAssignmentParserRuleCall_6_2_0());
                    	    					
                    	    pushFollow(FOLLOW_10);
                    	    lv_mappings_8_0=ruleColumnAssignment();

                    	    state._fsp--;


                    	    						if (current==null) {
                    	    							current = createModelElementForParent(grammarAccess.getAppendRowsOperationRule());
                    	    						}
                    	    						add(
                    	    							current,
                    	    							"mappings",
                    	    							lv_mappings_8_0,
                    	    							"org.example.lts.Lts.ColumnAssignment");
                    	    						afterParserOrEnumRuleCall();
                    	    					

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    if ( cnt16 >= 1 ) break loop16;
                                EarlyExitException eee =
                                    new EarlyExitException(16, input);
                                throw eee;
                        }
                        cnt16++;
                    } while (true);

                    otherlv_9=(Token)match(input,14,FOLLOW_19); 

                    				newLeafNode(otherlv_9, grammarAccess.getAppendRowsOperationAccess().getRightCurlyBracketKeyword_6_3());
                    			

                    }
                    break;

            }

            otherlv_10=(Token)match(input,24,FOLLOW_2); 

            			newLeafNode(otherlv_10, grammarAccess.getAppendRowsOperationAccess().getSemicolonKeyword_7());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleAppendRowsOperation"


    // $ANTLR start "entryRuleFilterOperation"
    // InternalLts.g:1363:1: entryRuleFilterOperation returns [EObject current=null] : iv_ruleFilterOperation= ruleFilterOperation EOF ;
    public final EObject entryRuleFilterOperation() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFilterOperation = null;


        try {
            // InternalLts.g:1363:56: (iv_ruleFilterOperation= ruleFilterOperation EOF )
            // InternalLts.g:1364:2: iv_ruleFilterOperation= ruleFilterOperation EOF
            {
             newCompositeNode(grammarAccess.getFilterOperationRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleFilterOperation=ruleFilterOperation();

            state._fsp--;

             current =iv_ruleFilterOperation; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleFilterOperation"


    // $ANTLR start "ruleFilterOperation"
    // InternalLts.g:1370:1: ruleFilterOperation returns [EObject current=null] : (otherlv_0= 'filter' ( (otherlv_1= RULE_ID ) ) otherlv_2= 'where' ( (lv_condition_3_0= ruleExpression ) ) otherlv_4= ';' ) ;
    public final EObject ruleFilterOperation() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject lv_condition_3_0 = null;



        	enterRule();

        try {
            // InternalLts.g:1376:2: ( (otherlv_0= 'filter' ( (otherlv_1= RULE_ID ) ) otherlv_2= 'where' ( (lv_condition_3_0= ruleExpression ) ) otherlv_4= ';' ) )
            // InternalLts.g:1377:2: (otherlv_0= 'filter' ( (otherlv_1= RULE_ID ) ) otherlv_2= 'where' ( (lv_condition_3_0= ruleExpression ) ) otherlv_4= ';' )
            {
            // InternalLts.g:1377:2: (otherlv_0= 'filter' ( (otherlv_1= RULE_ID ) ) otherlv_2= 'where' ( (lv_condition_3_0= ruleExpression ) ) otherlv_4= ';' )
            // InternalLts.g:1378:3: otherlv_0= 'filter' ( (otherlv_1= RULE_ID ) ) otherlv_2= 'where' ( (lv_condition_3_0= ruleExpression ) ) otherlv_4= ';'
            {
            otherlv_0=(Token)match(input,42,FOLLOW_3); 

            			newLeafNode(otherlv_0, grammarAccess.getFilterOperationAccess().getFilterKeyword_0());
            		
            // InternalLts.g:1382:3: ( (otherlv_1= RULE_ID ) )
            // InternalLts.g:1383:4: (otherlv_1= RULE_ID )
            {
            // InternalLts.g:1383:4: (otherlv_1= RULE_ID )
            // InternalLts.g:1384:5: otherlv_1= RULE_ID
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getFilterOperationRule());
            					}
            				
            otherlv_1=(Token)match(input,RULE_ID,FOLLOW_36); 

            					newLeafNode(otherlv_1, grammarAccess.getFilterOperationAccess().getTableTableDeclarationCrossReference_1_0());
            				

            }


            }

            otherlv_2=(Token)match(input,43,FOLLOW_37); 

            			newLeafNode(otherlv_2, grammarAccess.getFilterOperationAccess().getWhereKeyword_2());
            		
            // InternalLts.g:1399:3: ( (lv_condition_3_0= ruleExpression ) )
            // InternalLts.g:1400:4: (lv_condition_3_0= ruleExpression )
            {
            // InternalLts.g:1400:4: (lv_condition_3_0= ruleExpression )
            // InternalLts.g:1401:5: lv_condition_3_0= ruleExpression
            {

            					newCompositeNode(grammarAccess.getFilterOperationAccess().getConditionExpressionParserRuleCall_3_0());
            				
            pushFollow(FOLLOW_19);
            lv_condition_3_0=ruleExpression();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getFilterOperationRule());
            					}
            					set(
            						current,
            						"condition",
            						lv_condition_3_0,
            						"org.example.lts.Lts.Expression");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_4=(Token)match(input,24,FOLLOW_2); 

            			newLeafNode(otherlv_4, grammarAccess.getFilterOperationAccess().getSemicolonKeyword_4());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleFilterOperation"


    // $ANTLR start "entryRuleSortOperation"
    // InternalLts.g:1426:1: entryRuleSortOperation returns [EObject current=null] : iv_ruleSortOperation= ruleSortOperation EOF ;
    public final EObject entryRuleSortOperation() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSortOperation = null;


        try {
            // InternalLts.g:1426:54: (iv_ruleSortOperation= ruleSortOperation EOF )
            // InternalLts.g:1427:2: iv_ruleSortOperation= ruleSortOperation EOF
            {
             newCompositeNode(grammarAccess.getSortOperationRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleSortOperation=ruleSortOperation();

            state._fsp--;

             current =iv_ruleSortOperation; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleSortOperation"


    // $ANTLR start "ruleSortOperation"
    // InternalLts.g:1433:1: ruleSortOperation returns [EObject current=null] : (otherlv_0= 'sort' ( (otherlv_1= RULE_ID ) ) otherlv_2= 'by' ( (lv_keys_3_0= ruleSortKey ) ) (otherlv_4= ',' ( (lv_keys_5_0= ruleSortKey ) ) )* otherlv_6= ';' ) ;
    public final EObject ruleSortOperation() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        EObject lv_keys_3_0 = null;

        EObject lv_keys_5_0 = null;



        	enterRule();

        try {
            // InternalLts.g:1439:2: ( (otherlv_0= 'sort' ( (otherlv_1= RULE_ID ) ) otherlv_2= 'by' ( (lv_keys_3_0= ruleSortKey ) ) (otherlv_4= ',' ( (lv_keys_5_0= ruleSortKey ) ) )* otherlv_6= ';' ) )
            // InternalLts.g:1440:2: (otherlv_0= 'sort' ( (otherlv_1= RULE_ID ) ) otherlv_2= 'by' ( (lv_keys_3_0= ruleSortKey ) ) (otherlv_4= ',' ( (lv_keys_5_0= ruleSortKey ) ) )* otherlv_6= ';' )
            {
            // InternalLts.g:1440:2: (otherlv_0= 'sort' ( (otherlv_1= RULE_ID ) ) otherlv_2= 'by' ( (lv_keys_3_0= ruleSortKey ) ) (otherlv_4= ',' ( (lv_keys_5_0= ruleSortKey ) ) )* otherlv_6= ';' )
            // InternalLts.g:1441:3: otherlv_0= 'sort' ( (otherlv_1= RULE_ID ) ) otherlv_2= 'by' ( (lv_keys_3_0= ruleSortKey ) ) (otherlv_4= ',' ( (lv_keys_5_0= ruleSortKey ) ) )* otherlv_6= ';'
            {
            otherlv_0=(Token)match(input,44,FOLLOW_3); 

            			newLeafNode(otherlv_0, grammarAccess.getSortOperationAccess().getSortKeyword_0());
            		
            // InternalLts.g:1445:3: ( (otherlv_1= RULE_ID ) )
            // InternalLts.g:1446:4: (otherlv_1= RULE_ID )
            {
            // InternalLts.g:1446:4: (otherlv_1= RULE_ID )
            // InternalLts.g:1447:5: otherlv_1= RULE_ID
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getSortOperationRule());
            					}
            				
            otherlv_1=(Token)match(input,RULE_ID,FOLLOW_32); 

            					newLeafNode(otherlv_1, grammarAccess.getSortOperationAccess().getTableTableDeclarationCrossReference_1_0());
            				

            }


            }

            otherlv_2=(Token)match(input,35,FOLLOW_3); 

            			newLeafNode(otherlv_2, grammarAccess.getSortOperationAccess().getByKeyword_2());
            		
            // InternalLts.g:1462:3: ( (lv_keys_3_0= ruleSortKey ) )
            // InternalLts.g:1463:4: (lv_keys_3_0= ruleSortKey )
            {
            // InternalLts.g:1463:4: (lv_keys_3_0= ruleSortKey )
            // InternalLts.g:1464:5: lv_keys_3_0= ruleSortKey
            {

            					newCompositeNode(grammarAccess.getSortOperationAccess().getKeysSortKeyParserRuleCall_3_0());
            				
            pushFollow(FOLLOW_26);
            lv_keys_3_0=ruleSortKey();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getSortOperationRule());
            					}
            					add(
            						current,
            						"keys",
            						lv_keys_3_0,
            						"org.example.lts.Lts.SortKey");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalLts.g:1481:3: (otherlv_4= ',' ( (lv_keys_5_0= ruleSortKey ) ) )*
            loop18:
            do {
                int alt18=2;
                int LA18_0 = input.LA(1);

                if ( (LA18_0==29) ) {
                    alt18=1;
                }


                switch (alt18) {
            	case 1 :
            	    // InternalLts.g:1482:4: otherlv_4= ',' ( (lv_keys_5_0= ruleSortKey ) )
            	    {
            	    otherlv_4=(Token)match(input,29,FOLLOW_3); 

            	    				newLeafNode(otherlv_4, grammarAccess.getSortOperationAccess().getCommaKeyword_4_0());
            	    			
            	    // InternalLts.g:1486:4: ( (lv_keys_5_0= ruleSortKey ) )
            	    // InternalLts.g:1487:5: (lv_keys_5_0= ruleSortKey )
            	    {
            	    // InternalLts.g:1487:5: (lv_keys_5_0= ruleSortKey )
            	    // InternalLts.g:1488:6: lv_keys_5_0= ruleSortKey
            	    {

            	    						newCompositeNode(grammarAccess.getSortOperationAccess().getKeysSortKeyParserRuleCall_4_1_0());
            	    					
            	    pushFollow(FOLLOW_26);
            	    lv_keys_5_0=ruleSortKey();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getSortOperationRule());
            	    						}
            	    						add(
            	    							current,
            	    							"keys",
            	    							lv_keys_5_0,
            	    							"org.example.lts.Lts.SortKey");
            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop18;
                }
            } while (true);

            otherlv_6=(Token)match(input,24,FOLLOW_2); 

            			newLeafNode(otherlv_6, grammarAccess.getSortOperationAccess().getSemicolonKeyword_5());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleSortOperation"


    // $ANTLR start "entryRuleSortKey"
    // InternalLts.g:1514:1: entryRuleSortKey returns [EObject current=null] : iv_ruleSortKey= ruleSortKey EOF ;
    public final EObject entryRuleSortKey() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSortKey = null;


        try {
            // InternalLts.g:1514:48: (iv_ruleSortKey= ruleSortKey EOF )
            // InternalLts.g:1515:2: iv_ruleSortKey= ruleSortKey EOF
            {
             newCompositeNode(grammarAccess.getSortKeyRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleSortKey=ruleSortKey();

            state._fsp--;

             current =iv_ruleSortKey; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleSortKey"


    // $ANTLR start "ruleSortKey"
    // InternalLts.g:1521:1: ruleSortKey returns [EObject current=null] : ( ( (lv_column_0_0= ruleColumnReference ) ) ( (lv_direction_1_0= ruleSortDirection ) )? ) ;
    public final EObject ruleSortKey() throws RecognitionException {
        EObject current = null;

        EObject lv_column_0_0 = null;

        Enumerator lv_direction_1_0 = null;



        	enterRule();

        try {
            // InternalLts.g:1527:2: ( ( ( (lv_column_0_0= ruleColumnReference ) ) ( (lv_direction_1_0= ruleSortDirection ) )? ) )
            // InternalLts.g:1528:2: ( ( (lv_column_0_0= ruleColumnReference ) ) ( (lv_direction_1_0= ruleSortDirection ) )? )
            {
            // InternalLts.g:1528:2: ( ( (lv_column_0_0= ruleColumnReference ) ) ( (lv_direction_1_0= ruleSortDirection ) )? )
            // InternalLts.g:1529:3: ( (lv_column_0_0= ruleColumnReference ) ) ( (lv_direction_1_0= ruleSortDirection ) )?
            {
            // InternalLts.g:1529:3: ( (lv_column_0_0= ruleColumnReference ) )
            // InternalLts.g:1530:4: (lv_column_0_0= ruleColumnReference )
            {
            // InternalLts.g:1530:4: (lv_column_0_0= ruleColumnReference )
            // InternalLts.g:1531:5: lv_column_0_0= ruleColumnReference
            {

            					newCompositeNode(grammarAccess.getSortKeyAccess().getColumnColumnReferenceParserRuleCall_0_0());
            				
            pushFollow(FOLLOW_38);
            lv_column_0_0=ruleColumnReference();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getSortKeyRule());
            					}
            					set(
            						current,
            						"column",
            						lv_column_0_0,
            						"org.example.lts.Lts.ColumnReference");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalLts.g:1548:3: ( (lv_direction_1_0= ruleSortDirection ) )?
            int alt19=2;
            int LA19_0 = input.LA(1);

            if ( ((LA19_0>=84 && LA19_0<=85)) ) {
                alt19=1;
            }
            switch (alt19) {
                case 1 :
                    // InternalLts.g:1549:4: (lv_direction_1_0= ruleSortDirection )
                    {
                    // InternalLts.g:1549:4: (lv_direction_1_0= ruleSortDirection )
                    // InternalLts.g:1550:5: lv_direction_1_0= ruleSortDirection
                    {

                    					newCompositeNode(grammarAccess.getSortKeyAccess().getDirectionSortDirectionEnumRuleCall_1_0());
                    				
                    pushFollow(FOLLOW_2);
                    lv_direction_1_0=ruleSortDirection();

                    state._fsp--;


                    					if (current==null) {
                    						current = createModelElementForParent(grammarAccess.getSortKeyRule());
                    					}
                    					set(
                    						current,
                    						"direction",
                    						lv_direction_1_0,
                    						"org.example.lts.Lts.SortDirection");
                    					afterParserOrEnumRuleCall();
                    				

                    }


                    }
                    break;

            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleSortKey"


    // $ANTLR start "entryRuleGroupOperation"
    // InternalLts.g:1571:1: entryRuleGroupOperation returns [EObject current=null] : iv_ruleGroupOperation= ruleGroupOperation EOF ;
    public final EObject entryRuleGroupOperation() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleGroupOperation = null;


        try {
            // InternalLts.g:1571:55: (iv_ruleGroupOperation= ruleGroupOperation EOF )
            // InternalLts.g:1572:2: iv_ruleGroupOperation= ruleGroupOperation EOF
            {
             newCompositeNode(grammarAccess.getGroupOperationRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleGroupOperation=ruleGroupOperation();

            state._fsp--;

             current =iv_ruleGroupOperation; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleGroupOperation"


    // $ANTLR start "ruleGroupOperation"
    // InternalLts.g:1578:1: ruleGroupOperation returns [EObject current=null] : (otherlv_0= 'group' ( (otherlv_1= RULE_ID ) ) otherlv_2= 'into' ( (otherlv_3= RULE_ID ) ) otherlv_4= 'by' ( (lv_keys_5_0= ruleColumnReference ) ) (otherlv_6= ',' ( (lv_keys_7_0= ruleColumnReference ) ) )* otherlv_8= 'aggregate' otherlv_9= '{' ( (lv_aggregations_10_0= ruleColumnAssignment ) )+ otherlv_11= '}' otherlv_12= ';' ) ;
    public final EObject ruleGroupOperation() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        Token otherlv_8=null;
        Token otherlv_9=null;
        Token otherlv_11=null;
        Token otherlv_12=null;
        EObject lv_keys_5_0 = null;

        EObject lv_keys_7_0 = null;

        EObject lv_aggregations_10_0 = null;



        	enterRule();

        try {
            // InternalLts.g:1584:2: ( (otherlv_0= 'group' ( (otherlv_1= RULE_ID ) ) otherlv_2= 'into' ( (otherlv_3= RULE_ID ) ) otherlv_4= 'by' ( (lv_keys_5_0= ruleColumnReference ) ) (otherlv_6= ',' ( (lv_keys_7_0= ruleColumnReference ) ) )* otherlv_8= 'aggregate' otherlv_9= '{' ( (lv_aggregations_10_0= ruleColumnAssignment ) )+ otherlv_11= '}' otherlv_12= ';' ) )
            // InternalLts.g:1585:2: (otherlv_0= 'group' ( (otherlv_1= RULE_ID ) ) otherlv_2= 'into' ( (otherlv_3= RULE_ID ) ) otherlv_4= 'by' ( (lv_keys_5_0= ruleColumnReference ) ) (otherlv_6= ',' ( (lv_keys_7_0= ruleColumnReference ) ) )* otherlv_8= 'aggregate' otherlv_9= '{' ( (lv_aggregations_10_0= ruleColumnAssignment ) )+ otherlv_11= '}' otherlv_12= ';' )
            {
            // InternalLts.g:1585:2: (otherlv_0= 'group' ( (otherlv_1= RULE_ID ) ) otherlv_2= 'into' ( (otherlv_3= RULE_ID ) ) otherlv_4= 'by' ( (lv_keys_5_0= ruleColumnReference ) ) (otherlv_6= ',' ( (lv_keys_7_0= ruleColumnReference ) ) )* otherlv_8= 'aggregate' otherlv_9= '{' ( (lv_aggregations_10_0= ruleColumnAssignment ) )+ otherlv_11= '}' otherlv_12= ';' )
            // InternalLts.g:1586:3: otherlv_0= 'group' ( (otherlv_1= RULE_ID ) ) otherlv_2= 'into' ( (otherlv_3= RULE_ID ) ) otherlv_4= 'by' ( (lv_keys_5_0= ruleColumnReference ) ) (otherlv_6= ',' ( (lv_keys_7_0= ruleColumnReference ) ) )* otherlv_8= 'aggregate' otherlv_9= '{' ( (lv_aggregations_10_0= ruleColumnAssignment ) )+ otherlv_11= '}' otherlv_12= ';'
            {
            otherlv_0=(Token)match(input,45,FOLLOW_3); 

            			newLeafNode(otherlv_0, grammarAccess.getGroupOperationAccess().getGroupKeyword_0());
            		
            // InternalLts.g:1590:3: ( (otherlv_1= RULE_ID ) )
            // InternalLts.g:1591:4: (otherlv_1= RULE_ID )
            {
            // InternalLts.g:1591:4: (otherlv_1= RULE_ID )
            // InternalLts.g:1592:5: otherlv_1= RULE_ID
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getGroupOperationRule());
            					}
            				
            otherlv_1=(Token)match(input,RULE_ID,FOLLOW_39); 

            					newLeafNode(otherlv_1, grammarAccess.getGroupOperationAccess().getSourceTableDeclarationCrossReference_1_0());
            				

            }


            }

            otherlv_2=(Token)match(input,46,FOLLOW_3); 

            			newLeafNode(otherlv_2, grammarAccess.getGroupOperationAccess().getIntoKeyword_2());
            		
            // InternalLts.g:1607:3: ( (otherlv_3= RULE_ID ) )
            // InternalLts.g:1608:4: (otherlv_3= RULE_ID )
            {
            // InternalLts.g:1608:4: (otherlv_3= RULE_ID )
            // InternalLts.g:1609:5: otherlv_3= RULE_ID
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getGroupOperationRule());
            					}
            				
            otherlv_3=(Token)match(input,RULE_ID,FOLLOW_32); 

            					newLeafNode(otherlv_3, grammarAccess.getGroupOperationAccess().getTargetTableDeclarationCrossReference_3_0());
            				

            }


            }

            otherlv_4=(Token)match(input,35,FOLLOW_3); 

            			newLeafNode(otherlv_4, grammarAccess.getGroupOperationAccess().getByKeyword_4());
            		
            // InternalLts.g:1624:3: ( (lv_keys_5_0= ruleColumnReference ) )
            // InternalLts.g:1625:4: (lv_keys_5_0= ruleColumnReference )
            {
            // InternalLts.g:1625:4: (lv_keys_5_0= ruleColumnReference )
            // InternalLts.g:1626:5: lv_keys_5_0= ruleColumnReference
            {

            					newCompositeNode(grammarAccess.getGroupOperationAccess().getKeysColumnReferenceParserRuleCall_5_0());
            				
            pushFollow(FOLLOW_40);
            lv_keys_5_0=ruleColumnReference();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getGroupOperationRule());
            					}
            					add(
            						current,
            						"keys",
            						lv_keys_5_0,
            						"org.example.lts.Lts.ColumnReference");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalLts.g:1643:3: (otherlv_6= ',' ( (lv_keys_7_0= ruleColumnReference ) ) )*
            loop20:
            do {
                int alt20=2;
                int LA20_0 = input.LA(1);

                if ( (LA20_0==29) ) {
                    alt20=1;
                }


                switch (alt20) {
            	case 1 :
            	    // InternalLts.g:1644:4: otherlv_6= ',' ( (lv_keys_7_0= ruleColumnReference ) )
            	    {
            	    otherlv_6=(Token)match(input,29,FOLLOW_3); 

            	    				newLeafNode(otherlv_6, grammarAccess.getGroupOperationAccess().getCommaKeyword_6_0());
            	    			
            	    // InternalLts.g:1648:4: ( (lv_keys_7_0= ruleColumnReference ) )
            	    // InternalLts.g:1649:5: (lv_keys_7_0= ruleColumnReference )
            	    {
            	    // InternalLts.g:1649:5: (lv_keys_7_0= ruleColumnReference )
            	    // InternalLts.g:1650:6: lv_keys_7_0= ruleColumnReference
            	    {

            	    						newCompositeNode(grammarAccess.getGroupOperationAccess().getKeysColumnReferenceParserRuleCall_6_1_0());
            	    					
            	    pushFollow(FOLLOW_40);
            	    lv_keys_7_0=ruleColumnReference();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getGroupOperationRule());
            	    						}
            	    						add(
            	    							current,
            	    							"keys",
            	    							lv_keys_7_0,
            	    							"org.example.lts.Lts.ColumnReference");
            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop20;
                }
            } while (true);

            otherlv_8=(Token)match(input,47,FOLLOW_4); 

            			newLeafNode(otherlv_8, grammarAccess.getGroupOperationAccess().getAggregateKeyword_7());
            		
            otherlv_9=(Token)match(input,12,FOLLOW_3); 

            			newLeafNode(otherlv_9, grammarAccess.getGroupOperationAccess().getLeftCurlyBracketKeyword_8());
            		
            // InternalLts.g:1676:3: ( (lv_aggregations_10_0= ruleColumnAssignment ) )+
            int cnt21=0;
            loop21:
            do {
                int alt21=2;
                int LA21_0 = input.LA(1);

                if ( (LA21_0==RULE_ID) ) {
                    alt21=1;
                }


                switch (alt21) {
            	case 1 :
            	    // InternalLts.g:1677:4: (lv_aggregations_10_0= ruleColumnAssignment )
            	    {
            	    // InternalLts.g:1677:4: (lv_aggregations_10_0= ruleColumnAssignment )
            	    // InternalLts.g:1678:5: lv_aggregations_10_0= ruleColumnAssignment
            	    {

            	    					newCompositeNode(grammarAccess.getGroupOperationAccess().getAggregationsColumnAssignmentParserRuleCall_9_0());
            	    				
            	    pushFollow(FOLLOW_10);
            	    lv_aggregations_10_0=ruleColumnAssignment();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getGroupOperationRule());
            	    					}
            	    					add(
            	    						current,
            	    						"aggregations",
            	    						lv_aggregations_10_0,
            	    						"org.example.lts.Lts.ColumnAssignment");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt21 >= 1 ) break loop21;
                        EarlyExitException eee =
                            new EarlyExitException(21, input);
                        throw eee;
                }
                cnt21++;
            } while (true);

            otherlv_11=(Token)match(input,14,FOLLOW_19); 

            			newLeafNode(otherlv_11, grammarAccess.getGroupOperationAccess().getRightCurlyBracketKeyword_10());
            		
            otherlv_12=(Token)match(input,24,FOLLOW_2); 

            			newLeafNode(otherlv_12, grammarAccess.getGroupOperationAccess().getSemicolonKeyword_11());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleGroupOperation"


    // $ANTLR start "entryRuleAggregateOperation"
    // InternalLts.g:1707:1: entryRuleAggregateOperation returns [EObject current=null] : iv_ruleAggregateOperation= ruleAggregateOperation EOF ;
    public final EObject entryRuleAggregateOperation() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAggregateOperation = null;


        try {
            // InternalLts.g:1707:59: (iv_ruleAggregateOperation= ruleAggregateOperation EOF )
            // InternalLts.g:1708:2: iv_ruleAggregateOperation= ruleAggregateOperation EOF
            {
             newCompositeNode(grammarAccess.getAggregateOperationRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleAggregateOperation=ruleAggregateOperation();

            state._fsp--;

             current =iv_ruleAggregateOperation; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleAggregateOperation"


    // $ANTLR start "ruleAggregateOperation"
    // InternalLts.g:1714:1: ruleAggregateOperation returns [EObject current=null] : (otherlv_0= 'aggregate' ( (otherlv_1= RULE_ID ) ) otherlv_2= 'into' ( (otherlv_3= RULE_ID ) ) (otherlv_4= 'by' ( (lv_keys_5_0= ruleColumnReference ) ) (otherlv_6= ',' ( (lv_keys_7_0= ruleColumnReference ) ) )* )? otherlv_8= 'compute' otherlv_9= '{' ( (lv_aggregations_10_0= ruleColumnAssignment ) )+ otherlv_11= '}' otherlv_12= ';' ) ;
    public final EObject ruleAggregateOperation() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        Token otherlv_8=null;
        Token otherlv_9=null;
        Token otherlv_11=null;
        Token otherlv_12=null;
        EObject lv_keys_5_0 = null;

        EObject lv_keys_7_0 = null;

        EObject lv_aggregations_10_0 = null;



        	enterRule();

        try {
            // InternalLts.g:1720:2: ( (otherlv_0= 'aggregate' ( (otherlv_1= RULE_ID ) ) otherlv_2= 'into' ( (otherlv_3= RULE_ID ) ) (otherlv_4= 'by' ( (lv_keys_5_0= ruleColumnReference ) ) (otherlv_6= ',' ( (lv_keys_7_0= ruleColumnReference ) ) )* )? otherlv_8= 'compute' otherlv_9= '{' ( (lv_aggregations_10_0= ruleColumnAssignment ) )+ otherlv_11= '}' otherlv_12= ';' ) )
            // InternalLts.g:1721:2: (otherlv_0= 'aggregate' ( (otherlv_1= RULE_ID ) ) otherlv_2= 'into' ( (otherlv_3= RULE_ID ) ) (otherlv_4= 'by' ( (lv_keys_5_0= ruleColumnReference ) ) (otherlv_6= ',' ( (lv_keys_7_0= ruleColumnReference ) ) )* )? otherlv_8= 'compute' otherlv_9= '{' ( (lv_aggregations_10_0= ruleColumnAssignment ) )+ otherlv_11= '}' otherlv_12= ';' )
            {
            // InternalLts.g:1721:2: (otherlv_0= 'aggregate' ( (otherlv_1= RULE_ID ) ) otherlv_2= 'into' ( (otherlv_3= RULE_ID ) ) (otherlv_4= 'by' ( (lv_keys_5_0= ruleColumnReference ) ) (otherlv_6= ',' ( (lv_keys_7_0= ruleColumnReference ) ) )* )? otherlv_8= 'compute' otherlv_9= '{' ( (lv_aggregations_10_0= ruleColumnAssignment ) )+ otherlv_11= '}' otherlv_12= ';' )
            // InternalLts.g:1722:3: otherlv_0= 'aggregate' ( (otherlv_1= RULE_ID ) ) otherlv_2= 'into' ( (otherlv_3= RULE_ID ) ) (otherlv_4= 'by' ( (lv_keys_5_0= ruleColumnReference ) ) (otherlv_6= ',' ( (lv_keys_7_0= ruleColumnReference ) ) )* )? otherlv_8= 'compute' otherlv_9= '{' ( (lv_aggregations_10_0= ruleColumnAssignment ) )+ otherlv_11= '}' otherlv_12= ';'
            {
            otherlv_0=(Token)match(input,47,FOLLOW_3); 

            			newLeafNode(otherlv_0, grammarAccess.getAggregateOperationAccess().getAggregateKeyword_0());
            		
            // InternalLts.g:1726:3: ( (otherlv_1= RULE_ID ) )
            // InternalLts.g:1727:4: (otherlv_1= RULE_ID )
            {
            // InternalLts.g:1727:4: (otherlv_1= RULE_ID )
            // InternalLts.g:1728:5: otherlv_1= RULE_ID
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getAggregateOperationRule());
            					}
            				
            otherlv_1=(Token)match(input,RULE_ID,FOLLOW_39); 

            					newLeafNode(otherlv_1, grammarAccess.getAggregateOperationAccess().getSourceTableDeclarationCrossReference_1_0());
            				

            }


            }

            otherlv_2=(Token)match(input,46,FOLLOW_3); 

            			newLeafNode(otherlv_2, grammarAccess.getAggregateOperationAccess().getIntoKeyword_2());
            		
            // InternalLts.g:1743:3: ( (otherlv_3= RULE_ID ) )
            // InternalLts.g:1744:4: (otherlv_3= RULE_ID )
            {
            // InternalLts.g:1744:4: (otherlv_3= RULE_ID )
            // InternalLts.g:1745:5: otherlv_3= RULE_ID
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getAggregateOperationRule());
            					}
            				
            otherlv_3=(Token)match(input,RULE_ID,FOLLOW_41); 

            					newLeafNode(otherlv_3, grammarAccess.getAggregateOperationAccess().getTargetTableDeclarationCrossReference_3_0());
            				

            }


            }

            // InternalLts.g:1756:3: (otherlv_4= 'by' ( (lv_keys_5_0= ruleColumnReference ) ) (otherlv_6= ',' ( (lv_keys_7_0= ruleColumnReference ) ) )* )?
            int alt23=2;
            int LA23_0 = input.LA(1);

            if ( (LA23_0==35) ) {
                alt23=1;
            }
            switch (alt23) {
                case 1 :
                    // InternalLts.g:1757:4: otherlv_4= 'by' ( (lv_keys_5_0= ruleColumnReference ) ) (otherlv_6= ',' ( (lv_keys_7_0= ruleColumnReference ) ) )*
                    {
                    otherlv_4=(Token)match(input,35,FOLLOW_3); 

                    				newLeafNode(otherlv_4, grammarAccess.getAggregateOperationAccess().getByKeyword_4_0());
                    			
                    // InternalLts.g:1761:4: ( (lv_keys_5_0= ruleColumnReference ) )
                    // InternalLts.g:1762:5: (lv_keys_5_0= ruleColumnReference )
                    {
                    // InternalLts.g:1762:5: (lv_keys_5_0= ruleColumnReference )
                    // InternalLts.g:1763:6: lv_keys_5_0= ruleColumnReference
                    {

                    						newCompositeNode(grammarAccess.getAggregateOperationAccess().getKeysColumnReferenceParserRuleCall_4_1_0());
                    					
                    pushFollow(FOLLOW_42);
                    lv_keys_5_0=ruleColumnReference();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getAggregateOperationRule());
                    						}
                    						add(
                    							current,
                    							"keys",
                    							lv_keys_5_0,
                    							"org.example.lts.Lts.ColumnReference");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    // InternalLts.g:1780:4: (otherlv_6= ',' ( (lv_keys_7_0= ruleColumnReference ) ) )*
                    loop22:
                    do {
                        int alt22=2;
                        int LA22_0 = input.LA(1);

                        if ( (LA22_0==29) ) {
                            alt22=1;
                        }


                        switch (alt22) {
                    	case 1 :
                    	    // InternalLts.g:1781:5: otherlv_6= ',' ( (lv_keys_7_0= ruleColumnReference ) )
                    	    {
                    	    otherlv_6=(Token)match(input,29,FOLLOW_3); 

                    	    					newLeafNode(otherlv_6, grammarAccess.getAggregateOperationAccess().getCommaKeyword_4_2_0());
                    	    				
                    	    // InternalLts.g:1785:5: ( (lv_keys_7_0= ruleColumnReference ) )
                    	    // InternalLts.g:1786:6: (lv_keys_7_0= ruleColumnReference )
                    	    {
                    	    // InternalLts.g:1786:6: (lv_keys_7_0= ruleColumnReference )
                    	    // InternalLts.g:1787:7: lv_keys_7_0= ruleColumnReference
                    	    {

                    	    							newCompositeNode(grammarAccess.getAggregateOperationAccess().getKeysColumnReferenceParserRuleCall_4_2_1_0());
                    	    						
                    	    pushFollow(FOLLOW_42);
                    	    lv_keys_7_0=ruleColumnReference();

                    	    state._fsp--;


                    	    							if (current==null) {
                    	    								current = createModelElementForParent(grammarAccess.getAggregateOperationRule());
                    	    							}
                    	    							add(
                    	    								current,
                    	    								"keys",
                    	    								lv_keys_7_0,
                    	    								"org.example.lts.Lts.ColumnReference");
                    	    							afterParserOrEnumRuleCall();
                    	    						

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop22;
                        }
                    } while (true);


                    }
                    break;

            }

            otherlv_8=(Token)match(input,48,FOLLOW_4); 

            			newLeafNode(otherlv_8, grammarAccess.getAggregateOperationAccess().getComputeKeyword_5());
            		
            otherlv_9=(Token)match(input,12,FOLLOW_3); 

            			newLeafNode(otherlv_9, grammarAccess.getAggregateOperationAccess().getLeftCurlyBracketKeyword_6());
            		
            // InternalLts.g:1814:3: ( (lv_aggregations_10_0= ruleColumnAssignment ) )+
            int cnt24=0;
            loop24:
            do {
                int alt24=2;
                int LA24_0 = input.LA(1);

                if ( (LA24_0==RULE_ID) ) {
                    alt24=1;
                }


                switch (alt24) {
            	case 1 :
            	    // InternalLts.g:1815:4: (lv_aggregations_10_0= ruleColumnAssignment )
            	    {
            	    // InternalLts.g:1815:4: (lv_aggregations_10_0= ruleColumnAssignment )
            	    // InternalLts.g:1816:5: lv_aggregations_10_0= ruleColumnAssignment
            	    {

            	    					newCompositeNode(grammarAccess.getAggregateOperationAccess().getAggregationsColumnAssignmentParserRuleCall_7_0());
            	    				
            	    pushFollow(FOLLOW_10);
            	    lv_aggregations_10_0=ruleColumnAssignment();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getAggregateOperationRule());
            	    					}
            	    					add(
            	    						current,
            	    						"aggregations",
            	    						lv_aggregations_10_0,
            	    						"org.example.lts.Lts.ColumnAssignment");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt24 >= 1 ) break loop24;
                        EarlyExitException eee =
                            new EarlyExitException(24, input);
                        throw eee;
                }
                cnt24++;
            } while (true);

            otherlv_11=(Token)match(input,14,FOLLOW_19); 

            			newLeafNode(otherlv_11, grammarAccess.getAggregateOperationAccess().getRightCurlyBracketKeyword_8());
            		
            otherlv_12=(Token)match(input,24,FOLLOW_2); 

            			newLeafNode(otherlv_12, grammarAccess.getAggregateOperationAccess().getSemicolonKeyword_9());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleAggregateOperation"


    // $ANTLR start "entryRuleJoinOperation"
    // InternalLts.g:1845:1: entryRuleJoinOperation returns [EObject current=null] : iv_ruleJoinOperation= ruleJoinOperation EOF ;
    public final EObject entryRuleJoinOperation() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleJoinOperation = null;


        try {
            // InternalLts.g:1845:54: (iv_ruleJoinOperation= ruleJoinOperation EOF )
            // InternalLts.g:1846:2: iv_ruleJoinOperation= ruleJoinOperation EOF
            {
             newCompositeNode(grammarAccess.getJoinOperationRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleJoinOperation=ruleJoinOperation();

            state._fsp--;

             current =iv_ruleJoinOperation; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleJoinOperation"


    // $ANTLR start "ruleJoinOperation"
    // InternalLts.g:1852:1: ruleJoinOperation returns [EObject current=null] : (otherlv_0= 'join' ( (otherlv_1= RULE_ID ) ) ( (lv_kind_2_0= ruleJoinKind ) )? otherlv_3= 'with' ( (otherlv_4= RULE_ID ) ) otherlv_5= 'on' ( (lv_condition_6_0= ruleExpression ) ) (otherlv_7= 'select' otherlv_8= '{' ( (lv_selections_9_0= ruleColumnAssignment ) )+ otherlv_10= '}' )? (otherlv_11= 'aggregate' otherlv_12= '{' ( (lv_aggregations_13_0= ruleColumnAssignment ) )+ otherlv_14= '}' )? otherlv_15= ';' ) ;
    public final EObject ruleJoinOperation() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        Token otherlv_8=null;
        Token otherlv_10=null;
        Token otherlv_11=null;
        Token otherlv_12=null;
        Token otherlv_14=null;
        Token otherlv_15=null;
        Enumerator lv_kind_2_0 = null;

        EObject lv_condition_6_0 = null;

        EObject lv_selections_9_0 = null;

        EObject lv_aggregations_13_0 = null;



        	enterRule();

        try {
            // InternalLts.g:1858:2: ( (otherlv_0= 'join' ( (otherlv_1= RULE_ID ) ) ( (lv_kind_2_0= ruleJoinKind ) )? otherlv_3= 'with' ( (otherlv_4= RULE_ID ) ) otherlv_5= 'on' ( (lv_condition_6_0= ruleExpression ) ) (otherlv_7= 'select' otherlv_8= '{' ( (lv_selections_9_0= ruleColumnAssignment ) )+ otherlv_10= '}' )? (otherlv_11= 'aggregate' otherlv_12= '{' ( (lv_aggregations_13_0= ruleColumnAssignment ) )+ otherlv_14= '}' )? otherlv_15= ';' ) )
            // InternalLts.g:1859:2: (otherlv_0= 'join' ( (otherlv_1= RULE_ID ) ) ( (lv_kind_2_0= ruleJoinKind ) )? otherlv_3= 'with' ( (otherlv_4= RULE_ID ) ) otherlv_5= 'on' ( (lv_condition_6_0= ruleExpression ) ) (otherlv_7= 'select' otherlv_8= '{' ( (lv_selections_9_0= ruleColumnAssignment ) )+ otherlv_10= '}' )? (otherlv_11= 'aggregate' otherlv_12= '{' ( (lv_aggregations_13_0= ruleColumnAssignment ) )+ otherlv_14= '}' )? otherlv_15= ';' )
            {
            // InternalLts.g:1859:2: (otherlv_0= 'join' ( (otherlv_1= RULE_ID ) ) ( (lv_kind_2_0= ruleJoinKind ) )? otherlv_3= 'with' ( (otherlv_4= RULE_ID ) ) otherlv_5= 'on' ( (lv_condition_6_0= ruleExpression ) ) (otherlv_7= 'select' otherlv_8= '{' ( (lv_selections_9_0= ruleColumnAssignment ) )+ otherlv_10= '}' )? (otherlv_11= 'aggregate' otherlv_12= '{' ( (lv_aggregations_13_0= ruleColumnAssignment ) )+ otherlv_14= '}' )? otherlv_15= ';' )
            // InternalLts.g:1860:3: otherlv_0= 'join' ( (otherlv_1= RULE_ID ) ) ( (lv_kind_2_0= ruleJoinKind ) )? otherlv_3= 'with' ( (otherlv_4= RULE_ID ) ) otherlv_5= 'on' ( (lv_condition_6_0= ruleExpression ) ) (otherlv_7= 'select' otherlv_8= '{' ( (lv_selections_9_0= ruleColumnAssignment ) )+ otherlv_10= '}' )? (otherlv_11= 'aggregate' otherlv_12= '{' ( (lv_aggregations_13_0= ruleColumnAssignment ) )+ otherlv_14= '}' )? otherlv_15= ';'
            {
            otherlv_0=(Token)match(input,49,FOLLOW_3); 

            			newLeafNode(otherlv_0, grammarAccess.getJoinOperationAccess().getJoinKeyword_0());
            		
            // InternalLts.g:1864:3: ( (otherlv_1= RULE_ID ) )
            // InternalLts.g:1865:4: (otherlv_1= RULE_ID )
            {
            // InternalLts.g:1865:4: (otherlv_1= RULE_ID )
            // InternalLts.g:1866:5: otherlv_1= RULE_ID
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getJoinOperationRule());
            					}
            				
            otherlv_1=(Token)match(input,RULE_ID,FOLLOW_43); 

            					newLeafNode(otherlv_1, grammarAccess.getJoinOperationAccess().getTargetTableDeclarationCrossReference_1_0());
            				

            }


            }

            // InternalLts.g:1877:3: ( (lv_kind_2_0= ruleJoinKind ) )?
            int alt25=2;
            int LA25_0 = input.LA(1);

            if ( ((LA25_0>=86 && LA25_0<=87)) ) {
                alt25=1;
            }
            switch (alt25) {
                case 1 :
                    // InternalLts.g:1878:4: (lv_kind_2_0= ruleJoinKind )
                    {
                    // InternalLts.g:1878:4: (lv_kind_2_0= ruleJoinKind )
                    // InternalLts.g:1879:5: lv_kind_2_0= ruleJoinKind
                    {

                    					newCompositeNode(grammarAccess.getJoinOperationAccess().getKindJoinKindEnumRuleCall_2_0());
                    				
                    pushFollow(FOLLOW_44);
                    lv_kind_2_0=ruleJoinKind();

                    state._fsp--;


                    					if (current==null) {
                    						current = createModelElementForParent(grammarAccess.getJoinOperationRule());
                    					}
                    					set(
                    						current,
                    						"kind",
                    						lv_kind_2_0,
                    						"org.example.lts.Lts.JoinKind");
                    					afterParserOrEnumRuleCall();
                    				

                    }


                    }
                    break;

            }

            otherlv_3=(Token)match(input,50,FOLLOW_3); 

            			newLeafNode(otherlv_3, grammarAccess.getJoinOperationAccess().getWithKeyword_3());
            		
            // InternalLts.g:1900:3: ( (otherlv_4= RULE_ID ) )
            // InternalLts.g:1901:4: (otherlv_4= RULE_ID )
            {
            // InternalLts.g:1901:4: (otherlv_4= RULE_ID )
            // InternalLts.g:1902:5: otherlv_4= RULE_ID
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getJoinOperationRule());
            					}
            				
            otherlv_4=(Token)match(input,RULE_ID,FOLLOW_45); 

            					newLeafNode(otherlv_4, grammarAccess.getJoinOperationAccess().getSourceTableDeclarationCrossReference_4_0());
            				

            }


            }

            otherlv_5=(Token)match(input,51,FOLLOW_37); 

            			newLeafNode(otherlv_5, grammarAccess.getJoinOperationAccess().getOnKeyword_5());
            		
            // InternalLts.g:1917:3: ( (lv_condition_6_0= ruleExpression ) )
            // InternalLts.g:1918:4: (lv_condition_6_0= ruleExpression )
            {
            // InternalLts.g:1918:4: (lv_condition_6_0= ruleExpression )
            // InternalLts.g:1919:5: lv_condition_6_0= ruleExpression
            {

            					newCompositeNode(grammarAccess.getJoinOperationAccess().getConditionExpressionParserRuleCall_6_0());
            				
            pushFollow(FOLLOW_46);
            lv_condition_6_0=ruleExpression();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getJoinOperationRule());
            					}
            					set(
            						current,
            						"condition",
            						lv_condition_6_0,
            						"org.example.lts.Lts.Expression");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalLts.g:1936:3: (otherlv_7= 'select' otherlv_8= '{' ( (lv_selections_9_0= ruleColumnAssignment ) )+ otherlv_10= '}' )?
            int alt27=2;
            int LA27_0 = input.LA(1);

            if ( (LA27_0==52) ) {
                alt27=1;
            }
            switch (alt27) {
                case 1 :
                    // InternalLts.g:1937:4: otherlv_7= 'select' otherlv_8= '{' ( (lv_selections_9_0= ruleColumnAssignment ) )+ otherlv_10= '}'
                    {
                    otherlv_7=(Token)match(input,52,FOLLOW_4); 

                    				newLeafNode(otherlv_7, grammarAccess.getJoinOperationAccess().getSelectKeyword_7_0());
                    			
                    otherlv_8=(Token)match(input,12,FOLLOW_3); 

                    				newLeafNode(otherlv_8, grammarAccess.getJoinOperationAccess().getLeftCurlyBracketKeyword_7_1());
                    			
                    // InternalLts.g:1945:4: ( (lv_selections_9_0= ruleColumnAssignment ) )+
                    int cnt26=0;
                    loop26:
                    do {
                        int alt26=2;
                        int LA26_0 = input.LA(1);

                        if ( (LA26_0==RULE_ID) ) {
                            alt26=1;
                        }


                        switch (alt26) {
                    	case 1 :
                    	    // InternalLts.g:1946:5: (lv_selections_9_0= ruleColumnAssignment )
                    	    {
                    	    // InternalLts.g:1946:5: (lv_selections_9_0= ruleColumnAssignment )
                    	    // InternalLts.g:1947:6: lv_selections_9_0= ruleColumnAssignment
                    	    {

                    	    						newCompositeNode(grammarAccess.getJoinOperationAccess().getSelectionsColumnAssignmentParserRuleCall_7_2_0());
                    	    					
                    	    pushFollow(FOLLOW_10);
                    	    lv_selections_9_0=ruleColumnAssignment();

                    	    state._fsp--;


                    	    						if (current==null) {
                    	    							current = createModelElementForParent(grammarAccess.getJoinOperationRule());
                    	    						}
                    	    						add(
                    	    							current,
                    	    							"selections",
                    	    							lv_selections_9_0,
                    	    							"org.example.lts.Lts.ColumnAssignment");
                    	    						afterParserOrEnumRuleCall();
                    	    					

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    if ( cnt26 >= 1 ) break loop26;
                                EarlyExitException eee =
                                    new EarlyExitException(26, input);
                                throw eee;
                        }
                        cnt26++;
                    } while (true);

                    otherlv_10=(Token)match(input,14,FOLLOW_47); 

                    				newLeafNode(otherlv_10, grammarAccess.getJoinOperationAccess().getRightCurlyBracketKeyword_7_3());
                    			

                    }
                    break;

            }

            // InternalLts.g:1969:3: (otherlv_11= 'aggregate' otherlv_12= '{' ( (lv_aggregations_13_0= ruleColumnAssignment ) )+ otherlv_14= '}' )?
            int alt29=2;
            int LA29_0 = input.LA(1);

            if ( (LA29_0==47) ) {
                alt29=1;
            }
            switch (alt29) {
                case 1 :
                    // InternalLts.g:1970:4: otherlv_11= 'aggregate' otherlv_12= '{' ( (lv_aggregations_13_0= ruleColumnAssignment ) )+ otherlv_14= '}'
                    {
                    otherlv_11=(Token)match(input,47,FOLLOW_4); 

                    				newLeafNode(otherlv_11, grammarAccess.getJoinOperationAccess().getAggregateKeyword_8_0());
                    			
                    otherlv_12=(Token)match(input,12,FOLLOW_3); 

                    				newLeafNode(otherlv_12, grammarAccess.getJoinOperationAccess().getLeftCurlyBracketKeyword_8_1());
                    			
                    // InternalLts.g:1978:4: ( (lv_aggregations_13_0= ruleColumnAssignment ) )+
                    int cnt28=0;
                    loop28:
                    do {
                        int alt28=2;
                        int LA28_0 = input.LA(1);

                        if ( (LA28_0==RULE_ID) ) {
                            alt28=1;
                        }


                        switch (alt28) {
                    	case 1 :
                    	    // InternalLts.g:1979:5: (lv_aggregations_13_0= ruleColumnAssignment )
                    	    {
                    	    // InternalLts.g:1979:5: (lv_aggregations_13_0= ruleColumnAssignment )
                    	    // InternalLts.g:1980:6: lv_aggregations_13_0= ruleColumnAssignment
                    	    {

                    	    						newCompositeNode(grammarAccess.getJoinOperationAccess().getAggregationsColumnAssignmentParserRuleCall_8_2_0());
                    	    					
                    	    pushFollow(FOLLOW_10);
                    	    lv_aggregations_13_0=ruleColumnAssignment();

                    	    state._fsp--;


                    	    						if (current==null) {
                    	    							current = createModelElementForParent(grammarAccess.getJoinOperationRule());
                    	    						}
                    	    						add(
                    	    							current,
                    	    							"aggregations",
                    	    							lv_aggregations_13_0,
                    	    							"org.example.lts.Lts.ColumnAssignment");
                    	    						afterParserOrEnumRuleCall();
                    	    					

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    if ( cnt28 >= 1 ) break loop28;
                                EarlyExitException eee =
                                    new EarlyExitException(28, input);
                                throw eee;
                        }
                        cnt28++;
                    } while (true);

                    otherlv_14=(Token)match(input,14,FOLLOW_19); 

                    				newLeafNode(otherlv_14, grammarAccess.getJoinOperationAccess().getRightCurlyBracketKeyword_8_3());
                    			

                    }
                    break;

            }

            otherlv_15=(Token)match(input,24,FOLLOW_2); 

            			newLeafNode(otherlv_15, grammarAccess.getJoinOperationAccess().getSemicolonKeyword_9());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleJoinOperation"


    // $ANTLR start "entryRuleInsertColumnOperation"
    // InternalLts.g:2010:1: entryRuleInsertColumnOperation returns [EObject current=null] : iv_ruleInsertColumnOperation= ruleInsertColumnOperation EOF ;
    public final EObject entryRuleInsertColumnOperation() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleInsertColumnOperation = null;


        try {
            // InternalLts.g:2010:62: (iv_ruleInsertColumnOperation= ruleInsertColumnOperation EOF )
            // InternalLts.g:2011:2: iv_ruleInsertColumnOperation= ruleInsertColumnOperation EOF
            {
             newCompositeNode(grammarAccess.getInsertColumnOperationRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleInsertColumnOperation=ruleInsertColumnOperation();

            state._fsp--;

             current =iv_ruleInsertColumnOperation; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleInsertColumnOperation"


    // $ANTLR start "ruleInsertColumnOperation"
    // InternalLts.g:2017:1: ruleInsertColumnOperation returns [EObject current=null] : (otherlv_0= 'insert' otherlv_1= 'column' ( (otherlv_2= RULE_ID ) ) otherlv_3= '.' ( (lv_column_4_0= RULE_ID ) ) otherlv_5= ':' ( (lv_type_6_0= ruleDataType ) ) (otherlv_7= '=' ( (lv_value_8_0= ruleExpression ) ) )? otherlv_9= ';' ) ;
    public final EObject ruleInsertColumnOperation() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token lv_column_4_0=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        Token otherlv_9=null;
        Enumerator lv_type_6_0 = null;

        EObject lv_value_8_0 = null;



        	enterRule();

        try {
            // InternalLts.g:2023:2: ( (otherlv_0= 'insert' otherlv_1= 'column' ( (otherlv_2= RULE_ID ) ) otherlv_3= '.' ( (lv_column_4_0= RULE_ID ) ) otherlv_5= ':' ( (lv_type_6_0= ruleDataType ) ) (otherlv_7= '=' ( (lv_value_8_0= ruleExpression ) ) )? otherlv_9= ';' ) )
            // InternalLts.g:2024:2: (otherlv_0= 'insert' otherlv_1= 'column' ( (otherlv_2= RULE_ID ) ) otherlv_3= '.' ( (lv_column_4_0= RULE_ID ) ) otherlv_5= ':' ( (lv_type_6_0= ruleDataType ) ) (otherlv_7= '=' ( (lv_value_8_0= ruleExpression ) ) )? otherlv_9= ';' )
            {
            // InternalLts.g:2024:2: (otherlv_0= 'insert' otherlv_1= 'column' ( (otherlv_2= RULE_ID ) ) otherlv_3= '.' ( (lv_column_4_0= RULE_ID ) ) otherlv_5= ':' ( (lv_type_6_0= ruleDataType ) ) (otherlv_7= '=' ( (lv_value_8_0= ruleExpression ) ) )? otherlv_9= ';' )
            // InternalLts.g:2025:3: otherlv_0= 'insert' otherlv_1= 'column' ( (otherlv_2= RULE_ID ) ) otherlv_3= '.' ( (lv_column_4_0= RULE_ID ) ) otherlv_5= ':' ( (lv_type_6_0= ruleDataType ) ) (otherlv_7= '=' ( (lv_value_8_0= ruleExpression ) ) )? otherlv_9= ';'
            {
            otherlv_0=(Token)match(input,53,FOLLOW_48); 

            			newLeafNode(otherlv_0, grammarAccess.getInsertColumnOperationAccess().getInsertKeyword_0());
            		
            otherlv_1=(Token)match(input,54,FOLLOW_3); 

            			newLeafNode(otherlv_1, grammarAccess.getInsertColumnOperationAccess().getColumnKeyword_1());
            		
            // InternalLts.g:2033:3: ( (otherlv_2= RULE_ID ) )
            // InternalLts.g:2034:4: (otherlv_2= RULE_ID )
            {
            // InternalLts.g:2034:4: (otherlv_2= RULE_ID )
            // InternalLts.g:2035:5: otherlv_2= RULE_ID
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getInsertColumnOperationRule());
            					}
            				
            otherlv_2=(Token)match(input,RULE_ID,FOLLOW_49); 

            					newLeafNode(otherlv_2, grammarAccess.getInsertColumnOperationAccess().getTableTableDeclarationCrossReference_2_0());
            				

            }


            }

            otherlv_3=(Token)match(input,55,FOLLOW_3); 

            			newLeafNode(otherlv_3, grammarAccess.getInsertColumnOperationAccess().getFullStopKeyword_3());
            		
            // InternalLts.g:2050:3: ( (lv_column_4_0= RULE_ID ) )
            // InternalLts.g:2051:4: (lv_column_4_0= RULE_ID )
            {
            // InternalLts.g:2051:4: (lv_column_4_0= RULE_ID )
            // InternalLts.g:2052:5: lv_column_4_0= RULE_ID
            {
            lv_column_4_0=(Token)match(input,RULE_ID,FOLLOW_15); 

            					newLeafNode(lv_column_4_0, grammarAccess.getInsertColumnOperationAccess().getColumnIDTerminalRuleCall_4_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getInsertColumnOperationRule());
            					}
            					setWithLastConsumed(
            						current,
            						"column",
            						lv_column_4_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }

            otherlv_5=(Token)match(input,21,FOLLOW_16); 

            			newLeafNode(otherlv_5, grammarAccess.getInsertColumnOperationAccess().getColonKeyword_5());
            		
            // InternalLts.g:2072:3: ( (lv_type_6_0= ruleDataType ) )
            // InternalLts.g:2073:4: (lv_type_6_0= ruleDataType )
            {
            // InternalLts.g:2073:4: (lv_type_6_0= ruleDataType )
            // InternalLts.g:2074:5: lv_type_6_0= ruleDataType
            {

            					newCompositeNode(grammarAccess.getInsertColumnOperationAccess().getTypeDataTypeEnumRuleCall_6_0());
            				
            pushFollow(FOLLOW_50);
            lv_type_6_0=ruleDataType();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getInsertColumnOperationRule());
            					}
            					set(
            						current,
            						"type",
            						lv_type_6_0,
            						"org.example.lts.Lts.DataType");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalLts.g:2091:3: (otherlv_7= '=' ( (lv_value_8_0= ruleExpression ) ) )?
            int alt30=2;
            int LA30_0 = input.LA(1);

            if ( (LA30_0==56) ) {
                alt30=1;
            }
            switch (alt30) {
                case 1 :
                    // InternalLts.g:2092:4: otherlv_7= '=' ( (lv_value_8_0= ruleExpression ) )
                    {
                    otherlv_7=(Token)match(input,56,FOLLOW_37); 

                    				newLeafNode(otherlv_7, grammarAccess.getInsertColumnOperationAccess().getEqualsSignKeyword_7_0());
                    			
                    // InternalLts.g:2096:4: ( (lv_value_8_0= ruleExpression ) )
                    // InternalLts.g:2097:5: (lv_value_8_0= ruleExpression )
                    {
                    // InternalLts.g:2097:5: (lv_value_8_0= ruleExpression )
                    // InternalLts.g:2098:6: lv_value_8_0= ruleExpression
                    {

                    						newCompositeNode(grammarAccess.getInsertColumnOperationAccess().getValueExpressionParserRuleCall_7_1_0());
                    					
                    pushFollow(FOLLOW_19);
                    lv_value_8_0=ruleExpression();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getInsertColumnOperationRule());
                    						}
                    						set(
                    							current,
                    							"value",
                    							lv_value_8_0,
                    							"org.example.lts.Lts.Expression");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;

            }

            otherlv_9=(Token)match(input,24,FOLLOW_2); 

            			newLeafNode(otherlv_9, grammarAccess.getInsertColumnOperationAccess().getSemicolonKeyword_8());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleInsertColumnOperation"


    // $ANTLR start "entryRuleRemoveColumnOperation"
    // InternalLts.g:2124:1: entryRuleRemoveColumnOperation returns [EObject current=null] : iv_ruleRemoveColumnOperation= ruleRemoveColumnOperation EOF ;
    public final EObject entryRuleRemoveColumnOperation() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRemoveColumnOperation = null;


        try {
            // InternalLts.g:2124:62: (iv_ruleRemoveColumnOperation= ruleRemoveColumnOperation EOF )
            // InternalLts.g:2125:2: iv_ruleRemoveColumnOperation= ruleRemoveColumnOperation EOF
            {
             newCompositeNode(grammarAccess.getRemoveColumnOperationRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleRemoveColumnOperation=ruleRemoveColumnOperation();

            state._fsp--;

             current =iv_ruleRemoveColumnOperation; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleRemoveColumnOperation"


    // $ANTLR start "ruleRemoveColumnOperation"
    // InternalLts.g:2131:1: ruleRemoveColumnOperation returns [EObject current=null] : (otherlv_0= 'remove' otherlv_1= 'columns' ( (lv_columns_2_0= ruleColumnReference ) ) (otherlv_3= ',' ( (lv_columns_4_0= ruleColumnReference ) ) )* otherlv_5= ';' ) ;
    public final EObject ruleRemoveColumnOperation() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        EObject lv_columns_2_0 = null;

        EObject lv_columns_4_0 = null;



        	enterRule();

        try {
            // InternalLts.g:2137:2: ( (otherlv_0= 'remove' otherlv_1= 'columns' ( (lv_columns_2_0= ruleColumnReference ) ) (otherlv_3= ',' ( (lv_columns_4_0= ruleColumnReference ) ) )* otherlv_5= ';' ) )
            // InternalLts.g:2138:2: (otherlv_0= 'remove' otherlv_1= 'columns' ( (lv_columns_2_0= ruleColumnReference ) ) (otherlv_3= ',' ( (lv_columns_4_0= ruleColumnReference ) ) )* otherlv_5= ';' )
            {
            // InternalLts.g:2138:2: (otherlv_0= 'remove' otherlv_1= 'columns' ( (lv_columns_2_0= ruleColumnReference ) ) (otherlv_3= ',' ( (lv_columns_4_0= ruleColumnReference ) ) )* otherlv_5= ';' )
            // InternalLts.g:2139:3: otherlv_0= 'remove' otherlv_1= 'columns' ( (lv_columns_2_0= ruleColumnReference ) ) (otherlv_3= ',' ( (lv_columns_4_0= ruleColumnReference ) ) )* otherlv_5= ';'
            {
            otherlv_0=(Token)match(input,57,FOLLOW_51); 

            			newLeafNode(otherlv_0, grammarAccess.getRemoveColumnOperationAccess().getRemoveKeyword_0());
            		
            otherlv_1=(Token)match(input,58,FOLLOW_3); 

            			newLeafNode(otherlv_1, grammarAccess.getRemoveColumnOperationAccess().getColumnsKeyword_1());
            		
            // InternalLts.g:2147:3: ( (lv_columns_2_0= ruleColumnReference ) )
            // InternalLts.g:2148:4: (lv_columns_2_0= ruleColumnReference )
            {
            // InternalLts.g:2148:4: (lv_columns_2_0= ruleColumnReference )
            // InternalLts.g:2149:5: lv_columns_2_0= ruleColumnReference
            {

            					newCompositeNode(grammarAccess.getRemoveColumnOperationAccess().getColumnsColumnReferenceParserRuleCall_2_0());
            				
            pushFollow(FOLLOW_26);
            lv_columns_2_0=ruleColumnReference();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getRemoveColumnOperationRule());
            					}
            					add(
            						current,
            						"columns",
            						lv_columns_2_0,
            						"org.example.lts.Lts.ColumnReference");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalLts.g:2166:3: (otherlv_3= ',' ( (lv_columns_4_0= ruleColumnReference ) ) )*
            loop31:
            do {
                int alt31=2;
                int LA31_0 = input.LA(1);

                if ( (LA31_0==29) ) {
                    alt31=1;
                }


                switch (alt31) {
            	case 1 :
            	    // InternalLts.g:2167:4: otherlv_3= ',' ( (lv_columns_4_0= ruleColumnReference ) )
            	    {
            	    otherlv_3=(Token)match(input,29,FOLLOW_3); 

            	    				newLeafNode(otherlv_3, grammarAccess.getRemoveColumnOperationAccess().getCommaKeyword_3_0());
            	    			
            	    // InternalLts.g:2171:4: ( (lv_columns_4_0= ruleColumnReference ) )
            	    // InternalLts.g:2172:5: (lv_columns_4_0= ruleColumnReference )
            	    {
            	    // InternalLts.g:2172:5: (lv_columns_4_0= ruleColumnReference )
            	    // InternalLts.g:2173:6: lv_columns_4_0= ruleColumnReference
            	    {

            	    						newCompositeNode(grammarAccess.getRemoveColumnOperationAccess().getColumnsColumnReferenceParserRuleCall_3_1_0());
            	    					
            	    pushFollow(FOLLOW_26);
            	    lv_columns_4_0=ruleColumnReference();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getRemoveColumnOperationRule());
            	    						}
            	    						add(
            	    							current,
            	    							"columns",
            	    							lv_columns_4_0,
            	    							"org.example.lts.Lts.ColumnReference");
            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop31;
                }
            } while (true);

            otherlv_5=(Token)match(input,24,FOLLOW_2); 

            			newLeafNode(otherlv_5, grammarAccess.getRemoveColumnOperationAccess().getSemicolonKeyword_4());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleRemoveColumnOperation"


    // $ANTLR start "entryRuleCalculateColumnOperation"
    // InternalLts.g:2199:1: entryRuleCalculateColumnOperation returns [EObject current=null] : iv_ruleCalculateColumnOperation= ruleCalculateColumnOperation EOF ;
    public final EObject entryRuleCalculateColumnOperation() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCalculateColumnOperation = null;


        try {
            // InternalLts.g:2199:65: (iv_ruleCalculateColumnOperation= ruleCalculateColumnOperation EOF )
            // InternalLts.g:2200:2: iv_ruleCalculateColumnOperation= ruleCalculateColumnOperation EOF
            {
             newCompositeNode(grammarAccess.getCalculateColumnOperationRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleCalculateColumnOperation=ruleCalculateColumnOperation();

            state._fsp--;

             current =iv_ruleCalculateColumnOperation; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleCalculateColumnOperation"


    // $ANTLR start "ruleCalculateColumnOperation"
    // InternalLts.g:2206:1: ruleCalculateColumnOperation returns [EObject current=null] : (otherlv_0= 'calculate' otherlv_1= 'column' ( (otherlv_2= RULE_ID ) ) otherlv_3= '.' ( (lv_column_4_0= RULE_ID ) ) otherlv_5= '=' ( (lv_value_6_0= ruleExpression ) ) otherlv_7= ';' ) ;
    public final EObject ruleCalculateColumnOperation() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token lv_column_4_0=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        EObject lv_value_6_0 = null;



        	enterRule();

        try {
            // InternalLts.g:2212:2: ( (otherlv_0= 'calculate' otherlv_1= 'column' ( (otherlv_2= RULE_ID ) ) otherlv_3= '.' ( (lv_column_4_0= RULE_ID ) ) otherlv_5= '=' ( (lv_value_6_0= ruleExpression ) ) otherlv_7= ';' ) )
            // InternalLts.g:2213:2: (otherlv_0= 'calculate' otherlv_1= 'column' ( (otherlv_2= RULE_ID ) ) otherlv_3= '.' ( (lv_column_4_0= RULE_ID ) ) otherlv_5= '=' ( (lv_value_6_0= ruleExpression ) ) otherlv_7= ';' )
            {
            // InternalLts.g:2213:2: (otherlv_0= 'calculate' otherlv_1= 'column' ( (otherlv_2= RULE_ID ) ) otherlv_3= '.' ( (lv_column_4_0= RULE_ID ) ) otherlv_5= '=' ( (lv_value_6_0= ruleExpression ) ) otherlv_7= ';' )
            // InternalLts.g:2214:3: otherlv_0= 'calculate' otherlv_1= 'column' ( (otherlv_2= RULE_ID ) ) otherlv_3= '.' ( (lv_column_4_0= RULE_ID ) ) otherlv_5= '=' ( (lv_value_6_0= ruleExpression ) ) otherlv_7= ';'
            {
            otherlv_0=(Token)match(input,59,FOLLOW_48); 

            			newLeafNode(otherlv_0, grammarAccess.getCalculateColumnOperationAccess().getCalculateKeyword_0());
            		
            otherlv_1=(Token)match(input,54,FOLLOW_3); 

            			newLeafNode(otherlv_1, grammarAccess.getCalculateColumnOperationAccess().getColumnKeyword_1());
            		
            // InternalLts.g:2222:3: ( (otherlv_2= RULE_ID ) )
            // InternalLts.g:2223:4: (otherlv_2= RULE_ID )
            {
            // InternalLts.g:2223:4: (otherlv_2= RULE_ID )
            // InternalLts.g:2224:5: otherlv_2= RULE_ID
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getCalculateColumnOperationRule());
            					}
            				
            otherlv_2=(Token)match(input,RULE_ID,FOLLOW_49); 

            					newLeafNode(otherlv_2, grammarAccess.getCalculateColumnOperationAccess().getTableTableDeclarationCrossReference_2_0());
            				

            }


            }

            otherlv_3=(Token)match(input,55,FOLLOW_3); 

            			newLeafNode(otherlv_3, grammarAccess.getCalculateColumnOperationAccess().getFullStopKeyword_3());
            		
            // InternalLts.g:2239:3: ( (lv_column_4_0= RULE_ID ) )
            // InternalLts.g:2240:4: (lv_column_4_0= RULE_ID )
            {
            // InternalLts.g:2240:4: (lv_column_4_0= RULE_ID )
            // InternalLts.g:2241:5: lv_column_4_0= RULE_ID
            {
            lv_column_4_0=(Token)match(input,RULE_ID,FOLLOW_52); 

            					newLeafNode(lv_column_4_0, grammarAccess.getCalculateColumnOperationAccess().getColumnIDTerminalRuleCall_4_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getCalculateColumnOperationRule());
            					}
            					setWithLastConsumed(
            						current,
            						"column",
            						lv_column_4_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }

            otherlv_5=(Token)match(input,56,FOLLOW_37); 

            			newLeafNode(otherlv_5, grammarAccess.getCalculateColumnOperationAccess().getEqualsSignKeyword_5());
            		
            // InternalLts.g:2261:3: ( (lv_value_6_0= ruleExpression ) )
            // InternalLts.g:2262:4: (lv_value_6_0= ruleExpression )
            {
            // InternalLts.g:2262:4: (lv_value_6_0= ruleExpression )
            // InternalLts.g:2263:5: lv_value_6_0= ruleExpression
            {

            					newCompositeNode(grammarAccess.getCalculateColumnOperationAccess().getValueExpressionParserRuleCall_6_0());
            				
            pushFollow(FOLLOW_19);
            lv_value_6_0=ruleExpression();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getCalculateColumnOperationRule());
            					}
            					set(
            						current,
            						"value",
            						lv_value_6_0,
            						"org.example.lts.Lts.Expression");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_7=(Token)match(input,24,FOLLOW_2); 

            			newLeafNode(otherlv_7, grammarAccess.getCalculateColumnOperationAccess().getSemicolonKeyword_7());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleCalculateColumnOperation"


    // $ANTLR start "entryRuleLookupOperation"
    // InternalLts.g:2288:1: entryRuleLookupOperation returns [EObject current=null] : iv_ruleLookupOperation= ruleLookupOperation EOF ;
    public final EObject entryRuleLookupOperation() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLookupOperation = null;


        try {
            // InternalLts.g:2288:56: (iv_ruleLookupOperation= ruleLookupOperation EOF )
            // InternalLts.g:2289:2: iv_ruleLookupOperation= ruleLookupOperation EOF
            {
             newCompositeNode(grammarAccess.getLookupOperationRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleLookupOperation=ruleLookupOperation();

            state._fsp--;

             current =iv_ruleLookupOperation; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleLookupOperation"


    // $ANTLR start "ruleLookupOperation"
    // InternalLts.g:2295:1: ruleLookupOperation returns [EObject current=null] : (otherlv_0= 'lookup' otherlv_1= 'into' ( (lv_target_2_0= ruleColumnReference ) ) otherlv_3= 'from' ( (otherlv_4= RULE_ID ) ) otherlv_5= 'match' ( (lv_left_6_0= ruleColumnReference ) ) otherlv_7= '=' ( (lv_right_8_0= ruleColumnReference ) ) otherlv_9= 'return' ( (lv_result_10_0= ruleColumnReference ) ) (otherlv_11= 'default' ( (lv_defaultValue_12_0= ruleExpression ) ) )? otherlv_13= ';' ) ;
    public final EObject ruleLookupOperation() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        Token otherlv_9=null;
        Token otherlv_11=null;
        Token otherlv_13=null;
        EObject lv_target_2_0 = null;

        EObject lv_left_6_0 = null;

        EObject lv_right_8_0 = null;

        EObject lv_result_10_0 = null;

        EObject lv_defaultValue_12_0 = null;



        	enterRule();

        try {
            // InternalLts.g:2301:2: ( (otherlv_0= 'lookup' otherlv_1= 'into' ( (lv_target_2_0= ruleColumnReference ) ) otherlv_3= 'from' ( (otherlv_4= RULE_ID ) ) otherlv_5= 'match' ( (lv_left_6_0= ruleColumnReference ) ) otherlv_7= '=' ( (lv_right_8_0= ruleColumnReference ) ) otherlv_9= 'return' ( (lv_result_10_0= ruleColumnReference ) ) (otherlv_11= 'default' ( (lv_defaultValue_12_0= ruleExpression ) ) )? otherlv_13= ';' ) )
            // InternalLts.g:2302:2: (otherlv_0= 'lookup' otherlv_1= 'into' ( (lv_target_2_0= ruleColumnReference ) ) otherlv_3= 'from' ( (otherlv_4= RULE_ID ) ) otherlv_5= 'match' ( (lv_left_6_0= ruleColumnReference ) ) otherlv_7= '=' ( (lv_right_8_0= ruleColumnReference ) ) otherlv_9= 'return' ( (lv_result_10_0= ruleColumnReference ) ) (otherlv_11= 'default' ( (lv_defaultValue_12_0= ruleExpression ) ) )? otherlv_13= ';' )
            {
            // InternalLts.g:2302:2: (otherlv_0= 'lookup' otherlv_1= 'into' ( (lv_target_2_0= ruleColumnReference ) ) otherlv_3= 'from' ( (otherlv_4= RULE_ID ) ) otherlv_5= 'match' ( (lv_left_6_0= ruleColumnReference ) ) otherlv_7= '=' ( (lv_right_8_0= ruleColumnReference ) ) otherlv_9= 'return' ( (lv_result_10_0= ruleColumnReference ) ) (otherlv_11= 'default' ( (lv_defaultValue_12_0= ruleExpression ) ) )? otherlv_13= ';' )
            // InternalLts.g:2303:3: otherlv_0= 'lookup' otherlv_1= 'into' ( (lv_target_2_0= ruleColumnReference ) ) otherlv_3= 'from' ( (otherlv_4= RULE_ID ) ) otherlv_5= 'match' ( (lv_left_6_0= ruleColumnReference ) ) otherlv_7= '=' ( (lv_right_8_0= ruleColumnReference ) ) otherlv_9= 'return' ( (lv_result_10_0= ruleColumnReference ) ) (otherlv_11= 'default' ( (lv_defaultValue_12_0= ruleExpression ) ) )? otherlv_13= ';'
            {
            otherlv_0=(Token)match(input,60,FOLLOW_39); 

            			newLeafNode(otherlv_0, grammarAccess.getLookupOperationAccess().getLookupKeyword_0());
            		
            otherlv_1=(Token)match(input,46,FOLLOW_3); 

            			newLeafNode(otherlv_1, grammarAccess.getLookupOperationAccess().getIntoKeyword_1());
            		
            // InternalLts.g:2311:3: ( (lv_target_2_0= ruleColumnReference ) )
            // InternalLts.g:2312:4: (lv_target_2_0= ruleColumnReference )
            {
            // InternalLts.g:2312:4: (lv_target_2_0= ruleColumnReference )
            // InternalLts.g:2313:5: lv_target_2_0= ruleColumnReference
            {

            					newCompositeNode(grammarAccess.getLookupOperationAccess().getTargetColumnReferenceParserRuleCall_2_0());
            				
            pushFollow(FOLLOW_8);
            lv_target_2_0=ruleColumnReference();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getLookupOperationRule());
            					}
            					set(
            						current,
            						"target",
            						lv_target_2_0,
            						"org.example.lts.Lts.ColumnReference");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_3=(Token)match(input,16,FOLLOW_3); 

            			newLeafNode(otherlv_3, grammarAccess.getLookupOperationAccess().getFromKeyword_3());
            		
            // InternalLts.g:2334:3: ( (otherlv_4= RULE_ID ) )
            // InternalLts.g:2335:4: (otherlv_4= RULE_ID )
            {
            // InternalLts.g:2335:4: (otherlv_4= RULE_ID )
            // InternalLts.g:2336:5: otherlv_4= RULE_ID
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getLookupOperationRule());
            					}
            				
            otherlv_4=(Token)match(input,RULE_ID,FOLLOW_53); 

            					newLeafNode(otherlv_4, grammarAccess.getLookupOperationAccess().getSourceTableDeclarationCrossReference_4_0());
            				

            }


            }

            otherlv_5=(Token)match(input,61,FOLLOW_3); 

            			newLeafNode(otherlv_5, grammarAccess.getLookupOperationAccess().getMatchKeyword_5());
            		
            // InternalLts.g:2351:3: ( (lv_left_6_0= ruleColumnReference ) )
            // InternalLts.g:2352:4: (lv_left_6_0= ruleColumnReference )
            {
            // InternalLts.g:2352:4: (lv_left_6_0= ruleColumnReference )
            // InternalLts.g:2353:5: lv_left_6_0= ruleColumnReference
            {

            					newCompositeNode(grammarAccess.getLookupOperationAccess().getLeftColumnReferenceParserRuleCall_6_0());
            				
            pushFollow(FOLLOW_52);
            lv_left_6_0=ruleColumnReference();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getLookupOperationRule());
            					}
            					set(
            						current,
            						"left",
            						lv_left_6_0,
            						"org.example.lts.Lts.ColumnReference");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_7=(Token)match(input,56,FOLLOW_3); 

            			newLeafNode(otherlv_7, grammarAccess.getLookupOperationAccess().getEqualsSignKeyword_7());
            		
            // InternalLts.g:2374:3: ( (lv_right_8_0= ruleColumnReference ) )
            // InternalLts.g:2375:4: (lv_right_8_0= ruleColumnReference )
            {
            // InternalLts.g:2375:4: (lv_right_8_0= ruleColumnReference )
            // InternalLts.g:2376:5: lv_right_8_0= ruleColumnReference
            {

            					newCompositeNode(grammarAccess.getLookupOperationAccess().getRightColumnReferenceParserRuleCall_8_0());
            				
            pushFollow(FOLLOW_54);
            lv_right_8_0=ruleColumnReference();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getLookupOperationRule());
            					}
            					set(
            						current,
            						"right",
            						lv_right_8_0,
            						"org.example.lts.Lts.ColumnReference");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_9=(Token)match(input,62,FOLLOW_3); 

            			newLeafNode(otherlv_9, grammarAccess.getLookupOperationAccess().getReturnKeyword_9());
            		
            // InternalLts.g:2397:3: ( (lv_result_10_0= ruleColumnReference ) )
            // InternalLts.g:2398:4: (lv_result_10_0= ruleColumnReference )
            {
            // InternalLts.g:2398:4: (lv_result_10_0= ruleColumnReference )
            // InternalLts.g:2399:5: lv_result_10_0= ruleColumnReference
            {

            					newCompositeNode(grammarAccess.getLookupOperationAccess().getResultColumnReferenceParserRuleCall_10_0());
            				
            pushFollow(FOLLOW_55);
            lv_result_10_0=ruleColumnReference();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getLookupOperationRule());
            					}
            					set(
            						current,
            						"result",
            						lv_result_10_0,
            						"org.example.lts.Lts.ColumnReference");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalLts.g:2416:3: (otherlv_11= 'default' ( (lv_defaultValue_12_0= ruleExpression ) ) )?
            int alt32=2;
            int LA32_0 = input.LA(1);

            if ( (LA32_0==63) ) {
                alt32=1;
            }
            switch (alt32) {
                case 1 :
                    // InternalLts.g:2417:4: otherlv_11= 'default' ( (lv_defaultValue_12_0= ruleExpression ) )
                    {
                    otherlv_11=(Token)match(input,63,FOLLOW_37); 

                    				newLeafNode(otherlv_11, grammarAccess.getLookupOperationAccess().getDefaultKeyword_11_0());
                    			
                    // InternalLts.g:2421:4: ( (lv_defaultValue_12_0= ruleExpression ) )
                    // InternalLts.g:2422:5: (lv_defaultValue_12_0= ruleExpression )
                    {
                    // InternalLts.g:2422:5: (lv_defaultValue_12_0= ruleExpression )
                    // InternalLts.g:2423:6: lv_defaultValue_12_0= ruleExpression
                    {

                    						newCompositeNode(grammarAccess.getLookupOperationAccess().getDefaultValueExpressionParserRuleCall_11_1_0());
                    					
                    pushFollow(FOLLOW_19);
                    lv_defaultValue_12_0=ruleExpression();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getLookupOperationRule());
                    						}
                    						set(
                    							current,
                    							"defaultValue",
                    							lv_defaultValue_12_0,
                    							"org.example.lts.Lts.Expression");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;

            }

            otherlv_13=(Token)match(input,24,FOLLOW_2); 

            			newLeafNode(otherlv_13, grammarAccess.getLookupOperationAccess().getSemicolonKeyword_12());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleLookupOperation"


    // $ANTLR start "entryRuleRemoveDuplicatesOperation"
    // InternalLts.g:2449:1: entryRuleRemoveDuplicatesOperation returns [EObject current=null] : iv_ruleRemoveDuplicatesOperation= ruleRemoveDuplicatesOperation EOF ;
    public final EObject entryRuleRemoveDuplicatesOperation() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRemoveDuplicatesOperation = null;


        try {
            // InternalLts.g:2449:66: (iv_ruleRemoveDuplicatesOperation= ruleRemoveDuplicatesOperation EOF )
            // InternalLts.g:2450:2: iv_ruleRemoveDuplicatesOperation= ruleRemoveDuplicatesOperation EOF
            {
             newCompositeNode(grammarAccess.getRemoveDuplicatesOperationRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleRemoveDuplicatesOperation=ruleRemoveDuplicatesOperation();

            state._fsp--;

             current =iv_ruleRemoveDuplicatesOperation; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleRemoveDuplicatesOperation"


    // $ANTLR start "ruleRemoveDuplicatesOperation"
    // InternalLts.g:2456:1: ruleRemoveDuplicatesOperation returns [EObject current=null] : (otherlv_0= 'remove' otherlv_1= 'duplicates' otherlv_2= 'from' ( (otherlv_3= RULE_ID ) ) otherlv_4= 'by' ( (lv_keys_5_0= ruleColumnReference ) ) (otherlv_6= ',' ( (lv_keys_7_0= ruleColumnReference ) ) )* otherlv_8= ';' ) ;
    public final EObject ruleRemoveDuplicatesOperation() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        Token otherlv_8=null;
        EObject lv_keys_5_0 = null;

        EObject lv_keys_7_0 = null;



        	enterRule();

        try {
            // InternalLts.g:2462:2: ( (otherlv_0= 'remove' otherlv_1= 'duplicates' otherlv_2= 'from' ( (otherlv_3= RULE_ID ) ) otherlv_4= 'by' ( (lv_keys_5_0= ruleColumnReference ) ) (otherlv_6= ',' ( (lv_keys_7_0= ruleColumnReference ) ) )* otherlv_8= ';' ) )
            // InternalLts.g:2463:2: (otherlv_0= 'remove' otherlv_1= 'duplicates' otherlv_2= 'from' ( (otherlv_3= RULE_ID ) ) otherlv_4= 'by' ( (lv_keys_5_0= ruleColumnReference ) ) (otherlv_6= ',' ( (lv_keys_7_0= ruleColumnReference ) ) )* otherlv_8= ';' )
            {
            // InternalLts.g:2463:2: (otherlv_0= 'remove' otherlv_1= 'duplicates' otherlv_2= 'from' ( (otherlv_3= RULE_ID ) ) otherlv_4= 'by' ( (lv_keys_5_0= ruleColumnReference ) ) (otherlv_6= ',' ( (lv_keys_7_0= ruleColumnReference ) ) )* otherlv_8= ';' )
            // InternalLts.g:2464:3: otherlv_0= 'remove' otherlv_1= 'duplicates' otherlv_2= 'from' ( (otherlv_3= RULE_ID ) ) otherlv_4= 'by' ( (lv_keys_5_0= ruleColumnReference ) ) (otherlv_6= ',' ( (lv_keys_7_0= ruleColumnReference ) ) )* otherlv_8= ';'
            {
            otherlv_0=(Token)match(input,57,FOLLOW_56); 

            			newLeafNode(otherlv_0, grammarAccess.getRemoveDuplicatesOperationAccess().getRemoveKeyword_0());
            		
            otherlv_1=(Token)match(input,64,FOLLOW_8); 

            			newLeafNode(otherlv_1, grammarAccess.getRemoveDuplicatesOperationAccess().getDuplicatesKeyword_1());
            		
            otherlv_2=(Token)match(input,16,FOLLOW_3); 

            			newLeafNode(otherlv_2, grammarAccess.getRemoveDuplicatesOperationAccess().getFromKeyword_2());
            		
            // InternalLts.g:2476:3: ( (otherlv_3= RULE_ID ) )
            // InternalLts.g:2477:4: (otherlv_3= RULE_ID )
            {
            // InternalLts.g:2477:4: (otherlv_3= RULE_ID )
            // InternalLts.g:2478:5: otherlv_3= RULE_ID
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getRemoveDuplicatesOperationRule());
            					}
            				
            otherlv_3=(Token)match(input,RULE_ID,FOLLOW_32); 

            					newLeafNode(otherlv_3, grammarAccess.getRemoveDuplicatesOperationAccess().getTableTableDeclarationCrossReference_3_0());
            				

            }


            }

            otherlv_4=(Token)match(input,35,FOLLOW_3); 

            			newLeafNode(otherlv_4, grammarAccess.getRemoveDuplicatesOperationAccess().getByKeyword_4());
            		
            // InternalLts.g:2493:3: ( (lv_keys_5_0= ruleColumnReference ) )
            // InternalLts.g:2494:4: (lv_keys_5_0= ruleColumnReference )
            {
            // InternalLts.g:2494:4: (lv_keys_5_0= ruleColumnReference )
            // InternalLts.g:2495:5: lv_keys_5_0= ruleColumnReference
            {

            					newCompositeNode(grammarAccess.getRemoveDuplicatesOperationAccess().getKeysColumnReferenceParserRuleCall_5_0());
            				
            pushFollow(FOLLOW_26);
            lv_keys_5_0=ruleColumnReference();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getRemoveDuplicatesOperationRule());
            					}
            					add(
            						current,
            						"keys",
            						lv_keys_5_0,
            						"org.example.lts.Lts.ColumnReference");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalLts.g:2512:3: (otherlv_6= ',' ( (lv_keys_7_0= ruleColumnReference ) ) )*
            loop33:
            do {
                int alt33=2;
                int LA33_0 = input.LA(1);

                if ( (LA33_0==29) ) {
                    alt33=1;
                }


                switch (alt33) {
            	case 1 :
            	    // InternalLts.g:2513:4: otherlv_6= ',' ( (lv_keys_7_0= ruleColumnReference ) )
            	    {
            	    otherlv_6=(Token)match(input,29,FOLLOW_3); 

            	    				newLeafNode(otherlv_6, grammarAccess.getRemoveDuplicatesOperationAccess().getCommaKeyword_6_0());
            	    			
            	    // InternalLts.g:2517:4: ( (lv_keys_7_0= ruleColumnReference ) )
            	    // InternalLts.g:2518:5: (lv_keys_7_0= ruleColumnReference )
            	    {
            	    // InternalLts.g:2518:5: (lv_keys_7_0= ruleColumnReference )
            	    // InternalLts.g:2519:6: lv_keys_7_0= ruleColumnReference
            	    {

            	    						newCompositeNode(grammarAccess.getRemoveDuplicatesOperationAccess().getKeysColumnReferenceParserRuleCall_6_1_0());
            	    					
            	    pushFollow(FOLLOW_26);
            	    lv_keys_7_0=ruleColumnReference();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getRemoveDuplicatesOperationRule());
            	    						}
            	    						add(
            	    							current,
            	    							"keys",
            	    							lv_keys_7_0,
            	    							"org.example.lts.Lts.ColumnReference");
            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop33;
                }
            } while (true);

            otherlv_8=(Token)match(input,24,FOLLOW_2); 

            			newLeafNode(otherlv_8, grammarAccess.getRemoveDuplicatesOperationAccess().getSemicolonKeyword_7());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleRemoveDuplicatesOperation"


    // $ANTLR start "entryRuleSaveTableOperation"
    // InternalLts.g:2545:1: entryRuleSaveTableOperation returns [EObject current=null] : iv_ruleSaveTableOperation= ruleSaveTableOperation EOF ;
    public final EObject entryRuleSaveTableOperation() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSaveTableOperation = null;


        try {
            // InternalLts.g:2545:59: (iv_ruleSaveTableOperation= ruleSaveTableOperation EOF )
            // InternalLts.g:2546:2: iv_ruleSaveTableOperation= ruleSaveTableOperation EOF
            {
             newCompositeNode(grammarAccess.getSaveTableOperationRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleSaveTableOperation=ruleSaveTableOperation();

            state._fsp--;

             current =iv_ruleSaveTableOperation; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleSaveTableOperation"


    // $ANTLR start "ruleSaveTableOperation"
    // InternalLts.g:2552:1: ruleSaveTableOperation returns [EObject current=null] : (otherlv_0= 'save' ( (otherlv_1= RULE_ID ) ) otherlv_2= 'to' ( (otherlv_3= RULE_ID ) ) otherlv_4= ';' ) ;
    public final EObject ruleSaveTableOperation() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_4=null;


        	enterRule();

        try {
            // InternalLts.g:2558:2: ( (otherlv_0= 'save' ( (otherlv_1= RULE_ID ) ) otherlv_2= 'to' ( (otherlv_3= RULE_ID ) ) otherlv_4= ';' ) )
            // InternalLts.g:2559:2: (otherlv_0= 'save' ( (otherlv_1= RULE_ID ) ) otherlv_2= 'to' ( (otherlv_3= RULE_ID ) ) otherlv_4= ';' )
            {
            // InternalLts.g:2559:2: (otherlv_0= 'save' ( (otherlv_1= RULE_ID ) ) otherlv_2= 'to' ( (otherlv_3= RULE_ID ) ) otherlv_4= ';' )
            // InternalLts.g:2560:3: otherlv_0= 'save' ( (otherlv_1= RULE_ID ) ) otherlv_2= 'to' ( (otherlv_3= RULE_ID ) ) otherlv_4= ';'
            {
            otherlv_0=(Token)match(input,65,FOLLOW_3); 

            			newLeafNode(otherlv_0, grammarAccess.getSaveTableOperationAccess().getSaveKeyword_0());
            		
            // InternalLts.g:2564:3: ( (otherlv_1= RULE_ID ) )
            // InternalLts.g:2565:4: (otherlv_1= RULE_ID )
            {
            // InternalLts.g:2565:4: (otherlv_1= RULE_ID )
            // InternalLts.g:2566:5: otherlv_1= RULE_ID
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getSaveTableOperationRule());
            					}
            				
            otherlv_1=(Token)match(input,RULE_ID,FOLLOW_21); 

            					newLeafNode(otherlv_1, grammarAccess.getSaveTableOperationAccess().getTableTableDeclarationCrossReference_1_0());
            				

            }


            }

            otherlv_2=(Token)match(input,26,FOLLOW_3); 

            			newLeafNode(otherlv_2, grammarAccess.getSaveTableOperationAccess().getToKeyword_2());
            		
            // InternalLts.g:2581:3: ( (otherlv_3= RULE_ID ) )
            // InternalLts.g:2582:4: (otherlv_3= RULE_ID )
            {
            // InternalLts.g:2582:4: (otherlv_3= RULE_ID )
            // InternalLts.g:2583:5: otherlv_3= RULE_ID
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getSaveTableOperationRule());
            					}
            				
            otherlv_3=(Token)match(input,RULE_ID,FOLLOW_19); 

            					newLeafNode(otherlv_3, grammarAccess.getSaveTableOperationAccess().getSinkCsvSinkCrossReference_3_0());
            				

            }


            }

            otherlv_4=(Token)match(input,24,FOLLOW_2); 

            			newLeafNode(otherlv_4, grammarAccess.getSaveTableOperationAccess().getSemicolonKeyword_4());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleSaveTableOperation"


    // $ANTLR start "entryRuleSaveLogOperation"
    // InternalLts.g:2602:1: entryRuleSaveLogOperation returns [EObject current=null] : iv_ruleSaveLogOperation= ruleSaveLogOperation EOF ;
    public final EObject entryRuleSaveLogOperation() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSaveLogOperation = null;


        try {
            // InternalLts.g:2602:57: (iv_ruleSaveLogOperation= ruleSaveLogOperation EOF )
            // InternalLts.g:2603:2: iv_ruleSaveLogOperation= ruleSaveLogOperation EOF
            {
             newCompositeNode(grammarAccess.getSaveLogOperationRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleSaveLogOperation=ruleSaveLogOperation();

            state._fsp--;

             current =iv_ruleSaveLogOperation; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleSaveLogOperation"


    // $ANTLR start "ruleSaveLogOperation"
    // InternalLts.g:2609:1: ruleSaveLogOperation returns [EObject current=null] : (otherlv_0= 'save' otherlv_1= 'log' ( (otherlv_2= RULE_ID ) ) otherlv_3= ';' ) ;
    public final EObject ruleSaveLogOperation() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_3=null;


        	enterRule();

        try {
            // InternalLts.g:2615:2: ( (otherlv_0= 'save' otherlv_1= 'log' ( (otherlv_2= RULE_ID ) ) otherlv_3= ';' ) )
            // InternalLts.g:2616:2: (otherlv_0= 'save' otherlv_1= 'log' ( (otherlv_2= RULE_ID ) ) otherlv_3= ';' )
            {
            // InternalLts.g:2616:2: (otherlv_0= 'save' otherlv_1= 'log' ( (otherlv_2= RULE_ID ) ) otherlv_3= ';' )
            // InternalLts.g:2617:3: otherlv_0= 'save' otherlv_1= 'log' ( (otherlv_2= RULE_ID ) ) otherlv_3= ';'
            {
            otherlv_0=(Token)match(input,65,FOLLOW_57); 

            			newLeafNode(otherlv_0, grammarAccess.getSaveLogOperationAccess().getSaveKeyword_0());
            		
            otherlv_1=(Token)match(input,27,FOLLOW_3); 

            			newLeafNode(otherlv_1, grammarAccess.getSaveLogOperationAccess().getLogKeyword_1());
            		
            // InternalLts.g:2625:3: ( (otherlv_2= RULE_ID ) )
            // InternalLts.g:2626:4: (otherlv_2= RULE_ID )
            {
            // InternalLts.g:2626:4: (otherlv_2= RULE_ID )
            // InternalLts.g:2627:5: otherlv_2= RULE_ID
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getSaveLogOperationRule());
            					}
            				
            otherlv_2=(Token)match(input,RULE_ID,FOLLOW_19); 

            					newLeafNode(otherlv_2, grammarAccess.getSaveLogOperationAccess().getLogLogSinkCrossReference_2_0());
            				

            }


            }

            otherlv_3=(Token)match(input,24,FOLLOW_2); 

            			newLeafNode(otherlv_3, grammarAccess.getSaveLogOperationAccess().getSemicolonKeyword_3());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleSaveLogOperation"


    // $ANTLR start "entryRuleColumnAssignment"
    // InternalLts.g:2646:1: entryRuleColumnAssignment returns [EObject current=null] : iv_ruleColumnAssignment= ruleColumnAssignment EOF ;
    public final EObject entryRuleColumnAssignment() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleColumnAssignment = null;


        try {
            // InternalLts.g:2646:57: (iv_ruleColumnAssignment= ruleColumnAssignment EOF )
            // InternalLts.g:2647:2: iv_ruleColumnAssignment= ruleColumnAssignment EOF
            {
             newCompositeNode(grammarAccess.getColumnAssignmentRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleColumnAssignment=ruleColumnAssignment();

            state._fsp--;

             current =iv_ruleColumnAssignment; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleColumnAssignment"


    // $ANTLR start "ruleColumnAssignment"
    // InternalLts.g:2653:1: ruleColumnAssignment returns [EObject current=null] : ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '.' ( (lv_column_2_0= RULE_ID ) ) otherlv_3= '=' ( (lv_value_4_0= ruleExpression ) ) otherlv_5= ';' ) ;
    public final EObject ruleColumnAssignment() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token lv_column_2_0=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        EObject lv_value_4_0 = null;



        	enterRule();

        try {
            // InternalLts.g:2659:2: ( ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '.' ( (lv_column_2_0= RULE_ID ) ) otherlv_3= '=' ( (lv_value_4_0= ruleExpression ) ) otherlv_5= ';' ) )
            // InternalLts.g:2660:2: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '.' ( (lv_column_2_0= RULE_ID ) ) otherlv_3= '=' ( (lv_value_4_0= ruleExpression ) ) otherlv_5= ';' )
            {
            // InternalLts.g:2660:2: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '.' ( (lv_column_2_0= RULE_ID ) ) otherlv_3= '=' ( (lv_value_4_0= ruleExpression ) ) otherlv_5= ';' )
            // InternalLts.g:2661:3: ( (otherlv_0= RULE_ID ) ) otherlv_1= '.' ( (lv_column_2_0= RULE_ID ) ) otherlv_3= '=' ( (lv_value_4_0= ruleExpression ) ) otherlv_5= ';'
            {
            // InternalLts.g:2661:3: ( (otherlv_0= RULE_ID ) )
            // InternalLts.g:2662:4: (otherlv_0= RULE_ID )
            {
            // InternalLts.g:2662:4: (otherlv_0= RULE_ID )
            // InternalLts.g:2663:5: otherlv_0= RULE_ID
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getColumnAssignmentRule());
            					}
            				
            otherlv_0=(Token)match(input,RULE_ID,FOLLOW_49); 

            					newLeafNode(otherlv_0, grammarAccess.getColumnAssignmentAccess().getTableTableDeclarationCrossReference_0_0());
            				

            }


            }

            otherlv_1=(Token)match(input,55,FOLLOW_3); 

            			newLeafNode(otherlv_1, grammarAccess.getColumnAssignmentAccess().getFullStopKeyword_1());
            		
            // InternalLts.g:2678:3: ( (lv_column_2_0= RULE_ID ) )
            // InternalLts.g:2679:4: (lv_column_2_0= RULE_ID )
            {
            // InternalLts.g:2679:4: (lv_column_2_0= RULE_ID )
            // InternalLts.g:2680:5: lv_column_2_0= RULE_ID
            {
            lv_column_2_0=(Token)match(input,RULE_ID,FOLLOW_52); 

            					newLeafNode(lv_column_2_0, grammarAccess.getColumnAssignmentAccess().getColumnIDTerminalRuleCall_2_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getColumnAssignmentRule());
            					}
            					setWithLastConsumed(
            						current,
            						"column",
            						lv_column_2_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }

            otherlv_3=(Token)match(input,56,FOLLOW_37); 

            			newLeafNode(otherlv_3, grammarAccess.getColumnAssignmentAccess().getEqualsSignKeyword_3());
            		
            // InternalLts.g:2700:3: ( (lv_value_4_0= ruleExpression ) )
            // InternalLts.g:2701:4: (lv_value_4_0= ruleExpression )
            {
            // InternalLts.g:2701:4: (lv_value_4_0= ruleExpression )
            // InternalLts.g:2702:5: lv_value_4_0= ruleExpression
            {

            					newCompositeNode(grammarAccess.getColumnAssignmentAccess().getValueExpressionParserRuleCall_4_0());
            				
            pushFollow(FOLLOW_19);
            lv_value_4_0=ruleExpression();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getColumnAssignmentRule());
            					}
            					set(
            						current,
            						"value",
            						lv_value_4_0,
            						"org.example.lts.Lts.Expression");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_5=(Token)match(input,24,FOLLOW_2); 

            			newLeafNode(otherlv_5, grammarAccess.getColumnAssignmentAccess().getSemicolonKeyword_5());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleColumnAssignment"


    // $ANTLR start "entryRuleExpression"
    // InternalLts.g:2727:1: entryRuleExpression returns [EObject current=null] : iv_ruleExpression= ruleExpression EOF ;
    public final EObject entryRuleExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExpression = null;


        try {
            // InternalLts.g:2727:51: (iv_ruleExpression= ruleExpression EOF )
            // InternalLts.g:2728:2: iv_ruleExpression= ruleExpression EOF
            {
             newCompositeNode(grammarAccess.getExpressionRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleExpression=ruleExpression();

            state._fsp--;

             current =iv_ruleExpression; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleExpression"


    // $ANTLR start "ruleExpression"
    // InternalLts.g:2734:1: ruleExpression returns [EObject current=null] : this_OrExpression_0= ruleOrExpression ;
    public final EObject ruleExpression() throws RecognitionException {
        EObject current = null;

        EObject this_OrExpression_0 = null;



        	enterRule();

        try {
            // InternalLts.g:2740:2: (this_OrExpression_0= ruleOrExpression )
            // InternalLts.g:2741:2: this_OrExpression_0= ruleOrExpression
            {

            		newCompositeNode(grammarAccess.getExpressionAccess().getOrExpressionParserRuleCall());
            	
            pushFollow(FOLLOW_2);
            this_OrExpression_0=ruleOrExpression();

            state._fsp--;


            		current = this_OrExpression_0;
            		afterParserOrEnumRuleCall();
            	

            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleExpression"


    // $ANTLR start "entryRuleOrExpression"
    // InternalLts.g:2752:1: entryRuleOrExpression returns [EObject current=null] : iv_ruleOrExpression= ruleOrExpression EOF ;
    public final EObject entryRuleOrExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleOrExpression = null;


        try {
            // InternalLts.g:2752:53: (iv_ruleOrExpression= ruleOrExpression EOF )
            // InternalLts.g:2753:2: iv_ruleOrExpression= ruleOrExpression EOF
            {
             newCompositeNode(grammarAccess.getOrExpressionRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleOrExpression=ruleOrExpression();

            state._fsp--;

             current =iv_ruleOrExpression; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleOrExpression"


    // $ANTLR start "ruleOrExpression"
    // InternalLts.g:2759:1: ruleOrExpression returns [EObject current=null] : (this_AndExpression_0= ruleAndExpression ( () ( (lv_operator_2_0= 'or' ) ) ( (lv_right_3_0= ruleAndExpression ) ) )* ) ;
    public final EObject ruleOrExpression() throws RecognitionException {
        EObject current = null;

        Token lv_operator_2_0=null;
        EObject this_AndExpression_0 = null;

        EObject lv_right_3_0 = null;



        	enterRule();

        try {
            // InternalLts.g:2765:2: ( (this_AndExpression_0= ruleAndExpression ( () ( (lv_operator_2_0= 'or' ) ) ( (lv_right_3_0= ruleAndExpression ) ) )* ) )
            // InternalLts.g:2766:2: (this_AndExpression_0= ruleAndExpression ( () ( (lv_operator_2_0= 'or' ) ) ( (lv_right_3_0= ruleAndExpression ) ) )* )
            {
            // InternalLts.g:2766:2: (this_AndExpression_0= ruleAndExpression ( () ( (lv_operator_2_0= 'or' ) ) ( (lv_right_3_0= ruleAndExpression ) ) )* )
            // InternalLts.g:2767:3: this_AndExpression_0= ruleAndExpression ( () ( (lv_operator_2_0= 'or' ) ) ( (lv_right_3_0= ruleAndExpression ) ) )*
            {

            			newCompositeNode(grammarAccess.getOrExpressionAccess().getAndExpressionParserRuleCall_0());
            		
            pushFollow(FOLLOW_58);
            this_AndExpression_0=ruleAndExpression();

            state._fsp--;


            			current = this_AndExpression_0;
            			afterParserOrEnumRuleCall();
            		
            // InternalLts.g:2775:3: ( () ( (lv_operator_2_0= 'or' ) ) ( (lv_right_3_0= ruleAndExpression ) ) )*
            loop34:
            do {
                int alt34=2;
                int LA34_0 = input.LA(1);

                if ( (LA34_0==66) ) {
                    alt34=1;
                }


                switch (alt34) {
            	case 1 :
            	    // InternalLts.g:2776:4: () ( (lv_operator_2_0= 'or' ) ) ( (lv_right_3_0= ruleAndExpression ) )
            	    {
            	    // InternalLts.g:2776:4: ()
            	    // InternalLts.g:2777:5: 
            	    {

            	    					current = forceCreateModelElementAndSet(
            	    						grammarAccess.getOrExpressionAccess().getBinaryExpressionLeftAction_1_0(),
            	    						current);
            	    				

            	    }

            	    // InternalLts.g:2783:4: ( (lv_operator_2_0= 'or' ) )
            	    // InternalLts.g:2784:5: (lv_operator_2_0= 'or' )
            	    {
            	    // InternalLts.g:2784:5: (lv_operator_2_0= 'or' )
            	    // InternalLts.g:2785:6: lv_operator_2_0= 'or'
            	    {
            	    lv_operator_2_0=(Token)match(input,66,FOLLOW_37); 

            	    						newLeafNode(lv_operator_2_0, grammarAccess.getOrExpressionAccess().getOperatorOrKeyword_1_1_0());
            	    					

            	    						if (current==null) {
            	    							current = createModelElement(grammarAccess.getOrExpressionRule());
            	    						}
            	    						setWithLastConsumed(current, "operator", lv_operator_2_0, "or");
            	    					

            	    }


            	    }

            	    // InternalLts.g:2797:4: ( (lv_right_3_0= ruleAndExpression ) )
            	    // InternalLts.g:2798:5: (lv_right_3_0= ruleAndExpression )
            	    {
            	    // InternalLts.g:2798:5: (lv_right_3_0= ruleAndExpression )
            	    // InternalLts.g:2799:6: lv_right_3_0= ruleAndExpression
            	    {

            	    						newCompositeNode(grammarAccess.getOrExpressionAccess().getRightAndExpressionParserRuleCall_1_2_0());
            	    					
            	    pushFollow(FOLLOW_58);
            	    lv_right_3_0=ruleAndExpression();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getOrExpressionRule());
            	    						}
            	    						set(
            	    							current,
            	    							"right",
            	    							lv_right_3_0,
            	    							"org.example.lts.Lts.AndExpression");
            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop34;
                }
            } while (true);


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleOrExpression"


    // $ANTLR start "entryRuleAndExpression"
    // InternalLts.g:2821:1: entryRuleAndExpression returns [EObject current=null] : iv_ruleAndExpression= ruleAndExpression EOF ;
    public final EObject entryRuleAndExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAndExpression = null;


        try {
            // InternalLts.g:2821:54: (iv_ruleAndExpression= ruleAndExpression EOF )
            // InternalLts.g:2822:2: iv_ruleAndExpression= ruleAndExpression EOF
            {
             newCompositeNode(grammarAccess.getAndExpressionRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleAndExpression=ruleAndExpression();

            state._fsp--;

             current =iv_ruleAndExpression; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleAndExpression"


    // $ANTLR start "ruleAndExpression"
    // InternalLts.g:2828:1: ruleAndExpression returns [EObject current=null] : (this_EqualityExpression_0= ruleEqualityExpression ( () ( (lv_operator_2_0= 'and' ) ) ( (lv_right_3_0= ruleEqualityExpression ) ) )* ) ;
    public final EObject ruleAndExpression() throws RecognitionException {
        EObject current = null;

        Token lv_operator_2_0=null;
        EObject this_EqualityExpression_0 = null;

        EObject lv_right_3_0 = null;



        	enterRule();

        try {
            // InternalLts.g:2834:2: ( (this_EqualityExpression_0= ruleEqualityExpression ( () ( (lv_operator_2_0= 'and' ) ) ( (lv_right_3_0= ruleEqualityExpression ) ) )* ) )
            // InternalLts.g:2835:2: (this_EqualityExpression_0= ruleEqualityExpression ( () ( (lv_operator_2_0= 'and' ) ) ( (lv_right_3_0= ruleEqualityExpression ) ) )* )
            {
            // InternalLts.g:2835:2: (this_EqualityExpression_0= ruleEqualityExpression ( () ( (lv_operator_2_0= 'and' ) ) ( (lv_right_3_0= ruleEqualityExpression ) ) )* )
            // InternalLts.g:2836:3: this_EqualityExpression_0= ruleEqualityExpression ( () ( (lv_operator_2_0= 'and' ) ) ( (lv_right_3_0= ruleEqualityExpression ) ) )*
            {

            			newCompositeNode(grammarAccess.getAndExpressionAccess().getEqualityExpressionParserRuleCall_0());
            		
            pushFollow(FOLLOW_59);
            this_EqualityExpression_0=ruleEqualityExpression();

            state._fsp--;


            			current = this_EqualityExpression_0;
            			afterParserOrEnumRuleCall();
            		
            // InternalLts.g:2844:3: ( () ( (lv_operator_2_0= 'and' ) ) ( (lv_right_3_0= ruleEqualityExpression ) ) )*
            loop35:
            do {
                int alt35=2;
                int LA35_0 = input.LA(1);

                if ( (LA35_0==67) ) {
                    alt35=1;
                }


                switch (alt35) {
            	case 1 :
            	    // InternalLts.g:2845:4: () ( (lv_operator_2_0= 'and' ) ) ( (lv_right_3_0= ruleEqualityExpression ) )
            	    {
            	    // InternalLts.g:2845:4: ()
            	    // InternalLts.g:2846:5: 
            	    {

            	    					current = forceCreateModelElementAndSet(
            	    						grammarAccess.getAndExpressionAccess().getBinaryExpressionLeftAction_1_0(),
            	    						current);
            	    				

            	    }

            	    // InternalLts.g:2852:4: ( (lv_operator_2_0= 'and' ) )
            	    // InternalLts.g:2853:5: (lv_operator_2_0= 'and' )
            	    {
            	    // InternalLts.g:2853:5: (lv_operator_2_0= 'and' )
            	    // InternalLts.g:2854:6: lv_operator_2_0= 'and'
            	    {
            	    lv_operator_2_0=(Token)match(input,67,FOLLOW_37); 

            	    						newLeafNode(lv_operator_2_0, grammarAccess.getAndExpressionAccess().getOperatorAndKeyword_1_1_0());
            	    					

            	    						if (current==null) {
            	    							current = createModelElement(grammarAccess.getAndExpressionRule());
            	    						}
            	    						setWithLastConsumed(current, "operator", lv_operator_2_0, "and");
            	    					

            	    }


            	    }

            	    // InternalLts.g:2866:4: ( (lv_right_3_0= ruleEqualityExpression ) )
            	    // InternalLts.g:2867:5: (lv_right_3_0= ruleEqualityExpression )
            	    {
            	    // InternalLts.g:2867:5: (lv_right_3_0= ruleEqualityExpression )
            	    // InternalLts.g:2868:6: lv_right_3_0= ruleEqualityExpression
            	    {

            	    						newCompositeNode(grammarAccess.getAndExpressionAccess().getRightEqualityExpressionParserRuleCall_1_2_0());
            	    					
            	    pushFollow(FOLLOW_59);
            	    lv_right_3_0=ruleEqualityExpression();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getAndExpressionRule());
            	    						}
            	    						set(
            	    							current,
            	    							"right",
            	    							lv_right_3_0,
            	    							"org.example.lts.Lts.EqualityExpression");
            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop35;
                }
            } while (true);


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleAndExpression"


    // $ANTLR start "entryRuleEqualityExpression"
    // InternalLts.g:2890:1: entryRuleEqualityExpression returns [EObject current=null] : iv_ruleEqualityExpression= ruleEqualityExpression EOF ;
    public final EObject entryRuleEqualityExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEqualityExpression = null;


        try {
            // InternalLts.g:2890:59: (iv_ruleEqualityExpression= ruleEqualityExpression EOF )
            // InternalLts.g:2891:2: iv_ruleEqualityExpression= ruleEqualityExpression EOF
            {
             newCompositeNode(grammarAccess.getEqualityExpressionRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleEqualityExpression=ruleEqualityExpression();

            state._fsp--;

             current =iv_ruleEqualityExpression; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleEqualityExpression"


    // $ANTLR start "ruleEqualityExpression"
    // InternalLts.g:2897:1: ruleEqualityExpression returns [EObject current=null] : (this_RelationalExpression_0= ruleRelationalExpression ( () ( ( (lv_operator_2_1= '=' | lv_operator_2_2= '!=' ) ) ) ( (lv_right_3_0= ruleRelationalExpression ) ) )* ) ;
    public final EObject ruleEqualityExpression() throws RecognitionException {
        EObject current = null;

        Token lv_operator_2_1=null;
        Token lv_operator_2_2=null;
        EObject this_RelationalExpression_0 = null;

        EObject lv_right_3_0 = null;



        	enterRule();

        try {
            // InternalLts.g:2903:2: ( (this_RelationalExpression_0= ruleRelationalExpression ( () ( ( (lv_operator_2_1= '=' | lv_operator_2_2= '!=' ) ) ) ( (lv_right_3_0= ruleRelationalExpression ) ) )* ) )
            // InternalLts.g:2904:2: (this_RelationalExpression_0= ruleRelationalExpression ( () ( ( (lv_operator_2_1= '=' | lv_operator_2_2= '!=' ) ) ) ( (lv_right_3_0= ruleRelationalExpression ) ) )* )
            {
            // InternalLts.g:2904:2: (this_RelationalExpression_0= ruleRelationalExpression ( () ( ( (lv_operator_2_1= '=' | lv_operator_2_2= '!=' ) ) ) ( (lv_right_3_0= ruleRelationalExpression ) ) )* )
            // InternalLts.g:2905:3: this_RelationalExpression_0= ruleRelationalExpression ( () ( ( (lv_operator_2_1= '=' | lv_operator_2_2= '!=' ) ) ) ( (lv_right_3_0= ruleRelationalExpression ) ) )*
            {

            			newCompositeNode(grammarAccess.getEqualityExpressionAccess().getRelationalExpressionParserRuleCall_0());
            		
            pushFollow(FOLLOW_60);
            this_RelationalExpression_0=ruleRelationalExpression();

            state._fsp--;


            			current = this_RelationalExpression_0;
            			afterParserOrEnumRuleCall();
            		
            // InternalLts.g:2913:3: ( () ( ( (lv_operator_2_1= '=' | lv_operator_2_2= '!=' ) ) ) ( (lv_right_3_0= ruleRelationalExpression ) ) )*
            loop37:
            do {
                int alt37=2;
                int LA37_0 = input.LA(1);

                if ( (LA37_0==56||LA37_0==68) ) {
                    alt37=1;
                }


                switch (alt37) {
            	case 1 :
            	    // InternalLts.g:2914:4: () ( ( (lv_operator_2_1= '=' | lv_operator_2_2= '!=' ) ) ) ( (lv_right_3_0= ruleRelationalExpression ) )
            	    {
            	    // InternalLts.g:2914:4: ()
            	    // InternalLts.g:2915:5: 
            	    {

            	    					current = forceCreateModelElementAndSet(
            	    						grammarAccess.getEqualityExpressionAccess().getBinaryExpressionLeftAction_1_0(),
            	    						current);
            	    				

            	    }

            	    // InternalLts.g:2921:4: ( ( (lv_operator_2_1= '=' | lv_operator_2_2= '!=' ) ) )
            	    // InternalLts.g:2922:5: ( (lv_operator_2_1= '=' | lv_operator_2_2= '!=' ) )
            	    {
            	    // InternalLts.g:2922:5: ( (lv_operator_2_1= '=' | lv_operator_2_2= '!=' ) )
            	    // InternalLts.g:2923:6: (lv_operator_2_1= '=' | lv_operator_2_2= '!=' )
            	    {
            	    // InternalLts.g:2923:6: (lv_operator_2_1= '=' | lv_operator_2_2= '!=' )
            	    int alt36=2;
            	    int LA36_0 = input.LA(1);

            	    if ( (LA36_0==56) ) {
            	        alt36=1;
            	    }
            	    else if ( (LA36_0==68) ) {
            	        alt36=2;
            	    }
            	    else {
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 36, 0, input);

            	        throw nvae;
            	    }
            	    switch (alt36) {
            	        case 1 :
            	            // InternalLts.g:2924:7: lv_operator_2_1= '='
            	            {
            	            lv_operator_2_1=(Token)match(input,56,FOLLOW_37); 

            	            							newLeafNode(lv_operator_2_1, grammarAccess.getEqualityExpressionAccess().getOperatorEqualsSignKeyword_1_1_0_0());
            	            						

            	            							if (current==null) {
            	            								current = createModelElement(grammarAccess.getEqualityExpressionRule());
            	            							}
            	            							setWithLastConsumed(current, "operator", lv_operator_2_1, null);
            	            						

            	            }
            	            break;
            	        case 2 :
            	            // InternalLts.g:2935:7: lv_operator_2_2= '!='
            	            {
            	            lv_operator_2_2=(Token)match(input,68,FOLLOW_37); 

            	            							newLeafNode(lv_operator_2_2, grammarAccess.getEqualityExpressionAccess().getOperatorExclamationMarkEqualsSignKeyword_1_1_0_1());
            	            						

            	            							if (current==null) {
            	            								current = createModelElement(grammarAccess.getEqualityExpressionRule());
            	            							}
            	            							setWithLastConsumed(current, "operator", lv_operator_2_2, null);
            	            						

            	            }
            	            break;

            	    }


            	    }


            	    }

            	    // InternalLts.g:2948:4: ( (lv_right_3_0= ruleRelationalExpression ) )
            	    // InternalLts.g:2949:5: (lv_right_3_0= ruleRelationalExpression )
            	    {
            	    // InternalLts.g:2949:5: (lv_right_3_0= ruleRelationalExpression )
            	    // InternalLts.g:2950:6: lv_right_3_0= ruleRelationalExpression
            	    {

            	    						newCompositeNode(grammarAccess.getEqualityExpressionAccess().getRightRelationalExpressionParserRuleCall_1_2_0());
            	    					
            	    pushFollow(FOLLOW_60);
            	    lv_right_3_0=ruleRelationalExpression();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getEqualityExpressionRule());
            	    						}
            	    						set(
            	    							current,
            	    							"right",
            	    							lv_right_3_0,
            	    							"org.example.lts.Lts.RelationalExpression");
            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop37;
                }
            } while (true);


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleEqualityExpression"


    // $ANTLR start "entryRuleRelationalExpression"
    // InternalLts.g:2972:1: entryRuleRelationalExpression returns [EObject current=null] : iv_ruleRelationalExpression= ruleRelationalExpression EOF ;
    public final EObject entryRuleRelationalExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRelationalExpression = null;


        try {
            // InternalLts.g:2972:61: (iv_ruleRelationalExpression= ruleRelationalExpression EOF )
            // InternalLts.g:2973:2: iv_ruleRelationalExpression= ruleRelationalExpression EOF
            {
             newCompositeNode(grammarAccess.getRelationalExpressionRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleRelationalExpression=ruleRelationalExpression();

            state._fsp--;

             current =iv_ruleRelationalExpression; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleRelationalExpression"


    // $ANTLR start "ruleRelationalExpression"
    // InternalLts.g:2979:1: ruleRelationalExpression returns [EObject current=null] : (this_AdditiveExpression_0= ruleAdditiveExpression ( () ( ( (lv_operator_2_1= '<' | lv_operator_2_2= '<=' | lv_operator_2_3= '>' | lv_operator_2_4= '>=' ) ) ) ( (lv_right_3_0= ruleAdditiveExpression ) ) )* ) ;
    public final EObject ruleRelationalExpression() throws RecognitionException {
        EObject current = null;

        Token lv_operator_2_1=null;
        Token lv_operator_2_2=null;
        Token lv_operator_2_3=null;
        Token lv_operator_2_4=null;
        EObject this_AdditiveExpression_0 = null;

        EObject lv_right_3_0 = null;



        	enterRule();

        try {
            // InternalLts.g:2985:2: ( (this_AdditiveExpression_0= ruleAdditiveExpression ( () ( ( (lv_operator_2_1= '<' | lv_operator_2_2= '<=' | lv_operator_2_3= '>' | lv_operator_2_4= '>=' ) ) ) ( (lv_right_3_0= ruleAdditiveExpression ) ) )* ) )
            // InternalLts.g:2986:2: (this_AdditiveExpression_0= ruleAdditiveExpression ( () ( ( (lv_operator_2_1= '<' | lv_operator_2_2= '<=' | lv_operator_2_3= '>' | lv_operator_2_4= '>=' ) ) ) ( (lv_right_3_0= ruleAdditiveExpression ) ) )* )
            {
            // InternalLts.g:2986:2: (this_AdditiveExpression_0= ruleAdditiveExpression ( () ( ( (lv_operator_2_1= '<' | lv_operator_2_2= '<=' | lv_operator_2_3= '>' | lv_operator_2_4= '>=' ) ) ) ( (lv_right_3_0= ruleAdditiveExpression ) ) )* )
            // InternalLts.g:2987:3: this_AdditiveExpression_0= ruleAdditiveExpression ( () ( ( (lv_operator_2_1= '<' | lv_operator_2_2= '<=' | lv_operator_2_3= '>' | lv_operator_2_4= '>=' ) ) ) ( (lv_right_3_0= ruleAdditiveExpression ) ) )*
            {

            			newCompositeNode(grammarAccess.getRelationalExpressionAccess().getAdditiveExpressionParserRuleCall_0());
            		
            pushFollow(FOLLOW_61);
            this_AdditiveExpression_0=ruleAdditiveExpression();

            state._fsp--;


            			current = this_AdditiveExpression_0;
            			afterParserOrEnumRuleCall();
            		
            // InternalLts.g:2995:3: ( () ( ( (lv_operator_2_1= '<' | lv_operator_2_2= '<=' | lv_operator_2_3= '>' | lv_operator_2_4= '>=' ) ) ) ( (lv_right_3_0= ruleAdditiveExpression ) ) )*
            loop39:
            do {
                int alt39=2;
                int LA39_0 = input.LA(1);

                if ( ((LA39_0>=69 && LA39_0<=72)) ) {
                    alt39=1;
                }


                switch (alt39) {
            	case 1 :
            	    // InternalLts.g:2996:4: () ( ( (lv_operator_2_1= '<' | lv_operator_2_2= '<=' | lv_operator_2_3= '>' | lv_operator_2_4= '>=' ) ) ) ( (lv_right_3_0= ruleAdditiveExpression ) )
            	    {
            	    // InternalLts.g:2996:4: ()
            	    // InternalLts.g:2997:5: 
            	    {

            	    					current = forceCreateModelElementAndSet(
            	    						grammarAccess.getRelationalExpressionAccess().getBinaryExpressionLeftAction_1_0(),
            	    						current);
            	    				

            	    }

            	    // InternalLts.g:3003:4: ( ( (lv_operator_2_1= '<' | lv_operator_2_2= '<=' | lv_operator_2_3= '>' | lv_operator_2_4= '>=' ) ) )
            	    // InternalLts.g:3004:5: ( (lv_operator_2_1= '<' | lv_operator_2_2= '<=' | lv_operator_2_3= '>' | lv_operator_2_4= '>=' ) )
            	    {
            	    // InternalLts.g:3004:5: ( (lv_operator_2_1= '<' | lv_operator_2_2= '<=' | lv_operator_2_3= '>' | lv_operator_2_4= '>=' ) )
            	    // InternalLts.g:3005:6: (lv_operator_2_1= '<' | lv_operator_2_2= '<=' | lv_operator_2_3= '>' | lv_operator_2_4= '>=' )
            	    {
            	    // InternalLts.g:3005:6: (lv_operator_2_1= '<' | lv_operator_2_2= '<=' | lv_operator_2_3= '>' | lv_operator_2_4= '>=' )
            	    int alt38=4;
            	    switch ( input.LA(1) ) {
            	    case 69:
            	        {
            	        alt38=1;
            	        }
            	        break;
            	    case 70:
            	        {
            	        alt38=2;
            	        }
            	        break;
            	    case 71:
            	        {
            	        alt38=3;
            	        }
            	        break;
            	    case 72:
            	        {
            	        alt38=4;
            	        }
            	        break;
            	    default:
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 38, 0, input);

            	        throw nvae;
            	    }

            	    switch (alt38) {
            	        case 1 :
            	            // InternalLts.g:3006:7: lv_operator_2_1= '<'
            	            {
            	            lv_operator_2_1=(Token)match(input,69,FOLLOW_37); 

            	            							newLeafNode(lv_operator_2_1, grammarAccess.getRelationalExpressionAccess().getOperatorLessThanSignKeyword_1_1_0_0());
            	            						

            	            							if (current==null) {
            	            								current = createModelElement(grammarAccess.getRelationalExpressionRule());
            	            							}
            	            							setWithLastConsumed(current, "operator", lv_operator_2_1, null);
            	            						

            	            }
            	            break;
            	        case 2 :
            	            // InternalLts.g:3017:7: lv_operator_2_2= '<='
            	            {
            	            lv_operator_2_2=(Token)match(input,70,FOLLOW_37); 

            	            							newLeafNode(lv_operator_2_2, grammarAccess.getRelationalExpressionAccess().getOperatorLessThanSignEqualsSignKeyword_1_1_0_1());
            	            						

            	            							if (current==null) {
            	            								current = createModelElement(grammarAccess.getRelationalExpressionRule());
            	            							}
            	            							setWithLastConsumed(current, "operator", lv_operator_2_2, null);
            	            						

            	            }
            	            break;
            	        case 3 :
            	            // InternalLts.g:3028:7: lv_operator_2_3= '>'
            	            {
            	            lv_operator_2_3=(Token)match(input,71,FOLLOW_37); 

            	            							newLeafNode(lv_operator_2_3, grammarAccess.getRelationalExpressionAccess().getOperatorGreaterThanSignKeyword_1_1_0_2());
            	            						

            	            							if (current==null) {
            	            								current = createModelElement(grammarAccess.getRelationalExpressionRule());
            	            							}
            	            							setWithLastConsumed(current, "operator", lv_operator_2_3, null);
            	            						

            	            }
            	            break;
            	        case 4 :
            	            // InternalLts.g:3039:7: lv_operator_2_4= '>='
            	            {
            	            lv_operator_2_4=(Token)match(input,72,FOLLOW_37); 

            	            							newLeafNode(lv_operator_2_4, grammarAccess.getRelationalExpressionAccess().getOperatorGreaterThanSignEqualsSignKeyword_1_1_0_3());
            	            						

            	            							if (current==null) {
            	            								current = createModelElement(grammarAccess.getRelationalExpressionRule());
            	            							}
            	            							setWithLastConsumed(current, "operator", lv_operator_2_4, null);
            	            						

            	            }
            	            break;

            	    }


            	    }


            	    }

            	    // InternalLts.g:3052:4: ( (lv_right_3_0= ruleAdditiveExpression ) )
            	    // InternalLts.g:3053:5: (lv_right_3_0= ruleAdditiveExpression )
            	    {
            	    // InternalLts.g:3053:5: (lv_right_3_0= ruleAdditiveExpression )
            	    // InternalLts.g:3054:6: lv_right_3_0= ruleAdditiveExpression
            	    {

            	    						newCompositeNode(grammarAccess.getRelationalExpressionAccess().getRightAdditiveExpressionParserRuleCall_1_2_0());
            	    					
            	    pushFollow(FOLLOW_61);
            	    lv_right_3_0=ruleAdditiveExpression();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getRelationalExpressionRule());
            	    						}
            	    						set(
            	    							current,
            	    							"right",
            	    							lv_right_3_0,
            	    							"org.example.lts.Lts.AdditiveExpression");
            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop39;
                }
            } while (true);


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleRelationalExpression"


    // $ANTLR start "entryRuleAdditiveExpression"
    // InternalLts.g:3076:1: entryRuleAdditiveExpression returns [EObject current=null] : iv_ruleAdditiveExpression= ruleAdditiveExpression EOF ;
    public final EObject entryRuleAdditiveExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAdditiveExpression = null;


        try {
            // InternalLts.g:3076:59: (iv_ruleAdditiveExpression= ruleAdditiveExpression EOF )
            // InternalLts.g:3077:2: iv_ruleAdditiveExpression= ruleAdditiveExpression EOF
            {
             newCompositeNode(grammarAccess.getAdditiveExpressionRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleAdditiveExpression=ruleAdditiveExpression();

            state._fsp--;

             current =iv_ruleAdditiveExpression; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleAdditiveExpression"


    // $ANTLR start "ruleAdditiveExpression"
    // InternalLts.g:3083:1: ruleAdditiveExpression returns [EObject current=null] : (this_MultiplicativeExpression_0= ruleMultiplicativeExpression ( () ( ( (lv_operator_2_1= '+' | lv_operator_2_2= '-' | lv_operator_2_3= '&' ) ) ) ( (lv_right_3_0= ruleMultiplicativeExpression ) ) )* ) ;
    public final EObject ruleAdditiveExpression() throws RecognitionException {
        EObject current = null;

        Token lv_operator_2_1=null;
        Token lv_operator_2_2=null;
        Token lv_operator_2_3=null;
        EObject this_MultiplicativeExpression_0 = null;

        EObject lv_right_3_0 = null;



        	enterRule();

        try {
            // InternalLts.g:3089:2: ( (this_MultiplicativeExpression_0= ruleMultiplicativeExpression ( () ( ( (lv_operator_2_1= '+' | lv_operator_2_2= '-' | lv_operator_2_3= '&' ) ) ) ( (lv_right_3_0= ruleMultiplicativeExpression ) ) )* ) )
            // InternalLts.g:3090:2: (this_MultiplicativeExpression_0= ruleMultiplicativeExpression ( () ( ( (lv_operator_2_1= '+' | lv_operator_2_2= '-' | lv_operator_2_3= '&' ) ) ) ( (lv_right_3_0= ruleMultiplicativeExpression ) ) )* )
            {
            // InternalLts.g:3090:2: (this_MultiplicativeExpression_0= ruleMultiplicativeExpression ( () ( ( (lv_operator_2_1= '+' | lv_operator_2_2= '-' | lv_operator_2_3= '&' ) ) ) ( (lv_right_3_0= ruleMultiplicativeExpression ) ) )* )
            // InternalLts.g:3091:3: this_MultiplicativeExpression_0= ruleMultiplicativeExpression ( () ( ( (lv_operator_2_1= '+' | lv_operator_2_2= '-' | lv_operator_2_3= '&' ) ) ) ( (lv_right_3_0= ruleMultiplicativeExpression ) ) )*
            {

            			newCompositeNode(grammarAccess.getAdditiveExpressionAccess().getMultiplicativeExpressionParserRuleCall_0());
            		
            pushFollow(FOLLOW_62);
            this_MultiplicativeExpression_0=ruleMultiplicativeExpression();

            state._fsp--;


            			current = this_MultiplicativeExpression_0;
            			afterParserOrEnumRuleCall();
            		
            // InternalLts.g:3099:3: ( () ( ( (lv_operator_2_1= '+' | lv_operator_2_2= '-' | lv_operator_2_3= '&' ) ) ) ( (lv_right_3_0= ruleMultiplicativeExpression ) ) )*
            loop41:
            do {
                int alt41=2;
                int LA41_0 = input.LA(1);

                if ( ((LA41_0>=73 && LA41_0<=75)) ) {
                    alt41=1;
                }


                switch (alt41) {
            	case 1 :
            	    // InternalLts.g:3100:4: () ( ( (lv_operator_2_1= '+' | lv_operator_2_2= '-' | lv_operator_2_3= '&' ) ) ) ( (lv_right_3_0= ruleMultiplicativeExpression ) )
            	    {
            	    // InternalLts.g:3100:4: ()
            	    // InternalLts.g:3101:5: 
            	    {

            	    					current = forceCreateModelElementAndSet(
            	    						grammarAccess.getAdditiveExpressionAccess().getBinaryExpressionLeftAction_1_0(),
            	    						current);
            	    				

            	    }

            	    // InternalLts.g:3107:4: ( ( (lv_operator_2_1= '+' | lv_operator_2_2= '-' | lv_operator_2_3= '&' ) ) )
            	    // InternalLts.g:3108:5: ( (lv_operator_2_1= '+' | lv_operator_2_2= '-' | lv_operator_2_3= '&' ) )
            	    {
            	    // InternalLts.g:3108:5: ( (lv_operator_2_1= '+' | lv_operator_2_2= '-' | lv_operator_2_3= '&' ) )
            	    // InternalLts.g:3109:6: (lv_operator_2_1= '+' | lv_operator_2_2= '-' | lv_operator_2_3= '&' )
            	    {
            	    // InternalLts.g:3109:6: (lv_operator_2_1= '+' | lv_operator_2_2= '-' | lv_operator_2_3= '&' )
            	    int alt40=3;
            	    switch ( input.LA(1) ) {
            	    case 73:
            	        {
            	        alt40=1;
            	        }
            	        break;
            	    case 74:
            	        {
            	        alt40=2;
            	        }
            	        break;
            	    case 75:
            	        {
            	        alt40=3;
            	        }
            	        break;
            	    default:
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 40, 0, input);

            	        throw nvae;
            	    }

            	    switch (alt40) {
            	        case 1 :
            	            // InternalLts.g:3110:7: lv_operator_2_1= '+'
            	            {
            	            lv_operator_2_1=(Token)match(input,73,FOLLOW_37); 

            	            							newLeafNode(lv_operator_2_1, grammarAccess.getAdditiveExpressionAccess().getOperatorPlusSignKeyword_1_1_0_0());
            	            						

            	            							if (current==null) {
            	            								current = createModelElement(grammarAccess.getAdditiveExpressionRule());
            	            							}
            	            							setWithLastConsumed(current, "operator", lv_operator_2_1, null);
            	            						

            	            }
            	            break;
            	        case 2 :
            	            // InternalLts.g:3121:7: lv_operator_2_2= '-'
            	            {
            	            lv_operator_2_2=(Token)match(input,74,FOLLOW_37); 

            	            							newLeafNode(lv_operator_2_2, grammarAccess.getAdditiveExpressionAccess().getOperatorHyphenMinusKeyword_1_1_0_1());
            	            						

            	            							if (current==null) {
            	            								current = createModelElement(grammarAccess.getAdditiveExpressionRule());
            	            							}
            	            							setWithLastConsumed(current, "operator", lv_operator_2_2, null);
            	            						

            	            }
            	            break;
            	        case 3 :
            	            // InternalLts.g:3132:7: lv_operator_2_3= '&'
            	            {
            	            lv_operator_2_3=(Token)match(input,75,FOLLOW_37); 

            	            							newLeafNode(lv_operator_2_3, grammarAccess.getAdditiveExpressionAccess().getOperatorAmpersandKeyword_1_1_0_2());
            	            						

            	            							if (current==null) {
            	            								current = createModelElement(grammarAccess.getAdditiveExpressionRule());
            	            							}
            	            							setWithLastConsumed(current, "operator", lv_operator_2_3, null);
            	            						

            	            }
            	            break;

            	    }


            	    }


            	    }

            	    // InternalLts.g:3145:4: ( (lv_right_3_0= ruleMultiplicativeExpression ) )
            	    // InternalLts.g:3146:5: (lv_right_3_0= ruleMultiplicativeExpression )
            	    {
            	    // InternalLts.g:3146:5: (lv_right_3_0= ruleMultiplicativeExpression )
            	    // InternalLts.g:3147:6: lv_right_3_0= ruleMultiplicativeExpression
            	    {

            	    						newCompositeNode(grammarAccess.getAdditiveExpressionAccess().getRightMultiplicativeExpressionParserRuleCall_1_2_0());
            	    					
            	    pushFollow(FOLLOW_62);
            	    lv_right_3_0=ruleMultiplicativeExpression();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getAdditiveExpressionRule());
            	    						}
            	    						set(
            	    							current,
            	    							"right",
            	    							lv_right_3_0,
            	    							"org.example.lts.Lts.MultiplicativeExpression");
            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop41;
                }
            } while (true);


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleAdditiveExpression"


    // $ANTLR start "entryRuleMultiplicativeExpression"
    // InternalLts.g:3169:1: entryRuleMultiplicativeExpression returns [EObject current=null] : iv_ruleMultiplicativeExpression= ruleMultiplicativeExpression EOF ;
    public final EObject entryRuleMultiplicativeExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMultiplicativeExpression = null;


        try {
            // InternalLts.g:3169:65: (iv_ruleMultiplicativeExpression= ruleMultiplicativeExpression EOF )
            // InternalLts.g:3170:2: iv_ruleMultiplicativeExpression= ruleMultiplicativeExpression EOF
            {
             newCompositeNode(grammarAccess.getMultiplicativeExpressionRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleMultiplicativeExpression=ruleMultiplicativeExpression();

            state._fsp--;

             current =iv_ruleMultiplicativeExpression; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleMultiplicativeExpression"


    // $ANTLR start "ruleMultiplicativeExpression"
    // InternalLts.g:3176:1: ruleMultiplicativeExpression returns [EObject current=null] : (this_UnaryExpression_0= ruleUnaryExpression ( () ( ( (lv_operator_2_1= '*' | lv_operator_2_2= '/' ) ) ) ( (lv_right_3_0= ruleUnaryExpression ) ) )* ) ;
    public final EObject ruleMultiplicativeExpression() throws RecognitionException {
        EObject current = null;

        Token lv_operator_2_1=null;
        Token lv_operator_2_2=null;
        EObject this_UnaryExpression_0 = null;

        EObject lv_right_3_0 = null;



        	enterRule();

        try {
            // InternalLts.g:3182:2: ( (this_UnaryExpression_0= ruleUnaryExpression ( () ( ( (lv_operator_2_1= '*' | lv_operator_2_2= '/' ) ) ) ( (lv_right_3_0= ruleUnaryExpression ) ) )* ) )
            // InternalLts.g:3183:2: (this_UnaryExpression_0= ruleUnaryExpression ( () ( ( (lv_operator_2_1= '*' | lv_operator_2_2= '/' ) ) ) ( (lv_right_3_0= ruleUnaryExpression ) ) )* )
            {
            // InternalLts.g:3183:2: (this_UnaryExpression_0= ruleUnaryExpression ( () ( ( (lv_operator_2_1= '*' | lv_operator_2_2= '/' ) ) ) ( (lv_right_3_0= ruleUnaryExpression ) ) )* )
            // InternalLts.g:3184:3: this_UnaryExpression_0= ruleUnaryExpression ( () ( ( (lv_operator_2_1= '*' | lv_operator_2_2= '/' ) ) ) ( (lv_right_3_0= ruleUnaryExpression ) ) )*
            {

            			newCompositeNode(grammarAccess.getMultiplicativeExpressionAccess().getUnaryExpressionParserRuleCall_0());
            		
            pushFollow(FOLLOW_63);
            this_UnaryExpression_0=ruleUnaryExpression();

            state._fsp--;


            			current = this_UnaryExpression_0;
            			afterParserOrEnumRuleCall();
            		
            // InternalLts.g:3192:3: ( () ( ( (lv_operator_2_1= '*' | lv_operator_2_2= '/' ) ) ) ( (lv_right_3_0= ruleUnaryExpression ) ) )*
            loop43:
            do {
                int alt43=2;
                int LA43_0 = input.LA(1);

                if ( ((LA43_0>=76 && LA43_0<=77)) ) {
                    alt43=1;
                }


                switch (alt43) {
            	case 1 :
            	    // InternalLts.g:3193:4: () ( ( (lv_operator_2_1= '*' | lv_operator_2_2= '/' ) ) ) ( (lv_right_3_0= ruleUnaryExpression ) )
            	    {
            	    // InternalLts.g:3193:4: ()
            	    // InternalLts.g:3194:5: 
            	    {

            	    					current = forceCreateModelElementAndSet(
            	    						grammarAccess.getMultiplicativeExpressionAccess().getBinaryExpressionLeftAction_1_0(),
            	    						current);
            	    				

            	    }

            	    // InternalLts.g:3200:4: ( ( (lv_operator_2_1= '*' | lv_operator_2_2= '/' ) ) )
            	    // InternalLts.g:3201:5: ( (lv_operator_2_1= '*' | lv_operator_2_2= '/' ) )
            	    {
            	    // InternalLts.g:3201:5: ( (lv_operator_2_1= '*' | lv_operator_2_2= '/' ) )
            	    // InternalLts.g:3202:6: (lv_operator_2_1= '*' | lv_operator_2_2= '/' )
            	    {
            	    // InternalLts.g:3202:6: (lv_operator_2_1= '*' | lv_operator_2_2= '/' )
            	    int alt42=2;
            	    int LA42_0 = input.LA(1);

            	    if ( (LA42_0==76) ) {
            	        alt42=1;
            	    }
            	    else if ( (LA42_0==77) ) {
            	        alt42=2;
            	    }
            	    else {
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 42, 0, input);

            	        throw nvae;
            	    }
            	    switch (alt42) {
            	        case 1 :
            	            // InternalLts.g:3203:7: lv_operator_2_1= '*'
            	            {
            	            lv_operator_2_1=(Token)match(input,76,FOLLOW_37); 

            	            							newLeafNode(lv_operator_2_1, grammarAccess.getMultiplicativeExpressionAccess().getOperatorAsteriskKeyword_1_1_0_0());
            	            						

            	            							if (current==null) {
            	            								current = createModelElement(grammarAccess.getMultiplicativeExpressionRule());
            	            							}
            	            							setWithLastConsumed(current, "operator", lv_operator_2_1, null);
            	            						

            	            }
            	            break;
            	        case 2 :
            	            // InternalLts.g:3214:7: lv_operator_2_2= '/'
            	            {
            	            lv_operator_2_2=(Token)match(input,77,FOLLOW_37); 

            	            							newLeafNode(lv_operator_2_2, grammarAccess.getMultiplicativeExpressionAccess().getOperatorSolidusKeyword_1_1_0_1());
            	            						

            	            							if (current==null) {
            	            								current = createModelElement(grammarAccess.getMultiplicativeExpressionRule());
            	            							}
            	            							setWithLastConsumed(current, "operator", lv_operator_2_2, null);
            	            						

            	            }
            	            break;

            	    }


            	    }


            	    }

            	    // InternalLts.g:3227:4: ( (lv_right_3_0= ruleUnaryExpression ) )
            	    // InternalLts.g:3228:5: (lv_right_3_0= ruleUnaryExpression )
            	    {
            	    // InternalLts.g:3228:5: (lv_right_3_0= ruleUnaryExpression )
            	    // InternalLts.g:3229:6: lv_right_3_0= ruleUnaryExpression
            	    {

            	    						newCompositeNode(grammarAccess.getMultiplicativeExpressionAccess().getRightUnaryExpressionParserRuleCall_1_2_0());
            	    					
            	    pushFollow(FOLLOW_63);
            	    lv_right_3_0=ruleUnaryExpression();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getMultiplicativeExpressionRule());
            	    						}
            	    						set(
            	    							current,
            	    							"right",
            	    							lv_right_3_0,
            	    							"org.example.lts.Lts.UnaryExpression");
            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop43;
                }
            } while (true);


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleMultiplicativeExpression"


    // $ANTLR start "entryRuleUnaryExpression"
    // InternalLts.g:3251:1: entryRuleUnaryExpression returns [EObject current=null] : iv_ruleUnaryExpression= ruleUnaryExpression EOF ;
    public final EObject entryRuleUnaryExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleUnaryExpression = null;


        try {
            // InternalLts.g:3251:56: (iv_ruleUnaryExpression= ruleUnaryExpression EOF )
            // InternalLts.g:3252:2: iv_ruleUnaryExpression= ruleUnaryExpression EOF
            {
             newCompositeNode(grammarAccess.getUnaryExpressionRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleUnaryExpression=ruleUnaryExpression();

            state._fsp--;

             current =iv_ruleUnaryExpression; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleUnaryExpression"


    // $ANTLR start "ruleUnaryExpression"
    // InternalLts.g:3258:1: ruleUnaryExpression returns [EObject current=null] : ( ( () ( ( (lv_operator_1_1= 'not' | lv_operator_1_2= '-' ) ) ) ( (lv_operand_2_0= ruleUnaryExpression ) ) ) | this_PrimaryExpression_3= rulePrimaryExpression ) ;
    public final EObject ruleUnaryExpression() throws RecognitionException {
        EObject current = null;

        Token lv_operator_1_1=null;
        Token lv_operator_1_2=null;
        EObject lv_operand_2_0 = null;

        EObject this_PrimaryExpression_3 = null;



        	enterRule();

        try {
            // InternalLts.g:3264:2: ( ( ( () ( ( (lv_operator_1_1= 'not' | lv_operator_1_2= '-' ) ) ) ( (lv_operand_2_0= ruleUnaryExpression ) ) ) | this_PrimaryExpression_3= rulePrimaryExpression ) )
            // InternalLts.g:3265:2: ( ( () ( ( (lv_operator_1_1= 'not' | lv_operator_1_2= '-' ) ) ) ( (lv_operand_2_0= ruleUnaryExpression ) ) ) | this_PrimaryExpression_3= rulePrimaryExpression )
            {
            // InternalLts.g:3265:2: ( ( () ( ( (lv_operator_1_1= 'not' | lv_operator_1_2= '-' ) ) ) ( (lv_operand_2_0= ruleUnaryExpression ) ) ) | this_PrimaryExpression_3= rulePrimaryExpression )
            int alt45=2;
            int LA45_0 = input.LA(1);

            if ( (LA45_0==74||LA45_0==78) ) {
                alt45=1;
            }
            else if ( ((LA45_0>=RULE_ID && LA45_0<=RULE_INT)||LA45_0==32||(LA45_0>=79 && LA45_0<=81)) ) {
                alt45=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 45, 0, input);

                throw nvae;
            }
            switch (alt45) {
                case 1 :
                    // InternalLts.g:3266:3: ( () ( ( (lv_operator_1_1= 'not' | lv_operator_1_2= '-' ) ) ) ( (lv_operand_2_0= ruleUnaryExpression ) ) )
                    {
                    // InternalLts.g:3266:3: ( () ( ( (lv_operator_1_1= 'not' | lv_operator_1_2= '-' ) ) ) ( (lv_operand_2_0= ruleUnaryExpression ) ) )
                    // InternalLts.g:3267:4: () ( ( (lv_operator_1_1= 'not' | lv_operator_1_2= '-' ) ) ) ( (lv_operand_2_0= ruleUnaryExpression ) )
                    {
                    // InternalLts.g:3267:4: ()
                    // InternalLts.g:3268:5: 
                    {

                    					current = forceCreateModelElement(
                    						grammarAccess.getUnaryExpressionAccess().getUnaryExpressionAction_0_0(),
                    						current);
                    				

                    }

                    // InternalLts.g:3274:4: ( ( (lv_operator_1_1= 'not' | lv_operator_1_2= '-' ) ) )
                    // InternalLts.g:3275:5: ( (lv_operator_1_1= 'not' | lv_operator_1_2= '-' ) )
                    {
                    // InternalLts.g:3275:5: ( (lv_operator_1_1= 'not' | lv_operator_1_2= '-' ) )
                    // InternalLts.g:3276:6: (lv_operator_1_1= 'not' | lv_operator_1_2= '-' )
                    {
                    // InternalLts.g:3276:6: (lv_operator_1_1= 'not' | lv_operator_1_2= '-' )
                    int alt44=2;
                    int LA44_0 = input.LA(1);

                    if ( (LA44_0==78) ) {
                        alt44=1;
                    }
                    else if ( (LA44_0==74) ) {
                        alt44=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 44, 0, input);

                        throw nvae;
                    }
                    switch (alt44) {
                        case 1 :
                            // InternalLts.g:3277:7: lv_operator_1_1= 'not'
                            {
                            lv_operator_1_1=(Token)match(input,78,FOLLOW_37); 

                            							newLeafNode(lv_operator_1_1, grammarAccess.getUnaryExpressionAccess().getOperatorNotKeyword_0_1_0_0());
                            						

                            							if (current==null) {
                            								current = createModelElement(grammarAccess.getUnaryExpressionRule());
                            							}
                            							setWithLastConsumed(current, "operator", lv_operator_1_1, null);
                            						

                            }
                            break;
                        case 2 :
                            // InternalLts.g:3288:7: lv_operator_1_2= '-'
                            {
                            lv_operator_1_2=(Token)match(input,74,FOLLOW_37); 

                            							newLeafNode(lv_operator_1_2, grammarAccess.getUnaryExpressionAccess().getOperatorHyphenMinusKeyword_0_1_0_1());
                            						

                            							if (current==null) {
                            								current = createModelElement(grammarAccess.getUnaryExpressionRule());
                            							}
                            							setWithLastConsumed(current, "operator", lv_operator_1_2, null);
                            						

                            }
                            break;

                    }


                    }


                    }

                    // InternalLts.g:3301:4: ( (lv_operand_2_0= ruleUnaryExpression ) )
                    // InternalLts.g:3302:5: (lv_operand_2_0= ruleUnaryExpression )
                    {
                    // InternalLts.g:3302:5: (lv_operand_2_0= ruleUnaryExpression )
                    // InternalLts.g:3303:6: lv_operand_2_0= ruleUnaryExpression
                    {

                    						newCompositeNode(grammarAccess.getUnaryExpressionAccess().getOperandUnaryExpressionParserRuleCall_0_2_0());
                    					
                    pushFollow(FOLLOW_2);
                    lv_operand_2_0=ruleUnaryExpression();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getUnaryExpressionRule());
                    						}
                    						set(
                    							current,
                    							"operand",
                    							lv_operand_2_0,
                    							"org.example.lts.Lts.UnaryExpression");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalLts.g:3322:3: this_PrimaryExpression_3= rulePrimaryExpression
                    {

                    			newCompositeNode(grammarAccess.getUnaryExpressionAccess().getPrimaryExpressionParserRuleCall_1());
                    		
                    pushFollow(FOLLOW_2);
                    this_PrimaryExpression_3=rulePrimaryExpression();

                    state._fsp--;


                    			current = this_PrimaryExpression_3;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleUnaryExpression"


    // $ANTLR start "entryRulePrimaryExpression"
    // InternalLts.g:3334:1: entryRulePrimaryExpression returns [EObject current=null] : iv_rulePrimaryExpression= rulePrimaryExpression EOF ;
    public final EObject entryRulePrimaryExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePrimaryExpression = null;


        try {
            // InternalLts.g:3334:58: (iv_rulePrimaryExpression= rulePrimaryExpression EOF )
            // InternalLts.g:3335:2: iv_rulePrimaryExpression= rulePrimaryExpression EOF
            {
             newCompositeNode(grammarAccess.getPrimaryExpressionRule()); 
            pushFollow(FOLLOW_1);
            iv_rulePrimaryExpression=rulePrimaryExpression();

            state._fsp--;

             current =iv_rulePrimaryExpression; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRulePrimaryExpression"


    // $ANTLR start "rulePrimaryExpression"
    // InternalLts.g:3341:1: rulePrimaryExpression returns [EObject current=null] : (this_ColumnReference_0= ruleColumnReference | this_FunctionCall_1= ruleFunctionCall | this_StringLiteral_2= ruleStringLiteral | this_DecimalLiteral_3= ruleDecimalLiteral | this_IntegerLiteral_4= ruleIntegerLiteral | this_BooleanValue_5= ruleBooleanValue | this_NullLiteral_6= ruleNullLiteral | (otherlv_7= '(' this_Expression_8= ruleExpression otherlv_9= ')' ) ) ;
    public final EObject rulePrimaryExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_7=null;
        Token otherlv_9=null;
        EObject this_ColumnReference_0 = null;

        EObject this_FunctionCall_1 = null;

        EObject this_StringLiteral_2 = null;

        EObject this_DecimalLiteral_3 = null;

        EObject this_IntegerLiteral_4 = null;

        EObject this_BooleanValue_5 = null;

        EObject this_NullLiteral_6 = null;

        EObject this_Expression_8 = null;



        	enterRule();

        try {
            // InternalLts.g:3347:2: ( (this_ColumnReference_0= ruleColumnReference | this_FunctionCall_1= ruleFunctionCall | this_StringLiteral_2= ruleStringLiteral | this_DecimalLiteral_3= ruleDecimalLiteral | this_IntegerLiteral_4= ruleIntegerLiteral | this_BooleanValue_5= ruleBooleanValue | this_NullLiteral_6= ruleNullLiteral | (otherlv_7= '(' this_Expression_8= ruleExpression otherlv_9= ')' ) ) )
            // InternalLts.g:3348:2: (this_ColumnReference_0= ruleColumnReference | this_FunctionCall_1= ruleFunctionCall | this_StringLiteral_2= ruleStringLiteral | this_DecimalLiteral_3= ruleDecimalLiteral | this_IntegerLiteral_4= ruleIntegerLiteral | this_BooleanValue_5= ruleBooleanValue | this_NullLiteral_6= ruleNullLiteral | (otherlv_7= '(' this_Expression_8= ruleExpression otherlv_9= ')' ) )
            {
            // InternalLts.g:3348:2: (this_ColumnReference_0= ruleColumnReference | this_FunctionCall_1= ruleFunctionCall | this_StringLiteral_2= ruleStringLiteral | this_DecimalLiteral_3= ruleDecimalLiteral | this_IntegerLiteral_4= ruleIntegerLiteral | this_BooleanValue_5= ruleBooleanValue | this_NullLiteral_6= ruleNullLiteral | (otherlv_7= '(' this_Expression_8= ruleExpression otherlv_9= ')' ) )
            int alt46=8;
            alt46 = dfa46.predict(input);
            switch (alt46) {
                case 1 :
                    // InternalLts.g:3349:3: this_ColumnReference_0= ruleColumnReference
                    {

                    			newCompositeNode(grammarAccess.getPrimaryExpressionAccess().getColumnReferenceParserRuleCall_0());
                    		
                    pushFollow(FOLLOW_2);
                    this_ColumnReference_0=ruleColumnReference();

                    state._fsp--;


                    			current = this_ColumnReference_0;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 2 :
                    // InternalLts.g:3358:3: this_FunctionCall_1= ruleFunctionCall
                    {

                    			newCompositeNode(grammarAccess.getPrimaryExpressionAccess().getFunctionCallParserRuleCall_1());
                    		
                    pushFollow(FOLLOW_2);
                    this_FunctionCall_1=ruleFunctionCall();

                    state._fsp--;


                    			current = this_FunctionCall_1;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 3 :
                    // InternalLts.g:3367:3: this_StringLiteral_2= ruleStringLiteral
                    {

                    			newCompositeNode(grammarAccess.getPrimaryExpressionAccess().getStringLiteralParserRuleCall_2());
                    		
                    pushFollow(FOLLOW_2);
                    this_StringLiteral_2=ruleStringLiteral();

                    state._fsp--;


                    			current = this_StringLiteral_2;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 4 :
                    // InternalLts.g:3376:3: this_DecimalLiteral_3= ruleDecimalLiteral
                    {

                    			newCompositeNode(grammarAccess.getPrimaryExpressionAccess().getDecimalLiteralParserRuleCall_3());
                    		
                    pushFollow(FOLLOW_2);
                    this_DecimalLiteral_3=ruleDecimalLiteral();

                    state._fsp--;


                    			current = this_DecimalLiteral_3;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 5 :
                    // InternalLts.g:3385:3: this_IntegerLiteral_4= ruleIntegerLiteral
                    {

                    			newCompositeNode(grammarAccess.getPrimaryExpressionAccess().getIntegerLiteralParserRuleCall_4());
                    		
                    pushFollow(FOLLOW_2);
                    this_IntegerLiteral_4=ruleIntegerLiteral();

                    state._fsp--;


                    			current = this_IntegerLiteral_4;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 6 :
                    // InternalLts.g:3394:3: this_BooleanValue_5= ruleBooleanValue
                    {

                    			newCompositeNode(grammarAccess.getPrimaryExpressionAccess().getBooleanValueParserRuleCall_5());
                    		
                    pushFollow(FOLLOW_2);
                    this_BooleanValue_5=ruleBooleanValue();

                    state._fsp--;


                    			current = this_BooleanValue_5;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 7 :
                    // InternalLts.g:3403:3: this_NullLiteral_6= ruleNullLiteral
                    {

                    			newCompositeNode(grammarAccess.getPrimaryExpressionAccess().getNullLiteralParserRuleCall_6());
                    		
                    pushFollow(FOLLOW_2);
                    this_NullLiteral_6=ruleNullLiteral();

                    state._fsp--;


                    			current = this_NullLiteral_6;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 8 :
                    // InternalLts.g:3412:3: (otherlv_7= '(' this_Expression_8= ruleExpression otherlv_9= ')' )
                    {
                    // InternalLts.g:3412:3: (otherlv_7= '(' this_Expression_8= ruleExpression otherlv_9= ')' )
                    // InternalLts.g:3413:4: otherlv_7= '(' this_Expression_8= ruleExpression otherlv_9= ')'
                    {
                    otherlv_7=(Token)match(input,32,FOLLOW_37); 

                    				newLeafNode(otherlv_7, grammarAccess.getPrimaryExpressionAccess().getLeftParenthesisKeyword_7_0());
                    			

                    				newCompositeNode(grammarAccess.getPrimaryExpressionAccess().getExpressionParserRuleCall_7_1());
                    			
                    pushFollow(FOLLOW_64);
                    this_Expression_8=ruleExpression();

                    state._fsp--;


                    				current = this_Expression_8;
                    				afterParserOrEnumRuleCall();
                    			
                    otherlv_9=(Token)match(input,33,FOLLOW_2); 

                    				newLeafNode(otherlv_9, grammarAccess.getPrimaryExpressionAccess().getRightParenthesisKeyword_7_2());
                    			

                    }


                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "rulePrimaryExpression"


    // $ANTLR start "entryRuleColumnReference"
    // InternalLts.g:3434:1: entryRuleColumnReference returns [EObject current=null] : iv_ruleColumnReference= ruleColumnReference EOF ;
    public final EObject entryRuleColumnReference() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleColumnReference = null;


        try {
            // InternalLts.g:3434:56: (iv_ruleColumnReference= ruleColumnReference EOF )
            // InternalLts.g:3435:2: iv_ruleColumnReference= ruleColumnReference EOF
            {
             newCompositeNode(grammarAccess.getColumnReferenceRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleColumnReference=ruleColumnReference();

            state._fsp--;

             current =iv_ruleColumnReference; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleColumnReference"


    // $ANTLR start "ruleColumnReference"
    // InternalLts.g:3441:1: ruleColumnReference returns [EObject current=null] : ( () ( (otherlv_1= RULE_ID ) ) otherlv_2= '.' ( (lv_column_3_0= RULE_ID ) ) ) ;
    public final EObject ruleColumnReference() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token lv_column_3_0=null;


        	enterRule();

        try {
            // InternalLts.g:3447:2: ( ( () ( (otherlv_1= RULE_ID ) ) otherlv_2= '.' ( (lv_column_3_0= RULE_ID ) ) ) )
            // InternalLts.g:3448:2: ( () ( (otherlv_1= RULE_ID ) ) otherlv_2= '.' ( (lv_column_3_0= RULE_ID ) ) )
            {
            // InternalLts.g:3448:2: ( () ( (otherlv_1= RULE_ID ) ) otherlv_2= '.' ( (lv_column_3_0= RULE_ID ) ) )
            // InternalLts.g:3449:3: () ( (otherlv_1= RULE_ID ) ) otherlv_2= '.' ( (lv_column_3_0= RULE_ID ) )
            {
            // InternalLts.g:3449:3: ()
            // InternalLts.g:3450:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getColumnReferenceAccess().getColumnReferenceAction_0(),
            					current);
            			

            }

            // InternalLts.g:3456:3: ( (otherlv_1= RULE_ID ) )
            // InternalLts.g:3457:4: (otherlv_1= RULE_ID )
            {
            // InternalLts.g:3457:4: (otherlv_1= RULE_ID )
            // InternalLts.g:3458:5: otherlv_1= RULE_ID
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getColumnReferenceRule());
            					}
            				
            otherlv_1=(Token)match(input,RULE_ID,FOLLOW_49); 

            					newLeafNode(otherlv_1, grammarAccess.getColumnReferenceAccess().getTableTableDeclarationCrossReference_1_0());
            				

            }


            }

            otherlv_2=(Token)match(input,55,FOLLOW_3); 

            			newLeafNode(otherlv_2, grammarAccess.getColumnReferenceAccess().getFullStopKeyword_2());
            		
            // InternalLts.g:3473:3: ( (lv_column_3_0= RULE_ID ) )
            // InternalLts.g:3474:4: (lv_column_3_0= RULE_ID )
            {
            // InternalLts.g:3474:4: (lv_column_3_0= RULE_ID )
            // InternalLts.g:3475:5: lv_column_3_0= RULE_ID
            {
            lv_column_3_0=(Token)match(input,RULE_ID,FOLLOW_2); 

            					newLeafNode(lv_column_3_0, grammarAccess.getColumnReferenceAccess().getColumnIDTerminalRuleCall_3_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getColumnReferenceRule());
            					}
            					setWithLastConsumed(
            						current,
            						"column",
            						lv_column_3_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleColumnReference"


    // $ANTLR start "entryRuleFunctionCall"
    // InternalLts.g:3495:1: entryRuleFunctionCall returns [EObject current=null] : iv_ruleFunctionCall= ruleFunctionCall EOF ;
    public final EObject entryRuleFunctionCall() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFunctionCall = null;


        try {
            // InternalLts.g:3495:53: (iv_ruleFunctionCall= ruleFunctionCall EOF )
            // InternalLts.g:3496:2: iv_ruleFunctionCall= ruleFunctionCall EOF
            {
             newCompositeNode(grammarAccess.getFunctionCallRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleFunctionCall=ruleFunctionCall();

            state._fsp--;

             current =iv_ruleFunctionCall; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleFunctionCall"


    // $ANTLR start "ruleFunctionCall"
    // InternalLts.g:3502:1: ruleFunctionCall returns [EObject current=null] : ( () ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '(' ( ( (lv_arguments_3_0= ruleExpression ) ) (otherlv_4= ',' ( (lv_arguments_5_0= ruleExpression ) ) )* )? otherlv_6= ')' ) ;
    public final EObject ruleFunctionCall() throws RecognitionException {
        EObject current = null;

        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        EObject lv_arguments_3_0 = null;

        EObject lv_arguments_5_0 = null;



        	enterRule();

        try {
            // InternalLts.g:3508:2: ( ( () ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '(' ( ( (lv_arguments_3_0= ruleExpression ) ) (otherlv_4= ',' ( (lv_arguments_5_0= ruleExpression ) ) )* )? otherlv_6= ')' ) )
            // InternalLts.g:3509:2: ( () ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '(' ( ( (lv_arguments_3_0= ruleExpression ) ) (otherlv_4= ',' ( (lv_arguments_5_0= ruleExpression ) ) )* )? otherlv_6= ')' )
            {
            // InternalLts.g:3509:2: ( () ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '(' ( ( (lv_arguments_3_0= ruleExpression ) ) (otherlv_4= ',' ( (lv_arguments_5_0= ruleExpression ) ) )* )? otherlv_6= ')' )
            // InternalLts.g:3510:3: () ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '(' ( ( (lv_arguments_3_0= ruleExpression ) ) (otherlv_4= ',' ( (lv_arguments_5_0= ruleExpression ) ) )* )? otherlv_6= ')'
            {
            // InternalLts.g:3510:3: ()
            // InternalLts.g:3511:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getFunctionCallAccess().getFunctionCallAction_0(),
            					current);
            			

            }

            // InternalLts.g:3517:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalLts.g:3518:4: (lv_name_1_0= RULE_ID )
            {
            // InternalLts.g:3518:4: (lv_name_1_0= RULE_ID )
            // InternalLts.g:3519:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_28); 

            					newLeafNode(lv_name_1_0, grammarAccess.getFunctionCallAccess().getNameIDTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getFunctionCallRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_1_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }

            otherlv_2=(Token)match(input,32,FOLLOW_65); 

            			newLeafNode(otherlv_2, grammarAccess.getFunctionCallAccess().getLeftParenthesisKeyword_2());
            		
            // InternalLts.g:3539:3: ( ( (lv_arguments_3_0= ruleExpression ) ) (otherlv_4= ',' ( (lv_arguments_5_0= ruleExpression ) ) )* )?
            int alt48=2;
            int LA48_0 = input.LA(1);

            if ( ((LA48_0>=RULE_ID && LA48_0<=RULE_INT)||LA48_0==32||LA48_0==74||(LA48_0>=78 && LA48_0<=81)) ) {
                alt48=1;
            }
            switch (alt48) {
                case 1 :
                    // InternalLts.g:3540:4: ( (lv_arguments_3_0= ruleExpression ) ) (otherlv_4= ',' ( (lv_arguments_5_0= ruleExpression ) ) )*
                    {
                    // InternalLts.g:3540:4: ( (lv_arguments_3_0= ruleExpression ) )
                    // InternalLts.g:3541:5: (lv_arguments_3_0= ruleExpression )
                    {
                    // InternalLts.g:3541:5: (lv_arguments_3_0= ruleExpression )
                    // InternalLts.g:3542:6: lv_arguments_3_0= ruleExpression
                    {

                    						newCompositeNode(grammarAccess.getFunctionCallAccess().getArgumentsExpressionParserRuleCall_3_0_0());
                    					
                    pushFollow(FOLLOW_30);
                    lv_arguments_3_0=ruleExpression();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getFunctionCallRule());
                    						}
                    						add(
                    							current,
                    							"arguments",
                    							lv_arguments_3_0,
                    							"org.example.lts.Lts.Expression");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    // InternalLts.g:3559:4: (otherlv_4= ',' ( (lv_arguments_5_0= ruleExpression ) ) )*
                    loop47:
                    do {
                        int alt47=2;
                        int LA47_0 = input.LA(1);

                        if ( (LA47_0==29) ) {
                            alt47=1;
                        }


                        switch (alt47) {
                    	case 1 :
                    	    // InternalLts.g:3560:5: otherlv_4= ',' ( (lv_arguments_5_0= ruleExpression ) )
                    	    {
                    	    otherlv_4=(Token)match(input,29,FOLLOW_37); 

                    	    					newLeafNode(otherlv_4, grammarAccess.getFunctionCallAccess().getCommaKeyword_3_1_0());
                    	    				
                    	    // InternalLts.g:3564:5: ( (lv_arguments_5_0= ruleExpression ) )
                    	    // InternalLts.g:3565:6: (lv_arguments_5_0= ruleExpression )
                    	    {
                    	    // InternalLts.g:3565:6: (lv_arguments_5_0= ruleExpression )
                    	    // InternalLts.g:3566:7: lv_arguments_5_0= ruleExpression
                    	    {

                    	    							newCompositeNode(grammarAccess.getFunctionCallAccess().getArgumentsExpressionParserRuleCall_3_1_1_0());
                    	    						
                    	    pushFollow(FOLLOW_30);
                    	    lv_arguments_5_0=ruleExpression();

                    	    state._fsp--;


                    	    							if (current==null) {
                    	    								current = createModelElementForParent(grammarAccess.getFunctionCallRule());
                    	    							}
                    	    							add(
                    	    								current,
                    	    								"arguments",
                    	    								lv_arguments_5_0,
                    	    								"org.example.lts.Lts.Expression");
                    	    							afterParserOrEnumRuleCall();
                    	    						

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop47;
                        }
                    } while (true);


                    }
                    break;

            }

            otherlv_6=(Token)match(input,33,FOLLOW_2); 

            			newLeafNode(otherlv_6, grammarAccess.getFunctionCallAccess().getRightParenthesisKeyword_4());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleFunctionCall"


    // $ANTLR start "entryRuleStringLiteral"
    // InternalLts.g:3593:1: entryRuleStringLiteral returns [EObject current=null] : iv_ruleStringLiteral= ruleStringLiteral EOF ;
    public final EObject entryRuleStringLiteral() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleStringLiteral = null;


        try {
            // InternalLts.g:3593:54: (iv_ruleStringLiteral= ruleStringLiteral EOF )
            // InternalLts.g:3594:2: iv_ruleStringLiteral= ruleStringLiteral EOF
            {
             newCompositeNode(grammarAccess.getStringLiteralRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleStringLiteral=ruleStringLiteral();

            state._fsp--;

             current =iv_ruleStringLiteral; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleStringLiteral"


    // $ANTLR start "ruleStringLiteral"
    // InternalLts.g:3600:1: ruleStringLiteral returns [EObject current=null] : ( () ( (lv_value_1_0= RULE_STRING ) ) ) ;
    public final EObject ruleStringLiteral() throws RecognitionException {
        EObject current = null;

        Token lv_value_1_0=null;


        	enterRule();

        try {
            // InternalLts.g:3606:2: ( ( () ( (lv_value_1_0= RULE_STRING ) ) ) )
            // InternalLts.g:3607:2: ( () ( (lv_value_1_0= RULE_STRING ) ) )
            {
            // InternalLts.g:3607:2: ( () ( (lv_value_1_0= RULE_STRING ) ) )
            // InternalLts.g:3608:3: () ( (lv_value_1_0= RULE_STRING ) )
            {
            // InternalLts.g:3608:3: ()
            // InternalLts.g:3609:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getStringLiteralAccess().getStringLiteralAction_0(),
            					current);
            			

            }

            // InternalLts.g:3615:3: ( (lv_value_1_0= RULE_STRING ) )
            // InternalLts.g:3616:4: (lv_value_1_0= RULE_STRING )
            {
            // InternalLts.g:3616:4: (lv_value_1_0= RULE_STRING )
            // InternalLts.g:3617:5: lv_value_1_0= RULE_STRING
            {
            lv_value_1_0=(Token)match(input,RULE_STRING,FOLLOW_2); 

            					newLeafNode(lv_value_1_0, grammarAccess.getStringLiteralAccess().getValueSTRINGTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getStringLiteralRule());
            					}
            					setWithLastConsumed(
            						current,
            						"value",
            						lv_value_1_0,
            						"org.eclipse.xtext.common.Terminals.STRING");
            				

            }


            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleStringLiteral"


    // $ANTLR start "entryRuleIntegerLiteral"
    // InternalLts.g:3637:1: entryRuleIntegerLiteral returns [EObject current=null] : iv_ruleIntegerLiteral= ruleIntegerLiteral EOF ;
    public final EObject entryRuleIntegerLiteral() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleIntegerLiteral = null;


        try {
            // InternalLts.g:3637:55: (iv_ruleIntegerLiteral= ruleIntegerLiteral EOF )
            // InternalLts.g:3638:2: iv_ruleIntegerLiteral= ruleIntegerLiteral EOF
            {
             newCompositeNode(grammarAccess.getIntegerLiteralRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleIntegerLiteral=ruleIntegerLiteral();

            state._fsp--;

             current =iv_ruleIntegerLiteral; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleIntegerLiteral"


    // $ANTLR start "ruleIntegerLiteral"
    // InternalLts.g:3644:1: ruleIntegerLiteral returns [EObject current=null] : ( () ( (lv_value_1_0= RULE_INT ) ) ) ;
    public final EObject ruleIntegerLiteral() throws RecognitionException {
        EObject current = null;

        Token lv_value_1_0=null;


        	enterRule();

        try {
            // InternalLts.g:3650:2: ( ( () ( (lv_value_1_0= RULE_INT ) ) ) )
            // InternalLts.g:3651:2: ( () ( (lv_value_1_0= RULE_INT ) ) )
            {
            // InternalLts.g:3651:2: ( () ( (lv_value_1_0= RULE_INT ) ) )
            // InternalLts.g:3652:3: () ( (lv_value_1_0= RULE_INT ) )
            {
            // InternalLts.g:3652:3: ()
            // InternalLts.g:3653:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getIntegerLiteralAccess().getIntegerLiteralAction_0(),
            					current);
            			

            }

            // InternalLts.g:3659:3: ( (lv_value_1_0= RULE_INT ) )
            // InternalLts.g:3660:4: (lv_value_1_0= RULE_INT )
            {
            // InternalLts.g:3660:4: (lv_value_1_0= RULE_INT )
            // InternalLts.g:3661:5: lv_value_1_0= RULE_INT
            {
            lv_value_1_0=(Token)match(input,RULE_INT,FOLLOW_2); 

            					newLeafNode(lv_value_1_0, grammarAccess.getIntegerLiteralAccess().getValueINTTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getIntegerLiteralRule());
            					}
            					setWithLastConsumed(
            						current,
            						"value",
            						lv_value_1_0,
            						"org.eclipse.xtext.common.Terminals.INT");
            				

            }


            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleIntegerLiteral"


    // $ANTLR start "entryRuleDecimalLiteral"
    // InternalLts.g:3681:1: entryRuleDecimalLiteral returns [EObject current=null] : iv_ruleDecimalLiteral= ruleDecimalLiteral EOF ;
    public final EObject entryRuleDecimalLiteral() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDecimalLiteral = null;


        try {
            // InternalLts.g:3681:55: (iv_ruleDecimalLiteral= ruleDecimalLiteral EOF )
            // InternalLts.g:3682:2: iv_ruleDecimalLiteral= ruleDecimalLiteral EOF
            {
             newCompositeNode(grammarAccess.getDecimalLiteralRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleDecimalLiteral=ruleDecimalLiteral();

            state._fsp--;

             current =iv_ruleDecimalLiteral; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleDecimalLiteral"


    // $ANTLR start "ruleDecimalLiteral"
    // InternalLts.g:3688:1: ruleDecimalLiteral returns [EObject current=null] : ( () ( (lv_value_1_0= ruleDECIMAL ) ) ) ;
    public final EObject ruleDecimalLiteral() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_value_1_0 = null;



        	enterRule();

        try {
            // InternalLts.g:3694:2: ( ( () ( (lv_value_1_0= ruleDECIMAL ) ) ) )
            // InternalLts.g:3695:2: ( () ( (lv_value_1_0= ruleDECIMAL ) ) )
            {
            // InternalLts.g:3695:2: ( () ( (lv_value_1_0= ruleDECIMAL ) ) )
            // InternalLts.g:3696:3: () ( (lv_value_1_0= ruleDECIMAL ) )
            {
            // InternalLts.g:3696:3: ()
            // InternalLts.g:3697:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getDecimalLiteralAccess().getDecimalLiteralAction_0(),
            					current);
            			

            }

            // InternalLts.g:3703:3: ( (lv_value_1_0= ruleDECIMAL ) )
            // InternalLts.g:3704:4: (lv_value_1_0= ruleDECIMAL )
            {
            // InternalLts.g:3704:4: (lv_value_1_0= ruleDECIMAL )
            // InternalLts.g:3705:5: lv_value_1_0= ruleDECIMAL
            {

            					newCompositeNode(grammarAccess.getDecimalLiteralAccess().getValueDECIMALParserRuleCall_1_0());
            				
            pushFollow(FOLLOW_2);
            lv_value_1_0=ruleDECIMAL();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getDecimalLiteralRule());
            					}
            					set(
            						current,
            						"value",
            						lv_value_1_0,
            						"org.example.lts.Lts.DECIMAL");
            					afterParserOrEnumRuleCall();
            				

            }


            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleDecimalLiteral"


    // $ANTLR start "entryRuleBooleanValue"
    // InternalLts.g:3726:1: entryRuleBooleanValue returns [EObject current=null] : iv_ruleBooleanValue= ruleBooleanValue EOF ;
    public final EObject entryRuleBooleanValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBooleanValue = null;


        try {
            // InternalLts.g:3726:53: (iv_ruleBooleanValue= ruleBooleanValue EOF )
            // InternalLts.g:3727:2: iv_ruleBooleanValue= ruleBooleanValue EOF
            {
             newCompositeNode(grammarAccess.getBooleanValueRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleBooleanValue=ruleBooleanValue();

            state._fsp--;

             current =iv_ruleBooleanValue; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleBooleanValue"


    // $ANTLR start "ruleBooleanValue"
    // InternalLts.g:3733:1: ruleBooleanValue returns [EObject current=null] : ( () ( (lv_value_1_0= ruleBooleanLiteral ) ) ) ;
    public final EObject ruleBooleanValue() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_value_1_0 = null;



        	enterRule();

        try {
            // InternalLts.g:3739:2: ( ( () ( (lv_value_1_0= ruleBooleanLiteral ) ) ) )
            // InternalLts.g:3740:2: ( () ( (lv_value_1_0= ruleBooleanLiteral ) ) )
            {
            // InternalLts.g:3740:2: ( () ( (lv_value_1_0= ruleBooleanLiteral ) ) )
            // InternalLts.g:3741:3: () ( (lv_value_1_0= ruleBooleanLiteral ) )
            {
            // InternalLts.g:3741:3: ()
            // InternalLts.g:3742:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getBooleanValueAccess().getBooleanValueAction_0(),
            					current);
            			

            }

            // InternalLts.g:3748:3: ( (lv_value_1_0= ruleBooleanLiteral ) )
            // InternalLts.g:3749:4: (lv_value_1_0= ruleBooleanLiteral )
            {
            // InternalLts.g:3749:4: (lv_value_1_0= ruleBooleanLiteral )
            // InternalLts.g:3750:5: lv_value_1_0= ruleBooleanLiteral
            {

            					newCompositeNode(grammarAccess.getBooleanValueAccess().getValueBooleanLiteralParserRuleCall_1_0());
            				
            pushFollow(FOLLOW_2);
            lv_value_1_0=ruleBooleanLiteral();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getBooleanValueRule());
            					}
            					set(
            						current,
            						"value",
            						lv_value_1_0,
            						"org.example.lts.Lts.BooleanLiteral");
            					afterParserOrEnumRuleCall();
            				

            }


            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleBooleanValue"


    // $ANTLR start "entryRuleNullLiteral"
    // InternalLts.g:3771:1: entryRuleNullLiteral returns [EObject current=null] : iv_ruleNullLiteral= ruleNullLiteral EOF ;
    public final EObject entryRuleNullLiteral() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNullLiteral = null;


        try {
            // InternalLts.g:3771:52: (iv_ruleNullLiteral= ruleNullLiteral EOF )
            // InternalLts.g:3772:2: iv_ruleNullLiteral= ruleNullLiteral EOF
            {
             newCompositeNode(grammarAccess.getNullLiteralRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleNullLiteral=ruleNullLiteral();

            state._fsp--;

             current =iv_ruleNullLiteral; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleNullLiteral"


    // $ANTLR start "ruleNullLiteral"
    // InternalLts.g:3778:1: ruleNullLiteral returns [EObject current=null] : ( () otherlv_1= 'null' ) ;
    public final EObject ruleNullLiteral() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;


        	enterRule();

        try {
            // InternalLts.g:3784:2: ( ( () otherlv_1= 'null' ) )
            // InternalLts.g:3785:2: ( () otherlv_1= 'null' )
            {
            // InternalLts.g:3785:2: ( () otherlv_1= 'null' )
            // InternalLts.g:3786:3: () otherlv_1= 'null'
            {
            // InternalLts.g:3786:3: ()
            // InternalLts.g:3787:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getNullLiteralAccess().getNullLiteralAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,79,FOLLOW_2); 

            			newLeafNode(otherlv_1, grammarAccess.getNullLiteralAccess().getNullKeyword_1());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleNullLiteral"


    // $ANTLR start "entryRuleBooleanLiteral"
    // InternalLts.g:3801:1: entryRuleBooleanLiteral returns [String current=null] : iv_ruleBooleanLiteral= ruleBooleanLiteral EOF ;
    public final String entryRuleBooleanLiteral() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleBooleanLiteral = null;


        try {
            // InternalLts.g:3801:54: (iv_ruleBooleanLiteral= ruleBooleanLiteral EOF )
            // InternalLts.g:3802:2: iv_ruleBooleanLiteral= ruleBooleanLiteral EOF
            {
             newCompositeNode(grammarAccess.getBooleanLiteralRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleBooleanLiteral=ruleBooleanLiteral();

            state._fsp--;

             current =iv_ruleBooleanLiteral.getText(); 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleBooleanLiteral"


    // $ANTLR start "ruleBooleanLiteral"
    // InternalLts.g:3808:1: ruleBooleanLiteral returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= 'true' | kw= 'false' ) ;
    public final AntlrDatatypeRuleToken ruleBooleanLiteral() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;


        	enterRule();

        try {
            // InternalLts.g:3814:2: ( (kw= 'true' | kw= 'false' ) )
            // InternalLts.g:3815:2: (kw= 'true' | kw= 'false' )
            {
            // InternalLts.g:3815:2: (kw= 'true' | kw= 'false' )
            int alt49=2;
            int LA49_0 = input.LA(1);

            if ( (LA49_0==80) ) {
                alt49=1;
            }
            else if ( (LA49_0==81) ) {
                alt49=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 49, 0, input);

                throw nvae;
            }
            switch (alt49) {
                case 1 :
                    // InternalLts.g:3816:3: kw= 'true'
                    {
                    kw=(Token)match(input,80,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getBooleanLiteralAccess().getTrueKeyword_0());
                    		

                    }
                    break;
                case 2 :
                    // InternalLts.g:3822:3: kw= 'false'
                    {
                    kw=(Token)match(input,81,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getBooleanLiteralAccess().getFalseKeyword_1());
                    		

                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleBooleanLiteral"


    // $ANTLR start "entryRuleDECIMAL"
    // InternalLts.g:3831:1: entryRuleDECIMAL returns [String current=null] : iv_ruleDECIMAL= ruleDECIMAL EOF ;
    public final String entryRuleDECIMAL() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleDECIMAL = null;


        try {
            // InternalLts.g:3831:47: (iv_ruleDECIMAL= ruleDECIMAL EOF )
            // InternalLts.g:3832:2: iv_ruleDECIMAL= ruleDECIMAL EOF
            {
             newCompositeNode(grammarAccess.getDECIMALRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleDECIMAL=ruleDECIMAL();

            state._fsp--;

             current =iv_ruleDECIMAL.getText(); 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleDECIMAL"


    // $ANTLR start "ruleDECIMAL"
    // InternalLts.g:3838:1: ruleDECIMAL returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_INT_0= RULE_INT kw= '.' this_INT_2= RULE_INT ) ;
    public final AntlrDatatypeRuleToken ruleDECIMAL() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_INT_0=null;
        Token kw=null;
        Token this_INT_2=null;


        	enterRule();

        try {
            // InternalLts.g:3844:2: ( (this_INT_0= RULE_INT kw= '.' this_INT_2= RULE_INT ) )
            // InternalLts.g:3845:2: (this_INT_0= RULE_INT kw= '.' this_INT_2= RULE_INT )
            {
            // InternalLts.g:3845:2: (this_INT_0= RULE_INT kw= '.' this_INT_2= RULE_INT )
            // InternalLts.g:3846:3: this_INT_0= RULE_INT kw= '.' this_INT_2= RULE_INT
            {
            this_INT_0=(Token)match(input,RULE_INT,FOLLOW_49); 

            			current.merge(this_INT_0);
            		

            			newLeafNode(this_INT_0, grammarAccess.getDECIMALAccess().getINTTerminalRuleCall_0());
            		
            kw=(Token)match(input,55,FOLLOW_66); 

            			current.merge(kw);
            			newLeafNode(kw, grammarAccess.getDECIMALAccess().getFullStopKeyword_1());
            		
            this_INT_2=(Token)match(input,RULE_INT,FOLLOW_2); 

            			current.merge(this_INT_2);
            		

            			newLeafNode(this_INT_2, grammarAccess.getDECIMALAccess().getINTTerminalRuleCall_2());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleDECIMAL"


    // $ANTLR start "ruleLogLevel"
    // InternalLts.g:3869:1: ruleLogLevel returns [Enumerator current=null] : ( (enumLiteral_0= 'warnings' ) | (enumLiteral_1= 'errors' ) ) ;
    public final Enumerator ruleLogLevel() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;


        	enterRule();

        try {
            // InternalLts.g:3875:2: ( ( (enumLiteral_0= 'warnings' ) | (enumLiteral_1= 'errors' ) ) )
            // InternalLts.g:3876:2: ( (enumLiteral_0= 'warnings' ) | (enumLiteral_1= 'errors' ) )
            {
            // InternalLts.g:3876:2: ( (enumLiteral_0= 'warnings' ) | (enumLiteral_1= 'errors' ) )
            int alt50=2;
            int LA50_0 = input.LA(1);

            if ( (LA50_0==82) ) {
                alt50=1;
            }
            else if ( (LA50_0==83) ) {
                alt50=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 50, 0, input);

                throw nvae;
            }
            switch (alt50) {
                case 1 :
                    // InternalLts.g:3877:3: (enumLiteral_0= 'warnings' )
                    {
                    // InternalLts.g:3877:3: (enumLiteral_0= 'warnings' )
                    // InternalLts.g:3878:4: enumLiteral_0= 'warnings'
                    {
                    enumLiteral_0=(Token)match(input,82,FOLLOW_2); 

                    				current = grammarAccess.getLogLevelAccess().getWARNINGEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_0, grammarAccess.getLogLevelAccess().getWARNINGEnumLiteralDeclaration_0());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalLts.g:3885:3: (enumLiteral_1= 'errors' )
                    {
                    // InternalLts.g:3885:3: (enumLiteral_1= 'errors' )
                    // InternalLts.g:3886:4: enumLiteral_1= 'errors'
                    {
                    enumLiteral_1=(Token)match(input,83,FOLLOW_2); 

                    				current = grammarAccess.getLogLevelAccess().getERROREnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_1, grammarAccess.getLogLevelAccess().getERROREnumLiteralDeclaration_1());
                    			

                    }


                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleLogLevel"


    // $ANTLR start "ruleSortDirection"
    // InternalLts.g:3896:1: ruleSortDirection returns [Enumerator current=null] : ( (enumLiteral_0= 'ascending' ) | (enumLiteral_1= 'descending' ) ) ;
    public final Enumerator ruleSortDirection() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;


        	enterRule();

        try {
            // InternalLts.g:3902:2: ( ( (enumLiteral_0= 'ascending' ) | (enumLiteral_1= 'descending' ) ) )
            // InternalLts.g:3903:2: ( (enumLiteral_0= 'ascending' ) | (enumLiteral_1= 'descending' ) )
            {
            // InternalLts.g:3903:2: ( (enumLiteral_0= 'ascending' ) | (enumLiteral_1= 'descending' ) )
            int alt51=2;
            int LA51_0 = input.LA(1);

            if ( (LA51_0==84) ) {
                alt51=1;
            }
            else if ( (LA51_0==85) ) {
                alt51=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 51, 0, input);

                throw nvae;
            }
            switch (alt51) {
                case 1 :
                    // InternalLts.g:3904:3: (enumLiteral_0= 'ascending' )
                    {
                    // InternalLts.g:3904:3: (enumLiteral_0= 'ascending' )
                    // InternalLts.g:3905:4: enumLiteral_0= 'ascending'
                    {
                    enumLiteral_0=(Token)match(input,84,FOLLOW_2); 

                    				current = grammarAccess.getSortDirectionAccess().getASCEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_0, grammarAccess.getSortDirectionAccess().getASCEnumLiteralDeclaration_0());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalLts.g:3912:3: (enumLiteral_1= 'descending' )
                    {
                    // InternalLts.g:3912:3: (enumLiteral_1= 'descending' )
                    // InternalLts.g:3913:4: enumLiteral_1= 'descending'
                    {
                    enumLiteral_1=(Token)match(input,85,FOLLOW_2); 

                    				current = grammarAccess.getSortDirectionAccess().getDESCEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_1, grammarAccess.getSortDirectionAccess().getDESCEnumLiteralDeclaration_1());
                    			

                    }


                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleSortDirection"


    // $ANTLR start "ruleJoinKind"
    // InternalLts.g:3923:1: ruleJoinKind returns [Enumerator current=null] : ( (enumLiteral_0= 'inner' ) | (enumLiteral_1= 'left' ) ) ;
    public final Enumerator ruleJoinKind() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;


        	enterRule();

        try {
            // InternalLts.g:3929:2: ( ( (enumLiteral_0= 'inner' ) | (enumLiteral_1= 'left' ) ) )
            // InternalLts.g:3930:2: ( (enumLiteral_0= 'inner' ) | (enumLiteral_1= 'left' ) )
            {
            // InternalLts.g:3930:2: ( (enumLiteral_0= 'inner' ) | (enumLiteral_1= 'left' ) )
            int alt52=2;
            int LA52_0 = input.LA(1);

            if ( (LA52_0==86) ) {
                alt52=1;
            }
            else if ( (LA52_0==87) ) {
                alt52=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 52, 0, input);

                throw nvae;
            }
            switch (alt52) {
                case 1 :
                    // InternalLts.g:3931:3: (enumLiteral_0= 'inner' )
                    {
                    // InternalLts.g:3931:3: (enumLiteral_0= 'inner' )
                    // InternalLts.g:3932:4: enumLiteral_0= 'inner'
                    {
                    enumLiteral_0=(Token)match(input,86,FOLLOW_2); 

                    				current = grammarAccess.getJoinKindAccess().getINNEREnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_0, grammarAccess.getJoinKindAccess().getINNEREnumLiteralDeclaration_0());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalLts.g:3939:3: (enumLiteral_1= 'left' )
                    {
                    // InternalLts.g:3939:3: (enumLiteral_1= 'left' )
                    // InternalLts.g:3940:4: enumLiteral_1= 'left'
                    {
                    enumLiteral_1=(Token)match(input,87,FOLLOW_2); 

                    				current = grammarAccess.getJoinKindAccess().getLEFTEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_1, grammarAccess.getJoinKindAccess().getLEFTEnumLiteralDeclaration_1());
                    			

                    }


                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleJoinKind"


    // $ANTLR start "ruleDataType"
    // InternalLts.g:3950:1: ruleDataType returns [Enumerator current=null] : ( (enumLiteral_0= 'string' ) | (enumLiteral_1= 'integer' ) | (enumLiteral_2= 'decimal' ) | (enumLiteral_3= 'boolean' ) | (enumLiteral_4= 'date' ) | (enumLiteral_5= 'datetime' ) ) ;
    public final Enumerator ruleDataType() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;
        Token enumLiteral_3=null;
        Token enumLiteral_4=null;
        Token enumLiteral_5=null;


        	enterRule();

        try {
            // InternalLts.g:3956:2: ( ( (enumLiteral_0= 'string' ) | (enumLiteral_1= 'integer' ) | (enumLiteral_2= 'decimal' ) | (enumLiteral_3= 'boolean' ) | (enumLiteral_4= 'date' ) | (enumLiteral_5= 'datetime' ) ) )
            // InternalLts.g:3957:2: ( (enumLiteral_0= 'string' ) | (enumLiteral_1= 'integer' ) | (enumLiteral_2= 'decimal' ) | (enumLiteral_3= 'boolean' ) | (enumLiteral_4= 'date' ) | (enumLiteral_5= 'datetime' ) )
            {
            // InternalLts.g:3957:2: ( (enumLiteral_0= 'string' ) | (enumLiteral_1= 'integer' ) | (enumLiteral_2= 'decimal' ) | (enumLiteral_3= 'boolean' ) | (enumLiteral_4= 'date' ) | (enumLiteral_5= 'datetime' ) )
            int alt53=6;
            switch ( input.LA(1) ) {
            case 88:
                {
                alt53=1;
                }
                break;
            case 89:
                {
                alt53=2;
                }
                break;
            case 90:
                {
                alt53=3;
                }
                break;
            case 91:
                {
                alt53=4;
                }
                break;
            case 92:
                {
                alt53=5;
                }
                break;
            case 93:
                {
                alt53=6;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 53, 0, input);

                throw nvae;
            }

            switch (alt53) {
                case 1 :
                    // InternalLts.g:3958:3: (enumLiteral_0= 'string' )
                    {
                    // InternalLts.g:3958:3: (enumLiteral_0= 'string' )
                    // InternalLts.g:3959:4: enumLiteral_0= 'string'
                    {
                    enumLiteral_0=(Token)match(input,88,FOLLOW_2); 

                    				current = grammarAccess.getDataTypeAccess().getSTRINGEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_0, grammarAccess.getDataTypeAccess().getSTRINGEnumLiteralDeclaration_0());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalLts.g:3966:3: (enumLiteral_1= 'integer' )
                    {
                    // InternalLts.g:3966:3: (enumLiteral_1= 'integer' )
                    // InternalLts.g:3967:4: enumLiteral_1= 'integer'
                    {
                    enumLiteral_1=(Token)match(input,89,FOLLOW_2); 

                    				current = grammarAccess.getDataTypeAccess().getINTEGEREnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_1, grammarAccess.getDataTypeAccess().getINTEGEREnumLiteralDeclaration_1());
                    			

                    }


                    }
                    break;
                case 3 :
                    // InternalLts.g:3974:3: (enumLiteral_2= 'decimal' )
                    {
                    // InternalLts.g:3974:3: (enumLiteral_2= 'decimal' )
                    // InternalLts.g:3975:4: enumLiteral_2= 'decimal'
                    {
                    enumLiteral_2=(Token)match(input,90,FOLLOW_2); 

                    				current = grammarAccess.getDataTypeAccess().getDECIMALEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_2, grammarAccess.getDataTypeAccess().getDECIMALEnumLiteralDeclaration_2());
                    			

                    }


                    }
                    break;
                case 4 :
                    // InternalLts.g:3982:3: (enumLiteral_3= 'boolean' )
                    {
                    // InternalLts.g:3982:3: (enumLiteral_3= 'boolean' )
                    // InternalLts.g:3983:4: enumLiteral_3= 'boolean'
                    {
                    enumLiteral_3=(Token)match(input,91,FOLLOW_2); 

                    				current = grammarAccess.getDataTypeAccess().getBOOLEANEnumLiteralDeclaration_3().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_3, grammarAccess.getDataTypeAccess().getBOOLEANEnumLiteralDeclaration_3());
                    			

                    }


                    }
                    break;
                case 5 :
                    // InternalLts.g:3990:3: (enumLiteral_4= 'date' )
                    {
                    // InternalLts.g:3990:3: (enumLiteral_4= 'date' )
                    // InternalLts.g:3991:4: enumLiteral_4= 'date'
                    {
                    enumLiteral_4=(Token)match(input,92,FOLLOW_2); 

                    				current = grammarAccess.getDataTypeAccess().getDATEEnumLiteralDeclaration_4().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_4, grammarAccess.getDataTypeAccess().getDATEEnumLiteralDeclaration_4());
                    			

                    }


                    }
                    break;
                case 6 :
                    // InternalLts.g:3998:3: (enumLiteral_5= 'datetime' )
                    {
                    // InternalLts.g:3998:3: (enumLiteral_5= 'datetime' )
                    // InternalLts.g:3999:4: enumLiteral_5= 'datetime'
                    {
                    enumLiteral_5=(Token)match(input,93,FOLLOW_2); 

                    				current = grammarAccess.getDataTypeAccess().getDATETIMEEnumLiteralDeclaration_5().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_5, grammarAccess.getDataTypeAccess().getDATETIMEEnumLiteralDeclaration_5());
                    			

                    }


                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleDataType"

    // Delegated rules


    protected DFA15 dfa15 = new DFA15(this);
    protected DFA46 dfa46 = new DFA46(this);
    static final String dfa_1s = "\22\uffff";
    static final String dfa_2s = "\1\44\11\uffff\1\72\2\uffff\1\4\4\uffff";
    static final String dfa_3s = "\1\101\11\uffff\1\100\2\uffff\1\33\4\uffff";
    static final String dfa_4s = "\1\uffff\1\1\1\2\1\3\1\4\1\5\1\6\1\7\1\10\1\11\1\uffff\1\13\1\14\1\uffff\1\12\1\15\1\17\1\16";
    static final String dfa_5s = "\22\uffff}>";
    static final String[] dfa_6s = {
            "\1\1\1\2\1\uffff\1\3\2\uffff\1\4\1\uffff\1\5\1\6\1\uffff\1\7\1\uffff\1\10\3\uffff\1\11\3\uffff\1\12\1\uffff\1\13\1\14\4\uffff\1\15",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\16\5\uffff\1\17",
            "",
            "",
            "\1\21\26\uffff\1\20",
            "",
            "",
            "",
            ""
    };

    static final short[] dfa_1 = DFA.unpackEncodedString(dfa_1s);
    static final char[] dfa_2 = DFA.unpackEncodedStringToUnsignedChars(dfa_2s);
    static final char[] dfa_3 = DFA.unpackEncodedStringToUnsignedChars(dfa_3s);
    static final short[] dfa_4 = DFA.unpackEncodedString(dfa_4s);
    static final short[] dfa_5 = DFA.unpackEncodedString(dfa_5s);
    static final short[][] dfa_6 = unpackEncodedStringArray(dfa_6s);

    class DFA15 extends DFA {

        public DFA15(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 15;
            this.eot = dfa_1;
            this.eof = dfa_1;
            this.min = dfa_2;
            this.max = dfa_3;
            this.accept = dfa_4;
            this.special = dfa_5;
            this.transition = dfa_6;
        }
        public String getDescription() {
            return "1042:2: (this_LoadOperation_0= ruleLoadOperation | this_CreateTableOperation_1= ruleCreateTableOperation | this_AppendRowsOperation_2= ruleAppendRowsOperation | this_FilterOperation_3= ruleFilterOperation | this_SortOperation_4= ruleSortOperation | this_GroupOperation_5= ruleGroupOperation | this_AggregateOperation_6= ruleAggregateOperation | this_JoinOperation_7= ruleJoinOperation | this_InsertColumnOperation_8= ruleInsertColumnOperation | this_RemoveColumnOperation_9= ruleRemoveColumnOperation | this_CalculateColumnOperation_10= ruleCalculateColumnOperation | this_LookupOperation_11= ruleLookupOperation | this_RemoveDuplicatesOperation_12= ruleRemoveDuplicatesOperation | this_SaveTableOperation_13= ruleSaveTableOperation | this_SaveLogOperation_14= ruleSaveLogOperation )";
        }
    }
    static final String dfa_7s = "\13\uffff";
    static final String dfa_8s = "\3\uffff\1\12\7\uffff";
    static final String dfa_9s = "\1\4\1\40\1\uffff\1\30\7\uffff";
    static final String dfa_10s = "\1\121\1\67\1\uffff\1\115\7\uffff";
    static final String dfa_11s = "\2\uffff\1\3\1\uffff\1\6\1\7\1\10\1\2\1\1\1\4\1\5";
    static final String dfa_12s = "\13\uffff}>";
    static final String[] dfa_13s = {
            "\1\1\1\2\1\3\31\uffff\1\6\56\uffff\1\5\2\4",
            "\1\7\26\uffff\1\10",
            "",
            "\1\12\4\uffff\1\12\3\uffff\1\12\15\uffff\1\12\4\uffff\1\12\2\uffff\1\11\1\12\11\uffff\14\12",
            "",
            "",
            "",
            "",
            "",
            "",
            ""
    };

    static final short[] dfa_7 = DFA.unpackEncodedString(dfa_7s);
    static final short[] dfa_8 = DFA.unpackEncodedString(dfa_8s);
    static final char[] dfa_9 = DFA.unpackEncodedStringToUnsignedChars(dfa_9s);
    static final char[] dfa_10 = DFA.unpackEncodedStringToUnsignedChars(dfa_10s);
    static final short[] dfa_11 = DFA.unpackEncodedString(dfa_11s);
    static final short[] dfa_12 = DFA.unpackEncodedString(dfa_12s);
    static final short[][] dfa_13 = unpackEncodedStringArray(dfa_13s);

    class DFA46 extends DFA {

        public DFA46(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 46;
            this.eot = dfa_7;
            this.eof = dfa_8;
            this.min = dfa_9;
            this.max = dfa_10;
            this.accept = dfa_11;
            this.special = dfa_12;
            this.transition = dfa_13;
        }
        public String getDescription() {
            return "3348:2: (this_ColumnReference_0= ruleColumnReference | this_FunctionCall_1= ruleFunctionCall | this_StringLiteral_2= ruleStringLiteral | this_DecimalLiteral_3= ruleDecimalLiteral | this_IntegerLiteral_4= ruleIntegerLiteral | this_BooleanValue_5= ruleBooleanValue | this_NullLiteral_6= ruleNullLiteral | (otherlv_7= '(' this_Expression_8= ruleExpression otherlv_9= ')' ) )";
        }
    }
 

    public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x000000004A02A000L});
    public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x1A22B4B000004000L,0x0000000000000002L});
    public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x0000000000004010L});
    public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_12 = new BitSet(new long[]{0x0000000000180002L});
    public static final BitSet FOLLOW_13 = new BitSet(new long[]{0x0000000000100002L});
    public static final BitSet FOLLOW_14 = new BitSet(new long[]{0x0000000000000000L,0x0000000000030000L});
    public static final BitSet FOLLOW_15 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_16 = new BitSet(new long[]{0x0000000000000000L,0x000000003F000000L});
    public static final BitSet FOLLOW_17 = new BitSet(new long[]{0x0000000001C00000L});
    public static final BitSet FOLLOW_18 = new BitSet(new long[]{0x0000000001800000L});
    public static final BitSet FOLLOW_19 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_20 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_21 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_22 = new BitSet(new long[]{0x0000000001180000L});
    public static final BitSet FOLLOW_23 = new BitSet(new long[]{0x0000000001100000L});
    public static final BitSet FOLLOW_24 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_25 = new BitSet(new long[]{0x0000000000000000L,0x00000000000C0000L});
    public static final BitSet FOLLOW_26 = new BitSet(new long[]{0x0000000021000000L});
    public static final BitSet FOLLOW_27 = new BitSet(new long[]{0x0000000080000000L});
    public static final BitSet FOLLOW_28 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_29 = new BitSet(new long[]{0x0000000200000010L});
    public static final BitSet FOLLOW_30 = new BitSet(new long[]{0x0000000220000000L});
    public static final BitSet FOLLOW_31 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_32 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_33 = new BitSet(new long[]{0x0000004000000000L});
    public static final BitSet FOLLOW_34 = new BitSet(new long[]{0x0000010000000000L});
    public static final BitSet FOLLOW_35 = new BitSet(new long[]{0x0000020001000000L});
    public static final BitSet FOLLOW_36 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_37 = new BitSet(new long[]{0x0000000100000070L,0x000000000003C400L});
    public static final BitSet FOLLOW_38 = new BitSet(new long[]{0x0000000000000002L,0x0000000000300000L});
    public static final BitSet FOLLOW_39 = new BitSet(new long[]{0x0000400000000000L});
    public static final BitSet FOLLOW_40 = new BitSet(new long[]{0x0000800020000000L});
    public static final BitSet FOLLOW_41 = new BitSet(new long[]{0x0001000800000000L});
    public static final BitSet FOLLOW_42 = new BitSet(new long[]{0x0001000020000000L});
    public static final BitSet FOLLOW_43 = new BitSet(new long[]{0x0004000000000000L,0x0000000000C00000L});
    public static final BitSet FOLLOW_44 = new BitSet(new long[]{0x0004000000000000L});
    public static final BitSet FOLLOW_45 = new BitSet(new long[]{0x0008000000000000L});
    public static final BitSet FOLLOW_46 = new BitSet(new long[]{0x0010800001000000L});
    public static final BitSet FOLLOW_47 = new BitSet(new long[]{0x0000800001000000L});
    public static final BitSet FOLLOW_48 = new BitSet(new long[]{0x0040000000000000L});
    public static final BitSet FOLLOW_49 = new BitSet(new long[]{0x0080000000000000L});
    public static final BitSet FOLLOW_50 = new BitSet(new long[]{0x0100000001000000L});
    public static final BitSet FOLLOW_51 = new BitSet(new long[]{0x0400000000000000L});
    public static final BitSet FOLLOW_52 = new BitSet(new long[]{0x0100000000000000L});
    public static final BitSet FOLLOW_53 = new BitSet(new long[]{0x2000000000000000L});
    public static final BitSet FOLLOW_54 = new BitSet(new long[]{0x4000000000000000L});
    public static final BitSet FOLLOW_55 = new BitSet(new long[]{0x8000000001000000L});
    public static final BitSet FOLLOW_56 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000001L});
    public static final BitSet FOLLOW_57 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_58 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000004L});
    public static final BitSet FOLLOW_59 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000008L});
    public static final BitSet FOLLOW_60 = new BitSet(new long[]{0x0100000000000002L,0x0000000000000010L});
    public static final BitSet FOLLOW_61 = new BitSet(new long[]{0x0000000000000002L,0x00000000000001E0L});
    public static final BitSet FOLLOW_62 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000E00L});
    public static final BitSet FOLLOW_63 = new BitSet(new long[]{0x0000000000000002L,0x0000000000003000L});
    public static final BitSet FOLLOW_64 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_65 = new BitSet(new long[]{0x0000000300000070L,0x000000000003C400L});
    public static final BitSet FOLLOW_66 = new BitSet(new long[]{0x0000000000000040L});

}