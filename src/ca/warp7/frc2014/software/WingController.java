package ca.warp7.frc2014.software;

import ca.warp7.frc2014.robot.Warp7Robot;
import ca.warp7.frc2014.util.WingModes;

public class WingController extends SubsystemBase {

    private int STATE = WingModes.FLUSH;

    public void periodic() {
        Warp7Robot.hw.sonar.getDistance();
        Warp7Robot.ds.table.putNumber("encoder", Warp7Robot.hw.backWing.getWristEncoder().getAverageValue());
        Warp7Robot.ds.table.putNumber("setPoint", Warp7Robot.hw.backWing.getWristEncoder().getAverageValue());
    }

    public void setState(int state) {
        STATE = state;
        switch (state) {
            case WingModes.CATCH:
                // Rollers go up, arms go up. \[]/
                Warp7Robot.hw.backWing.rollersUp();
                Warp7Robot.hw.frontWing.rollersUp();
                break;

            case WingModes.HOLD:
                //Rollers shouldn't have to move, arms should be slightly angled in. [\O/]
                Warp7Robot.hw.backWing.rollersOff();
                Warp7Robot.hw.frontWing.rollersOff();
                break;

            case WingModes.FLUSH:
                //Rollers shouldn't have to move, arms should be flush. [| |]
                Warp7Robot.hw.backWing.rollersOff();
                Warp7Robot.hw.frontWing.rollersOff();
                break;

            case WingModes.KISS:
                //Rollers should push ball out, back wing should punt ball out, front roller up.
                Warp7Robot.hw.frontWing.rollersOff();
                Warp7Robot.hw.backWing.rollersUp();
                break;

            case WingModes.PICKUP:
                //Front rollers down, back off.
                Warp7Robot.hw.frontWing.rollersDown();
                Warp7Robot.hw.backWing.rollersOff();
                break;
            case WingModes.DP:
                //Dual-pass ;)
                //in back, out front.
                Warp7Robot.hw.frontWing.rollersUp();
                Warp7Robot.hw.backWing.rollersDown();


        }

    }

    public String getName() {
        return "Wing Controller";
    }
}
