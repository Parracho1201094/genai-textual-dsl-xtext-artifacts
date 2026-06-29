package org.xtext.example.mydsl.parser.antlr.internal;

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
import org.xtext.example.mydsl.services.MyDslGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalMyDslParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_STRING", "RULE_ID", "RULE_INT", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'logs:'", "'tables:'", "'steps:'", "':'", "'as'", "'SAVE'", "'description'", "'GROUP_BY'", "'->'", "'ON'", "'('", "','", "')'", "'AND'", "'INTO'", "'SORT'", "'BY'", "'ORDER'", "'APPEND_ROWS'", "'FROM'", "'TO'", "'MAPPING'", "'FILTER'", "'WHERE'", "'VALUES'", "'ARE'", "'GenericStep'", "'{'", "'next'", "'}'", "'JOIN'", "'WITH'", "'SELECTING'", "'IMPORT'", "'LOOKUP'", "'PUT'", "'REMOVE_DUPLICATES'", "'Concat'", "'table'", "'sourceA'", "'sourceB'", "'resultColumn'", "'resultTable'", "'Split'", "'source'", "'delimiter'", "'atCharIndex'", "'resultColumnA'", "'resultColumnB'", "'Extract'", "'column'", "'lbChar'", "'ubChar'", "'pattern'", "'DELIMITER'", "'DELETE_MISMATCHED_TYPES'", "'AS'", "'-'", "'true'", "'false'", "'TEXT'", "'NUMBER'", "'DATE'", "'MAX'", "'MIN'", "'COUNT'", "'SUM'", "'AVERAGE'", "'ASC'", "'DESC'", "'EQUALS'", "'LESS_THAN'", "'GREATER_THAN'", "'LESS_OR_EQUALS_THAN'", "'GREATER_OR_EQUALS_THAN'", "'INNER'", "'OUTER'", "'LEFT'", "'RIGHT'", "'NUMERIC_SUM'", "'NUMERIC_SUBTRACT'", "'NUMERIC_MULTIPLY'", "'NUMERIC_DIVIDE'", "'TEXT_CONCAT'"
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
    public static final int RULE_ID=5;
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
    public static final int T__94=94;
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
    public static final int RULE_STRING=4;
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


        public InternalMyDslParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalMyDslParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalMyDslParser.tokenNames; }
    public String getGrammarFileName() { return "InternalMyDsl.g"; }



     	private MyDslGrammarAccess grammarAccess;

        public InternalMyDslParser(TokenStream input, MyDslGrammarAccess grammarAccess) {
            this(input);
            this.grammarAccess = grammarAccess;
            registerRules(grammarAccess.getGrammar());
        }

        @Override
        protected String getFirstRuleName() {
        	return "Model";
       	}

       	@Override
       	protected MyDslGrammarAccess getGrammarAccess() {
       		return grammarAccess;
       	}




    // $ANTLR start "entryRuleModel"
    // InternalMyDsl.g:65:1: entryRuleModel returns [EObject current=null] : iv_ruleModel= ruleModel EOF ;
    public final EObject entryRuleModel() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleModel = null;


        try {
            // InternalMyDsl.g:65:46: (iv_ruleModel= ruleModel EOF )
            // InternalMyDsl.g:66:2: iv_ruleModel= ruleModel EOF
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
    // InternalMyDsl.g:72:1: ruleModel returns [EObject current=null] : ( ( (lv_name_0_0= ruleEString ) ) otherlv_1= 'logs:' ( (lv_logs_2_0= ruleEBooleanObject ) ) otherlv_3= 'tables:' ( (lv_tables_4_0= ruleTable ) ) ( (lv_tables_5_0= ruleTable ) )* otherlv_6= 'steps:' ( (lv_steps_7_0= ruleStep ) ) ( (lv_steps_8_0= ruleStep ) )* ) ;
    public final EObject ruleModel() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_6=null;
        AntlrDatatypeRuleToken lv_name_0_0 = null;

        AntlrDatatypeRuleToken lv_logs_2_0 = null;

        EObject lv_tables_4_0 = null;

        EObject lv_tables_5_0 = null;

        EObject lv_steps_7_0 = null;

        EObject lv_steps_8_0 = null;



        	enterRule();

        try {
            // InternalMyDsl.g:78:2: ( ( ( (lv_name_0_0= ruleEString ) ) otherlv_1= 'logs:' ( (lv_logs_2_0= ruleEBooleanObject ) ) otherlv_3= 'tables:' ( (lv_tables_4_0= ruleTable ) ) ( (lv_tables_5_0= ruleTable ) )* otherlv_6= 'steps:' ( (lv_steps_7_0= ruleStep ) ) ( (lv_steps_8_0= ruleStep ) )* ) )
            // InternalMyDsl.g:79:2: ( ( (lv_name_0_0= ruleEString ) ) otherlv_1= 'logs:' ( (lv_logs_2_0= ruleEBooleanObject ) ) otherlv_3= 'tables:' ( (lv_tables_4_0= ruleTable ) ) ( (lv_tables_5_0= ruleTable ) )* otherlv_6= 'steps:' ( (lv_steps_7_0= ruleStep ) ) ( (lv_steps_8_0= ruleStep ) )* )
            {
            // InternalMyDsl.g:79:2: ( ( (lv_name_0_0= ruleEString ) ) otherlv_1= 'logs:' ( (lv_logs_2_0= ruleEBooleanObject ) ) otherlv_3= 'tables:' ( (lv_tables_4_0= ruleTable ) ) ( (lv_tables_5_0= ruleTable ) )* otherlv_6= 'steps:' ( (lv_steps_7_0= ruleStep ) ) ( (lv_steps_8_0= ruleStep ) )* )
            // InternalMyDsl.g:80:3: ( (lv_name_0_0= ruleEString ) ) otherlv_1= 'logs:' ( (lv_logs_2_0= ruleEBooleanObject ) ) otherlv_3= 'tables:' ( (lv_tables_4_0= ruleTable ) ) ( (lv_tables_5_0= ruleTable ) )* otherlv_6= 'steps:' ( (lv_steps_7_0= ruleStep ) ) ( (lv_steps_8_0= ruleStep ) )*
            {
            // InternalMyDsl.g:80:3: ( (lv_name_0_0= ruleEString ) )
            // InternalMyDsl.g:81:4: (lv_name_0_0= ruleEString )
            {
            // InternalMyDsl.g:81:4: (lv_name_0_0= ruleEString )
            // InternalMyDsl.g:82:5: lv_name_0_0= ruleEString
            {

            					newCompositeNode(grammarAccess.getModelAccess().getNameEStringParserRuleCall_0_0());
            				
            pushFollow(FOLLOW_3);
            lv_name_0_0=ruleEString();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getModelRule());
            					}
            					set(
            						current,
            						"name",
            						lv_name_0_0,
            						"org.xtext.example.mydsl.MyDsl.EString");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_1=(Token)match(input,11,FOLLOW_4); 

            			newLeafNode(otherlv_1, grammarAccess.getModelAccess().getLogsKeyword_1());
            		
            // InternalMyDsl.g:103:3: ( (lv_logs_2_0= ruleEBooleanObject ) )
            // InternalMyDsl.g:104:4: (lv_logs_2_0= ruleEBooleanObject )
            {
            // InternalMyDsl.g:104:4: (lv_logs_2_0= ruleEBooleanObject )
            // InternalMyDsl.g:105:5: lv_logs_2_0= ruleEBooleanObject
            {

            					newCompositeNode(grammarAccess.getModelAccess().getLogsEBooleanObjectParserRuleCall_2_0());
            				
            pushFollow(FOLLOW_5);
            lv_logs_2_0=ruleEBooleanObject();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getModelRule());
            					}
            					set(
            						current,
            						"logs",
            						lv_logs_2_0,
            						"org.xtext.example.mydsl.MyDsl.EBooleanObject");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_3=(Token)match(input,12,FOLLOW_6); 

            			newLeafNode(otherlv_3, grammarAccess.getModelAccess().getTablesKeyword_3());
            		
            // InternalMyDsl.g:126:3: ( (lv_tables_4_0= ruleTable ) )
            // InternalMyDsl.g:127:4: (lv_tables_4_0= ruleTable )
            {
            // InternalMyDsl.g:127:4: (lv_tables_4_0= ruleTable )
            // InternalMyDsl.g:128:5: lv_tables_4_0= ruleTable
            {

            					newCompositeNode(grammarAccess.getModelAccess().getTablesTableParserRuleCall_4_0());
            				
            pushFollow(FOLLOW_7);
            lv_tables_4_0=ruleTable();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getModelRule());
            					}
            					add(
            						current,
            						"tables",
            						lv_tables_4_0,
            						"org.xtext.example.mydsl.MyDsl.Table");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalMyDsl.g:145:3: ( (lv_tables_5_0= ruleTable ) )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( ((LA1_0>=RULE_STRING && LA1_0<=RULE_ID)) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // InternalMyDsl.g:146:4: (lv_tables_5_0= ruleTable )
            	    {
            	    // InternalMyDsl.g:146:4: (lv_tables_5_0= ruleTable )
            	    // InternalMyDsl.g:147:5: lv_tables_5_0= ruleTable
            	    {

            	    					newCompositeNode(grammarAccess.getModelAccess().getTablesTableParserRuleCall_5_0());
            	    				
            	    pushFollow(FOLLOW_7);
            	    lv_tables_5_0=ruleTable();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getModelRule());
            	    					}
            	    					add(
            	    						current,
            	    						"tables",
            	    						lv_tables_5_0,
            	    						"org.xtext.example.mydsl.MyDsl.Table");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);

            otherlv_6=(Token)match(input,13,FOLLOW_8); 

            			newLeafNode(otherlv_6, grammarAccess.getModelAccess().getStepsKeyword_6());
            		
            // InternalMyDsl.g:168:3: ( (lv_steps_7_0= ruleStep ) )
            // InternalMyDsl.g:169:4: (lv_steps_7_0= ruleStep )
            {
            // InternalMyDsl.g:169:4: (lv_steps_7_0= ruleStep )
            // InternalMyDsl.g:170:5: lv_steps_7_0= ruleStep
            {

            					newCompositeNode(grammarAccess.getModelAccess().getStepsStepParserRuleCall_7_0());
            				
            pushFollow(FOLLOW_9);
            lv_steps_7_0=ruleStep();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getModelRule());
            					}
            					add(
            						current,
            						"steps",
            						lv_steps_7_0,
            						"org.xtext.example.mydsl.MyDsl.Step");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalMyDsl.g:187:3: ( (lv_steps_8_0= ruleStep ) )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==16||LA2_0==18||LA2_0==26||LA2_0==29||LA2_0==33||LA2_0==37||LA2_0==41||(LA2_0>=44 && LA2_0<=45)||(LA2_0>=47 && LA2_0<=48)||LA2_0==54||LA2_0==60) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // InternalMyDsl.g:188:4: (lv_steps_8_0= ruleStep )
            	    {
            	    // InternalMyDsl.g:188:4: (lv_steps_8_0= ruleStep )
            	    // InternalMyDsl.g:189:5: lv_steps_8_0= ruleStep
            	    {

            	    					newCompositeNode(grammarAccess.getModelAccess().getStepsStepParserRuleCall_8_0());
            	    				
            	    pushFollow(FOLLOW_9);
            	    lv_steps_8_0=ruleStep();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getModelRule());
            	    					}
            	    					add(
            	    						current,
            	    						"steps",
            	    						lv_steps_8_0,
            	    						"org.xtext.example.mydsl.MyDsl.Step");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop2;
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
    // $ANTLR end "ruleModel"


    // $ANTLR start "entryRuleStep"
    // InternalMyDsl.g:210:1: entryRuleStep returns [EObject current=null] : iv_ruleStep= ruleStep EOF ;
    public final EObject entryRuleStep() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleStep = null;


        try {
            // InternalMyDsl.g:210:45: (iv_ruleStep= ruleStep EOF )
            // InternalMyDsl.g:211:2: iv_ruleStep= ruleStep EOF
            {
             newCompositeNode(grammarAccess.getStepRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleStep=ruleStep();

            state._fsp--;

             current =iv_ruleStep; 
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
    // $ANTLR end "entryRuleStep"


    // $ANTLR start "ruleStep"
    // InternalMyDsl.g:217:1: ruleStep returns [EObject current=null] : (this_Save_0= ruleSave | this_Group_1= ruleGroup | this_Sort_2= ruleSort | this_AppendRows_3= ruleAppendRows | this_Filter_4= ruleFilter | this_GenericStep_5= ruleGenericStep | this_Join_6= ruleJoin | this_Import_7= ruleImport | this_Lookup_8= ruleLookup | this_RemoveDuplicates_9= ruleRemoveDuplicates | this_Concat_10= ruleConcat | this_Split_11= ruleSplit | this_Extract_12= ruleExtract ) ;
    public final EObject ruleStep() throws RecognitionException {
        EObject current = null;

        EObject this_Save_0 = null;

        EObject this_Group_1 = null;

        EObject this_Sort_2 = null;

        EObject this_AppendRows_3 = null;

        EObject this_Filter_4 = null;

        EObject this_GenericStep_5 = null;

        EObject this_Join_6 = null;

        EObject this_Import_7 = null;

        EObject this_Lookup_8 = null;

        EObject this_RemoveDuplicates_9 = null;

        EObject this_Concat_10 = null;

        EObject this_Split_11 = null;

        EObject this_Extract_12 = null;



        	enterRule();

        try {
            // InternalMyDsl.g:223:2: ( (this_Save_0= ruleSave | this_Group_1= ruleGroup | this_Sort_2= ruleSort | this_AppendRows_3= ruleAppendRows | this_Filter_4= ruleFilter | this_GenericStep_5= ruleGenericStep | this_Join_6= ruleJoin | this_Import_7= ruleImport | this_Lookup_8= ruleLookup | this_RemoveDuplicates_9= ruleRemoveDuplicates | this_Concat_10= ruleConcat | this_Split_11= ruleSplit | this_Extract_12= ruleExtract ) )
            // InternalMyDsl.g:224:2: (this_Save_0= ruleSave | this_Group_1= ruleGroup | this_Sort_2= ruleSort | this_AppendRows_3= ruleAppendRows | this_Filter_4= ruleFilter | this_GenericStep_5= ruleGenericStep | this_Join_6= ruleJoin | this_Import_7= ruleImport | this_Lookup_8= ruleLookup | this_RemoveDuplicates_9= ruleRemoveDuplicates | this_Concat_10= ruleConcat | this_Split_11= ruleSplit | this_Extract_12= ruleExtract )
            {
            // InternalMyDsl.g:224:2: (this_Save_0= ruleSave | this_Group_1= ruleGroup | this_Sort_2= ruleSort | this_AppendRows_3= ruleAppendRows | this_Filter_4= ruleFilter | this_GenericStep_5= ruleGenericStep | this_Join_6= ruleJoin | this_Import_7= ruleImport | this_Lookup_8= ruleLookup | this_RemoveDuplicates_9= ruleRemoveDuplicates | this_Concat_10= ruleConcat | this_Split_11= ruleSplit | this_Extract_12= ruleExtract )
            int alt3=13;
            switch ( input.LA(1) ) {
            case 16:
                {
                alt3=1;
                }
                break;
            case 18:
                {
                alt3=2;
                }
                break;
            case 26:
                {
                alt3=3;
                }
                break;
            case 29:
                {
                alt3=4;
                }
                break;
            case 33:
                {
                alt3=5;
                }
                break;
            case 37:
                {
                alt3=6;
                }
                break;
            case 41:
                {
                alt3=7;
                }
                break;
            case 44:
                {
                alt3=8;
                }
                break;
            case 45:
                {
                alt3=9;
                }
                break;
            case 47:
                {
                alt3=10;
                }
                break;
            case 48:
                {
                alt3=11;
                }
                break;
            case 54:
                {
                alt3=12;
                }
                break;
            case 60:
                {
                alt3=13;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 3, 0, input);

                throw nvae;
            }

            switch (alt3) {
                case 1 :
                    // InternalMyDsl.g:225:3: this_Save_0= ruleSave
                    {

                    			newCompositeNode(grammarAccess.getStepAccess().getSaveParserRuleCall_0());
                    		
                    pushFollow(FOLLOW_2);
                    this_Save_0=ruleSave();

                    state._fsp--;


                    			current = this_Save_0;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 2 :
                    // InternalMyDsl.g:234:3: this_Group_1= ruleGroup
                    {

                    			newCompositeNode(grammarAccess.getStepAccess().getGroupParserRuleCall_1());
                    		
                    pushFollow(FOLLOW_2);
                    this_Group_1=ruleGroup();

                    state._fsp--;


                    			current = this_Group_1;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 3 :
                    // InternalMyDsl.g:243:3: this_Sort_2= ruleSort
                    {

                    			newCompositeNode(grammarAccess.getStepAccess().getSortParserRuleCall_2());
                    		
                    pushFollow(FOLLOW_2);
                    this_Sort_2=ruleSort();

                    state._fsp--;


                    			current = this_Sort_2;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 4 :
                    // InternalMyDsl.g:252:3: this_AppendRows_3= ruleAppendRows
                    {

                    			newCompositeNode(grammarAccess.getStepAccess().getAppendRowsParserRuleCall_3());
                    		
                    pushFollow(FOLLOW_2);
                    this_AppendRows_3=ruleAppendRows();

                    state._fsp--;


                    			current = this_AppendRows_3;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 5 :
                    // InternalMyDsl.g:261:3: this_Filter_4= ruleFilter
                    {

                    			newCompositeNode(grammarAccess.getStepAccess().getFilterParserRuleCall_4());
                    		
                    pushFollow(FOLLOW_2);
                    this_Filter_4=ruleFilter();

                    state._fsp--;


                    			current = this_Filter_4;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 6 :
                    // InternalMyDsl.g:270:3: this_GenericStep_5= ruleGenericStep
                    {

                    			newCompositeNode(grammarAccess.getStepAccess().getGenericStepParserRuleCall_5());
                    		
                    pushFollow(FOLLOW_2);
                    this_GenericStep_5=ruleGenericStep();

                    state._fsp--;


                    			current = this_GenericStep_5;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 7 :
                    // InternalMyDsl.g:279:3: this_Join_6= ruleJoin
                    {

                    			newCompositeNode(grammarAccess.getStepAccess().getJoinParserRuleCall_6());
                    		
                    pushFollow(FOLLOW_2);
                    this_Join_6=ruleJoin();

                    state._fsp--;


                    			current = this_Join_6;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 8 :
                    // InternalMyDsl.g:288:3: this_Import_7= ruleImport
                    {

                    			newCompositeNode(grammarAccess.getStepAccess().getImportParserRuleCall_7());
                    		
                    pushFollow(FOLLOW_2);
                    this_Import_7=ruleImport();

                    state._fsp--;


                    			current = this_Import_7;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 9 :
                    // InternalMyDsl.g:297:3: this_Lookup_8= ruleLookup
                    {

                    			newCompositeNode(grammarAccess.getStepAccess().getLookupParserRuleCall_8());
                    		
                    pushFollow(FOLLOW_2);
                    this_Lookup_8=ruleLookup();

                    state._fsp--;


                    			current = this_Lookup_8;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 10 :
                    // InternalMyDsl.g:306:3: this_RemoveDuplicates_9= ruleRemoveDuplicates
                    {

                    			newCompositeNode(grammarAccess.getStepAccess().getRemoveDuplicatesParserRuleCall_9());
                    		
                    pushFollow(FOLLOW_2);
                    this_RemoveDuplicates_9=ruleRemoveDuplicates();

                    state._fsp--;


                    			current = this_RemoveDuplicates_9;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 11 :
                    // InternalMyDsl.g:315:3: this_Concat_10= ruleConcat
                    {

                    			newCompositeNode(grammarAccess.getStepAccess().getConcatParserRuleCall_10());
                    		
                    pushFollow(FOLLOW_2);
                    this_Concat_10=ruleConcat();

                    state._fsp--;


                    			current = this_Concat_10;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 12 :
                    // InternalMyDsl.g:324:3: this_Split_11= ruleSplit
                    {

                    			newCompositeNode(grammarAccess.getStepAccess().getSplitParserRuleCall_11());
                    		
                    pushFollow(FOLLOW_2);
                    this_Split_11=ruleSplit();

                    state._fsp--;


                    			current = this_Split_11;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 13 :
                    // InternalMyDsl.g:333:3: this_Extract_12= ruleExtract
                    {

                    			newCompositeNode(grammarAccess.getStepAccess().getExtractParserRuleCall_12());
                    		
                    pushFollow(FOLLOW_2);
                    this_Extract_12=ruleExtract();

                    state._fsp--;


                    			current = this_Extract_12;
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
    // $ANTLR end "ruleStep"


    // $ANTLR start "entryRuleEString"
    // InternalMyDsl.g:345:1: entryRuleEString returns [String current=null] : iv_ruleEString= ruleEString EOF ;
    public final String entryRuleEString() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleEString = null;


        try {
            // InternalMyDsl.g:345:47: (iv_ruleEString= ruleEString EOF )
            // InternalMyDsl.g:346:2: iv_ruleEString= ruleEString EOF
            {
             newCompositeNode(grammarAccess.getEStringRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleEString=ruleEString();

            state._fsp--;

             current =iv_ruleEString.getText(); 
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
    // $ANTLR end "entryRuleEString"


    // $ANTLR start "ruleEString"
    // InternalMyDsl.g:352:1: ruleEString returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_STRING_0= RULE_STRING | this_ID_1= RULE_ID ) ;
    public final AntlrDatatypeRuleToken ruleEString() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_STRING_0=null;
        Token this_ID_1=null;


        	enterRule();

        try {
            // InternalMyDsl.g:358:2: ( (this_STRING_0= RULE_STRING | this_ID_1= RULE_ID ) )
            // InternalMyDsl.g:359:2: (this_STRING_0= RULE_STRING | this_ID_1= RULE_ID )
            {
            // InternalMyDsl.g:359:2: (this_STRING_0= RULE_STRING | this_ID_1= RULE_ID )
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==RULE_STRING) ) {
                alt4=1;
            }
            else if ( (LA4_0==RULE_ID) ) {
                alt4=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 4, 0, input);

                throw nvae;
            }
            switch (alt4) {
                case 1 :
                    // InternalMyDsl.g:360:3: this_STRING_0= RULE_STRING
                    {
                    this_STRING_0=(Token)match(input,RULE_STRING,FOLLOW_2); 

                    			current.merge(this_STRING_0);
                    		

                    			newLeafNode(this_STRING_0, grammarAccess.getEStringAccess().getSTRINGTerminalRuleCall_0());
                    		

                    }
                    break;
                case 2 :
                    // InternalMyDsl.g:368:3: this_ID_1= RULE_ID
                    {
                    this_ID_1=(Token)match(input,RULE_ID,FOLLOW_2); 

                    			current.merge(this_ID_1);
                    		

                    			newLeafNode(this_ID_1, grammarAccess.getEStringAccess().getIDTerminalRuleCall_1());
                    		

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
    // $ANTLR end "ruleEString"


    // $ANTLR start "entryRuleTable"
    // InternalMyDsl.g:379:1: entryRuleTable returns [EObject current=null] : iv_ruleTable= ruleTable EOF ;
    public final EObject entryRuleTable() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTable = null;


        try {
            // InternalMyDsl.g:379:46: (iv_ruleTable= ruleTable EOF )
            // InternalMyDsl.g:380:2: iv_ruleTable= ruleTable EOF
            {
             newCompositeNode(grammarAccess.getTableRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleTable=ruleTable();

            state._fsp--;

             current =iv_ruleTable; 
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
    // $ANTLR end "entryRuleTable"


    // $ANTLR start "ruleTable"
    // InternalMyDsl.g:386:1: ruleTable returns [EObject current=null] : ( ( (lv_name_0_0= ruleEString ) ) otherlv_1= ':' ( (lv_columns_2_0= ruleColumn ) ) ( (lv_columns_3_0= ruleColumn ) )* ) ;
    public final EObject ruleTable() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        AntlrDatatypeRuleToken lv_name_0_0 = null;

        EObject lv_columns_2_0 = null;

        EObject lv_columns_3_0 = null;



        	enterRule();

        try {
            // InternalMyDsl.g:392:2: ( ( ( (lv_name_0_0= ruleEString ) ) otherlv_1= ':' ( (lv_columns_2_0= ruleColumn ) ) ( (lv_columns_3_0= ruleColumn ) )* ) )
            // InternalMyDsl.g:393:2: ( ( (lv_name_0_0= ruleEString ) ) otherlv_1= ':' ( (lv_columns_2_0= ruleColumn ) ) ( (lv_columns_3_0= ruleColumn ) )* )
            {
            // InternalMyDsl.g:393:2: ( ( (lv_name_0_0= ruleEString ) ) otherlv_1= ':' ( (lv_columns_2_0= ruleColumn ) ) ( (lv_columns_3_0= ruleColumn ) )* )
            // InternalMyDsl.g:394:3: ( (lv_name_0_0= ruleEString ) ) otherlv_1= ':' ( (lv_columns_2_0= ruleColumn ) ) ( (lv_columns_3_0= ruleColumn ) )*
            {
            // InternalMyDsl.g:394:3: ( (lv_name_0_0= ruleEString ) )
            // InternalMyDsl.g:395:4: (lv_name_0_0= ruleEString )
            {
            // InternalMyDsl.g:395:4: (lv_name_0_0= ruleEString )
            // InternalMyDsl.g:396:5: lv_name_0_0= ruleEString
            {

            					newCompositeNode(grammarAccess.getTableAccess().getNameEStringParserRuleCall_0_0());
            				
            pushFollow(FOLLOW_10);
            lv_name_0_0=ruleEString();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getTableRule());
            					}
            					set(
            						current,
            						"name",
            						lv_name_0_0,
            						"org.xtext.example.mydsl.MyDsl.EString");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_1=(Token)match(input,14,FOLLOW_6); 

            			newLeafNode(otherlv_1, grammarAccess.getTableAccess().getColonKeyword_1());
            		
            // InternalMyDsl.g:417:3: ( (lv_columns_2_0= ruleColumn ) )
            // InternalMyDsl.g:418:4: (lv_columns_2_0= ruleColumn )
            {
            // InternalMyDsl.g:418:4: (lv_columns_2_0= ruleColumn )
            // InternalMyDsl.g:419:5: lv_columns_2_0= ruleColumn
            {

            					newCompositeNode(grammarAccess.getTableAccess().getColumnsColumnParserRuleCall_2_0());
            				
            pushFollow(FOLLOW_11);
            lv_columns_2_0=ruleColumn();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getTableRule());
            					}
            					add(
            						current,
            						"columns",
            						lv_columns_2_0,
            						"org.xtext.example.mydsl.MyDsl.Column");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalMyDsl.g:436:3: ( (lv_columns_3_0= ruleColumn ) )*
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( (LA5_0==RULE_STRING) ) {
                    int LA5_1 = input.LA(2);

                    if ( (LA5_1==15) ) {
                        alt5=1;
                    }


                }
                else if ( (LA5_0==RULE_ID) ) {
                    int LA5_2 = input.LA(2);

                    if ( (LA5_2==15) ) {
                        alt5=1;
                    }


                }


                switch (alt5) {
            	case 1 :
            	    // InternalMyDsl.g:437:4: (lv_columns_3_0= ruleColumn )
            	    {
            	    // InternalMyDsl.g:437:4: (lv_columns_3_0= ruleColumn )
            	    // InternalMyDsl.g:438:5: lv_columns_3_0= ruleColumn
            	    {

            	    					newCompositeNode(grammarAccess.getTableAccess().getColumnsColumnParserRuleCall_3_0());
            	    				
            	    pushFollow(FOLLOW_11);
            	    lv_columns_3_0=ruleColumn();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getTableRule());
            	    					}
            	    					add(
            	    						current,
            	    						"columns",
            	    						lv_columns_3_0,
            	    						"org.xtext.example.mydsl.MyDsl.Column");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop5;
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
    // $ANTLR end "ruleTable"


    // $ANTLR start "entryRuleColumn"
    // InternalMyDsl.g:459:1: entryRuleColumn returns [EObject current=null] : iv_ruleColumn= ruleColumn EOF ;
    public final EObject entryRuleColumn() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleColumn = null;


        try {
            // InternalMyDsl.g:459:47: (iv_ruleColumn= ruleColumn EOF )
            // InternalMyDsl.g:460:2: iv_ruleColumn= ruleColumn EOF
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
    // InternalMyDsl.g:466:1: ruleColumn returns [EObject current=null] : ( ( (lv_name_0_0= ruleEString ) ) otherlv_1= 'as' ( (lv_dataType_2_0= ruleDataType ) ) ) ;
    public final EObject ruleColumn() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        AntlrDatatypeRuleToken lv_name_0_0 = null;

        Enumerator lv_dataType_2_0 = null;



        	enterRule();

        try {
            // InternalMyDsl.g:472:2: ( ( ( (lv_name_0_0= ruleEString ) ) otherlv_1= 'as' ( (lv_dataType_2_0= ruleDataType ) ) ) )
            // InternalMyDsl.g:473:2: ( ( (lv_name_0_0= ruleEString ) ) otherlv_1= 'as' ( (lv_dataType_2_0= ruleDataType ) ) )
            {
            // InternalMyDsl.g:473:2: ( ( (lv_name_0_0= ruleEString ) ) otherlv_1= 'as' ( (lv_dataType_2_0= ruleDataType ) ) )
            // InternalMyDsl.g:474:3: ( (lv_name_0_0= ruleEString ) ) otherlv_1= 'as' ( (lv_dataType_2_0= ruleDataType ) )
            {
            // InternalMyDsl.g:474:3: ( (lv_name_0_0= ruleEString ) )
            // InternalMyDsl.g:475:4: (lv_name_0_0= ruleEString )
            {
            // InternalMyDsl.g:475:4: (lv_name_0_0= ruleEString )
            // InternalMyDsl.g:476:5: lv_name_0_0= ruleEString
            {

            					newCompositeNode(grammarAccess.getColumnAccess().getNameEStringParserRuleCall_0_0());
            				
            pushFollow(FOLLOW_12);
            lv_name_0_0=ruleEString();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getColumnRule());
            					}
            					set(
            						current,
            						"name",
            						lv_name_0_0,
            						"org.xtext.example.mydsl.MyDsl.EString");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_1=(Token)match(input,15,FOLLOW_13); 

            			newLeafNode(otherlv_1, grammarAccess.getColumnAccess().getAsKeyword_1());
            		
            // InternalMyDsl.g:497:3: ( (lv_dataType_2_0= ruleDataType ) )
            // InternalMyDsl.g:498:4: (lv_dataType_2_0= ruleDataType )
            {
            // InternalMyDsl.g:498:4: (lv_dataType_2_0= ruleDataType )
            // InternalMyDsl.g:499:5: lv_dataType_2_0= ruleDataType
            {

            					newCompositeNode(grammarAccess.getColumnAccess().getDataTypeDataTypeEnumRuleCall_2_0());
            				
            pushFollow(FOLLOW_2);
            lv_dataType_2_0=ruleDataType();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getColumnRule());
            					}
            					set(
            						current,
            						"dataType",
            						lv_dataType_2_0,
            						"org.xtext.example.mydsl.MyDsl.DataType");
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
    // $ANTLR end "ruleColumn"


    // $ANTLR start "entryRuleSave"
    // InternalMyDsl.g:520:1: entryRuleSave returns [EObject current=null] : iv_ruleSave= ruleSave EOF ;
    public final EObject entryRuleSave() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSave = null;


        try {
            // InternalMyDsl.g:520:45: (iv_ruleSave= ruleSave EOF )
            // InternalMyDsl.g:521:2: iv_ruleSave= ruleSave EOF
            {
             newCompositeNode(grammarAccess.getSaveRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleSave=ruleSave();

            state._fsp--;

             current =iv_ruleSave; 
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
    // $ANTLR end "entryRuleSave"


    // $ANTLR start "ruleSave"
    // InternalMyDsl.g:527:1: ruleSave returns [EObject current=null] : (otherlv_0= 'SAVE' ( (lv_name_1_0= ruleEString ) ) otherlv_2= ':' (otherlv_3= 'description' ( (lv_description_4_0= ruleEString ) ) )? ( (lv_tablesToSave_5_0= ruleTableToSave ) ) ( (lv_tablesToSave_6_0= ruleTableToSave ) )* ) ;
    public final EObject ruleSave() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        AntlrDatatypeRuleToken lv_name_1_0 = null;

        AntlrDatatypeRuleToken lv_description_4_0 = null;

        EObject lv_tablesToSave_5_0 = null;

        EObject lv_tablesToSave_6_0 = null;



        	enterRule();

        try {
            // InternalMyDsl.g:533:2: ( (otherlv_0= 'SAVE' ( (lv_name_1_0= ruleEString ) ) otherlv_2= ':' (otherlv_3= 'description' ( (lv_description_4_0= ruleEString ) ) )? ( (lv_tablesToSave_5_0= ruleTableToSave ) ) ( (lv_tablesToSave_6_0= ruleTableToSave ) )* ) )
            // InternalMyDsl.g:534:2: (otherlv_0= 'SAVE' ( (lv_name_1_0= ruleEString ) ) otherlv_2= ':' (otherlv_3= 'description' ( (lv_description_4_0= ruleEString ) ) )? ( (lv_tablesToSave_5_0= ruleTableToSave ) ) ( (lv_tablesToSave_6_0= ruleTableToSave ) )* )
            {
            // InternalMyDsl.g:534:2: (otherlv_0= 'SAVE' ( (lv_name_1_0= ruleEString ) ) otherlv_2= ':' (otherlv_3= 'description' ( (lv_description_4_0= ruleEString ) ) )? ( (lv_tablesToSave_5_0= ruleTableToSave ) ) ( (lv_tablesToSave_6_0= ruleTableToSave ) )* )
            // InternalMyDsl.g:535:3: otherlv_0= 'SAVE' ( (lv_name_1_0= ruleEString ) ) otherlv_2= ':' (otherlv_3= 'description' ( (lv_description_4_0= ruleEString ) ) )? ( (lv_tablesToSave_5_0= ruleTableToSave ) ) ( (lv_tablesToSave_6_0= ruleTableToSave ) )*
            {
            otherlv_0=(Token)match(input,16,FOLLOW_6); 

            			newLeafNode(otherlv_0, grammarAccess.getSaveAccess().getSAVEKeyword_0());
            		
            // InternalMyDsl.g:539:3: ( (lv_name_1_0= ruleEString ) )
            // InternalMyDsl.g:540:4: (lv_name_1_0= ruleEString )
            {
            // InternalMyDsl.g:540:4: (lv_name_1_0= ruleEString )
            // InternalMyDsl.g:541:5: lv_name_1_0= ruleEString
            {

            					newCompositeNode(grammarAccess.getSaveAccess().getNameEStringParserRuleCall_1_0());
            				
            pushFollow(FOLLOW_10);
            lv_name_1_0=ruleEString();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getSaveRule());
            					}
            					set(
            						current,
            						"name",
            						lv_name_1_0,
            						"org.xtext.example.mydsl.MyDsl.EString");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_2=(Token)match(input,14,FOLLOW_14); 

            			newLeafNode(otherlv_2, grammarAccess.getSaveAccess().getColonKeyword_2());
            		
            // InternalMyDsl.g:562:3: (otherlv_3= 'description' ( (lv_description_4_0= ruleEString ) ) )?
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==17) ) {
                alt6=1;
            }
            switch (alt6) {
                case 1 :
                    // InternalMyDsl.g:563:4: otherlv_3= 'description' ( (lv_description_4_0= ruleEString ) )
                    {
                    otherlv_3=(Token)match(input,17,FOLLOW_6); 

                    				newLeafNode(otherlv_3, grammarAccess.getSaveAccess().getDescriptionKeyword_3_0());
                    			
                    // InternalMyDsl.g:567:4: ( (lv_description_4_0= ruleEString ) )
                    // InternalMyDsl.g:568:5: (lv_description_4_0= ruleEString )
                    {
                    // InternalMyDsl.g:568:5: (lv_description_4_0= ruleEString )
                    // InternalMyDsl.g:569:6: lv_description_4_0= ruleEString
                    {

                    						newCompositeNode(grammarAccess.getSaveAccess().getDescriptionEStringParserRuleCall_3_1_0());
                    					
                    pushFollow(FOLLOW_14);
                    lv_description_4_0=ruleEString();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getSaveRule());
                    						}
                    						set(
                    							current,
                    							"description",
                    							lv_description_4_0,
                    							"org.xtext.example.mydsl.MyDsl.EString");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;

            }

            // InternalMyDsl.g:587:3: ( (lv_tablesToSave_5_0= ruleTableToSave ) )
            // InternalMyDsl.g:588:4: (lv_tablesToSave_5_0= ruleTableToSave )
            {
            // InternalMyDsl.g:588:4: (lv_tablesToSave_5_0= ruleTableToSave )
            // InternalMyDsl.g:589:5: lv_tablesToSave_5_0= ruleTableToSave
            {

            					newCompositeNode(grammarAccess.getSaveAccess().getTablesToSaveTableToSaveParserRuleCall_4_0());
            				
            pushFollow(FOLLOW_15);
            lv_tablesToSave_5_0=ruleTableToSave();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getSaveRule());
            					}
            					add(
            						current,
            						"tablesToSave",
            						lv_tablesToSave_5_0,
            						"org.xtext.example.mydsl.MyDsl.TableToSave");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalMyDsl.g:606:3: ( (lv_tablesToSave_6_0= ruleTableToSave ) )*
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( ((LA7_0>=RULE_STRING && LA7_0<=RULE_ID)) ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // InternalMyDsl.g:607:4: (lv_tablesToSave_6_0= ruleTableToSave )
            	    {
            	    // InternalMyDsl.g:607:4: (lv_tablesToSave_6_0= ruleTableToSave )
            	    // InternalMyDsl.g:608:5: lv_tablesToSave_6_0= ruleTableToSave
            	    {

            	    					newCompositeNode(grammarAccess.getSaveAccess().getTablesToSaveTableToSaveParserRuleCall_5_0());
            	    				
            	    pushFollow(FOLLOW_15);
            	    lv_tablesToSave_6_0=ruleTableToSave();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getSaveRule());
            	    					}
            	    					add(
            	    						current,
            	    						"tablesToSave",
            	    						lv_tablesToSave_6_0,
            	    						"org.xtext.example.mydsl.MyDsl.TableToSave");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop7;
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
    // $ANTLR end "ruleSave"


    // $ANTLR start "entryRuleGroup"
    // InternalMyDsl.g:629:1: entryRuleGroup returns [EObject current=null] : iv_ruleGroup= ruleGroup EOF ;
    public final EObject entryRuleGroup() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleGroup = null;


        try {
            // InternalMyDsl.g:629:46: (iv_ruleGroup= ruleGroup EOF )
            // InternalMyDsl.g:630:2: iv_ruleGroup= ruleGroup EOF
            {
             newCompositeNode(grammarAccess.getGroupRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleGroup=ruleGroup();

            state._fsp--;

             current =iv_ruleGroup; 
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
    // $ANTLR end "entryRuleGroup"


    // $ANTLR start "ruleGroup"
    // InternalMyDsl.g:636:1: ruleGroup returns [EObject current=null] : (otherlv_0= 'GROUP_BY' ( (lv_name_1_0= ruleEString ) ) otherlv_2= '->' ( ( ruleEString ) ) otherlv_4= ':' (otherlv_5= 'description' ( (lv_description_6_0= ruleEString ) ) )? otherlv_7= 'ON' ( ( ruleEString ) ) otherlv_9= '(' ( ( ruleEString ) ) (otherlv_11= ',' ( ( ruleEString ) ) )* otherlv_13= ')' otherlv_14= 'AND' ( (lv_operation_15_0= ruleGroupOperationType ) ) ( ( ruleEString ) ) otherlv_17= 'INTO' ( ( ruleEString ) ) otherlv_19= '(' ( ( ruleEString ) ) otherlv_21= ')' ) ;
    public final EObject ruleGroup() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        Token otherlv_9=null;
        Token otherlv_11=null;
        Token otherlv_13=null;
        Token otherlv_14=null;
        Token otherlv_17=null;
        Token otherlv_19=null;
        Token otherlv_21=null;
        AntlrDatatypeRuleToken lv_name_1_0 = null;

        AntlrDatatypeRuleToken lv_description_6_0 = null;

        Enumerator lv_operation_15_0 = null;



        	enterRule();

        try {
            // InternalMyDsl.g:642:2: ( (otherlv_0= 'GROUP_BY' ( (lv_name_1_0= ruleEString ) ) otherlv_2= '->' ( ( ruleEString ) ) otherlv_4= ':' (otherlv_5= 'description' ( (lv_description_6_0= ruleEString ) ) )? otherlv_7= 'ON' ( ( ruleEString ) ) otherlv_9= '(' ( ( ruleEString ) ) (otherlv_11= ',' ( ( ruleEString ) ) )* otherlv_13= ')' otherlv_14= 'AND' ( (lv_operation_15_0= ruleGroupOperationType ) ) ( ( ruleEString ) ) otherlv_17= 'INTO' ( ( ruleEString ) ) otherlv_19= '(' ( ( ruleEString ) ) otherlv_21= ')' ) )
            // InternalMyDsl.g:643:2: (otherlv_0= 'GROUP_BY' ( (lv_name_1_0= ruleEString ) ) otherlv_2= '->' ( ( ruleEString ) ) otherlv_4= ':' (otherlv_5= 'description' ( (lv_description_6_0= ruleEString ) ) )? otherlv_7= 'ON' ( ( ruleEString ) ) otherlv_9= '(' ( ( ruleEString ) ) (otherlv_11= ',' ( ( ruleEString ) ) )* otherlv_13= ')' otherlv_14= 'AND' ( (lv_operation_15_0= ruleGroupOperationType ) ) ( ( ruleEString ) ) otherlv_17= 'INTO' ( ( ruleEString ) ) otherlv_19= '(' ( ( ruleEString ) ) otherlv_21= ')' )
            {
            // InternalMyDsl.g:643:2: (otherlv_0= 'GROUP_BY' ( (lv_name_1_0= ruleEString ) ) otherlv_2= '->' ( ( ruleEString ) ) otherlv_4= ':' (otherlv_5= 'description' ( (lv_description_6_0= ruleEString ) ) )? otherlv_7= 'ON' ( ( ruleEString ) ) otherlv_9= '(' ( ( ruleEString ) ) (otherlv_11= ',' ( ( ruleEString ) ) )* otherlv_13= ')' otherlv_14= 'AND' ( (lv_operation_15_0= ruleGroupOperationType ) ) ( ( ruleEString ) ) otherlv_17= 'INTO' ( ( ruleEString ) ) otherlv_19= '(' ( ( ruleEString ) ) otherlv_21= ')' )
            // InternalMyDsl.g:644:3: otherlv_0= 'GROUP_BY' ( (lv_name_1_0= ruleEString ) ) otherlv_2= '->' ( ( ruleEString ) ) otherlv_4= ':' (otherlv_5= 'description' ( (lv_description_6_0= ruleEString ) ) )? otherlv_7= 'ON' ( ( ruleEString ) ) otherlv_9= '(' ( ( ruleEString ) ) (otherlv_11= ',' ( ( ruleEString ) ) )* otherlv_13= ')' otherlv_14= 'AND' ( (lv_operation_15_0= ruleGroupOperationType ) ) ( ( ruleEString ) ) otherlv_17= 'INTO' ( ( ruleEString ) ) otherlv_19= '(' ( ( ruleEString ) ) otherlv_21= ')'
            {
            otherlv_0=(Token)match(input,18,FOLLOW_6); 

            			newLeafNode(otherlv_0, grammarAccess.getGroupAccess().getGROUP_BYKeyword_0());
            		
            // InternalMyDsl.g:648:3: ( (lv_name_1_0= ruleEString ) )
            // InternalMyDsl.g:649:4: (lv_name_1_0= ruleEString )
            {
            // InternalMyDsl.g:649:4: (lv_name_1_0= ruleEString )
            // InternalMyDsl.g:650:5: lv_name_1_0= ruleEString
            {

            					newCompositeNode(grammarAccess.getGroupAccess().getNameEStringParserRuleCall_1_0());
            				
            pushFollow(FOLLOW_16);
            lv_name_1_0=ruleEString();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getGroupRule());
            					}
            					set(
            						current,
            						"name",
            						lv_name_1_0,
            						"org.xtext.example.mydsl.MyDsl.EString");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_2=(Token)match(input,19,FOLLOW_6); 

            			newLeafNode(otherlv_2, grammarAccess.getGroupAccess().getHyphenMinusGreaterThanSignKeyword_2());
            		
            // InternalMyDsl.g:671:3: ( ( ruleEString ) )
            // InternalMyDsl.g:672:4: ( ruleEString )
            {
            // InternalMyDsl.g:672:4: ( ruleEString )
            // InternalMyDsl.g:673:5: ruleEString
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getGroupRule());
            					}
            				

            					newCompositeNode(grammarAccess.getGroupAccess().getNextStepCrossReference_3_0());
            				
            pushFollow(FOLLOW_10);
            ruleEString();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_4=(Token)match(input,14,FOLLOW_17); 

            			newLeafNode(otherlv_4, grammarAccess.getGroupAccess().getColonKeyword_4());
            		
            // InternalMyDsl.g:691:3: (otherlv_5= 'description' ( (lv_description_6_0= ruleEString ) ) )?
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==17) ) {
                alt8=1;
            }
            switch (alt8) {
                case 1 :
                    // InternalMyDsl.g:692:4: otherlv_5= 'description' ( (lv_description_6_0= ruleEString ) )
                    {
                    otherlv_5=(Token)match(input,17,FOLLOW_6); 

                    				newLeafNode(otherlv_5, grammarAccess.getGroupAccess().getDescriptionKeyword_5_0());
                    			
                    // InternalMyDsl.g:696:4: ( (lv_description_6_0= ruleEString ) )
                    // InternalMyDsl.g:697:5: (lv_description_6_0= ruleEString )
                    {
                    // InternalMyDsl.g:697:5: (lv_description_6_0= ruleEString )
                    // InternalMyDsl.g:698:6: lv_description_6_0= ruleEString
                    {

                    						newCompositeNode(grammarAccess.getGroupAccess().getDescriptionEStringParserRuleCall_5_1_0());
                    					
                    pushFollow(FOLLOW_18);
                    lv_description_6_0=ruleEString();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getGroupRule());
                    						}
                    						set(
                    							current,
                    							"description",
                    							lv_description_6_0,
                    							"org.xtext.example.mydsl.MyDsl.EString");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;

            }

            otherlv_7=(Token)match(input,20,FOLLOW_6); 

            			newLeafNode(otherlv_7, grammarAccess.getGroupAccess().getONKeyword_6());
            		
            // InternalMyDsl.g:720:3: ( ( ruleEString ) )
            // InternalMyDsl.g:721:4: ( ruleEString )
            {
            // InternalMyDsl.g:721:4: ( ruleEString )
            // InternalMyDsl.g:722:5: ruleEString
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getGroupRule());
            					}
            				

            					newCompositeNode(grammarAccess.getGroupAccess().getTableTableCrossReference_7_0());
            				
            pushFollow(FOLLOW_19);
            ruleEString();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_9=(Token)match(input,21,FOLLOW_6); 

            			newLeafNode(otherlv_9, grammarAccess.getGroupAccess().getLeftParenthesisKeyword_8());
            		
            // InternalMyDsl.g:740:3: ( ( ruleEString ) )
            // InternalMyDsl.g:741:4: ( ruleEString )
            {
            // InternalMyDsl.g:741:4: ( ruleEString )
            // InternalMyDsl.g:742:5: ruleEString
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getGroupRule());
            					}
            				

            					newCompositeNode(grammarAccess.getGroupAccess().getGroupByColumnCrossReference_9_0());
            				
            pushFollow(FOLLOW_20);
            ruleEString();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalMyDsl.g:756:3: (otherlv_11= ',' ( ( ruleEString ) ) )*
            loop9:
            do {
                int alt9=2;
                int LA9_0 = input.LA(1);

                if ( (LA9_0==22) ) {
                    alt9=1;
                }


                switch (alt9) {
            	case 1 :
            	    // InternalMyDsl.g:757:4: otherlv_11= ',' ( ( ruleEString ) )
            	    {
            	    otherlv_11=(Token)match(input,22,FOLLOW_6); 

            	    				newLeafNode(otherlv_11, grammarAccess.getGroupAccess().getCommaKeyword_10_0());
            	    			
            	    // InternalMyDsl.g:761:4: ( ( ruleEString ) )
            	    // InternalMyDsl.g:762:5: ( ruleEString )
            	    {
            	    // InternalMyDsl.g:762:5: ( ruleEString )
            	    // InternalMyDsl.g:763:6: ruleEString
            	    {

            	    						if (current==null) {
            	    							current = createModelElement(grammarAccess.getGroupRule());
            	    						}
            	    					

            	    						newCompositeNode(grammarAccess.getGroupAccess().getGroupByColumnCrossReference_10_1_0());
            	    					
            	    pushFollow(FOLLOW_20);
            	    ruleEString();

            	    state._fsp--;


            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop9;
                }
            } while (true);

            otherlv_13=(Token)match(input,23,FOLLOW_21); 

            			newLeafNode(otherlv_13, grammarAccess.getGroupAccess().getRightParenthesisKeyword_11());
            		
            otherlv_14=(Token)match(input,24,FOLLOW_22); 

            			newLeafNode(otherlv_14, grammarAccess.getGroupAccess().getANDKeyword_12());
            		
            // InternalMyDsl.g:786:3: ( (lv_operation_15_0= ruleGroupOperationType ) )
            // InternalMyDsl.g:787:4: (lv_operation_15_0= ruleGroupOperationType )
            {
            // InternalMyDsl.g:787:4: (lv_operation_15_0= ruleGroupOperationType )
            // InternalMyDsl.g:788:5: lv_operation_15_0= ruleGroupOperationType
            {

            					newCompositeNode(grammarAccess.getGroupAccess().getOperationGroupOperationTypeEnumRuleCall_13_0());
            				
            pushFollow(FOLLOW_6);
            lv_operation_15_0=ruleGroupOperationType();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getGroupRule());
            					}
            					set(
            						current,
            						"operation",
            						lv_operation_15_0,
            						"org.xtext.example.mydsl.MyDsl.GroupOperationType");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalMyDsl.g:805:3: ( ( ruleEString ) )
            // InternalMyDsl.g:806:4: ( ruleEString )
            {
            // InternalMyDsl.g:806:4: ( ruleEString )
            // InternalMyDsl.g:807:5: ruleEString
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getGroupRule());
            					}
            				

            					newCompositeNode(grammarAccess.getGroupAccess().getOperandColumnColumnCrossReference_14_0());
            				
            pushFollow(FOLLOW_23);
            ruleEString();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_17=(Token)match(input,25,FOLLOW_6); 

            			newLeafNode(otherlv_17, grammarAccess.getGroupAccess().getINTOKeyword_15());
            		
            // InternalMyDsl.g:825:3: ( ( ruleEString ) )
            // InternalMyDsl.g:826:4: ( ruleEString )
            {
            // InternalMyDsl.g:826:4: ( ruleEString )
            // InternalMyDsl.g:827:5: ruleEString
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getGroupRule());
            					}
            				

            					newCompositeNode(grammarAccess.getGroupAccess().getResultTableTableCrossReference_16_0());
            				
            pushFollow(FOLLOW_19);
            ruleEString();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_19=(Token)match(input,21,FOLLOW_6); 

            			newLeafNode(otherlv_19, grammarAccess.getGroupAccess().getLeftParenthesisKeyword_17());
            		
            // InternalMyDsl.g:845:3: ( ( ruleEString ) )
            // InternalMyDsl.g:846:4: ( ruleEString )
            {
            // InternalMyDsl.g:846:4: ( ruleEString )
            // InternalMyDsl.g:847:5: ruleEString
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getGroupRule());
            					}
            				

            					newCompositeNode(grammarAccess.getGroupAccess().getResultColumnColumnCrossReference_18_0());
            				
            pushFollow(FOLLOW_24);
            ruleEString();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_21=(Token)match(input,23,FOLLOW_2); 

            			newLeafNode(otherlv_21, grammarAccess.getGroupAccess().getRightParenthesisKeyword_19());
            		

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
    // $ANTLR end "ruleGroup"


    // $ANTLR start "entryRuleSort"
    // InternalMyDsl.g:869:1: entryRuleSort returns [EObject current=null] : iv_ruleSort= ruleSort EOF ;
    public final EObject entryRuleSort() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSort = null;


        try {
            // InternalMyDsl.g:869:45: (iv_ruleSort= ruleSort EOF )
            // InternalMyDsl.g:870:2: iv_ruleSort= ruleSort EOF
            {
             newCompositeNode(grammarAccess.getSortRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleSort=ruleSort();

            state._fsp--;

             current =iv_ruleSort; 
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
    // $ANTLR end "entryRuleSort"


    // $ANTLR start "ruleSort"
    // InternalMyDsl.g:876:1: ruleSort returns [EObject current=null] : (otherlv_0= 'SORT' ( (lv_name_1_0= ruleEString ) ) otherlv_2= '->' ( ( ruleEString ) ) otherlv_4= ':' (otherlv_5= 'description' ( (lv_description_6_0= ruleEString ) ) )? otherlv_7= 'ON' ( ( ruleEString ) ) otherlv_9= '(' ( ( ruleEString ) ) otherlv_11= ')' otherlv_12= 'BY' otherlv_13= 'ORDER' ( (lv_order_14_0= ruleOrderType ) ) ) ;
    public final EObject ruleSort() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        Token otherlv_9=null;
        Token otherlv_11=null;
        Token otherlv_12=null;
        Token otherlv_13=null;
        AntlrDatatypeRuleToken lv_name_1_0 = null;

        AntlrDatatypeRuleToken lv_description_6_0 = null;

        Enumerator lv_order_14_0 = null;



        	enterRule();

        try {
            // InternalMyDsl.g:882:2: ( (otherlv_0= 'SORT' ( (lv_name_1_0= ruleEString ) ) otherlv_2= '->' ( ( ruleEString ) ) otherlv_4= ':' (otherlv_5= 'description' ( (lv_description_6_0= ruleEString ) ) )? otherlv_7= 'ON' ( ( ruleEString ) ) otherlv_9= '(' ( ( ruleEString ) ) otherlv_11= ')' otherlv_12= 'BY' otherlv_13= 'ORDER' ( (lv_order_14_0= ruleOrderType ) ) ) )
            // InternalMyDsl.g:883:2: (otherlv_0= 'SORT' ( (lv_name_1_0= ruleEString ) ) otherlv_2= '->' ( ( ruleEString ) ) otherlv_4= ':' (otherlv_5= 'description' ( (lv_description_6_0= ruleEString ) ) )? otherlv_7= 'ON' ( ( ruleEString ) ) otherlv_9= '(' ( ( ruleEString ) ) otherlv_11= ')' otherlv_12= 'BY' otherlv_13= 'ORDER' ( (lv_order_14_0= ruleOrderType ) ) )
            {
            // InternalMyDsl.g:883:2: (otherlv_0= 'SORT' ( (lv_name_1_0= ruleEString ) ) otherlv_2= '->' ( ( ruleEString ) ) otherlv_4= ':' (otherlv_5= 'description' ( (lv_description_6_0= ruleEString ) ) )? otherlv_7= 'ON' ( ( ruleEString ) ) otherlv_9= '(' ( ( ruleEString ) ) otherlv_11= ')' otherlv_12= 'BY' otherlv_13= 'ORDER' ( (lv_order_14_0= ruleOrderType ) ) )
            // InternalMyDsl.g:884:3: otherlv_0= 'SORT' ( (lv_name_1_0= ruleEString ) ) otherlv_2= '->' ( ( ruleEString ) ) otherlv_4= ':' (otherlv_5= 'description' ( (lv_description_6_0= ruleEString ) ) )? otherlv_7= 'ON' ( ( ruleEString ) ) otherlv_9= '(' ( ( ruleEString ) ) otherlv_11= ')' otherlv_12= 'BY' otherlv_13= 'ORDER' ( (lv_order_14_0= ruleOrderType ) )
            {
            otherlv_0=(Token)match(input,26,FOLLOW_6); 

            			newLeafNode(otherlv_0, grammarAccess.getSortAccess().getSORTKeyword_0());
            		
            // InternalMyDsl.g:888:3: ( (lv_name_1_0= ruleEString ) )
            // InternalMyDsl.g:889:4: (lv_name_1_0= ruleEString )
            {
            // InternalMyDsl.g:889:4: (lv_name_1_0= ruleEString )
            // InternalMyDsl.g:890:5: lv_name_1_0= ruleEString
            {

            					newCompositeNode(grammarAccess.getSortAccess().getNameEStringParserRuleCall_1_0());
            				
            pushFollow(FOLLOW_16);
            lv_name_1_0=ruleEString();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getSortRule());
            					}
            					set(
            						current,
            						"name",
            						lv_name_1_0,
            						"org.xtext.example.mydsl.MyDsl.EString");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_2=(Token)match(input,19,FOLLOW_6); 

            			newLeafNode(otherlv_2, grammarAccess.getSortAccess().getHyphenMinusGreaterThanSignKeyword_2());
            		
            // InternalMyDsl.g:911:3: ( ( ruleEString ) )
            // InternalMyDsl.g:912:4: ( ruleEString )
            {
            // InternalMyDsl.g:912:4: ( ruleEString )
            // InternalMyDsl.g:913:5: ruleEString
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getSortRule());
            					}
            				

            					newCompositeNode(grammarAccess.getSortAccess().getNextStepCrossReference_3_0());
            				
            pushFollow(FOLLOW_10);
            ruleEString();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_4=(Token)match(input,14,FOLLOW_17); 

            			newLeafNode(otherlv_4, grammarAccess.getSortAccess().getColonKeyword_4());
            		
            // InternalMyDsl.g:931:3: (otherlv_5= 'description' ( (lv_description_6_0= ruleEString ) ) )?
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==17) ) {
                alt10=1;
            }
            switch (alt10) {
                case 1 :
                    // InternalMyDsl.g:932:4: otherlv_5= 'description' ( (lv_description_6_0= ruleEString ) )
                    {
                    otherlv_5=(Token)match(input,17,FOLLOW_6); 

                    				newLeafNode(otherlv_5, grammarAccess.getSortAccess().getDescriptionKeyword_5_0());
                    			
                    // InternalMyDsl.g:936:4: ( (lv_description_6_0= ruleEString ) )
                    // InternalMyDsl.g:937:5: (lv_description_6_0= ruleEString )
                    {
                    // InternalMyDsl.g:937:5: (lv_description_6_0= ruleEString )
                    // InternalMyDsl.g:938:6: lv_description_6_0= ruleEString
                    {

                    						newCompositeNode(grammarAccess.getSortAccess().getDescriptionEStringParserRuleCall_5_1_0());
                    					
                    pushFollow(FOLLOW_18);
                    lv_description_6_0=ruleEString();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getSortRule());
                    						}
                    						set(
                    							current,
                    							"description",
                    							lv_description_6_0,
                    							"org.xtext.example.mydsl.MyDsl.EString");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;

            }

            otherlv_7=(Token)match(input,20,FOLLOW_6); 

            			newLeafNode(otherlv_7, grammarAccess.getSortAccess().getONKeyword_6());
            		
            // InternalMyDsl.g:960:3: ( ( ruleEString ) )
            // InternalMyDsl.g:961:4: ( ruleEString )
            {
            // InternalMyDsl.g:961:4: ( ruleEString )
            // InternalMyDsl.g:962:5: ruleEString
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getSortRule());
            					}
            				

            					newCompositeNode(grammarAccess.getSortAccess().getTableTableCrossReference_7_0());
            				
            pushFollow(FOLLOW_19);
            ruleEString();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_9=(Token)match(input,21,FOLLOW_6); 

            			newLeafNode(otherlv_9, grammarAccess.getSortAccess().getLeftParenthesisKeyword_8());
            		
            // InternalMyDsl.g:980:3: ( ( ruleEString ) )
            // InternalMyDsl.g:981:4: ( ruleEString )
            {
            // InternalMyDsl.g:981:4: ( ruleEString )
            // InternalMyDsl.g:982:5: ruleEString
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getSortRule());
            					}
            				

            					newCompositeNode(grammarAccess.getSortAccess().getColumnColumnCrossReference_9_0());
            				
            pushFollow(FOLLOW_24);
            ruleEString();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_11=(Token)match(input,23,FOLLOW_25); 

            			newLeafNode(otherlv_11, grammarAccess.getSortAccess().getRightParenthesisKeyword_10());
            		
            otherlv_12=(Token)match(input,27,FOLLOW_26); 

            			newLeafNode(otherlv_12, grammarAccess.getSortAccess().getBYKeyword_11());
            		
            otherlv_13=(Token)match(input,28,FOLLOW_27); 

            			newLeafNode(otherlv_13, grammarAccess.getSortAccess().getORDERKeyword_12());
            		
            // InternalMyDsl.g:1008:3: ( (lv_order_14_0= ruleOrderType ) )
            // InternalMyDsl.g:1009:4: (lv_order_14_0= ruleOrderType )
            {
            // InternalMyDsl.g:1009:4: (lv_order_14_0= ruleOrderType )
            // InternalMyDsl.g:1010:5: lv_order_14_0= ruleOrderType
            {

            					newCompositeNode(grammarAccess.getSortAccess().getOrderOrderTypeEnumRuleCall_13_0());
            				
            pushFollow(FOLLOW_2);
            lv_order_14_0=ruleOrderType();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getSortRule());
            					}
            					set(
            						current,
            						"order",
            						lv_order_14_0,
            						"org.xtext.example.mydsl.MyDsl.OrderType");
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
    // $ANTLR end "ruleSort"


    // $ANTLR start "entryRuleAppendRows"
    // InternalMyDsl.g:1031:1: entryRuleAppendRows returns [EObject current=null] : iv_ruleAppendRows= ruleAppendRows EOF ;
    public final EObject entryRuleAppendRows() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAppendRows = null;


        try {
            // InternalMyDsl.g:1031:51: (iv_ruleAppendRows= ruleAppendRows EOF )
            // InternalMyDsl.g:1032:2: iv_ruleAppendRows= ruleAppendRows EOF
            {
             newCompositeNode(grammarAccess.getAppendRowsRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleAppendRows=ruleAppendRows();

            state._fsp--;

             current =iv_ruleAppendRows; 
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
    // $ANTLR end "entryRuleAppendRows"


    // $ANTLR start "ruleAppendRows"
    // InternalMyDsl.g:1038:1: ruleAppendRows returns [EObject current=null] : (otherlv_0= 'APPEND_ROWS' ( (lv_name_1_0= ruleEString ) ) otherlv_2= '->' ( ( ruleEString ) ) otherlv_4= ':' (otherlv_5= 'description' ( (lv_description_6_0= ruleEString ) ) )? otherlv_7= 'FROM' ( ( ruleEString ) ) otherlv_9= 'TO' ( ( ruleEString ) ) otherlv_11= 'MAPPING' otherlv_12= ':' ( (lv_associations_13_0= ruleAssociation ) ) ( (lv_associations_14_0= ruleAssociation ) )* ) ;
    public final EObject ruleAppendRows() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        Token otherlv_9=null;
        Token otherlv_11=null;
        Token otherlv_12=null;
        AntlrDatatypeRuleToken lv_name_1_0 = null;

        AntlrDatatypeRuleToken lv_description_6_0 = null;

        EObject lv_associations_13_0 = null;

        EObject lv_associations_14_0 = null;



        	enterRule();

        try {
            // InternalMyDsl.g:1044:2: ( (otherlv_0= 'APPEND_ROWS' ( (lv_name_1_0= ruleEString ) ) otherlv_2= '->' ( ( ruleEString ) ) otherlv_4= ':' (otherlv_5= 'description' ( (lv_description_6_0= ruleEString ) ) )? otherlv_7= 'FROM' ( ( ruleEString ) ) otherlv_9= 'TO' ( ( ruleEString ) ) otherlv_11= 'MAPPING' otherlv_12= ':' ( (lv_associations_13_0= ruleAssociation ) ) ( (lv_associations_14_0= ruleAssociation ) )* ) )
            // InternalMyDsl.g:1045:2: (otherlv_0= 'APPEND_ROWS' ( (lv_name_1_0= ruleEString ) ) otherlv_2= '->' ( ( ruleEString ) ) otherlv_4= ':' (otherlv_5= 'description' ( (lv_description_6_0= ruleEString ) ) )? otherlv_7= 'FROM' ( ( ruleEString ) ) otherlv_9= 'TO' ( ( ruleEString ) ) otherlv_11= 'MAPPING' otherlv_12= ':' ( (lv_associations_13_0= ruleAssociation ) ) ( (lv_associations_14_0= ruleAssociation ) )* )
            {
            // InternalMyDsl.g:1045:2: (otherlv_0= 'APPEND_ROWS' ( (lv_name_1_0= ruleEString ) ) otherlv_2= '->' ( ( ruleEString ) ) otherlv_4= ':' (otherlv_5= 'description' ( (lv_description_6_0= ruleEString ) ) )? otherlv_7= 'FROM' ( ( ruleEString ) ) otherlv_9= 'TO' ( ( ruleEString ) ) otherlv_11= 'MAPPING' otherlv_12= ':' ( (lv_associations_13_0= ruleAssociation ) ) ( (lv_associations_14_0= ruleAssociation ) )* )
            // InternalMyDsl.g:1046:3: otherlv_0= 'APPEND_ROWS' ( (lv_name_1_0= ruleEString ) ) otherlv_2= '->' ( ( ruleEString ) ) otherlv_4= ':' (otherlv_5= 'description' ( (lv_description_6_0= ruleEString ) ) )? otherlv_7= 'FROM' ( ( ruleEString ) ) otherlv_9= 'TO' ( ( ruleEString ) ) otherlv_11= 'MAPPING' otherlv_12= ':' ( (lv_associations_13_0= ruleAssociation ) ) ( (lv_associations_14_0= ruleAssociation ) )*
            {
            otherlv_0=(Token)match(input,29,FOLLOW_6); 

            			newLeafNode(otherlv_0, grammarAccess.getAppendRowsAccess().getAPPEND_ROWSKeyword_0());
            		
            // InternalMyDsl.g:1050:3: ( (lv_name_1_0= ruleEString ) )
            // InternalMyDsl.g:1051:4: (lv_name_1_0= ruleEString )
            {
            // InternalMyDsl.g:1051:4: (lv_name_1_0= ruleEString )
            // InternalMyDsl.g:1052:5: lv_name_1_0= ruleEString
            {

            					newCompositeNode(grammarAccess.getAppendRowsAccess().getNameEStringParserRuleCall_1_0());
            				
            pushFollow(FOLLOW_16);
            lv_name_1_0=ruleEString();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getAppendRowsRule());
            					}
            					set(
            						current,
            						"name",
            						lv_name_1_0,
            						"org.xtext.example.mydsl.MyDsl.EString");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_2=(Token)match(input,19,FOLLOW_6); 

            			newLeafNode(otherlv_2, grammarAccess.getAppendRowsAccess().getHyphenMinusGreaterThanSignKeyword_2());
            		
            // InternalMyDsl.g:1073:3: ( ( ruleEString ) )
            // InternalMyDsl.g:1074:4: ( ruleEString )
            {
            // InternalMyDsl.g:1074:4: ( ruleEString )
            // InternalMyDsl.g:1075:5: ruleEString
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getAppendRowsRule());
            					}
            				

            					newCompositeNode(grammarAccess.getAppendRowsAccess().getNextStepCrossReference_3_0());
            				
            pushFollow(FOLLOW_10);
            ruleEString();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_4=(Token)match(input,14,FOLLOW_28); 

            			newLeafNode(otherlv_4, grammarAccess.getAppendRowsAccess().getColonKeyword_4());
            		
            // InternalMyDsl.g:1093:3: (otherlv_5= 'description' ( (lv_description_6_0= ruleEString ) ) )?
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0==17) ) {
                alt11=1;
            }
            switch (alt11) {
                case 1 :
                    // InternalMyDsl.g:1094:4: otherlv_5= 'description' ( (lv_description_6_0= ruleEString ) )
                    {
                    otherlv_5=(Token)match(input,17,FOLLOW_6); 

                    				newLeafNode(otherlv_5, grammarAccess.getAppendRowsAccess().getDescriptionKeyword_5_0());
                    			
                    // InternalMyDsl.g:1098:4: ( (lv_description_6_0= ruleEString ) )
                    // InternalMyDsl.g:1099:5: (lv_description_6_0= ruleEString )
                    {
                    // InternalMyDsl.g:1099:5: (lv_description_6_0= ruleEString )
                    // InternalMyDsl.g:1100:6: lv_description_6_0= ruleEString
                    {

                    						newCompositeNode(grammarAccess.getAppendRowsAccess().getDescriptionEStringParserRuleCall_5_1_0());
                    					
                    pushFollow(FOLLOW_29);
                    lv_description_6_0=ruleEString();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getAppendRowsRule());
                    						}
                    						set(
                    							current,
                    							"description",
                    							lv_description_6_0,
                    							"org.xtext.example.mydsl.MyDsl.EString");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;

            }

            otherlv_7=(Token)match(input,30,FOLLOW_6); 

            			newLeafNode(otherlv_7, grammarAccess.getAppendRowsAccess().getFROMKeyword_6());
            		
            // InternalMyDsl.g:1122:3: ( ( ruleEString ) )
            // InternalMyDsl.g:1123:4: ( ruleEString )
            {
            // InternalMyDsl.g:1123:4: ( ruleEString )
            // InternalMyDsl.g:1124:5: ruleEString
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getAppendRowsRule());
            					}
            				

            					newCompositeNode(grammarAccess.getAppendRowsAccess().getOriginTableTableCrossReference_7_0());
            				
            pushFollow(FOLLOW_30);
            ruleEString();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_9=(Token)match(input,31,FOLLOW_6); 

            			newLeafNode(otherlv_9, grammarAccess.getAppendRowsAccess().getTOKeyword_8());
            		
            // InternalMyDsl.g:1142:3: ( ( ruleEString ) )
            // InternalMyDsl.g:1143:4: ( ruleEString )
            {
            // InternalMyDsl.g:1143:4: ( ruleEString )
            // InternalMyDsl.g:1144:5: ruleEString
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getAppendRowsRule());
            					}
            				

            					newCompositeNode(grammarAccess.getAppendRowsAccess().getDestinTableTableCrossReference_9_0());
            				
            pushFollow(FOLLOW_31);
            ruleEString();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_11=(Token)match(input,32,FOLLOW_10); 

            			newLeafNode(otherlv_11, grammarAccess.getAppendRowsAccess().getMAPPINGKeyword_10());
            		
            otherlv_12=(Token)match(input,14,FOLLOW_6); 

            			newLeafNode(otherlv_12, grammarAccess.getAppendRowsAccess().getColonKeyword_11());
            		
            // InternalMyDsl.g:1166:3: ( (lv_associations_13_0= ruleAssociation ) )
            // InternalMyDsl.g:1167:4: (lv_associations_13_0= ruleAssociation )
            {
            // InternalMyDsl.g:1167:4: (lv_associations_13_0= ruleAssociation )
            // InternalMyDsl.g:1168:5: lv_associations_13_0= ruleAssociation
            {

            					newCompositeNode(grammarAccess.getAppendRowsAccess().getAssociationsAssociationParserRuleCall_12_0());
            				
            pushFollow(FOLLOW_11);
            lv_associations_13_0=ruleAssociation();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getAppendRowsRule());
            					}
            					add(
            						current,
            						"associations",
            						lv_associations_13_0,
            						"org.xtext.example.mydsl.MyDsl.Association");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalMyDsl.g:1185:3: ( (lv_associations_14_0= ruleAssociation ) )*
            loop12:
            do {
                int alt12=2;
                int LA12_0 = input.LA(1);

                if ( ((LA12_0>=RULE_STRING && LA12_0<=RULE_ID)) ) {
                    alt12=1;
                }


                switch (alt12) {
            	case 1 :
            	    // InternalMyDsl.g:1186:4: (lv_associations_14_0= ruleAssociation )
            	    {
            	    // InternalMyDsl.g:1186:4: (lv_associations_14_0= ruleAssociation )
            	    // InternalMyDsl.g:1187:5: lv_associations_14_0= ruleAssociation
            	    {

            	    					newCompositeNode(grammarAccess.getAppendRowsAccess().getAssociationsAssociationParserRuleCall_13_0());
            	    				
            	    pushFollow(FOLLOW_11);
            	    lv_associations_14_0=ruleAssociation();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getAppendRowsRule());
            	    					}
            	    					add(
            	    						current,
            	    						"associations",
            	    						lv_associations_14_0,
            	    						"org.xtext.example.mydsl.MyDsl.Association");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop12;
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
    // $ANTLR end "ruleAppendRows"


    // $ANTLR start "entryRuleFilter"
    // InternalMyDsl.g:1208:1: entryRuleFilter returns [EObject current=null] : iv_ruleFilter= ruleFilter EOF ;
    public final EObject entryRuleFilter() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFilter = null;


        try {
            // InternalMyDsl.g:1208:47: (iv_ruleFilter= ruleFilter EOF )
            // InternalMyDsl.g:1209:2: iv_ruleFilter= ruleFilter EOF
            {
             newCompositeNode(grammarAccess.getFilterRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleFilter=ruleFilter();

            state._fsp--;

             current =iv_ruleFilter; 
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
    // $ANTLR end "entryRuleFilter"


    // $ANTLR start "ruleFilter"
    // InternalMyDsl.g:1215:1: ruleFilter returns [EObject current=null] : (otherlv_0= 'FILTER' ( (lv_name_1_0= ruleEString ) ) otherlv_2= '->' ( ( ruleEString ) ) otherlv_4= ':' (otherlv_5= 'description' ( (lv_description_6_0= ruleEString ) ) )? otherlv_7= 'ON' ( ( ruleEString ) ) otherlv_9= '(' ( ( ruleEString ) ) otherlv_11= ')' otherlv_12= 'WHERE' otherlv_13= 'VALUES' otherlv_14= 'ARE' ( (lv_operator_15_0= ruleFilterOperatorType ) ) ( (lv_operand_16_0= ruleEString ) ) ) ;
    public final EObject ruleFilter() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        Token otherlv_9=null;
        Token otherlv_11=null;
        Token otherlv_12=null;
        Token otherlv_13=null;
        Token otherlv_14=null;
        AntlrDatatypeRuleToken lv_name_1_0 = null;

        AntlrDatatypeRuleToken lv_description_6_0 = null;

        Enumerator lv_operator_15_0 = null;

        AntlrDatatypeRuleToken lv_operand_16_0 = null;



        	enterRule();

        try {
            // InternalMyDsl.g:1221:2: ( (otherlv_0= 'FILTER' ( (lv_name_1_0= ruleEString ) ) otherlv_2= '->' ( ( ruleEString ) ) otherlv_4= ':' (otherlv_5= 'description' ( (lv_description_6_0= ruleEString ) ) )? otherlv_7= 'ON' ( ( ruleEString ) ) otherlv_9= '(' ( ( ruleEString ) ) otherlv_11= ')' otherlv_12= 'WHERE' otherlv_13= 'VALUES' otherlv_14= 'ARE' ( (lv_operator_15_0= ruleFilterOperatorType ) ) ( (lv_operand_16_0= ruleEString ) ) ) )
            // InternalMyDsl.g:1222:2: (otherlv_0= 'FILTER' ( (lv_name_1_0= ruleEString ) ) otherlv_2= '->' ( ( ruleEString ) ) otherlv_4= ':' (otherlv_5= 'description' ( (lv_description_6_0= ruleEString ) ) )? otherlv_7= 'ON' ( ( ruleEString ) ) otherlv_9= '(' ( ( ruleEString ) ) otherlv_11= ')' otherlv_12= 'WHERE' otherlv_13= 'VALUES' otherlv_14= 'ARE' ( (lv_operator_15_0= ruleFilterOperatorType ) ) ( (lv_operand_16_0= ruleEString ) ) )
            {
            // InternalMyDsl.g:1222:2: (otherlv_0= 'FILTER' ( (lv_name_1_0= ruleEString ) ) otherlv_2= '->' ( ( ruleEString ) ) otherlv_4= ':' (otherlv_5= 'description' ( (lv_description_6_0= ruleEString ) ) )? otherlv_7= 'ON' ( ( ruleEString ) ) otherlv_9= '(' ( ( ruleEString ) ) otherlv_11= ')' otherlv_12= 'WHERE' otherlv_13= 'VALUES' otherlv_14= 'ARE' ( (lv_operator_15_0= ruleFilterOperatorType ) ) ( (lv_operand_16_0= ruleEString ) ) )
            // InternalMyDsl.g:1223:3: otherlv_0= 'FILTER' ( (lv_name_1_0= ruleEString ) ) otherlv_2= '->' ( ( ruleEString ) ) otherlv_4= ':' (otherlv_5= 'description' ( (lv_description_6_0= ruleEString ) ) )? otherlv_7= 'ON' ( ( ruleEString ) ) otherlv_9= '(' ( ( ruleEString ) ) otherlv_11= ')' otherlv_12= 'WHERE' otherlv_13= 'VALUES' otherlv_14= 'ARE' ( (lv_operator_15_0= ruleFilterOperatorType ) ) ( (lv_operand_16_0= ruleEString ) )
            {
            otherlv_0=(Token)match(input,33,FOLLOW_6); 

            			newLeafNode(otherlv_0, grammarAccess.getFilterAccess().getFILTERKeyword_0());
            		
            // InternalMyDsl.g:1227:3: ( (lv_name_1_0= ruleEString ) )
            // InternalMyDsl.g:1228:4: (lv_name_1_0= ruleEString )
            {
            // InternalMyDsl.g:1228:4: (lv_name_1_0= ruleEString )
            // InternalMyDsl.g:1229:5: lv_name_1_0= ruleEString
            {

            					newCompositeNode(grammarAccess.getFilterAccess().getNameEStringParserRuleCall_1_0());
            				
            pushFollow(FOLLOW_16);
            lv_name_1_0=ruleEString();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getFilterRule());
            					}
            					set(
            						current,
            						"name",
            						lv_name_1_0,
            						"org.xtext.example.mydsl.MyDsl.EString");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_2=(Token)match(input,19,FOLLOW_6); 

            			newLeafNode(otherlv_2, grammarAccess.getFilterAccess().getHyphenMinusGreaterThanSignKeyword_2());
            		
            // InternalMyDsl.g:1250:3: ( ( ruleEString ) )
            // InternalMyDsl.g:1251:4: ( ruleEString )
            {
            // InternalMyDsl.g:1251:4: ( ruleEString )
            // InternalMyDsl.g:1252:5: ruleEString
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getFilterRule());
            					}
            				

            					newCompositeNode(grammarAccess.getFilterAccess().getNextStepCrossReference_3_0());
            				
            pushFollow(FOLLOW_10);
            ruleEString();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_4=(Token)match(input,14,FOLLOW_17); 

            			newLeafNode(otherlv_4, grammarAccess.getFilterAccess().getColonKeyword_4());
            		
            // InternalMyDsl.g:1270:3: (otherlv_5= 'description' ( (lv_description_6_0= ruleEString ) ) )?
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( (LA13_0==17) ) {
                alt13=1;
            }
            switch (alt13) {
                case 1 :
                    // InternalMyDsl.g:1271:4: otherlv_5= 'description' ( (lv_description_6_0= ruleEString ) )
                    {
                    otherlv_5=(Token)match(input,17,FOLLOW_6); 

                    				newLeafNode(otherlv_5, grammarAccess.getFilterAccess().getDescriptionKeyword_5_0());
                    			
                    // InternalMyDsl.g:1275:4: ( (lv_description_6_0= ruleEString ) )
                    // InternalMyDsl.g:1276:5: (lv_description_6_0= ruleEString )
                    {
                    // InternalMyDsl.g:1276:5: (lv_description_6_0= ruleEString )
                    // InternalMyDsl.g:1277:6: lv_description_6_0= ruleEString
                    {

                    						newCompositeNode(grammarAccess.getFilterAccess().getDescriptionEStringParserRuleCall_5_1_0());
                    					
                    pushFollow(FOLLOW_18);
                    lv_description_6_0=ruleEString();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getFilterRule());
                    						}
                    						set(
                    							current,
                    							"description",
                    							lv_description_6_0,
                    							"org.xtext.example.mydsl.MyDsl.EString");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;

            }

            otherlv_7=(Token)match(input,20,FOLLOW_6); 

            			newLeafNode(otherlv_7, grammarAccess.getFilterAccess().getONKeyword_6());
            		
            // InternalMyDsl.g:1299:3: ( ( ruleEString ) )
            // InternalMyDsl.g:1300:4: ( ruleEString )
            {
            // InternalMyDsl.g:1300:4: ( ruleEString )
            // InternalMyDsl.g:1301:5: ruleEString
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getFilterRule());
            					}
            				

            					newCompositeNode(grammarAccess.getFilterAccess().getTableTableCrossReference_7_0());
            				
            pushFollow(FOLLOW_19);
            ruleEString();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_9=(Token)match(input,21,FOLLOW_6); 

            			newLeafNode(otherlv_9, grammarAccess.getFilterAccess().getLeftParenthesisKeyword_8());
            		
            // InternalMyDsl.g:1319:3: ( ( ruleEString ) )
            // InternalMyDsl.g:1320:4: ( ruleEString )
            {
            // InternalMyDsl.g:1320:4: ( ruleEString )
            // InternalMyDsl.g:1321:5: ruleEString
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getFilterRule());
            					}
            				

            					newCompositeNode(grammarAccess.getFilterAccess().getColumnColumnCrossReference_9_0());
            				
            pushFollow(FOLLOW_24);
            ruleEString();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_11=(Token)match(input,23,FOLLOW_32); 

            			newLeafNode(otherlv_11, grammarAccess.getFilterAccess().getRightParenthesisKeyword_10());
            		
            otherlv_12=(Token)match(input,34,FOLLOW_33); 

            			newLeafNode(otherlv_12, grammarAccess.getFilterAccess().getWHEREKeyword_11());
            		
            otherlv_13=(Token)match(input,35,FOLLOW_34); 

            			newLeafNode(otherlv_13, grammarAccess.getFilterAccess().getVALUESKeyword_12());
            		
            otherlv_14=(Token)match(input,36,FOLLOW_35); 

            			newLeafNode(otherlv_14, grammarAccess.getFilterAccess().getAREKeyword_13());
            		
            // InternalMyDsl.g:1351:3: ( (lv_operator_15_0= ruleFilterOperatorType ) )
            // InternalMyDsl.g:1352:4: (lv_operator_15_0= ruleFilterOperatorType )
            {
            // InternalMyDsl.g:1352:4: (lv_operator_15_0= ruleFilterOperatorType )
            // InternalMyDsl.g:1353:5: lv_operator_15_0= ruleFilterOperatorType
            {

            					newCompositeNode(grammarAccess.getFilterAccess().getOperatorFilterOperatorTypeEnumRuleCall_14_0());
            				
            pushFollow(FOLLOW_6);
            lv_operator_15_0=ruleFilterOperatorType();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getFilterRule());
            					}
            					set(
            						current,
            						"operator",
            						lv_operator_15_0,
            						"org.xtext.example.mydsl.MyDsl.FilterOperatorType");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalMyDsl.g:1370:3: ( (lv_operand_16_0= ruleEString ) )
            // InternalMyDsl.g:1371:4: (lv_operand_16_0= ruleEString )
            {
            // InternalMyDsl.g:1371:4: (lv_operand_16_0= ruleEString )
            // InternalMyDsl.g:1372:5: lv_operand_16_0= ruleEString
            {

            					newCompositeNode(grammarAccess.getFilterAccess().getOperandEStringParserRuleCall_15_0());
            				
            pushFollow(FOLLOW_2);
            lv_operand_16_0=ruleEString();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getFilterRule());
            					}
            					set(
            						current,
            						"operand",
            						lv_operand_16_0,
            						"org.xtext.example.mydsl.MyDsl.EString");
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
    // $ANTLR end "ruleFilter"


    // $ANTLR start "entryRuleGenericStep"
    // InternalMyDsl.g:1393:1: entryRuleGenericStep returns [EObject current=null] : iv_ruleGenericStep= ruleGenericStep EOF ;
    public final EObject entryRuleGenericStep() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleGenericStep = null;


        try {
            // InternalMyDsl.g:1393:52: (iv_ruleGenericStep= ruleGenericStep EOF )
            // InternalMyDsl.g:1394:2: iv_ruleGenericStep= ruleGenericStep EOF
            {
             newCompositeNode(grammarAccess.getGenericStepRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleGenericStep=ruleGenericStep();

            state._fsp--;

             current =iv_ruleGenericStep; 
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
    // $ANTLR end "entryRuleGenericStep"


    // $ANTLR start "ruleGenericStep"
    // InternalMyDsl.g:1400:1: ruleGenericStep returns [EObject current=null] : (otherlv_0= 'GenericStep' ( (lv_name_1_0= ruleEString ) ) otherlv_2= '{' (otherlv_3= 'description' ( (lv_description_4_0= ruleEString ) ) )? otherlv_5= 'next' ( ( ruleEString ) ) otherlv_7= '}' ) ;
    public final EObject ruleGenericStep() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        AntlrDatatypeRuleToken lv_name_1_0 = null;

        AntlrDatatypeRuleToken lv_description_4_0 = null;



        	enterRule();

        try {
            // InternalMyDsl.g:1406:2: ( (otherlv_0= 'GenericStep' ( (lv_name_1_0= ruleEString ) ) otherlv_2= '{' (otherlv_3= 'description' ( (lv_description_4_0= ruleEString ) ) )? otherlv_5= 'next' ( ( ruleEString ) ) otherlv_7= '}' ) )
            // InternalMyDsl.g:1407:2: (otherlv_0= 'GenericStep' ( (lv_name_1_0= ruleEString ) ) otherlv_2= '{' (otherlv_3= 'description' ( (lv_description_4_0= ruleEString ) ) )? otherlv_5= 'next' ( ( ruleEString ) ) otherlv_7= '}' )
            {
            // InternalMyDsl.g:1407:2: (otherlv_0= 'GenericStep' ( (lv_name_1_0= ruleEString ) ) otherlv_2= '{' (otherlv_3= 'description' ( (lv_description_4_0= ruleEString ) ) )? otherlv_5= 'next' ( ( ruleEString ) ) otherlv_7= '}' )
            // InternalMyDsl.g:1408:3: otherlv_0= 'GenericStep' ( (lv_name_1_0= ruleEString ) ) otherlv_2= '{' (otherlv_3= 'description' ( (lv_description_4_0= ruleEString ) ) )? otherlv_5= 'next' ( ( ruleEString ) ) otherlv_7= '}'
            {
            otherlv_0=(Token)match(input,37,FOLLOW_6); 

            			newLeafNode(otherlv_0, grammarAccess.getGenericStepAccess().getGenericStepKeyword_0());
            		
            // InternalMyDsl.g:1412:3: ( (lv_name_1_0= ruleEString ) )
            // InternalMyDsl.g:1413:4: (lv_name_1_0= ruleEString )
            {
            // InternalMyDsl.g:1413:4: (lv_name_1_0= ruleEString )
            // InternalMyDsl.g:1414:5: lv_name_1_0= ruleEString
            {

            					newCompositeNode(grammarAccess.getGenericStepAccess().getNameEStringParserRuleCall_1_0());
            				
            pushFollow(FOLLOW_36);
            lv_name_1_0=ruleEString();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getGenericStepRule());
            					}
            					set(
            						current,
            						"name",
            						lv_name_1_0,
            						"org.xtext.example.mydsl.MyDsl.EString");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_2=(Token)match(input,38,FOLLOW_37); 

            			newLeafNode(otherlv_2, grammarAccess.getGenericStepAccess().getLeftCurlyBracketKeyword_2());
            		
            // InternalMyDsl.g:1435:3: (otherlv_3= 'description' ( (lv_description_4_0= ruleEString ) ) )?
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( (LA14_0==17) ) {
                alt14=1;
            }
            switch (alt14) {
                case 1 :
                    // InternalMyDsl.g:1436:4: otherlv_3= 'description' ( (lv_description_4_0= ruleEString ) )
                    {
                    otherlv_3=(Token)match(input,17,FOLLOW_6); 

                    				newLeafNode(otherlv_3, grammarAccess.getGenericStepAccess().getDescriptionKeyword_3_0());
                    			
                    // InternalMyDsl.g:1440:4: ( (lv_description_4_0= ruleEString ) )
                    // InternalMyDsl.g:1441:5: (lv_description_4_0= ruleEString )
                    {
                    // InternalMyDsl.g:1441:5: (lv_description_4_0= ruleEString )
                    // InternalMyDsl.g:1442:6: lv_description_4_0= ruleEString
                    {

                    						newCompositeNode(grammarAccess.getGenericStepAccess().getDescriptionEStringParserRuleCall_3_1_0());
                    					
                    pushFollow(FOLLOW_38);
                    lv_description_4_0=ruleEString();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getGenericStepRule());
                    						}
                    						set(
                    							current,
                    							"description",
                    							lv_description_4_0,
                    							"org.xtext.example.mydsl.MyDsl.EString");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;

            }

            otherlv_5=(Token)match(input,39,FOLLOW_6); 

            			newLeafNode(otherlv_5, grammarAccess.getGenericStepAccess().getNextKeyword_4());
            		
            // InternalMyDsl.g:1464:3: ( ( ruleEString ) )
            // InternalMyDsl.g:1465:4: ( ruleEString )
            {
            // InternalMyDsl.g:1465:4: ( ruleEString )
            // InternalMyDsl.g:1466:5: ruleEString
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getGenericStepRule());
            					}
            				

            					newCompositeNode(grammarAccess.getGenericStepAccess().getNextStepCrossReference_5_0());
            				
            pushFollow(FOLLOW_39);
            ruleEString();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_7=(Token)match(input,40,FOLLOW_2); 

            			newLeafNode(otherlv_7, grammarAccess.getGenericStepAccess().getRightCurlyBracketKeyword_6());
            		

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
    // $ANTLR end "ruleGenericStep"


    // $ANTLR start "entryRuleJoin"
    // InternalMyDsl.g:1488:1: entryRuleJoin returns [EObject current=null] : iv_ruleJoin= ruleJoin EOF ;
    public final EObject entryRuleJoin() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleJoin = null;


        try {
            // InternalMyDsl.g:1488:45: (iv_ruleJoin= ruleJoin EOF )
            // InternalMyDsl.g:1489:2: iv_ruleJoin= ruleJoin EOF
            {
             newCompositeNode(grammarAccess.getJoinRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleJoin=ruleJoin();

            state._fsp--;

             current =iv_ruleJoin; 
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
    // $ANTLR end "entryRuleJoin"


    // $ANTLR start "ruleJoin"
    // InternalMyDsl.g:1495:1: ruleJoin returns [EObject current=null] : (otherlv_0= 'JOIN' ( (lv_type_1_0= ruleJoinType ) ) ( (lv_name_2_0= ruleEString ) ) otherlv_3= '->' ( ( ruleEString ) ) otherlv_5= ':' (otherlv_6= 'description' ( (lv_description_7_0= ruleEString ) ) )? otherlv_8= 'ON' ( ( ruleEString ) ) otherlv_10= '(' ( ( ruleEString ) ) otherlv_12= ')' otherlv_13= 'WITH' ( ( ruleEString ) ) otherlv_15= '(' ( ( ruleEString ) ) otherlv_17= ')' otherlv_18= 'SELECTING' ( ( ruleEString ) ) (otherlv_20= ',' ( ( ruleEString ) ) )* otherlv_22= 'INTO' ( ( ruleEString ) ) ) ;
    public final EObject ruleJoin() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Token otherlv_6=null;
        Token otherlv_8=null;
        Token otherlv_10=null;
        Token otherlv_12=null;
        Token otherlv_13=null;
        Token otherlv_15=null;
        Token otherlv_17=null;
        Token otherlv_18=null;
        Token otherlv_20=null;
        Token otherlv_22=null;
        Enumerator lv_type_1_0 = null;

        AntlrDatatypeRuleToken lv_name_2_0 = null;

        AntlrDatatypeRuleToken lv_description_7_0 = null;



        	enterRule();

        try {
            // InternalMyDsl.g:1501:2: ( (otherlv_0= 'JOIN' ( (lv_type_1_0= ruleJoinType ) ) ( (lv_name_2_0= ruleEString ) ) otherlv_3= '->' ( ( ruleEString ) ) otherlv_5= ':' (otherlv_6= 'description' ( (lv_description_7_0= ruleEString ) ) )? otherlv_8= 'ON' ( ( ruleEString ) ) otherlv_10= '(' ( ( ruleEString ) ) otherlv_12= ')' otherlv_13= 'WITH' ( ( ruleEString ) ) otherlv_15= '(' ( ( ruleEString ) ) otherlv_17= ')' otherlv_18= 'SELECTING' ( ( ruleEString ) ) (otherlv_20= ',' ( ( ruleEString ) ) )* otherlv_22= 'INTO' ( ( ruleEString ) ) ) )
            // InternalMyDsl.g:1502:2: (otherlv_0= 'JOIN' ( (lv_type_1_0= ruleJoinType ) ) ( (lv_name_2_0= ruleEString ) ) otherlv_3= '->' ( ( ruleEString ) ) otherlv_5= ':' (otherlv_6= 'description' ( (lv_description_7_0= ruleEString ) ) )? otherlv_8= 'ON' ( ( ruleEString ) ) otherlv_10= '(' ( ( ruleEString ) ) otherlv_12= ')' otherlv_13= 'WITH' ( ( ruleEString ) ) otherlv_15= '(' ( ( ruleEString ) ) otherlv_17= ')' otherlv_18= 'SELECTING' ( ( ruleEString ) ) (otherlv_20= ',' ( ( ruleEString ) ) )* otherlv_22= 'INTO' ( ( ruleEString ) ) )
            {
            // InternalMyDsl.g:1502:2: (otherlv_0= 'JOIN' ( (lv_type_1_0= ruleJoinType ) ) ( (lv_name_2_0= ruleEString ) ) otherlv_3= '->' ( ( ruleEString ) ) otherlv_5= ':' (otherlv_6= 'description' ( (lv_description_7_0= ruleEString ) ) )? otherlv_8= 'ON' ( ( ruleEString ) ) otherlv_10= '(' ( ( ruleEString ) ) otherlv_12= ')' otherlv_13= 'WITH' ( ( ruleEString ) ) otherlv_15= '(' ( ( ruleEString ) ) otherlv_17= ')' otherlv_18= 'SELECTING' ( ( ruleEString ) ) (otherlv_20= ',' ( ( ruleEString ) ) )* otherlv_22= 'INTO' ( ( ruleEString ) ) )
            // InternalMyDsl.g:1503:3: otherlv_0= 'JOIN' ( (lv_type_1_0= ruleJoinType ) ) ( (lv_name_2_0= ruleEString ) ) otherlv_3= '->' ( ( ruleEString ) ) otherlv_5= ':' (otherlv_6= 'description' ( (lv_description_7_0= ruleEString ) ) )? otherlv_8= 'ON' ( ( ruleEString ) ) otherlv_10= '(' ( ( ruleEString ) ) otherlv_12= ')' otherlv_13= 'WITH' ( ( ruleEString ) ) otherlv_15= '(' ( ( ruleEString ) ) otherlv_17= ')' otherlv_18= 'SELECTING' ( ( ruleEString ) ) (otherlv_20= ',' ( ( ruleEString ) ) )* otherlv_22= 'INTO' ( ( ruleEString ) )
            {
            otherlv_0=(Token)match(input,41,FOLLOW_40); 

            			newLeafNode(otherlv_0, grammarAccess.getJoinAccess().getJOINKeyword_0());
            		
            // InternalMyDsl.g:1507:3: ( (lv_type_1_0= ruleJoinType ) )
            // InternalMyDsl.g:1508:4: (lv_type_1_0= ruleJoinType )
            {
            // InternalMyDsl.g:1508:4: (lv_type_1_0= ruleJoinType )
            // InternalMyDsl.g:1509:5: lv_type_1_0= ruleJoinType
            {

            					newCompositeNode(grammarAccess.getJoinAccess().getTypeJoinTypeEnumRuleCall_1_0());
            				
            pushFollow(FOLLOW_6);
            lv_type_1_0=ruleJoinType();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getJoinRule());
            					}
            					set(
            						current,
            						"type",
            						lv_type_1_0,
            						"org.xtext.example.mydsl.MyDsl.JoinType");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalMyDsl.g:1526:3: ( (lv_name_2_0= ruleEString ) )
            // InternalMyDsl.g:1527:4: (lv_name_2_0= ruleEString )
            {
            // InternalMyDsl.g:1527:4: (lv_name_2_0= ruleEString )
            // InternalMyDsl.g:1528:5: lv_name_2_0= ruleEString
            {

            					newCompositeNode(grammarAccess.getJoinAccess().getNameEStringParserRuleCall_2_0());
            				
            pushFollow(FOLLOW_16);
            lv_name_2_0=ruleEString();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getJoinRule());
            					}
            					set(
            						current,
            						"name",
            						lv_name_2_0,
            						"org.xtext.example.mydsl.MyDsl.EString");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_3=(Token)match(input,19,FOLLOW_6); 

            			newLeafNode(otherlv_3, grammarAccess.getJoinAccess().getHyphenMinusGreaterThanSignKeyword_3());
            		
            // InternalMyDsl.g:1549:3: ( ( ruleEString ) )
            // InternalMyDsl.g:1550:4: ( ruleEString )
            {
            // InternalMyDsl.g:1550:4: ( ruleEString )
            // InternalMyDsl.g:1551:5: ruleEString
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getJoinRule());
            					}
            				

            					newCompositeNode(grammarAccess.getJoinAccess().getNextStepCrossReference_4_0());
            				
            pushFollow(FOLLOW_10);
            ruleEString();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_5=(Token)match(input,14,FOLLOW_17); 

            			newLeafNode(otherlv_5, grammarAccess.getJoinAccess().getColonKeyword_5());
            		
            // InternalMyDsl.g:1569:3: (otherlv_6= 'description' ( (lv_description_7_0= ruleEString ) ) )?
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( (LA15_0==17) ) {
                alt15=1;
            }
            switch (alt15) {
                case 1 :
                    // InternalMyDsl.g:1570:4: otherlv_6= 'description' ( (lv_description_7_0= ruleEString ) )
                    {
                    otherlv_6=(Token)match(input,17,FOLLOW_6); 

                    				newLeafNode(otherlv_6, grammarAccess.getJoinAccess().getDescriptionKeyword_6_0());
                    			
                    // InternalMyDsl.g:1574:4: ( (lv_description_7_0= ruleEString ) )
                    // InternalMyDsl.g:1575:5: (lv_description_7_0= ruleEString )
                    {
                    // InternalMyDsl.g:1575:5: (lv_description_7_0= ruleEString )
                    // InternalMyDsl.g:1576:6: lv_description_7_0= ruleEString
                    {

                    						newCompositeNode(grammarAccess.getJoinAccess().getDescriptionEStringParserRuleCall_6_1_0());
                    					
                    pushFollow(FOLLOW_18);
                    lv_description_7_0=ruleEString();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getJoinRule());
                    						}
                    						set(
                    							current,
                    							"description",
                    							lv_description_7_0,
                    							"org.xtext.example.mydsl.MyDsl.EString");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;

            }

            otherlv_8=(Token)match(input,20,FOLLOW_6); 

            			newLeafNode(otherlv_8, grammarAccess.getJoinAccess().getONKeyword_7());
            		
            // InternalMyDsl.g:1598:3: ( ( ruleEString ) )
            // InternalMyDsl.g:1599:4: ( ruleEString )
            {
            // InternalMyDsl.g:1599:4: ( ruleEString )
            // InternalMyDsl.g:1600:5: ruleEString
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getJoinRule());
            					}
            				

            					newCompositeNode(grammarAccess.getJoinAccess().getTableLeftTableCrossReference_8_0());
            				
            pushFollow(FOLLOW_19);
            ruleEString();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_10=(Token)match(input,21,FOLLOW_6); 

            			newLeafNode(otherlv_10, grammarAccess.getJoinAccess().getLeftParenthesisKeyword_9());
            		
            // InternalMyDsl.g:1618:3: ( ( ruleEString ) )
            // InternalMyDsl.g:1619:4: ( ruleEString )
            {
            // InternalMyDsl.g:1619:4: ( ruleEString )
            // InternalMyDsl.g:1620:5: ruleEString
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getJoinRule());
            					}
            				

            					newCompositeNode(grammarAccess.getJoinAccess().getColumnLeftColumnCrossReference_10_0());
            				
            pushFollow(FOLLOW_24);
            ruleEString();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_12=(Token)match(input,23,FOLLOW_41); 

            			newLeafNode(otherlv_12, grammarAccess.getJoinAccess().getRightParenthesisKeyword_11());
            		
            otherlv_13=(Token)match(input,42,FOLLOW_6); 

            			newLeafNode(otherlv_13, grammarAccess.getJoinAccess().getWITHKeyword_12());
            		
            // InternalMyDsl.g:1642:3: ( ( ruleEString ) )
            // InternalMyDsl.g:1643:4: ( ruleEString )
            {
            // InternalMyDsl.g:1643:4: ( ruleEString )
            // InternalMyDsl.g:1644:5: ruleEString
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getJoinRule());
            					}
            				

            					newCompositeNode(grammarAccess.getJoinAccess().getTableRightTableCrossReference_13_0());
            				
            pushFollow(FOLLOW_19);
            ruleEString();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_15=(Token)match(input,21,FOLLOW_6); 

            			newLeafNode(otherlv_15, grammarAccess.getJoinAccess().getLeftParenthesisKeyword_14());
            		
            // InternalMyDsl.g:1662:3: ( ( ruleEString ) )
            // InternalMyDsl.g:1663:4: ( ruleEString )
            {
            // InternalMyDsl.g:1663:4: ( ruleEString )
            // InternalMyDsl.g:1664:5: ruleEString
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getJoinRule());
            					}
            				

            					newCompositeNode(grammarAccess.getJoinAccess().getColumnRightColumnCrossReference_15_0());
            				
            pushFollow(FOLLOW_24);
            ruleEString();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_17=(Token)match(input,23,FOLLOW_42); 

            			newLeafNode(otherlv_17, grammarAccess.getJoinAccess().getRightParenthesisKeyword_16());
            		
            otherlv_18=(Token)match(input,43,FOLLOW_6); 

            			newLeafNode(otherlv_18, grammarAccess.getJoinAccess().getSELECTINGKeyword_17());
            		
            // InternalMyDsl.g:1686:3: ( ( ruleEString ) )
            // InternalMyDsl.g:1687:4: ( ruleEString )
            {
            // InternalMyDsl.g:1687:4: ( ruleEString )
            // InternalMyDsl.g:1688:5: ruleEString
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getJoinRule());
            					}
            				

            					newCompositeNode(grammarAccess.getJoinAccess().getSelectColumnsColumnCrossReference_18_0());
            				
            pushFollow(FOLLOW_43);
            ruleEString();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalMyDsl.g:1702:3: (otherlv_20= ',' ( ( ruleEString ) ) )*
            loop16:
            do {
                int alt16=2;
                int LA16_0 = input.LA(1);

                if ( (LA16_0==22) ) {
                    alt16=1;
                }


                switch (alt16) {
            	case 1 :
            	    // InternalMyDsl.g:1703:4: otherlv_20= ',' ( ( ruleEString ) )
            	    {
            	    otherlv_20=(Token)match(input,22,FOLLOW_6); 

            	    				newLeafNode(otherlv_20, grammarAccess.getJoinAccess().getCommaKeyword_19_0());
            	    			
            	    // InternalMyDsl.g:1707:4: ( ( ruleEString ) )
            	    // InternalMyDsl.g:1708:5: ( ruleEString )
            	    {
            	    // InternalMyDsl.g:1708:5: ( ruleEString )
            	    // InternalMyDsl.g:1709:6: ruleEString
            	    {

            	    						if (current==null) {
            	    							current = createModelElement(grammarAccess.getJoinRule());
            	    						}
            	    					

            	    						newCompositeNode(grammarAccess.getJoinAccess().getSelectColumnsColumnCrossReference_19_1_0());
            	    					
            	    pushFollow(FOLLOW_43);
            	    ruleEString();

            	    state._fsp--;


            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop16;
                }
            } while (true);

            otherlv_22=(Token)match(input,25,FOLLOW_6); 

            			newLeafNode(otherlv_22, grammarAccess.getJoinAccess().getINTOKeyword_20());
            		
            // InternalMyDsl.g:1728:3: ( ( ruleEString ) )
            // InternalMyDsl.g:1729:4: ( ruleEString )
            {
            // InternalMyDsl.g:1729:4: ( ruleEString )
            // InternalMyDsl.g:1730:5: ruleEString
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getJoinRule());
            					}
            				

            					newCompositeNode(grammarAccess.getJoinAccess().getResultTableTableCrossReference_21_0());
            				
            pushFollow(FOLLOW_2);
            ruleEString();

            state._fsp--;


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
    // $ANTLR end "ruleJoin"


    // $ANTLR start "entryRuleImport"
    // InternalMyDsl.g:1748:1: entryRuleImport returns [EObject current=null] : iv_ruleImport= ruleImport EOF ;
    public final EObject entryRuleImport() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleImport = null;


        try {
            // InternalMyDsl.g:1748:47: (iv_ruleImport= ruleImport EOF )
            // InternalMyDsl.g:1749:2: iv_ruleImport= ruleImport EOF
            {
             newCompositeNode(grammarAccess.getImportRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleImport=ruleImport();

            state._fsp--;

             current =iv_ruleImport; 
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
    // $ANTLR end "entryRuleImport"


    // $ANTLR start "ruleImport"
    // InternalMyDsl.g:1755:1: ruleImport returns [EObject current=null] : (otherlv_0= 'IMPORT' ( (lv_name_1_0= ruleEString ) ) otherlv_2= '->' ( ( ruleEString ) ) otherlv_4= ':' (otherlv_5= 'description' ( (lv_description_6_0= ruleEString ) ) )? ( (lv_tablesToImport_7_0= ruleTableToImport ) ) ( (lv_tablesToImport_8_0= ruleTableToImport ) )* ) ;
    public final EObject ruleImport() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_5=null;
        AntlrDatatypeRuleToken lv_name_1_0 = null;

        AntlrDatatypeRuleToken lv_description_6_0 = null;

        EObject lv_tablesToImport_7_0 = null;

        EObject lv_tablesToImport_8_0 = null;



        	enterRule();

        try {
            // InternalMyDsl.g:1761:2: ( (otherlv_0= 'IMPORT' ( (lv_name_1_0= ruleEString ) ) otherlv_2= '->' ( ( ruleEString ) ) otherlv_4= ':' (otherlv_5= 'description' ( (lv_description_6_0= ruleEString ) ) )? ( (lv_tablesToImport_7_0= ruleTableToImport ) ) ( (lv_tablesToImport_8_0= ruleTableToImport ) )* ) )
            // InternalMyDsl.g:1762:2: (otherlv_0= 'IMPORT' ( (lv_name_1_0= ruleEString ) ) otherlv_2= '->' ( ( ruleEString ) ) otherlv_4= ':' (otherlv_5= 'description' ( (lv_description_6_0= ruleEString ) ) )? ( (lv_tablesToImport_7_0= ruleTableToImport ) ) ( (lv_tablesToImport_8_0= ruleTableToImport ) )* )
            {
            // InternalMyDsl.g:1762:2: (otherlv_0= 'IMPORT' ( (lv_name_1_0= ruleEString ) ) otherlv_2= '->' ( ( ruleEString ) ) otherlv_4= ':' (otherlv_5= 'description' ( (lv_description_6_0= ruleEString ) ) )? ( (lv_tablesToImport_7_0= ruleTableToImport ) ) ( (lv_tablesToImport_8_0= ruleTableToImport ) )* )
            // InternalMyDsl.g:1763:3: otherlv_0= 'IMPORT' ( (lv_name_1_0= ruleEString ) ) otherlv_2= '->' ( ( ruleEString ) ) otherlv_4= ':' (otherlv_5= 'description' ( (lv_description_6_0= ruleEString ) ) )? ( (lv_tablesToImport_7_0= ruleTableToImport ) ) ( (lv_tablesToImport_8_0= ruleTableToImport ) )*
            {
            otherlv_0=(Token)match(input,44,FOLLOW_6); 

            			newLeafNode(otherlv_0, grammarAccess.getImportAccess().getIMPORTKeyword_0());
            		
            // InternalMyDsl.g:1767:3: ( (lv_name_1_0= ruleEString ) )
            // InternalMyDsl.g:1768:4: (lv_name_1_0= ruleEString )
            {
            // InternalMyDsl.g:1768:4: (lv_name_1_0= ruleEString )
            // InternalMyDsl.g:1769:5: lv_name_1_0= ruleEString
            {

            					newCompositeNode(grammarAccess.getImportAccess().getNameEStringParserRuleCall_1_0());
            				
            pushFollow(FOLLOW_16);
            lv_name_1_0=ruleEString();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getImportRule());
            					}
            					set(
            						current,
            						"name",
            						lv_name_1_0,
            						"org.xtext.example.mydsl.MyDsl.EString");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_2=(Token)match(input,19,FOLLOW_6); 

            			newLeafNode(otherlv_2, grammarAccess.getImportAccess().getHyphenMinusGreaterThanSignKeyword_2());
            		
            // InternalMyDsl.g:1790:3: ( ( ruleEString ) )
            // InternalMyDsl.g:1791:4: ( ruleEString )
            {
            // InternalMyDsl.g:1791:4: ( ruleEString )
            // InternalMyDsl.g:1792:5: ruleEString
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getImportRule());
            					}
            				

            					newCompositeNode(grammarAccess.getImportAccess().getNextStepCrossReference_3_0());
            				
            pushFollow(FOLLOW_10);
            ruleEString();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_4=(Token)match(input,14,FOLLOW_44); 

            			newLeafNode(otherlv_4, grammarAccess.getImportAccess().getColonKeyword_4());
            		
            // InternalMyDsl.g:1810:3: (otherlv_5= 'description' ( (lv_description_6_0= ruleEString ) ) )?
            int alt17=2;
            int LA17_0 = input.LA(1);

            if ( (LA17_0==17) ) {
                alt17=1;
            }
            switch (alt17) {
                case 1 :
                    // InternalMyDsl.g:1811:4: otherlv_5= 'description' ( (lv_description_6_0= ruleEString ) )
                    {
                    otherlv_5=(Token)match(input,17,FOLLOW_6); 

                    				newLeafNode(otherlv_5, grammarAccess.getImportAccess().getDescriptionKeyword_5_0());
                    			
                    // InternalMyDsl.g:1815:4: ( (lv_description_6_0= ruleEString ) )
                    // InternalMyDsl.g:1816:5: (lv_description_6_0= ruleEString )
                    {
                    // InternalMyDsl.g:1816:5: (lv_description_6_0= ruleEString )
                    // InternalMyDsl.g:1817:6: lv_description_6_0= ruleEString
                    {

                    						newCompositeNode(grammarAccess.getImportAccess().getDescriptionEStringParserRuleCall_5_1_0());
                    					
                    pushFollow(FOLLOW_44);
                    lv_description_6_0=ruleEString();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getImportRule());
                    						}
                    						set(
                    							current,
                    							"description",
                    							lv_description_6_0,
                    							"org.xtext.example.mydsl.MyDsl.EString");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;

            }

            // InternalMyDsl.g:1835:3: ( (lv_tablesToImport_7_0= ruleTableToImport ) )
            // InternalMyDsl.g:1836:4: (lv_tablesToImport_7_0= ruleTableToImport )
            {
            // InternalMyDsl.g:1836:4: (lv_tablesToImport_7_0= ruleTableToImport )
            // InternalMyDsl.g:1837:5: lv_tablesToImport_7_0= ruleTableToImport
            {

            					newCompositeNode(grammarAccess.getImportAccess().getTablesToImportTableToImportParserRuleCall_6_0());
            				
            pushFollow(FOLLOW_45);
            lv_tablesToImport_7_0=ruleTableToImport();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getImportRule());
            					}
            					add(
            						current,
            						"tablesToImport",
            						lv_tablesToImport_7_0,
            						"org.xtext.example.mydsl.MyDsl.TableToImport");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalMyDsl.g:1854:3: ( (lv_tablesToImport_8_0= ruleTableToImport ) )*
            loop18:
            do {
                int alt18=2;
                int LA18_0 = input.LA(1);

                if ( (LA18_0==44) ) {
                    int LA18_2 = input.LA(2);

                    if ( (LA18_2==30) ) {
                        alt18=1;
                    }


                }


                switch (alt18) {
            	case 1 :
            	    // InternalMyDsl.g:1855:4: (lv_tablesToImport_8_0= ruleTableToImport )
            	    {
            	    // InternalMyDsl.g:1855:4: (lv_tablesToImport_8_0= ruleTableToImport )
            	    // InternalMyDsl.g:1856:5: lv_tablesToImport_8_0= ruleTableToImport
            	    {

            	    					newCompositeNode(grammarAccess.getImportAccess().getTablesToImportTableToImportParserRuleCall_7_0());
            	    				
            	    pushFollow(FOLLOW_45);
            	    lv_tablesToImport_8_0=ruleTableToImport();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getImportRule());
            	    					}
            	    					add(
            	    						current,
            	    						"tablesToImport",
            	    						lv_tablesToImport_8_0,
            	    						"org.xtext.example.mydsl.MyDsl.TableToImport");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop18;
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
    // $ANTLR end "ruleImport"


    // $ANTLR start "entryRuleLookup"
    // InternalMyDsl.g:1877:1: entryRuleLookup returns [EObject current=null] : iv_ruleLookup= ruleLookup EOF ;
    public final EObject entryRuleLookup() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLookup = null;


        try {
            // InternalMyDsl.g:1877:47: (iv_ruleLookup= ruleLookup EOF )
            // InternalMyDsl.g:1878:2: iv_ruleLookup= ruleLookup EOF
            {
             newCompositeNode(grammarAccess.getLookupRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleLookup=ruleLookup();

            state._fsp--;

             current =iv_ruleLookup; 
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
    // $ANTLR end "entryRuleLookup"


    // $ANTLR start "ruleLookup"
    // InternalMyDsl.g:1884:1: ruleLookup returns [EObject current=null] : (otherlv_0= 'LOOKUP' ( (lv_name_1_0= ruleEString ) ) otherlv_2= '->' ( ( ruleEString ) ) otherlv_4= ':' (otherlv_5= 'description' ( (lv_description_6_0= ruleEString ) ) )? otherlv_7= 'FROM' ( ( ruleEString ) ) otherlv_9= '(' ( ( ruleEString ) ) otherlv_11= ')' otherlv_12= 'TO' ( ( ruleEString ) ) otherlv_14= '(' ( ( ruleEString ) ) otherlv_16= ')' otherlv_17= 'AND' otherlv_18= 'PUT' ( (lv_operation_19_0= ruleLookupOperationType ) ) otherlv_20= '(' ( ( ruleEString ) ) otherlv_22= ',' ( ( ruleEString ) ) otherlv_24= ')' otherlv_25= 'INTO' ( ( ruleEString ) ) otherlv_27= '(' ( ( ruleEString ) ) otherlv_29= ')' ) ;
    public final EObject ruleLookup() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        Token otherlv_9=null;
        Token otherlv_11=null;
        Token otherlv_12=null;
        Token otherlv_14=null;
        Token otherlv_16=null;
        Token otherlv_17=null;
        Token otherlv_18=null;
        Token otherlv_20=null;
        Token otherlv_22=null;
        Token otherlv_24=null;
        Token otherlv_25=null;
        Token otherlv_27=null;
        Token otherlv_29=null;
        AntlrDatatypeRuleToken lv_name_1_0 = null;

        AntlrDatatypeRuleToken lv_description_6_0 = null;

        Enumerator lv_operation_19_0 = null;



        	enterRule();

        try {
            // InternalMyDsl.g:1890:2: ( (otherlv_0= 'LOOKUP' ( (lv_name_1_0= ruleEString ) ) otherlv_2= '->' ( ( ruleEString ) ) otherlv_4= ':' (otherlv_5= 'description' ( (lv_description_6_0= ruleEString ) ) )? otherlv_7= 'FROM' ( ( ruleEString ) ) otherlv_9= '(' ( ( ruleEString ) ) otherlv_11= ')' otherlv_12= 'TO' ( ( ruleEString ) ) otherlv_14= '(' ( ( ruleEString ) ) otherlv_16= ')' otherlv_17= 'AND' otherlv_18= 'PUT' ( (lv_operation_19_0= ruleLookupOperationType ) ) otherlv_20= '(' ( ( ruleEString ) ) otherlv_22= ',' ( ( ruleEString ) ) otherlv_24= ')' otherlv_25= 'INTO' ( ( ruleEString ) ) otherlv_27= '(' ( ( ruleEString ) ) otherlv_29= ')' ) )
            // InternalMyDsl.g:1891:2: (otherlv_0= 'LOOKUP' ( (lv_name_1_0= ruleEString ) ) otherlv_2= '->' ( ( ruleEString ) ) otherlv_4= ':' (otherlv_5= 'description' ( (lv_description_6_0= ruleEString ) ) )? otherlv_7= 'FROM' ( ( ruleEString ) ) otherlv_9= '(' ( ( ruleEString ) ) otherlv_11= ')' otherlv_12= 'TO' ( ( ruleEString ) ) otherlv_14= '(' ( ( ruleEString ) ) otherlv_16= ')' otherlv_17= 'AND' otherlv_18= 'PUT' ( (lv_operation_19_0= ruleLookupOperationType ) ) otherlv_20= '(' ( ( ruleEString ) ) otherlv_22= ',' ( ( ruleEString ) ) otherlv_24= ')' otherlv_25= 'INTO' ( ( ruleEString ) ) otherlv_27= '(' ( ( ruleEString ) ) otherlv_29= ')' )
            {
            // InternalMyDsl.g:1891:2: (otherlv_0= 'LOOKUP' ( (lv_name_1_0= ruleEString ) ) otherlv_2= '->' ( ( ruleEString ) ) otherlv_4= ':' (otherlv_5= 'description' ( (lv_description_6_0= ruleEString ) ) )? otherlv_7= 'FROM' ( ( ruleEString ) ) otherlv_9= '(' ( ( ruleEString ) ) otherlv_11= ')' otherlv_12= 'TO' ( ( ruleEString ) ) otherlv_14= '(' ( ( ruleEString ) ) otherlv_16= ')' otherlv_17= 'AND' otherlv_18= 'PUT' ( (lv_operation_19_0= ruleLookupOperationType ) ) otherlv_20= '(' ( ( ruleEString ) ) otherlv_22= ',' ( ( ruleEString ) ) otherlv_24= ')' otherlv_25= 'INTO' ( ( ruleEString ) ) otherlv_27= '(' ( ( ruleEString ) ) otherlv_29= ')' )
            // InternalMyDsl.g:1892:3: otherlv_0= 'LOOKUP' ( (lv_name_1_0= ruleEString ) ) otherlv_2= '->' ( ( ruleEString ) ) otherlv_4= ':' (otherlv_5= 'description' ( (lv_description_6_0= ruleEString ) ) )? otherlv_7= 'FROM' ( ( ruleEString ) ) otherlv_9= '(' ( ( ruleEString ) ) otherlv_11= ')' otherlv_12= 'TO' ( ( ruleEString ) ) otherlv_14= '(' ( ( ruleEString ) ) otherlv_16= ')' otherlv_17= 'AND' otherlv_18= 'PUT' ( (lv_operation_19_0= ruleLookupOperationType ) ) otherlv_20= '(' ( ( ruleEString ) ) otherlv_22= ',' ( ( ruleEString ) ) otherlv_24= ')' otherlv_25= 'INTO' ( ( ruleEString ) ) otherlv_27= '(' ( ( ruleEString ) ) otherlv_29= ')'
            {
            otherlv_0=(Token)match(input,45,FOLLOW_6); 

            			newLeafNode(otherlv_0, grammarAccess.getLookupAccess().getLOOKUPKeyword_0());
            		
            // InternalMyDsl.g:1896:3: ( (lv_name_1_0= ruleEString ) )
            // InternalMyDsl.g:1897:4: (lv_name_1_0= ruleEString )
            {
            // InternalMyDsl.g:1897:4: (lv_name_1_0= ruleEString )
            // InternalMyDsl.g:1898:5: lv_name_1_0= ruleEString
            {

            					newCompositeNode(grammarAccess.getLookupAccess().getNameEStringParserRuleCall_1_0());
            				
            pushFollow(FOLLOW_16);
            lv_name_1_0=ruleEString();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getLookupRule());
            					}
            					set(
            						current,
            						"name",
            						lv_name_1_0,
            						"org.xtext.example.mydsl.MyDsl.EString");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_2=(Token)match(input,19,FOLLOW_6); 

            			newLeafNode(otherlv_2, grammarAccess.getLookupAccess().getHyphenMinusGreaterThanSignKeyword_2());
            		
            // InternalMyDsl.g:1919:3: ( ( ruleEString ) )
            // InternalMyDsl.g:1920:4: ( ruleEString )
            {
            // InternalMyDsl.g:1920:4: ( ruleEString )
            // InternalMyDsl.g:1921:5: ruleEString
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getLookupRule());
            					}
            				

            					newCompositeNode(grammarAccess.getLookupAccess().getNextStepCrossReference_3_0());
            				
            pushFollow(FOLLOW_10);
            ruleEString();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_4=(Token)match(input,14,FOLLOW_28); 

            			newLeafNode(otherlv_4, grammarAccess.getLookupAccess().getColonKeyword_4());
            		
            // InternalMyDsl.g:1939:3: (otherlv_5= 'description' ( (lv_description_6_0= ruleEString ) ) )?
            int alt19=2;
            int LA19_0 = input.LA(1);

            if ( (LA19_0==17) ) {
                alt19=1;
            }
            switch (alt19) {
                case 1 :
                    // InternalMyDsl.g:1940:4: otherlv_5= 'description' ( (lv_description_6_0= ruleEString ) )
                    {
                    otherlv_5=(Token)match(input,17,FOLLOW_6); 

                    				newLeafNode(otherlv_5, grammarAccess.getLookupAccess().getDescriptionKeyword_5_0());
                    			
                    // InternalMyDsl.g:1944:4: ( (lv_description_6_0= ruleEString ) )
                    // InternalMyDsl.g:1945:5: (lv_description_6_0= ruleEString )
                    {
                    // InternalMyDsl.g:1945:5: (lv_description_6_0= ruleEString )
                    // InternalMyDsl.g:1946:6: lv_description_6_0= ruleEString
                    {

                    						newCompositeNode(grammarAccess.getLookupAccess().getDescriptionEStringParserRuleCall_5_1_0());
                    					
                    pushFollow(FOLLOW_29);
                    lv_description_6_0=ruleEString();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getLookupRule());
                    						}
                    						set(
                    							current,
                    							"description",
                    							lv_description_6_0,
                    							"org.xtext.example.mydsl.MyDsl.EString");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;

            }

            otherlv_7=(Token)match(input,30,FOLLOW_6); 

            			newLeafNode(otherlv_7, grammarAccess.getLookupAccess().getFROMKeyword_6());
            		
            // InternalMyDsl.g:1968:3: ( ( ruleEString ) )
            // InternalMyDsl.g:1969:4: ( ruleEString )
            {
            // InternalMyDsl.g:1969:4: ( ruleEString )
            // InternalMyDsl.g:1970:5: ruleEString
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getLookupRule());
            					}
            				

            					newCompositeNode(grammarAccess.getLookupAccess().getTableTableCrossReference_7_0());
            				
            pushFollow(FOLLOW_19);
            ruleEString();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_9=(Token)match(input,21,FOLLOW_6); 

            			newLeafNode(otherlv_9, grammarAccess.getLookupAccess().getLeftParenthesisKeyword_8());
            		
            // InternalMyDsl.g:1988:3: ( ( ruleEString ) )
            // InternalMyDsl.g:1989:4: ( ruleEString )
            {
            // InternalMyDsl.g:1989:4: ( ruleEString )
            // InternalMyDsl.g:1990:5: ruleEString
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getLookupRule());
            					}
            				

            					newCompositeNode(grammarAccess.getLookupAccess().getColumnColumnCrossReference_9_0());
            				
            pushFollow(FOLLOW_24);
            ruleEString();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_11=(Token)match(input,23,FOLLOW_30); 

            			newLeafNode(otherlv_11, grammarAccess.getLookupAccess().getRightParenthesisKeyword_10());
            		
            otherlv_12=(Token)match(input,31,FOLLOW_6); 

            			newLeafNode(otherlv_12, grammarAccess.getLookupAccess().getTOKeyword_11());
            		
            // InternalMyDsl.g:2012:3: ( ( ruleEString ) )
            // InternalMyDsl.g:2013:4: ( ruleEString )
            {
            // InternalMyDsl.g:2013:4: ( ruleEString )
            // InternalMyDsl.g:2014:5: ruleEString
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getLookupRule());
            					}
            				

            					newCompositeNode(grammarAccess.getLookupAccess().getLookupTableTableCrossReference_12_0());
            				
            pushFollow(FOLLOW_19);
            ruleEString();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_14=(Token)match(input,21,FOLLOW_6); 

            			newLeafNode(otherlv_14, grammarAccess.getLookupAccess().getLeftParenthesisKeyword_13());
            		
            // InternalMyDsl.g:2032:3: ( ( ruleEString ) )
            // InternalMyDsl.g:2033:4: ( ruleEString )
            {
            // InternalMyDsl.g:2033:4: ( ruleEString )
            // InternalMyDsl.g:2034:5: ruleEString
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getLookupRule());
            					}
            				

            					newCompositeNode(grammarAccess.getLookupAccess().getMatchColumnColumnCrossReference_14_0());
            				
            pushFollow(FOLLOW_24);
            ruleEString();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_16=(Token)match(input,23,FOLLOW_21); 

            			newLeafNode(otherlv_16, grammarAccess.getLookupAccess().getRightParenthesisKeyword_15());
            		
            otherlv_17=(Token)match(input,24,FOLLOW_46); 

            			newLeafNode(otherlv_17, grammarAccess.getLookupAccess().getANDKeyword_16());
            		
            otherlv_18=(Token)match(input,46,FOLLOW_47); 

            			newLeafNode(otherlv_18, grammarAccess.getLookupAccess().getPUTKeyword_17());
            		
            // InternalMyDsl.g:2060:3: ( (lv_operation_19_0= ruleLookupOperationType ) )
            // InternalMyDsl.g:2061:4: (lv_operation_19_0= ruleLookupOperationType )
            {
            // InternalMyDsl.g:2061:4: (lv_operation_19_0= ruleLookupOperationType )
            // InternalMyDsl.g:2062:5: lv_operation_19_0= ruleLookupOperationType
            {

            					newCompositeNode(grammarAccess.getLookupAccess().getOperationLookupOperationTypeEnumRuleCall_18_0());
            				
            pushFollow(FOLLOW_19);
            lv_operation_19_0=ruleLookupOperationType();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getLookupRule());
            					}
            					set(
            						current,
            						"operation",
            						lv_operation_19_0,
            						"org.xtext.example.mydsl.MyDsl.LookupOperationType");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_20=(Token)match(input,21,FOLLOW_6); 

            			newLeafNode(otherlv_20, grammarAccess.getLookupAccess().getLeftParenthesisKeyword_19());
            		
            // InternalMyDsl.g:2083:3: ( ( ruleEString ) )
            // InternalMyDsl.g:2084:4: ( ruleEString )
            {
            // InternalMyDsl.g:2084:4: ( ruleEString )
            // InternalMyDsl.g:2085:5: ruleEString
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getLookupRule());
            					}
            				

            					newCompositeNode(grammarAccess.getLookupAccess().getOperandColumnColumnCrossReference_20_0());
            				
            pushFollow(FOLLOW_48);
            ruleEString();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_22=(Token)match(input,22,FOLLOW_6); 

            			newLeafNode(otherlv_22, grammarAccess.getLookupAccess().getCommaKeyword_21());
            		
            // InternalMyDsl.g:2103:3: ( ( ruleEString ) )
            // InternalMyDsl.g:2104:4: ( ruleEString )
            {
            // InternalMyDsl.g:2104:4: ( ruleEString )
            // InternalMyDsl.g:2105:5: ruleEString
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getLookupRule());
            					}
            				

            					newCompositeNode(grammarAccess.getLookupAccess().getLookupColumnColumnCrossReference_22_0());
            				
            pushFollow(FOLLOW_24);
            ruleEString();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_24=(Token)match(input,23,FOLLOW_23); 

            			newLeafNode(otherlv_24, grammarAccess.getLookupAccess().getRightParenthesisKeyword_23());
            		
            otherlv_25=(Token)match(input,25,FOLLOW_6); 

            			newLeafNode(otherlv_25, grammarAccess.getLookupAccess().getINTOKeyword_24());
            		
            // InternalMyDsl.g:2127:3: ( ( ruleEString ) )
            // InternalMyDsl.g:2128:4: ( ruleEString )
            {
            // InternalMyDsl.g:2128:4: ( ruleEString )
            // InternalMyDsl.g:2129:5: ruleEString
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getLookupRule());
            					}
            				

            					newCompositeNode(grammarAccess.getLookupAccess().getResultTableTableCrossReference_25_0());
            				
            pushFollow(FOLLOW_19);
            ruleEString();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_27=(Token)match(input,21,FOLLOW_6); 

            			newLeafNode(otherlv_27, grammarAccess.getLookupAccess().getLeftParenthesisKeyword_26());
            		
            // InternalMyDsl.g:2147:3: ( ( ruleEString ) )
            // InternalMyDsl.g:2148:4: ( ruleEString )
            {
            // InternalMyDsl.g:2148:4: ( ruleEString )
            // InternalMyDsl.g:2149:5: ruleEString
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getLookupRule());
            					}
            				

            					newCompositeNode(grammarAccess.getLookupAccess().getResultColumnColumnCrossReference_27_0());
            				
            pushFollow(FOLLOW_24);
            ruleEString();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_29=(Token)match(input,23,FOLLOW_2); 

            			newLeafNode(otherlv_29, grammarAccess.getLookupAccess().getRightParenthesisKeyword_28());
            		

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
    // $ANTLR end "ruleLookup"


    // $ANTLR start "entryRuleRemoveDuplicates"
    // InternalMyDsl.g:2171:1: entryRuleRemoveDuplicates returns [EObject current=null] : iv_ruleRemoveDuplicates= ruleRemoveDuplicates EOF ;
    public final EObject entryRuleRemoveDuplicates() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRemoveDuplicates = null;


        try {
            // InternalMyDsl.g:2171:57: (iv_ruleRemoveDuplicates= ruleRemoveDuplicates EOF )
            // InternalMyDsl.g:2172:2: iv_ruleRemoveDuplicates= ruleRemoveDuplicates EOF
            {
             newCompositeNode(grammarAccess.getRemoveDuplicatesRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleRemoveDuplicates=ruleRemoveDuplicates();

            state._fsp--;

             current =iv_ruleRemoveDuplicates; 
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
    // $ANTLR end "entryRuleRemoveDuplicates"


    // $ANTLR start "ruleRemoveDuplicates"
    // InternalMyDsl.g:2178:1: ruleRemoveDuplicates returns [EObject current=null] : (otherlv_0= 'REMOVE_DUPLICATES' ( (lv_name_1_0= ruleEString ) ) otherlv_2= '->' ( ( ruleEString ) ) otherlv_4= ':' (otherlv_5= 'description' ( (lv_description_6_0= ruleEString ) ) )? otherlv_7= 'ON' ( ( ruleEString ) ) otherlv_9= '(' ( ( ruleEString ) ) otherlv_11= ')' ) ;
    public final EObject ruleRemoveDuplicates() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        Token otherlv_9=null;
        Token otherlv_11=null;
        AntlrDatatypeRuleToken lv_name_1_0 = null;

        AntlrDatatypeRuleToken lv_description_6_0 = null;



        	enterRule();

        try {
            // InternalMyDsl.g:2184:2: ( (otherlv_0= 'REMOVE_DUPLICATES' ( (lv_name_1_0= ruleEString ) ) otherlv_2= '->' ( ( ruleEString ) ) otherlv_4= ':' (otherlv_5= 'description' ( (lv_description_6_0= ruleEString ) ) )? otherlv_7= 'ON' ( ( ruleEString ) ) otherlv_9= '(' ( ( ruleEString ) ) otherlv_11= ')' ) )
            // InternalMyDsl.g:2185:2: (otherlv_0= 'REMOVE_DUPLICATES' ( (lv_name_1_0= ruleEString ) ) otherlv_2= '->' ( ( ruleEString ) ) otherlv_4= ':' (otherlv_5= 'description' ( (lv_description_6_0= ruleEString ) ) )? otherlv_7= 'ON' ( ( ruleEString ) ) otherlv_9= '(' ( ( ruleEString ) ) otherlv_11= ')' )
            {
            // InternalMyDsl.g:2185:2: (otherlv_0= 'REMOVE_DUPLICATES' ( (lv_name_1_0= ruleEString ) ) otherlv_2= '->' ( ( ruleEString ) ) otherlv_4= ':' (otherlv_5= 'description' ( (lv_description_6_0= ruleEString ) ) )? otherlv_7= 'ON' ( ( ruleEString ) ) otherlv_9= '(' ( ( ruleEString ) ) otherlv_11= ')' )
            // InternalMyDsl.g:2186:3: otherlv_0= 'REMOVE_DUPLICATES' ( (lv_name_1_0= ruleEString ) ) otherlv_2= '->' ( ( ruleEString ) ) otherlv_4= ':' (otherlv_5= 'description' ( (lv_description_6_0= ruleEString ) ) )? otherlv_7= 'ON' ( ( ruleEString ) ) otherlv_9= '(' ( ( ruleEString ) ) otherlv_11= ')'
            {
            otherlv_0=(Token)match(input,47,FOLLOW_6); 

            			newLeafNode(otherlv_0, grammarAccess.getRemoveDuplicatesAccess().getREMOVE_DUPLICATESKeyword_0());
            		
            // InternalMyDsl.g:2190:3: ( (lv_name_1_0= ruleEString ) )
            // InternalMyDsl.g:2191:4: (lv_name_1_0= ruleEString )
            {
            // InternalMyDsl.g:2191:4: (lv_name_1_0= ruleEString )
            // InternalMyDsl.g:2192:5: lv_name_1_0= ruleEString
            {

            					newCompositeNode(grammarAccess.getRemoveDuplicatesAccess().getNameEStringParserRuleCall_1_0());
            				
            pushFollow(FOLLOW_16);
            lv_name_1_0=ruleEString();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getRemoveDuplicatesRule());
            					}
            					set(
            						current,
            						"name",
            						lv_name_1_0,
            						"org.xtext.example.mydsl.MyDsl.EString");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_2=(Token)match(input,19,FOLLOW_6); 

            			newLeafNode(otherlv_2, grammarAccess.getRemoveDuplicatesAccess().getHyphenMinusGreaterThanSignKeyword_2());
            		
            // InternalMyDsl.g:2213:3: ( ( ruleEString ) )
            // InternalMyDsl.g:2214:4: ( ruleEString )
            {
            // InternalMyDsl.g:2214:4: ( ruleEString )
            // InternalMyDsl.g:2215:5: ruleEString
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getRemoveDuplicatesRule());
            					}
            				

            					newCompositeNode(grammarAccess.getRemoveDuplicatesAccess().getNextStepCrossReference_3_0());
            				
            pushFollow(FOLLOW_10);
            ruleEString();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_4=(Token)match(input,14,FOLLOW_17); 

            			newLeafNode(otherlv_4, grammarAccess.getRemoveDuplicatesAccess().getColonKeyword_4());
            		
            // InternalMyDsl.g:2233:3: (otherlv_5= 'description' ( (lv_description_6_0= ruleEString ) ) )?
            int alt20=2;
            int LA20_0 = input.LA(1);

            if ( (LA20_0==17) ) {
                alt20=1;
            }
            switch (alt20) {
                case 1 :
                    // InternalMyDsl.g:2234:4: otherlv_5= 'description' ( (lv_description_6_0= ruleEString ) )
                    {
                    otherlv_5=(Token)match(input,17,FOLLOW_6); 

                    				newLeafNode(otherlv_5, grammarAccess.getRemoveDuplicatesAccess().getDescriptionKeyword_5_0());
                    			
                    // InternalMyDsl.g:2238:4: ( (lv_description_6_0= ruleEString ) )
                    // InternalMyDsl.g:2239:5: (lv_description_6_0= ruleEString )
                    {
                    // InternalMyDsl.g:2239:5: (lv_description_6_0= ruleEString )
                    // InternalMyDsl.g:2240:6: lv_description_6_0= ruleEString
                    {

                    						newCompositeNode(grammarAccess.getRemoveDuplicatesAccess().getDescriptionEStringParserRuleCall_5_1_0());
                    					
                    pushFollow(FOLLOW_18);
                    lv_description_6_0=ruleEString();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getRemoveDuplicatesRule());
                    						}
                    						set(
                    							current,
                    							"description",
                    							lv_description_6_0,
                    							"org.xtext.example.mydsl.MyDsl.EString");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;

            }

            otherlv_7=(Token)match(input,20,FOLLOW_6); 

            			newLeafNode(otherlv_7, grammarAccess.getRemoveDuplicatesAccess().getONKeyword_6());
            		
            // InternalMyDsl.g:2262:3: ( ( ruleEString ) )
            // InternalMyDsl.g:2263:4: ( ruleEString )
            {
            // InternalMyDsl.g:2263:4: ( ruleEString )
            // InternalMyDsl.g:2264:5: ruleEString
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getRemoveDuplicatesRule());
            					}
            				

            					newCompositeNode(grammarAccess.getRemoveDuplicatesAccess().getTableTableCrossReference_7_0());
            				
            pushFollow(FOLLOW_19);
            ruleEString();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_9=(Token)match(input,21,FOLLOW_6); 

            			newLeafNode(otherlv_9, grammarAccess.getRemoveDuplicatesAccess().getLeftParenthesisKeyword_8());
            		
            // InternalMyDsl.g:2282:3: ( ( ruleEString ) )
            // InternalMyDsl.g:2283:4: ( ruleEString )
            {
            // InternalMyDsl.g:2283:4: ( ruleEString )
            // InternalMyDsl.g:2284:5: ruleEString
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getRemoveDuplicatesRule());
            					}
            				

            					newCompositeNode(grammarAccess.getRemoveDuplicatesAccess().getColumnColumnCrossReference_9_0());
            				
            pushFollow(FOLLOW_24);
            ruleEString();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_11=(Token)match(input,23,FOLLOW_2); 

            			newLeafNode(otherlv_11, grammarAccess.getRemoveDuplicatesAccess().getRightParenthesisKeyword_10());
            		

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
    // $ANTLR end "ruleRemoveDuplicates"


    // $ANTLR start "entryRuleConcat"
    // InternalMyDsl.g:2306:1: entryRuleConcat returns [EObject current=null] : iv_ruleConcat= ruleConcat EOF ;
    public final EObject entryRuleConcat() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleConcat = null;


        try {
            // InternalMyDsl.g:2306:47: (iv_ruleConcat= ruleConcat EOF )
            // InternalMyDsl.g:2307:2: iv_ruleConcat= ruleConcat EOF
            {
             newCompositeNode(grammarAccess.getConcatRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleConcat=ruleConcat();

            state._fsp--;

             current =iv_ruleConcat; 
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
    // $ANTLR end "entryRuleConcat"


    // $ANTLR start "ruleConcat"
    // InternalMyDsl.g:2313:1: ruleConcat returns [EObject current=null] : (otherlv_0= 'Concat' ( (lv_name_1_0= ruleEString ) ) otherlv_2= '{' (otherlv_3= 'description' ( (lv_description_4_0= ruleEString ) ) )? otherlv_5= 'table' ( ( ruleEString ) ) otherlv_7= 'sourceA' ( ( ruleEString ) ) otherlv_9= 'sourceB' ( ( ruleEString ) ) otherlv_11= 'resultColumn' ( ( ruleEString ) ) otherlv_13= 'resultTable' ( ( ruleEString ) ) otherlv_15= 'next' ( ( ruleEString ) ) otherlv_17= '}' ) ;
    public final EObject ruleConcat() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        Token otherlv_9=null;
        Token otherlv_11=null;
        Token otherlv_13=null;
        Token otherlv_15=null;
        Token otherlv_17=null;
        AntlrDatatypeRuleToken lv_name_1_0 = null;

        AntlrDatatypeRuleToken lv_description_4_0 = null;



        	enterRule();

        try {
            // InternalMyDsl.g:2319:2: ( (otherlv_0= 'Concat' ( (lv_name_1_0= ruleEString ) ) otherlv_2= '{' (otherlv_3= 'description' ( (lv_description_4_0= ruleEString ) ) )? otherlv_5= 'table' ( ( ruleEString ) ) otherlv_7= 'sourceA' ( ( ruleEString ) ) otherlv_9= 'sourceB' ( ( ruleEString ) ) otherlv_11= 'resultColumn' ( ( ruleEString ) ) otherlv_13= 'resultTable' ( ( ruleEString ) ) otherlv_15= 'next' ( ( ruleEString ) ) otherlv_17= '}' ) )
            // InternalMyDsl.g:2320:2: (otherlv_0= 'Concat' ( (lv_name_1_0= ruleEString ) ) otherlv_2= '{' (otherlv_3= 'description' ( (lv_description_4_0= ruleEString ) ) )? otherlv_5= 'table' ( ( ruleEString ) ) otherlv_7= 'sourceA' ( ( ruleEString ) ) otherlv_9= 'sourceB' ( ( ruleEString ) ) otherlv_11= 'resultColumn' ( ( ruleEString ) ) otherlv_13= 'resultTable' ( ( ruleEString ) ) otherlv_15= 'next' ( ( ruleEString ) ) otherlv_17= '}' )
            {
            // InternalMyDsl.g:2320:2: (otherlv_0= 'Concat' ( (lv_name_1_0= ruleEString ) ) otherlv_2= '{' (otherlv_3= 'description' ( (lv_description_4_0= ruleEString ) ) )? otherlv_5= 'table' ( ( ruleEString ) ) otherlv_7= 'sourceA' ( ( ruleEString ) ) otherlv_9= 'sourceB' ( ( ruleEString ) ) otherlv_11= 'resultColumn' ( ( ruleEString ) ) otherlv_13= 'resultTable' ( ( ruleEString ) ) otherlv_15= 'next' ( ( ruleEString ) ) otherlv_17= '}' )
            // InternalMyDsl.g:2321:3: otherlv_0= 'Concat' ( (lv_name_1_0= ruleEString ) ) otherlv_2= '{' (otherlv_3= 'description' ( (lv_description_4_0= ruleEString ) ) )? otherlv_5= 'table' ( ( ruleEString ) ) otherlv_7= 'sourceA' ( ( ruleEString ) ) otherlv_9= 'sourceB' ( ( ruleEString ) ) otherlv_11= 'resultColumn' ( ( ruleEString ) ) otherlv_13= 'resultTable' ( ( ruleEString ) ) otherlv_15= 'next' ( ( ruleEString ) ) otherlv_17= '}'
            {
            otherlv_0=(Token)match(input,48,FOLLOW_6); 

            			newLeafNode(otherlv_0, grammarAccess.getConcatAccess().getConcatKeyword_0());
            		
            // InternalMyDsl.g:2325:3: ( (lv_name_1_0= ruleEString ) )
            // InternalMyDsl.g:2326:4: (lv_name_1_0= ruleEString )
            {
            // InternalMyDsl.g:2326:4: (lv_name_1_0= ruleEString )
            // InternalMyDsl.g:2327:5: lv_name_1_0= ruleEString
            {

            					newCompositeNode(grammarAccess.getConcatAccess().getNameEStringParserRuleCall_1_0());
            				
            pushFollow(FOLLOW_36);
            lv_name_1_0=ruleEString();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getConcatRule());
            					}
            					set(
            						current,
            						"name",
            						lv_name_1_0,
            						"org.xtext.example.mydsl.MyDsl.EString");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_2=(Token)match(input,38,FOLLOW_49); 

            			newLeafNode(otherlv_2, grammarAccess.getConcatAccess().getLeftCurlyBracketKeyword_2());
            		
            // InternalMyDsl.g:2348:3: (otherlv_3= 'description' ( (lv_description_4_0= ruleEString ) ) )?
            int alt21=2;
            int LA21_0 = input.LA(1);

            if ( (LA21_0==17) ) {
                alt21=1;
            }
            switch (alt21) {
                case 1 :
                    // InternalMyDsl.g:2349:4: otherlv_3= 'description' ( (lv_description_4_0= ruleEString ) )
                    {
                    otherlv_3=(Token)match(input,17,FOLLOW_6); 

                    				newLeafNode(otherlv_3, grammarAccess.getConcatAccess().getDescriptionKeyword_3_0());
                    			
                    // InternalMyDsl.g:2353:4: ( (lv_description_4_0= ruleEString ) )
                    // InternalMyDsl.g:2354:5: (lv_description_4_0= ruleEString )
                    {
                    // InternalMyDsl.g:2354:5: (lv_description_4_0= ruleEString )
                    // InternalMyDsl.g:2355:6: lv_description_4_0= ruleEString
                    {

                    						newCompositeNode(grammarAccess.getConcatAccess().getDescriptionEStringParserRuleCall_3_1_0());
                    					
                    pushFollow(FOLLOW_50);
                    lv_description_4_0=ruleEString();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getConcatRule());
                    						}
                    						set(
                    							current,
                    							"description",
                    							lv_description_4_0,
                    							"org.xtext.example.mydsl.MyDsl.EString");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;

            }

            otherlv_5=(Token)match(input,49,FOLLOW_6); 

            			newLeafNode(otherlv_5, grammarAccess.getConcatAccess().getTableKeyword_4());
            		
            // InternalMyDsl.g:2377:3: ( ( ruleEString ) )
            // InternalMyDsl.g:2378:4: ( ruleEString )
            {
            // InternalMyDsl.g:2378:4: ( ruleEString )
            // InternalMyDsl.g:2379:5: ruleEString
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getConcatRule());
            					}
            				

            					newCompositeNode(grammarAccess.getConcatAccess().getTableTableCrossReference_5_0());
            				
            pushFollow(FOLLOW_51);
            ruleEString();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_7=(Token)match(input,50,FOLLOW_6); 

            			newLeafNode(otherlv_7, grammarAccess.getConcatAccess().getSourceAKeyword_6());
            		
            // InternalMyDsl.g:2397:3: ( ( ruleEString ) )
            // InternalMyDsl.g:2398:4: ( ruleEString )
            {
            // InternalMyDsl.g:2398:4: ( ruleEString )
            // InternalMyDsl.g:2399:5: ruleEString
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getConcatRule());
            					}
            				

            					newCompositeNode(grammarAccess.getConcatAccess().getSourceAColumnCrossReference_7_0());
            				
            pushFollow(FOLLOW_52);
            ruleEString();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_9=(Token)match(input,51,FOLLOW_6); 

            			newLeafNode(otherlv_9, grammarAccess.getConcatAccess().getSourceBKeyword_8());
            		
            // InternalMyDsl.g:2417:3: ( ( ruleEString ) )
            // InternalMyDsl.g:2418:4: ( ruleEString )
            {
            // InternalMyDsl.g:2418:4: ( ruleEString )
            // InternalMyDsl.g:2419:5: ruleEString
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getConcatRule());
            					}
            				

            					newCompositeNode(grammarAccess.getConcatAccess().getSourceBColumnCrossReference_9_0());
            				
            pushFollow(FOLLOW_53);
            ruleEString();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_11=(Token)match(input,52,FOLLOW_6); 

            			newLeafNode(otherlv_11, grammarAccess.getConcatAccess().getResultColumnKeyword_10());
            		
            // InternalMyDsl.g:2437:3: ( ( ruleEString ) )
            // InternalMyDsl.g:2438:4: ( ruleEString )
            {
            // InternalMyDsl.g:2438:4: ( ruleEString )
            // InternalMyDsl.g:2439:5: ruleEString
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getConcatRule());
            					}
            				

            					newCompositeNode(grammarAccess.getConcatAccess().getResultColumnColumnCrossReference_11_0());
            				
            pushFollow(FOLLOW_54);
            ruleEString();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_13=(Token)match(input,53,FOLLOW_6); 

            			newLeafNode(otherlv_13, grammarAccess.getConcatAccess().getResultTableKeyword_12());
            		
            // InternalMyDsl.g:2457:3: ( ( ruleEString ) )
            // InternalMyDsl.g:2458:4: ( ruleEString )
            {
            // InternalMyDsl.g:2458:4: ( ruleEString )
            // InternalMyDsl.g:2459:5: ruleEString
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getConcatRule());
            					}
            				

            					newCompositeNode(grammarAccess.getConcatAccess().getResultTableTableCrossReference_13_0());
            				
            pushFollow(FOLLOW_38);
            ruleEString();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_15=(Token)match(input,39,FOLLOW_6); 

            			newLeafNode(otherlv_15, grammarAccess.getConcatAccess().getNextKeyword_14());
            		
            // InternalMyDsl.g:2477:3: ( ( ruleEString ) )
            // InternalMyDsl.g:2478:4: ( ruleEString )
            {
            // InternalMyDsl.g:2478:4: ( ruleEString )
            // InternalMyDsl.g:2479:5: ruleEString
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getConcatRule());
            					}
            				

            					newCompositeNode(grammarAccess.getConcatAccess().getNextStepCrossReference_15_0());
            				
            pushFollow(FOLLOW_39);
            ruleEString();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_17=(Token)match(input,40,FOLLOW_2); 

            			newLeafNode(otherlv_17, grammarAccess.getConcatAccess().getRightCurlyBracketKeyword_16());
            		

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
    // $ANTLR end "ruleConcat"


    // $ANTLR start "entryRuleSplit"
    // InternalMyDsl.g:2501:1: entryRuleSplit returns [EObject current=null] : iv_ruleSplit= ruleSplit EOF ;
    public final EObject entryRuleSplit() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSplit = null;


        try {
            // InternalMyDsl.g:2501:46: (iv_ruleSplit= ruleSplit EOF )
            // InternalMyDsl.g:2502:2: iv_ruleSplit= ruleSplit EOF
            {
             newCompositeNode(grammarAccess.getSplitRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleSplit=ruleSplit();

            state._fsp--;

             current =iv_ruleSplit; 
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
    // $ANTLR end "entryRuleSplit"


    // $ANTLR start "ruleSplit"
    // InternalMyDsl.g:2508:1: ruleSplit returns [EObject current=null] : (otherlv_0= 'Split' ( (lv_name_1_0= ruleEString ) ) otherlv_2= '{' (otherlv_3= 'description' ( (lv_description_4_0= ruleEString ) ) )? otherlv_5= 'table' ( ( ruleEString ) ) otherlv_7= 'source' ( ( ruleEString ) ) otherlv_9= 'delimiter' ( (lv_delimiter_10_0= ruleEString ) ) otherlv_11= 'atCharIndex' ( (lv_atCharIndex_12_0= ruleEIntegerObject ) ) otherlv_13= 'resultColumnA' ( ( ruleEString ) ) otherlv_15= 'resultColumnB' ( ( ruleEString ) ) otherlv_17= 'resultTable' ( ( ruleEString ) ) otherlv_19= 'next' ( ( ruleEString ) ) otherlv_21= '}' ) ;
    public final EObject ruleSplit() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        Token otherlv_9=null;
        Token otherlv_11=null;
        Token otherlv_13=null;
        Token otherlv_15=null;
        Token otherlv_17=null;
        Token otherlv_19=null;
        Token otherlv_21=null;
        AntlrDatatypeRuleToken lv_name_1_0 = null;

        AntlrDatatypeRuleToken lv_description_4_0 = null;

        AntlrDatatypeRuleToken lv_delimiter_10_0 = null;

        AntlrDatatypeRuleToken lv_atCharIndex_12_0 = null;



        	enterRule();

        try {
            // InternalMyDsl.g:2514:2: ( (otherlv_0= 'Split' ( (lv_name_1_0= ruleEString ) ) otherlv_2= '{' (otherlv_3= 'description' ( (lv_description_4_0= ruleEString ) ) )? otherlv_5= 'table' ( ( ruleEString ) ) otherlv_7= 'source' ( ( ruleEString ) ) otherlv_9= 'delimiter' ( (lv_delimiter_10_0= ruleEString ) ) otherlv_11= 'atCharIndex' ( (lv_atCharIndex_12_0= ruleEIntegerObject ) ) otherlv_13= 'resultColumnA' ( ( ruleEString ) ) otherlv_15= 'resultColumnB' ( ( ruleEString ) ) otherlv_17= 'resultTable' ( ( ruleEString ) ) otherlv_19= 'next' ( ( ruleEString ) ) otherlv_21= '}' ) )
            // InternalMyDsl.g:2515:2: (otherlv_0= 'Split' ( (lv_name_1_0= ruleEString ) ) otherlv_2= '{' (otherlv_3= 'description' ( (lv_description_4_0= ruleEString ) ) )? otherlv_5= 'table' ( ( ruleEString ) ) otherlv_7= 'source' ( ( ruleEString ) ) otherlv_9= 'delimiter' ( (lv_delimiter_10_0= ruleEString ) ) otherlv_11= 'atCharIndex' ( (lv_atCharIndex_12_0= ruleEIntegerObject ) ) otherlv_13= 'resultColumnA' ( ( ruleEString ) ) otherlv_15= 'resultColumnB' ( ( ruleEString ) ) otherlv_17= 'resultTable' ( ( ruleEString ) ) otherlv_19= 'next' ( ( ruleEString ) ) otherlv_21= '}' )
            {
            // InternalMyDsl.g:2515:2: (otherlv_0= 'Split' ( (lv_name_1_0= ruleEString ) ) otherlv_2= '{' (otherlv_3= 'description' ( (lv_description_4_0= ruleEString ) ) )? otherlv_5= 'table' ( ( ruleEString ) ) otherlv_7= 'source' ( ( ruleEString ) ) otherlv_9= 'delimiter' ( (lv_delimiter_10_0= ruleEString ) ) otherlv_11= 'atCharIndex' ( (lv_atCharIndex_12_0= ruleEIntegerObject ) ) otherlv_13= 'resultColumnA' ( ( ruleEString ) ) otherlv_15= 'resultColumnB' ( ( ruleEString ) ) otherlv_17= 'resultTable' ( ( ruleEString ) ) otherlv_19= 'next' ( ( ruleEString ) ) otherlv_21= '}' )
            // InternalMyDsl.g:2516:3: otherlv_0= 'Split' ( (lv_name_1_0= ruleEString ) ) otherlv_2= '{' (otherlv_3= 'description' ( (lv_description_4_0= ruleEString ) ) )? otherlv_5= 'table' ( ( ruleEString ) ) otherlv_7= 'source' ( ( ruleEString ) ) otherlv_9= 'delimiter' ( (lv_delimiter_10_0= ruleEString ) ) otherlv_11= 'atCharIndex' ( (lv_atCharIndex_12_0= ruleEIntegerObject ) ) otherlv_13= 'resultColumnA' ( ( ruleEString ) ) otherlv_15= 'resultColumnB' ( ( ruleEString ) ) otherlv_17= 'resultTable' ( ( ruleEString ) ) otherlv_19= 'next' ( ( ruleEString ) ) otherlv_21= '}'
            {
            otherlv_0=(Token)match(input,54,FOLLOW_6); 

            			newLeafNode(otherlv_0, grammarAccess.getSplitAccess().getSplitKeyword_0());
            		
            // InternalMyDsl.g:2520:3: ( (lv_name_1_0= ruleEString ) )
            // InternalMyDsl.g:2521:4: (lv_name_1_0= ruleEString )
            {
            // InternalMyDsl.g:2521:4: (lv_name_1_0= ruleEString )
            // InternalMyDsl.g:2522:5: lv_name_1_0= ruleEString
            {

            					newCompositeNode(grammarAccess.getSplitAccess().getNameEStringParserRuleCall_1_0());
            				
            pushFollow(FOLLOW_36);
            lv_name_1_0=ruleEString();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getSplitRule());
            					}
            					set(
            						current,
            						"name",
            						lv_name_1_0,
            						"org.xtext.example.mydsl.MyDsl.EString");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_2=(Token)match(input,38,FOLLOW_49); 

            			newLeafNode(otherlv_2, grammarAccess.getSplitAccess().getLeftCurlyBracketKeyword_2());
            		
            // InternalMyDsl.g:2543:3: (otherlv_3= 'description' ( (lv_description_4_0= ruleEString ) ) )?
            int alt22=2;
            int LA22_0 = input.LA(1);

            if ( (LA22_0==17) ) {
                alt22=1;
            }
            switch (alt22) {
                case 1 :
                    // InternalMyDsl.g:2544:4: otherlv_3= 'description' ( (lv_description_4_0= ruleEString ) )
                    {
                    otherlv_3=(Token)match(input,17,FOLLOW_6); 

                    				newLeafNode(otherlv_3, grammarAccess.getSplitAccess().getDescriptionKeyword_3_0());
                    			
                    // InternalMyDsl.g:2548:4: ( (lv_description_4_0= ruleEString ) )
                    // InternalMyDsl.g:2549:5: (lv_description_4_0= ruleEString )
                    {
                    // InternalMyDsl.g:2549:5: (lv_description_4_0= ruleEString )
                    // InternalMyDsl.g:2550:6: lv_description_4_0= ruleEString
                    {

                    						newCompositeNode(grammarAccess.getSplitAccess().getDescriptionEStringParserRuleCall_3_1_0());
                    					
                    pushFollow(FOLLOW_50);
                    lv_description_4_0=ruleEString();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getSplitRule());
                    						}
                    						set(
                    							current,
                    							"description",
                    							lv_description_4_0,
                    							"org.xtext.example.mydsl.MyDsl.EString");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;

            }

            otherlv_5=(Token)match(input,49,FOLLOW_6); 

            			newLeafNode(otherlv_5, grammarAccess.getSplitAccess().getTableKeyword_4());
            		
            // InternalMyDsl.g:2572:3: ( ( ruleEString ) )
            // InternalMyDsl.g:2573:4: ( ruleEString )
            {
            // InternalMyDsl.g:2573:4: ( ruleEString )
            // InternalMyDsl.g:2574:5: ruleEString
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getSplitRule());
            					}
            				

            					newCompositeNode(grammarAccess.getSplitAccess().getTableTableCrossReference_5_0());
            				
            pushFollow(FOLLOW_55);
            ruleEString();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_7=(Token)match(input,55,FOLLOW_6); 

            			newLeafNode(otherlv_7, grammarAccess.getSplitAccess().getSourceKeyword_6());
            		
            // InternalMyDsl.g:2592:3: ( ( ruleEString ) )
            // InternalMyDsl.g:2593:4: ( ruleEString )
            {
            // InternalMyDsl.g:2593:4: ( ruleEString )
            // InternalMyDsl.g:2594:5: ruleEString
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getSplitRule());
            					}
            				

            					newCompositeNode(grammarAccess.getSplitAccess().getSourceColumnCrossReference_7_0());
            				
            pushFollow(FOLLOW_56);
            ruleEString();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_9=(Token)match(input,56,FOLLOW_6); 

            			newLeafNode(otherlv_9, grammarAccess.getSplitAccess().getDelimiterKeyword_8());
            		
            // InternalMyDsl.g:2612:3: ( (lv_delimiter_10_0= ruleEString ) )
            // InternalMyDsl.g:2613:4: (lv_delimiter_10_0= ruleEString )
            {
            // InternalMyDsl.g:2613:4: (lv_delimiter_10_0= ruleEString )
            // InternalMyDsl.g:2614:5: lv_delimiter_10_0= ruleEString
            {

            					newCompositeNode(grammarAccess.getSplitAccess().getDelimiterEStringParserRuleCall_9_0());
            				
            pushFollow(FOLLOW_57);
            lv_delimiter_10_0=ruleEString();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getSplitRule());
            					}
            					set(
            						current,
            						"delimiter",
            						lv_delimiter_10_0,
            						"org.xtext.example.mydsl.MyDsl.EString");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_11=(Token)match(input,57,FOLLOW_58); 

            			newLeafNode(otherlv_11, grammarAccess.getSplitAccess().getAtCharIndexKeyword_10());
            		
            // InternalMyDsl.g:2635:3: ( (lv_atCharIndex_12_0= ruleEIntegerObject ) )
            // InternalMyDsl.g:2636:4: (lv_atCharIndex_12_0= ruleEIntegerObject )
            {
            // InternalMyDsl.g:2636:4: (lv_atCharIndex_12_0= ruleEIntegerObject )
            // InternalMyDsl.g:2637:5: lv_atCharIndex_12_0= ruleEIntegerObject
            {

            					newCompositeNode(grammarAccess.getSplitAccess().getAtCharIndexEIntegerObjectParserRuleCall_11_0());
            				
            pushFollow(FOLLOW_59);
            lv_atCharIndex_12_0=ruleEIntegerObject();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getSplitRule());
            					}
            					set(
            						current,
            						"atCharIndex",
            						lv_atCharIndex_12_0,
            						"org.xtext.example.mydsl.MyDsl.EIntegerObject");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_13=(Token)match(input,58,FOLLOW_6); 

            			newLeafNode(otherlv_13, grammarAccess.getSplitAccess().getResultColumnAKeyword_12());
            		
            // InternalMyDsl.g:2658:3: ( ( ruleEString ) )
            // InternalMyDsl.g:2659:4: ( ruleEString )
            {
            // InternalMyDsl.g:2659:4: ( ruleEString )
            // InternalMyDsl.g:2660:5: ruleEString
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getSplitRule());
            					}
            				

            					newCompositeNode(grammarAccess.getSplitAccess().getResultColumnAColumnCrossReference_13_0());
            				
            pushFollow(FOLLOW_60);
            ruleEString();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_15=(Token)match(input,59,FOLLOW_6); 

            			newLeafNode(otherlv_15, grammarAccess.getSplitAccess().getResultColumnBKeyword_14());
            		
            // InternalMyDsl.g:2678:3: ( ( ruleEString ) )
            // InternalMyDsl.g:2679:4: ( ruleEString )
            {
            // InternalMyDsl.g:2679:4: ( ruleEString )
            // InternalMyDsl.g:2680:5: ruleEString
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getSplitRule());
            					}
            				

            					newCompositeNode(grammarAccess.getSplitAccess().getResultColumnBColumnCrossReference_15_0());
            				
            pushFollow(FOLLOW_54);
            ruleEString();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_17=(Token)match(input,53,FOLLOW_6); 

            			newLeafNode(otherlv_17, grammarAccess.getSplitAccess().getResultTableKeyword_16());
            		
            // InternalMyDsl.g:2698:3: ( ( ruleEString ) )
            // InternalMyDsl.g:2699:4: ( ruleEString )
            {
            // InternalMyDsl.g:2699:4: ( ruleEString )
            // InternalMyDsl.g:2700:5: ruleEString
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getSplitRule());
            					}
            				

            					newCompositeNode(grammarAccess.getSplitAccess().getResultTableTableCrossReference_17_0());
            				
            pushFollow(FOLLOW_38);
            ruleEString();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_19=(Token)match(input,39,FOLLOW_6); 

            			newLeafNode(otherlv_19, grammarAccess.getSplitAccess().getNextKeyword_18());
            		
            // InternalMyDsl.g:2718:3: ( ( ruleEString ) )
            // InternalMyDsl.g:2719:4: ( ruleEString )
            {
            // InternalMyDsl.g:2719:4: ( ruleEString )
            // InternalMyDsl.g:2720:5: ruleEString
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getSplitRule());
            					}
            				

            					newCompositeNode(grammarAccess.getSplitAccess().getNextStepCrossReference_19_0());
            				
            pushFollow(FOLLOW_39);
            ruleEString();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_21=(Token)match(input,40,FOLLOW_2); 

            			newLeafNode(otherlv_21, grammarAccess.getSplitAccess().getRightCurlyBracketKeyword_20());
            		

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
    // $ANTLR end "ruleSplit"


    // $ANTLR start "entryRuleExtract"
    // InternalMyDsl.g:2742:1: entryRuleExtract returns [EObject current=null] : iv_ruleExtract= ruleExtract EOF ;
    public final EObject entryRuleExtract() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExtract = null;


        try {
            // InternalMyDsl.g:2742:48: (iv_ruleExtract= ruleExtract EOF )
            // InternalMyDsl.g:2743:2: iv_ruleExtract= ruleExtract EOF
            {
             newCompositeNode(grammarAccess.getExtractRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleExtract=ruleExtract();

            state._fsp--;

             current =iv_ruleExtract; 
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
    // $ANTLR end "entryRuleExtract"


    // $ANTLR start "ruleExtract"
    // InternalMyDsl.g:2749:1: ruleExtract returns [EObject current=null] : (otherlv_0= 'Extract' ( (lv_name_1_0= ruleEString ) ) otherlv_2= '{' (otherlv_3= 'description' ( (lv_description_4_0= ruleEString ) ) )? otherlv_5= 'table' ( ( ruleEString ) ) otherlv_7= 'column' ( ( ruleEString ) ) otherlv_9= 'lbChar' ( (lv_lbChar_10_0= ruleEIntegerObject ) ) otherlv_11= 'ubChar' ( (lv_ubChar_12_0= ruleEIntegerObject ) ) otherlv_13= 'pattern' ( (lv_pattern_14_0= ruleEString ) ) otherlv_15= 'next' ( ( ruleEString ) ) otherlv_17= '}' ) ;
    public final EObject ruleExtract() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        Token otherlv_9=null;
        Token otherlv_11=null;
        Token otherlv_13=null;
        Token otherlv_15=null;
        Token otherlv_17=null;
        AntlrDatatypeRuleToken lv_name_1_0 = null;

        AntlrDatatypeRuleToken lv_description_4_0 = null;

        AntlrDatatypeRuleToken lv_lbChar_10_0 = null;

        AntlrDatatypeRuleToken lv_ubChar_12_0 = null;

        AntlrDatatypeRuleToken lv_pattern_14_0 = null;



        	enterRule();

        try {
            // InternalMyDsl.g:2755:2: ( (otherlv_0= 'Extract' ( (lv_name_1_0= ruleEString ) ) otherlv_2= '{' (otherlv_3= 'description' ( (lv_description_4_0= ruleEString ) ) )? otherlv_5= 'table' ( ( ruleEString ) ) otherlv_7= 'column' ( ( ruleEString ) ) otherlv_9= 'lbChar' ( (lv_lbChar_10_0= ruleEIntegerObject ) ) otherlv_11= 'ubChar' ( (lv_ubChar_12_0= ruleEIntegerObject ) ) otherlv_13= 'pattern' ( (lv_pattern_14_0= ruleEString ) ) otherlv_15= 'next' ( ( ruleEString ) ) otherlv_17= '}' ) )
            // InternalMyDsl.g:2756:2: (otherlv_0= 'Extract' ( (lv_name_1_0= ruleEString ) ) otherlv_2= '{' (otherlv_3= 'description' ( (lv_description_4_0= ruleEString ) ) )? otherlv_5= 'table' ( ( ruleEString ) ) otherlv_7= 'column' ( ( ruleEString ) ) otherlv_9= 'lbChar' ( (lv_lbChar_10_0= ruleEIntegerObject ) ) otherlv_11= 'ubChar' ( (lv_ubChar_12_0= ruleEIntegerObject ) ) otherlv_13= 'pattern' ( (lv_pattern_14_0= ruleEString ) ) otherlv_15= 'next' ( ( ruleEString ) ) otherlv_17= '}' )
            {
            // InternalMyDsl.g:2756:2: (otherlv_0= 'Extract' ( (lv_name_1_0= ruleEString ) ) otherlv_2= '{' (otherlv_3= 'description' ( (lv_description_4_0= ruleEString ) ) )? otherlv_5= 'table' ( ( ruleEString ) ) otherlv_7= 'column' ( ( ruleEString ) ) otherlv_9= 'lbChar' ( (lv_lbChar_10_0= ruleEIntegerObject ) ) otherlv_11= 'ubChar' ( (lv_ubChar_12_0= ruleEIntegerObject ) ) otherlv_13= 'pattern' ( (lv_pattern_14_0= ruleEString ) ) otherlv_15= 'next' ( ( ruleEString ) ) otherlv_17= '}' )
            // InternalMyDsl.g:2757:3: otherlv_0= 'Extract' ( (lv_name_1_0= ruleEString ) ) otherlv_2= '{' (otherlv_3= 'description' ( (lv_description_4_0= ruleEString ) ) )? otherlv_5= 'table' ( ( ruleEString ) ) otherlv_7= 'column' ( ( ruleEString ) ) otherlv_9= 'lbChar' ( (lv_lbChar_10_0= ruleEIntegerObject ) ) otherlv_11= 'ubChar' ( (lv_ubChar_12_0= ruleEIntegerObject ) ) otherlv_13= 'pattern' ( (lv_pattern_14_0= ruleEString ) ) otherlv_15= 'next' ( ( ruleEString ) ) otherlv_17= '}'
            {
            otherlv_0=(Token)match(input,60,FOLLOW_6); 

            			newLeafNode(otherlv_0, grammarAccess.getExtractAccess().getExtractKeyword_0());
            		
            // InternalMyDsl.g:2761:3: ( (lv_name_1_0= ruleEString ) )
            // InternalMyDsl.g:2762:4: (lv_name_1_0= ruleEString )
            {
            // InternalMyDsl.g:2762:4: (lv_name_1_0= ruleEString )
            // InternalMyDsl.g:2763:5: lv_name_1_0= ruleEString
            {

            					newCompositeNode(grammarAccess.getExtractAccess().getNameEStringParserRuleCall_1_0());
            				
            pushFollow(FOLLOW_36);
            lv_name_1_0=ruleEString();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getExtractRule());
            					}
            					set(
            						current,
            						"name",
            						lv_name_1_0,
            						"org.xtext.example.mydsl.MyDsl.EString");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_2=(Token)match(input,38,FOLLOW_49); 

            			newLeafNode(otherlv_2, grammarAccess.getExtractAccess().getLeftCurlyBracketKeyword_2());
            		
            // InternalMyDsl.g:2784:3: (otherlv_3= 'description' ( (lv_description_4_0= ruleEString ) ) )?
            int alt23=2;
            int LA23_0 = input.LA(1);

            if ( (LA23_0==17) ) {
                alt23=1;
            }
            switch (alt23) {
                case 1 :
                    // InternalMyDsl.g:2785:4: otherlv_3= 'description' ( (lv_description_4_0= ruleEString ) )
                    {
                    otherlv_3=(Token)match(input,17,FOLLOW_6); 

                    				newLeafNode(otherlv_3, grammarAccess.getExtractAccess().getDescriptionKeyword_3_0());
                    			
                    // InternalMyDsl.g:2789:4: ( (lv_description_4_0= ruleEString ) )
                    // InternalMyDsl.g:2790:5: (lv_description_4_0= ruleEString )
                    {
                    // InternalMyDsl.g:2790:5: (lv_description_4_0= ruleEString )
                    // InternalMyDsl.g:2791:6: lv_description_4_0= ruleEString
                    {

                    						newCompositeNode(grammarAccess.getExtractAccess().getDescriptionEStringParserRuleCall_3_1_0());
                    					
                    pushFollow(FOLLOW_50);
                    lv_description_4_0=ruleEString();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getExtractRule());
                    						}
                    						set(
                    							current,
                    							"description",
                    							lv_description_4_0,
                    							"org.xtext.example.mydsl.MyDsl.EString");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;

            }

            otherlv_5=(Token)match(input,49,FOLLOW_6); 

            			newLeafNode(otherlv_5, grammarAccess.getExtractAccess().getTableKeyword_4());
            		
            // InternalMyDsl.g:2813:3: ( ( ruleEString ) )
            // InternalMyDsl.g:2814:4: ( ruleEString )
            {
            // InternalMyDsl.g:2814:4: ( ruleEString )
            // InternalMyDsl.g:2815:5: ruleEString
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getExtractRule());
            					}
            				

            					newCompositeNode(grammarAccess.getExtractAccess().getTableTableCrossReference_5_0());
            				
            pushFollow(FOLLOW_61);
            ruleEString();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_7=(Token)match(input,61,FOLLOW_6); 

            			newLeafNode(otherlv_7, grammarAccess.getExtractAccess().getColumnKeyword_6());
            		
            // InternalMyDsl.g:2833:3: ( ( ruleEString ) )
            // InternalMyDsl.g:2834:4: ( ruleEString )
            {
            // InternalMyDsl.g:2834:4: ( ruleEString )
            // InternalMyDsl.g:2835:5: ruleEString
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getExtractRule());
            					}
            				

            					newCompositeNode(grammarAccess.getExtractAccess().getColumnColumnCrossReference_7_0());
            				
            pushFollow(FOLLOW_62);
            ruleEString();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_9=(Token)match(input,62,FOLLOW_58); 

            			newLeafNode(otherlv_9, grammarAccess.getExtractAccess().getLbCharKeyword_8());
            		
            // InternalMyDsl.g:2853:3: ( (lv_lbChar_10_0= ruleEIntegerObject ) )
            // InternalMyDsl.g:2854:4: (lv_lbChar_10_0= ruleEIntegerObject )
            {
            // InternalMyDsl.g:2854:4: (lv_lbChar_10_0= ruleEIntegerObject )
            // InternalMyDsl.g:2855:5: lv_lbChar_10_0= ruleEIntegerObject
            {

            					newCompositeNode(grammarAccess.getExtractAccess().getLbCharEIntegerObjectParserRuleCall_9_0());
            				
            pushFollow(FOLLOW_63);
            lv_lbChar_10_0=ruleEIntegerObject();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getExtractRule());
            					}
            					set(
            						current,
            						"lbChar",
            						lv_lbChar_10_0,
            						"org.xtext.example.mydsl.MyDsl.EIntegerObject");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_11=(Token)match(input,63,FOLLOW_58); 

            			newLeafNode(otherlv_11, grammarAccess.getExtractAccess().getUbCharKeyword_10());
            		
            // InternalMyDsl.g:2876:3: ( (lv_ubChar_12_0= ruleEIntegerObject ) )
            // InternalMyDsl.g:2877:4: (lv_ubChar_12_0= ruleEIntegerObject )
            {
            // InternalMyDsl.g:2877:4: (lv_ubChar_12_0= ruleEIntegerObject )
            // InternalMyDsl.g:2878:5: lv_ubChar_12_0= ruleEIntegerObject
            {

            					newCompositeNode(grammarAccess.getExtractAccess().getUbCharEIntegerObjectParserRuleCall_11_0());
            				
            pushFollow(FOLLOW_64);
            lv_ubChar_12_0=ruleEIntegerObject();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getExtractRule());
            					}
            					set(
            						current,
            						"ubChar",
            						lv_ubChar_12_0,
            						"org.xtext.example.mydsl.MyDsl.EIntegerObject");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_13=(Token)match(input,64,FOLLOW_6); 

            			newLeafNode(otherlv_13, grammarAccess.getExtractAccess().getPatternKeyword_12());
            		
            // InternalMyDsl.g:2899:3: ( (lv_pattern_14_0= ruleEString ) )
            // InternalMyDsl.g:2900:4: (lv_pattern_14_0= ruleEString )
            {
            // InternalMyDsl.g:2900:4: (lv_pattern_14_0= ruleEString )
            // InternalMyDsl.g:2901:5: lv_pattern_14_0= ruleEString
            {

            					newCompositeNode(grammarAccess.getExtractAccess().getPatternEStringParserRuleCall_13_0());
            				
            pushFollow(FOLLOW_38);
            lv_pattern_14_0=ruleEString();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getExtractRule());
            					}
            					set(
            						current,
            						"pattern",
            						lv_pattern_14_0,
            						"org.xtext.example.mydsl.MyDsl.EString");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_15=(Token)match(input,39,FOLLOW_6); 

            			newLeafNode(otherlv_15, grammarAccess.getExtractAccess().getNextKeyword_14());
            		
            // InternalMyDsl.g:2922:3: ( ( ruleEString ) )
            // InternalMyDsl.g:2923:4: ( ruleEString )
            {
            // InternalMyDsl.g:2923:4: ( ruleEString )
            // InternalMyDsl.g:2924:5: ruleEString
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getExtractRule());
            					}
            				

            					newCompositeNode(grammarAccess.getExtractAccess().getNextStepCrossReference_15_0());
            				
            pushFollow(FOLLOW_39);
            ruleEString();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_17=(Token)match(input,40,FOLLOW_2); 

            			newLeafNode(otherlv_17, grammarAccess.getExtractAccess().getRightCurlyBracketKeyword_16());
            		

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
    // $ANTLR end "ruleExtract"


    // $ANTLR start "entryRuleTableToSave"
    // InternalMyDsl.g:2946:1: entryRuleTableToSave returns [EObject current=null] : iv_ruleTableToSave= ruleTableToSave EOF ;
    public final EObject entryRuleTableToSave() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTableToSave = null;


        try {
            // InternalMyDsl.g:2946:52: (iv_ruleTableToSave= ruleTableToSave EOF )
            // InternalMyDsl.g:2947:2: iv_ruleTableToSave= ruleTableToSave EOF
            {
             newCompositeNode(grammarAccess.getTableToSaveRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleTableToSave=ruleTableToSave();

            state._fsp--;

             current =iv_ruleTableToSave; 
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
    // $ANTLR end "entryRuleTableToSave"


    // $ANTLR start "ruleTableToSave"
    // InternalMyDsl.g:2953:1: ruleTableToSave returns [EObject current=null] : ( ( ( ruleEString ) ) otherlv_1= '(' ( (lv_columnsNames_2_0= ruleEString ) ) (otherlv_3= ',' ( (lv_columnsNames_4_0= ruleEString ) ) )* otherlv_5= ')' otherlv_6= 'TO' ( (lv_path_7_0= ruleEString ) ) ) ;
    public final EObject ruleTableToSave() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Token otherlv_6=null;
        AntlrDatatypeRuleToken lv_columnsNames_2_0 = null;

        AntlrDatatypeRuleToken lv_columnsNames_4_0 = null;

        AntlrDatatypeRuleToken lv_path_7_0 = null;



        	enterRule();

        try {
            // InternalMyDsl.g:2959:2: ( ( ( ( ruleEString ) ) otherlv_1= '(' ( (lv_columnsNames_2_0= ruleEString ) ) (otherlv_3= ',' ( (lv_columnsNames_4_0= ruleEString ) ) )* otherlv_5= ')' otherlv_6= 'TO' ( (lv_path_7_0= ruleEString ) ) ) )
            // InternalMyDsl.g:2960:2: ( ( ( ruleEString ) ) otherlv_1= '(' ( (lv_columnsNames_2_0= ruleEString ) ) (otherlv_3= ',' ( (lv_columnsNames_4_0= ruleEString ) ) )* otherlv_5= ')' otherlv_6= 'TO' ( (lv_path_7_0= ruleEString ) ) )
            {
            // InternalMyDsl.g:2960:2: ( ( ( ruleEString ) ) otherlv_1= '(' ( (lv_columnsNames_2_0= ruleEString ) ) (otherlv_3= ',' ( (lv_columnsNames_4_0= ruleEString ) ) )* otherlv_5= ')' otherlv_6= 'TO' ( (lv_path_7_0= ruleEString ) ) )
            // InternalMyDsl.g:2961:3: ( ( ruleEString ) ) otherlv_1= '(' ( (lv_columnsNames_2_0= ruleEString ) ) (otherlv_3= ',' ( (lv_columnsNames_4_0= ruleEString ) ) )* otherlv_5= ')' otherlv_6= 'TO' ( (lv_path_7_0= ruleEString ) )
            {
            // InternalMyDsl.g:2961:3: ( ( ruleEString ) )
            // InternalMyDsl.g:2962:4: ( ruleEString )
            {
            // InternalMyDsl.g:2962:4: ( ruleEString )
            // InternalMyDsl.g:2963:5: ruleEString
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getTableToSaveRule());
            					}
            				

            					newCompositeNode(grammarAccess.getTableToSaveAccess().getTableTableCrossReference_0_0());
            				
            pushFollow(FOLLOW_19);
            ruleEString();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_1=(Token)match(input,21,FOLLOW_6); 

            			newLeafNode(otherlv_1, grammarAccess.getTableToSaveAccess().getLeftParenthesisKeyword_1());
            		
            // InternalMyDsl.g:2981:3: ( (lv_columnsNames_2_0= ruleEString ) )
            // InternalMyDsl.g:2982:4: (lv_columnsNames_2_0= ruleEString )
            {
            // InternalMyDsl.g:2982:4: (lv_columnsNames_2_0= ruleEString )
            // InternalMyDsl.g:2983:5: lv_columnsNames_2_0= ruleEString
            {

            					newCompositeNode(grammarAccess.getTableToSaveAccess().getColumnsNamesEStringParserRuleCall_2_0());
            				
            pushFollow(FOLLOW_20);
            lv_columnsNames_2_0=ruleEString();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getTableToSaveRule());
            					}
            					add(
            						current,
            						"columnsNames",
            						lv_columnsNames_2_0,
            						"org.xtext.example.mydsl.MyDsl.EString");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalMyDsl.g:3000:3: (otherlv_3= ',' ( (lv_columnsNames_4_0= ruleEString ) ) )*
            loop24:
            do {
                int alt24=2;
                int LA24_0 = input.LA(1);

                if ( (LA24_0==22) ) {
                    alt24=1;
                }


                switch (alt24) {
            	case 1 :
            	    // InternalMyDsl.g:3001:4: otherlv_3= ',' ( (lv_columnsNames_4_0= ruleEString ) )
            	    {
            	    otherlv_3=(Token)match(input,22,FOLLOW_6); 

            	    				newLeafNode(otherlv_3, grammarAccess.getTableToSaveAccess().getCommaKeyword_3_0());
            	    			
            	    // InternalMyDsl.g:3005:4: ( (lv_columnsNames_4_0= ruleEString ) )
            	    // InternalMyDsl.g:3006:5: (lv_columnsNames_4_0= ruleEString )
            	    {
            	    // InternalMyDsl.g:3006:5: (lv_columnsNames_4_0= ruleEString )
            	    // InternalMyDsl.g:3007:6: lv_columnsNames_4_0= ruleEString
            	    {

            	    						newCompositeNode(grammarAccess.getTableToSaveAccess().getColumnsNamesEStringParserRuleCall_3_1_0());
            	    					
            	    pushFollow(FOLLOW_20);
            	    lv_columnsNames_4_0=ruleEString();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getTableToSaveRule());
            	    						}
            	    						add(
            	    							current,
            	    							"columnsNames",
            	    							lv_columnsNames_4_0,
            	    							"org.xtext.example.mydsl.MyDsl.EString");
            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop24;
                }
            } while (true);

            otherlv_5=(Token)match(input,23,FOLLOW_30); 

            			newLeafNode(otherlv_5, grammarAccess.getTableToSaveAccess().getRightParenthesisKeyword_4());
            		
            otherlv_6=(Token)match(input,31,FOLLOW_6); 

            			newLeafNode(otherlv_6, grammarAccess.getTableToSaveAccess().getTOKeyword_5());
            		
            // InternalMyDsl.g:3033:3: ( (lv_path_7_0= ruleEString ) )
            // InternalMyDsl.g:3034:4: (lv_path_7_0= ruleEString )
            {
            // InternalMyDsl.g:3034:4: (lv_path_7_0= ruleEString )
            // InternalMyDsl.g:3035:5: lv_path_7_0= ruleEString
            {

            					newCompositeNode(grammarAccess.getTableToSaveAccess().getPathEStringParserRuleCall_6_0());
            				
            pushFollow(FOLLOW_2);
            lv_path_7_0=ruleEString();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getTableToSaveRule());
            					}
            					set(
            						current,
            						"path",
            						lv_path_7_0,
            						"org.xtext.example.mydsl.MyDsl.EString");
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
    // $ANTLR end "ruleTableToSave"


    // $ANTLR start "entryRuleAssociation"
    // InternalMyDsl.g:3056:1: entryRuleAssociation returns [EObject current=null] : iv_ruleAssociation= ruleAssociation EOF ;
    public final EObject entryRuleAssociation() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAssociation = null;


        try {
            // InternalMyDsl.g:3056:52: (iv_ruleAssociation= ruleAssociation EOF )
            // InternalMyDsl.g:3057:2: iv_ruleAssociation= ruleAssociation EOF
            {
             newCompositeNode(grammarAccess.getAssociationRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleAssociation=ruleAssociation();

            state._fsp--;

             current =iv_ruleAssociation; 
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
    // $ANTLR end "entryRuleAssociation"


    // $ANTLR start "ruleAssociation"
    // InternalMyDsl.g:3063:1: ruleAssociation returns [EObject current=null] : ( ( ( ruleEString ) ) otherlv_1= 'TO' ( ( ruleEString ) ) ) ;
    public final EObject ruleAssociation() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;


        	enterRule();

        try {
            // InternalMyDsl.g:3069:2: ( ( ( ( ruleEString ) ) otherlv_1= 'TO' ( ( ruleEString ) ) ) )
            // InternalMyDsl.g:3070:2: ( ( ( ruleEString ) ) otherlv_1= 'TO' ( ( ruleEString ) ) )
            {
            // InternalMyDsl.g:3070:2: ( ( ( ruleEString ) ) otherlv_1= 'TO' ( ( ruleEString ) ) )
            // InternalMyDsl.g:3071:3: ( ( ruleEString ) ) otherlv_1= 'TO' ( ( ruleEString ) )
            {
            // InternalMyDsl.g:3071:3: ( ( ruleEString ) )
            // InternalMyDsl.g:3072:4: ( ruleEString )
            {
            // InternalMyDsl.g:3072:4: ( ruleEString )
            // InternalMyDsl.g:3073:5: ruleEString
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getAssociationRule());
            					}
            				

            					newCompositeNode(grammarAccess.getAssociationAccess().getOriginColColumnCrossReference_0_0());
            				
            pushFollow(FOLLOW_30);
            ruleEString();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_1=(Token)match(input,31,FOLLOW_6); 

            			newLeafNode(otherlv_1, grammarAccess.getAssociationAccess().getTOKeyword_1());
            		
            // InternalMyDsl.g:3091:3: ( ( ruleEString ) )
            // InternalMyDsl.g:3092:4: ( ruleEString )
            {
            // InternalMyDsl.g:3092:4: ( ruleEString )
            // InternalMyDsl.g:3093:5: ruleEString
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getAssociationRule());
            					}
            				

            					newCompositeNode(grammarAccess.getAssociationAccess().getDestinColColumnCrossReference_2_0());
            				
            pushFollow(FOLLOW_2);
            ruleEString();

            state._fsp--;


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
    // $ANTLR end "ruleAssociation"


    // $ANTLR start "entryRuleTableToImport"
    // InternalMyDsl.g:3111:1: entryRuleTableToImport returns [EObject current=null] : iv_ruleTableToImport= ruleTableToImport EOF ;
    public final EObject entryRuleTableToImport() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTableToImport = null;


        try {
            // InternalMyDsl.g:3111:54: (iv_ruleTableToImport= ruleTableToImport EOF )
            // InternalMyDsl.g:3112:2: iv_ruleTableToImport= ruleTableToImport EOF
            {
             newCompositeNode(grammarAccess.getTableToImportRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleTableToImport=ruleTableToImport();

            state._fsp--;

             current =iv_ruleTableToImport; 
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
    // $ANTLR end "entryRuleTableToImport"


    // $ANTLR start "ruleTableToImport"
    // InternalMyDsl.g:3118:1: ruleTableToImport returns [EObject current=null] : (otherlv_0= 'IMPORT' otherlv_1= 'FROM' ( (lv_path_2_0= ruleEString ) ) otherlv_3= 'TO' ( ( ruleEString ) ) otherlv_5= 'WITH' otherlv_6= 'DELIMITER' ( (lv_delimiter_7_0= ruleEString ) ) otherlv_8= 'AND' otherlv_9= 'DELETE_MISMATCHED_TYPES' otherlv_10= 'AS' ( (lv_deleteMismatchedTypes_11_0= ruleEBooleanObject ) ) ) ;
    public final EObject ruleTableToImport() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Token otherlv_6=null;
        Token otherlv_8=null;
        Token otherlv_9=null;
        Token otherlv_10=null;
        AntlrDatatypeRuleToken lv_path_2_0 = null;

        AntlrDatatypeRuleToken lv_delimiter_7_0 = null;

        AntlrDatatypeRuleToken lv_deleteMismatchedTypes_11_0 = null;



        	enterRule();

        try {
            // InternalMyDsl.g:3124:2: ( (otherlv_0= 'IMPORT' otherlv_1= 'FROM' ( (lv_path_2_0= ruleEString ) ) otherlv_3= 'TO' ( ( ruleEString ) ) otherlv_5= 'WITH' otherlv_6= 'DELIMITER' ( (lv_delimiter_7_0= ruleEString ) ) otherlv_8= 'AND' otherlv_9= 'DELETE_MISMATCHED_TYPES' otherlv_10= 'AS' ( (lv_deleteMismatchedTypes_11_0= ruleEBooleanObject ) ) ) )
            // InternalMyDsl.g:3125:2: (otherlv_0= 'IMPORT' otherlv_1= 'FROM' ( (lv_path_2_0= ruleEString ) ) otherlv_3= 'TO' ( ( ruleEString ) ) otherlv_5= 'WITH' otherlv_6= 'DELIMITER' ( (lv_delimiter_7_0= ruleEString ) ) otherlv_8= 'AND' otherlv_9= 'DELETE_MISMATCHED_TYPES' otherlv_10= 'AS' ( (lv_deleteMismatchedTypes_11_0= ruleEBooleanObject ) ) )
            {
            // InternalMyDsl.g:3125:2: (otherlv_0= 'IMPORT' otherlv_1= 'FROM' ( (lv_path_2_0= ruleEString ) ) otherlv_3= 'TO' ( ( ruleEString ) ) otherlv_5= 'WITH' otherlv_6= 'DELIMITER' ( (lv_delimiter_7_0= ruleEString ) ) otherlv_8= 'AND' otherlv_9= 'DELETE_MISMATCHED_TYPES' otherlv_10= 'AS' ( (lv_deleteMismatchedTypes_11_0= ruleEBooleanObject ) ) )
            // InternalMyDsl.g:3126:3: otherlv_0= 'IMPORT' otherlv_1= 'FROM' ( (lv_path_2_0= ruleEString ) ) otherlv_3= 'TO' ( ( ruleEString ) ) otherlv_5= 'WITH' otherlv_6= 'DELIMITER' ( (lv_delimiter_7_0= ruleEString ) ) otherlv_8= 'AND' otherlv_9= 'DELETE_MISMATCHED_TYPES' otherlv_10= 'AS' ( (lv_deleteMismatchedTypes_11_0= ruleEBooleanObject ) )
            {
            otherlv_0=(Token)match(input,44,FOLLOW_29); 

            			newLeafNode(otherlv_0, grammarAccess.getTableToImportAccess().getIMPORTKeyword_0());
            		
            otherlv_1=(Token)match(input,30,FOLLOW_6); 

            			newLeafNode(otherlv_1, grammarAccess.getTableToImportAccess().getFROMKeyword_1());
            		
            // InternalMyDsl.g:3134:3: ( (lv_path_2_0= ruleEString ) )
            // InternalMyDsl.g:3135:4: (lv_path_2_0= ruleEString )
            {
            // InternalMyDsl.g:3135:4: (lv_path_2_0= ruleEString )
            // InternalMyDsl.g:3136:5: lv_path_2_0= ruleEString
            {

            					newCompositeNode(grammarAccess.getTableToImportAccess().getPathEStringParserRuleCall_2_0());
            				
            pushFollow(FOLLOW_30);
            lv_path_2_0=ruleEString();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getTableToImportRule());
            					}
            					set(
            						current,
            						"path",
            						lv_path_2_0,
            						"org.xtext.example.mydsl.MyDsl.EString");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_3=(Token)match(input,31,FOLLOW_6); 

            			newLeafNode(otherlv_3, grammarAccess.getTableToImportAccess().getTOKeyword_3());
            		
            // InternalMyDsl.g:3157:3: ( ( ruleEString ) )
            // InternalMyDsl.g:3158:4: ( ruleEString )
            {
            // InternalMyDsl.g:3158:4: ( ruleEString )
            // InternalMyDsl.g:3159:5: ruleEString
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getTableToImportRule());
            					}
            				

            					newCompositeNode(grammarAccess.getTableToImportAccess().getTableTableCrossReference_4_0());
            				
            pushFollow(FOLLOW_41);
            ruleEString();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_5=(Token)match(input,42,FOLLOW_65); 

            			newLeafNode(otherlv_5, grammarAccess.getTableToImportAccess().getWITHKeyword_5());
            		
            otherlv_6=(Token)match(input,65,FOLLOW_6); 

            			newLeafNode(otherlv_6, grammarAccess.getTableToImportAccess().getDELIMITERKeyword_6());
            		
            // InternalMyDsl.g:3181:3: ( (lv_delimiter_7_0= ruleEString ) )
            // InternalMyDsl.g:3182:4: (lv_delimiter_7_0= ruleEString )
            {
            // InternalMyDsl.g:3182:4: (lv_delimiter_7_0= ruleEString )
            // InternalMyDsl.g:3183:5: lv_delimiter_7_0= ruleEString
            {

            					newCompositeNode(grammarAccess.getTableToImportAccess().getDelimiterEStringParserRuleCall_7_0());
            				
            pushFollow(FOLLOW_21);
            lv_delimiter_7_0=ruleEString();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getTableToImportRule());
            					}
            					set(
            						current,
            						"delimiter",
            						lv_delimiter_7_0,
            						"org.xtext.example.mydsl.MyDsl.EString");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_8=(Token)match(input,24,FOLLOW_66); 

            			newLeafNode(otherlv_8, grammarAccess.getTableToImportAccess().getANDKeyword_8());
            		
            otherlv_9=(Token)match(input,66,FOLLOW_67); 

            			newLeafNode(otherlv_9, grammarAccess.getTableToImportAccess().getDELETE_MISMATCHED_TYPESKeyword_9());
            		
            otherlv_10=(Token)match(input,67,FOLLOW_4); 

            			newLeafNode(otherlv_10, grammarAccess.getTableToImportAccess().getASKeyword_10());
            		
            // InternalMyDsl.g:3212:3: ( (lv_deleteMismatchedTypes_11_0= ruleEBooleanObject ) )
            // InternalMyDsl.g:3213:4: (lv_deleteMismatchedTypes_11_0= ruleEBooleanObject )
            {
            // InternalMyDsl.g:3213:4: (lv_deleteMismatchedTypes_11_0= ruleEBooleanObject )
            // InternalMyDsl.g:3214:5: lv_deleteMismatchedTypes_11_0= ruleEBooleanObject
            {

            					newCompositeNode(grammarAccess.getTableToImportAccess().getDeleteMismatchedTypesEBooleanObjectParserRuleCall_11_0());
            				
            pushFollow(FOLLOW_2);
            lv_deleteMismatchedTypes_11_0=ruleEBooleanObject();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getTableToImportRule());
            					}
            					set(
            						current,
            						"deleteMismatchedTypes",
            						lv_deleteMismatchedTypes_11_0,
            						"org.xtext.example.mydsl.MyDsl.EBooleanObject");
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
    // $ANTLR end "ruleTableToImport"


    // $ANTLR start "entryRuleEIntegerObject"
    // InternalMyDsl.g:3235:1: entryRuleEIntegerObject returns [String current=null] : iv_ruleEIntegerObject= ruleEIntegerObject EOF ;
    public final String entryRuleEIntegerObject() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleEIntegerObject = null;


        try {
            // InternalMyDsl.g:3235:54: (iv_ruleEIntegerObject= ruleEIntegerObject EOF )
            // InternalMyDsl.g:3236:2: iv_ruleEIntegerObject= ruleEIntegerObject EOF
            {
             newCompositeNode(grammarAccess.getEIntegerObjectRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleEIntegerObject=ruleEIntegerObject();

            state._fsp--;

             current =iv_ruleEIntegerObject.getText(); 
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
    // $ANTLR end "entryRuleEIntegerObject"


    // $ANTLR start "ruleEIntegerObject"
    // InternalMyDsl.g:3242:1: ruleEIntegerObject returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : ( (kw= '-' )? this_INT_1= RULE_INT ) ;
    public final AntlrDatatypeRuleToken ruleEIntegerObject() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        Token this_INT_1=null;


        	enterRule();

        try {
            // InternalMyDsl.g:3248:2: ( ( (kw= '-' )? this_INT_1= RULE_INT ) )
            // InternalMyDsl.g:3249:2: ( (kw= '-' )? this_INT_1= RULE_INT )
            {
            // InternalMyDsl.g:3249:2: ( (kw= '-' )? this_INT_1= RULE_INT )
            // InternalMyDsl.g:3250:3: (kw= '-' )? this_INT_1= RULE_INT
            {
            // InternalMyDsl.g:3250:3: (kw= '-' )?
            int alt25=2;
            int LA25_0 = input.LA(1);

            if ( (LA25_0==68) ) {
                alt25=1;
            }
            switch (alt25) {
                case 1 :
                    // InternalMyDsl.g:3251:4: kw= '-'
                    {
                    kw=(Token)match(input,68,FOLLOW_68); 

                    				current.merge(kw);
                    				newLeafNode(kw, grammarAccess.getEIntegerObjectAccess().getHyphenMinusKeyword_0());
                    			

                    }
                    break;

            }

            this_INT_1=(Token)match(input,RULE_INT,FOLLOW_2); 

            			current.merge(this_INT_1);
            		

            			newLeafNode(this_INT_1, grammarAccess.getEIntegerObjectAccess().getINTTerminalRuleCall_1());
            		

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
    // $ANTLR end "ruleEIntegerObject"


    // $ANTLR start "entryRuleEBooleanObject"
    // InternalMyDsl.g:3268:1: entryRuleEBooleanObject returns [String current=null] : iv_ruleEBooleanObject= ruleEBooleanObject EOF ;
    public final String entryRuleEBooleanObject() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleEBooleanObject = null;


        try {
            // InternalMyDsl.g:3268:54: (iv_ruleEBooleanObject= ruleEBooleanObject EOF )
            // InternalMyDsl.g:3269:2: iv_ruleEBooleanObject= ruleEBooleanObject EOF
            {
             newCompositeNode(grammarAccess.getEBooleanObjectRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleEBooleanObject=ruleEBooleanObject();

            state._fsp--;

             current =iv_ruleEBooleanObject.getText(); 
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
    // $ANTLR end "entryRuleEBooleanObject"


    // $ANTLR start "ruleEBooleanObject"
    // InternalMyDsl.g:3275:1: ruleEBooleanObject returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= 'true' | kw= 'false' ) ;
    public final AntlrDatatypeRuleToken ruleEBooleanObject() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;


        	enterRule();

        try {
            // InternalMyDsl.g:3281:2: ( (kw= 'true' | kw= 'false' ) )
            // InternalMyDsl.g:3282:2: (kw= 'true' | kw= 'false' )
            {
            // InternalMyDsl.g:3282:2: (kw= 'true' | kw= 'false' )
            int alt26=2;
            int LA26_0 = input.LA(1);

            if ( (LA26_0==69) ) {
                alt26=1;
            }
            else if ( (LA26_0==70) ) {
                alt26=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 26, 0, input);

                throw nvae;
            }
            switch (alt26) {
                case 1 :
                    // InternalMyDsl.g:3283:3: kw= 'true'
                    {
                    kw=(Token)match(input,69,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getEBooleanObjectAccess().getTrueKeyword_0());
                    		

                    }
                    break;
                case 2 :
                    // InternalMyDsl.g:3289:3: kw= 'false'
                    {
                    kw=(Token)match(input,70,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getEBooleanObjectAccess().getFalseKeyword_1());
                    		

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
    // $ANTLR end "ruleEBooleanObject"


    // $ANTLR start "ruleDataType"
    // InternalMyDsl.g:3298:1: ruleDataType returns [Enumerator current=null] : ( (enumLiteral_0= 'TEXT' ) | (enumLiteral_1= 'NUMBER' ) | (enumLiteral_2= 'DATE' ) ) ;
    public final Enumerator ruleDataType() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;


        	enterRule();

        try {
            // InternalMyDsl.g:3304:2: ( ( (enumLiteral_0= 'TEXT' ) | (enumLiteral_1= 'NUMBER' ) | (enumLiteral_2= 'DATE' ) ) )
            // InternalMyDsl.g:3305:2: ( (enumLiteral_0= 'TEXT' ) | (enumLiteral_1= 'NUMBER' ) | (enumLiteral_2= 'DATE' ) )
            {
            // InternalMyDsl.g:3305:2: ( (enumLiteral_0= 'TEXT' ) | (enumLiteral_1= 'NUMBER' ) | (enumLiteral_2= 'DATE' ) )
            int alt27=3;
            switch ( input.LA(1) ) {
            case 71:
                {
                alt27=1;
                }
                break;
            case 72:
                {
                alt27=2;
                }
                break;
            case 73:
                {
                alt27=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 27, 0, input);

                throw nvae;
            }

            switch (alt27) {
                case 1 :
                    // InternalMyDsl.g:3306:3: (enumLiteral_0= 'TEXT' )
                    {
                    // InternalMyDsl.g:3306:3: (enumLiteral_0= 'TEXT' )
                    // InternalMyDsl.g:3307:4: enumLiteral_0= 'TEXT'
                    {
                    enumLiteral_0=(Token)match(input,71,FOLLOW_2); 

                    				current = grammarAccess.getDataTypeAccess().getTEXTEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_0, grammarAccess.getDataTypeAccess().getTEXTEnumLiteralDeclaration_0());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalMyDsl.g:3314:3: (enumLiteral_1= 'NUMBER' )
                    {
                    // InternalMyDsl.g:3314:3: (enumLiteral_1= 'NUMBER' )
                    // InternalMyDsl.g:3315:4: enumLiteral_1= 'NUMBER'
                    {
                    enumLiteral_1=(Token)match(input,72,FOLLOW_2); 

                    				current = grammarAccess.getDataTypeAccess().getNUMBEREnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_1, grammarAccess.getDataTypeAccess().getNUMBEREnumLiteralDeclaration_1());
                    			

                    }


                    }
                    break;
                case 3 :
                    // InternalMyDsl.g:3322:3: (enumLiteral_2= 'DATE' )
                    {
                    // InternalMyDsl.g:3322:3: (enumLiteral_2= 'DATE' )
                    // InternalMyDsl.g:3323:4: enumLiteral_2= 'DATE'
                    {
                    enumLiteral_2=(Token)match(input,73,FOLLOW_2); 

                    				current = grammarAccess.getDataTypeAccess().getDATEEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_2, grammarAccess.getDataTypeAccess().getDATEEnumLiteralDeclaration_2());
                    			

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


    // $ANTLR start "ruleGroupOperationType"
    // InternalMyDsl.g:3333:1: ruleGroupOperationType returns [Enumerator current=null] : ( (enumLiteral_0= 'MAX' ) | (enumLiteral_1= 'MIN' ) | (enumLiteral_2= 'COUNT' ) | (enumLiteral_3= 'SUM' ) | (enumLiteral_4= 'AVERAGE' ) ) ;
    public final Enumerator ruleGroupOperationType() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;
        Token enumLiteral_3=null;
        Token enumLiteral_4=null;


        	enterRule();

        try {
            // InternalMyDsl.g:3339:2: ( ( (enumLiteral_0= 'MAX' ) | (enumLiteral_1= 'MIN' ) | (enumLiteral_2= 'COUNT' ) | (enumLiteral_3= 'SUM' ) | (enumLiteral_4= 'AVERAGE' ) ) )
            // InternalMyDsl.g:3340:2: ( (enumLiteral_0= 'MAX' ) | (enumLiteral_1= 'MIN' ) | (enumLiteral_2= 'COUNT' ) | (enumLiteral_3= 'SUM' ) | (enumLiteral_4= 'AVERAGE' ) )
            {
            // InternalMyDsl.g:3340:2: ( (enumLiteral_0= 'MAX' ) | (enumLiteral_1= 'MIN' ) | (enumLiteral_2= 'COUNT' ) | (enumLiteral_3= 'SUM' ) | (enumLiteral_4= 'AVERAGE' ) )
            int alt28=5;
            switch ( input.LA(1) ) {
            case 74:
                {
                alt28=1;
                }
                break;
            case 75:
                {
                alt28=2;
                }
                break;
            case 76:
                {
                alt28=3;
                }
                break;
            case 77:
                {
                alt28=4;
                }
                break;
            case 78:
                {
                alt28=5;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 28, 0, input);

                throw nvae;
            }

            switch (alt28) {
                case 1 :
                    // InternalMyDsl.g:3341:3: (enumLiteral_0= 'MAX' )
                    {
                    // InternalMyDsl.g:3341:3: (enumLiteral_0= 'MAX' )
                    // InternalMyDsl.g:3342:4: enumLiteral_0= 'MAX'
                    {
                    enumLiteral_0=(Token)match(input,74,FOLLOW_2); 

                    				current = grammarAccess.getGroupOperationTypeAccess().getMAXEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_0, grammarAccess.getGroupOperationTypeAccess().getMAXEnumLiteralDeclaration_0());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalMyDsl.g:3349:3: (enumLiteral_1= 'MIN' )
                    {
                    // InternalMyDsl.g:3349:3: (enumLiteral_1= 'MIN' )
                    // InternalMyDsl.g:3350:4: enumLiteral_1= 'MIN'
                    {
                    enumLiteral_1=(Token)match(input,75,FOLLOW_2); 

                    				current = grammarAccess.getGroupOperationTypeAccess().getMINEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_1, grammarAccess.getGroupOperationTypeAccess().getMINEnumLiteralDeclaration_1());
                    			

                    }


                    }
                    break;
                case 3 :
                    // InternalMyDsl.g:3357:3: (enumLiteral_2= 'COUNT' )
                    {
                    // InternalMyDsl.g:3357:3: (enumLiteral_2= 'COUNT' )
                    // InternalMyDsl.g:3358:4: enumLiteral_2= 'COUNT'
                    {
                    enumLiteral_2=(Token)match(input,76,FOLLOW_2); 

                    				current = grammarAccess.getGroupOperationTypeAccess().getCOUNTEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_2, grammarAccess.getGroupOperationTypeAccess().getCOUNTEnumLiteralDeclaration_2());
                    			

                    }


                    }
                    break;
                case 4 :
                    // InternalMyDsl.g:3365:3: (enumLiteral_3= 'SUM' )
                    {
                    // InternalMyDsl.g:3365:3: (enumLiteral_3= 'SUM' )
                    // InternalMyDsl.g:3366:4: enumLiteral_3= 'SUM'
                    {
                    enumLiteral_3=(Token)match(input,77,FOLLOW_2); 

                    				current = grammarAccess.getGroupOperationTypeAccess().getSUMEnumLiteralDeclaration_3().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_3, grammarAccess.getGroupOperationTypeAccess().getSUMEnumLiteralDeclaration_3());
                    			

                    }


                    }
                    break;
                case 5 :
                    // InternalMyDsl.g:3373:3: (enumLiteral_4= 'AVERAGE' )
                    {
                    // InternalMyDsl.g:3373:3: (enumLiteral_4= 'AVERAGE' )
                    // InternalMyDsl.g:3374:4: enumLiteral_4= 'AVERAGE'
                    {
                    enumLiteral_4=(Token)match(input,78,FOLLOW_2); 

                    				current = grammarAccess.getGroupOperationTypeAccess().getAVERAGEEnumLiteralDeclaration_4().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_4, grammarAccess.getGroupOperationTypeAccess().getAVERAGEEnumLiteralDeclaration_4());
                    			

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
    // $ANTLR end "ruleGroupOperationType"


    // $ANTLR start "ruleOrderType"
    // InternalMyDsl.g:3384:1: ruleOrderType returns [Enumerator current=null] : ( (enumLiteral_0= 'ASC' ) | (enumLiteral_1= 'DESC' ) ) ;
    public final Enumerator ruleOrderType() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;


        	enterRule();

        try {
            // InternalMyDsl.g:3390:2: ( ( (enumLiteral_0= 'ASC' ) | (enumLiteral_1= 'DESC' ) ) )
            // InternalMyDsl.g:3391:2: ( (enumLiteral_0= 'ASC' ) | (enumLiteral_1= 'DESC' ) )
            {
            // InternalMyDsl.g:3391:2: ( (enumLiteral_0= 'ASC' ) | (enumLiteral_1= 'DESC' ) )
            int alt29=2;
            int LA29_0 = input.LA(1);

            if ( (LA29_0==79) ) {
                alt29=1;
            }
            else if ( (LA29_0==80) ) {
                alt29=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 29, 0, input);

                throw nvae;
            }
            switch (alt29) {
                case 1 :
                    // InternalMyDsl.g:3392:3: (enumLiteral_0= 'ASC' )
                    {
                    // InternalMyDsl.g:3392:3: (enumLiteral_0= 'ASC' )
                    // InternalMyDsl.g:3393:4: enumLiteral_0= 'ASC'
                    {
                    enumLiteral_0=(Token)match(input,79,FOLLOW_2); 

                    				current = grammarAccess.getOrderTypeAccess().getASCEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_0, grammarAccess.getOrderTypeAccess().getASCEnumLiteralDeclaration_0());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalMyDsl.g:3400:3: (enumLiteral_1= 'DESC' )
                    {
                    // InternalMyDsl.g:3400:3: (enumLiteral_1= 'DESC' )
                    // InternalMyDsl.g:3401:4: enumLiteral_1= 'DESC'
                    {
                    enumLiteral_1=(Token)match(input,80,FOLLOW_2); 

                    				current = grammarAccess.getOrderTypeAccess().getDESCEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_1, grammarAccess.getOrderTypeAccess().getDESCEnumLiteralDeclaration_1());
                    			

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
    // $ANTLR end "ruleOrderType"


    // $ANTLR start "ruleFilterOperatorType"
    // InternalMyDsl.g:3411:1: ruleFilterOperatorType returns [Enumerator current=null] : ( (enumLiteral_0= 'EQUALS' ) | (enumLiteral_1= 'LESS_THAN' ) | (enumLiteral_2= 'GREATER_THAN' ) | (enumLiteral_3= 'LESS_OR_EQUALS_THAN' ) | (enumLiteral_4= 'GREATER_OR_EQUALS_THAN' ) ) ;
    public final Enumerator ruleFilterOperatorType() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;
        Token enumLiteral_3=null;
        Token enumLiteral_4=null;


        	enterRule();

        try {
            // InternalMyDsl.g:3417:2: ( ( (enumLiteral_0= 'EQUALS' ) | (enumLiteral_1= 'LESS_THAN' ) | (enumLiteral_2= 'GREATER_THAN' ) | (enumLiteral_3= 'LESS_OR_EQUALS_THAN' ) | (enumLiteral_4= 'GREATER_OR_EQUALS_THAN' ) ) )
            // InternalMyDsl.g:3418:2: ( (enumLiteral_0= 'EQUALS' ) | (enumLiteral_1= 'LESS_THAN' ) | (enumLiteral_2= 'GREATER_THAN' ) | (enumLiteral_3= 'LESS_OR_EQUALS_THAN' ) | (enumLiteral_4= 'GREATER_OR_EQUALS_THAN' ) )
            {
            // InternalMyDsl.g:3418:2: ( (enumLiteral_0= 'EQUALS' ) | (enumLiteral_1= 'LESS_THAN' ) | (enumLiteral_2= 'GREATER_THAN' ) | (enumLiteral_3= 'LESS_OR_EQUALS_THAN' ) | (enumLiteral_4= 'GREATER_OR_EQUALS_THAN' ) )
            int alt30=5;
            switch ( input.LA(1) ) {
            case 81:
                {
                alt30=1;
                }
                break;
            case 82:
                {
                alt30=2;
                }
                break;
            case 83:
                {
                alt30=3;
                }
                break;
            case 84:
                {
                alt30=4;
                }
                break;
            case 85:
                {
                alt30=5;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 30, 0, input);

                throw nvae;
            }

            switch (alt30) {
                case 1 :
                    // InternalMyDsl.g:3419:3: (enumLiteral_0= 'EQUALS' )
                    {
                    // InternalMyDsl.g:3419:3: (enumLiteral_0= 'EQUALS' )
                    // InternalMyDsl.g:3420:4: enumLiteral_0= 'EQUALS'
                    {
                    enumLiteral_0=(Token)match(input,81,FOLLOW_2); 

                    				current = grammarAccess.getFilterOperatorTypeAccess().getEQUALSEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_0, grammarAccess.getFilterOperatorTypeAccess().getEQUALSEnumLiteralDeclaration_0());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalMyDsl.g:3427:3: (enumLiteral_1= 'LESS_THAN' )
                    {
                    // InternalMyDsl.g:3427:3: (enumLiteral_1= 'LESS_THAN' )
                    // InternalMyDsl.g:3428:4: enumLiteral_1= 'LESS_THAN'
                    {
                    enumLiteral_1=(Token)match(input,82,FOLLOW_2); 

                    				current = grammarAccess.getFilterOperatorTypeAccess().getLESS_THANEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_1, grammarAccess.getFilterOperatorTypeAccess().getLESS_THANEnumLiteralDeclaration_1());
                    			

                    }


                    }
                    break;
                case 3 :
                    // InternalMyDsl.g:3435:3: (enumLiteral_2= 'GREATER_THAN' )
                    {
                    // InternalMyDsl.g:3435:3: (enumLiteral_2= 'GREATER_THAN' )
                    // InternalMyDsl.g:3436:4: enumLiteral_2= 'GREATER_THAN'
                    {
                    enumLiteral_2=(Token)match(input,83,FOLLOW_2); 

                    				current = grammarAccess.getFilterOperatorTypeAccess().getGREATER_THANEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_2, grammarAccess.getFilterOperatorTypeAccess().getGREATER_THANEnumLiteralDeclaration_2());
                    			

                    }


                    }
                    break;
                case 4 :
                    // InternalMyDsl.g:3443:3: (enumLiteral_3= 'LESS_OR_EQUALS_THAN' )
                    {
                    // InternalMyDsl.g:3443:3: (enumLiteral_3= 'LESS_OR_EQUALS_THAN' )
                    // InternalMyDsl.g:3444:4: enumLiteral_3= 'LESS_OR_EQUALS_THAN'
                    {
                    enumLiteral_3=(Token)match(input,84,FOLLOW_2); 

                    				current = grammarAccess.getFilterOperatorTypeAccess().getLESS_OR_EQUALS_THANEnumLiteralDeclaration_3().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_3, grammarAccess.getFilterOperatorTypeAccess().getLESS_OR_EQUALS_THANEnumLiteralDeclaration_3());
                    			

                    }


                    }
                    break;
                case 5 :
                    // InternalMyDsl.g:3451:3: (enumLiteral_4= 'GREATER_OR_EQUALS_THAN' )
                    {
                    // InternalMyDsl.g:3451:3: (enumLiteral_4= 'GREATER_OR_EQUALS_THAN' )
                    // InternalMyDsl.g:3452:4: enumLiteral_4= 'GREATER_OR_EQUALS_THAN'
                    {
                    enumLiteral_4=(Token)match(input,85,FOLLOW_2); 

                    				current = grammarAccess.getFilterOperatorTypeAccess().getGREATER_OR_EQUALS_THANEnumLiteralDeclaration_4().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_4, grammarAccess.getFilterOperatorTypeAccess().getGREATER_OR_EQUALS_THANEnumLiteralDeclaration_4());
                    			

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
    // $ANTLR end "ruleFilterOperatorType"


    // $ANTLR start "ruleJoinType"
    // InternalMyDsl.g:3462:1: ruleJoinType returns [Enumerator current=null] : ( (enumLiteral_0= 'INNER' ) | (enumLiteral_1= 'OUTER' ) | (enumLiteral_2= 'LEFT' ) | (enumLiteral_3= 'RIGHT' ) ) ;
    public final Enumerator ruleJoinType() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;
        Token enumLiteral_3=null;


        	enterRule();

        try {
            // InternalMyDsl.g:3468:2: ( ( (enumLiteral_0= 'INNER' ) | (enumLiteral_1= 'OUTER' ) | (enumLiteral_2= 'LEFT' ) | (enumLiteral_3= 'RIGHT' ) ) )
            // InternalMyDsl.g:3469:2: ( (enumLiteral_0= 'INNER' ) | (enumLiteral_1= 'OUTER' ) | (enumLiteral_2= 'LEFT' ) | (enumLiteral_3= 'RIGHT' ) )
            {
            // InternalMyDsl.g:3469:2: ( (enumLiteral_0= 'INNER' ) | (enumLiteral_1= 'OUTER' ) | (enumLiteral_2= 'LEFT' ) | (enumLiteral_3= 'RIGHT' ) )
            int alt31=4;
            switch ( input.LA(1) ) {
            case 86:
                {
                alt31=1;
                }
                break;
            case 87:
                {
                alt31=2;
                }
                break;
            case 88:
                {
                alt31=3;
                }
                break;
            case 89:
                {
                alt31=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 31, 0, input);

                throw nvae;
            }

            switch (alt31) {
                case 1 :
                    // InternalMyDsl.g:3470:3: (enumLiteral_0= 'INNER' )
                    {
                    // InternalMyDsl.g:3470:3: (enumLiteral_0= 'INNER' )
                    // InternalMyDsl.g:3471:4: enumLiteral_0= 'INNER'
                    {
                    enumLiteral_0=(Token)match(input,86,FOLLOW_2); 

                    				current = grammarAccess.getJoinTypeAccess().getINNEREnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_0, grammarAccess.getJoinTypeAccess().getINNEREnumLiteralDeclaration_0());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalMyDsl.g:3478:3: (enumLiteral_1= 'OUTER' )
                    {
                    // InternalMyDsl.g:3478:3: (enumLiteral_1= 'OUTER' )
                    // InternalMyDsl.g:3479:4: enumLiteral_1= 'OUTER'
                    {
                    enumLiteral_1=(Token)match(input,87,FOLLOW_2); 

                    				current = grammarAccess.getJoinTypeAccess().getOUTEREnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_1, grammarAccess.getJoinTypeAccess().getOUTEREnumLiteralDeclaration_1());
                    			

                    }


                    }
                    break;
                case 3 :
                    // InternalMyDsl.g:3486:3: (enumLiteral_2= 'LEFT' )
                    {
                    // InternalMyDsl.g:3486:3: (enumLiteral_2= 'LEFT' )
                    // InternalMyDsl.g:3487:4: enumLiteral_2= 'LEFT'
                    {
                    enumLiteral_2=(Token)match(input,88,FOLLOW_2); 

                    				current = grammarAccess.getJoinTypeAccess().getLEFTEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_2, grammarAccess.getJoinTypeAccess().getLEFTEnumLiteralDeclaration_2());
                    			

                    }


                    }
                    break;
                case 4 :
                    // InternalMyDsl.g:3494:3: (enumLiteral_3= 'RIGHT' )
                    {
                    // InternalMyDsl.g:3494:3: (enumLiteral_3= 'RIGHT' )
                    // InternalMyDsl.g:3495:4: enumLiteral_3= 'RIGHT'
                    {
                    enumLiteral_3=(Token)match(input,89,FOLLOW_2); 

                    				current = grammarAccess.getJoinTypeAccess().getRIGHTEnumLiteralDeclaration_3().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_3, grammarAccess.getJoinTypeAccess().getRIGHTEnumLiteralDeclaration_3());
                    			

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
    // $ANTLR end "ruleJoinType"


    // $ANTLR start "ruleLookupOperationType"
    // InternalMyDsl.g:3505:1: ruleLookupOperationType returns [Enumerator current=null] : ( (enumLiteral_0= 'NUMERIC_SUM' ) | (enumLiteral_1= 'NUMERIC_SUBTRACT' ) | (enumLiteral_2= 'NUMERIC_MULTIPLY' ) | (enumLiteral_3= 'NUMERIC_DIVIDE' ) | (enumLiteral_4= 'TEXT_CONCAT' ) ) ;
    public final Enumerator ruleLookupOperationType() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;
        Token enumLiteral_3=null;
        Token enumLiteral_4=null;


        	enterRule();

        try {
            // InternalMyDsl.g:3511:2: ( ( (enumLiteral_0= 'NUMERIC_SUM' ) | (enumLiteral_1= 'NUMERIC_SUBTRACT' ) | (enumLiteral_2= 'NUMERIC_MULTIPLY' ) | (enumLiteral_3= 'NUMERIC_DIVIDE' ) | (enumLiteral_4= 'TEXT_CONCAT' ) ) )
            // InternalMyDsl.g:3512:2: ( (enumLiteral_0= 'NUMERIC_SUM' ) | (enumLiteral_1= 'NUMERIC_SUBTRACT' ) | (enumLiteral_2= 'NUMERIC_MULTIPLY' ) | (enumLiteral_3= 'NUMERIC_DIVIDE' ) | (enumLiteral_4= 'TEXT_CONCAT' ) )
            {
            // InternalMyDsl.g:3512:2: ( (enumLiteral_0= 'NUMERIC_SUM' ) | (enumLiteral_1= 'NUMERIC_SUBTRACT' ) | (enumLiteral_2= 'NUMERIC_MULTIPLY' ) | (enumLiteral_3= 'NUMERIC_DIVIDE' ) | (enumLiteral_4= 'TEXT_CONCAT' ) )
            int alt32=5;
            switch ( input.LA(1) ) {
            case 90:
                {
                alt32=1;
                }
                break;
            case 91:
                {
                alt32=2;
                }
                break;
            case 92:
                {
                alt32=3;
                }
                break;
            case 93:
                {
                alt32=4;
                }
                break;
            case 94:
                {
                alt32=5;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 32, 0, input);

                throw nvae;
            }

            switch (alt32) {
                case 1 :
                    // InternalMyDsl.g:3513:3: (enumLiteral_0= 'NUMERIC_SUM' )
                    {
                    // InternalMyDsl.g:3513:3: (enumLiteral_0= 'NUMERIC_SUM' )
                    // InternalMyDsl.g:3514:4: enumLiteral_0= 'NUMERIC_SUM'
                    {
                    enumLiteral_0=(Token)match(input,90,FOLLOW_2); 

                    				current = grammarAccess.getLookupOperationTypeAccess().getNUMERIC_SUMEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_0, grammarAccess.getLookupOperationTypeAccess().getNUMERIC_SUMEnumLiteralDeclaration_0());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalMyDsl.g:3521:3: (enumLiteral_1= 'NUMERIC_SUBTRACT' )
                    {
                    // InternalMyDsl.g:3521:3: (enumLiteral_1= 'NUMERIC_SUBTRACT' )
                    // InternalMyDsl.g:3522:4: enumLiteral_1= 'NUMERIC_SUBTRACT'
                    {
                    enumLiteral_1=(Token)match(input,91,FOLLOW_2); 

                    				current = grammarAccess.getLookupOperationTypeAccess().getNUMERIC_SUBTRACTEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_1, grammarAccess.getLookupOperationTypeAccess().getNUMERIC_SUBTRACTEnumLiteralDeclaration_1());
                    			

                    }


                    }
                    break;
                case 3 :
                    // InternalMyDsl.g:3529:3: (enumLiteral_2= 'NUMERIC_MULTIPLY' )
                    {
                    // InternalMyDsl.g:3529:3: (enumLiteral_2= 'NUMERIC_MULTIPLY' )
                    // InternalMyDsl.g:3530:4: enumLiteral_2= 'NUMERIC_MULTIPLY'
                    {
                    enumLiteral_2=(Token)match(input,92,FOLLOW_2); 

                    				current = grammarAccess.getLookupOperationTypeAccess().getNUMERIC_MULTIPLYEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_2, grammarAccess.getLookupOperationTypeAccess().getNUMERIC_MULTIPLYEnumLiteralDeclaration_2());
                    			

                    }


                    }
                    break;
                case 4 :
                    // InternalMyDsl.g:3537:3: (enumLiteral_3= 'NUMERIC_DIVIDE' )
                    {
                    // InternalMyDsl.g:3537:3: (enumLiteral_3= 'NUMERIC_DIVIDE' )
                    // InternalMyDsl.g:3538:4: enumLiteral_3= 'NUMERIC_DIVIDE'
                    {
                    enumLiteral_3=(Token)match(input,93,FOLLOW_2); 

                    				current = grammarAccess.getLookupOperationTypeAccess().getNUMERIC_DIVIDEEnumLiteralDeclaration_3().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_3, grammarAccess.getLookupOperationTypeAccess().getNUMERIC_DIVIDEEnumLiteralDeclaration_3());
                    			

                    }


                    }
                    break;
                case 5 :
                    // InternalMyDsl.g:3545:3: (enumLiteral_4= 'TEXT_CONCAT' )
                    {
                    // InternalMyDsl.g:3545:3: (enumLiteral_4= 'TEXT_CONCAT' )
                    // InternalMyDsl.g:3546:4: enumLiteral_4= 'TEXT_CONCAT'
                    {
                    enumLiteral_4=(Token)match(input,94,FOLLOW_2); 

                    				current = grammarAccess.getLookupOperationTypeAccess().getTEXT_CONCATEnumLiteralDeclaration_4().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_4, grammarAccess.getLookupOperationTypeAccess().getTEXT_CONCATEnumLiteralDeclaration_4());
                    			

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
    // $ANTLR end "ruleLookupOperationType"

    // Delegated rules


 

    public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000060L});
    public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0000000000000030L});
    public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0000000000002030L});
    public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x1041B22224050000L});
    public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x1041B22224050002L});
    public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x0000000000000032L});
    public static final BitSet FOLLOW_12 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_13 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000380L});
    public static final BitSet FOLLOW_14 = new BitSet(new long[]{0x0000000000020030L});
    public static final BitSet FOLLOW_15 = new BitSet(new long[]{0x0000000000020032L});
    public static final BitSet FOLLOW_16 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_17 = new BitSet(new long[]{0x0000000000120000L});
    public static final BitSet FOLLOW_18 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_19 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_20 = new BitSet(new long[]{0x0000000000C00000L});
    public static final BitSet FOLLOW_21 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_22 = new BitSet(new long[]{0x0000000000000000L,0x0000000000007C00L});
    public static final BitSet FOLLOW_23 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_24 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_25 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_26 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_27 = new BitSet(new long[]{0x0000000000000000L,0x0000000000018000L});
    public static final BitSet FOLLOW_28 = new BitSet(new long[]{0x0000000040020000L});
    public static final BitSet FOLLOW_29 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_30 = new BitSet(new long[]{0x0000000080000000L});
    public static final BitSet FOLLOW_31 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_32 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_33 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_34 = new BitSet(new long[]{0x0000001000000000L});
    public static final BitSet FOLLOW_35 = new BitSet(new long[]{0x0000000000000000L,0x00000000003E0000L});
    public static final BitSet FOLLOW_36 = new BitSet(new long[]{0x0000004000000000L});
    public static final BitSet FOLLOW_37 = new BitSet(new long[]{0x0000008000020000L});
    public static final BitSet FOLLOW_38 = new BitSet(new long[]{0x0000008000000000L});
    public static final BitSet FOLLOW_39 = new BitSet(new long[]{0x0000010000000000L});
    public static final BitSet FOLLOW_40 = new BitSet(new long[]{0x0000000000000000L,0x0000000003C00000L});
    public static final BitSet FOLLOW_41 = new BitSet(new long[]{0x0000040000000000L});
    public static final BitSet FOLLOW_42 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_43 = new BitSet(new long[]{0x0000000002400000L});
    public static final BitSet FOLLOW_44 = new BitSet(new long[]{0x0000100000020000L});
    public static final BitSet FOLLOW_45 = new BitSet(new long[]{0x0000100000020002L});
    public static final BitSet FOLLOW_46 = new BitSet(new long[]{0x0000400000000000L});
    public static final BitSet FOLLOW_47 = new BitSet(new long[]{0x0000000000000000L,0x000000007C000000L});
    public static final BitSet FOLLOW_48 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_49 = new BitSet(new long[]{0x0002000000020000L});
    public static final BitSet FOLLOW_50 = new BitSet(new long[]{0x0002000000000000L});
    public static final BitSet FOLLOW_51 = new BitSet(new long[]{0x0004000000000000L});
    public static final BitSet FOLLOW_52 = new BitSet(new long[]{0x0008000000000000L});
    public static final BitSet FOLLOW_53 = new BitSet(new long[]{0x0010000000000000L});
    public static final BitSet FOLLOW_54 = new BitSet(new long[]{0x0020000000000000L});
    public static final BitSet FOLLOW_55 = new BitSet(new long[]{0x0080000000000000L});
    public static final BitSet FOLLOW_56 = new BitSet(new long[]{0x0100000000000000L});
    public static final BitSet FOLLOW_57 = new BitSet(new long[]{0x0200000000000000L});
    public static final BitSet FOLLOW_58 = new BitSet(new long[]{0x0000000000000040L,0x0000000000000010L});
    public static final BitSet FOLLOW_59 = new BitSet(new long[]{0x0400000000000000L});
    public static final BitSet FOLLOW_60 = new BitSet(new long[]{0x0800000000000000L});
    public static final BitSet FOLLOW_61 = new BitSet(new long[]{0x2000000000000000L});
    public static final BitSet FOLLOW_62 = new BitSet(new long[]{0x4000000000000000L});
    public static final BitSet FOLLOW_63 = new BitSet(new long[]{0x8000000000000000L});
    public static final BitSet FOLLOW_64 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000001L});
    public static final BitSet FOLLOW_65 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000002L});
    public static final BitSet FOLLOW_66 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000004L});
    public static final BitSet FOLLOW_67 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000008L});
    public static final BitSet FOLLOW_68 = new BitSet(new long[]{0x0000000000000040L});

}