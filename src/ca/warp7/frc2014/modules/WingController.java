package ca.warp7.frc2014.modules;

import ca.warp7.frc2014.robot.Robot;
import ca.warp7.frc2014.util.Util;
import ca.warp7.frc2014.util.WingModes;

public class WingController extends ModuleBase {

    private int STATE;
    private int timer = 0;
    private static WingController instance;
    private final Robot robot;

    public WingController() {
        instance = this;
        robot = Robot.getInstance();
    }

    public static WingController getInstance() {
        return instance;
    }

    public void periodic() {
        setState(robot.ds.controller.getModeButton());
        if (timer > 0) {
            timer--;
        }
        if (timer == 0) {
            switch (STATE) {
                case WingModes.DROP:
                    robot.hw.backWing.setTargetAngle(300);
                    break;

            }

            timer = -1;
        }
    }

    public void setState(int state) {
        if (state != -1) {
            STATE = state;
            robot.ds.table.putNumber("wingMode", STATE);
            Util.log("WingController", "State: " + state);
            switch (state) {
                case WingModes.CATCH:
                    // Rollers go up, arms go up. \[]/
                    Util.log("WingController", "Mode: CATCH");
                    robot.hw.backWing.rollersUp();
                    robot.hw.frontWing.rollersUp();
                    break;

                case WingModes.HOLD:
                    //Rollers shouldn't have to move, arms should be slightly angled in. [\O/]
                    Util.log("WingController", "Mode: HOLD");
                    robot.hw.backWing.rollersOff();
                    robot.hw.frontWing.rollersOff();
                    break;

                case WingModes.OFF:
                    //Rollers shouldn't have to move, arms should be flush. [| |]
                    robot.hw.backWing.rollersOff();
                    robot.hw.frontWing.rollersOff();
                    break;

                case WingModes.KISS:
                    //Rollers should push ball out, back wing should punt ball out, front roller up.
                    Util.log("WingController", "Mode: KISS");
                    robot.hw.frontWing.rollersOff();
                    robot.hw.backWing.rollersUp();
                    break;

                case WingModes.PICKUP:
                    //Front rollers down, back off.
                    Util.log("WingController", "Mode: PICKUP");
                /*
                robot.hw.frontWing.rollersDown();
                robot.hw.backWing.rollersOff();
                */
                    //TODO REMOVE THIS DEBUG vvvvvvvvvvvvvvvv
                    robot.hw.backWing.rollersDown();
                    robot.hw.frontWing.rollersOff();
                    // END TODO

                    robot.hw.backWing.setTargetAngle(85);
                    robot.hw.frontWing.setTargetAngle(0);

                    break;
                case WingModes.DROP:
                    //Kick it out.
                    Util.log("WingController", "Mode: DROP");
                    robot.hw.frontWing.rollersUp();
                    robot.hw.backWing.rollersOff();

                    robot.hw.frontWing.setTargetAngle(180);
                    robot.hw.backWing.setTargetAngle(90);
                    timer = 30;
                    break;


            }
        }
    }

    public String getName() {
        return "Wing Controller";
    }
}
