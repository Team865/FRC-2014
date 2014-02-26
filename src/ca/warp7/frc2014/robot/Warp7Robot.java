package ca.warp7.frc2014.robot;// Time Created: 1/4/14 4:57 PM

import ca.warp7.frc2014.autonomous.DetectHotTarget;
import ca.warp7.frc2014.driverstation.ControllerTwoJoysticks;
import ca.warp7.frc2014.driverstation.DriverStation;
import ca.warp7.frc2014.software.CheesyDrive;
import ca.warp7.frc2014.software.WingController;
import ca.warp7.frc2014.util.RobotInfo;
import ca.warp7.frc2014.util.Util;
import edu.wpi.first.wpilibj.IterativeRobot;

public class Warp7Robot extends IterativeRobot {

    public static SubsystemController subsystem;
    public static DriverStation ds;
    public static HardwareController hw;

    public void robotInit() {
        hw = new HardwareController();
        ds = new DriverStation();
        subsystem = new SubsystemController();

        ds.controller = new ControllerTwoJoysticks();

        //subsystem.add(new TankDrive());
        subsystem.add(new WingController());
        subsystem.add(new CheesyDrive());

        getWatchdog().setExpiration(250);
        getWatchdog().setEnabled(true);
        Util.log("Main", "Robot has booted, ready to go.");
    }

    public void autonomousInit() {
        ds.setMode("Autonomous");
        new DetectHotTarget().run();
        getWatchdog().setEnabled(false);
    }

    public void teleopInit() {
        getWatchdog().setEnabled(false);
        ds.setMode("Teleop");
        ds.loadSubsystemInfo();
        Util.log("Main", "Subsystem Init");
        subsystem.runSubsystemsLoad();
        hw.load();
        hw.backWing.setPIDControlled();
    }

    public void teleopPeriodic() {
        subsystem.runSubsystemsPeriodic();
        getWatchdog().feed();
    }

    public void disabledInit() {
        Util.log("Main", "Disabled initializing.");
        ds.setMode("Disabled");
        getWatchdog().setEnabled(false);
        Util.log("Main", "Loading InfoValues from file.");
        RobotInfo.readInfoFromFile();
        subsystem.runSubsystemsDisabled();
        ds.loadSubsystemInfo();

    }

    public void disabledPeriodic() {
        ds.sendSensorInfo();
    }

    public void testInit() {
        teleopInit();
    }

    public void testPeriodic() {
        teleopPeriodic();
    }
}
