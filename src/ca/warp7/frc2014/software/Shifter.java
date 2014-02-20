package ca.warp7.frc2014.software;

import ca.warp7.frc2014.robot.Warp7Robot;

public class Shifter extends Subsystem {
    public Shifter() {
        Warp7Robot.hw.drive.shift(false);
    }

    public void periodic() {
        if (Warp7Robot.ds.controller.getTertiaryAction()) {
            Warp7Robot.hw.drive.shift(true);
        }
        if (Warp7Robot.ds.controller.getQuaternaryAction()) {
            Warp7Robot.hw.drive.shift(false);
        }

    }

    public String getName() {
        return "Shifter";
    }
}
