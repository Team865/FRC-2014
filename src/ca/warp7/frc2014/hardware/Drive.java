package ca.warp7.frc2014.hardware;

import ca.warp7.frc2014.util.RobotInfo;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Solenoid;

public class Drive {
    private Solenoid shifter = new Solenoid(RobotInfo.shifterPort.getInt());
    private final Motor leftDrive = new Motor(RobotInfo.leftMotorPort.getInt());
    private final Motor rightDrive = new Motor(RobotInfo.rightMotorPort.getInt(), true);
    public boolean gear;
    public void setLRPower(double lPower, double rPower) {
        leftDrive.set(lPower);
        rightDrive.set(rPower);
    }

    public void shiftHigh() {
        shifter.set(false);
        gear = true;

    }

    public void shiftLow (){
        shifter.set(true);
        gear = false;
    }
}
