package org.macrobotics.cfcl.robot.behavior;

import org.jetbrains.annotations.NotNull;
import org.macrobotics.cfcl.robot.module.DriveModule;
import org.macrobotics.cfcl.robot.Behavior;

import java.util.Objects;

public class EncoderDriveBehavior extends Behavior {

    private final DriveModule drive;

    public EncoderDriveBehavior(@NotNull DriveModule drive) {
        this.drive = Objects.requireNonNull(drive);
    }

    public void pushLocalTransform() {}

    public boolean encodersFinished() {
        return drive.encodersFinished();
    }
}
