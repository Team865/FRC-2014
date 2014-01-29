package ca.warp7.frc2014.hardware;// Time Created: 1/4/14 5:21 PM

import ca.warp7.frc2014.control.Controller;
import ca.warp7.frc2014.util.RobotInfo;

public abstract class Hardware {
    Hardware() {
        // how do abstraction
    }

    public abstract void stop();

    public static final Motor leftDrive = new Motor(RobotInfo.leftMotorPort.getInt());
    public static final Motor rightDrive = new Motor(RobotInfo.rightMotorPort.getInt(), true);

    public static Controller controller;
}
