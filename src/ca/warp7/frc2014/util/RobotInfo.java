package ca.warp7.frc2014.util;

import java.util.HashMap;

/**
 * Created with IntelliJ IDEA.
 * User: Ari
 * Date: 1/9/14
 * Time: 3:22 PM
 */
public class RobotInfo {
    public static HashMap<String, Number> infoMap = new HashMap<String, Number>();

    // Syntax:
    // new RobotInfo(key, data);

    static {
        new RobotInfo("leftJoyPort", 1);
        new RobotInfo("rightJoyPort", 2);
    }

    public static void loadPrefsFromFile() {
        // LATER
    }

    private RobotInfo(String key, Number data) {
        infoMap.put(key, data);
    }

    public static int getInt(String key) {
        return (Integer) infoMap.get(key);
    }

    public static double getDouble(String key) {
        return (Double) infoMap.get(key);
    }

}
