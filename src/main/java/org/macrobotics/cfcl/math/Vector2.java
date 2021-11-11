package org.macrobotics.cfcl.math;

import org.jetbrains.annotations.NotNull;

public class Vector2 {

    public double x;
    public double y;

    public Vector2(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public Vector2(float x, float y) {
        this.x = x;
        this.y = y;
    }

    public Vector2(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Vector2() {
        this(0, 0);
    }

    /**
     * Returns the length of the vector.
     * @return Length of the vector.
     */
    public double len() {
        return Math.hypot(x, y);
    }

    /**
     * Computes a normalized version of the vector.
     * @return Normalized vector.
     */
    public Vector2 normalized() {
        double l = len();
        return new Vector2(x / l, y / l);
    }

    public double angle() {
        return Math.atan2(y, x);
    }

    public Vector2 add(@NotNull Vector2 other) {
        return new Vector2(x + other.x, y + other.y);
    }

    public Vector2 subtract(@NotNull Vector2 other) {
        return new Vector2(x - other.x, y - other.y);
    }

    public Vector2 multiply(double s) {
        return new Vector2(x * s, y * s);
    }

    public Vector2 dot(@NotNull Vector2 other) {
        return new Vector2(x + other.x, y + other.y);
    }

    public Vector2 rotate(double theta) {
        double a = Math.sin(theta);
        double b = Math.cos(theta);
        return new Vector2(x * b - y * a, x * a + y * b);
    }
}
