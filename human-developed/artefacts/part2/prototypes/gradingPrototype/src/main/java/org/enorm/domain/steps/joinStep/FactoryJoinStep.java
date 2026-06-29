package org.enorm.domain.steps.joinStep;

public class FactoryJoinStep {

    private static IJoinStep step;

    public static void setStep(IJoinStep s) {
        step = s;
    }

    public static IJoinStep getStep() {
        return step;
    }
}
