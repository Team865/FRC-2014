package ca.warp7.frc2014.modules;

import ca.warp7.frc2014.TwoChainz;
import ca.warp7.frc2014.driverstation.MohitDriverStation;
import ca.warp7.frc2014.hardware.Drive;
import ca.warp7.robotlib.Warp7Robot;
import ca.warp7.robotlib.robot.ModuleBase;

public class Shifter extends ModuleBase {

    /**
     * @noinspection EmptyMethod
     */
    public void load() {
        //herpa
    }

    public void periodic() {
        Warp7Robot r = TwoChainz.getInstance();

        ((Drive) r.hw.getHardware("Drive")).shift(((MohitDriverStation) r.ds).getShiftLowButton());
    }
}
