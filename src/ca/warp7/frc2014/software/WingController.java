package ca.warp7.frc2014.software;

import ca.warp7.frc2014.hardware.Wing;
import ca.warp7.frc2014.robot.Warp7Robot;

public class WingController extends Subsystem {

    private final Wing wing;

    public WingController(Wing wing) {
        this.wing = wing;
    }

    public void periodic() {
        Warp7Robot.ds.table.putNumber("dong", wing.getWristPos());
    }

    public String getName() {
        return null;
    }
}
