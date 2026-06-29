package org.enorm;

import org.enorm.domain.Flow;
import org.enorm.domain.steps.StrManipulationConcatStep.FactoryStrManipulationConcatStep;
import org.enorm.domain.steps.StrManipulationConcatStep.StrManipulationConcatStepDefault;
import org.enorm.domain.steps.StrManipulationExtractStep.FactoryStrManipulationExtractStep;
import org.enorm.domain.steps.StrManipulationExtractStep.StrManipulationExtractStepDefault;
import org.enorm.domain.steps.StrManipulationSplitStep.FactoryStrManipulationSplitStep;
import org.enorm.domain.steps.StrManipulationSplitStep.StrManipulationSplitStepDefault;
import org.enorm.domain.steps.appendRowsStep.AppendRowsStepDefault;
import org.enorm.domain.steps.appendRowsStep.FactoryAppendRowsStep;
import org.enorm.domain.steps.filterStep.FactoryFilterStep;
import org.enorm.domain.steps.filterStep.FilterStepDefault;
import org.enorm.domain.steps.groupByStep.FactoryGroupByStep;
import org.enorm.domain.steps.groupByStep.GroupByStepDefault;
import org.enorm.domain.steps.importStep.FactoryImportStep;
import org.enorm.domain.steps.importStep.ImportStepDefault;
import org.enorm.domain.steps.joinStep.FactoryJoinStep;
import org.enorm.domain.steps.joinStep.JoinStepDefault;
import org.enorm.domain.steps.lookupStep.FactoryLookupStep;
import org.enorm.domain.steps.lookupStep.LookupStepDefault;
import org.enorm.domain.steps.removeDuplicatesStep.FactoryRemoveDuplicatesStep;
import org.enorm.domain.steps.removeDuplicatesStep.RemoveDuplicatesStepDefault;
import org.enorm.domain.steps.saveStep.FactorySaveStep;
import org.enorm.domain.steps.saveStep.SaveStepDefault;
import org.enorm.domain.steps.sortStep.FactorySortStep;
import org.enorm.domain.steps.sortStep.SortStepDefault;

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