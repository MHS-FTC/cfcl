package org.macrobotics.cfcl.math;

import com.qualcomm.robotcore.hardware.Gamepad;

import org.jetbrains.annotations.NotNull;

/**
 * A utility class for helpful math functions involving the custom classes used in this library.
 */
public final class Util {
    private Util() {} // no instancing smh

    /**
     * Converts an boolean into an int. Yes, there's a function for this. Yes, it's because I keep
     * forgetting which side of the ternary the 1 goes on. Just don't bully me, please.
     *
     * @param b The boolean to convert
     * @return 1 if the boolean is true, 0 otherwise
     */
    public static int toInt(boolean b) {
        return b ? 1 : 0;
    }

    /**
     * Uses a Gamepad to create a robot transform based on arcade-style controls.
     *
     * Designed to be used with the
     * {@link org.macrobotics.cfcl.robot.module.DriveModule#setDriveDirection(Transform)} function,
     * though can be adapted to to other places if needed.
     *
     * @param gamepad The Gamepad to use for the input.
     * @return A Transform representation of the current gamepad state.
     */
    public static @NotNull Transform getGamepadInput(@NotNull Gamepad gamepad) {
        return new Transform(
                new Vector2(gamepad.left_stick_x, -gamepad.left_stick_y),
                gamepad.right_stick_x);
    }
}
