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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_STRING", "RULE_ID", "RULE_INT", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'Model'", "'{'", "'logs'", "'tables'", "','", "'}'", "'steps'", "'Table'", "'columns'", "'Column'", "'dataType'", "'Save'", "'description'", "'tablesToSave'", "'Group'", "'table'", "'groupBy'", "'('", "')'", "'operation'", "'operandColumn'", "'resultTable'", "'resultColumn'", "'next'", "'Sort'", "'column'", "'order'", "'AppendRows'", "'originTable'", "'destinTable'", "'associations'", "'Filter'", "'operator'", "'operand'", "'GenericStep'", "'Join'", "'tableLeft'", "'columnLeft'", "'type'", "'tableRight'", "'columnRight'", "'selectColumns'", "'Import'", "'tablesToImport'", "'Lookup'", "'lookupTable'", "'matchColumn'", "'lookupColumn'", "'RemoveDuplicates'", "'Concat'", "'sourceA'", "'sourceB'", "'Split'", "'source'", "'delimiter'", "'atCharIndex'", "'resultColumnA'", "'resultColumnB'", "'Extract'", "'lbChar'", "'ubChar'", "'pattern'", "'TableToSave'", "'path'", "'columnsNames'", "'Association'", "'originCol'", "'destinCol'", "'deleteMismatchedTypes'", "'TableToImport'", "'-'", "'true'", "'false'", "'TEXT'", "'NUMBER'", "'DATE'", "'MAX'", "'MIN'", "'COUNT'", "'SUM'", "'AVERAGE'", "'ASC'", "'DESC'", "'EQUALS'", "'LESS_THAN'", "'GREATER_THAN'", "'LESS_OR_EQUALS_THAN'", "'GREATER_OR_EQUALS_THAN'", "'INNER'", "'OUTER'", "'LEFT'", "'RIGHT'", "'NUMERIC_SUM'", "'NUMERIC_SUBTRACT'", "'NUMERIC_MULTIPLY'", "'NUMERIC_DIVIDE'", "'TEXT_CONCAT'"
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
    public static final int T__100=100;
    public static final int T__92=92;
    public static final int T__93=93;
    public static final int T__102=102;
    public static final int T__94=94;
    public static final int T__101=101;
    public static final int T__90=90;
    public static final int T__19=19;
    public static final int T__15=15;
    public static final int T__16=16;
    public static final int T__17=17;
    public static final int T__18=18;
    public static final int T__11=11;
    public static final int T__99=99;
    public static final int T__12=12;
    public static final int T__13=13;
    public static final int T__14=14;
    public static final int T__95=95;
    public static final int T__96=96;
    public static final int T__97=97;
    public static final int T__98=98;
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
    public static final int T__107=107;
    public static final int T__84=84;
    public static final int T__104=104;
    public static final int T__85=85;
    public static final int T__103=103;
    public static final int T__86=86;
    public static final int T__106=106;
    public static final int T__87=87;
    public static final int T__105=105;

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
    // InternalMyDsl.g:72:1: ruleModel returns [EObject current=null] : (otherlv_0= 'Model' ( (lv_name_1_0= ruleEString ) ) otherlv_2= '{' otherlv_3= 'logs' ( (lv_logs_4_0= ruleEBooleanObject ) ) otherlv_5= 'tables' otherlv_6= '{' ( (lv_tables_7_0= ruleTable ) ) (otherlv_8= ',' ( (lv_tables_9_0= ruleTable ) ) )* otherlv_10= '}' otherlv_11= 'steps' otherlv_12= '{' ( (lv_steps_13_0= ruleStep ) ) (otherlv_14= ',' ( (lv_steps_15_0= ruleStep ) ) )* otherlv_16= '}' otherlv_17= '}' ) ;
    public final EObject ruleModel() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Token otherlv_6=null;
        Token otherlv_8=null;
        Token otherlv_10=null;
        Token otherlv_11=null;
        Token otherlv_12=null;
        Token otherlv_14=null;
        Token otherlv_16=null;
        Token otherlv_17=null;
        AntlrDatatypeRuleToken lv_name_1_0 = null;

        AntlrDatatypeRuleToken lv_logs_4_0 = null;

        EObject lv_tables_7_0 = null;

        EObject lv_tables_9_0 = null;

        EObject lv_steps_13_0 = null;

        EObject lv_steps_15_0 = null;



        	enterRule();

        try {
            // InternalMyDsl.g:78:2: ( (otherlv_0= 'Model' ( (lv_name_1_0= ruleEString ) ) otherlv_2= '{' otherlv_3= 'logs' ( (lv_logs_4_0= ruleEBooleanObject ) ) otherlv_5= 'tables' otherlv_6= '{' ( (lv_tables_7_0= ruleTable ) ) (otherlv_8= ',' ( (lv_tables_9_0= ruleTable ) ) )* otherlv_10= '}' otherlv_11= 'steps' otherlv_12= '{' ( (lv_steps_13_0= ruleStep ) ) (otherlv_14= ',' ( (lv_steps_15_0= ruleStep ) ) )* otherlv_16= '}' otherlv_17= '}' ) )
            // InternalMyDsl.g:79:2: (otherlv_0= 'Model' ( (lv_name_1_0= ruleEString ) ) otherlv_2= '{' otherlv_3= 'logs' ( (lv_logs_4_0= ruleEBooleanObject ) ) otherlv_5= 'tables' otherlv_6= '{' ( (lv_tables_7_0= ruleTable ) ) (otherlv_8= ',' ( (lv_tables_9_0= ruleTable ) ) )* otherlv_10= '}' otherlv_11= 'steps' otherlv_12= '{' ( (lv_steps_13_0= ruleStep ) ) (otherlv_14= ',' ( (lv_steps_15_0= ruleStep ) ) )* otherlv_16= '}' otherlv_17= '}' )
            {
            // InternalMyDsl.g:79:2: (otherlv_0= 'Model' ( (lv_name_1_0= ruleEString ) ) otherlv_2= '{' otherlv_3= 'logs' ( (lv_logs_4_0= ruleEBooleanObject ) ) otherlv_5= 'tables' otherlv_6= '{' ( (lv_tables_7_0= ruleTable ) ) (otherlv_8= ',' ( (lv_tables_9_0= ruleTable ) ) )* otherlv_10= '}' otherlv_11= 'steps' otherlv_12= '{' ( (lv_steps_13_0= ruleStep ) ) (otherlv_14= ',' ( (lv_steps_15_0= ruleStep ) ) )* otherlv_16= '}' otherlv_17= '}' )
            // InternalMyDsl.g:80:3: otherlv_0= 'Model' ( (lv_name_1_0= ruleEString ) ) otherlv_2= '{' otherlv_3= 'logs' ( (lv_logs_4_0= ruleEBooleanObject ) ) otherlv_5= 'tables' otherlv_6= '{' ( (lv_tables_7_0= ruleTable ) ) (otherlv_8= ',' ( (lv_tables_9_0= ruleTable ) ) )* otherlv_10= '}' otherlv_11= 'steps' otherlv_12= '{' ( (lv_steps_13_0= ruleStep ) ) (otherlv_14= ',' ( (lv_steps_15_0= ruleStep ) ) )* otherlv_16= '}' otherlv_17= '}'
            {
            otherlv_0=(Token)match(input,11,FOLLOW_3); 

            			newLeafNode(otherlv_0, grammarAccess.getModelAccess().getModelKeyword_0());
            		
            // InternalMyDsl.g:84:3: ( (lv_name_1_0= ruleEString ) )
            // InternalMyDsl.g:85:4: (lv_name_1_0= ruleEString )
            {
            // InternalMyDsl.g:85:4: (lv_name_1_0= ruleEString )
            // InternalMyDsl.g:86:5: lv_name_1_0= ruleEString
            {

            					newCompositeNode(grammarAccess.getModelAccess().getNameEStringParserRuleCall_1_0());
            				
            pushFollow(FOLLOW_4);
            lv_name_1_0=ruleEString();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getModelRule());
            					}
            					set(
            						current,
            						"name",
            						lv_name_1_0,
            						"org.xtext.example.mydsl.MyDsl.EString");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_2=(Token)match(input,12,FOLLOW_5); 

            			newLeafNode(otherlv_2, grammarAccess.getModelAccess().getLeftCurlyBracketKeyword_2());
            		
            otherlv_3=(Token)match(input,13,FOLLOW_6); 

            			newLeafNode(otherlv_3, grammarAccess.getModelAccess().getLogsKeyword_3());
            		
            // InternalMyDsl.g:111:3: ( (lv_logs_4_0= ruleEBooleanObject ) )
            // InternalMyDsl.g:112:4: (lv_logs_4_0= ruleEBooleanObject )
            {
            // InternalMyDsl.g:112:4: (lv_logs_4_0= ruleEBooleanObject )
            // InternalMyDsl.g:113:5: lv_logs_4_0= ruleEBooleanObject
            {

            					newCompositeNode(grammarAccess.getModelAccess().getLogsEBooleanObjectParserRuleCall_4_0());
            				
            pushFollow(FOLLOW_7);
            lv_logs_4_0=ruleEBooleanObject();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getModelRule());
            					}
            					set(
            						current,
            						"logs",
            						lv_logs_4_0,
            						"org.xtext.example.mydsl.MyDsl.EBooleanObject");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_5=(Token)match(input,14,FOLLOW_4); 

            			newLeafNode(otherlv_5, grammarAccess.getModelAccess().getTablesKeyword_5());
            		
            otherlv_6=(Token)match(input,12,FOLLOW_8); 

            			newLeafNode(otherlv_6, grammarAccess.getModelAccess().getLeftCurlyBracketKeyword_6());
            		
            // InternalMyDsl.g:138:3: ( (lv_tables_7_0= ruleTable ) )
            // InternalMyDsl.g:139:4: (lv_tables_7_0= ruleTable )
            {
            // InternalMyDsl.g:139:4: (lv_tables_7_0= ruleTable )
            // InternalMyDsl.g:140:5: lv_tables_7_0= ruleTable
            {

            					newCompositeNode(grammarAccess.getModelAccess().getTablesTableParserRuleCall_7_0());
            				
            pushFollow(FOLLOW_9);
            lv_tables_7_0=ruleTable();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getModelRule());
            					}
            					add(
            						current,
            						"tables",
            						lv_tables_7_0,
            						"org.xtext.example.mydsl.MyDsl.Table");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalMyDsl.g:157:3: (otherlv_8= ',' ( (lv_tables_9_0= ruleTable ) ) )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==15) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // InternalMyDsl.g:158:4: otherlv_8= ',' ( (lv_tables_9_0= ruleTable ) )
            	    {
            	    otherlv_8=(Token)match(input,15,FOLLOW_8); 

            	    				newLeafNode(otherlv_8, grammarAccess.getModelAccess().getCommaKeyword_8_0());
            	    			
            	    // InternalMyDsl.g:162:4: ( (lv_tables_9_0= ruleTable ) )
            	    // InternalMyDsl.g:163:5: (lv_tables_9_0= ruleTable )
            	    {
            	    // InternalMyDsl.g:163:5: (lv_tables_9_0= ruleTable )
            	    // InternalMyDsl.g:164:6: lv_tables_9_0= ruleTable
            	    {

            	    						newCompositeNode(grammarAccess.getModelAccess().getTablesTableParserRuleCall_8_1_0());
            	    					
            	    pushFollow(FOLLOW_9);
            	    lv_tables_9_0=ruleTable();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getModelRule());
            	    						}
            	    						add(
            	    							current,
            	    							"tables",
            	    							lv_tables_9_0,
            	    							"org.xtext.example.mydsl.MyDsl.Table");
            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);

            otherlv_10=(Token)match(input,16,FOLLOW_10); 

            			newLeafNode(otherlv_10, grammarAccess.getModelAccess().getRightCurlyBracketKeyword_9());
            		
            otherlv_11=(Token)match(input,17,FOLLOW_4); 

            			newLeafNode(otherlv_11, grammarAccess.getModelAccess().getStepsKeyword_10());
            		
            otherlv_12=(Token)match(input,12,FOLLOW_11); 

            			newLeafNode(otherlv_12, grammarAccess.getModelAccess().getLeftCurlyBracketKeyword_11());
            		
            // InternalMyDsl.g:194:3: ( (lv_steps_13_0= ruleStep ) )
            // InternalMyDsl.g:195:4: (lv_steps_13_0= ruleStep )
            {
            // InternalMyDsl.g:195:4: (lv_steps_13_0= ruleStep )
            // InternalMyDsl.g:196:5: lv_steps_13_0= ruleStep
            {

            					newCompositeNode(grammarAccess.getModelAccess().getStepsStepParserRuleCall_12_0());
            				
            pushFollow(FOLLOW_9);
            lv_steps_13_0=ruleStep();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getModelRule());
            					}
            					add(
            						current,
            						"steps",
            						lv_steps_13_0,
            						"org.xtext.example.mydsl.MyDsl.Step");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalMyDsl.g:213:3: (otherlv_14= ',' ( (lv_steps_15_0= ruleStep ) ) )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==15) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // InternalMyDsl.g:214:4: otherlv_14= ',' ( (lv_steps_15_0= ruleStep ) )
            	    {
            	    otherlv_14=(Token)match(input,15,FOLLOW_11); 

            	    				newLeafNode(otherlv_14, grammarAccess.getModelAccess().getCommaKeyword_13_0());
            	    			
            	    // InternalMyDsl.g:218:4: ( (lv_steps_15_0= ruleStep ) )
            	    // InternalMyDsl.g:219:5: (lv_steps_15_0= ruleStep )
            	    {
            	    // InternalMyDsl.g:219:5: (lv_steps_15_0= ruleStep )
            	    // InternalMyDsl.g:220:6: lv_steps_15_0= ruleStep
            	    {

            	    						newCompositeNode(grammarAccess.getModelAccess().getStepsStepParserRuleCall_13_1_0());
            	    					
            	    pushFollow(FOLLOW_9);
            	    lv_steps_15_0=ruleStep();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getModelRule());
            	    						}
            	    						add(
            	    							current,
            	    							"steps",
            	    							lv_steps_15_0,
            	    							"org.xtext.example.mydsl.MyDsl.Step");
            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop2;
                }
            } while (true);

            otherlv_16=(Token)match(input,16,FOLLOW_12); 

            			newLeafNode(otherlv_16, grammarAccess.getModelAccess().getRightCurlyBracketKeyword_14());
            		
            otherlv_17=(Token)match(input,16,FOLLOW_2); 

            			newLeafNode(otherlv_17, grammarAccess.getModelAccess().getRightCurlyBracketKeyword_15());
            		

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
    // InternalMyDsl.g:250:1: entryRuleStep returns [EObject current=null] : iv_ruleStep= ruleStep EOF ;
    public final EObject entryRuleStep() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleStep = null;


        try {
            // InternalMyDsl.g:250:45: (iv_ruleStep= ruleStep EOF )
            // InternalMyDsl.g:251:2: iv_ruleStep= ruleStep EOF
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
    // InternalMyDsl.g:257:1: ruleStep returns [EObject current=null] : (this_Save_0= ruleSave | this_Group_1= ruleGroup | this_Sort_2= ruleSort | this_AppendRows_3= ruleAppendRows | this_Filter_4= ruleFilter | this_GenericStep_5= ruleGenericStep | this_Join_6= ruleJoin | this_Import_7= ruleImport | this_Lookup_8= ruleLookup | this_RemoveDuplicates_9= ruleRemoveDuplicates | this_Concat_10= ruleConcat | this_Split_11= ruleSplit | this_Extract_12= ruleExtract ) ;
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
            // InternalMyDsl.g:263:2: ( (this_Save_0= ruleSave | this_Group_1= ruleGroup | this_Sort_2= ruleSort | this_AppendRows_3= ruleAppendRows | this_Filter_4= ruleFilter | this_GenericStep_5= ruleGenericStep | this_Join_6= ruleJoin | this_Import_7= ruleImport | this_Lookup_8= ruleLookup | this_RemoveDuplicates_9= ruleRemoveDuplicates | this_Concat_10= ruleConcat | this_Split_11= ruleSplit | this_Extract_12= ruleExtract ) )
            // InternalMyDsl.g:264:2: (this_Save_0= ruleSave | this_Group_1= ruleGroup | this_Sort_2= ruleSort | this_AppendRows_3= ruleAppendRows | this_Filter_4= ruleFilter | this_GenericStep_5= ruleGenericStep | this_Join_6= ruleJoin | this_Import_7= ruleImport | this_Lookup_8= ruleLookup | this_RemoveDuplicates_9= ruleRemoveDuplicates | this_Concat_10= ruleConcat | this_Split_11= ruleSplit | this_Extract_12= ruleExtract )
            {
            // InternalMyDsl.g:264:2: (this_Save_0= ruleSave | this_Group_1= ruleGroup | this_Sort_2= ruleSort | this_AppendRows_3= ruleAppendRows | this_Filter_4= ruleFilter | this_GenericStep_5= ruleGenericStep | this_Join_6= ruleJoin | this_Import_7= ruleImport | this_Lookup_8= ruleLookup | this_RemoveDuplicates_9= ruleRemoveDuplicates | this_Concat_10= ruleConcat | this_Split_11= ruleSplit | this_Extract_12= ruleExtract )
            int alt3=13;
            switch ( input.LA(1) ) {
            case 22:
                {
                alt3=1;
                }
                break;
            case 25:
                {
                alt3=2;
                }
                break;
            case 35:
                {
                alt3=3;
                }
                break;
            case 38:
                {
                alt3=4;
                }
                break;
            case 42:
                {
                alt3=5;
                }
                break;
            case 45:
                {
                alt3=6;
                }
                break;
            case 46:
                {
                alt3=7;
                }
                break;
            case 53:
                {
                alt3=8;
                }
                break;
            case 55:
                {
                alt3=9;
                }
                break;
            case 59:
                {
                alt3=10;
                }
                break;
            case 60:
                {
                alt3=11;
                }
                break;
            case 63:
                {
                alt3=12;
                }
                break;
            case 69:
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
                    // InternalMyDsl.g:265:3: this_Save_0= ruleSave
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
                    // InternalMyDsl.g:274:3: this_Group_1= ruleGroup
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
                    // InternalMyDsl.g:283:3: this_Sort_2= ruleSort
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
                    // InternalMyDsl.g:292:3: this_AppendRows_3= ruleAppendRows
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
                    // InternalMyDsl.g:301:3: this_Filter_4= ruleFilter
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
                    // InternalMyDsl.g:310:3: this_GenericStep_5= ruleGenericStep
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
                    // InternalMyDsl.g:319:3: this_Join_6= ruleJoin
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
                    // InternalMyDsl.g:328:3: this_Import_7= ruleImport
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
                    // InternalMyDsl.g:337:3: this_Lookup_8= ruleLookup
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
                    // InternalMyDsl.g:346:3: this_RemoveDuplicates_9= ruleRemoveDuplicates
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
                    // InternalMyDsl.g:355:3: this_Concat_10= ruleConcat
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
                    // InternalMyDsl.g:364:3: this_Split_11= ruleSplit
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
                    // InternalMyDsl.g:373:3: this_Extract_12= ruleExtract
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
    // InternalMyDsl.g:385:1: entryRuleEString returns [String current=null] : iv_ruleEString= ruleEString EOF ;
    public final String entryRuleEString() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleEString = null;


        try {
            // InternalMyDsl.g:385:47: (iv_ruleEString= ruleEString EOF )
            // InternalMyDsl.g:386:2: iv_ruleEString= ruleEString EOF
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
    // InternalMyDsl.g:392:1: ruleEString returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_STRING_0= RULE_STRING | this_ID_1= RULE_ID ) ;
    public final AntlrDatatypeRuleToken ruleEString() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_STRING_0=null;
        Token this_ID_1=null;


        	enterRule();

        try {
            // InternalMyDsl.g:398:2: ( (this_STRING_0= RULE_STRING | this_ID_1= RULE_ID ) )
            // InternalMyDsl.g:399:2: (this_STRING_0= RULE_STRING | this_ID_1= RULE_ID )
            {
            // InternalMyDsl.g:399:2: (this_STRING_0= RULE_STRING | this_ID_1= RULE_ID )
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
                    // InternalMyDsl.g:400:3: this_STRING_0= RULE_STRING
                    {
                    this_STRING_0=(Token)match(input,RULE_STRING,FOLLOW_2); 

                    			current.merge(this_STRING_0);
                    		

                    			newLeafNode(this_STRING_0, grammarAccess.getEStringAccess().getSTRINGTerminalRuleCall_0());
                    		

                    }
                    break;
                case 2 :
                    // InternalMyDsl.g:408:3: this_ID_1= RULE_ID
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
    // InternalMyDsl.g:419:1: entryRuleTable returns [EObject current=null] : iv_ruleTable= ruleTable EOF ;
    public final EObject entryRuleTable() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTable = null;


        try {
            // InternalMyDsl.g:419:46: (iv_ruleTable= ruleTable EOF )
            // InternalMyDsl.g:420:2: iv_ruleTable= ruleTable EOF
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
    // InternalMyDsl.g:426:1: ruleTable returns [EObject current=null] : (otherlv_0= 'Table' ( (lv_name_1_0= ruleEString ) ) otherlv_2= '{' otherlv_3= 'columns' otherlv_4= '{' ( (lv_columns_5_0= ruleColumn ) ) (otherlv_6= ',' ( (lv_columns_7_0= ruleColumn ) ) )* otherlv_8= '}' otherlv_9= '}' ) ;
    public final EObject ruleTable() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        Token otherlv_8=null;
        Token otherlv_9=null;
        AntlrDatatypeRuleToken lv_name_1_0 = null;

        EObject lv_columns_5_0 = null;

        EObject lv_columns_7_0 = null;



        	enterRule();

        try {
            // InternalMyDsl.g:432:2: ( (otherlv_0= 'Table' ( (lv_name_1_0= ruleEString ) ) otherlv_2= '{' otherlv_3= 'columns' otherlv_4= '{' ( (lv_columns_5_0= ruleColumn ) ) (otherlv_6= ',' ( (lv_columns_7_0= ruleColumn ) ) )* otherlv_8= '}' otherlv_9= '}' ) )
            // InternalMyDsl.g:433:2: (otherlv_0= 'Table' ( (lv_name_1_0= ruleEString ) ) otherlv_2= '{' otherlv_3= 'columns' otherlv_4= '{' ( (lv_columns_5_0= ruleColumn ) ) (otherlv_6= ',' ( (lv_columns_7_0= ruleColumn ) ) )* otherlv_8= '}' otherlv_9= '}' )
            {
            // InternalMyDsl.g:433:2: (otherlv_0= 'Table' ( (lv_name_1_0= ruleEString ) ) otherlv_2= '{' otherlv_3= 'columns' otherlv_4= '{' ( (lv_columns_5_0= ruleColumn ) ) (otherlv_6= ',' ( (lv_columns_7_0= ruleColumn ) ) )* otherlv_8= '}' otherlv_9= '}' )
            // InternalMyDsl.g:434:3: otherlv_0= 'Table' ( (lv_name_1_0= ruleEString ) ) otherlv_2= '{' otherlv_3= 'columns' otherlv_4= '{' ( (lv_columns_5_0= ruleColumn ) ) (otherlv_6= ',' ( (lv_columns_7_0= ruleColumn ) ) )* otherlv_8= '}' otherlv_9= '}'
            {
            otherlv_0=(Token)match(input,18,FOLLOW_3); 

            			newLeafNode(otherlv_0, grammarAccess.getTableAccess().getTableKeyword_0());
            		
            // InternalMyDsl.g:438:3: ( (lv_name_1_0= ruleEString ) )
            // InternalMyDsl.g:439:4: (lv_name_1_0= ruleEString )
            {
            // InternalMyDsl.g:439:4: (lv_name_1_0= ruleEString )
            // InternalMyDsl.g:440:5: lv_name_1_0= ruleEString
            {

            					newCompositeNode(grammarAccess.getTableAccess().getNameEStringParserRuleCall_1_0());
            				
            pushFollow(FOLLOW_4);
            lv_name_1_0=ruleEString();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getTableRule());
            					}
            					set(
            						current,
            						"name",
            						lv_name_1_0,
            						"org.xtext.example.mydsl.MyDsl.EString");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_2=(Token)match(input,12,FOLLOW_13); 

            			newLeafNode(otherlv_2, grammarAccess.getTableAccess().getLeftCurlyBracketKeyword_2());
            		
            otherlv_3=(Token)match(input,19,FOLLOW_4); 

            			newLeafNode(otherlv_3, grammarAccess.getTableAccess().getColumnsKeyword_3());
            		
            otherlv_4=(Token)match(input,12,FOLLOW_14); 

            			newLeafNode(otherlv_4, grammarAccess.getTableAccess().getLeftCurlyBracketKeyword_4());
            		
            // InternalMyDsl.g:469:3: ( (lv_columns_5_0= ruleColumn ) )
            // InternalMyDsl.g:470:4: (lv_columns_5_0= ruleColumn )
            {
            // InternalMyDsl.g:470:4: (lv_columns_5_0= ruleColumn )
            // InternalMyDsl.g:471:5: lv_columns_5_0= ruleColumn
            {

            					newCompositeNode(grammarAccess.getTableAccess().getColumnsColumnParserRuleCall_5_0());
            				
            pushFollow(FOLLOW_9);
            lv_columns_5_0=ruleColumn();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getTableRule());
            					}
            					add(
            						current,
            						"columns",
            						lv_columns_5_0,
            						"org.xtext.example.mydsl.MyDsl.Column");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalMyDsl.g:488:3: (otherlv_6= ',' ( (lv_columns_7_0= ruleColumn ) ) )*
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( (LA5_0==15) ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // InternalMyDsl.g:489:4: otherlv_6= ',' ( (lv_columns_7_0= ruleColumn ) )
            	    {
            	    otherlv_6=(Token)match(input,15,FOLLOW_14); 

            	    				newLeafNode(otherlv_6, grammarAccess.getTableAccess().getCommaKeyword_6_0());
            	    			
            	    // InternalMyDsl.g:493:4: ( (lv_columns_7_0= ruleColumn ) )
            	    // InternalMyDsl.g:494:5: (lv_columns_7_0= ruleColumn )
            	    {
            	    // InternalMyDsl.g:494:5: (lv_columns_7_0= ruleColumn )
            	    // InternalMyDsl.g:495:6: lv_columns_7_0= ruleColumn
            	    {

            	    						newCompositeNode(grammarAccess.getTableAccess().getColumnsColumnParserRuleCall_6_1_0());
            	    					
            	    pushFollow(FOLLOW_9);
            	    lv_columns_7_0=ruleColumn();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getTableRule());
            	    						}
            	    						add(
            	    							current,
            	    							"columns",
            	    							lv_columns_7_0,
            	    							"org.xtext.example.mydsl.MyDsl.Column");
            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop5;
                }
            } while (true);

            otherlv_8=(Token)match(input,16,FOLLOW_12); 

            			newLeafNode(otherlv_8, grammarAccess.getTableAccess().getRightCurlyBracketKeyword_7());
            		
            otherlv_9=(Token)match(input,16,FOLLOW_2); 

            			newLeafNode(otherlv_9, grammarAccess.getTableAccess().getRightCurlyBracketKeyword_8());
            		

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
    // InternalMyDsl.g:525:1: entryRuleColumn returns [EObject current=null] : iv_ruleColumn= ruleColumn EOF ;
    public final EObject entryRuleColumn() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleColumn = null;


        try {
            // InternalMyDsl.g:525:47: (iv_ruleColumn= ruleColumn EOF )
            // InternalMyDsl.g:526:2: iv_ruleColumn= ruleColumn EOF
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
    // InternalMyDsl.g:532:1: ruleColumn returns [EObject current=null] : (otherlv_0= 'Column' ( (lv_name_1_0= ruleEString ) ) otherlv_2= '{' otherlv_3= 'dataType' ( (lv_dataType_4_0= ruleDataType ) ) otherlv_5= '}' ) ;
    public final EObject ruleColumn() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        AntlrDatatypeRuleToken lv_name_1_0 = null;

        Enumerator lv_dataType_4_0 = null;



        	enterRule();

        try {
            // InternalMyDsl.g:538:2: ( (otherlv_0= 'Column' ( (lv_name_1_0= ruleEString ) ) otherlv_2= '{' otherlv_3= 'dataType' ( (lv_dataType_4_0= ruleDataType ) ) otherlv_5= '}' ) )
            // InternalMyDsl.g:539:2: (otherlv_0= 'Column' ( (lv_name_1_0= ruleEString ) ) otherlv_2= '{' otherlv_3= 'dataType' ( (lv_dataType_4_0= ruleDataType ) ) otherlv_5= '}' )
            {
            // InternalMyDsl.g:539:2: (otherlv_0= 'Column' ( (lv_name_1_0= ruleEString ) ) otherlv_2= '{' otherlv_3= 'dataType' ( (lv_dataType_4_0= ruleDataType ) ) otherlv_5= '}' )
            // InternalMyDsl.g:540:3: otherlv_0= 'Column' ( (lv_name_1_0= ruleEString ) ) otherlv_2= '{' otherlv_3= 'dataType' ( (lv_dataType_4_0= ruleDataType ) ) otherlv_5= '}'
            {
            otherlv_0=(Token)match(input,20,FOLLOW_3); 

            			newLeafNode(otherlv_0, grammarAccess.getColumnAccess().getColumnKeyword_0());
            		
            // InternalMyDsl.g:544:3: ( (lv_name_1_0= ruleEString ) )
            // InternalMyDsl.g:545:4: (lv_name_1_0= ruleEString )
            {
            // InternalMyDsl.g:545:4: (lv_name_1_0= ruleEString )
            // InternalMyDsl.g:546:5: lv_name_1_0= ruleEString
            {

            					newCompositeNode(grammarAccess.getColumnAccess().getNameEStringParserRuleCall_1_0());
            				
            pushFollow(FOLLOW_4);
            lv_name_1_0=ruleEString();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getColumnRule());
            					}
            					set(
            						current,
            						"name",
            						lv_name_1_0,
            						"org.xtext.example.mydsl.MyDsl.EString");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_2=(Token)match(input,12,FOLLOW_15); 

            			newLeafNode(otherlv_2, grammarAccess.getColumnAccess().getLeftCurlyBracketKeyword_2());
            		
            otherlv_3=(Token)match(input,21,FOLLOW_16); 

            			newLeafNode(otherlv_3, grammarAccess.getColumnAccess().getDataTypeKeyword_3());
            		
            // InternalMyDsl.g:571:3: ( (lv_dataType_4_0= ruleDataType ) )
            // InternalMyDsl.g:572:4: (lv_dataType_4_0= ruleDataType )
            {
            // InternalMyDsl.g:572:4: (lv_dataType_4_0= ruleDataType )
            // InternalMyDsl.g:573:5: lv_dataType_4_0= ruleDataType
            {

            					newCompositeNode(grammarAccess.getColumnAccess().getDataTypeDataTypeEnumRuleCall_4_0());
            				
            pushFollow(FOLLOW_12);
            lv_dataType_4_0=ruleDataType();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getColumnRule());
            					}
            					set(
            						current,
            						"dataType",
            						lv_dataType_4_0,
            						"org.xtext.example.mydsl.MyDsl.DataType");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_5=(Token)match(input,16,FOLLOW_2); 

            			newLeafNode(otherlv_5, grammarAccess.getColumnAccess().getRightCurlyBracketKeyword_5());
            		

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
    // InternalMyDsl.g:598:1: entryRuleSave returns [EObject current=null] : iv_ruleSave= ruleSave EOF ;
    public final EObject entryRuleSave() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSave = null;


        try {
            // InternalMyDsl.g:598:45: (iv_ruleSave= ruleSave EOF )
            // InternalMyDsl.g:599:2: iv_ruleSave= ruleSave EOF
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
    // InternalMyDsl.g:605:1: ruleSave returns [EObject current=null] : (otherlv_0= 'Save' ( (lv_name_1_0= ruleEString ) ) otherlv_2= '{' (otherlv_3= 'description' ( (lv_description_4_0= ruleEString ) ) )? otherlv_5= 'tablesToSave' otherlv_6= '{' ( (lv_tablesToSave_7_0= ruleTableToSave ) ) (otherlv_8= ',' ( (lv_tablesToSave_9_0= ruleTableToSave ) ) )* otherlv_10= '}' otherlv_11= '}' ) ;
    public final EObject ruleSave() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Token otherlv_6=null;
        Token otherlv_8=null;
        Token otherlv_10=null;
        Token otherlv_11=null;
        AntlrDatatypeRuleToken lv_name_1_0 = null;

        AntlrDatatypeRuleToken lv_description_4_0 = null;

        EObject lv_tablesToSave_7_0 = null;

        EObject lv_tablesToSave_9_0 = null;



        	enterRule();

        try {
            // InternalMyDsl.g:611:2: ( (otherlv_0= 'Save' ( (lv_name_1_0= ruleEString ) ) otherlv_2= '{' (otherlv_3= 'description' ( (lv_description_4_0= ruleEString ) ) )? otherlv_5= 'tablesToSave' otherlv_6= '{' ( (lv_tablesToSave_7_0= ruleTableToSave ) ) (otherlv_8= ',' ( (lv_tablesToSave_9_0= ruleTableToSave ) ) )* otherlv_10= '}' otherlv_11= '}' ) )
            // InternalMyDsl.g:612:2: (otherlv_0= 'Save' ( (lv_name_1_0= ruleEString ) ) otherlv_2= '{' (otherlv_3= 'description' ( (lv_description_4_0= ruleEString ) ) )? otherlv_5= 'tablesToSave' otherlv_6= '{' ( (lv_tablesToSave_7_0= ruleTableToSave ) ) (otherlv_8= ',' ( (lv_tablesToSave_9_0= ruleTableToSave ) ) )* otherlv_10= '}' otherlv_11= '}' )
            {
            // InternalMyDsl.g:612:2: (otherlv_0= 'Save' ( (lv_name_1_0= ruleEString ) ) otherlv_2= '{' (otherlv_3= 'description' ( (lv_description_4_0= ruleEString ) ) )? otherlv_5= 'tablesToSave' otherlv_6= '{' ( (lv_tablesToSave_7_0= ruleTableToSave ) ) (otherlv_8= ',' ( (lv_tablesToSave_9_0= ruleTableToSave ) ) )* otherlv_10= '}' otherlv_11= '}' )
            // InternalMyDsl.g:613:3: otherlv_0= 'Save' ( (lv_name_1_0= ruleEString ) ) otherlv_2= '{' (otherlv_3= 'description' ( (lv_description_4_0= ruleEString ) ) )? otherlv_5= 'tablesToSave' otherlv_6= '{' ( (lv_tablesToSave_7_0= ruleTableToSave ) ) (otherlv_8= ',' ( (lv_tablesToSave_9_0= ruleTableToSave ) ) )* otherlv_10= '}' otherlv_11= '}'
            {
            otherlv_0=(Token)match(input,22,FOLLOW_3); 

            			newLeafNode(otherlv_0, grammarAccess.getSaveAccess().getSaveKeyword_0());
            		
            // InternalMyDsl.g:617:3: ( (lv_name_1_0= ruleEString ) )
            // InternalMyDsl.g:618:4: (lv_name_1_0= ruleEString )
            {
            // InternalMyDsl.g:618:4: (lv_name_1_0= ruleEString )
            // InternalMyDsl.g:619:5: lv_name_1_0= ruleEString
            {

            					newCompositeNode(grammarAccess.getSaveAccess().getNameEStringParserRuleCall_1_0());
            				
            pushFollow(FOLLOW_4);
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

            otherlv_2=(Token)match(input,12,FOLLOW_17); 

            			newLeafNode(otherlv_2, grammarAccess.getSaveAccess().getLeftCurlyBracketKeyword_2());
            		
            // InternalMyDsl.g:640:3: (otherlv_3= 'description' ( (lv_description_4_0= ruleEString ) ) )?
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==23) ) {
                alt6=1;
            }
            switch (alt6) {
                case 1 :
                    // InternalMyDsl.g:641:4: otherlv_3= 'description' ( (lv_description_4_0= ruleEString ) )
                    {
                    otherlv_3=(Token)match(input,23,FOLLOW_3); 

                    				newLeafNode(otherlv_3, grammarAccess.getSaveAccess().getDescriptionKeyword_3_0());
                    			
                    // InternalMyDsl.g:645:4: ( (lv_description_4_0= ruleEString ) )
                    // InternalMyDsl.g:646:5: (lv_description_4_0= ruleEString )
                    {
                    // InternalMyDsl.g:646:5: (lv_description_4_0= ruleEString )
                    // InternalMyDsl.g:647:6: lv_description_4_0= ruleEString
                    {

                    						newCompositeNode(grammarAccess.getSaveAccess().getDescriptionEStringParserRuleCall_3_1_0());
                    					
                    pushFollow(FOLLOW_18);
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

            otherlv_5=(Token)match(input,24,FOLLOW_4); 

            			newLeafNode(otherlv_5, grammarAccess.getSaveAccess().getTablesToSaveKeyword_4());
            		
            otherlv_6=(Token)match(input,12,FOLLOW_19); 

            			newLeafNode(otherlv_6, grammarAccess.getSaveAccess().getLeftCurlyBracketKeyword_5());
            		
            // InternalMyDsl.g:673:3: ( (lv_tablesToSave_7_0= ruleTableToSave ) )
            // InternalMyDsl.g:674:4: (lv_tablesToSave_7_0= ruleTableToSave )
            {
            // InternalMyDsl.g:674:4: (lv_tablesToSave_7_0= ruleTableToSave )
            // InternalMyDsl.g:675:5: lv_tablesToSave_7_0= ruleTableToSave
            {

            					newCompositeNode(grammarAccess.getSaveAccess().getTablesToSaveTableToSaveParserRuleCall_6_0());
            				
            pushFollow(FOLLOW_9);
            lv_tablesToSave_7_0=ruleTableToSave();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getSaveRule());
            					}
            					add(
            						current,
            						"tablesToSave",
            						lv_tablesToSave_7_0,
            						"org.xtext.example.mydsl.MyDsl.TableToSave");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalMyDsl.g:692:3: (otherlv_8= ',' ( (lv_tablesToSave_9_0= ruleTableToSave ) ) )*
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( (LA7_0==15) ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // InternalMyDsl.g:693:4: otherlv_8= ',' ( (lv_tablesToSave_9_0= ruleTableToSave ) )
            	    {
            	    otherlv_8=(Token)match(input,15,FOLLOW_19); 

            	    				newLeafNode(otherlv_8, grammarAccess.getSaveAccess().getCommaKeyword_7_0());
            	    			
            	    // InternalMyDsl.g:697:4: ( (lv_tablesToSave_9_0= ruleTableToSave ) )
            	    // InternalMyDsl.g:698:5: (lv_tablesToSave_9_0= ruleTableToSave )
            	    {
            	    // InternalMyDsl.g:698:5: (lv_tablesToSave_9_0= ruleTableToSave )
            	    // InternalMyDsl.g:699:6: lv_tablesToSave_9_0= ruleTableToSave
            	    {

            	    						newCompositeNode(grammarAccess.getSaveAccess().getTablesToSaveTableToSaveParserRuleCall_7_1_0());
            	    					
            	    pushFollow(FOLLOW_9);
            	    lv_tablesToSave_9_0=ruleTableToSave();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getSaveRule());
            	    						}
            	    						add(
            	    							current,
            	    							"tablesToSave",
            	    							lv_tablesToSave_9_0,
            	    							"org.xtext.example.mydsl.MyDsl.TableToSave");
            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop7;
                }
            } while (true);

            otherlv_10=(Token)match(input,16,FOLLOW_12); 

            			newLeafNode(otherlv_10, grammarAccess.getSaveAccess().getRightCurlyBracketKeyword_8());
            		
            otherlv_11=(Token)match(input,16,FOLLOW_2); 

            			newLeafNode(otherlv_11, grammarAccess.getSaveAccess().getRightCurlyBracketKeyword_9());
            		

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
    // InternalMyDsl.g:729:1: entryRuleGroup returns [EObject current=null] : iv_ruleGroup= ruleGroup EOF ;
    public final EObject entryRuleGroup() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleGroup = null;


        try {
            // InternalMyDsl.g:729:46: (iv_ruleGroup= ruleGroup EOF )
            // InternalMyDsl.g:730:2: iv_ruleGroup= ruleGroup EOF
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
    // InternalMyDsl.g:736:1: ruleGroup returns [EObject current=null] : (otherlv_0= 'Group' ( (lv_name_1_0= ruleEString ) ) otherlv_2= '{' (otherlv_3= 'description' ( (lv_description_4_0= ruleEString ) ) )? otherlv_5= 'table' ( ( ruleEString ) ) otherlv_7= 'groupBy' otherlv_8= '(' ( ( ruleEString ) ) (otherlv_10= ',' ( ( ruleEString ) ) )* otherlv_12= ')' otherlv_13= 'operation' ( (lv_operation_14_0= ruleGroupOperationType ) ) otherlv_15= 'operandColumn' ( ( ruleEString ) ) otherlv_17= 'resultTable' ( ( ruleEString ) ) otherlv_19= 'resultColumn' ( ( ruleEString ) ) otherlv_21= 'next' ( ( ruleEString ) ) otherlv_23= '}' ) ;
    public final EObject ruleGroup() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        Token otherlv_8=null;
        Token otherlv_10=null;
        Token otherlv_12=null;
        Token otherlv_13=null;
        Token otherlv_15=null;
        Token otherlv_17=null;
        Token otherlv_19=null;
        Token otherlv_21=null;
        Token otherlv_23=null;
        AntlrDatatypeRuleToken lv_name_1_0 = null;

        AntlrDatatypeRuleToken lv_description_4_0 = null;

        Enumerator lv_operation_14_0 = null;



        	enterRule();

        try {
            // InternalMyDsl.g:742:2: ( (otherlv_0= 'Group' ( (lv_name_1_0= ruleEString ) ) otherlv_2= '{' (otherlv_3= 'description' ( (lv_description_4_0= ruleEString ) ) )? otherlv_5= 'table' ( ( ruleEString ) ) otherlv_7= 'groupBy' otherlv_8= '(' ( ( ruleEString ) ) (otherlv_10= ',' ( ( ruleEString ) ) )* otherlv_12= ')' otherlv_13= 'operation' ( (lv_operation_14_0= ruleGroupOperationType ) ) otherlv_15= 'operandColumn' ( ( ruleEString ) ) otherlv_17= 'resultTable' ( ( ruleEString ) ) otherlv_19= 'resultColumn' ( ( ruleEString ) ) otherlv_21= 'next' ( ( ruleEString ) ) otherlv_23= '}' ) )
            // InternalMyDsl.g:743:2: (otherlv_0= 'Group' ( (lv_name_1_0= ruleEString ) ) otherlv_2= '{' (otherlv_3= 'description' ( (lv_description_4_0= ruleEString ) ) )? otherlv_5= 'table' ( ( ruleEString ) ) otherlv_7= 'groupBy' otherlv_8= '(' ( ( ruleEString ) ) (otherlv_10= ',' ( ( ruleEString ) ) )* otherlv_12= ')' otherlv_13= 'operation' ( (lv_operation_14_0= ruleGroupOperationType ) ) otherlv_15= 'operandColumn' ( ( ruleEString ) ) otherlv_17= 'resultTable' ( ( ruleEString ) ) otherlv_19= 'resultColumn' ( ( ruleEString ) ) otherlv_21= 'next' ( ( ruleEString ) ) otherlv_23= '}' )
            {
            // InternalMyDsl.g:743:2: (otherlv_0= 'Group' ( (lv_name_1_0= ruleEString ) ) otherlv_2= '{' (otherlv_3= 'description' ( (lv_description_4_0= ruleEString ) ) )? otherlv_5= 'table' ( ( ruleEString ) ) otherlv_7= 'groupBy' otherlv_8= '(' ( ( ruleEString ) ) (otherlv_10= ',' ( ( ruleEString ) ) )* otherlv_12= ')' otherlv_13= 'operation' ( (lv_operation_14_0= ruleGroupOperationType ) ) otherlv_15= 'operandColumn' ( ( ruleEString ) ) otherlv_17= 'resultTable' ( ( ruleEString ) ) otherlv_19= 'resultColumn' ( ( ruleEString ) ) otherlv_21= 'next' ( ( ruleEString ) ) otherlv_23= '}' )
            // InternalMyDsl.g:744:3: otherlv_0= 'Group' ( (lv_name_1_0= ruleEString ) ) otherlv_2= '{' (otherlv_3= 'description' ( (lv_description_4_0= ruleEString ) ) )? otherlv_5= 'table' ( ( ruleEString ) ) otherlv_7= 'groupBy' otherlv_8= '(' ( ( ruleEString ) ) (otherlv_10= ',' ( ( ruleEString ) ) )* otherlv_12= ')' otherlv_13= 'operation' ( (lv_operation_14_0= ruleGroupOperationType ) ) otherlv_15= 'operandColumn' ( ( ruleEString ) ) otherlv_17= 'resultTable' ( ( ruleEString ) ) otherlv_19= 'resultColumn' ( ( ruleEString ) ) otherlv_21= 'next' ( ( ruleEString ) ) otherlv_23= '}'
            {
            otherlv_0=(Token)match(input,25,FOLLOW_3); 

            			newLeafNode(otherlv_0, grammarAccess.getGroupAccess().getGroupKeyword_0());
            		
            // InternalMyDsl.g:748:3: ( (lv_name_1_0= ruleEString ) )
            // InternalMyDsl.g:749:4: (lv_name_1_0= ruleEString )
            {
            // InternalMyDsl.g:749:4: (lv_name_1_0= ruleEString )
            // InternalMyDsl.g:750:5: lv_name_1_0= ruleEString
            {

            					newCompositeNode(grammarAccess.getGroupAccess().getNameEStringParserRuleCall_1_0());
            				
            pushFollow(FOLLOW_4);
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

            otherlv_2=(Token)match(input,12,FOLLOW_20); 

            			newLeafNode(otherlv_2, grammarAccess.getGroupAccess().getLeftCurlyBracketKeyword_2());
            		
            // InternalMyDsl.g:771:3: (otherlv_3= 'description' ( (lv_description_4_0= ruleEString ) ) )?
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==23) ) {
                alt8=1;
            }
            switch (alt8) {
                case 1 :
                    // InternalMyDsl.g:772:4: otherlv_3= 'description' ( (lv_description_4_0= ruleEString ) )
                    {
                    otherlv_3=(Token)match(input,23,FOLLOW_3); 

                    				newLeafNode(otherlv_3, grammarAccess.getGroupAccess().getDescriptionKeyword_3_0());
                    			
                    // InternalMyDsl.g:776:4: ( (lv_description_4_0= ruleEString ) )
                    // InternalMyDsl.g:777:5: (lv_description_4_0= ruleEString )
                    {
                    // InternalMyDsl.g:777:5: (lv_description_4_0= ruleEString )
                    // InternalMyDsl.g:778:6: lv_description_4_0= ruleEString
                    {

                    						newCompositeNode(grammarAccess.getGroupAccess().getDescriptionEStringParserRuleCall_3_1_0());
                    					
                    pushFollow(FOLLOW_21);
                    lv_description_4_0=ruleEString();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getGroupRule());
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

            otherlv_5=(Token)match(input,26,FOLLOW_3); 

            			newLeafNode(otherlv_5, grammarAccess.getGroupAccess().getTableKeyword_4());
            		
            // InternalMyDsl.g:800:3: ( ( ruleEString ) )
            // InternalMyDsl.g:801:4: ( ruleEString )
            {
            // InternalMyDsl.g:801:4: ( ruleEString )
            // InternalMyDsl.g:802:5: ruleEString
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getGroupRule());
            					}
            				

            					newCompositeNode(grammarAccess.getGroupAccess().getTableTableCrossReference_5_0());
            				
            pushFollow(FOLLOW_22);
            ruleEString();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_7=(Token)match(input,27,FOLLOW_23); 

            			newLeafNode(otherlv_7, grammarAccess.getGroupAccess().getGroupByKeyword_6());
            		
            otherlv_8=(Token)match(input,28,FOLLOW_3); 

            			newLeafNode(otherlv_8, grammarAccess.getGroupAccess().getLeftParenthesisKeyword_7());
            		
            // InternalMyDsl.g:824:3: ( ( ruleEString ) )
            // InternalMyDsl.g:825:4: ( ruleEString )
            {
            // InternalMyDsl.g:825:4: ( ruleEString )
            // InternalMyDsl.g:826:5: ruleEString
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getGroupRule());
            					}
            				

            					newCompositeNode(grammarAccess.getGroupAccess().getGroupByColumnCrossReference_8_0());
            				
            pushFollow(FOLLOW_24);
            ruleEString();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalMyDsl.g:840:3: (otherlv_10= ',' ( ( ruleEString ) ) )*
            loop9:
            do {
                int alt9=2;
                int LA9_0 = input.LA(1);

                if ( (LA9_0==15) ) {
                    alt9=1;
                }


                switch (alt9) {
            	case 1 :
            	    // InternalMyDsl.g:841:4: otherlv_10= ',' ( ( ruleEString ) )
            	    {
            	    otherlv_10=(Token)match(input,15,FOLLOW_3); 

            	    				newLeafNode(otherlv_10, grammarAccess.getGroupAccess().getCommaKeyword_9_0());
            	    			
            	    // InternalMyDsl.g:845:4: ( ( ruleEString ) )
            	    // InternalMyDsl.g:846:5: ( ruleEString )
            	    {
            	    // InternalMyDsl.g:846:5: ( ruleEString )
            	    // InternalMyDsl.g:847:6: ruleEString
            	    {

            	    						if (current==null) {
            	    							current = createModelElement(grammarAccess.getGroupRule());
            	    						}
            	    					

            	    						newCompositeNode(grammarAccess.getGroupAccess().getGroupByColumnCrossReference_9_1_0());
            	    					
            	    pushFollow(FOLLOW_24);
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

            otherlv_12=(Token)match(input,29,FOLLOW_25); 

            			newLeafNode(otherlv_12, grammarAccess.getGroupAccess().getRightParenthesisKeyword_10());
            		
            otherlv_13=(Token)match(input,30,FOLLOW_26); 

            			newLeafNode(otherlv_13, grammarAccess.getGroupAccess().getOperationKeyword_11());
            		
            // InternalMyDsl.g:870:3: ( (lv_operation_14_0= ruleGroupOperationType ) )
            // InternalMyDsl.g:871:4: (lv_operation_14_0= ruleGroupOperationType )
            {
            // InternalMyDsl.g:871:4: (lv_operation_14_0= ruleGroupOperationType )
            // InternalMyDsl.g:872:5: lv_operation_14_0= ruleGroupOperationType
            {

            					newCompositeNode(grammarAccess.getGroupAccess().getOperationGroupOperationTypeEnumRuleCall_12_0());
            				
            pushFollow(FOLLOW_27);
            lv_operation_14_0=ruleGroupOperationType();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getGroupRule());
            					}
            					set(
            						current,
            						"operation",
            						lv_operation_14_0,
            						"org.xtext.example.mydsl.MyDsl.GroupOperationType");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_15=(Token)match(input,31,FOLLOW_3); 

            			newLeafNode(otherlv_15, grammarAccess.getGroupAccess().getOperandColumnKeyword_13());
            		
            // InternalMyDsl.g:893:3: ( ( ruleEString ) )
            // InternalMyDsl.g:894:4: ( ruleEString )
            {
            // InternalMyDsl.g:894:4: ( ruleEString )
            // InternalMyDsl.g:895:5: ruleEString
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getGroupRule());
            					}
            				

            					newCompositeNode(grammarAccess.getGroupAccess().getOperandColumnColumnCrossReference_14_0());
            				
            pushFollow(FOLLOW_28);
            ruleEString();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_17=(Token)match(input,32,FOLLOW_3); 

            			newLeafNode(otherlv_17, grammarAccess.getGroupAccess().getResultTableKeyword_15());
            		
            // InternalMyDsl.g:913:3: ( ( ruleEString ) )
            // InternalMyDsl.g:914:4: ( ruleEString )
            {
            // InternalMyDsl.g:914:4: ( ruleEString )
            // InternalMyDsl.g:915:5: ruleEString
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getGroupRule());
            					}
            				

            					newCompositeNode(grammarAccess.getGroupAccess().getResultTableTableCrossReference_16_0());
            				
            pushFollow(FOLLOW_29);
            ruleEString();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_19=(Token)match(input,33,FOLLOW_3); 

            			newLeafNode(otherlv_19, grammarAccess.getGroupAccess().getResultColumnKeyword_17());
            		
            // InternalMyDsl.g:933:3: ( ( ruleEString ) )
            // InternalMyDsl.g:934:4: ( ruleEString )
            {
            // InternalMyDsl.g:934:4: ( ruleEString )
            // InternalMyDsl.g:935:5: ruleEString
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getGroupRule());
            					}
            				

            					newCompositeNode(grammarAccess.getGroupAccess().getResultColumnColumnCrossReference_18_0());
            				
            pushFollow(FOLLOW_30);
            ruleEString();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_21=(Token)match(input,34,FOLLOW_3); 

            			newLeafNode(otherlv_21, grammarAccess.getGroupAccess().getNextKeyword_19());
            		
            // InternalMyDsl.g:953:3: ( ( ruleEString ) )
            // InternalMyDsl.g:954:4: ( ruleEString )
            {
            // InternalMyDsl.g:954:4: ( ruleEString )
            // InternalMyDsl.g:955:5: ruleEString
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getGroupRule());
            					}
            				

            					newCompositeNode(grammarAccess.getGroupAccess().getNextStepCrossReference_20_0());
            				
            pushFollow(FOLLOW_12);
            ruleEString();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_23=(Token)match(input,16,FOLLOW_2); 

            			newLeafNode(otherlv_23, grammarAccess.getGroupAccess().getRightCurlyBracketKeyword_21());
            		

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
    // InternalMyDsl.g:977:1: entryRuleSort returns [EObject current=null] : iv_ruleSort= ruleSort EOF ;
    public final EObject entryRuleSort() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSort = null;


        try {
            // InternalMyDsl.g:977:45: (iv_ruleSort= ruleSort EOF )
            // InternalMyDsl.g:978:2: iv_ruleSort= ruleSort EOF
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
    // InternalMyDsl.g:984:1: ruleSort returns [EObject current=null] : (otherlv_0= 'Sort' ( (lv_name_1_0= ruleEString ) ) otherlv_2= '{' (otherlv_3= 'description' ( (lv_description_4_0= ruleEString ) ) )? otherlv_5= 'table' ( ( ruleEString ) ) otherlv_7= 'column' ( ( ruleEString ) ) otherlv_9= 'order' ( (lv_order_10_0= ruleOrderType ) ) otherlv_11= 'next' ( ( ruleEString ) ) otherlv_13= '}' ) ;
    public final EObject ruleSort() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        Token otherlv_9=null;
        Token otherlv_11=null;
        Token otherlv_13=null;
        AntlrDatatypeRuleToken lv_name_1_0 = null;

        AntlrDatatypeRuleToken lv_description_4_0 = null;

        Enumerator lv_order_10_0 = null;



        	enterRule();

        try {
            // InternalMyDsl.g:990:2: ( (otherlv_0= 'Sort' ( (lv_name_1_0= ruleEString ) ) otherlv_2= '{' (otherlv_3= 'description' ( (lv_description_4_0= ruleEString ) ) )? otherlv_5= 'table' ( ( ruleEString ) ) otherlv_7= 'column' ( ( ruleEString ) ) otherlv_9= 'order' ( (lv_order_10_0= ruleOrderType ) ) otherlv_11= 'next' ( ( ruleEString ) ) otherlv_13= '}' ) )
            // InternalMyDsl.g:991:2: (otherlv_0= 'Sort' ( (lv_name_1_0= ruleEString ) ) otherlv_2= '{' (otherlv_3= 'description' ( (lv_description_4_0= ruleEString ) ) )? otherlv_5= 'table' ( ( ruleEString ) ) otherlv_7= 'column' ( ( ruleEString ) ) otherlv_9= 'order' ( (lv_order_10_0= ruleOrderType ) ) otherlv_11= 'next' ( ( ruleEString ) ) otherlv_13= '}' )
            {
            // InternalMyDsl.g:991:2: (otherlv_0= 'Sort' ( (lv_name_1_0= ruleEString ) ) otherlv_2= '{' (otherlv_3= 'description' ( (lv_description_4_0= ruleEString ) ) )? otherlv_5= 'table' ( ( ruleEString ) ) otherlv_7= 'column' ( ( ruleEString ) ) otherlv_9= 'order' ( (lv_order_10_0= ruleOrderType ) ) otherlv_11= 'next' ( ( ruleEString ) ) otherlv_13= '}' )
            // InternalMyDsl.g:992:3: otherlv_0= 'Sort' ( (lv_name_1_0= ruleEString ) ) otherlv_2= '{' (otherlv_3= 'description' ( (lv_description_4_0= ruleEString ) ) )? otherlv_5= 'table' ( ( ruleEString ) ) otherlv_7= 'column' ( ( ruleEString ) ) otherlv_9= 'order' ( (lv_order_10_0= ruleOrderType ) ) otherlv_11= 'next' ( ( ruleEString ) ) otherlv_13= '}'
            {
            otherlv_0=(Token)match(input,35,FOLLOW_3); 

            			newLeafNode(otherlv_0, grammarAccess.getSortAccess().getSortKeyword_0());
            		
            // InternalMyDsl.g:996:3: ( (lv_name_1_0= ruleEString ) )
            // InternalMyDsl.g:997:4: (lv_name_1_0= ruleEString )
            {
            // InternalMyDsl.g:997:4: (lv_name_1_0= ruleEString )
            // InternalMyDsl.g:998:5: lv_name_1_0= ruleEString
            {

            					newCompositeNode(grammarAccess.getSortAccess().getNameEStringParserRuleCall_1_0());
            				
            pushFollow(FOLLOW_4);
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

            otherlv_2=(Token)match(input,12,FOLLOW_20); 

            			newLeafNode(otherlv_2, grammarAccess.getSortAccess().getLeftCurlyBracketKeyword_2());
            		
            // InternalMyDsl.g:1019:3: (otherlv_3= 'description' ( (lv_description_4_0= ruleEString ) ) )?
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==23) ) {
                alt10=1;
            }
            switch (alt10) {
                case 1 :
                    // InternalMyDsl.g:1020:4: otherlv_3= 'description' ( (lv_description_4_0= ruleEString ) )
                    {
                    otherlv_3=(Token)match(input,23,FOLLOW_3); 

                    				newLeafNode(otherlv_3, grammarAccess.getSortAccess().getDescriptionKeyword_3_0());
                    			
                    // InternalMyDsl.g:1024:4: ( (lv_description_4_0= ruleEString ) )
                    // InternalMyDsl.g:1025:5: (lv_description_4_0= ruleEString )
                    {
                    // InternalMyDsl.g:1025:5: (lv_description_4_0= ruleEString )
                    // InternalMyDsl.g:1026:6: lv_description_4_0= ruleEString
                    {

                    						newCompositeNode(grammarAccess.getSortAccess().getDescriptionEStringParserRuleCall_3_1_0());
                    					
                    pushFollow(FOLLOW_21);
                    lv_description_4_0=ruleEString();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getSortRule());
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

            otherlv_5=(Token)match(input,26,FOLLOW_3); 

            			newLeafNode(otherlv_5, grammarAccess.getSortAccess().getTableKeyword_4());
            		
            // InternalMyDsl.g:1048:3: ( ( ruleEString ) )
            // InternalMyDsl.g:1049:4: ( ruleEString )
            {
            // InternalMyDsl.g:1049:4: ( ruleEString )
            // InternalMyDsl.g:1050:5: ruleEString
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getSortRule());
            					}
            				

            					newCompositeNode(grammarAccess.getSortAccess().getTableTableCrossReference_5_0());
            				
            pushFollow(FOLLOW_31);
            ruleEString();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_7=(Token)match(input,36,FOLLOW_3); 

            			newLeafNode(otherlv_7, grammarAccess.getSortAccess().getColumnKeyword_6());
            		
            // InternalMyDsl.g:1068:3: ( ( ruleEString ) )
            // InternalMyDsl.g:1069:4: ( ruleEString )
            {
            // InternalMyDsl.g:1069:4: ( ruleEString )
            // InternalMyDsl.g:1070:5: ruleEString
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getSortRule());
            					}
            				

            					newCompositeNode(grammarAccess.getSortAccess().getColumnColumnCrossReference_7_0());
            				
            pushFollow(FOLLOW_32);
            ruleEString();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_9=(Token)match(input,37,FOLLOW_33); 

            			newLeafNode(otherlv_9, grammarAccess.getSortAccess().getOrderKeyword_8());
            		
            // InternalMyDsl.g:1088:3: ( (lv_order_10_0= ruleOrderType ) )
            // InternalMyDsl.g:1089:4: (lv_order_10_0= ruleOrderType )
            {
            // InternalMyDsl.g:1089:4: (lv_order_10_0= ruleOrderType )
            // InternalMyDsl.g:1090:5: lv_order_10_0= ruleOrderType
            {

            					newCompositeNode(grammarAccess.getSortAccess().getOrderOrderTypeEnumRuleCall_9_0());
            				
            pushFollow(FOLLOW_30);
            lv_order_10_0=ruleOrderType();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getSortRule());
            					}
            					set(
            						current,
            						"order",
            						lv_order_10_0,
            						"org.xtext.example.mydsl.MyDsl.OrderType");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_11=(Token)match(input,34,FOLLOW_3); 

            			newLeafNode(otherlv_11, grammarAccess.getSortAccess().getNextKeyword_10());
            		
            // InternalMyDsl.g:1111:3: ( ( ruleEString ) )
            // InternalMyDsl.g:1112:4: ( ruleEString )
            {
            // InternalMyDsl.g:1112:4: ( ruleEString )
            // InternalMyDsl.g:1113:5: ruleEString
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getSortRule());
            					}
            				

            					newCompositeNode(grammarAccess.getSortAccess().getNextStepCrossReference_11_0());
            				
            pushFollow(FOLLOW_12);
            ruleEString();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_13=(Token)match(input,16,FOLLOW_2); 

            			newLeafNode(otherlv_13, grammarAccess.getSortAccess().getRightCurlyBracketKeyword_12());
            		

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
    // InternalMyDsl.g:1135:1: entryRuleAppendRows returns [EObject current=null] : iv_ruleAppendRows= ruleAppendRows EOF ;
    public final EObject entryRuleAppendRows() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAppendRows = null;


        try {
            // InternalMyDsl.g:1135:51: (iv_ruleAppendRows= ruleAppendRows EOF )
            // InternalMyDsl.g:1136:2: iv_ruleAppendRows= ruleAppendRows EOF
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
    // InternalMyDsl.g:1142:1: ruleAppendRows returns [EObject current=null] : (otherlv_0= 'AppendRows' ( (lv_name_1_0= ruleEString ) ) otherlv_2= '{' (otherlv_3= 'description' ( (lv_description_4_0= ruleEString ) ) )? otherlv_5= 'originTable' ( ( ruleEString ) ) otherlv_7= 'destinTable' ( ( ruleEString ) ) otherlv_9= 'associations' otherlv_10= '{' ( (lv_associations_11_0= ruleAssociation ) ) (otherlv_12= ',' ( (lv_associations_13_0= ruleAssociation ) ) )* otherlv_14= '}' otherlv_15= 'next' ( ( ruleEString ) ) otherlv_17= '}' ) ;
    public final EObject ruleAppendRows() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        Token otherlv_9=null;
        Token otherlv_10=null;
        Token otherlv_12=null;
        Token otherlv_14=null;
        Token otherlv_15=null;
        Token otherlv_17=null;
        AntlrDatatypeRuleToken lv_name_1_0 = null;

        AntlrDatatypeRuleToken lv_description_4_0 = null;

        EObject lv_associations_11_0 = null;

        EObject lv_associations_13_0 = null;



        	enterRule();

        try {
            // InternalMyDsl.g:1148:2: ( (otherlv_0= 'AppendRows' ( (lv_name_1_0= ruleEString ) ) otherlv_2= '{' (otherlv_3= 'description' ( (lv_description_4_0= ruleEString ) ) )? otherlv_5= 'originTable' ( ( ruleEString ) ) otherlv_7= 'destinTable' ( ( ruleEString ) ) otherlv_9= 'associations' otherlv_10= '{' ( (lv_associations_11_0= ruleAssociation ) ) (otherlv_12= ',' ( (lv_associations_13_0= ruleAssociation ) ) )* otherlv_14= '}' otherlv_15= 'next' ( ( ruleEString ) ) otherlv_17= '}' ) )
            // InternalMyDsl.g:1149:2: (otherlv_0= 'AppendRows' ( (lv_name_1_0= ruleEString ) ) otherlv_2= '{' (otherlv_3= 'description' ( (lv_description_4_0= ruleEString ) ) )? otherlv_5= 'originTable' ( ( ruleEString ) ) otherlv_7= 'destinTable' ( ( ruleEString ) ) otherlv_9= 'associations' otherlv_10= '{' ( (lv_associations_11_0= ruleAssociation ) ) (otherlv_12= ',' ( (lv_associations_13_0= ruleAssociation ) ) )* otherlv_14= '}' otherlv_15= 'next' ( ( ruleEString ) ) otherlv_17= '}' )
            {
            // InternalMyDsl.g:1149:2: (otherlv_0= 'AppendRows' ( (lv_name_1_0= ruleEString ) ) otherlv_2= '{' (otherlv_3= 'description' ( (lv_description_4_0= ruleEString ) ) )? otherlv_5= 'originTable' ( ( ruleEString ) ) otherlv_7= 'destinTable' ( ( ruleEString ) ) otherlv_9= 'associations' otherlv_10= '{' ( (lv_associations_11_0= ruleAssociation ) ) (otherlv_12= ',' ( (lv_associations_13_0= ruleAssociation ) ) )* otherlv_14= '}' otherlv_15= 'next' ( ( ruleEString ) ) otherlv_17= '}' )
            // InternalMyDsl.g:1150:3: otherlv_0= 'AppendRows' ( (lv_name_1_0= ruleEString ) ) otherlv_2= '{' (otherlv_3= 'description' ( (lv_description_4_0= ruleEString ) ) )? otherlv_5= 'originTable' ( ( ruleEString ) ) otherlv_7= 'destinTable' ( ( ruleEString ) ) otherlv_9= 'associations' otherlv_10= '{' ( (lv_associations_11_0= ruleAssociation ) ) (otherlv_12= ',' ( (lv_associations_13_0= ruleAssociation ) ) )* otherlv_14= '}' otherlv_15= 'next' ( ( ruleEString ) ) otherlv_17= '}'
            {
            otherlv_0=(Token)match(input,38,FOLLOW_3); 

            			newLeafNode(otherlv_0, grammarAccess.getAppendRowsAccess().getAppendRowsKeyword_0());
            		
            // InternalMyDsl.g:1154:3: ( (lv_name_1_0= ruleEString ) )
            // InternalMyDsl.g:1155:4: (lv_name_1_0= ruleEString )
            {
            // InternalMyDsl.g:1155:4: (lv_name_1_0= ruleEString )
            // InternalMyDsl.g:1156:5: lv_name_1_0= ruleEString
            {

            					newCompositeNode(grammarAccess.getAppendRowsAccess().getNameEStringParserRuleCall_1_0());
            				
            pushFollow(FOLLOW_4);
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

            otherlv_2=(Token)match(input,12,FOLLOW_34); 

            			newLeafNode(otherlv_2, grammarAccess.getAppendRowsAccess().getLeftCurlyBracketKeyword_2());
            		
            // InternalMyDsl.g:1177:3: (otherlv_3= 'description' ( (lv_description_4_0= ruleEString ) ) )?
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0==23) ) {
                alt11=1;
            }
            switch (alt11) {
                case 1 :
                    // InternalMyDsl.g:1178:4: otherlv_3= 'description' ( (lv_description_4_0= ruleEString ) )
                    {
                    otherlv_3=(Token)match(input,23,FOLLOW_3); 

                    				newLeafNode(otherlv_3, grammarAccess.getAppendRowsAccess().getDescriptionKeyword_3_0());
                    			
                    // InternalMyDsl.g:1182:4: ( (lv_description_4_0= ruleEString ) )
                    // InternalMyDsl.g:1183:5: (lv_description_4_0= ruleEString )
                    {
                    // InternalMyDsl.g:1183:5: (lv_description_4_0= ruleEString )
                    // InternalMyDsl.g:1184:6: lv_description_4_0= ruleEString
                    {

                    						newCompositeNode(grammarAccess.getAppendRowsAccess().getDescriptionEStringParserRuleCall_3_1_0());
                    					
                    pushFollow(FOLLOW_35);
                    lv_description_4_0=ruleEString();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getAppendRowsRule());
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

            otherlv_5=(Token)match(input,39,FOLLOW_3); 

            			newLeafNode(otherlv_5, grammarAccess.getAppendRowsAccess().getOriginTableKeyword_4());
            		
            // InternalMyDsl.g:1206:3: ( ( ruleEString ) )
            // InternalMyDsl.g:1207:4: ( ruleEString )
            {
            // InternalMyDsl.g:1207:4: ( ruleEString )
            // InternalMyDsl.g:1208:5: ruleEString
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getAppendRowsRule());
            					}
            				

            					newCompositeNode(grammarAccess.getAppendRowsAccess().getOriginTableTableCrossReference_5_0());
            				
            pushFollow(FOLLOW_36);
            ruleEString();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_7=(Token)match(input,40,FOLLOW_3); 

            			newLeafNode(otherlv_7, grammarAccess.getAppendRowsAccess().getDestinTableKeyword_6());
            		
            // InternalMyDsl.g:1226:3: ( ( ruleEString ) )
            // InternalMyDsl.g:1227:4: ( ruleEString )
            {
            // InternalMyDsl.g:1227:4: ( ruleEString )
            // InternalMyDsl.g:1228:5: ruleEString
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getAppendRowsRule());
            					}
            				

            					newCompositeNode(grammarAccess.getAppendRowsAccess().getDestinTableTableCrossReference_7_0());
            				
            pushFollow(FOLLOW_37);
            ruleEString();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_9=(Token)match(input,41,FOLLOW_4); 

            			newLeafNode(otherlv_9, grammarAccess.getAppendRowsAccess().getAssociationsKeyword_8());
            		
            otherlv_10=(Token)match(input,12,FOLLOW_38); 

            			newLeafNode(otherlv_10, grammarAccess.getAppendRowsAccess().getLeftCurlyBracketKeyword_9());
            		
            // InternalMyDsl.g:1250:3: ( (lv_associations_11_0= ruleAssociation ) )
            // InternalMyDsl.g:1251:4: (lv_associations_11_0= ruleAssociation )
            {
            // InternalMyDsl.g:1251:4: (lv_associations_11_0= ruleAssociation )
            // InternalMyDsl.g:1252:5: lv_associations_11_0= ruleAssociation
            {

            					newCompositeNode(grammarAccess.getAppendRowsAccess().getAssociationsAssociationParserRuleCall_10_0());
            				
            pushFollow(FOLLOW_9);
            lv_associations_11_0=ruleAssociation();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getAppendRowsRule());
            					}
            					add(
            						current,
            						"associations",
            						lv_associations_11_0,
            						"org.xtext.example.mydsl.MyDsl.Association");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalMyDsl.g:1269:3: (otherlv_12= ',' ( (lv_associations_13_0= ruleAssociation ) ) )*
            loop12:
            do {
                int alt12=2;
                int LA12_0 = input.LA(1);

                if ( (LA12_0==15) ) {
                    alt12=1;
                }


                switch (alt12) {
            	case 1 :
            	    // InternalMyDsl.g:1270:4: otherlv_12= ',' ( (lv_associations_13_0= ruleAssociation ) )
            	    {
            	    otherlv_12=(Token)match(input,15,FOLLOW_38); 

            	    				newLeafNode(otherlv_12, grammarAccess.getAppendRowsAccess().getCommaKeyword_11_0());
            	    			
            	    // InternalMyDsl.g:1274:4: ( (lv_associations_13_0= ruleAssociation ) )
            	    // InternalMyDsl.g:1275:5: (lv_associations_13_0= ruleAssociation )
            	    {
            	    // InternalMyDsl.g:1275:5: (lv_associations_13_0= ruleAssociation )
            	    // InternalMyDsl.g:1276:6: lv_associations_13_0= ruleAssociation
            	    {

            	    						newCompositeNode(grammarAccess.getAppendRowsAccess().getAssociationsAssociationParserRuleCall_11_1_0());
            	    					
            	    pushFollow(FOLLOW_9);
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


            	    }
            	    break;

            	default :
            	    break loop12;
                }
            } while (true);

            otherlv_14=(Token)match(input,16,FOLLOW_30); 

            			newLeafNode(otherlv_14, grammarAccess.getAppendRowsAccess().getRightCurlyBracketKeyword_12());
            		
            otherlv_15=(Token)match(input,34,FOLLOW_3); 

            			newLeafNode(otherlv_15, grammarAccess.getAppendRowsAccess().getNextKeyword_13());
            		
            // InternalMyDsl.g:1302:3: ( ( ruleEString ) )
            // InternalMyDsl.g:1303:4: ( ruleEString )
            {
            // InternalMyDsl.g:1303:4: ( ruleEString )
            // InternalMyDsl.g:1304:5: ruleEString
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getAppendRowsRule());
            					}
            				

            					newCompositeNode(grammarAccess.getAppendRowsAccess().getNextStepCrossReference_14_0());
            				
            pushFollow(FOLLOW_12);
            ruleEString();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_17=(Token)match(input,16,FOLLOW_2); 

            			newLeafNode(otherlv_17, grammarAccess.getAppendRowsAccess().getRightCurlyBracketKeyword_15());
            		

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
    // InternalMyDsl.g:1326:1: entryRuleFilter returns [EObject current=null] : iv_ruleFilter= ruleFilter EOF ;
    public final EObject entryRuleFilter() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFilter = null;


        try {
            // InternalMyDsl.g:1326:47: (iv_ruleFilter= ruleFilter EOF )
            // InternalMyDsl.g:1327:2: iv_ruleFilter= ruleFilter EOF
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
    // InternalMyDsl.g:1333:1: ruleFilter returns [EObject current=null] : (otherlv_0= 'Filter' ( (lv_name_1_0= ruleEString ) ) otherlv_2= '{' (otherlv_3= 'description' ( (lv_description_4_0= ruleEString ) ) )? otherlv_5= 'table' ( ( ruleEString ) ) otherlv_7= 'column' ( ( ruleEString ) ) otherlv_9= 'operator' ( (lv_operator_10_0= ruleFilterOperatorType ) ) otherlv_11= 'operand' ( (lv_operand_12_0= ruleEString ) ) otherlv_13= 'next' ( ( ruleEString ) ) otherlv_15= '}' ) ;
    public final EObject ruleFilter() throws RecognitionException {
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
        AntlrDatatypeRuleToken lv_name_1_0 = null;

        AntlrDatatypeRuleToken lv_description_4_0 = null;

        Enumerator lv_operator_10_0 = null;

        AntlrDatatypeRuleToken lv_operand_12_0 = null;



        	enterRule();

        try {
            // InternalMyDsl.g:1339:2: ( (otherlv_0= 'Filter' ( (lv_name_1_0= ruleEString ) ) otherlv_2= '{' (otherlv_3= 'description' ( (lv_description_4_0= ruleEString ) ) )? otherlv_5= 'table' ( ( ruleEString ) ) otherlv_7= 'column' ( ( ruleEString ) ) otherlv_9= 'operator' ( (lv_operator_10_0= ruleFilterOperatorType ) ) otherlv_11= 'operand' ( (lv_operand_12_0= ruleEString ) ) otherlv_13= 'next' ( ( ruleEString ) ) otherlv_15= '}' ) )
            // InternalMyDsl.g:1340:2: (otherlv_0= 'Filter' ( (lv_name_1_0= ruleEString ) ) otherlv_2= '{' (otherlv_3= 'description' ( (lv_description_4_0= ruleEString ) ) )? otherlv_5= 'table' ( ( ruleEString ) ) otherlv_7= 'column' ( ( ruleEString ) ) otherlv_9= 'operator' ( (lv_operator_10_0= ruleFilterOperatorType ) ) otherlv_11= 'operand' ( (lv_operand_12_0= ruleEString ) ) otherlv_13= 'next' ( ( ruleEString ) ) otherlv_15= '}' )
            {
            // InternalMyDsl.g:1340:2: (otherlv_0= 'Filter' ( (lv_name_1_0= ruleEString ) ) otherlv_2= '{' (otherlv_3= 'description' ( (lv_description_4_0= ruleEString ) ) )? otherlv_5= 'table' ( ( ruleEString ) ) otherlv_7= 'column' ( ( ruleEString ) ) otherlv_9= 'operator' ( (lv_operator_10_0= ruleFilterOperatorType ) ) otherlv_11= 'operand' ( (lv_operand_12_0= ruleEString ) ) otherlv_13= 'next' ( ( ruleEString ) ) otherlv_15= '}' )
            // InternalMyDsl.g:1341:3: otherlv_0= 'Filter' ( (lv_name_1_0= ruleEString ) ) otherlv_2= '{' (otherlv_3= 'description' ( (lv_description_4_0= ruleEString ) ) )? otherlv_5= 'table' ( ( ruleEString ) ) otherlv_7= 'column' ( ( ruleEString ) ) otherlv_9= 'operator' ( (lv_operator_10_0= ruleFilterOperatorType ) ) otherlv_11= 'operand' ( (lv_operand_12_0= ruleEString ) ) otherlv_13= 'next' ( ( ruleEString ) ) otherlv_15= '}'
            {
            otherlv_0=(Token)match(input,42,FOLLOW_3); 

            			newLeafNode(otherlv_0, grammarAccess.getFilterAccess().getFilterKeyword_0());
            		
            // InternalMyDsl.g:1345:3: ( (lv_name_1_0= ruleEString ) )
            // InternalMyDsl.g:1346:4: (lv_name_1_0= ruleEString )
            {
            // InternalMyDsl.g:1346:4: (lv_name_1_0= ruleEString )
            // InternalMyDsl.g:1347:5: lv_name_1_0= ruleEString
            {

            					newCompositeNode(grammarAccess.getFilterAccess().getNameEStringParserRuleCall_1_0());
            				
            pushFollow(FOLLOW_4);
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

            otherlv_2=(Token)match(input,12,FOLLOW_20); 

            			newLeafNode(otherlv_2, grammarAccess.getFilterAccess().getLeftCurlyBracketKeyword_2());
            		
            // InternalMyDsl.g:1368:3: (otherlv_3= 'description' ( (lv_description_4_0= ruleEString ) ) )?
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( (LA13_0==23) ) {
                alt13=1;
            }
            switch (alt13) {
                case 1 :
                    // InternalMyDsl.g:1369:4: otherlv_3= 'description' ( (lv_description_4_0= ruleEString ) )
                    {
                    otherlv_3=(Token)match(input,23,FOLLOW_3); 

                    				newLeafNode(otherlv_3, grammarAccess.getFilterAccess().getDescriptionKeyword_3_0());
                    			
                    // InternalMyDsl.g:1373:4: ( (lv_description_4_0= ruleEString ) )
                    // InternalMyDsl.g:1374:5: (lv_description_4_0= ruleEString )
                    {
                    // InternalMyDsl.g:1374:5: (lv_description_4_0= ruleEString )
                    // InternalMyDsl.g:1375:6: lv_description_4_0= ruleEString
                    {

                    						newCompositeNode(grammarAccess.getFilterAccess().getDescriptionEStringParserRuleCall_3_1_0());
                    					
                    pushFollow(FOLLOW_21);
                    lv_description_4_0=ruleEString();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getFilterRule());
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

            otherlv_5=(Token)match(input,26,FOLLOW_3); 

            			newLeafNode(otherlv_5, grammarAccess.getFilterAccess().getTableKeyword_4());
            		
            // InternalMyDsl.g:1397:3: ( ( ruleEString ) )
            // InternalMyDsl.g:1398:4: ( ruleEString )
            {
            // InternalMyDsl.g:1398:4: ( ruleEString )
            // InternalMyDsl.g:1399:5: ruleEString
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getFilterRule());
            					}
            				

            					newCompositeNode(grammarAccess.getFilterAccess().getTableTableCrossReference_5_0());
            				
            pushFollow(FOLLOW_31);
            ruleEString();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_7=(Token)match(input,36,FOLLOW_3); 

            			newLeafNode(otherlv_7, grammarAccess.getFilterAccess().getColumnKeyword_6());
            		
            // InternalMyDsl.g:1417:3: ( ( ruleEString ) )
            // InternalMyDsl.g:1418:4: ( ruleEString )
            {
            // InternalMyDsl.g:1418:4: ( ruleEString )
            // InternalMyDsl.g:1419:5: ruleEString
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getFilterRule());
            					}
            				

            					newCompositeNode(grammarAccess.getFilterAccess().getColumnColumnCrossReference_7_0());
            				
            pushFollow(FOLLOW_39);
            ruleEString();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_9=(Token)match(input,43,FOLLOW_40); 

            			newLeafNode(otherlv_9, grammarAccess.getFilterAccess().getOperatorKeyword_8());
            		
            // InternalMyDsl.g:1437:3: ( (lv_operator_10_0= ruleFilterOperatorType ) )
            // InternalMyDsl.g:1438:4: (lv_operator_10_0= ruleFilterOperatorType )
            {
            // InternalMyDsl.g:1438:4: (lv_operator_10_0= ruleFilterOperatorType )
            // InternalMyDsl.g:1439:5: lv_operator_10_0= ruleFilterOperatorType
            {

            					newCompositeNode(grammarAccess.getFilterAccess().getOperatorFilterOperatorTypeEnumRuleCall_9_0());
            				
            pushFollow(FOLLOW_41);
            lv_operator_10_0=ruleFilterOperatorType();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getFilterRule());
            					}
            					set(
            						current,
            						"operator",
            						lv_operator_10_0,
            						"org.xtext.example.mydsl.MyDsl.FilterOperatorType");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_11=(Token)match(input,44,FOLLOW_3); 

            			newLeafNode(otherlv_11, grammarAccess.getFilterAccess().getOperandKeyword_10());
            		
            // InternalMyDsl.g:1460:3: ( (lv_operand_12_0= ruleEString ) )
            // InternalMyDsl.g:1461:4: (lv_operand_12_0= ruleEString )
            {
            // InternalMyDsl.g:1461:4: (lv_operand_12_0= ruleEString )
            // InternalMyDsl.g:1462:5: lv_operand_12_0= ruleEString
            {

            					newCompositeNode(grammarAccess.getFilterAccess().getOperandEStringParserRuleCall_11_0());
            				
            pushFollow(FOLLOW_30);
            lv_operand_12_0=ruleEString();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getFilterRule());
            					}
            					set(
            						current,
            						"operand",
            						lv_operand_12_0,
            						"org.xtext.example.mydsl.MyDsl.EString");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_13=(Token)match(input,34,FOLLOW_3); 

            			newLeafNode(otherlv_13, grammarAccess.getFilterAccess().getNextKeyword_12());
            		
            // InternalMyDsl.g:1483:3: ( ( ruleEString ) )
            // InternalMyDsl.g:1484:4: ( ruleEString )
            {
            // InternalMyDsl.g:1484:4: ( ruleEString )
            // InternalMyDsl.g:1485:5: ruleEString
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getFilterRule());
            					}
            				

            					newCompositeNode(grammarAccess.getFilterAccess().getNextStepCrossReference_13_0());
            				
            pushFollow(FOLLOW_12);
            ruleEString();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_15=(Token)match(input,16,FOLLOW_2); 

            			newLeafNode(otherlv_15, grammarAccess.getFilterAccess().getRightCurlyBracketKeyword_14());
            		

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
    // InternalMyDsl.g:1507:1: entryRuleGenericStep returns [EObject current=null] : iv_ruleGenericStep= ruleGenericStep EOF ;
    public final EObject entryRuleGenericStep() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleGenericStep = null;


        try {
            // InternalMyDsl.g:1507:52: (iv_ruleGenericStep= ruleGenericStep EOF )
            // InternalMyDsl.g:1508:2: iv_ruleGenericStep= ruleGenericStep EOF
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
    // InternalMyDsl.g:1514:1: ruleGenericStep returns [EObject current=null] : (otherlv_0= 'GenericStep' ( (lv_name_1_0= ruleEString ) ) otherlv_2= '{' (otherlv_3= 'description' ( (lv_description_4_0= ruleEString ) ) )? otherlv_5= 'next' ( ( ruleEString ) ) otherlv_7= '}' ) ;
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
            // InternalMyDsl.g:1520:2: ( (otherlv_0= 'GenericStep' ( (lv_name_1_0= ruleEString ) ) otherlv_2= '{' (otherlv_3= 'description' ( (lv_description_4_0= ruleEString ) ) )? otherlv_5= 'next' ( ( ruleEString ) ) otherlv_7= '}' ) )
            // InternalMyDsl.g:1521:2: (otherlv_0= 'GenericStep' ( (lv_name_1_0= ruleEString ) ) otherlv_2= '{' (otherlv_3= 'description' ( (lv_description_4_0= ruleEString ) ) )? otherlv_5= 'next' ( ( ruleEString ) ) otherlv_7= '}' )
            {
            // InternalMyDsl.g:1521:2: (otherlv_0= 'GenericStep' ( (lv_name_1_0= ruleEString ) ) otherlv_2= '{' (otherlv_3= 'description' ( (lv_description_4_0= ruleEString ) ) )? otherlv_5= 'next' ( ( ruleEString ) ) otherlv_7= '}' )
            // InternalMyDsl.g:1522:3: otherlv_0= 'GenericStep' ( (lv_name_1_0= ruleEString ) ) otherlv_2= '{' (otherlv_3= 'description' ( (lv_description_4_0= ruleEString ) ) )? otherlv_5= 'next' ( ( ruleEString ) ) otherlv_7= '}'
            {
            otherlv_0=(Token)match(input,45,FOLLOW_3); 

            			newLeafNode(otherlv_0, grammarAccess.getGenericStepAccess().getGenericStepKeyword_0());
            		
            // InternalMyDsl.g:1526:3: ( (lv_name_1_0= ruleEString ) )
            // InternalMyDsl.g:1527:4: (lv_name_1_0= ruleEString )
            {
            // InternalMyDsl.g:1527:4: (lv_name_1_0= ruleEString )
            // InternalMyDsl.g:1528:5: lv_name_1_0= ruleEString
            {

            					newCompositeNode(grammarAccess.getGenericStepAccess().getNameEStringParserRuleCall_1_0());
            				
            pushFollow(FOLLOW_4);
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

            otherlv_2=(Token)match(input,12,FOLLOW_42); 

            			newLeafNode(otherlv_2, grammarAccess.getGenericStepAccess().getLeftCurlyBracketKeyword_2());
            		
            // InternalMyDsl.g:1549:3: (otherlv_3= 'description' ( (lv_description_4_0= ruleEString ) ) )?
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( (LA14_0==23) ) {
                alt14=1;
            }
            switch (alt14) {
                case 1 :
                    // InternalMyDsl.g:1550:4: otherlv_3= 'description' ( (lv_description_4_0= ruleEString ) )
                    {
                    otherlv_3=(Token)match(input,23,FOLLOW_3); 

                    				newLeafNode(otherlv_3, grammarAccess.getGenericStepAccess().getDescriptionKeyword_3_0());
                    			
                    // InternalMyDsl.g:1554:4: ( (lv_description_4_0= ruleEString ) )
                    // InternalMyDsl.g:1555:5: (lv_description_4_0= ruleEString )
                    {
                    // InternalMyDsl.g:1555:5: (lv_description_4_0= ruleEString )
                    // InternalMyDsl.g:1556:6: lv_description_4_0= ruleEString
                    {

                    						newCompositeNode(grammarAccess.getGenericStepAccess().getDescriptionEStringParserRuleCall_3_1_0());
                    					
                    pushFollow(FOLLOW_30);
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

            otherlv_5=(Token)match(input,34,FOLLOW_3); 

            			newLeafNode(otherlv_5, grammarAccess.getGenericStepAccess().getNextKeyword_4());
            		
            // InternalMyDsl.g:1578:3: ( ( ruleEString ) )
            // InternalMyDsl.g:1579:4: ( ruleEString )
            {
            // InternalMyDsl.g:1579:4: ( ruleEString )
            // InternalMyDsl.g:1580:5: ruleEString
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getGenericStepRule());
            					}
            				

            					newCompositeNode(grammarAccess.getGenericStepAccess().getNextStepCrossReference_5_0());
            				
            pushFollow(FOLLOW_12);
            ruleEString();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_7=(Token)match(input,16,FOLLOW_2); 

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
    // InternalMyDsl.g:1602:1: entryRuleJoin returns [EObject current=null] : iv_ruleJoin= ruleJoin EOF ;
    public final EObject entryRuleJoin() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleJoin = null;


        try {
            // InternalMyDsl.g:1602:45: (iv_ruleJoin= ruleJoin EOF )
            // InternalMyDsl.g:1603:2: iv_ruleJoin= ruleJoin EOF
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
    // InternalMyDsl.g:1609:1: ruleJoin returns [EObject current=null] : (otherlv_0= 'Join' ( (lv_name_1_0= ruleEString ) ) otherlv_2= '{' (otherlv_3= 'description' ( (lv_description_4_0= ruleEString ) ) )? otherlv_5= 'tableLeft' ( ( ruleEString ) ) otherlv_7= 'columnLeft' ( ( ruleEString ) ) otherlv_9= 'type' ( (lv_type_10_0= ruleJoinType ) ) otherlv_11= 'tableRight' ( ( ruleEString ) ) otherlv_13= 'columnRight' ( ( ruleEString ) ) otherlv_15= 'selectColumns' otherlv_16= '(' ( ( ruleEString ) ) (otherlv_18= ',' ( ( ruleEString ) ) )* otherlv_20= ')' otherlv_21= 'resultTable' ( ( ruleEString ) ) otherlv_23= 'next' ( ( ruleEString ) ) otherlv_25= '}' ) ;
    public final EObject ruleJoin() throws RecognitionException {
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
        Token otherlv_16=null;
        Token otherlv_18=null;
        Token otherlv_20=null;
        Token otherlv_21=null;
        Token otherlv_23=null;
        Token otherlv_25=null;
        AntlrDatatypeRuleToken lv_name_1_0 = null;

        AntlrDatatypeRuleToken lv_description_4_0 = null;

        Enumerator lv_type_10_0 = null;



        	enterRule();

        try {
            // InternalMyDsl.g:1615:2: ( (otherlv_0= 'Join' ( (lv_name_1_0= ruleEString ) ) otherlv_2= '{' (otherlv_3= 'description' ( (lv_description_4_0= ruleEString ) ) )? otherlv_5= 'tableLeft' ( ( ruleEString ) ) otherlv_7= 'columnLeft' ( ( ruleEString ) ) otherlv_9= 'type' ( (lv_type_10_0= ruleJoinType ) ) otherlv_11= 'tableRight' ( ( ruleEString ) ) otherlv_13= 'columnRight' ( ( ruleEString ) ) otherlv_15= 'selectColumns' otherlv_16= '(' ( ( ruleEString ) ) (otherlv_18= ',' ( ( ruleEString ) ) )* otherlv_20= ')' otherlv_21= 'resultTable' ( ( ruleEString ) ) otherlv_23= 'next' ( ( ruleEString ) ) otherlv_25= '}' ) )
            // InternalMyDsl.g:1616:2: (otherlv_0= 'Join' ( (lv_name_1_0= ruleEString ) ) otherlv_2= '{' (otherlv_3= 'description' ( (lv_description_4_0= ruleEString ) ) )? otherlv_5= 'tableLeft' ( ( ruleEString ) ) otherlv_7= 'columnLeft' ( ( ruleEString ) ) otherlv_9= 'type' ( (lv_type_10_0= ruleJoinType ) ) otherlv_11= 'tableRight' ( ( ruleEString ) ) otherlv_13= 'columnRight' ( ( ruleEString ) ) otherlv_15= 'selectColumns' otherlv_16= '(' ( ( ruleEString ) ) (otherlv_18= ',' ( ( ruleEString ) ) )* otherlv_20= ')' otherlv_21= 'resultTable' ( ( ruleEString ) ) otherlv_23= 'next' ( ( ruleEString ) ) otherlv_25= '}' )
            {
            // InternalMyDsl.g:1616:2: (otherlv_0= 'Join' ( (lv_name_1_0= ruleEString ) ) otherlv_2= '{' (otherlv_3= 'description' ( (lv_description_4_0= ruleEString ) ) )? otherlv_5= 'tableLeft' ( ( ruleEString ) ) otherlv_7= 'columnLeft' ( ( ruleEString ) ) otherlv_9= 'type' ( (lv_type_10_0= ruleJoinType ) ) otherlv_11= 'tableRight' ( ( ruleEString ) ) otherlv_13= 'columnRight' ( ( ruleEString ) ) otherlv_15= 'selectColumns' otherlv_16= '(' ( ( ruleEString ) ) (otherlv_18= ',' ( ( ruleEString ) ) )* otherlv_20= ')' otherlv_21= 'resultTable' ( ( ruleEString ) ) otherlv_23= 'next' ( ( ruleEString ) ) otherlv_25= '}' )
            // InternalMyDsl.g:1617:3: otherlv_0= 'Join' ( (lv_name_1_0= ruleEString ) ) otherlv_2= '{' (otherlv_3= 'description' ( (lv_description_4_0= ruleEString ) ) )? otherlv_5= 'tableLeft' ( ( ruleEString ) ) otherlv_7= 'columnLeft' ( ( ruleEString ) ) otherlv_9= 'type' ( (lv_type_10_0= ruleJoinType ) ) otherlv_11= 'tableRight' ( ( ruleEString ) ) otherlv_13= 'columnRight' ( ( ruleEString ) ) otherlv_15= 'selectColumns' otherlv_16= '(' ( ( ruleEString ) ) (otherlv_18= ',' ( ( ruleEString ) ) )* otherlv_20= ')' otherlv_21= 'resultTable' ( ( ruleEString ) ) otherlv_23= 'next' ( ( ruleEString ) ) otherlv_25= '}'
            {
            otherlv_0=(Token)match(input,46,FOLLOW_3); 

            			newLeafNode(otherlv_0, grammarAccess.getJoinAccess().getJoinKeyword_0());
            		
            // InternalMyDsl.g:1621:3: ( (lv_name_1_0= ruleEString ) )
            // InternalMyDsl.g:1622:4: (lv_name_1_0= ruleEString )
            {
            // InternalMyDsl.g:1622:4: (lv_name_1_0= ruleEString )
            // InternalMyDsl.g:1623:5: lv_name_1_0= ruleEString
            {

            					newCompositeNode(grammarAccess.getJoinAccess().getNameEStringParserRuleCall_1_0());
            				
            pushFollow(FOLLOW_4);
            lv_name_1_0=ruleEString();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getJoinRule());
            					}
            					set(
            						current,
            						"name",
            						lv_name_1_0,
            						"org.xtext.example.mydsl.MyDsl.EString");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_2=(Token)match(input,12,FOLLOW_43); 

            			newLeafNode(otherlv_2, grammarAccess.getJoinAccess().getLeftCurlyBracketKeyword_2());
            		
            // InternalMyDsl.g:1644:3: (otherlv_3= 'description' ( (lv_description_4_0= ruleEString ) ) )?
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( (LA15_0==23) ) {
                alt15=1;
            }
            switch (alt15) {
                case 1 :
                    // InternalMyDsl.g:1645:4: otherlv_3= 'description' ( (lv_description_4_0= ruleEString ) )
                    {
                    otherlv_3=(Token)match(input,23,FOLLOW_3); 

                    				newLeafNode(otherlv_3, grammarAccess.getJoinAccess().getDescriptionKeyword_3_0());
                    			
                    // InternalMyDsl.g:1649:4: ( (lv_description_4_0= ruleEString ) )
                    // InternalMyDsl.g:1650:5: (lv_description_4_0= ruleEString )
                    {
                    // InternalMyDsl.g:1650:5: (lv_description_4_0= ruleEString )
                    // InternalMyDsl.g:1651:6: lv_description_4_0= ruleEString
                    {

                    						newCompositeNode(grammarAccess.getJoinAccess().getDescriptionEStringParserRuleCall_3_1_0());
                    					
                    pushFollow(FOLLOW_44);
                    lv_description_4_0=ruleEString();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getJoinRule());
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

            otherlv_5=(Token)match(input,47,FOLLOW_3); 

            			newLeafNode(otherlv_5, grammarAccess.getJoinAccess().getTableLeftKeyword_4());
            		
            // InternalMyDsl.g:1673:3: ( ( ruleEString ) )
            // InternalMyDsl.g:1674:4: ( ruleEString )
            {
            // InternalMyDsl.g:1674:4: ( ruleEString )
            // InternalMyDsl.g:1675:5: ruleEString
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getJoinRule());
            					}
            				

            					newCompositeNode(grammarAccess.getJoinAccess().getTableLeftTableCrossReference_5_0());
            				
            pushFollow(FOLLOW_45);
            ruleEString();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_7=(Token)match(input,48,FOLLOW_3); 

            			newLeafNode(otherlv_7, grammarAccess.getJoinAccess().getColumnLeftKeyword_6());
            		
            // InternalMyDsl.g:1693:3: ( ( ruleEString ) )
            // InternalMyDsl.g:1694:4: ( ruleEString )
            {
            // InternalMyDsl.g:1694:4: ( ruleEString )
            // InternalMyDsl.g:1695:5: ruleEString
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getJoinRule());
            					}
            				

            					newCompositeNode(grammarAccess.getJoinAccess().getColumnLeftColumnCrossReference_7_0());
            				
            pushFollow(FOLLOW_46);
            ruleEString();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_9=(Token)match(input,49,FOLLOW_47); 

            			newLeafNode(otherlv_9, grammarAccess.getJoinAccess().getTypeKeyword_8());
            		
            // InternalMyDsl.g:1713:3: ( (lv_type_10_0= ruleJoinType ) )
            // InternalMyDsl.g:1714:4: (lv_type_10_0= ruleJoinType )
            {
            // InternalMyDsl.g:1714:4: (lv_type_10_0= ruleJoinType )
            // InternalMyDsl.g:1715:5: lv_type_10_0= ruleJoinType
            {

            					newCompositeNode(grammarAccess.getJoinAccess().getTypeJoinTypeEnumRuleCall_9_0());
            				
            pushFollow(FOLLOW_48);
            lv_type_10_0=ruleJoinType();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getJoinRule());
            					}
            					set(
            						current,
            						"type",
            						lv_type_10_0,
            						"org.xtext.example.mydsl.MyDsl.JoinType");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_11=(Token)match(input,50,FOLLOW_3); 

            			newLeafNode(otherlv_11, grammarAccess.getJoinAccess().getTableRightKeyword_10());
            		
            // InternalMyDsl.g:1736:3: ( ( ruleEString ) )
            // InternalMyDsl.g:1737:4: ( ruleEString )
            {
            // InternalMyDsl.g:1737:4: ( ruleEString )
            // InternalMyDsl.g:1738:5: ruleEString
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getJoinRule());
            					}
            				

            					newCompositeNode(grammarAccess.getJoinAccess().getTableRightTableCrossReference_11_0());
            				
            pushFollow(FOLLOW_49);
            ruleEString();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_13=(Token)match(input,51,FOLLOW_3); 

            			newLeafNode(otherlv_13, grammarAccess.getJoinAccess().getColumnRightKeyword_12());
            		
            // InternalMyDsl.g:1756:3: ( ( ruleEString ) )
            // InternalMyDsl.g:1757:4: ( ruleEString )
            {
            // InternalMyDsl.g:1757:4: ( ruleEString )
            // InternalMyDsl.g:1758:5: ruleEString
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getJoinRule());
            					}
            				

            					newCompositeNode(grammarAccess.getJoinAccess().getColumnRightColumnCrossReference_13_0());
            				
            pushFollow(FOLLOW_50);
            ruleEString();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_15=(Token)match(input,52,FOLLOW_23); 

            			newLeafNode(otherlv_15, grammarAccess.getJoinAccess().getSelectColumnsKeyword_14());
            		
            otherlv_16=(Token)match(input,28,FOLLOW_3); 

            			newLeafNode(otherlv_16, grammarAccess.getJoinAccess().getLeftParenthesisKeyword_15());
            		
            // InternalMyDsl.g:1780:3: ( ( ruleEString ) )
            // InternalMyDsl.g:1781:4: ( ruleEString )
            {
            // InternalMyDsl.g:1781:4: ( ruleEString )
            // InternalMyDsl.g:1782:5: ruleEString
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getJoinRule());
            					}
            				

            					newCompositeNode(grammarAccess.getJoinAccess().getSelectColumnsColumnCrossReference_16_0());
            				
            pushFollow(FOLLOW_24);
            ruleEString();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalMyDsl.g:1796:3: (otherlv_18= ',' ( ( ruleEString ) ) )*
            loop16:
            do {
                int alt16=2;
                int LA16_0 = input.LA(1);

                if ( (LA16_0==15) ) {
                    alt16=1;
                }


                switch (alt16) {
            	case 1 :
            	    // InternalMyDsl.g:1797:4: otherlv_18= ',' ( ( ruleEString ) )
            	    {
            	    otherlv_18=(Token)match(input,15,FOLLOW_3); 

            	    				newLeafNode(otherlv_18, grammarAccess.getJoinAccess().getCommaKeyword_17_0());
            	    			
            	    // InternalMyDsl.g:1801:4: ( ( ruleEString ) )
            	    // InternalMyDsl.g:1802:5: ( ruleEString )
            	    {
            	    // InternalMyDsl.g:1802:5: ( ruleEString )
            	    // InternalMyDsl.g:1803:6: ruleEString
            	    {

            	    						if (current==null) {
            	    							current = createModelElement(grammarAccess.getJoinRule());
            	    						}
            	    					

            	    						newCompositeNode(grammarAccess.getJoinAccess().getSelectColumnsColumnCrossReference_17_1_0());
            	    					
            	    pushFollow(FOLLOW_24);
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

            otherlv_20=(Token)match(input,29,FOLLOW_28); 

            			newLeafNode(otherlv_20, grammarAccess.getJoinAccess().getRightParenthesisKeyword_18());
            		
            otherlv_21=(Token)match(input,32,FOLLOW_3); 

            			newLeafNode(otherlv_21, grammarAccess.getJoinAccess().getResultTableKeyword_19());
            		
            // InternalMyDsl.g:1826:3: ( ( ruleEString ) )
            // InternalMyDsl.g:1827:4: ( ruleEString )
            {
            // InternalMyDsl.g:1827:4: ( ruleEString )
            // InternalMyDsl.g:1828:5: ruleEString
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getJoinRule());
            					}
            				

            					newCompositeNode(grammarAccess.getJoinAccess().getResultTableTableCrossReference_20_0());
            				
            pushFollow(FOLLOW_30);
            ruleEString();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_23=(Token)match(input,34,FOLLOW_3); 

            			newLeafNode(otherlv_23, grammarAccess.getJoinAccess().getNextKeyword_21());
            		
            // InternalMyDsl.g:1846:3: ( ( ruleEString ) )
            // InternalMyDsl.g:1847:4: ( ruleEString )
            {
            // InternalMyDsl.g:1847:4: ( ruleEString )
            // InternalMyDsl.g:1848:5: ruleEString
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getJoinRule());
            					}
            				

            					newCompositeNode(grammarAccess.getJoinAccess().getNextStepCrossReference_22_0());
            				
            pushFollow(FOLLOW_12);
            ruleEString();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_25=(Token)match(input,16,FOLLOW_2); 

            			newLeafNode(otherlv_25, grammarAccess.getJoinAccess().getRightCurlyBracketKeyword_23());
            		

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
    // InternalMyDsl.g:1870:1: entryRuleImport returns [EObject current=null] : iv_ruleImport= ruleImport EOF ;
    public final EObject entryRuleImport() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleImport = null;


        try {
            // InternalMyDsl.g:1870:47: (iv_ruleImport= ruleImport EOF )
            // InternalMyDsl.g:1871:2: iv_ruleImport= ruleImport EOF
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
    // InternalMyDsl.g:1877:1: ruleImport returns [EObject current=null] : (otherlv_0= 'Import' ( (lv_name_1_0= ruleEString ) ) otherlv_2= '{' (otherlv_3= 'description' ( (lv_description_4_0= ruleEString ) ) )? otherlv_5= 'tablesToImport' otherlv_6= '{' ( (lv_tablesToImport_7_0= ruleTableToImport ) ) (otherlv_8= ',' ( (lv_tablesToImport_9_0= ruleTableToImport ) ) )* otherlv_10= '}' otherlv_11= 'next' ( ( ruleEString ) ) otherlv_13= '}' ) ;
    public final EObject ruleImport() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Token otherlv_6=null;
        Token otherlv_8=null;
        Token otherlv_10=null;
        Token otherlv_11=null;
        Token otherlv_13=null;
        AntlrDatatypeRuleToken lv_name_1_0 = null;

        AntlrDatatypeRuleToken lv_description_4_0 = null;

        EObject lv_tablesToImport_7_0 = null;

        EObject lv_tablesToImport_9_0 = null;



        	enterRule();

        try {
            // InternalMyDsl.g:1883:2: ( (otherlv_0= 'Import' ( (lv_name_1_0= ruleEString ) ) otherlv_2= '{' (otherlv_3= 'description' ( (lv_description_4_0= ruleEString ) ) )? otherlv_5= 'tablesToImport' otherlv_6= '{' ( (lv_tablesToImport_7_0= ruleTableToImport ) ) (otherlv_8= ',' ( (lv_tablesToImport_9_0= ruleTableToImport ) ) )* otherlv_10= '}' otherlv_11= 'next' ( ( ruleEString ) ) otherlv_13= '}' ) )
            // InternalMyDsl.g:1884:2: (otherlv_0= 'Import' ( (lv_name_1_0= ruleEString ) ) otherlv_2= '{' (otherlv_3= 'description' ( (lv_description_4_0= ruleEString ) ) )? otherlv_5= 'tablesToImport' otherlv_6= '{' ( (lv_tablesToImport_7_0= ruleTableToImport ) ) (otherlv_8= ',' ( (lv_tablesToImport_9_0= ruleTableToImport ) ) )* otherlv_10= '}' otherlv_11= 'next' ( ( ruleEString ) ) otherlv_13= '}' )
            {
            // InternalMyDsl.g:1884:2: (otherlv_0= 'Import' ( (lv_name_1_0= ruleEString ) ) otherlv_2= '{' (otherlv_3= 'description' ( (lv_description_4_0= ruleEString ) ) )? otherlv_5= 'tablesToImport' otherlv_6= '{' ( (lv_tablesToImport_7_0= ruleTableToImport ) ) (otherlv_8= ',' ( (lv_tablesToImport_9_0= ruleTableToImport ) ) )* otherlv_10= '}' otherlv_11= 'next' ( ( ruleEString ) ) otherlv_13= '}' )
            // InternalMyDsl.g:1885:3: otherlv_0= 'Import' ( (lv_name_1_0= ruleEString ) ) otherlv_2= '{' (otherlv_3= 'description' ( (lv_description_4_0= ruleEString ) ) )? otherlv_5= 'tablesToImport' otherlv_6= '{' ( (lv_tablesToImport_7_0= ruleTableToImport ) ) (otherlv_8= ',' ( (lv_tablesToImport_9_0= ruleTableToImport ) ) )* otherlv_10= '}' otherlv_11= 'next' ( ( ruleEString ) ) otherlv_13= '}'
            {
            otherlv_0=(Token)match(input,53,FOLLOW_3); 

            			newLeafNode(otherlv_0, grammarAccess.getImportAccess().getImportKeyword_0());
            		
            // InternalMyDsl.g:1889:3: ( (lv_name_1_0= ruleEString ) )
            // InternalMyDsl.g:1890:4: (lv_name_1_0= ruleEString )
            {
            // InternalMyDsl.g:1890:4: (lv_name_1_0= ruleEString )
            // InternalMyDsl.g:1891:5: lv_name_1_0= ruleEString
            {

            					newCompositeNode(grammarAccess.getImportAccess().getNameEStringParserRuleCall_1_0());
            				
            pushFollow(FOLLOW_4);
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

            otherlv_2=(Token)match(input,12,FOLLOW_51); 

            			newLeafNode(otherlv_2, grammarAccess.getImportAccess().getLeftCurlyBracketKeyword_2());
            		
            // InternalMyDsl.g:1912:3: (otherlv_3= 'description' ( (lv_description_4_0= ruleEString ) ) )?
            int alt17=2;
            int LA17_0 = input.LA(1);

            if ( (LA17_0==23) ) {
                alt17=1;
            }
            switch (alt17) {
                case 1 :
                    // InternalMyDsl.g:1913:4: otherlv_3= 'description' ( (lv_description_4_0= ruleEString ) )
                    {
                    otherlv_3=(Token)match(input,23,FOLLOW_3); 

                    				newLeafNode(otherlv_3, grammarAccess.getImportAccess().getDescriptionKeyword_3_0());
                    			
                    // InternalMyDsl.g:1917:4: ( (lv_description_4_0= ruleEString ) )
                    // InternalMyDsl.g:1918:5: (lv_description_4_0= ruleEString )
                    {
                    // InternalMyDsl.g:1918:5: (lv_description_4_0= ruleEString )
                    // InternalMyDsl.g:1919:6: lv_description_4_0= ruleEString
                    {

                    						newCompositeNode(grammarAccess.getImportAccess().getDescriptionEStringParserRuleCall_3_1_0());
                    					
                    pushFollow(FOLLOW_52);
                    lv_description_4_0=ruleEString();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getImportRule());
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

            otherlv_5=(Token)match(input,54,FOLLOW_4); 

            			newLeafNode(otherlv_5, grammarAccess.getImportAccess().getTablesToImportKeyword_4());
            		
            otherlv_6=(Token)match(input,12,FOLLOW_53); 

            			newLeafNode(otherlv_6, grammarAccess.getImportAccess().getLeftCurlyBracketKeyword_5());
            		
            // InternalMyDsl.g:1945:3: ( (lv_tablesToImport_7_0= ruleTableToImport ) )
            // InternalMyDsl.g:1946:4: (lv_tablesToImport_7_0= ruleTableToImport )
            {
            // InternalMyDsl.g:1946:4: (lv_tablesToImport_7_0= ruleTableToImport )
            // InternalMyDsl.g:1947:5: lv_tablesToImport_7_0= ruleTableToImport
            {

            					newCompositeNode(grammarAccess.getImportAccess().getTablesToImportTableToImportParserRuleCall_6_0());
            				
            pushFollow(FOLLOW_9);
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

            // InternalMyDsl.g:1964:3: (otherlv_8= ',' ( (lv_tablesToImport_9_0= ruleTableToImport ) ) )*
            loop18:
            do {
                int alt18=2;
                int LA18_0 = input.LA(1);

                if ( (LA18_0==15) ) {
                    alt18=1;
                }


                switch (alt18) {
            	case 1 :
            	    // InternalMyDsl.g:1965:4: otherlv_8= ',' ( (lv_tablesToImport_9_0= ruleTableToImport ) )
            	    {
            	    otherlv_8=(Token)match(input,15,FOLLOW_53); 

            	    				newLeafNode(otherlv_8, grammarAccess.getImportAccess().getCommaKeyword_7_0());
            	    			
            	    // InternalMyDsl.g:1969:4: ( (lv_tablesToImport_9_0= ruleTableToImport ) )
            	    // InternalMyDsl.g:1970:5: (lv_tablesToImport_9_0= ruleTableToImport )
            	    {
            	    // InternalMyDsl.g:1970:5: (lv_tablesToImport_9_0= ruleTableToImport )
            	    // InternalMyDsl.g:1971:6: lv_tablesToImport_9_0= ruleTableToImport
            	    {

            	    						newCompositeNode(grammarAccess.getImportAccess().getTablesToImportTableToImportParserRuleCall_7_1_0());
            	    					
            	    pushFollow(FOLLOW_9);
            	    lv_tablesToImport_9_0=ruleTableToImport();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getImportRule());
            	    						}
            	    						add(
            	    							current,
            	    							"tablesToImport",
            	    							lv_tablesToImport_9_0,
            	    							"org.xtext.example.mydsl.MyDsl.TableToImport");
            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop18;
                }
            } while (true);

            otherlv_10=(Token)match(input,16,FOLLOW_30); 

            			newLeafNode(otherlv_10, grammarAccess.getImportAccess().getRightCurlyBracketKeyword_8());
            		
            otherlv_11=(Token)match(input,34,FOLLOW_3); 

            			newLeafNode(otherlv_11, grammarAccess.getImportAccess().getNextKeyword_9());
            		
            // InternalMyDsl.g:1997:3: ( ( ruleEString ) )
            // InternalMyDsl.g:1998:4: ( ruleEString )
            {
            // InternalMyDsl.g:1998:4: ( ruleEString )
            // InternalMyDsl.g:1999:5: ruleEString
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getImportRule());
            					}
            				

            					newCompositeNode(grammarAccess.getImportAccess().getNextStepCrossReference_10_0());
            				
            pushFollow(FOLLOW_12);
            ruleEString();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_13=(Token)match(input,16,FOLLOW_2); 

            			newLeafNode(otherlv_13, grammarAccess.getImportAccess().getRightCurlyBracketKeyword_11());
            		

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
    // InternalMyDsl.g:2021:1: entryRuleLookup returns [EObject current=null] : iv_ruleLookup= ruleLookup EOF ;
    public final EObject entryRuleLookup() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLookup = null;


        try {
            // InternalMyDsl.g:2021:47: (iv_ruleLookup= ruleLookup EOF )
            // InternalMyDsl.g:2022:2: iv_ruleLookup= ruleLookup EOF
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
    // InternalMyDsl.g:2028:1: ruleLookup returns [EObject current=null] : (otherlv_0= 'Lookup' ( (lv_name_1_0= ruleEString ) ) otherlv_2= '{' (otherlv_3= 'description' ( (lv_description_4_0= ruleEString ) ) )? otherlv_5= 'table' ( ( ruleEString ) ) otherlv_7= 'column' ( ( ruleEString ) ) otherlv_9= 'lookupTable' ( ( ruleEString ) ) otherlv_11= 'matchColumn' ( ( ruleEString ) ) otherlv_13= 'operandColumn' ( ( ruleEString ) ) otherlv_15= 'lookupColumn' ( ( ruleEString ) ) otherlv_17= 'operation' ( (lv_operation_18_0= ruleLookupOperationType ) ) otherlv_19= 'resultTable' ( ( ruleEString ) ) otherlv_21= 'resultColumn' ( ( ruleEString ) ) otherlv_23= 'next' ( ( ruleEString ) ) otherlv_25= '}' ) ;
    public final EObject ruleLookup() throws RecognitionException {
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
        Token otherlv_23=null;
        Token otherlv_25=null;
        AntlrDatatypeRuleToken lv_name_1_0 = null;

        AntlrDatatypeRuleToken lv_description_4_0 = null;

        Enumerator lv_operation_18_0 = null;



        	enterRule();

        try {
            // InternalMyDsl.g:2034:2: ( (otherlv_0= 'Lookup' ( (lv_name_1_0= ruleEString ) ) otherlv_2= '{' (otherlv_3= 'description' ( (lv_description_4_0= ruleEString ) ) )? otherlv_5= 'table' ( ( ruleEString ) ) otherlv_7= 'column' ( ( ruleEString ) ) otherlv_9= 'lookupTable' ( ( ruleEString ) ) otherlv_11= 'matchColumn' ( ( ruleEString ) ) otherlv_13= 'operandColumn' ( ( ruleEString ) ) otherlv_15= 'lookupColumn' ( ( ruleEString ) ) otherlv_17= 'operation' ( (lv_operation_18_0= ruleLookupOperationType ) ) otherlv_19= 'resultTable' ( ( ruleEString ) ) otherlv_21= 'resultColumn' ( ( ruleEString ) ) otherlv_23= 'next' ( ( ruleEString ) ) otherlv_25= '}' ) )
            // InternalMyDsl.g:2035:2: (otherlv_0= 'Lookup' ( (lv_name_1_0= ruleEString ) ) otherlv_2= '{' (otherlv_3= 'description' ( (lv_description_4_0= ruleEString ) ) )? otherlv_5= 'table' ( ( ruleEString ) ) otherlv_7= 'column' ( ( ruleEString ) ) otherlv_9= 'lookupTable' ( ( ruleEString ) ) otherlv_11= 'matchColumn' ( ( ruleEString ) ) otherlv_13= 'operandColumn' ( ( ruleEString ) ) otherlv_15= 'lookupColumn' ( ( ruleEString ) ) otherlv_17= 'operation' ( (lv_operation_18_0= ruleLookupOperationType ) ) otherlv_19= 'resultTable' ( ( ruleEString ) ) otherlv_21= 'resultColumn' ( ( ruleEString ) ) otherlv_23= 'next' ( ( ruleEString ) ) otherlv_25= '}' )
            {
            // InternalMyDsl.g:2035:2: (otherlv_0= 'Lookup' ( (lv_name_1_0= ruleEString ) ) otherlv_2= '{' (otherlv_3= 'description' ( (lv_description_4_0= ruleEString ) ) )? otherlv_5= 'table' ( ( ruleEString ) ) otherlv_7= 'column' ( ( ruleEString ) ) otherlv_9= 'lookupTable' ( ( ruleEString ) ) otherlv_11= 'matchColumn' ( ( ruleEString ) ) otherlv_13= 'operandColumn' ( ( ruleEString ) ) otherlv_15= 'lookupColumn' ( ( ruleEString ) ) otherlv_17= 'operation' ( (lv_operation_18_0= ruleLookupOperationType ) ) otherlv_19= 'resultTable' ( ( ruleEString ) ) otherlv_21= 'resultColumn' ( ( ruleEString ) ) otherlv_23= 'next' ( ( ruleEString ) ) otherlv_25= '}' )
            // InternalMyDsl.g:2036:3: otherlv_0= 'Lookup' ( (lv_name_1_0= ruleEString ) ) otherlv_2= '{' (otherlv_3= 'description' ( (lv_description_4_0= ruleEString ) ) )? otherlv_5= 'table' ( ( ruleEString ) ) otherlv_7= 'column' ( ( ruleEString ) ) otherlv_9= 'lookupTable' ( ( ruleEString ) ) otherlv_11= 'matchColumn' ( ( ruleEString ) ) otherlv_13= 'operandColumn' ( ( ruleEString ) ) otherlv_15= 'lookupColumn' ( ( ruleEString ) ) otherlv_17= 'operation' ( (lv_operation_18_0= ruleLookupOperationType ) ) otherlv_19= 'resultTable' ( ( ruleEString ) ) otherlv_21= 'resultColumn' ( ( ruleEString ) ) otherlv_23= 'next' ( ( ruleEString ) ) otherlv_25= '}'
            {
            otherlv_0=(Token)match(input,55,FOLLOW_3); 

            			newLeafNode(otherlv_0, grammarAccess.getLookupAccess().getLookupKeyword_0());
            		
            // InternalMyDsl.g:2040:3: ( (lv_name_1_0= ruleEString ) )
            // InternalMyDsl.g:2041:4: (lv_name_1_0= ruleEString )
            {
            // InternalMyDsl.g:2041:4: (lv_name_1_0= ruleEString )
            // InternalMyDsl.g:2042:5: lv_name_1_0= ruleEString
            {

            					newCompositeNode(grammarAccess.getLookupAccess().getNameEStringParserRuleCall_1_0());
            				
            pushFollow(FOLLOW_4);
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

            otherlv_2=(Token)match(input,12,FOLLOW_20); 

            			newLeafNode(otherlv_2, grammarAccess.getLookupAccess().getLeftCurlyBracketKeyword_2());
            		
            // InternalMyDsl.g:2063:3: (otherlv_3= 'description' ( (lv_description_4_0= ruleEString ) ) )?
            int alt19=2;
            int LA19_0 = input.LA(1);

            if ( (LA19_0==23) ) {
                alt19=1;
            }
            switch (alt19) {
                case 1 :
                    // InternalMyDsl.g:2064:4: otherlv_3= 'description' ( (lv_description_4_0= ruleEString ) )
                    {
                    otherlv_3=(Token)match(input,23,FOLLOW_3); 

                    				newLeafNode(otherlv_3, grammarAccess.getLookupAccess().getDescriptionKeyword_3_0());
                    			
                    // InternalMyDsl.g:2068:4: ( (lv_description_4_0= ruleEString ) )
                    // InternalMyDsl.g:2069:5: (lv_description_4_0= ruleEString )
                    {
                    // InternalMyDsl.g:2069:5: (lv_description_4_0= ruleEString )
                    // InternalMyDsl.g:2070:6: lv_description_4_0= ruleEString
                    {

                    						newCompositeNode(grammarAccess.getLookupAccess().getDescriptionEStringParserRuleCall_3_1_0());
                    					
                    pushFollow(FOLLOW_21);
                    lv_description_4_0=ruleEString();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getLookupRule());
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

            otherlv_5=(Token)match(input,26,FOLLOW_3); 

            			newLeafNode(otherlv_5, grammarAccess.getLookupAccess().getTableKeyword_4());
            		
            // InternalMyDsl.g:2092:3: ( ( ruleEString ) )
            // InternalMyDsl.g:2093:4: ( ruleEString )
            {
            // InternalMyDsl.g:2093:4: ( ruleEString )
            // InternalMyDsl.g:2094:5: ruleEString
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getLookupRule());
            					}
            				

            					newCompositeNode(grammarAccess.getLookupAccess().getTableTableCrossReference_5_0());
            				
            pushFollow(FOLLOW_31);
            ruleEString();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_7=(Token)match(input,36,FOLLOW_3); 

            			newLeafNode(otherlv_7, grammarAccess.getLookupAccess().getColumnKeyword_6());
            		
            // InternalMyDsl.g:2112:3: ( ( ruleEString ) )
            // InternalMyDsl.g:2113:4: ( ruleEString )
            {
            // InternalMyDsl.g:2113:4: ( ruleEString )
            // InternalMyDsl.g:2114:5: ruleEString
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getLookupRule());
            					}
            				

            					newCompositeNode(grammarAccess.getLookupAccess().getColumnColumnCrossReference_7_0());
            				
            pushFollow(FOLLOW_54);
            ruleEString();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_9=(Token)match(input,56,FOLLOW_3); 

            			newLeafNode(otherlv_9, grammarAccess.getLookupAccess().getLookupTableKeyword_8());
            		
            // InternalMyDsl.g:2132:3: ( ( ruleEString ) )
            // InternalMyDsl.g:2133:4: ( ruleEString )
            {
            // InternalMyDsl.g:2133:4: ( ruleEString )
            // InternalMyDsl.g:2134:5: ruleEString
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getLookupRule());
            					}
            				

            					newCompositeNode(grammarAccess.getLookupAccess().getLookupTableTableCrossReference_9_0());
            				
            pushFollow(FOLLOW_55);
            ruleEString();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_11=(Token)match(input,57,FOLLOW_3); 

            			newLeafNode(otherlv_11, grammarAccess.getLookupAccess().getMatchColumnKeyword_10());
            		
            // InternalMyDsl.g:2152:3: ( ( ruleEString ) )
            // InternalMyDsl.g:2153:4: ( ruleEString )
            {
            // InternalMyDsl.g:2153:4: ( ruleEString )
            // InternalMyDsl.g:2154:5: ruleEString
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getLookupRule());
            					}
            				

            					newCompositeNode(grammarAccess.getLookupAccess().getMatchColumnColumnCrossReference_11_0());
            				
            pushFollow(FOLLOW_27);
            ruleEString();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_13=(Token)match(input,31,FOLLOW_3); 

            			newLeafNode(otherlv_13, grammarAccess.getLookupAccess().getOperandColumnKeyword_12());
            		
            // InternalMyDsl.g:2172:3: ( ( ruleEString ) )
            // InternalMyDsl.g:2173:4: ( ruleEString )
            {
            // InternalMyDsl.g:2173:4: ( ruleEString )
            // InternalMyDsl.g:2174:5: ruleEString
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getLookupRule());
            					}
            				

            					newCompositeNode(grammarAccess.getLookupAccess().getOperandColumnColumnCrossReference_13_0());
            				
            pushFollow(FOLLOW_56);
            ruleEString();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_15=(Token)match(input,58,FOLLOW_3); 

            			newLeafNode(otherlv_15, grammarAccess.getLookupAccess().getLookupColumnKeyword_14());
            		
            // InternalMyDsl.g:2192:3: ( ( ruleEString ) )
            // InternalMyDsl.g:2193:4: ( ruleEString )
            {
            // InternalMyDsl.g:2193:4: ( ruleEString )
            // InternalMyDsl.g:2194:5: ruleEString
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getLookupRule());
            					}
            				

            					newCompositeNode(grammarAccess.getLookupAccess().getLookupColumnColumnCrossReference_15_0());
            				
            pushFollow(FOLLOW_25);
            ruleEString();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_17=(Token)match(input,30,FOLLOW_57); 

            			newLeafNode(otherlv_17, grammarAccess.getLookupAccess().getOperationKeyword_16());
            		
            // InternalMyDsl.g:2212:3: ( (lv_operation_18_0= ruleLookupOperationType ) )
            // InternalMyDsl.g:2213:4: (lv_operation_18_0= ruleLookupOperationType )
            {
            // InternalMyDsl.g:2213:4: (lv_operation_18_0= ruleLookupOperationType )
            // InternalMyDsl.g:2214:5: lv_operation_18_0= ruleLookupOperationType
            {

            					newCompositeNode(grammarAccess.getLookupAccess().getOperationLookupOperationTypeEnumRuleCall_17_0());
            				
            pushFollow(FOLLOW_28);
            lv_operation_18_0=ruleLookupOperationType();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getLookupRule());
            					}
            					set(
            						current,
            						"operation",
            						lv_operation_18_0,
            						"org.xtext.example.mydsl.MyDsl.LookupOperationType");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_19=(Token)match(input,32,FOLLOW_3); 

            			newLeafNode(otherlv_19, grammarAccess.getLookupAccess().getResultTableKeyword_18());
            		
            // InternalMyDsl.g:2235:3: ( ( ruleEString ) )
            // InternalMyDsl.g:2236:4: ( ruleEString )
            {
            // InternalMyDsl.g:2236:4: ( ruleEString )
            // InternalMyDsl.g:2237:5: ruleEString
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getLookupRule());
            					}
            				

            					newCompositeNode(grammarAccess.getLookupAccess().getResultTableTableCrossReference_19_0());
            				
            pushFollow(FOLLOW_29);
            ruleEString();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_21=(Token)match(input,33,FOLLOW_3); 

            			newLeafNode(otherlv_21, grammarAccess.getLookupAccess().getResultColumnKeyword_20());
            		
            // InternalMyDsl.g:2255:3: ( ( ruleEString ) )
            // InternalMyDsl.g:2256:4: ( ruleEString )
            {
            // InternalMyDsl.g:2256:4: ( ruleEString )
            // InternalMyDsl.g:2257:5: ruleEString
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getLookupRule());
            					}
            				

            					newCompositeNode(grammarAccess.getLookupAccess().getResultColumnColumnCrossReference_21_0());
            				
            pushFollow(FOLLOW_30);
            ruleEString();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_23=(Token)match(input,34,FOLLOW_3); 

            			newLeafNode(otherlv_23, grammarAccess.getLookupAccess().getNextKeyword_22());
            		
            // InternalMyDsl.g:2275:3: ( ( ruleEString ) )
            // InternalMyDsl.g:2276:4: ( ruleEString )
            {
            // InternalMyDsl.g:2276:4: ( ruleEString )
            // InternalMyDsl.g:2277:5: ruleEString
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getLookupRule());
            					}
            				

            					newCompositeNode(grammarAccess.getLookupAccess().getNextStepCrossReference_23_0());
            				
            pushFollow(FOLLOW_12);
            ruleEString();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_25=(Token)match(input,16,FOLLOW_2); 

            			newLeafNode(otherlv_25, grammarAccess.getLookupAccess().getRightCurlyBracketKeyword_24());
            		

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
    // InternalMyDsl.g:2299:1: entryRuleRemoveDuplicates returns [EObject current=null] : iv_ruleRemoveDuplicates= ruleRemoveDuplicates EOF ;
    public final EObject entryRuleRemoveDuplicates() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRemoveDuplicates = null;


        try {
            // InternalMyDsl.g:2299:57: (iv_ruleRemoveDuplicates= ruleRemoveDuplicates EOF )
            // InternalMyDsl.g:2300:2: iv_ruleRemoveDuplicates= ruleRemoveDuplicates EOF
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
    // InternalMyDsl.g:2306:1: ruleRemoveDuplicates returns [EObject current=null] : (otherlv_0= 'RemoveDuplicates' ( (lv_name_1_0= ruleEString ) ) otherlv_2= '{' (otherlv_3= 'description' ( (lv_description_4_0= ruleEString ) ) )? otherlv_5= 'table' ( ( ruleEString ) ) otherlv_7= 'column' ( ( ruleEString ) ) otherlv_9= 'next' ( ( ruleEString ) ) otherlv_11= '}' ) ;
    public final EObject ruleRemoveDuplicates() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        Token otherlv_9=null;
        Token otherlv_11=null;
        AntlrDatatypeRuleToken lv_name_1_0 = null;

        AntlrDatatypeRuleToken lv_description_4_0 = null;



        	enterRule();

        try {
            // InternalMyDsl.g:2312:2: ( (otherlv_0= 'RemoveDuplicates' ( (lv_name_1_0= ruleEString ) ) otherlv_2= '{' (otherlv_3= 'description' ( (lv_description_4_0= ruleEString ) ) )? otherlv_5= 'table' ( ( ruleEString ) ) otherlv_7= 'column' ( ( ruleEString ) ) otherlv_9= 'next' ( ( ruleEString ) ) otherlv_11= '}' ) )
            // InternalMyDsl.g:2313:2: (otherlv_0= 'RemoveDuplicates' ( (lv_name_1_0= ruleEString ) ) otherlv_2= '{' (otherlv_3= 'description' ( (lv_description_4_0= ruleEString ) ) )? otherlv_5= 'table' ( ( ruleEString ) ) otherlv_7= 'column' ( ( ruleEString ) ) otherlv_9= 'next' ( ( ruleEString ) ) otherlv_11= '}' )
            {
            // InternalMyDsl.g:2313:2: (otherlv_0= 'RemoveDuplicates' ( (lv_name_1_0= ruleEString ) ) otherlv_2= '{' (otherlv_3= 'description' ( (lv_description_4_0= ruleEString ) ) )? otherlv_5= 'table' ( ( ruleEString ) ) otherlv_7= 'column' ( ( ruleEString ) ) otherlv_9= 'next' ( ( ruleEString ) ) otherlv_11= '}' )
            // InternalMyDsl.g:2314:3: otherlv_0= 'RemoveDuplicates' ( (lv_name_1_0= ruleEString ) ) otherlv_2= '{' (otherlv_3= 'description' ( (lv_description_4_0= ruleEString ) ) )? otherlv_5= 'table' ( ( ruleEString ) ) otherlv_7= 'column' ( ( ruleEString ) ) otherlv_9= 'next' ( ( ruleEString ) ) otherlv_11= '}'
            {
            otherlv_0=(Token)match(input,59,FOLLOW_3); 

            			newLeafNode(otherlv_0, grammarAccess.getRemoveDuplicatesAccess().getRemoveDuplicatesKeyword_0());
            		
            // InternalMyDsl.g:2318:3: ( (lv_name_1_0= ruleEString ) )
            // InternalMyDsl.g:2319:4: (lv_name_1_0= ruleEString )
            {
            // InternalMyDsl.g:2319:4: (lv_name_1_0= ruleEString )
            // InternalMyDsl.g:2320:5: lv_name_1_0= ruleEString
            {

            					newCompositeNode(grammarAccess.getRemoveDuplicatesAccess().getNameEStringParserRuleCall_1_0());
            				
            pushFollow(FOLLOW_4);
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

            otherlv_2=(Token)match(input,12,FOLLOW_20); 

            			newLeafNode(otherlv_2, grammarAccess.getRemoveDuplicatesAccess().getLeftCurlyBracketKeyword_2());
            		
            // InternalMyDsl.g:2341:3: (otherlv_3= 'description' ( (lv_description_4_0= ruleEString ) ) )?
            int alt20=2;
            int LA20_0 = input.LA(1);

            if ( (LA20_0==23) ) {
                alt20=1;
            }
            switch (alt20) {
                case 1 :
                    // InternalMyDsl.g:2342:4: otherlv_3= 'description' ( (lv_description_4_0= ruleEString ) )
                    {
                    otherlv_3=(Token)match(input,23,FOLLOW_3); 

                    				newLeafNode(otherlv_3, grammarAccess.getRemoveDuplicatesAccess().getDescriptionKeyword_3_0());
                    			
                    // InternalMyDsl.g:2346:4: ( (lv_description_4_0= ruleEString ) )
                    // InternalMyDsl.g:2347:5: (lv_description_4_0= ruleEString )
                    {
                    // InternalMyDsl.g:2347:5: (lv_description_4_0= ruleEString )
                    // InternalMyDsl.g:2348:6: lv_description_4_0= ruleEString
                    {

                    						newCompositeNode(grammarAccess.getRemoveDuplicatesAccess().getDescriptionEStringParserRuleCall_3_1_0());
                    					
                    pushFollow(FOLLOW_21);
                    lv_description_4_0=ruleEString();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getRemoveDuplicatesRule());
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

            otherlv_5=(Token)match(input,26,FOLLOW_3); 

            			newLeafNode(otherlv_5, grammarAccess.getRemoveDuplicatesAccess().getTableKeyword_4());
            		
            // InternalMyDsl.g:2370:3: ( ( ruleEString ) )
            // InternalMyDsl.g:2371:4: ( ruleEString )
            {
            // InternalMyDsl.g:2371:4: ( ruleEString )
            // InternalMyDsl.g:2372:5: ruleEString
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getRemoveDuplicatesRule());
            					}
            				

            					newCompositeNode(grammarAccess.getRemoveDuplicatesAccess().getTableTableCrossReference_5_0());
            				
            pushFollow(FOLLOW_31);
            ruleEString();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_7=(Token)match(input,36,FOLLOW_3); 

            			newLeafNode(otherlv_7, grammarAccess.getRemoveDuplicatesAccess().getColumnKeyword_6());
            		
            // InternalMyDsl.g:2390:3: ( ( ruleEString ) )
            // InternalMyDsl.g:2391:4: ( ruleEString )
            {
            // InternalMyDsl.g:2391:4: ( ruleEString )
            // InternalMyDsl.g:2392:5: ruleEString
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getRemoveDuplicatesRule());
            					}
            				

            					newCompositeNode(grammarAccess.getRemoveDuplicatesAccess().getColumnColumnCrossReference_7_0());
            				
            pushFollow(FOLLOW_30);
            ruleEString();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_9=(Token)match(input,34,FOLLOW_3); 

            			newLeafNode(otherlv_9, grammarAccess.getRemoveDuplicatesAccess().getNextKeyword_8());
            		
            // InternalMyDsl.g:2410:3: ( ( ruleEString ) )
            // InternalMyDsl.g:2411:4: ( ruleEString )
            {
            // InternalMyDsl.g:2411:4: ( ruleEString )
            // InternalMyDsl.g:2412:5: ruleEString
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getRemoveDuplicatesRule());
            					}
            				

            					newCompositeNode(grammarAccess.getRemoveDuplicatesAccess().getNextStepCrossReference_9_0());
            				
            pushFollow(FOLLOW_12);
            ruleEString();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_11=(Token)match(input,16,FOLLOW_2); 

            			newLeafNode(otherlv_11, grammarAccess.getRemoveDuplicatesAccess().getRightCurlyBracketKeyword_10());
            		

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
    // InternalMyDsl.g:2434:1: entryRuleConcat returns [EObject current=null] : iv_ruleConcat= ruleConcat EOF ;
    public final EObject entryRuleConcat() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleConcat = null;


        try {
            // InternalMyDsl.g:2434:47: (iv_ruleConcat= ruleConcat EOF )
            // InternalMyDsl.g:2435:2: iv_ruleConcat= ruleConcat EOF
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
    // InternalMyDsl.g:2441:1: ruleConcat returns [EObject current=null] : (otherlv_0= 'Concat' ( (lv_name_1_0= ruleEString ) ) otherlv_2= '{' (otherlv_3= 'description' ( (lv_description_4_0= ruleEString ) ) )? otherlv_5= 'table' ( ( ruleEString ) ) otherlv_7= 'sourceA' ( ( ruleEString ) ) otherlv_9= 'sourceB' ( ( ruleEString ) ) otherlv_11= 'resultColumn' ( ( ruleEString ) ) otherlv_13= 'resultTable' ( ( ruleEString ) ) otherlv_15= 'next' ( ( ruleEString ) ) otherlv_17= '}' ) ;
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
            // InternalMyDsl.g:2447:2: ( (otherlv_0= 'Concat' ( (lv_name_1_0= ruleEString ) ) otherlv_2= '{' (otherlv_3= 'description' ( (lv_description_4_0= ruleEString ) ) )? otherlv_5= 'table' ( ( ruleEString ) ) otherlv_7= 'sourceA' ( ( ruleEString ) ) otherlv_9= 'sourceB' ( ( ruleEString ) ) otherlv_11= 'resultColumn' ( ( ruleEString ) ) otherlv_13= 'resultTable' ( ( ruleEString ) ) otherlv_15= 'next' ( ( ruleEString ) ) otherlv_17= '}' ) )
            // InternalMyDsl.g:2448:2: (otherlv_0= 'Concat' ( (lv_name_1_0= ruleEString ) ) otherlv_2= '{' (otherlv_3= 'description' ( (lv_description_4_0= ruleEString ) ) )? otherlv_5= 'table' ( ( ruleEString ) ) otherlv_7= 'sourceA' ( ( ruleEString ) ) otherlv_9= 'sourceB' ( ( ruleEString ) ) otherlv_11= 'resultColumn' ( ( ruleEString ) ) otherlv_13= 'resultTable' ( ( ruleEString ) ) otherlv_15= 'next' ( ( ruleEString ) ) otherlv_17= '}' )
            {
            // InternalMyDsl.g:2448:2: (otherlv_0= 'Concat' ( (lv_name_1_0= ruleEString ) ) otherlv_2= '{' (otherlv_3= 'description' ( (lv_description_4_0= ruleEString ) ) )? otherlv_5= 'table' ( ( ruleEString ) ) otherlv_7= 'sourceA' ( ( ruleEString ) ) otherlv_9= 'sourceB' ( ( ruleEString ) ) otherlv_11= 'resultColumn' ( ( ruleEString ) ) otherlv_13= 'resultTable' ( ( ruleEString ) ) otherlv_15= 'next' ( ( ruleEString ) ) otherlv_17= '}' )
            // InternalMyDsl.g:2449:3: otherlv_0= 'Concat' ( (lv_name_1_0= ruleEString ) ) otherlv_2= '{' (otherlv_3= 'description' ( (lv_description_4_0= ruleEString ) ) )? otherlv_5= 'table' ( ( ruleEString ) ) otherlv_7= 'sourceA' ( ( ruleEString ) ) otherlv_9= 'sourceB' ( ( ruleEString ) ) otherlv_11= 'resultColumn' ( ( ruleEString ) ) otherlv_13= 'resultTable' ( ( ruleEString ) ) otherlv_15= 'next' ( ( ruleEString ) ) otherlv_17= '}'
            {
            otherlv_0=(Token)match(input,60,FOLLOW_3); 

            			newLeafNode(otherlv_0, grammarAccess.getConcatAccess().getConcatKeyword_0());
            		
            // InternalMyDsl.g:2453:3: ( (lv_name_1_0= ruleEString ) )
            // InternalMyDsl.g:2454:4: (lv_name_1_0= ruleEString )
            {
            // InternalMyDsl.g:2454:4: (lv_name_1_0= ruleEString )
            // InternalMyDsl.g:2455:5: lv_name_1_0= ruleEString
            {

            					newCompositeNode(grammarAccess.getConcatAccess().getNameEStringParserRuleCall_1_0());
            				
            pushFollow(FOLLOW_4);
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

            otherlv_2=(Token)match(input,12,FOLLOW_20); 

            			newLeafNode(otherlv_2, grammarAccess.getConcatAccess().getLeftCurlyBracketKeyword_2());
            		
            // InternalMyDsl.g:2476:3: (otherlv_3= 'description' ( (lv_description_4_0= ruleEString ) ) )?
            int alt21=2;
            int LA21_0 = input.LA(1);

            if ( (LA21_0==23) ) {
                alt21=1;
            }
            switch (alt21) {
                case 1 :
                    // InternalMyDsl.g:2477:4: otherlv_3= 'description' ( (lv_description_4_0= ruleEString ) )
                    {
                    otherlv_3=(Token)match(input,23,FOLLOW_3); 

                    				newLeafNode(otherlv_3, grammarAccess.getConcatAccess().getDescriptionKeyword_3_0());
                    			
                    // InternalMyDsl.g:2481:4: ( (lv_description_4_0= ruleEString ) )
                    // InternalMyDsl.g:2482:5: (lv_description_4_0= ruleEString )
                    {
                    // InternalMyDsl.g:2482:5: (lv_description_4_0= ruleEString )
                    // InternalMyDsl.g:2483:6: lv_description_4_0= ruleEString
                    {

                    						newCompositeNode(grammarAccess.getConcatAccess().getDescriptionEStringParserRuleCall_3_1_0());
                    					
                    pushFollow(FOLLOW_21);
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

            otherlv_5=(Token)match(input,26,FOLLOW_3); 

            			newLeafNode(otherlv_5, grammarAccess.getConcatAccess().getTableKeyword_4());
            		
            // InternalMyDsl.g:2505:3: ( ( ruleEString ) )
            // InternalMyDsl.g:2506:4: ( ruleEString )
            {
            // InternalMyDsl.g:2506:4: ( ruleEString )
            // InternalMyDsl.g:2507:5: ruleEString
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getConcatRule());
            					}
            				

            					newCompositeNode(grammarAccess.getConcatAccess().getTableTableCrossReference_5_0());
            				
            pushFollow(FOLLOW_58);
            ruleEString();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_7=(Token)match(input,61,FOLLOW_3); 

            			newLeafNode(otherlv_7, grammarAccess.getConcatAccess().getSourceAKeyword_6());
            		
            // InternalMyDsl.g:2525:3: ( ( ruleEString ) )
            // InternalMyDsl.g:2526:4: ( ruleEString )
            {
            // InternalMyDsl.g:2526:4: ( ruleEString )
            // InternalMyDsl.g:2527:5: ruleEString
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getConcatRule());
            					}
            				

            					newCompositeNode(grammarAccess.getConcatAccess().getSourceAColumnCrossReference_7_0());
            				
            pushFollow(FOLLOW_59);
            ruleEString();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_9=(Token)match(input,62,FOLLOW_3); 

            			newLeafNode(otherlv_9, grammarAccess.getConcatAccess().getSourceBKeyword_8());
            		
            // InternalMyDsl.g:2545:3: ( ( ruleEString ) )
            // InternalMyDsl.g:2546:4: ( ruleEString )
            {
            // InternalMyDsl.g:2546:4: ( ruleEString )
            // InternalMyDsl.g:2547:5: ruleEString
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getConcatRule());
            					}
            				

            					newCompositeNode(grammarAccess.getConcatAccess().getSourceBColumnCrossReference_9_0());
            				
            pushFollow(FOLLOW_29);
            ruleEString();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_11=(Token)match(input,33,FOLLOW_3); 

            			newLeafNode(otherlv_11, grammarAccess.getConcatAccess().getResultColumnKeyword_10());
            		
            // InternalMyDsl.g:2565:3: ( ( ruleEString ) )
            // InternalMyDsl.g:2566:4: ( ruleEString )
            {
            // InternalMyDsl.g:2566:4: ( ruleEString )
            // InternalMyDsl.g:2567:5: ruleEString
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getConcatRule());
            					}
            				

            					newCompositeNode(grammarAccess.getConcatAccess().getResultColumnColumnCrossReference_11_0());
            				
            pushFollow(FOLLOW_28);
            ruleEString();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_13=(Token)match(input,32,FOLLOW_3); 

            			newLeafNode(otherlv_13, grammarAccess.getConcatAccess().getResultTableKeyword_12());
            		
            // InternalMyDsl.g:2585:3: ( ( ruleEString ) )
            // InternalMyDsl.g:2586:4: ( ruleEString )
            {
            // InternalMyDsl.g:2586:4: ( ruleEString )
            // InternalMyDsl.g:2587:5: ruleEString
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getConcatRule());
            					}
            				

            					newCompositeNode(grammarAccess.getConcatAccess().getResultTableTableCrossReference_13_0());
            				
            pushFollow(FOLLOW_30);
            ruleEString();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_15=(Token)match(input,34,FOLLOW_3); 

            			newLeafNode(otherlv_15, grammarAccess.getConcatAccess().getNextKeyword_14());
            		
            // InternalMyDsl.g:2605:3: ( ( ruleEString ) )
            // InternalMyDsl.g:2606:4: ( ruleEString )
            {
            // InternalMyDsl.g:2606:4: ( ruleEString )
            // InternalMyDsl.g:2607:5: ruleEString
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getConcatRule());
            					}
            				

            					newCompositeNode(grammarAccess.getConcatAccess().getNextStepCrossReference_15_0());
            				
            pushFollow(FOLLOW_12);
            ruleEString();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_17=(Token)match(input,16,FOLLOW_2); 

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
    // InternalMyDsl.g:2629:1: entryRuleSplit returns [EObject current=null] : iv_ruleSplit= ruleSplit EOF ;
    public final EObject entryRuleSplit() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSplit = null;


        try {
            // InternalMyDsl.g:2629:46: (iv_ruleSplit= ruleSplit EOF )
            // InternalMyDsl.g:2630:2: iv_ruleSplit= ruleSplit EOF
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
    // InternalMyDsl.g:2636:1: ruleSplit returns [EObject current=null] : (otherlv_0= 'Split' ( (lv_name_1_0= ruleEString ) ) otherlv_2= '{' (otherlv_3= 'description' ( (lv_description_4_0= ruleEString ) ) )? otherlv_5= 'table' ( ( ruleEString ) ) otherlv_7= 'source' ( ( ruleEString ) ) otherlv_9= 'delimiter' ( (lv_delimiter_10_0= ruleEString ) ) otherlv_11= 'atCharIndex' ( (lv_atCharIndex_12_0= ruleEIntegerObject ) ) otherlv_13= 'resultColumnA' ( ( ruleEString ) ) otherlv_15= 'resultColumnB' ( ( ruleEString ) ) otherlv_17= 'resultTable' ( ( ruleEString ) ) otherlv_19= 'next' ( ( ruleEString ) ) otherlv_21= '}' ) ;
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
            // InternalMyDsl.g:2642:2: ( (otherlv_0= 'Split' ( (lv_name_1_0= ruleEString ) ) otherlv_2= '{' (otherlv_3= 'description' ( (lv_description_4_0= ruleEString ) ) )? otherlv_5= 'table' ( ( ruleEString ) ) otherlv_7= 'source' ( ( ruleEString ) ) otherlv_9= 'delimiter' ( (lv_delimiter_10_0= ruleEString ) ) otherlv_11= 'atCharIndex' ( (lv_atCharIndex_12_0= ruleEIntegerObject ) ) otherlv_13= 'resultColumnA' ( ( ruleEString ) ) otherlv_15= 'resultColumnB' ( ( ruleEString ) ) otherlv_17= 'resultTable' ( ( ruleEString ) ) otherlv_19= 'next' ( ( ruleEString ) ) otherlv_21= '}' ) )
            // InternalMyDsl.g:2643:2: (otherlv_0= 'Split' ( (lv_name_1_0= ruleEString ) ) otherlv_2= '{' (otherlv_3= 'description' ( (lv_description_4_0= ruleEString ) ) )? otherlv_5= 'table' ( ( ruleEString ) ) otherlv_7= 'source' ( ( ruleEString ) ) otherlv_9= 'delimiter' ( (lv_delimiter_10_0= ruleEString ) ) otherlv_11= 'atCharIndex' ( (lv_atCharIndex_12_0= ruleEIntegerObject ) ) otherlv_13= 'resultColumnA' ( ( ruleEString ) ) otherlv_15= 'resultColumnB' ( ( ruleEString ) ) otherlv_17= 'resultTable' ( ( ruleEString ) ) otherlv_19= 'next' ( ( ruleEString ) ) otherlv_21= '}' )
            {
            // InternalMyDsl.g:2643:2: (otherlv_0= 'Split' ( (lv_name_1_0= ruleEString ) ) otherlv_2= '{' (otherlv_3= 'description' ( (lv_description_4_0= ruleEString ) ) )? otherlv_5= 'table' ( ( ruleEString ) ) otherlv_7= 'source' ( ( ruleEString ) ) otherlv_9= 'delimiter' ( (lv_delimiter_10_0= ruleEString ) ) otherlv_11= 'atCharIndex' ( (lv_atCharIndex_12_0= ruleEIntegerObject ) ) otherlv_13= 'resultColumnA' ( ( ruleEString ) ) otherlv_15= 'resultColumnB' ( ( ruleEString ) ) otherlv_17= 'resultTable' ( ( ruleEString ) ) otherlv_19= 'next' ( ( ruleEString ) ) otherlv_21= '}' )
            // InternalMyDsl.g:2644:3: otherlv_0= 'Split' ( (lv_name_1_0= ruleEString ) ) otherlv_2= '{' (otherlv_3= 'description' ( (lv_description_4_0= ruleEString ) ) )? otherlv_5= 'table' ( ( ruleEString ) ) otherlv_7= 'source' ( ( ruleEString ) ) otherlv_9= 'delimiter' ( (lv_delimiter_10_0= ruleEString ) ) otherlv_11= 'atCharIndex' ( (lv_atCharIndex_12_0= ruleEIntegerObject ) ) otherlv_13= 'resultColumnA' ( ( ruleEString ) ) otherlv_15= 'resultColumnB' ( ( ruleEString ) ) otherlv_17= 'resultTable' ( ( ruleEString ) ) otherlv_19= 'next' ( ( ruleEString ) ) otherlv_21= '}'
            {
            otherlv_0=(Token)match(input,63,FOLLOW_3); 

            			newLeafNode(otherlv_0, grammarAccess.getSplitAccess().getSplitKeyword_0());
            		
            // InternalMyDsl.g:2648:3: ( (lv_name_1_0= ruleEString ) )
            // InternalMyDsl.g:2649:4: (lv_name_1_0= ruleEString )
            {
            // InternalMyDsl.g:2649:4: (lv_name_1_0= ruleEString )
            // InternalMyDsl.g:2650:5: lv_name_1_0= ruleEString
            {

            					newCompositeNode(grammarAccess.getSplitAccess().getNameEStringParserRuleCall_1_0());
            				
            pushFollow(FOLLOW_4);
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

            otherlv_2=(Token)match(input,12,FOLLOW_20); 

            			newLeafNode(otherlv_2, grammarAccess.getSplitAccess().getLeftCurlyBracketKeyword_2());
            		
            // InternalMyDsl.g:2671:3: (otherlv_3= 'description' ( (lv_description_4_0= ruleEString ) ) )?
            int alt22=2;
            int LA22_0 = input.LA(1);

            if ( (LA22_0==23) ) {
                alt22=1;
            }
            switch (alt22) {
                case 1 :
                    // InternalMyDsl.g:2672:4: otherlv_3= 'description' ( (lv_description_4_0= ruleEString ) )
                    {
                    otherlv_3=(Token)match(input,23,FOLLOW_3); 

                    				newLeafNode(otherlv_3, grammarAccess.getSplitAccess().getDescriptionKeyword_3_0());
                    			
                    // InternalMyDsl.g:2676:4: ( (lv_description_4_0= ruleEString ) )
                    // InternalMyDsl.g:2677:5: (lv_description_4_0= ruleEString )
                    {
                    // InternalMyDsl.g:2677:5: (lv_description_4_0= ruleEString )
                    // InternalMyDsl.g:2678:6: lv_description_4_0= ruleEString
                    {

                    						newCompositeNode(grammarAccess.getSplitAccess().getDescriptionEStringParserRuleCall_3_1_0());
                    					
                    pushFollow(FOLLOW_21);
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

            otherlv_5=(Token)match(input,26,FOLLOW_3); 

            			newLeafNode(otherlv_5, grammarAccess.getSplitAccess().getTableKeyword_4());
            		
            // InternalMyDsl.g:2700:3: ( ( ruleEString ) )
            // InternalMyDsl.g:2701:4: ( ruleEString )
            {
            // InternalMyDsl.g:2701:4: ( ruleEString )
            // InternalMyDsl.g:2702:5: ruleEString
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getSplitRule());
            					}
            				

            					newCompositeNode(grammarAccess.getSplitAccess().getTableTableCrossReference_5_0());
            				
            pushFollow(FOLLOW_60);
            ruleEString();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_7=(Token)match(input,64,FOLLOW_3); 

            			newLeafNode(otherlv_7, grammarAccess.getSplitAccess().getSourceKeyword_6());
            		
            // InternalMyDsl.g:2720:3: ( ( ruleEString ) )
            // InternalMyDsl.g:2721:4: ( ruleEString )
            {
            // InternalMyDsl.g:2721:4: ( ruleEString )
            // InternalMyDsl.g:2722:5: ruleEString
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getSplitRule());
            					}
            				

            					newCompositeNode(grammarAccess.getSplitAccess().getSourceColumnCrossReference_7_0());
            				
            pushFollow(FOLLOW_61);
            ruleEString();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_9=(Token)match(input,65,FOLLOW_3); 

            			newLeafNode(otherlv_9, grammarAccess.getSplitAccess().getDelimiterKeyword_8());
            		
            // InternalMyDsl.g:2740:3: ( (lv_delimiter_10_0= ruleEString ) )
            // InternalMyDsl.g:2741:4: (lv_delimiter_10_0= ruleEString )
            {
            // InternalMyDsl.g:2741:4: (lv_delimiter_10_0= ruleEString )
            // InternalMyDsl.g:2742:5: lv_delimiter_10_0= ruleEString
            {

            					newCompositeNode(grammarAccess.getSplitAccess().getDelimiterEStringParserRuleCall_9_0());
            				
            pushFollow(FOLLOW_62);
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

            otherlv_11=(Token)match(input,66,FOLLOW_63); 

            			newLeafNode(otherlv_11, grammarAccess.getSplitAccess().getAtCharIndexKeyword_10());
            		
            // InternalMyDsl.g:2763:3: ( (lv_atCharIndex_12_0= ruleEIntegerObject ) )
            // InternalMyDsl.g:2764:4: (lv_atCharIndex_12_0= ruleEIntegerObject )
            {
            // InternalMyDsl.g:2764:4: (lv_atCharIndex_12_0= ruleEIntegerObject )
            // InternalMyDsl.g:2765:5: lv_atCharIndex_12_0= ruleEIntegerObject
            {

            					newCompositeNode(grammarAccess.getSplitAccess().getAtCharIndexEIntegerObjectParserRuleCall_11_0());
            				
            pushFollow(FOLLOW_64);
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

            otherlv_13=(Token)match(input,67,FOLLOW_3); 

            			newLeafNode(otherlv_13, grammarAccess.getSplitAccess().getResultColumnAKeyword_12());
            		
            // InternalMyDsl.g:2786:3: ( ( ruleEString ) )
            // InternalMyDsl.g:2787:4: ( ruleEString )
            {
            // InternalMyDsl.g:2787:4: ( ruleEString )
            // InternalMyDsl.g:2788:5: ruleEString
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getSplitRule());
            					}
            				

            					newCompositeNode(grammarAccess.getSplitAccess().getResultColumnAColumnCrossReference_13_0());
            				
            pushFollow(FOLLOW_65);
            ruleEString();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_15=(Token)match(input,68,FOLLOW_3); 

            			newLeafNode(otherlv_15, grammarAccess.getSplitAccess().getResultColumnBKeyword_14());
            		
            // InternalMyDsl.g:2806:3: ( ( ruleEString ) )
            // InternalMyDsl.g:2807:4: ( ruleEString )
            {
            // InternalMyDsl.g:2807:4: ( ruleEString )
            // InternalMyDsl.g:2808:5: ruleEString
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getSplitRule());
            					}
            				

            					newCompositeNode(grammarAccess.getSplitAccess().getResultColumnBColumnCrossReference_15_0());
            				
            pushFollow(FOLLOW_28);
            ruleEString();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_17=(Token)match(input,32,FOLLOW_3); 

            			newLeafNode(otherlv_17, grammarAccess.getSplitAccess().getResultTableKeyword_16());
            		
            // InternalMyDsl.g:2826:3: ( ( ruleEString ) )
            // InternalMyDsl.g:2827:4: ( ruleEString )
            {
            // InternalMyDsl.g:2827:4: ( ruleEString )
            // InternalMyDsl.g:2828:5: ruleEString
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getSplitRule());
            					}
            				

            					newCompositeNode(grammarAccess.getSplitAccess().getResultTableTableCrossReference_17_0());
            				
            pushFollow(FOLLOW_30);
            ruleEString();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_19=(Token)match(input,34,FOLLOW_3); 

            			newLeafNode(otherlv_19, grammarAccess.getSplitAccess().getNextKeyword_18());
            		
            // InternalMyDsl.g:2846:3: ( ( ruleEString ) )
            // InternalMyDsl.g:2847:4: ( ruleEString )
            {
            // InternalMyDsl.g:2847:4: ( ruleEString )
            // InternalMyDsl.g:2848:5: ruleEString
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getSplitRule());
            					}
            				

            					newCompositeNode(grammarAccess.getSplitAccess().getNextStepCrossReference_19_0());
            				
            pushFollow(FOLLOW_12);
            ruleEString();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_21=(Token)match(input,16,FOLLOW_2); 

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
    // InternalMyDsl.g:2870:1: entryRuleExtract returns [EObject current=null] : iv_ruleExtract= ruleExtract EOF ;
    public final EObject entryRuleExtract() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExtract = null;


        try {
            // InternalMyDsl.g:2870:48: (iv_ruleExtract= ruleExtract EOF )
            // InternalMyDsl.g:2871:2: iv_ruleExtract= ruleExtract EOF
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
    // InternalMyDsl.g:2877:1: ruleExtract returns [EObject current=null] : (otherlv_0= 'Extract' ( (lv_name_1_0= ruleEString ) ) otherlv_2= '{' (otherlv_3= 'description' ( (lv_description_4_0= ruleEString ) ) )? otherlv_5= 'table' ( ( ruleEString ) ) otherlv_7= 'column' ( ( ruleEString ) ) otherlv_9= 'lbChar' ( (lv_lbChar_10_0= ruleEIntegerObject ) ) otherlv_11= 'ubChar' ( (lv_ubChar_12_0= ruleEIntegerObject ) ) otherlv_13= 'pattern' ( (lv_pattern_14_0= ruleEString ) ) otherlv_15= 'next' ( ( ruleEString ) ) otherlv_17= '}' ) ;
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
            // InternalMyDsl.g:2883:2: ( (otherlv_0= 'Extract' ( (lv_name_1_0= ruleEString ) ) otherlv_2= '{' (otherlv_3= 'description' ( (lv_description_4_0= ruleEString ) ) )? otherlv_5= 'table' ( ( ruleEString ) ) otherlv_7= 'column' ( ( ruleEString ) ) otherlv_9= 'lbChar' ( (lv_lbChar_10_0= ruleEIntegerObject ) ) otherlv_11= 'ubChar' ( (lv_ubChar_12_0= ruleEIntegerObject ) ) otherlv_13= 'pattern' ( (lv_pattern_14_0= ruleEString ) ) otherlv_15= 'next' ( ( ruleEString ) ) otherlv_17= '}' ) )
            // InternalMyDsl.g:2884:2: (otherlv_0= 'Extract' ( (lv_name_1_0= ruleEString ) ) otherlv_2= '{' (otherlv_3= 'description' ( (lv_description_4_0= ruleEString ) ) )? otherlv_5= 'table' ( ( ruleEString ) ) otherlv_7= 'column' ( ( ruleEString ) ) otherlv_9= 'lbChar' ( (lv_lbChar_10_0= ruleEIntegerObject ) ) otherlv_11= 'ubChar' ( (lv_ubChar_12_0= ruleEIntegerObject ) ) otherlv_13= 'pattern' ( (lv_pattern_14_0= ruleEString ) ) otherlv_15= 'next' ( ( ruleEString ) ) otherlv_17= '}' )
            {
            // InternalMyDsl.g:2884:2: (otherlv_0= 'Extract' ( (lv_name_1_0= ruleEString ) ) otherlv_2= '{' (otherlv_3= 'description' ( (lv_description_4_0= ruleEString ) ) )? otherlv_5= 'table' ( ( ruleEString ) ) otherlv_7= 'column' ( ( ruleEString ) ) otherlv_9= 'lbChar' ( (lv_lbChar_10_0= ruleEIntegerObject ) ) otherlv_11= 'ubChar' ( (lv_ubChar_12_0= ruleEIntegerObject ) ) otherlv_13= 'pattern' ( (lv_pattern_14_0= ruleEString ) ) otherlv_15= 'next' ( ( ruleEString ) ) otherlv_17= '}' )
            // InternalMyDsl.g:2885:3: otherlv_0= 'Extract' ( (lv_name_1_0= ruleEString ) ) otherlv_2= '{' (otherlv_3= 'description' ( (lv_description_4_0= ruleEString ) ) )? otherlv_5= 'table' ( ( ruleEString ) ) otherlv_7= 'column' ( ( ruleEString ) ) otherlv_9= 'lbChar' ( (lv_lbChar_10_0= ruleEIntegerObject ) ) otherlv_11= 'ubChar' ( (lv_ubChar_12_0= ruleEIntegerObject ) ) otherlv_13= 'pattern' ( (lv_pattern_14_0= ruleEString ) ) otherlv_15= 'next' ( ( ruleEString ) ) otherlv_17= '}'
            {
            otherlv_0=(Token)match(input,69,FOLLOW_3); 

            			newLeafNode(otherlv_0, grammarAccess.getExtractAccess().getExtractKeyword_0());
            		
            // InternalMyDsl.g:2889:3: ( (lv_name_1_0= ruleEString ) )
            // InternalMyDsl.g:2890:4: (lv_name_1_0= ruleEString )
            {
            // InternalMyDsl.g:2890:4: (lv_name_1_0= ruleEString )
            // InternalMyDsl.g:2891:5: lv_name_1_0= ruleEString
            {

            					newCompositeNode(grammarAccess.getExtractAccess().getNameEStringParserRuleCall_1_0());
            				
            pushFollow(FOLLOW_4);
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

            otherlv_2=(Token)match(input,12,FOLLOW_20); 

            			newLeafNode(otherlv_2, grammarAccess.getExtractAccess().getLeftCurlyBracketKeyword_2());
            		
            // InternalMyDsl.g:2912:3: (otherlv_3= 'description' ( (lv_description_4_0= ruleEString ) ) )?
            int alt23=2;
            int LA23_0 = input.LA(1);

            if ( (LA23_0==23) ) {
                alt23=1;
            }
            switch (alt23) {
                case 1 :
                    // InternalMyDsl.g:2913:4: otherlv_3= 'description' ( (lv_description_4_0= ruleEString ) )
                    {
                    otherlv_3=(Token)match(input,23,FOLLOW_3); 

                    				newLeafNode(otherlv_3, grammarAccess.getExtractAccess().getDescriptionKeyword_3_0());
                    			
                    // InternalMyDsl.g:2917:4: ( (lv_description_4_0= ruleEString ) )
                    // InternalMyDsl.g:2918:5: (lv_description_4_0= ruleEString )
                    {
                    // InternalMyDsl.g:2918:5: (lv_description_4_0= ruleEString )
                    // InternalMyDsl.g:2919:6: lv_description_4_0= ruleEString
                    {

                    						newCompositeNode(grammarAccess.getExtractAccess().getDescriptionEStringParserRuleCall_3_1_0());
                    					
                    pushFollow(FOLLOW_21);
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

            otherlv_5=(Token)match(input,26,FOLLOW_3); 

            			newLeafNode(otherlv_5, grammarAccess.getExtractAccess().getTableKeyword_4());
            		
            // InternalMyDsl.g:2941:3: ( ( ruleEString ) )
            // InternalMyDsl.g:2942:4: ( ruleEString )
            {
            // InternalMyDsl.g:2942:4: ( ruleEString )
            // InternalMyDsl.g:2943:5: ruleEString
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getExtractRule());
            					}
            				

            					newCompositeNode(grammarAccess.getExtractAccess().getTableTableCrossReference_5_0());
            				
            pushFollow(FOLLOW_31);
            ruleEString();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_7=(Token)match(input,36,FOLLOW_3); 

            			newLeafNode(otherlv_7, grammarAccess.getExtractAccess().getColumnKeyword_6());
            		
            // InternalMyDsl.g:2961:3: ( ( ruleEString ) )
            // InternalMyDsl.g:2962:4: ( ruleEString )
            {
            // InternalMyDsl.g:2962:4: ( ruleEString )
            // InternalMyDsl.g:2963:5: ruleEString
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getExtractRule());
            					}
            				

            					newCompositeNode(grammarAccess.getExtractAccess().getColumnColumnCrossReference_7_0());
            				
            pushFollow(FOLLOW_66);
            ruleEString();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_9=(Token)match(input,70,FOLLOW_63); 

            			newLeafNode(otherlv_9, grammarAccess.getExtractAccess().getLbCharKeyword_8());
            		
            // InternalMyDsl.g:2981:3: ( (lv_lbChar_10_0= ruleEIntegerObject ) )
            // InternalMyDsl.g:2982:4: (lv_lbChar_10_0= ruleEIntegerObject )
            {
            // InternalMyDsl.g:2982:4: (lv_lbChar_10_0= ruleEIntegerObject )
            // InternalMyDsl.g:2983:5: lv_lbChar_10_0= ruleEIntegerObject
            {

            					newCompositeNode(grammarAccess.getExtractAccess().getLbCharEIntegerObjectParserRuleCall_9_0());
            				
            pushFollow(FOLLOW_67);
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

            otherlv_11=(Token)match(input,71,FOLLOW_63); 

            			newLeafNode(otherlv_11, grammarAccess.getExtractAccess().getUbCharKeyword_10());
            		
            // InternalMyDsl.g:3004:3: ( (lv_ubChar_12_0= ruleEIntegerObject ) )
            // InternalMyDsl.g:3005:4: (lv_ubChar_12_0= ruleEIntegerObject )
            {
            // InternalMyDsl.g:3005:4: (lv_ubChar_12_0= ruleEIntegerObject )
            // InternalMyDsl.g:3006:5: lv_ubChar_12_0= ruleEIntegerObject
            {

            					newCompositeNode(grammarAccess.getExtractAccess().getUbCharEIntegerObjectParserRuleCall_11_0());
            				
            pushFollow(FOLLOW_68);
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

            otherlv_13=(Token)match(input,72,FOLLOW_3); 

            			newLeafNode(otherlv_13, grammarAccess.getExtractAccess().getPatternKeyword_12());
            		
            // InternalMyDsl.g:3027:3: ( (lv_pattern_14_0= ruleEString ) )
            // InternalMyDsl.g:3028:4: (lv_pattern_14_0= ruleEString )
            {
            // InternalMyDsl.g:3028:4: (lv_pattern_14_0= ruleEString )
            // InternalMyDsl.g:3029:5: lv_pattern_14_0= ruleEString
            {

            					newCompositeNode(grammarAccess.getExtractAccess().getPatternEStringParserRuleCall_13_0());
            				
            pushFollow(FOLLOW_30);
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

            otherlv_15=(Token)match(input,34,FOLLOW_3); 

            			newLeafNode(otherlv_15, grammarAccess.getExtractAccess().getNextKeyword_14());
            		
            // InternalMyDsl.g:3050:3: ( ( ruleEString ) )
            // InternalMyDsl.g:3051:4: ( ruleEString )
            {
            // InternalMyDsl.g:3051:4: ( ruleEString )
            // InternalMyDsl.g:3052:5: ruleEString
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getExtractRule());
            					}
            				

            					newCompositeNode(grammarAccess.getExtractAccess().getNextStepCrossReference_15_0());
            				
            pushFollow(FOLLOW_12);
            ruleEString();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_17=(Token)match(input,16,FOLLOW_2); 

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
    // InternalMyDsl.g:3074:1: entryRuleTableToSave returns [EObject current=null] : iv_ruleTableToSave= ruleTableToSave EOF ;
    public final EObject entryRuleTableToSave() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTableToSave = null;


        try {
            // InternalMyDsl.g:3074:52: (iv_ruleTableToSave= ruleTableToSave EOF )
            // InternalMyDsl.g:3075:2: iv_ruleTableToSave= ruleTableToSave EOF
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
    // InternalMyDsl.g:3081:1: ruleTableToSave returns [EObject current=null] : (otherlv_0= 'TableToSave' otherlv_1= '{' otherlv_2= 'path' ( (lv_path_3_0= ruleEString ) ) otherlv_4= 'table' ( ( ruleEString ) ) otherlv_6= 'columnsNames' otherlv_7= '{' ( (lv_columnsNames_8_0= ruleEString ) ) (otherlv_9= ',' ( (lv_columnsNames_10_0= ruleEString ) ) )* otherlv_11= '}' otherlv_12= '}' ) ;
    public final EObject ruleTableToSave() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        Token otherlv_7=null;
        Token otherlv_9=null;
        Token otherlv_11=null;
        Token otherlv_12=null;
        AntlrDatatypeRuleToken lv_path_3_0 = null;

        AntlrDatatypeRuleToken lv_columnsNames_8_0 = null;

        AntlrDatatypeRuleToken lv_columnsNames_10_0 = null;



        	enterRule();

        try {
            // InternalMyDsl.g:3087:2: ( (otherlv_0= 'TableToSave' otherlv_1= '{' otherlv_2= 'path' ( (lv_path_3_0= ruleEString ) ) otherlv_4= 'table' ( ( ruleEString ) ) otherlv_6= 'columnsNames' otherlv_7= '{' ( (lv_columnsNames_8_0= ruleEString ) ) (otherlv_9= ',' ( (lv_columnsNames_10_0= ruleEString ) ) )* otherlv_11= '}' otherlv_12= '}' ) )
            // InternalMyDsl.g:3088:2: (otherlv_0= 'TableToSave' otherlv_1= '{' otherlv_2= 'path' ( (lv_path_3_0= ruleEString ) ) otherlv_4= 'table' ( ( ruleEString ) ) otherlv_6= 'columnsNames' otherlv_7= '{' ( (lv_columnsNames_8_0= ruleEString ) ) (otherlv_9= ',' ( (lv_columnsNames_10_0= ruleEString ) ) )* otherlv_11= '}' otherlv_12= '}' )
            {
            // InternalMyDsl.g:3088:2: (otherlv_0= 'TableToSave' otherlv_1= '{' otherlv_2= 'path' ( (lv_path_3_0= ruleEString ) ) otherlv_4= 'table' ( ( ruleEString ) ) otherlv_6= 'columnsNames' otherlv_7= '{' ( (lv_columnsNames_8_0= ruleEString ) ) (otherlv_9= ',' ( (lv_columnsNames_10_0= ruleEString ) ) )* otherlv_11= '}' otherlv_12= '}' )
            // InternalMyDsl.g:3089:3: otherlv_0= 'TableToSave' otherlv_1= '{' otherlv_2= 'path' ( (lv_path_3_0= ruleEString ) ) otherlv_4= 'table' ( ( ruleEString ) ) otherlv_6= 'columnsNames' otherlv_7= '{' ( (lv_columnsNames_8_0= ruleEString ) ) (otherlv_9= ',' ( (lv_columnsNames_10_0= ruleEString ) ) )* otherlv_11= '}' otherlv_12= '}'
            {
            otherlv_0=(Token)match(input,73,FOLLOW_4); 

            			newLeafNode(otherlv_0, grammarAccess.getTableToSaveAccess().getTableToSaveKeyword_0());
            		
            otherlv_1=(Token)match(input,12,FOLLOW_69); 

            			newLeafNode(otherlv_1, grammarAccess.getTableToSaveAccess().getLeftCurlyBracketKeyword_1());
            		
            otherlv_2=(Token)match(input,74,FOLLOW_3); 

            			newLeafNode(otherlv_2, grammarAccess.getTableToSaveAccess().getPathKeyword_2());
            		
            // InternalMyDsl.g:3101:3: ( (lv_path_3_0= ruleEString ) )
            // InternalMyDsl.g:3102:4: (lv_path_3_0= ruleEString )
            {
            // InternalMyDsl.g:3102:4: (lv_path_3_0= ruleEString )
            // InternalMyDsl.g:3103:5: lv_path_3_0= ruleEString
            {

            					newCompositeNode(grammarAccess.getTableToSaveAccess().getPathEStringParserRuleCall_3_0());
            				
            pushFollow(FOLLOW_21);
            lv_path_3_0=ruleEString();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getTableToSaveRule());
            					}
            					set(
            						current,
            						"path",
            						lv_path_3_0,
            						"org.xtext.example.mydsl.MyDsl.EString");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_4=(Token)match(input,26,FOLLOW_3); 

            			newLeafNode(otherlv_4, grammarAccess.getTableToSaveAccess().getTableKeyword_4());
            		
            // InternalMyDsl.g:3124:3: ( ( ruleEString ) )
            // InternalMyDsl.g:3125:4: ( ruleEString )
            {
            // InternalMyDsl.g:3125:4: ( ruleEString )
            // InternalMyDsl.g:3126:5: ruleEString
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getTableToSaveRule());
            					}
            				

            					newCompositeNode(grammarAccess.getTableToSaveAccess().getTableTableCrossReference_5_0());
            				
            pushFollow(FOLLOW_70);
            ruleEString();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_6=(Token)match(input,75,FOLLOW_4); 

            			newLeafNode(otherlv_6, grammarAccess.getTableToSaveAccess().getColumnsNamesKeyword_6());
            		
            otherlv_7=(Token)match(input,12,FOLLOW_3); 

            			newLeafNode(otherlv_7, grammarAccess.getTableToSaveAccess().getLeftCurlyBracketKeyword_7());
            		
            // InternalMyDsl.g:3148:3: ( (lv_columnsNames_8_0= ruleEString ) )
            // InternalMyDsl.g:3149:4: (lv_columnsNames_8_0= ruleEString )
            {
            // InternalMyDsl.g:3149:4: (lv_columnsNames_8_0= ruleEString )
            // InternalMyDsl.g:3150:5: lv_columnsNames_8_0= ruleEString
            {

            					newCompositeNode(grammarAccess.getTableToSaveAccess().getColumnsNamesEStringParserRuleCall_8_0());
            				
            pushFollow(FOLLOW_9);
            lv_columnsNames_8_0=ruleEString();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getTableToSaveRule());
            					}
            					add(
            						current,
            						"columnsNames",
            						lv_columnsNames_8_0,
            						"org.xtext.example.mydsl.MyDsl.EString");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalMyDsl.g:3167:3: (otherlv_9= ',' ( (lv_columnsNames_10_0= ruleEString ) ) )*
            loop24:
            do {
                int alt24=2;
                int LA24_0 = input.LA(1);

                if ( (LA24_0==15) ) {
                    alt24=1;
                }


                switch (alt24) {
            	case 1 :
            	    // InternalMyDsl.g:3168:4: otherlv_9= ',' ( (lv_columnsNames_10_0= ruleEString ) )
            	    {
            	    otherlv_9=(Token)match(input,15,FOLLOW_3); 

            	    				newLeafNode(otherlv_9, grammarAccess.getTableToSaveAccess().getCommaKeyword_9_0());
            	    			
            	    // InternalMyDsl.g:3172:4: ( (lv_columnsNames_10_0= ruleEString ) )
            	    // InternalMyDsl.g:3173:5: (lv_columnsNames_10_0= ruleEString )
            	    {
            	    // InternalMyDsl.g:3173:5: (lv_columnsNames_10_0= ruleEString )
            	    // InternalMyDsl.g:3174:6: lv_columnsNames_10_0= ruleEString
            	    {

            	    						newCompositeNode(grammarAccess.getTableToSaveAccess().getColumnsNamesEStringParserRuleCall_9_1_0());
            	    					
            	    pushFollow(FOLLOW_9);
            	    lv_columnsNames_10_0=ruleEString();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getTableToSaveRule());
            	    						}
            	    						add(
            	    							current,
            	    							"columnsNames",
            	    							lv_columnsNames_10_0,
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

            otherlv_11=(Token)match(input,16,FOLLOW_12); 

            			newLeafNode(otherlv_11, grammarAccess.getTableToSaveAccess().getRightCurlyBracketKeyword_10());
            		
            otherlv_12=(Token)match(input,16,FOLLOW_2); 

            			newLeafNode(otherlv_12, grammarAccess.getTableToSaveAccess().getRightCurlyBracketKeyword_11());
            		

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
    // InternalMyDsl.g:3204:1: entryRuleAssociation returns [EObject current=null] : iv_ruleAssociation= ruleAssociation EOF ;
    public final EObject entryRuleAssociation() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAssociation = null;


        try {
            // InternalMyDsl.g:3204:52: (iv_ruleAssociation= ruleAssociation EOF )
            // InternalMyDsl.g:3205:2: iv_ruleAssociation= ruleAssociation EOF
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
    // InternalMyDsl.g:3211:1: ruleAssociation returns [EObject current=null] : (otherlv_0= 'Association' otherlv_1= '{' otherlv_2= 'originCol' ( ( ruleEString ) ) otherlv_4= 'destinCol' ( ( ruleEString ) ) otherlv_6= '}' ) ;
    public final EObject ruleAssociation() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_6=null;


        	enterRule();

        try {
            // InternalMyDsl.g:3217:2: ( (otherlv_0= 'Association' otherlv_1= '{' otherlv_2= 'originCol' ( ( ruleEString ) ) otherlv_4= 'destinCol' ( ( ruleEString ) ) otherlv_6= '}' ) )
            // InternalMyDsl.g:3218:2: (otherlv_0= 'Association' otherlv_1= '{' otherlv_2= 'originCol' ( ( ruleEString ) ) otherlv_4= 'destinCol' ( ( ruleEString ) ) otherlv_6= '}' )
            {
            // InternalMyDsl.g:3218:2: (otherlv_0= 'Association' otherlv_1= '{' otherlv_2= 'originCol' ( ( ruleEString ) ) otherlv_4= 'destinCol' ( ( ruleEString ) ) otherlv_6= '}' )
            // InternalMyDsl.g:3219:3: otherlv_0= 'Association' otherlv_1= '{' otherlv_2= 'originCol' ( ( ruleEString ) ) otherlv_4= 'destinCol' ( ( ruleEString ) ) otherlv_6= '}'
            {
            otherlv_0=(Token)match(input,76,FOLLOW_4); 

            			newLeafNode(otherlv_0, grammarAccess.getAssociationAccess().getAssociationKeyword_0());
            		
            otherlv_1=(Token)match(input,12,FOLLOW_71); 

            			newLeafNode(otherlv_1, grammarAccess.getAssociationAccess().getLeftCurlyBracketKeyword_1());
            		
            otherlv_2=(Token)match(input,77,FOLLOW_3); 

            			newLeafNode(otherlv_2, grammarAccess.getAssociationAccess().getOriginColKeyword_2());
            		
            // InternalMyDsl.g:3231:3: ( ( ruleEString ) )
            // InternalMyDsl.g:3232:4: ( ruleEString )
            {
            // InternalMyDsl.g:3232:4: ( ruleEString )
            // InternalMyDsl.g:3233:5: ruleEString
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getAssociationRule());
            					}
            				

            					newCompositeNode(grammarAccess.getAssociationAccess().getOriginColColumnCrossReference_3_0());
            				
            pushFollow(FOLLOW_72);
            ruleEString();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_4=(Token)match(input,78,FOLLOW_3); 

            			newLeafNode(otherlv_4, grammarAccess.getAssociationAccess().getDestinColKeyword_4());
            		
            // InternalMyDsl.g:3251:3: ( ( ruleEString ) )
            // InternalMyDsl.g:3252:4: ( ruleEString )
            {
            // InternalMyDsl.g:3252:4: ( ruleEString )
            // InternalMyDsl.g:3253:5: ruleEString
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getAssociationRule());
            					}
            				

            					newCompositeNode(grammarAccess.getAssociationAccess().getDestinColColumnCrossReference_5_0());
            				
            pushFollow(FOLLOW_12);
            ruleEString();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_6=(Token)match(input,16,FOLLOW_2); 

            			newLeafNode(otherlv_6, grammarAccess.getAssociationAccess().getRightCurlyBracketKeyword_6());
            		

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
    // InternalMyDsl.g:3275:1: entryRuleTableToImport returns [EObject current=null] : iv_ruleTableToImport= ruleTableToImport EOF ;
    public final EObject entryRuleTableToImport() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTableToImport = null;


        try {
            // InternalMyDsl.g:3275:54: (iv_ruleTableToImport= ruleTableToImport EOF )
            // InternalMyDsl.g:3276:2: iv_ruleTableToImport= ruleTableToImport EOF
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
    // InternalMyDsl.g:3282:1: ruleTableToImport returns [EObject current=null] : (otherlv_0= 'deleteMismatchedTypes' ( (lv_deleteMismatchedTypes_1_0= ruleEBooleanObject ) ) otherlv_2= 'TableToImport' otherlv_3= '{' otherlv_4= 'path' ( (lv_path_5_0= ruleEString ) ) otherlv_6= 'delimiter' ( (lv_delimiter_7_0= ruleEString ) ) otherlv_8= 'table' ( ( ruleEString ) ) otherlv_10= '}' ) ;
    public final EObject ruleTableToImport() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        Token otherlv_8=null;
        Token otherlv_10=null;
        AntlrDatatypeRuleToken lv_deleteMismatchedTypes_1_0 = null;

        AntlrDatatypeRuleToken lv_path_5_0 = null;

        AntlrDatatypeRuleToken lv_delimiter_7_0 = null;



        	enterRule();

        try {
            // InternalMyDsl.g:3288:2: ( (otherlv_0= 'deleteMismatchedTypes' ( (lv_deleteMismatchedTypes_1_0= ruleEBooleanObject ) ) otherlv_2= 'TableToImport' otherlv_3= '{' otherlv_4= 'path' ( (lv_path_5_0= ruleEString ) ) otherlv_6= 'delimiter' ( (lv_delimiter_7_0= ruleEString ) ) otherlv_8= 'table' ( ( ruleEString ) ) otherlv_10= '}' ) )
            // InternalMyDsl.g:3289:2: (otherlv_0= 'deleteMismatchedTypes' ( (lv_deleteMismatchedTypes_1_0= ruleEBooleanObject ) ) otherlv_2= 'TableToImport' otherlv_3= '{' otherlv_4= 'path' ( (lv_path_5_0= ruleEString ) ) otherlv_6= 'delimiter' ( (lv_delimiter_7_0= ruleEString ) ) otherlv_8= 'table' ( ( ruleEString ) ) otherlv_10= '}' )
            {
            // InternalMyDsl.g:3289:2: (otherlv_0= 'deleteMismatchedTypes' ( (lv_deleteMismatchedTypes_1_0= ruleEBooleanObject ) ) otherlv_2= 'TableToImport' otherlv_3= '{' otherlv_4= 'path' ( (lv_path_5_0= ruleEString ) ) otherlv_6= 'delimiter' ( (lv_delimiter_7_0= ruleEString ) ) otherlv_8= 'table' ( ( ruleEString ) ) otherlv_10= '}' )
            // InternalMyDsl.g:3290:3: otherlv_0= 'deleteMismatchedTypes' ( (lv_deleteMismatchedTypes_1_0= ruleEBooleanObject ) ) otherlv_2= 'TableToImport' otherlv_3= '{' otherlv_4= 'path' ( (lv_path_5_0= ruleEString ) ) otherlv_6= 'delimiter' ( (lv_delimiter_7_0= ruleEString ) ) otherlv_8= 'table' ( ( ruleEString ) ) otherlv_10= '}'
            {
            otherlv_0=(Token)match(input,79,FOLLOW_6); 

            			newLeafNode(otherlv_0, grammarAccess.getTableToImportAccess().getDeleteMismatchedTypesKeyword_0());
            		
            // InternalMyDsl.g:3294:3: ( (lv_deleteMismatchedTypes_1_0= ruleEBooleanObject ) )
            // InternalMyDsl.g:3295:4: (lv_deleteMismatchedTypes_1_0= ruleEBooleanObject )
            {
            // InternalMyDsl.g:3295:4: (lv_deleteMismatchedTypes_1_0= ruleEBooleanObject )
            // InternalMyDsl.g:3296:5: lv_deleteMismatchedTypes_1_0= ruleEBooleanObject
            {

            					newCompositeNode(grammarAccess.getTableToImportAccess().getDeleteMismatchedTypesEBooleanObjectParserRuleCall_1_0());
            				
            pushFollow(FOLLOW_73);
            lv_deleteMismatchedTypes_1_0=ruleEBooleanObject();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getTableToImportRule());
            					}
            					set(
            						current,
            						"deleteMismatchedTypes",
            						lv_deleteMismatchedTypes_1_0,
            						"org.xtext.example.mydsl.MyDsl.EBooleanObject");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_2=(Token)match(input,80,FOLLOW_4); 

            			newLeafNode(otherlv_2, grammarAccess.getTableToImportAccess().getTableToImportKeyword_2());
            		
            otherlv_3=(Token)match(input,12,FOLLOW_69); 

            			newLeafNode(otherlv_3, grammarAccess.getTableToImportAccess().getLeftCurlyBracketKeyword_3());
            		
            otherlv_4=(Token)match(input,74,FOLLOW_3); 

            			newLeafNode(otherlv_4, grammarAccess.getTableToImportAccess().getPathKeyword_4());
            		
            // InternalMyDsl.g:3325:3: ( (lv_path_5_0= ruleEString ) )
            // InternalMyDsl.g:3326:4: (lv_path_5_0= ruleEString )
            {
            // InternalMyDsl.g:3326:4: (lv_path_5_0= ruleEString )
            // InternalMyDsl.g:3327:5: lv_path_5_0= ruleEString
            {

            					newCompositeNode(grammarAccess.getTableToImportAccess().getPathEStringParserRuleCall_5_0());
            				
            pushFollow(FOLLOW_61);
            lv_path_5_0=ruleEString();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getTableToImportRule());
            					}
            					set(
            						current,
            						"path",
            						lv_path_5_0,
            						"org.xtext.example.mydsl.MyDsl.EString");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_6=(Token)match(input,65,FOLLOW_3); 

            			newLeafNode(otherlv_6, grammarAccess.getTableToImportAccess().getDelimiterKeyword_6());
            		
            // InternalMyDsl.g:3348:3: ( (lv_delimiter_7_0= ruleEString ) )
            // InternalMyDsl.g:3349:4: (lv_delimiter_7_0= ruleEString )
            {
            // InternalMyDsl.g:3349:4: (lv_delimiter_7_0= ruleEString )
            // InternalMyDsl.g:3350:5: lv_delimiter_7_0= ruleEString
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

            otherlv_8=(Token)match(input,26,FOLLOW_3); 

            			newLeafNode(otherlv_8, grammarAccess.getTableToImportAccess().getTableKeyword_8());
            		
            // InternalMyDsl.g:3371:3: ( ( ruleEString ) )
            // InternalMyDsl.g:3372:4: ( ruleEString )
            {
            // InternalMyDsl.g:3372:4: ( ruleEString )
            // InternalMyDsl.g:3373:5: ruleEString
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getTableToImportRule());
            					}
            				

            					newCompositeNode(grammarAccess.getTableToImportAccess().getTableTableCrossReference_9_0());
            				
            pushFollow(FOLLOW_12);
            ruleEString();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_10=(Token)match(input,16,FOLLOW_2); 

            			newLeafNode(otherlv_10, grammarAccess.getTableToImportAccess().getRightCurlyBracketKeyword_10());
            		

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
    // InternalMyDsl.g:3395:1: entryRuleEIntegerObject returns [String current=null] : iv_ruleEIntegerObject= ruleEIntegerObject EOF ;
    public final String entryRuleEIntegerObject() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleEIntegerObject = null;


        try {
            // InternalMyDsl.g:3395:54: (iv_ruleEIntegerObject= ruleEIntegerObject EOF )
            // InternalMyDsl.g:3396:2: iv_ruleEIntegerObject= ruleEIntegerObject EOF
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
    // InternalMyDsl.g:3402:1: ruleEIntegerObject returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : ( (kw= '-' )? this_INT_1= RULE_INT ) ;
    public final AntlrDatatypeRuleToken ruleEIntegerObject() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        Token this_INT_1=null;


        	enterRule();

        try {
            // InternalMyDsl.g:3408:2: ( ( (kw= '-' )? this_INT_1= RULE_INT ) )
            // InternalMyDsl.g:3409:2: ( (kw= '-' )? this_INT_1= RULE_INT )
            {
            // InternalMyDsl.g:3409:2: ( (kw= '-' )? this_INT_1= RULE_INT )
            // InternalMyDsl.g:3410:3: (kw= '-' )? this_INT_1= RULE_INT
            {
            // InternalMyDsl.g:3410:3: (kw= '-' )?
            int alt25=2;
            int LA25_0 = input.LA(1);

            if ( (LA25_0==81) ) {
                alt25=1;
            }
            switch (alt25) {
                case 1 :
                    // InternalMyDsl.g:3411:4: kw= '-'
                    {
                    kw=(Token)match(input,81,FOLLOW_74); 

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
    // InternalMyDsl.g:3428:1: entryRuleEBooleanObject returns [String current=null] : iv_ruleEBooleanObject= ruleEBooleanObject EOF ;
    public final String entryRuleEBooleanObject() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleEBooleanObject = null;


        try {
            // InternalMyDsl.g:3428:54: (iv_ruleEBooleanObject= ruleEBooleanObject EOF )
            // InternalMyDsl.g:3429:2: iv_ruleEBooleanObject= ruleEBooleanObject EOF
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
    // InternalMyDsl.g:3435:1: ruleEBooleanObject returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= 'true' | kw= 'false' ) ;
    public final AntlrDatatypeRuleToken ruleEBooleanObject() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;


        	enterRule();

        try {
            // InternalMyDsl.g:3441:2: ( (kw= 'true' | kw= 'false' ) )
            // InternalMyDsl.g:3442:2: (kw= 'true' | kw= 'false' )
            {
            // InternalMyDsl.g:3442:2: (kw= 'true' | kw= 'false' )
            int alt26=2;
            int LA26_0 = input.LA(1);

            if ( (LA26_0==82) ) {
                alt26=1;
            }
            else if ( (LA26_0==83) ) {
                alt26=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 26, 0, input);

                throw nvae;
            }
            switch (alt26) {
                case 1 :
                    // InternalMyDsl.g:3443:3: kw= 'true'
                    {
                    kw=(Token)match(input,82,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getEBooleanObjectAccess().getTrueKeyword_0());
                    		

                    }
                    break;
                case 2 :
                    // InternalMyDsl.g:3449:3: kw= 'false'
                    {
                    kw=(Token)match(input,83,FOLLOW_2); 

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
    // InternalMyDsl.g:3458:1: ruleDataType returns [Enumerator current=null] : ( (enumLiteral_0= 'TEXT' ) | (enumLiteral_1= 'NUMBER' ) | (enumLiteral_2= 'DATE' ) ) ;
    public final Enumerator ruleDataType() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;


        	enterRule();

        try {
            // InternalMyDsl.g:3464:2: ( ( (enumLiteral_0= 'TEXT' ) | (enumLiteral_1= 'NUMBER' ) | (enumLiteral_2= 'DATE' ) ) )
            // InternalMyDsl.g:3465:2: ( (enumLiteral_0= 'TEXT' ) | (enumLiteral_1= 'NUMBER' ) | (enumLiteral_2= 'DATE' ) )
            {
            // InternalMyDsl.g:3465:2: ( (enumLiteral_0= 'TEXT' ) | (enumLiteral_1= 'NUMBER' ) | (enumLiteral_2= 'DATE' ) )
            int alt27=3;
            switch ( input.LA(1) ) {
            case 84:
                {
                alt27=1;
                }
                break;
            case 85:
                {
                alt27=2;
                }
                break;
            case 86:
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
                    // InternalMyDsl.g:3466:3: (enumLiteral_0= 'TEXT' )
                    {
                    // InternalMyDsl.g:3466:3: (enumLiteral_0= 'TEXT' )
                    // InternalMyDsl.g:3467:4: enumLiteral_0= 'TEXT'
                    {
                    enumLiteral_0=(Token)match(input,84,FOLLOW_2); 

                    				current = grammarAccess.getDataTypeAccess().getTEXTEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_0, grammarAccess.getDataTypeAccess().getTEXTEnumLiteralDeclaration_0());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalMyDsl.g:3474:3: (enumLiteral_1= 'NUMBER' )
                    {
                    // InternalMyDsl.g:3474:3: (enumLiteral_1= 'NUMBER' )
                    // InternalMyDsl.g:3475:4: enumLiteral_1= 'NUMBER'
                    {
                    enumLiteral_1=(Token)match(input,85,FOLLOW_2); 

                    				current = grammarAccess.getDataTypeAccess().getNUMBEREnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_1, grammarAccess.getDataTypeAccess().getNUMBEREnumLiteralDeclaration_1());
                    			

                    }


                    }
                    break;
                case 3 :
                    // InternalMyDsl.g:3482:3: (enumLiteral_2= 'DATE' )
                    {
                    // InternalMyDsl.g:3482:3: (enumLiteral_2= 'DATE' )
                    // InternalMyDsl.g:3483:4: enumLiteral_2= 'DATE'
                    {
                    enumLiteral_2=(Token)match(input,86,FOLLOW_2); 

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
    // InternalMyDsl.g:3493:1: ruleGroupOperationType returns [Enumerator current=null] : ( (enumLiteral_0= 'MAX' ) | (enumLiteral_1= 'MIN' ) | (enumLiteral_2= 'COUNT' ) | (enumLiteral_3= 'SUM' ) | (enumLiteral_4= 'AVERAGE' ) ) ;
    public final Enumerator ruleGroupOperationType() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;
        Token enumLiteral_3=null;
        Token enumLiteral_4=null;


        	enterRule();

        try {
            // InternalMyDsl.g:3499:2: ( ( (enumLiteral_0= 'MAX' ) | (enumLiteral_1= 'MIN' ) | (enumLiteral_2= 'COUNT' ) | (enumLiteral_3= 'SUM' ) | (enumLiteral_4= 'AVERAGE' ) ) )
            // InternalMyDsl.g:3500:2: ( (enumLiteral_0= 'MAX' ) | (enumLiteral_1= 'MIN' ) | (enumLiteral_2= 'COUNT' ) | (enumLiteral_3= 'SUM' ) | (enumLiteral_4= 'AVERAGE' ) )
            {
            // InternalMyDsl.g:3500:2: ( (enumLiteral_0= 'MAX' ) | (enumLiteral_1= 'MIN' ) | (enumLiteral_2= 'COUNT' ) | (enumLiteral_3= 'SUM' ) | (enumLiteral_4= 'AVERAGE' ) )
            int alt28=5;
            switch ( input.LA(1) ) {
            case 87:
                {
                alt28=1;
                }
                break;
            case 88:
                {
                alt28=2;
                }
                break;
            case 89:
                {
                alt28=3;
                }
                break;
            case 90:
                {
                alt28=4;
                }
                break;
            case 91:
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
                    // InternalMyDsl.g:3501:3: (enumLiteral_0= 'MAX' )
                    {
                    // InternalMyDsl.g:3501:3: (enumLiteral_0= 'MAX' )
                    // InternalMyDsl.g:3502:4: enumLiteral_0= 'MAX'
                    {
                    enumLiteral_0=(Token)match(input,87,FOLLOW_2); 

                    				current = grammarAccess.getGroupOperationTypeAccess().getMAXEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_0, grammarAccess.getGroupOperationTypeAccess().getMAXEnumLiteralDeclaration_0());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalMyDsl.g:3509:3: (enumLiteral_1= 'MIN' )
                    {
                    // InternalMyDsl.g:3509:3: (enumLiteral_1= 'MIN' )
                    // InternalMyDsl.g:3510:4: enumLiteral_1= 'MIN'
                    {
                    enumLiteral_1=(Token)match(input,88,FOLLOW_2); 

                    				current = grammarAccess.getGroupOperationTypeAccess().getMINEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_1, grammarAccess.getGroupOperationTypeAccess().getMINEnumLiteralDeclaration_1());
                    			

                    }


                    }
                    break;
                case 3 :
                    // InternalMyDsl.g:3517:3: (enumLiteral_2= 'COUNT' )
                    {
                    // InternalMyDsl.g:3517:3: (enumLiteral_2= 'COUNT' )
                    // InternalMyDsl.g:3518:4: enumLiteral_2= 'COUNT'
                    {
                    enumLiteral_2=(Token)match(input,89,FOLLOW_2); 

                    				current = grammarAccess.getGroupOperationTypeAccess().getCOUNTEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_2, grammarAccess.getGroupOperationTypeAccess().getCOUNTEnumLiteralDeclaration_2());
                    			

                    }


                    }
                    break;
                case 4 :
                    // InternalMyDsl.g:3525:3: (enumLiteral_3= 'SUM' )
                    {
                    // InternalMyDsl.g:3525:3: (enumLiteral_3= 'SUM' )
                    // InternalMyDsl.g:3526:4: enumLiteral_3= 'SUM'
                    {
                    enumLiteral_3=(Token)match(input,90,FOLLOW_2); 

                    				current = grammarAccess.getGroupOperationTypeAccess().getSUMEnumLiteralDeclaration_3().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_3, grammarAccess.getGroupOperationTypeAccess().getSUMEnumLiteralDeclaration_3());
                    			

                    }


                    }
                    break;
                case 5 :
                    // InternalMyDsl.g:3533:3: (enumLiteral_4= 'AVERAGE' )
                    {
                    // InternalMyDsl.g:3533:3: (enumLiteral_4= 'AVERAGE' )
                    // InternalMyDsl.g:3534:4: enumLiteral_4= 'AVERAGE'
                    {
                    enumLiteral_4=(Token)match(input,91,FOLLOW_2); 

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
    // InternalMyDsl.g:3544:1: ruleOrderType returns [Enumerator current=null] : ( (enumLiteral_0= 'ASC' ) | (enumLiteral_1= 'DESC' ) ) ;
    public final Enumerator ruleOrderType() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;


        	enterRule();

        try {
            // InternalMyDsl.g:3550:2: ( ( (enumLiteral_0= 'ASC' ) | (enumLiteral_1= 'DESC' ) ) )
            // InternalMyDsl.g:3551:2: ( (enumLiteral_0= 'ASC' ) | (enumLiteral_1= 'DESC' ) )
            {
            // InternalMyDsl.g:3551:2: ( (enumLiteral_0= 'ASC' ) | (enumLiteral_1= 'DESC' ) )
            int alt29=2;
            int LA29_0 = input.LA(1);

            if ( (LA29_0==92) ) {
                alt29=1;
            }
            else if ( (LA29_0==93) ) {
                alt29=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 29, 0, input);

                throw nvae;
            }
            switch (alt29) {
                case 1 :
                    // InternalMyDsl.g:3552:3: (enumLiteral_0= 'ASC' )
                    {
                    // InternalMyDsl.g:3552:3: (enumLiteral_0= 'ASC' )
                    // InternalMyDsl.g:3553:4: enumLiteral_0= 'ASC'
                    {
                    enumLiteral_0=(Token)match(input,92,FOLLOW_2); 

                    				current = grammarAccess.getOrderTypeAccess().getASCEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_0, grammarAccess.getOrderTypeAccess().getASCEnumLiteralDeclaration_0());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalMyDsl.g:3560:3: (enumLiteral_1= 'DESC' )
                    {
                    // InternalMyDsl.g:3560:3: (enumLiteral_1= 'DESC' )
                    // InternalMyDsl.g:3561:4: enumLiteral_1= 'DESC'
                    {
                    enumLiteral_1=(Token)match(input,93,FOLLOW_2); 

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
    // InternalMyDsl.g:3571:1: ruleFilterOperatorType returns [Enumerator current=null] : ( (enumLiteral_0= 'EQUALS' ) | (enumLiteral_1= 'LESS_THAN' ) | (enumLiteral_2= 'GREATER_THAN' ) | (enumLiteral_3= 'LESS_OR_EQUALS_THAN' ) | (enumLiteral_4= 'GREATER_OR_EQUALS_THAN' ) ) ;
    public final Enumerator ruleFilterOperatorType() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;
        Token enumLiteral_3=null;
        Token enumLiteral_4=null;


        	enterRule();

        try {
            // InternalMyDsl.g:3577:2: ( ( (enumLiteral_0= 'EQUALS' ) | (enumLiteral_1= 'LESS_THAN' ) | (enumLiteral_2= 'GREATER_THAN' ) | (enumLiteral_3= 'LESS_OR_EQUALS_THAN' ) | (enumLiteral_4= 'GREATER_OR_EQUALS_THAN' ) ) )
            // InternalMyDsl.g:3578:2: ( (enumLiteral_0= 'EQUALS' ) | (enumLiteral_1= 'LESS_THAN' ) | (enumLiteral_2= 'GREATER_THAN' ) | (enumLiteral_3= 'LESS_OR_EQUALS_THAN' ) | (enumLiteral_4= 'GREATER_OR_EQUALS_THAN' ) )
            {
            // InternalMyDsl.g:3578:2: ( (enumLiteral_0= 'EQUALS' ) | (enumLiteral_1= 'LESS_THAN' ) | (enumLiteral_2= 'GREATER_THAN' ) | (enumLiteral_3= 'LESS_OR_EQUALS_THAN' ) | (enumLiteral_4= 'GREATER_OR_EQUALS_THAN' ) )
            int alt30=5;
            switch ( input.LA(1) ) {
            case 94:
                {
                alt30=1;
                }
                break;
            case 95:
                {
                alt30=2;
                }
                break;
            case 96:
                {
                alt30=3;
                }
                break;
            case 97:
                {
                alt30=4;
                }
                break;
            case 98:
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
                    // InternalMyDsl.g:3579:3: (enumLiteral_0= 'EQUALS' )
                    {
                    // InternalMyDsl.g:3579:3: (enumLiteral_0= 'EQUALS' )
                    // InternalMyDsl.g:3580:4: enumLiteral_0= 'EQUALS'
                    {
                    enumLiteral_0=(Token)match(input,94,FOLLOW_2); 

                    				current = grammarAccess.getFilterOperatorTypeAccess().getEQUALSEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_0, grammarAccess.getFilterOperatorTypeAccess().getEQUALSEnumLiteralDeclaration_0());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalMyDsl.g:3587:3: (enumLiteral_1= 'LESS_THAN' )
                    {
                    // InternalMyDsl.g:3587:3: (enumLiteral_1= 'LESS_THAN' )
                    // InternalMyDsl.g:3588:4: enumLiteral_1= 'LESS_THAN'
                    {
                    enumLiteral_1=(Token)match(input,95,FOLLOW_2); 

                    				current = grammarAccess.getFilterOperatorTypeAccess().getLESS_THANEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_1, grammarAccess.getFilterOperatorTypeAccess().getLESS_THANEnumLiteralDeclaration_1());
                    			

                    }


                    }
                    break;
                case 3 :
                    // InternalMyDsl.g:3595:3: (enumLiteral_2= 'GREATER_THAN' )
                    {
                    // InternalMyDsl.g:3595:3: (enumLiteral_2= 'GREATER_THAN' )
                    // InternalMyDsl.g:3596:4: enumLiteral_2= 'GREATER_THAN'
                    {
                    enumLiteral_2=(Token)match(input,96,FOLLOW_2); 

                    				current = grammarAccess.getFilterOperatorTypeAccess().getGREATER_THANEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_2, grammarAccess.getFilterOperatorTypeAccess().getGREATER_THANEnumLiteralDeclaration_2());
                    			

                    }


                    }
                    break;
                case 4 :
                    // InternalMyDsl.g:3603:3: (enumLiteral_3= 'LESS_OR_EQUALS_THAN' )
                    {
                    // InternalMyDsl.g:3603:3: (enumLiteral_3= 'LESS_OR_EQUALS_THAN' )
                    // InternalMyDsl.g:3604:4: enumLiteral_3= 'LESS_OR_EQUALS_THAN'
                    {
                    enumLiteral_3=(Token)match(input,97,FOLLOW_2); 

                    				current = grammarAccess.getFilterOperatorTypeAccess().getLESS_OR_EQUALS_THANEnumLiteralDeclaration_3().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_3, grammarAccess.getFilterOperatorTypeAccess().getLESS_OR_EQUALS_THANEnumLiteralDeclaration_3());
                    			

                    }


                    }
                    break;
                case 5 :
                    // InternalMyDsl.g:3611:3: (enumLiteral_4= 'GREATER_OR_EQUALS_THAN' )
                    {
                    // InternalMyDsl.g:3611:3: (enumLiteral_4= 'GREATER_OR_EQUALS_THAN' )
                    // InternalMyDsl.g:3612:4: enumLiteral_4= 'GREATER_OR_EQUALS_THAN'
                    {
                    enumLiteral_4=(Token)match(input,98,FOLLOW_2); 

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
    // InternalMyDsl.g:3622:1: ruleJoinType returns [Enumerator current=null] : ( (enumLiteral_0= 'INNER' ) | (enumLiteral_1= 'OUTER' ) | (enumLiteral_2= 'LEFT' ) | (enumLiteral_3= 'RIGHT' ) ) ;
    public final Enumerator ruleJoinType() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;
        Token enumLiteral_3=null;


        	enterRule();

        try {
            // InternalMyDsl.g:3628:2: ( ( (enumLiteral_0= 'INNER' ) | (enumLiteral_1= 'OUTER' ) | (enumLiteral_2= 'LEFT' ) | (enumLiteral_3= 'RIGHT' ) ) )
            // InternalMyDsl.g:3629:2: ( (enumLiteral_0= 'INNER' ) | (enumLiteral_1= 'OUTER' ) | (enumLiteral_2= 'LEFT' ) | (enumLiteral_3= 'RIGHT' ) )
            {
            // InternalMyDsl.g:3629:2: ( (enumLiteral_0= 'INNER' ) | (enumLiteral_1= 'OUTER' ) | (enumLiteral_2= 'LEFT' ) | (enumLiteral_3= 'RIGHT' ) )
            int alt31=4;
            switch ( input.LA(1) ) {
            case 99:
                {
                alt31=1;
                }
                break;
            case 100:
                {
                alt31=2;
                }
                break;
            case 101:
                {
                alt31=3;
                }
                break;
            case 102:
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
                    // InternalMyDsl.g:3630:3: (enumLiteral_0= 'INNER' )
                    {
                    // InternalMyDsl.g:3630:3: (enumLiteral_0= 'INNER' )
                    // InternalMyDsl.g:3631:4: enumLiteral_0= 'INNER'
                    {
                    enumLiteral_0=(Token)match(input,99,FOLLOW_2); 

                    				current = grammarAccess.getJoinTypeAccess().getINNEREnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_0, grammarAccess.getJoinTypeAccess().getINNEREnumLiteralDeclaration_0());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalMyDsl.g:3638:3: (enumLiteral_1= 'OUTER' )
                    {
                    // InternalMyDsl.g:3638:3: (enumLiteral_1= 'OUTER' )
                    // InternalMyDsl.g:3639:4: enumLiteral_1= 'OUTER'
                    {
                    enumLiteral_1=(Token)match(input,100,FOLLOW_2); 

                    				current = grammarAccess.getJoinTypeAccess().getOUTEREnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_1, grammarAccess.getJoinTypeAccess().getOUTEREnumLiteralDeclaration_1());
                    			

                    }


                    }
                    break;
                case 3 :
                    // InternalMyDsl.g:3646:3: (enumLiteral_2= 'LEFT' )
                    {
                    // InternalMyDsl.g:3646:3: (enumLiteral_2= 'LEFT' )
                    // InternalMyDsl.g:3647:4: enumLiteral_2= 'LEFT'
                    {
                    enumLiteral_2=(Token)match(input,101,FOLLOW_2); 

                    				current = grammarAccess.getJoinTypeAccess().getLEFTEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_2, grammarAccess.getJoinTypeAccess().getLEFTEnumLiteralDeclaration_2());
                    			

                    }


                    }
                    break;
                case 4 :
                    // InternalMyDsl.g:3654:3: (enumLiteral_3= 'RIGHT' )
                    {
                    // InternalMyDsl.g:3654:3: (enumLiteral_3= 'RIGHT' )
                    // InternalMyDsl.g:3655:4: enumLiteral_3= 'RIGHT'
                    {
                    enumLiteral_3=(Token)match(input,102,FOLLOW_2); 

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
    // InternalMyDsl.g:3665:1: ruleLookupOperationType returns [Enumerator current=null] : ( (enumLiteral_0= 'NUMERIC_SUM' ) | (enumLiteral_1= 'NUMERIC_SUBTRACT' ) | (enumLiteral_2= 'NUMERIC_MULTIPLY' ) | (enumLiteral_3= 'NUMERIC_DIVIDE' ) | (enumLiteral_4= 'TEXT_CONCAT' ) ) ;
    public final Enumerator ruleLookupOperationType() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;
        Token enumLiteral_3=null;
        Token enumLiteral_4=null;


        	enterRule();

        try {
            // InternalMyDsl.g:3671:2: ( ( (enumLiteral_0= 'NUMERIC_SUM' ) | (enumLiteral_1= 'NUMERIC_SUBTRACT' ) | (enumLiteral_2= 'NUMERIC_MULTIPLY' ) | (enumLiteral_3= 'NUMERIC_DIVIDE' ) | (enumLiteral_4= 'TEXT_CONCAT' ) ) )
            // InternalMyDsl.g:3672:2: ( (enumLiteral_0= 'NUMERIC_SUM' ) | (enumLiteral_1= 'NUMERIC_SUBTRACT' ) | (enumLiteral_2= 'NUMERIC_MULTIPLY' ) | (enumLiteral_3= 'NUMERIC_DIVIDE' ) | (enumLiteral_4= 'TEXT_CONCAT' ) )
            {
            // InternalMyDsl.g:3672:2: ( (enumLiteral_0= 'NUMERIC_SUM' ) | (enumLiteral_1= 'NUMERIC_SUBTRACT' ) | (enumLiteral_2= 'NUMERIC_MULTIPLY' ) | (enumLiteral_3= 'NUMERIC_DIVIDE' ) | (enumLiteral_4= 'TEXT_CONCAT' ) )
            int alt32=5;
            switch ( input.LA(1) ) {
            case 103:
                {
                alt32=1;
                }
                break;
            case 104:
                {
                alt32=2;
                }
                break;
            case 105:
                {
                alt32=3;
                }
                break;
            case 106:
                {
                alt32=4;
                }
                break;
            case 107:
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
                    // InternalMyDsl.g:3673:3: (enumLiteral_0= 'NUMERIC_SUM' )
                    {
                    // InternalMyDsl.g:3673:3: (enumLiteral_0= 'NUMERIC_SUM' )
                    // InternalMyDsl.g:3674:4: enumLiteral_0= 'NUMERIC_SUM'
                    {
                    enumLiteral_0=(Token)match(input,103,FOLLOW_2); 

                    				current = grammarAccess.getLookupOperationTypeAccess().getNUMERIC_SUMEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_0, grammarAccess.getLookupOperationTypeAccess().getNUMERIC_SUMEnumLiteralDeclaration_0());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalMyDsl.g:3681:3: (enumLiteral_1= 'NUMERIC_SUBTRACT' )
                    {
                    // InternalMyDsl.g:3681:3: (enumLiteral_1= 'NUMERIC_SUBTRACT' )
                    // InternalMyDsl.g:3682:4: enumLiteral_1= 'NUMERIC_SUBTRACT'
                    {
                    enumLiteral_1=(Token)match(input,104,FOLLOW_2); 

                    				current = grammarAccess.getLookupOperationTypeAccess().getNUMERIC_SUBTRACTEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_1, grammarAccess.getLookupOperationTypeAccess().getNUMERIC_SUBTRACTEnumLiteralDeclaration_1());
                    			

                    }


                    }
                    break;
                case 3 :
                    // InternalMyDsl.g:3689:3: (enumLiteral_2= 'NUMERIC_MULTIPLY' )
                    {
                    // InternalMyDsl.g:3689:3: (enumLiteral_2= 'NUMERIC_MULTIPLY' )
                    // InternalMyDsl.g:3690:4: enumLiteral_2= 'NUMERIC_MULTIPLY'
                    {
                    enumLiteral_2=(Token)match(input,105,FOLLOW_2); 

                    				current = grammarAccess.getLookupOperationTypeAccess().getNUMERIC_MULTIPLYEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_2, grammarAccess.getLookupOperationTypeAccess().getNUMERIC_MULTIPLYEnumLiteralDeclaration_2());
                    			

                    }


                    }
                    break;
                case 4 :
                    // InternalMyDsl.g:3697:3: (enumLiteral_3= 'NUMERIC_DIVIDE' )
                    {
                    // InternalMyDsl.g:3697:3: (enumLiteral_3= 'NUMERIC_DIVIDE' )
                    // InternalMyDsl.g:3698:4: enumLiteral_3= 'NUMERIC_DIVIDE'
                    {
                    enumLiteral_3=(Token)match(input,106,FOLLOW_2); 

                    				current = grammarAccess.getLookupOperationTypeAccess().getNUMERIC_DIVIDEEnumLiteralDeclaration_3().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_3, grammarAccess.getLookupOperationTypeAccess().getNUMERIC_DIVIDEEnumLiteralDeclaration_3());
                    			

                    }


                    }
                    break;
                case 5 :
                    // InternalMyDsl.g:3705:3: (enumLiteral_4= 'TEXT_CONCAT' )
                    {
                    // InternalMyDsl.g:3705:3: (enumLiteral_4= 'TEXT_CONCAT' )
                    // InternalMyDsl.g:3706:4: enumLiteral_4= 'TEXT_CONCAT'
                    {
                    enumLiteral_4=(Token)match(input,107,FOLLOW_2); 

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
    public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000000000030L});
    public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0000000000000000L,0x00000000000C0000L});
    public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x0000000000018000L});
    public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x98A0644802400000L,0x0000000000000020L});
    public static final BitSet FOLLOW_12 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_13 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_14 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_15 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_16 = new BitSet(new long[]{0x0000000000000000L,0x0000000000700000L});
    public static final BitSet FOLLOW_17 = new BitSet(new long[]{0x0000000001800000L});
    public static final BitSet FOLLOW_18 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_19 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000200L});
    public static final BitSet FOLLOW_20 = new BitSet(new long[]{0x0000000004800000L});
    public static final BitSet FOLLOW_21 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_22 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_23 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_24 = new BitSet(new long[]{0x0000000020008000L});
    public static final BitSet FOLLOW_25 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_26 = new BitSet(new long[]{0x0000000000000000L,0x000000000F800000L});
    public static final BitSet FOLLOW_27 = new BitSet(new long[]{0x0000000080000000L});
    public static final BitSet FOLLOW_28 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_29 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_30 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_31 = new BitSet(new long[]{0x0000001000000000L});
    public static final BitSet FOLLOW_32 = new BitSet(new long[]{0x0000002000000000L});
    public static final BitSet FOLLOW_33 = new BitSet(new long[]{0x0000000000000000L,0x0000000030000000L});
    public static final BitSet FOLLOW_34 = new BitSet(new long[]{0x0000008000800000L});
    public static final BitSet FOLLOW_35 = new BitSet(new long[]{0x0000008000000000L});
    public static final BitSet FOLLOW_36 = new BitSet(new long[]{0x0000010000000000L});
    public static final BitSet FOLLOW_37 = new BitSet(new long[]{0x0000020000000000L});
    public static final BitSet FOLLOW_38 = new BitSet(new long[]{0x0000000000000000L,0x0000000000001000L});
    public static final BitSet FOLLOW_39 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_40 = new BitSet(new long[]{0x0000000000000000L,0x00000007C0000000L});
    public static final BitSet FOLLOW_41 = new BitSet(new long[]{0x0000100000000000L});
    public static final BitSet FOLLOW_42 = new BitSet(new long[]{0x0000000400800000L});
    public static final BitSet FOLLOW_43 = new BitSet(new long[]{0x0000800000800000L});
    public static final BitSet FOLLOW_44 = new BitSet(new long[]{0x0000800000000000L});
    public static final BitSet FOLLOW_45 = new BitSet(new long[]{0x0001000000000000L});
    public static final BitSet FOLLOW_46 = new BitSet(new long[]{0x0002000000000000L});
    public static final BitSet FOLLOW_47 = new BitSet(new long[]{0x0000000000000000L,0x0000007800000000L});
    public static final BitSet FOLLOW_48 = new BitSet(new long[]{0x0004000000000000L});
    public static final BitSet FOLLOW_49 = new BitSet(new long[]{0x0008000000000000L});
    public static final BitSet FOLLOW_50 = new BitSet(new long[]{0x0010000000000000L});
    public static final BitSet FOLLOW_51 = new BitSet(new long[]{0x0040000000800000L});
    public static final BitSet FOLLOW_52 = new BitSet(new long[]{0x0040000000000000L});
    public static final BitSet FOLLOW_53 = new BitSet(new long[]{0x0000000000000000L,0x0000000000008000L});
    public static final BitSet FOLLOW_54 = new BitSet(new long[]{0x0100000000000000L});
    public static final BitSet FOLLOW_55 = new BitSet(new long[]{0x0200000000000000L});
    public static final BitSet FOLLOW_56 = new BitSet(new long[]{0x0400000000000000L});
    public static final BitSet FOLLOW_57 = new BitSet(new long[]{0x0000000000000000L,0x00000F8000000000L});
    public static final BitSet FOLLOW_58 = new BitSet(new long[]{0x2000000000000000L});
    public static final BitSet FOLLOW_59 = new BitSet(new long[]{0x4000000000000000L});
    public static final BitSet FOLLOW_60 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000001L});
    public static final BitSet FOLLOW_61 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000002L});
    public static final BitSet FOLLOW_62 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000004L});
    public static final BitSet FOLLOW_63 = new BitSet(new long[]{0x0000000000000040L,0x0000000000020000L});
    public static final BitSet FOLLOW_64 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000008L});
    public static final BitSet FOLLOW_65 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000010L});
    public static final BitSet FOLLOW_66 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000040L});
    public static final BitSet FOLLOW_67 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000080L});
    public static final BitSet FOLLOW_68 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000100L});
    public static final BitSet FOLLOW_69 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000400L});
    public static final BitSet FOLLOW_70 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000800L});
    public static final BitSet FOLLOW_71 = new BitSet(new long[]{0x0000000000000000L,0x0000000000002000L});
    public static final BitSet FOLLOW_72 = new BitSet(new long[]{0x0000000000000000L,0x0000000000004000L});
    public static final BitSet FOLLOW_73 = new BitSet(new long[]{0x0000000000000000L,0x0000000000010000L});
    public static final BitSet FOLLOW_74 = new BitSet(new long[]{0x0000000000000040L});

}