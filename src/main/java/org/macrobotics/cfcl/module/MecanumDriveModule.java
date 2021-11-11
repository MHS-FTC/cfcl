package org.macrobotics.cfcl.module;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.jetbrains.annotations.NotNull;
import org.macrobotics.cfcl.math.Transform;

public class MecanumDriveModule extends DriveModule {

    DcMotor leftFront;
    DcMotor rightFront;
    DcMotor leftBack;
    DcMotor rightBack;

    private double speed = 1;

    public MecanumDriveModule(HardwareMap hwMap, String lf, String rf, String lb, String rb) {
        super(hwMap);
        leftFront = getHardwareMap().dcMotor.get(lf);
        rightFront = getHardwareMap().dcMotor.get(rf);
        leftBack = getHardwareMap().dcMotor.get(lb);
        rightBack = getHardwareMap().dcMotor.get(rb);
    }

    public void setSpeed(double s) {
        speed = s;
    }

    public void driveRaw(double lf, double rf, double lb, double rb) {
        leftFront.setPower(lf * speed);
        rightFront.setPower(rf * speed);
        leftBack.setPower(lb * speed);
        rightBack.setPower(rb * speed);
    }

    @Override
    public void setDriveDirection(@NotNull Transform t) {
        driveRaw(t.offset.y + t.offset.x + t.theta, t.offset.y - t.offset.x - t.theta,
                t.offset.y - t.offset.x + t.theta, t.offset.y + t.offset.x - t.theta);
    }
}
