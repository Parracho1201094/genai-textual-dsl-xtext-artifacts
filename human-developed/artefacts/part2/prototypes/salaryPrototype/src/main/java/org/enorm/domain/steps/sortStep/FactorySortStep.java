package org.enorm.domain.steps.sortStep;

public class FactorySortStep {

    private static ISortStep step;

    public static void setStep(ISortStep s) {
        step = s;
    }

    public static ISortStep getStep() {
        return step;
    }
}
