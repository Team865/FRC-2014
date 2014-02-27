package ca.warp7.frc2014.software;

import ca.warp7.frc2014.robot.Robot;
import ca.warp7.frc2014.util.WingModes;

public class WingController extends SubsystemBase {

    private static int STATE;
    private int timer = 0;
    private static WingController instance;

    public void periodic() {
        if(timer > 0) {
            timer --;
        }
        if(timer == 0) {
            switch(STATE) {
                case WingModes.DROP:
                    Robot.getInstance().hw.backWing.setTargetAngle(300);
                    break;

            }

            timer = -1;
        }
    }

    public void setState(int state) {
        STATE = state;
        Warp7Robot.ds.table.putNumber("wingMode", STATE);
        Util.log("WingController","State: " + state);
        switch (state) {
            case WingModes.CATCH:
                // Rollers go up, arms go up. \[]/
                Util.log("WingController", "Mode: CATCH");
                Warp7Robot.hw.backWing.rollersUp();
                Warp7Robot.hw.frontWing.rollersUp();
                break;

            case WingModes.HOLD:
                //Rollers shouldn't have to move, arms should be slightly angled in. [\O/]
                Util.log("WingController", "Mode: HOLD");
                Warp7Robot.hw.backWing.rollersOff();
                Warp7Robot.hw.frontWing.rollersOff();
                break;

            case WingModes.FLUSH:
                //Rollers shouldn't have to move, arms should be flush. [| |]
                Robot.getInstance().hw.backWing.rollersOff();
                Robot.getInstance().hw.frontWing.rollersOff();
                break;

            case WingModes.KISS:
                //Rollers should push ball out, back wing should punt ball out, front roller up.
                Util.log("WingController", "Mode: KISS");
                Warp7Robot.hw.frontWing.rollersOff();
                Warp7Robot.hw.backWing.rollersUp();
                break;

            case WingModes.PICKUP:
                //Front rollers down, back off.
                Util.log("WingController", "Mode: PICKUP");
                /*
                Warp7Robot.hw.frontWing.rollersDown();
                Warp7Robot.hw.backWing.rollersOff();
                */
                //TODO REMOVE THIS DEBUG vvvvvvvvvvvvvvvv
                Warp7Robot.hw.backWing.rollersDown();
                Warp7Robot.hw.frontWing.rollersOff();
                // END TODO

                Warp7Robot.hw.backWing.setTargetAngle(85);
                Warp7Robot.hw.frontWing.setTargetAngle(0);

                break;
            case WingModes.DROP:
                //Kick it out.
                Util.log("WingController", "Mode: DROP");
                Warp7Robot.hw.frontWing.rollersUp();
                Warp7Robot.hw.backWing.rollersOff();

                Warp7Robot.hw.frontWing.setTargetAngle(180);
                Warp7Robot.hw.backWing.setTargetAngle(90);
                timer = 30;
                break;


        }

    }

    public String getName() {
        return "Wing Controller";
    }
}
