package ca.warp7.frc2014.hardware;

import ca.warp7.frc2014.robot.Warp7Robot;
import ca.warp7.frc2014.util.RobotInfo;
import ca.warp7.frc2014.util.Util;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.Talon;

public class Drive {
    private final Solenoid shifter = new Solenoid(RobotInfo.shifterPort.getInt());
    private final Talon leftDrive = new Talon(RobotInfo.leftMotorPort.getInt());
    private final Talon rightDrive = new Talon(RobotInfo.rightMotorPort.getInt());
    private boolean gear = false;

    public void setLRPower(double lPower, double rPower) {
        leftDrive.set(lPower);
        rightDrive.set(rPower * -1); //inverted cause other side
    }

    public void shift(boolean gear) {
        shifter.set(!gear);
        this.gear = gear;
        Util.log("Drive", gear ? "High" : "Low");
        Warp7Robot.ds.table.putBoolean("Gear", gear);
    }

    public boolean getGear() {
        return gear;
    }
}
