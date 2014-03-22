package ca.warp7.frc2014.hardware;

import ca.warp7.frc2014.util.RobotInfo;
import ca.warp7.robotlib.parents.HardwareBase;
import edu.wpi.first.wpilibj.Talon;

public class Shooter extends HardwareBase {
    private Talon shooterWheel;
    public void init() {
        shooterWheel = new Talon(RobotInfo.shooterWheelPin.getInt());
    }

    public void free() {
        shooterWheel.free();
        shooterWheel = null;
    }
    public void spinWheelForwards() {
        shooterWheel.set(1);
    }
    public void spinWheelBackwards() {
        shooterWheel.set(-1);
    }
    public void stopWheel() {
        shooterWheel.set(0);
    }

}
