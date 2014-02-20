package ca.warp7.frc2014.software;

import ca.warp7.frc2014.robot.Warp7Robot;

public class Shifter extends Subsystem {
    public Shifter() {
        Warp7Robot.hw.drive.shiftLow();
    }

    public void periodic() {
        if (Warp7Robot.ds.controller.getTertiaryAction()) {
            Warp7Robot.hw.drive.shiftHigh();
        }
        if (Warp7Robot.ds.controller.getQuaternaryAction()) {
            Warp7Robot.hw.drive.shiftLow();
        }

    }

    public String getName() {
        return "Shifter";
    }
}
