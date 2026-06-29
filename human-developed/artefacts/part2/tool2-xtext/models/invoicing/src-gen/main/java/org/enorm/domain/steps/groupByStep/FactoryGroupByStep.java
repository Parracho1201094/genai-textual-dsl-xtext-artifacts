package main.java.org.enorm.domain.steps.groupByStep;
						
public class FactoryGroupByStep {
	
    private static IGroupByStep step;

    public static void setStep(IGroupByStep s) {
        step = s;
    }

    public static IGroupByStep getStep() {
        return step;
    }
}
