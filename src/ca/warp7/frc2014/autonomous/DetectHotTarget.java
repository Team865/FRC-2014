package ca.warp7.frc2014.autonomous;


import ca.warp7.frc2014.robot.Robot;
import ca.warp7.frc2014.software.Vision;
import ca.warp7.frc2014.util.Util;
import edu.wpi.first.wpilibj.Timer;

public class DetectHotTarget {
    public void run() {
        Vision v = new Vision();
        v.run();
        Util.log("Vision", v.isHot() ? "Hot" : "Not Hot");
        // Disable watchdog here, then re-enable after driving.
        if (!v.isHot()) { // wait till it is hot
            Timer.delay(4.5);
        }
        Robot.getInstance().hw.drive.setLRPower(1, 1);
        Timer.delay(2); // How long do we drive??
        Robot.getInstance().hw.drive.setLRPower(0, 0);
    }
}
