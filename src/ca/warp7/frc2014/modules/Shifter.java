package ca.warp7.frc2014.modules;

import ca.warp7.frc2014.robot.Robot;

public class Shifter extends ModuleBase {

    public void load() {
        Robot.getInstance().hw.drive.shift(false);
    }

    public void periodic() {
        if (Robot.getInstance().ds.controller.getButton(4)) {
            Robot.getInstance().hw.drive.shift(true);
        }
        if (Robot.getInstance().ds.controller.getButton(5)) {
            Robot.getInstance().hw.drive.shift(false);
        }

    }

    public String getName() {
        return "Shifter";
    }
}
