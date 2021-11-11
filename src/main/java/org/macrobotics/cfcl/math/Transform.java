package org.macrobotics.cfcl.math;

import org.jetbrains.annotations.NotNull;

public class Transform {
    public Vector2 offset;
    public double theta;

    public Transform(Vector2 v, double t) {
        offset = v;
        theta = t;
    }

    public Transform(Vector2 v) {
        this(v, 0);
    }

    public Transform(double t) {
        this(new Vector2(), t);
    }

    public Transform() {
        offset = new Vector2();
        theta = 0;
    }

    public Transform apply(@NotNull Transform other) {
        Vector2 t = offset.rotate(other.offset.angle());
        return new Transform(offset.add(t), theta + other.theta);
    }
}
