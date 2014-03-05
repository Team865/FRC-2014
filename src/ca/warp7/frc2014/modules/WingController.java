package ca.warp7.frc2014.modules;

import ca.warp7.frc2014.robot.Robot;
import ca.warp7.frc2014.util.Util;
import ca.warp7.frc2014.util.WingModes;

public class WingController extends ModuleBase {

    public static int STATE;
    private static WingController instance;
    private final Robot robot;

    public WingController() {
        instance = this;
        robot = Robot.getInstance();
    }

    public void load() {
        setState(WingModes.OFF);
    }

    public static WingController getInstance() {
        return instance;
    } // whoo hooray for the singleton pattern

    public void periodic() {
        int butt = robot.ds.getModeButton();
        if (butt != -1) {
            //System.out.println(butt);
            setState(butt);
        }
        if (robot.hw.backWing.isAtSetpoint()) {
            if (STATE == WingModes.OFF) {
                robot.hw.backWing.disable();
            }
            if( STATE == WingModes.DROP) {
                setState(WingModes.DO_DROP);
            }

        }
        if (robot.hw.frontWing.isAtSetpoint()) {
            if (STATE == WingModes.OFF) {
                robot.hw.frontWing.disable();
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

                robot.hw.frontWing.rollersUp();
                robot.hw.backWing.rollersUp();

                robot.hw.backWing.setTargetAngle(135); // guesstimated #.
                robot.hw.frontWing.setTargetAngle(135);
                break;

            case WingModes.BACK_PICKUP:
                robot.hw.backWing.rollersDown();
                robot.hw.frontWing.rollersOff();

                robot.hw.backWing.setTargetAngle(85);
                robot.hw.frontWing.setTargetAngle(0);
                break;

            case WingModes.PICKUP:
                //Back rollers down, front off.

                robot.hw.backWing.rollersOff();
                robot.hw.frontWing.rollersDown();

                robot.hw.backWing.setTargetAngle(0);
                robot.hw.frontWing.setTargetAngle(85);
                break;


            case WingModes.DO_DROP:
                //Prepare to kick

                robot.hw.backWing.rollersUp();
                robot.hw.frontWing.rollersUp();

                robot.hw.frontWing.setTargetAngle(85);
                robot.hw.backWing.setTargetAngle(300);

                break;
            case WingModes.DROP:
            case WingModes.OFF:
                //redy 4 teh flush
                robot.hw.frontWing.setTargetAngle(0);
                robot.hw.backWing.setTargetAngle(0);

                robot.hw.frontWing.rollersOff();
                robot.hw.backWing.rollersOff();

                break;
        }
    }

    public String getName() {
        return "Wing Controller";
    }
}
