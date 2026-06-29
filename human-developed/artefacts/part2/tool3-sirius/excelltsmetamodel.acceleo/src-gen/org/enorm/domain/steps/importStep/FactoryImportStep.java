package org.enorm.domain.steps.importStep;

public class FactoryImportStep {

    private static IImportStep step;

    public static void setStep(IImportStep s) {
        step = s;
    }

    public static IImportStep getStep() {
        return step;
    }
}

