package ca.warp7.frc2014.hardware;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Talon;

public class Wing {
    private Talon wrist;
    private Talon roller;
    private Encoder wristEncoder;

    public Wing(int wristPin, int rollerPin) {
        wrist = new Talon(wristPin);
        roller = new Talon(rollerPin);
    }

    public void setWristPower(double power) {
        wrist.set(power);
    }

    public void setRollerPower(double power) {
        roller.set(power);
    }

    public void free() {
        wrist.free();
        roller.free();
    }
}
