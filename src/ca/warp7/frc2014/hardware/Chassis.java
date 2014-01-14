package ca.warp7.frc2014.hardware;// Time Created: 1/4/14 5:24 PM

import ca.warp7.frc2014.util.RobotInfo;
import edu.wpi.first.wpilibj.Talon;

public class Chassis extends Part {

    private Talon leftDrive = new Talon(RobotInfo.leftMotorPort.intValue());
    private Talon rightDrive = new Talon(RobotInfo.rightMotorPort.intValue());


    public void stop() {
        leftDrive.set(0);
        rightDrive.set(0);

    }

    public void tick() {

    }

    public void setLeftRightPower(double leftPower, double rightPower) {
        leftDrive.set(leftPower);
        rightDrive.set(rightPower);

    }
}
