package ca.warp7.frc2014.modules;

import ca.warp7.frc2014.TwoChainz;
import ca.warp7.frc2014.driverstation.MohitDriverStation;
import ca.warp7.frc2014.hardware.Wing;
import ca.warp7.frc2014.util.WingModes;
import ca.warp7.robotlib.Warp7Robot;
import ca.warp7.robotlib.robot.ModuleBase;

public class WingController extends ModuleBase {

    public static int STATE;
    private static WingController instance;
    private final Warp7Robot robot;
    private final Wing backWing, frontWing;

    public WingController() {
        instance = this;
        robot = TwoChainz.getInstance();
        backWing = (Wing) robot.hw.getHardware("backWing");
        frontWing = (Wing) robot.hw.getHardware("frontWing");
    }

    public void load() {
        setState(WingModes.OFF);
    }

    public static WingController getInstance() {
        return instance;
    } // whoo hooray for the singleton pattern

    public void periodic() {
        int butt = ((MohitDriverStation)robot.ds).getModeButton();
        if (butt != -1) {
            setState(butt);
        }
        if (backWing.isAtSetpoint()) {
            if (STATE == WingModes.OFF) {
                backWing.stopRollers();
            }
        }
        if (frontWing.isAtSetpoint()) {
            if (STATE == WingModes.OFF) {
                frontWing.disable();
            }
        }

        /*
        if(STATE == WingModes.CATCH) { // go dowm
            if(robot.hw.sonar.notHoldingBall()) {
                this.setState(WingModes.HOLD);
            }
        }
        */

        //disabled for testing

        /*
        if(robot.hw.sonar.ballAbove()) { // this might make thigns very bad be careful
            this.setState(WingModes.CATCH);
        }
        */
    }

    public void setState(int state) {
        STATE = state;
        robot.ds.table.putNumber("wingMode", STATE);

        switch (state) {
            case WingModes.CATCH:
                // Rollers go up, arms go up. \[]/

                frontWing.startRollersUp();
                backWing.startRollersUp();

                backWing.setTargetAngle(135); // guesstimated #.
                frontWing.setTargetAngle(135);
                break;

            case WingModes.BACK_PICKUP:
                backWing.startRollersDown();
                frontWing.stopRollers();

                backWing.setTargetAngle(80);
                frontWing.setTargetAngle(0);
                break;

            case WingModes.PICKUP:
                //Back rollers down, front off.

                backWing.stopRollers();
                frontWing.startRollersDown();

                backWing.setTargetAngle(0);
                frontWing.setTargetAngle(85);
                break;
            case WingModes.DROP:
                //Prepare to kick

                backWing.startRollersUp();
                frontWing.startRollersUp();

                frontWing.setTargetAngle(175);
                backWing.setTargetAngle(300);
                break;

            case WingModes.OFF:
                //redy 4 teh flush
                frontWing.setTargetAngle(0);
                backWing.setTargetAngle(0);

                frontWing.stopRollers();
                backWing.stopRollers();

                break;

            case WingModes.GOAL_KICK:
                backWing.setTargetAngle(22);
                frontWing.setTargetAngle(141);

                frontWing.startRollersDown();
                break;

            case WingModes.SHOOT:
                frontWing.setTargetAngle(0);
                backWing.setTargetAngle(0);

                backWing.startRollersUp();
                frontWing.startRollersUp();
                break;
        }
    }
}
