package ca.warp7.frc2014.modules;

import ca.warp7.frc2014.TwoChainz;
import ca.warp7.frc2014.driverstation.MohitDriverStation;
import ca.warp7.frc2014.hardware.Drive;
import ca.warp7.robotlib.robot.ModuleBase;

public class Shifter extends ModuleBase {

    public void load() {

    }

    public void periodic() {
        ((Drive) TwoChainz.getInstance().hw.getHardware("Drive")).shift(((MohitDriverStation)TwoChainz.getInstance().ds).getShiftLowButton());
    }
}
