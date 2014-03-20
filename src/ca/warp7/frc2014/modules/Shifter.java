package ca.warp7.frc2014.modules;

import ca.warp7.frc2014.TwoChainz;
import ca.warp7.frc2014.driverstation.TheBeast;
import ca.warp7.frc2014.hardware.Drive;
import ca.warp7.robotlib.robot.ModuleBase;

public class Shifter extends ModuleBase {

    public void load() {

    }

    public void periodic() {
        ((Drive) TwoChainz.getInstance().hw.getHardware("Drive")).shift(((TheBeast)TwoChainz.getInstance().ds).getShiftLowButton());
    }
}
