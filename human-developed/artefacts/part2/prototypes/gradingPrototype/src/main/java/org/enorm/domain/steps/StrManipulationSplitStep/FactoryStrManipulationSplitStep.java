package org.enorm.domain.steps.StrManipulationSplitStep;

public class FactoryStrManipulationSplitStep {

    private static IStrManipulationSplitStep step;

    public static void setStep(IStrManipulationSplitStep s) {
        step = s;
    }

    public static IStrManipulationSplitStep getStep() {
        return step;
    }
}
