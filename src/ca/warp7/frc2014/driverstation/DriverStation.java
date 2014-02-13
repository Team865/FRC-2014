package ca.warp7.frc2014.driverstation;

import ca.warp7.frc2014.robot.Warp7Robot;
import ca.warp7.frc2014.software.Subsystem;
import ca.warp7.frc2014.util.Util;
import edu.wpi.first.wpilibj.networktables.NetworkTable;

import java.util.Vector;

public class DriverStation {
    public Controller controller;
    private NetworkTable table;

    public DriverStation() {
        table = NetworkTable.getTable("ds");
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

                Util.log(s.getName() + ":" + s.isEnabled());
            }
        }
    }
}
