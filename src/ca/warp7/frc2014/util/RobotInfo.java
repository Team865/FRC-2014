package ca.warp7.frc2014.util;


public class RobotInfo extends RobotInfoHandler {

    // Syntax:
    // public static final RobotInfo key = new RobotInfo(key, data);

    public static final RobotInfo leftJoyPort = new RobotInfo("leftJoyPort", 1);
    public static final RobotInfo rightJoyPort = new RobotInfo("rightJoyPort", 2);

    public static final RobotInfo leftMotorPort = new RobotInfo("leftMotorPort", 1);
    public static final RobotInfo rightMotorPort = new RobotInfo("rightMotorPort", 2);

    public static final RobotInfo shifterPort = new RobotInfo("shifterPort", 3);

    public static final RobotInfo xboxPin = new RobotInfo("xboxPin", 1);
    public static final RobotInfo xboxDeadband = new RobotInfo("xboxDeadband", 0.1);


    public static final RobotInfo cheesyMod = new RobotInfo("cheesyMod", 1.2);

    static {
        // Set any overridden constants from the file on startup.
        readInfoFromFile();
    }

    // Prevent instantiation of this class, as it should only be used statically.
    private RobotInfo() {
    }
}
