package ca.warp7.frc2014.driverstation;

import ca.warp7.frc2014.robot.Warp7Robot;
import ca.warp7.frc2014.software.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import java.util.Vector;

public class DriverStation {
    public Controller controller;

    public void setMode(String mode) {
        SmartDashboard.putString("Robot Mode", mode);
    }

    public void sendSubsystemInfo() {
        Vector list = Warp7Robot.subsystem.subsystemList;

        for (int i = 0; i < list.size(); i++) {
            Subsystem s = (Subsystem) list.elementAt(i);
            SmartDashboard.putBoolean(s.getName(), s.isEnabled());
        }
    }
}
