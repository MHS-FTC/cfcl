package org.macrobotics.cfcl.robot;

import com.qualcomm.robotcore.hardware.HardwareMap;

public abstract class Module {

    private final HardwareMap hwMap;

    public Module(HardwareMap h) {
        hwMap = h;
    }

    /**
     * Run in a loop to poll hardware, update state, and run core module logic.
     * <p>
     * Submodules should override this method to define their own update logic. Examples can be
     * found in the 'modules' package.
     */
    public void update() {}

    protected HardwareMap getHardwareMap() {
        return hwMap;
    }
}
