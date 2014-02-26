package ca.warp7.frc2014.software;

import ca.warp7.frc2014.robot.Warp7Robot;

public class Shifter extends SubsystemBase {

    public void load() {
        Warp7Robot.hw.drive.shift(false);
    }

    public void periodic() {
        if (Warp7Robot.ds.controller.getButton(4)) {
            Warp7Robot.hw.drive.shift(true);
        }
        if (Warp7Robot.ds.controller.getButton(5)) {
            Warp7Robot.hw.drive.shift(false);
        }

    }

    public String getName() {
        return "Shifter";
    }
}
