package org.macrobotics.cfcl.opmode.autonomous.step;

import org.macrobotics.cfcl.math.Transform;
import org.macrobotics.cfcl.robot.RobotConfig;
import org.macrobotics.cfcl.robot.module.DriveModule;

public class DriveByTimeStep extends WaitStep {
    private final DriveModule m;
    private final Transform dir;

    public DriveByTimeStep(RobotConfig cfg, Transform driveDir, double delay) {
        super(cfg, delay);
        dir = driveDir;
        m = cfg.getModule(DriveModule.class);

        if (m == null) {
            throw new IllegalStateException("No drive module found for DriveByTimeStep!");
        }
    }

    @Override
    public void start() {
        super.start();
        m.setDriveDirection(dir);
    }

    @Override
    public void stop() {
        super.stop();
        m.setDriveDirection(new Transform());
    }
}
