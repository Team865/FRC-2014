package ca.warp7.frc2014.software;

import ca.warp7.frc2014.robot.Robot;
import edu.wpi.first.wpilibj.Talon;

public class MotorTester extends SubsystemBase {
    private final Talon motor;

    public MotorTester() {
        motor = new Talon(5);
    }

    public void periodic() {
        if (Robot.getInstance().ds.controller.getButton(1)) {
            motor.set(1);
        } else if (Robot.getInstance().ds.controller.getButton(2)) {
            motor.set(-1);
        } else {
            motor.set(0);
        }
    }

    public String getName() {
        return "Motor Test";
    }
}
