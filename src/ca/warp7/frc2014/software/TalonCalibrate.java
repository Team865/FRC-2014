package ca.warp7.frc2014.software;

import ca.warp7.frc2014.hardware.Hardware;
import edu.wpi.first.wpilibj.Talon;

/**
 * Created with IntelliJ IDEA.
 * User: Ari
 * Date: 1/29/14
 * Time: 2:39 PM
 */
public class TalonCalibrate extends Subsystem {
    private Talon talon;

    public TalonCalibrate(Talon talon) {
        this.talon = talon;
    }

    protected void tick() {
        if (Hardware.controller.getPrimaryAction()) {
            talon.set(1);
        } else if (Hardware.controller.getSecondaryAction()) {
            talon.set(-1);
        } else {
            talon.set(0);
        }
    }
}
