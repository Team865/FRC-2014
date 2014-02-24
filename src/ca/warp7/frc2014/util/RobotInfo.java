package ca.warp7.frc2014.util;


public class RobotInfo extends RobotInfoHandler {

    // Syntax:
    // public static final RobotInfo key = new RobotInfo(key, data);

    //Motor Pins
    public static final RobotInfo testMotorPin = new RobotInfo("testMotorPin", 0);
    public static final RobotInfo leftMotorPort = new RobotInfo("leftMotorPort", 1);
    public static final RobotInfo rightMotorPort = new RobotInfo("rightMotorPort", 2);

    public static final RobotInfo backWingWristPin = new RobotInfo("backWingWristPin", 3);
    public static final RobotInfo backWingRollerPin = new RobotInfo("backWingRollerPin", 4);

    //Encoders
    public static final RobotInfo backWingEncoderPin = new RobotInfo("backWingEncoderPort", 1);

    //Solenoid Breakout
    public static final RobotInfo shifterPort = new RobotInfo("shifterPort", 3);

    //Controller-Specific stuff
    public static final RobotInfo xboxDeadband = new RobotInfo("xboxDeadband", 0.1);
    public static final RobotInfo leftJoyPort = new RobotInfo("leftJoyPort", 1);
    public static final RobotInfo rightJoyPort = new RobotInfo("rightJoyPort", 2);

    // Subsystem-specific tweaking stuff
    public static final RobotInfo cheesyMod = new RobotInfo("cheesyMod", 1.2);
    public static final RobotInfo backWingP = new RobotInfo("backWingP", 0.1);
    public static final RobotInfo backWingI = new RobotInfo("backWingI", 0.001);
    public static final RobotInfo backWingD = new RobotInfo("backWingD", 0.0);

    // Prevent instantiation of this class, as it should only be used statically.
    private RobotInfo() {

    }
}
