package ca.warp7.frc2014.software;

import ca.warp7.frc2014.robot.Warp7Robot;
import ca.warp7.frc2014.util.RobotInfo;
import ca.warp7.frc2014.util.Util;
import edu.wpi.first.wpilibj.Talon;

public class MotorTester extends Subsystem {
    private final Talon motor;

    public MotorTester() {
        if (RobotInfo.testMotorPin.getInt() != 0) {

            Warp7Robot.hw.freeAll();
            motor = new Talon(RobotInfo.testMotorPin.getInt());
            Util.log(getName(), "CALIBRATING MOTOR PIN " + motor.getChannel());
        } else {
            motor = null;
            this.setEnabled(false);
            Warp7Robot.subsystem.remove(this);        //herpa derpa
        }

    }

    public void periodic() {
        if (Warp7Robot.ds.controller.getSecondaryButton(1)) {
            Warp7Robot.hw.backWing.setWristPower(1);
        } else if (Warp7Robot.ds.controller.getSecondaryButton(2)) {
            Warp7Robot.hw.backWing.setWristPower(-1);
        } else {
            Warp7Robot.hw.backWing.setWristPower(0);
        }
    }

    public String getName() {
        return "Motor Test";
    }
}
