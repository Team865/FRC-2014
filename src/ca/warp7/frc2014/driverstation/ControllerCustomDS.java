package ca.warp7.frc2014.driverstation;

import ca.warp7.frc2014.util.RobotInfo;
import edu.wpi.first.wpilibj.Joystick;


public class ControllerCustomDS extends Controller {

    private final Joystick leftJoy;
    private final Joystick rightJoy;

    public ControllerCustomDS() {
        this.leftJoy = new Joystick(RobotInfo.leftJoyPort.getInt());
        this.rightJoy = new Joystick(RobotInfo.rightJoyPort.getInt());
    }


    public double getPrimaryX() {
        return leftJoy.getX();
    }

    public double getPrimaryY() {
        return leftJoy.getY();
    }

    public double getSecondaryX() {
        return rightJoy.getX();
    }

    public double getSecondaryY() {
        return rightJoy.getY();
    }

    public boolean getButton(int i) {
        return leftJoy.getRawButton(i);
    }

    public boolean getSecondaryButton(int i) {
        return rightJoy.getRawButton(i);
    }

    public int getModeButton() {
        int numModes = 6;
        int offset = 9;
        for (int i = 0; i < numModes; i++) {
            if (rightJoy.getRawButton(i + offset)) {
                return i;
            }
        }
        return -1;
    }

    public boolean getDriveModButton() {
        return leftJoy.getTrigger();
    }

    public boolean getFunctionButton() {
        return rightJoy.getTrigger();
    }
}
