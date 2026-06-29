package org.enorm.domain.steps.StrManipulationConcatStep;

public class FactoryStrManipulationConcatStep {

    private static IStrManipulationConcatStep step;

    public static void setStep(IStrManipulationConcatStep s) {
        step = s;
    }

    public static IStrManipulationConcatStep getStep() {
        return step;
    }
}
