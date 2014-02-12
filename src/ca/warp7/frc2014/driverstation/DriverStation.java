package ca.warp7.frc2014.driverstation;

import ca.warp7.frc2014.util.Util;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class DriverStation {
    public Controller controller;

    public void setMode(String mode) {
        SmartDashboard.putString("Robot Mode", mode);
        Util.log("Robot Mode:" + mode);
    }
}
