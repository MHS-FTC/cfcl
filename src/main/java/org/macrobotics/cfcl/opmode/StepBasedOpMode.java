package org.macrobotics.cfcl.opmode;

import org.jetbrains.annotations.NotNull;
import org.macrobotics.cfcl.opmode.autonomous.Step;
import org.macrobotics.cfcl.robot.RobotConfig;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.Queue;

public abstract class StepBasedOpMode<T extends RobotConfig> extends CFClOpMode<T> {
    private final Queue<Step> stepQueue = new LinkedList<>();

    @Override
    public void start() {
        super.start();

        stepQueue.addAll(buildSteps().stepList);

        Step firstStep = stepQueue.peek();
        if (firstStep != null) {
            firstStep.start();
        } else {
            requestOpModeStop();
        }
    }

    @Override
    public void update() {
        Step currentStep = stepQueue.peek();

        if (currentStep != null) {
            if (currentStep.isFinished()) {
                currentStep.stop();
                stepQueue.poll();

                Step nextStep = stepQueue.peek();
                if (nextStep != null) {
                    nextStep.start();
                } else {
                    requestOpModeStop();
                }
            } else {
                currentStep.update();
            }
        } else {
            requestOpModeStop();
        }
    }

    @Override
    public void stop() {
        super.stop();
        stepQueue.forEach(Step::stop);
    }

    public abstract StepQueueBuilder buildSteps();

    public static class StepQueueBuilder {
        private final List<Step> stepList = new ArrayList<>();

        public StepQueueBuilder() {}

        public StepQueueBuilder putStep(@NotNull Step s) {
            stepList.add(Objects.requireNonNull(s));
            return this;
        }
    }
}
