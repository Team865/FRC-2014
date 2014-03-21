package ca.warp7.frc2014.modules;

import ca.warp7.frc2014.TwoChainz;
import ca.warp7.frc2014.driverstation.MohitDriverStation;
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
        int butt = ((MohitDriverStation) robot.ds).getModeButton();
        if (butt != -1) {
            setState(butt);
        }
        if (backWing.isAtSetpoint()) {
            if (STATE == WingModes.FLUSH) {
                backWing.stopRollers();
            }
        }
        if (frontWing.isAtSetpoint()) {
            if (STATE == WingModes.FLUSH) {
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

    public synchronized void setState(int state) { //synched to stop things from possibly borking


        switch (state) {
            case WingModes.CATCH:
                // Rollers go up, arms go up. \[]/
                frontWing.startRollersUp();
                backWing.startRollersUp();

                backWing.setTargetAngle(135); // guesstimated #s.
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


            case WingModes.FLUSH:
                frontWing.setTargetAngle(0);
                backWing.setTargetAngle(0);

                frontWing.stopRollers();
                backWing.stopRollers();
                break;

            case WingModes.PREP_KICK:
                backWing.setTargetAngle(22);
                frontWing.setTargetAngle(141);

                frontWing.stopRollers();
                backWing.stopRollers();
                break;

            case WingModes.DO_KICK:
                backWing.stopRollers();
                frontWing.startRollersUp();

                frontWing.setTargetAngle(175);
                backWing.setTargetAngle(300);
                break;
        }

        STATE = state;
        robot.ds.table.putNumber("wingMode", STATE);
    }
}
