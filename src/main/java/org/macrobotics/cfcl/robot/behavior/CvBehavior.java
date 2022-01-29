package org.macrobotics.cfcl.robot.behavior;

import org.firstinspires.ftc.robotcore.external.ClassFactory;
import org.firstinspires.ftc.robotcore.external.hardware.camera.CameraName;
import org.firstinspires.ftc.robotcore.external.navigation.VuforiaLocalizer;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.macrobotics.cfcl.robot.module.WebcamModule;
import org.macrobotics.cfcl.robot.Behavior;

import java.util.Optional;

public class CvBehavior extends Behavior {

    private final VuforiaLocalizer vuforia;

    public CvBehavior(@Nullable WebcamModule cam, @NotNull String licenseKey,
                      @Nullable VuforiaLocalizer.CameraDirection cameraDirection) {
        VuforiaLocalizer.Parameters p = new VuforiaLocalizer.Parameters();
        p.vuforiaLicenseKey = licenseKey;
        p.cameraName = Optional.ofNullable(cam)
                .map(WebcamModule::getWebcam)
                .map(m -> (CameraName) m)
                .orElse(p.cameraName);
        p.cameraDirection = Optional.ofNullable(cameraDirection).orElse(p.cameraDirection);
        vuforia = ClassFactory.getInstance().createVuforia(p);
    }

    public CvBehavior(WebcamModule cam, String licenseKey) {
        this(cam, licenseKey, null);
    }
}
