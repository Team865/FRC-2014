package ca.warp7.frc2014.util;

/**
 * Created with IntelliJ IDEA.
 * User: Ari
 * Date: 1/9/14
 * Time: 3:22 PM
 */
public class RobotInfo {
    private final String key;
    private final double data;


    // Syntax:
    // public static final RobotInfo key = new RobotInfo(key, data);

    public static final RobotInfo leftJoyPort = new RobotInfo("leftJoyPort", 1);
    public static final RobotInfo rightJoyPort = new RobotInfo("rightJoyPort", 2);
    public static final RobotInfo leftMotorPort = new RobotInfo("leftMotorPort", 1);
    public static final RobotInfo rightMotorPort = new RobotInfo("rightMotorPort", 2);
    public static final RobotInfo xboxPin = new RobotInfo("xboxPin", 1);
    public static final RobotInfo xboxDeadband = new RobotInfo("xboxDeadband", 0.1);
    public static final RobotInfo cheesyMod = new RobotInfo("cheesyMod", 1.2);


    public static void loadPrefsFromFile() {
        // LATER
    }

    private RobotInfo(String key, double data) {
        this.key = key;
        this.data = data;

    }

    public double getDouble() {
        return data;
    }

    public int getInt() {
        return (int) data;
    }
}
