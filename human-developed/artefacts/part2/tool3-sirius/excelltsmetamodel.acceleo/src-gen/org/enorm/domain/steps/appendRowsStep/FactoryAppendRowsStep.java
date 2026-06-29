package org.enorm.domain.steps.appendRowsStep;

public class FactoryAppendRowsStep {
    private static IAppendRowsStep step;

    public static void setStep(IAppendRowsStep s) {
        step = s;
    }

    public static IAppendRowsStep getStep() {
        return step;
    }
}


