package org.macrobotics.cfcl.robot;

import org.jetbrains.annotations.NotNull;

import java.util.Set;

public abstract class Behavior {

    public void init(Set<Module> modules) {
        Set<Class<? extends Module>> a = getRequiredModules();
    }

    public @NotNull
    abstract Set<Class<? extends Module>> getRequiredModules();
}
