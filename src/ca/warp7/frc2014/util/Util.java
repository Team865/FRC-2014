package ca.warp7.frc2014.util;

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
     *
     * @author richard@team254.com (Richard Lin)
     * @author brandon.gonzalez.451@gmail.com (Brandon Gonzalez) Thanks to the
     * cheesy poofs! Limits the given input to the given magnitude.
     */
    public static double limit(double v, double limit) {
        return (Math.abs(v) < limit) ? v : limit * (v < 0 ? -1 : 1); //This is used for cheesydrive, if we're gonna use it.
    }

    public static void log(String string) {
        System.out.println(string);
    }
}
