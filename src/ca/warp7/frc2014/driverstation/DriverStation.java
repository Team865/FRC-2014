package ca.warp7.frc2014.driverstation;

import ca.warp7.frc2014.modules.ModuleBase;
import ca.warp7.frc2014.robot.Robot;
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
        r.ds.table.putNumber("frontWingEncoder", r.hw.frontWing.getWristPosition());
        r.ds.table.putNumber("backWingEncoder", r.hw.backWing.getWristPosition());
        //r.ds.table.putBoolean("driveGear", r.hw.drive.getGear());
        //no shifters :c
        r.ds.table.putNumber("sonarDistance", r.hw.sonar.getDistance());
    }
}
