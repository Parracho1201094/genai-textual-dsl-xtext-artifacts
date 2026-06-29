package org.xtext.example.mydsl.ide.contentassist.antlr.internal;

import java.io.InputStream;
import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.ide.editor.contentassist.antlr.internal.AbstractInternalContentAssistParser;
import org.eclipse.xtext.ide.editor.contentassist.antlr.internal.DFA;
import org.xtext.example.mydsl.services.MyDslGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalMyDslParser extends AbstractInternalContentAssistParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_STRING", "RULE_ID", "RULE_INT", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'true'", "'false'", "'TEXT'", "'NUMBER'", "'DATE'", "'MAX'", "'MIN'", "'COUNT'", "'SUM'", "'AVERAGE'", "'ASC'", "'DESC'", "'EQUALS'", "'LESS_THAN'", "'GREATER_THAN'", "'LESS_OR_EQUALS_THAN'", "'GREATER_OR_EQUALS_THAN'", "'INNER'", "'OUTER'", "'LEFT'", "'RIGHT'", "'NUMERIC_SUM'", "'NUMERIC_SUBTRACT'", "'NUMERIC_MULTIPLY'", "'NUMERIC_DIVIDE'", "'TEXT_CONCAT'", "'Model'", "'{'", "'logs'", "'tables'", "'}'", "'steps'", "','", "'Table'", "'columns'", "'Column'", "'dataType'", "'Save'", "'tablesToSave'", "'description'", "'Group'", "'table'", "'groupBy'", "'('", "')'", "'operation'", "'operandColumn'", "'resultTable'", "'resultColumn'", "'next'", "'Sort'", "'column'", "'order'", "'AppendRows'", "'originTable'", "'destinTable'", "'associations'", "'Filter'", "'operator'", "'operand'", "'GenericStep'", "'Join'", "'tableLeft'", "'columnLeft'", "'type'", "'tableRight'", "'columnRight'", "'selectColumns'", "'Import'", "'tablesToImport'", "'Lookup'", "'lookupTable'", "'matchColumn'", "'lookupColumn'", "'RemoveDuplicates'", "'Concat'", "'sourceA'", "'sourceB'", "'Split'", "'source'", "'delimiter'", "'atCharIndex'", "'resultColumnA'", "'resultColumnB'", "'Extract'", "'lbChar'", "'ubChar'", "'pattern'", "'TableToSave'", "'path'", "'columnsNames'", "'Association'", "'originCol'", "'destinCol'", "'deleteMismatchedTypes'", "'TableToImport'", "'-'"
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

    	public void setGrammarAccess(MyDslGrammarAccess grammarAccess) {
    		this.grammarAccess = grammarAccess;
    	}

    	@Override
    	protected Grammar getGrammar() {
    		return grammarAccess.getGrammar();
    	}

    	@Override
    	protected String getValueForTokenName(String tokenName) {
    		return tokenName;
    	}



    // $ANTLR start "entryRuleModel"
    // InternalMyDsl.g:53:1: entryRuleModel : ruleModel EOF ;
    public final void entryRuleModel() throws RecognitionException {
        try {
            // InternalMyDsl.g:54:1: ( ruleModel EOF )
            // InternalMyDsl.g:55:1: ruleModel EOF
            {
             before(grammarAccess.getModelRule()); 
            pushFollow(FOLLOW_1);
            ruleModel();

            state._fsp--;

             after(grammarAccess.getModelRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleModel"


    // $ANTLR start "ruleModel"
    // InternalMyDsl.g:62:1: ruleModel : ( ( rule__Model__Group__0 ) ) ;
    public final void ruleModel() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:66:2: ( ( ( rule__Model__Group__0 ) ) )
            // InternalMyDsl.g:67:2: ( ( rule__Model__Group__0 ) )
            {
            // InternalMyDsl.g:67:2: ( ( rule__Model__Group__0 ) )
            // InternalMyDsl.g:68:3: ( rule__Model__Group__0 )
            {
             before(grammarAccess.getModelAccess().getGroup()); 
            // InternalMyDsl.g:69:3: ( rule__Model__Group__0 )
            // InternalMyDsl.g:69:4: rule__Model__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__Model__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getModelAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleModel"


    // $ANTLR start "entryRuleStep"
    // InternalMyDsl.g:78:1: entryRuleStep : ruleStep EOF ;
    public final void entryRuleStep() throws RecognitionException {
        try {
            // InternalMyDsl.g:79:1: ( ruleStep EOF )
            // InternalMyDsl.g:80:1: ruleStep EOF
            {
             before(grammarAccess.getStepRule()); 
            pushFollow(FOLLOW_1);
            ruleStep();

            state._fsp--;

             after(grammarAccess.getStepRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleStep"


    // $ANTLR start "ruleStep"
    // InternalMyDsl.g:87:1: ruleStep : ( ( rule__Step__Alternatives ) ) ;
    public final void ruleStep() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:91:2: ( ( ( rule__Step__Alternatives ) ) )
            // InternalMyDsl.g:92:2: ( ( rule__Step__Alternatives ) )
            {
            // InternalMyDsl.g:92:2: ( ( rule__Step__Alternatives ) )
            // InternalMyDsl.g:93:3: ( rule__Step__Alternatives )
            {
             before(grammarAccess.getStepAccess().getAlternatives()); 
            // InternalMyDsl.g:94:3: ( rule__Step__Alternatives )
            // InternalMyDsl.g:94:4: rule__Step__Alternatives
            {
            pushFollow(FOLLOW_2);
            rule__Step__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getStepAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleStep"


    // $ANTLR start "entryRuleEString"
    // InternalMyDsl.g:103:1: entryRuleEString : ruleEString EOF ;
    public final void entryRuleEString() throws RecognitionException {
        try {
            // InternalMyDsl.g:104:1: ( ruleEString EOF )
            // InternalMyDsl.g:105:1: ruleEString EOF
            {
             before(grammarAccess.getEStringRule()); 
            pushFollow(FOLLOW_1);
            ruleEString();

            state._fsp--;

             after(grammarAccess.getEStringRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleEString"


    // $ANTLR start "ruleEString"
    // InternalMyDsl.g:112:1: ruleEString : ( ( rule__EString__Alternatives ) ) ;
    public final void ruleEString() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:116:2: ( ( ( rule__EString__Alternatives ) ) )
            // InternalMyDsl.g:117:2: ( ( rule__EString__Alternatives ) )
            {
            // InternalMyDsl.g:117:2: ( ( rule__EString__Alternatives ) )
            // InternalMyDsl.g:118:3: ( rule__EString__Alternatives )
            {
             before(grammarAccess.getEStringAccess().getAlternatives()); 
            // InternalMyDsl.g:119:3: ( rule__EString__Alternatives )
            // InternalMyDsl.g:119:4: rule__EString__Alternatives
            {
            pushFollow(FOLLOW_2);
            rule__EString__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getEStringAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleEString"


    // $ANTLR start "entryRuleTable"
    // InternalMyDsl.g:128:1: entryRuleTable : ruleTable EOF ;
    public final void entryRuleTable() throws RecognitionException {
        try {
            // InternalMyDsl.g:129:1: ( ruleTable EOF )
            // InternalMyDsl.g:130:1: ruleTable EOF
            {
             before(grammarAccess.getTableRule()); 
            pushFollow(FOLLOW_1);
            ruleTable();

            state._fsp--;

             after(grammarAccess.getTableRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleTable"


    // $ANTLR start "ruleTable"
    // InternalMyDsl.g:137:1: ruleTable : ( ( rule__Table__Group__0 ) ) ;
    public final void ruleTable() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:141:2: ( ( ( rule__Table__Group__0 ) ) )
            // InternalMyDsl.g:142:2: ( ( rule__Table__Group__0 ) )
            {
            // InternalMyDsl.g:142:2: ( ( rule__Table__Group__0 ) )
            // InternalMyDsl.g:143:3: ( rule__Table__Group__0 )
            {
             before(grammarAccess.getTableAccess().getGroup()); 
            // InternalMyDsl.g:144:3: ( rule__Table__Group__0 )
            // InternalMyDsl.g:144:4: rule__Table__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__Table__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getTableAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleTable"


    // $ANTLR start "entryRuleColumn"
    // InternalMyDsl.g:153:1: entryRuleColumn : ruleColumn EOF ;
    public final void entryRuleColumn() throws RecognitionException {
        try {
            // InternalMyDsl.g:154:1: ( ruleColumn EOF )
            // InternalMyDsl.g:155:1: ruleColumn EOF
            {
             before(grammarAccess.getColumnRule()); 
            pushFollow(FOLLOW_1);
            ruleColumn();

            state._fsp--;

             after(grammarAccess.getColumnRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleColumn"


    // $ANTLR start "ruleColumn"
    // InternalMyDsl.g:162:1: ruleColumn : ( ( rule__Column__Group__0 ) ) ;
    public final void ruleColumn() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:166:2: ( ( ( rule__Column__Group__0 ) ) )
            // InternalMyDsl.g:167:2: ( ( rule__Column__Group__0 ) )
            {
            // InternalMyDsl.g:167:2: ( ( rule__Column__Group__0 ) )
            // InternalMyDsl.g:168:3: ( rule__Column__Group__0 )
            {
             before(grammarAccess.getColumnAccess().getGroup()); 
            // InternalMyDsl.g:169:3: ( rule__Column__Group__0 )
            // InternalMyDsl.g:169:4: rule__Column__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__Column__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getColumnAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleColumn"


    // $ANTLR start "entryRuleSave"
    // InternalMyDsl.g:178:1: entryRuleSave : ruleSave EOF ;
    public final void entryRuleSave() throws RecognitionException {
        try {
            // InternalMyDsl.g:179:1: ( ruleSave EOF )
            // InternalMyDsl.g:180:1: ruleSave EOF
            {
             before(grammarAccess.getSaveRule()); 
            pushFollow(FOLLOW_1);
            ruleSave();

            state._fsp--;

             after(grammarAccess.getSaveRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleSave"


    // $ANTLR start "ruleSave"
    // InternalMyDsl.g:187:1: ruleSave : ( ( rule__Save__Group__0 ) ) ;
    public final void ruleSave() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:191:2: ( ( ( rule__Save__Group__0 ) ) )
            // InternalMyDsl.g:192:2: ( ( rule__Save__Group__0 ) )
            {
            // InternalMyDsl.g:192:2: ( ( rule__Save__Group__0 ) )
            // InternalMyDsl.g:193:3: ( rule__Save__Group__0 )
            {
             before(grammarAccess.getSaveAccess().getGroup()); 
            // InternalMyDsl.g:194:3: ( rule__Save__Group__0 )
            // InternalMyDsl.g:194:4: rule__Save__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__Save__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getSaveAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleSave"


    // $ANTLR start "entryRuleGroup"
    // InternalMyDsl.g:203:1: entryRuleGroup : ruleGroup EOF ;
    public final void entryRuleGroup() throws RecognitionException {
        try {
            // InternalMyDsl.g:204:1: ( ruleGroup EOF )
            // InternalMyDsl.g:205:1: ruleGroup EOF
            {
             before(grammarAccess.getGroupRule()); 
            pushFollow(FOLLOW_1);
            ruleGroup();

            state._fsp--;

             after(grammarAccess.getGroupRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleGroup"


    // $ANTLR start "ruleGroup"
    // InternalMyDsl.g:212:1: ruleGroup : ( ( rule__Group__Group__0 ) ) ;
    public final void ruleGroup() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:216:2: ( ( ( rule__Group__Group__0 ) ) )
            // InternalMyDsl.g:217:2: ( ( rule__Group__Group__0 ) )
            {
            // InternalMyDsl.g:217:2: ( ( rule__Group__Group__0 ) )
            // InternalMyDsl.g:218:3: ( rule__Group__Group__0 )
            {
             before(grammarAccess.getGroupAccess().getGroup()); 
            // InternalMyDsl.g:219:3: ( rule__Group__Group__0 )
            // InternalMyDsl.g:219:4: rule__Group__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__Group__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getGroupAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleGroup"


    // $ANTLR start "entryRuleSort"
    // InternalMyDsl.g:228:1: entryRuleSort : ruleSort EOF ;
    public final void entryRuleSort() throws RecognitionException {
        try {
            // InternalMyDsl.g:229:1: ( ruleSort EOF )
            // InternalMyDsl.g:230:1: ruleSort EOF
            {
             before(grammarAccess.getSortRule()); 
            pushFollow(FOLLOW_1);
            ruleSort();

            state._fsp--;

             after(grammarAccess.getSortRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleSort"


    // $ANTLR start "ruleSort"
    // InternalMyDsl.g:237:1: ruleSort : ( ( rule__Sort__Group__0 ) ) ;
    public final void ruleSort() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:241:2: ( ( ( rule__Sort__Group__0 ) ) )
            // InternalMyDsl.g:242:2: ( ( rule__Sort__Group__0 ) )
            {
            // InternalMyDsl.g:242:2: ( ( rule__Sort__Group__0 ) )
            // InternalMyDsl.g:243:3: ( rule__Sort__Group__0 )
            {
             before(grammarAccess.getSortAccess().getGroup()); 
            // InternalMyDsl.g:244:3: ( rule__Sort__Group__0 )
            // InternalMyDsl.g:244:4: rule__Sort__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__Sort__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getSortAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleSort"


    // $ANTLR start "entryRuleAppendRows"
    // InternalMyDsl.g:253:1: entryRuleAppendRows : ruleAppendRows EOF ;
    public final void entryRuleAppendRows() throws RecognitionException {
        try {
            // InternalMyDsl.g:254:1: ( ruleAppendRows EOF )
            // InternalMyDsl.g:255:1: ruleAppendRows EOF
            {
             before(grammarAccess.getAppendRowsRule()); 
            pushFollow(FOLLOW_1);
            ruleAppendRows();

            state._fsp--;

             after(grammarAccess.getAppendRowsRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleAppendRows"


    // $ANTLR start "ruleAppendRows"
    // InternalMyDsl.g:262:1: ruleAppendRows : ( ( rule__AppendRows__Group__0 ) ) ;
    public final void ruleAppendRows() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:266:2: ( ( ( rule__AppendRows__Group__0 ) ) )
            // InternalMyDsl.g:267:2: ( ( rule__AppendRows__Group__0 ) )
            {
            // InternalMyDsl.g:267:2: ( ( rule__AppendRows__Group__0 ) )
            // InternalMyDsl.g:268:3: ( rule__AppendRows__Group__0 )
            {
             before(grammarAccess.getAppendRowsAccess().getGroup()); 
            // InternalMyDsl.g:269:3: ( rule__AppendRows__Group__0 )
            // InternalMyDsl.g:269:4: rule__AppendRows__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__AppendRows__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getAppendRowsAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleAppendRows"


    // $ANTLR start "entryRuleFilter"
    // InternalMyDsl.g:278:1: entryRuleFilter : ruleFilter EOF ;
    public final void entryRuleFilter() throws RecognitionException {
        try {
            // InternalMyDsl.g:279:1: ( ruleFilter EOF )
            // InternalMyDsl.g:280:1: ruleFilter EOF
            {
             before(grammarAccess.getFilterRule()); 
            pushFollow(FOLLOW_1);
            ruleFilter();

            state._fsp--;

             after(grammarAccess.getFilterRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleFilter"


    // $ANTLR start "ruleFilter"
    // InternalMyDsl.g:287:1: ruleFilter : ( ( rule__Filter__Group__0 ) ) ;
    public final void ruleFilter() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:291:2: ( ( ( rule__Filter__Group__0 ) ) )
            // InternalMyDsl.g:292:2: ( ( rule__Filter__Group__0 ) )
            {
            // InternalMyDsl.g:292:2: ( ( rule__Filter__Group__0 ) )
            // InternalMyDsl.g:293:3: ( rule__Filter__Group__0 )
            {
             before(grammarAccess.getFilterAccess().getGroup()); 
            // InternalMyDsl.g:294:3: ( rule__Filter__Group__0 )
            // InternalMyDsl.g:294:4: rule__Filter__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__Filter__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getFilterAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleFilter"


    // $ANTLR start "entryRuleGenericStep"
    // InternalMyDsl.g:303:1: entryRuleGenericStep : ruleGenericStep EOF ;
    public final void entryRuleGenericStep() throws RecognitionException {
        try {
            // InternalMyDsl.g:304:1: ( ruleGenericStep EOF )
            // InternalMyDsl.g:305:1: ruleGenericStep EOF
            {
             before(grammarAccess.getGenericStepRule()); 
            pushFollow(FOLLOW_1);
            ruleGenericStep();

            state._fsp--;

             after(grammarAccess.getGenericStepRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleGenericStep"


    // $ANTLR start "ruleGenericStep"
    // InternalMyDsl.g:312:1: ruleGenericStep : ( ( rule__GenericStep__Group__0 ) ) ;
    public final void ruleGenericStep() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:316:2: ( ( ( rule__GenericStep__Group__0 ) ) )
            // InternalMyDsl.g:317:2: ( ( rule__GenericStep__Group__0 ) )
            {
            // InternalMyDsl.g:317:2: ( ( rule__GenericStep__Group__0 ) )
            // InternalMyDsl.g:318:3: ( rule__GenericStep__Group__0 )
            {
             before(grammarAccess.getGenericStepAccess().getGroup()); 
            // InternalMyDsl.g:319:3: ( rule__GenericStep__Group__0 )
            // InternalMyDsl.g:319:4: rule__GenericStep__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__GenericStep__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getGenericStepAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleGenericStep"


    // $ANTLR start "entryRuleJoin"
    // InternalMyDsl.g:328:1: entryRuleJoin : ruleJoin EOF ;
    public final void entryRuleJoin() throws RecognitionException {
        try {
            // InternalMyDsl.g:329:1: ( ruleJoin EOF )
            // InternalMyDsl.g:330:1: ruleJoin EOF
            {
             before(grammarAccess.getJoinRule()); 
            pushFollow(FOLLOW_1);
            ruleJoin();

            state._fsp--;

             after(grammarAccess.getJoinRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleJoin"


    // $ANTLR start "ruleJoin"
    // InternalMyDsl.g:337:1: ruleJoin : ( ( rule__Join__Group__0 ) ) ;
    public final void ruleJoin() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:341:2: ( ( ( rule__Join__Group__0 ) ) )
            // InternalMyDsl.g:342:2: ( ( rule__Join__Group__0 ) )
            {
            // InternalMyDsl.g:342:2: ( ( rule__Join__Group__0 ) )
            // InternalMyDsl.g:343:3: ( rule__Join__Group__0 )
            {
             before(grammarAccess.getJoinAccess().getGroup()); 
            // InternalMyDsl.g:344:3: ( rule__Join__Group__0 )
            // InternalMyDsl.g:344:4: rule__Join__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__Join__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getJoinAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleJoin"


    // $ANTLR start "entryRuleImport"
    // InternalMyDsl.g:353:1: entryRuleImport : ruleImport EOF ;
    public final void entryRuleImport() throws RecognitionException {
        try {
            // InternalMyDsl.g:354:1: ( ruleImport EOF )
            // InternalMyDsl.g:355:1: ruleImport EOF
            {
             before(grammarAccess.getImportRule()); 
            pushFollow(FOLLOW_1);
            ruleImport();

            state._fsp--;

             after(grammarAccess.getImportRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleImport"


    // $ANTLR start "ruleImport"
    // InternalMyDsl.g:362:1: ruleImport : ( ( rule__Import__Group__0 ) ) ;
    public final void ruleImport() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:366:2: ( ( ( rule__Import__Group__0 ) ) )
            // InternalMyDsl.g:367:2: ( ( rule__Import__Group__0 ) )
            {
            // InternalMyDsl.g:367:2: ( ( rule__Import__Group__0 ) )
            // InternalMyDsl.g:368:3: ( rule__Import__Group__0 )
            {
             before(grammarAccess.getImportAccess().getGroup()); 
            // InternalMyDsl.g:369:3: ( rule__Import__Group__0 )
            // InternalMyDsl.g:369:4: rule__Import__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__Import__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getImportAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleImport"


    // $ANTLR start "entryRuleLookup"
    // InternalMyDsl.g:378:1: entryRuleLookup : ruleLookup EOF ;
    public final void entryRuleLookup() throws RecognitionException {
        try {
            // InternalMyDsl.g:379:1: ( ruleLookup EOF )
            // InternalMyDsl.g:380:1: ruleLookup EOF
            {
             before(grammarAccess.getLookupRule()); 
            pushFollow(FOLLOW_1);
            ruleLookup();

            state._fsp--;

             after(grammarAccess.getLookupRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleLookup"


    // $ANTLR start "ruleLookup"
    // InternalMyDsl.g:387:1: ruleLookup : ( ( rule__Lookup__Group__0 ) ) ;
    public final void ruleLookup() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:391:2: ( ( ( rule__Lookup__Group__0 ) ) )
            // InternalMyDsl.g:392:2: ( ( rule__Lookup__Group__0 ) )
            {
            // InternalMyDsl.g:392:2: ( ( rule__Lookup__Group__0 ) )
            // InternalMyDsl.g:393:3: ( rule__Lookup__Group__0 )
            {
             before(grammarAccess.getLookupAccess().getGroup()); 
            // InternalMyDsl.g:394:3: ( rule__Lookup__Group__0 )
            // InternalMyDsl.g:394:4: rule__Lookup__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__Lookup__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getLookupAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleLookup"


    // $ANTLR start "entryRuleRemoveDuplicates"
    // InternalMyDsl.g:403:1: entryRuleRemoveDuplicates : ruleRemoveDuplicates EOF ;
    public final void entryRuleRemoveDuplicates() throws RecognitionException {
        try {
            // InternalMyDsl.g:404:1: ( ruleRemoveDuplicates EOF )
            // InternalMyDsl.g:405:1: ruleRemoveDuplicates EOF
            {
             before(grammarAccess.getRemoveDuplicatesRule()); 
            pushFollow(FOLLOW_1);
            ruleRemoveDuplicates();

            state._fsp--;

             after(grammarAccess.getRemoveDuplicatesRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleRemoveDuplicates"


    // $ANTLR start "ruleRemoveDuplicates"
    // InternalMyDsl.g:412:1: ruleRemoveDuplicates : ( ( rule__RemoveDuplicates__Group__0 ) ) ;
    public final void ruleRemoveDuplicates() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:416:2: ( ( ( rule__RemoveDuplicates__Group__0 ) ) )
            // InternalMyDsl.g:417:2: ( ( rule__RemoveDuplicates__Group__0 ) )
            {
            // InternalMyDsl.g:417:2: ( ( rule__RemoveDuplicates__Group__0 ) )
            // InternalMyDsl.g:418:3: ( rule__RemoveDuplicates__Group__0 )
            {
             before(grammarAccess.getRemoveDuplicatesAccess().getGroup()); 
            // InternalMyDsl.g:419:3: ( rule__RemoveDuplicates__Group__0 )
            // InternalMyDsl.g:419:4: rule__RemoveDuplicates__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__RemoveDuplicates__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getRemoveDuplicatesAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleRemoveDuplicates"


    // $ANTLR start "entryRuleConcat"
    // InternalMyDsl.g:428:1: entryRuleConcat : ruleConcat EOF ;
    public final void entryRuleConcat() throws RecognitionException {
        try {
            // InternalMyDsl.g:429:1: ( ruleConcat EOF )
            // InternalMyDsl.g:430:1: ruleConcat EOF
            {
             before(grammarAccess.getConcatRule()); 
            pushFollow(FOLLOW_1);
            ruleConcat();

            state._fsp--;

             after(grammarAccess.getConcatRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleConcat"


    // $ANTLR start "ruleConcat"
    // InternalMyDsl.g:437:1: ruleConcat : ( ( rule__Concat__Group__0 ) ) ;
    public final void ruleConcat() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:441:2: ( ( ( rule__Concat__Group__0 ) ) )
            // InternalMyDsl.g:442:2: ( ( rule__Concat__Group__0 ) )
            {
            // InternalMyDsl.g:442:2: ( ( rule__Concat__Group__0 ) )
            // InternalMyDsl.g:443:3: ( rule__Concat__Group__0 )
            {
             before(grammarAccess.getConcatAccess().getGroup()); 
            // InternalMyDsl.g:444:3: ( rule__Concat__Group__0 )
            // InternalMyDsl.g:444:4: rule__Concat__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__Concat__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getConcatAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleConcat"


    // $ANTLR start "entryRuleSplit"
    // InternalMyDsl.g:453:1: entryRuleSplit : ruleSplit EOF ;
    public final void entryRuleSplit() throws RecognitionException {
        try {
            // InternalMyDsl.g:454:1: ( ruleSplit EOF )
            // InternalMyDsl.g:455:1: ruleSplit EOF
            {
             before(grammarAccess.getSplitRule()); 
            pushFollow(FOLLOW_1);
            ruleSplit();

            state._fsp--;

             after(grammarAccess.getSplitRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleSplit"


    // $ANTLR start "ruleSplit"
    // InternalMyDsl.g:462:1: ruleSplit : ( ( rule__Split__Group__0 ) ) ;
    public final void ruleSplit() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:466:2: ( ( ( rule__Split__Group__0 ) ) )
            // InternalMyDsl.g:467:2: ( ( rule__Split__Group__0 ) )
            {
            // InternalMyDsl.g:467:2: ( ( rule__Split__Group__0 ) )
            // InternalMyDsl.g:468:3: ( rule__Split__Group__0 )
            {
             before(grammarAccess.getSplitAccess().getGroup()); 
            // InternalMyDsl.g:469:3: ( rule__Split__Group__0 )
            // InternalMyDsl.g:469:4: rule__Split__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__Split__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getSplitAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleSplit"


    // $ANTLR start "entryRuleExtract"
    // InternalMyDsl.g:478:1: entryRuleExtract : ruleExtract EOF ;
    public final void entryRuleExtract() throws RecognitionException {
        try {
            // InternalMyDsl.g:479:1: ( ruleExtract EOF )
            // InternalMyDsl.g:480:1: ruleExtract EOF
            {
             before(grammarAccess.getExtractRule()); 
            pushFollow(FOLLOW_1);
            ruleExtract();

            state._fsp--;

             after(grammarAccess.getExtractRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleExtract"


    // $ANTLR start "ruleExtract"
    // InternalMyDsl.g:487:1: ruleExtract : ( ( rule__Extract__Group__0 ) ) ;
    public final void ruleExtract() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:491:2: ( ( ( rule__Extract__Group__0 ) ) )
            // InternalMyDsl.g:492:2: ( ( rule__Extract__Group__0 ) )
            {
            // InternalMyDsl.g:492:2: ( ( rule__Extract__Group__0 ) )
            // InternalMyDsl.g:493:3: ( rule__Extract__Group__0 )
            {
             before(grammarAccess.getExtractAccess().getGroup()); 
            // InternalMyDsl.g:494:3: ( rule__Extract__Group__0 )
            // InternalMyDsl.g:494:4: rule__Extract__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__Extract__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getExtractAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleExtract"


    // $ANTLR start "entryRuleTableToSave"
    // InternalMyDsl.g:503:1: entryRuleTableToSave : ruleTableToSave EOF ;
    public final void entryRuleTableToSave() throws RecognitionException {
        try {
            // InternalMyDsl.g:504:1: ( ruleTableToSave EOF )
            // InternalMyDsl.g:505:1: ruleTableToSave EOF
            {
             before(grammarAccess.getTableToSaveRule()); 
            pushFollow(FOLLOW_1);
            ruleTableToSave();

            state._fsp--;

             after(grammarAccess.getTableToSaveRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleTableToSave"


    // $ANTLR start "ruleTableToSave"
    // InternalMyDsl.g:512:1: ruleTableToSave : ( ( rule__TableToSave__Group__0 ) ) ;
    public final void ruleTableToSave() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:516:2: ( ( ( rule__TableToSave__Group__0 ) ) )
            // InternalMyDsl.g:517:2: ( ( rule__TableToSave__Group__0 ) )
            {
            // InternalMyDsl.g:517:2: ( ( rule__TableToSave__Group__0 ) )
            // InternalMyDsl.g:518:3: ( rule__TableToSave__Group__0 )
            {
             before(grammarAccess.getTableToSaveAccess().getGroup()); 
            // InternalMyDsl.g:519:3: ( rule__TableToSave__Group__0 )
            // InternalMyDsl.g:519:4: rule__TableToSave__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__TableToSave__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getTableToSaveAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleTableToSave"


    // $ANTLR start "entryRuleAssociation"
    // InternalMyDsl.g:528:1: entryRuleAssociation : ruleAssociation EOF ;
    public final void entryRuleAssociation() throws RecognitionException {
        try {
            // InternalMyDsl.g:529:1: ( ruleAssociation EOF )
            // InternalMyDsl.g:530:1: ruleAssociation EOF
            {
             before(grammarAccess.getAssociationRule()); 
            pushFollow(FOLLOW_1);
            ruleAssociation();

            state._fsp--;

             after(grammarAccess.getAssociationRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleAssociation"


    // $ANTLR start "ruleAssociation"
    // InternalMyDsl.g:537:1: ruleAssociation : ( ( rule__Association__Group__0 ) ) ;
    public final void ruleAssociation() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:541:2: ( ( ( rule__Association__Group__0 ) ) )
            // InternalMyDsl.g:542:2: ( ( rule__Association__Group__0 ) )
            {
            // InternalMyDsl.g:542:2: ( ( rule__Association__Group__0 ) )
            // InternalMyDsl.g:543:3: ( rule__Association__Group__0 )
            {
             before(grammarAccess.getAssociationAccess().getGroup()); 
            // InternalMyDsl.g:544:3: ( rule__Association__Group__0 )
            // InternalMyDsl.g:544:4: rule__Association__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__Association__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getAssociationAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleAssociation"


    // $ANTLR start "entryRuleTableToImport"
    // InternalMyDsl.g:553:1: entryRuleTableToImport : ruleTableToImport EOF ;
    public final void entryRuleTableToImport() throws RecognitionException {
        try {
            // InternalMyDsl.g:554:1: ( ruleTableToImport EOF )
            // InternalMyDsl.g:555:1: ruleTableToImport EOF
            {
             before(grammarAccess.getTableToImportRule()); 
            pushFollow(FOLLOW_1);
            ruleTableToImport();

            state._fsp--;

             after(grammarAccess.getTableToImportRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleTableToImport"


    // $ANTLR start "ruleTableToImport"
    // InternalMyDsl.g:562:1: ruleTableToImport : ( ( rule__TableToImport__Group__0 ) ) ;
    public final void ruleTableToImport() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:566:2: ( ( ( rule__TableToImport__Group__0 ) ) )
            // InternalMyDsl.g:567:2: ( ( rule__TableToImport__Group__0 ) )
            {
            // InternalMyDsl.g:567:2: ( ( rule__TableToImport__Group__0 ) )
            // InternalMyDsl.g:568:3: ( rule__TableToImport__Group__0 )
            {
             before(grammarAccess.getTableToImportAccess().getGroup()); 
            // InternalMyDsl.g:569:3: ( rule__TableToImport__Group__0 )
            // InternalMyDsl.g:569:4: rule__TableToImport__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__TableToImport__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getTableToImportAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleTableToImport"


    // $ANTLR start "entryRuleEIntegerObject"
    // InternalMyDsl.g:578:1: entryRuleEIntegerObject : ruleEIntegerObject EOF ;
    public final void entryRuleEIntegerObject() throws RecognitionException {
        try {
            // InternalMyDsl.g:579:1: ( ruleEIntegerObject EOF )
            // InternalMyDsl.g:580:1: ruleEIntegerObject EOF
            {
             before(grammarAccess.getEIntegerObjectRule()); 
            pushFollow(FOLLOW_1);
            ruleEIntegerObject();

            state._fsp--;

             after(grammarAccess.getEIntegerObjectRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleEIntegerObject"


    // $ANTLR start "ruleEIntegerObject"
    // InternalMyDsl.g:587:1: ruleEIntegerObject : ( ( rule__EIntegerObject__Group__0 ) ) ;
    public final void ruleEIntegerObject() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:591:2: ( ( ( rule__EIntegerObject__Group__0 ) ) )
            // InternalMyDsl.g:592:2: ( ( rule__EIntegerObject__Group__0 ) )
            {
            // InternalMyDsl.g:592:2: ( ( rule__EIntegerObject__Group__0 ) )
            // InternalMyDsl.g:593:3: ( rule__EIntegerObject__Group__0 )
            {
             before(grammarAccess.getEIntegerObjectAccess().getGroup()); 
            // InternalMyDsl.g:594:3: ( rule__EIntegerObject__Group__0 )
            // InternalMyDsl.g:594:4: rule__EIntegerObject__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__EIntegerObject__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getEIntegerObjectAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleEIntegerObject"


    // $ANTLR start "entryRuleEBooleanObject"
    // InternalMyDsl.g:603:1: entryRuleEBooleanObject : ruleEBooleanObject EOF ;
    public final void entryRuleEBooleanObject() throws RecognitionException {
        try {
            // InternalMyDsl.g:604:1: ( ruleEBooleanObject EOF )
            // InternalMyDsl.g:605:1: ruleEBooleanObject EOF
            {
             before(grammarAccess.getEBooleanObjectRule()); 
            pushFollow(FOLLOW_1);
            ruleEBooleanObject();

            state._fsp--;

             after(grammarAccess.getEBooleanObjectRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleEBooleanObject"


    // $ANTLR start "ruleEBooleanObject"
    // InternalMyDsl.g:612:1: ruleEBooleanObject : ( ( rule__EBooleanObject__Alternatives ) ) ;
    public final void ruleEBooleanObject() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:616:2: ( ( ( rule__EBooleanObject__Alternatives ) ) )
            // InternalMyDsl.g:617:2: ( ( rule__EBooleanObject__Alternatives ) )
            {
            // InternalMyDsl.g:617:2: ( ( rule__EBooleanObject__Alternatives ) )
            // InternalMyDsl.g:618:3: ( rule__EBooleanObject__Alternatives )
            {
             before(grammarAccess.getEBooleanObjectAccess().getAlternatives()); 
            // InternalMyDsl.g:619:3: ( rule__EBooleanObject__Alternatives )
            // InternalMyDsl.g:619:4: rule__EBooleanObject__Alternatives
            {
            pushFollow(FOLLOW_2);
            rule__EBooleanObject__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getEBooleanObjectAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleEBooleanObject"


    // $ANTLR start "ruleDataType"
    // InternalMyDsl.g:628:1: ruleDataType : ( ( rule__DataType__Alternatives ) ) ;
    public final void ruleDataType() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:632:1: ( ( ( rule__DataType__Alternatives ) ) )
            // InternalMyDsl.g:633:2: ( ( rule__DataType__Alternatives ) )
            {
            // InternalMyDsl.g:633:2: ( ( rule__DataType__Alternatives ) )
            // InternalMyDsl.g:634:3: ( rule__DataType__Alternatives )
            {
             before(grammarAccess.getDataTypeAccess().getAlternatives()); 
            // InternalMyDsl.g:635:3: ( rule__DataType__Alternatives )
            // InternalMyDsl.g:635:4: rule__DataType__Alternatives
            {
            pushFollow(FOLLOW_2);
            rule__DataType__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getDataTypeAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleDataType"


    // $ANTLR start "ruleGroupOperationType"
    // InternalMyDsl.g:644:1: ruleGroupOperationType : ( ( rule__GroupOperationType__Alternatives ) ) ;
    public final void ruleGroupOperationType() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:648:1: ( ( ( rule__GroupOperationType__Alternatives ) ) )
            // InternalMyDsl.g:649:2: ( ( rule__GroupOperationType__Alternatives ) )
            {
            // InternalMyDsl.g:649:2: ( ( rule__GroupOperationType__Alternatives ) )
            // InternalMyDsl.g:650:3: ( rule__GroupOperationType__Alternatives )
            {
             before(grammarAccess.getGroupOperationTypeAccess().getAlternatives()); 
            // InternalMyDsl.g:651:3: ( rule__GroupOperationType__Alternatives )
            // InternalMyDsl.g:651:4: rule__GroupOperationType__Alternatives
            {
            pushFollow(FOLLOW_2);
            rule__GroupOperationType__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getGroupOperationTypeAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleGroupOperationType"


    // $ANTLR start "ruleOrderType"
    // InternalMyDsl.g:660:1: ruleOrderType : ( ( rule__OrderType__Alternatives ) ) ;
    public final void ruleOrderType() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:664:1: ( ( ( rule__OrderType__Alternatives ) ) )
            // InternalMyDsl.g:665:2: ( ( rule__OrderType__Alternatives ) )
            {
            // InternalMyDsl.g:665:2: ( ( rule__OrderType__Alternatives ) )
            // InternalMyDsl.g:666:3: ( rule__OrderType__Alternatives )
            {
             before(grammarAccess.getOrderTypeAccess().getAlternatives()); 
            // InternalMyDsl.g:667:3: ( rule__OrderType__Alternatives )
            // InternalMyDsl.g:667:4: rule__OrderType__Alternatives
            {
            pushFollow(FOLLOW_2);
            rule__OrderType__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getOrderTypeAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleOrderType"


    // $ANTLR start "ruleFilterOperatorType"
    // InternalMyDsl.g:676:1: ruleFilterOperatorType : ( ( rule__FilterOperatorType__Alternatives ) ) ;
    public final void ruleFilterOperatorType() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:680:1: ( ( ( rule__FilterOperatorType__Alternatives ) ) )
            // InternalMyDsl.g:681:2: ( ( rule__FilterOperatorType__Alternatives ) )
            {
            // InternalMyDsl.g:681:2: ( ( rule__FilterOperatorType__Alternatives ) )
            // InternalMyDsl.g:682:3: ( rule__FilterOperatorType__Alternatives )
            {
             before(grammarAccess.getFilterOperatorTypeAccess().getAlternatives()); 
            // InternalMyDsl.g:683:3: ( rule__FilterOperatorType__Alternatives )
            // InternalMyDsl.g:683:4: rule__FilterOperatorType__Alternatives
            {
            pushFollow(FOLLOW_2);
            rule__FilterOperatorType__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getFilterOperatorTypeAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleFilterOperatorType"


    // $ANTLR start "ruleJoinType"
    // InternalMyDsl.g:692:1: ruleJoinType : ( ( rule__JoinType__Alternatives ) ) ;
    public final void ruleJoinType() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:696:1: ( ( ( rule__JoinType__Alternatives ) ) )
            // InternalMyDsl.g:697:2: ( ( rule__JoinType__Alternatives ) )
            {
            // InternalMyDsl.g:697:2: ( ( rule__JoinType__Alternatives ) )
            // InternalMyDsl.g:698:3: ( rule__JoinType__Alternatives )
            {
             before(grammarAccess.getJoinTypeAccess().getAlternatives()); 
            // InternalMyDsl.g:699:3: ( rule__JoinType__Alternatives )
            // InternalMyDsl.g:699:4: rule__JoinType__Alternatives
            {
            pushFollow(FOLLOW_2);
            rule__JoinType__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getJoinTypeAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleJoinType"


    // $ANTLR start "ruleLookupOperationType"
    // InternalMyDsl.g:708:1: ruleLookupOperationType : ( ( rule__LookupOperationType__Alternatives ) ) ;
    public final void ruleLookupOperationType() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:712:1: ( ( ( rule__LookupOperationType__Alternatives ) ) )
            // InternalMyDsl.g:713:2: ( ( rule__LookupOperationType__Alternatives ) )
            {
            // InternalMyDsl.g:713:2: ( ( rule__LookupOperationType__Alternatives ) )
            // InternalMyDsl.g:714:3: ( rule__LookupOperationType__Alternatives )
            {
             before(grammarAccess.getLookupOperationTypeAccess().getAlternatives()); 
            // InternalMyDsl.g:715:3: ( rule__LookupOperationType__Alternatives )
            // InternalMyDsl.g:715:4: rule__LookupOperationType__Alternatives
            {
            pushFollow(FOLLOW_2);
            rule__LookupOperationType__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getLookupOperationTypeAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleLookupOperationType"


    // $ANTLR start "rule__Step__Alternatives"
    // InternalMyDsl.g:723:1: rule__Step__Alternatives : ( ( ruleSave ) | ( ruleGroup ) | ( ruleSort ) | ( ruleAppendRows ) | ( ruleFilter ) | ( ruleGenericStep ) | ( ruleJoin ) | ( ruleImport ) | ( ruleLookup ) | ( ruleRemoveDuplicates ) | ( ruleConcat ) | ( ruleSplit ) | ( ruleExtract ) );
    public final void rule__Step__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:727:1: ( ( ruleSave ) | ( ruleGroup ) | ( ruleSort ) | ( ruleAppendRows ) | ( ruleFilter ) | ( ruleGenericStep ) | ( ruleJoin ) | ( ruleImport ) | ( ruleLookup ) | ( ruleRemoveDuplicates ) | ( ruleConcat ) | ( ruleSplit ) | ( ruleExtract ) )
            int alt1=13;
            switch ( input.LA(1) ) {
            case 48:
                {
                alt1=1;
                }
                break;
            case 51:
                {
                alt1=2;
                }
                break;
            case 61:
                {
                alt1=3;
                }
                break;
            case 64:
                {
                alt1=4;
                }
                break;
            case 68:
                {
                alt1=5;
                }
                break;
            case 71:
                {
                alt1=6;
                }
                break;
            case 72:
                {
                alt1=7;
                }
                break;
            case 79:
                {
                alt1=8;
                }
                break;
            case 81:
                {
                alt1=9;
                }
                break;
            case 85:
                {
                alt1=10;
                }
                break;
            case 86:
                {
                alt1=11;
                }
                break;
            case 89:
                {
                alt1=12;
                }
                break;
            case 95:
                {
                alt1=13;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 1, 0, input);

                throw nvae;
            }

            switch (alt1) {
                case 1 :
                    // InternalMyDsl.g:728:2: ( ruleSave )
                    {
                    // InternalMyDsl.g:728:2: ( ruleSave )
                    // InternalMyDsl.g:729:3: ruleSave
                    {
                     before(grammarAccess.getStepAccess().getSaveParserRuleCall_0()); 
                    pushFollow(FOLLOW_2);
                    ruleSave();

                    state._fsp--;

                     after(grammarAccess.getStepAccess().getSaveParserRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalMyDsl.g:734:2: ( ruleGroup )
                    {
                    // InternalMyDsl.g:734:2: ( ruleGroup )
                    // InternalMyDsl.g:735:3: ruleGroup
                    {
                     before(grammarAccess.getStepAccess().getGroupParserRuleCall_1()); 
                    pushFollow(FOLLOW_2);
                    ruleGroup();

                    state._fsp--;

                     after(grammarAccess.getStepAccess().getGroupParserRuleCall_1()); 

                    }


                    }
                    break;
                case 3 :
                    // InternalMyDsl.g:740:2: ( ruleSort )
                    {
                    // InternalMyDsl.g:740:2: ( ruleSort )
                    // InternalMyDsl.g:741:3: ruleSort
                    {
                     before(grammarAccess.getStepAccess().getSortParserRuleCall_2()); 
                    pushFollow(FOLLOW_2);
                    ruleSort();

                    state._fsp--;

                     after(grammarAccess.getStepAccess().getSortParserRuleCall_2()); 

                    }


                    }
                    break;
                case 4 :
                    // InternalMyDsl.g:746:2: ( ruleAppendRows )
                    {
                    // InternalMyDsl.g:746:2: ( ruleAppendRows )
                    // InternalMyDsl.g:747:3: ruleAppendRows
                    {
                     before(grammarAccess.getStepAccess().getAppendRowsParserRuleCall_3()); 
                    pushFollow(FOLLOW_2);
                    ruleAppendRows();

                    state._fsp--;

                     after(grammarAccess.getStepAccess().getAppendRowsParserRuleCall_3()); 

                    }


                    }
                    break;
                case 5 :
                    // InternalMyDsl.g:752:2: ( ruleFilter )
                    {
                    // InternalMyDsl.g:752:2: ( ruleFilter )
                    // InternalMyDsl.g:753:3: ruleFilter
                    {
                     before(grammarAccess.getStepAccess().getFilterParserRuleCall_4()); 
                    pushFollow(FOLLOW_2);
                    ruleFilter();

                    state._fsp--;

                     after(grammarAccess.getStepAccess().getFilterParserRuleCall_4()); 

                    }


                    }
                    break;
                case 6 :
                    // InternalMyDsl.g:758:2: ( ruleGenericStep )
                    {
                    // InternalMyDsl.g:758:2: ( ruleGenericStep )
                    // InternalMyDsl.g:759:3: ruleGenericStep
                    {
                     before(grammarAccess.getStepAccess().getGenericStepParserRuleCall_5()); 
                    pushFollow(FOLLOW_2);
                    ruleGenericStep();

                    state._fsp--;

                     after(grammarAccess.getStepAccess().getGenericStepParserRuleCall_5()); 

                    }


                    }
                    break;
                case 7 :
                    // InternalMyDsl.g:764:2: ( ruleJoin )
                    {
                    // InternalMyDsl.g:764:2: ( ruleJoin )
                    // InternalMyDsl.g:765:3: ruleJoin
                    {
                     before(grammarAccess.getStepAccess().getJoinParserRuleCall_6()); 
                    pushFollow(FOLLOW_2);
                    ruleJoin();

                    state._fsp--;

                     after(grammarAccess.getStepAccess().getJoinParserRuleCall_6()); 

                    }


                    }
                    break;
                case 8 :
                    // InternalMyDsl.g:770:2: ( ruleImport )
                    {
                    // InternalMyDsl.g:770:2: ( ruleImport )
                    // InternalMyDsl.g:771:3: ruleImport
                    {
                     before(grammarAccess.getStepAccess().getImportParserRuleCall_7()); 
                    pushFollow(FOLLOW_2);
                    ruleImport();

                    state._fsp--;

                     after(grammarAccess.getStepAccess().getImportParserRuleCall_7()); 

                    }


                    }
                    break;
                case 9 :
                    // InternalMyDsl.g:776:2: ( ruleLookup )
                    {
                    // InternalMyDsl.g:776:2: ( ruleLookup )
                    // InternalMyDsl.g:777:3: ruleLookup
                    {
                     before(grammarAccess.getStepAccess().getLookupParserRuleCall_8()); 
                    pushFollow(FOLLOW_2);
                    ruleLookup();

                    state._fsp--;

                     after(grammarAccess.getStepAccess().getLookupParserRuleCall_8()); 

                    }


                    }
                    break;
                case 10 :
                    // InternalMyDsl.g:782:2: ( ruleRemoveDuplicates )
                    {
                    // InternalMyDsl.g:782:2: ( ruleRemoveDuplicates )
                    // InternalMyDsl.g:783:3: ruleRemoveDuplicates
                    {
                     before(grammarAccess.getStepAccess().getRemoveDuplicatesParserRuleCall_9()); 
                    pushFollow(FOLLOW_2);
                    ruleRemoveDuplicates();

                    state._fsp--;

                     after(grammarAccess.getStepAccess().getRemoveDuplicatesParserRuleCall_9()); 

                    }


                    }
                    break;
                case 11 :
                    // InternalMyDsl.g:788:2: ( ruleConcat )
                    {
                    // InternalMyDsl.g:788:2: ( ruleConcat )
                    // InternalMyDsl.g:789:3: ruleConcat
                    {
                     before(grammarAccess.getStepAccess().getConcatParserRuleCall_10()); 
                    pushFollow(FOLLOW_2);
                    ruleConcat();

                    state._fsp--;

                     after(grammarAccess.getStepAccess().getConcatParserRuleCall_10()); 

                    }


                    }
                    break;
                case 12 :
                    // InternalMyDsl.g:794:2: ( ruleSplit )
                    {
                    // InternalMyDsl.g:794:2: ( ruleSplit )
                    // InternalMyDsl.g:795:3: ruleSplit
                    {
                     before(grammarAccess.getStepAccess().getSplitParserRuleCall_11()); 
                    pushFollow(FOLLOW_2);
                    ruleSplit();

                    state._fsp--;

                     after(grammarAccess.getStepAccess().getSplitParserRuleCall_11()); 

                    }


                    }
                    break;
                case 13 :
                    // InternalMyDsl.g:800:2: ( ruleExtract )
                    {
                    // InternalMyDsl.g:800:2: ( ruleExtract )
                    // InternalMyDsl.g:801:3: ruleExtract
                    {
                     before(grammarAccess.getStepAccess().getExtractParserRuleCall_12()); 
                    pushFollow(FOLLOW_2);
                    ruleExtract();

                    state._fsp--;

                     after(grammarAccess.getStepAccess().getExtractParserRuleCall_12()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Step__Alternatives"


    // $ANTLR start "rule__EString__Alternatives"
    // InternalMyDsl.g:810:1: rule__EString__Alternatives : ( ( RULE_STRING ) | ( RULE_ID ) );
    public final void rule__EString__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:814:1: ( ( RULE_STRING ) | ( RULE_ID ) )
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==RULE_STRING) ) {
                alt2=1;
            }
            else if ( (LA2_0==RULE_ID) ) {
                alt2=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 2, 0, input);

                throw nvae;
            }
            switch (alt2) {
                case 1 :
                    // InternalMyDsl.g:815:2: ( RULE_STRING )
                    {
                    // InternalMyDsl.g:815:2: ( RULE_STRING )
                    // InternalMyDsl.g:816:3: RULE_STRING
                    {
                     before(grammarAccess.getEStringAccess().getSTRINGTerminalRuleCall_0()); 
                    match(input,RULE_STRING,FOLLOW_2); 
                     after(grammarAccess.getEStringAccess().getSTRINGTerminalRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalMyDsl.g:821:2: ( RULE_ID )
                    {
                    // InternalMyDsl.g:821:2: ( RULE_ID )
                    // InternalMyDsl.g:822:3: RULE_ID
                    {
                     before(grammarAccess.getEStringAccess().getIDTerminalRuleCall_1()); 
                    match(input,RULE_ID,FOLLOW_2); 
                     after(grammarAccess.getEStringAccess().getIDTerminalRuleCall_1()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EString__Alternatives"


    // $ANTLR start "rule__EBooleanObject__Alternatives"
    // InternalMyDsl.g:831:1: rule__EBooleanObject__Alternatives : ( ( 'true' ) | ( 'false' ) );
    public final void rule__EBooleanObject__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:835:1: ( ( 'true' ) | ( 'false' ) )
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==11) ) {
                alt3=1;
            }
            else if ( (LA3_0==12) ) {
                alt3=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 3, 0, input);

                throw nvae;
            }
            switch (alt3) {
                case 1 :
                    // InternalMyDsl.g:836:2: ( 'true' )
                    {
                    // InternalMyDsl.g:836:2: ( 'true' )
                    // InternalMyDsl.g:837:3: 'true'
                    {
                     before(grammarAccess.getEBooleanObjectAccess().getTrueKeyword_0()); 
                    match(input,11,FOLLOW_2); 
                     after(grammarAccess.getEBooleanObjectAccess().getTrueKeyword_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalMyDsl.g:842:2: ( 'false' )
                    {
                    // InternalMyDsl.g:842:2: ( 'false' )
                    // InternalMyDsl.g:843:3: 'false'
                    {
                     before(grammarAccess.getEBooleanObjectAccess().getFalseKeyword_1()); 
                    match(input,12,FOLLOW_2); 
                     after(grammarAccess.getEBooleanObjectAccess().getFalseKeyword_1()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EBooleanObject__Alternatives"


    // $ANTLR start "rule__DataType__Alternatives"
    // InternalMyDsl.g:852:1: rule__DataType__Alternatives : ( ( ( 'TEXT' ) ) | ( ( 'NUMBER' ) ) | ( ( 'DATE' ) ) );
    public final void rule__DataType__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:856:1: ( ( ( 'TEXT' ) ) | ( ( 'NUMBER' ) ) | ( ( 'DATE' ) ) )
            int alt4=3;
            switch ( input.LA(1) ) {
            case 13:
                {
                alt4=1;
                }
                break;
            case 14:
                {
                alt4=2;
                }
                break;
            case 15:
                {
                alt4=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 4, 0, input);

                throw nvae;
            }

            switch (alt4) {
                case 1 :
                    // InternalMyDsl.g:857:2: ( ( 'TEXT' ) )
                    {
                    // InternalMyDsl.g:857:2: ( ( 'TEXT' ) )
                    // InternalMyDsl.g:858:3: ( 'TEXT' )
                    {
                     before(grammarAccess.getDataTypeAccess().getTEXTEnumLiteralDeclaration_0()); 
                    // InternalMyDsl.g:859:3: ( 'TEXT' )
                    // InternalMyDsl.g:859:4: 'TEXT'
                    {
                    match(input,13,FOLLOW_2); 

                    }

                     after(grammarAccess.getDataTypeAccess().getTEXTEnumLiteralDeclaration_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalMyDsl.g:863:2: ( ( 'NUMBER' ) )
                    {
                    // InternalMyDsl.g:863:2: ( ( 'NUMBER' ) )
                    // InternalMyDsl.g:864:3: ( 'NUMBER' )
                    {
                     before(grammarAccess.getDataTypeAccess().getNUMBEREnumLiteralDeclaration_1()); 
                    // InternalMyDsl.g:865:3: ( 'NUMBER' )
                    // InternalMyDsl.g:865:4: 'NUMBER'
                    {
                    match(input,14,FOLLOW_2); 

                    }

                     after(grammarAccess.getDataTypeAccess().getNUMBEREnumLiteralDeclaration_1()); 

                    }


                    }
                    break;
                case 3 :
                    // InternalMyDsl.g:869:2: ( ( 'DATE' ) )
                    {
                    // InternalMyDsl.g:869:2: ( ( 'DATE' ) )
                    // InternalMyDsl.g:870:3: ( 'DATE' )
                    {
                     before(grammarAccess.getDataTypeAccess().getDATEEnumLiteralDeclaration_2()); 
                    // InternalMyDsl.g:871:3: ( 'DATE' )
                    // InternalMyDsl.g:871:4: 'DATE'
                    {
                    match(input,15,FOLLOW_2); 

                    }

                     after(grammarAccess.getDataTypeAccess().getDATEEnumLiteralDeclaration_2()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DataType__Alternatives"


    // $ANTLR start "rule__GroupOperationType__Alternatives"
    // InternalMyDsl.g:879:1: rule__GroupOperationType__Alternatives : ( ( ( 'MAX' ) ) | ( ( 'MIN' ) ) | ( ( 'COUNT' ) ) | ( ( 'SUM' ) ) | ( ( 'AVERAGE' ) ) );
    public final void rule__GroupOperationType__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:883:1: ( ( ( 'MAX' ) ) | ( ( 'MIN' ) ) | ( ( 'COUNT' ) ) | ( ( 'SUM' ) ) | ( ( 'AVERAGE' ) ) )
            int alt5=5;
            switch ( input.LA(1) ) {
            case 16:
                {
                alt5=1;
                }
                break;
            case 17:
                {
                alt5=2;
                }
                break;
            case 18:
                {
                alt5=3;
                }
                break;
            case 19:
                {
                alt5=4;
                }
                break;
            case 20:
                {
                alt5=5;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 5, 0, input);

                throw nvae;
            }

            switch (alt5) {
                case 1 :
                    // InternalMyDsl.g:884:2: ( ( 'MAX' ) )
                    {
                    // InternalMyDsl.g:884:2: ( ( 'MAX' ) )
                    // InternalMyDsl.g:885:3: ( 'MAX' )
                    {
                     before(grammarAccess.getGroupOperationTypeAccess().getMAXEnumLiteralDeclaration_0()); 
                    // InternalMyDsl.g:886:3: ( 'MAX' )
                    // InternalMyDsl.g:886:4: 'MAX'
                    {
                    match(input,16,FOLLOW_2); 

                    }

                     after(grammarAccess.getGroupOperationTypeAccess().getMAXEnumLiteralDeclaration_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalMyDsl.g:890:2: ( ( 'MIN' ) )
                    {
                    // InternalMyDsl.g:890:2: ( ( 'MIN' ) )
                    // InternalMyDsl.g:891:3: ( 'MIN' )
                    {
                     before(grammarAccess.getGroupOperationTypeAccess().getMINEnumLiteralDeclaration_1()); 
                    // InternalMyDsl.g:892:3: ( 'MIN' )
                    // InternalMyDsl.g:892:4: 'MIN'
                    {
                    match(input,17,FOLLOW_2); 

                    }

                     after(grammarAccess.getGroupOperationTypeAccess().getMINEnumLiteralDeclaration_1()); 

                    }


                    }
                    break;
                case 3 :
                    // InternalMyDsl.g:896:2: ( ( 'COUNT' ) )
                    {
                    // InternalMyDsl.g:896:2: ( ( 'COUNT' ) )
                    // InternalMyDsl.g:897:3: ( 'COUNT' )
                    {
                     before(grammarAccess.getGroupOperationTypeAccess().getCOUNTEnumLiteralDeclaration_2()); 
                    // InternalMyDsl.g:898:3: ( 'COUNT' )
                    // InternalMyDsl.g:898:4: 'COUNT'
                    {
                    match(input,18,FOLLOW_2); 

                    }

                     after(grammarAccess.getGroupOperationTypeAccess().getCOUNTEnumLiteralDeclaration_2()); 

                    }


                    }
                    break;
                case 4 :
                    // InternalMyDsl.g:902:2: ( ( 'SUM' ) )
                    {
                    // InternalMyDsl.g:902:2: ( ( 'SUM' ) )
                    // InternalMyDsl.g:903:3: ( 'SUM' )
                    {
                     before(grammarAccess.getGroupOperationTypeAccess().getSUMEnumLiteralDeclaration_3()); 
                    // InternalMyDsl.g:904:3: ( 'SUM' )
                    // InternalMyDsl.g:904:4: 'SUM'
                    {
                    match(input,19,FOLLOW_2); 

                    }

                     after(grammarAccess.getGroupOperationTypeAccess().getSUMEnumLiteralDeclaration_3()); 

                    }


                    }
                    break;
                case 5 :
                    // InternalMyDsl.g:908:2: ( ( 'AVERAGE' ) )
                    {
                    // InternalMyDsl.g:908:2: ( ( 'AVERAGE' ) )
                    // InternalMyDsl.g:909:3: ( 'AVERAGE' )
                    {
                     before(grammarAccess.getGroupOperationTypeAccess().getAVERAGEEnumLiteralDeclaration_4()); 
                    // InternalMyDsl.g:910:3: ( 'AVERAGE' )
                    // InternalMyDsl.g:910:4: 'AVERAGE'
                    {
                    match(input,20,FOLLOW_2); 

                    }

                     after(grammarAccess.getGroupOperationTypeAccess().getAVERAGEEnumLiteralDeclaration_4()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__GroupOperationType__Alternatives"


    // $ANTLR start "rule__OrderType__Alternatives"
    // InternalMyDsl.g:918:1: rule__OrderType__Alternatives : ( ( ( 'ASC' ) ) | ( ( 'DESC' ) ) );
    public final void rule__OrderType__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:922:1: ( ( ( 'ASC' ) ) | ( ( 'DESC' ) ) )
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==21) ) {
                alt6=1;
            }
            else if ( (LA6_0==22) ) {
                alt6=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 6, 0, input);

                throw nvae;
            }
            switch (alt6) {
                case 1 :
                    // InternalMyDsl.g:923:2: ( ( 'ASC' ) )
                    {
                    // InternalMyDsl.g:923:2: ( ( 'ASC' ) )
                    // InternalMyDsl.g:924:3: ( 'ASC' )
                    {
                     before(grammarAccess.getOrderTypeAccess().getASCEnumLiteralDeclaration_0()); 
                    // InternalMyDsl.g:925:3: ( 'ASC' )
                    // InternalMyDsl.g:925:4: 'ASC'
                    {
                    match(input,21,FOLLOW_2); 

                    }

                     after(grammarAccess.getOrderTypeAccess().getASCEnumLiteralDeclaration_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalMyDsl.g:929:2: ( ( 'DESC' ) )
                    {
                    // InternalMyDsl.g:929:2: ( ( 'DESC' ) )
                    // InternalMyDsl.g:930:3: ( 'DESC' )
                    {
                     before(grammarAccess.getOrderTypeAccess().getDESCEnumLiteralDeclaration_1()); 
                    // InternalMyDsl.g:931:3: ( 'DESC' )
                    // InternalMyDsl.g:931:4: 'DESC'
                    {
                    match(input,22,FOLLOW_2); 

                    }

                     after(grammarAccess.getOrderTypeAccess().getDESCEnumLiteralDeclaration_1()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__OrderType__Alternatives"


    // $ANTLR start "rule__FilterOperatorType__Alternatives"
    // InternalMyDsl.g:939:1: rule__FilterOperatorType__Alternatives : ( ( ( 'EQUALS' ) ) | ( ( 'LESS_THAN' ) ) | ( ( 'GREATER_THAN' ) ) | ( ( 'LESS_OR_EQUALS_THAN' ) ) | ( ( 'GREATER_OR_EQUALS_THAN' ) ) );
    public final void rule__FilterOperatorType__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:943:1: ( ( ( 'EQUALS' ) ) | ( ( 'LESS_THAN' ) ) | ( ( 'GREATER_THAN' ) ) | ( ( 'LESS_OR_EQUALS_THAN' ) ) | ( ( 'GREATER_OR_EQUALS_THAN' ) ) )
            int alt7=5;
            switch ( input.LA(1) ) {
            case 23:
                {
                alt7=1;
                }
                break;
            case 24:
                {
                alt7=2;
                }
                break;
            case 25:
                {
                alt7=3;
                }
                break;
            case 26:
                {
                alt7=4;
                }
                break;
            case 27:
                {
                alt7=5;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 7, 0, input);

                throw nvae;
            }

            switch (alt7) {
                case 1 :
                    // InternalMyDsl.g:944:2: ( ( 'EQUALS' ) )
                    {
                    // InternalMyDsl.g:944:2: ( ( 'EQUALS' ) )
                    // InternalMyDsl.g:945:3: ( 'EQUALS' )
                    {
                     before(grammarAccess.getFilterOperatorTypeAccess().getEQUALSEnumLiteralDeclaration_0()); 
                    // InternalMyDsl.g:946:3: ( 'EQUALS' )
                    // InternalMyDsl.g:946:4: 'EQUALS'
                    {
                    match(input,23,FOLLOW_2); 

                    }

                     after(grammarAccess.getFilterOperatorTypeAccess().getEQUALSEnumLiteralDeclaration_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalMyDsl.g:950:2: ( ( 'LESS_THAN' ) )
                    {
                    // InternalMyDsl.g:950:2: ( ( 'LESS_THAN' ) )
                    // InternalMyDsl.g:951:3: ( 'LESS_THAN' )
                    {
                     before(grammarAccess.getFilterOperatorTypeAccess().getLESS_THANEnumLiteralDeclaration_1()); 
                    // InternalMyDsl.g:952:3: ( 'LESS_THAN' )
                    // InternalMyDsl.g:952:4: 'LESS_THAN'
                    {
                    match(input,24,FOLLOW_2); 

                    }

                     after(grammarAccess.getFilterOperatorTypeAccess().getLESS_THANEnumLiteralDeclaration_1()); 

                    }


                    }
                    break;
                case 3 :
                    // InternalMyDsl.g:956:2: ( ( 'GREATER_THAN' ) )
                    {
                    // InternalMyDsl.g:956:2: ( ( 'GREATER_THAN' ) )
                    // InternalMyDsl.g:957:3: ( 'GREATER_THAN' )
                    {
                     before(grammarAccess.getFilterOperatorTypeAccess().getGREATER_THANEnumLiteralDeclaration_2()); 
                    // InternalMyDsl.g:958:3: ( 'GREATER_THAN' )
                    // InternalMyDsl.g:958:4: 'GREATER_THAN'
                    {
                    match(input,25,FOLLOW_2); 

                    }

                     after(grammarAccess.getFilterOperatorTypeAccess().getGREATER_THANEnumLiteralDeclaration_2()); 

                    }


                    }
                    break;
                case 4 :
                    // InternalMyDsl.g:962:2: ( ( 'LESS_OR_EQUALS_THAN' ) )
                    {
                    // InternalMyDsl.g:962:2: ( ( 'LESS_OR_EQUALS_THAN' ) )
                    // InternalMyDsl.g:963:3: ( 'LESS_OR_EQUALS_THAN' )
                    {
                     before(grammarAccess.getFilterOperatorTypeAccess().getLESS_OR_EQUALS_THANEnumLiteralDeclaration_3()); 
                    // InternalMyDsl.g:964:3: ( 'LESS_OR_EQUALS_THAN' )
                    // InternalMyDsl.g:964:4: 'LESS_OR_EQUALS_THAN'
                    {
                    match(input,26,FOLLOW_2); 

                    }

                     after(grammarAccess.getFilterOperatorTypeAccess().getLESS_OR_EQUALS_THANEnumLiteralDeclaration_3()); 

                    }


                    }
                    break;
                case 5 :
                    // InternalMyDsl.g:968:2: ( ( 'GREATER_OR_EQUALS_THAN' ) )
                    {
                    // InternalMyDsl.g:968:2: ( ( 'GREATER_OR_EQUALS_THAN' ) )
                    // InternalMyDsl.g:969:3: ( 'GREATER_OR_EQUALS_THAN' )
                    {
                     before(grammarAccess.getFilterOperatorTypeAccess().getGREATER_OR_EQUALS_THANEnumLiteralDeclaration_4()); 
                    // InternalMyDsl.g:970:3: ( 'GREATER_OR_EQUALS_THAN' )
                    // InternalMyDsl.g:970:4: 'GREATER_OR_EQUALS_THAN'
                    {
                    match(input,27,FOLLOW_2); 

                    }

                     after(grammarAccess.getFilterOperatorTypeAccess().getGREATER_OR_EQUALS_THANEnumLiteralDeclaration_4()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FilterOperatorType__Alternatives"


    // $ANTLR start "rule__JoinType__Alternatives"
    // InternalMyDsl.g:978:1: rule__JoinType__Alternatives : ( ( ( 'INNER' ) ) | ( ( 'OUTER' ) ) | ( ( 'LEFT' ) ) | ( ( 'RIGHT' ) ) );
    public final void rule__JoinType__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:982:1: ( ( ( 'INNER' ) ) | ( ( 'OUTER' ) ) | ( ( 'LEFT' ) ) | ( ( 'RIGHT' ) ) )
            int alt8=4;
            switch ( input.LA(1) ) {
            case 28:
                {
                alt8=1;
                }
                break;
            case 29:
                {
                alt8=2;
                }
                break;
            case 30:
                {
                alt8=3;
                }
                break;
            case 31:
                {
                alt8=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 8, 0, input);

                throw nvae;
            }

            switch (alt8) {
                case 1 :
                    // InternalMyDsl.g:983:2: ( ( 'INNER' ) )
                    {
                    // InternalMyDsl.g:983:2: ( ( 'INNER' ) )
                    // InternalMyDsl.g:984:3: ( 'INNER' )
                    {
                     before(grammarAccess.getJoinTypeAccess().getINNEREnumLiteralDeclaration_0()); 
                    // InternalMyDsl.g:985:3: ( 'INNER' )
                    // InternalMyDsl.g:985:4: 'INNER'
                    {
                    match(input,28,FOLLOW_2); 

                    }

                     after(grammarAccess.getJoinTypeAccess().getINNEREnumLiteralDeclaration_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalMyDsl.g:989:2: ( ( 'OUTER' ) )
                    {
                    // InternalMyDsl.g:989:2: ( ( 'OUTER' ) )
                    // InternalMyDsl.g:990:3: ( 'OUTER' )
                    {
                     before(grammarAccess.getJoinTypeAccess().getOUTEREnumLiteralDeclaration_1()); 
                    // InternalMyDsl.g:991:3: ( 'OUTER' )
                    // InternalMyDsl.g:991:4: 'OUTER'
                    {
                    match(input,29,FOLLOW_2); 

                    }

                     after(grammarAccess.getJoinTypeAccess().getOUTEREnumLiteralDeclaration_1()); 

                    }


                    }
                    break;
                case 3 :
                    // InternalMyDsl.g:995:2: ( ( 'LEFT' ) )
                    {
                    // InternalMyDsl.g:995:2: ( ( 'LEFT' ) )
                    // InternalMyDsl.g:996:3: ( 'LEFT' )
                    {
                     before(grammarAccess.getJoinTypeAccess().getLEFTEnumLiteralDeclaration_2()); 
                    // InternalMyDsl.g:997:3: ( 'LEFT' )
                    // InternalMyDsl.g:997:4: 'LEFT'
                    {
                    match(input,30,FOLLOW_2); 

                    }

                     after(grammarAccess.getJoinTypeAccess().getLEFTEnumLiteralDeclaration_2()); 

                    }


                    }
                    break;
                case 4 :
                    // InternalMyDsl.g:1001:2: ( ( 'RIGHT' ) )
                    {
                    // InternalMyDsl.g:1001:2: ( ( 'RIGHT' ) )
                    // InternalMyDsl.g:1002:3: ( 'RIGHT' )
                    {
                     before(grammarAccess.getJoinTypeAccess().getRIGHTEnumLiteralDeclaration_3()); 
                    // InternalMyDsl.g:1003:3: ( 'RIGHT' )
                    // InternalMyDsl.g:1003:4: 'RIGHT'
                    {
                    match(input,31,FOLLOW_2); 

                    }

                     after(grammarAccess.getJoinTypeAccess().getRIGHTEnumLiteralDeclaration_3()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__JoinType__Alternatives"


    // $ANTLR start "rule__LookupOperationType__Alternatives"
    // InternalMyDsl.g:1011:1: rule__LookupOperationType__Alternatives : ( ( ( 'NUMERIC_SUM' ) ) | ( ( 'NUMERIC_SUBTRACT' ) ) | ( ( 'NUMERIC_MULTIPLY' ) ) | ( ( 'NUMERIC_DIVIDE' ) ) | ( ( 'TEXT_CONCAT' ) ) );
    public final void rule__LookupOperationType__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:1015:1: ( ( ( 'NUMERIC_SUM' ) ) | ( ( 'NUMERIC_SUBTRACT' ) ) | ( ( 'NUMERIC_MULTIPLY' ) ) | ( ( 'NUMERIC_DIVIDE' ) ) | ( ( 'TEXT_CONCAT' ) ) )
            int alt9=5;
            switch ( input.LA(1) ) {
            case 32:
                {
                alt9=1;
                }
                break;
            case 33:
                {
                alt9=2;
                }
                break;
            case 34:
                {
                alt9=3;
                }
                break;
            case 35:
                {
                alt9=4;
                }
                break;
            case 36:
                {
                alt9=5;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 9, 0, input);

                throw nvae;
            }

            switch (alt9) {
                case 1 :
                    // InternalMyDsl.g:1016:2: ( ( 'NUMERIC_SUM' ) )
                    {
                    // InternalMyDsl.g:1016:2: ( ( 'NUMERIC_SUM' ) )
                    // InternalMyDsl.g:1017:3: ( 'NUMERIC_SUM' )
                    {
                     before(grammarAccess.getLookupOperationTypeAccess().getNUMERIC_SUMEnumLiteralDeclaration_0()); 
                    // InternalMyDsl.g:1018:3: ( 'NUMERIC_SUM' )
                    // InternalMyDsl.g:1018:4: 'NUMERIC_SUM'
                    {
                    match(input,32,FOLLOW_2); 

                    }

                     after(grammarAccess.getLookupOperationTypeAccess().getNUMERIC_SUMEnumLiteralDeclaration_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalMyDsl.g:1022:2: ( ( 'NUMERIC_SUBTRACT' ) )
                    {
                    // InternalMyDsl.g:1022:2: ( ( 'NUMERIC_SUBTRACT' ) )
                    // InternalMyDsl.g:1023:3: ( 'NUMERIC_SUBTRACT' )
                    {
                     before(grammarAccess.getLookupOperationTypeAccess().getNUMERIC_SUBTRACTEnumLiteralDeclaration_1()); 
                    // InternalMyDsl.g:1024:3: ( 'NUMERIC_SUBTRACT' )
                    // InternalMyDsl.g:1024:4: 'NUMERIC_SUBTRACT'
                    {
                    match(input,33,FOLLOW_2); 

                    }

                     after(grammarAccess.getLookupOperationTypeAccess().getNUMERIC_SUBTRACTEnumLiteralDeclaration_1()); 

                    }


                    }
                    break;
                case 3 :
                    // InternalMyDsl.g:1028:2: ( ( 'NUMERIC_MULTIPLY' ) )
                    {
                    // InternalMyDsl.g:1028:2: ( ( 'NUMERIC_MULTIPLY' ) )
                    // InternalMyDsl.g:1029:3: ( 'NUMERIC_MULTIPLY' )
                    {
                     before(grammarAccess.getLookupOperationTypeAccess().getNUMERIC_MULTIPLYEnumLiteralDeclaration_2()); 
                    // InternalMyDsl.g:1030:3: ( 'NUMERIC_MULTIPLY' )
                    // InternalMyDsl.g:1030:4: 'NUMERIC_MULTIPLY'
                    {
                    match(input,34,FOLLOW_2); 

                    }

                     after(grammarAccess.getLookupOperationTypeAccess().getNUMERIC_MULTIPLYEnumLiteralDeclaration_2()); 

                    }


                    }
                    break;
                case 4 :
                    // InternalMyDsl.g:1034:2: ( ( 'NUMERIC_DIVIDE' ) )
                    {
                    // InternalMyDsl.g:1034:2: ( ( 'NUMERIC_DIVIDE' ) )
                    // InternalMyDsl.g:1035:3: ( 'NUMERIC_DIVIDE' )
                    {
                     before(grammarAccess.getLookupOperationTypeAccess().getNUMERIC_DIVIDEEnumLiteralDeclaration_3()); 
                    // InternalMyDsl.g:1036:3: ( 'NUMERIC_DIVIDE' )
                    // InternalMyDsl.g:1036:4: 'NUMERIC_DIVIDE'
                    {
                    match(input,35,FOLLOW_2); 

                    }

                     after(grammarAccess.getLookupOperationTypeAccess().getNUMERIC_DIVIDEEnumLiteralDeclaration_3()); 

                    }


                    }
                    break;
                case 5 :
                    // InternalMyDsl.g:1040:2: ( ( 'TEXT_CONCAT' ) )
                    {
                    // InternalMyDsl.g:1040:2: ( ( 'TEXT_CONCAT' ) )
                    // InternalMyDsl.g:1041:3: ( 'TEXT_CONCAT' )
                    {
                     before(grammarAccess.getLookupOperationTypeAccess().getTEXT_CONCATEnumLiteralDeclaration_4()); 
                    // InternalMyDsl.g:1042:3: ( 'TEXT_CONCAT' )
                    // InternalMyDsl.g:1042:4: 'TEXT_CONCAT'
                    {
                    match(input,36,FOLLOW_2); 

                    }

                     after(grammarAccess.getLookupOperationTypeAccess().getTEXT_CONCATEnumLiteralDeclaration_4()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__LookupOperationType__Alternatives"


    // $ANTLR start "rule__Model__Group__0"
    // InternalMyDsl.g:1050:1: rule__Model__Group__0 : rule__Model__Group__0__Impl rule__Model__Group__1 ;
    public final void rule__Model__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:1054:1: ( rule__Model__Group__0__Impl rule__Model__Group__1 )
            // InternalMyDsl.g:1055:2: rule__Model__Group__0__Impl rule__Model__Group__1
            {
            pushFollow(FOLLOW_3);
            rule__Model__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Model__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__Group__0"


    // $ANTLR start "rule__Model__Group__0__Impl"
    // InternalMyDsl.g:1062:1: rule__Model__Group__0__Impl : ( 'Model' ) ;
    public final void rule__Model__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:1066:1: ( ( 'Model' ) )
            // InternalMyDsl.g:1067:1: ( 'Model' )
            {
            // InternalMyDsl.g:1067:1: ( 'Model' )
            // InternalMyDsl.g:1068:2: 'Model'
            {
             before(grammarAccess.getModelAccess().getModelKeyword_0()); 
            match(input,37,FOLLOW_2); 
             after(grammarAccess.getModelAccess().getModelKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__Group__0__Impl"


    // $ANTLR start "rule__Model__Group__1"
    // InternalMyDsl.g:1077:1: rule__Model__Group__1 : rule__Model__Group__1__Impl rule__Model__Group__2 ;
    public final void rule__Model__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:1081:1: ( rule__Model__Group__1__Impl rule__Model__Group__2 )
            // InternalMyDsl.g:1082:2: rule__Model__Group__1__Impl rule__Model__Group__2
            {
            pushFollow(FOLLOW_4);
            rule__Model__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Model__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__Group__1"


    // $ANTLR start "rule__Model__Group__1__Impl"
    // InternalMyDsl.g:1089:1: rule__Model__Group__1__Impl : ( ( rule__Model__NameAssignment_1 ) ) ;
    public final void rule__Model__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:1093:1: ( ( ( rule__Model__NameAssignment_1 ) ) )
            // InternalMyDsl.g:1094:1: ( ( rule__Model__NameAssignment_1 ) )
            {
            // InternalMyDsl.g:1094:1: ( ( rule__Model__NameAssignment_1 ) )
            // InternalMyDsl.g:1095:2: ( rule__Model__NameAssignment_1 )
            {
             before(grammarAccess.getModelAccess().getNameAssignment_1()); 
            // InternalMyDsl.g:1096:2: ( rule__Model__NameAssignment_1 )
            // InternalMyDsl.g:1096:3: rule__Model__NameAssignment_1
            {
            pushFollow(FOLLOW_2);
            rule__Model__NameAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getModelAccess().getNameAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__Group__1__Impl"


    // $ANTLR start "rule__Model__Group__2"
    // InternalMyDsl.g:1104:1: rule__Model__Group__2 : rule__Model__Group__2__Impl rule__Model__Group__3 ;
    public final void rule__Model__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:1108:1: ( rule__Model__Group__2__Impl rule__Model__Group__3 )
            // InternalMyDsl.g:1109:2: rule__Model__Group__2__Impl rule__Model__Group__3
            {
            pushFollow(FOLLOW_5);
            rule__Model__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Model__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__Group__2"


    // $ANTLR start "rule__Model__Group__2__Impl"
    // InternalMyDsl.g:1116:1: rule__Model__Group__2__Impl : ( '{' ) ;
    public final void rule__Model__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:1120:1: ( ( '{' ) )
            // InternalMyDsl.g:1121:1: ( '{' )
            {
            // InternalMyDsl.g:1121:1: ( '{' )
            // InternalMyDsl.g:1122:2: '{'
            {
             before(grammarAccess.getModelAccess().getLeftCurlyBracketKeyword_2()); 
            match(input,38,FOLLOW_2); 
             after(grammarAccess.getModelAccess().getLeftCurlyBracketKeyword_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__Group__2__Impl"


    // $ANTLR start "rule__Model__Group__3"
    // InternalMyDsl.g:1131:1: rule__Model__Group__3 : rule__Model__Group__3__Impl rule__Model__Group__4 ;
    public final void rule__Model__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:1135:1: ( rule__Model__Group__3__Impl rule__Model__Group__4 )
            // InternalMyDsl.g:1136:2: rule__Model__Group__3__Impl rule__Model__Group__4
            {
            pushFollow(FOLLOW_6);
            rule__Model__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Model__Group__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__Group__3"


    // $ANTLR start "rule__Model__Group__3__Impl"
    // InternalMyDsl.g:1143:1: rule__Model__Group__3__Impl : ( 'logs' ) ;
    public final void rule__Model__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:1147:1: ( ( 'logs' ) )
            // InternalMyDsl.g:1148:1: ( 'logs' )
            {
            // InternalMyDsl.g:1148:1: ( 'logs' )
            // InternalMyDsl.g:1149:2: 'logs'
            {
             before(grammarAccess.getModelAccess().getLogsKeyword_3()); 
            match(input,39,FOLLOW_2); 
             after(grammarAccess.getModelAccess().getLogsKeyword_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__Group__3__Impl"


    // $ANTLR start "rule__Model__Group__4"
    // InternalMyDsl.g:1158:1: rule__Model__Group__4 : rule__Model__Group__4__Impl rule__Model__Group__5 ;
    public final void rule__Model__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:1162:1: ( rule__Model__Group__4__Impl rule__Model__Group__5 )
            // InternalMyDsl.g:1163:2: rule__Model__Group__4__Impl rule__Model__Group__5
            {
            pushFollow(FOLLOW_7);
            rule__Model__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Model__Group__5();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__Group__4"


    // $ANTLR start "rule__Model__Group__4__Impl"
    // InternalMyDsl.g:1170:1: rule__Model__Group__4__Impl : ( ( rule__Model__LogsAssignment_4 ) ) ;
    public final void rule__Model__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:1174:1: ( ( ( rule__Model__LogsAssignment_4 ) ) )
            // InternalMyDsl.g:1175:1: ( ( rule__Model__LogsAssignment_4 ) )
            {
            // InternalMyDsl.g:1175:1: ( ( rule__Model__LogsAssignment_4 ) )
            // InternalMyDsl.g:1176:2: ( rule__Model__LogsAssignment_4 )
            {
             before(grammarAccess.getModelAccess().getLogsAssignment_4()); 
            // InternalMyDsl.g:1177:2: ( rule__Model__LogsAssignment_4 )
            // InternalMyDsl.g:1177:3: rule__Model__LogsAssignment_4
            {
            pushFollow(FOLLOW_2);
            rule__Model__LogsAssignment_4();

            state._fsp--;


            }

             after(grammarAccess.getModelAccess().getLogsAssignment_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__Group__4__Impl"


    // $ANTLR start "rule__Model__Group__5"
    // InternalMyDsl.g:1185:1: rule__Model__Group__5 : rule__Model__Group__5__Impl rule__Model__Group__6 ;
    public final void rule__Model__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:1189:1: ( rule__Model__Group__5__Impl rule__Model__Group__6 )
            // InternalMyDsl.g:1190:2: rule__Model__Group__5__Impl rule__Model__Group__6
            {
            pushFollow(FOLLOW_4);
            rule__Model__Group__5__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Model__Group__6();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__Group__5"


    // $ANTLR start "rule__Model__Group__5__Impl"
    // InternalMyDsl.g:1197:1: rule__Model__Group__5__Impl : ( 'tables' ) ;
    public final void rule__Model__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:1201:1: ( ( 'tables' ) )
            // InternalMyDsl.g:1202:1: ( 'tables' )
            {
            // InternalMyDsl.g:1202:1: ( 'tables' )
            // InternalMyDsl.g:1203:2: 'tables'
            {
             before(grammarAccess.getModelAccess().getTablesKeyword_5()); 
            match(input,40,FOLLOW_2); 
             after(grammarAccess.getModelAccess().getTablesKeyword_5()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__Group__5__Impl"


    // $ANTLR start "rule__Model__Group__6"
    // InternalMyDsl.g:1212:1: rule__Model__Group__6 : rule__Model__Group__6__Impl rule__Model__Group__7 ;
    public final void rule__Model__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:1216:1: ( rule__Model__Group__6__Impl rule__Model__Group__7 )
            // InternalMyDsl.g:1217:2: rule__Model__Group__6__Impl rule__Model__Group__7
            {
            pushFollow(FOLLOW_8);
            rule__Model__Group__6__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Model__Group__7();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__Group__6"


    // $ANTLR start "rule__Model__Group__6__Impl"
    // InternalMyDsl.g:1224:1: rule__Model__Group__6__Impl : ( '{' ) ;
    public final void rule__Model__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:1228:1: ( ( '{' ) )
            // InternalMyDsl.g:1229:1: ( '{' )
            {
            // InternalMyDsl.g:1229:1: ( '{' )
            // InternalMyDsl.g:1230:2: '{'
            {
             before(grammarAccess.getModelAccess().getLeftCurlyBracketKeyword_6()); 
            match(input,38,FOLLOW_2); 
             after(grammarAccess.getModelAccess().getLeftCurlyBracketKeyword_6()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__Group__6__Impl"


    // $ANTLR start "rule__Model__Group__7"
    // InternalMyDsl.g:1239:1: rule__Model__Group__7 : rule__Model__Group__7__Impl rule__Model__Group__8 ;
    public final void rule__Model__Group__7() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:1243:1: ( rule__Model__Group__7__Impl rule__Model__Group__8 )
            // InternalMyDsl.g:1244:2: rule__Model__Group__7__Impl rule__Model__Group__8
            {
            pushFollow(FOLLOW_9);
            rule__Model__Group__7__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Model__Group__8();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__Group__7"


    // $ANTLR start "rule__Model__Group__7__Impl"
    // InternalMyDsl.g:1251:1: rule__Model__Group__7__Impl : ( ( rule__Model__TablesAssignment_7 ) ) ;
    public final void rule__Model__Group__7__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:1255:1: ( ( ( rule__Model__TablesAssignment_7 ) ) )
            // InternalMyDsl.g:1256:1: ( ( rule__Model__TablesAssignment_7 ) )
            {
            // InternalMyDsl.g:1256:1: ( ( rule__Model__TablesAssignment_7 ) )
            // InternalMyDsl.g:1257:2: ( rule__Model__TablesAssignment_7 )
            {
             before(grammarAccess.getModelAccess().getTablesAssignment_7()); 
            // InternalMyDsl.g:1258:2: ( rule__Model__TablesAssignment_7 )
            // InternalMyDsl.g:1258:3: rule__Model__TablesAssignment_7
            {
            pushFollow(FOLLOW_2);
            rule__Model__TablesAssignment_7();

            state._fsp--;


            }

             after(grammarAccess.getModelAccess().getTablesAssignment_7()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__Group__7__Impl"


    // $ANTLR start "rule__Model__Group__8"
    // InternalMyDsl.g:1266:1: rule__Model__Group__8 : rule__Model__Group__8__Impl rule__Model__Group__9 ;
    public final void rule__Model__Group__8() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:1270:1: ( rule__Model__Group__8__Impl rule__Model__Group__9 )
            // InternalMyDsl.g:1271:2: rule__Model__Group__8__Impl rule__Model__Group__9
            {
            pushFollow(FOLLOW_9);
            rule__Model__Group__8__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Model__Group__9();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__Group__8"


    // $ANTLR start "rule__Model__Group__8__Impl"
    // InternalMyDsl.g:1278:1: rule__Model__Group__8__Impl : ( ( rule__Model__Group_8__0 )* ) ;
    public final void rule__Model__Group__8__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:1282:1: ( ( ( rule__Model__Group_8__0 )* ) )
            // InternalMyDsl.g:1283:1: ( ( rule__Model__Group_8__0 )* )
            {
            // InternalMyDsl.g:1283:1: ( ( rule__Model__Group_8__0 )* )
            // InternalMyDsl.g:1284:2: ( rule__Model__Group_8__0 )*
            {
             before(grammarAccess.getModelAccess().getGroup_8()); 
            // InternalMyDsl.g:1285:2: ( rule__Model__Group_8__0 )*
            loop10:
            do {
                int alt10=2;
                int LA10_0 = input.LA(1);

                if ( (LA10_0==43) ) {
                    alt10=1;
                }


                switch (alt10) {
            	case 1 :
            	    // InternalMyDsl.g:1285:3: rule__Model__Group_8__0
            	    {
            	    pushFollow(FOLLOW_10);
            	    rule__Model__Group_8__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop10;
                }
            } while (true);

             after(grammarAccess.getModelAccess().getGroup_8()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__Group__8__Impl"


    // $ANTLR start "rule__Model__Group__9"
    // InternalMyDsl.g:1293:1: rule__Model__Group__9 : rule__Model__Group__9__Impl rule__Model__Group__10 ;
    public final void rule__Model__Group__9() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:1297:1: ( rule__Model__Group__9__Impl rule__Model__Group__10 )
            // InternalMyDsl.g:1298:2: rule__Model__Group__9__Impl rule__Model__Group__10
            {
            pushFollow(FOLLOW_11);
            rule__Model__Group__9__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Model__Group__10();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__Group__9"


    // $ANTLR start "rule__Model__Group__9__Impl"
    // InternalMyDsl.g:1305:1: rule__Model__Group__9__Impl : ( '}' ) ;
    public final void rule__Model__Group__9__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:1309:1: ( ( '}' ) )
            // InternalMyDsl.g:1310:1: ( '}' )
            {
            // InternalMyDsl.g:1310:1: ( '}' )
            // InternalMyDsl.g:1311:2: '}'
            {
             before(grammarAccess.getModelAccess().getRightCurlyBracketKeyword_9()); 
            match(input,41,FOLLOW_2); 
             after(grammarAccess.getModelAccess().getRightCurlyBracketKeyword_9()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__Group__9__Impl"


    // $ANTLR start "rule__Model__Group__10"
    // InternalMyDsl.g:1320:1: rule__Model__Group__10 : rule__Model__Group__10__Impl rule__Model__Group__11 ;
    public final void rule__Model__Group__10() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:1324:1: ( rule__Model__Group__10__Impl rule__Model__Group__11 )
            // InternalMyDsl.g:1325:2: rule__Model__Group__10__Impl rule__Model__Group__11
            {
            pushFollow(FOLLOW_4);
            rule__Model__Group__10__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Model__Group__11();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__Group__10"


    // $ANTLR start "rule__Model__Group__10__Impl"
    // InternalMyDsl.g:1332:1: rule__Model__Group__10__Impl : ( 'steps' ) ;
    public final void rule__Model__Group__10__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:1336:1: ( ( 'steps' ) )
            // InternalMyDsl.g:1337:1: ( 'steps' )
            {
            // InternalMyDsl.g:1337:1: ( 'steps' )
            // InternalMyDsl.g:1338:2: 'steps'
            {
             before(grammarAccess.getModelAccess().getStepsKeyword_10()); 
            match(input,42,FOLLOW_2); 
             after(grammarAccess.getModelAccess().getStepsKeyword_10()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__Group__10__Impl"


    // $ANTLR start "rule__Model__Group__11"
    // InternalMyDsl.g:1347:1: rule__Model__Group__11 : rule__Model__Group__11__Impl rule__Model__Group__12 ;
    public final void rule__Model__Group__11() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:1351:1: ( rule__Model__Group__11__Impl rule__Model__Group__12 )
            // InternalMyDsl.g:1352:2: rule__Model__Group__11__Impl rule__Model__Group__12
            {
            pushFollow(FOLLOW_12);
            rule__Model__Group__11__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Model__Group__12();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__Group__11"


    // $ANTLR start "rule__Model__Group__11__Impl"
    // InternalMyDsl.g:1359:1: rule__Model__Group__11__Impl : ( '{' ) ;
    public final void rule__Model__Group__11__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:1363:1: ( ( '{' ) )
            // InternalMyDsl.g:1364:1: ( '{' )
            {
            // InternalMyDsl.g:1364:1: ( '{' )
            // InternalMyDsl.g:1365:2: '{'
            {
             before(grammarAccess.getModelAccess().getLeftCurlyBracketKeyword_11()); 
            match(input,38,FOLLOW_2); 
             after(grammarAccess.getModelAccess().getLeftCurlyBracketKeyword_11()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__Group__11__Impl"


    // $ANTLR start "rule__Model__Group__12"
    // InternalMyDsl.g:1374:1: rule__Model__Group__12 : rule__Model__Group__12__Impl rule__Model__Group__13 ;
    public final void rule__Model__Group__12() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:1378:1: ( rule__Model__Group__12__Impl rule__Model__Group__13 )
            // InternalMyDsl.g:1379:2: rule__Model__Group__12__Impl rule__Model__Group__13
            {
            pushFollow(FOLLOW_9);
            rule__Model__Group__12__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Model__Group__13();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__Group__12"


    // $ANTLR start "rule__Model__Group__12__Impl"
    // InternalMyDsl.g:1386:1: rule__Model__Group__12__Impl : ( ( rule__Model__StepsAssignment_12 ) ) ;
    public final void rule__Model__Group__12__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:1390:1: ( ( ( rule__Model__StepsAssignment_12 ) ) )
            // InternalMyDsl.g:1391:1: ( ( rule__Model__StepsAssignment_12 ) )
            {
            // InternalMyDsl.g:1391:1: ( ( rule__Model__StepsAssignment_12 ) )
            // InternalMyDsl.g:1392:2: ( rule__Model__StepsAssignment_12 )
            {
             before(grammarAccess.getModelAccess().getStepsAssignment_12()); 
            // InternalMyDsl.g:1393:2: ( rule__Model__StepsAssignment_12 )
            // InternalMyDsl.g:1393:3: rule__Model__StepsAssignment_12
            {
            pushFollow(FOLLOW_2);
            rule__Model__StepsAssignment_12();

            state._fsp--;


            }

             after(grammarAccess.getModelAccess().getStepsAssignment_12()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__Group__12__Impl"


    // $ANTLR start "rule__Model__Group__13"
    // InternalMyDsl.g:1401:1: rule__Model__Group__13 : rule__Model__Group__13__Impl rule__Model__Group__14 ;
    public final void rule__Model__Group__13() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:1405:1: ( rule__Model__Group__13__Impl rule__Model__Group__14 )
            // InternalMyDsl.g:1406:2: rule__Model__Group__13__Impl rule__Model__Group__14
            {
            pushFollow(FOLLOW_9);
            rule__Model__Group__13__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Model__Group__14();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__Group__13"


    // $ANTLR start "rule__Model__Group__13__Impl"
    // InternalMyDsl.g:1413:1: rule__Model__Group__13__Impl : ( ( rule__Model__Group_13__0 )* ) ;
    public final void rule__Model__Group__13__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:1417:1: ( ( ( rule__Model__Group_13__0 )* ) )
            // InternalMyDsl.g:1418:1: ( ( rule__Model__Group_13__0 )* )
            {
            // InternalMyDsl.g:1418:1: ( ( rule__Model__Group_13__0 )* )
            // InternalMyDsl.g:1419:2: ( rule__Model__Group_13__0 )*
            {
             before(grammarAccess.getModelAccess().getGroup_13()); 
            // InternalMyDsl.g:1420:2: ( rule__Model__Group_13__0 )*
            loop11:
            do {
                int alt11=2;
                int LA11_0 = input.LA(1);

                if ( (LA11_0==43) ) {
                    alt11=1;
                }


                switch (alt11) {
            	case 1 :
            	    // InternalMyDsl.g:1420:3: rule__Model__Group_13__0
            	    {
            	    pushFollow(FOLLOW_10);
            	    rule__Model__Group_13__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop11;
                }
            } while (true);

             after(grammarAccess.getModelAccess().getGroup_13()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__Group__13__Impl"


    // $ANTLR start "rule__Model__Group__14"
    // InternalMyDsl.g:1428:1: rule__Model__Group__14 : rule__Model__Group__14__Impl rule__Model__Group__15 ;
    public final void rule__Model__Group__14() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:1432:1: ( rule__Model__Group__14__Impl rule__Model__Group__15 )
            // InternalMyDsl.g:1433:2: rule__Model__Group__14__Impl rule__Model__Group__15
            {
            pushFollow(FOLLOW_13);
            rule__Model__Group__14__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Model__Group__15();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__Group__14"


    // $ANTLR start "rule__Model__Group__14__Impl"
    // InternalMyDsl.g:1440:1: rule__Model__Group__14__Impl : ( '}' ) ;
    public final void rule__Model__Group__14__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:1444:1: ( ( '}' ) )
            // InternalMyDsl.g:1445:1: ( '}' )
            {
            // InternalMyDsl.g:1445:1: ( '}' )
            // InternalMyDsl.g:1446:2: '}'
            {
             before(grammarAccess.getModelAccess().getRightCurlyBracketKeyword_14()); 
            match(input,41,FOLLOW_2); 
             after(grammarAccess.getModelAccess().getRightCurlyBracketKeyword_14()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__Group__14__Impl"


    // $ANTLR start "rule__Model__Group__15"
    // InternalMyDsl.g:1455:1: rule__Model__Group__15 : rule__Model__Group__15__Impl ;
    public final void rule__Model__Group__15() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:1459:1: ( rule__Model__Group__15__Impl )
            // InternalMyDsl.g:1460:2: rule__Model__Group__15__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Model__Group__15__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__Group__15"


    // $ANTLR start "rule__Model__Group__15__Impl"
    // InternalMyDsl.g:1466:1: rule__Model__Group__15__Impl : ( '}' ) ;
    public final void rule__Model__Group__15__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:1470:1: ( ( '}' ) )
            // InternalMyDsl.g:1471:1: ( '}' )
            {
            // InternalMyDsl.g:1471:1: ( '}' )
            // InternalMyDsl.g:1472:2: '}'
            {
             before(grammarAccess.getModelAccess().getRightCurlyBracketKeyword_15()); 
            match(input,41,FOLLOW_2); 
             after(grammarAccess.getModelAccess().getRightCurlyBracketKeyword_15()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__Group__15__Impl"


    // $ANTLR start "rule__Model__Group_8__0"
    // InternalMyDsl.g:1482:1: rule__Model__Group_8__0 : rule__Model__Group_8__0__Impl rule__Model__Group_8__1 ;
    public final void rule__Model__Group_8__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:1486:1: ( rule__Model__Group_8__0__Impl rule__Model__Group_8__1 )
            // InternalMyDsl.g:1487:2: rule__Model__Group_8__0__Impl rule__Model__Group_8__1
            {
            pushFollow(FOLLOW_8);
            rule__Model__Group_8__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Model__Group_8__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__Group_8__0"


    // $ANTLR start "rule__Model__Group_8__0__Impl"
    // InternalMyDsl.g:1494:1: rule__Model__Group_8__0__Impl : ( ',' ) ;
    public final void rule__Model__Group_8__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:1498:1: ( ( ',' ) )
            // InternalMyDsl.g:1499:1: ( ',' )
            {
            // InternalMyDsl.g:1499:1: ( ',' )
            // InternalMyDsl.g:1500:2: ','
            {
             before(grammarAccess.getModelAccess().getCommaKeyword_8_0()); 
            match(input,43,FOLLOW_2); 
             after(grammarAccess.getModelAccess().getCommaKeyword_8_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__Group_8__0__Impl"


    // $ANTLR start "rule__Model__Group_8__1"
    // InternalMyDsl.g:1509:1: rule__Model__Group_8__1 : rule__Model__Group_8__1__Impl ;
    public final void rule__Model__Group_8__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:1513:1: ( rule__Model__Group_8__1__Impl )
            // InternalMyDsl.g:1514:2: rule__Model__Group_8__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Model__Group_8__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__Group_8__1"


    // $ANTLR start "rule__Model__Group_8__1__Impl"
    // InternalMyDsl.g:1520:1: rule__Model__Group_8__1__Impl : ( ( rule__Model__TablesAssignment_8_1 ) ) ;
    public final void rule__Model__Group_8__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:1524:1: ( ( ( rule__Model__TablesAssignment_8_1 ) ) )
            // InternalMyDsl.g:1525:1: ( ( rule__Model__TablesAssignment_8_1 ) )
            {
            // InternalMyDsl.g:1525:1: ( ( rule__Model__TablesAssignment_8_1 ) )
            // InternalMyDsl.g:1526:2: ( rule__Model__TablesAssignment_8_1 )
            {
             before(grammarAccess.getModelAccess().getTablesAssignment_8_1()); 
            // InternalMyDsl.g:1527:2: ( rule__Model__TablesAssignment_8_1 )
            // InternalMyDsl.g:1527:3: rule__Model__TablesAssignment_8_1
            {
            pushFollow(FOLLOW_2);
            rule__Model__TablesAssignment_8_1();

            state._fsp--;


            }

             after(grammarAccess.getModelAccess().getTablesAssignment_8_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__Group_8__1__Impl"


    // $ANTLR start "rule__Model__Group_13__0"
    // InternalMyDsl.g:1536:1: rule__Model__Group_13__0 : rule__Model__Group_13__0__Impl rule__Model__Group_13__1 ;
    public final void rule__Model__Group_13__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:1540:1: ( rule__Model__Group_13__0__Impl rule__Model__Group_13__1 )
            // InternalMyDsl.g:1541:2: rule__Model__Group_13__0__Impl rule__Model__Group_13__1
            {
            pushFollow(FOLLOW_12);
            rule__Model__Group_13__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Model__Group_13__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__Group_13__0"


    // $ANTLR start "rule__Model__Group_13__0__Impl"
    // InternalMyDsl.g:1548:1: rule__Model__Group_13__0__Impl : ( ',' ) ;
    public final void rule__Model__Group_13__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:1552:1: ( ( ',' ) )
            // InternalMyDsl.g:1553:1: ( ',' )
            {
            // InternalMyDsl.g:1553:1: ( ',' )
            // InternalMyDsl.g:1554:2: ','
            {
             before(grammarAccess.getModelAccess().getCommaKeyword_13_0()); 
            match(input,43,FOLLOW_2); 
             after(grammarAccess.getModelAccess().getCommaKeyword_13_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__Group_13__0__Impl"


    // $ANTLR start "rule__Model__Group_13__1"
    // InternalMyDsl.g:1563:1: rule__Model__Group_13__1 : rule__Model__Group_13__1__Impl ;
    public final void rule__Model__Group_13__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:1567:1: ( rule__Model__Group_13__1__Impl )
            // InternalMyDsl.g:1568:2: rule__Model__Group_13__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Model__Group_13__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__Group_13__1"


    // $ANTLR start "rule__Model__Group_13__1__Impl"
    // InternalMyDsl.g:1574:1: rule__Model__Group_13__1__Impl : ( ( rule__Model__StepsAssignment_13_1 ) ) ;
    public final void rule__Model__Group_13__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:1578:1: ( ( ( rule__Model__StepsAssignment_13_1 ) ) )
            // InternalMyDsl.g:1579:1: ( ( rule__Model__StepsAssignment_13_1 ) )
            {
            // InternalMyDsl.g:1579:1: ( ( rule__Model__StepsAssignment_13_1 ) )
            // InternalMyDsl.g:1580:2: ( rule__Model__StepsAssignment_13_1 )
            {
             before(grammarAccess.getModelAccess().getStepsAssignment_13_1()); 
            // InternalMyDsl.g:1581:2: ( rule__Model__StepsAssignment_13_1 )
            // InternalMyDsl.g:1581:3: rule__Model__StepsAssignment_13_1
            {
            pushFollow(FOLLOW_2);
            rule__Model__StepsAssignment_13_1();

            state._fsp--;


            }

             after(grammarAccess.getModelAccess().getStepsAssignment_13_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__Group_13__1__Impl"


    // $ANTLR start "rule__Table__Group__0"
    // InternalMyDsl.g:1590:1: rule__Table__Group__0 : rule__Table__Group__0__Impl rule__Table__Group__1 ;
    public final void rule__Table__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:1594:1: ( rule__Table__Group__0__Impl rule__Table__Group__1 )
            // InternalMyDsl.g:1595:2: rule__Table__Group__0__Impl rule__Table__Group__1
            {
            pushFollow(FOLLOW_3);
            rule__Table__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Table__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Table__Group__0"


    // $ANTLR start "rule__Table__Group__0__Impl"
    // InternalMyDsl.g:1602:1: rule__Table__Group__0__Impl : ( 'Table' ) ;
    public final void rule__Table__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:1606:1: ( ( 'Table' ) )
            // InternalMyDsl.g:1607:1: ( 'Table' )
            {
            // InternalMyDsl.g:1607:1: ( 'Table' )
            // InternalMyDsl.g:1608:2: 'Table'
            {
             before(grammarAccess.getTableAccess().getTableKeyword_0()); 
            match(input,44,FOLLOW_2); 
             after(grammarAccess.getTableAccess().getTableKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Table__Group__0__Impl"


    // $ANTLR start "rule__Table__Group__1"
    // InternalMyDsl.g:1617:1: rule__Table__Group__1 : rule__Table__Group__1__Impl rule__Table__Group__2 ;
    public final void rule__Table__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:1621:1: ( rule__Table__Group__1__Impl rule__Table__Group__2 )
            // InternalMyDsl.g:1622:2: rule__Table__Group__1__Impl rule__Table__Group__2
            {
            pushFollow(FOLLOW_4);
            rule__Table__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Table__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Table__Group__1"


    // $ANTLR start "rule__Table__Group__1__Impl"
    // InternalMyDsl.g:1629:1: rule__Table__Group__1__Impl : ( ( rule__Table__NameAssignment_1 ) ) ;
    public final void rule__Table__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:1633:1: ( ( ( rule__Table__NameAssignment_1 ) ) )
            // InternalMyDsl.g:1634:1: ( ( rule__Table__NameAssignment_1 ) )
            {
            // InternalMyDsl.g:1634:1: ( ( rule__Table__NameAssignment_1 ) )
            // InternalMyDsl.g:1635:2: ( rule__Table__NameAssignment_1 )
            {
             before(grammarAccess.getTableAccess().getNameAssignment_1()); 
            // InternalMyDsl.g:1636:2: ( rule__Table__NameAssignment_1 )
            // InternalMyDsl.g:1636:3: rule__Table__NameAssignment_1
            {
            pushFollow(FOLLOW_2);
            rule__Table__NameAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getTableAccess().getNameAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Table__Group__1__Impl"


    // $ANTLR start "rule__Table__Group__2"
    // InternalMyDsl.g:1644:1: rule__Table__Group__2 : rule__Table__Group__2__Impl rule__Table__Group__3 ;
    public final void rule__Table__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:1648:1: ( rule__Table__Group__2__Impl rule__Table__Group__3 )
            // InternalMyDsl.g:1649:2: rule__Table__Group__2__Impl rule__Table__Group__3
            {
            pushFollow(FOLLOW_14);
            rule__Table__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Table__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Table__Group__2"


    // $ANTLR start "rule__Table__Group__2__Impl"
    // InternalMyDsl.g:1656:1: rule__Table__Group__2__Impl : ( '{' ) ;
    public final void rule__Table__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:1660:1: ( ( '{' ) )
            // InternalMyDsl.g:1661:1: ( '{' )
            {
            // InternalMyDsl.g:1661:1: ( '{' )
            // InternalMyDsl.g:1662:2: '{'
            {
             before(grammarAccess.getTableAccess().getLeftCurlyBracketKeyword_2()); 
            match(input,38,FOLLOW_2); 
             after(grammarAccess.getTableAccess().getLeftCurlyBracketKeyword_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Table__Group__2__Impl"


    // $ANTLR start "rule__Table__Group__3"
    // InternalMyDsl.g:1671:1: rule__Table__Group__3 : rule__Table__Group__3__Impl rule__Table__Group__4 ;
    public final void rule__Table__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:1675:1: ( rule__Table__Group__3__Impl rule__Table__Group__4 )
            // InternalMyDsl.g:1676:2: rule__Table__Group__3__Impl rule__Table__Group__4
            {
            pushFollow(FOLLOW_4);
            rule__Table__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Table__Group__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Table__Group__3"


    // $ANTLR start "rule__Table__Group__3__Impl"
    // InternalMyDsl.g:1683:1: rule__Table__Group__3__Impl : ( 'columns' ) ;
    public final void rule__Table__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:1687:1: ( ( 'columns' ) )
            // InternalMyDsl.g:1688:1: ( 'columns' )
            {
            // InternalMyDsl.g:1688:1: ( 'columns' )
            // InternalMyDsl.g:1689:2: 'columns'
            {
             before(grammarAccess.getTableAccess().getColumnsKeyword_3()); 
            match(input,45,FOLLOW_2); 
             after(grammarAccess.getTableAccess().getColumnsKeyword_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Table__Group__3__Impl"


    // $ANTLR start "rule__Table__Group__4"
    // InternalMyDsl.g:1698:1: rule__Table__Group__4 : rule__Table__Group__4__Impl rule__Table__Group__5 ;
    public final void rule__Table__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:1702:1: ( rule__Table__Group__4__Impl rule__Table__Group__5 )
            // InternalMyDsl.g:1703:2: rule__Table__Group__4__Impl rule__Table__Group__5
            {
            pushFollow(FOLLOW_15);
            rule__Table__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Table__Group__5();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Table__Group__4"


    // $ANTLR start "rule__Table__Group__4__Impl"
    // InternalMyDsl.g:1710:1: rule__Table__Group__4__Impl : ( '{' ) ;
    public final void rule__Table__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:1714:1: ( ( '{' ) )
            // InternalMyDsl.g:1715:1: ( '{' )
            {
            // InternalMyDsl.g:1715:1: ( '{' )
            // InternalMyDsl.g:1716:2: '{'
            {
             before(grammarAccess.getTableAccess().getLeftCurlyBracketKeyword_4()); 
            match(input,38,FOLLOW_2); 
             after(grammarAccess.getTableAccess().getLeftCurlyBracketKeyword_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Table__Group__4__Impl"


    // $ANTLR start "rule__Table__Group__5"
    // InternalMyDsl.g:1725:1: rule__Table__Group__5 : rule__Table__Group__5__Impl rule__Table__Group__6 ;
    public final void rule__Table__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:1729:1: ( rule__Table__Group__5__Impl rule__Table__Group__6 )
            // InternalMyDsl.g:1730:2: rule__Table__Group__5__Impl rule__Table__Group__6
            {
            pushFollow(FOLLOW_9);
            rule__Table__Group__5__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Table__Group__6();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Table__Group__5"


    // $ANTLR start "rule__Table__Group__5__Impl"
    // InternalMyDsl.g:1737:1: rule__Table__Group__5__Impl : ( ( rule__Table__ColumnsAssignment_5 ) ) ;
    public final void rule__Table__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:1741:1: ( ( ( rule__Table__ColumnsAssignment_5 ) ) )
            // InternalMyDsl.g:1742:1: ( ( rule__Table__ColumnsAssignment_5 ) )
            {
            // InternalMyDsl.g:1742:1: ( ( rule__Table__ColumnsAssignment_5 ) )
            // InternalMyDsl.g:1743:2: ( rule__Table__ColumnsAssignment_5 )
            {
             before(grammarAccess.getTableAccess().getColumnsAssignment_5()); 
            // InternalMyDsl.g:1744:2: ( rule__Table__ColumnsAssignment_5 )
            // InternalMyDsl.g:1744:3: rule__Table__ColumnsAssignment_5
            {
            pushFollow(FOLLOW_2);
            rule__Table__ColumnsAssignment_5();

            state._fsp--;


            }

             after(grammarAccess.getTableAccess().getColumnsAssignment_5()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Table__Group__5__Impl"


    // $ANTLR start "rule__Table__Group__6"
    // InternalMyDsl.g:1752:1: rule__Table__Group__6 : rule__Table__Group__6__Impl rule__Table__Group__7 ;
    public final void rule__Table__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:1756:1: ( rule__Table__Group__6__Impl rule__Table__Group__7 )
            // InternalMyDsl.g:1757:2: rule__Table__Group__6__Impl rule__Table__Group__7
            {
            pushFollow(FOLLOW_9);
            rule__Table__Group__6__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Table__Group__7();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Table__Group__6"


    // $ANTLR start "rule__Table__Group__6__Impl"
    // InternalMyDsl.g:1764:1: rule__Table__Group__6__Impl : ( ( rule__Table__Group_6__0 )* ) ;
    public final void rule__Table__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:1768:1: ( ( ( rule__Table__Group_6__0 )* ) )
            // InternalMyDsl.g:1769:1: ( ( rule__Table__Group_6__0 )* )
            {
            // InternalMyDsl.g:1769:1: ( ( rule__Table__Group_6__0 )* )
            // InternalMyDsl.g:1770:2: ( rule__Table__Group_6__0 )*
            {
             before(grammarAccess.getTableAccess().getGroup_6()); 
            // InternalMyDsl.g:1771:2: ( rule__Table__Group_6__0 )*
            loop12:
            do {
                int alt12=2;
                int LA12_0 = input.LA(1);

                if ( (LA12_0==43) ) {
                    alt12=1;
                }


                switch (alt12) {
            	case 1 :
            	    // InternalMyDsl.g:1771:3: rule__Table__Group_6__0
            	    {
            	    pushFollow(FOLLOW_10);
            	    rule__Table__Group_6__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop12;
                }
            } while (true);

             after(grammarAccess.getTableAccess().getGroup_6()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Table__Group__6__Impl"


    // $ANTLR start "rule__Table__Group__7"
    // InternalMyDsl.g:1779:1: rule__Table__Group__7 : rule__Table__Group__7__Impl rule__Table__Group__8 ;
    public final void rule__Table__Group__7() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:1783:1: ( rule__Table__Group__7__Impl rule__Table__Group__8 )
            // InternalMyDsl.g:1784:2: rule__Table__Group__7__Impl rule__Table__Group__8
            {
            pushFollow(FOLLOW_13);
            rule__Table__Group__7__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Table__Group__8();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Table__Group__7"


    // $ANTLR start "rule__Table__Group__7__Impl"
    // InternalMyDsl.g:1791:1: rule__Table__Group__7__Impl : ( '}' ) ;
    public final void rule__Table__Group__7__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:1795:1: ( ( '}' ) )
            // InternalMyDsl.g:1796:1: ( '}' )
            {
            // InternalMyDsl.g:1796:1: ( '}' )
            // InternalMyDsl.g:1797:2: '}'
            {
             before(grammarAccess.getTableAccess().getRightCurlyBracketKeyword_7()); 
            match(input,41,FOLLOW_2); 
             after(grammarAccess.getTableAccess().getRightCurlyBracketKeyword_7()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Table__Group__7__Impl"


    // $ANTLR start "rule__Table__Group__8"
    // InternalMyDsl.g:1806:1: rule__Table__Group__8 : rule__Table__Group__8__Impl ;
    public final void rule__Table__Group__8() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:1810:1: ( rule__Table__Group__8__Impl )
            // InternalMyDsl.g:1811:2: rule__Table__Group__8__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Table__Group__8__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Table__Group__8"


    // $ANTLR start "rule__Table__Group__8__Impl"
    // InternalMyDsl.g:1817:1: rule__Table__Group__8__Impl : ( '}' ) ;
    public final void rule__Table__Group__8__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:1821:1: ( ( '}' ) )
            // InternalMyDsl.g:1822:1: ( '}' )
            {
            // InternalMyDsl.g:1822:1: ( '}' )
            // InternalMyDsl.g:1823:2: '}'
            {
             before(grammarAccess.getTableAccess().getRightCurlyBracketKeyword_8()); 
            match(input,41,FOLLOW_2); 
             after(grammarAccess.getTableAccess().getRightCurlyBracketKeyword_8()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Table__Group__8__Impl"


    // $ANTLR start "rule__Table__Group_6__0"
    // InternalMyDsl.g:1833:1: rule__Table__Group_6__0 : rule__Table__Group_6__0__Impl rule__Table__Group_6__1 ;
    public final void rule__Table__Group_6__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:1837:1: ( rule__Table__Group_6__0__Impl rule__Table__Group_6__1 )
            // InternalMyDsl.g:1838:2: rule__Table__Group_6__0__Impl rule__Table__Group_6__1
            {
            pushFollow(FOLLOW_15);
            rule__Table__Group_6__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Table__Group_6__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Table__Group_6__0"


    // $ANTLR start "rule__Table__Group_6__0__Impl"
    // InternalMyDsl.g:1845:1: rule__Table__Group_6__0__Impl : ( ',' ) ;
    public final void rule__Table__Group_6__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:1849:1: ( ( ',' ) )
            // InternalMyDsl.g:1850:1: ( ',' )
            {
            // InternalMyDsl.g:1850:1: ( ',' )
            // InternalMyDsl.g:1851:2: ','
            {
             before(grammarAccess.getTableAccess().getCommaKeyword_6_0()); 
            match(input,43,FOLLOW_2); 
             after(grammarAccess.getTableAccess().getCommaKeyword_6_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Table__Group_6__0__Impl"


    // $ANTLR start "rule__Table__Group_6__1"
    // InternalMyDsl.g:1860:1: rule__Table__Group_6__1 : rule__Table__Group_6__1__Impl ;
    public final void rule__Table__Group_6__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:1864:1: ( rule__Table__Group_6__1__Impl )
            // InternalMyDsl.g:1865:2: rule__Table__Group_6__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Table__Group_6__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Table__Group_6__1"


    // $ANTLR start "rule__Table__Group_6__1__Impl"
    // InternalMyDsl.g:1871:1: rule__Table__Group_6__1__Impl : ( ( rule__Table__ColumnsAssignment_6_1 ) ) ;
    public final void rule__Table__Group_6__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:1875:1: ( ( ( rule__Table__ColumnsAssignment_6_1 ) ) )
            // InternalMyDsl.g:1876:1: ( ( rule__Table__ColumnsAssignment_6_1 ) )
            {
            // InternalMyDsl.g:1876:1: ( ( rule__Table__ColumnsAssignment_6_1 ) )
            // InternalMyDsl.g:1877:2: ( rule__Table__ColumnsAssignment_6_1 )
            {
             before(grammarAccess.getTableAccess().getColumnsAssignment_6_1()); 
            // InternalMyDsl.g:1878:2: ( rule__Table__ColumnsAssignment_6_1 )
            // InternalMyDsl.g:1878:3: rule__Table__ColumnsAssignment_6_1
            {
            pushFollow(FOLLOW_2);
            rule__Table__ColumnsAssignment_6_1();

            state._fsp--;


            }

             after(grammarAccess.getTableAccess().getColumnsAssignment_6_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Table__Group_6__1__Impl"


    // $ANTLR start "rule__Column__Group__0"
    // InternalMyDsl.g:1887:1: rule__Column__Group__0 : rule__Column__Group__0__Impl rule__Column__Group__1 ;
    public final void rule__Column__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:1891:1: ( rule__Column__Group__0__Impl rule__Column__Group__1 )
            // InternalMyDsl.g:1892:2: rule__Column__Group__0__Impl rule__Column__Group__1
            {
            pushFollow(FOLLOW_3);
            rule__Column__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Column__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Column__Group__0"


    // $ANTLR start "rule__Column__Group__0__Impl"
    // InternalMyDsl.g:1899:1: rule__Column__Group__0__Impl : ( 'Column' ) ;
    public final void rule__Column__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:1903:1: ( ( 'Column' ) )
            // InternalMyDsl.g:1904:1: ( 'Column' )
            {
            // InternalMyDsl.g:1904:1: ( 'Column' )
            // InternalMyDsl.g:1905:2: 'Column'
            {
             before(grammarAccess.getColumnAccess().getColumnKeyword_0()); 
            match(input,46,FOLLOW_2); 
             after(grammarAccess.getColumnAccess().getColumnKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Column__Group__0__Impl"


    // $ANTLR start "rule__Column__Group__1"
    // InternalMyDsl.g:1914:1: rule__Column__Group__1 : rule__Column__Group__1__Impl rule__Column__Group__2 ;
    public final void rule__Column__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:1918:1: ( rule__Column__Group__1__Impl rule__Column__Group__2 )
            // InternalMyDsl.g:1919:2: rule__Column__Group__1__Impl rule__Column__Group__2
            {
            pushFollow(FOLLOW_4);
            rule__Column__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Column__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Column__Group__1"


    // $ANTLR start "rule__Column__Group__1__Impl"
    // InternalMyDsl.g:1926:1: rule__Column__Group__1__Impl : ( ( rule__Column__NameAssignment_1 ) ) ;
    public final void rule__Column__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:1930:1: ( ( ( rule__Column__NameAssignment_1 ) ) )
            // InternalMyDsl.g:1931:1: ( ( rule__Column__NameAssignment_1 ) )
            {
            // InternalMyDsl.g:1931:1: ( ( rule__Column__NameAssignment_1 ) )
            // InternalMyDsl.g:1932:2: ( rule__Column__NameAssignment_1 )
            {
             before(grammarAccess.getColumnAccess().getNameAssignment_1()); 
            // InternalMyDsl.g:1933:2: ( rule__Column__NameAssignment_1 )
            // InternalMyDsl.g:1933:3: rule__Column__NameAssignment_1
            {
            pushFollow(FOLLOW_2);
            rule__Column__NameAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getColumnAccess().getNameAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Column__Group__1__Impl"


    // $ANTLR start "rule__Column__Group__2"
    // InternalMyDsl.g:1941:1: rule__Column__Group__2 : rule__Column__Group__2__Impl rule__Column__Group__3 ;
    public final void rule__Column__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:1945:1: ( rule__Column__Group__2__Impl rule__Column__Group__3 )
            // InternalMyDsl.g:1946:2: rule__Column__Group__2__Impl rule__Column__Group__3
            {
            pushFollow(FOLLOW_16);
            rule__Column__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Column__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Column__Group__2"


    // $ANTLR start "rule__Column__Group__2__Impl"
    // InternalMyDsl.g:1953:1: rule__Column__Group__2__Impl : ( '{' ) ;
    public final void rule__Column__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:1957:1: ( ( '{' ) )
            // InternalMyDsl.g:1958:1: ( '{' )
            {
            // InternalMyDsl.g:1958:1: ( '{' )
            // InternalMyDsl.g:1959:2: '{'
            {
             before(grammarAccess.getColumnAccess().getLeftCurlyBracketKeyword_2()); 
            match(input,38,FOLLOW_2); 
             after(grammarAccess.getColumnAccess().getLeftCurlyBracketKeyword_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Column__Group__2__Impl"


    // $ANTLR start "rule__Column__Group__3"
    // InternalMyDsl.g:1968:1: rule__Column__Group__3 : rule__Column__Group__3__Impl rule__Column__Group__4 ;
    public final void rule__Column__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:1972:1: ( rule__Column__Group__3__Impl rule__Column__Group__4 )
            // InternalMyDsl.g:1973:2: rule__Column__Group__3__Impl rule__Column__Group__4
            {
            pushFollow(FOLLOW_17);
            rule__Column__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Column__Group__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Column__Group__3"


    // $ANTLR start "rule__Column__Group__3__Impl"
    // InternalMyDsl.g:1980:1: rule__Column__Group__3__Impl : ( 'dataType' ) ;
    public final void rule__Column__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:1984:1: ( ( 'dataType' ) )
            // InternalMyDsl.g:1985:1: ( 'dataType' )
            {
            // InternalMyDsl.g:1985:1: ( 'dataType' )
            // InternalMyDsl.g:1986:2: 'dataType'
            {
             before(grammarAccess.getColumnAccess().getDataTypeKeyword_3()); 
            match(input,47,FOLLOW_2); 
             after(grammarAccess.getColumnAccess().getDataTypeKeyword_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Column__Group__3__Impl"


    // $ANTLR start "rule__Column__Group__4"
    // InternalMyDsl.g:1995:1: rule__Column__Group__4 : rule__Column__Group__4__Impl rule__Column__Group__5 ;
    public final void rule__Column__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:1999:1: ( rule__Column__Group__4__Impl rule__Column__Group__5 )
            // InternalMyDsl.g:2000:2: rule__Column__Group__4__Impl rule__Column__Group__5
            {
            pushFollow(FOLLOW_13);
            rule__Column__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Column__Group__5();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Column__Group__4"


    // $ANTLR start "rule__Column__Group__4__Impl"
    // InternalMyDsl.g:2007:1: rule__Column__Group__4__Impl : ( ( rule__Column__DataTypeAssignment_4 ) ) ;
    public final void rule__Column__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:2011:1: ( ( ( rule__Column__DataTypeAssignment_4 ) ) )
            // InternalMyDsl.g:2012:1: ( ( rule__Column__DataTypeAssignment_4 ) )
            {
            // InternalMyDsl.g:2012:1: ( ( rule__Column__DataTypeAssignment_4 ) )
            // InternalMyDsl.g:2013:2: ( rule__Column__DataTypeAssignment_4 )
            {
             before(grammarAccess.getColumnAccess().getDataTypeAssignment_4()); 
            // InternalMyDsl.g:2014:2: ( rule__Column__DataTypeAssignment_4 )
            // InternalMyDsl.g:2014:3: rule__Column__DataTypeAssignment_4
            {
            pushFollow(FOLLOW_2);
            rule__Column__DataTypeAssignment_4();

            state._fsp--;


            }

             after(grammarAccess.getColumnAccess().getDataTypeAssignment_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Column__Group__4__Impl"


    // $ANTLR start "rule__Column__Group__5"
    // InternalMyDsl.g:2022:1: rule__Column__Group__5 : rule__Column__Group__5__Impl ;
    public final void rule__Column__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:2026:1: ( rule__Column__Group__5__Impl )
            // InternalMyDsl.g:2027:2: rule__Column__Group__5__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Column__Group__5__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Column__Group__5"


    // $ANTLR start "rule__Column__Group__5__Impl"
    // InternalMyDsl.g:2033:1: rule__Column__Group__5__Impl : ( '}' ) ;
    public final void rule__Column__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:2037:1: ( ( '}' ) )
            // InternalMyDsl.g:2038:1: ( '}' )
            {
            // InternalMyDsl.g:2038:1: ( '}' )
            // InternalMyDsl.g:2039:2: '}'
            {
             before(grammarAccess.getColumnAccess().getRightCurlyBracketKeyword_5()); 
            match(input,41,FOLLOW_2); 
             after(grammarAccess.getColumnAccess().getRightCurlyBracketKeyword_5()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Column__Group__5__Impl"


    // $ANTLR start "rule__Save__Group__0"
    // InternalMyDsl.g:2049:1: rule__Save__Group__0 : rule__Save__Group__0__Impl rule__Save__Group__1 ;
    public final void rule__Save__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:2053:1: ( rule__Save__Group__0__Impl rule__Save__Group__1 )
            // InternalMyDsl.g:2054:2: rule__Save__Group__0__Impl rule__Save__Group__1
            {
            pushFollow(FOLLOW_3);
            rule__Save__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Save__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Save__Group__0"


    // $ANTLR start "rule__Save__Group__0__Impl"
    // InternalMyDsl.g:2061:1: rule__Save__Group__0__Impl : ( 'Save' ) ;
    public final void rule__Save__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:2065:1: ( ( 'Save' ) )
            // InternalMyDsl.g:2066:1: ( 'Save' )
            {
            // InternalMyDsl.g:2066:1: ( 'Save' )
            // InternalMyDsl.g:2067:2: 'Save'
            {
             before(grammarAccess.getSaveAccess().getSaveKeyword_0()); 
            match(input,48,FOLLOW_2); 
             after(grammarAccess.getSaveAccess().getSaveKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Save__Group__0__Impl"


    // $ANTLR start "rule__Save__Group__1"
    // InternalMyDsl.g:2076:1: rule__Save__Group__1 : rule__Save__Group__1__Impl rule__Save__Group__2 ;
    public final void rule__Save__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:2080:1: ( rule__Save__Group__1__Impl rule__Save__Group__2 )
            // InternalMyDsl.g:2081:2: rule__Save__Group__1__Impl rule__Save__Group__2
            {
            pushFollow(FOLLOW_4);
            rule__Save__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Save__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Save__Group__1"


    // $ANTLR start "rule__Save__Group__1__Impl"
    // InternalMyDsl.g:2088:1: rule__Save__Group__1__Impl : ( ( rule__Save__NameAssignment_1 ) ) ;
    public final void rule__Save__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:2092:1: ( ( ( rule__Save__NameAssignment_1 ) ) )
            // InternalMyDsl.g:2093:1: ( ( rule__Save__NameAssignment_1 ) )
            {
            // InternalMyDsl.g:2093:1: ( ( rule__Save__NameAssignment_1 ) )
            // InternalMyDsl.g:2094:2: ( rule__Save__NameAssignment_1 )
            {
             before(grammarAccess.getSaveAccess().getNameAssignment_1()); 
            // InternalMyDsl.g:2095:2: ( rule__Save__NameAssignment_1 )
            // InternalMyDsl.g:2095:3: rule__Save__NameAssignment_1
            {
            pushFollow(FOLLOW_2);
            rule__Save__NameAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getSaveAccess().getNameAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Save__Group__1__Impl"


    // $ANTLR start "rule__Save__Group__2"
    // InternalMyDsl.g:2103:1: rule__Save__Group__2 : rule__Save__Group__2__Impl rule__Save__Group__3 ;
    public final void rule__Save__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:2107:1: ( rule__Save__Group__2__Impl rule__Save__Group__3 )
            // InternalMyDsl.g:2108:2: rule__Save__Group__2__Impl rule__Save__Group__3
            {
            pushFollow(FOLLOW_18);
            rule__Save__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Save__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Save__Group__2"


    // $ANTLR start "rule__Save__Group__2__Impl"
    // InternalMyDsl.g:2115:1: rule__Save__Group__2__Impl : ( '{' ) ;
    public final void rule__Save__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:2119:1: ( ( '{' ) )
            // InternalMyDsl.g:2120:1: ( '{' )
            {
            // InternalMyDsl.g:2120:1: ( '{' )
            // InternalMyDsl.g:2121:2: '{'
            {
             before(grammarAccess.getSaveAccess().getLeftCurlyBracketKeyword_2()); 
            match(input,38,FOLLOW_2); 
             after(grammarAccess.getSaveAccess().getLeftCurlyBracketKeyword_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Save__Group__2__Impl"


    // $ANTLR start "rule__Save__Group__3"
    // InternalMyDsl.g:2130:1: rule__Save__Group__3 : rule__Save__Group__3__Impl rule__Save__Group__4 ;
    public final void rule__Save__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:2134:1: ( rule__Save__Group__3__Impl rule__Save__Group__4 )
            // InternalMyDsl.g:2135:2: rule__Save__Group__3__Impl rule__Save__Group__4
            {
            pushFollow(FOLLOW_18);
            rule__Save__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Save__Group__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Save__Group__3"


    // $ANTLR start "rule__Save__Group__3__Impl"
    // InternalMyDsl.g:2142:1: rule__Save__Group__3__Impl : ( ( rule__Save__Group_3__0 )? ) ;
    public final void rule__Save__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:2146:1: ( ( ( rule__Save__Group_3__0 )? ) )
            // InternalMyDsl.g:2147:1: ( ( rule__Save__Group_3__0 )? )
            {
            // InternalMyDsl.g:2147:1: ( ( rule__Save__Group_3__0 )? )
            // InternalMyDsl.g:2148:2: ( rule__Save__Group_3__0 )?
            {
             before(grammarAccess.getSaveAccess().getGroup_3()); 
            // InternalMyDsl.g:2149:2: ( rule__Save__Group_3__0 )?
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( (LA13_0==50) ) {
                alt13=1;
            }
            switch (alt13) {
                case 1 :
                    // InternalMyDsl.g:2149:3: rule__Save__Group_3__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__Save__Group_3__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getSaveAccess().getGroup_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Save__Group__3__Impl"


    // $ANTLR start "rule__Save__Group__4"
    // InternalMyDsl.g:2157:1: rule__Save__Group__4 : rule__Save__Group__4__Impl rule__Save__Group__5 ;
    public final void rule__Save__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:2161:1: ( rule__Save__Group__4__Impl rule__Save__Group__5 )
            // InternalMyDsl.g:2162:2: rule__Save__Group__4__Impl rule__Save__Group__5
            {
            pushFollow(FOLLOW_4);
            rule__Save__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Save__Group__5();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Save__Group__4"


    // $ANTLR start "rule__Save__Group__4__Impl"
    // InternalMyDsl.g:2169:1: rule__Save__Group__4__Impl : ( 'tablesToSave' ) ;
    public final void rule__Save__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:2173:1: ( ( 'tablesToSave' ) )
            // InternalMyDsl.g:2174:1: ( 'tablesToSave' )
            {
            // InternalMyDsl.g:2174:1: ( 'tablesToSave' )
            // InternalMyDsl.g:2175:2: 'tablesToSave'
            {
             before(grammarAccess.getSaveAccess().getTablesToSaveKeyword_4()); 
            match(input,49,FOLLOW_2); 
             after(grammarAccess.getSaveAccess().getTablesToSaveKeyword_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Save__Group__4__Impl"


    // $ANTLR start "rule__Save__Group__5"
    // InternalMyDsl.g:2184:1: rule__Save__Group__5 : rule__Save__Group__5__Impl rule__Save__Group__6 ;
    public final void rule__Save__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:2188:1: ( rule__Save__Group__5__Impl rule__Save__Group__6 )
            // InternalMyDsl.g:2189:2: rule__Save__Group__5__Impl rule__Save__Group__6
            {
            pushFollow(FOLLOW_19);
            rule__Save__Group__5__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Save__Group__6();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Save__Group__5"


    // $ANTLR start "rule__Save__Group__5__Impl"
    // InternalMyDsl.g:2196:1: rule__Save__Group__5__Impl : ( '{' ) ;
    public final void rule__Save__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:2200:1: ( ( '{' ) )
            // InternalMyDsl.g:2201:1: ( '{' )
            {
            // InternalMyDsl.g:2201:1: ( '{' )
            // InternalMyDsl.g:2202:2: '{'
            {
             before(grammarAccess.getSaveAccess().getLeftCurlyBracketKeyword_5()); 
            match(input,38,FOLLOW_2); 
             after(grammarAccess.getSaveAccess().getLeftCurlyBracketKeyword_5()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Save__Group__5__Impl"


    // $ANTLR start "rule__Save__Group__6"
    // InternalMyDsl.g:2211:1: rule__Save__Group__6 : rule__Save__Group__6__Impl rule__Save__Group__7 ;
    public final void rule__Save__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:2215:1: ( rule__Save__Group__6__Impl rule__Save__Group__7 )
            // InternalMyDsl.g:2216:2: rule__Save__Group__6__Impl rule__Save__Group__7
            {
            pushFollow(FOLLOW_9);
            rule__Save__Group__6__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Save__Group__7();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Save__Group__6"


    // $ANTLR start "rule__Save__Group__6__Impl"
    // InternalMyDsl.g:2223:1: rule__Save__Group__6__Impl : ( ( rule__Save__TablesToSaveAssignment_6 ) ) ;
    public final void rule__Save__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:2227:1: ( ( ( rule__Save__TablesToSaveAssignment_6 ) ) )
            // InternalMyDsl.g:2228:1: ( ( rule__Save__TablesToSaveAssignment_6 ) )
            {
            // InternalMyDsl.g:2228:1: ( ( rule__Save__TablesToSaveAssignment_6 ) )
            // InternalMyDsl.g:2229:2: ( rule__Save__TablesToSaveAssignment_6 )
            {
             before(grammarAccess.getSaveAccess().getTablesToSaveAssignment_6()); 
            // InternalMyDsl.g:2230:2: ( rule__Save__TablesToSaveAssignment_6 )
            // InternalMyDsl.g:2230:3: rule__Save__TablesToSaveAssignment_6
            {
            pushFollow(FOLLOW_2);
            rule__Save__TablesToSaveAssignment_6();

            state._fsp--;


            }

             after(grammarAccess.getSaveAccess().getTablesToSaveAssignment_6()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Save__Group__6__Impl"


    // $ANTLR start "rule__Save__Group__7"
    // InternalMyDsl.g:2238:1: rule__Save__Group__7 : rule__Save__Group__7__Impl rule__Save__Group__8 ;
    public final void rule__Save__Group__7() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:2242:1: ( rule__Save__Group__7__Impl rule__Save__Group__8 )
            // InternalMyDsl.g:2243:2: rule__Save__Group__7__Impl rule__Save__Group__8
            {
            pushFollow(FOLLOW_9);
            rule__Save__Group__7__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Save__Group__8();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Save__Group__7"


    // $ANTLR start "rule__Save__Group__7__Impl"
    // InternalMyDsl.g:2250:1: rule__Save__Group__7__Impl : ( ( rule__Save__Group_7__0 )* ) ;
    public final void rule__Save__Group__7__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:2254:1: ( ( ( rule__Save__Group_7__0 )* ) )
            // InternalMyDsl.g:2255:1: ( ( rule__Save__Group_7__0 )* )
            {
            // InternalMyDsl.g:2255:1: ( ( rule__Save__Group_7__0 )* )
            // InternalMyDsl.g:2256:2: ( rule__Save__Group_7__0 )*
            {
             before(grammarAccess.getSaveAccess().getGroup_7()); 
            // InternalMyDsl.g:2257:2: ( rule__Save__Group_7__0 )*
            loop14:
            do {
                int alt14=2;
                int LA14_0 = input.LA(1);

                if ( (LA14_0==43) ) {
                    alt14=1;
                }


                switch (alt14) {
            	case 1 :
            	    // InternalMyDsl.g:2257:3: rule__Save__Group_7__0
            	    {
            	    pushFollow(FOLLOW_10);
            	    rule__Save__Group_7__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop14;
                }
            } while (true);

             after(grammarAccess.getSaveAccess().getGroup_7()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Save__Group__7__Impl"


    // $ANTLR start "rule__Save__Group__8"
    // InternalMyDsl.g:2265:1: rule__Save__Group__8 : rule__Save__Group__8__Impl rule__Save__Group__9 ;
    public final void rule__Save__Group__8() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:2269:1: ( rule__Save__Group__8__Impl rule__Save__Group__9 )
            // InternalMyDsl.g:2270:2: rule__Save__Group__8__Impl rule__Save__Group__9
            {
            pushFollow(FOLLOW_13);
            rule__Save__Group__8__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Save__Group__9();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Save__Group__8"


    // $ANTLR start "rule__Save__Group__8__Impl"
    // InternalMyDsl.g:2277:1: rule__Save__Group__8__Impl : ( '}' ) ;
    public final void rule__Save__Group__8__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:2281:1: ( ( '}' ) )
            // InternalMyDsl.g:2282:1: ( '}' )
            {
            // InternalMyDsl.g:2282:1: ( '}' )
            // InternalMyDsl.g:2283:2: '}'
            {
             before(grammarAccess.getSaveAccess().getRightCurlyBracketKeyword_8()); 
            match(input,41,FOLLOW_2); 
             after(grammarAccess.getSaveAccess().getRightCurlyBracketKeyword_8()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Save__Group__8__Impl"


    // $ANTLR start "rule__Save__Group__9"
    // InternalMyDsl.g:2292:1: rule__Save__Group__9 : rule__Save__Group__9__Impl ;
    public final void rule__Save__Group__9() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:2296:1: ( rule__Save__Group__9__Impl )
            // InternalMyDsl.g:2297:2: rule__Save__Group__9__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Save__Group__9__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Save__Group__9"


    // $ANTLR start "rule__Save__Group__9__Impl"
    // InternalMyDsl.g:2303:1: rule__Save__Group__9__Impl : ( '}' ) ;
    public final void rule__Save__Group__9__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:2307:1: ( ( '}' ) )
            // InternalMyDsl.g:2308:1: ( '}' )
            {
            // InternalMyDsl.g:2308:1: ( '}' )
            // InternalMyDsl.g:2309:2: '}'
            {
             before(grammarAccess.getSaveAccess().getRightCurlyBracketKeyword_9()); 
            match(input,41,FOLLOW_2); 
             after(grammarAccess.getSaveAccess().getRightCurlyBracketKeyword_9()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Save__Group__9__Impl"


    // $ANTLR start "rule__Save__Group_3__0"
    // InternalMyDsl.g:2319:1: rule__Save__Group_3__0 : rule__Save__Group_3__0__Impl rule__Save__Group_3__1 ;
    public final void rule__Save__Group_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:2323:1: ( rule__Save__Group_3__0__Impl rule__Save__Group_3__1 )
            // InternalMyDsl.g:2324:2: rule__Save__Group_3__0__Impl rule__Save__Group_3__1
            {
            pushFollow(FOLLOW_3);
            rule__Save__Group_3__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Save__Group_3__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Save__Group_3__0"


    // $ANTLR start "rule__Save__Group_3__0__Impl"
    // InternalMyDsl.g:2331:1: rule__Save__Group_3__0__Impl : ( 'description' ) ;
    public final void rule__Save__Group_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:2335:1: ( ( 'description' ) )
            // InternalMyDsl.g:2336:1: ( 'description' )
            {
            // InternalMyDsl.g:2336:1: ( 'description' )
            // InternalMyDsl.g:2337:2: 'description'
            {
             before(grammarAccess.getSaveAccess().getDescriptionKeyword_3_0()); 
            match(input,50,FOLLOW_2); 
             after(grammarAccess.getSaveAccess().getDescriptionKeyword_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Save__Group_3__0__Impl"


    // $ANTLR start "rule__Save__Group_3__1"
    // InternalMyDsl.g:2346:1: rule__Save__Group_3__1 : rule__Save__Group_3__1__Impl ;
    public final void rule__Save__Group_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:2350:1: ( rule__Save__Group_3__1__Impl )
            // InternalMyDsl.g:2351:2: rule__Save__Group_3__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Save__Group_3__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Save__Group_3__1"


    // $ANTLR start "rule__Save__Group_3__1__Impl"
    // InternalMyDsl.g:2357:1: rule__Save__Group_3__1__Impl : ( ( rule__Save__DescriptionAssignment_3_1 ) ) ;
    public final void rule__Save__Group_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:2361:1: ( ( ( rule__Save__DescriptionAssignment_3_1 ) ) )
            // InternalMyDsl.g:2362:1: ( ( rule__Save__DescriptionAssignment_3_1 ) )
            {
            // InternalMyDsl.g:2362:1: ( ( rule__Save__DescriptionAssignment_3_1 ) )
            // InternalMyDsl.g:2363:2: ( rule__Save__DescriptionAssignment_3_1 )
            {
             before(grammarAccess.getSaveAccess().getDescriptionAssignment_3_1()); 
            // InternalMyDsl.g:2364:2: ( rule__Save__DescriptionAssignment_3_1 )
            // InternalMyDsl.g:2364:3: rule__Save__DescriptionAssignment_3_1
            {
            pushFollow(FOLLOW_2);
            rule__Save__DescriptionAssignment_3_1();

            state._fsp--;


            }

             after(grammarAccess.getSaveAccess().getDescriptionAssignment_3_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Save__Group_3__1__Impl"


    // $ANTLR start "rule__Save__Group_7__0"
    // InternalMyDsl.g:2373:1: rule__Save__Group_7__0 : rule__Save__Group_7__0__Impl rule__Save__Group_7__1 ;
    public final void rule__Save__Group_7__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:2377:1: ( rule__Save__Group_7__0__Impl rule__Save__Group_7__1 )
            // InternalMyDsl.g:2378:2: rule__Save__Group_7__0__Impl rule__Save__Group_7__1
            {
            pushFollow(FOLLOW_19);
            rule__Save__Group_7__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Save__Group_7__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Save__Group_7__0"


    // $ANTLR start "rule__Save__Group_7__0__Impl"
    // InternalMyDsl.g:2385:1: rule__Save__Group_7__0__Impl : ( ',' ) ;
    public final void rule__Save__Group_7__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:2389:1: ( ( ',' ) )
            // InternalMyDsl.g:2390:1: ( ',' )
            {
            // InternalMyDsl.g:2390:1: ( ',' )
            // InternalMyDsl.g:2391:2: ','
            {
             before(grammarAccess.getSaveAccess().getCommaKeyword_7_0()); 
            match(input,43,FOLLOW_2); 
             after(grammarAccess.getSaveAccess().getCommaKeyword_7_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Save__Group_7__0__Impl"


    // $ANTLR start "rule__Save__Group_7__1"
    // InternalMyDsl.g:2400:1: rule__Save__Group_7__1 : rule__Save__Group_7__1__Impl ;
    public final void rule__Save__Group_7__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:2404:1: ( rule__Save__Group_7__1__Impl )
            // InternalMyDsl.g:2405:2: rule__Save__Group_7__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Save__Group_7__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Save__Group_7__1"


    // $ANTLR start "rule__Save__Group_7__1__Impl"
    // InternalMyDsl.g:2411:1: rule__Save__Group_7__1__Impl : ( ( rule__Save__TablesToSaveAssignment_7_1 ) ) ;
    public final void rule__Save__Group_7__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:2415:1: ( ( ( rule__Save__TablesToSaveAssignment_7_1 ) ) )
            // InternalMyDsl.g:2416:1: ( ( rule__Save__TablesToSaveAssignment_7_1 ) )
            {
            // InternalMyDsl.g:2416:1: ( ( rule__Save__TablesToSaveAssignment_7_1 ) )
            // InternalMyDsl.g:2417:2: ( rule__Save__TablesToSaveAssignment_7_1 )
            {
             before(grammarAccess.getSaveAccess().getTablesToSaveAssignment_7_1()); 
            // InternalMyDsl.g:2418:2: ( rule__Save__TablesToSaveAssignment_7_1 )
            // InternalMyDsl.g:2418:3: rule__Save__TablesToSaveAssignment_7_1
            {
            pushFollow(FOLLOW_2);
            rule__Save__TablesToSaveAssignment_7_1();

            state._fsp--;


            }

             after(grammarAccess.getSaveAccess().getTablesToSaveAssignment_7_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Save__Group_7__1__Impl"


    // $ANTLR start "rule__Group__Group__0"
    // InternalMyDsl.g:2427:1: rule__Group__Group__0 : rule__Group__Group__0__Impl rule__Group__Group__1 ;
    public final void rule__Group__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:2431:1: ( rule__Group__Group__0__Impl rule__Group__Group__1 )
            // InternalMyDsl.g:2432:2: rule__Group__Group__0__Impl rule__Group__Group__1
            {
            pushFollow(FOLLOW_3);
            rule__Group__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Group__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Group__Group__0"


    // $ANTLR start "rule__Group__Group__0__Impl"
    // InternalMyDsl.g:2439:1: rule__Group__Group__0__Impl : ( 'Group' ) ;
    public final void rule__Group__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:2443:1: ( ( 'Group' ) )
            // InternalMyDsl.g:2444:1: ( 'Group' )
            {
            // InternalMyDsl.g:2444:1: ( 'Group' )
            // InternalMyDsl.g:2445:2: 'Group'
            {
             before(grammarAccess.getGroupAccess().getGroupKeyword_0()); 
            match(input,51,FOLLOW_2); 
             after(grammarAccess.getGroupAccess().getGroupKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Group__Group__0__Impl"


    // $ANTLR start "rule__Group__Group__1"
    // InternalMyDsl.g:2454:1: rule__Group__Group__1 : rule__Group__Group__1__Impl rule__Group__Group__2 ;
    public final void rule__Group__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:2458:1: ( rule__Group__Group__1__Impl rule__Group__Group__2 )
            // InternalMyDsl.g:2459:2: rule__Group__Group__1__Impl rule__Group__Group__2
            {
            pushFollow(FOLLOW_4);
            rule__Group__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Group__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Group__Group__1"


    // $ANTLR start "rule__Group__Group__1__Impl"
    // InternalMyDsl.g:2466:1: rule__Group__Group__1__Impl : ( ( rule__Group__NameAssignment_1 ) ) ;
    public final void rule__Group__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:2470:1: ( ( ( rule__Group__NameAssignment_1 ) ) )
            // InternalMyDsl.g:2471:1: ( ( rule__Group__NameAssignment_1 ) )
            {
            // InternalMyDsl.g:2471:1: ( ( rule__Group__NameAssignment_1 ) )
            // InternalMyDsl.g:2472:2: ( rule__Group__NameAssignment_1 )
            {
             before(grammarAccess.getGroupAccess().getNameAssignment_1()); 
            // InternalMyDsl.g:2473:2: ( rule__Group__NameAssignment_1 )
            // InternalMyDsl.g:2473:3: rule__Group__NameAssignment_1
            {
            pushFollow(FOLLOW_2);
            rule__Group__NameAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getGroupAccess().getNameAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Group__Group__1__Impl"


    // $ANTLR start "rule__Group__Group__2"
    // InternalMyDsl.g:2481:1: rule__Group__Group__2 : rule__Group__Group__2__Impl rule__Group__Group__3 ;
    public final void rule__Group__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:2485:1: ( rule__Group__Group__2__Impl rule__Group__Group__3 )
            // InternalMyDsl.g:2486:2: rule__Group__Group__2__Impl rule__Group__Group__3
            {
            pushFollow(FOLLOW_20);
            rule__Group__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Group__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Group__Group__2"


    // $ANTLR start "rule__Group__Group__2__Impl"
    // InternalMyDsl.g:2493:1: rule__Group__Group__2__Impl : ( '{' ) ;
    public final void rule__Group__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:2497:1: ( ( '{' ) )
            // InternalMyDsl.g:2498:1: ( '{' )
            {
            // InternalMyDsl.g:2498:1: ( '{' )
            // InternalMyDsl.g:2499:2: '{'
            {
             before(grammarAccess.getGroupAccess().getLeftCurlyBracketKeyword_2()); 
            match(input,38,FOLLOW_2); 
             after(grammarAccess.getGroupAccess().getLeftCurlyBracketKeyword_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Group__Group__2__Impl"


    // $ANTLR start "rule__Group__Group__3"
    // InternalMyDsl.g:2508:1: rule__Group__Group__3 : rule__Group__Group__3__Impl rule__Group__Group__4 ;
    public final void rule__Group__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:2512:1: ( rule__Group__Group__3__Impl rule__Group__Group__4 )
            // InternalMyDsl.g:2513:2: rule__Group__Group__3__Impl rule__Group__Group__4
            {
            pushFollow(FOLLOW_20);
            rule__Group__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Group__Group__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Group__Group__3"


    // $ANTLR start "rule__Group__Group__3__Impl"
    // InternalMyDsl.g:2520:1: rule__Group__Group__3__Impl : ( ( rule__Group__Group_3__0 )? ) ;
    public final void rule__Group__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:2524:1: ( ( ( rule__Group__Group_3__0 )? ) )
            // InternalMyDsl.g:2525:1: ( ( rule__Group__Group_3__0 )? )
            {
            // InternalMyDsl.g:2525:1: ( ( rule__Group__Group_3__0 )? )
            // InternalMyDsl.g:2526:2: ( rule__Group__Group_3__0 )?
            {
             before(grammarAccess.getGroupAccess().getGroup_3()); 
            // InternalMyDsl.g:2527:2: ( rule__Group__Group_3__0 )?
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( (LA15_0==50) ) {
                alt15=1;
            }
            switch (alt15) {
                case 1 :
                    // InternalMyDsl.g:2527:3: rule__Group__Group_3__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__Group__Group_3__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getGroupAccess().getGroup_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Group__Group__3__Impl"


    // $ANTLR start "rule__Group__Group__4"
    // InternalMyDsl.g:2535:1: rule__Group__Group__4 : rule__Group__Group__4__Impl rule__Group__Group__5 ;
    public final void rule__Group__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:2539:1: ( rule__Group__Group__4__Impl rule__Group__Group__5 )
            // InternalMyDsl.g:2540:2: rule__Group__Group__4__Impl rule__Group__Group__5
            {
            pushFollow(FOLLOW_3);
            rule__Group__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Group__Group__5();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Group__Group__4"


    // $ANTLR start "rule__Group__Group__4__Impl"
    // InternalMyDsl.g:2547:1: rule__Group__Group__4__Impl : ( 'table' ) ;
    public final void rule__Group__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:2551:1: ( ( 'table' ) )
            // InternalMyDsl.g:2552:1: ( 'table' )
            {
            // InternalMyDsl.g:2552:1: ( 'table' )
            // InternalMyDsl.g:2553:2: 'table'
            {
             before(grammarAccess.getGroupAccess().getTableKeyword_4()); 
            match(input,52,FOLLOW_2); 
             after(grammarAccess.getGroupAccess().getTableKeyword_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Group__Group__4__Impl"


    // $ANTLR start "rule__Group__Group__5"
    // InternalMyDsl.g:2562:1: rule__Group__Group__5 : rule__Group__Group__5__Impl rule__Group__Group__6 ;
    public final void rule__Group__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:2566:1: ( rule__Group__Group__5__Impl rule__Group__Group__6 )
            // InternalMyDsl.g:2567:2: rule__Group__Group__5__Impl rule__Group__Group__6
            {
            pushFollow(FOLLOW_21);
            rule__Group__Group__5__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Group__Group__6();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Group__Group__5"


    // $ANTLR start "rule__Group__Group__5__Impl"
    // InternalMyDsl.g:2574:1: rule__Group__Group__5__Impl : ( ( rule__Group__TableAssignment_5 ) ) ;
    public final void rule__Group__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:2578:1: ( ( ( rule__Group__TableAssignment_5 ) ) )
            // InternalMyDsl.g:2579:1: ( ( rule__Group__TableAssignment_5 ) )
            {
            // InternalMyDsl.g:2579:1: ( ( rule__Group__TableAssignment_5 ) )
            // InternalMyDsl.g:2580:2: ( rule__Group__TableAssignment_5 )
            {
             before(grammarAccess.getGroupAccess().getTableAssignment_5()); 
            // InternalMyDsl.g:2581:2: ( rule__Group__TableAssignment_5 )
            // InternalMyDsl.g:2581:3: rule__Group__TableAssignment_5
            {
            pushFollow(FOLLOW_2);
            rule__Group__TableAssignment_5();

            state._fsp--;


            }

             after(grammarAccess.getGroupAccess().getTableAssignment_5()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Group__Group__5__Impl"


    // $ANTLR start "rule__Group__Group__6"
    // InternalMyDsl.g:2589:1: rule__Group__Group__6 : rule__Group__Group__6__Impl rule__Group__Group__7 ;
    public final void rule__Group__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:2593:1: ( rule__Group__Group__6__Impl rule__Group__Group__7 )
            // InternalMyDsl.g:2594:2: rule__Group__Group__6__Impl rule__Group__Group__7
            {
            pushFollow(FOLLOW_22);
            rule__Group__Group__6__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Group__Group__7();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Group__Group__6"


    // $ANTLR start "rule__Group__Group__6__Impl"
    // InternalMyDsl.g:2601:1: rule__Group__Group__6__Impl : ( 'groupBy' ) ;
    public final void rule__Group__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:2605:1: ( ( 'groupBy' ) )
            // InternalMyDsl.g:2606:1: ( 'groupBy' )
            {
            // InternalMyDsl.g:2606:1: ( 'groupBy' )
            // InternalMyDsl.g:2607:2: 'groupBy'
            {
             before(grammarAccess.getGroupAccess().getGroupByKeyword_6()); 
            match(input,53,FOLLOW_2); 
             after(grammarAccess.getGroupAccess().getGroupByKeyword_6()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Group__Group__6__Impl"


    // $ANTLR start "rule__Group__Group__7"
    // InternalMyDsl.g:2616:1: rule__Group__Group__7 : rule__Group__Group__7__Impl rule__Group__Group__8 ;
    public final void rule__Group__Group__7() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:2620:1: ( rule__Group__Group__7__Impl rule__Group__Group__8 )
            // InternalMyDsl.g:2621:2: rule__Group__Group__7__Impl rule__Group__Group__8
            {
            pushFollow(FOLLOW_3);
            rule__Group__Group__7__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Group__Group__8();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Group__Group__7"


    // $ANTLR start "rule__Group__Group__7__Impl"
    // InternalMyDsl.g:2628:1: rule__Group__Group__7__Impl : ( '(' ) ;
    public final void rule__Group__Group__7__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:2632:1: ( ( '(' ) )
            // InternalMyDsl.g:2633:1: ( '(' )
            {
            // InternalMyDsl.g:2633:1: ( '(' )
            // InternalMyDsl.g:2634:2: '('
            {
             before(grammarAccess.getGroupAccess().getLeftParenthesisKeyword_7()); 
            match(input,54,FOLLOW_2); 
             after(grammarAccess.getGroupAccess().getLeftParenthesisKeyword_7()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Group__Group__7__Impl"


    // $ANTLR start "rule__Group__Group__8"
    // InternalMyDsl.g:2643:1: rule__Group__Group__8 : rule__Group__Group__8__Impl rule__Group__Group__9 ;
    public final void rule__Group__Group__8() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:2647:1: ( rule__Group__Group__8__Impl rule__Group__Group__9 )
            // InternalMyDsl.g:2648:2: rule__Group__Group__8__Impl rule__Group__Group__9
            {
            pushFollow(FOLLOW_23);
            rule__Group__Group__8__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Group__Group__9();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Group__Group__8"


    // $ANTLR start "rule__Group__Group__8__Impl"
    // InternalMyDsl.g:2655:1: rule__Group__Group__8__Impl : ( ( rule__Group__GroupByAssignment_8 ) ) ;
    public final void rule__Group__Group__8__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:2659:1: ( ( ( rule__Group__GroupByAssignment_8 ) ) )
            // InternalMyDsl.g:2660:1: ( ( rule__Group__GroupByAssignment_8 ) )
            {
            // InternalMyDsl.g:2660:1: ( ( rule__Group__GroupByAssignment_8 ) )
            // InternalMyDsl.g:2661:2: ( rule__Group__GroupByAssignment_8 )
            {
             before(grammarAccess.getGroupAccess().getGroupByAssignment_8()); 
            // InternalMyDsl.g:2662:2: ( rule__Group__GroupByAssignment_8 )
            // InternalMyDsl.g:2662:3: rule__Group__GroupByAssignment_8
            {
            pushFollow(FOLLOW_2);
            rule__Group__GroupByAssignment_8();

            state._fsp--;


            }

             after(grammarAccess.getGroupAccess().getGroupByAssignment_8()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Group__Group__8__Impl"


    // $ANTLR start "rule__Group__Group__9"
    // InternalMyDsl.g:2670:1: rule__Group__Group__9 : rule__Group__Group__9__Impl rule__Group__Group__10 ;
    public final void rule__Group__Group__9() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:2674:1: ( rule__Group__Group__9__Impl rule__Group__Group__10 )
            // InternalMyDsl.g:2675:2: rule__Group__Group__9__Impl rule__Group__Group__10
            {
            pushFollow(FOLLOW_23);
            rule__Group__Group__9__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Group__Group__10();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Group__Group__9"


    // $ANTLR start "rule__Group__Group__9__Impl"
    // InternalMyDsl.g:2682:1: rule__Group__Group__9__Impl : ( ( rule__Group__Group_9__0 )* ) ;
    public final void rule__Group__Group__9__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:2686:1: ( ( ( rule__Group__Group_9__0 )* ) )
            // InternalMyDsl.g:2687:1: ( ( rule__Group__Group_9__0 )* )
            {
            // InternalMyDsl.g:2687:1: ( ( rule__Group__Group_9__0 )* )
            // InternalMyDsl.g:2688:2: ( rule__Group__Group_9__0 )*
            {
             before(grammarAccess.getGroupAccess().getGroup_9()); 
            // InternalMyDsl.g:2689:2: ( rule__Group__Group_9__0 )*
            loop16:
            do {
                int alt16=2;
                int LA16_0 = input.LA(1);

                if ( (LA16_0==43) ) {
                    alt16=1;
                }


                switch (alt16) {
            	case 1 :
            	    // InternalMyDsl.g:2689:3: rule__Group__Group_9__0
            	    {
            	    pushFollow(FOLLOW_10);
            	    rule__Group__Group_9__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop16;
                }
            } while (true);

             after(grammarAccess.getGroupAccess().getGroup_9()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Group__Group__9__Impl"


    // $ANTLR start "rule__Group__Group__10"
    // InternalMyDsl.g:2697:1: rule__Group__Group__10 : rule__Group__Group__10__Impl rule__Group__Group__11 ;
    public final void rule__Group__Group__10() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:2701:1: ( rule__Group__Group__10__Impl rule__Group__Group__11 )
            // InternalMyDsl.g:2702:2: rule__Group__Group__10__Impl rule__Group__Group__11
            {
            pushFollow(FOLLOW_24);
            rule__Group__Group__10__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Group__Group__11();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Group__Group__10"


    // $ANTLR start "rule__Group__Group__10__Impl"
    // InternalMyDsl.g:2709:1: rule__Group__Group__10__Impl : ( ')' ) ;
    public final void rule__Group__Group__10__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:2713:1: ( ( ')' ) )
            // InternalMyDsl.g:2714:1: ( ')' )
            {
            // InternalMyDsl.g:2714:1: ( ')' )
            // InternalMyDsl.g:2715:2: ')'
            {
             before(grammarAccess.getGroupAccess().getRightParenthesisKeyword_10()); 
            match(input,55,FOLLOW_2); 
             after(grammarAccess.getGroupAccess().getRightParenthesisKeyword_10()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Group__Group__10__Impl"


    // $ANTLR start "rule__Group__Group__11"
    // InternalMyDsl.g:2724:1: rule__Group__Group__11 : rule__Group__Group__11__Impl rule__Group__Group__12 ;
    public final void rule__Group__Group__11() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:2728:1: ( rule__Group__Group__11__Impl rule__Group__Group__12 )
            // InternalMyDsl.g:2729:2: rule__Group__Group__11__Impl rule__Group__Group__12
            {
            pushFollow(FOLLOW_25);
            rule__Group__Group__11__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Group__Group__12();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Group__Group__11"


    // $ANTLR start "rule__Group__Group__11__Impl"
    // InternalMyDsl.g:2736:1: rule__Group__Group__11__Impl : ( 'operation' ) ;
    public final void rule__Group__Group__11__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:2740:1: ( ( 'operation' ) )
            // InternalMyDsl.g:2741:1: ( 'operation' )
            {
            // InternalMyDsl.g:2741:1: ( 'operation' )
            // InternalMyDsl.g:2742:2: 'operation'
            {
             before(grammarAccess.getGroupAccess().getOperationKeyword_11()); 
            match(input,56,FOLLOW_2); 
             after(grammarAccess.getGroupAccess().getOperationKeyword_11()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Group__Group__11__Impl"


    // $ANTLR start "rule__Group__Group__12"
    // InternalMyDsl.g:2751:1: rule__Group__Group__12 : rule__Group__Group__12__Impl rule__Group__Group__13 ;
    public final void rule__Group__Group__12() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:2755:1: ( rule__Group__Group__12__Impl rule__Group__Group__13 )
            // InternalMyDsl.g:2756:2: rule__Group__Group__12__Impl rule__Group__Group__13
            {
            pushFollow(FOLLOW_26);
            rule__Group__Group__12__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Group__Group__13();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Group__Group__12"


    // $ANTLR start "rule__Group__Group__12__Impl"
    // InternalMyDsl.g:2763:1: rule__Group__Group__12__Impl : ( ( rule__Group__OperationAssignment_12 ) ) ;
    public final void rule__Group__Group__12__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:2767:1: ( ( ( rule__Group__OperationAssignment_12 ) ) )
            // InternalMyDsl.g:2768:1: ( ( rule__Group__OperationAssignment_12 ) )
            {
            // InternalMyDsl.g:2768:1: ( ( rule__Group__OperationAssignment_12 ) )
            // InternalMyDsl.g:2769:2: ( rule__Group__OperationAssignment_12 )
            {
             before(grammarAccess.getGroupAccess().getOperationAssignment_12()); 
            // InternalMyDsl.g:2770:2: ( rule__Group__OperationAssignment_12 )
            // InternalMyDsl.g:2770:3: rule__Group__OperationAssignment_12
            {
            pushFollow(FOLLOW_2);
            rule__Group__OperationAssignment_12();

            state._fsp--;


            }

             after(grammarAccess.getGroupAccess().getOperationAssignment_12()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Group__Group__12__Impl"


    // $ANTLR start "rule__Group__Group__13"
    // InternalMyDsl.g:2778:1: rule__Group__Group__13 : rule__Group__Group__13__Impl rule__Group__Group__14 ;
    public final void rule__Group__Group__13() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:2782:1: ( rule__Group__Group__13__Impl rule__Group__Group__14 )
            // InternalMyDsl.g:2783:2: rule__Group__Group__13__Impl rule__Group__Group__14
            {
            pushFollow(FOLLOW_3);
            rule__Group__Group__13__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Group__Group__14();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Group__Group__13"


    // $ANTLR start "rule__Group__Group__13__Impl"
    // InternalMyDsl.g:2790:1: rule__Group__Group__13__Impl : ( 'operandColumn' ) ;
    public final void rule__Group__Group__13__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:2794:1: ( ( 'operandColumn' ) )
            // InternalMyDsl.g:2795:1: ( 'operandColumn' )
            {
            // InternalMyDsl.g:2795:1: ( 'operandColumn' )
            // InternalMyDsl.g:2796:2: 'operandColumn'
            {
             before(grammarAccess.getGroupAccess().getOperandColumnKeyword_13()); 
            match(input,57,FOLLOW_2); 
             after(grammarAccess.getGroupAccess().getOperandColumnKeyword_13()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Group__Group__13__Impl"


    // $ANTLR start "rule__Group__Group__14"
    // InternalMyDsl.g:2805:1: rule__Group__Group__14 : rule__Group__Group__14__Impl rule__Group__Group__15 ;
    public final void rule__Group__Group__14() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:2809:1: ( rule__Group__Group__14__Impl rule__Group__Group__15 )
            // InternalMyDsl.g:2810:2: rule__Group__Group__14__Impl rule__Group__Group__15
            {
            pushFollow(FOLLOW_27);
            rule__Group__Group__14__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Group__Group__15();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Group__Group__14"


    // $ANTLR start "rule__Group__Group__14__Impl"
    // InternalMyDsl.g:2817:1: rule__Group__Group__14__Impl : ( ( rule__Group__OperandColumnAssignment_14 ) ) ;
    public final void rule__Group__Group__14__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:2821:1: ( ( ( rule__Group__OperandColumnAssignment_14 ) ) )
            // InternalMyDsl.g:2822:1: ( ( rule__Group__OperandColumnAssignment_14 ) )
            {
            // InternalMyDsl.g:2822:1: ( ( rule__Group__OperandColumnAssignment_14 ) )
            // InternalMyDsl.g:2823:2: ( rule__Group__OperandColumnAssignment_14 )
            {
             before(grammarAccess.getGroupAccess().getOperandColumnAssignment_14()); 
            // InternalMyDsl.g:2824:2: ( rule__Group__OperandColumnAssignment_14 )
            // InternalMyDsl.g:2824:3: rule__Group__OperandColumnAssignment_14
            {
            pushFollow(FOLLOW_2);
            rule__Group__OperandColumnAssignment_14();

            state._fsp--;


            }

             after(grammarAccess.getGroupAccess().getOperandColumnAssignment_14()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Group__Group__14__Impl"


    // $ANTLR start "rule__Group__Group__15"
    // InternalMyDsl.g:2832:1: rule__Group__Group__15 : rule__Group__Group__15__Impl rule__Group__Group__16 ;
    public final void rule__Group__Group__15() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:2836:1: ( rule__Group__Group__15__Impl rule__Group__Group__16 )
            // InternalMyDsl.g:2837:2: rule__Group__Group__15__Impl rule__Group__Group__16
            {
            pushFollow(FOLLOW_3);
            rule__Group__Group__15__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Group__Group__16();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Group__Group__15"


    // $ANTLR start "rule__Group__Group__15__Impl"
    // InternalMyDsl.g:2844:1: rule__Group__Group__15__Impl : ( 'resultTable' ) ;
    public final void rule__Group__Group__15__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:2848:1: ( ( 'resultTable' ) )
            // InternalMyDsl.g:2849:1: ( 'resultTable' )
            {
            // InternalMyDsl.g:2849:1: ( 'resultTable' )
            // InternalMyDsl.g:2850:2: 'resultTable'
            {
             before(grammarAccess.getGroupAccess().getResultTableKeyword_15()); 
            match(input,58,FOLLOW_2); 
             after(grammarAccess.getGroupAccess().getResultTableKeyword_15()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Group__Group__15__Impl"


    // $ANTLR start "rule__Group__Group__16"
    // InternalMyDsl.g:2859:1: rule__Group__Group__16 : rule__Group__Group__16__Impl rule__Group__Group__17 ;
    public final void rule__Group__Group__16() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:2863:1: ( rule__Group__Group__16__Impl rule__Group__Group__17 )
            // InternalMyDsl.g:2864:2: rule__Group__Group__16__Impl rule__Group__Group__17
            {
            pushFollow(FOLLOW_28);
            rule__Group__Group__16__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Group__Group__17();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Group__Group__16"


    // $ANTLR start "rule__Group__Group__16__Impl"
    // InternalMyDsl.g:2871:1: rule__Group__Group__16__Impl : ( ( rule__Group__ResultTableAssignment_16 ) ) ;
    public final void rule__Group__Group__16__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:2875:1: ( ( ( rule__Group__ResultTableAssignment_16 ) ) )
            // InternalMyDsl.g:2876:1: ( ( rule__Group__ResultTableAssignment_16 ) )
            {
            // InternalMyDsl.g:2876:1: ( ( rule__Group__ResultTableAssignment_16 ) )
            // InternalMyDsl.g:2877:2: ( rule__Group__ResultTableAssignment_16 )
            {
             before(grammarAccess.getGroupAccess().getResultTableAssignment_16()); 
            // InternalMyDsl.g:2878:2: ( rule__Group__ResultTableAssignment_16 )
            // InternalMyDsl.g:2878:3: rule__Group__ResultTableAssignment_16
            {
            pushFollow(FOLLOW_2);
            rule__Group__ResultTableAssignment_16();

            state._fsp--;


            }

             after(grammarAccess.getGroupAccess().getResultTableAssignment_16()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Group__Group__16__Impl"


    // $ANTLR start "rule__Group__Group__17"
    // InternalMyDsl.g:2886:1: rule__Group__Group__17 : rule__Group__Group__17__Impl rule__Group__Group__18 ;
    public final void rule__Group__Group__17() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:2890:1: ( rule__Group__Group__17__Impl rule__Group__Group__18 )
            // InternalMyDsl.g:2891:2: rule__Group__Group__17__Impl rule__Group__Group__18
            {
            pushFollow(FOLLOW_3);
            rule__Group__Group__17__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Group__Group__18();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Group__Group__17"


    // $ANTLR start "rule__Group__Group__17__Impl"
    // InternalMyDsl.g:2898:1: rule__Group__Group__17__Impl : ( 'resultColumn' ) ;
    public final void rule__Group__Group__17__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:2902:1: ( ( 'resultColumn' ) )
            // InternalMyDsl.g:2903:1: ( 'resultColumn' )
            {
            // InternalMyDsl.g:2903:1: ( 'resultColumn' )
            // InternalMyDsl.g:2904:2: 'resultColumn'
            {
             before(grammarAccess.getGroupAccess().getResultColumnKeyword_17()); 
            match(input,59,FOLLOW_2); 
             after(grammarAccess.getGroupAccess().getResultColumnKeyword_17()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Group__Group__17__Impl"


    // $ANTLR start "rule__Group__Group__18"
    // InternalMyDsl.g:2913:1: rule__Group__Group__18 : rule__Group__Group__18__Impl rule__Group__Group__19 ;
    public final void rule__Group__Group__18() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:2917:1: ( rule__Group__Group__18__Impl rule__Group__Group__19 )
            // InternalMyDsl.g:2918:2: rule__Group__Group__18__Impl rule__Group__Group__19
            {
            pushFollow(FOLLOW_29);
            rule__Group__Group__18__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Group__Group__19();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Group__Group__18"


    // $ANTLR start "rule__Group__Group__18__Impl"
    // InternalMyDsl.g:2925:1: rule__Group__Group__18__Impl : ( ( rule__Group__ResultColumnAssignment_18 ) ) ;
    public final void rule__Group__Group__18__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:2929:1: ( ( ( rule__Group__ResultColumnAssignment_18 ) ) )
            // InternalMyDsl.g:2930:1: ( ( rule__Group__ResultColumnAssignment_18 ) )
            {
            // InternalMyDsl.g:2930:1: ( ( rule__Group__ResultColumnAssignment_18 ) )
            // InternalMyDsl.g:2931:2: ( rule__Group__ResultColumnAssignment_18 )
            {
             before(grammarAccess.getGroupAccess().getResultColumnAssignment_18()); 
            // InternalMyDsl.g:2932:2: ( rule__Group__ResultColumnAssignment_18 )
            // InternalMyDsl.g:2932:3: rule__Group__ResultColumnAssignment_18
            {
            pushFollow(FOLLOW_2);
            rule__Group__ResultColumnAssignment_18();

            state._fsp--;


            }

             after(grammarAccess.getGroupAccess().getResultColumnAssignment_18()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Group__Group__18__Impl"


    // $ANTLR start "rule__Group__Group__19"
    // InternalMyDsl.g:2940:1: rule__Group__Group__19 : rule__Group__Group__19__Impl rule__Group__Group__20 ;
    public final void rule__Group__Group__19() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:2944:1: ( rule__Group__Group__19__Impl rule__Group__Group__20 )
            // InternalMyDsl.g:2945:2: rule__Group__Group__19__Impl rule__Group__Group__20
            {
            pushFollow(FOLLOW_3);
            rule__Group__Group__19__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Group__Group__20();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Group__Group__19"


    // $ANTLR start "rule__Group__Group__19__Impl"
    // InternalMyDsl.g:2952:1: rule__Group__Group__19__Impl : ( 'next' ) ;
    public final void rule__Group__Group__19__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:2956:1: ( ( 'next' ) )
            // InternalMyDsl.g:2957:1: ( 'next' )
            {
            // InternalMyDsl.g:2957:1: ( 'next' )
            // InternalMyDsl.g:2958:2: 'next'
            {
             before(grammarAccess.getGroupAccess().getNextKeyword_19()); 
            match(input,60,FOLLOW_2); 
             after(grammarAccess.getGroupAccess().getNextKeyword_19()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Group__Group__19__Impl"


    // $ANTLR start "rule__Group__Group__20"
    // InternalMyDsl.g:2967:1: rule__Group__Group__20 : rule__Group__Group__20__Impl rule__Group__Group__21 ;
    public final void rule__Group__Group__20() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:2971:1: ( rule__Group__Group__20__Impl rule__Group__Group__21 )
            // InternalMyDsl.g:2972:2: rule__Group__Group__20__Impl rule__Group__Group__21
            {
            pushFollow(FOLLOW_13);
            rule__Group__Group__20__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Group__Group__21();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Group__Group__20"


    // $ANTLR start "rule__Group__Group__20__Impl"
    // InternalMyDsl.g:2979:1: rule__Group__Group__20__Impl : ( ( rule__Group__NextAssignment_20 ) ) ;
    public final void rule__Group__Group__20__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:2983:1: ( ( ( rule__Group__NextAssignment_20 ) ) )
            // InternalMyDsl.g:2984:1: ( ( rule__Group__NextAssignment_20 ) )
            {
            // InternalMyDsl.g:2984:1: ( ( rule__Group__NextAssignment_20 ) )
            // InternalMyDsl.g:2985:2: ( rule__Group__NextAssignment_20 )
            {
             before(grammarAccess.getGroupAccess().getNextAssignment_20()); 
            // InternalMyDsl.g:2986:2: ( rule__Group__NextAssignment_20 )
            // InternalMyDsl.g:2986:3: rule__Group__NextAssignment_20
            {
            pushFollow(FOLLOW_2);
            rule__Group__NextAssignment_20();

            state._fsp--;


            }

             after(grammarAccess.getGroupAccess().getNextAssignment_20()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Group__Group__20__Impl"


    // $ANTLR start "rule__Group__Group__21"
    // InternalMyDsl.g:2994:1: rule__Group__Group__21 : rule__Group__Group__21__Impl ;
    public final void rule__Group__Group__21() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:2998:1: ( rule__Group__Group__21__Impl )
            // InternalMyDsl.g:2999:2: rule__Group__Group__21__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Group__Group__21__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Group__Group__21"


    // $ANTLR start "rule__Group__Group__21__Impl"
    // InternalMyDsl.g:3005:1: rule__Group__Group__21__Impl : ( '}' ) ;
    public final void rule__Group__Group__21__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:3009:1: ( ( '}' ) )
            // InternalMyDsl.g:3010:1: ( '}' )
            {
            // InternalMyDsl.g:3010:1: ( '}' )
            // InternalMyDsl.g:3011:2: '}'
            {
             before(grammarAccess.getGroupAccess().getRightCurlyBracketKeyword_21()); 
            match(input,41,FOLLOW_2); 
             after(grammarAccess.getGroupAccess().getRightCurlyBracketKeyword_21()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Group__Group__21__Impl"


    // $ANTLR start "rule__Group__Group_3__0"
    // InternalMyDsl.g:3021:1: rule__Group__Group_3__0 : rule__Group__Group_3__0__Impl rule__Group__Group_3__1 ;
    public final void rule__Group__Group_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:3025:1: ( rule__Group__Group_3__0__Impl rule__Group__Group_3__1 )
            // InternalMyDsl.g:3026:2: rule__Group__Group_3__0__Impl rule__Group__Group_3__1
            {
            pushFollow(FOLLOW_3);
            rule__Group__Group_3__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Group__Group_3__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Group__Group_3__0"


    // $ANTLR start "rule__Group__Group_3__0__Impl"
    // InternalMyDsl.g:3033:1: rule__Group__Group_3__0__Impl : ( 'description' ) ;
    public final void rule__Group__Group_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:3037:1: ( ( 'description' ) )
            // InternalMyDsl.g:3038:1: ( 'description' )
            {
            // InternalMyDsl.g:3038:1: ( 'description' )
            // InternalMyDsl.g:3039:2: 'description'
            {
             before(grammarAccess.getGroupAccess().getDescriptionKeyword_3_0()); 
            match(input,50,FOLLOW_2); 
             after(grammarAccess.getGroupAccess().getDescriptionKeyword_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Group__Group_3__0__Impl"


    // $ANTLR start "rule__Group__Group_3__1"
    // InternalMyDsl.g:3048:1: rule__Group__Group_3__1 : rule__Group__Group_3__1__Impl ;
    public final void rule__Group__Group_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:3052:1: ( rule__Group__Group_3__1__Impl )
            // InternalMyDsl.g:3053:2: rule__Group__Group_3__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Group__Group_3__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Group__Group_3__1"


    // $ANTLR start "rule__Group__Group_3__1__Impl"
    // InternalMyDsl.g:3059:1: rule__Group__Group_3__1__Impl : ( ( rule__Group__DescriptionAssignment_3_1 ) ) ;
    public final void rule__Group__Group_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:3063:1: ( ( ( rule__Group__DescriptionAssignment_3_1 ) ) )
            // InternalMyDsl.g:3064:1: ( ( rule__Group__DescriptionAssignment_3_1 ) )
            {
            // InternalMyDsl.g:3064:1: ( ( rule__Group__DescriptionAssignment_3_1 ) )
            // InternalMyDsl.g:3065:2: ( rule__Group__DescriptionAssignment_3_1 )
            {
             before(grammarAccess.getGroupAccess().getDescriptionAssignment_3_1()); 
            // InternalMyDsl.g:3066:2: ( rule__Group__DescriptionAssignment_3_1 )
            // InternalMyDsl.g:3066:3: rule__Group__DescriptionAssignment_3_1
            {
            pushFollow(FOLLOW_2);
            rule__Group__DescriptionAssignment_3_1();

            state._fsp--;


            }

             after(grammarAccess.getGroupAccess().getDescriptionAssignment_3_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Group__Group_3__1__Impl"


    // $ANTLR start "rule__Group__Group_9__0"
    // InternalMyDsl.g:3075:1: rule__Group__Group_9__0 : rule__Group__Group_9__0__Impl rule__Group__Group_9__1 ;
    public final void rule__Group__Group_9__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:3079:1: ( rule__Group__Group_9__0__Impl rule__Group__Group_9__1 )
            // InternalMyDsl.g:3080:2: rule__Group__Group_9__0__Impl rule__Group__Group_9__1
            {
            pushFollow(FOLLOW_3);
            rule__Group__Group_9__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Group__Group_9__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Group__Group_9__0"


    // $ANTLR start "rule__Group__Group_9__0__Impl"
    // InternalMyDsl.g:3087:1: rule__Group__Group_9__0__Impl : ( ',' ) ;
    public final void rule__Group__Group_9__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:3091:1: ( ( ',' ) )
            // InternalMyDsl.g:3092:1: ( ',' )
            {
            // InternalMyDsl.g:3092:1: ( ',' )
            // InternalMyDsl.g:3093:2: ','
            {
             before(grammarAccess.getGroupAccess().getCommaKeyword_9_0()); 
            match(input,43,FOLLOW_2); 
             after(grammarAccess.getGroupAccess().getCommaKeyword_9_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Group__Group_9__0__Impl"


    // $ANTLR start "rule__Group__Group_9__1"
    // InternalMyDsl.g:3102:1: rule__Group__Group_9__1 : rule__Group__Group_9__1__Impl ;
    public final void rule__Group__Group_9__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:3106:1: ( rule__Group__Group_9__1__Impl )
            // InternalMyDsl.g:3107:2: rule__Group__Group_9__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Group__Group_9__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Group__Group_9__1"


    // $ANTLR start "rule__Group__Group_9__1__Impl"
    // InternalMyDsl.g:3113:1: rule__Group__Group_9__1__Impl : ( ( rule__Group__GroupByAssignment_9_1 ) ) ;
    public final void rule__Group__Group_9__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:3117:1: ( ( ( rule__Group__GroupByAssignment_9_1 ) ) )
            // InternalMyDsl.g:3118:1: ( ( rule__Group__GroupByAssignment_9_1 ) )
            {
            // InternalMyDsl.g:3118:1: ( ( rule__Group__GroupByAssignment_9_1 ) )
            // InternalMyDsl.g:3119:2: ( rule__Group__GroupByAssignment_9_1 )
            {
             before(grammarAccess.getGroupAccess().getGroupByAssignment_9_1()); 
            // InternalMyDsl.g:3120:2: ( rule__Group__GroupByAssignment_9_1 )
            // InternalMyDsl.g:3120:3: rule__Group__GroupByAssignment_9_1
            {
            pushFollow(FOLLOW_2);
            rule__Group__GroupByAssignment_9_1();

            state._fsp--;


            }

             after(grammarAccess.getGroupAccess().getGroupByAssignment_9_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Group__Group_9__1__Impl"


    // $ANTLR start "rule__Sort__Group__0"
    // InternalMyDsl.g:3129:1: rule__Sort__Group__0 : rule__Sort__Group__0__Impl rule__Sort__Group__1 ;
    public final void rule__Sort__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:3133:1: ( rule__Sort__Group__0__Impl rule__Sort__Group__1 )
            // InternalMyDsl.g:3134:2: rule__Sort__Group__0__Impl rule__Sort__Group__1
            {
            pushFollow(FOLLOW_3);
            rule__Sort__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Sort__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Sort__Group__0"


    // $ANTLR start "rule__Sort__Group__0__Impl"
    // InternalMyDsl.g:3141:1: rule__Sort__Group__0__Impl : ( 'Sort' ) ;
    public final void rule__Sort__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:3145:1: ( ( 'Sort' ) )
            // InternalMyDsl.g:3146:1: ( 'Sort' )
            {
            // InternalMyDsl.g:3146:1: ( 'Sort' )
            // InternalMyDsl.g:3147:2: 'Sort'
            {
             before(grammarAccess.getSortAccess().getSortKeyword_0()); 
            match(input,61,FOLLOW_2); 
             after(grammarAccess.getSortAccess().getSortKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Sort__Group__0__Impl"


    // $ANTLR start "rule__Sort__Group__1"
    // InternalMyDsl.g:3156:1: rule__Sort__Group__1 : rule__Sort__Group__1__Impl rule__Sort__Group__2 ;
    public final void rule__Sort__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:3160:1: ( rule__Sort__Group__1__Impl rule__Sort__Group__2 )
            // InternalMyDsl.g:3161:2: rule__Sort__Group__1__Impl rule__Sort__Group__2
            {
            pushFollow(FOLLOW_4);
            rule__Sort__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Sort__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Sort__Group__1"


    // $ANTLR start "rule__Sort__Group__1__Impl"
    // InternalMyDsl.g:3168:1: rule__Sort__Group__1__Impl : ( ( rule__Sort__NameAssignment_1 ) ) ;
    public final void rule__Sort__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:3172:1: ( ( ( rule__Sort__NameAssignment_1 ) ) )
            // InternalMyDsl.g:3173:1: ( ( rule__Sort__NameAssignment_1 ) )
            {
            // InternalMyDsl.g:3173:1: ( ( rule__Sort__NameAssignment_1 ) )
            // InternalMyDsl.g:3174:2: ( rule__Sort__NameAssignment_1 )
            {
             before(grammarAccess.getSortAccess().getNameAssignment_1()); 
            // InternalMyDsl.g:3175:2: ( rule__Sort__NameAssignment_1 )
            // InternalMyDsl.g:3175:3: rule__Sort__NameAssignment_1
            {
            pushFollow(FOLLOW_2);
            rule__Sort__NameAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getSortAccess().getNameAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Sort__Group__1__Impl"


    // $ANTLR start "rule__Sort__Group__2"
    // InternalMyDsl.g:3183:1: rule__Sort__Group__2 : rule__Sort__Group__2__Impl rule__Sort__Group__3 ;
    public final void rule__Sort__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:3187:1: ( rule__Sort__Group__2__Impl rule__Sort__Group__3 )
            // InternalMyDsl.g:3188:2: rule__Sort__Group__2__Impl rule__Sort__Group__3
            {
            pushFollow(FOLLOW_20);
            rule__Sort__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Sort__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Sort__Group__2"


    // $ANTLR start "rule__Sort__Group__2__Impl"
    // InternalMyDsl.g:3195:1: rule__Sort__Group__2__Impl : ( '{' ) ;
    public final void rule__Sort__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:3199:1: ( ( '{' ) )
            // InternalMyDsl.g:3200:1: ( '{' )
            {
            // InternalMyDsl.g:3200:1: ( '{' )
            // InternalMyDsl.g:3201:2: '{'
            {
             before(grammarAccess.getSortAccess().getLeftCurlyBracketKeyword_2()); 
            match(input,38,FOLLOW_2); 
             after(grammarAccess.getSortAccess().getLeftCurlyBracketKeyword_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Sort__Group__2__Impl"


    // $ANTLR start "rule__Sort__Group__3"
    // InternalMyDsl.g:3210:1: rule__Sort__Group__3 : rule__Sort__Group__3__Impl rule__Sort__Group__4 ;
    public final void rule__Sort__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:3214:1: ( rule__Sort__Group__3__Impl rule__Sort__Group__4 )
            // InternalMyDsl.g:3215:2: rule__Sort__Group__3__Impl rule__Sort__Group__4
            {
            pushFollow(FOLLOW_20);
            rule__Sort__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Sort__Group__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Sort__Group__3"


    // $ANTLR start "rule__Sort__Group__3__Impl"
    // InternalMyDsl.g:3222:1: rule__Sort__Group__3__Impl : ( ( rule__Sort__Group_3__0 )? ) ;
    public final void rule__Sort__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:3226:1: ( ( ( rule__Sort__Group_3__0 )? ) )
            // InternalMyDsl.g:3227:1: ( ( rule__Sort__Group_3__0 )? )
            {
            // InternalMyDsl.g:3227:1: ( ( rule__Sort__Group_3__0 )? )
            // InternalMyDsl.g:3228:2: ( rule__Sort__Group_3__0 )?
            {
             before(grammarAccess.getSortAccess().getGroup_3()); 
            // InternalMyDsl.g:3229:2: ( rule__Sort__Group_3__0 )?
            int alt17=2;
            int LA17_0 = input.LA(1);

            if ( (LA17_0==50) ) {
                alt17=1;
            }
            switch (alt17) {
                case 1 :
                    // InternalMyDsl.g:3229:3: rule__Sort__Group_3__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__Sort__Group_3__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getSortAccess().getGroup_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Sort__Group__3__Impl"


    // $ANTLR start "rule__Sort__Group__4"
    // InternalMyDsl.g:3237:1: rule__Sort__Group__4 : rule__Sort__Group__4__Impl rule__Sort__Group__5 ;
    public final void rule__Sort__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:3241:1: ( rule__Sort__Group__4__Impl rule__Sort__Group__5 )
            // InternalMyDsl.g:3242:2: rule__Sort__Group__4__Impl rule__Sort__Group__5
            {
            pushFollow(FOLLOW_3);
            rule__Sort__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Sort__Group__5();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Sort__Group__4"


    // $ANTLR start "rule__Sort__Group__4__Impl"
    // InternalMyDsl.g:3249:1: rule__Sort__Group__4__Impl : ( 'table' ) ;
    public final void rule__Sort__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:3253:1: ( ( 'table' ) )
            // InternalMyDsl.g:3254:1: ( 'table' )
            {
            // InternalMyDsl.g:3254:1: ( 'table' )
            // InternalMyDsl.g:3255:2: 'table'
            {
             before(grammarAccess.getSortAccess().getTableKeyword_4()); 
            match(input,52,FOLLOW_2); 
             after(grammarAccess.getSortAccess().getTableKeyword_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Sort__Group__4__Impl"


    // $ANTLR start "rule__Sort__Group__5"
    // InternalMyDsl.g:3264:1: rule__Sort__Group__5 : rule__Sort__Group__5__Impl rule__Sort__Group__6 ;
    public final void rule__Sort__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:3268:1: ( rule__Sort__Group__5__Impl rule__Sort__Group__6 )
            // InternalMyDsl.g:3269:2: rule__Sort__Group__5__Impl rule__Sort__Group__6
            {
            pushFollow(FOLLOW_30);
            rule__Sort__Group__5__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Sort__Group__6();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Sort__Group__5"


    // $ANTLR start "rule__Sort__Group__5__Impl"
    // InternalMyDsl.g:3276:1: rule__Sort__Group__5__Impl : ( ( rule__Sort__TableAssignment_5 ) ) ;
    public final void rule__Sort__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:3280:1: ( ( ( rule__Sort__TableAssignment_5 ) ) )
            // InternalMyDsl.g:3281:1: ( ( rule__Sort__TableAssignment_5 ) )
            {
            // InternalMyDsl.g:3281:1: ( ( rule__Sort__TableAssignment_5 ) )
            // InternalMyDsl.g:3282:2: ( rule__Sort__TableAssignment_5 )
            {
             before(grammarAccess.getSortAccess().getTableAssignment_5()); 
            // InternalMyDsl.g:3283:2: ( rule__Sort__TableAssignment_5 )
            // InternalMyDsl.g:3283:3: rule__Sort__TableAssignment_5
            {
            pushFollow(FOLLOW_2);
            rule__Sort__TableAssignment_5();

            state._fsp--;


            }

             after(grammarAccess.getSortAccess().getTableAssignment_5()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Sort__Group__5__Impl"


    // $ANTLR start "rule__Sort__Group__6"
    // InternalMyDsl.g:3291:1: rule__Sort__Group__6 : rule__Sort__Group__6__Impl rule__Sort__Group__7 ;
    public final void rule__Sort__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:3295:1: ( rule__Sort__Group__6__Impl rule__Sort__Group__7 )
            // InternalMyDsl.g:3296:2: rule__Sort__Group__6__Impl rule__Sort__Group__7
            {
            pushFollow(FOLLOW_3);
            rule__Sort__Group__6__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Sort__Group__7();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Sort__Group__6"


    // $ANTLR start "rule__Sort__Group__6__Impl"
    // InternalMyDsl.g:3303:1: rule__Sort__Group__6__Impl : ( 'column' ) ;
    public final void rule__Sort__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:3307:1: ( ( 'column' ) )
            // InternalMyDsl.g:3308:1: ( 'column' )
            {
            // InternalMyDsl.g:3308:1: ( 'column' )
            // InternalMyDsl.g:3309:2: 'column'
            {
             before(grammarAccess.getSortAccess().getColumnKeyword_6()); 
            match(input,62,FOLLOW_2); 
             after(grammarAccess.getSortAccess().getColumnKeyword_6()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Sort__Group__6__Impl"


    // $ANTLR start "rule__Sort__Group__7"
    // InternalMyDsl.g:3318:1: rule__Sort__Group__7 : rule__Sort__Group__7__Impl rule__Sort__Group__8 ;
    public final void rule__Sort__Group__7() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:3322:1: ( rule__Sort__Group__7__Impl rule__Sort__Group__8 )
            // InternalMyDsl.g:3323:2: rule__Sort__Group__7__Impl rule__Sort__Group__8
            {
            pushFollow(FOLLOW_31);
            rule__Sort__Group__7__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Sort__Group__8();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Sort__Group__7"


    // $ANTLR start "rule__Sort__Group__7__Impl"
    // InternalMyDsl.g:3330:1: rule__Sort__Group__7__Impl : ( ( rule__Sort__ColumnAssignment_7 ) ) ;
    public final void rule__Sort__Group__7__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:3334:1: ( ( ( rule__Sort__ColumnAssignment_7 ) ) )
            // InternalMyDsl.g:3335:1: ( ( rule__Sort__ColumnAssignment_7 ) )
            {
            // InternalMyDsl.g:3335:1: ( ( rule__Sort__ColumnAssignment_7 ) )
            // InternalMyDsl.g:3336:2: ( rule__Sort__ColumnAssignment_7 )
            {
             before(grammarAccess.getSortAccess().getColumnAssignment_7()); 
            // InternalMyDsl.g:3337:2: ( rule__Sort__ColumnAssignment_7 )
            // InternalMyDsl.g:3337:3: rule__Sort__ColumnAssignment_7
            {
            pushFollow(FOLLOW_2);
            rule__Sort__ColumnAssignment_7();

            state._fsp--;


            }

             after(grammarAccess.getSortAccess().getColumnAssignment_7()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Sort__Group__7__Impl"


    // $ANTLR start "rule__Sort__Group__8"
    // InternalMyDsl.g:3345:1: rule__Sort__Group__8 : rule__Sort__Group__8__Impl rule__Sort__Group__9 ;
    public final void rule__Sort__Group__8() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:3349:1: ( rule__Sort__Group__8__Impl rule__Sort__Group__9 )
            // InternalMyDsl.g:3350:2: rule__Sort__Group__8__Impl rule__Sort__Group__9
            {
            pushFollow(FOLLOW_32);
            rule__Sort__Group__8__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Sort__Group__9();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Sort__Group__8"


    // $ANTLR start "rule__Sort__Group__8__Impl"
    // InternalMyDsl.g:3357:1: rule__Sort__Group__8__Impl : ( 'order' ) ;
    public final void rule__Sort__Group__8__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:3361:1: ( ( 'order' ) )
            // InternalMyDsl.g:3362:1: ( 'order' )
            {
            // InternalMyDsl.g:3362:1: ( 'order' )
            // InternalMyDsl.g:3363:2: 'order'
            {
             before(grammarAccess.getSortAccess().getOrderKeyword_8()); 
            match(input,63,FOLLOW_2); 
             after(grammarAccess.getSortAccess().getOrderKeyword_8()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Sort__Group__8__Impl"


    // $ANTLR start "rule__Sort__Group__9"
    // InternalMyDsl.g:3372:1: rule__Sort__Group__9 : rule__Sort__Group__9__Impl rule__Sort__Group__10 ;
    public final void rule__Sort__Group__9() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:3376:1: ( rule__Sort__Group__9__Impl rule__Sort__Group__10 )
            // InternalMyDsl.g:3377:2: rule__Sort__Group__9__Impl rule__Sort__Group__10
            {
            pushFollow(FOLLOW_29);
            rule__Sort__Group__9__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Sort__Group__10();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Sort__Group__9"


    // $ANTLR start "rule__Sort__Group__9__Impl"
    // InternalMyDsl.g:3384:1: rule__Sort__Group__9__Impl : ( ( rule__Sort__OrderAssignment_9 ) ) ;
    public final void rule__Sort__Group__9__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:3388:1: ( ( ( rule__Sort__OrderAssignment_9 ) ) )
            // InternalMyDsl.g:3389:1: ( ( rule__Sort__OrderAssignment_9 ) )
            {
            // InternalMyDsl.g:3389:1: ( ( rule__Sort__OrderAssignment_9 ) )
            // InternalMyDsl.g:3390:2: ( rule__Sort__OrderAssignment_9 )
            {
             before(grammarAccess.getSortAccess().getOrderAssignment_9()); 
            // InternalMyDsl.g:3391:2: ( rule__Sort__OrderAssignment_9 )
            // InternalMyDsl.g:3391:3: rule__Sort__OrderAssignment_9
            {
            pushFollow(FOLLOW_2);
            rule__Sort__OrderAssignment_9();

            state._fsp--;


            }

             after(grammarAccess.getSortAccess().getOrderAssignment_9()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Sort__Group__9__Impl"


    // $ANTLR start "rule__Sort__Group__10"
    // InternalMyDsl.g:3399:1: rule__Sort__Group__10 : rule__Sort__Group__10__Impl rule__Sort__Group__11 ;
    public final void rule__Sort__Group__10() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:3403:1: ( rule__Sort__Group__10__Impl rule__Sort__Group__11 )
            // InternalMyDsl.g:3404:2: rule__Sort__Group__10__Impl rule__Sort__Group__11
            {
            pushFollow(FOLLOW_3);
            rule__Sort__Group__10__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Sort__Group__11();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Sort__Group__10"


    // $ANTLR start "rule__Sort__Group__10__Impl"
    // InternalMyDsl.g:3411:1: rule__Sort__Group__10__Impl : ( 'next' ) ;
    public final void rule__Sort__Group__10__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:3415:1: ( ( 'next' ) )
            // InternalMyDsl.g:3416:1: ( 'next' )
            {
            // InternalMyDsl.g:3416:1: ( 'next' )
            // InternalMyDsl.g:3417:2: 'next'
            {
             before(grammarAccess.getSortAccess().getNextKeyword_10()); 
            match(input,60,FOLLOW_2); 
             after(grammarAccess.getSortAccess().getNextKeyword_10()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Sort__Group__10__Impl"


    // $ANTLR start "rule__Sort__Group__11"
    // InternalMyDsl.g:3426:1: rule__Sort__Group__11 : rule__Sort__Group__11__Impl rule__Sort__Group__12 ;
    public final void rule__Sort__Group__11() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:3430:1: ( rule__Sort__Group__11__Impl rule__Sort__Group__12 )
            // InternalMyDsl.g:3431:2: rule__Sort__Group__11__Impl rule__Sort__Group__12
            {
            pushFollow(FOLLOW_13);
            rule__Sort__Group__11__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Sort__Group__12();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Sort__Group__11"


    // $ANTLR start "rule__Sort__Group__11__Impl"
    // InternalMyDsl.g:3438:1: rule__Sort__Group__11__Impl : ( ( rule__Sort__NextAssignment_11 ) ) ;
    public final void rule__Sort__Group__11__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:3442:1: ( ( ( rule__Sort__NextAssignment_11 ) ) )
            // InternalMyDsl.g:3443:1: ( ( rule__Sort__NextAssignment_11 ) )
            {
            // InternalMyDsl.g:3443:1: ( ( rule__Sort__NextAssignment_11 ) )
            // InternalMyDsl.g:3444:2: ( rule__Sort__NextAssignment_11 )
            {
             before(grammarAccess.getSortAccess().getNextAssignment_11()); 
            // InternalMyDsl.g:3445:2: ( rule__Sort__NextAssignment_11 )
            // InternalMyDsl.g:3445:3: rule__Sort__NextAssignment_11
            {
            pushFollow(FOLLOW_2);
            rule__Sort__NextAssignment_11();

            state._fsp--;


            }

             after(grammarAccess.getSortAccess().getNextAssignment_11()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Sort__Group__11__Impl"


    // $ANTLR start "rule__Sort__Group__12"
    // InternalMyDsl.g:3453:1: rule__Sort__Group__12 : rule__Sort__Group__12__Impl ;
    public final void rule__Sort__Group__12() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:3457:1: ( rule__Sort__Group__12__Impl )
            // InternalMyDsl.g:3458:2: rule__Sort__Group__12__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Sort__Group__12__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Sort__Group__12"


    // $ANTLR start "rule__Sort__Group__12__Impl"
    // InternalMyDsl.g:3464:1: rule__Sort__Group__12__Impl : ( '}' ) ;
    public final void rule__Sort__Group__12__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:3468:1: ( ( '}' ) )
            // InternalMyDsl.g:3469:1: ( '}' )
            {
            // InternalMyDsl.g:3469:1: ( '}' )
            // InternalMyDsl.g:3470:2: '}'
            {
             before(grammarAccess.getSortAccess().getRightCurlyBracketKeyword_12()); 
            match(input,41,FOLLOW_2); 
             after(grammarAccess.getSortAccess().getRightCurlyBracketKeyword_12()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Sort__Group__12__Impl"


    // $ANTLR start "rule__Sort__Group_3__0"
    // InternalMyDsl.g:3480:1: rule__Sort__Group_3__0 : rule__Sort__Group_3__0__Impl rule__Sort__Group_3__1 ;
    public final void rule__Sort__Group_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:3484:1: ( rule__Sort__Group_3__0__Impl rule__Sort__Group_3__1 )
            // InternalMyDsl.g:3485:2: rule__Sort__Group_3__0__Impl rule__Sort__Group_3__1
            {
            pushFollow(FOLLOW_3);
            rule__Sort__Group_3__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Sort__Group_3__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Sort__Group_3__0"


    // $ANTLR start "rule__Sort__Group_3__0__Impl"
    // InternalMyDsl.g:3492:1: rule__Sort__Group_3__0__Impl : ( 'description' ) ;
    public final void rule__Sort__Group_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:3496:1: ( ( 'description' ) )
            // InternalMyDsl.g:3497:1: ( 'description' )
            {
            // InternalMyDsl.g:3497:1: ( 'description' )
            // InternalMyDsl.g:3498:2: 'description'
            {
             before(grammarAccess.getSortAccess().getDescriptionKeyword_3_0()); 
            match(input,50,FOLLOW_2); 
             after(grammarAccess.getSortAccess().getDescriptionKeyword_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Sort__Group_3__0__Impl"


    // $ANTLR start "rule__Sort__Group_3__1"
    // InternalMyDsl.g:3507:1: rule__Sort__Group_3__1 : rule__Sort__Group_3__1__Impl ;
    public final void rule__Sort__Group_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:3511:1: ( rule__Sort__Group_3__1__Impl )
            // InternalMyDsl.g:3512:2: rule__Sort__Group_3__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Sort__Group_3__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Sort__Group_3__1"


    // $ANTLR start "rule__Sort__Group_3__1__Impl"
    // InternalMyDsl.g:3518:1: rule__Sort__Group_3__1__Impl : ( ( rule__Sort__DescriptionAssignment_3_1 ) ) ;
    public final void rule__Sort__Group_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:3522:1: ( ( ( rule__Sort__DescriptionAssignment_3_1 ) ) )
            // InternalMyDsl.g:3523:1: ( ( rule__Sort__DescriptionAssignment_3_1 ) )
            {
            // InternalMyDsl.g:3523:1: ( ( rule__Sort__DescriptionAssignment_3_1 ) )
            // InternalMyDsl.g:3524:2: ( rule__Sort__DescriptionAssignment_3_1 )
            {
             before(grammarAccess.getSortAccess().getDescriptionAssignment_3_1()); 
            // InternalMyDsl.g:3525:2: ( rule__Sort__DescriptionAssignment_3_1 )
            // InternalMyDsl.g:3525:3: rule__Sort__DescriptionAssignment_3_1
            {
            pushFollow(FOLLOW_2);
            rule__Sort__DescriptionAssignment_3_1();

            state._fsp--;


            }

             after(grammarAccess.getSortAccess().getDescriptionAssignment_3_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Sort__Group_3__1__Impl"


    // $ANTLR start "rule__AppendRows__Group__0"
    // InternalMyDsl.g:3534:1: rule__AppendRows__Group__0 : rule__AppendRows__Group__0__Impl rule__AppendRows__Group__1 ;
    public final void rule__AppendRows__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:3538:1: ( rule__AppendRows__Group__0__Impl rule__AppendRows__Group__1 )
            // InternalMyDsl.g:3539:2: rule__AppendRows__Group__0__Impl rule__AppendRows__Group__1
            {
            pushFollow(FOLLOW_3);
            rule__AppendRows__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__AppendRows__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AppendRows__Group__0"


    // $ANTLR start "rule__AppendRows__Group__0__Impl"
    // InternalMyDsl.g:3546:1: rule__AppendRows__Group__0__Impl : ( 'AppendRows' ) ;
    public final void rule__AppendRows__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:3550:1: ( ( 'AppendRows' ) )
            // InternalMyDsl.g:3551:1: ( 'AppendRows' )
            {
            // InternalMyDsl.g:3551:1: ( 'AppendRows' )
            // InternalMyDsl.g:3552:2: 'AppendRows'
            {
             before(grammarAccess.getAppendRowsAccess().getAppendRowsKeyword_0()); 
            match(input,64,FOLLOW_2); 
             after(grammarAccess.getAppendRowsAccess().getAppendRowsKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AppendRows__Group__0__Impl"


    // $ANTLR start "rule__AppendRows__Group__1"
    // InternalMyDsl.g:3561:1: rule__AppendRows__Group__1 : rule__AppendRows__Group__1__Impl rule__AppendRows__Group__2 ;
    public final void rule__AppendRows__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:3565:1: ( rule__AppendRows__Group__1__Impl rule__AppendRows__Group__2 )
            // InternalMyDsl.g:3566:2: rule__AppendRows__Group__1__Impl rule__AppendRows__Group__2
            {
            pushFollow(FOLLOW_4);
            rule__AppendRows__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__AppendRows__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AppendRows__Group__1"


    // $ANTLR start "rule__AppendRows__Group__1__Impl"
    // InternalMyDsl.g:3573:1: rule__AppendRows__Group__1__Impl : ( ( rule__AppendRows__NameAssignment_1 ) ) ;
    public final void rule__AppendRows__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:3577:1: ( ( ( rule__AppendRows__NameAssignment_1 ) ) )
            // InternalMyDsl.g:3578:1: ( ( rule__AppendRows__NameAssignment_1 ) )
            {
            // InternalMyDsl.g:3578:1: ( ( rule__AppendRows__NameAssignment_1 ) )
            // InternalMyDsl.g:3579:2: ( rule__AppendRows__NameAssignment_1 )
            {
             before(grammarAccess.getAppendRowsAccess().getNameAssignment_1()); 
            // InternalMyDsl.g:3580:2: ( rule__AppendRows__NameAssignment_1 )
            // InternalMyDsl.g:3580:3: rule__AppendRows__NameAssignment_1
            {
            pushFollow(FOLLOW_2);
            rule__AppendRows__NameAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getAppendRowsAccess().getNameAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AppendRows__Group__1__Impl"


    // $ANTLR start "rule__AppendRows__Group__2"
    // InternalMyDsl.g:3588:1: rule__AppendRows__Group__2 : rule__AppendRows__Group__2__Impl rule__AppendRows__Group__3 ;
    public final void rule__AppendRows__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:3592:1: ( rule__AppendRows__Group__2__Impl rule__AppendRows__Group__3 )
            // InternalMyDsl.g:3593:2: rule__AppendRows__Group__2__Impl rule__AppendRows__Group__3
            {
            pushFollow(FOLLOW_33);
            rule__AppendRows__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__AppendRows__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AppendRows__Group__2"


    // $ANTLR start "rule__AppendRows__Group__2__Impl"
    // InternalMyDsl.g:3600:1: rule__AppendRows__Group__2__Impl : ( '{' ) ;
    public final void rule__AppendRows__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:3604:1: ( ( '{' ) )
            // InternalMyDsl.g:3605:1: ( '{' )
            {
            // InternalMyDsl.g:3605:1: ( '{' )
            // InternalMyDsl.g:3606:2: '{'
            {
             before(grammarAccess.getAppendRowsAccess().getLeftCurlyBracketKeyword_2()); 
            match(input,38,FOLLOW_2); 
             after(grammarAccess.getAppendRowsAccess().getLeftCurlyBracketKeyword_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AppendRows__Group__2__Impl"


    // $ANTLR start "rule__AppendRows__Group__3"
    // InternalMyDsl.g:3615:1: rule__AppendRows__Group__3 : rule__AppendRows__Group__3__Impl rule__AppendRows__Group__4 ;
    public final void rule__AppendRows__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:3619:1: ( rule__AppendRows__Group__3__Impl rule__AppendRows__Group__4 )
            // InternalMyDsl.g:3620:2: rule__AppendRows__Group__3__Impl rule__AppendRows__Group__4
            {
            pushFollow(FOLLOW_33);
            rule__AppendRows__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__AppendRows__Group__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AppendRows__Group__3"


    // $ANTLR start "rule__AppendRows__Group__3__Impl"
    // InternalMyDsl.g:3627:1: rule__AppendRows__Group__3__Impl : ( ( rule__AppendRows__Group_3__0 )? ) ;
    public final void rule__AppendRows__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:3631:1: ( ( ( rule__AppendRows__Group_3__0 )? ) )
            // InternalMyDsl.g:3632:1: ( ( rule__AppendRows__Group_3__0 )? )
            {
            // InternalMyDsl.g:3632:1: ( ( rule__AppendRows__Group_3__0 )? )
            // InternalMyDsl.g:3633:2: ( rule__AppendRows__Group_3__0 )?
            {
             before(grammarAccess.getAppendRowsAccess().getGroup_3()); 
            // InternalMyDsl.g:3634:2: ( rule__AppendRows__Group_3__0 )?
            int alt18=2;
            int LA18_0 = input.LA(1);

            if ( (LA18_0==50) ) {
                alt18=1;
            }
            switch (alt18) {
                case 1 :
                    // InternalMyDsl.g:3634:3: rule__AppendRows__Group_3__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__AppendRows__Group_3__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getAppendRowsAccess().getGroup_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AppendRows__Group__3__Impl"


    // $ANTLR start "rule__AppendRows__Group__4"
    // InternalMyDsl.g:3642:1: rule__AppendRows__Group__4 : rule__AppendRows__Group__4__Impl rule__AppendRows__Group__5 ;
    public final void rule__AppendRows__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:3646:1: ( rule__AppendRows__Group__4__Impl rule__AppendRows__Group__5 )
            // InternalMyDsl.g:3647:2: rule__AppendRows__Group__4__Impl rule__AppendRows__Group__5
            {
            pushFollow(FOLLOW_3);
            rule__AppendRows__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__AppendRows__Group__5();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AppendRows__Group__4"


    // $ANTLR start "rule__AppendRows__Group__4__Impl"
    // InternalMyDsl.g:3654:1: rule__AppendRows__Group__4__Impl : ( 'originTable' ) ;
    public final void rule__AppendRows__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:3658:1: ( ( 'originTable' ) )
            // InternalMyDsl.g:3659:1: ( 'originTable' )
            {
            // InternalMyDsl.g:3659:1: ( 'originTable' )
            // InternalMyDsl.g:3660:2: 'originTable'
            {
             before(grammarAccess.getAppendRowsAccess().getOriginTableKeyword_4()); 
            match(input,65,FOLLOW_2); 
             after(grammarAccess.getAppendRowsAccess().getOriginTableKeyword_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AppendRows__Group__4__Impl"


    // $ANTLR start "rule__AppendRows__Group__5"
    // InternalMyDsl.g:3669:1: rule__AppendRows__Group__5 : rule__AppendRows__Group__5__Impl rule__AppendRows__Group__6 ;
    public final void rule__AppendRows__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:3673:1: ( rule__AppendRows__Group__5__Impl rule__AppendRows__Group__6 )
            // InternalMyDsl.g:3674:2: rule__AppendRows__Group__5__Impl rule__AppendRows__Group__6
            {
            pushFollow(FOLLOW_34);
            rule__AppendRows__Group__5__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__AppendRows__Group__6();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AppendRows__Group__5"


    // $ANTLR start "rule__AppendRows__Group__5__Impl"
    // InternalMyDsl.g:3681:1: rule__AppendRows__Group__5__Impl : ( ( rule__AppendRows__OriginTableAssignment_5 ) ) ;
    public final void rule__AppendRows__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:3685:1: ( ( ( rule__AppendRows__OriginTableAssignment_5 ) ) )
            // InternalMyDsl.g:3686:1: ( ( rule__AppendRows__OriginTableAssignment_5 ) )
            {
            // InternalMyDsl.g:3686:1: ( ( rule__AppendRows__OriginTableAssignment_5 ) )
            // InternalMyDsl.g:3687:2: ( rule__AppendRows__OriginTableAssignment_5 )
            {
             before(grammarAccess.getAppendRowsAccess().getOriginTableAssignment_5()); 
            // InternalMyDsl.g:3688:2: ( rule__AppendRows__OriginTableAssignment_5 )
            // InternalMyDsl.g:3688:3: rule__AppendRows__OriginTableAssignment_5
            {
            pushFollow(FOLLOW_2);
            rule__AppendRows__OriginTableAssignment_5();

            state._fsp--;


            }

             after(grammarAccess.getAppendRowsAccess().getOriginTableAssignment_5()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AppendRows__Group__5__Impl"


    // $ANTLR start "rule__AppendRows__Group__6"
    // InternalMyDsl.g:3696:1: rule__AppendRows__Group__6 : rule__AppendRows__Group__6__Impl rule__AppendRows__Group__7 ;
    public final void rule__AppendRows__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:3700:1: ( rule__AppendRows__Group__6__Impl rule__AppendRows__Group__7 )
            // InternalMyDsl.g:3701:2: rule__AppendRows__Group__6__Impl rule__AppendRows__Group__7
            {
            pushFollow(FOLLOW_3);
            rule__AppendRows__Group__6__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__AppendRows__Group__7();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AppendRows__Group__6"


    // $ANTLR start "rule__AppendRows__Group__6__Impl"
    // InternalMyDsl.g:3708:1: rule__AppendRows__Group__6__Impl : ( 'destinTable' ) ;
    public final void rule__AppendRows__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:3712:1: ( ( 'destinTable' ) )
            // InternalMyDsl.g:3713:1: ( 'destinTable' )
            {
            // InternalMyDsl.g:3713:1: ( 'destinTable' )
            // InternalMyDsl.g:3714:2: 'destinTable'
            {
             before(grammarAccess.getAppendRowsAccess().getDestinTableKeyword_6()); 
            match(input,66,FOLLOW_2); 
             after(grammarAccess.getAppendRowsAccess().getDestinTableKeyword_6()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AppendRows__Group__6__Impl"


    // $ANTLR start "rule__AppendRows__Group__7"
    // InternalMyDsl.g:3723:1: rule__AppendRows__Group__7 : rule__AppendRows__Group__7__Impl rule__AppendRows__Group__8 ;
    public final void rule__AppendRows__Group__7() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:3727:1: ( rule__AppendRows__Group__7__Impl rule__AppendRows__Group__8 )
            // InternalMyDsl.g:3728:2: rule__AppendRows__Group__7__Impl rule__AppendRows__Group__8
            {
            pushFollow(FOLLOW_35);
            rule__AppendRows__Group__7__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__AppendRows__Group__8();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AppendRows__Group__7"


    // $ANTLR start "rule__AppendRows__Group__7__Impl"
    // InternalMyDsl.g:3735:1: rule__AppendRows__Group__7__Impl : ( ( rule__AppendRows__DestinTableAssignment_7 ) ) ;
    public final void rule__AppendRows__Group__7__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:3739:1: ( ( ( rule__AppendRows__DestinTableAssignment_7 ) ) )
            // InternalMyDsl.g:3740:1: ( ( rule__AppendRows__DestinTableAssignment_7 ) )
            {
            // InternalMyDsl.g:3740:1: ( ( rule__AppendRows__DestinTableAssignment_7 ) )
            // InternalMyDsl.g:3741:2: ( rule__AppendRows__DestinTableAssignment_7 )
            {
             before(grammarAccess.getAppendRowsAccess().getDestinTableAssignment_7()); 
            // InternalMyDsl.g:3742:2: ( rule__AppendRows__DestinTableAssignment_7 )
            // InternalMyDsl.g:3742:3: rule__AppendRows__DestinTableAssignment_7
            {
            pushFollow(FOLLOW_2);
            rule__AppendRows__DestinTableAssignment_7();

            state._fsp--;


            }

             after(grammarAccess.getAppendRowsAccess().getDestinTableAssignment_7()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AppendRows__Group__7__Impl"


    // $ANTLR start "rule__AppendRows__Group__8"
    // InternalMyDsl.g:3750:1: rule__AppendRows__Group__8 : rule__AppendRows__Group__8__Impl rule__AppendRows__Group__9 ;
    public final void rule__AppendRows__Group__8() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:3754:1: ( rule__AppendRows__Group__8__Impl rule__AppendRows__Group__9 )
            // InternalMyDsl.g:3755:2: rule__AppendRows__Group__8__Impl rule__AppendRows__Group__9
            {
            pushFollow(FOLLOW_4);
            rule__AppendRows__Group__8__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__AppendRows__Group__9();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AppendRows__Group__8"


    // $ANTLR start "rule__AppendRows__Group__8__Impl"
    // InternalMyDsl.g:3762:1: rule__AppendRows__Group__8__Impl : ( 'associations' ) ;
    public final void rule__AppendRows__Group__8__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:3766:1: ( ( 'associations' ) )
            // InternalMyDsl.g:3767:1: ( 'associations' )
            {
            // InternalMyDsl.g:3767:1: ( 'associations' )
            // InternalMyDsl.g:3768:2: 'associations'
            {
             before(grammarAccess.getAppendRowsAccess().getAssociationsKeyword_8()); 
            match(input,67,FOLLOW_2); 
             after(grammarAccess.getAppendRowsAccess().getAssociationsKeyword_8()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AppendRows__Group__8__Impl"


    // $ANTLR start "rule__AppendRows__Group__9"
    // InternalMyDsl.g:3777:1: rule__AppendRows__Group__9 : rule__AppendRows__Group__9__Impl rule__AppendRows__Group__10 ;
    public final void rule__AppendRows__Group__9() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:3781:1: ( rule__AppendRows__Group__9__Impl rule__AppendRows__Group__10 )
            // InternalMyDsl.g:3782:2: rule__AppendRows__Group__9__Impl rule__AppendRows__Group__10
            {
            pushFollow(FOLLOW_36);
            rule__AppendRows__Group__9__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__AppendRows__Group__10();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AppendRows__Group__9"


    // $ANTLR start "rule__AppendRows__Group__9__Impl"
    // InternalMyDsl.g:3789:1: rule__AppendRows__Group__9__Impl : ( '{' ) ;
    public final void rule__AppendRows__Group__9__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:3793:1: ( ( '{' ) )
            // InternalMyDsl.g:3794:1: ( '{' )
            {
            // InternalMyDsl.g:3794:1: ( '{' )
            // InternalMyDsl.g:3795:2: '{'
            {
             before(grammarAccess.getAppendRowsAccess().getLeftCurlyBracketKeyword_9()); 
            match(input,38,FOLLOW_2); 
             after(grammarAccess.getAppendRowsAccess().getLeftCurlyBracketKeyword_9()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AppendRows__Group__9__Impl"


    // $ANTLR start "rule__AppendRows__Group__10"
    // InternalMyDsl.g:3804:1: rule__AppendRows__Group__10 : rule__AppendRows__Group__10__Impl rule__AppendRows__Group__11 ;
    public final void rule__AppendRows__Group__10() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:3808:1: ( rule__AppendRows__Group__10__Impl rule__AppendRows__Group__11 )
            // InternalMyDsl.g:3809:2: rule__AppendRows__Group__10__Impl rule__AppendRows__Group__11
            {
            pushFollow(FOLLOW_9);
            rule__AppendRows__Group__10__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__AppendRows__Group__11();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AppendRows__Group__10"


    // $ANTLR start "rule__AppendRows__Group__10__Impl"
    // InternalMyDsl.g:3816:1: rule__AppendRows__Group__10__Impl : ( ( rule__AppendRows__AssociationsAssignment_10 ) ) ;
    public final void rule__AppendRows__Group__10__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:3820:1: ( ( ( rule__AppendRows__AssociationsAssignment_10 ) ) )
            // InternalMyDsl.g:3821:1: ( ( rule__AppendRows__AssociationsAssignment_10 ) )
            {
            // InternalMyDsl.g:3821:1: ( ( rule__AppendRows__AssociationsAssignment_10 ) )
            // InternalMyDsl.g:3822:2: ( rule__AppendRows__AssociationsAssignment_10 )
            {
             before(grammarAccess.getAppendRowsAccess().getAssociationsAssignment_10()); 
            // InternalMyDsl.g:3823:2: ( rule__AppendRows__AssociationsAssignment_10 )
            // InternalMyDsl.g:3823:3: rule__AppendRows__AssociationsAssignment_10
            {
            pushFollow(FOLLOW_2);
            rule__AppendRows__AssociationsAssignment_10();

            state._fsp--;


            }

             after(grammarAccess.getAppendRowsAccess().getAssociationsAssignment_10()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AppendRows__Group__10__Impl"


    // $ANTLR start "rule__AppendRows__Group__11"
    // InternalMyDsl.g:3831:1: rule__AppendRows__Group__11 : rule__AppendRows__Group__11__Impl rule__AppendRows__Group__12 ;
    public final void rule__AppendRows__Group__11() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:3835:1: ( rule__AppendRows__Group__11__Impl rule__AppendRows__Group__12 )
            // InternalMyDsl.g:3836:2: rule__AppendRows__Group__11__Impl rule__AppendRows__Group__12
            {
            pushFollow(FOLLOW_9);
            rule__AppendRows__Group__11__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__AppendRows__Group__12();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AppendRows__Group__11"


    // $ANTLR start "rule__AppendRows__Group__11__Impl"
    // InternalMyDsl.g:3843:1: rule__AppendRows__Group__11__Impl : ( ( rule__AppendRows__Group_11__0 )* ) ;
    public final void rule__AppendRows__Group__11__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:3847:1: ( ( ( rule__AppendRows__Group_11__0 )* ) )
            // InternalMyDsl.g:3848:1: ( ( rule__AppendRows__Group_11__0 )* )
            {
            // InternalMyDsl.g:3848:1: ( ( rule__AppendRows__Group_11__0 )* )
            // InternalMyDsl.g:3849:2: ( rule__AppendRows__Group_11__0 )*
            {
             before(grammarAccess.getAppendRowsAccess().getGroup_11()); 
            // InternalMyDsl.g:3850:2: ( rule__AppendRows__Group_11__0 )*
            loop19:
            do {
                int alt19=2;
                int LA19_0 = input.LA(1);

                if ( (LA19_0==43) ) {
                    alt19=1;
                }


                switch (alt19) {
            	case 1 :
            	    // InternalMyDsl.g:3850:3: rule__AppendRows__Group_11__0
            	    {
            	    pushFollow(FOLLOW_10);
            	    rule__AppendRows__Group_11__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop19;
                }
            } while (true);

             after(grammarAccess.getAppendRowsAccess().getGroup_11()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AppendRows__Group__11__Impl"


    // $ANTLR start "rule__AppendRows__Group__12"
    // InternalMyDsl.g:3858:1: rule__AppendRows__Group__12 : rule__AppendRows__Group__12__Impl rule__AppendRows__Group__13 ;
    public final void rule__AppendRows__Group__12() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:3862:1: ( rule__AppendRows__Group__12__Impl rule__AppendRows__Group__13 )
            // InternalMyDsl.g:3863:2: rule__AppendRows__Group__12__Impl rule__AppendRows__Group__13
            {
            pushFollow(FOLLOW_29);
            rule__AppendRows__Group__12__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__AppendRows__Group__13();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AppendRows__Group__12"


    // $ANTLR start "rule__AppendRows__Group__12__Impl"
    // InternalMyDsl.g:3870:1: rule__AppendRows__Group__12__Impl : ( '}' ) ;
    public final void rule__AppendRows__Group__12__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:3874:1: ( ( '}' ) )
            // InternalMyDsl.g:3875:1: ( '}' )
            {
            // InternalMyDsl.g:3875:1: ( '}' )
            // InternalMyDsl.g:3876:2: '}'
            {
             before(grammarAccess.getAppendRowsAccess().getRightCurlyBracketKeyword_12()); 
            match(input,41,FOLLOW_2); 
             after(grammarAccess.getAppendRowsAccess().getRightCurlyBracketKeyword_12()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AppendRows__Group__12__Impl"


    // $ANTLR start "rule__AppendRows__Group__13"
    // InternalMyDsl.g:3885:1: rule__AppendRows__Group__13 : rule__AppendRows__Group__13__Impl rule__AppendRows__Group__14 ;
    public final void rule__AppendRows__Group__13() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:3889:1: ( rule__AppendRows__Group__13__Impl rule__AppendRows__Group__14 )
            // InternalMyDsl.g:3890:2: rule__AppendRows__Group__13__Impl rule__AppendRows__Group__14
            {
            pushFollow(FOLLOW_3);
            rule__AppendRows__Group__13__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__AppendRows__Group__14();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AppendRows__Group__13"


    // $ANTLR start "rule__AppendRows__Group__13__Impl"
    // InternalMyDsl.g:3897:1: rule__AppendRows__Group__13__Impl : ( 'next' ) ;
    public final void rule__AppendRows__Group__13__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:3901:1: ( ( 'next' ) )
            // InternalMyDsl.g:3902:1: ( 'next' )
            {
            // InternalMyDsl.g:3902:1: ( 'next' )
            // InternalMyDsl.g:3903:2: 'next'
            {
             before(grammarAccess.getAppendRowsAccess().getNextKeyword_13()); 
            match(input,60,FOLLOW_2); 
             after(grammarAccess.getAppendRowsAccess().getNextKeyword_13()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AppendRows__Group__13__Impl"


    // $ANTLR start "rule__AppendRows__Group__14"
    // InternalMyDsl.g:3912:1: rule__AppendRows__Group__14 : rule__AppendRows__Group__14__Impl rule__AppendRows__Group__15 ;
    public final void rule__AppendRows__Group__14() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:3916:1: ( rule__AppendRows__Group__14__Impl rule__AppendRows__Group__15 )
            // InternalMyDsl.g:3917:2: rule__AppendRows__Group__14__Impl rule__AppendRows__Group__15
            {
            pushFollow(FOLLOW_13);
            rule__AppendRows__Group__14__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__AppendRows__Group__15();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AppendRows__Group__14"


    // $ANTLR start "rule__AppendRows__Group__14__Impl"
    // InternalMyDsl.g:3924:1: rule__AppendRows__Group__14__Impl : ( ( rule__AppendRows__NextAssignment_14 ) ) ;
    public final void rule__AppendRows__Group__14__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:3928:1: ( ( ( rule__AppendRows__NextAssignment_14 ) ) )
            // InternalMyDsl.g:3929:1: ( ( rule__AppendRows__NextAssignment_14 ) )
            {
            // InternalMyDsl.g:3929:1: ( ( rule__AppendRows__NextAssignment_14 ) )
            // InternalMyDsl.g:3930:2: ( rule__AppendRows__NextAssignment_14 )
            {
             before(grammarAccess.getAppendRowsAccess().getNextAssignment_14()); 
            // InternalMyDsl.g:3931:2: ( rule__AppendRows__NextAssignment_14 )
            // InternalMyDsl.g:3931:3: rule__AppendRows__NextAssignment_14
            {
            pushFollow(FOLLOW_2);
            rule__AppendRows__NextAssignment_14();

            state._fsp--;


            }

             after(grammarAccess.getAppendRowsAccess().getNextAssignment_14()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AppendRows__Group__14__Impl"


    // $ANTLR start "rule__AppendRows__Group__15"
    // InternalMyDsl.g:3939:1: rule__AppendRows__Group__15 : rule__AppendRows__Group__15__Impl ;
    public final void rule__AppendRows__Group__15() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:3943:1: ( rule__AppendRows__Group__15__Impl )
            // InternalMyDsl.g:3944:2: rule__AppendRows__Group__15__Impl
            {
            pushFollow(FOLLOW_2);
            rule__AppendRows__Group__15__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AppendRows__Group__15"


    // $ANTLR start "rule__AppendRows__Group__15__Impl"
    // InternalMyDsl.g:3950:1: rule__AppendRows__Group__15__Impl : ( '}' ) ;
    public final void rule__AppendRows__Group__15__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:3954:1: ( ( '}' ) )
            // InternalMyDsl.g:3955:1: ( '}' )
            {
            // InternalMyDsl.g:3955:1: ( '}' )
            // InternalMyDsl.g:3956:2: '}'
            {
             before(grammarAccess.getAppendRowsAccess().getRightCurlyBracketKeyword_15()); 
            match(input,41,FOLLOW_2); 
             after(grammarAccess.getAppendRowsAccess().getRightCurlyBracketKeyword_15()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AppendRows__Group__15__Impl"


    // $ANTLR start "rule__AppendRows__Group_3__0"
    // InternalMyDsl.g:3966:1: rule__AppendRows__Group_3__0 : rule__AppendRows__Group_3__0__Impl rule__AppendRows__Group_3__1 ;
    public final void rule__AppendRows__Group_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:3970:1: ( rule__AppendRows__Group_3__0__Impl rule__AppendRows__Group_3__1 )
            // InternalMyDsl.g:3971:2: rule__AppendRows__Group_3__0__Impl rule__AppendRows__Group_3__1
            {
            pushFollow(FOLLOW_3);
            rule__AppendRows__Group_3__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__AppendRows__Group_3__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AppendRows__Group_3__0"


    // $ANTLR start "rule__AppendRows__Group_3__0__Impl"
    // InternalMyDsl.g:3978:1: rule__AppendRows__Group_3__0__Impl : ( 'description' ) ;
    public final void rule__AppendRows__Group_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:3982:1: ( ( 'description' ) )
            // InternalMyDsl.g:3983:1: ( 'description' )
            {
            // InternalMyDsl.g:3983:1: ( 'description' )
            // InternalMyDsl.g:3984:2: 'description'
            {
             before(grammarAccess.getAppendRowsAccess().getDescriptionKeyword_3_0()); 
            match(input,50,FOLLOW_2); 
             after(grammarAccess.getAppendRowsAccess().getDescriptionKeyword_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AppendRows__Group_3__0__Impl"


    // $ANTLR start "rule__AppendRows__Group_3__1"
    // InternalMyDsl.g:3993:1: rule__AppendRows__Group_3__1 : rule__AppendRows__Group_3__1__Impl ;
    public final void rule__AppendRows__Group_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:3997:1: ( rule__AppendRows__Group_3__1__Impl )
            // InternalMyDsl.g:3998:2: rule__AppendRows__Group_3__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__AppendRows__Group_3__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AppendRows__Group_3__1"


    // $ANTLR start "rule__AppendRows__Group_3__1__Impl"
    // InternalMyDsl.g:4004:1: rule__AppendRows__Group_3__1__Impl : ( ( rule__AppendRows__DescriptionAssignment_3_1 ) ) ;
    public final void rule__AppendRows__Group_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:4008:1: ( ( ( rule__AppendRows__DescriptionAssignment_3_1 ) ) )
            // InternalMyDsl.g:4009:1: ( ( rule__AppendRows__DescriptionAssignment_3_1 ) )
            {
            // InternalMyDsl.g:4009:1: ( ( rule__AppendRows__DescriptionAssignment_3_1 ) )
            // InternalMyDsl.g:4010:2: ( rule__AppendRows__DescriptionAssignment_3_1 )
            {
             before(grammarAccess.getAppendRowsAccess().getDescriptionAssignment_3_1()); 
            // InternalMyDsl.g:4011:2: ( rule__AppendRows__DescriptionAssignment_3_1 )
            // InternalMyDsl.g:4011:3: rule__AppendRows__DescriptionAssignment_3_1
            {
            pushFollow(FOLLOW_2);
            rule__AppendRows__DescriptionAssignment_3_1();

            state._fsp--;


            }

             after(grammarAccess.getAppendRowsAccess().getDescriptionAssignment_3_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AppendRows__Group_3__1__Impl"


    // $ANTLR start "rule__AppendRows__Group_11__0"
    // InternalMyDsl.g:4020:1: rule__AppendRows__Group_11__0 : rule__AppendRows__Group_11__0__Impl rule__AppendRows__Group_11__1 ;
    public final void rule__AppendRows__Group_11__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:4024:1: ( rule__AppendRows__Group_11__0__Impl rule__AppendRows__Group_11__1 )
            // InternalMyDsl.g:4025:2: rule__AppendRows__Group_11__0__Impl rule__AppendRows__Group_11__1
            {
            pushFollow(FOLLOW_36);
            rule__AppendRows__Group_11__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__AppendRows__Group_11__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AppendRows__Group_11__0"


    // $ANTLR start "rule__AppendRows__Group_11__0__Impl"
    // InternalMyDsl.g:4032:1: rule__AppendRows__Group_11__0__Impl : ( ',' ) ;
    public final void rule__AppendRows__Group_11__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:4036:1: ( ( ',' ) )
            // InternalMyDsl.g:4037:1: ( ',' )
            {
            // InternalMyDsl.g:4037:1: ( ',' )
            // InternalMyDsl.g:4038:2: ','
            {
             before(grammarAccess.getAppendRowsAccess().getCommaKeyword_11_0()); 
            match(input,43,FOLLOW_2); 
             after(grammarAccess.getAppendRowsAccess().getCommaKeyword_11_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AppendRows__Group_11__0__Impl"


    // $ANTLR start "rule__AppendRows__Group_11__1"
    // InternalMyDsl.g:4047:1: rule__AppendRows__Group_11__1 : rule__AppendRows__Group_11__1__Impl ;
    public final void rule__AppendRows__Group_11__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:4051:1: ( rule__AppendRows__Group_11__1__Impl )
            // InternalMyDsl.g:4052:2: rule__AppendRows__Group_11__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__AppendRows__Group_11__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AppendRows__Group_11__1"


    // $ANTLR start "rule__AppendRows__Group_11__1__Impl"
    // InternalMyDsl.g:4058:1: rule__AppendRows__Group_11__1__Impl : ( ( rule__AppendRows__AssociationsAssignment_11_1 ) ) ;
    public final void rule__AppendRows__Group_11__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:4062:1: ( ( ( rule__AppendRows__AssociationsAssignment_11_1 ) ) )
            // InternalMyDsl.g:4063:1: ( ( rule__AppendRows__AssociationsAssignment_11_1 ) )
            {
            // InternalMyDsl.g:4063:1: ( ( rule__AppendRows__AssociationsAssignment_11_1 ) )
            // InternalMyDsl.g:4064:2: ( rule__AppendRows__AssociationsAssignment_11_1 )
            {
             before(grammarAccess.getAppendRowsAccess().getAssociationsAssignment_11_1()); 
            // InternalMyDsl.g:4065:2: ( rule__AppendRows__AssociationsAssignment_11_1 )
            // InternalMyDsl.g:4065:3: rule__AppendRows__AssociationsAssignment_11_1
            {
            pushFollow(FOLLOW_2);
            rule__AppendRows__AssociationsAssignment_11_1();

            state._fsp--;


            }

             after(grammarAccess.getAppendRowsAccess().getAssociationsAssignment_11_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AppendRows__Group_11__1__Impl"


    // $ANTLR start "rule__Filter__Group__0"
    // InternalMyDsl.g:4074:1: rule__Filter__Group__0 : rule__Filter__Group__0__Impl rule__Filter__Group__1 ;
    public final void rule__Filter__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:4078:1: ( rule__Filter__Group__0__Impl rule__Filter__Group__1 )
            // InternalMyDsl.g:4079:2: rule__Filter__Group__0__Impl rule__Filter__Group__1
            {
            pushFollow(FOLLOW_3);
            rule__Filter__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Filter__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Filter__Group__0"


    // $ANTLR start "rule__Filter__Group__0__Impl"
    // InternalMyDsl.g:4086:1: rule__Filter__Group__0__Impl : ( 'Filter' ) ;
    public final void rule__Filter__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:4090:1: ( ( 'Filter' ) )
            // InternalMyDsl.g:4091:1: ( 'Filter' )
            {
            // InternalMyDsl.g:4091:1: ( 'Filter' )
            // InternalMyDsl.g:4092:2: 'Filter'
            {
             before(grammarAccess.getFilterAccess().getFilterKeyword_0()); 
            match(input,68,FOLLOW_2); 
             after(grammarAccess.getFilterAccess().getFilterKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Filter__Group__0__Impl"


    // $ANTLR start "rule__Filter__Group__1"
    // InternalMyDsl.g:4101:1: rule__Filter__Group__1 : rule__Filter__Group__1__Impl rule__Filter__Group__2 ;
    public final void rule__Filter__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:4105:1: ( rule__Filter__Group__1__Impl rule__Filter__Group__2 )
            // InternalMyDsl.g:4106:2: rule__Filter__Group__1__Impl rule__Filter__Group__2
            {
            pushFollow(FOLLOW_4);
            rule__Filter__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Filter__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Filter__Group__1"


    // $ANTLR start "rule__Filter__Group__1__Impl"
    // InternalMyDsl.g:4113:1: rule__Filter__Group__1__Impl : ( ( rule__Filter__NameAssignment_1 ) ) ;
    public final void rule__Filter__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:4117:1: ( ( ( rule__Filter__NameAssignment_1 ) ) )
            // InternalMyDsl.g:4118:1: ( ( rule__Filter__NameAssignment_1 ) )
            {
            // InternalMyDsl.g:4118:1: ( ( rule__Filter__NameAssignment_1 ) )
            // InternalMyDsl.g:4119:2: ( rule__Filter__NameAssignment_1 )
            {
             before(grammarAccess.getFilterAccess().getNameAssignment_1()); 
            // InternalMyDsl.g:4120:2: ( rule__Filter__NameAssignment_1 )
            // InternalMyDsl.g:4120:3: rule__Filter__NameAssignment_1
            {
            pushFollow(FOLLOW_2);
            rule__Filter__NameAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getFilterAccess().getNameAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Filter__Group__1__Impl"


    // $ANTLR start "rule__Filter__Group__2"
    // InternalMyDsl.g:4128:1: rule__Filter__Group__2 : rule__Filter__Group__2__Impl rule__Filter__Group__3 ;
    public final void rule__Filter__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:4132:1: ( rule__Filter__Group__2__Impl rule__Filter__Group__3 )
            // InternalMyDsl.g:4133:2: rule__Filter__Group__2__Impl rule__Filter__Group__3
            {
            pushFollow(FOLLOW_20);
            rule__Filter__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Filter__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Filter__Group__2"


    // $ANTLR start "rule__Filter__Group__2__Impl"
    // InternalMyDsl.g:4140:1: rule__Filter__Group__2__Impl : ( '{' ) ;
    public final void rule__Filter__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:4144:1: ( ( '{' ) )
            // InternalMyDsl.g:4145:1: ( '{' )
            {
            // InternalMyDsl.g:4145:1: ( '{' )
            // InternalMyDsl.g:4146:2: '{'
            {
             before(grammarAccess.getFilterAccess().getLeftCurlyBracketKeyword_2()); 
            match(input,38,FOLLOW_2); 
             after(grammarAccess.getFilterAccess().getLeftCurlyBracketKeyword_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Filter__Group__2__Impl"


    // $ANTLR start "rule__Filter__Group__3"
    // InternalMyDsl.g:4155:1: rule__Filter__Group__3 : rule__Filter__Group__3__Impl rule__Filter__Group__4 ;
    public final void rule__Filter__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:4159:1: ( rule__Filter__Group__3__Impl rule__Filter__Group__4 )
            // InternalMyDsl.g:4160:2: rule__Filter__Group__3__Impl rule__Filter__Group__4
            {
            pushFollow(FOLLOW_20);
            rule__Filter__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Filter__Group__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Filter__Group__3"


    // $ANTLR start "rule__Filter__Group__3__Impl"
    // InternalMyDsl.g:4167:1: rule__Filter__Group__3__Impl : ( ( rule__Filter__Group_3__0 )? ) ;
    public final void rule__Filter__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:4171:1: ( ( ( rule__Filter__Group_3__0 )? ) )
            // InternalMyDsl.g:4172:1: ( ( rule__Filter__Group_3__0 )? )
            {
            // InternalMyDsl.g:4172:1: ( ( rule__Filter__Group_3__0 )? )
            // InternalMyDsl.g:4173:2: ( rule__Filter__Group_3__0 )?
            {
             before(grammarAccess.getFilterAccess().getGroup_3()); 
            // InternalMyDsl.g:4174:2: ( rule__Filter__Group_3__0 )?
            int alt20=2;
            int LA20_0 = input.LA(1);

            if ( (LA20_0==50) ) {
                alt20=1;
            }
            switch (alt20) {
                case 1 :
                    // InternalMyDsl.g:4174:3: rule__Filter__Group_3__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__Filter__Group_3__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getFilterAccess().getGroup_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Filter__Group__3__Impl"


    // $ANTLR start "rule__Filter__Group__4"
    // InternalMyDsl.g:4182:1: rule__Filter__Group__4 : rule__Filter__Group__4__Impl rule__Filter__Group__5 ;
    public final void rule__Filter__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:4186:1: ( rule__Filter__Group__4__Impl rule__Filter__Group__5 )
            // InternalMyDsl.g:4187:2: rule__Filter__Group__4__Impl rule__Filter__Group__5
            {
            pushFollow(FOLLOW_3);
            rule__Filter__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Filter__Group__5();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Filter__Group__4"


    // $ANTLR start "rule__Filter__Group__4__Impl"
    // InternalMyDsl.g:4194:1: rule__Filter__Group__4__Impl : ( 'table' ) ;
    public final void rule__Filter__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:4198:1: ( ( 'table' ) )
            // InternalMyDsl.g:4199:1: ( 'table' )
            {
            // InternalMyDsl.g:4199:1: ( 'table' )
            // InternalMyDsl.g:4200:2: 'table'
            {
             before(grammarAccess.getFilterAccess().getTableKeyword_4()); 
            match(input,52,FOLLOW_2); 
             after(grammarAccess.getFilterAccess().getTableKeyword_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Filter__Group__4__Impl"


    // $ANTLR start "rule__Filter__Group__5"
    // InternalMyDsl.g:4209:1: rule__Filter__Group__5 : rule__Filter__Group__5__Impl rule__Filter__Group__6 ;
    public final void rule__Filter__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:4213:1: ( rule__Filter__Group__5__Impl rule__Filter__Group__6 )
            // InternalMyDsl.g:4214:2: rule__Filter__Group__5__Impl rule__Filter__Group__6
            {
            pushFollow(FOLLOW_30);
            rule__Filter__Group__5__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Filter__Group__6();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Filter__Group__5"


    // $ANTLR start "rule__Filter__Group__5__Impl"
    // InternalMyDsl.g:4221:1: rule__Filter__Group__5__Impl : ( ( rule__Filter__TableAssignment_5 ) ) ;
    public final void rule__Filter__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:4225:1: ( ( ( rule__Filter__TableAssignment_5 ) ) )
            // InternalMyDsl.g:4226:1: ( ( rule__Filter__TableAssignment_5 ) )
            {
            // InternalMyDsl.g:4226:1: ( ( rule__Filter__TableAssignment_5 ) )
            // InternalMyDsl.g:4227:2: ( rule__Filter__TableAssignment_5 )
            {
             before(grammarAccess.getFilterAccess().getTableAssignment_5()); 
            // InternalMyDsl.g:4228:2: ( rule__Filter__TableAssignment_5 )
            // InternalMyDsl.g:4228:3: rule__Filter__TableAssignment_5
            {
            pushFollow(FOLLOW_2);
            rule__Filter__TableAssignment_5();

            state._fsp--;


            }

             after(grammarAccess.getFilterAccess().getTableAssignment_5()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Filter__Group__5__Impl"


    // $ANTLR start "rule__Filter__Group__6"
    // InternalMyDsl.g:4236:1: rule__Filter__Group__6 : rule__Filter__Group__6__Impl rule__Filter__Group__7 ;
    public final void rule__Filter__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:4240:1: ( rule__Filter__Group__6__Impl rule__Filter__Group__7 )
            // InternalMyDsl.g:4241:2: rule__Filter__Group__6__Impl rule__Filter__Group__7
            {
            pushFollow(FOLLOW_3);
            rule__Filter__Group__6__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Filter__Group__7();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Filter__Group__6"


    // $ANTLR start "rule__Filter__Group__6__Impl"
    // InternalMyDsl.g:4248:1: rule__Filter__Group__6__Impl : ( 'column' ) ;
    public final void rule__Filter__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:4252:1: ( ( 'column' ) )
            // InternalMyDsl.g:4253:1: ( 'column' )
            {
            // InternalMyDsl.g:4253:1: ( 'column' )
            // InternalMyDsl.g:4254:2: 'column'
            {
             before(grammarAccess.getFilterAccess().getColumnKeyword_6()); 
            match(input,62,FOLLOW_2); 
             after(grammarAccess.getFilterAccess().getColumnKeyword_6()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Filter__Group__6__Impl"


    // $ANTLR start "rule__Filter__Group__7"
    // InternalMyDsl.g:4263:1: rule__Filter__Group__7 : rule__Filter__Group__7__Impl rule__Filter__Group__8 ;
    public final void rule__Filter__Group__7() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:4267:1: ( rule__Filter__Group__7__Impl rule__Filter__Group__8 )
            // InternalMyDsl.g:4268:2: rule__Filter__Group__7__Impl rule__Filter__Group__8
            {
            pushFollow(FOLLOW_37);
            rule__Filter__Group__7__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Filter__Group__8();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Filter__Group__7"


    // $ANTLR start "rule__Filter__Group__7__Impl"
    // InternalMyDsl.g:4275:1: rule__Filter__Group__7__Impl : ( ( rule__Filter__ColumnAssignment_7 ) ) ;
    public final void rule__Filter__Group__7__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:4279:1: ( ( ( rule__Filter__ColumnAssignment_7 ) ) )
            // InternalMyDsl.g:4280:1: ( ( rule__Filter__ColumnAssignment_7 ) )
            {
            // InternalMyDsl.g:4280:1: ( ( rule__Filter__ColumnAssignment_7 ) )
            // InternalMyDsl.g:4281:2: ( rule__Filter__ColumnAssignment_7 )
            {
             before(grammarAccess.getFilterAccess().getColumnAssignment_7()); 
            // InternalMyDsl.g:4282:2: ( rule__Filter__ColumnAssignment_7 )
            // InternalMyDsl.g:4282:3: rule__Filter__ColumnAssignment_7
            {
            pushFollow(FOLLOW_2);
            rule__Filter__ColumnAssignment_7();

            state._fsp--;


            }

             after(grammarAccess.getFilterAccess().getColumnAssignment_7()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Filter__Group__7__Impl"


    // $ANTLR start "rule__Filter__Group__8"
    // InternalMyDsl.g:4290:1: rule__Filter__Group__8 : rule__Filter__Group__8__Impl rule__Filter__Group__9 ;
    public final void rule__Filter__Group__8() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:4294:1: ( rule__Filter__Group__8__Impl rule__Filter__Group__9 )
            // InternalMyDsl.g:4295:2: rule__Filter__Group__8__Impl rule__Filter__Group__9
            {
            pushFollow(FOLLOW_38);
            rule__Filter__Group__8__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Filter__Group__9();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Filter__Group__8"


    // $ANTLR start "rule__Filter__Group__8__Impl"
    // InternalMyDsl.g:4302:1: rule__Filter__Group__8__Impl : ( 'operator' ) ;
    public final void rule__Filter__Group__8__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:4306:1: ( ( 'operator' ) )
            // InternalMyDsl.g:4307:1: ( 'operator' )
            {
            // InternalMyDsl.g:4307:1: ( 'operator' )
            // InternalMyDsl.g:4308:2: 'operator'
            {
             before(grammarAccess.getFilterAccess().getOperatorKeyword_8()); 
            match(input,69,FOLLOW_2); 
             after(grammarAccess.getFilterAccess().getOperatorKeyword_8()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Filter__Group__8__Impl"


    // $ANTLR start "rule__Filter__Group__9"
    // InternalMyDsl.g:4317:1: rule__Filter__Group__9 : rule__Filter__Group__9__Impl rule__Filter__Group__10 ;
    public final void rule__Filter__Group__9() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:4321:1: ( rule__Filter__Group__9__Impl rule__Filter__Group__10 )
            // InternalMyDsl.g:4322:2: rule__Filter__Group__9__Impl rule__Filter__Group__10
            {
            pushFollow(FOLLOW_39);
            rule__Filter__Group__9__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Filter__Group__10();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Filter__Group__9"


    // $ANTLR start "rule__Filter__Group__9__Impl"
    // InternalMyDsl.g:4329:1: rule__Filter__Group__9__Impl : ( ( rule__Filter__OperatorAssignment_9 ) ) ;
    public final void rule__Filter__Group__9__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:4333:1: ( ( ( rule__Filter__OperatorAssignment_9 ) ) )
            // InternalMyDsl.g:4334:1: ( ( rule__Filter__OperatorAssignment_9 ) )
            {
            // InternalMyDsl.g:4334:1: ( ( rule__Filter__OperatorAssignment_9 ) )
            // InternalMyDsl.g:4335:2: ( rule__Filter__OperatorAssignment_9 )
            {
             before(grammarAccess.getFilterAccess().getOperatorAssignment_9()); 
            // InternalMyDsl.g:4336:2: ( rule__Filter__OperatorAssignment_9 )
            // InternalMyDsl.g:4336:3: rule__Filter__OperatorAssignment_9
            {
            pushFollow(FOLLOW_2);
            rule__Filter__OperatorAssignment_9();

            state._fsp--;


            }

             after(grammarAccess.getFilterAccess().getOperatorAssignment_9()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Filter__Group__9__Impl"


    // $ANTLR start "rule__Filter__Group__10"
    // InternalMyDsl.g:4344:1: rule__Filter__Group__10 : rule__Filter__Group__10__Impl rule__Filter__Group__11 ;
    public final void rule__Filter__Group__10() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:4348:1: ( rule__Filter__Group__10__Impl rule__Filter__Group__11 )
            // InternalMyDsl.g:4349:2: rule__Filter__Group__10__Impl rule__Filter__Group__11
            {
            pushFollow(FOLLOW_3);
            rule__Filter__Group__10__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Filter__Group__11();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Filter__Group__10"


    // $ANTLR start "rule__Filter__Group__10__Impl"
    // InternalMyDsl.g:4356:1: rule__Filter__Group__10__Impl : ( 'operand' ) ;
    public final void rule__Filter__Group__10__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:4360:1: ( ( 'operand' ) )
            // InternalMyDsl.g:4361:1: ( 'operand' )
            {
            // InternalMyDsl.g:4361:1: ( 'operand' )
            // InternalMyDsl.g:4362:2: 'operand'
            {
             before(grammarAccess.getFilterAccess().getOperandKeyword_10()); 
            match(input,70,FOLLOW_2); 
             after(grammarAccess.getFilterAccess().getOperandKeyword_10()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Filter__Group__10__Impl"


    // $ANTLR start "rule__Filter__Group__11"
    // InternalMyDsl.g:4371:1: rule__Filter__Group__11 : rule__Filter__Group__11__Impl rule__Filter__Group__12 ;
    public final void rule__Filter__Group__11() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:4375:1: ( rule__Filter__Group__11__Impl rule__Filter__Group__12 )
            // InternalMyDsl.g:4376:2: rule__Filter__Group__11__Impl rule__Filter__Group__12
            {
            pushFollow(FOLLOW_29);
            rule__Filter__Group__11__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Filter__Group__12();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Filter__Group__11"


    // $ANTLR start "rule__Filter__Group__11__Impl"
    // InternalMyDsl.g:4383:1: rule__Filter__Group__11__Impl : ( ( rule__Filter__OperandAssignment_11 ) ) ;
    public final void rule__Filter__Group__11__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:4387:1: ( ( ( rule__Filter__OperandAssignment_11 ) ) )
            // InternalMyDsl.g:4388:1: ( ( rule__Filter__OperandAssignment_11 ) )
            {
            // InternalMyDsl.g:4388:1: ( ( rule__Filter__OperandAssignment_11 ) )
            // InternalMyDsl.g:4389:2: ( rule__Filter__OperandAssignment_11 )
            {
             before(grammarAccess.getFilterAccess().getOperandAssignment_11()); 
            // InternalMyDsl.g:4390:2: ( rule__Filter__OperandAssignment_11 )
            // InternalMyDsl.g:4390:3: rule__Filter__OperandAssignment_11
            {
            pushFollow(FOLLOW_2);
            rule__Filter__OperandAssignment_11();

            state._fsp--;


            }

             after(grammarAccess.getFilterAccess().getOperandAssignment_11()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Filter__Group__11__Impl"


    // $ANTLR start "rule__Filter__Group__12"
    // InternalMyDsl.g:4398:1: rule__Filter__Group__12 : rule__Filter__Group__12__Impl rule__Filter__Group__13 ;
    public final void rule__Filter__Group__12() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:4402:1: ( rule__Filter__Group__12__Impl rule__Filter__Group__13 )
            // InternalMyDsl.g:4403:2: rule__Filter__Group__12__Impl rule__Filter__Group__13
            {
            pushFollow(FOLLOW_3);
            rule__Filter__Group__12__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Filter__Group__13();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Filter__Group__12"


    // $ANTLR start "rule__Filter__Group__12__Impl"
    // InternalMyDsl.g:4410:1: rule__Filter__Group__12__Impl : ( 'next' ) ;
    public final void rule__Filter__Group__12__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:4414:1: ( ( 'next' ) )
            // InternalMyDsl.g:4415:1: ( 'next' )
            {
            // InternalMyDsl.g:4415:1: ( 'next' )
            // InternalMyDsl.g:4416:2: 'next'
            {
             before(grammarAccess.getFilterAccess().getNextKeyword_12()); 
            match(input,60,FOLLOW_2); 
             after(grammarAccess.getFilterAccess().getNextKeyword_12()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Filter__Group__12__Impl"


    // $ANTLR start "rule__Filter__Group__13"
    // InternalMyDsl.g:4425:1: rule__Filter__Group__13 : rule__Filter__Group__13__Impl rule__Filter__Group__14 ;
    public final void rule__Filter__Group__13() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:4429:1: ( rule__Filter__Group__13__Impl rule__Filter__Group__14 )
            // InternalMyDsl.g:4430:2: rule__Filter__Group__13__Impl rule__Filter__Group__14
            {
            pushFollow(FOLLOW_13);
            rule__Filter__Group__13__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Filter__Group__14();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Filter__Group__13"


    // $ANTLR start "rule__Filter__Group__13__Impl"
    // InternalMyDsl.g:4437:1: rule__Filter__Group__13__Impl : ( ( rule__Filter__NextAssignment_13 ) ) ;
    public final void rule__Filter__Group__13__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:4441:1: ( ( ( rule__Filter__NextAssignment_13 ) ) )
            // InternalMyDsl.g:4442:1: ( ( rule__Filter__NextAssignment_13 ) )
            {
            // InternalMyDsl.g:4442:1: ( ( rule__Filter__NextAssignment_13 ) )
            // InternalMyDsl.g:4443:2: ( rule__Filter__NextAssignment_13 )
            {
             before(grammarAccess.getFilterAccess().getNextAssignment_13()); 
            // InternalMyDsl.g:4444:2: ( rule__Filter__NextAssignment_13 )
            // InternalMyDsl.g:4444:3: rule__Filter__NextAssignment_13
            {
            pushFollow(FOLLOW_2);
            rule__Filter__NextAssignment_13();

            state._fsp--;


            }

             after(grammarAccess.getFilterAccess().getNextAssignment_13()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Filter__Group__13__Impl"


    // $ANTLR start "rule__Filter__Group__14"
    // InternalMyDsl.g:4452:1: rule__Filter__Group__14 : rule__Filter__Group__14__Impl ;
    public final void rule__Filter__Group__14() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:4456:1: ( rule__Filter__Group__14__Impl )
            // InternalMyDsl.g:4457:2: rule__Filter__Group__14__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Filter__Group__14__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Filter__Group__14"


    // $ANTLR start "rule__Filter__Group__14__Impl"
    // InternalMyDsl.g:4463:1: rule__Filter__Group__14__Impl : ( '}' ) ;
    public final void rule__Filter__Group__14__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:4467:1: ( ( '}' ) )
            // InternalMyDsl.g:4468:1: ( '}' )
            {
            // InternalMyDsl.g:4468:1: ( '}' )
            // InternalMyDsl.g:4469:2: '}'
            {
             before(grammarAccess.getFilterAccess().getRightCurlyBracketKeyword_14()); 
            match(input,41,FOLLOW_2); 
             after(grammarAccess.getFilterAccess().getRightCurlyBracketKeyword_14()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Filter__Group__14__Impl"


    // $ANTLR start "rule__Filter__Group_3__0"
    // InternalMyDsl.g:4479:1: rule__Filter__Group_3__0 : rule__Filter__Group_3__0__Impl rule__Filter__Group_3__1 ;
    public final void rule__Filter__Group_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:4483:1: ( rule__Filter__Group_3__0__Impl rule__Filter__Group_3__1 )
            // InternalMyDsl.g:4484:2: rule__Filter__Group_3__0__Impl rule__Filter__Group_3__1
            {
            pushFollow(FOLLOW_3);
            rule__Filter__Group_3__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Filter__Group_3__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Filter__Group_3__0"


    // $ANTLR start "rule__Filter__Group_3__0__Impl"
    // InternalMyDsl.g:4491:1: rule__Filter__Group_3__0__Impl : ( 'description' ) ;
    public final void rule__Filter__Group_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:4495:1: ( ( 'description' ) )
            // InternalMyDsl.g:4496:1: ( 'description' )
            {
            // InternalMyDsl.g:4496:1: ( 'description' )
            // InternalMyDsl.g:4497:2: 'description'
            {
             before(grammarAccess.getFilterAccess().getDescriptionKeyword_3_0()); 
            match(input,50,FOLLOW_2); 
             after(grammarAccess.getFilterAccess().getDescriptionKeyword_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Filter__Group_3__0__Impl"


    // $ANTLR start "rule__Filter__Group_3__1"
    // InternalMyDsl.g:4506:1: rule__Filter__Group_3__1 : rule__Filter__Group_3__1__Impl ;
    public final void rule__Filter__Group_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:4510:1: ( rule__Filter__Group_3__1__Impl )
            // InternalMyDsl.g:4511:2: rule__Filter__Group_3__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Filter__Group_3__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Filter__Group_3__1"


    // $ANTLR start "rule__Filter__Group_3__1__Impl"
    // InternalMyDsl.g:4517:1: rule__Filter__Group_3__1__Impl : ( ( rule__Filter__DescriptionAssignment_3_1 ) ) ;
    public final void rule__Filter__Group_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:4521:1: ( ( ( rule__Filter__DescriptionAssignment_3_1 ) ) )
            // InternalMyDsl.g:4522:1: ( ( rule__Filter__DescriptionAssignment_3_1 ) )
            {
            // InternalMyDsl.g:4522:1: ( ( rule__Filter__DescriptionAssignment_3_1 ) )
            // InternalMyDsl.g:4523:2: ( rule__Filter__DescriptionAssignment_3_1 )
            {
             before(grammarAccess.getFilterAccess().getDescriptionAssignment_3_1()); 
            // InternalMyDsl.g:4524:2: ( rule__Filter__DescriptionAssignment_3_1 )
            // InternalMyDsl.g:4524:3: rule__Filter__DescriptionAssignment_3_1
            {
            pushFollow(FOLLOW_2);
            rule__Filter__DescriptionAssignment_3_1();

            state._fsp--;


            }

             after(grammarAccess.getFilterAccess().getDescriptionAssignment_3_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Filter__Group_3__1__Impl"


    // $ANTLR start "rule__GenericStep__Group__0"
    // InternalMyDsl.g:4533:1: rule__GenericStep__Group__0 : rule__GenericStep__Group__0__Impl rule__GenericStep__Group__1 ;
    public final void rule__GenericStep__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:4537:1: ( rule__GenericStep__Group__0__Impl rule__GenericStep__Group__1 )
            // InternalMyDsl.g:4538:2: rule__GenericStep__Group__0__Impl rule__GenericStep__Group__1
            {
            pushFollow(FOLLOW_3);
            rule__GenericStep__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__GenericStep__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__GenericStep__Group__0"


    // $ANTLR start "rule__GenericStep__Group__0__Impl"
    // InternalMyDsl.g:4545:1: rule__GenericStep__Group__0__Impl : ( 'GenericStep' ) ;
    public final void rule__GenericStep__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:4549:1: ( ( 'GenericStep' ) )
            // InternalMyDsl.g:4550:1: ( 'GenericStep' )
            {
            // InternalMyDsl.g:4550:1: ( 'GenericStep' )
            // InternalMyDsl.g:4551:2: 'GenericStep'
            {
             before(grammarAccess.getGenericStepAccess().getGenericStepKeyword_0()); 
            match(input,71,FOLLOW_2); 
             after(grammarAccess.getGenericStepAccess().getGenericStepKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__GenericStep__Group__0__Impl"


    // $ANTLR start "rule__GenericStep__Group__1"
    // InternalMyDsl.g:4560:1: rule__GenericStep__Group__1 : rule__GenericStep__Group__1__Impl rule__GenericStep__Group__2 ;
    public final void rule__GenericStep__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:4564:1: ( rule__GenericStep__Group__1__Impl rule__GenericStep__Group__2 )
            // InternalMyDsl.g:4565:2: rule__GenericStep__Group__1__Impl rule__GenericStep__Group__2
            {
            pushFollow(FOLLOW_4);
            rule__GenericStep__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__GenericStep__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__GenericStep__Group__1"


    // $ANTLR start "rule__GenericStep__Group__1__Impl"
    // InternalMyDsl.g:4572:1: rule__GenericStep__Group__1__Impl : ( ( rule__GenericStep__NameAssignment_1 ) ) ;
    public final void rule__GenericStep__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:4576:1: ( ( ( rule__GenericStep__NameAssignment_1 ) ) )
            // InternalMyDsl.g:4577:1: ( ( rule__GenericStep__NameAssignment_1 ) )
            {
            // InternalMyDsl.g:4577:1: ( ( rule__GenericStep__NameAssignment_1 ) )
            // InternalMyDsl.g:4578:2: ( rule__GenericStep__NameAssignment_1 )
            {
             before(grammarAccess.getGenericStepAccess().getNameAssignment_1()); 
            // InternalMyDsl.g:4579:2: ( rule__GenericStep__NameAssignment_1 )
            // InternalMyDsl.g:4579:3: rule__GenericStep__NameAssignment_1
            {
            pushFollow(FOLLOW_2);
            rule__GenericStep__NameAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getGenericStepAccess().getNameAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__GenericStep__Group__1__Impl"


    // $ANTLR start "rule__GenericStep__Group__2"
    // InternalMyDsl.g:4587:1: rule__GenericStep__Group__2 : rule__GenericStep__Group__2__Impl rule__GenericStep__Group__3 ;
    public final void rule__GenericStep__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:4591:1: ( rule__GenericStep__Group__2__Impl rule__GenericStep__Group__3 )
            // InternalMyDsl.g:4592:2: rule__GenericStep__Group__2__Impl rule__GenericStep__Group__3
            {
            pushFollow(FOLLOW_40);
            rule__GenericStep__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__GenericStep__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__GenericStep__Group__2"


    // $ANTLR start "rule__GenericStep__Group__2__Impl"
    // InternalMyDsl.g:4599:1: rule__GenericStep__Group__2__Impl : ( '{' ) ;
    public final void rule__GenericStep__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:4603:1: ( ( '{' ) )
            // InternalMyDsl.g:4604:1: ( '{' )
            {
            // InternalMyDsl.g:4604:1: ( '{' )
            // InternalMyDsl.g:4605:2: '{'
            {
             before(grammarAccess.getGenericStepAccess().getLeftCurlyBracketKeyword_2()); 
            match(input,38,FOLLOW_2); 
             after(grammarAccess.getGenericStepAccess().getLeftCurlyBracketKeyword_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__GenericStep__Group__2__Impl"


    // $ANTLR start "rule__GenericStep__Group__3"
    // InternalMyDsl.g:4614:1: rule__GenericStep__Group__3 : rule__GenericStep__Group__3__Impl rule__GenericStep__Group__4 ;
    public final void rule__GenericStep__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:4618:1: ( rule__GenericStep__Group__3__Impl rule__GenericStep__Group__4 )
            // InternalMyDsl.g:4619:2: rule__GenericStep__Group__3__Impl rule__GenericStep__Group__4
            {
            pushFollow(FOLLOW_40);
            rule__GenericStep__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__GenericStep__Group__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__GenericStep__Group__3"


    // $ANTLR start "rule__GenericStep__Group__3__Impl"
    // InternalMyDsl.g:4626:1: rule__GenericStep__Group__3__Impl : ( ( rule__GenericStep__Group_3__0 )? ) ;
    public final void rule__GenericStep__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:4630:1: ( ( ( rule__GenericStep__Group_3__0 )? ) )
            // InternalMyDsl.g:4631:1: ( ( rule__GenericStep__Group_3__0 )? )
            {
            // InternalMyDsl.g:4631:1: ( ( rule__GenericStep__Group_3__0 )? )
            // InternalMyDsl.g:4632:2: ( rule__GenericStep__Group_3__0 )?
            {
             before(grammarAccess.getGenericStepAccess().getGroup_3()); 
            // InternalMyDsl.g:4633:2: ( rule__GenericStep__Group_3__0 )?
            int alt21=2;
            int LA21_0 = input.LA(1);

            if ( (LA21_0==50) ) {
                alt21=1;
            }
            switch (alt21) {
                case 1 :
                    // InternalMyDsl.g:4633:3: rule__GenericStep__Group_3__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__GenericStep__Group_3__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getGenericStepAccess().getGroup_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__GenericStep__Group__3__Impl"


    // $ANTLR start "rule__GenericStep__Group__4"
    // InternalMyDsl.g:4641:1: rule__GenericStep__Group__4 : rule__GenericStep__Group__4__Impl rule__GenericStep__Group__5 ;
    public final void rule__GenericStep__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:4645:1: ( rule__GenericStep__Group__4__Impl rule__GenericStep__Group__5 )
            // InternalMyDsl.g:4646:2: rule__GenericStep__Group__4__Impl rule__GenericStep__Group__5
            {
            pushFollow(FOLLOW_3);
            rule__GenericStep__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__GenericStep__Group__5();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__GenericStep__Group__4"


    // $ANTLR start "rule__GenericStep__Group__4__Impl"
    // InternalMyDsl.g:4653:1: rule__GenericStep__Group__4__Impl : ( 'next' ) ;
    public final void rule__GenericStep__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:4657:1: ( ( 'next' ) )
            // InternalMyDsl.g:4658:1: ( 'next' )
            {
            // InternalMyDsl.g:4658:1: ( 'next' )
            // InternalMyDsl.g:4659:2: 'next'
            {
             before(grammarAccess.getGenericStepAccess().getNextKeyword_4()); 
            match(input,60,FOLLOW_2); 
             after(grammarAccess.getGenericStepAccess().getNextKeyword_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__GenericStep__Group__4__Impl"


    // $ANTLR start "rule__GenericStep__Group__5"
    // InternalMyDsl.g:4668:1: rule__GenericStep__Group__5 : rule__GenericStep__Group__5__Impl rule__GenericStep__Group__6 ;
    public final void rule__GenericStep__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:4672:1: ( rule__GenericStep__Group__5__Impl rule__GenericStep__Group__6 )
            // InternalMyDsl.g:4673:2: rule__GenericStep__Group__5__Impl rule__GenericStep__Group__6
            {
            pushFollow(FOLLOW_13);
            rule__GenericStep__Group__5__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__GenericStep__Group__6();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__GenericStep__Group__5"


    // $ANTLR start "rule__GenericStep__Group__5__Impl"
    // InternalMyDsl.g:4680:1: rule__GenericStep__Group__5__Impl : ( ( rule__GenericStep__NextAssignment_5 ) ) ;
    public final void rule__GenericStep__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:4684:1: ( ( ( rule__GenericStep__NextAssignment_5 ) ) )
            // InternalMyDsl.g:4685:1: ( ( rule__GenericStep__NextAssignment_5 ) )
            {
            // InternalMyDsl.g:4685:1: ( ( rule__GenericStep__NextAssignment_5 ) )
            // InternalMyDsl.g:4686:2: ( rule__GenericStep__NextAssignment_5 )
            {
             before(grammarAccess.getGenericStepAccess().getNextAssignment_5()); 
            // InternalMyDsl.g:4687:2: ( rule__GenericStep__NextAssignment_5 )
            // InternalMyDsl.g:4687:3: rule__GenericStep__NextAssignment_5
            {
            pushFollow(FOLLOW_2);
            rule__GenericStep__NextAssignment_5();

            state._fsp--;


            }

             after(grammarAccess.getGenericStepAccess().getNextAssignment_5()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__GenericStep__Group__5__Impl"


    // $ANTLR start "rule__GenericStep__Group__6"
    // InternalMyDsl.g:4695:1: rule__GenericStep__Group__6 : rule__GenericStep__Group__6__Impl ;
    public final void rule__GenericStep__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:4699:1: ( rule__GenericStep__Group__6__Impl )
            // InternalMyDsl.g:4700:2: rule__GenericStep__Group__6__Impl
            {
            pushFollow(FOLLOW_2);
            rule__GenericStep__Group__6__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__GenericStep__Group__6"


    // $ANTLR start "rule__GenericStep__Group__6__Impl"
    // InternalMyDsl.g:4706:1: rule__GenericStep__Group__6__Impl : ( '}' ) ;
    public final void rule__GenericStep__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:4710:1: ( ( '}' ) )
            // InternalMyDsl.g:4711:1: ( '}' )
            {
            // InternalMyDsl.g:4711:1: ( '}' )
            // InternalMyDsl.g:4712:2: '}'
            {
             before(grammarAccess.getGenericStepAccess().getRightCurlyBracketKeyword_6()); 
            match(input,41,FOLLOW_2); 
             after(grammarAccess.getGenericStepAccess().getRightCurlyBracketKeyword_6()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__GenericStep__Group__6__Impl"


    // $ANTLR start "rule__GenericStep__Group_3__0"
    // InternalMyDsl.g:4722:1: rule__GenericStep__Group_3__0 : rule__GenericStep__Group_3__0__Impl rule__GenericStep__Group_3__1 ;
    public final void rule__GenericStep__Group_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:4726:1: ( rule__GenericStep__Group_3__0__Impl rule__GenericStep__Group_3__1 )
            // InternalMyDsl.g:4727:2: rule__GenericStep__Group_3__0__Impl rule__GenericStep__Group_3__1
            {
            pushFollow(FOLLOW_3);
            rule__GenericStep__Group_3__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__GenericStep__Group_3__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__GenericStep__Group_3__0"


    // $ANTLR start "rule__GenericStep__Group_3__0__Impl"
    // InternalMyDsl.g:4734:1: rule__GenericStep__Group_3__0__Impl : ( 'description' ) ;
    public final void rule__GenericStep__Group_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:4738:1: ( ( 'description' ) )
            // InternalMyDsl.g:4739:1: ( 'description' )
            {
            // InternalMyDsl.g:4739:1: ( 'description' )
            // InternalMyDsl.g:4740:2: 'description'
            {
             before(grammarAccess.getGenericStepAccess().getDescriptionKeyword_3_0()); 
            match(input,50,FOLLOW_2); 
             after(grammarAccess.getGenericStepAccess().getDescriptionKeyword_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__GenericStep__Group_3__0__Impl"


    // $ANTLR start "rule__GenericStep__Group_3__1"
    // InternalMyDsl.g:4749:1: rule__GenericStep__Group_3__1 : rule__GenericStep__Group_3__1__Impl ;
    public final void rule__GenericStep__Group_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:4753:1: ( rule__GenericStep__Group_3__1__Impl )
            // InternalMyDsl.g:4754:2: rule__GenericStep__Group_3__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__GenericStep__Group_3__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__GenericStep__Group_3__1"


    // $ANTLR start "rule__GenericStep__Group_3__1__Impl"
    // InternalMyDsl.g:4760:1: rule__GenericStep__Group_3__1__Impl : ( ( rule__GenericStep__DescriptionAssignment_3_1 ) ) ;
    public final void rule__GenericStep__Group_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:4764:1: ( ( ( rule__GenericStep__DescriptionAssignment_3_1 ) ) )
            // InternalMyDsl.g:4765:1: ( ( rule__GenericStep__DescriptionAssignment_3_1 ) )
            {
            // InternalMyDsl.g:4765:1: ( ( rule__GenericStep__DescriptionAssignment_3_1 ) )
            // InternalMyDsl.g:4766:2: ( rule__GenericStep__DescriptionAssignment_3_1 )
            {
             before(grammarAccess.getGenericStepAccess().getDescriptionAssignment_3_1()); 
            // InternalMyDsl.g:4767:2: ( rule__GenericStep__DescriptionAssignment_3_1 )
            // InternalMyDsl.g:4767:3: rule__GenericStep__DescriptionAssignment_3_1
            {
            pushFollow(FOLLOW_2);
            rule__GenericStep__DescriptionAssignment_3_1();

            state._fsp--;


            }

             after(grammarAccess.getGenericStepAccess().getDescriptionAssignment_3_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__GenericStep__Group_3__1__Impl"


    // $ANTLR start "rule__Join__Group__0"
    // InternalMyDsl.g:4776:1: rule__Join__Group__0 : rule__Join__Group__0__Impl rule__Join__Group__1 ;
    public final void rule__Join__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:4780:1: ( rule__Join__Group__0__Impl rule__Join__Group__1 )
            // InternalMyDsl.g:4781:2: rule__Join__Group__0__Impl rule__Join__Group__1
            {
            pushFollow(FOLLOW_3);
            rule__Join__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Join__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Join__Group__0"


    // $ANTLR start "rule__Join__Group__0__Impl"
    // InternalMyDsl.g:4788:1: rule__Join__Group__0__Impl : ( 'Join' ) ;
    public final void rule__Join__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:4792:1: ( ( 'Join' ) )
            // InternalMyDsl.g:4793:1: ( 'Join' )
            {
            // InternalMyDsl.g:4793:1: ( 'Join' )
            // InternalMyDsl.g:4794:2: 'Join'
            {
             before(grammarAccess.getJoinAccess().getJoinKeyword_0()); 
            match(input,72,FOLLOW_2); 
             after(grammarAccess.getJoinAccess().getJoinKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Join__Group__0__Impl"


    // $ANTLR start "rule__Join__Group__1"
    // InternalMyDsl.g:4803:1: rule__Join__Group__1 : rule__Join__Group__1__Impl rule__Join__Group__2 ;
    public final void rule__Join__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:4807:1: ( rule__Join__Group__1__Impl rule__Join__Group__2 )
            // InternalMyDsl.g:4808:2: rule__Join__Group__1__Impl rule__Join__Group__2
            {
            pushFollow(FOLLOW_4);
            rule__Join__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Join__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Join__Group__1"


    // $ANTLR start "rule__Join__Group__1__Impl"
    // InternalMyDsl.g:4815:1: rule__Join__Group__1__Impl : ( ( rule__Join__NameAssignment_1 ) ) ;
    public final void rule__Join__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:4819:1: ( ( ( rule__Join__NameAssignment_1 ) ) )
            // InternalMyDsl.g:4820:1: ( ( rule__Join__NameAssignment_1 ) )
            {
            // InternalMyDsl.g:4820:1: ( ( rule__Join__NameAssignment_1 ) )
            // InternalMyDsl.g:4821:2: ( rule__Join__NameAssignment_1 )
            {
             before(grammarAccess.getJoinAccess().getNameAssignment_1()); 
            // InternalMyDsl.g:4822:2: ( rule__Join__NameAssignment_1 )
            // InternalMyDsl.g:4822:3: rule__Join__NameAssignment_1
            {
            pushFollow(FOLLOW_2);
            rule__Join__NameAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getJoinAccess().getNameAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Join__Group__1__Impl"


    // $ANTLR start "rule__Join__Group__2"
    // InternalMyDsl.g:4830:1: rule__Join__Group__2 : rule__Join__Group__2__Impl rule__Join__Group__3 ;
    public final void rule__Join__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:4834:1: ( rule__Join__Group__2__Impl rule__Join__Group__3 )
            // InternalMyDsl.g:4835:2: rule__Join__Group__2__Impl rule__Join__Group__3
            {
            pushFollow(FOLLOW_41);
            rule__Join__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Join__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Join__Group__2"


    // $ANTLR start "rule__Join__Group__2__Impl"
    // InternalMyDsl.g:4842:1: rule__Join__Group__2__Impl : ( '{' ) ;
    public final void rule__Join__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:4846:1: ( ( '{' ) )
            // InternalMyDsl.g:4847:1: ( '{' )
            {
            // InternalMyDsl.g:4847:1: ( '{' )
            // InternalMyDsl.g:4848:2: '{'
            {
             before(grammarAccess.getJoinAccess().getLeftCurlyBracketKeyword_2()); 
            match(input,38,FOLLOW_2); 
             after(grammarAccess.getJoinAccess().getLeftCurlyBracketKeyword_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Join__Group__2__Impl"


    // $ANTLR start "rule__Join__Group__3"
    // InternalMyDsl.g:4857:1: rule__Join__Group__3 : rule__Join__Group__3__Impl rule__Join__Group__4 ;
    public final void rule__Join__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:4861:1: ( rule__Join__Group__3__Impl rule__Join__Group__4 )
            // InternalMyDsl.g:4862:2: rule__Join__Group__3__Impl rule__Join__Group__4
            {
            pushFollow(FOLLOW_41);
            rule__Join__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Join__Group__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Join__Group__3"


    // $ANTLR start "rule__Join__Group__3__Impl"
    // InternalMyDsl.g:4869:1: rule__Join__Group__3__Impl : ( ( rule__Join__Group_3__0 )? ) ;
    public final void rule__Join__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:4873:1: ( ( ( rule__Join__Group_3__0 )? ) )
            // InternalMyDsl.g:4874:1: ( ( rule__Join__Group_3__0 )? )
            {
            // InternalMyDsl.g:4874:1: ( ( rule__Join__Group_3__0 )? )
            // InternalMyDsl.g:4875:2: ( rule__Join__Group_3__0 )?
            {
             before(grammarAccess.getJoinAccess().getGroup_3()); 
            // InternalMyDsl.g:4876:2: ( rule__Join__Group_3__0 )?
            int alt22=2;
            int LA22_0 = input.LA(1);

            if ( (LA22_0==50) ) {
                alt22=1;
            }
            switch (alt22) {
                case 1 :
                    // InternalMyDsl.g:4876:3: rule__Join__Group_3__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__Join__Group_3__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getJoinAccess().getGroup_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Join__Group__3__Impl"


    // $ANTLR start "rule__Join__Group__4"
    // InternalMyDsl.g:4884:1: rule__Join__Group__4 : rule__Join__Group__4__Impl rule__Join__Group__5 ;
    public final void rule__Join__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:4888:1: ( rule__Join__Group__4__Impl rule__Join__Group__5 )
            // InternalMyDsl.g:4889:2: rule__Join__Group__4__Impl rule__Join__Group__5
            {
            pushFollow(FOLLOW_3);
            rule__Join__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Join__Group__5();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Join__Group__4"


    // $ANTLR start "rule__Join__Group__4__Impl"
    // InternalMyDsl.g:4896:1: rule__Join__Group__4__Impl : ( 'tableLeft' ) ;
    public final void rule__Join__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:4900:1: ( ( 'tableLeft' ) )
            // InternalMyDsl.g:4901:1: ( 'tableLeft' )
            {
            // InternalMyDsl.g:4901:1: ( 'tableLeft' )
            // InternalMyDsl.g:4902:2: 'tableLeft'
            {
             before(grammarAccess.getJoinAccess().getTableLeftKeyword_4()); 
            match(input,73,FOLLOW_2); 
             after(grammarAccess.getJoinAccess().getTableLeftKeyword_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Join__Group__4__Impl"


    // $ANTLR start "rule__Join__Group__5"
    // InternalMyDsl.g:4911:1: rule__Join__Group__5 : rule__Join__Group__5__Impl rule__Join__Group__6 ;
    public final void rule__Join__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:4915:1: ( rule__Join__Group__5__Impl rule__Join__Group__6 )
            // InternalMyDsl.g:4916:2: rule__Join__Group__5__Impl rule__Join__Group__6
            {
            pushFollow(FOLLOW_42);
            rule__Join__Group__5__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Join__Group__6();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Join__Group__5"


    // $ANTLR start "rule__Join__Group__5__Impl"
    // InternalMyDsl.g:4923:1: rule__Join__Group__5__Impl : ( ( rule__Join__TableLeftAssignment_5 ) ) ;
    public final void rule__Join__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:4927:1: ( ( ( rule__Join__TableLeftAssignment_5 ) ) )
            // InternalMyDsl.g:4928:1: ( ( rule__Join__TableLeftAssignment_5 ) )
            {
            // InternalMyDsl.g:4928:1: ( ( rule__Join__TableLeftAssignment_5 ) )
            // InternalMyDsl.g:4929:2: ( rule__Join__TableLeftAssignment_5 )
            {
             before(grammarAccess.getJoinAccess().getTableLeftAssignment_5()); 
            // InternalMyDsl.g:4930:2: ( rule__Join__TableLeftAssignment_5 )
            // InternalMyDsl.g:4930:3: rule__Join__TableLeftAssignment_5
            {
            pushFollow(FOLLOW_2);
            rule__Join__TableLeftAssignment_5();

            state._fsp--;


            }

             after(grammarAccess.getJoinAccess().getTableLeftAssignment_5()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Join__Group__5__Impl"


    // $ANTLR start "rule__Join__Group__6"
    // InternalMyDsl.g:4938:1: rule__Join__Group__6 : rule__Join__Group__6__Impl rule__Join__Group__7 ;
    public final void rule__Join__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:4942:1: ( rule__Join__Group__6__Impl rule__Join__Group__7 )
            // InternalMyDsl.g:4943:2: rule__Join__Group__6__Impl rule__Join__Group__7
            {
            pushFollow(FOLLOW_3);
            rule__Join__Group__6__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Join__Group__7();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Join__Group__6"


    // $ANTLR start "rule__Join__Group__6__Impl"
    // InternalMyDsl.g:4950:1: rule__Join__Group__6__Impl : ( 'columnLeft' ) ;
    public final void rule__Join__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:4954:1: ( ( 'columnLeft' ) )
            // InternalMyDsl.g:4955:1: ( 'columnLeft' )
            {
            // InternalMyDsl.g:4955:1: ( 'columnLeft' )
            // InternalMyDsl.g:4956:2: 'columnLeft'
            {
             before(grammarAccess.getJoinAccess().getColumnLeftKeyword_6()); 
            match(input,74,FOLLOW_2); 
             after(grammarAccess.getJoinAccess().getColumnLeftKeyword_6()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Join__Group__6__Impl"


    // $ANTLR start "rule__Join__Group__7"
    // InternalMyDsl.g:4965:1: rule__Join__Group__7 : rule__Join__Group__7__Impl rule__Join__Group__8 ;
    public final void rule__Join__Group__7() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:4969:1: ( rule__Join__Group__7__Impl rule__Join__Group__8 )
            // InternalMyDsl.g:4970:2: rule__Join__Group__7__Impl rule__Join__Group__8
            {
            pushFollow(FOLLOW_43);
            rule__Join__Group__7__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Join__Group__8();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Join__Group__7"


    // $ANTLR start "rule__Join__Group__7__Impl"
    // InternalMyDsl.g:4977:1: rule__Join__Group__7__Impl : ( ( rule__Join__ColumnLeftAssignment_7 ) ) ;
    public final void rule__Join__Group__7__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:4981:1: ( ( ( rule__Join__ColumnLeftAssignment_7 ) ) )
            // InternalMyDsl.g:4982:1: ( ( rule__Join__ColumnLeftAssignment_7 ) )
            {
            // InternalMyDsl.g:4982:1: ( ( rule__Join__ColumnLeftAssignment_7 ) )
            // InternalMyDsl.g:4983:2: ( rule__Join__ColumnLeftAssignment_7 )
            {
             before(grammarAccess.getJoinAccess().getColumnLeftAssignment_7()); 
            // InternalMyDsl.g:4984:2: ( rule__Join__ColumnLeftAssignment_7 )
            // InternalMyDsl.g:4984:3: rule__Join__ColumnLeftAssignment_7
            {
            pushFollow(FOLLOW_2);
            rule__Join__ColumnLeftAssignment_7();

            state._fsp--;


            }

             after(grammarAccess.getJoinAccess().getColumnLeftAssignment_7()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Join__Group__7__Impl"


    // $ANTLR start "rule__Join__Group__8"
    // InternalMyDsl.g:4992:1: rule__Join__Group__8 : rule__Join__Group__8__Impl rule__Join__Group__9 ;
    public final void rule__Join__Group__8() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:4996:1: ( rule__Join__Group__8__Impl rule__Join__Group__9 )
            // InternalMyDsl.g:4997:2: rule__Join__Group__8__Impl rule__Join__Group__9
            {
            pushFollow(FOLLOW_44);
            rule__Join__Group__8__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Join__Group__9();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Join__Group__8"


    // $ANTLR start "rule__Join__Group__8__Impl"
    // InternalMyDsl.g:5004:1: rule__Join__Group__8__Impl : ( 'type' ) ;
    public final void rule__Join__Group__8__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:5008:1: ( ( 'type' ) )
            // InternalMyDsl.g:5009:1: ( 'type' )
            {
            // InternalMyDsl.g:5009:1: ( 'type' )
            // InternalMyDsl.g:5010:2: 'type'
            {
             before(grammarAccess.getJoinAccess().getTypeKeyword_8()); 
            match(input,75,FOLLOW_2); 
             after(grammarAccess.getJoinAccess().getTypeKeyword_8()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Join__Group__8__Impl"


    // $ANTLR start "rule__Join__Group__9"
    // InternalMyDsl.g:5019:1: rule__Join__Group__9 : rule__Join__Group__9__Impl rule__Join__Group__10 ;
    public final void rule__Join__Group__9() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:5023:1: ( rule__Join__Group__9__Impl rule__Join__Group__10 )
            // InternalMyDsl.g:5024:2: rule__Join__Group__9__Impl rule__Join__Group__10
            {
            pushFollow(FOLLOW_45);
            rule__Join__Group__9__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Join__Group__10();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Join__Group__9"


    // $ANTLR start "rule__Join__Group__9__Impl"
    // InternalMyDsl.g:5031:1: rule__Join__Group__9__Impl : ( ( rule__Join__TypeAssignment_9 ) ) ;
    public final void rule__Join__Group__9__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:5035:1: ( ( ( rule__Join__TypeAssignment_9 ) ) )
            // InternalMyDsl.g:5036:1: ( ( rule__Join__TypeAssignment_9 ) )
            {
            // InternalMyDsl.g:5036:1: ( ( rule__Join__TypeAssignment_9 ) )
            // InternalMyDsl.g:5037:2: ( rule__Join__TypeAssignment_9 )
            {
             before(grammarAccess.getJoinAccess().getTypeAssignment_9()); 
            // InternalMyDsl.g:5038:2: ( rule__Join__TypeAssignment_9 )
            // InternalMyDsl.g:5038:3: rule__Join__TypeAssignment_9
            {
            pushFollow(FOLLOW_2);
            rule__Join__TypeAssignment_9();

            state._fsp--;


            }

             after(grammarAccess.getJoinAccess().getTypeAssignment_9()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Join__Group__9__Impl"


    // $ANTLR start "rule__Join__Group__10"
    // InternalMyDsl.g:5046:1: rule__Join__Group__10 : rule__Join__Group__10__Impl rule__Join__Group__11 ;
    public final void rule__Join__Group__10() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:5050:1: ( rule__Join__Group__10__Impl rule__Join__Group__11 )
            // InternalMyDsl.g:5051:2: rule__Join__Group__10__Impl rule__Join__Group__11
            {
            pushFollow(FOLLOW_3);
            rule__Join__Group__10__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Join__Group__11();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Join__Group__10"


    // $ANTLR start "rule__Join__Group__10__Impl"
    // InternalMyDsl.g:5058:1: rule__Join__Group__10__Impl : ( 'tableRight' ) ;
    public final void rule__Join__Group__10__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:5062:1: ( ( 'tableRight' ) )
            // InternalMyDsl.g:5063:1: ( 'tableRight' )
            {
            // InternalMyDsl.g:5063:1: ( 'tableRight' )
            // InternalMyDsl.g:5064:2: 'tableRight'
            {
             before(grammarAccess.getJoinAccess().getTableRightKeyword_10()); 
            match(input,76,FOLLOW_2); 
             after(grammarAccess.getJoinAccess().getTableRightKeyword_10()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Join__Group__10__Impl"


    // $ANTLR start "rule__Join__Group__11"
    // InternalMyDsl.g:5073:1: rule__Join__Group__11 : rule__Join__Group__11__Impl rule__Join__Group__12 ;
    public final void rule__Join__Group__11() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:5077:1: ( rule__Join__Group__11__Impl rule__Join__Group__12 )
            // InternalMyDsl.g:5078:2: rule__Join__Group__11__Impl rule__Join__Group__12
            {
            pushFollow(FOLLOW_46);
            rule__Join__Group__11__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Join__Group__12();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Join__Group__11"


    // $ANTLR start "rule__Join__Group__11__Impl"
    // InternalMyDsl.g:5085:1: rule__Join__Group__11__Impl : ( ( rule__Join__TableRightAssignment_11 ) ) ;
    public final void rule__Join__Group__11__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:5089:1: ( ( ( rule__Join__TableRightAssignment_11 ) ) )
            // InternalMyDsl.g:5090:1: ( ( rule__Join__TableRightAssignment_11 ) )
            {
            // InternalMyDsl.g:5090:1: ( ( rule__Join__TableRightAssignment_11 ) )
            // InternalMyDsl.g:5091:2: ( rule__Join__TableRightAssignment_11 )
            {
             before(grammarAccess.getJoinAccess().getTableRightAssignment_11()); 
            // InternalMyDsl.g:5092:2: ( rule__Join__TableRightAssignment_11 )
            // InternalMyDsl.g:5092:3: rule__Join__TableRightAssignment_11
            {
            pushFollow(FOLLOW_2);
            rule__Join__TableRightAssignment_11();

            state._fsp--;


            }

             after(grammarAccess.getJoinAccess().getTableRightAssignment_11()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Join__Group__11__Impl"


    // $ANTLR start "rule__Join__Group__12"
    // InternalMyDsl.g:5100:1: rule__Join__Group__12 : rule__Join__Group__12__Impl rule__Join__Group__13 ;
    public final void rule__Join__Group__12() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:5104:1: ( rule__Join__Group__12__Impl rule__Join__Group__13 )
            // InternalMyDsl.g:5105:2: rule__Join__Group__12__Impl rule__Join__Group__13
            {
            pushFollow(FOLLOW_3);
            rule__Join__Group__12__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Join__Group__13();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Join__Group__12"


    // $ANTLR start "rule__Join__Group__12__Impl"
    // InternalMyDsl.g:5112:1: rule__Join__Group__12__Impl : ( 'columnRight' ) ;
    public final void rule__Join__Group__12__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:5116:1: ( ( 'columnRight' ) )
            // InternalMyDsl.g:5117:1: ( 'columnRight' )
            {
            // InternalMyDsl.g:5117:1: ( 'columnRight' )
            // InternalMyDsl.g:5118:2: 'columnRight'
            {
             before(grammarAccess.getJoinAccess().getColumnRightKeyword_12()); 
            match(input,77,FOLLOW_2); 
             after(grammarAccess.getJoinAccess().getColumnRightKeyword_12()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Join__Group__12__Impl"


    // $ANTLR start "rule__Join__Group__13"
    // InternalMyDsl.g:5127:1: rule__Join__Group__13 : rule__Join__Group__13__Impl rule__Join__Group__14 ;
    public final void rule__Join__Group__13() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:5131:1: ( rule__Join__Group__13__Impl rule__Join__Group__14 )
            // InternalMyDsl.g:5132:2: rule__Join__Group__13__Impl rule__Join__Group__14
            {
            pushFollow(FOLLOW_47);
            rule__Join__Group__13__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Join__Group__14();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Join__Group__13"


    // $ANTLR start "rule__Join__Group__13__Impl"
    // InternalMyDsl.g:5139:1: rule__Join__Group__13__Impl : ( ( rule__Join__ColumnRightAssignment_13 ) ) ;
    public final void rule__Join__Group__13__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:5143:1: ( ( ( rule__Join__ColumnRightAssignment_13 ) ) )
            // InternalMyDsl.g:5144:1: ( ( rule__Join__ColumnRightAssignment_13 ) )
            {
            // InternalMyDsl.g:5144:1: ( ( rule__Join__ColumnRightAssignment_13 ) )
            // InternalMyDsl.g:5145:2: ( rule__Join__ColumnRightAssignment_13 )
            {
             before(grammarAccess.getJoinAccess().getColumnRightAssignment_13()); 
            // InternalMyDsl.g:5146:2: ( rule__Join__ColumnRightAssignment_13 )
            // InternalMyDsl.g:5146:3: rule__Join__ColumnRightAssignment_13
            {
            pushFollow(FOLLOW_2);
            rule__Join__ColumnRightAssignment_13();

            state._fsp--;


            }

             after(grammarAccess.getJoinAccess().getColumnRightAssignment_13()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Join__Group__13__Impl"


    // $ANTLR start "rule__Join__Group__14"
    // InternalMyDsl.g:5154:1: rule__Join__Group__14 : rule__Join__Group__14__Impl rule__Join__Group__15 ;
    public final void rule__Join__Group__14() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:5158:1: ( rule__Join__Group__14__Impl rule__Join__Group__15 )
            // InternalMyDsl.g:5159:2: rule__Join__Group__14__Impl rule__Join__Group__15
            {
            pushFollow(FOLLOW_22);
            rule__Join__Group__14__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Join__Group__15();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Join__Group__14"


    // $ANTLR start "rule__Join__Group__14__Impl"
    // InternalMyDsl.g:5166:1: rule__Join__Group__14__Impl : ( 'selectColumns' ) ;
    public final void rule__Join__Group__14__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:5170:1: ( ( 'selectColumns' ) )
            // InternalMyDsl.g:5171:1: ( 'selectColumns' )
            {
            // InternalMyDsl.g:5171:1: ( 'selectColumns' )
            // InternalMyDsl.g:5172:2: 'selectColumns'
            {
             before(grammarAccess.getJoinAccess().getSelectColumnsKeyword_14()); 
            match(input,78,FOLLOW_2); 
             after(grammarAccess.getJoinAccess().getSelectColumnsKeyword_14()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Join__Group__14__Impl"


    // $ANTLR start "rule__Join__Group__15"
    // InternalMyDsl.g:5181:1: rule__Join__Group__15 : rule__Join__Group__15__Impl rule__Join__Group__16 ;
    public final void rule__Join__Group__15() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:5185:1: ( rule__Join__Group__15__Impl rule__Join__Group__16 )
            // InternalMyDsl.g:5186:2: rule__Join__Group__15__Impl rule__Join__Group__16
            {
            pushFollow(FOLLOW_3);
            rule__Join__Group__15__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Join__Group__16();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Join__Group__15"


    // $ANTLR start "rule__Join__Group__15__Impl"
    // InternalMyDsl.g:5193:1: rule__Join__Group__15__Impl : ( '(' ) ;
    public final void rule__Join__Group__15__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:5197:1: ( ( '(' ) )
            // InternalMyDsl.g:5198:1: ( '(' )
            {
            // InternalMyDsl.g:5198:1: ( '(' )
            // InternalMyDsl.g:5199:2: '('
            {
             before(grammarAccess.getJoinAccess().getLeftParenthesisKeyword_15()); 
            match(input,54,FOLLOW_2); 
             after(grammarAccess.getJoinAccess().getLeftParenthesisKeyword_15()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Join__Group__15__Impl"


    // $ANTLR start "rule__Join__Group__16"
    // InternalMyDsl.g:5208:1: rule__Join__Group__16 : rule__Join__Group__16__Impl rule__Join__Group__17 ;
    public final void rule__Join__Group__16() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:5212:1: ( rule__Join__Group__16__Impl rule__Join__Group__17 )
            // InternalMyDsl.g:5213:2: rule__Join__Group__16__Impl rule__Join__Group__17
            {
            pushFollow(FOLLOW_23);
            rule__Join__Group__16__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Join__Group__17();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Join__Group__16"


    // $ANTLR start "rule__Join__Group__16__Impl"
    // InternalMyDsl.g:5220:1: rule__Join__Group__16__Impl : ( ( rule__Join__SelectColumnsAssignment_16 ) ) ;
    public final void rule__Join__Group__16__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:5224:1: ( ( ( rule__Join__SelectColumnsAssignment_16 ) ) )
            // InternalMyDsl.g:5225:1: ( ( rule__Join__SelectColumnsAssignment_16 ) )
            {
            // InternalMyDsl.g:5225:1: ( ( rule__Join__SelectColumnsAssignment_16 ) )
            // InternalMyDsl.g:5226:2: ( rule__Join__SelectColumnsAssignment_16 )
            {
             before(grammarAccess.getJoinAccess().getSelectColumnsAssignment_16()); 
            // InternalMyDsl.g:5227:2: ( rule__Join__SelectColumnsAssignment_16 )
            // InternalMyDsl.g:5227:3: rule__Join__SelectColumnsAssignment_16
            {
            pushFollow(FOLLOW_2);
            rule__Join__SelectColumnsAssignment_16();

            state._fsp--;


            }

             after(grammarAccess.getJoinAccess().getSelectColumnsAssignment_16()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Join__Group__16__Impl"


    // $ANTLR start "rule__Join__Group__17"
    // InternalMyDsl.g:5235:1: rule__Join__Group__17 : rule__Join__Group__17__Impl rule__Join__Group__18 ;
    public final void rule__Join__Group__17() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:5239:1: ( rule__Join__Group__17__Impl rule__Join__Group__18 )
            // InternalMyDsl.g:5240:2: rule__Join__Group__17__Impl rule__Join__Group__18
            {
            pushFollow(FOLLOW_23);
            rule__Join__Group__17__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Join__Group__18();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Join__Group__17"


    // $ANTLR start "rule__Join__Group__17__Impl"
    // InternalMyDsl.g:5247:1: rule__Join__Group__17__Impl : ( ( rule__Join__Group_17__0 )* ) ;
    public final void rule__Join__Group__17__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:5251:1: ( ( ( rule__Join__Group_17__0 )* ) )
            // InternalMyDsl.g:5252:1: ( ( rule__Join__Group_17__0 )* )
            {
            // InternalMyDsl.g:5252:1: ( ( rule__Join__Group_17__0 )* )
            // InternalMyDsl.g:5253:2: ( rule__Join__Group_17__0 )*
            {
             before(grammarAccess.getJoinAccess().getGroup_17()); 
            // InternalMyDsl.g:5254:2: ( rule__Join__Group_17__0 )*
            loop23:
            do {
                int alt23=2;
                int LA23_0 = input.LA(1);

                if ( (LA23_0==43) ) {
                    alt23=1;
                }


                switch (alt23) {
            	case 1 :
            	    // InternalMyDsl.g:5254:3: rule__Join__Group_17__0
            	    {
            	    pushFollow(FOLLOW_10);
            	    rule__Join__Group_17__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop23;
                }
            } while (true);

             after(grammarAccess.getJoinAccess().getGroup_17()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Join__Group__17__Impl"


    // $ANTLR start "rule__Join__Group__18"
    // InternalMyDsl.g:5262:1: rule__Join__Group__18 : rule__Join__Group__18__Impl rule__Join__Group__19 ;
    public final void rule__Join__Group__18() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:5266:1: ( rule__Join__Group__18__Impl rule__Join__Group__19 )
            // InternalMyDsl.g:5267:2: rule__Join__Group__18__Impl rule__Join__Group__19
            {
            pushFollow(FOLLOW_27);
            rule__Join__Group__18__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Join__Group__19();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Join__Group__18"


    // $ANTLR start "rule__Join__Group__18__Impl"
    // InternalMyDsl.g:5274:1: rule__Join__Group__18__Impl : ( ')' ) ;
    public final void rule__Join__Group__18__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:5278:1: ( ( ')' ) )
            // InternalMyDsl.g:5279:1: ( ')' )
            {
            // InternalMyDsl.g:5279:1: ( ')' )
            // InternalMyDsl.g:5280:2: ')'
            {
             before(grammarAccess.getJoinAccess().getRightParenthesisKeyword_18()); 
            match(input,55,FOLLOW_2); 
             after(grammarAccess.getJoinAccess().getRightParenthesisKeyword_18()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Join__Group__18__Impl"


    // $ANTLR start "rule__Join__Group__19"
    // InternalMyDsl.g:5289:1: rule__Join__Group__19 : rule__Join__Group__19__Impl rule__Join__Group__20 ;
    public final void rule__Join__Group__19() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:5293:1: ( rule__Join__Group__19__Impl rule__Join__Group__20 )
            // InternalMyDsl.g:5294:2: rule__Join__Group__19__Impl rule__Join__Group__20
            {
            pushFollow(FOLLOW_3);
            rule__Join__Group__19__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Join__Group__20();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Join__Group__19"


    // $ANTLR start "rule__Join__Group__19__Impl"
    // InternalMyDsl.g:5301:1: rule__Join__Group__19__Impl : ( 'resultTable' ) ;
    public final void rule__Join__Group__19__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:5305:1: ( ( 'resultTable' ) )
            // InternalMyDsl.g:5306:1: ( 'resultTable' )
            {
            // InternalMyDsl.g:5306:1: ( 'resultTable' )
            // InternalMyDsl.g:5307:2: 'resultTable'
            {
             before(grammarAccess.getJoinAccess().getResultTableKeyword_19()); 
            match(input,58,FOLLOW_2); 
             after(grammarAccess.getJoinAccess().getResultTableKeyword_19()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Join__Group__19__Impl"


    // $ANTLR start "rule__Join__Group__20"
    // InternalMyDsl.g:5316:1: rule__Join__Group__20 : rule__Join__Group__20__Impl rule__Join__Group__21 ;
    public final void rule__Join__Group__20() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:5320:1: ( rule__Join__Group__20__Impl rule__Join__Group__21 )
            // InternalMyDsl.g:5321:2: rule__Join__Group__20__Impl rule__Join__Group__21
            {
            pushFollow(FOLLOW_29);
            rule__Join__Group__20__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Join__Group__21();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Join__Group__20"


    // $ANTLR start "rule__Join__Group__20__Impl"
    // InternalMyDsl.g:5328:1: rule__Join__Group__20__Impl : ( ( rule__Join__ResultTableAssignment_20 ) ) ;
    public final void rule__Join__Group__20__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:5332:1: ( ( ( rule__Join__ResultTableAssignment_20 ) ) )
            // InternalMyDsl.g:5333:1: ( ( rule__Join__ResultTableAssignment_20 ) )
            {
            // InternalMyDsl.g:5333:1: ( ( rule__Join__ResultTableAssignment_20 ) )
            // InternalMyDsl.g:5334:2: ( rule__Join__ResultTableAssignment_20 )
            {
             before(grammarAccess.getJoinAccess().getResultTableAssignment_20()); 
            // InternalMyDsl.g:5335:2: ( rule__Join__ResultTableAssignment_20 )
            // InternalMyDsl.g:5335:3: rule__Join__ResultTableAssignment_20
            {
            pushFollow(FOLLOW_2);
            rule__Join__ResultTableAssignment_20();

            state._fsp--;


            }

             after(grammarAccess.getJoinAccess().getResultTableAssignment_20()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Join__Group__20__Impl"


    // $ANTLR start "rule__Join__Group__21"
    // InternalMyDsl.g:5343:1: rule__Join__Group__21 : rule__Join__Group__21__Impl rule__Join__Group__22 ;
    public final void rule__Join__Group__21() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:5347:1: ( rule__Join__Group__21__Impl rule__Join__Group__22 )
            // InternalMyDsl.g:5348:2: rule__Join__Group__21__Impl rule__Join__Group__22
            {
            pushFollow(FOLLOW_3);
            rule__Join__Group__21__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Join__Group__22();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Join__Group__21"


    // $ANTLR start "rule__Join__Group__21__Impl"
    // InternalMyDsl.g:5355:1: rule__Join__Group__21__Impl : ( 'next' ) ;
    public final void rule__Join__Group__21__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:5359:1: ( ( 'next' ) )
            // InternalMyDsl.g:5360:1: ( 'next' )
            {
            // InternalMyDsl.g:5360:1: ( 'next' )
            // InternalMyDsl.g:5361:2: 'next'
            {
             before(grammarAccess.getJoinAccess().getNextKeyword_21()); 
            match(input,60,FOLLOW_2); 
             after(grammarAccess.getJoinAccess().getNextKeyword_21()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Join__Group__21__Impl"


    // $ANTLR start "rule__Join__Group__22"
    // InternalMyDsl.g:5370:1: rule__Join__Group__22 : rule__Join__Group__22__Impl rule__Join__Group__23 ;
    public final void rule__Join__Group__22() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:5374:1: ( rule__Join__Group__22__Impl rule__Join__Group__23 )
            // InternalMyDsl.g:5375:2: rule__Join__Group__22__Impl rule__Join__Group__23
            {
            pushFollow(FOLLOW_13);
            rule__Join__Group__22__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Join__Group__23();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Join__Group__22"


    // $ANTLR start "rule__Join__Group__22__Impl"
    // InternalMyDsl.g:5382:1: rule__Join__Group__22__Impl : ( ( rule__Join__NextAssignment_22 ) ) ;
    public final void rule__Join__Group__22__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:5386:1: ( ( ( rule__Join__NextAssignment_22 ) ) )
            // InternalMyDsl.g:5387:1: ( ( rule__Join__NextAssignment_22 ) )
            {
            // InternalMyDsl.g:5387:1: ( ( rule__Join__NextAssignment_22 ) )
            // InternalMyDsl.g:5388:2: ( rule__Join__NextAssignment_22 )
            {
             before(grammarAccess.getJoinAccess().getNextAssignment_22()); 
            // InternalMyDsl.g:5389:2: ( rule__Join__NextAssignment_22 )
            // InternalMyDsl.g:5389:3: rule__Join__NextAssignment_22
            {
            pushFollow(FOLLOW_2);
            rule__Join__NextAssignment_22();

            state._fsp--;


            }

             after(grammarAccess.getJoinAccess().getNextAssignment_22()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Join__Group__22__Impl"


    // $ANTLR start "rule__Join__Group__23"
    // InternalMyDsl.g:5397:1: rule__Join__Group__23 : rule__Join__Group__23__Impl ;
    public final void rule__Join__Group__23() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:5401:1: ( rule__Join__Group__23__Impl )
            // InternalMyDsl.g:5402:2: rule__Join__Group__23__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Join__Group__23__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Join__Group__23"


    // $ANTLR start "rule__Join__Group__23__Impl"
    // InternalMyDsl.g:5408:1: rule__Join__Group__23__Impl : ( '}' ) ;
    public final void rule__Join__Group__23__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:5412:1: ( ( '}' ) )
            // InternalMyDsl.g:5413:1: ( '}' )
            {
            // InternalMyDsl.g:5413:1: ( '}' )
            // InternalMyDsl.g:5414:2: '}'
            {
             before(grammarAccess.getJoinAccess().getRightCurlyBracketKeyword_23()); 
            match(input,41,FOLLOW_2); 
             after(grammarAccess.getJoinAccess().getRightCurlyBracketKeyword_23()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Join__Group__23__Impl"


    // $ANTLR start "rule__Join__Group_3__0"
    // InternalMyDsl.g:5424:1: rule__Join__Group_3__0 : rule__Join__Group_3__0__Impl rule__Join__Group_3__1 ;
    public final void rule__Join__Group_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:5428:1: ( rule__Join__Group_3__0__Impl rule__Join__Group_3__1 )
            // InternalMyDsl.g:5429:2: rule__Join__Group_3__0__Impl rule__Join__Group_3__1
            {
            pushFollow(FOLLOW_3);
            rule__Join__Group_3__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Join__Group_3__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Join__Group_3__0"


    // $ANTLR start "rule__Join__Group_3__0__Impl"
    // InternalMyDsl.g:5436:1: rule__Join__Group_3__0__Impl : ( 'description' ) ;
    public final void rule__Join__Group_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:5440:1: ( ( 'description' ) )
            // InternalMyDsl.g:5441:1: ( 'description' )
            {
            // InternalMyDsl.g:5441:1: ( 'description' )
            // InternalMyDsl.g:5442:2: 'description'
            {
             before(grammarAccess.getJoinAccess().getDescriptionKeyword_3_0()); 
            match(input,50,FOLLOW_2); 
             after(grammarAccess.getJoinAccess().getDescriptionKeyword_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Join__Group_3__0__Impl"


    // $ANTLR start "rule__Join__Group_3__1"
    // InternalMyDsl.g:5451:1: rule__Join__Group_3__1 : rule__Join__Group_3__1__Impl ;
    public final void rule__Join__Group_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:5455:1: ( rule__Join__Group_3__1__Impl )
            // InternalMyDsl.g:5456:2: rule__Join__Group_3__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Join__Group_3__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Join__Group_3__1"


    // $ANTLR start "rule__Join__Group_3__1__Impl"
    // InternalMyDsl.g:5462:1: rule__Join__Group_3__1__Impl : ( ( rule__Join__DescriptionAssignment_3_1 ) ) ;
    public final void rule__Join__Group_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:5466:1: ( ( ( rule__Join__DescriptionAssignment_3_1 ) ) )
            // InternalMyDsl.g:5467:1: ( ( rule__Join__DescriptionAssignment_3_1 ) )
            {
            // InternalMyDsl.g:5467:1: ( ( rule__Join__DescriptionAssignment_3_1 ) )
            // InternalMyDsl.g:5468:2: ( rule__Join__DescriptionAssignment_3_1 )
            {
             before(grammarAccess.getJoinAccess().getDescriptionAssignment_3_1()); 
            // InternalMyDsl.g:5469:2: ( rule__Join__DescriptionAssignment_3_1 )
            // InternalMyDsl.g:5469:3: rule__Join__DescriptionAssignment_3_1
            {
            pushFollow(FOLLOW_2);
            rule__Join__DescriptionAssignment_3_1();

            state._fsp--;


            }

             after(grammarAccess.getJoinAccess().getDescriptionAssignment_3_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Join__Group_3__1__Impl"


    // $ANTLR start "rule__Join__Group_17__0"
    // InternalMyDsl.g:5478:1: rule__Join__Group_17__0 : rule__Join__Group_17__0__Impl rule__Join__Group_17__1 ;
    public final void rule__Join__Group_17__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:5482:1: ( rule__Join__Group_17__0__Impl rule__Join__Group_17__1 )
            // InternalMyDsl.g:5483:2: rule__Join__Group_17__0__Impl rule__Join__Group_17__1
            {
            pushFollow(FOLLOW_3);
            rule__Join__Group_17__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Join__Group_17__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Join__Group_17__0"


    // $ANTLR start "rule__Join__Group_17__0__Impl"
    // InternalMyDsl.g:5490:1: rule__Join__Group_17__0__Impl : ( ',' ) ;
    public final void rule__Join__Group_17__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:5494:1: ( ( ',' ) )
            // InternalMyDsl.g:5495:1: ( ',' )
            {
            // InternalMyDsl.g:5495:1: ( ',' )
            // InternalMyDsl.g:5496:2: ','
            {
             before(grammarAccess.getJoinAccess().getCommaKeyword_17_0()); 
            match(input,43,FOLLOW_2); 
             after(grammarAccess.getJoinAccess().getCommaKeyword_17_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Join__Group_17__0__Impl"


    // $ANTLR start "rule__Join__Group_17__1"
    // InternalMyDsl.g:5505:1: rule__Join__Group_17__1 : rule__Join__Group_17__1__Impl ;
    public final void rule__Join__Group_17__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:5509:1: ( rule__Join__Group_17__1__Impl )
            // InternalMyDsl.g:5510:2: rule__Join__Group_17__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Join__Group_17__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Join__Group_17__1"


    // $ANTLR start "rule__Join__Group_17__1__Impl"
    // InternalMyDsl.g:5516:1: rule__Join__Group_17__1__Impl : ( ( rule__Join__SelectColumnsAssignment_17_1 ) ) ;
    public final void rule__Join__Group_17__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:5520:1: ( ( ( rule__Join__SelectColumnsAssignment_17_1 ) ) )
            // InternalMyDsl.g:5521:1: ( ( rule__Join__SelectColumnsAssignment_17_1 ) )
            {
            // InternalMyDsl.g:5521:1: ( ( rule__Join__SelectColumnsAssignment_17_1 ) )
            // InternalMyDsl.g:5522:2: ( rule__Join__SelectColumnsAssignment_17_1 )
            {
             before(grammarAccess.getJoinAccess().getSelectColumnsAssignment_17_1()); 
            // InternalMyDsl.g:5523:2: ( rule__Join__SelectColumnsAssignment_17_1 )
            // InternalMyDsl.g:5523:3: rule__Join__SelectColumnsAssignment_17_1
            {
            pushFollow(FOLLOW_2);
            rule__Join__SelectColumnsAssignment_17_1();

            state._fsp--;


            }

             after(grammarAccess.getJoinAccess().getSelectColumnsAssignment_17_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Join__Group_17__1__Impl"


    // $ANTLR start "rule__Import__Group__0"
    // InternalMyDsl.g:5532:1: rule__Import__Group__0 : rule__Import__Group__0__Impl rule__Import__Group__1 ;
    public final void rule__Import__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:5536:1: ( rule__Import__Group__0__Impl rule__Import__Group__1 )
            // InternalMyDsl.g:5537:2: rule__Import__Group__0__Impl rule__Import__Group__1
            {
            pushFollow(FOLLOW_3);
            rule__Import__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Import__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Import__Group__0"


    // $ANTLR start "rule__Import__Group__0__Impl"
    // InternalMyDsl.g:5544:1: rule__Import__Group__0__Impl : ( 'Import' ) ;
    public final void rule__Import__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:5548:1: ( ( 'Import' ) )
            // InternalMyDsl.g:5549:1: ( 'Import' )
            {
            // InternalMyDsl.g:5549:1: ( 'Import' )
            // InternalMyDsl.g:5550:2: 'Import'
            {
             before(grammarAccess.getImportAccess().getImportKeyword_0()); 
            match(input,79,FOLLOW_2); 
             after(grammarAccess.getImportAccess().getImportKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Import__Group__0__Impl"


    // $ANTLR start "rule__Import__Group__1"
    // InternalMyDsl.g:5559:1: rule__Import__Group__1 : rule__Import__Group__1__Impl rule__Import__Group__2 ;
    public final void rule__Import__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:5563:1: ( rule__Import__Group__1__Impl rule__Import__Group__2 )
            // InternalMyDsl.g:5564:2: rule__Import__Group__1__Impl rule__Import__Group__2
            {
            pushFollow(FOLLOW_4);
            rule__Import__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Import__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Import__Group__1"


    // $ANTLR start "rule__Import__Group__1__Impl"
    // InternalMyDsl.g:5571:1: rule__Import__Group__1__Impl : ( ( rule__Import__NameAssignment_1 ) ) ;
    public final void rule__Import__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:5575:1: ( ( ( rule__Import__NameAssignment_1 ) ) )
            // InternalMyDsl.g:5576:1: ( ( rule__Import__NameAssignment_1 ) )
            {
            // InternalMyDsl.g:5576:1: ( ( rule__Import__NameAssignment_1 ) )
            // InternalMyDsl.g:5577:2: ( rule__Import__NameAssignment_1 )
            {
             before(grammarAccess.getImportAccess().getNameAssignment_1()); 
            // InternalMyDsl.g:5578:2: ( rule__Import__NameAssignment_1 )
            // InternalMyDsl.g:5578:3: rule__Import__NameAssignment_1
            {
            pushFollow(FOLLOW_2);
            rule__Import__NameAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getImportAccess().getNameAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Import__Group__1__Impl"


    // $ANTLR start "rule__Import__Group__2"
    // InternalMyDsl.g:5586:1: rule__Import__Group__2 : rule__Import__Group__2__Impl rule__Import__Group__3 ;
    public final void rule__Import__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:5590:1: ( rule__Import__Group__2__Impl rule__Import__Group__3 )
            // InternalMyDsl.g:5591:2: rule__Import__Group__2__Impl rule__Import__Group__3
            {
            pushFollow(FOLLOW_48);
            rule__Import__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Import__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Import__Group__2"


    // $ANTLR start "rule__Import__Group__2__Impl"
    // InternalMyDsl.g:5598:1: rule__Import__Group__2__Impl : ( '{' ) ;
    public final void rule__Import__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:5602:1: ( ( '{' ) )
            // InternalMyDsl.g:5603:1: ( '{' )
            {
            // InternalMyDsl.g:5603:1: ( '{' )
            // InternalMyDsl.g:5604:2: '{'
            {
             before(grammarAccess.getImportAccess().getLeftCurlyBracketKeyword_2()); 
            match(input,38,FOLLOW_2); 
             after(grammarAccess.getImportAccess().getLeftCurlyBracketKeyword_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Import__Group__2__Impl"


    // $ANTLR start "rule__Import__Group__3"
    // InternalMyDsl.g:5613:1: rule__Import__Group__3 : rule__Import__Group__3__Impl rule__Import__Group__4 ;
    public final void rule__Import__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:5617:1: ( rule__Import__Group__3__Impl rule__Import__Group__4 )
            // InternalMyDsl.g:5618:2: rule__Import__Group__3__Impl rule__Import__Group__4
            {
            pushFollow(FOLLOW_48);
            rule__Import__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Import__Group__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Import__Group__3"


    // $ANTLR start "rule__Import__Group__3__Impl"
    // InternalMyDsl.g:5625:1: rule__Import__Group__3__Impl : ( ( rule__Import__Group_3__0 )? ) ;
    public final void rule__Import__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:5629:1: ( ( ( rule__Import__Group_3__0 )? ) )
            // InternalMyDsl.g:5630:1: ( ( rule__Import__Group_3__0 )? )
            {
            // InternalMyDsl.g:5630:1: ( ( rule__Import__Group_3__0 )? )
            // InternalMyDsl.g:5631:2: ( rule__Import__Group_3__0 )?
            {
             before(grammarAccess.getImportAccess().getGroup_3()); 
            // InternalMyDsl.g:5632:2: ( rule__Import__Group_3__0 )?
            int alt24=2;
            int LA24_0 = input.LA(1);

            if ( (LA24_0==50) ) {
                alt24=1;
            }
            switch (alt24) {
                case 1 :
                    // InternalMyDsl.g:5632:3: rule__Import__Group_3__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__Import__Group_3__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getImportAccess().getGroup_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Import__Group__3__Impl"


    // $ANTLR start "rule__Import__Group__4"
    // InternalMyDsl.g:5640:1: rule__Import__Group__4 : rule__Import__Group__4__Impl rule__Import__Group__5 ;
    public final void rule__Import__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:5644:1: ( rule__Import__Group__4__Impl rule__Import__Group__5 )
            // InternalMyDsl.g:5645:2: rule__Import__Group__4__Impl rule__Import__Group__5
            {
            pushFollow(FOLLOW_4);
            rule__Import__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Import__Group__5();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Import__Group__4"


    // $ANTLR start "rule__Import__Group__4__Impl"
    // InternalMyDsl.g:5652:1: rule__Import__Group__4__Impl : ( 'tablesToImport' ) ;
    public final void rule__Import__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:5656:1: ( ( 'tablesToImport' ) )
            // InternalMyDsl.g:5657:1: ( 'tablesToImport' )
            {
            // InternalMyDsl.g:5657:1: ( 'tablesToImport' )
            // InternalMyDsl.g:5658:2: 'tablesToImport'
            {
             before(grammarAccess.getImportAccess().getTablesToImportKeyword_4()); 
            match(input,80,FOLLOW_2); 
             after(grammarAccess.getImportAccess().getTablesToImportKeyword_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Import__Group__4__Impl"


    // $ANTLR start "rule__Import__Group__5"
    // InternalMyDsl.g:5667:1: rule__Import__Group__5 : rule__Import__Group__5__Impl rule__Import__Group__6 ;
    public final void rule__Import__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:5671:1: ( rule__Import__Group__5__Impl rule__Import__Group__6 )
            // InternalMyDsl.g:5672:2: rule__Import__Group__5__Impl rule__Import__Group__6
            {
            pushFollow(FOLLOW_49);
            rule__Import__Group__5__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Import__Group__6();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Import__Group__5"


    // $ANTLR start "rule__Import__Group__5__Impl"
    // InternalMyDsl.g:5679:1: rule__Import__Group__5__Impl : ( '{' ) ;
    public final void rule__Import__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:5683:1: ( ( '{' ) )
            // InternalMyDsl.g:5684:1: ( '{' )
            {
            // InternalMyDsl.g:5684:1: ( '{' )
            // InternalMyDsl.g:5685:2: '{'
            {
             before(grammarAccess.getImportAccess().getLeftCurlyBracketKeyword_5()); 
            match(input,38,FOLLOW_2); 
             after(grammarAccess.getImportAccess().getLeftCurlyBracketKeyword_5()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Import__Group__5__Impl"


    // $ANTLR start "rule__Import__Group__6"
    // InternalMyDsl.g:5694:1: rule__Import__Group__6 : rule__Import__Group__6__Impl rule__Import__Group__7 ;
    public final void rule__Import__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:5698:1: ( rule__Import__Group__6__Impl rule__Import__Group__7 )
            // InternalMyDsl.g:5699:2: rule__Import__Group__6__Impl rule__Import__Group__7
            {
            pushFollow(FOLLOW_9);
            rule__Import__Group__6__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Import__Group__7();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Import__Group__6"


    // $ANTLR start "rule__Import__Group__6__Impl"
    // InternalMyDsl.g:5706:1: rule__Import__Group__6__Impl : ( ( rule__Import__TablesToImportAssignment_6 ) ) ;
    public final void rule__Import__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:5710:1: ( ( ( rule__Import__TablesToImportAssignment_6 ) ) )
            // InternalMyDsl.g:5711:1: ( ( rule__Import__TablesToImportAssignment_6 ) )
            {
            // InternalMyDsl.g:5711:1: ( ( rule__Import__TablesToImportAssignment_6 ) )
            // InternalMyDsl.g:5712:2: ( rule__Import__TablesToImportAssignment_6 )
            {
             before(grammarAccess.getImportAccess().getTablesToImportAssignment_6()); 
            // InternalMyDsl.g:5713:2: ( rule__Import__TablesToImportAssignment_6 )
            // InternalMyDsl.g:5713:3: rule__Import__TablesToImportAssignment_6
            {
            pushFollow(FOLLOW_2);
            rule__Import__TablesToImportAssignment_6();

            state._fsp--;


            }

             after(grammarAccess.getImportAccess().getTablesToImportAssignment_6()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Import__Group__6__Impl"


    // $ANTLR start "rule__Import__Group__7"
    // InternalMyDsl.g:5721:1: rule__Import__Group__7 : rule__Import__Group__7__Impl rule__Import__Group__8 ;
    public final void rule__Import__Group__7() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:5725:1: ( rule__Import__Group__7__Impl rule__Import__Group__8 )
            // InternalMyDsl.g:5726:2: rule__Import__Group__7__Impl rule__Import__Group__8
            {
            pushFollow(FOLLOW_9);
            rule__Import__Group__7__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Import__Group__8();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Import__Group__7"


    // $ANTLR start "rule__Import__Group__7__Impl"
    // InternalMyDsl.g:5733:1: rule__Import__Group__7__Impl : ( ( rule__Import__Group_7__0 )* ) ;
    public final void rule__Import__Group__7__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:5737:1: ( ( ( rule__Import__Group_7__0 )* ) )
            // InternalMyDsl.g:5738:1: ( ( rule__Import__Group_7__0 )* )
            {
            // InternalMyDsl.g:5738:1: ( ( rule__Import__Group_7__0 )* )
            // InternalMyDsl.g:5739:2: ( rule__Import__Group_7__0 )*
            {
             before(grammarAccess.getImportAccess().getGroup_7()); 
            // InternalMyDsl.g:5740:2: ( rule__Import__Group_7__0 )*
            loop25:
            do {
                int alt25=2;
                int LA25_0 = input.LA(1);

                if ( (LA25_0==43) ) {
                    alt25=1;
                }


                switch (alt25) {
            	case 1 :
            	    // InternalMyDsl.g:5740:3: rule__Import__Group_7__0
            	    {
            	    pushFollow(FOLLOW_10);
            	    rule__Import__Group_7__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop25;
                }
            } while (true);

             after(grammarAccess.getImportAccess().getGroup_7()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Import__Group__7__Impl"


    // $ANTLR start "rule__Import__Group__8"
    // InternalMyDsl.g:5748:1: rule__Import__Group__8 : rule__Import__Group__8__Impl rule__Import__Group__9 ;
    public final void rule__Import__Group__8() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:5752:1: ( rule__Import__Group__8__Impl rule__Import__Group__9 )
            // InternalMyDsl.g:5753:2: rule__Import__Group__8__Impl rule__Import__Group__9
            {
            pushFollow(FOLLOW_29);
            rule__Import__Group__8__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Import__Group__9();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Import__Group__8"


    // $ANTLR start "rule__Import__Group__8__Impl"
    // InternalMyDsl.g:5760:1: rule__Import__Group__8__Impl : ( '}' ) ;
    public final void rule__Import__Group__8__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:5764:1: ( ( '}' ) )
            // InternalMyDsl.g:5765:1: ( '}' )
            {
            // InternalMyDsl.g:5765:1: ( '}' )
            // InternalMyDsl.g:5766:2: '}'
            {
             before(grammarAccess.getImportAccess().getRightCurlyBracketKeyword_8()); 
            match(input,41,FOLLOW_2); 
             after(grammarAccess.getImportAccess().getRightCurlyBracketKeyword_8()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Import__Group__8__Impl"


    // $ANTLR start "rule__Import__Group__9"
    // InternalMyDsl.g:5775:1: rule__Import__Group__9 : rule__Import__Group__9__Impl rule__Import__Group__10 ;
    public final void rule__Import__Group__9() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:5779:1: ( rule__Import__Group__9__Impl rule__Import__Group__10 )
            // InternalMyDsl.g:5780:2: rule__Import__Group__9__Impl rule__Import__Group__10
            {
            pushFollow(FOLLOW_3);
            rule__Import__Group__9__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Import__Group__10();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Import__Group__9"


    // $ANTLR start "rule__Import__Group__9__Impl"
    // InternalMyDsl.g:5787:1: rule__Import__Group__9__Impl : ( 'next' ) ;
    public final void rule__Import__Group__9__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:5791:1: ( ( 'next' ) )
            // InternalMyDsl.g:5792:1: ( 'next' )
            {
            // InternalMyDsl.g:5792:1: ( 'next' )
            // InternalMyDsl.g:5793:2: 'next'
            {
             before(grammarAccess.getImportAccess().getNextKeyword_9()); 
            match(input,60,FOLLOW_2); 
             after(grammarAccess.getImportAccess().getNextKeyword_9()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Import__Group__9__Impl"


    // $ANTLR start "rule__Import__Group__10"
    // InternalMyDsl.g:5802:1: rule__Import__Group__10 : rule__Import__Group__10__Impl rule__Import__Group__11 ;
    public final void rule__Import__Group__10() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:5806:1: ( rule__Import__Group__10__Impl rule__Import__Group__11 )
            // InternalMyDsl.g:5807:2: rule__Import__Group__10__Impl rule__Import__Group__11
            {
            pushFollow(FOLLOW_13);
            rule__Import__Group__10__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Import__Group__11();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Import__Group__10"


    // $ANTLR start "rule__Import__Group__10__Impl"
    // InternalMyDsl.g:5814:1: rule__Import__Group__10__Impl : ( ( rule__Import__NextAssignment_10 ) ) ;
    public final void rule__Import__Group__10__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:5818:1: ( ( ( rule__Import__NextAssignment_10 ) ) )
            // InternalMyDsl.g:5819:1: ( ( rule__Import__NextAssignment_10 ) )
            {
            // InternalMyDsl.g:5819:1: ( ( rule__Import__NextAssignment_10 ) )
            // InternalMyDsl.g:5820:2: ( rule__Import__NextAssignment_10 )
            {
             before(grammarAccess.getImportAccess().getNextAssignment_10()); 
            // InternalMyDsl.g:5821:2: ( rule__Import__NextAssignment_10 )
            // InternalMyDsl.g:5821:3: rule__Import__NextAssignment_10
            {
            pushFollow(FOLLOW_2);
            rule__Import__NextAssignment_10();

            state._fsp--;


            }

             after(grammarAccess.getImportAccess().getNextAssignment_10()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Import__Group__10__Impl"


    // $ANTLR start "rule__Import__Group__11"
    // InternalMyDsl.g:5829:1: rule__Import__Group__11 : rule__Import__Group__11__Impl ;
    public final void rule__Import__Group__11() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:5833:1: ( rule__Import__Group__11__Impl )
            // InternalMyDsl.g:5834:2: rule__Import__Group__11__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Import__Group__11__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Import__Group__11"


    // $ANTLR start "rule__Import__Group__11__Impl"
    // InternalMyDsl.g:5840:1: rule__Import__Group__11__Impl : ( '}' ) ;
    public final void rule__Import__Group__11__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:5844:1: ( ( '}' ) )
            // InternalMyDsl.g:5845:1: ( '}' )
            {
            // InternalMyDsl.g:5845:1: ( '}' )
            // InternalMyDsl.g:5846:2: '}'
            {
             before(grammarAccess.getImportAccess().getRightCurlyBracketKeyword_11()); 
            match(input,41,FOLLOW_2); 
             after(grammarAccess.getImportAccess().getRightCurlyBracketKeyword_11()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Import__Group__11__Impl"


    // $ANTLR start "rule__Import__Group_3__0"
    // InternalMyDsl.g:5856:1: rule__Import__Group_3__0 : rule__Import__Group_3__0__Impl rule__Import__Group_3__1 ;
    public final void rule__Import__Group_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:5860:1: ( rule__Import__Group_3__0__Impl rule__Import__Group_3__1 )
            // InternalMyDsl.g:5861:2: rule__Import__Group_3__0__Impl rule__Import__Group_3__1
            {
            pushFollow(FOLLOW_3);
            rule__Import__Group_3__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Import__Group_3__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Import__Group_3__0"


    // $ANTLR start "rule__Import__Group_3__0__Impl"
    // InternalMyDsl.g:5868:1: rule__Import__Group_3__0__Impl : ( 'description' ) ;
    public final void rule__Import__Group_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:5872:1: ( ( 'description' ) )
            // InternalMyDsl.g:5873:1: ( 'description' )
            {
            // InternalMyDsl.g:5873:1: ( 'description' )
            // InternalMyDsl.g:5874:2: 'description'
            {
             before(grammarAccess.getImportAccess().getDescriptionKeyword_3_0()); 
            match(input,50,FOLLOW_2); 
             after(grammarAccess.getImportAccess().getDescriptionKeyword_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Import__Group_3__0__Impl"


    // $ANTLR start "rule__Import__Group_3__1"
    // InternalMyDsl.g:5883:1: rule__Import__Group_3__1 : rule__Import__Group_3__1__Impl ;
    public final void rule__Import__Group_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:5887:1: ( rule__Import__Group_3__1__Impl )
            // InternalMyDsl.g:5888:2: rule__Import__Group_3__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Import__Group_3__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Import__Group_3__1"


    // $ANTLR start "rule__Import__Group_3__1__Impl"
    // InternalMyDsl.g:5894:1: rule__Import__Group_3__1__Impl : ( ( rule__Import__DescriptionAssignment_3_1 ) ) ;
    public final void rule__Import__Group_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:5898:1: ( ( ( rule__Import__DescriptionAssignment_3_1 ) ) )
            // InternalMyDsl.g:5899:1: ( ( rule__Import__DescriptionAssignment_3_1 ) )
            {
            // InternalMyDsl.g:5899:1: ( ( rule__Import__DescriptionAssignment_3_1 ) )
            // InternalMyDsl.g:5900:2: ( rule__Import__DescriptionAssignment_3_1 )
            {
             before(grammarAccess.getImportAccess().getDescriptionAssignment_3_1()); 
            // InternalMyDsl.g:5901:2: ( rule__Import__DescriptionAssignment_3_1 )
            // InternalMyDsl.g:5901:3: rule__Import__DescriptionAssignment_3_1
            {
            pushFollow(FOLLOW_2);
            rule__Import__DescriptionAssignment_3_1();

            state._fsp--;


            }

             after(grammarAccess.getImportAccess().getDescriptionAssignment_3_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Import__Group_3__1__Impl"


    // $ANTLR start "rule__Import__Group_7__0"
    // InternalMyDsl.g:5910:1: rule__Import__Group_7__0 : rule__Import__Group_7__0__Impl rule__Import__Group_7__1 ;
    public final void rule__Import__Group_7__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:5914:1: ( rule__Import__Group_7__0__Impl rule__Import__Group_7__1 )
            // InternalMyDsl.g:5915:2: rule__Import__Group_7__0__Impl rule__Import__Group_7__1
            {
            pushFollow(FOLLOW_49);
            rule__Import__Group_7__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Import__Group_7__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Import__Group_7__0"


    // $ANTLR start "rule__Import__Group_7__0__Impl"
    // InternalMyDsl.g:5922:1: rule__Import__Group_7__0__Impl : ( ',' ) ;
    public final void rule__Import__Group_7__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:5926:1: ( ( ',' ) )
            // InternalMyDsl.g:5927:1: ( ',' )
            {
            // InternalMyDsl.g:5927:1: ( ',' )
            // InternalMyDsl.g:5928:2: ','
            {
             before(grammarAccess.getImportAccess().getCommaKeyword_7_0()); 
            match(input,43,FOLLOW_2); 
             after(grammarAccess.getImportAccess().getCommaKeyword_7_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Import__Group_7__0__Impl"


    // $ANTLR start "rule__Import__Group_7__1"
    // InternalMyDsl.g:5937:1: rule__Import__Group_7__1 : rule__Import__Group_7__1__Impl ;
    public final void rule__Import__Group_7__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:5941:1: ( rule__Import__Group_7__1__Impl )
            // InternalMyDsl.g:5942:2: rule__Import__Group_7__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Import__Group_7__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Import__Group_7__1"


    // $ANTLR start "rule__Import__Group_7__1__Impl"
    // InternalMyDsl.g:5948:1: rule__Import__Group_7__1__Impl : ( ( rule__Import__TablesToImportAssignment_7_1 ) ) ;
    public final void rule__Import__Group_7__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:5952:1: ( ( ( rule__Import__TablesToImportAssignment_7_1 ) ) )
            // InternalMyDsl.g:5953:1: ( ( rule__Import__TablesToImportAssignment_7_1 ) )
            {
            // InternalMyDsl.g:5953:1: ( ( rule__Import__TablesToImportAssignment_7_1 ) )
            // InternalMyDsl.g:5954:2: ( rule__Import__TablesToImportAssignment_7_1 )
            {
             before(grammarAccess.getImportAccess().getTablesToImportAssignment_7_1()); 
            // InternalMyDsl.g:5955:2: ( rule__Import__TablesToImportAssignment_7_1 )
            // InternalMyDsl.g:5955:3: rule__Import__TablesToImportAssignment_7_1
            {
            pushFollow(FOLLOW_2);
            rule__Import__TablesToImportAssignment_7_1();

            state._fsp--;


            }

             after(grammarAccess.getImportAccess().getTablesToImportAssignment_7_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Import__Group_7__1__Impl"


    // $ANTLR start "rule__Lookup__Group__0"
    // InternalMyDsl.g:5964:1: rule__Lookup__Group__0 : rule__Lookup__Group__0__Impl rule__Lookup__Group__1 ;
    public final void rule__Lookup__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:5968:1: ( rule__Lookup__Group__0__Impl rule__Lookup__Group__1 )
            // InternalMyDsl.g:5969:2: rule__Lookup__Group__0__Impl rule__Lookup__Group__1
            {
            pushFollow(FOLLOW_3);
            rule__Lookup__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Lookup__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Lookup__Group__0"


    // $ANTLR start "rule__Lookup__Group__0__Impl"
    // InternalMyDsl.g:5976:1: rule__Lookup__Group__0__Impl : ( 'Lookup' ) ;
    public final void rule__Lookup__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:5980:1: ( ( 'Lookup' ) )
            // InternalMyDsl.g:5981:1: ( 'Lookup' )
            {
            // InternalMyDsl.g:5981:1: ( 'Lookup' )
            // InternalMyDsl.g:5982:2: 'Lookup'
            {
             before(grammarAccess.getLookupAccess().getLookupKeyword_0()); 
            match(input,81,FOLLOW_2); 
             after(grammarAccess.getLookupAccess().getLookupKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Lookup__Group__0__Impl"


    // $ANTLR start "rule__Lookup__Group__1"
    // InternalMyDsl.g:5991:1: rule__Lookup__Group__1 : rule__Lookup__Group__1__Impl rule__Lookup__Group__2 ;
    public final void rule__Lookup__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:5995:1: ( rule__Lookup__Group__1__Impl rule__Lookup__Group__2 )
            // InternalMyDsl.g:5996:2: rule__Lookup__Group__1__Impl rule__Lookup__Group__2
            {
            pushFollow(FOLLOW_4);
            rule__Lookup__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Lookup__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Lookup__Group__1"


    // $ANTLR start "rule__Lookup__Group__1__Impl"
    // InternalMyDsl.g:6003:1: rule__Lookup__Group__1__Impl : ( ( rule__Lookup__NameAssignment_1 ) ) ;
    public final void rule__Lookup__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:6007:1: ( ( ( rule__Lookup__NameAssignment_1 ) ) )
            // InternalMyDsl.g:6008:1: ( ( rule__Lookup__NameAssignment_1 ) )
            {
            // InternalMyDsl.g:6008:1: ( ( rule__Lookup__NameAssignment_1 ) )
            // InternalMyDsl.g:6009:2: ( rule__Lookup__NameAssignment_1 )
            {
             before(grammarAccess.getLookupAccess().getNameAssignment_1()); 
            // InternalMyDsl.g:6010:2: ( rule__Lookup__NameAssignment_1 )
            // InternalMyDsl.g:6010:3: rule__Lookup__NameAssignment_1
            {
            pushFollow(FOLLOW_2);
            rule__Lookup__NameAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getLookupAccess().getNameAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Lookup__Group__1__Impl"


    // $ANTLR start "rule__Lookup__Group__2"
    // InternalMyDsl.g:6018:1: rule__Lookup__Group__2 : rule__Lookup__Group__2__Impl rule__Lookup__Group__3 ;
    public final void rule__Lookup__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:6022:1: ( rule__Lookup__Group__2__Impl rule__Lookup__Group__3 )
            // InternalMyDsl.g:6023:2: rule__Lookup__Group__2__Impl rule__Lookup__Group__3
            {
            pushFollow(FOLLOW_20);
            rule__Lookup__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Lookup__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Lookup__Group__2"


    // $ANTLR start "rule__Lookup__Group__2__Impl"
    // InternalMyDsl.g:6030:1: rule__Lookup__Group__2__Impl : ( '{' ) ;
    public final void rule__Lookup__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:6034:1: ( ( '{' ) )
            // InternalMyDsl.g:6035:1: ( '{' )
            {
            // InternalMyDsl.g:6035:1: ( '{' )
            // InternalMyDsl.g:6036:2: '{'
            {
             before(grammarAccess.getLookupAccess().getLeftCurlyBracketKeyword_2()); 
            match(input,38,FOLLOW_2); 
             after(grammarAccess.getLookupAccess().getLeftCurlyBracketKeyword_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Lookup__Group__2__Impl"


    // $ANTLR start "rule__Lookup__Group__3"
    // InternalMyDsl.g:6045:1: rule__Lookup__Group__3 : rule__Lookup__Group__3__Impl rule__Lookup__Group__4 ;
    public final void rule__Lookup__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:6049:1: ( rule__Lookup__Group__3__Impl rule__Lookup__Group__4 )
            // InternalMyDsl.g:6050:2: rule__Lookup__Group__3__Impl rule__Lookup__Group__4
            {
            pushFollow(FOLLOW_20);
            rule__Lookup__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Lookup__Group__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Lookup__Group__3"


    // $ANTLR start "rule__Lookup__Group__3__Impl"
    // InternalMyDsl.g:6057:1: rule__Lookup__Group__3__Impl : ( ( rule__Lookup__Group_3__0 )? ) ;
    public final void rule__Lookup__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:6061:1: ( ( ( rule__Lookup__Group_3__0 )? ) )
            // InternalMyDsl.g:6062:1: ( ( rule__Lookup__Group_3__0 )? )
            {
            // InternalMyDsl.g:6062:1: ( ( rule__Lookup__Group_3__0 )? )
            // InternalMyDsl.g:6063:2: ( rule__Lookup__Group_3__0 )?
            {
             before(grammarAccess.getLookupAccess().getGroup_3()); 
            // InternalMyDsl.g:6064:2: ( rule__Lookup__Group_3__0 )?
            int alt26=2;
            int LA26_0 = input.LA(1);

            if ( (LA26_0==50) ) {
                alt26=1;
            }
            switch (alt26) {
                case 1 :
                    // InternalMyDsl.g:6064:3: rule__Lookup__Group_3__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__Lookup__Group_3__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getLookupAccess().getGroup_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Lookup__Group__3__Impl"


    // $ANTLR start "rule__Lookup__Group__4"
    // InternalMyDsl.g:6072:1: rule__Lookup__Group__4 : rule__Lookup__Group__4__Impl rule__Lookup__Group__5 ;
    public final void rule__Lookup__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:6076:1: ( rule__Lookup__Group__4__Impl rule__Lookup__Group__5 )
            // InternalMyDsl.g:6077:2: rule__Lookup__Group__4__Impl rule__Lookup__Group__5
            {
            pushFollow(FOLLOW_3);
            rule__Lookup__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Lookup__Group__5();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Lookup__Group__4"


    // $ANTLR start "rule__Lookup__Group__4__Impl"
    // InternalMyDsl.g:6084:1: rule__Lookup__Group__4__Impl : ( 'table' ) ;
    public final void rule__Lookup__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:6088:1: ( ( 'table' ) )
            // InternalMyDsl.g:6089:1: ( 'table' )
            {
            // InternalMyDsl.g:6089:1: ( 'table' )
            // InternalMyDsl.g:6090:2: 'table'
            {
             before(grammarAccess.getLookupAccess().getTableKeyword_4()); 
            match(input,52,FOLLOW_2); 
             after(grammarAccess.getLookupAccess().getTableKeyword_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Lookup__Group__4__Impl"


    // $ANTLR start "rule__Lookup__Group__5"
    // InternalMyDsl.g:6099:1: rule__Lookup__Group__5 : rule__Lookup__Group__5__Impl rule__Lookup__Group__6 ;
    public final void rule__Lookup__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:6103:1: ( rule__Lookup__Group__5__Impl rule__Lookup__Group__6 )
            // InternalMyDsl.g:6104:2: rule__Lookup__Group__5__Impl rule__Lookup__Group__6
            {
            pushFollow(FOLLOW_30);
            rule__Lookup__Group__5__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Lookup__Group__6();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Lookup__Group__5"


    // $ANTLR start "rule__Lookup__Group__5__Impl"
    // InternalMyDsl.g:6111:1: rule__Lookup__Group__5__Impl : ( ( rule__Lookup__TableAssignment_5 ) ) ;
    public final void rule__Lookup__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:6115:1: ( ( ( rule__Lookup__TableAssignment_5 ) ) )
            // InternalMyDsl.g:6116:1: ( ( rule__Lookup__TableAssignment_5 ) )
            {
            // InternalMyDsl.g:6116:1: ( ( rule__Lookup__TableAssignment_5 ) )
            // InternalMyDsl.g:6117:2: ( rule__Lookup__TableAssignment_5 )
            {
             before(grammarAccess.getLookupAccess().getTableAssignment_5()); 
            // InternalMyDsl.g:6118:2: ( rule__Lookup__TableAssignment_5 )
            // InternalMyDsl.g:6118:3: rule__Lookup__TableAssignment_5
            {
            pushFollow(FOLLOW_2);
            rule__Lookup__TableAssignment_5();

            state._fsp--;


            }

             after(grammarAccess.getLookupAccess().getTableAssignment_5()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Lookup__Group__5__Impl"


    // $ANTLR start "rule__Lookup__Group__6"
    // InternalMyDsl.g:6126:1: rule__Lookup__Group__6 : rule__Lookup__Group__6__Impl rule__Lookup__Group__7 ;
    public final void rule__Lookup__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:6130:1: ( rule__Lookup__Group__6__Impl rule__Lookup__Group__7 )
            // InternalMyDsl.g:6131:2: rule__Lookup__Group__6__Impl rule__Lookup__Group__7
            {
            pushFollow(FOLLOW_3);
            rule__Lookup__Group__6__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Lookup__Group__7();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Lookup__Group__6"


    // $ANTLR start "rule__Lookup__Group__6__Impl"
    // InternalMyDsl.g:6138:1: rule__Lookup__Group__6__Impl : ( 'column' ) ;
    public final void rule__Lookup__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:6142:1: ( ( 'column' ) )
            // InternalMyDsl.g:6143:1: ( 'column' )
            {
            // InternalMyDsl.g:6143:1: ( 'column' )
            // InternalMyDsl.g:6144:2: 'column'
            {
             before(grammarAccess.getLookupAccess().getColumnKeyword_6()); 
            match(input,62,FOLLOW_2); 
             after(grammarAccess.getLookupAccess().getColumnKeyword_6()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Lookup__Group__6__Impl"


    // $ANTLR start "rule__Lookup__Group__7"
    // InternalMyDsl.g:6153:1: rule__Lookup__Group__7 : rule__Lookup__Group__7__Impl rule__Lookup__Group__8 ;
    public final void rule__Lookup__Group__7() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:6157:1: ( rule__Lookup__Group__7__Impl rule__Lookup__Group__8 )
            // InternalMyDsl.g:6158:2: rule__Lookup__Group__7__Impl rule__Lookup__Group__8
            {
            pushFollow(FOLLOW_50);
            rule__Lookup__Group__7__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Lookup__Group__8();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Lookup__Group__7"


    // $ANTLR start "rule__Lookup__Group__7__Impl"
    // InternalMyDsl.g:6165:1: rule__Lookup__Group__7__Impl : ( ( rule__Lookup__ColumnAssignment_7 ) ) ;
    public final void rule__Lookup__Group__7__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:6169:1: ( ( ( rule__Lookup__ColumnAssignment_7 ) ) )
            // InternalMyDsl.g:6170:1: ( ( rule__Lookup__ColumnAssignment_7 ) )
            {
            // InternalMyDsl.g:6170:1: ( ( rule__Lookup__ColumnAssignment_7 ) )
            // InternalMyDsl.g:6171:2: ( rule__Lookup__ColumnAssignment_7 )
            {
             before(grammarAccess.getLookupAccess().getColumnAssignment_7()); 
            // InternalMyDsl.g:6172:2: ( rule__Lookup__ColumnAssignment_7 )
            // InternalMyDsl.g:6172:3: rule__Lookup__ColumnAssignment_7
            {
            pushFollow(FOLLOW_2);
            rule__Lookup__ColumnAssignment_7();

            state._fsp--;


            }

             after(grammarAccess.getLookupAccess().getColumnAssignment_7()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Lookup__Group__7__Impl"


    // $ANTLR start "rule__Lookup__Group__8"
    // InternalMyDsl.g:6180:1: rule__Lookup__Group__8 : rule__Lookup__Group__8__Impl rule__Lookup__Group__9 ;
    public final void rule__Lookup__Group__8() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:6184:1: ( rule__Lookup__Group__8__Impl rule__Lookup__Group__9 )
            // InternalMyDsl.g:6185:2: rule__Lookup__Group__8__Impl rule__Lookup__Group__9
            {
            pushFollow(FOLLOW_3);
            rule__Lookup__Group__8__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Lookup__Group__9();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Lookup__Group__8"


    // $ANTLR start "rule__Lookup__Group__8__Impl"
    // InternalMyDsl.g:6192:1: rule__Lookup__Group__8__Impl : ( 'lookupTable' ) ;
    public final void rule__Lookup__Group__8__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:6196:1: ( ( 'lookupTable' ) )
            // InternalMyDsl.g:6197:1: ( 'lookupTable' )
            {
            // InternalMyDsl.g:6197:1: ( 'lookupTable' )
            // InternalMyDsl.g:6198:2: 'lookupTable'
            {
             before(grammarAccess.getLookupAccess().getLookupTableKeyword_8()); 
            match(input,82,FOLLOW_2); 
             after(grammarAccess.getLookupAccess().getLookupTableKeyword_8()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Lookup__Group__8__Impl"


    // $ANTLR start "rule__Lookup__Group__9"
    // InternalMyDsl.g:6207:1: rule__Lookup__Group__9 : rule__Lookup__Group__9__Impl rule__Lookup__Group__10 ;
    public final void rule__Lookup__Group__9() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:6211:1: ( rule__Lookup__Group__9__Impl rule__Lookup__Group__10 )
            // InternalMyDsl.g:6212:2: rule__Lookup__Group__9__Impl rule__Lookup__Group__10
            {
            pushFollow(FOLLOW_51);
            rule__Lookup__Group__9__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Lookup__Group__10();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Lookup__Group__9"


    // $ANTLR start "rule__Lookup__Group__9__Impl"
    // InternalMyDsl.g:6219:1: rule__Lookup__Group__9__Impl : ( ( rule__Lookup__LookupTableAssignment_9 ) ) ;
    public final void rule__Lookup__Group__9__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:6223:1: ( ( ( rule__Lookup__LookupTableAssignment_9 ) ) )
            // InternalMyDsl.g:6224:1: ( ( rule__Lookup__LookupTableAssignment_9 ) )
            {
            // InternalMyDsl.g:6224:1: ( ( rule__Lookup__LookupTableAssignment_9 ) )
            // InternalMyDsl.g:6225:2: ( rule__Lookup__LookupTableAssignment_9 )
            {
             before(grammarAccess.getLookupAccess().getLookupTableAssignment_9()); 
            // InternalMyDsl.g:6226:2: ( rule__Lookup__LookupTableAssignment_9 )
            // InternalMyDsl.g:6226:3: rule__Lookup__LookupTableAssignment_9
            {
            pushFollow(FOLLOW_2);
            rule__Lookup__LookupTableAssignment_9();

            state._fsp--;


            }

             after(grammarAccess.getLookupAccess().getLookupTableAssignment_9()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Lookup__Group__9__Impl"


    // $ANTLR start "rule__Lookup__Group__10"
    // InternalMyDsl.g:6234:1: rule__Lookup__Group__10 : rule__Lookup__Group__10__Impl rule__Lookup__Group__11 ;
    public final void rule__Lookup__Group__10() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:6238:1: ( rule__Lookup__Group__10__Impl rule__Lookup__Group__11 )
            // InternalMyDsl.g:6239:2: rule__Lookup__Group__10__Impl rule__Lookup__Group__11
            {
            pushFollow(FOLLOW_3);
            rule__Lookup__Group__10__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Lookup__Group__11();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Lookup__Group__10"


    // $ANTLR start "rule__Lookup__Group__10__Impl"
    // InternalMyDsl.g:6246:1: rule__Lookup__Group__10__Impl : ( 'matchColumn' ) ;
    public final void rule__Lookup__Group__10__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:6250:1: ( ( 'matchColumn' ) )
            // InternalMyDsl.g:6251:1: ( 'matchColumn' )
            {
            // InternalMyDsl.g:6251:1: ( 'matchColumn' )
            // InternalMyDsl.g:6252:2: 'matchColumn'
            {
             before(grammarAccess.getLookupAccess().getMatchColumnKeyword_10()); 
            match(input,83,FOLLOW_2); 
             after(grammarAccess.getLookupAccess().getMatchColumnKeyword_10()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Lookup__Group__10__Impl"


    // $ANTLR start "rule__Lookup__Group__11"
    // InternalMyDsl.g:6261:1: rule__Lookup__Group__11 : rule__Lookup__Group__11__Impl rule__Lookup__Group__12 ;
    public final void rule__Lookup__Group__11() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:6265:1: ( rule__Lookup__Group__11__Impl rule__Lookup__Group__12 )
            // InternalMyDsl.g:6266:2: rule__Lookup__Group__11__Impl rule__Lookup__Group__12
            {
            pushFollow(FOLLOW_26);
            rule__Lookup__Group__11__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Lookup__Group__12();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Lookup__Group__11"


    // $ANTLR start "rule__Lookup__Group__11__Impl"
    // InternalMyDsl.g:6273:1: rule__Lookup__Group__11__Impl : ( ( rule__Lookup__MatchColumnAssignment_11 ) ) ;
    public final void rule__Lookup__Group__11__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:6277:1: ( ( ( rule__Lookup__MatchColumnAssignment_11 ) ) )
            // InternalMyDsl.g:6278:1: ( ( rule__Lookup__MatchColumnAssignment_11 ) )
            {
            // InternalMyDsl.g:6278:1: ( ( rule__Lookup__MatchColumnAssignment_11 ) )
            // InternalMyDsl.g:6279:2: ( rule__Lookup__MatchColumnAssignment_11 )
            {
             before(grammarAccess.getLookupAccess().getMatchColumnAssignment_11()); 
            // InternalMyDsl.g:6280:2: ( rule__Lookup__MatchColumnAssignment_11 )
            // InternalMyDsl.g:6280:3: rule__Lookup__MatchColumnAssignment_11
            {
            pushFollow(FOLLOW_2);
            rule__Lookup__MatchColumnAssignment_11();

            state._fsp--;


            }

             after(grammarAccess.getLookupAccess().getMatchColumnAssignment_11()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Lookup__Group__11__Impl"


    // $ANTLR start "rule__Lookup__Group__12"
    // InternalMyDsl.g:6288:1: rule__Lookup__Group__12 : rule__Lookup__Group__12__Impl rule__Lookup__Group__13 ;
    public final void rule__Lookup__Group__12() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:6292:1: ( rule__Lookup__Group__12__Impl rule__Lookup__Group__13 )
            // InternalMyDsl.g:6293:2: rule__Lookup__Group__12__Impl rule__Lookup__Group__13
            {
            pushFollow(FOLLOW_3);
            rule__Lookup__Group__12__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Lookup__Group__13();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Lookup__Group__12"


    // $ANTLR start "rule__Lookup__Group__12__Impl"
    // InternalMyDsl.g:6300:1: rule__Lookup__Group__12__Impl : ( 'operandColumn' ) ;
    public final void rule__Lookup__Group__12__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:6304:1: ( ( 'operandColumn' ) )
            // InternalMyDsl.g:6305:1: ( 'operandColumn' )
            {
            // InternalMyDsl.g:6305:1: ( 'operandColumn' )
            // InternalMyDsl.g:6306:2: 'operandColumn'
            {
             before(grammarAccess.getLookupAccess().getOperandColumnKeyword_12()); 
            match(input,57,FOLLOW_2); 
             after(grammarAccess.getLookupAccess().getOperandColumnKeyword_12()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Lookup__Group__12__Impl"


    // $ANTLR start "rule__Lookup__Group__13"
    // InternalMyDsl.g:6315:1: rule__Lookup__Group__13 : rule__Lookup__Group__13__Impl rule__Lookup__Group__14 ;
    public final void rule__Lookup__Group__13() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:6319:1: ( rule__Lookup__Group__13__Impl rule__Lookup__Group__14 )
            // InternalMyDsl.g:6320:2: rule__Lookup__Group__13__Impl rule__Lookup__Group__14
            {
            pushFollow(FOLLOW_52);
            rule__Lookup__Group__13__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Lookup__Group__14();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Lookup__Group__13"


    // $ANTLR start "rule__Lookup__Group__13__Impl"
    // InternalMyDsl.g:6327:1: rule__Lookup__Group__13__Impl : ( ( rule__Lookup__OperandColumnAssignment_13 ) ) ;
    public final void rule__Lookup__Group__13__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:6331:1: ( ( ( rule__Lookup__OperandColumnAssignment_13 ) ) )
            // InternalMyDsl.g:6332:1: ( ( rule__Lookup__OperandColumnAssignment_13 ) )
            {
            // InternalMyDsl.g:6332:1: ( ( rule__Lookup__OperandColumnAssignment_13 ) )
            // InternalMyDsl.g:6333:2: ( rule__Lookup__OperandColumnAssignment_13 )
            {
             before(grammarAccess.getLookupAccess().getOperandColumnAssignment_13()); 
            // InternalMyDsl.g:6334:2: ( rule__Lookup__OperandColumnAssignment_13 )
            // InternalMyDsl.g:6334:3: rule__Lookup__OperandColumnAssignment_13
            {
            pushFollow(FOLLOW_2);
            rule__Lookup__OperandColumnAssignment_13();

            state._fsp--;


            }

             after(grammarAccess.getLookupAccess().getOperandColumnAssignment_13()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Lookup__Group__13__Impl"


    // $ANTLR start "rule__Lookup__Group__14"
    // InternalMyDsl.g:6342:1: rule__Lookup__Group__14 : rule__Lookup__Group__14__Impl rule__Lookup__Group__15 ;
    public final void rule__Lookup__Group__14() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:6346:1: ( rule__Lookup__Group__14__Impl rule__Lookup__Group__15 )
            // InternalMyDsl.g:6347:2: rule__Lookup__Group__14__Impl rule__Lookup__Group__15
            {
            pushFollow(FOLLOW_3);
            rule__Lookup__Group__14__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Lookup__Group__15();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Lookup__Group__14"


    // $ANTLR start "rule__Lookup__Group__14__Impl"
    // InternalMyDsl.g:6354:1: rule__Lookup__Group__14__Impl : ( 'lookupColumn' ) ;
    public final void rule__Lookup__Group__14__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:6358:1: ( ( 'lookupColumn' ) )
            // InternalMyDsl.g:6359:1: ( 'lookupColumn' )
            {
            // InternalMyDsl.g:6359:1: ( 'lookupColumn' )
            // InternalMyDsl.g:6360:2: 'lookupColumn'
            {
             before(grammarAccess.getLookupAccess().getLookupColumnKeyword_14()); 
            match(input,84,FOLLOW_2); 
             after(grammarAccess.getLookupAccess().getLookupColumnKeyword_14()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Lookup__Group__14__Impl"


    // $ANTLR start "rule__Lookup__Group__15"
    // InternalMyDsl.g:6369:1: rule__Lookup__Group__15 : rule__Lookup__Group__15__Impl rule__Lookup__Group__16 ;
    public final void rule__Lookup__Group__15() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:6373:1: ( rule__Lookup__Group__15__Impl rule__Lookup__Group__16 )
            // InternalMyDsl.g:6374:2: rule__Lookup__Group__15__Impl rule__Lookup__Group__16
            {
            pushFollow(FOLLOW_24);
            rule__Lookup__Group__15__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Lookup__Group__16();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Lookup__Group__15"


    // $ANTLR start "rule__Lookup__Group__15__Impl"
    // InternalMyDsl.g:6381:1: rule__Lookup__Group__15__Impl : ( ( rule__Lookup__LookupColumnAssignment_15 ) ) ;
    public final void rule__Lookup__Group__15__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:6385:1: ( ( ( rule__Lookup__LookupColumnAssignment_15 ) ) )
            // InternalMyDsl.g:6386:1: ( ( rule__Lookup__LookupColumnAssignment_15 ) )
            {
            // InternalMyDsl.g:6386:1: ( ( rule__Lookup__LookupColumnAssignment_15 ) )
            // InternalMyDsl.g:6387:2: ( rule__Lookup__LookupColumnAssignment_15 )
            {
             before(grammarAccess.getLookupAccess().getLookupColumnAssignment_15()); 
            // InternalMyDsl.g:6388:2: ( rule__Lookup__LookupColumnAssignment_15 )
            // InternalMyDsl.g:6388:3: rule__Lookup__LookupColumnAssignment_15
            {
            pushFollow(FOLLOW_2);
            rule__Lookup__LookupColumnAssignment_15();

            state._fsp--;


            }

             after(grammarAccess.getLookupAccess().getLookupColumnAssignment_15()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Lookup__Group__15__Impl"


    // $ANTLR start "rule__Lookup__Group__16"
    // InternalMyDsl.g:6396:1: rule__Lookup__Group__16 : rule__Lookup__Group__16__Impl rule__Lookup__Group__17 ;
    public final void rule__Lookup__Group__16() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:6400:1: ( rule__Lookup__Group__16__Impl rule__Lookup__Group__17 )
            // InternalMyDsl.g:6401:2: rule__Lookup__Group__16__Impl rule__Lookup__Group__17
            {
            pushFollow(FOLLOW_53);
            rule__Lookup__Group__16__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Lookup__Group__17();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Lookup__Group__16"


    // $ANTLR start "rule__Lookup__Group__16__Impl"
    // InternalMyDsl.g:6408:1: rule__Lookup__Group__16__Impl : ( 'operation' ) ;
    public final void rule__Lookup__Group__16__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:6412:1: ( ( 'operation' ) )
            // InternalMyDsl.g:6413:1: ( 'operation' )
            {
            // InternalMyDsl.g:6413:1: ( 'operation' )
            // InternalMyDsl.g:6414:2: 'operation'
            {
             before(grammarAccess.getLookupAccess().getOperationKeyword_16()); 
            match(input,56,FOLLOW_2); 
             after(grammarAccess.getLookupAccess().getOperationKeyword_16()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Lookup__Group__16__Impl"


    // $ANTLR start "rule__Lookup__Group__17"
    // InternalMyDsl.g:6423:1: rule__Lookup__Group__17 : rule__Lookup__Group__17__Impl rule__Lookup__Group__18 ;
    public final void rule__Lookup__Group__17() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:6427:1: ( rule__Lookup__Group__17__Impl rule__Lookup__Group__18 )
            // InternalMyDsl.g:6428:2: rule__Lookup__Group__17__Impl rule__Lookup__Group__18
            {
            pushFollow(FOLLOW_27);
            rule__Lookup__Group__17__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Lookup__Group__18();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Lookup__Group__17"


    // $ANTLR start "rule__Lookup__Group__17__Impl"
    // InternalMyDsl.g:6435:1: rule__Lookup__Group__17__Impl : ( ( rule__Lookup__OperationAssignment_17 ) ) ;
    public final void rule__Lookup__Group__17__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:6439:1: ( ( ( rule__Lookup__OperationAssignment_17 ) ) )
            // InternalMyDsl.g:6440:1: ( ( rule__Lookup__OperationAssignment_17 ) )
            {
            // InternalMyDsl.g:6440:1: ( ( rule__Lookup__OperationAssignment_17 ) )
            // InternalMyDsl.g:6441:2: ( rule__Lookup__OperationAssignment_17 )
            {
             before(grammarAccess.getLookupAccess().getOperationAssignment_17()); 
            // InternalMyDsl.g:6442:2: ( rule__Lookup__OperationAssignment_17 )
            // InternalMyDsl.g:6442:3: rule__Lookup__OperationAssignment_17
            {
            pushFollow(FOLLOW_2);
            rule__Lookup__OperationAssignment_17();

            state._fsp--;


            }

             after(grammarAccess.getLookupAccess().getOperationAssignment_17()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Lookup__Group__17__Impl"


    // $ANTLR start "rule__Lookup__Group__18"
    // InternalMyDsl.g:6450:1: rule__Lookup__Group__18 : rule__Lookup__Group__18__Impl rule__Lookup__Group__19 ;
    public final void rule__Lookup__Group__18() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:6454:1: ( rule__Lookup__Group__18__Impl rule__Lookup__Group__19 )
            // InternalMyDsl.g:6455:2: rule__Lookup__Group__18__Impl rule__Lookup__Group__19
            {
            pushFollow(FOLLOW_3);
            rule__Lookup__Group__18__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Lookup__Group__19();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Lookup__Group__18"


    // $ANTLR start "rule__Lookup__Group__18__Impl"
    // InternalMyDsl.g:6462:1: rule__Lookup__Group__18__Impl : ( 'resultTable' ) ;
    public final void rule__Lookup__Group__18__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:6466:1: ( ( 'resultTable' ) )
            // InternalMyDsl.g:6467:1: ( 'resultTable' )
            {
            // InternalMyDsl.g:6467:1: ( 'resultTable' )
            // InternalMyDsl.g:6468:2: 'resultTable'
            {
             before(grammarAccess.getLookupAccess().getResultTableKeyword_18()); 
            match(input,58,FOLLOW_2); 
             after(grammarAccess.getLookupAccess().getResultTableKeyword_18()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Lookup__Group__18__Impl"


    // $ANTLR start "rule__Lookup__Group__19"
    // InternalMyDsl.g:6477:1: rule__Lookup__Group__19 : rule__Lookup__Group__19__Impl rule__Lookup__Group__20 ;
    public final void rule__Lookup__Group__19() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:6481:1: ( rule__Lookup__Group__19__Impl rule__Lookup__Group__20 )
            // InternalMyDsl.g:6482:2: rule__Lookup__Group__19__Impl rule__Lookup__Group__20
            {
            pushFollow(FOLLOW_28);
            rule__Lookup__Group__19__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Lookup__Group__20();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Lookup__Group__19"


    // $ANTLR start "rule__Lookup__Group__19__Impl"
    // InternalMyDsl.g:6489:1: rule__Lookup__Group__19__Impl : ( ( rule__Lookup__ResultTableAssignment_19 ) ) ;
    public final void rule__Lookup__Group__19__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:6493:1: ( ( ( rule__Lookup__ResultTableAssignment_19 ) ) )
            // InternalMyDsl.g:6494:1: ( ( rule__Lookup__ResultTableAssignment_19 ) )
            {
            // InternalMyDsl.g:6494:1: ( ( rule__Lookup__ResultTableAssignment_19 ) )
            // InternalMyDsl.g:6495:2: ( rule__Lookup__ResultTableAssignment_19 )
            {
             before(grammarAccess.getLookupAccess().getResultTableAssignment_19()); 
            // InternalMyDsl.g:6496:2: ( rule__Lookup__ResultTableAssignment_19 )
            // InternalMyDsl.g:6496:3: rule__Lookup__ResultTableAssignment_19
            {
            pushFollow(FOLLOW_2);
            rule__Lookup__ResultTableAssignment_19();

            state._fsp--;


            }

             after(grammarAccess.getLookupAccess().getResultTableAssignment_19()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Lookup__Group__19__Impl"


    // $ANTLR start "rule__Lookup__Group__20"
    // InternalMyDsl.g:6504:1: rule__Lookup__Group__20 : rule__Lookup__Group__20__Impl rule__Lookup__Group__21 ;
    public final void rule__Lookup__Group__20() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:6508:1: ( rule__Lookup__Group__20__Impl rule__Lookup__Group__21 )
            // InternalMyDsl.g:6509:2: rule__Lookup__Group__20__Impl rule__Lookup__Group__21
            {
            pushFollow(FOLLOW_3);
            rule__Lookup__Group__20__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Lookup__Group__21();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Lookup__Group__20"


    // $ANTLR start "rule__Lookup__Group__20__Impl"
    // InternalMyDsl.g:6516:1: rule__Lookup__Group__20__Impl : ( 'resultColumn' ) ;
    public final void rule__Lookup__Group__20__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:6520:1: ( ( 'resultColumn' ) )
            // InternalMyDsl.g:6521:1: ( 'resultColumn' )
            {
            // InternalMyDsl.g:6521:1: ( 'resultColumn' )
            // InternalMyDsl.g:6522:2: 'resultColumn'
            {
             before(grammarAccess.getLookupAccess().getResultColumnKeyword_20()); 
            match(input,59,FOLLOW_2); 
             after(grammarAccess.getLookupAccess().getResultColumnKeyword_20()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Lookup__Group__20__Impl"


    // $ANTLR start "rule__Lookup__Group__21"
    // InternalMyDsl.g:6531:1: rule__Lookup__Group__21 : rule__Lookup__Group__21__Impl rule__Lookup__Group__22 ;
    public final void rule__Lookup__Group__21() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:6535:1: ( rule__Lookup__Group__21__Impl rule__Lookup__Group__22 )
            // InternalMyDsl.g:6536:2: rule__Lookup__Group__21__Impl rule__Lookup__Group__22
            {
            pushFollow(FOLLOW_29);
            rule__Lookup__Group__21__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Lookup__Group__22();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Lookup__Group__21"


    // $ANTLR start "rule__Lookup__Group__21__Impl"
    // InternalMyDsl.g:6543:1: rule__Lookup__Group__21__Impl : ( ( rule__Lookup__ResultColumnAssignment_21 ) ) ;
    public final void rule__Lookup__Group__21__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:6547:1: ( ( ( rule__Lookup__ResultColumnAssignment_21 ) ) )
            // InternalMyDsl.g:6548:1: ( ( rule__Lookup__ResultColumnAssignment_21 ) )
            {
            // InternalMyDsl.g:6548:1: ( ( rule__Lookup__ResultColumnAssignment_21 ) )
            // InternalMyDsl.g:6549:2: ( rule__Lookup__ResultColumnAssignment_21 )
            {
             before(grammarAccess.getLookupAccess().getResultColumnAssignment_21()); 
            // InternalMyDsl.g:6550:2: ( rule__Lookup__ResultColumnAssignment_21 )
            // InternalMyDsl.g:6550:3: rule__Lookup__ResultColumnAssignment_21
            {
            pushFollow(FOLLOW_2);
            rule__Lookup__ResultColumnAssignment_21();

            state._fsp--;


            }

             after(grammarAccess.getLookupAccess().getResultColumnAssignment_21()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Lookup__Group__21__Impl"


    // $ANTLR start "rule__Lookup__Group__22"
    // InternalMyDsl.g:6558:1: rule__Lookup__Group__22 : rule__Lookup__Group__22__Impl rule__Lookup__Group__23 ;
    public final void rule__Lookup__Group__22() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:6562:1: ( rule__Lookup__Group__22__Impl rule__Lookup__Group__23 )
            // InternalMyDsl.g:6563:2: rule__Lookup__Group__22__Impl rule__Lookup__Group__23
            {
            pushFollow(FOLLOW_3);
            rule__Lookup__Group__22__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Lookup__Group__23();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Lookup__Group__22"


    // $ANTLR start "rule__Lookup__Group__22__Impl"
    // InternalMyDsl.g:6570:1: rule__Lookup__Group__22__Impl : ( 'next' ) ;
    public final void rule__Lookup__Group__22__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:6574:1: ( ( 'next' ) )
            // InternalMyDsl.g:6575:1: ( 'next' )
            {
            // InternalMyDsl.g:6575:1: ( 'next' )
            // InternalMyDsl.g:6576:2: 'next'
            {
             before(grammarAccess.getLookupAccess().getNextKeyword_22()); 
            match(input,60,FOLLOW_2); 
             after(grammarAccess.getLookupAccess().getNextKeyword_22()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Lookup__Group__22__Impl"


    // $ANTLR start "rule__Lookup__Group__23"
    // InternalMyDsl.g:6585:1: rule__Lookup__Group__23 : rule__Lookup__Group__23__Impl rule__Lookup__Group__24 ;
    public final void rule__Lookup__Group__23() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:6589:1: ( rule__Lookup__Group__23__Impl rule__Lookup__Group__24 )
            // InternalMyDsl.g:6590:2: rule__Lookup__Group__23__Impl rule__Lookup__Group__24
            {
            pushFollow(FOLLOW_13);
            rule__Lookup__Group__23__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Lookup__Group__24();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Lookup__Group__23"


    // $ANTLR start "rule__Lookup__Group__23__Impl"
    // InternalMyDsl.g:6597:1: rule__Lookup__Group__23__Impl : ( ( rule__Lookup__NextAssignment_23 ) ) ;
    public final void rule__Lookup__Group__23__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:6601:1: ( ( ( rule__Lookup__NextAssignment_23 ) ) )
            // InternalMyDsl.g:6602:1: ( ( rule__Lookup__NextAssignment_23 ) )
            {
            // InternalMyDsl.g:6602:1: ( ( rule__Lookup__NextAssignment_23 ) )
            // InternalMyDsl.g:6603:2: ( rule__Lookup__NextAssignment_23 )
            {
             before(grammarAccess.getLookupAccess().getNextAssignment_23()); 
            // InternalMyDsl.g:6604:2: ( rule__Lookup__NextAssignment_23 )
            // InternalMyDsl.g:6604:3: rule__Lookup__NextAssignment_23
            {
            pushFollow(FOLLOW_2);
            rule__Lookup__NextAssignment_23();

            state._fsp--;


            }

             after(grammarAccess.getLookupAccess().getNextAssignment_23()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Lookup__Group__23__Impl"


    // $ANTLR start "rule__Lookup__Group__24"
    // InternalMyDsl.g:6612:1: rule__Lookup__Group__24 : rule__Lookup__Group__24__Impl ;
    public final void rule__Lookup__Group__24() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:6616:1: ( rule__Lookup__Group__24__Impl )
            // InternalMyDsl.g:6617:2: rule__Lookup__Group__24__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Lookup__Group__24__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Lookup__Group__24"


    // $ANTLR start "rule__Lookup__Group__24__Impl"
    // InternalMyDsl.g:6623:1: rule__Lookup__Group__24__Impl : ( '}' ) ;
    public final void rule__Lookup__Group__24__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:6627:1: ( ( '}' ) )
            // InternalMyDsl.g:6628:1: ( '}' )
            {
            // InternalMyDsl.g:6628:1: ( '}' )
            // InternalMyDsl.g:6629:2: '}'
            {
             before(grammarAccess.getLookupAccess().getRightCurlyBracketKeyword_24()); 
            match(input,41,FOLLOW_2); 
             after(grammarAccess.getLookupAccess().getRightCurlyBracketKeyword_24()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Lookup__Group__24__Impl"


    // $ANTLR start "rule__Lookup__Group_3__0"
    // InternalMyDsl.g:6639:1: rule__Lookup__Group_3__0 : rule__Lookup__Group_3__0__Impl rule__Lookup__Group_3__1 ;
    public final void rule__Lookup__Group_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:6643:1: ( rule__Lookup__Group_3__0__Impl rule__Lookup__Group_3__1 )
            // InternalMyDsl.g:6644:2: rule__Lookup__Group_3__0__Impl rule__Lookup__Group_3__1
            {
            pushFollow(FOLLOW_3);
            rule__Lookup__Group_3__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Lookup__Group_3__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Lookup__Group_3__0"


    // $ANTLR start "rule__Lookup__Group_3__0__Impl"
    // InternalMyDsl.g:6651:1: rule__Lookup__Group_3__0__Impl : ( 'description' ) ;
    public final void rule__Lookup__Group_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:6655:1: ( ( 'description' ) )
            // InternalMyDsl.g:6656:1: ( 'description' )
            {
            // InternalMyDsl.g:6656:1: ( 'description' )
            // InternalMyDsl.g:6657:2: 'description'
            {
             before(grammarAccess.getLookupAccess().getDescriptionKeyword_3_0()); 
            match(input,50,FOLLOW_2); 
             after(grammarAccess.getLookupAccess().getDescriptionKeyword_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Lookup__Group_3__0__Impl"


    // $ANTLR start "rule__Lookup__Group_3__1"
    // InternalMyDsl.g:6666:1: rule__Lookup__Group_3__1 : rule__Lookup__Group_3__1__Impl ;
    public final void rule__Lookup__Group_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:6670:1: ( rule__Lookup__Group_3__1__Impl )
            // InternalMyDsl.g:6671:2: rule__Lookup__Group_3__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Lookup__Group_3__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Lookup__Group_3__1"


    // $ANTLR start "rule__Lookup__Group_3__1__Impl"
    // InternalMyDsl.g:6677:1: rule__Lookup__Group_3__1__Impl : ( ( rule__Lookup__DescriptionAssignment_3_1 ) ) ;
    public final void rule__Lookup__Group_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:6681:1: ( ( ( rule__Lookup__DescriptionAssignment_3_1 ) ) )
            // InternalMyDsl.g:6682:1: ( ( rule__Lookup__DescriptionAssignment_3_1 ) )
            {
            // InternalMyDsl.g:6682:1: ( ( rule__Lookup__DescriptionAssignment_3_1 ) )
            // InternalMyDsl.g:6683:2: ( rule__Lookup__DescriptionAssignment_3_1 )
            {
             before(grammarAccess.getLookupAccess().getDescriptionAssignment_3_1()); 
            // InternalMyDsl.g:6684:2: ( rule__Lookup__DescriptionAssignment_3_1 )
            // InternalMyDsl.g:6684:3: rule__Lookup__DescriptionAssignment_3_1
            {
            pushFollow(FOLLOW_2);
            rule__Lookup__DescriptionAssignment_3_1();

            state._fsp--;


            }

             after(grammarAccess.getLookupAccess().getDescriptionAssignment_3_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Lookup__Group_3__1__Impl"


    // $ANTLR start "rule__RemoveDuplicates__Group__0"
    // InternalMyDsl.g:6693:1: rule__RemoveDuplicates__Group__0 : rule__RemoveDuplicates__Group__0__Impl rule__RemoveDuplicates__Group__1 ;
    public final void rule__RemoveDuplicates__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:6697:1: ( rule__RemoveDuplicates__Group__0__Impl rule__RemoveDuplicates__Group__1 )
            // InternalMyDsl.g:6698:2: rule__RemoveDuplicates__Group__0__Impl rule__RemoveDuplicates__Group__1
            {
            pushFollow(FOLLOW_3);
            rule__RemoveDuplicates__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__RemoveDuplicates__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RemoveDuplicates__Group__0"


    // $ANTLR start "rule__RemoveDuplicates__Group__0__Impl"
    // InternalMyDsl.g:6705:1: rule__RemoveDuplicates__Group__0__Impl : ( 'RemoveDuplicates' ) ;
    public final void rule__RemoveDuplicates__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:6709:1: ( ( 'RemoveDuplicates' ) )
            // InternalMyDsl.g:6710:1: ( 'RemoveDuplicates' )
            {
            // InternalMyDsl.g:6710:1: ( 'RemoveDuplicates' )
            // InternalMyDsl.g:6711:2: 'RemoveDuplicates'
            {
             before(grammarAccess.getRemoveDuplicatesAccess().getRemoveDuplicatesKeyword_0()); 
            match(input,85,FOLLOW_2); 
             after(grammarAccess.getRemoveDuplicatesAccess().getRemoveDuplicatesKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RemoveDuplicates__Group__0__Impl"


    // $ANTLR start "rule__RemoveDuplicates__Group__1"
    // InternalMyDsl.g:6720:1: rule__RemoveDuplicates__Group__1 : rule__RemoveDuplicates__Group__1__Impl rule__RemoveDuplicates__Group__2 ;
    public final void rule__RemoveDuplicates__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:6724:1: ( rule__RemoveDuplicates__Group__1__Impl rule__RemoveDuplicates__Group__2 )
            // InternalMyDsl.g:6725:2: rule__RemoveDuplicates__Group__1__Impl rule__RemoveDuplicates__Group__2
            {
            pushFollow(FOLLOW_4);
            rule__RemoveDuplicates__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__RemoveDuplicates__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RemoveDuplicates__Group__1"


    // $ANTLR start "rule__RemoveDuplicates__Group__1__Impl"
    // InternalMyDsl.g:6732:1: rule__RemoveDuplicates__Group__1__Impl : ( ( rule__RemoveDuplicates__NameAssignment_1 ) ) ;
    public final void rule__RemoveDuplicates__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:6736:1: ( ( ( rule__RemoveDuplicates__NameAssignment_1 ) ) )
            // InternalMyDsl.g:6737:1: ( ( rule__RemoveDuplicates__NameAssignment_1 ) )
            {
            // InternalMyDsl.g:6737:1: ( ( rule__RemoveDuplicates__NameAssignment_1 ) )
            // InternalMyDsl.g:6738:2: ( rule__RemoveDuplicates__NameAssignment_1 )
            {
             before(grammarAccess.getRemoveDuplicatesAccess().getNameAssignment_1()); 
            // InternalMyDsl.g:6739:2: ( rule__RemoveDuplicates__NameAssignment_1 )
            // InternalMyDsl.g:6739:3: rule__RemoveDuplicates__NameAssignment_1
            {
            pushFollow(FOLLOW_2);
            rule__RemoveDuplicates__NameAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getRemoveDuplicatesAccess().getNameAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RemoveDuplicates__Group__1__Impl"


    // $ANTLR start "rule__RemoveDuplicates__Group__2"
    // InternalMyDsl.g:6747:1: rule__RemoveDuplicates__Group__2 : rule__RemoveDuplicates__Group__2__Impl rule__RemoveDuplicates__Group__3 ;
    public final void rule__RemoveDuplicates__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:6751:1: ( rule__RemoveDuplicates__Group__2__Impl rule__RemoveDuplicates__Group__3 )
            // InternalMyDsl.g:6752:2: rule__RemoveDuplicates__Group__2__Impl rule__RemoveDuplicates__Group__3
            {
            pushFollow(FOLLOW_20);
            rule__RemoveDuplicates__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__RemoveDuplicates__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RemoveDuplicates__Group__2"


    // $ANTLR start "rule__RemoveDuplicates__Group__2__Impl"
    // InternalMyDsl.g:6759:1: rule__RemoveDuplicates__Group__2__Impl : ( '{' ) ;
    public final void rule__RemoveDuplicates__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:6763:1: ( ( '{' ) )
            // InternalMyDsl.g:6764:1: ( '{' )
            {
            // InternalMyDsl.g:6764:1: ( '{' )
            // InternalMyDsl.g:6765:2: '{'
            {
             before(grammarAccess.getRemoveDuplicatesAccess().getLeftCurlyBracketKeyword_2()); 
            match(input,38,FOLLOW_2); 
             after(grammarAccess.getRemoveDuplicatesAccess().getLeftCurlyBracketKeyword_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RemoveDuplicates__Group__2__Impl"


    // $ANTLR start "rule__RemoveDuplicates__Group__3"
    // InternalMyDsl.g:6774:1: rule__RemoveDuplicates__Group__3 : rule__RemoveDuplicates__Group__3__Impl rule__RemoveDuplicates__Group__4 ;
    public final void rule__RemoveDuplicates__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:6778:1: ( rule__RemoveDuplicates__Group__3__Impl rule__RemoveDuplicates__Group__4 )
            // InternalMyDsl.g:6779:2: rule__RemoveDuplicates__Group__3__Impl rule__RemoveDuplicates__Group__4
            {
            pushFollow(FOLLOW_20);
            rule__RemoveDuplicates__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__RemoveDuplicates__Group__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RemoveDuplicates__Group__3"


    // $ANTLR start "rule__RemoveDuplicates__Group__3__Impl"
    // InternalMyDsl.g:6786:1: rule__RemoveDuplicates__Group__3__Impl : ( ( rule__RemoveDuplicates__Group_3__0 )? ) ;
    public final void rule__RemoveDuplicates__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:6790:1: ( ( ( rule__RemoveDuplicates__Group_3__0 )? ) )
            // InternalMyDsl.g:6791:1: ( ( rule__RemoveDuplicates__Group_3__0 )? )
            {
            // InternalMyDsl.g:6791:1: ( ( rule__RemoveDuplicates__Group_3__0 )? )
            // InternalMyDsl.g:6792:2: ( rule__RemoveDuplicates__Group_3__0 )?
            {
             before(grammarAccess.getRemoveDuplicatesAccess().getGroup_3()); 
            // InternalMyDsl.g:6793:2: ( rule__RemoveDuplicates__Group_3__0 )?
            int alt27=2;
            int LA27_0 = input.LA(1);

            if ( (LA27_0==50) ) {
                alt27=1;
            }
            switch (alt27) {
                case 1 :
                    // InternalMyDsl.g:6793:3: rule__RemoveDuplicates__Group_3__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__RemoveDuplicates__Group_3__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getRemoveDuplicatesAccess().getGroup_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RemoveDuplicates__Group__3__Impl"


    // $ANTLR start "rule__RemoveDuplicates__Group__4"
    // InternalMyDsl.g:6801:1: rule__RemoveDuplicates__Group__4 : rule__RemoveDuplicates__Group__4__Impl rule__RemoveDuplicates__Group__5 ;
    public final void rule__RemoveDuplicates__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:6805:1: ( rule__RemoveDuplicates__Group__4__Impl rule__RemoveDuplicates__Group__5 )
            // InternalMyDsl.g:6806:2: rule__RemoveDuplicates__Group__4__Impl rule__RemoveDuplicates__Group__5
            {
            pushFollow(FOLLOW_3);
            rule__RemoveDuplicates__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__RemoveDuplicates__Group__5();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RemoveDuplicates__Group__4"


    // $ANTLR start "rule__RemoveDuplicates__Group__4__Impl"
    // InternalMyDsl.g:6813:1: rule__RemoveDuplicates__Group__4__Impl : ( 'table' ) ;
    public final void rule__RemoveDuplicates__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:6817:1: ( ( 'table' ) )
            // InternalMyDsl.g:6818:1: ( 'table' )
            {
            // InternalMyDsl.g:6818:1: ( 'table' )
            // InternalMyDsl.g:6819:2: 'table'
            {
             before(grammarAccess.getRemoveDuplicatesAccess().getTableKeyword_4()); 
            match(input,52,FOLLOW_2); 
             after(grammarAccess.getRemoveDuplicatesAccess().getTableKeyword_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RemoveDuplicates__Group__4__Impl"


    // $ANTLR start "rule__RemoveDuplicates__Group__5"
    // InternalMyDsl.g:6828:1: rule__RemoveDuplicates__Group__5 : rule__RemoveDuplicates__Group__5__Impl rule__RemoveDuplicates__Group__6 ;
    public final void rule__RemoveDuplicates__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:6832:1: ( rule__RemoveDuplicates__Group__5__Impl rule__RemoveDuplicates__Group__6 )
            // InternalMyDsl.g:6833:2: rule__RemoveDuplicates__Group__5__Impl rule__RemoveDuplicates__Group__6
            {
            pushFollow(FOLLOW_30);
            rule__RemoveDuplicates__Group__5__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__RemoveDuplicates__Group__6();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RemoveDuplicates__Group__5"


    // $ANTLR start "rule__RemoveDuplicates__Group__5__Impl"
    // InternalMyDsl.g:6840:1: rule__RemoveDuplicates__Group__5__Impl : ( ( rule__RemoveDuplicates__TableAssignment_5 ) ) ;
    public final void rule__RemoveDuplicates__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:6844:1: ( ( ( rule__RemoveDuplicates__TableAssignment_5 ) ) )
            // InternalMyDsl.g:6845:1: ( ( rule__RemoveDuplicates__TableAssignment_5 ) )
            {
            // InternalMyDsl.g:6845:1: ( ( rule__RemoveDuplicates__TableAssignment_5 ) )
            // InternalMyDsl.g:6846:2: ( rule__RemoveDuplicates__TableAssignment_5 )
            {
             before(grammarAccess.getRemoveDuplicatesAccess().getTableAssignment_5()); 
            // InternalMyDsl.g:6847:2: ( rule__RemoveDuplicates__TableAssignment_5 )
            // InternalMyDsl.g:6847:3: rule__RemoveDuplicates__TableAssignment_5
            {
            pushFollow(FOLLOW_2);
            rule__RemoveDuplicates__TableAssignment_5();

            state._fsp--;


            }

             after(grammarAccess.getRemoveDuplicatesAccess().getTableAssignment_5()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RemoveDuplicates__Group__5__Impl"


    // $ANTLR start "rule__RemoveDuplicates__Group__6"
    // InternalMyDsl.g:6855:1: rule__RemoveDuplicates__Group__6 : rule__RemoveDuplicates__Group__6__Impl rule__RemoveDuplicates__Group__7 ;
    public final void rule__RemoveDuplicates__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:6859:1: ( rule__RemoveDuplicates__Group__6__Impl rule__RemoveDuplicates__Group__7 )
            // InternalMyDsl.g:6860:2: rule__RemoveDuplicates__Group__6__Impl rule__RemoveDuplicates__Group__7
            {
            pushFollow(FOLLOW_3);
            rule__RemoveDuplicates__Group__6__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__RemoveDuplicates__Group__7();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RemoveDuplicates__Group__6"


    // $ANTLR start "rule__RemoveDuplicates__Group__6__Impl"
    // InternalMyDsl.g:6867:1: rule__RemoveDuplicates__Group__6__Impl : ( 'column' ) ;
    public final void rule__RemoveDuplicates__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:6871:1: ( ( 'column' ) )
            // InternalMyDsl.g:6872:1: ( 'column' )
            {
            // InternalMyDsl.g:6872:1: ( 'column' )
            // InternalMyDsl.g:6873:2: 'column'
            {
             before(grammarAccess.getRemoveDuplicatesAccess().getColumnKeyword_6()); 
            match(input,62,FOLLOW_2); 
             after(grammarAccess.getRemoveDuplicatesAccess().getColumnKeyword_6()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RemoveDuplicates__Group__6__Impl"


    // $ANTLR start "rule__RemoveDuplicates__Group__7"
    // InternalMyDsl.g:6882:1: rule__RemoveDuplicates__Group__7 : rule__RemoveDuplicates__Group__7__Impl rule__RemoveDuplicates__Group__8 ;
    public final void rule__RemoveDuplicates__Group__7() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:6886:1: ( rule__RemoveDuplicates__Group__7__Impl rule__RemoveDuplicates__Group__8 )
            // InternalMyDsl.g:6887:2: rule__RemoveDuplicates__Group__7__Impl rule__RemoveDuplicates__Group__8
            {
            pushFollow(FOLLOW_29);
            rule__RemoveDuplicates__Group__7__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__RemoveDuplicates__Group__8();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RemoveDuplicates__Group__7"


    // $ANTLR start "rule__RemoveDuplicates__Group__7__Impl"
    // InternalMyDsl.g:6894:1: rule__RemoveDuplicates__Group__7__Impl : ( ( rule__RemoveDuplicates__ColumnAssignment_7 ) ) ;
    public final void rule__RemoveDuplicates__Group__7__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:6898:1: ( ( ( rule__RemoveDuplicates__ColumnAssignment_7 ) ) )
            // InternalMyDsl.g:6899:1: ( ( rule__RemoveDuplicates__ColumnAssignment_7 ) )
            {
            // InternalMyDsl.g:6899:1: ( ( rule__RemoveDuplicates__ColumnAssignment_7 ) )
            // InternalMyDsl.g:6900:2: ( rule__RemoveDuplicates__ColumnAssignment_7 )
            {
             before(grammarAccess.getRemoveDuplicatesAccess().getColumnAssignment_7()); 
            // InternalMyDsl.g:6901:2: ( rule__RemoveDuplicates__ColumnAssignment_7 )
            // InternalMyDsl.g:6901:3: rule__RemoveDuplicates__ColumnAssignment_7
            {
            pushFollow(FOLLOW_2);
            rule__RemoveDuplicates__ColumnAssignment_7();

            state._fsp--;


            }

             after(grammarAccess.getRemoveDuplicatesAccess().getColumnAssignment_7()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RemoveDuplicates__Group__7__Impl"


    // $ANTLR start "rule__RemoveDuplicates__Group__8"
    // InternalMyDsl.g:6909:1: rule__RemoveDuplicates__Group__8 : rule__RemoveDuplicates__Group__8__Impl rule__RemoveDuplicates__Group__9 ;
    public final void rule__RemoveDuplicates__Group__8() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:6913:1: ( rule__RemoveDuplicates__Group__8__Impl rule__RemoveDuplicates__Group__9 )
            // InternalMyDsl.g:6914:2: rule__RemoveDuplicates__Group__8__Impl rule__RemoveDuplicates__Group__9
            {
            pushFollow(FOLLOW_3);
            rule__RemoveDuplicates__Group__8__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__RemoveDuplicates__Group__9();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RemoveDuplicates__Group__8"


    // $ANTLR start "rule__RemoveDuplicates__Group__8__Impl"
    // InternalMyDsl.g:6921:1: rule__RemoveDuplicates__Group__8__Impl : ( 'next' ) ;
    public final void rule__RemoveDuplicates__Group__8__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:6925:1: ( ( 'next' ) )
            // InternalMyDsl.g:6926:1: ( 'next' )
            {
            // InternalMyDsl.g:6926:1: ( 'next' )
            // InternalMyDsl.g:6927:2: 'next'
            {
             before(grammarAccess.getRemoveDuplicatesAccess().getNextKeyword_8()); 
            match(input,60,FOLLOW_2); 
             after(grammarAccess.getRemoveDuplicatesAccess().getNextKeyword_8()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RemoveDuplicates__Group__8__Impl"


    // $ANTLR start "rule__RemoveDuplicates__Group__9"
    // InternalMyDsl.g:6936:1: rule__RemoveDuplicates__Group__9 : rule__RemoveDuplicates__Group__9__Impl rule__RemoveDuplicates__Group__10 ;
    public final void rule__RemoveDuplicates__Group__9() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:6940:1: ( rule__RemoveDuplicates__Group__9__Impl rule__RemoveDuplicates__Group__10 )
            // InternalMyDsl.g:6941:2: rule__RemoveDuplicates__Group__9__Impl rule__RemoveDuplicates__Group__10
            {
            pushFollow(FOLLOW_13);
            rule__RemoveDuplicates__Group__9__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__RemoveDuplicates__Group__10();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RemoveDuplicates__Group__9"


    // $ANTLR start "rule__RemoveDuplicates__Group__9__Impl"
    // InternalMyDsl.g:6948:1: rule__RemoveDuplicates__Group__9__Impl : ( ( rule__RemoveDuplicates__NextAssignment_9 ) ) ;
    public final void rule__RemoveDuplicates__Group__9__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:6952:1: ( ( ( rule__RemoveDuplicates__NextAssignment_9 ) ) )
            // InternalMyDsl.g:6953:1: ( ( rule__RemoveDuplicates__NextAssignment_9 ) )
            {
            // InternalMyDsl.g:6953:1: ( ( rule__RemoveDuplicates__NextAssignment_9 ) )
            // InternalMyDsl.g:6954:2: ( rule__RemoveDuplicates__NextAssignment_9 )
            {
             before(grammarAccess.getRemoveDuplicatesAccess().getNextAssignment_9()); 
            // InternalMyDsl.g:6955:2: ( rule__RemoveDuplicates__NextAssignment_9 )
            // InternalMyDsl.g:6955:3: rule__RemoveDuplicates__NextAssignment_9
            {
            pushFollow(FOLLOW_2);
            rule__RemoveDuplicates__NextAssignment_9();

            state._fsp--;


            }

             after(grammarAccess.getRemoveDuplicatesAccess().getNextAssignment_9()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RemoveDuplicates__Group__9__Impl"


    // $ANTLR start "rule__RemoveDuplicates__Group__10"
    // InternalMyDsl.g:6963:1: rule__RemoveDuplicates__Group__10 : rule__RemoveDuplicates__Group__10__Impl ;
    public final void rule__RemoveDuplicates__Group__10() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:6967:1: ( rule__RemoveDuplicates__Group__10__Impl )
            // InternalMyDsl.g:6968:2: rule__RemoveDuplicates__Group__10__Impl
            {
            pushFollow(FOLLOW_2);
            rule__RemoveDuplicates__Group__10__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RemoveDuplicates__Group__10"


    // $ANTLR start "rule__RemoveDuplicates__Group__10__Impl"
    // InternalMyDsl.g:6974:1: rule__RemoveDuplicates__Group__10__Impl : ( '}' ) ;
    public final void rule__RemoveDuplicates__Group__10__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:6978:1: ( ( '}' ) )
            // InternalMyDsl.g:6979:1: ( '}' )
            {
            // InternalMyDsl.g:6979:1: ( '}' )
            // InternalMyDsl.g:6980:2: '}'
            {
             before(grammarAccess.getRemoveDuplicatesAccess().getRightCurlyBracketKeyword_10()); 
            match(input,41,FOLLOW_2); 
             after(grammarAccess.getRemoveDuplicatesAccess().getRightCurlyBracketKeyword_10()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RemoveDuplicates__Group__10__Impl"


    // $ANTLR start "rule__RemoveDuplicates__Group_3__0"
    // InternalMyDsl.g:6990:1: rule__RemoveDuplicates__Group_3__0 : rule__RemoveDuplicates__Group_3__0__Impl rule__RemoveDuplicates__Group_3__1 ;
    public final void rule__RemoveDuplicates__Group_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:6994:1: ( rule__RemoveDuplicates__Group_3__0__Impl rule__RemoveDuplicates__Group_3__1 )
            // InternalMyDsl.g:6995:2: rule__RemoveDuplicates__Group_3__0__Impl rule__RemoveDuplicates__Group_3__1
            {
            pushFollow(FOLLOW_3);
            rule__RemoveDuplicates__Group_3__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__RemoveDuplicates__Group_3__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RemoveDuplicates__Group_3__0"


    // $ANTLR start "rule__RemoveDuplicates__Group_3__0__Impl"
    // InternalMyDsl.g:7002:1: rule__RemoveDuplicates__Group_3__0__Impl : ( 'description' ) ;
    public final void rule__RemoveDuplicates__Group_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:7006:1: ( ( 'description' ) )
            // InternalMyDsl.g:7007:1: ( 'description' )
            {
            // InternalMyDsl.g:7007:1: ( 'description' )
            // InternalMyDsl.g:7008:2: 'description'
            {
             before(grammarAccess.getRemoveDuplicatesAccess().getDescriptionKeyword_3_0()); 
            match(input,50,FOLLOW_2); 
             after(grammarAccess.getRemoveDuplicatesAccess().getDescriptionKeyword_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RemoveDuplicates__Group_3__0__Impl"


    // $ANTLR start "rule__RemoveDuplicates__Group_3__1"
    // InternalMyDsl.g:7017:1: rule__RemoveDuplicates__Group_3__1 : rule__RemoveDuplicates__Group_3__1__Impl ;
    public final void rule__RemoveDuplicates__Group_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:7021:1: ( rule__RemoveDuplicates__Group_3__1__Impl )
            // InternalMyDsl.g:7022:2: rule__RemoveDuplicates__Group_3__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__RemoveDuplicates__Group_3__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RemoveDuplicates__Group_3__1"


    // $ANTLR start "rule__RemoveDuplicates__Group_3__1__Impl"
    // InternalMyDsl.g:7028:1: rule__RemoveDuplicates__Group_3__1__Impl : ( ( rule__RemoveDuplicates__DescriptionAssignment_3_1 ) ) ;
    public final void rule__RemoveDuplicates__Group_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:7032:1: ( ( ( rule__RemoveDuplicates__DescriptionAssignment_3_1 ) ) )
            // InternalMyDsl.g:7033:1: ( ( rule__RemoveDuplicates__DescriptionAssignment_3_1 ) )
            {
            // InternalMyDsl.g:7033:1: ( ( rule__RemoveDuplicates__DescriptionAssignment_3_1 ) )
            // InternalMyDsl.g:7034:2: ( rule__RemoveDuplicates__DescriptionAssignment_3_1 )
            {
             before(grammarAccess.getRemoveDuplicatesAccess().getDescriptionAssignment_3_1()); 
            // InternalMyDsl.g:7035:2: ( rule__RemoveDuplicates__DescriptionAssignment_3_1 )
            // InternalMyDsl.g:7035:3: rule__RemoveDuplicates__DescriptionAssignment_3_1
            {
            pushFollow(FOLLOW_2);
            rule__RemoveDuplicates__DescriptionAssignment_3_1();

            state._fsp--;


            }

             after(grammarAccess.getRemoveDuplicatesAccess().getDescriptionAssignment_3_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RemoveDuplicates__Group_3__1__Impl"


    // $ANTLR start "rule__Concat__Group__0"
    // InternalMyDsl.g:7044:1: rule__Concat__Group__0 : rule__Concat__Group__0__Impl rule__Concat__Group__1 ;
    public final void rule__Concat__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:7048:1: ( rule__Concat__Group__0__Impl rule__Concat__Group__1 )
            // InternalMyDsl.g:7049:2: rule__Concat__Group__0__Impl rule__Concat__Group__1
            {
            pushFollow(FOLLOW_3);
            rule__Concat__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Concat__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Concat__Group__0"


    // $ANTLR start "rule__Concat__Group__0__Impl"
    // InternalMyDsl.g:7056:1: rule__Concat__Group__0__Impl : ( 'Concat' ) ;
    public final void rule__Concat__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:7060:1: ( ( 'Concat' ) )
            // InternalMyDsl.g:7061:1: ( 'Concat' )
            {
            // InternalMyDsl.g:7061:1: ( 'Concat' )
            // InternalMyDsl.g:7062:2: 'Concat'
            {
             before(grammarAccess.getConcatAccess().getConcatKeyword_0()); 
            match(input,86,FOLLOW_2); 
             after(grammarAccess.getConcatAccess().getConcatKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Concat__Group__0__Impl"


    // $ANTLR start "rule__Concat__Group__1"
    // InternalMyDsl.g:7071:1: rule__Concat__Group__1 : rule__Concat__Group__1__Impl rule__Concat__Group__2 ;
    public final void rule__Concat__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:7075:1: ( rule__Concat__Group__1__Impl rule__Concat__Group__2 )
            // InternalMyDsl.g:7076:2: rule__Concat__Group__1__Impl rule__Concat__Group__2
            {
            pushFollow(FOLLOW_4);
            rule__Concat__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Concat__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Concat__Group__1"


    // $ANTLR start "rule__Concat__Group__1__Impl"
    // InternalMyDsl.g:7083:1: rule__Concat__Group__1__Impl : ( ( rule__Concat__NameAssignment_1 ) ) ;
    public final void rule__Concat__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:7087:1: ( ( ( rule__Concat__NameAssignment_1 ) ) )
            // InternalMyDsl.g:7088:1: ( ( rule__Concat__NameAssignment_1 ) )
            {
            // InternalMyDsl.g:7088:1: ( ( rule__Concat__NameAssignment_1 ) )
            // InternalMyDsl.g:7089:2: ( rule__Concat__NameAssignment_1 )
            {
             before(grammarAccess.getConcatAccess().getNameAssignment_1()); 
            // InternalMyDsl.g:7090:2: ( rule__Concat__NameAssignment_1 )
            // InternalMyDsl.g:7090:3: rule__Concat__NameAssignment_1
            {
            pushFollow(FOLLOW_2);
            rule__Concat__NameAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getConcatAccess().getNameAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Concat__Group__1__Impl"


    // $ANTLR start "rule__Concat__Group__2"
    // InternalMyDsl.g:7098:1: rule__Concat__Group__2 : rule__Concat__Group__2__Impl rule__Concat__Group__3 ;
    public final void rule__Concat__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:7102:1: ( rule__Concat__Group__2__Impl rule__Concat__Group__3 )
            // InternalMyDsl.g:7103:2: rule__Concat__Group__2__Impl rule__Concat__Group__3
            {
            pushFollow(FOLLOW_20);
            rule__Concat__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Concat__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Concat__Group__2"


    // $ANTLR start "rule__Concat__Group__2__Impl"
    // InternalMyDsl.g:7110:1: rule__Concat__Group__2__Impl : ( '{' ) ;
    public final void rule__Concat__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:7114:1: ( ( '{' ) )
            // InternalMyDsl.g:7115:1: ( '{' )
            {
            // InternalMyDsl.g:7115:1: ( '{' )
            // InternalMyDsl.g:7116:2: '{'
            {
             before(grammarAccess.getConcatAccess().getLeftCurlyBracketKeyword_2()); 
            match(input,38,FOLLOW_2); 
             after(grammarAccess.getConcatAccess().getLeftCurlyBracketKeyword_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Concat__Group__2__Impl"


    // $ANTLR start "rule__Concat__Group__3"
    // InternalMyDsl.g:7125:1: rule__Concat__Group__3 : rule__Concat__Group__3__Impl rule__Concat__Group__4 ;
    public final void rule__Concat__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:7129:1: ( rule__Concat__Group__3__Impl rule__Concat__Group__4 )
            // InternalMyDsl.g:7130:2: rule__Concat__Group__3__Impl rule__Concat__Group__4
            {
            pushFollow(FOLLOW_20);
            rule__Concat__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Concat__Group__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Concat__Group__3"


    // $ANTLR start "rule__Concat__Group__3__Impl"
    // InternalMyDsl.g:7137:1: rule__Concat__Group__3__Impl : ( ( rule__Concat__Group_3__0 )? ) ;
    public final void rule__Concat__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:7141:1: ( ( ( rule__Concat__Group_3__0 )? ) )
            // InternalMyDsl.g:7142:1: ( ( rule__Concat__Group_3__0 )? )
            {
            // InternalMyDsl.g:7142:1: ( ( rule__Concat__Group_3__0 )? )
            // InternalMyDsl.g:7143:2: ( rule__Concat__Group_3__0 )?
            {
             before(grammarAccess.getConcatAccess().getGroup_3()); 
            // InternalMyDsl.g:7144:2: ( rule__Concat__Group_3__0 )?
            int alt28=2;
            int LA28_0 = input.LA(1);

            if ( (LA28_0==50) ) {
                alt28=1;
            }
            switch (alt28) {
                case 1 :
                    // InternalMyDsl.g:7144:3: rule__Concat__Group_3__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__Concat__Group_3__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getConcatAccess().getGroup_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Concat__Group__3__Impl"


    // $ANTLR start "rule__Concat__Group__4"
    // InternalMyDsl.g:7152:1: rule__Concat__Group__4 : rule__Concat__Group__4__Impl rule__Concat__Group__5 ;
    public final void rule__Concat__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:7156:1: ( rule__Concat__Group__4__Impl rule__Concat__Group__5 )
            // InternalMyDsl.g:7157:2: rule__Concat__Group__4__Impl rule__Concat__Group__5
            {
            pushFollow(FOLLOW_3);
            rule__Concat__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Concat__Group__5();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Concat__Group__4"


    // $ANTLR start "rule__Concat__Group__4__Impl"
    // InternalMyDsl.g:7164:1: rule__Concat__Group__4__Impl : ( 'table' ) ;
    public final void rule__Concat__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:7168:1: ( ( 'table' ) )
            // InternalMyDsl.g:7169:1: ( 'table' )
            {
            // InternalMyDsl.g:7169:1: ( 'table' )
            // InternalMyDsl.g:7170:2: 'table'
            {
             before(grammarAccess.getConcatAccess().getTableKeyword_4()); 
            match(input,52,FOLLOW_2); 
             after(grammarAccess.getConcatAccess().getTableKeyword_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Concat__Group__4__Impl"


    // $ANTLR start "rule__Concat__Group__5"
    // InternalMyDsl.g:7179:1: rule__Concat__Group__5 : rule__Concat__Group__5__Impl rule__Concat__Group__6 ;
    public final void rule__Concat__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:7183:1: ( rule__Concat__Group__5__Impl rule__Concat__Group__6 )
            // InternalMyDsl.g:7184:2: rule__Concat__Group__5__Impl rule__Concat__Group__6
            {
            pushFollow(FOLLOW_54);
            rule__Concat__Group__5__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Concat__Group__6();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Concat__Group__5"


    // $ANTLR start "rule__Concat__Group__5__Impl"
    // InternalMyDsl.g:7191:1: rule__Concat__Group__5__Impl : ( ( rule__Concat__TableAssignment_5 ) ) ;
    public final void rule__Concat__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:7195:1: ( ( ( rule__Concat__TableAssignment_5 ) ) )
            // InternalMyDsl.g:7196:1: ( ( rule__Concat__TableAssignment_5 ) )
            {
            // InternalMyDsl.g:7196:1: ( ( rule__Concat__TableAssignment_5 ) )
            // InternalMyDsl.g:7197:2: ( rule__Concat__TableAssignment_5 )
            {
             before(grammarAccess.getConcatAccess().getTableAssignment_5()); 
            // InternalMyDsl.g:7198:2: ( rule__Concat__TableAssignment_5 )
            // InternalMyDsl.g:7198:3: rule__Concat__TableAssignment_5
            {
            pushFollow(FOLLOW_2);
            rule__Concat__TableAssignment_5();

            state._fsp--;


            }

             after(grammarAccess.getConcatAccess().getTableAssignment_5()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Concat__Group__5__Impl"


    // $ANTLR start "rule__Concat__Group__6"
    // InternalMyDsl.g:7206:1: rule__Concat__Group__6 : rule__Concat__Group__6__Impl rule__Concat__Group__7 ;
    public final void rule__Concat__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:7210:1: ( rule__Concat__Group__6__Impl rule__Concat__Group__7 )
            // InternalMyDsl.g:7211:2: rule__Concat__Group__6__Impl rule__Concat__Group__7
            {
            pushFollow(FOLLOW_3);
            rule__Concat__Group__6__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Concat__Group__7();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Concat__Group__6"


    // $ANTLR start "rule__Concat__Group__6__Impl"
    // InternalMyDsl.g:7218:1: rule__Concat__Group__6__Impl : ( 'sourceA' ) ;
    public final void rule__Concat__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:7222:1: ( ( 'sourceA' ) )
            // InternalMyDsl.g:7223:1: ( 'sourceA' )
            {
            // InternalMyDsl.g:7223:1: ( 'sourceA' )
            // InternalMyDsl.g:7224:2: 'sourceA'
            {
             before(grammarAccess.getConcatAccess().getSourceAKeyword_6()); 
            match(input,87,FOLLOW_2); 
             after(grammarAccess.getConcatAccess().getSourceAKeyword_6()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Concat__Group__6__Impl"


    // $ANTLR start "rule__Concat__Group__7"
    // InternalMyDsl.g:7233:1: rule__Concat__Group__7 : rule__Concat__Group__7__Impl rule__Concat__Group__8 ;
    public final void rule__Concat__Group__7() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:7237:1: ( rule__Concat__Group__7__Impl rule__Concat__Group__8 )
            // InternalMyDsl.g:7238:2: rule__Concat__Group__7__Impl rule__Concat__Group__8
            {
            pushFollow(FOLLOW_55);
            rule__Concat__Group__7__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Concat__Group__8();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Concat__Group__7"


    // $ANTLR start "rule__Concat__Group__7__Impl"
    // InternalMyDsl.g:7245:1: rule__Concat__Group__7__Impl : ( ( rule__Concat__SourceAAssignment_7 ) ) ;
    public final void rule__Concat__Group__7__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:7249:1: ( ( ( rule__Concat__SourceAAssignment_7 ) ) )
            // InternalMyDsl.g:7250:1: ( ( rule__Concat__SourceAAssignment_7 ) )
            {
            // InternalMyDsl.g:7250:1: ( ( rule__Concat__SourceAAssignment_7 ) )
            // InternalMyDsl.g:7251:2: ( rule__Concat__SourceAAssignment_7 )
            {
             before(grammarAccess.getConcatAccess().getSourceAAssignment_7()); 
            // InternalMyDsl.g:7252:2: ( rule__Concat__SourceAAssignment_7 )
            // InternalMyDsl.g:7252:3: rule__Concat__SourceAAssignment_7
            {
            pushFollow(FOLLOW_2);
            rule__Concat__SourceAAssignment_7();

            state._fsp--;


            }

             after(grammarAccess.getConcatAccess().getSourceAAssignment_7()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Concat__Group__7__Impl"


    // $ANTLR start "rule__Concat__Group__8"
    // InternalMyDsl.g:7260:1: rule__Concat__Group__8 : rule__Concat__Group__8__Impl rule__Concat__Group__9 ;
    public final void rule__Concat__Group__8() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:7264:1: ( rule__Concat__Group__8__Impl rule__Concat__Group__9 )
            // InternalMyDsl.g:7265:2: rule__Concat__Group__8__Impl rule__Concat__Group__9
            {
            pushFollow(FOLLOW_3);
            rule__Concat__Group__8__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Concat__Group__9();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Concat__Group__8"


    // $ANTLR start "rule__Concat__Group__8__Impl"
    // InternalMyDsl.g:7272:1: rule__Concat__Group__8__Impl : ( 'sourceB' ) ;
    public final void rule__Concat__Group__8__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:7276:1: ( ( 'sourceB' ) )
            // InternalMyDsl.g:7277:1: ( 'sourceB' )
            {
            // InternalMyDsl.g:7277:1: ( 'sourceB' )
            // InternalMyDsl.g:7278:2: 'sourceB'
            {
             before(grammarAccess.getConcatAccess().getSourceBKeyword_8()); 
            match(input,88,FOLLOW_2); 
             after(grammarAccess.getConcatAccess().getSourceBKeyword_8()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Concat__Group__8__Impl"


    // $ANTLR start "rule__Concat__Group__9"
    // InternalMyDsl.g:7287:1: rule__Concat__Group__9 : rule__Concat__Group__9__Impl rule__Concat__Group__10 ;
    public final void rule__Concat__Group__9() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:7291:1: ( rule__Concat__Group__9__Impl rule__Concat__Group__10 )
            // InternalMyDsl.g:7292:2: rule__Concat__Group__9__Impl rule__Concat__Group__10
            {
            pushFollow(FOLLOW_28);
            rule__Concat__Group__9__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Concat__Group__10();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Concat__Group__9"


    // $ANTLR start "rule__Concat__Group__9__Impl"
    // InternalMyDsl.g:7299:1: rule__Concat__Group__9__Impl : ( ( rule__Concat__SourceBAssignment_9 ) ) ;
    public final void rule__Concat__Group__9__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:7303:1: ( ( ( rule__Concat__SourceBAssignment_9 ) ) )
            // InternalMyDsl.g:7304:1: ( ( rule__Concat__SourceBAssignment_9 ) )
            {
            // InternalMyDsl.g:7304:1: ( ( rule__Concat__SourceBAssignment_9 ) )
            // InternalMyDsl.g:7305:2: ( rule__Concat__SourceBAssignment_9 )
            {
             before(grammarAccess.getConcatAccess().getSourceBAssignment_9()); 
            // InternalMyDsl.g:7306:2: ( rule__Concat__SourceBAssignment_9 )
            // InternalMyDsl.g:7306:3: rule__Concat__SourceBAssignment_9
            {
            pushFollow(FOLLOW_2);
            rule__Concat__SourceBAssignment_9();

            state._fsp--;


            }

             after(grammarAccess.getConcatAccess().getSourceBAssignment_9()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Concat__Group__9__Impl"


    // $ANTLR start "rule__Concat__Group__10"
    // InternalMyDsl.g:7314:1: rule__Concat__Group__10 : rule__Concat__Group__10__Impl rule__Concat__Group__11 ;
    public final void rule__Concat__Group__10() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:7318:1: ( rule__Concat__Group__10__Impl rule__Concat__Group__11 )
            // InternalMyDsl.g:7319:2: rule__Concat__Group__10__Impl rule__Concat__Group__11
            {
            pushFollow(FOLLOW_3);
            rule__Concat__Group__10__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Concat__Group__11();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Concat__Group__10"


    // $ANTLR start "rule__Concat__Group__10__Impl"
    // InternalMyDsl.g:7326:1: rule__Concat__Group__10__Impl : ( 'resultColumn' ) ;
    public final void rule__Concat__Group__10__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:7330:1: ( ( 'resultColumn' ) )
            // InternalMyDsl.g:7331:1: ( 'resultColumn' )
            {
            // InternalMyDsl.g:7331:1: ( 'resultColumn' )
            // InternalMyDsl.g:7332:2: 'resultColumn'
            {
             before(grammarAccess.getConcatAccess().getResultColumnKeyword_10()); 
            match(input,59,FOLLOW_2); 
             after(grammarAccess.getConcatAccess().getResultColumnKeyword_10()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Concat__Group__10__Impl"


    // $ANTLR start "rule__Concat__Group__11"
    // InternalMyDsl.g:7341:1: rule__Concat__Group__11 : rule__Concat__Group__11__Impl rule__Concat__Group__12 ;
    public final void rule__Concat__Group__11() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:7345:1: ( rule__Concat__Group__11__Impl rule__Concat__Group__12 )
            // InternalMyDsl.g:7346:2: rule__Concat__Group__11__Impl rule__Concat__Group__12
            {
            pushFollow(FOLLOW_27);
            rule__Concat__Group__11__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Concat__Group__12();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Concat__Group__11"


    // $ANTLR start "rule__Concat__Group__11__Impl"
    // InternalMyDsl.g:7353:1: rule__Concat__Group__11__Impl : ( ( rule__Concat__ResultColumnAssignment_11 ) ) ;
    public final void rule__Concat__Group__11__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:7357:1: ( ( ( rule__Concat__ResultColumnAssignment_11 ) ) )
            // InternalMyDsl.g:7358:1: ( ( rule__Concat__ResultColumnAssignment_11 ) )
            {
            // InternalMyDsl.g:7358:1: ( ( rule__Concat__ResultColumnAssignment_11 ) )
            // InternalMyDsl.g:7359:2: ( rule__Concat__ResultColumnAssignment_11 )
            {
             before(grammarAccess.getConcatAccess().getResultColumnAssignment_11()); 
            // InternalMyDsl.g:7360:2: ( rule__Concat__ResultColumnAssignment_11 )
            // InternalMyDsl.g:7360:3: rule__Concat__ResultColumnAssignment_11
            {
            pushFollow(FOLLOW_2);
            rule__Concat__ResultColumnAssignment_11();

            state._fsp--;


            }

             after(grammarAccess.getConcatAccess().getResultColumnAssignment_11()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Concat__Group__11__Impl"


    // $ANTLR start "rule__Concat__Group__12"
    // InternalMyDsl.g:7368:1: rule__Concat__Group__12 : rule__Concat__Group__12__Impl rule__Concat__Group__13 ;
    public final void rule__Concat__Group__12() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:7372:1: ( rule__Concat__Group__12__Impl rule__Concat__Group__13 )
            // InternalMyDsl.g:7373:2: rule__Concat__Group__12__Impl rule__Concat__Group__13
            {
            pushFollow(FOLLOW_3);
            rule__Concat__Group__12__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Concat__Group__13();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Concat__Group__12"


    // $ANTLR start "rule__Concat__Group__12__Impl"
    // InternalMyDsl.g:7380:1: rule__Concat__Group__12__Impl : ( 'resultTable' ) ;
    public final void rule__Concat__Group__12__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:7384:1: ( ( 'resultTable' ) )
            // InternalMyDsl.g:7385:1: ( 'resultTable' )
            {
            // InternalMyDsl.g:7385:1: ( 'resultTable' )
            // InternalMyDsl.g:7386:2: 'resultTable'
            {
             before(grammarAccess.getConcatAccess().getResultTableKeyword_12()); 
            match(input,58,FOLLOW_2); 
             after(grammarAccess.getConcatAccess().getResultTableKeyword_12()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Concat__Group__12__Impl"


    // $ANTLR start "rule__Concat__Group__13"
    // InternalMyDsl.g:7395:1: rule__Concat__Group__13 : rule__Concat__Group__13__Impl rule__Concat__Group__14 ;
    public final void rule__Concat__Group__13() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:7399:1: ( rule__Concat__Group__13__Impl rule__Concat__Group__14 )
            // InternalMyDsl.g:7400:2: rule__Concat__Group__13__Impl rule__Concat__Group__14
            {
            pushFollow(FOLLOW_29);
            rule__Concat__Group__13__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Concat__Group__14();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Concat__Group__13"


    // $ANTLR start "rule__Concat__Group__13__Impl"
    // InternalMyDsl.g:7407:1: rule__Concat__Group__13__Impl : ( ( rule__Concat__ResultTableAssignment_13 ) ) ;
    public final void rule__Concat__Group__13__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:7411:1: ( ( ( rule__Concat__ResultTableAssignment_13 ) ) )
            // InternalMyDsl.g:7412:1: ( ( rule__Concat__ResultTableAssignment_13 ) )
            {
            // InternalMyDsl.g:7412:1: ( ( rule__Concat__ResultTableAssignment_13 ) )
            // InternalMyDsl.g:7413:2: ( rule__Concat__ResultTableAssignment_13 )
            {
             before(grammarAccess.getConcatAccess().getResultTableAssignment_13()); 
            // InternalMyDsl.g:7414:2: ( rule__Concat__ResultTableAssignment_13 )
            // InternalMyDsl.g:7414:3: rule__Concat__ResultTableAssignment_13
            {
            pushFollow(FOLLOW_2);
            rule__Concat__ResultTableAssignment_13();

            state._fsp--;


            }

             after(grammarAccess.getConcatAccess().getResultTableAssignment_13()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Concat__Group__13__Impl"


    // $ANTLR start "rule__Concat__Group__14"
    // InternalMyDsl.g:7422:1: rule__Concat__Group__14 : rule__Concat__Group__14__Impl rule__Concat__Group__15 ;
    public final void rule__Concat__Group__14() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:7426:1: ( rule__Concat__Group__14__Impl rule__Concat__Group__15 )
            // InternalMyDsl.g:7427:2: rule__Concat__Group__14__Impl rule__Concat__Group__15
            {
            pushFollow(FOLLOW_3);
            rule__Concat__Group__14__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Concat__Group__15();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Concat__Group__14"


    // $ANTLR start "rule__Concat__Group__14__Impl"
    // InternalMyDsl.g:7434:1: rule__Concat__Group__14__Impl : ( 'next' ) ;
    public final void rule__Concat__Group__14__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:7438:1: ( ( 'next' ) )
            // InternalMyDsl.g:7439:1: ( 'next' )
            {
            // InternalMyDsl.g:7439:1: ( 'next' )
            // InternalMyDsl.g:7440:2: 'next'
            {
             before(grammarAccess.getConcatAccess().getNextKeyword_14()); 
            match(input,60,FOLLOW_2); 
             after(grammarAccess.getConcatAccess().getNextKeyword_14()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Concat__Group__14__Impl"


    // $ANTLR start "rule__Concat__Group__15"
    // InternalMyDsl.g:7449:1: rule__Concat__Group__15 : rule__Concat__Group__15__Impl rule__Concat__Group__16 ;
    public final void rule__Concat__Group__15() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:7453:1: ( rule__Concat__Group__15__Impl rule__Concat__Group__16 )
            // InternalMyDsl.g:7454:2: rule__Concat__Group__15__Impl rule__Concat__Group__16
            {
            pushFollow(FOLLOW_13);
            rule__Concat__Group__15__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Concat__Group__16();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Concat__Group__15"


    // $ANTLR start "rule__Concat__Group__15__Impl"
    // InternalMyDsl.g:7461:1: rule__Concat__Group__15__Impl : ( ( rule__Concat__NextAssignment_15 ) ) ;
    public final void rule__Concat__Group__15__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:7465:1: ( ( ( rule__Concat__NextAssignment_15 ) ) )
            // InternalMyDsl.g:7466:1: ( ( rule__Concat__NextAssignment_15 ) )
            {
            // InternalMyDsl.g:7466:1: ( ( rule__Concat__NextAssignment_15 ) )
            // InternalMyDsl.g:7467:2: ( rule__Concat__NextAssignment_15 )
            {
             before(grammarAccess.getConcatAccess().getNextAssignment_15()); 
            // InternalMyDsl.g:7468:2: ( rule__Concat__NextAssignment_15 )
            // InternalMyDsl.g:7468:3: rule__Concat__NextAssignment_15
            {
            pushFollow(FOLLOW_2);
            rule__Concat__NextAssignment_15();

            state._fsp--;


            }

             after(grammarAccess.getConcatAccess().getNextAssignment_15()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Concat__Group__15__Impl"


    // $ANTLR start "rule__Concat__Group__16"
    // InternalMyDsl.g:7476:1: rule__Concat__Group__16 : rule__Concat__Group__16__Impl ;
    public final void rule__Concat__Group__16() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:7480:1: ( rule__Concat__Group__16__Impl )
            // InternalMyDsl.g:7481:2: rule__Concat__Group__16__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Concat__Group__16__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Concat__Group__16"


    // $ANTLR start "rule__Concat__Group__16__Impl"
    // InternalMyDsl.g:7487:1: rule__Concat__Group__16__Impl : ( '}' ) ;
    public final void rule__Concat__Group__16__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:7491:1: ( ( '}' ) )
            // InternalMyDsl.g:7492:1: ( '}' )
            {
            // InternalMyDsl.g:7492:1: ( '}' )
            // InternalMyDsl.g:7493:2: '}'
            {
             before(grammarAccess.getConcatAccess().getRightCurlyBracketKeyword_16()); 
            match(input,41,FOLLOW_2); 
             after(grammarAccess.getConcatAccess().getRightCurlyBracketKeyword_16()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Concat__Group__16__Impl"


    // $ANTLR start "rule__Concat__Group_3__0"
    // InternalMyDsl.g:7503:1: rule__Concat__Group_3__0 : rule__Concat__Group_3__0__Impl rule__Concat__Group_3__1 ;
    public final void rule__Concat__Group_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:7507:1: ( rule__Concat__Group_3__0__Impl rule__Concat__Group_3__1 )
            // InternalMyDsl.g:7508:2: rule__Concat__Group_3__0__Impl rule__Concat__Group_3__1
            {
            pushFollow(FOLLOW_3);
            rule__Concat__Group_3__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Concat__Group_3__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Concat__Group_3__0"


    // $ANTLR start "rule__Concat__Group_3__0__Impl"
    // InternalMyDsl.g:7515:1: rule__Concat__Group_3__0__Impl : ( 'description' ) ;
    public final void rule__Concat__Group_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:7519:1: ( ( 'description' ) )
            // InternalMyDsl.g:7520:1: ( 'description' )
            {
            // InternalMyDsl.g:7520:1: ( 'description' )
            // InternalMyDsl.g:7521:2: 'description'
            {
             before(grammarAccess.getConcatAccess().getDescriptionKeyword_3_0()); 
            match(input,50,FOLLOW_2); 
             after(grammarAccess.getConcatAccess().getDescriptionKeyword_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Concat__Group_3__0__Impl"


    // $ANTLR start "rule__Concat__Group_3__1"
    // InternalMyDsl.g:7530:1: rule__Concat__Group_3__1 : rule__Concat__Group_3__1__Impl ;
    public final void rule__Concat__Group_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:7534:1: ( rule__Concat__Group_3__1__Impl )
            // InternalMyDsl.g:7535:2: rule__Concat__Group_3__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Concat__Group_3__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Concat__Group_3__1"


    // $ANTLR start "rule__Concat__Group_3__1__Impl"
    // InternalMyDsl.g:7541:1: rule__Concat__Group_3__1__Impl : ( ( rule__Concat__DescriptionAssignment_3_1 ) ) ;
    public final void rule__Concat__Group_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:7545:1: ( ( ( rule__Concat__DescriptionAssignment_3_1 ) ) )
            // InternalMyDsl.g:7546:1: ( ( rule__Concat__DescriptionAssignment_3_1 ) )
            {
            // InternalMyDsl.g:7546:1: ( ( rule__Concat__DescriptionAssignment_3_1 ) )
            // InternalMyDsl.g:7547:2: ( rule__Concat__DescriptionAssignment_3_1 )
            {
             before(grammarAccess.getConcatAccess().getDescriptionAssignment_3_1()); 
            // InternalMyDsl.g:7548:2: ( rule__Concat__DescriptionAssignment_3_1 )
            // InternalMyDsl.g:7548:3: rule__Concat__DescriptionAssignment_3_1
            {
            pushFollow(FOLLOW_2);
            rule__Concat__DescriptionAssignment_3_1();

            state._fsp--;


            }

             after(grammarAccess.getConcatAccess().getDescriptionAssignment_3_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Concat__Group_3__1__Impl"


    // $ANTLR start "rule__Split__Group__0"
    // InternalMyDsl.g:7557:1: rule__Split__Group__0 : rule__Split__Group__0__Impl rule__Split__Group__1 ;
    public final void rule__Split__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:7561:1: ( rule__Split__Group__0__Impl rule__Split__Group__1 )
            // InternalMyDsl.g:7562:2: rule__Split__Group__0__Impl rule__Split__Group__1
            {
            pushFollow(FOLLOW_3);
            rule__Split__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Split__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Split__Group__0"


    // $ANTLR start "rule__Split__Group__0__Impl"
    // InternalMyDsl.g:7569:1: rule__Split__Group__0__Impl : ( 'Split' ) ;
    public final void rule__Split__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:7573:1: ( ( 'Split' ) )
            // InternalMyDsl.g:7574:1: ( 'Split' )
            {
            // InternalMyDsl.g:7574:1: ( 'Split' )
            // InternalMyDsl.g:7575:2: 'Split'
            {
             before(grammarAccess.getSplitAccess().getSplitKeyword_0()); 
            match(input,89,FOLLOW_2); 
             after(grammarAccess.getSplitAccess().getSplitKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Split__Group__0__Impl"


    // $ANTLR start "rule__Split__Group__1"
    // InternalMyDsl.g:7584:1: rule__Split__Group__1 : rule__Split__Group__1__Impl rule__Split__Group__2 ;
    public final void rule__Split__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:7588:1: ( rule__Split__Group__1__Impl rule__Split__Group__2 )
            // InternalMyDsl.g:7589:2: rule__Split__Group__1__Impl rule__Split__Group__2
            {
            pushFollow(FOLLOW_4);
            rule__Split__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Split__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Split__Group__1"


    // $ANTLR start "rule__Split__Group__1__Impl"
    // InternalMyDsl.g:7596:1: rule__Split__Group__1__Impl : ( ( rule__Split__NameAssignment_1 ) ) ;
    public final void rule__Split__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:7600:1: ( ( ( rule__Split__NameAssignment_1 ) ) )
            // InternalMyDsl.g:7601:1: ( ( rule__Split__NameAssignment_1 ) )
            {
            // InternalMyDsl.g:7601:1: ( ( rule__Split__NameAssignment_1 ) )
            // InternalMyDsl.g:7602:2: ( rule__Split__NameAssignment_1 )
            {
             before(grammarAccess.getSplitAccess().getNameAssignment_1()); 
            // InternalMyDsl.g:7603:2: ( rule__Split__NameAssignment_1 )
            // InternalMyDsl.g:7603:3: rule__Split__NameAssignment_1
            {
            pushFollow(FOLLOW_2);
            rule__Split__NameAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getSplitAccess().getNameAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Split__Group__1__Impl"


    // $ANTLR start "rule__Split__Group__2"
    // InternalMyDsl.g:7611:1: rule__Split__Group__2 : rule__Split__Group__2__Impl rule__Split__Group__3 ;
    public final void rule__Split__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:7615:1: ( rule__Split__Group__2__Impl rule__Split__Group__3 )
            // InternalMyDsl.g:7616:2: rule__Split__Group__2__Impl rule__Split__Group__3
            {
            pushFollow(FOLLOW_20);
            rule__Split__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Split__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Split__Group__2"


    // $ANTLR start "rule__Split__Group__2__Impl"
    // InternalMyDsl.g:7623:1: rule__Split__Group__2__Impl : ( '{' ) ;
    public final void rule__Split__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:7627:1: ( ( '{' ) )
            // InternalMyDsl.g:7628:1: ( '{' )
            {
            // InternalMyDsl.g:7628:1: ( '{' )
            // InternalMyDsl.g:7629:2: '{'
            {
             before(grammarAccess.getSplitAccess().getLeftCurlyBracketKeyword_2()); 
            match(input,38,FOLLOW_2); 
             after(grammarAccess.getSplitAccess().getLeftCurlyBracketKeyword_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Split__Group__2__Impl"


    // $ANTLR start "rule__Split__Group__3"
    // InternalMyDsl.g:7638:1: rule__Split__Group__3 : rule__Split__Group__3__Impl rule__Split__Group__4 ;
    public final void rule__Split__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:7642:1: ( rule__Split__Group__3__Impl rule__Split__Group__4 )
            // InternalMyDsl.g:7643:2: rule__Split__Group__3__Impl rule__Split__Group__4
            {
            pushFollow(FOLLOW_20);
            rule__Split__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Split__Group__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Split__Group__3"


    // $ANTLR start "rule__Split__Group__3__Impl"
    // InternalMyDsl.g:7650:1: rule__Split__Group__3__Impl : ( ( rule__Split__Group_3__0 )? ) ;
    public final void rule__Split__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:7654:1: ( ( ( rule__Split__Group_3__0 )? ) )
            // InternalMyDsl.g:7655:1: ( ( rule__Split__Group_3__0 )? )
            {
            // InternalMyDsl.g:7655:1: ( ( rule__Split__Group_3__0 )? )
            // InternalMyDsl.g:7656:2: ( rule__Split__Group_3__0 )?
            {
             before(grammarAccess.getSplitAccess().getGroup_3()); 
            // InternalMyDsl.g:7657:2: ( rule__Split__Group_3__0 )?
            int alt29=2;
            int LA29_0 = input.LA(1);

            if ( (LA29_0==50) ) {
                alt29=1;
            }
            switch (alt29) {
                case 1 :
                    // InternalMyDsl.g:7657:3: rule__Split__Group_3__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__Split__Group_3__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getSplitAccess().getGroup_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Split__Group__3__Impl"


    // $ANTLR start "rule__Split__Group__4"
    // InternalMyDsl.g:7665:1: rule__Split__Group__4 : rule__Split__Group__4__Impl rule__Split__Group__5 ;
    public final void rule__Split__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:7669:1: ( rule__Split__Group__4__Impl rule__Split__Group__5 )
            // InternalMyDsl.g:7670:2: rule__Split__Group__4__Impl rule__Split__Group__5
            {
            pushFollow(FOLLOW_3);
            rule__Split__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Split__Group__5();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Split__Group__4"


    // $ANTLR start "rule__Split__Group__4__Impl"
    // InternalMyDsl.g:7677:1: rule__Split__Group__4__Impl : ( 'table' ) ;
    public final void rule__Split__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:7681:1: ( ( 'table' ) )
            // InternalMyDsl.g:7682:1: ( 'table' )
            {
            // InternalMyDsl.g:7682:1: ( 'table' )
            // InternalMyDsl.g:7683:2: 'table'
            {
             before(grammarAccess.getSplitAccess().getTableKeyword_4()); 
            match(input,52,FOLLOW_2); 
             after(grammarAccess.getSplitAccess().getTableKeyword_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Split__Group__4__Impl"


    // $ANTLR start "rule__Split__Group__5"
    // InternalMyDsl.g:7692:1: rule__Split__Group__5 : rule__Split__Group__5__Impl rule__Split__Group__6 ;
    public final void rule__Split__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:7696:1: ( rule__Split__Group__5__Impl rule__Split__Group__6 )
            // InternalMyDsl.g:7697:2: rule__Split__Group__5__Impl rule__Split__Group__6
            {
            pushFollow(FOLLOW_56);
            rule__Split__Group__5__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Split__Group__6();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Split__Group__5"


    // $ANTLR start "rule__Split__Group__5__Impl"
    // InternalMyDsl.g:7704:1: rule__Split__Group__5__Impl : ( ( rule__Split__TableAssignment_5 ) ) ;
    public final void rule__Split__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:7708:1: ( ( ( rule__Split__TableAssignment_5 ) ) )
            // InternalMyDsl.g:7709:1: ( ( rule__Split__TableAssignment_5 ) )
            {
            // InternalMyDsl.g:7709:1: ( ( rule__Split__TableAssignment_5 ) )
            // InternalMyDsl.g:7710:2: ( rule__Split__TableAssignment_5 )
            {
             before(grammarAccess.getSplitAccess().getTableAssignment_5()); 
            // InternalMyDsl.g:7711:2: ( rule__Split__TableAssignment_5 )
            // InternalMyDsl.g:7711:3: rule__Split__TableAssignment_5
            {
            pushFollow(FOLLOW_2);
            rule__Split__TableAssignment_5();

            state._fsp--;


            }

             after(grammarAccess.getSplitAccess().getTableAssignment_5()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Split__Group__5__Impl"


    // $ANTLR start "rule__Split__Group__6"
    // InternalMyDsl.g:7719:1: rule__Split__Group__6 : rule__Split__Group__6__Impl rule__Split__Group__7 ;
    public final void rule__Split__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:7723:1: ( rule__Split__Group__6__Impl rule__Split__Group__7 )
            // InternalMyDsl.g:7724:2: rule__Split__Group__6__Impl rule__Split__Group__7
            {
            pushFollow(FOLLOW_3);
            rule__Split__Group__6__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Split__Group__7();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Split__Group__6"


    // $ANTLR start "rule__Split__Group__6__Impl"
    // InternalMyDsl.g:7731:1: rule__Split__Group__6__Impl : ( 'source' ) ;
    public final void rule__Split__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:7735:1: ( ( 'source' ) )
            // InternalMyDsl.g:7736:1: ( 'source' )
            {
            // InternalMyDsl.g:7736:1: ( 'source' )
            // InternalMyDsl.g:7737:2: 'source'
            {
             before(grammarAccess.getSplitAccess().getSourceKeyword_6()); 
            match(input,90,FOLLOW_2); 
             after(grammarAccess.getSplitAccess().getSourceKeyword_6()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Split__Group__6__Impl"


    // $ANTLR start "rule__Split__Group__7"
    // InternalMyDsl.g:7746:1: rule__Split__Group__7 : rule__Split__Group__7__Impl rule__Split__Group__8 ;
    public final void rule__Split__Group__7() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:7750:1: ( rule__Split__Group__7__Impl rule__Split__Group__8 )
            // InternalMyDsl.g:7751:2: rule__Split__Group__7__Impl rule__Split__Group__8
            {
            pushFollow(FOLLOW_57);
            rule__Split__Group__7__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Split__Group__8();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Split__Group__7"


    // $ANTLR start "rule__Split__Group__7__Impl"
    // InternalMyDsl.g:7758:1: rule__Split__Group__7__Impl : ( ( rule__Split__SourceAssignment_7 ) ) ;
    public final void rule__Split__Group__7__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:7762:1: ( ( ( rule__Split__SourceAssignment_7 ) ) )
            // InternalMyDsl.g:7763:1: ( ( rule__Split__SourceAssignment_7 ) )
            {
            // InternalMyDsl.g:7763:1: ( ( rule__Split__SourceAssignment_7 ) )
            // InternalMyDsl.g:7764:2: ( rule__Split__SourceAssignment_7 )
            {
             before(grammarAccess.getSplitAccess().getSourceAssignment_7()); 
            // InternalMyDsl.g:7765:2: ( rule__Split__SourceAssignment_7 )
            // InternalMyDsl.g:7765:3: rule__Split__SourceAssignment_7
            {
            pushFollow(FOLLOW_2);
            rule__Split__SourceAssignment_7();

            state._fsp--;


            }

             after(grammarAccess.getSplitAccess().getSourceAssignment_7()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Split__Group__7__Impl"


    // $ANTLR start "rule__Split__Group__8"
    // InternalMyDsl.g:7773:1: rule__Split__Group__8 : rule__Split__Group__8__Impl rule__Split__Group__9 ;
    public final void rule__Split__Group__8() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:7777:1: ( rule__Split__Group__8__Impl rule__Split__Group__9 )
            // InternalMyDsl.g:7778:2: rule__Split__Group__8__Impl rule__Split__Group__9
            {
            pushFollow(FOLLOW_3);
            rule__Split__Group__8__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Split__Group__9();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Split__Group__8"


    // $ANTLR start "rule__Split__Group__8__Impl"
    // InternalMyDsl.g:7785:1: rule__Split__Group__8__Impl : ( 'delimiter' ) ;
    public final void rule__Split__Group__8__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:7789:1: ( ( 'delimiter' ) )
            // InternalMyDsl.g:7790:1: ( 'delimiter' )
            {
            // InternalMyDsl.g:7790:1: ( 'delimiter' )
            // InternalMyDsl.g:7791:2: 'delimiter'
            {
             before(grammarAccess.getSplitAccess().getDelimiterKeyword_8()); 
            match(input,91,FOLLOW_2); 
             after(grammarAccess.getSplitAccess().getDelimiterKeyword_8()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Split__Group__8__Impl"


    // $ANTLR start "rule__Split__Group__9"
    // InternalMyDsl.g:7800:1: rule__Split__Group__9 : rule__Split__Group__9__Impl rule__Split__Group__10 ;
    public final void rule__Split__Group__9() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:7804:1: ( rule__Split__Group__9__Impl rule__Split__Group__10 )
            // InternalMyDsl.g:7805:2: rule__Split__Group__9__Impl rule__Split__Group__10
            {
            pushFollow(FOLLOW_58);
            rule__Split__Group__9__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Split__Group__10();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Split__Group__9"


    // $ANTLR start "rule__Split__Group__9__Impl"
    // InternalMyDsl.g:7812:1: rule__Split__Group__9__Impl : ( ( rule__Split__DelimiterAssignment_9 ) ) ;
    public final void rule__Split__Group__9__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:7816:1: ( ( ( rule__Split__DelimiterAssignment_9 ) ) )
            // InternalMyDsl.g:7817:1: ( ( rule__Split__DelimiterAssignment_9 ) )
            {
            // InternalMyDsl.g:7817:1: ( ( rule__Split__DelimiterAssignment_9 ) )
            // InternalMyDsl.g:7818:2: ( rule__Split__DelimiterAssignment_9 )
            {
             before(grammarAccess.getSplitAccess().getDelimiterAssignment_9()); 
            // InternalMyDsl.g:7819:2: ( rule__Split__DelimiterAssignment_9 )
            // InternalMyDsl.g:7819:3: rule__Split__DelimiterAssignment_9
            {
            pushFollow(FOLLOW_2);
            rule__Split__DelimiterAssignment_9();

            state._fsp--;


            }

             after(grammarAccess.getSplitAccess().getDelimiterAssignment_9()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Split__Group__9__Impl"


    // $ANTLR start "rule__Split__Group__10"
    // InternalMyDsl.g:7827:1: rule__Split__Group__10 : rule__Split__Group__10__Impl rule__Split__Group__11 ;
    public final void rule__Split__Group__10() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:7831:1: ( rule__Split__Group__10__Impl rule__Split__Group__11 )
            // InternalMyDsl.g:7832:2: rule__Split__Group__10__Impl rule__Split__Group__11
            {
            pushFollow(FOLLOW_59);
            rule__Split__Group__10__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Split__Group__11();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Split__Group__10"


    // $ANTLR start "rule__Split__Group__10__Impl"
    // InternalMyDsl.g:7839:1: rule__Split__Group__10__Impl : ( 'atCharIndex' ) ;
    public final void rule__Split__Group__10__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:7843:1: ( ( 'atCharIndex' ) )
            // InternalMyDsl.g:7844:1: ( 'atCharIndex' )
            {
            // InternalMyDsl.g:7844:1: ( 'atCharIndex' )
            // InternalMyDsl.g:7845:2: 'atCharIndex'
            {
             before(grammarAccess.getSplitAccess().getAtCharIndexKeyword_10()); 
            match(input,92,FOLLOW_2); 
             after(grammarAccess.getSplitAccess().getAtCharIndexKeyword_10()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Split__Group__10__Impl"


    // $ANTLR start "rule__Split__Group__11"
    // InternalMyDsl.g:7854:1: rule__Split__Group__11 : rule__Split__Group__11__Impl rule__Split__Group__12 ;
    public final void rule__Split__Group__11() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:7858:1: ( rule__Split__Group__11__Impl rule__Split__Group__12 )
            // InternalMyDsl.g:7859:2: rule__Split__Group__11__Impl rule__Split__Group__12
            {
            pushFollow(FOLLOW_60);
            rule__Split__Group__11__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Split__Group__12();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Split__Group__11"


    // $ANTLR start "rule__Split__Group__11__Impl"
    // InternalMyDsl.g:7866:1: rule__Split__Group__11__Impl : ( ( rule__Split__AtCharIndexAssignment_11 ) ) ;
    public final void rule__Split__Group__11__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:7870:1: ( ( ( rule__Split__AtCharIndexAssignment_11 ) ) )
            // InternalMyDsl.g:7871:1: ( ( rule__Split__AtCharIndexAssignment_11 ) )
            {
            // InternalMyDsl.g:7871:1: ( ( rule__Split__AtCharIndexAssignment_11 ) )
            // InternalMyDsl.g:7872:2: ( rule__Split__AtCharIndexAssignment_11 )
            {
             before(grammarAccess.getSplitAccess().getAtCharIndexAssignment_11()); 
            // InternalMyDsl.g:7873:2: ( rule__Split__AtCharIndexAssignment_11 )
            // InternalMyDsl.g:7873:3: rule__Split__AtCharIndexAssignment_11
            {
            pushFollow(FOLLOW_2);
            rule__Split__AtCharIndexAssignment_11();

            state._fsp--;


            }

             after(grammarAccess.getSplitAccess().getAtCharIndexAssignment_11()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Split__Group__11__Impl"


    // $ANTLR start "rule__Split__Group__12"
    // InternalMyDsl.g:7881:1: rule__Split__Group__12 : rule__Split__Group__12__Impl rule__Split__Group__13 ;
    public final void rule__Split__Group__12() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:7885:1: ( rule__Split__Group__12__Impl rule__Split__Group__13 )
            // InternalMyDsl.g:7886:2: rule__Split__Group__12__Impl rule__Split__Group__13
            {
            pushFollow(FOLLOW_3);
            rule__Split__Group__12__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Split__Group__13();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Split__Group__12"


    // $ANTLR start "rule__Split__Group__12__Impl"
    // InternalMyDsl.g:7893:1: rule__Split__Group__12__Impl : ( 'resultColumnA' ) ;
    public final void rule__Split__Group__12__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:7897:1: ( ( 'resultColumnA' ) )
            // InternalMyDsl.g:7898:1: ( 'resultColumnA' )
            {
            // InternalMyDsl.g:7898:1: ( 'resultColumnA' )
            // InternalMyDsl.g:7899:2: 'resultColumnA'
            {
             before(grammarAccess.getSplitAccess().getResultColumnAKeyword_12()); 
            match(input,93,FOLLOW_2); 
             after(grammarAccess.getSplitAccess().getResultColumnAKeyword_12()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Split__Group__12__Impl"


    // $ANTLR start "rule__Split__Group__13"
    // InternalMyDsl.g:7908:1: rule__Split__Group__13 : rule__Split__Group__13__Impl rule__Split__Group__14 ;
    public final void rule__Split__Group__13() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:7912:1: ( rule__Split__Group__13__Impl rule__Split__Group__14 )
            // InternalMyDsl.g:7913:2: rule__Split__Group__13__Impl rule__Split__Group__14
            {
            pushFollow(FOLLOW_61);
            rule__Split__Group__13__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Split__Group__14();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Split__Group__13"


    // $ANTLR start "rule__Split__Group__13__Impl"
    // InternalMyDsl.g:7920:1: rule__Split__Group__13__Impl : ( ( rule__Split__ResultColumnAAssignment_13 ) ) ;
    public final void rule__Split__Group__13__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:7924:1: ( ( ( rule__Split__ResultColumnAAssignment_13 ) ) )
            // InternalMyDsl.g:7925:1: ( ( rule__Split__ResultColumnAAssignment_13 ) )
            {
            // InternalMyDsl.g:7925:1: ( ( rule__Split__ResultColumnAAssignment_13 ) )
            // InternalMyDsl.g:7926:2: ( rule__Split__ResultColumnAAssignment_13 )
            {
             before(grammarAccess.getSplitAccess().getResultColumnAAssignment_13()); 
            // InternalMyDsl.g:7927:2: ( rule__Split__ResultColumnAAssignment_13 )
            // InternalMyDsl.g:7927:3: rule__Split__ResultColumnAAssignment_13
            {
            pushFollow(FOLLOW_2);
            rule__Split__ResultColumnAAssignment_13();

            state._fsp--;


            }

             after(grammarAccess.getSplitAccess().getResultColumnAAssignment_13()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Split__Group__13__Impl"


    // $ANTLR start "rule__Split__Group__14"
    // InternalMyDsl.g:7935:1: rule__Split__Group__14 : rule__Split__Group__14__Impl rule__Split__Group__15 ;
    public final void rule__Split__Group__14() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:7939:1: ( rule__Split__Group__14__Impl rule__Split__Group__15 )
            // InternalMyDsl.g:7940:2: rule__Split__Group__14__Impl rule__Split__Group__15
            {
            pushFollow(FOLLOW_3);
            rule__Split__Group__14__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Split__Group__15();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Split__Group__14"


    // $ANTLR start "rule__Split__Group__14__Impl"
    // InternalMyDsl.g:7947:1: rule__Split__Group__14__Impl : ( 'resultColumnB' ) ;
    public final void rule__Split__Group__14__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:7951:1: ( ( 'resultColumnB' ) )
            // InternalMyDsl.g:7952:1: ( 'resultColumnB' )
            {
            // InternalMyDsl.g:7952:1: ( 'resultColumnB' )
            // InternalMyDsl.g:7953:2: 'resultColumnB'
            {
             before(grammarAccess.getSplitAccess().getResultColumnBKeyword_14()); 
            match(input,94,FOLLOW_2); 
             after(grammarAccess.getSplitAccess().getResultColumnBKeyword_14()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Split__Group__14__Impl"


    // $ANTLR start "rule__Split__Group__15"
    // InternalMyDsl.g:7962:1: rule__Split__Group__15 : rule__Split__Group__15__Impl rule__Split__Group__16 ;
    public final void rule__Split__Group__15() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:7966:1: ( rule__Split__Group__15__Impl rule__Split__Group__16 )
            // InternalMyDsl.g:7967:2: rule__Split__Group__15__Impl rule__Split__Group__16
            {
            pushFollow(FOLLOW_27);
            rule__Split__Group__15__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Split__Group__16();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Split__Group__15"


    // $ANTLR start "rule__Split__Group__15__Impl"
    // InternalMyDsl.g:7974:1: rule__Split__Group__15__Impl : ( ( rule__Split__ResultColumnBAssignment_15 ) ) ;
    public final void rule__Split__Group__15__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:7978:1: ( ( ( rule__Split__ResultColumnBAssignment_15 ) ) )
            // InternalMyDsl.g:7979:1: ( ( rule__Split__ResultColumnBAssignment_15 ) )
            {
            // InternalMyDsl.g:7979:1: ( ( rule__Split__ResultColumnBAssignment_15 ) )
            // InternalMyDsl.g:7980:2: ( rule__Split__ResultColumnBAssignment_15 )
            {
             before(grammarAccess.getSplitAccess().getResultColumnBAssignment_15()); 
            // InternalMyDsl.g:7981:2: ( rule__Split__ResultColumnBAssignment_15 )
            // InternalMyDsl.g:7981:3: rule__Split__ResultColumnBAssignment_15
            {
            pushFollow(FOLLOW_2);
            rule__Split__ResultColumnBAssignment_15();

            state._fsp--;


            }

             after(grammarAccess.getSplitAccess().getResultColumnBAssignment_15()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Split__Group__15__Impl"


    // $ANTLR start "rule__Split__Group__16"
    // InternalMyDsl.g:7989:1: rule__Split__Group__16 : rule__Split__Group__16__Impl rule__Split__Group__17 ;
    public final void rule__Split__Group__16() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:7993:1: ( rule__Split__Group__16__Impl rule__Split__Group__17 )
            // InternalMyDsl.g:7994:2: rule__Split__Group__16__Impl rule__Split__Group__17
            {
            pushFollow(FOLLOW_3);
            rule__Split__Group__16__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Split__Group__17();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Split__Group__16"


    // $ANTLR start "rule__Split__Group__16__Impl"
    // InternalMyDsl.g:8001:1: rule__Split__Group__16__Impl : ( 'resultTable' ) ;
    public final void rule__Split__Group__16__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:8005:1: ( ( 'resultTable' ) )
            // InternalMyDsl.g:8006:1: ( 'resultTable' )
            {
            // InternalMyDsl.g:8006:1: ( 'resultTable' )
            // InternalMyDsl.g:8007:2: 'resultTable'
            {
             before(grammarAccess.getSplitAccess().getResultTableKeyword_16()); 
            match(input,58,FOLLOW_2); 
             after(grammarAccess.getSplitAccess().getResultTableKeyword_16()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Split__Group__16__Impl"


    // $ANTLR start "rule__Split__Group__17"
    // InternalMyDsl.g:8016:1: rule__Split__Group__17 : rule__Split__Group__17__Impl rule__Split__Group__18 ;
    public final void rule__Split__Group__17() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:8020:1: ( rule__Split__Group__17__Impl rule__Split__Group__18 )
            // InternalMyDsl.g:8021:2: rule__Split__Group__17__Impl rule__Split__Group__18
            {
            pushFollow(FOLLOW_29);
            rule__Split__Group__17__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Split__Group__18();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Split__Group__17"


    // $ANTLR start "rule__Split__Group__17__Impl"
    // InternalMyDsl.g:8028:1: rule__Split__Group__17__Impl : ( ( rule__Split__ResultTableAssignment_17 ) ) ;
    public final void rule__Split__Group__17__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:8032:1: ( ( ( rule__Split__ResultTableAssignment_17 ) ) )
            // InternalMyDsl.g:8033:1: ( ( rule__Split__ResultTableAssignment_17 ) )
            {
            // InternalMyDsl.g:8033:1: ( ( rule__Split__ResultTableAssignment_17 ) )
            // InternalMyDsl.g:8034:2: ( rule__Split__ResultTableAssignment_17 )
            {
             before(grammarAccess.getSplitAccess().getResultTableAssignment_17()); 
            // InternalMyDsl.g:8035:2: ( rule__Split__ResultTableAssignment_17 )
            // InternalMyDsl.g:8035:3: rule__Split__ResultTableAssignment_17
            {
            pushFollow(FOLLOW_2);
            rule__Split__ResultTableAssignment_17();

            state._fsp--;


            }

             after(grammarAccess.getSplitAccess().getResultTableAssignment_17()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Split__Group__17__Impl"


    // $ANTLR start "rule__Split__Group__18"
    // InternalMyDsl.g:8043:1: rule__Split__Group__18 : rule__Split__Group__18__Impl rule__Split__Group__19 ;
    public final void rule__Split__Group__18() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:8047:1: ( rule__Split__Group__18__Impl rule__Split__Group__19 )
            // InternalMyDsl.g:8048:2: rule__Split__Group__18__Impl rule__Split__Group__19
            {
            pushFollow(FOLLOW_3);
            rule__Split__Group__18__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Split__Group__19();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Split__Group__18"


    // $ANTLR start "rule__Split__Group__18__Impl"
    // InternalMyDsl.g:8055:1: rule__Split__Group__18__Impl : ( 'next' ) ;
    public final void rule__Split__Group__18__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:8059:1: ( ( 'next' ) )
            // InternalMyDsl.g:8060:1: ( 'next' )
            {
            // InternalMyDsl.g:8060:1: ( 'next' )
            // InternalMyDsl.g:8061:2: 'next'
            {
             before(grammarAccess.getSplitAccess().getNextKeyword_18()); 
            match(input,60,FOLLOW_2); 
             after(grammarAccess.getSplitAccess().getNextKeyword_18()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Split__Group__18__Impl"


    // $ANTLR start "rule__Split__Group__19"
    // InternalMyDsl.g:8070:1: rule__Split__Group__19 : rule__Split__Group__19__Impl rule__Split__Group__20 ;
    public final void rule__Split__Group__19() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:8074:1: ( rule__Split__Group__19__Impl rule__Split__Group__20 )
            // InternalMyDsl.g:8075:2: rule__Split__Group__19__Impl rule__Split__Group__20
            {
            pushFollow(FOLLOW_13);
            rule__Split__Group__19__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Split__Group__20();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Split__Group__19"


    // $ANTLR start "rule__Split__Group__19__Impl"
    // InternalMyDsl.g:8082:1: rule__Split__Group__19__Impl : ( ( rule__Split__NextAssignment_19 ) ) ;
    public final void rule__Split__Group__19__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:8086:1: ( ( ( rule__Split__NextAssignment_19 ) ) )
            // InternalMyDsl.g:8087:1: ( ( rule__Split__NextAssignment_19 ) )
            {
            // InternalMyDsl.g:8087:1: ( ( rule__Split__NextAssignment_19 ) )
            // InternalMyDsl.g:8088:2: ( rule__Split__NextAssignment_19 )
            {
             before(grammarAccess.getSplitAccess().getNextAssignment_19()); 
            // InternalMyDsl.g:8089:2: ( rule__Split__NextAssignment_19 )
            // InternalMyDsl.g:8089:3: rule__Split__NextAssignment_19
            {
            pushFollow(FOLLOW_2);
            rule__Split__NextAssignment_19();

            state._fsp--;


            }

             after(grammarAccess.getSplitAccess().getNextAssignment_19()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Split__Group__19__Impl"


    // $ANTLR start "rule__Split__Group__20"
    // InternalMyDsl.g:8097:1: rule__Split__Group__20 : rule__Split__Group__20__Impl ;
    public final void rule__Split__Group__20() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:8101:1: ( rule__Split__Group__20__Impl )
            // InternalMyDsl.g:8102:2: rule__Split__Group__20__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Split__Group__20__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Split__Group__20"


    // $ANTLR start "rule__Split__Group__20__Impl"
    // InternalMyDsl.g:8108:1: rule__Split__Group__20__Impl : ( '}' ) ;
    public final void rule__Split__Group__20__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:8112:1: ( ( '}' ) )
            // InternalMyDsl.g:8113:1: ( '}' )
            {
            // InternalMyDsl.g:8113:1: ( '}' )
            // InternalMyDsl.g:8114:2: '}'
            {
             before(grammarAccess.getSplitAccess().getRightCurlyBracketKeyword_20()); 
            match(input,41,FOLLOW_2); 
             after(grammarAccess.getSplitAccess().getRightCurlyBracketKeyword_20()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Split__Group__20__Impl"


    // $ANTLR start "rule__Split__Group_3__0"
    // InternalMyDsl.g:8124:1: rule__Split__Group_3__0 : rule__Split__Group_3__0__Impl rule__Split__Group_3__1 ;
    public final void rule__Split__Group_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:8128:1: ( rule__Split__Group_3__0__Impl rule__Split__Group_3__1 )
            // InternalMyDsl.g:8129:2: rule__Split__Group_3__0__Impl rule__Split__Group_3__1
            {
            pushFollow(FOLLOW_3);
            rule__Split__Group_3__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Split__Group_3__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Split__Group_3__0"


    // $ANTLR start "rule__Split__Group_3__0__Impl"
    // InternalMyDsl.g:8136:1: rule__Split__Group_3__0__Impl : ( 'description' ) ;
    public final void rule__Split__Group_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:8140:1: ( ( 'description' ) )
            // InternalMyDsl.g:8141:1: ( 'description' )
            {
            // InternalMyDsl.g:8141:1: ( 'description' )
            // InternalMyDsl.g:8142:2: 'description'
            {
             before(grammarAccess.getSplitAccess().getDescriptionKeyword_3_0()); 
            match(input,50,FOLLOW_2); 
             after(grammarAccess.getSplitAccess().getDescriptionKeyword_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Split__Group_3__0__Impl"


    // $ANTLR start "rule__Split__Group_3__1"
    // InternalMyDsl.g:8151:1: rule__Split__Group_3__1 : rule__Split__Group_3__1__Impl ;
    public final void rule__Split__Group_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:8155:1: ( rule__Split__Group_3__1__Impl )
            // InternalMyDsl.g:8156:2: rule__Split__Group_3__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Split__Group_3__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Split__Group_3__1"


    // $ANTLR start "rule__Split__Group_3__1__Impl"
    // InternalMyDsl.g:8162:1: rule__Split__Group_3__1__Impl : ( ( rule__Split__DescriptionAssignment_3_1 ) ) ;
    public final void rule__Split__Group_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:8166:1: ( ( ( rule__Split__DescriptionAssignment_3_1 ) ) )
            // InternalMyDsl.g:8167:1: ( ( rule__Split__DescriptionAssignment_3_1 ) )
            {
            // InternalMyDsl.g:8167:1: ( ( rule__Split__DescriptionAssignment_3_1 ) )
            // InternalMyDsl.g:8168:2: ( rule__Split__DescriptionAssignment_3_1 )
            {
             before(grammarAccess.getSplitAccess().getDescriptionAssignment_3_1()); 
            // InternalMyDsl.g:8169:2: ( rule__Split__DescriptionAssignment_3_1 )
            // InternalMyDsl.g:8169:3: rule__Split__DescriptionAssignment_3_1
            {
            pushFollow(FOLLOW_2);
            rule__Split__DescriptionAssignment_3_1();

            state._fsp--;


            }

             after(grammarAccess.getSplitAccess().getDescriptionAssignment_3_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Split__Group_3__1__Impl"


    // $ANTLR start "rule__Extract__Group__0"
    // InternalMyDsl.g:8178:1: rule__Extract__Group__0 : rule__Extract__Group__0__Impl rule__Extract__Group__1 ;
    public final void rule__Extract__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:8182:1: ( rule__Extract__Group__0__Impl rule__Extract__Group__1 )
            // InternalMyDsl.g:8183:2: rule__Extract__Group__0__Impl rule__Extract__Group__1
            {
            pushFollow(FOLLOW_3);
            rule__Extract__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Extract__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Extract__Group__0"


    // $ANTLR start "rule__Extract__Group__0__Impl"
    // InternalMyDsl.g:8190:1: rule__Extract__Group__0__Impl : ( 'Extract' ) ;
    public final void rule__Extract__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:8194:1: ( ( 'Extract' ) )
            // InternalMyDsl.g:8195:1: ( 'Extract' )
            {
            // InternalMyDsl.g:8195:1: ( 'Extract' )
            // InternalMyDsl.g:8196:2: 'Extract'
            {
             before(grammarAccess.getExtractAccess().getExtractKeyword_0()); 
            match(input,95,FOLLOW_2); 
             after(grammarAccess.getExtractAccess().getExtractKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Extract__Group__0__Impl"


    // $ANTLR start "rule__Extract__Group__1"
    // InternalMyDsl.g:8205:1: rule__Extract__Group__1 : rule__Extract__Group__1__Impl rule__Extract__Group__2 ;
    public final void rule__Extract__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:8209:1: ( rule__Extract__Group__1__Impl rule__Extract__Group__2 )
            // InternalMyDsl.g:8210:2: rule__Extract__Group__1__Impl rule__Extract__Group__2
            {
            pushFollow(FOLLOW_4);
            rule__Extract__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Extract__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Extract__Group__1"


    // $ANTLR start "rule__Extract__Group__1__Impl"
    // InternalMyDsl.g:8217:1: rule__Extract__Group__1__Impl : ( ( rule__Extract__NameAssignment_1 ) ) ;
    public final void rule__Extract__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:8221:1: ( ( ( rule__Extract__NameAssignment_1 ) ) )
            // InternalMyDsl.g:8222:1: ( ( rule__Extract__NameAssignment_1 ) )
            {
            // InternalMyDsl.g:8222:1: ( ( rule__Extract__NameAssignment_1 ) )
            // InternalMyDsl.g:8223:2: ( rule__Extract__NameAssignment_1 )
            {
             before(grammarAccess.getExtractAccess().getNameAssignment_1()); 
            // InternalMyDsl.g:8224:2: ( rule__Extract__NameAssignment_1 )
            // InternalMyDsl.g:8224:3: rule__Extract__NameAssignment_1
            {
            pushFollow(FOLLOW_2);
            rule__Extract__NameAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getExtractAccess().getNameAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Extract__Group__1__Impl"


    // $ANTLR start "rule__Extract__Group__2"
    // InternalMyDsl.g:8232:1: rule__Extract__Group__2 : rule__Extract__Group__2__Impl rule__Extract__Group__3 ;
    public final void rule__Extract__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:8236:1: ( rule__Extract__Group__2__Impl rule__Extract__Group__3 )
            // InternalMyDsl.g:8237:2: rule__Extract__Group__2__Impl rule__Extract__Group__3
            {
            pushFollow(FOLLOW_20);
            rule__Extract__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Extract__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Extract__Group__2"


    // $ANTLR start "rule__Extract__Group__2__Impl"
    // InternalMyDsl.g:8244:1: rule__Extract__Group__2__Impl : ( '{' ) ;
    public final void rule__Extract__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:8248:1: ( ( '{' ) )
            // InternalMyDsl.g:8249:1: ( '{' )
            {
            // InternalMyDsl.g:8249:1: ( '{' )
            // InternalMyDsl.g:8250:2: '{'
            {
             before(grammarAccess.getExtractAccess().getLeftCurlyBracketKeyword_2()); 
            match(input,38,FOLLOW_2); 
             after(grammarAccess.getExtractAccess().getLeftCurlyBracketKeyword_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Extract__Group__2__Impl"


    // $ANTLR start "rule__Extract__Group__3"
    // InternalMyDsl.g:8259:1: rule__Extract__Group__3 : rule__Extract__Group__3__Impl rule__Extract__Group__4 ;
    public final void rule__Extract__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:8263:1: ( rule__Extract__Group__3__Impl rule__Extract__Group__4 )
            // InternalMyDsl.g:8264:2: rule__Extract__Group__3__Impl rule__Extract__Group__4
            {
            pushFollow(FOLLOW_20);
            rule__Extract__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Extract__Group__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Extract__Group__3"


    // $ANTLR start "rule__Extract__Group__3__Impl"
    // InternalMyDsl.g:8271:1: rule__Extract__Group__3__Impl : ( ( rule__Extract__Group_3__0 )? ) ;
    public final void rule__Extract__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:8275:1: ( ( ( rule__Extract__Group_3__0 )? ) )
            // InternalMyDsl.g:8276:1: ( ( rule__Extract__Group_3__0 )? )
            {
            // InternalMyDsl.g:8276:1: ( ( rule__Extract__Group_3__0 )? )
            // InternalMyDsl.g:8277:2: ( rule__Extract__Group_3__0 )?
            {
             before(grammarAccess.getExtractAccess().getGroup_3()); 
            // InternalMyDsl.g:8278:2: ( rule__Extract__Group_3__0 )?
            int alt30=2;
            int LA30_0 = input.LA(1);

            if ( (LA30_0==50) ) {
                alt30=1;
            }
            switch (alt30) {
                case 1 :
                    // InternalMyDsl.g:8278:3: rule__Extract__Group_3__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__Extract__Group_3__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getExtractAccess().getGroup_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Extract__Group__3__Impl"


    // $ANTLR start "rule__Extract__Group__4"
    // InternalMyDsl.g:8286:1: rule__Extract__Group__4 : rule__Extract__Group__4__Impl rule__Extract__Group__5 ;
    public final void rule__Extract__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:8290:1: ( rule__Extract__Group__4__Impl rule__Extract__Group__5 )
            // InternalMyDsl.g:8291:2: rule__Extract__Group__4__Impl rule__Extract__Group__5
            {
            pushFollow(FOLLOW_3);
            rule__Extract__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Extract__Group__5();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Extract__Group__4"


    // $ANTLR start "rule__Extract__Group__4__Impl"
    // InternalMyDsl.g:8298:1: rule__Extract__Group__4__Impl : ( 'table' ) ;
    public final void rule__Extract__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:8302:1: ( ( 'table' ) )
            // InternalMyDsl.g:8303:1: ( 'table' )
            {
            // InternalMyDsl.g:8303:1: ( 'table' )
            // InternalMyDsl.g:8304:2: 'table'
            {
             before(grammarAccess.getExtractAccess().getTableKeyword_4()); 
            match(input,52,FOLLOW_2); 
             after(grammarAccess.getExtractAccess().getTableKeyword_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Extract__Group__4__Impl"


    // $ANTLR start "rule__Extract__Group__5"
    // InternalMyDsl.g:8313:1: rule__Extract__Group__5 : rule__Extract__Group__5__Impl rule__Extract__Group__6 ;
    public final void rule__Extract__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:8317:1: ( rule__Extract__Group__5__Impl rule__Extract__Group__6 )
            // InternalMyDsl.g:8318:2: rule__Extract__Group__5__Impl rule__Extract__Group__6
            {
            pushFollow(FOLLOW_30);
            rule__Extract__Group__5__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Extract__Group__6();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Extract__Group__5"


    // $ANTLR start "rule__Extract__Group__5__Impl"
    // InternalMyDsl.g:8325:1: rule__Extract__Group__5__Impl : ( ( rule__Extract__TableAssignment_5 ) ) ;
    public final void rule__Extract__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:8329:1: ( ( ( rule__Extract__TableAssignment_5 ) ) )
            // InternalMyDsl.g:8330:1: ( ( rule__Extract__TableAssignment_5 ) )
            {
            // InternalMyDsl.g:8330:1: ( ( rule__Extract__TableAssignment_5 ) )
            // InternalMyDsl.g:8331:2: ( rule__Extract__TableAssignment_5 )
            {
             before(grammarAccess.getExtractAccess().getTableAssignment_5()); 
            // InternalMyDsl.g:8332:2: ( rule__Extract__TableAssignment_5 )
            // InternalMyDsl.g:8332:3: rule__Extract__TableAssignment_5
            {
            pushFollow(FOLLOW_2);
            rule__Extract__TableAssignment_5();

            state._fsp--;


            }

             after(grammarAccess.getExtractAccess().getTableAssignment_5()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Extract__Group__5__Impl"


    // $ANTLR start "rule__Extract__Group__6"
    // InternalMyDsl.g:8340:1: rule__Extract__Group__6 : rule__Extract__Group__6__Impl rule__Extract__Group__7 ;
    public final void rule__Extract__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:8344:1: ( rule__Extract__Group__6__Impl rule__Extract__Group__7 )
            // InternalMyDsl.g:8345:2: rule__Extract__Group__6__Impl rule__Extract__Group__7
            {
            pushFollow(FOLLOW_3);
            rule__Extract__Group__6__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Extract__Group__7();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Extract__Group__6"


    // $ANTLR start "rule__Extract__Group__6__Impl"
    // InternalMyDsl.g:8352:1: rule__Extract__Group__6__Impl : ( 'column' ) ;
    public final void rule__Extract__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:8356:1: ( ( 'column' ) )
            // InternalMyDsl.g:8357:1: ( 'column' )
            {
            // InternalMyDsl.g:8357:1: ( 'column' )
            // InternalMyDsl.g:8358:2: 'column'
            {
             before(grammarAccess.getExtractAccess().getColumnKeyword_6()); 
            match(input,62,FOLLOW_2); 
             after(grammarAccess.getExtractAccess().getColumnKeyword_6()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Extract__Group__6__Impl"


    // $ANTLR start "rule__Extract__Group__7"
    // InternalMyDsl.g:8367:1: rule__Extract__Group__7 : rule__Extract__Group__7__Impl rule__Extract__Group__8 ;
    public final void rule__Extract__Group__7() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:8371:1: ( rule__Extract__Group__7__Impl rule__Extract__Group__8 )
            // InternalMyDsl.g:8372:2: rule__Extract__Group__7__Impl rule__Extract__Group__8
            {
            pushFollow(FOLLOW_62);
            rule__Extract__Group__7__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Extract__Group__8();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Extract__Group__7"


    // $ANTLR start "rule__Extract__Group__7__Impl"
    // InternalMyDsl.g:8379:1: rule__Extract__Group__7__Impl : ( ( rule__Extract__ColumnAssignment_7 ) ) ;
    public final void rule__Extract__Group__7__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:8383:1: ( ( ( rule__Extract__ColumnAssignment_7 ) ) )
            // InternalMyDsl.g:8384:1: ( ( rule__Extract__ColumnAssignment_7 ) )
            {
            // InternalMyDsl.g:8384:1: ( ( rule__Extract__ColumnAssignment_7 ) )
            // InternalMyDsl.g:8385:2: ( rule__Extract__ColumnAssignment_7 )
            {
             before(grammarAccess.getExtractAccess().getColumnAssignment_7()); 
            // InternalMyDsl.g:8386:2: ( rule__Extract__ColumnAssignment_7 )
            // InternalMyDsl.g:8386:3: rule__Extract__ColumnAssignment_7
            {
            pushFollow(FOLLOW_2);
            rule__Extract__ColumnAssignment_7();

            state._fsp--;


            }

             after(grammarAccess.getExtractAccess().getColumnAssignment_7()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Extract__Group__7__Impl"


    // $ANTLR start "rule__Extract__Group__8"
    // InternalMyDsl.g:8394:1: rule__Extract__Group__8 : rule__Extract__Group__8__Impl rule__Extract__Group__9 ;
    public final void rule__Extract__Group__8() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:8398:1: ( rule__Extract__Group__8__Impl rule__Extract__Group__9 )
            // InternalMyDsl.g:8399:2: rule__Extract__Group__8__Impl rule__Extract__Group__9
            {
            pushFollow(FOLLOW_59);
            rule__Extract__Group__8__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Extract__Group__9();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Extract__Group__8"


    // $ANTLR start "rule__Extract__Group__8__Impl"
    // InternalMyDsl.g:8406:1: rule__Extract__Group__8__Impl : ( 'lbChar' ) ;
    public final void rule__Extract__Group__8__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:8410:1: ( ( 'lbChar' ) )
            // InternalMyDsl.g:8411:1: ( 'lbChar' )
            {
            // InternalMyDsl.g:8411:1: ( 'lbChar' )
            // InternalMyDsl.g:8412:2: 'lbChar'
            {
             before(grammarAccess.getExtractAccess().getLbCharKeyword_8()); 
            match(input,96,FOLLOW_2); 
             after(grammarAccess.getExtractAccess().getLbCharKeyword_8()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Extract__Group__8__Impl"


    // $ANTLR start "rule__Extract__Group__9"
    // InternalMyDsl.g:8421:1: rule__Extract__Group__9 : rule__Extract__Group__9__Impl rule__Extract__Group__10 ;
    public final void rule__Extract__Group__9() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:8425:1: ( rule__Extract__Group__9__Impl rule__Extract__Group__10 )
            // InternalMyDsl.g:8426:2: rule__Extract__Group__9__Impl rule__Extract__Group__10
            {
            pushFollow(FOLLOW_63);
            rule__Extract__Group__9__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Extract__Group__10();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Extract__Group__9"


    // $ANTLR start "rule__Extract__Group__9__Impl"
    // InternalMyDsl.g:8433:1: rule__Extract__Group__9__Impl : ( ( rule__Extract__LbCharAssignment_9 ) ) ;
    public final void rule__Extract__Group__9__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:8437:1: ( ( ( rule__Extract__LbCharAssignment_9 ) ) )
            // InternalMyDsl.g:8438:1: ( ( rule__Extract__LbCharAssignment_9 ) )
            {
            // InternalMyDsl.g:8438:1: ( ( rule__Extract__LbCharAssignment_9 ) )
            // InternalMyDsl.g:8439:2: ( rule__Extract__LbCharAssignment_9 )
            {
             before(grammarAccess.getExtractAccess().getLbCharAssignment_9()); 
            // InternalMyDsl.g:8440:2: ( rule__Extract__LbCharAssignment_9 )
            // InternalMyDsl.g:8440:3: rule__Extract__LbCharAssignment_9
            {
            pushFollow(FOLLOW_2);
            rule__Extract__LbCharAssignment_9();

            state._fsp--;


            }

             after(grammarAccess.getExtractAccess().getLbCharAssignment_9()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Extract__Group__9__Impl"


    // $ANTLR start "rule__Extract__Group__10"
    // InternalMyDsl.g:8448:1: rule__Extract__Group__10 : rule__Extract__Group__10__Impl rule__Extract__Group__11 ;
    public final void rule__Extract__Group__10() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:8452:1: ( rule__Extract__Group__10__Impl rule__Extract__Group__11 )
            // InternalMyDsl.g:8453:2: rule__Extract__Group__10__Impl rule__Extract__Group__11
            {
            pushFollow(FOLLOW_59);
            rule__Extract__Group__10__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Extract__Group__11();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Extract__Group__10"


    // $ANTLR start "rule__Extract__Group__10__Impl"
    // InternalMyDsl.g:8460:1: rule__Extract__Group__10__Impl : ( 'ubChar' ) ;
    public final void rule__Extract__Group__10__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:8464:1: ( ( 'ubChar' ) )
            // InternalMyDsl.g:8465:1: ( 'ubChar' )
            {
            // InternalMyDsl.g:8465:1: ( 'ubChar' )
            // InternalMyDsl.g:8466:2: 'ubChar'
            {
             before(grammarAccess.getExtractAccess().getUbCharKeyword_10()); 
            match(input,97,FOLLOW_2); 
             after(grammarAccess.getExtractAccess().getUbCharKeyword_10()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Extract__Group__10__Impl"


    // $ANTLR start "rule__Extract__Group__11"
    // InternalMyDsl.g:8475:1: rule__Extract__Group__11 : rule__Extract__Group__11__Impl rule__Extract__Group__12 ;
    public final void rule__Extract__Group__11() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:8479:1: ( rule__Extract__Group__11__Impl rule__Extract__Group__12 )
            // InternalMyDsl.g:8480:2: rule__Extract__Group__11__Impl rule__Extract__Group__12
            {
            pushFollow(FOLLOW_64);
            rule__Extract__Group__11__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Extract__Group__12();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Extract__Group__11"


    // $ANTLR start "rule__Extract__Group__11__Impl"
    // InternalMyDsl.g:8487:1: rule__Extract__Group__11__Impl : ( ( rule__Extract__UbCharAssignment_11 ) ) ;
    public final void rule__Extract__Group__11__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:8491:1: ( ( ( rule__Extract__UbCharAssignment_11 ) ) )
            // InternalMyDsl.g:8492:1: ( ( rule__Extract__UbCharAssignment_11 ) )
            {
            // InternalMyDsl.g:8492:1: ( ( rule__Extract__UbCharAssignment_11 ) )
            // InternalMyDsl.g:8493:2: ( rule__Extract__UbCharAssignment_11 )
            {
             before(grammarAccess.getExtractAccess().getUbCharAssignment_11()); 
            // InternalMyDsl.g:8494:2: ( rule__Extract__UbCharAssignment_11 )
            // InternalMyDsl.g:8494:3: rule__Extract__UbCharAssignment_11
            {
            pushFollow(FOLLOW_2);
            rule__Extract__UbCharAssignment_11();

            state._fsp--;


            }

             after(grammarAccess.getExtractAccess().getUbCharAssignment_11()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Extract__Group__11__Impl"


    // $ANTLR start "rule__Extract__Group__12"
    // InternalMyDsl.g:8502:1: rule__Extract__Group__12 : rule__Extract__Group__12__Impl rule__Extract__Group__13 ;
    public final void rule__Extract__Group__12() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:8506:1: ( rule__Extract__Group__12__Impl rule__Extract__Group__13 )
            // InternalMyDsl.g:8507:2: rule__Extract__Group__12__Impl rule__Extract__Group__13
            {
            pushFollow(FOLLOW_3);
            rule__Extract__Group__12__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Extract__Group__13();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Extract__Group__12"


    // $ANTLR start "rule__Extract__Group__12__Impl"
    // InternalMyDsl.g:8514:1: rule__Extract__Group__12__Impl : ( 'pattern' ) ;
    public final void rule__Extract__Group__12__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:8518:1: ( ( 'pattern' ) )
            // InternalMyDsl.g:8519:1: ( 'pattern' )
            {
            // InternalMyDsl.g:8519:1: ( 'pattern' )
            // InternalMyDsl.g:8520:2: 'pattern'
            {
             before(grammarAccess.getExtractAccess().getPatternKeyword_12()); 
            match(input,98,FOLLOW_2); 
             after(grammarAccess.getExtractAccess().getPatternKeyword_12()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Extract__Group__12__Impl"


    // $ANTLR start "rule__Extract__Group__13"
    // InternalMyDsl.g:8529:1: rule__Extract__Group__13 : rule__Extract__Group__13__Impl rule__Extract__Group__14 ;
    public final void rule__Extract__Group__13() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:8533:1: ( rule__Extract__Group__13__Impl rule__Extract__Group__14 )
            // InternalMyDsl.g:8534:2: rule__Extract__Group__13__Impl rule__Extract__Group__14
            {
            pushFollow(FOLLOW_29);
            rule__Extract__Group__13__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Extract__Group__14();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Extract__Group__13"


    // $ANTLR start "rule__Extract__Group__13__Impl"
    // InternalMyDsl.g:8541:1: rule__Extract__Group__13__Impl : ( ( rule__Extract__PatternAssignment_13 ) ) ;
    public final void rule__Extract__Group__13__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:8545:1: ( ( ( rule__Extract__PatternAssignment_13 ) ) )
            // InternalMyDsl.g:8546:1: ( ( rule__Extract__PatternAssignment_13 ) )
            {
            // InternalMyDsl.g:8546:1: ( ( rule__Extract__PatternAssignment_13 ) )
            // InternalMyDsl.g:8547:2: ( rule__Extract__PatternAssignment_13 )
            {
             before(grammarAccess.getExtractAccess().getPatternAssignment_13()); 
            // InternalMyDsl.g:8548:2: ( rule__Extract__PatternAssignment_13 )
            // InternalMyDsl.g:8548:3: rule__Extract__PatternAssignment_13
            {
            pushFollow(FOLLOW_2);
            rule__Extract__PatternAssignment_13();

            state._fsp--;


            }

             after(grammarAccess.getExtractAccess().getPatternAssignment_13()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Extract__Group__13__Impl"


    // $ANTLR start "rule__Extract__Group__14"
    // InternalMyDsl.g:8556:1: rule__Extract__Group__14 : rule__Extract__Group__14__Impl rule__Extract__Group__15 ;
    public final void rule__Extract__Group__14() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:8560:1: ( rule__Extract__Group__14__Impl rule__Extract__Group__15 )
            // InternalMyDsl.g:8561:2: rule__Extract__Group__14__Impl rule__Extract__Group__15
            {
            pushFollow(FOLLOW_3);
            rule__Extract__Group__14__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Extract__Group__15();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Extract__Group__14"


    // $ANTLR start "rule__Extract__Group__14__Impl"
    // InternalMyDsl.g:8568:1: rule__Extract__Group__14__Impl : ( 'next' ) ;
    public final void rule__Extract__Group__14__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:8572:1: ( ( 'next' ) )
            // InternalMyDsl.g:8573:1: ( 'next' )
            {
            // InternalMyDsl.g:8573:1: ( 'next' )
            // InternalMyDsl.g:8574:2: 'next'
            {
             before(grammarAccess.getExtractAccess().getNextKeyword_14()); 
            match(input,60,FOLLOW_2); 
             after(grammarAccess.getExtractAccess().getNextKeyword_14()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Extract__Group__14__Impl"


    // $ANTLR start "rule__Extract__Group__15"
    // InternalMyDsl.g:8583:1: rule__Extract__Group__15 : rule__Extract__Group__15__Impl rule__Extract__Group__16 ;
    public final void rule__Extract__Group__15() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:8587:1: ( rule__Extract__Group__15__Impl rule__Extract__Group__16 )
            // InternalMyDsl.g:8588:2: rule__Extract__Group__15__Impl rule__Extract__Group__16
            {
            pushFollow(FOLLOW_13);
            rule__Extract__Group__15__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Extract__Group__16();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Extract__Group__15"


    // $ANTLR start "rule__Extract__Group__15__Impl"
    // InternalMyDsl.g:8595:1: rule__Extract__Group__15__Impl : ( ( rule__Extract__NextAssignment_15 ) ) ;
    public final void rule__Extract__Group__15__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:8599:1: ( ( ( rule__Extract__NextAssignment_15 ) ) )
            // InternalMyDsl.g:8600:1: ( ( rule__Extract__NextAssignment_15 ) )
            {
            // InternalMyDsl.g:8600:1: ( ( rule__Extract__NextAssignment_15 ) )
            // InternalMyDsl.g:8601:2: ( rule__Extract__NextAssignment_15 )
            {
             before(grammarAccess.getExtractAccess().getNextAssignment_15()); 
            // InternalMyDsl.g:8602:2: ( rule__Extract__NextAssignment_15 )
            // InternalMyDsl.g:8602:3: rule__Extract__NextAssignment_15
            {
            pushFollow(FOLLOW_2);
            rule__Extract__NextAssignment_15();

            state._fsp--;


            }

             after(grammarAccess.getExtractAccess().getNextAssignment_15()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Extract__Group__15__Impl"


    // $ANTLR start "rule__Extract__Group__16"
    // InternalMyDsl.g:8610:1: rule__Extract__Group__16 : rule__Extract__Group__16__Impl ;
    public final void rule__Extract__Group__16() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:8614:1: ( rule__Extract__Group__16__Impl )
            // InternalMyDsl.g:8615:2: rule__Extract__Group__16__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Extract__Group__16__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Extract__Group__16"


    // $ANTLR start "rule__Extract__Group__16__Impl"
    // InternalMyDsl.g:8621:1: rule__Extract__Group__16__Impl : ( '}' ) ;
    public final void rule__Extract__Group__16__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:8625:1: ( ( '}' ) )
            // InternalMyDsl.g:8626:1: ( '}' )
            {
            // InternalMyDsl.g:8626:1: ( '}' )
            // InternalMyDsl.g:8627:2: '}'
            {
             before(grammarAccess.getExtractAccess().getRightCurlyBracketKeyword_16()); 
            match(input,41,FOLLOW_2); 
             after(grammarAccess.getExtractAccess().getRightCurlyBracketKeyword_16()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Extract__Group__16__Impl"


    // $ANTLR start "rule__Extract__Group_3__0"
    // InternalMyDsl.g:8637:1: rule__Extract__Group_3__0 : rule__Extract__Group_3__0__Impl rule__Extract__Group_3__1 ;
    public final void rule__Extract__Group_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:8641:1: ( rule__Extract__Group_3__0__Impl rule__Extract__Group_3__1 )
            // InternalMyDsl.g:8642:2: rule__Extract__Group_3__0__Impl rule__Extract__Group_3__1
            {
            pushFollow(FOLLOW_3);
            rule__Extract__Group_3__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Extract__Group_3__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Extract__Group_3__0"


    // $ANTLR start "rule__Extract__Group_3__0__Impl"
    // InternalMyDsl.g:8649:1: rule__Extract__Group_3__0__Impl : ( 'description' ) ;
    public final void rule__Extract__Group_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:8653:1: ( ( 'description' ) )
            // InternalMyDsl.g:8654:1: ( 'description' )
            {
            // InternalMyDsl.g:8654:1: ( 'description' )
            // InternalMyDsl.g:8655:2: 'description'
            {
             before(grammarAccess.getExtractAccess().getDescriptionKeyword_3_0()); 
            match(input,50,FOLLOW_2); 
             after(grammarAccess.getExtractAccess().getDescriptionKeyword_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Extract__Group_3__0__Impl"


    // $ANTLR start "rule__Extract__Group_3__1"
    // InternalMyDsl.g:8664:1: rule__Extract__Group_3__1 : rule__Extract__Group_3__1__Impl ;
    public final void rule__Extract__Group_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:8668:1: ( rule__Extract__Group_3__1__Impl )
            // InternalMyDsl.g:8669:2: rule__Extract__Group_3__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Extract__Group_3__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Extract__Group_3__1"


    // $ANTLR start "rule__Extract__Group_3__1__Impl"
    // InternalMyDsl.g:8675:1: rule__Extract__Group_3__1__Impl : ( ( rule__Extract__DescriptionAssignment_3_1 ) ) ;
    public final void rule__Extract__Group_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:8679:1: ( ( ( rule__Extract__DescriptionAssignment_3_1 ) ) )
            // InternalMyDsl.g:8680:1: ( ( rule__Extract__DescriptionAssignment_3_1 ) )
            {
            // InternalMyDsl.g:8680:1: ( ( rule__Extract__DescriptionAssignment_3_1 ) )
            // InternalMyDsl.g:8681:2: ( rule__Extract__DescriptionAssignment_3_1 )
            {
             before(grammarAccess.getExtractAccess().getDescriptionAssignment_3_1()); 
            // InternalMyDsl.g:8682:2: ( rule__Extract__DescriptionAssignment_3_1 )
            // InternalMyDsl.g:8682:3: rule__Extract__DescriptionAssignment_3_1
            {
            pushFollow(FOLLOW_2);
            rule__Extract__DescriptionAssignment_3_1();

            state._fsp--;


            }

             after(grammarAccess.getExtractAccess().getDescriptionAssignment_3_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Extract__Group_3__1__Impl"


    // $ANTLR start "rule__TableToSave__Group__0"
    // InternalMyDsl.g:8691:1: rule__TableToSave__Group__0 : rule__TableToSave__Group__0__Impl rule__TableToSave__Group__1 ;
    public final void rule__TableToSave__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:8695:1: ( rule__TableToSave__Group__0__Impl rule__TableToSave__Group__1 )
            // InternalMyDsl.g:8696:2: rule__TableToSave__Group__0__Impl rule__TableToSave__Group__1
            {
            pushFollow(FOLLOW_4);
            rule__TableToSave__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__TableToSave__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TableToSave__Group__0"


    // $ANTLR start "rule__TableToSave__Group__0__Impl"
    // InternalMyDsl.g:8703:1: rule__TableToSave__Group__0__Impl : ( 'TableToSave' ) ;
    public final void rule__TableToSave__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:8707:1: ( ( 'TableToSave' ) )
            // InternalMyDsl.g:8708:1: ( 'TableToSave' )
            {
            // InternalMyDsl.g:8708:1: ( 'TableToSave' )
            // InternalMyDsl.g:8709:2: 'TableToSave'
            {
             before(grammarAccess.getTableToSaveAccess().getTableToSaveKeyword_0()); 
            match(input,99,FOLLOW_2); 
             after(grammarAccess.getTableToSaveAccess().getTableToSaveKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TableToSave__Group__0__Impl"


    // $ANTLR start "rule__TableToSave__Group__1"
    // InternalMyDsl.g:8718:1: rule__TableToSave__Group__1 : rule__TableToSave__Group__1__Impl rule__TableToSave__Group__2 ;
    public final void rule__TableToSave__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:8722:1: ( rule__TableToSave__Group__1__Impl rule__TableToSave__Group__2 )
            // InternalMyDsl.g:8723:2: rule__TableToSave__Group__1__Impl rule__TableToSave__Group__2
            {
            pushFollow(FOLLOW_65);
            rule__TableToSave__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__TableToSave__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TableToSave__Group__1"


    // $ANTLR start "rule__TableToSave__Group__1__Impl"
    // InternalMyDsl.g:8730:1: rule__TableToSave__Group__1__Impl : ( '{' ) ;
    public final void rule__TableToSave__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:8734:1: ( ( '{' ) )
            // InternalMyDsl.g:8735:1: ( '{' )
            {
            // InternalMyDsl.g:8735:1: ( '{' )
            // InternalMyDsl.g:8736:2: '{'
            {
             before(grammarAccess.getTableToSaveAccess().getLeftCurlyBracketKeyword_1()); 
            match(input,38,FOLLOW_2); 
             after(grammarAccess.getTableToSaveAccess().getLeftCurlyBracketKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TableToSave__Group__1__Impl"


    // $ANTLR start "rule__TableToSave__Group__2"
    // InternalMyDsl.g:8745:1: rule__TableToSave__Group__2 : rule__TableToSave__Group__2__Impl rule__TableToSave__Group__3 ;
    public final void rule__TableToSave__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:8749:1: ( rule__TableToSave__Group__2__Impl rule__TableToSave__Group__3 )
            // InternalMyDsl.g:8750:2: rule__TableToSave__Group__2__Impl rule__TableToSave__Group__3
            {
            pushFollow(FOLLOW_3);
            rule__TableToSave__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__TableToSave__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TableToSave__Group__2"


    // $ANTLR start "rule__TableToSave__Group__2__Impl"
    // InternalMyDsl.g:8757:1: rule__TableToSave__Group__2__Impl : ( 'path' ) ;
    public final void rule__TableToSave__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:8761:1: ( ( 'path' ) )
            // InternalMyDsl.g:8762:1: ( 'path' )
            {
            // InternalMyDsl.g:8762:1: ( 'path' )
            // InternalMyDsl.g:8763:2: 'path'
            {
             before(grammarAccess.getTableToSaveAccess().getPathKeyword_2()); 
            match(input,100,FOLLOW_2); 
             after(grammarAccess.getTableToSaveAccess().getPathKeyword_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TableToSave__Group__2__Impl"


    // $ANTLR start "rule__TableToSave__Group__3"
    // InternalMyDsl.g:8772:1: rule__TableToSave__Group__3 : rule__TableToSave__Group__3__Impl rule__TableToSave__Group__4 ;
    public final void rule__TableToSave__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:8776:1: ( rule__TableToSave__Group__3__Impl rule__TableToSave__Group__4 )
            // InternalMyDsl.g:8777:2: rule__TableToSave__Group__3__Impl rule__TableToSave__Group__4
            {
            pushFollow(FOLLOW_66);
            rule__TableToSave__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__TableToSave__Group__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TableToSave__Group__3"


    // $ANTLR start "rule__TableToSave__Group__3__Impl"
    // InternalMyDsl.g:8784:1: rule__TableToSave__Group__3__Impl : ( ( rule__TableToSave__PathAssignment_3 ) ) ;
    public final void rule__TableToSave__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:8788:1: ( ( ( rule__TableToSave__PathAssignment_3 ) ) )
            // InternalMyDsl.g:8789:1: ( ( rule__TableToSave__PathAssignment_3 ) )
            {
            // InternalMyDsl.g:8789:1: ( ( rule__TableToSave__PathAssignment_3 ) )
            // InternalMyDsl.g:8790:2: ( rule__TableToSave__PathAssignment_3 )
            {
             before(grammarAccess.getTableToSaveAccess().getPathAssignment_3()); 
            // InternalMyDsl.g:8791:2: ( rule__TableToSave__PathAssignment_3 )
            // InternalMyDsl.g:8791:3: rule__TableToSave__PathAssignment_3
            {
            pushFollow(FOLLOW_2);
            rule__TableToSave__PathAssignment_3();

            state._fsp--;


            }

             after(grammarAccess.getTableToSaveAccess().getPathAssignment_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TableToSave__Group__3__Impl"


    // $ANTLR start "rule__TableToSave__Group__4"
    // InternalMyDsl.g:8799:1: rule__TableToSave__Group__4 : rule__TableToSave__Group__4__Impl rule__TableToSave__Group__5 ;
    public final void rule__TableToSave__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:8803:1: ( rule__TableToSave__Group__4__Impl rule__TableToSave__Group__5 )
            // InternalMyDsl.g:8804:2: rule__TableToSave__Group__4__Impl rule__TableToSave__Group__5
            {
            pushFollow(FOLLOW_3);
            rule__TableToSave__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__TableToSave__Group__5();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TableToSave__Group__4"


    // $ANTLR start "rule__TableToSave__Group__4__Impl"
    // InternalMyDsl.g:8811:1: rule__TableToSave__Group__4__Impl : ( 'table' ) ;
    public final void rule__TableToSave__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:8815:1: ( ( 'table' ) )
            // InternalMyDsl.g:8816:1: ( 'table' )
            {
            // InternalMyDsl.g:8816:1: ( 'table' )
            // InternalMyDsl.g:8817:2: 'table'
            {
             before(grammarAccess.getTableToSaveAccess().getTableKeyword_4()); 
            match(input,52,FOLLOW_2); 
             after(grammarAccess.getTableToSaveAccess().getTableKeyword_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TableToSave__Group__4__Impl"


    // $ANTLR start "rule__TableToSave__Group__5"
    // InternalMyDsl.g:8826:1: rule__TableToSave__Group__5 : rule__TableToSave__Group__5__Impl rule__TableToSave__Group__6 ;
    public final void rule__TableToSave__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:8830:1: ( rule__TableToSave__Group__5__Impl rule__TableToSave__Group__6 )
            // InternalMyDsl.g:8831:2: rule__TableToSave__Group__5__Impl rule__TableToSave__Group__6
            {
            pushFollow(FOLLOW_67);
            rule__TableToSave__Group__5__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__TableToSave__Group__6();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TableToSave__Group__5"


    // $ANTLR start "rule__TableToSave__Group__5__Impl"
    // InternalMyDsl.g:8838:1: rule__TableToSave__Group__5__Impl : ( ( rule__TableToSave__TableAssignment_5 ) ) ;
    public final void rule__TableToSave__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:8842:1: ( ( ( rule__TableToSave__TableAssignment_5 ) ) )
            // InternalMyDsl.g:8843:1: ( ( rule__TableToSave__TableAssignment_5 ) )
            {
            // InternalMyDsl.g:8843:1: ( ( rule__TableToSave__TableAssignment_5 ) )
            // InternalMyDsl.g:8844:2: ( rule__TableToSave__TableAssignment_5 )
            {
             before(grammarAccess.getTableToSaveAccess().getTableAssignment_5()); 
            // InternalMyDsl.g:8845:2: ( rule__TableToSave__TableAssignment_5 )
            // InternalMyDsl.g:8845:3: rule__TableToSave__TableAssignment_5
            {
            pushFollow(FOLLOW_2);
            rule__TableToSave__TableAssignment_5();

            state._fsp--;


            }

             after(grammarAccess.getTableToSaveAccess().getTableAssignment_5()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TableToSave__Group__5__Impl"


    // $ANTLR start "rule__TableToSave__Group__6"
    // InternalMyDsl.g:8853:1: rule__TableToSave__Group__6 : rule__TableToSave__Group__6__Impl rule__TableToSave__Group__7 ;
    public final void rule__TableToSave__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:8857:1: ( rule__TableToSave__Group__6__Impl rule__TableToSave__Group__7 )
            // InternalMyDsl.g:8858:2: rule__TableToSave__Group__6__Impl rule__TableToSave__Group__7
            {
            pushFollow(FOLLOW_4);
            rule__TableToSave__Group__6__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__TableToSave__Group__7();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TableToSave__Group__6"


    // $ANTLR start "rule__TableToSave__Group__6__Impl"
    // InternalMyDsl.g:8865:1: rule__TableToSave__Group__6__Impl : ( 'columnsNames' ) ;
    public final void rule__TableToSave__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:8869:1: ( ( 'columnsNames' ) )
            // InternalMyDsl.g:8870:1: ( 'columnsNames' )
            {
            // InternalMyDsl.g:8870:1: ( 'columnsNames' )
            // InternalMyDsl.g:8871:2: 'columnsNames'
            {
             before(grammarAccess.getTableToSaveAccess().getColumnsNamesKeyword_6()); 
            match(input,101,FOLLOW_2); 
             after(grammarAccess.getTableToSaveAccess().getColumnsNamesKeyword_6()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TableToSave__Group__6__Impl"


    // $ANTLR start "rule__TableToSave__Group__7"
    // InternalMyDsl.g:8880:1: rule__TableToSave__Group__7 : rule__TableToSave__Group__7__Impl rule__TableToSave__Group__8 ;
    public final void rule__TableToSave__Group__7() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:8884:1: ( rule__TableToSave__Group__7__Impl rule__TableToSave__Group__8 )
            // InternalMyDsl.g:8885:2: rule__TableToSave__Group__7__Impl rule__TableToSave__Group__8
            {
            pushFollow(FOLLOW_3);
            rule__TableToSave__Group__7__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__TableToSave__Group__8();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TableToSave__Group__7"


    // $ANTLR start "rule__TableToSave__Group__7__Impl"
    // InternalMyDsl.g:8892:1: rule__TableToSave__Group__7__Impl : ( '{' ) ;
    public final void rule__TableToSave__Group__7__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:8896:1: ( ( '{' ) )
            // InternalMyDsl.g:8897:1: ( '{' )
            {
            // InternalMyDsl.g:8897:1: ( '{' )
            // InternalMyDsl.g:8898:2: '{'
            {
             before(grammarAccess.getTableToSaveAccess().getLeftCurlyBracketKeyword_7()); 
            match(input,38,FOLLOW_2); 
             after(grammarAccess.getTableToSaveAccess().getLeftCurlyBracketKeyword_7()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TableToSave__Group__7__Impl"


    // $ANTLR start "rule__TableToSave__Group__8"
    // InternalMyDsl.g:8907:1: rule__TableToSave__Group__8 : rule__TableToSave__Group__8__Impl rule__TableToSave__Group__9 ;
    public final void rule__TableToSave__Group__8() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:8911:1: ( rule__TableToSave__Group__8__Impl rule__TableToSave__Group__9 )
            // InternalMyDsl.g:8912:2: rule__TableToSave__Group__8__Impl rule__TableToSave__Group__9
            {
            pushFollow(FOLLOW_9);
            rule__TableToSave__Group__8__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__TableToSave__Group__9();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TableToSave__Group__8"


    // $ANTLR start "rule__TableToSave__Group__8__Impl"
    // InternalMyDsl.g:8919:1: rule__TableToSave__Group__8__Impl : ( ( rule__TableToSave__ColumnsNamesAssignment_8 ) ) ;
    public final void rule__TableToSave__Group__8__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:8923:1: ( ( ( rule__TableToSave__ColumnsNamesAssignment_8 ) ) )
            // InternalMyDsl.g:8924:1: ( ( rule__TableToSave__ColumnsNamesAssignment_8 ) )
            {
            // InternalMyDsl.g:8924:1: ( ( rule__TableToSave__ColumnsNamesAssignment_8 ) )
            // InternalMyDsl.g:8925:2: ( rule__TableToSave__ColumnsNamesAssignment_8 )
            {
             before(grammarAccess.getTableToSaveAccess().getColumnsNamesAssignment_8()); 
            // InternalMyDsl.g:8926:2: ( rule__TableToSave__ColumnsNamesAssignment_8 )
            // InternalMyDsl.g:8926:3: rule__TableToSave__ColumnsNamesAssignment_8
            {
            pushFollow(FOLLOW_2);
            rule__TableToSave__ColumnsNamesAssignment_8();

            state._fsp--;


            }

             after(grammarAccess.getTableToSaveAccess().getColumnsNamesAssignment_8()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TableToSave__Group__8__Impl"


    // $ANTLR start "rule__TableToSave__Group__9"
    // InternalMyDsl.g:8934:1: rule__TableToSave__Group__9 : rule__TableToSave__Group__9__Impl rule__TableToSave__Group__10 ;
    public final void rule__TableToSave__Group__9() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:8938:1: ( rule__TableToSave__Group__9__Impl rule__TableToSave__Group__10 )
            // InternalMyDsl.g:8939:2: rule__TableToSave__Group__9__Impl rule__TableToSave__Group__10
            {
            pushFollow(FOLLOW_9);
            rule__TableToSave__Group__9__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__TableToSave__Group__10();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TableToSave__Group__9"


    // $ANTLR start "rule__TableToSave__Group__9__Impl"
    // InternalMyDsl.g:8946:1: rule__TableToSave__Group__9__Impl : ( ( rule__TableToSave__Group_9__0 )* ) ;
    public final void rule__TableToSave__Group__9__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:8950:1: ( ( ( rule__TableToSave__Group_9__0 )* ) )
            // InternalMyDsl.g:8951:1: ( ( rule__TableToSave__Group_9__0 )* )
            {
            // InternalMyDsl.g:8951:1: ( ( rule__TableToSave__Group_9__0 )* )
            // InternalMyDsl.g:8952:2: ( rule__TableToSave__Group_9__0 )*
            {
             before(grammarAccess.getTableToSaveAccess().getGroup_9()); 
            // InternalMyDsl.g:8953:2: ( rule__TableToSave__Group_9__0 )*
            loop31:
            do {
                int alt31=2;
                int LA31_0 = input.LA(1);

                if ( (LA31_0==43) ) {
                    alt31=1;
                }


                switch (alt31) {
            	case 1 :
            	    // InternalMyDsl.g:8953:3: rule__TableToSave__Group_9__0
            	    {
            	    pushFollow(FOLLOW_10);
            	    rule__TableToSave__Group_9__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop31;
                }
            } while (true);

             after(grammarAccess.getTableToSaveAccess().getGroup_9()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TableToSave__Group__9__Impl"


    // $ANTLR start "rule__TableToSave__Group__10"
    // InternalMyDsl.g:8961:1: rule__TableToSave__Group__10 : rule__TableToSave__Group__10__Impl rule__TableToSave__Group__11 ;
    public final void rule__TableToSave__Group__10() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:8965:1: ( rule__TableToSave__Group__10__Impl rule__TableToSave__Group__11 )
            // InternalMyDsl.g:8966:2: rule__TableToSave__Group__10__Impl rule__TableToSave__Group__11
            {
            pushFollow(FOLLOW_13);
            rule__TableToSave__Group__10__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__TableToSave__Group__11();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TableToSave__Group__10"


    // $ANTLR start "rule__TableToSave__Group__10__Impl"
    // InternalMyDsl.g:8973:1: rule__TableToSave__Group__10__Impl : ( '}' ) ;
    public final void rule__TableToSave__Group__10__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:8977:1: ( ( '}' ) )
            // InternalMyDsl.g:8978:1: ( '}' )
            {
            // InternalMyDsl.g:8978:1: ( '}' )
            // InternalMyDsl.g:8979:2: '}'
            {
             before(grammarAccess.getTableToSaveAccess().getRightCurlyBracketKeyword_10()); 
            match(input,41,FOLLOW_2); 
             after(grammarAccess.getTableToSaveAccess().getRightCurlyBracketKeyword_10()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TableToSave__Group__10__Impl"


    // $ANTLR start "rule__TableToSave__Group__11"
    // InternalMyDsl.g:8988:1: rule__TableToSave__Group__11 : rule__TableToSave__Group__11__Impl ;
    public final void rule__TableToSave__Group__11() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:8992:1: ( rule__TableToSave__Group__11__Impl )
            // InternalMyDsl.g:8993:2: rule__TableToSave__Group__11__Impl
            {
            pushFollow(FOLLOW_2);
            rule__TableToSave__Group__11__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TableToSave__Group__11"


    // $ANTLR start "rule__TableToSave__Group__11__Impl"
    // InternalMyDsl.g:8999:1: rule__TableToSave__Group__11__Impl : ( '}' ) ;
    public final void rule__TableToSave__Group__11__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:9003:1: ( ( '}' ) )
            // InternalMyDsl.g:9004:1: ( '}' )
            {
            // InternalMyDsl.g:9004:1: ( '}' )
            // InternalMyDsl.g:9005:2: '}'
            {
             before(grammarAccess.getTableToSaveAccess().getRightCurlyBracketKeyword_11()); 
            match(input,41,FOLLOW_2); 
             after(grammarAccess.getTableToSaveAccess().getRightCurlyBracketKeyword_11()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TableToSave__Group__11__Impl"


    // $ANTLR start "rule__TableToSave__Group_9__0"
    // InternalMyDsl.g:9015:1: rule__TableToSave__Group_9__0 : rule__TableToSave__Group_9__0__Impl rule__TableToSave__Group_9__1 ;
    public final void rule__TableToSave__Group_9__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:9019:1: ( rule__TableToSave__Group_9__0__Impl rule__TableToSave__Group_9__1 )
            // InternalMyDsl.g:9020:2: rule__TableToSave__Group_9__0__Impl rule__TableToSave__Group_9__1
            {
            pushFollow(FOLLOW_3);
            rule__TableToSave__Group_9__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__TableToSave__Group_9__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TableToSave__Group_9__0"


    // $ANTLR start "rule__TableToSave__Group_9__0__Impl"
    // InternalMyDsl.g:9027:1: rule__TableToSave__Group_9__0__Impl : ( ',' ) ;
    public final void rule__TableToSave__Group_9__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:9031:1: ( ( ',' ) )
            // InternalMyDsl.g:9032:1: ( ',' )
            {
            // InternalMyDsl.g:9032:1: ( ',' )
            // InternalMyDsl.g:9033:2: ','
            {
             before(grammarAccess.getTableToSaveAccess().getCommaKeyword_9_0()); 
            match(input,43,FOLLOW_2); 
             after(grammarAccess.getTableToSaveAccess().getCommaKeyword_9_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TableToSave__Group_9__0__Impl"


    // $ANTLR start "rule__TableToSave__Group_9__1"
    // InternalMyDsl.g:9042:1: rule__TableToSave__Group_9__1 : rule__TableToSave__Group_9__1__Impl ;
    public final void rule__TableToSave__Group_9__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:9046:1: ( rule__TableToSave__Group_9__1__Impl )
            // InternalMyDsl.g:9047:2: rule__TableToSave__Group_9__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__TableToSave__Group_9__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TableToSave__Group_9__1"


    // $ANTLR start "rule__TableToSave__Group_9__1__Impl"
    // InternalMyDsl.g:9053:1: rule__TableToSave__Group_9__1__Impl : ( ( rule__TableToSave__ColumnsNamesAssignment_9_1 ) ) ;
    public final void rule__TableToSave__Group_9__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:9057:1: ( ( ( rule__TableToSave__ColumnsNamesAssignment_9_1 ) ) )
            // InternalMyDsl.g:9058:1: ( ( rule__TableToSave__ColumnsNamesAssignment_9_1 ) )
            {
            // InternalMyDsl.g:9058:1: ( ( rule__TableToSave__ColumnsNamesAssignment_9_1 ) )
            // InternalMyDsl.g:9059:2: ( rule__TableToSave__ColumnsNamesAssignment_9_1 )
            {
             before(grammarAccess.getTableToSaveAccess().getColumnsNamesAssignment_9_1()); 
            // InternalMyDsl.g:9060:2: ( rule__TableToSave__ColumnsNamesAssignment_9_1 )
            // InternalMyDsl.g:9060:3: rule__TableToSave__ColumnsNamesAssignment_9_1
            {
            pushFollow(FOLLOW_2);
            rule__TableToSave__ColumnsNamesAssignment_9_1();

            state._fsp--;


            }

             after(grammarAccess.getTableToSaveAccess().getColumnsNamesAssignment_9_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TableToSave__Group_9__1__Impl"


    // $ANTLR start "rule__Association__Group__0"
    // InternalMyDsl.g:9069:1: rule__Association__Group__0 : rule__Association__Group__0__Impl rule__Association__Group__1 ;
    public final void rule__Association__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:9073:1: ( rule__Association__Group__0__Impl rule__Association__Group__1 )
            // InternalMyDsl.g:9074:2: rule__Association__Group__0__Impl rule__Association__Group__1
            {
            pushFollow(FOLLOW_4);
            rule__Association__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Association__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Association__Group__0"


    // $ANTLR start "rule__Association__Group__0__Impl"
    // InternalMyDsl.g:9081:1: rule__Association__Group__0__Impl : ( 'Association' ) ;
    public final void rule__Association__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:9085:1: ( ( 'Association' ) )
            // InternalMyDsl.g:9086:1: ( 'Association' )
            {
            // InternalMyDsl.g:9086:1: ( 'Association' )
            // InternalMyDsl.g:9087:2: 'Association'
            {
             before(grammarAccess.getAssociationAccess().getAssociationKeyword_0()); 
            match(input,102,FOLLOW_2); 
             after(grammarAccess.getAssociationAccess().getAssociationKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Association__Group__0__Impl"


    // $ANTLR start "rule__Association__Group__1"
    // InternalMyDsl.g:9096:1: rule__Association__Group__1 : rule__Association__Group__1__Impl rule__Association__Group__2 ;
    public final void rule__Association__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:9100:1: ( rule__Association__Group__1__Impl rule__Association__Group__2 )
            // InternalMyDsl.g:9101:2: rule__Association__Group__1__Impl rule__Association__Group__2
            {
            pushFollow(FOLLOW_68);
            rule__Association__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Association__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Association__Group__1"


    // $ANTLR start "rule__Association__Group__1__Impl"
    // InternalMyDsl.g:9108:1: rule__Association__Group__1__Impl : ( '{' ) ;
    public final void rule__Association__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:9112:1: ( ( '{' ) )
            // InternalMyDsl.g:9113:1: ( '{' )
            {
            // InternalMyDsl.g:9113:1: ( '{' )
            // InternalMyDsl.g:9114:2: '{'
            {
             before(grammarAccess.getAssociationAccess().getLeftCurlyBracketKeyword_1()); 
            match(input,38,FOLLOW_2); 
             after(grammarAccess.getAssociationAccess().getLeftCurlyBracketKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Association__Group__1__Impl"


    // $ANTLR start "rule__Association__Group__2"
    // InternalMyDsl.g:9123:1: rule__Association__Group__2 : rule__Association__Group__2__Impl rule__Association__Group__3 ;
    public final void rule__Association__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:9127:1: ( rule__Association__Group__2__Impl rule__Association__Group__3 )
            // InternalMyDsl.g:9128:2: rule__Association__Group__2__Impl rule__Association__Group__3
            {
            pushFollow(FOLLOW_3);
            rule__Association__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Association__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Association__Group__2"


    // $ANTLR start "rule__Association__Group__2__Impl"
    // InternalMyDsl.g:9135:1: rule__Association__Group__2__Impl : ( 'originCol' ) ;
    public final void rule__Association__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:9139:1: ( ( 'originCol' ) )
            // InternalMyDsl.g:9140:1: ( 'originCol' )
            {
            // InternalMyDsl.g:9140:1: ( 'originCol' )
            // InternalMyDsl.g:9141:2: 'originCol'
            {
             before(grammarAccess.getAssociationAccess().getOriginColKeyword_2()); 
            match(input,103,FOLLOW_2); 
             after(grammarAccess.getAssociationAccess().getOriginColKeyword_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Association__Group__2__Impl"


    // $ANTLR start "rule__Association__Group__3"
    // InternalMyDsl.g:9150:1: rule__Association__Group__3 : rule__Association__Group__3__Impl rule__Association__Group__4 ;
    public final void rule__Association__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:9154:1: ( rule__Association__Group__3__Impl rule__Association__Group__4 )
            // InternalMyDsl.g:9155:2: rule__Association__Group__3__Impl rule__Association__Group__4
            {
            pushFollow(FOLLOW_69);
            rule__Association__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Association__Group__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Association__Group__3"


    // $ANTLR start "rule__Association__Group__3__Impl"
    // InternalMyDsl.g:9162:1: rule__Association__Group__3__Impl : ( ( rule__Association__OriginColAssignment_3 ) ) ;
    public final void rule__Association__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:9166:1: ( ( ( rule__Association__OriginColAssignment_3 ) ) )
            // InternalMyDsl.g:9167:1: ( ( rule__Association__OriginColAssignment_3 ) )
            {
            // InternalMyDsl.g:9167:1: ( ( rule__Association__OriginColAssignment_3 ) )
            // InternalMyDsl.g:9168:2: ( rule__Association__OriginColAssignment_3 )
            {
             before(grammarAccess.getAssociationAccess().getOriginColAssignment_3()); 
            // InternalMyDsl.g:9169:2: ( rule__Association__OriginColAssignment_3 )
            // InternalMyDsl.g:9169:3: rule__Association__OriginColAssignment_3
            {
            pushFollow(FOLLOW_2);
            rule__Association__OriginColAssignment_3();

            state._fsp--;


            }

             after(grammarAccess.getAssociationAccess().getOriginColAssignment_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Association__Group__3__Impl"


    // $ANTLR start "rule__Association__Group__4"
    // InternalMyDsl.g:9177:1: rule__Association__Group__4 : rule__Association__Group__4__Impl rule__Association__Group__5 ;
    public final void rule__Association__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:9181:1: ( rule__Association__Group__4__Impl rule__Association__Group__5 )
            // InternalMyDsl.g:9182:2: rule__Association__Group__4__Impl rule__Association__Group__5
            {
            pushFollow(FOLLOW_3);
            rule__Association__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Association__Group__5();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Association__Group__4"


    // $ANTLR start "rule__Association__Group__4__Impl"
    // InternalMyDsl.g:9189:1: rule__Association__Group__4__Impl : ( 'destinCol' ) ;
    public final void rule__Association__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:9193:1: ( ( 'destinCol' ) )
            // InternalMyDsl.g:9194:1: ( 'destinCol' )
            {
            // InternalMyDsl.g:9194:1: ( 'destinCol' )
            // InternalMyDsl.g:9195:2: 'destinCol'
            {
             before(grammarAccess.getAssociationAccess().getDestinColKeyword_4()); 
            match(input,104,FOLLOW_2); 
             after(grammarAccess.getAssociationAccess().getDestinColKeyword_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Association__Group__4__Impl"


    // $ANTLR start "rule__Association__Group__5"
    // InternalMyDsl.g:9204:1: rule__Association__Group__5 : rule__Association__Group__5__Impl rule__Association__Group__6 ;
    public final void rule__Association__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:9208:1: ( rule__Association__Group__5__Impl rule__Association__Group__6 )
            // InternalMyDsl.g:9209:2: rule__Association__Group__5__Impl rule__Association__Group__6
            {
            pushFollow(FOLLOW_13);
            rule__Association__Group__5__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Association__Group__6();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Association__Group__5"


    // $ANTLR start "rule__Association__Group__5__Impl"
    // InternalMyDsl.g:9216:1: rule__Association__Group__5__Impl : ( ( rule__Association__DestinColAssignment_5 ) ) ;
    public final void rule__Association__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:9220:1: ( ( ( rule__Association__DestinColAssignment_5 ) ) )
            // InternalMyDsl.g:9221:1: ( ( rule__Association__DestinColAssignment_5 ) )
            {
            // InternalMyDsl.g:9221:1: ( ( rule__Association__DestinColAssignment_5 ) )
            // InternalMyDsl.g:9222:2: ( rule__Association__DestinColAssignment_5 )
            {
             before(grammarAccess.getAssociationAccess().getDestinColAssignment_5()); 
            // InternalMyDsl.g:9223:2: ( rule__Association__DestinColAssignment_5 )
            // InternalMyDsl.g:9223:3: rule__Association__DestinColAssignment_5
            {
            pushFollow(FOLLOW_2);
            rule__Association__DestinColAssignment_5();

            state._fsp--;


            }

             after(grammarAccess.getAssociationAccess().getDestinColAssignment_5()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Association__Group__5__Impl"


    // $ANTLR start "rule__Association__Group__6"
    // InternalMyDsl.g:9231:1: rule__Association__Group__6 : rule__Association__Group__6__Impl ;
    public final void rule__Association__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:9235:1: ( rule__Association__Group__6__Impl )
            // InternalMyDsl.g:9236:2: rule__Association__Group__6__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Association__Group__6__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Association__Group__6"


    // $ANTLR start "rule__Association__Group__6__Impl"
    // InternalMyDsl.g:9242:1: rule__Association__Group__6__Impl : ( '}' ) ;
    public final void rule__Association__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:9246:1: ( ( '}' ) )
            // InternalMyDsl.g:9247:1: ( '}' )
            {
            // InternalMyDsl.g:9247:1: ( '}' )
            // InternalMyDsl.g:9248:2: '}'
            {
             before(grammarAccess.getAssociationAccess().getRightCurlyBracketKeyword_6()); 
            match(input,41,FOLLOW_2); 
             after(grammarAccess.getAssociationAccess().getRightCurlyBracketKeyword_6()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Association__Group__6__Impl"


    // $ANTLR start "rule__TableToImport__Group__0"
    // InternalMyDsl.g:9258:1: rule__TableToImport__Group__0 : rule__TableToImport__Group__0__Impl rule__TableToImport__Group__1 ;
    public final void rule__TableToImport__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:9262:1: ( rule__TableToImport__Group__0__Impl rule__TableToImport__Group__1 )
            // InternalMyDsl.g:9263:2: rule__TableToImport__Group__0__Impl rule__TableToImport__Group__1
            {
            pushFollow(FOLLOW_6);
            rule__TableToImport__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__TableToImport__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TableToImport__Group__0"


    // $ANTLR start "rule__TableToImport__Group__0__Impl"
    // InternalMyDsl.g:9270:1: rule__TableToImport__Group__0__Impl : ( 'deleteMismatchedTypes' ) ;
    public final void rule__TableToImport__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:9274:1: ( ( 'deleteMismatchedTypes' ) )
            // InternalMyDsl.g:9275:1: ( 'deleteMismatchedTypes' )
            {
            // InternalMyDsl.g:9275:1: ( 'deleteMismatchedTypes' )
            // InternalMyDsl.g:9276:2: 'deleteMismatchedTypes'
            {
             before(grammarAccess.getTableToImportAccess().getDeleteMismatchedTypesKeyword_0()); 
            match(input,105,FOLLOW_2); 
             after(grammarAccess.getTableToImportAccess().getDeleteMismatchedTypesKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TableToImport__Group__0__Impl"


    // $ANTLR start "rule__TableToImport__Group__1"
    // InternalMyDsl.g:9285:1: rule__TableToImport__Group__1 : rule__TableToImport__Group__1__Impl rule__TableToImport__Group__2 ;
    public final void rule__TableToImport__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:9289:1: ( rule__TableToImport__Group__1__Impl rule__TableToImport__Group__2 )
            // InternalMyDsl.g:9290:2: rule__TableToImport__Group__1__Impl rule__TableToImport__Group__2
            {
            pushFollow(FOLLOW_70);
            rule__TableToImport__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__TableToImport__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TableToImport__Group__1"


    // $ANTLR start "rule__TableToImport__Group__1__Impl"
    // InternalMyDsl.g:9297:1: rule__TableToImport__Group__1__Impl : ( ( rule__TableToImport__DeleteMismatchedTypesAssignment_1 ) ) ;
    public final void rule__TableToImport__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:9301:1: ( ( ( rule__TableToImport__DeleteMismatchedTypesAssignment_1 ) ) )
            // InternalMyDsl.g:9302:1: ( ( rule__TableToImport__DeleteMismatchedTypesAssignment_1 ) )
            {
            // InternalMyDsl.g:9302:1: ( ( rule__TableToImport__DeleteMismatchedTypesAssignment_1 ) )
            // InternalMyDsl.g:9303:2: ( rule__TableToImport__DeleteMismatchedTypesAssignment_1 )
            {
             before(grammarAccess.getTableToImportAccess().getDeleteMismatchedTypesAssignment_1()); 
            // InternalMyDsl.g:9304:2: ( rule__TableToImport__DeleteMismatchedTypesAssignment_1 )
            // InternalMyDsl.g:9304:3: rule__TableToImport__DeleteMismatchedTypesAssignment_1
            {
            pushFollow(FOLLOW_2);
            rule__TableToImport__DeleteMismatchedTypesAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getTableToImportAccess().getDeleteMismatchedTypesAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TableToImport__Group__1__Impl"


    // $ANTLR start "rule__TableToImport__Group__2"
    // InternalMyDsl.g:9312:1: rule__TableToImport__Group__2 : rule__TableToImport__Group__2__Impl rule__TableToImport__Group__3 ;
    public final void rule__TableToImport__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:9316:1: ( rule__TableToImport__Group__2__Impl rule__TableToImport__Group__3 )
            // InternalMyDsl.g:9317:2: rule__TableToImport__Group__2__Impl rule__TableToImport__Group__3
            {
            pushFollow(FOLLOW_4);
            rule__TableToImport__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__TableToImport__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TableToImport__Group__2"


    // $ANTLR start "rule__TableToImport__Group__2__Impl"
    // InternalMyDsl.g:9324:1: rule__TableToImport__Group__2__Impl : ( 'TableToImport' ) ;
    public final void rule__TableToImport__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:9328:1: ( ( 'TableToImport' ) )
            // InternalMyDsl.g:9329:1: ( 'TableToImport' )
            {
            // InternalMyDsl.g:9329:1: ( 'TableToImport' )
            // InternalMyDsl.g:9330:2: 'TableToImport'
            {
             before(grammarAccess.getTableToImportAccess().getTableToImportKeyword_2()); 
            match(input,106,FOLLOW_2); 
             after(grammarAccess.getTableToImportAccess().getTableToImportKeyword_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TableToImport__Group__2__Impl"


    // $ANTLR start "rule__TableToImport__Group__3"
    // InternalMyDsl.g:9339:1: rule__TableToImport__Group__3 : rule__TableToImport__Group__3__Impl rule__TableToImport__Group__4 ;
    public final void rule__TableToImport__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:9343:1: ( rule__TableToImport__Group__3__Impl rule__TableToImport__Group__4 )
            // InternalMyDsl.g:9344:2: rule__TableToImport__Group__3__Impl rule__TableToImport__Group__4
            {
            pushFollow(FOLLOW_65);
            rule__TableToImport__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__TableToImport__Group__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TableToImport__Group__3"


    // $ANTLR start "rule__TableToImport__Group__3__Impl"
    // InternalMyDsl.g:9351:1: rule__TableToImport__Group__3__Impl : ( '{' ) ;
    public final void rule__TableToImport__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:9355:1: ( ( '{' ) )
            // InternalMyDsl.g:9356:1: ( '{' )
            {
            // InternalMyDsl.g:9356:1: ( '{' )
            // InternalMyDsl.g:9357:2: '{'
            {
             before(grammarAccess.getTableToImportAccess().getLeftCurlyBracketKeyword_3()); 
            match(input,38,FOLLOW_2); 
             after(grammarAccess.getTableToImportAccess().getLeftCurlyBracketKeyword_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TableToImport__Group__3__Impl"


    // $ANTLR start "rule__TableToImport__Group__4"
    // InternalMyDsl.g:9366:1: rule__TableToImport__Group__4 : rule__TableToImport__Group__4__Impl rule__TableToImport__Group__5 ;
    public final void rule__TableToImport__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:9370:1: ( rule__TableToImport__Group__4__Impl rule__TableToImport__Group__5 )
            // InternalMyDsl.g:9371:2: rule__TableToImport__Group__4__Impl rule__TableToImport__Group__5
            {
            pushFollow(FOLLOW_3);
            rule__TableToImport__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__TableToImport__Group__5();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TableToImport__Group__4"


    // $ANTLR start "rule__TableToImport__Group__4__Impl"
    // InternalMyDsl.g:9378:1: rule__TableToImport__Group__4__Impl : ( 'path' ) ;
    public final void rule__TableToImport__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:9382:1: ( ( 'path' ) )
            // InternalMyDsl.g:9383:1: ( 'path' )
            {
            // InternalMyDsl.g:9383:1: ( 'path' )
            // InternalMyDsl.g:9384:2: 'path'
            {
             before(grammarAccess.getTableToImportAccess().getPathKeyword_4()); 
            match(input,100,FOLLOW_2); 
             after(grammarAccess.getTableToImportAccess().getPathKeyword_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TableToImport__Group__4__Impl"


    // $ANTLR start "rule__TableToImport__Group__5"
    // InternalMyDsl.g:9393:1: rule__TableToImport__Group__5 : rule__TableToImport__Group__5__Impl rule__TableToImport__Group__6 ;
    public final void rule__TableToImport__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:9397:1: ( rule__TableToImport__Group__5__Impl rule__TableToImport__Group__6 )
            // InternalMyDsl.g:9398:2: rule__TableToImport__Group__5__Impl rule__TableToImport__Group__6
            {
            pushFollow(FOLLOW_57);
            rule__TableToImport__Group__5__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__TableToImport__Group__6();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TableToImport__Group__5"


    // $ANTLR start "rule__TableToImport__Group__5__Impl"
    // InternalMyDsl.g:9405:1: rule__TableToImport__Group__5__Impl : ( ( rule__TableToImport__PathAssignment_5 ) ) ;
    public final void rule__TableToImport__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:9409:1: ( ( ( rule__TableToImport__PathAssignment_5 ) ) )
            // InternalMyDsl.g:9410:1: ( ( rule__TableToImport__PathAssignment_5 ) )
            {
            // InternalMyDsl.g:9410:1: ( ( rule__TableToImport__PathAssignment_5 ) )
            // InternalMyDsl.g:9411:2: ( rule__TableToImport__PathAssignment_5 )
            {
             before(grammarAccess.getTableToImportAccess().getPathAssignment_5()); 
            // InternalMyDsl.g:9412:2: ( rule__TableToImport__PathAssignment_5 )
            // InternalMyDsl.g:9412:3: rule__TableToImport__PathAssignment_5
            {
            pushFollow(FOLLOW_2);
            rule__TableToImport__PathAssignment_5();

            state._fsp--;


            }

             after(grammarAccess.getTableToImportAccess().getPathAssignment_5()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TableToImport__Group__5__Impl"


    // $ANTLR start "rule__TableToImport__Group__6"
    // InternalMyDsl.g:9420:1: rule__TableToImport__Group__6 : rule__TableToImport__Group__6__Impl rule__TableToImport__Group__7 ;
    public final void rule__TableToImport__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:9424:1: ( rule__TableToImport__Group__6__Impl rule__TableToImport__Group__7 )
            // InternalMyDsl.g:9425:2: rule__TableToImport__Group__6__Impl rule__TableToImport__Group__7
            {
            pushFollow(FOLLOW_3);
            rule__TableToImport__Group__6__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__TableToImport__Group__7();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TableToImport__Group__6"


    // $ANTLR start "rule__TableToImport__Group__6__Impl"
    // InternalMyDsl.g:9432:1: rule__TableToImport__Group__6__Impl : ( 'delimiter' ) ;
    public final void rule__TableToImport__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:9436:1: ( ( 'delimiter' ) )
            // InternalMyDsl.g:9437:1: ( 'delimiter' )
            {
            // InternalMyDsl.g:9437:1: ( 'delimiter' )
            // InternalMyDsl.g:9438:2: 'delimiter'
            {
             before(grammarAccess.getTableToImportAccess().getDelimiterKeyword_6()); 
            match(input,91,FOLLOW_2); 
             after(grammarAccess.getTableToImportAccess().getDelimiterKeyword_6()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TableToImport__Group__6__Impl"


    // $ANTLR start "rule__TableToImport__Group__7"
    // InternalMyDsl.g:9447:1: rule__TableToImport__Group__7 : rule__TableToImport__Group__7__Impl rule__TableToImport__Group__8 ;
    public final void rule__TableToImport__Group__7() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:9451:1: ( rule__TableToImport__Group__7__Impl rule__TableToImport__Group__8 )
            // InternalMyDsl.g:9452:2: rule__TableToImport__Group__7__Impl rule__TableToImport__Group__8
            {
            pushFollow(FOLLOW_66);
            rule__TableToImport__Group__7__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__TableToImport__Group__8();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TableToImport__Group__7"


    // $ANTLR start "rule__TableToImport__Group__7__Impl"
    // InternalMyDsl.g:9459:1: rule__TableToImport__Group__7__Impl : ( ( rule__TableToImport__DelimiterAssignment_7 ) ) ;
    public final void rule__TableToImport__Group__7__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:9463:1: ( ( ( rule__TableToImport__DelimiterAssignment_7 ) ) )
            // InternalMyDsl.g:9464:1: ( ( rule__TableToImport__DelimiterAssignment_7 ) )
            {
            // InternalMyDsl.g:9464:1: ( ( rule__TableToImport__DelimiterAssignment_7 ) )
            // InternalMyDsl.g:9465:2: ( rule__TableToImport__DelimiterAssignment_7 )
            {
             before(grammarAccess.getTableToImportAccess().getDelimiterAssignment_7()); 
            // InternalMyDsl.g:9466:2: ( rule__TableToImport__DelimiterAssignment_7 )
            // InternalMyDsl.g:9466:3: rule__TableToImport__DelimiterAssignment_7
            {
            pushFollow(FOLLOW_2);
            rule__TableToImport__DelimiterAssignment_7();

            state._fsp--;


            }

             after(grammarAccess.getTableToImportAccess().getDelimiterAssignment_7()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TableToImport__Group__7__Impl"


    // $ANTLR start "rule__TableToImport__Group__8"
    // InternalMyDsl.g:9474:1: rule__TableToImport__Group__8 : rule__TableToImport__Group__8__Impl rule__TableToImport__Group__9 ;
    public final void rule__TableToImport__Group__8() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:9478:1: ( rule__TableToImport__Group__8__Impl rule__TableToImport__Group__9 )
            // InternalMyDsl.g:9479:2: rule__TableToImport__Group__8__Impl rule__TableToImport__Group__9
            {
            pushFollow(FOLLOW_3);
            rule__TableToImport__Group__8__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__TableToImport__Group__9();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TableToImport__Group__8"


    // $ANTLR start "rule__TableToImport__Group__8__Impl"
    // InternalMyDsl.g:9486:1: rule__TableToImport__Group__8__Impl : ( 'table' ) ;
    public final void rule__TableToImport__Group__8__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:9490:1: ( ( 'table' ) )
            // InternalMyDsl.g:9491:1: ( 'table' )
            {
            // InternalMyDsl.g:9491:1: ( 'table' )
            // InternalMyDsl.g:9492:2: 'table'
            {
             before(grammarAccess.getTableToImportAccess().getTableKeyword_8()); 
            match(input,52,FOLLOW_2); 
             after(grammarAccess.getTableToImportAccess().getTableKeyword_8()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TableToImport__Group__8__Impl"


    // $ANTLR start "rule__TableToImport__Group__9"
    // InternalMyDsl.g:9501:1: rule__TableToImport__Group__9 : rule__TableToImport__Group__9__Impl rule__TableToImport__Group__10 ;
    public final void rule__TableToImport__Group__9() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:9505:1: ( rule__TableToImport__Group__9__Impl rule__TableToImport__Group__10 )
            // InternalMyDsl.g:9506:2: rule__TableToImport__Group__9__Impl rule__TableToImport__Group__10
            {
            pushFollow(FOLLOW_13);
            rule__TableToImport__Group__9__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__TableToImport__Group__10();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TableToImport__Group__9"


    // $ANTLR start "rule__TableToImport__Group__9__Impl"
    // InternalMyDsl.g:9513:1: rule__TableToImport__Group__9__Impl : ( ( rule__TableToImport__TableAssignment_9 ) ) ;
    public final void rule__TableToImport__Group__9__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:9517:1: ( ( ( rule__TableToImport__TableAssignment_9 ) ) )
            // InternalMyDsl.g:9518:1: ( ( rule__TableToImport__TableAssignment_9 ) )
            {
            // InternalMyDsl.g:9518:1: ( ( rule__TableToImport__TableAssignment_9 ) )
            // InternalMyDsl.g:9519:2: ( rule__TableToImport__TableAssignment_9 )
            {
             before(grammarAccess.getTableToImportAccess().getTableAssignment_9()); 
            // InternalMyDsl.g:9520:2: ( rule__TableToImport__TableAssignment_9 )
            // InternalMyDsl.g:9520:3: rule__TableToImport__TableAssignment_9
            {
            pushFollow(FOLLOW_2);
            rule__TableToImport__TableAssignment_9();

            state._fsp--;


            }

             after(grammarAccess.getTableToImportAccess().getTableAssignment_9()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TableToImport__Group__9__Impl"


    // $ANTLR start "rule__TableToImport__Group__10"
    // InternalMyDsl.g:9528:1: rule__TableToImport__Group__10 : rule__TableToImport__Group__10__Impl ;
    public final void rule__TableToImport__Group__10() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:9532:1: ( rule__TableToImport__Group__10__Impl )
            // InternalMyDsl.g:9533:2: rule__TableToImport__Group__10__Impl
            {
            pushFollow(FOLLOW_2);
            rule__TableToImport__Group__10__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TableToImport__Group__10"


    // $ANTLR start "rule__TableToImport__Group__10__Impl"
    // InternalMyDsl.g:9539:1: rule__TableToImport__Group__10__Impl : ( '}' ) ;
    public final void rule__TableToImport__Group__10__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:9543:1: ( ( '}' ) )
            // InternalMyDsl.g:9544:1: ( '}' )
            {
            // InternalMyDsl.g:9544:1: ( '}' )
            // InternalMyDsl.g:9545:2: '}'
            {
             before(grammarAccess.getTableToImportAccess().getRightCurlyBracketKeyword_10()); 
            match(input,41,FOLLOW_2); 
             after(grammarAccess.getTableToImportAccess().getRightCurlyBracketKeyword_10()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TableToImport__Group__10__Impl"


    // $ANTLR start "rule__EIntegerObject__Group__0"
    // InternalMyDsl.g:9555:1: rule__EIntegerObject__Group__0 : rule__EIntegerObject__Group__0__Impl rule__EIntegerObject__Group__1 ;
    public final void rule__EIntegerObject__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:9559:1: ( rule__EIntegerObject__Group__0__Impl rule__EIntegerObject__Group__1 )
            // InternalMyDsl.g:9560:2: rule__EIntegerObject__Group__0__Impl rule__EIntegerObject__Group__1
            {
            pushFollow(FOLLOW_59);
            rule__EIntegerObject__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__EIntegerObject__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EIntegerObject__Group__0"


    // $ANTLR start "rule__EIntegerObject__Group__0__Impl"
    // InternalMyDsl.g:9567:1: rule__EIntegerObject__Group__0__Impl : ( ( '-' )? ) ;
    public final void rule__EIntegerObject__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:9571:1: ( ( ( '-' )? ) )
            // InternalMyDsl.g:9572:1: ( ( '-' )? )
            {
            // InternalMyDsl.g:9572:1: ( ( '-' )? )
            // InternalMyDsl.g:9573:2: ( '-' )?
            {
             before(grammarAccess.getEIntegerObjectAccess().getHyphenMinusKeyword_0()); 
            // InternalMyDsl.g:9574:2: ( '-' )?
            int alt32=2;
            int LA32_0 = input.LA(1);

            if ( (LA32_0==107) ) {
                alt32=1;
            }
            switch (alt32) {
                case 1 :
                    // InternalMyDsl.g:9574:3: '-'
                    {
                    match(input,107,FOLLOW_2); 

                    }
                    break;

            }

             after(grammarAccess.getEIntegerObjectAccess().getHyphenMinusKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EIntegerObject__Group__0__Impl"


    // $ANTLR start "rule__EIntegerObject__Group__1"
    // InternalMyDsl.g:9582:1: rule__EIntegerObject__Group__1 : rule__EIntegerObject__Group__1__Impl ;
    public final void rule__EIntegerObject__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:9586:1: ( rule__EIntegerObject__Group__1__Impl )
            // InternalMyDsl.g:9587:2: rule__EIntegerObject__Group__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__EIntegerObject__Group__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EIntegerObject__Group__1"


    // $ANTLR start "rule__EIntegerObject__Group__1__Impl"
    // InternalMyDsl.g:9593:1: rule__EIntegerObject__Group__1__Impl : ( RULE_INT ) ;
    public final void rule__EIntegerObject__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:9597:1: ( ( RULE_INT ) )
            // InternalMyDsl.g:9598:1: ( RULE_INT )
            {
            // InternalMyDsl.g:9598:1: ( RULE_INT )
            // InternalMyDsl.g:9599:2: RULE_INT
            {
             before(grammarAccess.getEIntegerObjectAccess().getINTTerminalRuleCall_1()); 
            match(input,RULE_INT,FOLLOW_2); 
             after(grammarAccess.getEIntegerObjectAccess().getINTTerminalRuleCall_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EIntegerObject__Group__1__Impl"


    // $ANTLR start "rule__Model__NameAssignment_1"
    // InternalMyDsl.g:9609:1: rule__Model__NameAssignment_1 : ( ruleEString ) ;
    public final void rule__Model__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:9613:1: ( ( ruleEString ) )
            // InternalMyDsl.g:9614:2: ( ruleEString )
            {
            // InternalMyDsl.g:9614:2: ( ruleEString )
            // InternalMyDsl.g:9615:3: ruleEString
            {
             before(grammarAccess.getModelAccess().getNameEStringParserRuleCall_1_0()); 
            pushFollow(FOLLOW_2);
            ruleEString();

            state._fsp--;

             after(grammarAccess.getModelAccess().getNameEStringParserRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__NameAssignment_1"


    // $ANTLR start "rule__Model__LogsAssignment_4"
    // InternalMyDsl.g:9624:1: rule__Model__LogsAssignment_4 : ( ruleEBooleanObject ) ;
    public final void rule__Model__LogsAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:9628:1: ( ( ruleEBooleanObject ) )
            // InternalMyDsl.g:9629:2: ( ruleEBooleanObject )
            {
            // InternalMyDsl.g:9629:2: ( ruleEBooleanObject )
            // InternalMyDsl.g:9630:3: ruleEBooleanObject
            {
             before(grammarAccess.getModelAccess().getLogsEBooleanObjectParserRuleCall_4_0()); 
            pushFollow(FOLLOW_2);
            ruleEBooleanObject();

            state._fsp--;

             after(grammarAccess.getModelAccess().getLogsEBooleanObjectParserRuleCall_4_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__LogsAssignment_4"


    // $ANTLR start "rule__Model__TablesAssignment_7"
    // InternalMyDsl.g:9639:1: rule__Model__TablesAssignment_7 : ( ruleTable ) ;
    public final void rule__Model__TablesAssignment_7() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:9643:1: ( ( ruleTable ) )
            // InternalMyDsl.g:9644:2: ( ruleTable )
            {
            // InternalMyDsl.g:9644:2: ( ruleTable )
            // InternalMyDsl.g:9645:3: ruleTable
            {
             before(grammarAccess.getModelAccess().getTablesTableParserRuleCall_7_0()); 
            pushFollow(FOLLOW_2);
            ruleTable();

            state._fsp--;

             after(grammarAccess.getModelAccess().getTablesTableParserRuleCall_7_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__TablesAssignment_7"


    // $ANTLR start "rule__Model__TablesAssignment_8_1"
    // InternalMyDsl.g:9654:1: rule__Model__TablesAssignment_8_1 : ( ruleTable ) ;
    public final void rule__Model__TablesAssignment_8_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:9658:1: ( ( ruleTable ) )
            // InternalMyDsl.g:9659:2: ( ruleTable )
            {
            // InternalMyDsl.g:9659:2: ( ruleTable )
            // InternalMyDsl.g:9660:3: ruleTable
            {
             before(grammarAccess.getModelAccess().getTablesTableParserRuleCall_8_1_0()); 
            pushFollow(FOLLOW_2);
            ruleTable();

            state._fsp--;

             after(grammarAccess.getModelAccess().getTablesTableParserRuleCall_8_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__TablesAssignment_8_1"


    // $ANTLR start "rule__Model__StepsAssignment_12"
    // InternalMyDsl.g:9669:1: rule__Model__StepsAssignment_12 : ( ruleStep ) ;
    public final void rule__Model__StepsAssignment_12() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:9673:1: ( ( ruleStep ) )
            // InternalMyDsl.g:9674:2: ( ruleStep )
            {
            // InternalMyDsl.g:9674:2: ( ruleStep )
            // InternalMyDsl.g:9675:3: ruleStep
            {
             before(grammarAccess.getModelAccess().getStepsStepParserRuleCall_12_0()); 
            pushFollow(FOLLOW_2);
            ruleStep();

            state._fsp--;

             after(grammarAccess.getModelAccess().getStepsStepParserRuleCall_12_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__StepsAssignment_12"


    // $ANTLR start "rule__Model__StepsAssignment_13_1"
    // InternalMyDsl.g:9684:1: rule__Model__StepsAssignment_13_1 : ( ruleStep ) ;
    public final void rule__Model__StepsAssignment_13_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:9688:1: ( ( ruleStep ) )
            // InternalMyDsl.g:9689:2: ( ruleStep )
            {
            // InternalMyDsl.g:9689:2: ( ruleStep )
            // InternalMyDsl.g:9690:3: ruleStep
            {
             before(grammarAccess.getModelAccess().getStepsStepParserRuleCall_13_1_0()); 
            pushFollow(FOLLOW_2);
            ruleStep();

            state._fsp--;

             after(grammarAccess.getModelAccess().getStepsStepParserRuleCall_13_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__StepsAssignment_13_1"


    // $ANTLR start "rule__Table__NameAssignment_1"
    // InternalMyDsl.g:9699:1: rule__Table__NameAssignment_1 : ( ruleEString ) ;
    public final void rule__Table__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:9703:1: ( ( ruleEString ) )
            // InternalMyDsl.g:9704:2: ( ruleEString )
            {
            // InternalMyDsl.g:9704:2: ( ruleEString )
            // InternalMyDsl.g:9705:3: ruleEString
            {
             before(grammarAccess.getTableAccess().getNameEStringParserRuleCall_1_0()); 
            pushFollow(FOLLOW_2);
            ruleEString();

            state._fsp--;

             after(grammarAccess.getTableAccess().getNameEStringParserRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Table__NameAssignment_1"


    // $ANTLR start "rule__Table__ColumnsAssignment_5"
    // InternalMyDsl.g:9714:1: rule__Table__ColumnsAssignment_5 : ( ruleColumn ) ;
    public final void rule__Table__ColumnsAssignment_5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:9718:1: ( ( ruleColumn ) )
            // InternalMyDsl.g:9719:2: ( ruleColumn )
            {
            // InternalMyDsl.g:9719:2: ( ruleColumn )
            // InternalMyDsl.g:9720:3: ruleColumn
            {
             before(grammarAccess.getTableAccess().getColumnsColumnParserRuleCall_5_0()); 
            pushFollow(FOLLOW_2);
            ruleColumn();

            state._fsp--;

             after(grammarAccess.getTableAccess().getColumnsColumnParserRuleCall_5_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Table__ColumnsAssignment_5"


    // $ANTLR start "rule__Table__ColumnsAssignment_6_1"
    // InternalMyDsl.g:9729:1: rule__Table__ColumnsAssignment_6_1 : ( ruleColumn ) ;
    public final void rule__Table__ColumnsAssignment_6_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:9733:1: ( ( ruleColumn ) )
            // InternalMyDsl.g:9734:2: ( ruleColumn )
            {
            // InternalMyDsl.g:9734:2: ( ruleColumn )
            // InternalMyDsl.g:9735:3: ruleColumn
            {
             before(grammarAccess.getTableAccess().getColumnsColumnParserRuleCall_6_1_0()); 
            pushFollow(FOLLOW_2);
            ruleColumn();

            state._fsp--;

             after(grammarAccess.getTableAccess().getColumnsColumnParserRuleCall_6_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Table__ColumnsAssignment_6_1"


    // $ANTLR start "rule__Column__NameAssignment_1"
    // InternalMyDsl.g:9744:1: rule__Column__NameAssignment_1 : ( ruleEString ) ;
    public final void rule__Column__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:9748:1: ( ( ruleEString ) )
            // InternalMyDsl.g:9749:2: ( ruleEString )
            {
            // InternalMyDsl.g:9749:2: ( ruleEString )
            // InternalMyDsl.g:9750:3: ruleEString
            {
             before(grammarAccess.getColumnAccess().getNameEStringParserRuleCall_1_0()); 
            pushFollow(FOLLOW_2);
            ruleEString();

            state._fsp--;

             after(grammarAccess.getColumnAccess().getNameEStringParserRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Column__NameAssignment_1"


    // $ANTLR start "rule__Column__DataTypeAssignment_4"
    // InternalMyDsl.g:9759:1: rule__Column__DataTypeAssignment_4 : ( ruleDataType ) ;
    public final void rule__Column__DataTypeAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:9763:1: ( ( ruleDataType ) )
            // InternalMyDsl.g:9764:2: ( ruleDataType )
            {
            // InternalMyDsl.g:9764:2: ( ruleDataType )
            // InternalMyDsl.g:9765:3: ruleDataType
            {
             before(grammarAccess.getColumnAccess().getDataTypeDataTypeEnumRuleCall_4_0()); 
            pushFollow(FOLLOW_2);
            ruleDataType();

            state._fsp--;

             after(grammarAccess.getColumnAccess().getDataTypeDataTypeEnumRuleCall_4_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Column__DataTypeAssignment_4"


    // $ANTLR start "rule__Save__NameAssignment_1"
    // InternalMyDsl.g:9774:1: rule__Save__NameAssignment_1 : ( ruleEString ) ;
    public final void rule__Save__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:9778:1: ( ( ruleEString ) )
            // InternalMyDsl.g:9779:2: ( ruleEString )
            {
            // InternalMyDsl.g:9779:2: ( ruleEString )
            // InternalMyDsl.g:9780:3: ruleEString
            {
             before(grammarAccess.getSaveAccess().getNameEStringParserRuleCall_1_0()); 
            pushFollow(FOLLOW_2);
            ruleEString();

            state._fsp--;

             after(grammarAccess.getSaveAccess().getNameEStringParserRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Save__NameAssignment_1"


    // $ANTLR start "rule__Save__DescriptionAssignment_3_1"
    // InternalMyDsl.g:9789:1: rule__Save__DescriptionAssignment_3_1 : ( ruleEString ) ;
    public final void rule__Save__DescriptionAssignment_3_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:9793:1: ( ( ruleEString ) )
            // InternalMyDsl.g:9794:2: ( ruleEString )
            {
            // InternalMyDsl.g:9794:2: ( ruleEString )
            // InternalMyDsl.g:9795:3: ruleEString
            {
             before(grammarAccess.getSaveAccess().getDescriptionEStringParserRuleCall_3_1_0()); 
            pushFollow(FOLLOW_2);
            ruleEString();

            state._fsp--;

             after(grammarAccess.getSaveAccess().getDescriptionEStringParserRuleCall_3_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Save__DescriptionAssignment_3_1"


    // $ANTLR start "rule__Save__TablesToSaveAssignment_6"
    // InternalMyDsl.g:9804:1: rule__Save__TablesToSaveAssignment_6 : ( ruleTableToSave ) ;
    public final void rule__Save__TablesToSaveAssignment_6() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:9808:1: ( ( ruleTableToSave ) )
            // InternalMyDsl.g:9809:2: ( ruleTableToSave )
            {
            // InternalMyDsl.g:9809:2: ( ruleTableToSave )
            // InternalMyDsl.g:9810:3: ruleTableToSave
            {
             before(grammarAccess.getSaveAccess().getTablesToSaveTableToSaveParserRuleCall_6_0()); 
            pushFollow(FOLLOW_2);
            ruleTableToSave();

            state._fsp--;

             after(grammarAccess.getSaveAccess().getTablesToSaveTableToSaveParserRuleCall_6_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Save__TablesToSaveAssignment_6"


    // $ANTLR start "rule__Save__TablesToSaveAssignment_7_1"
    // InternalMyDsl.g:9819:1: rule__Save__TablesToSaveAssignment_7_1 : ( ruleTableToSave ) ;
    public final void rule__Save__TablesToSaveAssignment_7_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:9823:1: ( ( ruleTableToSave ) )
            // InternalMyDsl.g:9824:2: ( ruleTableToSave )
            {
            // InternalMyDsl.g:9824:2: ( ruleTableToSave )
            // InternalMyDsl.g:9825:3: ruleTableToSave
            {
             before(grammarAccess.getSaveAccess().getTablesToSaveTableToSaveParserRuleCall_7_1_0()); 
            pushFollow(FOLLOW_2);
            ruleTableToSave();

            state._fsp--;

             after(grammarAccess.getSaveAccess().getTablesToSaveTableToSaveParserRuleCall_7_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Save__TablesToSaveAssignment_7_1"


    // $ANTLR start "rule__Group__NameAssignment_1"
    // InternalMyDsl.g:9834:1: rule__Group__NameAssignment_1 : ( ruleEString ) ;
    public final void rule__Group__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:9838:1: ( ( ruleEString ) )
            // InternalMyDsl.g:9839:2: ( ruleEString )
            {
            // InternalMyDsl.g:9839:2: ( ruleEString )
            // InternalMyDsl.g:9840:3: ruleEString
            {
             before(grammarAccess.getGroupAccess().getNameEStringParserRuleCall_1_0()); 
            pushFollow(FOLLOW_2);
            ruleEString();

            state._fsp--;

             after(grammarAccess.getGroupAccess().getNameEStringParserRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Group__NameAssignment_1"


    // $ANTLR start "rule__Group__DescriptionAssignment_3_1"
    // InternalMyDsl.g:9849:1: rule__Group__DescriptionAssignment_3_1 : ( ruleEString ) ;
    public final void rule__Group__DescriptionAssignment_3_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:9853:1: ( ( ruleEString ) )
            // InternalMyDsl.g:9854:2: ( ruleEString )
            {
            // InternalMyDsl.g:9854:2: ( ruleEString )
            // InternalMyDsl.g:9855:3: ruleEString
            {
             before(grammarAccess.getGroupAccess().getDescriptionEStringParserRuleCall_3_1_0()); 
            pushFollow(FOLLOW_2);
            ruleEString();

            state._fsp--;

             after(grammarAccess.getGroupAccess().getDescriptionEStringParserRuleCall_3_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Group__DescriptionAssignment_3_1"


    // $ANTLR start "rule__Group__TableAssignment_5"
    // InternalMyDsl.g:9864:1: rule__Group__TableAssignment_5 : ( ( ruleEString ) ) ;
    public final void rule__Group__TableAssignment_5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:9868:1: ( ( ( ruleEString ) ) )
            // InternalMyDsl.g:9869:2: ( ( ruleEString ) )
            {
            // InternalMyDsl.g:9869:2: ( ( ruleEString ) )
            // InternalMyDsl.g:9870:3: ( ruleEString )
            {
             before(grammarAccess.getGroupAccess().getTableTableCrossReference_5_0()); 
            // InternalMyDsl.g:9871:3: ( ruleEString )
            // InternalMyDsl.g:9872:4: ruleEString
            {
             before(grammarAccess.getGroupAccess().getTableTableEStringParserRuleCall_5_0_1()); 
            pushFollow(FOLLOW_2);
            ruleEString();

            state._fsp--;

             after(grammarAccess.getGroupAccess().getTableTableEStringParserRuleCall_5_0_1()); 

            }

             after(grammarAccess.getGroupAccess().getTableTableCrossReference_5_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Group__TableAssignment_5"


    // $ANTLR start "rule__Group__GroupByAssignment_8"
    // InternalMyDsl.g:9883:1: rule__Group__GroupByAssignment_8 : ( ( ruleEString ) ) ;
    public final void rule__Group__GroupByAssignment_8() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:9887:1: ( ( ( ruleEString ) ) )
            // InternalMyDsl.g:9888:2: ( ( ruleEString ) )
            {
            // InternalMyDsl.g:9888:2: ( ( ruleEString ) )
            // InternalMyDsl.g:9889:3: ( ruleEString )
            {
             before(grammarAccess.getGroupAccess().getGroupByColumnCrossReference_8_0()); 
            // InternalMyDsl.g:9890:3: ( ruleEString )
            // InternalMyDsl.g:9891:4: ruleEString
            {
             before(grammarAccess.getGroupAccess().getGroupByColumnEStringParserRuleCall_8_0_1()); 
            pushFollow(FOLLOW_2);
            ruleEString();

            state._fsp--;

             after(grammarAccess.getGroupAccess().getGroupByColumnEStringParserRuleCall_8_0_1()); 

            }

             after(grammarAccess.getGroupAccess().getGroupByColumnCrossReference_8_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Group__GroupByAssignment_8"


    // $ANTLR start "rule__Group__GroupByAssignment_9_1"
    // InternalMyDsl.g:9902:1: rule__Group__GroupByAssignment_9_1 : ( ( ruleEString ) ) ;
    public final void rule__Group__GroupByAssignment_9_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:9906:1: ( ( ( ruleEString ) ) )
            // InternalMyDsl.g:9907:2: ( ( ruleEString ) )
            {
            // InternalMyDsl.g:9907:2: ( ( ruleEString ) )
            // InternalMyDsl.g:9908:3: ( ruleEString )
            {
             before(grammarAccess.getGroupAccess().getGroupByColumnCrossReference_9_1_0()); 
            // InternalMyDsl.g:9909:3: ( ruleEString )
            // InternalMyDsl.g:9910:4: ruleEString
            {
             before(grammarAccess.getGroupAccess().getGroupByColumnEStringParserRuleCall_9_1_0_1()); 
            pushFollow(FOLLOW_2);
            ruleEString();

            state._fsp--;

             after(grammarAccess.getGroupAccess().getGroupByColumnEStringParserRuleCall_9_1_0_1()); 

            }

             after(grammarAccess.getGroupAccess().getGroupByColumnCrossReference_9_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Group__GroupByAssignment_9_1"


    // $ANTLR start "rule__Group__OperationAssignment_12"
    // InternalMyDsl.g:9921:1: rule__Group__OperationAssignment_12 : ( ruleGroupOperationType ) ;
    public final void rule__Group__OperationAssignment_12() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:9925:1: ( ( ruleGroupOperationType ) )
            // InternalMyDsl.g:9926:2: ( ruleGroupOperationType )
            {
            // InternalMyDsl.g:9926:2: ( ruleGroupOperationType )
            // InternalMyDsl.g:9927:3: ruleGroupOperationType
            {
             before(grammarAccess.getGroupAccess().getOperationGroupOperationTypeEnumRuleCall_12_0()); 
            pushFollow(FOLLOW_2);
            ruleGroupOperationType();

            state._fsp--;

             after(grammarAccess.getGroupAccess().getOperationGroupOperationTypeEnumRuleCall_12_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Group__OperationAssignment_12"


    // $ANTLR start "rule__Group__OperandColumnAssignment_14"
    // InternalMyDsl.g:9936:1: rule__Group__OperandColumnAssignment_14 : ( ( ruleEString ) ) ;
    public final void rule__Group__OperandColumnAssignment_14() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:9940:1: ( ( ( ruleEString ) ) )
            // InternalMyDsl.g:9941:2: ( ( ruleEString ) )
            {
            // InternalMyDsl.g:9941:2: ( ( ruleEString ) )
            // InternalMyDsl.g:9942:3: ( ruleEString )
            {
             before(grammarAccess.getGroupAccess().getOperandColumnColumnCrossReference_14_0()); 
            // InternalMyDsl.g:9943:3: ( ruleEString )
            // InternalMyDsl.g:9944:4: ruleEString
            {
             before(grammarAccess.getGroupAccess().getOperandColumnColumnEStringParserRuleCall_14_0_1()); 
            pushFollow(FOLLOW_2);
            ruleEString();

            state._fsp--;

             after(grammarAccess.getGroupAccess().getOperandColumnColumnEStringParserRuleCall_14_0_1()); 

            }

             after(grammarAccess.getGroupAccess().getOperandColumnColumnCrossReference_14_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Group__OperandColumnAssignment_14"


    // $ANTLR start "rule__Group__ResultTableAssignment_16"
    // InternalMyDsl.g:9955:1: rule__Group__ResultTableAssignment_16 : ( ( ruleEString ) ) ;
    public final void rule__Group__ResultTableAssignment_16() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:9959:1: ( ( ( ruleEString ) ) )
            // InternalMyDsl.g:9960:2: ( ( ruleEString ) )
            {
            // InternalMyDsl.g:9960:2: ( ( ruleEString ) )
            // InternalMyDsl.g:9961:3: ( ruleEString )
            {
             before(grammarAccess.getGroupAccess().getResultTableTableCrossReference_16_0()); 
            // InternalMyDsl.g:9962:3: ( ruleEString )
            // InternalMyDsl.g:9963:4: ruleEString
            {
             before(grammarAccess.getGroupAccess().getResultTableTableEStringParserRuleCall_16_0_1()); 
            pushFollow(FOLLOW_2);
            ruleEString();

            state._fsp--;

             after(grammarAccess.getGroupAccess().getResultTableTableEStringParserRuleCall_16_0_1()); 

            }

             after(grammarAccess.getGroupAccess().getResultTableTableCrossReference_16_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Group__ResultTableAssignment_16"


    // $ANTLR start "rule__Group__ResultColumnAssignment_18"
    // InternalMyDsl.g:9974:1: rule__Group__ResultColumnAssignment_18 : ( ( ruleEString ) ) ;
    public final void rule__Group__ResultColumnAssignment_18() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:9978:1: ( ( ( ruleEString ) ) )
            // InternalMyDsl.g:9979:2: ( ( ruleEString ) )
            {
            // InternalMyDsl.g:9979:2: ( ( ruleEString ) )
            // InternalMyDsl.g:9980:3: ( ruleEString )
            {
             before(grammarAccess.getGroupAccess().getResultColumnColumnCrossReference_18_0()); 
            // InternalMyDsl.g:9981:3: ( ruleEString )
            // InternalMyDsl.g:9982:4: ruleEString
            {
             before(grammarAccess.getGroupAccess().getResultColumnColumnEStringParserRuleCall_18_0_1()); 
            pushFollow(FOLLOW_2);
            ruleEString();

            state._fsp--;

             after(grammarAccess.getGroupAccess().getResultColumnColumnEStringParserRuleCall_18_0_1()); 

            }

             after(grammarAccess.getGroupAccess().getResultColumnColumnCrossReference_18_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Group__ResultColumnAssignment_18"


    // $ANTLR start "rule__Group__NextAssignment_20"
    // InternalMyDsl.g:9993:1: rule__Group__NextAssignment_20 : ( ( ruleEString ) ) ;
    public final void rule__Group__NextAssignment_20() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:9997:1: ( ( ( ruleEString ) ) )
            // InternalMyDsl.g:9998:2: ( ( ruleEString ) )
            {
            // InternalMyDsl.g:9998:2: ( ( ruleEString ) )
            // InternalMyDsl.g:9999:3: ( ruleEString )
            {
             before(grammarAccess.getGroupAccess().getNextStepCrossReference_20_0()); 
            // InternalMyDsl.g:10000:3: ( ruleEString )
            // InternalMyDsl.g:10001:4: ruleEString
            {
             before(grammarAccess.getGroupAccess().getNextStepEStringParserRuleCall_20_0_1()); 
            pushFollow(FOLLOW_2);
            ruleEString();

            state._fsp--;

             after(grammarAccess.getGroupAccess().getNextStepEStringParserRuleCall_20_0_1()); 

            }

             after(grammarAccess.getGroupAccess().getNextStepCrossReference_20_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Group__NextAssignment_20"


    // $ANTLR start "rule__Sort__NameAssignment_1"
    // InternalMyDsl.g:10012:1: rule__Sort__NameAssignment_1 : ( ruleEString ) ;
    public final void rule__Sort__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:10016:1: ( ( ruleEString ) )
            // InternalMyDsl.g:10017:2: ( ruleEString )
            {
            // InternalMyDsl.g:10017:2: ( ruleEString )
            // InternalMyDsl.g:10018:3: ruleEString
            {
             before(grammarAccess.getSortAccess().getNameEStringParserRuleCall_1_0()); 
            pushFollow(FOLLOW_2);
            ruleEString();

            state._fsp--;

             after(grammarAccess.getSortAccess().getNameEStringParserRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Sort__NameAssignment_1"


    // $ANTLR start "rule__Sort__DescriptionAssignment_3_1"
    // InternalMyDsl.g:10027:1: rule__Sort__DescriptionAssignment_3_1 : ( ruleEString ) ;
    public final void rule__Sort__DescriptionAssignment_3_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:10031:1: ( ( ruleEString ) )
            // InternalMyDsl.g:10032:2: ( ruleEString )
            {
            // InternalMyDsl.g:10032:2: ( ruleEString )
            // InternalMyDsl.g:10033:3: ruleEString
            {
             before(grammarAccess.getSortAccess().getDescriptionEStringParserRuleCall_3_1_0()); 
            pushFollow(FOLLOW_2);
            ruleEString();

            state._fsp--;

             after(grammarAccess.getSortAccess().getDescriptionEStringParserRuleCall_3_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Sort__DescriptionAssignment_3_1"


    // $ANTLR start "rule__Sort__TableAssignment_5"
    // InternalMyDsl.g:10042:1: rule__Sort__TableAssignment_5 : ( ( ruleEString ) ) ;
    public final void rule__Sort__TableAssignment_5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:10046:1: ( ( ( ruleEString ) ) )
            // InternalMyDsl.g:10047:2: ( ( ruleEString ) )
            {
            // InternalMyDsl.g:10047:2: ( ( ruleEString ) )
            // InternalMyDsl.g:10048:3: ( ruleEString )
            {
             before(grammarAccess.getSortAccess().getTableTableCrossReference_5_0()); 
            // InternalMyDsl.g:10049:3: ( ruleEString )
            // InternalMyDsl.g:10050:4: ruleEString
            {
             before(grammarAccess.getSortAccess().getTableTableEStringParserRuleCall_5_0_1()); 
            pushFollow(FOLLOW_2);
            ruleEString();

            state._fsp--;

             after(grammarAccess.getSortAccess().getTableTableEStringParserRuleCall_5_0_1()); 

            }

             after(grammarAccess.getSortAccess().getTableTableCrossReference_5_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Sort__TableAssignment_5"


    // $ANTLR start "rule__Sort__ColumnAssignment_7"
    // InternalMyDsl.g:10061:1: rule__Sort__ColumnAssignment_7 : ( ( ruleEString ) ) ;
    public final void rule__Sort__ColumnAssignment_7() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:10065:1: ( ( ( ruleEString ) ) )
            // InternalMyDsl.g:10066:2: ( ( ruleEString ) )
            {
            // InternalMyDsl.g:10066:2: ( ( ruleEString ) )
            // InternalMyDsl.g:10067:3: ( ruleEString )
            {
             before(grammarAccess.getSortAccess().getColumnColumnCrossReference_7_0()); 
            // InternalMyDsl.g:10068:3: ( ruleEString )
            // InternalMyDsl.g:10069:4: ruleEString
            {
             before(grammarAccess.getSortAccess().getColumnColumnEStringParserRuleCall_7_0_1()); 
            pushFollow(FOLLOW_2);
            ruleEString();

            state._fsp--;

             after(grammarAccess.getSortAccess().getColumnColumnEStringParserRuleCall_7_0_1()); 

            }

             after(grammarAccess.getSortAccess().getColumnColumnCrossReference_7_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Sort__ColumnAssignment_7"


    // $ANTLR start "rule__Sort__OrderAssignment_9"
    // InternalMyDsl.g:10080:1: rule__Sort__OrderAssignment_9 : ( ruleOrderType ) ;
    public final void rule__Sort__OrderAssignment_9() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:10084:1: ( ( ruleOrderType ) )
            // InternalMyDsl.g:10085:2: ( ruleOrderType )
            {
            // InternalMyDsl.g:10085:2: ( ruleOrderType )
            // InternalMyDsl.g:10086:3: ruleOrderType
            {
             before(grammarAccess.getSortAccess().getOrderOrderTypeEnumRuleCall_9_0()); 
            pushFollow(FOLLOW_2);
            ruleOrderType();

            state._fsp--;

             after(grammarAccess.getSortAccess().getOrderOrderTypeEnumRuleCall_9_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Sort__OrderAssignment_9"


    // $ANTLR start "rule__Sort__NextAssignment_11"
    // InternalMyDsl.g:10095:1: rule__Sort__NextAssignment_11 : ( ( ruleEString ) ) ;
    public final void rule__Sort__NextAssignment_11() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:10099:1: ( ( ( ruleEString ) ) )
            // InternalMyDsl.g:10100:2: ( ( ruleEString ) )
            {
            // InternalMyDsl.g:10100:2: ( ( ruleEString ) )
            // InternalMyDsl.g:10101:3: ( ruleEString )
            {
             before(grammarAccess.getSortAccess().getNextStepCrossReference_11_0()); 
            // InternalMyDsl.g:10102:3: ( ruleEString )
            // InternalMyDsl.g:10103:4: ruleEString
            {
             before(grammarAccess.getSortAccess().getNextStepEStringParserRuleCall_11_0_1()); 
            pushFollow(FOLLOW_2);
            ruleEString();

            state._fsp--;

             after(grammarAccess.getSortAccess().getNextStepEStringParserRuleCall_11_0_1()); 

            }

             after(grammarAccess.getSortAccess().getNextStepCrossReference_11_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Sort__NextAssignment_11"


    // $ANTLR start "rule__AppendRows__NameAssignment_1"
    // InternalMyDsl.g:10114:1: rule__AppendRows__NameAssignment_1 : ( ruleEString ) ;
    public final void rule__AppendRows__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:10118:1: ( ( ruleEString ) )
            // InternalMyDsl.g:10119:2: ( ruleEString )
            {
            // InternalMyDsl.g:10119:2: ( ruleEString )
            // InternalMyDsl.g:10120:3: ruleEString
            {
             before(grammarAccess.getAppendRowsAccess().getNameEStringParserRuleCall_1_0()); 
            pushFollow(FOLLOW_2);
            ruleEString();

            state._fsp--;

             after(grammarAccess.getAppendRowsAccess().getNameEStringParserRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AppendRows__NameAssignment_1"


    // $ANTLR start "rule__AppendRows__DescriptionAssignment_3_1"
    // InternalMyDsl.g:10129:1: rule__AppendRows__DescriptionAssignment_3_1 : ( ruleEString ) ;
    public final void rule__AppendRows__DescriptionAssignment_3_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:10133:1: ( ( ruleEString ) )
            // InternalMyDsl.g:10134:2: ( ruleEString )
            {
            // InternalMyDsl.g:10134:2: ( ruleEString )
            // InternalMyDsl.g:10135:3: ruleEString
            {
             before(grammarAccess.getAppendRowsAccess().getDescriptionEStringParserRuleCall_3_1_0()); 
            pushFollow(FOLLOW_2);
            ruleEString();

            state._fsp--;

             after(grammarAccess.getAppendRowsAccess().getDescriptionEStringParserRuleCall_3_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AppendRows__DescriptionAssignment_3_1"


    // $ANTLR start "rule__AppendRows__OriginTableAssignment_5"
    // InternalMyDsl.g:10144:1: rule__AppendRows__OriginTableAssignment_5 : ( ( ruleEString ) ) ;
    public final void rule__AppendRows__OriginTableAssignment_5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:10148:1: ( ( ( ruleEString ) ) )
            // InternalMyDsl.g:10149:2: ( ( ruleEString ) )
            {
            // InternalMyDsl.g:10149:2: ( ( ruleEString ) )
            // InternalMyDsl.g:10150:3: ( ruleEString )
            {
             before(grammarAccess.getAppendRowsAccess().getOriginTableTableCrossReference_5_0()); 
            // InternalMyDsl.g:10151:3: ( ruleEString )
            // InternalMyDsl.g:10152:4: ruleEString
            {
             before(grammarAccess.getAppendRowsAccess().getOriginTableTableEStringParserRuleCall_5_0_1()); 
            pushFollow(FOLLOW_2);
            ruleEString();

            state._fsp--;

             after(grammarAccess.getAppendRowsAccess().getOriginTableTableEStringParserRuleCall_5_0_1()); 

            }

             after(grammarAccess.getAppendRowsAccess().getOriginTableTableCrossReference_5_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AppendRows__OriginTableAssignment_5"


    // $ANTLR start "rule__AppendRows__DestinTableAssignment_7"
    // InternalMyDsl.g:10163:1: rule__AppendRows__DestinTableAssignment_7 : ( ( ruleEString ) ) ;
    public final void rule__AppendRows__DestinTableAssignment_7() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:10167:1: ( ( ( ruleEString ) ) )
            // InternalMyDsl.g:10168:2: ( ( ruleEString ) )
            {
            // InternalMyDsl.g:10168:2: ( ( ruleEString ) )
            // InternalMyDsl.g:10169:3: ( ruleEString )
            {
             before(grammarAccess.getAppendRowsAccess().getDestinTableTableCrossReference_7_0()); 
            // InternalMyDsl.g:10170:3: ( ruleEString )
            // InternalMyDsl.g:10171:4: ruleEString
            {
             before(grammarAccess.getAppendRowsAccess().getDestinTableTableEStringParserRuleCall_7_0_1()); 
            pushFollow(FOLLOW_2);
            ruleEString();

            state._fsp--;

             after(grammarAccess.getAppendRowsAccess().getDestinTableTableEStringParserRuleCall_7_0_1()); 

            }

             after(grammarAccess.getAppendRowsAccess().getDestinTableTableCrossReference_7_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AppendRows__DestinTableAssignment_7"


    // $ANTLR start "rule__AppendRows__AssociationsAssignment_10"
    // InternalMyDsl.g:10182:1: rule__AppendRows__AssociationsAssignment_10 : ( ruleAssociation ) ;
    public final void rule__AppendRows__AssociationsAssignment_10() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:10186:1: ( ( ruleAssociation ) )
            // InternalMyDsl.g:10187:2: ( ruleAssociation )
            {
            // InternalMyDsl.g:10187:2: ( ruleAssociation )
            // InternalMyDsl.g:10188:3: ruleAssociation
            {
             before(grammarAccess.getAppendRowsAccess().getAssociationsAssociationParserRuleCall_10_0()); 
            pushFollow(FOLLOW_2);
            ruleAssociation();

            state._fsp--;

             after(grammarAccess.getAppendRowsAccess().getAssociationsAssociationParserRuleCall_10_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AppendRows__AssociationsAssignment_10"


    // $ANTLR start "rule__AppendRows__AssociationsAssignment_11_1"
    // InternalMyDsl.g:10197:1: rule__AppendRows__AssociationsAssignment_11_1 : ( ruleAssociation ) ;
    public final void rule__AppendRows__AssociationsAssignment_11_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:10201:1: ( ( ruleAssociation ) )
            // InternalMyDsl.g:10202:2: ( ruleAssociation )
            {
            // InternalMyDsl.g:10202:2: ( ruleAssociation )
            // InternalMyDsl.g:10203:3: ruleAssociation
            {
             before(grammarAccess.getAppendRowsAccess().getAssociationsAssociationParserRuleCall_11_1_0()); 
            pushFollow(FOLLOW_2);
            ruleAssociation();

            state._fsp--;

             after(grammarAccess.getAppendRowsAccess().getAssociationsAssociationParserRuleCall_11_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AppendRows__AssociationsAssignment_11_1"


    // $ANTLR start "rule__AppendRows__NextAssignment_14"
    // InternalMyDsl.g:10212:1: rule__AppendRows__NextAssignment_14 : ( ( ruleEString ) ) ;
    public final void rule__AppendRows__NextAssignment_14() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:10216:1: ( ( ( ruleEString ) ) )
            // InternalMyDsl.g:10217:2: ( ( ruleEString ) )
            {
            // InternalMyDsl.g:10217:2: ( ( ruleEString ) )
            // InternalMyDsl.g:10218:3: ( ruleEString )
            {
             before(grammarAccess.getAppendRowsAccess().getNextStepCrossReference_14_0()); 
            // InternalMyDsl.g:10219:3: ( ruleEString )
            // InternalMyDsl.g:10220:4: ruleEString
            {
             before(grammarAccess.getAppendRowsAccess().getNextStepEStringParserRuleCall_14_0_1()); 
            pushFollow(FOLLOW_2);
            ruleEString();

            state._fsp--;

             after(grammarAccess.getAppendRowsAccess().getNextStepEStringParserRuleCall_14_0_1()); 

            }

             after(grammarAccess.getAppendRowsAccess().getNextStepCrossReference_14_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AppendRows__NextAssignment_14"


    // $ANTLR start "rule__Filter__NameAssignment_1"
    // InternalMyDsl.g:10231:1: rule__Filter__NameAssignment_1 : ( ruleEString ) ;
    public final void rule__Filter__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:10235:1: ( ( ruleEString ) )
            // InternalMyDsl.g:10236:2: ( ruleEString )
            {
            // InternalMyDsl.g:10236:2: ( ruleEString )
            // InternalMyDsl.g:10237:3: ruleEString
            {
             before(grammarAccess.getFilterAccess().getNameEStringParserRuleCall_1_0()); 
            pushFollow(FOLLOW_2);
            ruleEString();

            state._fsp--;

             after(grammarAccess.getFilterAccess().getNameEStringParserRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Filter__NameAssignment_1"


    // $ANTLR start "rule__Filter__DescriptionAssignment_3_1"
    // InternalMyDsl.g:10246:1: rule__Filter__DescriptionAssignment_3_1 : ( ruleEString ) ;
    public final void rule__Filter__DescriptionAssignment_3_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:10250:1: ( ( ruleEString ) )
            // InternalMyDsl.g:10251:2: ( ruleEString )
            {
            // InternalMyDsl.g:10251:2: ( ruleEString )
            // InternalMyDsl.g:10252:3: ruleEString
            {
             before(grammarAccess.getFilterAccess().getDescriptionEStringParserRuleCall_3_1_0()); 
            pushFollow(FOLLOW_2);
            ruleEString();

            state._fsp--;

             after(grammarAccess.getFilterAccess().getDescriptionEStringParserRuleCall_3_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Filter__DescriptionAssignment_3_1"


    // $ANTLR start "rule__Filter__TableAssignment_5"
    // InternalMyDsl.g:10261:1: rule__Filter__TableAssignment_5 : ( ( ruleEString ) ) ;
    public final void rule__Filter__TableAssignment_5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:10265:1: ( ( ( ruleEString ) ) )
            // InternalMyDsl.g:10266:2: ( ( ruleEString ) )
            {
            // InternalMyDsl.g:10266:2: ( ( ruleEString ) )
            // InternalMyDsl.g:10267:3: ( ruleEString )
            {
             before(grammarAccess.getFilterAccess().getTableTableCrossReference_5_0()); 
            // InternalMyDsl.g:10268:3: ( ruleEString )
            // InternalMyDsl.g:10269:4: ruleEString
            {
             before(grammarAccess.getFilterAccess().getTableTableEStringParserRuleCall_5_0_1()); 
            pushFollow(FOLLOW_2);
            ruleEString();

            state._fsp--;

             after(grammarAccess.getFilterAccess().getTableTableEStringParserRuleCall_5_0_1()); 

            }

             after(grammarAccess.getFilterAccess().getTableTableCrossReference_5_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Filter__TableAssignment_5"


    // $ANTLR start "rule__Filter__ColumnAssignment_7"
    // InternalMyDsl.g:10280:1: rule__Filter__ColumnAssignment_7 : ( ( ruleEString ) ) ;
    public final void rule__Filter__ColumnAssignment_7() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:10284:1: ( ( ( ruleEString ) ) )
            // InternalMyDsl.g:10285:2: ( ( ruleEString ) )
            {
            // InternalMyDsl.g:10285:2: ( ( ruleEString ) )
            // InternalMyDsl.g:10286:3: ( ruleEString )
            {
             before(grammarAccess.getFilterAccess().getColumnColumnCrossReference_7_0()); 
            // InternalMyDsl.g:10287:3: ( ruleEString )
            // InternalMyDsl.g:10288:4: ruleEString
            {
             before(grammarAccess.getFilterAccess().getColumnColumnEStringParserRuleCall_7_0_1()); 
            pushFollow(FOLLOW_2);
            ruleEString();

            state._fsp--;

             after(grammarAccess.getFilterAccess().getColumnColumnEStringParserRuleCall_7_0_1()); 

            }

             after(grammarAccess.getFilterAccess().getColumnColumnCrossReference_7_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Filter__ColumnAssignment_7"


    // $ANTLR start "rule__Filter__OperatorAssignment_9"
    // InternalMyDsl.g:10299:1: rule__Filter__OperatorAssignment_9 : ( ruleFilterOperatorType ) ;
    public final void rule__Filter__OperatorAssignment_9() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:10303:1: ( ( ruleFilterOperatorType ) )
            // InternalMyDsl.g:10304:2: ( ruleFilterOperatorType )
            {
            // InternalMyDsl.g:10304:2: ( ruleFilterOperatorType )
            // InternalMyDsl.g:10305:3: ruleFilterOperatorType
            {
             before(grammarAccess.getFilterAccess().getOperatorFilterOperatorTypeEnumRuleCall_9_0()); 
            pushFollow(FOLLOW_2);
            ruleFilterOperatorType();

            state._fsp--;

             after(grammarAccess.getFilterAccess().getOperatorFilterOperatorTypeEnumRuleCall_9_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Filter__OperatorAssignment_9"


    // $ANTLR start "rule__Filter__OperandAssignment_11"
    // InternalMyDsl.g:10314:1: rule__Filter__OperandAssignment_11 : ( ruleEString ) ;
    public final void rule__Filter__OperandAssignment_11() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:10318:1: ( ( ruleEString ) )
            // InternalMyDsl.g:10319:2: ( ruleEString )
            {
            // InternalMyDsl.g:10319:2: ( ruleEString )
            // InternalMyDsl.g:10320:3: ruleEString
            {
             before(grammarAccess.getFilterAccess().getOperandEStringParserRuleCall_11_0()); 
            pushFollow(FOLLOW_2);
            ruleEString();

            state._fsp--;

             after(grammarAccess.getFilterAccess().getOperandEStringParserRuleCall_11_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Filter__OperandAssignment_11"


    // $ANTLR start "rule__Filter__NextAssignment_13"
    // InternalMyDsl.g:10329:1: rule__Filter__NextAssignment_13 : ( ( ruleEString ) ) ;
    public final void rule__Filter__NextAssignment_13() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:10333:1: ( ( ( ruleEString ) ) )
            // InternalMyDsl.g:10334:2: ( ( ruleEString ) )
            {
            // InternalMyDsl.g:10334:2: ( ( ruleEString ) )
            // InternalMyDsl.g:10335:3: ( ruleEString )
            {
             before(grammarAccess.getFilterAccess().getNextStepCrossReference_13_0()); 
            // InternalMyDsl.g:10336:3: ( ruleEString )
            // InternalMyDsl.g:10337:4: ruleEString
            {
             before(grammarAccess.getFilterAccess().getNextStepEStringParserRuleCall_13_0_1()); 
            pushFollow(FOLLOW_2);
            ruleEString();

            state._fsp--;

             after(grammarAccess.getFilterAccess().getNextStepEStringParserRuleCall_13_0_1()); 

            }

             after(grammarAccess.getFilterAccess().getNextStepCrossReference_13_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Filter__NextAssignment_13"


    // $ANTLR start "rule__GenericStep__NameAssignment_1"
    // InternalMyDsl.g:10348:1: rule__GenericStep__NameAssignment_1 : ( ruleEString ) ;
    public final void rule__GenericStep__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:10352:1: ( ( ruleEString ) )
            // InternalMyDsl.g:10353:2: ( ruleEString )
            {
            // InternalMyDsl.g:10353:2: ( ruleEString )
            // InternalMyDsl.g:10354:3: ruleEString
            {
             before(grammarAccess.getGenericStepAccess().getNameEStringParserRuleCall_1_0()); 
            pushFollow(FOLLOW_2);
            ruleEString();

            state._fsp--;

             after(grammarAccess.getGenericStepAccess().getNameEStringParserRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__GenericStep__NameAssignment_1"


    // $ANTLR start "rule__GenericStep__DescriptionAssignment_3_1"
    // InternalMyDsl.g:10363:1: rule__GenericStep__DescriptionAssignment_3_1 : ( ruleEString ) ;
    public final void rule__GenericStep__DescriptionAssignment_3_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:10367:1: ( ( ruleEString ) )
            // InternalMyDsl.g:10368:2: ( ruleEString )
            {
            // InternalMyDsl.g:10368:2: ( ruleEString )
            // InternalMyDsl.g:10369:3: ruleEString
            {
             before(grammarAccess.getGenericStepAccess().getDescriptionEStringParserRuleCall_3_1_0()); 
            pushFollow(FOLLOW_2);
            ruleEString();

            state._fsp--;

             after(grammarAccess.getGenericStepAccess().getDescriptionEStringParserRuleCall_3_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__GenericStep__DescriptionAssignment_3_1"


    // $ANTLR start "rule__GenericStep__NextAssignment_5"
    // InternalMyDsl.g:10378:1: rule__GenericStep__NextAssignment_5 : ( ( ruleEString ) ) ;
    public final void rule__GenericStep__NextAssignment_5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:10382:1: ( ( ( ruleEString ) ) )
            // InternalMyDsl.g:10383:2: ( ( ruleEString ) )
            {
            // InternalMyDsl.g:10383:2: ( ( ruleEString ) )
            // InternalMyDsl.g:10384:3: ( ruleEString )
            {
             before(grammarAccess.getGenericStepAccess().getNextStepCrossReference_5_0()); 
            // InternalMyDsl.g:10385:3: ( ruleEString )
            // InternalMyDsl.g:10386:4: ruleEString
            {
             before(grammarAccess.getGenericStepAccess().getNextStepEStringParserRuleCall_5_0_1()); 
            pushFollow(FOLLOW_2);
            ruleEString();

            state._fsp--;

             after(grammarAccess.getGenericStepAccess().getNextStepEStringParserRuleCall_5_0_1()); 

            }

             after(grammarAccess.getGenericStepAccess().getNextStepCrossReference_5_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__GenericStep__NextAssignment_5"


    // $ANTLR start "rule__Join__NameAssignment_1"
    // InternalMyDsl.g:10397:1: rule__Join__NameAssignment_1 : ( ruleEString ) ;
    public final void rule__Join__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:10401:1: ( ( ruleEString ) )
            // InternalMyDsl.g:10402:2: ( ruleEString )
            {
            // InternalMyDsl.g:10402:2: ( ruleEString )
            // InternalMyDsl.g:10403:3: ruleEString
            {
             before(grammarAccess.getJoinAccess().getNameEStringParserRuleCall_1_0()); 
            pushFollow(FOLLOW_2);
            ruleEString();

            state._fsp--;

             after(grammarAccess.getJoinAccess().getNameEStringParserRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Join__NameAssignment_1"


    // $ANTLR start "rule__Join__DescriptionAssignment_3_1"
    // InternalMyDsl.g:10412:1: rule__Join__DescriptionAssignment_3_1 : ( ruleEString ) ;
    public final void rule__Join__DescriptionAssignment_3_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:10416:1: ( ( ruleEString ) )
            // InternalMyDsl.g:10417:2: ( ruleEString )
            {
            // InternalMyDsl.g:10417:2: ( ruleEString )
            // InternalMyDsl.g:10418:3: ruleEString
            {
             before(grammarAccess.getJoinAccess().getDescriptionEStringParserRuleCall_3_1_0()); 
            pushFollow(FOLLOW_2);
            ruleEString();

            state._fsp--;

             after(grammarAccess.getJoinAccess().getDescriptionEStringParserRuleCall_3_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Join__DescriptionAssignment_3_1"


    // $ANTLR start "rule__Join__TableLeftAssignment_5"
    // InternalMyDsl.g:10427:1: rule__Join__TableLeftAssignment_5 : ( ( ruleEString ) ) ;
    public final void rule__Join__TableLeftAssignment_5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:10431:1: ( ( ( ruleEString ) ) )
            // InternalMyDsl.g:10432:2: ( ( ruleEString ) )
            {
            // InternalMyDsl.g:10432:2: ( ( ruleEString ) )
            // InternalMyDsl.g:10433:3: ( ruleEString )
            {
             before(grammarAccess.getJoinAccess().getTableLeftTableCrossReference_5_0()); 
            // InternalMyDsl.g:10434:3: ( ruleEString )
            // InternalMyDsl.g:10435:4: ruleEString
            {
             before(grammarAccess.getJoinAccess().getTableLeftTableEStringParserRuleCall_5_0_1()); 
            pushFollow(FOLLOW_2);
            ruleEString();

            state._fsp--;

             after(grammarAccess.getJoinAccess().getTableLeftTableEStringParserRuleCall_5_0_1()); 

            }

             after(grammarAccess.getJoinAccess().getTableLeftTableCrossReference_5_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Join__TableLeftAssignment_5"


    // $ANTLR start "rule__Join__ColumnLeftAssignment_7"
    // InternalMyDsl.g:10446:1: rule__Join__ColumnLeftAssignment_7 : ( ( ruleEString ) ) ;
    public final void rule__Join__ColumnLeftAssignment_7() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:10450:1: ( ( ( ruleEString ) ) )
            // InternalMyDsl.g:10451:2: ( ( ruleEString ) )
            {
            // InternalMyDsl.g:10451:2: ( ( ruleEString ) )
            // InternalMyDsl.g:10452:3: ( ruleEString )
            {
             before(grammarAccess.getJoinAccess().getColumnLeftColumnCrossReference_7_0()); 
            // InternalMyDsl.g:10453:3: ( ruleEString )
            // InternalMyDsl.g:10454:4: ruleEString
            {
             before(grammarAccess.getJoinAccess().getColumnLeftColumnEStringParserRuleCall_7_0_1()); 
            pushFollow(FOLLOW_2);
            ruleEString();

            state._fsp--;

             after(grammarAccess.getJoinAccess().getColumnLeftColumnEStringParserRuleCall_7_0_1()); 

            }

             after(grammarAccess.getJoinAccess().getColumnLeftColumnCrossReference_7_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Join__ColumnLeftAssignment_7"


    // $ANTLR start "rule__Join__TypeAssignment_9"
    // InternalMyDsl.g:10465:1: rule__Join__TypeAssignment_9 : ( ruleJoinType ) ;
    public final void rule__Join__TypeAssignment_9() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:10469:1: ( ( ruleJoinType ) )
            // InternalMyDsl.g:10470:2: ( ruleJoinType )
            {
            // InternalMyDsl.g:10470:2: ( ruleJoinType )
            // InternalMyDsl.g:10471:3: ruleJoinType
            {
             before(grammarAccess.getJoinAccess().getTypeJoinTypeEnumRuleCall_9_0()); 
            pushFollow(FOLLOW_2);
            ruleJoinType();

            state._fsp--;

             after(grammarAccess.getJoinAccess().getTypeJoinTypeEnumRuleCall_9_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Join__TypeAssignment_9"


    // $ANTLR start "rule__Join__TableRightAssignment_11"
    // InternalMyDsl.g:10480:1: rule__Join__TableRightAssignment_11 : ( ( ruleEString ) ) ;
    public final void rule__Join__TableRightAssignment_11() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:10484:1: ( ( ( ruleEString ) ) )
            // InternalMyDsl.g:10485:2: ( ( ruleEString ) )
            {
            // InternalMyDsl.g:10485:2: ( ( ruleEString ) )
            // InternalMyDsl.g:10486:3: ( ruleEString )
            {
             before(grammarAccess.getJoinAccess().getTableRightTableCrossReference_11_0()); 
            // InternalMyDsl.g:10487:3: ( ruleEString )
            // InternalMyDsl.g:10488:4: ruleEString
            {
             before(grammarAccess.getJoinAccess().getTableRightTableEStringParserRuleCall_11_0_1()); 
            pushFollow(FOLLOW_2);
            ruleEString();

            state._fsp--;

             after(grammarAccess.getJoinAccess().getTableRightTableEStringParserRuleCall_11_0_1()); 

            }

             after(grammarAccess.getJoinAccess().getTableRightTableCrossReference_11_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Join__TableRightAssignment_11"


    // $ANTLR start "rule__Join__ColumnRightAssignment_13"
    // InternalMyDsl.g:10499:1: rule__Join__ColumnRightAssignment_13 : ( ( ruleEString ) ) ;
    public final void rule__Join__ColumnRightAssignment_13() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:10503:1: ( ( ( ruleEString ) ) )
            // InternalMyDsl.g:10504:2: ( ( ruleEString ) )
            {
            // InternalMyDsl.g:10504:2: ( ( ruleEString ) )
            // InternalMyDsl.g:10505:3: ( ruleEString )
            {
             before(grammarAccess.getJoinAccess().getColumnRightColumnCrossReference_13_0()); 
            // InternalMyDsl.g:10506:3: ( ruleEString )
            // InternalMyDsl.g:10507:4: ruleEString
            {
             before(grammarAccess.getJoinAccess().getColumnRightColumnEStringParserRuleCall_13_0_1()); 
            pushFollow(FOLLOW_2);
            ruleEString();

            state._fsp--;

             after(grammarAccess.getJoinAccess().getColumnRightColumnEStringParserRuleCall_13_0_1()); 

            }

             after(grammarAccess.getJoinAccess().getColumnRightColumnCrossReference_13_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Join__ColumnRightAssignment_13"


    // $ANTLR start "rule__Join__SelectColumnsAssignment_16"
    // InternalMyDsl.g:10518:1: rule__Join__SelectColumnsAssignment_16 : ( ( ruleEString ) ) ;
    public final void rule__Join__SelectColumnsAssignment_16() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:10522:1: ( ( ( ruleEString ) ) )
            // InternalMyDsl.g:10523:2: ( ( ruleEString ) )
            {
            // InternalMyDsl.g:10523:2: ( ( ruleEString ) )
            // InternalMyDsl.g:10524:3: ( ruleEString )
            {
             before(grammarAccess.getJoinAccess().getSelectColumnsColumnCrossReference_16_0()); 
            // InternalMyDsl.g:10525:3: ( ruleEString )
            // InternalMyDsl.g:10526:4: ruleEString
            {
             before(grammarAccess.getJoinAccess().getSelectColumnsColumnEStringParserRuleCall_16_0_1()); 
            pushFollow(FOLLOW_2);
            ruleEString();

            state._fsp--;

             after(grammarAccess.getJoinAccess().getSelectColumnsColumnEStringParserRuleCall_16_0_1()); 

            }

             after(grammarAccess.getJoinAccess().getSelectColumnsColumnCrossReference_16_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Join__SelectColumnsAssignment_16"


    // $ANTLR start "rule__Join__SelectColumnsAssignment_17_1"
    // InternalMyDsl.g:10537:1: rule__Join__SelectColumnsAssignment_17_1 : ( ( ruleEString ) ) ;
    public final void rule__Join__SelectColumnsAssignment_17_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:10541:1: ( ( ( ruleEString ) ) )
            // InternalMyDsl.g:10542:2: ( ( ruleEString ) )
            {
            // InternalMyDsl.g:10542:2: ( ( ruleEString ) )
            // InternalMyDsl.g:10543:3: ( ruleEString )
            {
             before(grammarAccess.getJoinAccess().getSelectColumnsColumnCrossReference_17_1_0()); 
            // InternalMyDsl.g:10544:3: ( ruleEString )
            // InternalMyDsl.g:10545:4: ruleEString
            {
             before(grammarAccess.getJoinAccess().getSelectColumnsColumnEStringParserRuleCall_17_1_0_1()); 
            pushFollow(FOLLOW_2);
            ruleEString();

            state._fsp--;

             after(grammarAccess.getJoinAccess().getSelectColumnsColumnEStringParserRuleCall_17_1_0_1()); 

            }

             after(grammarAccess.getJoinAccess().getSelectColumnsColumnCrossReference_17_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Join__SelectColumnsAssignment_17_1"


    // $ANTLR start "rule__Join__ResultTableAssignment_20"
    // InternalMyDsl.g:10556:1: rule__Join__ResultTableAssignment_20 : ( ( ruleEString ) ) ;
    public final void rule__Join__ResultTableAssignment_20() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:10560:1: ( ( ( ruleEString ) ) )
            // InternalMyDsl.g:10561:2: ( ( ruleEString ) )
            {
            // InternalMyDsl.g:10561:2: ( ( ruleEString ) )
            // InternalMyDsl.g:10562:3: ( ruleEString )
            {
             before(grammarAccess.getJoinAccess().getResultTableTableCrossReference_20_0()); 
            // InternalMyDsl.g:10563:3: ( ruleEString )
            // InternalMyDsl.g:10564:4: ruleEString
            {
             before(grammarAccess.getJoinAccess().getResultTableTableEStringParserRuleCall_20_0_1()); 
            pushFollow(FOLLOW_2);
            ruleEString();

            state._fsp--;

             after(grammarAccess.getJoinAccess().getResultTableTableEStringParserRuleCall_20_0_1()); 

            }

             after(grammarAccess.getJoinAccess().getResultTableTableCrossReference_20_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Join__ResultTableAssignment_20"


    // $ANTLR start "rule__Join__NextAssignment_22"
    // InternalMyDsl.g:10575:1: rule__Join__NextAssignment_22 : ( ( ruleEString ) ) ;
    public final void rule__Join__NextAssignment_22() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:10579:1: ( ( ( ruleEString ) ) )
            // InternalMyDsl.g:10580:2: ( ( ruleEString ) )
            {
            // InternalMyDsl.g:10580:2: ( ( ruleEString ) )
            // InternalMyDsl.g:10581:3: ( ruleEString )
            {
             before(grammarAccess.getJoinAccess().getNextStepCrossReference_22_0()); 
            // InternalMyDsl.g:10582:3: ( ruleEString )
            // InternalMyDsl.g:10583:4: ruleEString
            {
             before(grammarAccess.getJoinAccess().getNextStepEStringParserRuleCall_22_0_1()); 
            pushFollow(FOLLOW_2);
            ruleEString();

            state._fsp--;

             after(grammarAccess.getJoinAccess().getNextStepEStringParserRuleCall_22_0_1()); 

            }

             after(grammarAccess.getJoinAccess().getNextStepCrossReference_22_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Join__NextAssignment_22"


    // $ANTLR start "rule__Import__NameAssignment_1"
    // InternalMyDsl.g:10594:1: rule__Import__NameAssignment_1 : ( ruleEString ) ;
    public final void rule__Import__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:10598:1: ( ( ruleEString ) )
            // InternalMyDsl.g:10599:2: ( ruleEString )
            {
            // InternalMyDsl.g:10599:2: ( ruleEString )
            // InternalMyDsl.g:10600:3: ruleEString
            {
             before(grammarAccess.getImportAccess().getNameEStringParserRuleCall_1_0()); 
            pushFollow(FOLLOW_2);
            ruleEString();

            state._fsp--;

             after(grammarAccess.getImportAccess().getNameEStringParserRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Import__NameAssignment_1"


    // $ANTLR start "rule__Import__DescriptionAssignment_3_1"
    // InternalMyDsl.g:10609:1: rule__Import__DescriptionAssignment_3_1 : ( ruleEString ) ;
    public final void rule__Import__DescriptionAssignment_3_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:10613:1: ( ( ruleEString ) )
            // InternalMyDsl.g:10614:2: ( ruleEString )
            {
            // InternalMyDsl.g:10614:2: ( ruleEString )
            // InternalMyDsl.g:10615:3: ruleEString
            {
             before(grammarAccess.getImportAccess().getDescriptionEStringParserRuleCall_3_1_0()); 
            pushFollow(FOLLOW_2);
            ruleEString();

            state._fsp--;

             after(grammarAccess.getImportAccess().getDescriptionEStringParserRuleCall_3_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Import__DescriptionAssignment_3_1"


    // $ANTLR start "rule__Import__TablesToImportAssignment_6"
    // InternalMyDsl.g:10624:1: rule__Import__TablesToImportAssignment_6 : ( ruleTableToImport ) ;
    public final void rule__Import__TablesToImportAssignment_6() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:10628:1: ( ( ruleTableToImport ) )
            // InternalMyDsl.g:10629:2: ( ruleTableToImport )
            {
            // InternalMyDsl.g:10629:2: ( ruleTableToImport )
            // InternalMyDsl.g:10630:3: ruleTableToImport
            {
             before(grammarAccess.getImportAccess().getTablesToImportTableToImportParserRuleCall_6_0()); 
            pushFollow(FOLLOW_2);
            ruleTableToImport();

            state._fsp--;

             after(grammarAccess.getImportAccess().getTablesToImportTableToImportParserRuleCall_6_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Import__TablesToImportAssignment_6"


    // $ANTLR start "rule__Import__TablesToImportAssignment_7_1"
    // InternalMyDsl.g:10639:1: rule__Import__TablesToImportAssignment_7_1 : ( ruleTableToImport ) ;
    public final void rule__Import__TablesToImportAssignment_7_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:10643:1: ( ( ruleTableToImport ) )
            // InternalMyDsl.g:10644:2: ( ruleTableToImport )
            {
            // InternalMyDsl.g:10644:2: ( ruleTableToImport )
            // InternalMyDsl.g:10645:3: ruleTableToImport
            {
             before(grammarAccess.getImportAccess().getTablesToImportTableToImportParserRuleCall_7_1_0()); 
            pushFollow(FOLLOW_2);
            ruleTableToImport();

            state._fsp--;

             after(grammarAccess.getImportAccess().getTablesToImportTableToImportParserRuleCall_7_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Import__TablesToImportAssignment_7_1"


    // $ANTLR start "rule__Import__NextAssignment_10"
    // InternalMyDsl.g:10654:1: rule__Import__NextAssignment_10 : ( ( ruleEString ) ) ;
    public final void rule__Import__NextAssignment_10() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:10658:1: ( ( ( ruleEString ) ) )
            // InternalMyDsl.g:10659:2: ( ( ruleEString ) )
            {
            // InternalMyDsl.g:10659:2: ( ( ruleEString ) )
            // InternalMyDsl.g:10660:3: ( ruleEString )
            {
             before(grammarAccess.getImportAccess().getNextStepCrossReference_10_0()); 
            // InternalMyDsl.g:10661:3: ( ruleEString )
            // InternalMyDsl.g:10662:4: ruleEString
            {
             before(grammarAccess.getImportAccess().getNextStepEStringParserRuleCall_10_0_1()); 
            pushFollow(FOLLOW_2);
            ruleEString();

            state._fsp--;

             after(grammarAccess.getImportAccess().getNextStepEStringParserRuleCall_10_0_1()); 

            }

             after(grammarAccess.getImportAccess().getNextStepCrossReference_10_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Import__NextAssignment_10"


    // $ANTLR start "rule__Lookup__NameAssignment_1"
    // InternalMyDsl.g:10673:1: rule__Lookup__NameAssignment_1 : ( ruleEString ) ;
    public final void rule__Lookup__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:10677:1: ( ( ruleEString ) )
            // InternalMyDsl.g:10678:2: ( ruleEString )
            {
            // InternalMyDsl.g:10678:2: ( ruleEString )
            // InternalMyDsl.g:10679:3: ruleEString
            {
             before(grammarAccess.getLookupAccess().getNameEStringParserRuleCall_1_0()); 
            pushFollow(FOLLOW_2);
            ruleEString();

            state._fsp--;

             after(grammarAccess.getLookupAccess().getNameEStringParserRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Lookup__NameAssignment_1"


    // $ANTLR start "rule__Lookup__DescriptionAssignment_3_1"
    // InternalMyDsl.g:10688:1: rule__Lookup__DescriptionAssignment_3_1 : ( ruleEString ) ;
    public final void rule__Lookup__DescriptionAssignment_3_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:10692:1: ( ( ruleEString ) )
            // InternalMyDsl.g:10693:2: ( ruleEString )
            {
            // InternalMyDsl.g:10693:2: ( ruleEString )
            // InternalMyDsl.g:10694:3: ruleEString
            {
             before(grammarAccess.getLookupAccess().getDescriptionEStringParserRuleCall_3_1_0()); 
            pushFollow(FOLLOW_2);
            ruleEString();

            state._fsp--;

             after(grammarAccess.getLookupAccess().getDescriptionEStringParserRuleCall_3_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Lookup__DescriptionAssignment_3_1"


    // $ANTLR start "rule__Lookup__TableAssignment_5"
    // InternalMyDsl.g:10703:1: rule__Lookup__TableAssignment_5 : ( ( ruleEString ) ) ;
    public final void rule__Lookup__TableAssignment_5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:10707:1: ( ( ( ruleEString ) ) )
            // InternalMyDsl.g:10708:2: ( ( ruleEString ) )
            {
            // InternalMyDsl.g:10708:2: ( ( ruleEString ) )
            // InternalMyDsl.g:10709:3: ( ruleEString )
            {
             before(grammarAccess.getLookupAccess().getTableTableCrossReference_5_0()); 
            // InternalMyDsl.g:10710:3: ( ruleEString )
            // InternalMyDsl.g:10711:4: ruleEString
            {
             before(grammarAccess.getLookupAccess().getTableTableEStringParserRuleCall_5_0_1()); 
            pushFollow(FOLLOW_2);
            ruleEString();

            state._fsp--;

             after(grammarAccess.getLookupAccess().getTableTableEStringParserRuleCall_5_0_1()); 

            }

             after(grammarAccess.getLookupAccess().getTableTableCrossReference_5_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Lookup__TableAssignment_5"


    // $ANTLR start "rule__Lookup__ColumnAssignment_7"
    // InternalMyDsl.g:10722:1: rule__Lookup__ColumnAssignment_7 : ( ( ruleEString ) ) ;
    public final void rule__Lookup__ColumnAssignment_7() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:10726:1: ( ( ( ruleEString ) ) )
            // InternalMyDsl.g:10727:2: ( ( ruleEString ) )
            {
            // InternalMyDsl.g:10727:2: ( ( ruleEString ) )
            // InternalMyDsl.g:10728:3: ( ruleEString )
            {
             before(grammarAccess.getLookupAccess().getColumnColumnCrossReference_7_0()); 
            // InternalMyDsl.g:10729:3: ( ruleEString )
            // InternalMyDsl.g:10730:4: ruleEString
            {
             before(grammarAccess.getLookupAccess().getColumnColumnEStringParserRuleCall_7_0_1()); 
            pushFollow(FOLLOW_2);
            ruleEString();

            state._fsp--;

             after(grammarAccess.getLookupAccess().getColumnColumnEStringParserRuleCall_7_0_1()); 

            }

             after(grammarAccess.getLookupAccess().getColumnColumnCrossReference_7_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Lookup__ColumnAssignment_7"


    // $ANTLR start "rule__Lookup__LookupTableAssignment_9"
    // InternalMyDsl.g:10741:1: rule__Lookup__LookupTableAssignment_9 : ( ( ruleEString ) ) ;
    public final void rule__Lookup__LookupTableAssignment_9() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:10745:1: ( ( ( ruleEString ) ) )
            // InternalMyDsl.g:10746:2: ( ( ruleEString ) )
            {
            // InternalMyDsl.g:10746:2: ( ( ruleEString ) )
            // InternalMyDsl.g:10747:3: ( ruleEString )
            {
             before(grammarAccess.getLookupAccess().getLookupTableTableCrossReference_9_0()); 
            // InternalMyDsl.g:10748:3: ( ruleEString )
            // InternalMyDsl.g:10749:4: ruleEString
            {
             before(grammarAccess.getLookupAccess().getLookupTableTableEStringParserRuleCall_9_0_1()); 
            pushFollow(FOLLOW_2);
            ruleEString();

            state._fsp--;

             after(grammarAccess.getLookupAccess().getLookupTableTableEStringParserRuleCall_9_0_1()); 

            }

             after(grammarAccess.getLookupAccess().getLookupTableTableCrossReference_9_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Lookup__LookupTableAssignment_9"


    // $ANTLR start "rule__Lookup__MatchColumnAssignment_11"
    // InternalMyDsl.g:10760:1: rule__Lookup__MatchColumnAssignment_11 : ( ( ruleEString ) ) ;
    public final void rule__Lookup__MatchColumnAssignment_11() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:10764:1: ( ( ( ruleEString ) ) )
            // InternalMyDsl.g:10765:2: ( ( ruleEString ) )
            {
            // InternalMyDsl.g:10765:2: ( ( ruleEString ) )
            // InternalMyDsl.g:10766:3: ( ruleEString )
            {
             before(grammarAccess.getLookupAccess().getMatchColumnColumnCrossReference_11_0()); 
            // InternalMyDsl.g:10767:3: ( ruleEString )
            // InternalMyDsl.g:10768:4: ruleEString
            {
             before(grammarAccess.getLookupAccess().getMatchColumnColumnEStringParserRuleCall_11_0_1()); 
            pushFollow(FOLLOW_2);
            ruleEString();

            state._fsp--;

             after(grammarAccess.getLookupAccess().getMatchColumnColumnEStringParserRuleCall_11_0_1()); 

            }

             after(grammarAccess.getLookupAccess().getMatchColumnColumnCrossReference_11_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Lookup__MatchColumnAssignment_11"


    // $ANTLR start "rule__Lookup__OperandColumnAssignment_13"
    // InternalMyDsl.g:10779:1: rule__Lookup__OperandColumnAssignment_13 : ( ( ruleEString ) ) ;
    public final void rule__Lookup__OperandColumnAssignment_13() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:10783:1: ( ( ( ruleEString ) ) )
            // InternalMyDsl.g:10784:2: ( ( ruleEString ) )
            {
            // InternalMyDsl.g:10784:2: ( ( ruleEString ) )
            // InternalMyDsl.g:10785:3: ( ruleEString )
            {
             before(grammarAccess.getLookupAccess().getOperandColumnColumnCrossReference_13_0()); 
            // InternalMyDsl.g:10786:3: ( ruleEString )
            // InternalMyDsl.g:10787:4: ruleEString
            {
             before(grammarAccess.getLookupAccess().getOperandColumnColumnEStringParserRuleCall_13_0_1()); 
            pushFollow(FOLLOW_2);
            ruleEString();

            state._fsp--;

             after(grammarAccess.getLookupAccess().getOperandColumnColumnEStringParserRuleCall_13_0_1()); 

            }

             after(grammarAccess.getLookupAccess().getOperandColumnColumnCrossReference_13_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Lookup__OperandColumnAssignment_13"


    // $ANTLR start "rule__Lookup__LookupColumnAssignment_15"
    // InternalMyDsl.g:10798:1: rule__Lookup__LookupColumnAssignment_15 : ( ( ruleEString ) ) ;
    public final void rule__Lookup__LookupColumnAssignment_15() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:10802:1: ( ( ( ruleEString ) ) )
            // InternalMyDsl.g:10803:2: ( ( ruleEString ) )
            {
            // InternalMyDsl.g:10803:2: ( ( ruleEString ) )
            // InternalMyDsl.g:10804:3: ( ruleEString )
            {
             before(grammarAccess.getLookupAccess().getLookupColumnColumnCrossReference_15_0()); 
            // InternalMyDsl.g:10805:3: ( ruleEString )
            // InternalMyDsl.g:10806:4: ruleEString
            {
             before(grammarAccess.getLookupAccess().getLookupColumnColumnEStringParserRuleCall_15_0_1()); 
            pushFollow(FOLLOW_2);
            ruleEString();

            state._fsp--;

             after(grammarAccess.getLookupAccess().getLookupColumnColumnEStringParserRuleCall_15_0_1()); 

            }

             after(grammarAccess.getLookupAccess().getLookupColumnColumnCrossReference_15_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Lookup__LookupColumnAssignment_15"


    // $ANTLR start "rule__Lookup__OperationAssignment_17"
    // InternalMyDsl.g:10817:1: rule__Lookup__OperationAssignment_17 : ( ruleLookupOperationType ) ;
    public final void rule__Lookup__OperationAssignment_17() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:10821:1: ( ( ruleLookupOperationType ) )
            // InternalMyDsl.g:10822:2: ( ruleLookupOperationType )
            {
            // InternalMyDsl.g:10822:2: ( ruleLookupOperationType )
            // InternalMyDsl.g:10823:3: ruleLookupOperationType
            {
             before(grammarAccess.getLookupAccess().getOperationLookupOperationTypeEnumRuleCall_17_0()); 
            pushFollow(FOLLOW_2);
            ruleLookupOperationType();

            state._fsp--;

             after(grammarAccess.getLookupAccess().getOperationLookupOperationTypeEnumRuleCall_17_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Lookup__OperationAssignment_17"


    // $ANTLR start "rule__Lookup__ResultTableAssignment_19"
    // InternalMyDsl.g:10832:1: rule__Lookup__ResultTableAssignment_19 : ( ( ruleEString ) ) ;
    public final void rule__Lookup__ResultTableAssignment_19() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:10836:1: ( ( ( ruleEString ) ) )
            // InternalMyDsl.g:10837:2: ( ( ruleEString ) )
            {
            // InternalMyDsl.g:10837:2: ( ( ruleEString ) )
            // InternalMyDsl.g:10838:3: ( ruleEString )
            {
             before(grammarAccess.getLookupAccess().getResultTableTableCrossReference_19_0()); 
            // InternalMyDsl.g:10839:3: ( ruleEString )
            // InternalMyDsl.g:10840:4: ruleEString
            {
             before(grammarAccess.getLookupAccess().getResultTableTableEStringParserRuleCall_19_0_1()); 
            pushFollow(FOLLOW_2);
            ruleEString();

            state._fsp--;

             after(grammarAccess.getLookupAccess().getResultTableTableEStringParserRuleCall_19_0_1()); 

            }

             after(grammarAccess.getLookupAccess().getResultTableTableCrossReference_19_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Lookup__ResultTableAssignment_19"


    // $ANTLR start "rule__Lookup__ResultColumnAssignment_21"
    // InternalMyDsl.g:10851:1: rule__Lookup__ResultColumnAssignment_21 : ( ( ruleEString ) ) ;
    public final void rule__Lookup__ResultColumnAssignment_21() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:10855:1: ( ( ( ruleEString ) ) )
            // InternalMyDsl.g:10856:2: ( ( ruleEString ) )
            {
            // InternalMyDsl.g:10856:2: ( ( ruleEString ) )
            // InternalMyDsl.g:10857:3: ( ruleEString )
            {
             before(grammarAccess.getLookupAccess().getResultColumnColumnCrossReference_21_0()); 
            // InternalMyDsl.g:10858:3: ( ruleEString )
            // InternalMyDsl.g:10859:4: ruleEString
            {
             before(grammarAccess.getLookupAccess().getResultColumnColumnEStringParserRuleCall_21_0_1()); 
            pushFollow(FOLLOW_2);
            ruleEString();

            state._fsp--;

             after(grammarAccess.getLookupAccess().getResultColumnColumnEStringParserRuleCall_21_0_1()); 

            }

             after(grammarAccess.getLookupAccess().getResultColumnColumnCrossReference_21_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Lookup__ResultColumnAssignment_21"


    // $ANTLR start "rule__Lookup__NextAssignment_23"
    // InternalMyDsl.g:10870:1: rule__Lookup__NextAssignment_23 : ( ( ruleEString ) ) ;
    public final void rule__Lookup__NextAssignment_23() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:10874:1: ( ( ( ruleEString ) ) )
            // InternalMyDsl.g:10875:2: ( ( ruleEString ) )
            {
            // InternalMyDsl.g:10875:2: ( ( ruleEString ) )
            // InternalMyDsl.g:10876:3: ( ruleEString )
            {
             before(grammarAccess.getLookupAccess().getNextStepCrossReference_23_0()); 
            // InternalMyDsl.g:10877:3: ( ruleEString )
            // InternalMyDsl.g:10878:4: ruleEString
            {
             before(grammarAccess.getLookupAccess().getNextStepEStringParserRuleCall_23_0_1()); 
            pushFollow(FOLLOW_2);
            ruleEString();

            state._fsp--;

             after(grammarAccess.getLookupAccess().getNextStepEStringParserRuleCall_23_0_1()); 

            }

             after(grammarAccess.getLookupAccess().getNextStepCrossReference_23_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Lookup__NextAssignment_23"


    // $ANTLR start "rule__RemoveDuplicates__NameAssignment_1"
    // InternalMyDsl.g:10889:1: rule__RemoveDuplicates__NameAssignment_1 : ( ruleEString ) ;
    public final void rule__RemoveDuplicates__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:10893:1: ( ( ruleEString ) )
            // InternalMyDsl.g:10894:2: ( ruleEString )
            {
            // InternalMyDsl.g:10894:2: ( ruleEString )
            // InternalMyDsl.g:10895:3: ruleEString
            {
             before(grammarAccess.getRemoveDuplicatesAccess().getNameEStringParserRuleCall_1_0()); 
            pushFollow(FOLLOW_2);
            ruleEString();

            state._fsp--;

             after(grammarAccess.getRemoveDuplicatesAccess().getNameEStringParserRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RemoveDuplicates__NameAssignment_1"


    // $ANTLR start "rule__RemoveDuplicates__DescriptionAssignment_3_1"
    // InternalMyDsl.g:10904:1: rule__RemoveDuplicates__DescriptionAssignment_3_1 : ( ruleEString ) ;
    public final void rule__RemoveDuplicates__DescriptionAssignment_3_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:10908:1: ( ( ruleEString ) )
            // InternalMyDsl.g:10909:2: ( ruleEString )
            {
            // InternalMyDsl.g:10909:2: ( ruleEString )
            // InternalMyDsl.g:10910:3: ruleEString
            {
             before(grammarAccess.getRemoveDuplicatesAccess().getDescriptionEStringParserRuleCall_3_1_0()); 
            pushFollow(FOLLOW_2);
            ruleEString();

            state._fsp--;

             after(grammarAccess.getRemoveDuplicatesAccess().getDescriptionEStringParserRuleCall_3_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RemoveDuplicates__DescriptionAssignment_3_1"


    // $ANTLR start "rule__RemoveDuplicates__TableAssignment_5"
    // InternalMyDsl.g:10919:1: rule__RemoveDuplicates__TableAssignment_5 : ( ( ruleEString ) ) ;
    public final void rule__RemoveDuplicates__TableAssignment_5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:10923:1: ( ( ( ruleEString ) ) )
            // InternalMyDsl.g:10924:2: ( ( ruleEString ) )
            {
            // InternalMyDsl.g:10924:2: ( ( ruleEString ) )
            // InternalMyDsl.g:10925:3: ( ruleEString )
            {
             before(grammarAccess.getRemoveDuplicatesAccess().getTableTableCrossReference_5_0()); 
            // InternalMyDsl.g:10926:3: ( ruleEString )
            // InternalMyDsl.g:10927:4: ruleEString
            {
             before(grammarAccess.getRemoveDuplicatesAccess().getTableTableEStringParserRuleCall_5_0_1()); 
            pushFollow(FOLLOW_2);
            ruleEString();

            state._fsp--;

             after(grammarAccess.getRemoveDuplicatesAccess().getTableTableEStringParserRuleCall_5_0_1()); 

            }

             after(grammarAccess.getRemoveDuplicatesAccess().getTableTableCrossReference_5_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RemoveDuplicates__TableAssignment_5"


    // $ANTLR start "rule__RemoveDuplicates__ColumnAssignment_7"
    // InternalMyDsl.g:10938:1: rule__RemoveDuplicates__ColumnAssignment_7 : ( ( ruleEString ) ) ;
    public final void rule__RemoveDuplicates__ColumnAssignment_7() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:10942:1: ( ( ( ruleEString ) ) )
            // InternalMyDsl.g:10943:2: ( ( ruleEString ) )
            {
            // InternalMyDsl.g:10943:2: ( ( ruleEString ) )
            // InternalMyDsl.g:10944:3: ( ruleEString )
            {
             before(grammarAccess.getRemoveDuplicatesAccess().getColumnColumnCrossReference_7_0()); 
            // InternalMyDsl.g:10945:3: ( ruleEString )
            // InternalMyDsl.g:10946:4: ruleEString
            {
             before(grammarAccess.getRemoveDuplicatesAccess().getColumnColumnEStringParserRuleCall_7_0_1()); 
            pushFollow(FOLLOW_2);
            ruleEString();

            state._fsp--;

             after(grammarAccess.getRemoveDuplicatesAccess().getColumnColumnEStringParserRuleCall_7_0_1()); 

            }

             after(grammarAccess.getRemoveDuplicatesAccess().getColumnColumnCrossReference_7_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RemoveDuplicates__ColumnAssignment_7"


    // $ANTLR start "rule__RemoveDuplicates__NextAssignment_9"
    // InternalMyDsl.g:10957:1: rule__RemoveDuplicates__NextAssignment_9 : ( ( ruleEString ) ) ;
    public final void rule__RemoveDuplicates__NextAssignment_9() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:10961:1: ( ( ( ruleEString ) ) )
            // InternalMyDsl.g:10962:2: ( ( ruleEString ) )
            {
            // InternalMyDsl.g:10962:2: ( ( ruleEString ) )
            // InternalMyDsl.g:10963:3: ( ruleEString )
            {
             before(grammarAccess.getRemoveDuplicatesAccess().getNextStepCrossReference_9_0()); 
            // InternalMyDsl.g:10964:3: ( ruleEString )
            // InternalMyDsl.g:10965:4: ruleEString
            {
             before(grammarAccess.getRemoveDuplicatesAccess().getNextStepEStringParserRuleCall_9_0_1()); 
            pushFollow(FOLLOW_2);
            ruleEString();

            state._fsp--;

             after(grammarAccess.getRemoveDuplicatesAccess().getNextStepEStringParserRuleCall_9_0_1()); 

            }

             after(grammarAccess.getRemoveDuplicatesAccess().getNextStepCrossReference_9_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RemoveDuplicates__NextAssignment_9"


    // $ANTLR start "rule__Concat__NameAssignment_1"
    // InternalMyDsl.g:10976:1: rule__Concat__NameAssignment_1 : ( ruleEString ) ;
    public final void rule__Concat__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:10980:1: ( ( ruleEString ) )
            // InternalMyDsl.g:10981:2: ( ruleEString )
            {
            // InternalMyDsl.g:10981:2: ( ruleEString )
            // InternalMyDsl.g:10982:3: ruleEString
            {
             before(grammarAccess.getConcatAccess().getNameEStringParserRuleCall_1_0()); 
            pushFollow(FOLLOW_2);
            ruleEString();

            state._fsp--;

             after(grammarAccess.getConcatAccess().getNameEStringParserRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Concat__NameAssignment_1"


    // $ANTLR start "rule__Concat__DescriptionAssignment_3_1"
    // InternalMyDsl.g:10991:1: rule__Concat__DescriptionAssignment_3_1 : ( ruleEString ) ;
    public final void rule__Concat__DescriptionAssignment_3_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:10995:1: ( ( ruleEString ) )
            // InternalMyDsl.g:10996:2: ( ruleEString )
            {
            // InternalMyDsl.g:10996:2: ( ruleEString )
            // InternalMyDsl.g:10997:3: ruleEString
            {
             before(grammarAccess.getConcatAccess().getDescriptionEStringParserRuleCall_3_1_0()); 
            pushFollow(FOLLOW_2);
            ruleEString();

            state._fsp--;

             after(grammarAccess.getConcatAccess().getDescriptionEStringParserRuleCall_3_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Concat__DescriptionAssignment_3_1"


    // $ANTLR start "rule__Concat__TableAssignment_5"
    // InternalMyDsl.g:11006:1: rule__Concat__TableAssignment_5 : ( ( ruleEString ) ) ;
    public final void rule__Concat__TableAssignment_5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:11010:1: ( ( ( ruleEString ) ) )
            // InternalMyDsl.g:11011:2: ( ( ruleEString ) )
            {
            // InternalMyDsl.g:11011:2: ( ( ruleEString ) )
            // InternalMyDsl.g:11012:3: ( ruleEString )
            {
             before(grammarAccess.getConcatAccess().getTableTableCrossReference_5_0()); 
            // InternalMyDsl.g:11013:3: ( ruleEString )
            // InternalMyDsl.g:11014:4: ruleEString
            {
             before(grammarAccess.getConcatAccess().getTableTableEStringParserRuleCall_5_0_1()); 
            pushFollow(FOLLOW_2);
            ruleEString();

            state._fsp--;

             after(grammarAccess.getConcatAccess().getTableTableEStringParserRuleCall_5_0_1()); 

            }

             after(grammarAccess.getConcatAccess().getTableTableCrossReference_5_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Concat__TableAssignment_5"


    // $ANTLR start "rule__Concat__SourceAAssignment_7"
    // InternalMyDsl.g:11025:1: rule__Concat__SourceAAssignment_7 : ( ( ruleEString ) ) ;
    public final void rule__Concat__SourceAAssignment_7() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:11029:1: ( ( ( ruleEString ) ) )
            // InternalMyDsl.g:11030:2: ( ( ruleEString ) )
            {
            // InternalMyDsl.g:11030:2: ( ( ruleEString ) )
            // InternalMyDsl.g:11031:3: ( ruleEString )
            {
             before(grammarAccess.getConcatAccess().getSourceAColumnCrossReference_7_0()); 
            // InternalMyDsl.g:11032:3: ( ruleEString )
            // InternalMyDsl.g:11033:4: ruleEString
            {
             before(grammarAccess.getConcatAccess().getSourceAColumnEStringParserRuleCall_7_0_1()); 
            pushFollow(FOLLOW_2);
            ruleEString();

            state._fsp--;

             after(grammarAccess.getConcatAccess().getSourceAColumnEStringParserRuleCall_7_0_1()); 

            }

             after(grammarAccess.getConcatAccess().getSourceAColumnCrossReference_7_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Concat__SourceAAssignment_7"


    // $ANTLR start "rule__Concat__SourceBAssignment_9"
    // InternalMyDsl.g:11044:1: rule__Concat__SourceBAssignment_9 : ( ( ruleEString ) ) ;
    public final void rule__Concat__SourceBAssignment_9() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:11048:1: ( ( ( ruleEString ) ) )
            // InternalMyDsl.g:11049:2: ( ( ruleEString ) )
            {
            // InternalMyDsl.g:11049:2: ( ( ruleEString ) )
            // InternalMyDsl.g:11050:3: ( ruleEString )
            {
             before(grammarAccess.getConcatAccess().getSourceBColumnCrossReference_9_0()); 
            // InternalMyDsl.g:11051:3: ( ruleEString )
            // InternalMyDsl.g:11052:4: ruleEString
            {
             before(grammarAccess.getConcatAccess().getSourceBColumnEStringParserRuleCall_9_0_1()); 
            pushFollow(FOLLOW_2);
            ruleEString();

            state._fsp--;

             after(grammarAccess.getConcatAccess().getSourceBColumnEStringParserRuleCall_9_0_1()); 

            }

             after(grammarAccess.getConcatAccess().getSourceBColumnCrossReference_9_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Concat__SourceBAssignment_9"


    // $ANTLR start "rule__Concat__ResultColumnAssignment_11"
    // InternalMyDsl.g:11063:1: rule__Concat__ResultColumnAssignment_11 : ( ( ruleEString ) ) ;
    public final void rule__Concat__ResultColumnAssignment_11() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:11067:1: ( ( ( ruleEString ) ) )
            // InternalMyDsl.g:11068:2: ( ( ruleEString ) )
            {
            // InternalMyDsl.g:11068:2: ( ( ruleEString ) )
            // InternalMyDsl.g:11069:3: ( ruleEString )
            {
             before(grammarAccess.getConcatAccess().getResultColumnColumnCrossReference_11_0()); 
            // InternalMyDsl.g:11070:3: ( ruleEString )
            // InternalMyDsl.g:11071:4: ruleEString
            {
             before(grammarAccess.getConcatAccess().getResultColumnColumnEStringParserRuleCall_11_0_1()); 
            pushFollow(FOLLOW_2);
            ruleEString();

            state._fsp--;

             after(grammarAccess.getConcatAccess().getResultColumnColumnEStringParserRuleCall_11_0_1()); 

            }

             after(grammarAccess.getConcatAccess().getResultColumnColumnCrossReference_11_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Concat__ResultColumnAssignment_11"


    // $ANTLR start "rule__Concat__ResultTableAssignment_13"
    // InternalMyDsl.g:11082:1: rule__Concat__ResultTableAssignment_13 : ( ( ruleEString ) ) ;
    public final void rule__Concat__ResultTableAssignment_13() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:11086:1: ( ( ( ruleEString ) ) )
            // InternalMyDsl.g:11087:2: ( ( ruleEString ) )
            {
            // InternalMyDsl.g:11087:2: ( ( ruleEString ) )
            // InternalMyDsl.g:11088:3: ( ruleEString )
            {
             before(grammarAccess.getConcatAccess().getResultTableTableCrossReference_13_0()); 
            // InternalMyDsl.g:11089:3: ( ruleEString )
            // InternalMyDsl.g:11090:4: ruleEString
            {
             before(grammarAccess.getConcatAccess().getResultTableTableEStringParserRuleCall_13_0_1()); 
            pushFollow(FOLLOW_2);
            ruleEString();

            state._fsp--;

             after(grammarAccess.getConcatAccess().getResultTableTableEStringParserRuleCall_13_0_1()); 

            }

             after(grammarAccess.getConcatAccess().getResultTableTableCrossReference_13_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Concat__ResultTableAssignment_13"


    // $ANTLR start "rule__Concat__NextAssignment_15"
    // InternalMyDsl.g:11101:1: rule__Concat__NextAssignment_15 : ( ( ruleEString ) ) ;
    public final void rule__Concat__NextAssignment_15() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:11105:1: ( ( ( ruleEString ) ) )
            // InternalMyDsl.g:11106:2: ( ( ruleEString ) )
            {
            // InternalMyDsl.g:11106:2: ( ( ruleEString ) )
            // InternalMyDsl.g:11107:3: ( ruleEString )
            {
             before(grammarAccess.getConcatAccess().getNextStepCrossReference_15_0()); 
            // InternalMyDsl.g:11108:3: ( ruleEString )
            // InternalMyDsl.g:11109:4: ruleEString
            {
             before(grammarAccess.getConcatAccess().getNextStepEStringParserRuleCall_15_0_1()); 
            pushFollow(FOLLOW_2);
            ruleEString();

            state._fsp--;

             after(grammarAccess.getConcatAccess().getNextStepEStringParserRuleCall_15_0_1()); 

            }

             after(grammarAccess.getConcatAccess().getNextStepCrossReference_15_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Concat__NextAssignment_15"


    // $ANTLR start "rule__Split__NameAssignment_1"
    // InternalMyDsl.g:11120:1: rule__Split__NameAssignment_1 : ( ruleEString ) ;
    public final void rule__Split__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:11124:1: ( ( ruleEString ) )
            // InternalMyDsl.g:11125:2: ( ruleEString )
            {
            // InternalMyDsl.g:11125:2: ( ruleEString )
            // InternalMyDsl.g:11126:3: ruleEString
            {
             before(grammarAccess.getSplitAccess().getNameEStringParserRuleCall_1_0()); 
            pushFollow(FOLLOW_2);
            ruleEString();

            state._fsp--;

             after(grammarAccess.getSplitAccess().getNameEStringParserRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Split__NameAssignment_1"


    // $ANTLR start "rule__Split__DescriptionAssignment_3_1"
    // InternalMyDsl.g:11135:1: rule__Split__DescriptionAssignment_3_1 : ( ruleEString ) ;
    public final void rule__Split__DescriptionAssignment_3_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:11139:1: ( ( ruleEString ) )
            // InternalMyDsl.g:11140:2: ( ruleEString )
            {
            // InternalMyDsl.g:11140:2: ( ruleEString )
            // InternalMyDsl.g:11141:3: ruleEString
            {
             before(grammarAccess.getSplitAccess().getDescriptionEStringParserRuleCall_3_1_0()); 
            pushFollow(FOLLOW_2);
            ruleEString();

            state._fsp--;

             after(grammarAccess.getSplitAccess().getDescriptionEStringParserRuleCall_3_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Split__DescriptionAssignment_3_1"


    // $ANTLR start "rule__Split__TableAssignment_5"
    // InternalMyDsl.g:11150:1: rule__Split__TableAssignment_5 : ( ( ruleEString ) ) ;
    public final void rule__Split__TableAssignment_5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:11154:1: ( ( ( ruleEString ) ) )
            // InternalMyDsl.g:11155:2: ( ( ruleEString ) )
            {
            // InternalMyDsl.g:11155:2: ( ( ruleEString ) )
            // InternalMyDsl.g:11156:3: ( ruleEString )
            {
             before(grammarAccess.getSplitAccess().getTableTableCrossReference_5_0()); 
            // InternalMyDsl.g:11157:3: ( ruleEString )
            // InternalMyDsl.g:11158:4: ruleEString
            {
             before(grammarAccess.getSplitAccess().getTableTableEStringParserRuleCall_5_0_1()); 
            pushFollow(FOLLOW_2);
            ruleEString();

            state._fsp--;

             after(grammarAccess.getSplitAccess().getTableTableEStringParserRuleCall_5_0_1()); 

            }

             after(grammarAccess.getSplitAccess().getTableTableCrossReference_5_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Split__TableAssignment_5"


    // $ANTLR start "rule__Split__SourceAssignment_7"
    // InternalMyDsl.g:11169:1: rule__Split__SourceAssignment_7 : ( ( ruleEString ) ) ;
    public final void rule__Split__SourceAssignment_7() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:11173:1: ( ( ( ruleEString ) ) )
            // InternalMyDsl.g:11174:2: ( ( ruleEString ) )
            {
            // InternalMyDsl.g:11174:2: ( ( ruleEString ) )
            // InternalMyDsl.g:11175:3: ( ruleEString )
            {
             before(grammarAccess.getSplitAccess().getSourceColumnCrossReference_7_0()); 
            // InternalMyDsl.g:11176:3: ( ruleEString )
            // InternalMyDsl.g:11177:4: ruleEString
            {
             before(grammarAccess.getSplitAccess().getSourceColumnEStringParserRuleCall_7_0_1()); 
            pushFollow(FOLLOW_2);
            ruleEString();

            state._fsp--;

             after(grammarAccess.getSplitAccess().getSourceColumnEStringParserRuleCall_7_0_1()); 

            }

             after(grammarAccess.getSplitAccess().getSourceColumnCrossReference_7_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Split__SourceAssignment_7"


    // $ANTLR start "rule__Split__DelimiterAssignment_9"
    // InternalMyDsl.g:11188:1: rule__Split__DelimiterAssignment_9 : ( ruleEString ) ;
    public final void rule__Split__DelimiterAssignment_9() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:11192:1: ( ( ruleEString ) )
            // InternalMyDsl.g:11193:2: ( ruleEString )
            {
            // InternalMyDsl.g:11193:2: ( ruleEString )
            // InternalMyDsl.g:11194:3: ruleEString
            {
             before(grammarAccess.getSplitAccess().getDelimiterEStringParserRuleCall_9_0()); 
            pushFollow(FOLLOW_2);
            ruleEString();

            state._fsp--;

             after(grammarAccess.getSplitAccess().getDelimiterEStringParserRuleCall_9_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Split__DelimiterAssignment_9"


    // $ANTLR start "rule__Split__AtCharIndexAssignment_11"
    // InternalMyDsl.g:11203:1: rule__Split__AtCharIndexAssignment_11 : ( ruleEIntegerObject ) ;
    public final void rule__Split__AtCharIndexAssignment_11() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:11207:1: ( ( ruleEIntegerObject ) )
            // InternalMyDsl.g:11208:2: ( ruleEIntegerObject )
            {
            // InternalMyDsl.g:11208:2: ( ruleEIntegerObject )
            // InternalMyDsl.g:11209:3: ruleEIntegerObject
            {
             before(grammarAccess.getSplitAccess().getAtCharIndexEIntegerObjectParserRuleCall_11_0()); 
            pushFollow(FOLLOW_2);
            ruleEIntegerObject();

            state._fsp--;

             after(grammarAccess.getSplitAccess().getAtCharIndexEIntegerObjectParserRuleCall_11_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Split__AtCharIndexAssignment_11"


    // $ANTLR start "rule__Split__ResultColumnAAssignment_13"
    // InternalMyDsl.g:11218:1: rule__Split__ResultColumnAAssignment_13 : ( ( ruleEString ) ) ;
    public final void rule__Split__ResultColumnAAssignment_13() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:11222:1: ( ( ( ruleEString ) ) )
            // InternalMyDsl.g:11223:2: ( ( ruleEString ) )
            {
            // InternalMyDsl.g:11223:2: ( ( ruleEString ) )
            // InternalMyDsl.g:11224:3: ( ruleEString )
            {
             before(grammarAccess.getSplitAccess().getResultColumnAColumnCrossReference_13_0()); 
            // InternalMyDsl.g:11225:3: ( ruleEString )
            // InternalMyDsl.g:11226:4: ruleEString
            {
             before(grammarAccess.getSplitAccess().getResultColumnAColumnEStringParserRuleCall_13_0_1()); 
            pushFollow(FOLLOW_2);
            ruleEString();

            state._fsp--;

             after(grammarAccess.getSplitAccess().getResultColumnAColumnEStringParserRuleCall_13_0_1()); 

            }

             after(grammarAccess.getSplitAccess().getResultColumnAColumnCrossReference_13_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Split__ResultColumnAAssignment_13"


    // $ANTLR start "rule__Split__ResultColumnBAssignment_15"
    // InternalMyDsl.g:11237:1: rule__Split__ResultColumnBAssignment_15 : ( ( ruleEString ) ) ;
    public final void rule__Split__ResultColumnBAssignment_15() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:11241:1: ( ( ( ruleEString ) ) )
            // InternalMyDsl.g:11242:2: ( ( ruleEString ) )
            {
            // InternalMyDsl.g:11242:2: ( ( ruleEString ) )
            // InternalMyDsl.g:11243:3: ( ruleEString )
            {
             before(grammarAccess.getSplitAccess().getResultColumnBColumnCrossReference_15_0()); 
            // InternalMyDsl.g:11244:3: ( ruleEString )
            // InternalMyDsl.g:11245:4: ruleEString
            {
             before(grammarAccess.getSplitAccess().getResultColumnBColumnEStringParserRuleCall_15_0_1()); 
            pushFollow(FOLLOW_2);
            ruleEString();

            state._fsp--;

             after(grammarAccess.getSplitAccess().getResultColumnBColumnEStringParserRuleCall_15_0_1()); 

            }

             after(grammarAccess.getSplitAccess().getResultColumnBColumnCrossReference_15_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Split__ResultColumnBAssignment_15"


    // $ANTLR start "rule__Split__ResultTableAssignment_17"
    // InternalMyDsl.g:11256:1: rule__Split__ResultTableAssignment_17 : ( ( ruleEString ) ) ;
    public final void rule__Split__ResultTableAssignment_17() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:11260:1: ( ( ( ruleEString ) ) )
            // InternalMyDsl.g:11261:2: ( ( ruleEString ) )
            {
            // InternalMyDsl.g:11261:2: ( ( ruleEString ) )
            // InternalMyDsl.g:11262:3: ( ruleEString )
            {
             before(grammarAccess.getSplitAccess().getResultTableTableCrossReference_17_0()); 
            // InternalMyDsl.g:11263:3: ( ruleEString )
            // InternalMyDsl.g:11264:4: ruleEString
            {
             before(grammarAccess.getSplitAccess().getResultTableTableEStringParserRuleCall_17_0_1()); 
            pushFollow(FOLLOW_2);
            ruleEString();

            state._fsp--;

             after(grammarAccess.getSplitAccess().getResultTableTableEStringParserRuleCall_17_0_1()); 

            }

             after(grammarAccess.getSplitAccess().getResultTableTableCrossReference_17_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Split__ResultTableAssignment_17"


    // $ANTLR start "rule__Split__NextAssignment_19"
    // InternalMyDsl.g:11275:1: rule__Split__NextAssignment_19 : ( ( ruleEString ) ) ;
    public final void rule__Split__NextAssignment_19() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:11279:1: ( ( ( ruleEString ) ) )
            // InternalMyDsl.g:11280:2: ( ( ruleEString ) )
            {
            // InternalMyDsl.g:11280:2: ( ( ruleEString ) )
            // InternalMyDsl.g:11281:3: ( ruleEString )
            {
             before(grammarAccess.getSplitAccess().getNextStepCrossReference_19_0()); 
            // InternalMyDsl.g:11282:3: ( ruleEString )
            // InternalMyDsl.g:11283:4: ruleEString
            {
             before(grammarAccess.getSplitAccess().getNextStepEStringParserRuleCall_19_0_1()); 
            pushFollow(FOLLOW_2);
            ruleEString();

            state._fsp--;

             after(grammarAccess.getSplitAccess().getNextStepEStringParserRuleCall_19_0_1()); 

            }

             after(grammarAccess.getSplitAccess().getNextStepCrossReference_19_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Split__NextAssignment_19"


    // $ANTLR start "rule__Extract__NameAssignment_1"
    // InternalMyDsl.g:11294:1: rule__Extract__NameAssignment_1 : ( ruleEString ) ;
    public final void rule__Extract__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:11298:1: ( ( ruleEString ) )
            // InternalMyDsl.g:11299:2: ( ruleEString )
            {
            // InternalMyDsl.g:11299:2: ( ruleEString )
            // InternalMyDsl.g:11300:3: ruleEString
            {
             before(grammarAccess.getExtractAccess().getNameEStringParserRuleCall_1_0()); 
            pushFollow(FOLLOW_2);
            ruleEString();

            state._fsp--;

             after(grammarAccess.getExtractAccess().getNameEStringParserRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Extract__NameAssignment_1"


    // $ANTLR start "rule__Extract__DescriptionAssignment_3_1"
    // InternalMyDsl.g:11309:1: rule__Extract__DescriptionAssignment_3_1 : ( ruleEString ) ;
    public final void rule__Extract__DescriptionAssignment_3_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:11313:1: ( ( ruleEString ) )
            // InternalMyDsl.g:11314:2: ( ruleEString )
            {
            // InternalMyDsl.g:11314:2: ( ruleEString )
            // InternalMyDsl.g:11315:3: ruleEString
            {
             before(grammarAccess.getExtractAccess().getDescriptionEStringParserRuleCall_3_1_0()); 
            pushFollow(FOLLOW_2);
            ruleEString();

            state._fsp--;

             after(grammarAccess.getExtractAccess().getDescriptionEStringParserRuleCall_3_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Extract__DescriptionAssignment_3_1"


    // $ANTLR start "rule__Extract__TableAssignment_5"
    // InternalMyDsl.g:11324:1: rule__Extract__TableAssignment_5 : ( ( ruleEString ) ) ;
    public final void rule__Extract__TableAssignment_5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:11328:1: ( ( ( ruleEString ) ) )
            // InternalMyDsl.g:11329:2: ( ( ruleEString ) )
            {
            // InternalMyDsl.g:11329:2: ( ( ruleEString ) )
            // InternalMyDsl.g:11330:3: ( ruleEString )
            {
             before(grammarAccess.getExtractAccess().getTableTableCrossReference_5_0()); 
            // InternalMyDsl.g:11331:3: ( ruleEString )
            // InternalMyDsl.g:11332:4: ruleEString
            {
             before(grammarAccess.getExtractAccess().getTableTableEStringParserRuleCall_5_0_1()); 
            pushFollow(FOLLOW_2);
            ruleEString();

            state._fsp--;

             after(grammarAccess.getExtractAccess().getTableTableEStringParserRuleCall_5_0_1()); 

            }

             after(grammarAccess.getExtractAccess().getTableTableCrossReference_5_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Extract__TableAssignment_5"


    // $ANTLR start "rule__Extract__ColumnAssignment_7"
    // InternalMyDsl.g:11343:1: rule__Extract__ColumnAssignment_7 : ( ( ruleEString ) ) ;
    public final void rule__Extract__ColumnAssignment_7() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:11347:1: ( ( ( ruleEString ) ) )
            // InternalMyDsl.g:11348:2: ( ( ruleEString ) )
            {
            // InternalMyDsl.g:11348:2: ( ( ruleEString ) )
            // InternalMyDsl.g:11349:3: ( ruleEString )
            {
             before(grammarAccess.getExtractAccess().getColumnColumnCrossReference_7_0()); 
            // InternalMyDsl.g:11350:3: ( ruleEString )
            // InternalMyDsl.g:11351:4: ruleEString
            {
             before(grammarAccess.getExtractAccess().getColumnColumnEStringParserRuleCall_7_0_1()); 
            pushFollow(FOLLOW_2);
            ruleEString();

            state._fsp--;

             after(grammarAccess.getExtractAccess().getColumnColumnEStringParserRuleCall_7_0_1()); 

            }

             after(grammarAccess.getExtractAccess().getColumnColumnCrossReference_7_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Extract__ColumnAssignment_7"


    // $ANTLR start "rule__Extract__LbCharAssignment_9"
    // InternalMyDsl.g:11362:1: rule__Extract__LbCharAssignment_9 : ( ruleEIntegerObject ) ;
    public final void rule__Extract__LbCharAssignment_9() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:11366:1: ( ( ruleEIntegerObject ) )
            // InternalMyDsl.g:11367:2: ( ruleEIntegerObject )
            {
            // InternalMyDsl.g:11367:2: ( ruleEIntegerObject )
            // InternalMyDsl.g:11368:3: ruleEIntegerObject
            {
             before(grammarAccess.getExtractAccess().getLbCharEIntegerObjectParserRuleCall_9_0()); 
            pushFollow(FOLLOW_2);
            ruleEIntegerObject();

            state._fsp--;

             after(grammarAccess.getExtractAccess().getLbCharEIntegerObjectParserRuleCall_9_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Extract__LbCharAssignment_9"


    // $ANTLR start "rule__Extract__UbCharAssignment_11"
    // InternalMyDsl.g:11377:1: rule__Extract__UbCharAssignment_11 : ( ruleEIntegerObject ) ;
    public final void rule__Extract__UbCharAssignment_11() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:11381:1: ( ( ruleEIntegerObject ) )
            // InternalMyDsl.g:11382:2: ( ruleEIntegerObject )
            {
            // InternalMyDsl.g:11382:2: ( ruleEIntegerObject )
            // InternalMyDsl.g:11383:3: ruleEIntegerObject
            {
             before(grammarAccess.getExtractAccess().getUbCharEIntegerObjectParserRuleCall_11_0()); 
            pushFollow(FOLLOW_2);
            ruleEIntegerObject();

            state._fsp--;

             after(grammarAccess.getExtractAccess().getUbCharEIntegerObjectParserRuleCall_11_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Extract__UbCharAssignment_11"


    // $ANTLR start "rule__Extract__PatternAssignment_13"
    // InternalMyDsl.g:11392:1: rule__Extract__PatternAssignment_13 : ( ruleEString ) ;
    public final void rule__Extract__PatternAssignment_13() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:11396:1: ( ( ruleEString ) )
            // InternalMyDsl.g:11397:2: ( ruleEString )
            {
            // InternalMyDsl.g:11397:2: ( ruleEString )
            // InternalMyDsl.g:11398:3: ruleEString
            {
             before(grammarAccess.getExtractAccess().getPatternEStringParserRuleCall_13_0()); 
            pushFollow(FOLLOW_2);
            ruleEString();

            state._fsp--;

             after(grammarAccess.getExtractAccess().getPatternEStringParserRuleCall_13_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Extract__PatternAssignment_13"


    // $ANTLR start "rule__Extract__NextAssignment_15"
    // InternalMyDsl.g:11407:1: rule__Extract__NextAssignment_15 : ( ( ruleEString ) ) ;
    public final void rule__Extract__NextAssignment_15() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:11411:1: ( ( ( ruleEString ) ) )
            // InternalMyDsl.g:11412:2: ( ( ruleEString ) )
            {
            // InternalMyDsl.g:11412:2: ( ( ruleEString ) )
            // InternalMyDsl.g:11413:3: ( ruleEString )
            {
             before(grammarAccess.getExtractAccess().getNextStepCrossReference_15_0()); 
            // InternalMyDsl.g:11414:3: ( ruleEString )
            // InternalMyDsl.g:11415:4: ruleEString
            {
             before(grammarAccess.getExtractAccess().getNextStepEStringParserRuleCall_15_0_1()); 
            pushFollow(FOLLOW_2);
            ruleEString();

            state._fsp--;

             after(grammarAccess.getExtractAccess().getNextStepEStringParserRuleCall_15_0_1()); 

            }

             after(grammarAccess.getExtractAccess().getNextStepCrossReference_15_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Extract__NextAssignment_15"


    // $ANTLR start "rule__TableToSave__PathAssignment_3"
    // InternalMyDsl.g:11426:1: rule__TableToSave__PathAssignment_3 : ( ruleEString ) ;
    public final void rule__TableToSave__PathAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:11430:1: ( ( ruleEString ) )
            // InternalMyDsl.g:11431:2: ( ruleEString )
            {
            // InternalMyDsl.g:11431:2: ( ruleEString )
            // InternalMyDsl.g:11432:3: ruleEString
            {
             before(grammarAccess.getTableToSaveAccess().getPathEStringParserRuleCall_3_0()); 
            pushFollow(FOLLOW_2);
            ruleEString();

            state._fsp--;

             after(grammarAccess.getTableToSaveAccess().getPathEStringParserRuleCall_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TableToSave__PathAssignment_3"


    // $ANTLR start "rule__TableToSave__TableAssignment_5"
    // InternalMyDsl.g:11441:1: rule__TableToSave__TableAssignment_5 : ( ( ruleEString ) ) ;
    public final void rule__TableToSave__TableAssignment_5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:11445:1: ( ( ( ruleEString ) ) )
            // InternalMyDsl.g:11446:2: ( ( ruleEString ) )
            {
            // InternalMyDsl.g:11446:2: ( ( ruleEString ) )
            // InternalMyDsl.g:11447:3: ( ruleEString )
            {
             before(grammarAccess.getTableToSaveAccess().getTableTableCrossReference_5_0()); 
            // InternalMyDsl.g:11448:3: ( ruleEString )
            // InternalMyDsl.g:11449:4: ruleEString
            {
             before(grammarAccess.getTableToSaveAccess().getTableTableEStringParserRuleCall_5_0_1()); 
            pushFollow(FOLLOW_2);
            ruleEString();

            state._fsp--;

             after(grammarAccess.getTableToSaveAccess().getTableTableEStringParserRuleCall_5_0_1()); 

            }

             after(grammarAccess.getTableToSaveAccess().getTableTableCrossReference_5_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TableToSave__TableAssignment_5"


    // $ANTLR start "rule__TableToSave__ColumnsNamesAssignment_8"
    // InternalMyDsl.g:11460:1: rule__TableToSave__ColumnsNamesAssignment_8 : ( ruleEString ) ;
    public final void rule__TableToSave__ColumnsNamesAssignment_8() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:11464:1: ( ( ruleEString ) )
            // InternalMyDsl.g:11465:2: ( ruleEString )
            {
            // InternalMyDsl.g:11465:2: ( ruleEString )
            // InternalMyDsl.g:11466:3: ruleEString
            {
             before(grammarAccess.getTableToSaveAccess().getColumnsNamesEStringParserRuleCall_8_0()); 
            pushFollow(FOLLOW_2);
            ruleEString();

            state._fsp--;

             after(grammarAccess.getTableToSaveAccess().getColumnsNamesEStringParserRuleCall_8_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TableToSave__ColumnsNamesAssignment_8"


    // $ANTLR start "rule__TableToSave__ColumnsNamesAssignment_9_1"
    // InternalMyDsl.g:11475:1: rule__TableToSave__ColumnsNamesAssignment_9_1 : ( ruleEString ) ;
    public final void rule__TableToSave__ColumnsNamesAssignment_9_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:11479:1: ( ( ruleEString ) )
            // InternalMyDsl.g:11480:2: ( ruleEString )
            {
            // InternalMyDsl.g:11480:2: ( ruleEString )
            // InternalMyDsl.g:11481:3: ruleEString
            {
             before(grammarAccess.getTableToSaveAccess().getColumnsNamesEStringParserRuleCall_9_1_0()); 
            pushFollow(FOLLOW_2);
            ruleEString();

            state._fsp--;

             after(grammarAccess.getTableToSaveAccess().getColumnsNamesEStringParserRuleCall_9_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TableToSave__ColumnsNamesAssignment_9_1"


    // $ANTLR start "rule__Association__OriginColAssignment_3"
    // InternalMyDsl.g:11490:1: rule__Association__OriginColAssignment_3 : ( ( ruleEString ) ) ;
    public final void rule__Association__OriginColAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:11494:1: ( ( ( ruleEString ) ) )
            // InternalMyDsl.g:11495:2: ( ( ruleEString ) )
            {
            // InternalMyDsl.g:11495:2: ( ( ruleEString ) )
            // InternalMyDsl.g:11496:3: ( ruleEString )
            {
             before(grammarAccess.getAssociationAccess().getOriginColColumnCrossReference_3_0()); 
            // InternalMyDsl.g:11497:3: ( ruleEString )
            // InternalMyDsl.g:11498:4: ruleEString
            {
             before(grammarAccess.getAssociationAccess().getOriginColColumnEStringParserRuleCall_3_0_1()); 
            pushFollow(FOLLOW_2);
            ruleEString();

            state._fsp--;

             after(grammarAccess.getAssociationAccess().getOriginColColumnEStringParserRuleCall_3_0_1()); 

            }

             after(grammarAccess.getAssociationAccess().getOriginColColumnCrossReference_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Association__OriginColAssignment_3"


    // $ANTLR start "rule__Association__DestinColAssignment_5"
    // InternalMyDsl.g:11509:1: rule__Association__DestinColAssignment_5 : ( ( ruleEString ) ) ;
    public final void rule__Association__DestinColAssignment_5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:11513:1: ( ( ( ruleEString ) ) )
            // InternalMyDsl.g:11514:2: ( ( ruleEString ) )
            {
            // InternalMyDsl.g:11514:2: ( ( ruleEString ) )
            // InternalMyDsl.g:11515:3: ( ruleEString )
            {
             before(grammarAccess.getAssociationAccess().getDestinColColumnCrossReference_5_0()); 
            // InternalMyDsl.g:11516:3: ( ruleEString )
            // InternalMyDsl.g:11517:4: ruleEString
            {
             before(grammarAccess.getAssociationAccess().getDestinColColumnEStringParserRuleCall_5_0_1()); 
            pushFollow(FOLLOW_2);
            ruleEString();

            state._fsp--;

             after(grammarAccess.getAssociationAccess().getDestinColColumnEStringParserRuleCall_5_0_1()); 

            }

             after(grammarAccess.getAssociationAccess().getDestinColColumnCrossReference_5_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Association__DestinColAssignment_5"


    // $ANTLR start "rule__TableToImport__DeleteMismatchedTypesAssignment_1"
    // InternalMyDsl.g:11528:1: rule__TableToImport__DeleteMismatchedTypesAssignment_1 : ( ruleEBooleanObject ) ;
    public final void rule__TableToImport__DeleteMismatchedTypesAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:11532:1: ( ( ruleEBooleanObject ) )
            // InternalMyDsl.g:11533:2: ( ruleEBooleanObject )
            {
            // InternalMyDsl.g:11533:2: ( ruleEBooleanObject )
            // InternalMyDsl.g:11534:3: ruleEBooleanObject
            {
             before(grammarAccess.getTableToImportAccess().getDeleteMismatchedTypesEBooleanObjectParserRuleCall_1_0()); 
            pushFollow(FOLLOW_2);
            ruleEBooleanObject();

            state._fsp--;

             after(grammarAccess.getTableToImportAccess().getDeleteMismatchedTypesEBooleanObjectParserRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TableToImport__DeleteMismatchedTypesAssignment_1"


    // $ANTLR start "rule__TableToImport__PathAssignment_5"
    // InternalMyDsl.g:11543:1: rule__TableToImport__PathAssignment_5 : ( ruleEString ) ;
    public final void rule__TableToImport__PathAssignment_5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:11547:1: ( ( ruleEString ) )
            // InternalMyDsl.g:11548:2: ( ruleEString )
            {
            // InternalMyDsl.g:11548:2: ( ruleEString )
            // InternalMyDsl.g:11549:3: ruleEString
            {
             before(grammarAccess.getTableToImportAccess().getPathEStringParserRuleCall_5_0()); 
            pushFollow(FOLLOW_2);
            ruleEString();

            state._fsp--;

             after(grammarAccess.getTableToImportAccess().getPathEStringParserRuleCall_5_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TableToImport__PathAssignment_5"


    // $ANTLR start "rule__TableToImport__DelimiterAssignment_7"
    // InternalMyDsl.g:11558:1: rule__TableToImport__DelimiterAssignment_7 : ( ruleEString ) ;
    public final void rule__TableToImport__DelimiterAssignment_7() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:11562:1: ( ( ruleEString ) )
            // InternalMyDsl.g:11563:2: ( ruleEString )
            {
            // InternalMyDsl.g:11563:2: ( ruleEString )
            // InternalMyDsl.g:11564:3: ruleEString
            {
             before(grammarAccess.getTableToImportAccess().getDelimiterEStringParserRuleCall_7_0()); 
            pushFollow(FOLLOW_2);
            ruleEString();

            state._fsp--;

             after(grammarAccess.getTableToImportAccess().getDelimiterEStringParserRuleCall_7_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TableToImport__DelimiterAssignment_7"


    // $ANTLR start "rule__TableToImport__TableAssignment_9"
    // InternalMyDsl.g:11573:1: rule__TableToImport__TableAssignment_9 : ( ( ruleEString ) ) ;
    public final void rule__TableToImport__TableAssignment_9() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMyDsl.g:11577:1: ( ( ( ruleEString ) ) )
            // InternalMyDsl.g:11578:2: ( ( ruleEString ) )
            {
            // InternalMyDsl.g:11578:2: ( ( ruleEString ) )
            // InternalMyDsl.g:11579:3: ( ruleEString )
            {
             before(grammarAccess.getTableToImportAccess().getTableTableCrossReference_9_0()); 
            // InternalMyDsl.g:11580:3: ( ruleEString )
            // InternalMyDsl.g:11581:4: ruleEString
            {
             before(grammarAccess.getTableToImportAccess().getTableTableEStringParserRuleCall_9_0_1()); 
            pushFollow(FOLLOW_2);
            ruleEString();

            state._fsp--;

             after(grammarAccess.getTableToImportAccess().getTableTableEStringParserRuleCall_9_0_1()); 

            }

             after(grammarAccess.getTableToImportAccess().getTableTableCrossReference_9_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TableToImport__TableAssignment_9"

    // Delegated rules


 

    public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000000000030L});
    public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000004000000000L});
    public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000008000000000L});
    public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0000000000001800L});
    public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0000010000000000L});
    public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0000100000000000L});
    public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x00000A0000000000L});
    public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x0000080000000002L});
    public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x0000040000000000L});
    public static final BitSet FOLLOW_12 = new BitSet(new long[]{0x2009000000000000L,0x0000000082628191L});
    public static final BitSet FOLLOW_13 = new BitSet(new long[]{0x0000020000000000L});
    public static final BitSet FOLLOW_14 = new BitSet(new long[]{0x0000200000000000L});
    public static final BitSet FOLLOW_15 = new BitSet(new long[]{0x0000400000000000L});
    public static final BitSet FOLLOW_16 = new BitSet(new long[]{0x0000800000000000L});
    public static final BitSet FOLLOW_17 = new BitSet(new long[]{0x000000000000E000L});
    public static final BitSet FOLLOW_18 = new BitSet(new long[]{0x0006000000000000L});
    public static final BitSet FOLLOW_19 = new BitSet(new long[]{0x0000000000000000L,0x0000000800000000L});
    public static final BitSet FOLLOW_20 = new BitSet(new long[]{0x0014000000000000L});
    public static final BitSet FOLLOW_21 = new BitSet(new long[]{0x0020000000000000L});
    public static final BitSet FOLLOW_22 = new BitSet(new long[]{0x0040000000000000L});
    public static final BitSet FOLLOW_23 = new BitSet(new long[]{0x0080080000000000L});
    public static final BitSet FOLLOW_24 = new BitSet(new long[]{0x0100000000000000L});
    public static final BitSet FOLLOW_25 = new BitSet(new long[]{0x00000000001F0000L});
    public static final BitSet FOLLOW_26 = new BitSet(new long[]{0x0200000000000000L});
    public static final BitSet FOLLOW_27 = new BitSet(new long[]{0x0400000000000000L});
    public static final BitSet FOLLOW_28 = new BitSet(new long[]{0x0800000000000000L});
    public static final BitSet FOLLOW_29 = new BitSet(new long[]{0x1000000000000000L});
    public static final BitSet FOLLOW_30 = new BitSet(new long[]{0x4000000000000000L});
    public static final BitSet FOLLOW_31 = new BitSet(new long[]{0x8000000000000000L});
    public static final BitSet FOLLOW_32 = new BitSet(new long[]{0x0000000000600000L});
    public static final BitSet FOLLOW_33 = new BitSet(new long[]{0x0004000000000000L,0x0000000000000002L});
    public static final BitSet FOLLOW_34 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000004L});
    public static final BitSet FOLLOW_35 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000008L});
    public static final BitSet FOLLOW_36 = new BitSet(new long[]{0x0000000000000000L,0x0000004000000000L});
    public static final BitSet FOLLOW_37 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000020L});
    public static final BitSet FOLLOW_38 = new BitSet(new long[]{0x000000000F800000L});
    public static final BitSet FOLLOW_39 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000040L});
    public static final BitSet FOLLOW_40 = new BitSet(new long[]{0x1004000000000000L});
    public static final BitSet FOLLOW_41 = new BitSet(new long[]{0x0004000000000000L,0x0000000000000200L});
    public static final BitSet FOLLOW_42 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000400L});
    public static final BitSet FOLLOW_43 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000800L});
    public static final BitSet FOLLOW_44 = new BitSet(new long[]{0x00000000F0000000L});
    public static final BitSet FOLLOW_45 = new BitSet(new long[]{0x0000000000000000L,0x0000000000001000L});
    public static final BitSet FOLLOW_46 = new BitSet(new long[]{0x0000000000000000L,0x0000000000002000L});
    public static final BitSet FOLLOW_47 = new BitSet(new long[]{0x0000000000000000L,0x0000000000004000L});
    public static final BitSet FOLLOW_48 = new BitSet(new long[]{0x0004000000000000L,0x0000000000010000L});
    public static final BitSet FOLLOW_49 = new BitSet(new long[]{0x0000000000000000L,0x0000020000000000L});
    public static final BitSet FOLLOW_50 = new BitSet(new long[]{0x0000000000000000L,0x0000000000040000L});
    public static final BitSet FOLLOW_51 = new BitSet(new long[]{0x0000000000000000L,0x0000000000080000L});
    public static final BitSet FOLLOW_52 = new BitSet(new long[]{0x0000000000000000L,0x0000000000100000L});
    public static final BitSet FOLLOW_53 = new BitSet(new long[]{0x0000001F00000000L});
    public static final BitSet FOLLOW_54 = new BitSet(new long[]{0x0000000000000000L,0x0000000000800000L});
    public static final BitSet FOLLOW_55 = new BitSet(new long[]{0x0000000000000000L,0x0000000001000000L});
    public static final BitSet FOLLOW_56 = new BitSet(new long[]{0x0000000000000000L,0x0000000004000000L});
    public static final BitSet FOLLOW_57 = new BitSet(new long[]{0x0000000000000000L,0x0000000008000000L});
    public static final BitSet FOLLOW_58 = new BitSet(new long[]{0x0000000000000000L,0x0000000010000000L});
    public static final BitSet FOLLOW_59 = new BitSet(new long[]{0x0000000000000040L,0x0000080000000000L});
    public static final BitSet FOLLOW_60 = new BitSet(new long[]{0x0000000000000000L,0x0000000020000000L});
    public static final BitSet FOLLOW_61 = new BitSet(new long[]{0x0000000000000000L,0x0000000040000000L});
    public static final BitSet FOLLOW_62 = new BitSet(new long[]{0x0000000000000000L,0x0000000100000000L});
    public static final BitSet FOLLOW_63 = new BitSet(new long[]{0x0000000000000000L,0x0000000200000000L});
    public static final BitSet FOLLOW_64 = new BitSet(new long[]{0x0000000000000000L,0x0000000400000000L});
    public static final BitSet FOLLOW_65 = new BitSet(new long[]{0x0000000000000000L,0x0000001000000000L});
    public static final BitSet FOLLOW_66 = new BitSet(new long[]{0x0010000000000000L});
    public static final BitSet FOLLOW_67 = new BitSet(new long[]{0x0000000000000000L,0x0000002000000000L});
    public static final BitSet FOLLOW_68 = new BitSet(new long[]{0x0000000000000000L,0x0000008000000000L});
    public static final BitSet FOLLOW_69 = new BitSet(new long[]{0x0000000000000000L,0x0000010000000000L});
    public static final BitSet FOLLOW_70 = new BitSet(new long[]{0x0000000000000000L,0x0000040000000000L});

}