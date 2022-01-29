package org.macrobotics.cfcl.opmode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;

import org.macrobotics.cfcl.robot.RobotConfig;

public abstract class CFClOpMode<T extends RobotConfig> extends OpMode {

    public T robot;

    public abstract T createRobot();

    public abstract void update();

    @Override
    public void init() {
        robot = createRobot();
        robot.init();
    }

    @Override
    public void loop() {
        update();
    }
}
