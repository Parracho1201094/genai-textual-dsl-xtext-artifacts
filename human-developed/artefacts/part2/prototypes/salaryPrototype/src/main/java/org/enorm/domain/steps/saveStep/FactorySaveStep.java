package org.enorm.domain.steps.saveStep;

public class FactorySaveStep {

    private static ISaveStep step;

    public static void setStep(ISaveStep s) {
        step = s;
    }

    public static ISaveStep getStep() {
        return step;
    }
}
