package ca.warp7.frc2014.hardware;

import ca.warp7.robotlib.parents.HardwareBase;
import ca.warp7.robotlib.util.RobotInfo;
import edu.wpi.first.wpilibj.AnalogChannel;

public class Sonar extends HardwareBase {
    private AnalogChannel chan;

    public void init() {
        chan = new AnalogChannel(RobotInfo.sonarPin.getInt());
    }

    public void free() {
        chan.free();
        chan = null;
    }

    public double getDistance() { //In CM
        return (chan.getVoltage() * 1000) / 4.9;
    }

    public boolean ballAbove() {
        return getDistance() < 80 && notHoldingBall();
    }

    boolean notHoldingBall() {
        return getDistance() < 20;
    }
}
