package ca.warp7.frc2014.robot;// Time Created: 1/4/14 4:57 PM

import ca.warp7.frc2014.autonomous.DetectHotTarget;
import ca.warp7.frc2014.driverstation.ControllerTwoJoysticks;
import ca.warp7.frc2014.driverstation.DriverStation;
import ca.warp7.frc2014.software.CheesyDrive;
import ca.warp7.frc2014.software.MotorTester;
import ca.warp7.frc2014.software.WingController;
import ca.warp7.frc2014.util.RobotInfo;
import ca.warp7.frc2014.util.Util;
import edu.wpi.first.wpilibj.IterativeRobot;

public class Warp7Robot extends IterativeRobot {

    public static SubsystemController subsystem;
    public static DriverStation ds;
    public static HardwareController hw;

    public void robotInit() {
        RobotInfo.readInfoFromFile();
        hw = new HardwareController();
        ds = new DriverStation();
        subsystem = new SubsystemController();

        ds.controller = new ControllerTwoJoysticks();

        //subsystem.add(new TankDrive());
        subsystem.add(new WingController(hw.backWing));
        subsystem.add(new CheesyDrive());
        subsystem.add(new MotorTester());

        getWatchdog().setExpiration(250);
        getWatchdog().setEnabled(true);
        Util.log("Main", "Robot has booted, ready to go.");
    }

    public void autonomousInit() {
        ds.setMode("Autonomous");
        new DetectHotTarget().run();
        getWatchdog().feed();
    }

    public void teleopInit() {
        ds.setMode("Teleop");
        ds.loadSubsystemInfo();
    }

    public void teleopPeriodic() {
        subsystem.runSubsystemsPeriodic();
        getWatchdog().feed();
    }

    public void disabledInit() {
        Util.log("Main", "Disabled initializing.");
        ds.setMode("Disabled");
        Util.log("Main", "Loading RobotInfo from file.");

        RobotInfo.readInfoFromFile();
        ds.loadSubsystemInfo();

    }

    public void disabledPeriodic() {

    }

    public void testInit() {
        teleopInit();
    }

    public void testPeriodic() {
        teleopPeriodic();
    }
}
