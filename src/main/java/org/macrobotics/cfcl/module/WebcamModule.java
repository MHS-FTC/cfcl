package org.macrobotics.cfcl.module;

import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.hardware.camera.WebcamName;
import org.macrobotics.cfcl.robot.Module;

public class WebcamModule extends Module {

    WebcamName webcam;

    public WebcamModule(HardwareMap hwMap, String w) {
        super(hwMap);
        webcam = getHardwareMap().get(WebcamName.class, w);
    }

    public WebcamName getWebcam() {
        return webcam;
    }
}
