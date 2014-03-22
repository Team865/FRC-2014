package ca.warp7.frc2014.hardware;

import ca.warp7.frc2014.TwoChainz;
import ca.warp7.frc2014.util.RobotInfo;
import ca.warp7.robotlib.parents.HardwareBase;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.Talon;

public class Drive extends HardwareBase {
    private Solenoid shifter;
    private Talon rightDrive;
    private Talon leftDrive;

    public void init() {
        shifter = new Solenoid(RobotInfo.shifterPort.getInt());
        rightDrive = new Talon(RobotInfo.rightMotorPort.getInt());
        leftDrive = new Talon(RobotInfo.leftMotorPort.getInt());
    }

    public void free() {
        shifter.free();
        shifter = null;

        rightDrive.free();
        rightDrive = null;

        leftDrive.free();
        leftDrive = null;
    }

    public void setLRPower(double lPower, double rPower) {
        synchronized (this) { // so drive doesn't bork
            rightDrive.set(rPower);
            leftDrive.set(lPower * -1); //inverted cause other side
        }
    }

    public void shift(boolean gear) { // true for low.
        shifter.set(gear);
        TwoChainz.getInstance().ds.table.putBoolean("Gear", gear);
    }

    public boolean isHighGear() {
        return shifter.get();
    }

    public boolean isLowGear() {
        return !isHighGear();
    }

}
