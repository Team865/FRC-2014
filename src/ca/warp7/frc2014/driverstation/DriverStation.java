package ca.warp7.frc2014.driverstation;

import ca.warp7.frc2014.modules.ModuleBase;
import ca.warp7.frc2014.robot.Robot;
import ca.warp7.frc2014.util.RobotInfo;
import edu.wpi.first.wpilibj.networktables.NetworkTable;

import java.util.Vector;

public class DriverStation {
    public Controller controller;
    public final NetworkTable table;

    public DriverStation() {
        table = NetworkTable.getTable("DriverStation");
        table.addTableListener(new DriverStationUpdateListener());

    }

    public void setMode(String mode) {
        table.putString("Robot Mode", mode);
    }

    public void sendModuleInfo() {
        Vector list = Robot.getInstance().modules.moduleList;
        NetworkTable subtable = (NetworkTable) table.getSubTable("Modules");

        for (int i = 0; i < list.size(); i++) {
            ModuleBase s = (ModuleBase) list.elementAt(i);
            subtable.putBoolean(s.getName(), s.isEnabled());
        }
    }

    public void loadModuleInfo() {
        Vector list = Robot.getInstance().modules.moduleList;
        NetworkTable subtable = (NetworkTable) table.getSubTable("Modules");

        for (int i = 0; i < list.size(); i++) {
            ModuleBase s = (ModuleBase) list.elementAt(i);
            if (subtable.containsKey(s.getName())) {
                s.setEnabled(subtable.getBoolean(s.getName()));

            }
        }
    }

    public void sendSensorInfo() {
        Robot r = Robot.getInstance();
        r.ds.table.putNumber("backWingEncoder", r.hw.backWing.getWristPosition());
        r.ds.table.putNumber("backWingZeroPoint", RobotInfo.backWingZeroPoint.getDouble());
        r.ds.table.putBoolean("Gear", r.hw.drive.getGear());
        r.ds.table.putBoolean("dispence", r.hw.sonar.getDistance() < 50);
    }
}
