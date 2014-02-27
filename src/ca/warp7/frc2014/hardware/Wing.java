package ca.warp7.frc2014.hardware;

import ca.warp7.frc2014.util.RobotInfoHandler;
import ca.warp7.frc2014.util.Util;
import edu.wpi.first.wpilibj.AnalogChannel;
import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.Talon;

public class Wing {
    private Talon wrist;
    private Talon roller;
    private AnalogChannel wristEncoder;
    private PIDController controller;
    private RobotInfoHandler.InfoValue P, I, D, zeroPoint;

    public Wing(int wristPin, int rollerPin, int wristEncoderPin,
                RobotInfoHandler.InfoValue P,
                RobotInfoHandler.InfoValue I,
                RobotInfoHandler.InfoValue D,
                RobotInfoHandler.InfoValue zeroPoint) {
        wrist = new Talon(wristPin);
        roller = new Talon(rollerPin);
        wristEncoder = new AnalogChannel(wristEncoderPin);
        this.P = P;
        this.I = I;
        this.D = D;
        this.zeroPoint = zeroPoint;
        controller = new PIDController(0, 0, 0, wristEncoder, wrist);
        controller.setInputRange(0.0, 970.0);
        controller.setOutputRange(-1.0, 1.0);
        controller.setContinuous(true);
    }

    public void load() {
        //Robot.getInstance().ds.table.putNumber("zeroPoint", zeroPoint);
        controller.setPID(P.getDouble(), I.getDouble(), D.getDouble());
        Util.log("Wing", "P: " + controller.getP() + "I: " + controller.getI() + "D: " + controller.getD());
    }

    public void setPIDControlled() {
        controller.enable();
    }

    public void setTargetAngle(double angle) {
        if(!controller.isEnable()) {
            controller.enable();
        }
        angle /= 360;
        angle *= 970;
        double num = angle + zeroPoint.getDouble();

        num = num % 970;

        controller.setSetpoint(num);
    }

    public void rollersUp() {
        roller.set(1.0);
    }

    public void rollersDown() {
        roller.set(-1.0);
    }

    public void rollersOff() {
        roller.set(0.0);
    }

    public AnalogChannel getWristEncoder() {
        return wristEncoder;
    }

    public Talon getWrist() {
        return wrist;
    }
}
