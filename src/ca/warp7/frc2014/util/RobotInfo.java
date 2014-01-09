package ca.warp7.frc2014.util;

/**
 * Created with IntelliJ IDEA.
 * User: Ari
 * Date: 1/9/14
 * Time: 3:22 PM
 */
public class RobotInfo {
    private double data;

    // Syntax:
    // public static final RobotInfo varname = new RobotInfo(key, data);

    public static void loadPrefsFromFile() {
        // LATER
    }

    public RobotInfo(String key, double data) {
        this.data = data;
    }

    public double doubleValue() {
        return data;
    }

    public int intValue() {
        return (int) data;
    }
}
