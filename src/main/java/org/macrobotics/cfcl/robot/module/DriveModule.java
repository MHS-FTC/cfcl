package org.macrobotics.cfcl.robot.module;

import com.qualcomm.robotcore.hardware.HardwareMap;

import org.macrobotics.cfcl.math.Transform;
import org.macrobotics.cfcl.robot.Module;

public abstract class DriveModule extends Module {

    public DriveModule(HardwareMap h) {
        super(h);
    }

    public abstract void setDriveDirection(Transform t);

    public abstract void recalibrateEncoders();

    public abstract void setEncoderMovement(Transform t);
    public abstract boolean encodersFinished();
}
