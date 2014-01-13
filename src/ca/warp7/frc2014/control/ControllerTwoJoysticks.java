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
        this.joy1 = new Joystick(RobotInfo.getInt("leftJoyPort"));
        this.joy2 = new Joystick(RobotInfo.getInt("rightJoyPort"));

    }

    public double getPrimaryX() {
        return joy1.getX();
    }

    public double getPrimaryY() {
        return joy1.getY();
    }

    public double getSecondaryX() {
        return joy2.getX();
    }

    public double getSecondaryY() {
        return joy2.getY();
    }

    public boolean getPrimaryAction() {
        return false;
    }

    public boolean getSecondaryAction() {
        return false;
    }

    public boolean getTertiaryAction() {
        return false;
    }

    public boolean getQuaternaryAction() {
        return false;
    }

}