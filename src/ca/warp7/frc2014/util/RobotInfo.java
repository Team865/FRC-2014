package ca.warp7.frc2014.util;


public class RobotInfo extends RobotInfoHandler {

    // Syntax:
    // public static final InfoValue key = new InfoValue(key, data);

    //Motor Pins
    public static final InfoValue leftMotorPort = new InfoValue("leftMotorPort", 1);
    public static final InfoValue rightMotorPort = new InfoValue("rightMotorPort", 2);

    public static final InfoValue backWingWristPin = new InfoValue("backWingWristPin", 3);
    public static final InfoValue backWingRollerPin = new InfoValue("backWingRollerPin", 4);

    public static final InfoValue frontWingWristPin = new InfoValue("frontWingWristPin", 5);
    public static final InfoValue frontWingRollerPin = new InfoValue("frontWingRollerPin", 6);

    //Analog stuff
    public static final InfoValue backWingEncoderPin = new InfoValue("backWingEncoderPort", 1);
    public static final InfoValue frontWingEncoderPin = new InfoValue("frontWingEncoderPort", 2);
    public static final InfoValue sonarPin = new InfoValue("sonarPin", 3);

    //Solenoid Breakout
    public static final InfoValue shifterPort = new InfoValue("shifterPort", 3);

    //Controller-Specific stuff
    public static final InfoValue xboxDeadband = new InfoValue("xboxDeadband", 0.1);
    public static final InfoValue leftJoyPort = new InfoValue("leftJoyPort", 1);
    public static final InfoValue rightJoyPort = new InfoValue("rightJoyPort", 2);

    // SubsystemBase-specific tweaking stuff
    public static final InfoValue cheesyMod = new InfoValue("cheesyMod", 1.2);

    public static final InfoValue backWingP = new InfoValue("backWingP", 0.1);
    public static final InfoValue backWingI = new InfoValue("backWingI", 0.001);
    public static final InfoValue backWingD = new InfoValue("backWingD", 0.0);
    public static final InfoValue backWingZeroPoint = new InfoValue("backWingZeroPoint", 398.0);
    public static final InfoValue backWingSetPoint = new InfoValue("backWingSetPoint", 0.0);

    public static final InfoValue frontWingP = new InfoValue("frontWingP", 0.1);
    public static final InfoValue frontWingI = new InfoValue("frontWingI", 0.001);
    public static final InfoValue frontWingD = new InfoValue("frontWingD", 0.0);
    public static final InfoValue frontWingZeroPoint = new InfoValue("frontWingZeroPoint", 20.0);
    public static final InfoValue frontWingSetPoint = new InfoValue("frontWingSetPoint", 0.0);

    // Prevent instantiation of this class, as it should only be used statically.
    private RobotInfo() {

    }
}
