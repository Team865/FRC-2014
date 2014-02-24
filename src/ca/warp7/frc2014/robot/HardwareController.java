package ca.warp7.frc2014.robot;

import ca.warp7.frc2014.hardware.Drive;
import ca.warp7.frc2014.hardware.Wing;
import ca.warp7.frc2014.util.RobotInfo;

public class HardwareController {
    public final Drive drive;
    public final Wing backWing;

    public HardwareController() {
        drive = new Drive();
        backWing = new Wing(RobotInfo.backWingWristPin.getInt(),
                RobotInfo.backWingRollerPin.getInt(),
                RobotInfo.backWingEncoderPin.getInt(),
                RobotInfo.backWingP.getDouble(),
                RobotInfo.backWingI.getDouble(),
                RobotInfo.backWingD.getDouble());
    }

    public void freeAll() {
        drive.free();
        backWing.free();
    }
}
