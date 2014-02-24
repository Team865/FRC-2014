package ca.warp7.frc2014.hardware;

import edu.wpi.first.wpilibj.AnalogChannel;
import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.Talon;

public class Wing {
    private Talon wrist;
    private Talon roller;
    private AnalogChannel wristEncoder;
    PIDController controller;

    public Wing(int wristPin, int rollerPin, int wristEncoderPin, double p, double i, double d) {
        wrist = new Talon(wristPin);
        roller = new Talon(rollerPin);
        wristEncoder = new AnalogChannel(wristEncoderPin);
        controller = new PIDController(p, i, d, wristEncoder, wrist);
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

    public double getWristPos() {

        return wristEncoder.getVoltage();
    }
}
