package ca.warp7.frc2014.autonomous;

import ca.warp7.frc2014.TwoChainz;
import ca.warp7.frc2014.hardware.Drive;
import ca.warp7.robotlib.Warp7Robot;
import ca.warp7.robotlib.parents.AutoMode;
import edu.wpi.first.wpilibj.Timer;

public class Mobility extends AutoMode {
    public void init() {
        Warp7Robot robot = TwoChainz.getInstance();
        Drive drive = (Drive) robot.hw.getHardware("Drive");
        drive.setLRPower(-1, -1);
        Timer.delay(1.5);
        drive.setLRPower(0, 0);
    }

    public void disable() {
    }

    public void tick() {

    }
}
