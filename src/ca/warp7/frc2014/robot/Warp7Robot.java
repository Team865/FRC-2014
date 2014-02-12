package ca.warp7.frc2014.robot;// Time Created: 1/4/14 4:57 PM

import ca.warp7.frc2014.autonomous.HotAutoMode;
import ca.warp7.frc2014.driverstation.ControllerXbox;
import ca.warp7.frc2014.driverstation.DriverStation;
import ca.warp7.frc2014.software.CheesyDrive;
import ca.warp7.frc2014.util.RobotInfo;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Timer;

public class Warp7Robot extends IterativeRobot {

    private AutoController autoController;
    private SubsystemController subsystem;
    public static DriverStation ds;
    public static HardwareController hw;

    public void robotInit() {
        hw = new HardwareController();
        autoController = new AutoController();
        autoController.addAutoCommand("Hotspot Detect & Drive", HotAutoMode.class);

        // Adding shit onto the robot
        ds = new DriverStation();
        ds.controller = new ControllerXbox();

        subsystem = new SubsystemController();
        subsystem.add(new CheesyDrive());

        /*
        //TODO: dynamic subsystem switching  (I think this is done?? kinda)
        Subsystem.add(new TalonCalibrate(Hardware.leftDrive));
        Subsystem.add(new TalonCalibrate(Hardware.rightDrive));
        */
    }

    public void autonomousInit() {
        ds.setMode("Autonomous");
    }

    public void teleopInit() {
        //TODO: i dunno man, what would I do here. tell DS we're in tele?
        ds.setMode("Teleop");

    }

    public void teleopPeriodic() {
        subsystem.runSubsystemsPeriodic();
        Timer.delay(.1); // Don't spam packets!
    }

    public void disabledInit() {
        System.out.println("Disabled initializing.");
        ds.setMode("Disabled");
        System.out.println("Loading RobotInfo from file.");

        RobotInfo.readInfoFromFile();

    }

    public void disabledPeriodic() {
        //TODO: Make this let you choose an auton mode from the DS.
    }
}
