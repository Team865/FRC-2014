package ca.warp7.frc2014.hardware;

import ca.warp7.frc2014.util.RobotInfo;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Solenoid;

public class Drive {
    private Solenoid shifter = new Solenoid(RobotInfo.shifterPort.getInt());
    private final Motor leftDrive = new Motor(RobotInfo.leftMotorPort.getInt());
    private final Motor rightDrive = new Motor(RobotInfo.rightMotorPort.getInt(), true);
    private final Encoder leftEncoder = new Encoder(RobotInfo.leftEncoderPortA.getInt(), RobotInfo.leftEncoderPortB.getInt());
    private final Encoder rightEncoder = new Encoder(RobotInfo.rightEncoderPortA.getInt(), RobotInfo.rightEncoderPortB.getInt());

    public void setLRPower(double lPower, double rPower) {
        leftDrive.set(lPower);
        rightDrive.set(rPower);
    }

    public Encoder getLeftEncoder() {
        return leftEncoder;
    }

    public Encoder getRightEncoder() {
        return rightEncoder;
    }

    public void resetEncoders() {
        rightEncoder.reset();
        leftEncoder.reset();
    }
}
