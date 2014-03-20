package ca.warp7.robotlib;

import ca.warp7.frc2014.hardware.Drive;
import ca.warp7.robotlib.parents.DriverStationBase;
import ca.warp7.robotlib.robot.HardwareController;
import ca.warp7.robotlib.robot.ModuleController;
import ca.warp7.robotlib.util.RobotInfo;
import ca.warp7.robotlib.util.Util;
import edu.wpi.first.wpilibj.IterativeRobot;

public abstract class Warp7Robot extends IterativeRobot {
    public ModuleController modules;
    public DriverStationBase ds;
    public HardwareController hw;
    private static Warp7Robot instance;
    private String robotName; //hue

    public Warp7Robot() {
        instance = this;
    }

    public static Warp7Robot getInstance() {
        return instance;
    } //Singleton-ing

    public void robotInit() {
        robotName = getRobotName();
        RobotInfo.readInfoFromFile();
        hw = new HardwareController();
        modules = new ModuleController();
        ds = getDriverStation();
        getWatchdog().setEnabled(false);
        loadHardware();
        loadModules();
        Util.log("Main", robotName + " has booted, ready to go.");
    }

    public void autonomousInit() {
        ds.setMode("Autonomous");
    }

    public void autonomousPeriodic() {
        ds.sendSensorInfo();
    }

    public void teleopInit() {
        ds.setMode("Teleoperated");
        ds.loadModuleInfo();
        Util.log("Main", "Module Init");
        modules.loadModules();
    }

    public void teleopPeriodic() {
        modules.runModulesPeriodic();
        ds.sendSensorInfo();
    }


    public void disabledInit() {
        Util.log("Main", "Disabled initializing.");
        ds.setMode("Disabled");
        Util.log("Main", "Reloading info...");
        RobotInfo.readInfoFromFile();
        ds.loadModuleInfo();
        hw.reloadHardware();
        Util.log("Main", "Info reloaded.");
    }

    public void disabledPeriodic() {
        ds.sendSensorInfo();
    }

    public void testInit() {
        // wat
        hw.reloadHardware();
    }

    public void testPeriodic() {
        ds.sendSensorInfo();
    }

    public abstract void loadHardware();

    public abstract void loadModules();

    public abstract String getRobotName();

    public abstract DriverStationBase getDriverStation();

}