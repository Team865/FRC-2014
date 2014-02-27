package ca.warp7.frc2014.software;

import ca.warp7.frc2014.robot.Robot;
import ca.warp7.frc2014.util.WingModes;

public class WingController extends SubsystemBase {

    private int STATE = WingModes.FLUSH;

    public void periodic() {
        setState(Robot.getInstance().ds.controller.getModeButton());
    }

    public void setState(int state) {
        STATE = state;
        if (state != 0) { // if there's a new state

            switch (state) {
                case WingModes.CATCH:
                    // Rollers go up, arms go up. \[]/
                    Robot.getInstance().hw.backWing.rollersUp();
                    Robot.getInstance().hw.frontWing.rollersUp();
                    break;

                case WingModes.HOLD:
                    //Rollers shouldn't have to move, arms should be slightly angled in. [\O/]
                    Robot.getInstance().hw.backWing.rollersOff();
                    Robot.getInstance().hw.frontWing.rollersOff();
                    break;

                case WingModes.FLUSH:
                    //Rollers shouldn't have to move, arms should be flush. [| |]
                    Robot.getInstance().hw.backWing.rollersOff();
                    Robot.getInstance().hw.frontWing.rollersOff();
                    break;

                case WingModes.KISS:
                    //Rollers should push ball out, back wing should punt ball out, front roller up.
                    Robot.getInstance().hw.frontWing.rollersOff();
                    Robot.getInstance().hw.backWing.rollersUp();
                    break;

                case WingModes.PICKUP:
                    //Front rollers down, back off.
                    Robot.getInstance().hw.frontWing.rollersDown();
                    Robot.getInstance().hw.backWing.rollersOff();
                    break;
                case WingModes.DP:
                    //Dual-pass ;)
                    //in back, out front.
                    Robot.getInstance().hw.frontWing.rollersUp();
                    Robot.getInstance().hw.backWing.rollersDown();


            }
        }

    }

    public String getName() {
        return "Wing Controller";
    }
}
