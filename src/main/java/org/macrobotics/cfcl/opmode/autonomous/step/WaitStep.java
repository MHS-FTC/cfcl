package org.macrobotics.cfcl.opmode.autonomous.step;

import com.qualcomm.robotcore.util.ElapsedTime;

import org.macrobotics.cfcl.opmode.autonomous.Step;
import org.macrobotics.cfcl.robot.RobotConfig;

public class WaitStep extends Step {
    private final ElapsedTime t = new ElapsedTime();
    private final double delay;

    public WaitStep(RobotConfig cfg, double delay) {
        super(cfg);
        this.delay = delay;
    }

    @Override
    public void start() {
        t.reset();
    }

    @Override
    public void update() {}

    @Override
    public void stop() {}

    @Override
    public boolean isFinished() {
        return t.seconds() >= delay;
    }
}
