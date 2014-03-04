package ca.warp7.frc2014.modules;

import ca.warp7.frc2014.robot.Robot;

public class TankDrive extends ModuleBase {

    public String getName() {
        return "Tank Drive";
    }

    public void periodic() {
        Robot.getInstance().hw.drive.setLRPower(
                Robot.getInstance().ds.getPrimaryY(),
                Robot.getInstance().ds.getSecondaryY());
    }
}
