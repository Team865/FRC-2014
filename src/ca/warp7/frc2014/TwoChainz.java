package ca.warp7.frc2014;// Time Created: 1/4/14 4:57 PM

import ca.warp7.frc2014.autonomous.DetectHotTarget;
import ca.warp7.frc2014.driverstation.MohitDriverStation;
import ca.warp7.frc2014.hardware.CartCompressor;
import ca.warp7.frc2014.hardware.Drive;
import ca.warp7.frc2014.hardware.Sonar;
import ca.warp7.frc2014.hardware.Wing;
import ca.warp7.frc2014.modules.CheesyDrive;
import ca.warp7.frc2014.modules.Shifter;
import ca.warp7.frc2014.modules.WingController;
import ca.warp7.frc2014.util.RobotInfo;
import ca.warp7.robotlib.Warp7Robot;
import ca.warp7.robotlib.parents.AutoMode;
import ca.warp7.robotlib.parents.DriverStationBase;

public class TwoChainz extends Warp7Robot {

    public String getRobotName() {
        return "2 Chainz";
    }

    private AutoMode vision = new DetectHotTarget();

    public void autonomousInit() {
        super.autonomousInit();
        vision.init();
    }

    public void autonomousPeriodic() {
        super.autonomousPeriodic();
        vision.tick();
    }

    public void loadHardware() {
        hw.add(new Drive());

        hw.add(new Wing("frontWing",
                RobotInfo.frontWingWristPin,
                RobotInfo.frontWingRollerPin1,
                RobotInfo.frontWingRollerPin2,
                RobotInfo.frontWingEncoderPin,
                RobotInfo.frontWingP,
                RobotInfo.frontWingI,
                RobotInfo.frontWingD,
                RobotInfo.frontWingZeroPoint));

        hw.add(new Wing("backWing",
                RobotInfo.backWingWristPin,
                RobotInfo.backWingRollerPin1,
                RobotInfo.backWingRollerPin2,
                RobotInfo.backWingEncoderPin,
                RobotInfo.backWingP,
                RobotInfo.backWingI,
                RobotInfo.backWingD,
                RobotInfo.backWingZeroPoint));

        hw.add(new Sonar());
        hw.add(new CartCompressor());
    }

    public void loadModules() {
        modules.add(new CheesyDrive());
        modules.add(new Shifter());
        modules.add(new WingController());
    }

    public DriverStationBase getDriverStation() {
        return new MohitDriverStation();
    }
}
