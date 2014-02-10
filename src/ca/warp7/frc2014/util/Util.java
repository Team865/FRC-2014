package ca.warp7.frc2014.util;

import java.util.Vector;

/**
 * Created with IntelliJ IDEA.
 * User: Ari
 * Date: 1/9/14
 * Time: 3:22 PM
 */
public class Util {
    private Util() {
        // Stop an instance of this class from being created
    }

    /**
     * Stolen from
     * https://github.com/Team254/FRC-2013/blob/master/src/com/team254
     * /lib/util/Util.java
     */
    public static double limit(double v, double limit) {
        return (Math.abs(v) < limit) ? v : limit * (v < 0 ? -1 : 1); //This is used for cheesydrive, if we're gonna use it.
    }

    public static void log(String string) {
        System.out.println(string);
    }

    public static double deadband(double rawAxis) {
        return Math.abs(rawAxis) > Math.abs(RobotInfo.xboxDeadband.getDouble()) ? rawAxis : 0.0; // return rawAxis if it's above .1, otherwise return 0.
    }

    /**
     * Returns the array of substrings obtained by dividing the given input string at each occurrence
     * of the given delimiter.
     */
    public static String[] split(String input, String delimiter) {
        Vector node = new Vector();
        int index = input.indexOf(delimiter);
        while (index >= 0) {
            node.addElement(input.substring(0, index));
            input = input.substring(index + delimiter.length());
            index = input.indexOf(delimiter);
        }
        node.addElement(input);

        String[] retString = new String[node.size()];
        for (int i = 0; i < node.size(); ++i) {
            retString[i] = (String) node.elementAt(i);
        }

        return retString;
    }
}
