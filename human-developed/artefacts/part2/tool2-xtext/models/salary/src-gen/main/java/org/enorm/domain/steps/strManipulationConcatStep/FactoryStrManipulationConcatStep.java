package main.java.org.enorm.domain.steps.strManipulationConcatStep;
					
public class FactoryStrManipulationConcatStep {

    private static IStrManipulationConcatStep step;

    public static void setStep(IStrManipulationConcatStep s) {
        step = s;
    }

    public static IStrManipulationConcatStep getStep() {
        return step;
    }
}
