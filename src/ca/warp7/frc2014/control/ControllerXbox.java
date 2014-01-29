package ca.warp7.frc2014.control;

import ca.warp7.frc2014.util.RobotInfo;
import ca.warp7.frc2014.util.Util;
import edu.wpi.first.wpilibj.Joystick;

/**
 * Created with IntelliJ IDEA.
 * User: Ari
 * Date: 1/29/14
 * Time: 12:56 PM
 */
public class ControllerXbox extends Controller {
    private final Joystick con = new Joystick(RobotInfo.xboxPin.getInt());

    public double getPrimaryX() {
        return Util.deadband(con.getRawAxis(1)); //LeftX
    }

    public double getPrimaryY() {
        return Util.deadband(con.getRawAxis(2)); //LeftY
    }

    public double getSecondaryX() {
        return Util.deadband(con.getRawAxis(4)); //RightX
    }

    public double getSecondaryY() {
        return Util.deadband(con.getRawAxis(5)); //RightY

    }

    public boolean getPrimaryAction() {
        return con.getRawButton(1); //A
    }

    public boolean getSecondaryAction() {
        return con.getRawButton(2); //B
    }

    public boolean getTertiaryAction() {
        return con.getRawButton(3); //X
    }

    public boolean getQuaternaryAction() {
        return con.getRawButton(4); //Y
    }
}
