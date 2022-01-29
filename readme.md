# CFCl
![Version](https://img.shields.io/badge/version-0.0.1--beta-blue)
![License](https://img.shields.io/github/license/MHS-FTC/cfcl)
![GitHub issues](https://img.shields.io/github/issues/MHS-FTC/cfcl?logo=github)
![FTC library version](https://img.shields.io/badge/ftc%20library%20version-7.0.0-blue)

The Chronobreak FTC Code Library - a collection of useful code snippets, structures, and various
other bits and bobs useful for FTC programming. Designed to be used with Android Studio, though
might (?) work with OnBotJava as well.

## APIs
CFCl exposes a bunch of different APIs designed to be used together, but if needed they can be used
independently too.

### Modules/Behaviors
The core of the CFCl ecosystem, these are designed to be easily pluggable and replaceable chunks of
code to interface with the robot.

Modules are the lowest level, interfacing directly with the robot hardware itself. These include
things like drive systems, intakes, and actuators. Generally the code inside of these is fairly
simple, translating useful inputs into motor and servo outputs.

Behaviors are the next level up, depending on any number of modules and translating more complex
inputs into commands to the modules. These tend to be more complex, sometimes relying on multiple
sensor inputs at a time as well as providing an output.

### Steps
Any action that a robot can make, designed to be chained together with other Steps in a
StepSequence. Can be used either in Autonomous or TeleOp, based on need.

### RobotConfig
A simple way to use a bunch of Modules and Behaviors together.

### Opmodes
Opmode integration with the other APIs listed here.
