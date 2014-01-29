package ca.warp7.frc2014.software;

import ca.warp7.frc2014.hardware.Hardware;

/**
 * Created with IntelliJ IDEA.
 * User: Ari
 * Date: 1/9/14
 * Time: 3:04 PM
 */
public class TankDrive extends Subsystem {

    public void tick() {
        Hardware.leftDrive.set(Hardware.controller.getPrimaryY());
        Hardware.rightDrive.set(Hardware.controller.getSecondaryY());

    }
}
