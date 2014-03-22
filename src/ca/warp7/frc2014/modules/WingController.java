package ca.warp7.frc2014.modules;

import ca.warp7.frc2014.TwoChainz;
import ca.warp7.frc2014.driverstation.MohitDriverStation;
import ca.warp7.frc2014.hardware.Drive;
import ca.warp7.frc2014.hardware.Wing;
import ca.warp7.frc2014.util.WingModes;
import ca.warp7.robotlib.Warp7Robot;
import ca.warp7.robotlib.parents.ModuleBase;

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

    public void init() {
        setState(WingModes.FLUSH);
    }

    public static WingController getInstance() {
        return instance;
    } // whoo hooray for the singleton pattern

    public void doPeriodicTick() {
        //if we're in low gear, dock.

        //if (((Drive) robot.hw.getHardware("Drive")).isLowGear()) {
        if(false) {
            if (STATE != WingModes.SHOULD_OFF && STATE != WingModes.OFF) { // if we haven't turned off already
                setState(WingModes.SHOULD_OFF); //then turn off
            }
        } else if(((MohitDriverStation) robot.ds).getKillButton()) { // check if kill button is pressed, if so turn off.
            setState(WingModes.OFF);
        } else { //if we're in high gear
            int butt = ((MohitDriverStation) robot.ds).getModeButton();
            if (butt != -1) {
                setState(butt);
            }
        }

        if (backWing.isAtSetpoint() && frontWing.isAtSetpoint()) {
            if (STATE == WingModes.SHOULD_OFF) {
                setState(WingModes.OFF);
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

    void setState(int state) { //synched to stop things from possibly borking

        switch (state) {
            case WingModes.CATCH:
                // Rollers go up, arms go up. \[]/
                frontWing.startRollersUp();
                backWing.startRollersUp();

                backWing.setTargetAngle(135); // guesstimated #s.
                frontWing.setTargetAngle(165);
                break;

            case WingModes.BACK_PICKUP:
                backWing.startRollersDown();
                frontWing.stopRollers();

                backWing.setTargetAngle(80);
                frontWing.setTargetAngle(0);
                break;

            case WingModes.PICKUP:
                //Back rollers down, front off.
                backWing.startRollersDown();
                frontWing.startRollersDown();

                backWing.setTargetAngle(0);
                frontWing.setTargetAngle(85);
                break;


            case WingModes.FLUSH:
            case WingModes.SHOULD_OFF:
                frontWing.stopRollers();
                backWing.stopRollers();

                frontWing.setTargetAngle(0);
                backWing.setTargetAngle(0);
                break;

            case WingModes.PREP_KICK:
                frontWing.stopRollers();
                backWing.stopRollers();

                backWing.setTargetAngle(22);
                frontWing.setTargetAngle(141);
                break;

            case WingModes.DO_KICK:
                backWing.stopRollers();
                frontWing.startRollersUp();

                frontWing.setTargetAngle(175);
                backWing.setTargetAngle(280);
                break;

            case WingModes.ELEVATOR:
                backWing.startRollersDown();
                frontWing.startRollersDown();

                frontWing.setTargetAngle(0);
                backWing.setTargetAngle(0);
                break;

            case WingModes.OFF:
                backWing.disable();
                frontWing.disable();
                break;

        }

        STATE = state;
        robot.ds.table.putNumber("wingMode", STATE);
    }
}
