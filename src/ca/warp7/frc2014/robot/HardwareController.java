package ca.warp7.frc2014.robot;

import ca.warp7.frc2014.hardware.Compressor;
import ca.warp7.frc2014.hardware.Drive;
import ca.warp7.frc2014.hardware.Sonar;
import ca.warp7.frc2014.hardware.Wing;
import ca.warp7.frc2014.util.RobotInfo;

public class HardwareController {
    public final Drive drive;
    public final Wing frontWing;
    public final Wing backWing;
    public final Sonar sonar;
    public final Compressor comp;

    public HardwareController() {

        drive = new Drive();
        frontWing = new Wing(RobotInfo.frontWingWristPin.getInt(),
                RobotInfo.frontWingRollerPin1.getInt(),
                RobotInfo.frontWingRollerPin2.getInt(),
                RobotInfo.frontWingEncoderPin.getInt(),
                RobotInfo.frontWingP,
                RobotInfo.frontWingI,
                RobotInfo.frontWingD,
                RobotInfo.frontWingZeroPoint);

        backWing = new Wing(RobotInfo.backWingWristPin.getInt(),
                RobotInfo.backWingRollerPin1.getInt(),
                RobotInfo.backWingRollerPin2.getInt(),
                RobotInfo.backWingEncoderPin.getInt(),
                RobotInfo.backWingP,
                RobotInfo.backWingI,
                RobotInfo.backWingD,
                RobotInfo.backWingZeroPoint);


        sonar = new Sonar();
        comp = new Compressor();
    }

    public void load() {
        backWing.load();
        frontWing.load();
    }

}
