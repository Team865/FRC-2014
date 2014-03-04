package ca.warp7.frc2014.util;


public class RobotInfo extends RobotInfoHandler {

    // Syntax:
    // public static final InfoValue key = new InfoValue(key, data);

    //Motor Pins
    public static final InfoValue rightMotorPort = new InfoValue("rightMotorPort", 1);
    public static final InfoValue leftMotorPort = new InfoValue("leftMotorPort", 2);

    public static final InfoValue frontWingWristPin = new InfoValue("frontWingWristPin", 4);
    public static final InfoValue frontWingRollerPin1 = new InfoValue("frontWingRollerPin", 7);
    public static final InfoValue frontWingRollerPin2 = new InfoValue("frontWingRollerPin", 8);

    public static final InfoValue backWingWristPin = new InfoValue("backWingWristPin", 3);
    public static final InfoValue backWingRollerPin1 = new InfoValue("backWingRollerPin", 5);
    public static final InfoValue backWingRollerPin2 = new InfoValue("backWingRollerPin", 6);

    //Analog stuff
    public static final InfoValue frontWingEncoderPin = new InfoValue("frontWingEncoderPort", 2);
    public static final InfoValue backWingEncoderPin = new InfoValue("backWingEncoderPort", 1);

    public static final InfoValue sonarPin = new InfoValue("sonarPin", 3);

    //Solenoid Breakout
    public static final InfoValue shifterPort = new InfoValue("shifterPort", 3);

    //Controller-Specific stuff
    public static final InfoValue leftJoyPort = new InfoValue("leftJoyPort", 1);
    public static final InfoValue rightJoyPort = new InfoValue("rightJoyPort", 2);

    // Module-specific tweaking stuff
    public static final InfoValue cheesyHigh = new InfoValue("cheesyHigh", .85);
    public static final InfoValue cheesyLow = new InfoValue("cheesyLow", .75);

    public static final InfoValue frontWingP = new InfoValue("frontWingP", 0.1);
    public static final InfoValue frontWingI = new InfoValue("frontWingI", 0.001);
    public static final InfoValue frontWingD = new InfoValue("frontWingD", 0.0);
    public static final InfoValue frontWingZeroPoint = new InfoValue("frontWingZeroPoint", 398.0);

    public static final InfoValue backWingP = new InfoValue("backWingP", 0.07);
    public static final InfoValue backWingI = new InfoValue("backWingI", 0.00013);
    public static final InfoValue backWingD = new InfoValue("backWingD", 0.00001);
    public static final InfoValue backWingZeroPoint = new InfoValue("backWingZeroPoint", 20.0);

    // Prevent instantiation of this class, as it should only be used statically.
    private RobotInfo() {

    }
}
