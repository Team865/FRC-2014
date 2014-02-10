package ca.warp7.frc2014.software;

import ca.warp7.frc2014.robot.Warp7Robot;

public class TankDrive extends Subsystem {

    public void periodic() {
        Warp7Robot.hw.drive.setLRPower(Warp7Robot.ds.controller.getPrimaryY(), Warp7Robot.ds.controller.getSecondaryY());
    }
}
