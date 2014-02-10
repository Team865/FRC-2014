package ca.warp7.frc2014.driverstation;

import ca.warp7.frc2014.util.RobotInfo;
import ca.warp7.frc2014.util.Util;
import edu.wpi.first.wpilibj.Joystick;

public class ControllerXbox extends Controller {
    private final Joystick con;

    public ControllerXbox() {
        con = new Joystick(RobotInfo.xboxPin.getInt()); // Do this? or should put in the var statement above?
    }

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
