package org.macrobotics.cfcl.robot.module;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.sun.tools.javac.util.List;

import org.jetbrains.annotations.NotNull;
import org.macrobotics.cfcl.math.Transform;

import java.util.Collections;
import java.util.function.Consumer;
import java.util.stream.Stream;

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

        recalibrateEncoders();
    }

    private Stream<DcMotor> getAllMotors() {
        return List.of(leftFront, rightFront, leftBack, rightBack).stream();
    }

    public void setSpeed(double s) {
        speed = s;
    }

    public void reverseLeft() {
        leftFront.setDirection(DcMotorSimple.Direction.REVERSE);
        leftBack.setDirection(DcMotorSimple.Direction.REVERSE);
    }

    public void reverseRight() {
        rightFront.setDirection(DcMotorSimple.Direction.REVERSE);
        rightBack.setDirection(DcMotorSimple.Direction.REVERSE);
    }

    public void reverseFront() {
        leftFront.setDirection(DcMotorSimple.Direction.REVERSE);
        rightFront.setDirection(DcMotorSimple.Direction.REVERSE);
    }

    public void reverseBack() {
        leftBack.setDirection(DcMotorSimple.Direction.REVERSE);
        rightBack.setDirection(DcMotorSimple.Direction.REVERSE);
    }

    public void driveRaw(double lf, double rf, double lb, double rb) {
        getAllMotors().forEach(m -> m.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER));

        leftFront.setPower(lf * speed);
        rightFront.setPower(rf * speed);
        leftBack.setPower(lb * speed);
        rightBack.setPower(rb * speed);
    }

    public void setEncodersRaw(int lf, int rf, int lb, int rb) {
        leftFront.setTargetPosition(leftFront.getTargetPosition() + lf);
        rightFront.setTargetPosition(rightFront.getTargetPosition() + rf);
        leftBack.setTargetPosition(leftBack.getTargetPosition() + lb);
        rightBack.setTargetPosition(rightBack.getTargetPosition() + rb);

        getAllMotors().forEach(m -> m.setMode(DcMotor.RunMode.RUN_TO_POSITION));
    }

    @Override
    public void setDriveDirection(@NotNull Transform t) {
        driveRaw(t.offset.y + t.offset.x + t.theta, t.offset.y - t.offset.x - t.theta,
                t.offset.y - t.offset.x + t.theta, t.offset.y + t.offset.x - t.theta);
    }

    @Override
    public void recalibrateEncoders() {
        getAllMotors().forEach(m -> m.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER));
    }

    @Override
    public void setEncoderMovement(Transform t) {
        setEncodersRaw(200, 200, 200, 200);
    }

    @Override
    public boolean encodersFinished() {
        return getAllMotors().map(m -> m.getTargetPosition() - m.getCurrentPosition())
                .map(Math::abs).map(i -> i > 4).reduce((b1, b2) -> b1 || b2).orElse(true);
    }
}
