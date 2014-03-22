package ca.warp7.frc2014.autonomous;


import ca.warp7.frc2014.TwoChainz;
import ca.warp7.frc2014.hardware.Drive;
import ca.warp7.frc2014.hardware.Wing;
import ca.warp7.frc2014.modules.Vision;
import ca.warp7.frc2014.modules.WingController;
import ca.warp7.robotlib.Warp7Robot;
import ca.warp7.robotlib.util.Util;
import edu.wpi.first.wpilibj.Timer;

public class DetectHotTarget implements Runnable {
    public void run() {

        Warp7Robot robot = TwoChainz.getInstance();
        Drive drive = (Drive) robot.hw.getHardware("Drive");
        Wing backWing = (Wing) robot.hw.getHardware("backWing");

        Vision v = new Vision();
        Util.log(this, v.isHot() ? "Hot" : "Not Hot");

        if (!v.isHot()) { // wait till it is hot
            Timer.delay(2);
        }

        drive.setLRPower(0.5, 0.5);

        Timer.delay(2.1); // How long do we drive??

        backWing.startRollersUp();
        Timer.delay(0.6);
        drive.setLRPower(0, 0);
        Timer.delay(3);
        backWing.stopRollers();
        drive.setLRPower(-0.5, -0.5);

        Timer.delay(1); // How long do we drive??
        drive.setLRPower(0,0);

    }
}
