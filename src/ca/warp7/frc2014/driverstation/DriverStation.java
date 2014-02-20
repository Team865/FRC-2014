package ca.warp7.frc2014.driverstation;

import ca.warp7.frc2014.robot.Warp7Robot;
import ca.warp7.frc2014.software.Subsystem;
import edu.wpi.first.wpilibj.networktables.NetworkTable;
import edu.wpi.first.wpilibj.networktables.NetworkTableListenerAdapter;
import edu.wpi.first.wpilibj.tables.ITableListener;

import java.util.Vector;

public class DriverStation {
    public Controller controller;
    public NetworkTable table;

    public DriverStation() {
        table = NetworkTable.getTable("DriverStation");
        table.addTableListener(new DriverStationUpdateListener());

    }

    public void setMode(String mode) {
        table.putString("Robot Mode", mode);
    }

    public void sendSubsystemInfo() {
        Vector list = Warp7Robot.subsystem.subsystemList;
        NetworkTable subtable = (NetworkTable) table.getSubTable("Subsystems");

        for (int i = 0; i < list.size(); i++) {
            Subsystem s = (Subsystem) list.elementAt(i);
            subtable.putBoolean(s.getName(), s.isEnabled());
        }
    }

    public void loadSubsystemInfo() {
        Vector list = Warp7Robot.subsystem.subsystemList;
        NetworkTable subtable = (NetworkTable) table.getSubTable("Subsystems");
        for (int i = 0; i < list.size(); i++) {
            Subsystem s = (Subsystem) list.elementAt(i);
            if (subtable.containsKey(s.getName())) {
                s.setEnabled(subtable.getBoolean(s.getName()));
            }
        }
    }

}
