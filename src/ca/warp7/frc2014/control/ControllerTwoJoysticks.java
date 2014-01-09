package ca.warp7.frc2014.control;

import ca.warp7.frc2014.util.RobotInfo;
import edu.wpi.first.wpilibj.Joystick;

/**
 * Created with IntelliJ IDEA.
 * User: Aidan
 * Date: 1/9/14
 * Time: 3:41 PM
 */
public class ControllerTwoJoysticks extends Controller {
    private final Joystick joy1;
    private final Joystick joy2;

    public ControllerTwoJoysticks() {
        this.joy1 = new Joystick(RobotInfo.leftJoyPort.intValue());
        this.joy2 = new Joystick(RobotInfo.rightJoyPort.intValue());

    }

    public double getPrimaryX() {
        return 0;  //To change body of implemented methods use File | Settings | File Templates.
    }

    public double getPrimaryY() {
        return 0;  //To change body of implemented methods use File | Settings | File Templates.
    }

    public double getSecondaryX() {
        return 0;  //To change body of implemented methods use File | Settings | File Templates.
    }

    public double getSecondaryY() {
        return 0;  //To change body of implemented methods use File | Settings | File Templates.
    }

    public boolean getAction1() {
        return false;  //To change body of implemented methods use File | Settings | File Templates.
    }

    public boolean getAction2() {
        return false;  //To change body of implemented methods use File | Settings | File Templates.
    }

    public boolean getAction3() {
        return false;  //To change body of implemented methods use File | Settings | File Templates.
    }

    public boolean getAction4() {
        return false;  //To change body of implemented methods use File | Settings | File Templates.
    }
}
