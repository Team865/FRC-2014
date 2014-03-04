package ca.warp7.frc2014.modules;

import ca.warp7.frc2014.robot.Robot;

public class Compressor extends ModuleBase {
    public void load() {
        Robot.getInstance().hw.comp.start(); // yay compliance
    }

    public void periodic() {

    }

    public String getName() {
        return "Compressor";
    }
}
