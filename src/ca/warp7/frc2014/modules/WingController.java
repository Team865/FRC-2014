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
    public void load() {
        setState(WingModes.OFF);
    }

    public static WingController getInstance() {
        return instance;
    } // whoo hooray for the singleton pattern

    public void periodic() {
        int butt = robot.ds.controller.getModeButton();
        if (butt != -1) {
            //System.out.println(butt);
            setState(butt);
        }

        if (timer > 0) {
            timer--;
        }

        if (timer == 0) {
            switch (STATE) {
                case WingModes.DROP:
                case WingModes.KISS:
                    setState(WingModes.DROP_KICK);
                    break;

                case WingModes.DROP_KICK:
                case WingModes.CATCH:
                    setState(WingModes.OFF); //Reset to neutral
                    break;
            }

            timer = -1;
        }

        /*
        if(STATE == WingModes.CATCH) { // go dowm
            if(robot.hw.sonar.ballHolding()) {
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
                Util.log("WingController", "Mode: CATCH");

                robot.hw.frontWing.rollersUp();
                robot.hw.backWing.rollersUp();

                robot.hw.backWing.setTargetAngle(135); // guesstimated #.
                robot.hw.frontWing.setTargetAngle(135);
                timer = 120;
                break;

            case WingModes.HOLD:
                //Rollers shouldn't have to move, arms should be slightly angled in. [\O/]
                Util.log("WingController", "Mode: HOLD");

                robot.hw.frontWing.rollersOff();
                robot.hw.backWing.rollersOff();

                robot.hw.frontWing.setTargetAngle(90); // ALso guesstimated
                robot.hw.backWing.setTargetAngle(90); //halp
                //what am i doing asdfkjahdslkjffzgxkjlv zcx,mcv,lmz7uynhyju n
                //90 for testing ONLY FOR 0
                break;

            case WingModes.KISS:
                //Rollers should push ball out, front wing should punt ball out, back roller up.
                //same as drop but back goes up.
                Util.log("WingController", "Mode: KISS");

                robot.hw.backWing.rollersUp();
                robot.hw.frontWing.rollersOff();

                robot.hw.backWing.setTargetAngle(180);
                robot.hw.frontWing.setTargetAngle(120);
                //oh baby i didn't code this yet
                break;

            case WingModes.PICKUP:
                //Back rollers down, front off.
                Util.log("WingController", "Mode: PICKUP");

                robot.hw.backWing.rollersDown();
                robot.hw.frontWing.rollersOff();

                robot.hw.backWing.setTargetAngle(0);
                robot.hw.frontWing.setTargetAngle(85);
                break;

            case WingModes.DROP:
                //Prepare to kick
                Util.log("WingController", "Mode: DROP");

                robot.hw.backWing.rollersUp();
                robot.hw.frontWing.rollersOff();

                robot.hw.frontWing.setTargetAngle(100);
                robot.hw.backWing.setTargetAngle(120);

                timer = 30;
                break;

            case WingModes.DROP_KICK:
                //KICK THE SHIT OUT OF IT
                Util.log("WingController", "Mode: DROP");

                robot.hw.backWing.setTargetAngle(300);

                timer = 30;
                break;

            case WingModes.OFF:
                /*
                if (Robot.getInstance().hw.sonar.ballHolding()) { // if ya see dem balls
                    this.setState(WingModes.HOLD); // Grab dem balls
                    break;
                }
                */

                Util.log("WingController", "Mode: SHOULD_OFF");
                //redy 4 teh flush
                robot.hw.frontWing.disable();
                robot.hw.backWing.disable();
                break;
        }
    }

    public String getName() {
        return "Wing Controller";
    }
}
