package ca.warp7.frc2014.robot;// Time Created: 1/4/14 4:57 PM

import ca.warp7.frc2014.autonomous.HotAutoMode;
import ca.warp7.frc2014.driverstation.ControllerTwoJoysticks;
import ca.warp7.frc2014.driverstation.DriverStation;
import ca.warp7.frc2014.software.CheesyDrive;
import ca.warp7.frc2014.software.TankDrive;
import ca.warp7.frc2014.util.RobotInfo;
import edu.wpi.first.wpilibj.IterativeRobot;

public class Warp7Robot extends IterativeRobot {

    private AutoController autoController;
    public static SubsystemController subsystem;
    public static DriverStation ds;
    public static HardwareController hw;

    public void robotInit() {
        hw = new HardwareController();
        autoController = new AutoController();
        ds = new DriverStation();
        subsystem = new SubsystemController();


        autoController.addAutoCommand("Hot target Detect & Drive", HotAutoMode.class);
        ds.controller = new ControllerTwoJoysticks();
        subsystem.add(new TankDrive().setEnabled(false));
        subsystem.add(new CheesyDrive());
        getWatchdog().setExpiration(250);

        /*
        //TODO: dynamic subsystem switching  (I think this is done?? kinda)
        Subsystem.add(new TalonCalibrate(Hardware.leftDrive));
        Subsystem.add(new TalonCalibrate(Hardware.rightDrive));
        */
    }

    public void autonomousInit() {
        getWatchdog().setEnabled(true);
        ds.setMode("Autonomous");
    }

    public void teleopInit() {
        getWatchdog().setEnabled(true);
        ds.setMode("Teleop");
    }

    public void teleopPeriodic() {
        subsystem.runSubsystemsPeriodic();
        getWatchdog().feed();
    }

    public void disabledInit() {
        getWatchdog().setEnabled(false);
        System.out.println("Disabled initializing.");
        ds.setMode("Disabled");
        System.out.println("Loading RobotInfo from file.");

        RobotInfo.readInfoFromFile();
        ds.loadSubsystemInfo();

    }

    public void disabledPeriodic() {
        //TODO: Make this let you choose an auton mode from the DS.

    }

    public void testInit() {
        teleopInit();
    }

    public void testPeriodic() {
        teleopPeriodic();
    }
}
