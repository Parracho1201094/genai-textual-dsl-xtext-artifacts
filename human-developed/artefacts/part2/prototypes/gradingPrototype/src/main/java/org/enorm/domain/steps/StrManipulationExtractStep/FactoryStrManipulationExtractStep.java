package org.enorm.domain.steps.StrManipulationExtractStep;

public class FactoryStrManipulationExtractStep {

    private static IStrManipulationExtractStep step;

    public static void setStep(IStrManipulationExtractStep s) {
        step = s;
    }

    public static IStrManipulationExtractStep getStep() {
        return step;
    }
}
