package ca.warp7.frc2014.autonomous;

import ca.warp7.frc2014.TwoChainz;
import ca.warp7.frc2014.hardware.Drive;
import ca.warp7.frc2014.hardware.Wing;
import ca.warp7.robotlib.Warp7Robot;
import ca.warp7.robotlib.parents.AutoMode;
import edu.wpi.first.wpilibj.Timer;

public class ScoreLowGoal extends AutoMode {
    Thread wtfThread;
    public void init() {
        wtfThread = new Thread(new Runnable() {
            public void run() {
                Warp7Robot robot = TwoChainz.getInstance();
                Drive drive = (Drive) robot.hw.getHardware("Drive");
                Wing backWing = (Wing) robot.hw.getHardware("backWing");
                Wing frontWing = (Wing) robot.hw.getHardware("frontWing");
                drive.shift(true);
                drive.setLRPower(-0.5, -0.5);
                Timer.delay(2.7); // How long do we drive??
                backWing.startRollersUp();
                frontWing.startRollersUp();
                drive.setLRPower(0, 0);
                Timer.delay(3);
                backWing.stopRollers();
                frontWing.stopRollers();
                drive.setLRPower(0, 0);
            }
        });
        wtfThread.start();
    }

    public void disable() {
        try {
            wtfThread.interrupt();
        } catch (NullPointerException n) {
            //fail silently. that means auton was already disabled.
        }
        ((Drive) TwoChainz.getInstance().hw.getHardware("Drive")).setLRPower(0, 0);
    }

    public void tick() {
        //ding dong tock
    }
}
