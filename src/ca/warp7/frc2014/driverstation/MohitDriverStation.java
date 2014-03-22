package ca.warp7.frc2014.driverstation;

import ca.warp7.frc2014.TwoChainz;
import ca.warp7.frc2014.hardware.Drive;
import ca.warp7.frc2014.hardware.Sonar;
import ca.warp7.frc2014.hardware.Wing;
import ca.warp7.frc2014.modules.WingController;
import ca.warp7.robotlib.parents.DriverStationBase;
import ca.warp7.frc2014.util.RobotInfo;
import edu.wpi.first.wpilibj.Joystick;

public class MohitDriverStation extends DriverStationBase {

    //best class name NA
    private final Joystick leftJoy;
    private final Joystick rightJoy;

    private final Wing frontWing, backWing;
    private final Drive drive;
    private final Sonar sonar;

    public MohitDriverStation() {
        super(new DriverStationUpdateListener(), TwoChainz.getInstance());

        leftJoy = new Joystick(RobotInfo.leftJoyPort.getInt());
        rightJoy = new Joystick(RobotInfo.rightJoyPort.getInt());

        sonar = (Sonar) robot.hw.getHardware("Sonar");

        backWing = (Wing) robot.hw.getHardware("backWing");
        frontWing = (Wing) robot.hw.getHardware("frontWing");

        drive = (Drive) robot.hw.getHardware("Drive");
    }

    public void sendSensorInfo() {
        robot.ds.table.putNumber("frontWingEncoder", frontWing.getWristPosition());
        robot.ds.table.putNumber("backWingEncoder", backWing.getWristPosition());
        robot.ds.table.putBoolean("highGear", drive.isHighGear());
        robot.ds.table.putNumber("wingMode", WingController.STATE);
        robot.ds.table.putNumber("Button", getModeButton());
        robot.ds.table.putNumber("sonarDistance", sonar.getDistance());
    }

    //controller stuff
    public boolean getQuickTurnButton() {
        return leftJoy.getTrigger();
    }

    public double getPrimaryX() {
        return leftJoy.getX();
    }

    public double getPrimaryY() {
        return leftJoy.getY();
    }

    public double getSecondaryX() {
        return rightJoy.getX();
    }

    public double getSecondaryY() {
        return rightJoy.getY();
    }

    public int getModeButton() {
        int numModes = 7;
        int offset = 7;
        for (int i = 2; i < (numModes + offset); i++) {
            if (rightJoy.getRawButton(i) && !((i > 2) && (i < 7))) {
                return i; //this allows short circuiting.
                /* TODO: write a new button mapping system, rewrite
                   modlues like minecraftforge to
                   allow dynamic reistration and proper containmenet. */
            }
        }
        return -1;
    }

    public boolean getShiftLowButton() {
        return rightJoy.getTrigger();
    }
}
