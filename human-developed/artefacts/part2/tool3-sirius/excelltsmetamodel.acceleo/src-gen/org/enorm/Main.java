package org.enorm;

import org.enorm.domain.Flow;
import org.enorm.domain.steps.appendRowsStep.*;
import org.enorm.domain.steps.filterStep.*;
import org.enorm.domain.steps.groupByStep.*;
import org.enorm.domain.steps.importStep.*;
import org.enorm.domain.steps.joinStep.*;
import org.enorm.domain.steps.lookupStep.*;
import org.enorm.domain.steps.removeDuplicatesStep.*;
import org.enorm.domain.steps.saveStep.*;
import org.enorm.domain.steps.sortStep.*;

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

        Flow.execute();
    }
}

