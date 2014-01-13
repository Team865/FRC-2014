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
    // public static final RobotInfo varname = new RobotInfo(key, data);

    public static final RobotInfo leftJoyPort = new RobotInfo("leftJoyPort", 1);
    public static final RobotInfo rightJoyPort = new RobotInfo("rightJoyPort", 2);
    public static final RobotInfo controller = new RobotInfo("controller", 0);
    //0: 2 joysticks


    public static void loadPrefsFromFile() {
        // LATER
    }

    private RobotInfo(String key, double data) {
        this.key = key;
        this.data = data;

    }

    public double doubleValue() {
        return data;
    }

    public int getInt() {
        return (int) data;
    }
}
