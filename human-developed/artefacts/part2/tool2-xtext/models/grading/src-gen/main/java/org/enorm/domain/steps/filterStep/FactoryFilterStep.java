package main.java.org.enorm.domain.steps.filterStep;
						
public class FactoryFilterStep {
	
    private static IFilterStep step;

    public static void setStep(IFilterStep s) {
        step = s;
    }

    public static IFilterStep getStep() {
        return step;
    }
}
