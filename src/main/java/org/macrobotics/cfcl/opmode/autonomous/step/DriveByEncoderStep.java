package org.macrobotics.cfcl.opmode.autonomous.step;

import org.macrobotics.cfcl.opmode.autonomous.Step;
import org.macrobotics.cfcl.robot.RobotConfig;
import org.macrobotics.cfcl.robot.behavior.EncoderDriveBehavior;

public class DriveByEncoderStep extends Step {

    private final EncoderDriveBehavior bhv;

    public DriveByEncoderStep(RobotConfig cfg) {
        super(cfg);

        bhv = cfg.getBehavior(EncoderDriveBehavior.class);
    }

    @Override
    public void start() {

    }

    @Override
    public void update() {

    }

    @Override
    public void stop() {

    }

    @Override
    public boolean isFinished() {
        return bhv.encodersFinished();
    }
}
