package ca.warp7.frc2014.hardware;

import ca.warp7.frc2014.robot.Warp7Robot;
import ca.warp7.frc2014.util.RobotInfo;
import ca.warp7.frc2014.util.Util;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Solenoid;

public class Drive {
    private Solenoid shifter = new Solenoid(RobotInfo.shifterPort.getInt());
    private final Motor leftDrive = new Motor(RobotInfo.leftMotorPort.getInt());
    private final Motor rightDrive = new Motor(RobotInfo.rightMotorPort.getInt(), true);
    private boolean gear = false;
    public void setLRPower(double lPower, double rPower) {
        leftDrive.set(lPower);
        rightDrive.set(rPower);
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
