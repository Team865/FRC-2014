package ca.warp7.frc2014.modules;

import ca.warp7.frc2014.robot.Robot;

public class Shifter extends ModuleBase {

    public void load() {

    }

    public void periodic() {
        Robot.getInstance().hw.drive.shift(Robot.getInstance().ds.getShiftLowButton());
    }

    public String getName() {
        return "Shifter";
    }
}
