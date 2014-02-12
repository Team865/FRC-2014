package ca.warp7.frc2014.software;

import ca.warp7.frc2014.robot.Warp7Robot;
import edu.wpi.first.wpilibj.Talon;

public class TalonCalibrate extends Subsystem {

    public String getName() {
        return "Talon Calibration";
    }

    private Talon talon = null;

    public void setTalon(Talon talon) {
        this.talon = talon;
    }

    public void periodic() {
        if (talon != null) {
            if (Warp7Robot.ds.controller.getPrimaryAction()) {
                talon.set(1);
            } else if (Warp7Robot.ds.controller.getSecondaryAction()) {
                talon.set(-1);
            } else {
                talon.set(0);
            }
        }
    }
}
