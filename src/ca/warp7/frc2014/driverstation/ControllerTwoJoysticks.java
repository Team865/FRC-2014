package ca.warp7.frc2014.driverstation;

import ca.warp7.frc2014.util.RobotInfo;
import edu.wpi.first.wpilibj.Joystick;


public class ControllerTwoJoysticks extends Controller {

    private final Joystick joy1;
    private final Joystick joy2;

    public ControllerTwoJoysticks() {
        this.joy1 = new Joystick(RobotInfo.leftJoyPort.getInt());
        this.joy2 = new Joystick(RobotInfo.rightJoyPort.getInt());
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
        return joy2.getTrigger();
    }

    public boolean getSecondaryAction() {
        return joy1.getTrigger();
    }

    public boolean getTertiaryAction() {
        return joy1.getRawButton(3);
    }

    public boolean getQuaternaryAction() {
        return joy1.getRawButton(2);
    }

}
