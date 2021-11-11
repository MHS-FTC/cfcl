package org.macrobotics.cfcl.module;

import com.qualcomm.robotcore.hardware.HardwareMap;

import org.macrobotics.cfcl.math.Transform;
import org.macrobotics.cfcl.math.Vector2;
import org.macrobotics.cfcl.robot.Module;

public abstract class DriveModule extends Module {

    public DriveModule(HardwareMap h) {
        super(h);
    }

    public abstract void setDriveDirection(Transform t);
}
