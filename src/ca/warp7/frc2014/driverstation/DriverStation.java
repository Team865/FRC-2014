package ca.warp7.frc2014.driverstation;

import ca.warp7.frc2014.modules.ModuleBase;
import ca.warp7.frc2014.robot.Robot;
import ca.warp7.frc2014.util.RobotInfo;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.networktables.NetworkTable;

import java.util.Vector;

public class DriverStation {

    private final Joystick leftJoy;
    private final Joystick rightJoy;
    public final NetworkTable table;

    public DriverStation() {
        table = NetworkTable.getTable("DriverStation");
        table.addTableListener(new DriverStationUpdateListener());

        leftJoy = new Joystick(RobotInfo.leftJoyPort.getInt());
        rightJoy = new Joystick(RobotInfo.rightJoyPort.getInt());
    }

    public void setMode(String mode) {
        table.putString("Robot Mode", mode);
    }

    public void sendModuleInfo() {
        Vector list = Robot.getInstance().modules.moduleList;
        NetworkTable modulesTable = (NetworkTable) table.getSubTable("Modules");

        for (int i = 0; i < list.size(); i++) {
            ModuleBase s = (ModuleBase) list.elementAt(i);
            modulesTable.putBoolean(s.getName(), s.isEnabled());
        }
    }

    public void loadModuleInfo() {
        Vector list = Robot.getInstance().modules.moduleList;
        NetworkTable modulesTable = (NetworkTable) table.getSubTable("Modules");

        for (int i = 0; i < list.size(); i++) {
            ModuleBase s = (ModuleBase) list.elementAt(i);
            if (modulesTable.containsKey(s.getName())) {
                s.setEnabled(modulesTable.getBoolean(s.getName()));
            }
        }
    }

    public void sendSensorInfo() {
        Robot r = Robot.getInstance();
        r.ds.table.putNumber("frontWingEncoder", r.hw.frontWing.getWristPosition());
        r.ds.table.putNumber("backWingEncoder", r.hw.backWing.getWristPosition());
        r.ds.table.putBoolean("highGear", r.hw.drive.isHighGear());

        r.ds.table.putNumber("sonarDistance", r.hw.sonar.getDistance());
    }

    public boolean isQuickTurn() {
        return leftJoy.getTrigger();
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

    public boolean isShiftLow() {
        return rightJoy.getRawButton(4);
    }

    public boolean isShiftHigh() {
        return rightJoy.getRawButton(5);
    }
}
