package ca.warp7.frc2014.autonomous;


import ca.warp7.frc2014.modules.Vision;
import ca.warp7.frc2014.robot.Robot;
import ca.warp7.frc2014.util.Util;
import edu.wpi.first.wpilibj.Timer;

public class DetectHotTarget {
    public void run() {
        Robot robot = Robot.getInstance();

        Vision v = new Vision();
        Util.log("Vision", v.isHot() ? "Hot" : "Not Hot");

        if (!v.isHot()) { // wait till it is hot
            Timer.delay(2);
        }

        robot.hw.drive.setLRPower(-0.5, -0.5);

        Timer.delay(2); // How long do we drive??
        robot.hw.backWing.rollersDown();
        Timer.delay(0.8);
        robot.hw.drive.setLRPower(0, 0);
        Timer.delay(3);
        robot.hw.backWing.rollersOff();
    }
}
