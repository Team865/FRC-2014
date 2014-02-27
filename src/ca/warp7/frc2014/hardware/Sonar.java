package ca.warp7.frc2014.hardware;

import ca.warp7.frc2014.robot.Robot;
import ca.warp7.frc2014.util.RobotInfo;
import edu.wpi.first.wpilibj.AnalogChannel;

public class Sonar {
    private final AnalogChannel chan;

    public Sonar() {
        chan = new AnalogChannel(RobotInfo.sonarPin.getInt());
    }

    public double getDistance() { //In CM
        return (chan.getVoltage() * 1000) / 4.9;
    }

    public boolean ballDetected() {
        Robot.getInstance().ds.table.putBoolean("dispence", getDistance() < 50);
        return getDistance() < 50;
    }
}
