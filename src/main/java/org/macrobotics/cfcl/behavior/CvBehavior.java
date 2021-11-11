package org.macrobotics.cfcl.behavior;

import org.jetbrains.annotations.NotNull;
import org.macrobotics.cfcl.module.WebcamModule;
import org.macrobotics.cfcl.robot.Behavior;
import org.macrobotics.cfcl.robot.Module;

import java.util.Collections;
import java.util.Set;

public class CvBehavior extends Behavior {

    @Override
    public void init(Set<Module> modules) {
        super.init(modules);

    }

    @Override
    public @NotNull Set<Class<? extends Module>> getRequiredModules() {
        return Collections.singleton(WebcamModule.class);
    }
}
