package ca.warp7.frc2014.software;

import ca.warp7.frc2014.robot.Robot;

public class TankDrive extends SubsystemBase {

    public String getName() {
        return "Tank Drive";
    }

    public void periodic() {
        Robot.getInstance().hw.drive.setLRPower(Robot.getInstance().ds.controller.getPrimaryY(), Robot.getInstance().ds.controller.getSecondaryY());
    }
}
