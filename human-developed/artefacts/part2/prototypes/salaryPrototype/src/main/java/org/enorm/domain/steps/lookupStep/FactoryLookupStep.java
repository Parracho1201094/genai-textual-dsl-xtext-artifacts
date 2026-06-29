package org.enorm.domain.steps.lookupStep;

public class FactoryLookupStep {

    private static ILookupStep step;

    public static void setStep(ILookupStep s) {
        step = s;
    }

    public static ILookupStep getStep() {
        return step;
    }
}
