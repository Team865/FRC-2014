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
import edu.wpi.first.wpilibj.Timer;

public class TwoChainz extends Warp7Robot {

    private AutoMode vision = new DetectHotTarget();

    public String getRobotName() {
        return "2 Chainz";
    }

    public void autonomousInit() {
        super.autonomousInit();
        //FUCK IT DO IT HERE
        Warp7Robot robot = TwoChainz.getInstance();
        Drive drive = (Drive) robot.hw.getHardware("Drive");
        Wing backWing = (Wing) robot.hw.getHardware("backWing");
        drive.setLRPower(0.5, 0.5);
        //NO HOT GOAL FOR NOW.
        Timer.delay(2.1); // How long do we drive??
        backWing.startRollersUp();
        Timer.delay(0.6);
        drive.setLRPower(0, 0);
        Timer.delay(3);
        backWing.stopRollers();
        drive.setLRPower(-0.5, -0.5);
        Timer.delay(1); // How long do we drive??
        drive.setLRPower(0, 0);
        //vision.init();
    }

    public void autonomousPeriodic() {
        super.autonomousPeriodic();
        //vision.tick();
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
