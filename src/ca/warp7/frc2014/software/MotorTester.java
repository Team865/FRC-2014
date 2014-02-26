package ca.warp7.frc2014.software;

import ca.warp7.frc2014.robot.Warp7Robot;
import edu.wpi.first.wpilibj.Talon;

public class MotorTester extends SubsystemBase {
    private final Talon motor;

    public MotorTester() {
        motor = new Talon(5);
    }

    public void periodic() {
        if (Warp7Robot.ds.controller.getButton(1)) {
            motor.set(1);
        } else if (Warp7Robot.ds.controller.getButton(2)) {
            motor.set(-1);
        } else {
            motor.set(0);
        }
    }

    public String getName() {
        return "Motor Test";
    }
}
