package main.java.org.enorm;

import main.java.org.enorm.domain.Flow;
import main.java.org.enorm.domain.steps.strManipulationConcatStep.FactoryStrManipulationConcatStep;
import main.java.org.enorm.domain.steps.strManipulationConcatStep.StrManipulationConcatStepDefault;
import main.java.org.enorm.domain.steps.strManipulationExtractStep.FactoryStrManipulationExtractStep;
import main.java.org.enorm.domain.steps.strManipulationExtractStep.StrManipulationExtractStepDefault;
import main.java.org.enorm.domain.steps.strManipulationSplitStep.FactoryStrManipulationSplitStep;
import main.java.org.enorm.domain.steps.strManipulationSplitStep.StrManipulationSplitStepDefault;
import main.java.org.enorm.domain.steps.appendRowsStep.AppendRowsStepDefault;
import main.java.org.enorm.domain.steps.appendRowsStep.FactoryAppendRowsStep;
import main.java.org.enorm.domain.steps.filterStep.FactoryFilterStep;
import main.java.org.enorm.domain.steps.filterStep.FilterStepDefault;
import main.java.org.enorm.domain.steps.groupByStep.FactoryGroupByStep;
import main.java.org.enorm.domain.steps.groupByStep.GroupByStepDefault;
import main.java.org.enorm.domain.steps.importStep.FactoryImportStep;
import main.java.org.enorm.domain.steps.importStep.ImportStepDefault;
import main.java.org.enorm.domain.steps.joinStep.FactoryJoinStep;
import main.java.org.enorm.domain.steps.joinStep.JoinStepDefault;
import main.java.org.enorm.domain.steps.lookupStep.FactoryLookupStep;
import main.java.org.enorm.domain.steps.lookupStep.LookupStepDefault;
import main.java.org.enorm.domain.steps.removeDuplicatesStep.FactoryRemoveDuplicatesStep;
import main.java.org.enorm.domain.steps.removeDuplicatesStep.RemoveDuplicatesStepDefault;
import main.java.org.enorm.domain.steps.saveStep.FactorySaveStep;
import main.java.org.enorm.domain.steps.saveStep.SaveStepDefault;
import main.java.org.enorm.domain.steps.sortStep.FactorySortStep;
import main.java.org.enorm.domain.steps.sortStep.SortStepDefault;

public class Main {
    public static void main(String[] args) {
    	
        FactoryAppendRowsStep.setStep(new AppendRowsStepDefault());
        FactoryFilterStep.setStep(new FilterStepDefault());
        FactoryGroupByStep.setStep(new GroupByStepDefault());
        FactoryImportStep.setStep(new ImportStepDefault());
        FactoryJoinStep.setStep(new JoinStepDefault());
        FactoryLookupStep.setStep(new LookupStepDefault());
        FactoryRemoveDuplicatesStep.setStep(new RemoveDuplicatesStepDefault());
        FactorySaveStep.setStep(new SaveStepDefault());
        FactorySortStep.setStep(new SortStepDefault());
        FactoryStrManipulationConcatStep.setStep(new StrManipulationConcatStepDefault());
        FactoryStrManipulationExtractStep.setStep(new StrManipulationExtractStepDefault());
        FactoryStrManipulationSplitStep.setStep(new StrManipulationSplitStepDefault());

        Flow.execute();
    }
}
