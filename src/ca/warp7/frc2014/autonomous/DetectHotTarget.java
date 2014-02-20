package ca.warp7.frc2014.autonomous;


import ca.warp7.frc2014.software.Vision;
import ca.warp7.frc2014.util.Util;

public class DetectHotTarget {
    public void run() {
        Vision v = new Vision();
        v.run();
        Util.log("Vision", v.isHot() ? "Hot" : "Not Hot");
        // Disable watchdog here, then re-enable after driving.

    }
}
