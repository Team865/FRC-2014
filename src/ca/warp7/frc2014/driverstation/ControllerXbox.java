package ca.warp7.frc2014.driverstation;

import ca.warp7.frc2014.util.Util;
import edu.wpi.first.wpilibj.Joystick;

public class ControllerXbox extends Controller {
    private final Joystick con;

    public ControllerXbox() {
        con = new Joystick(1);
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

    public boolean getButton(int i) {
        return con.getRawButton(i);
    }

    public boolean getSecondaryButton(int i) {
        return getButton(i);
    }
}
