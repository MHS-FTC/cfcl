package org.macrobotics.cfcl.opmode.autonomous;

import org.macrobotics.cfcl.robot.RobotConfig;

public abstract class Step {
    public Step(RobotConfig cfg) {

    }

    public abstract void start();
    public abstract void update();
    public abstract void stop();

    public abstract boolean isFinished();
}
