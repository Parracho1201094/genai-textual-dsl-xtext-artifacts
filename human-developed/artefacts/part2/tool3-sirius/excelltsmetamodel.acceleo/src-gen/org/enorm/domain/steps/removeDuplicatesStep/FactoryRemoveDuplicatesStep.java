package org.enorm.domain.steps.removeDuplicatesStep;

public class FactoryRemoveDuplicatesStep {
    private static IRemoveDuplicatesStep step;

    public static void setStep(IRemoveDuplicatesStep s) {
        step = s;
    }

    public static IRemoveDuplicatesStep getStep() {
        return step;
    }
}

