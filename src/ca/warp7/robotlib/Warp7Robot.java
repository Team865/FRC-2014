package ca.warp7.robotlib;

import ca.warp7.robotlib.parents.DriverStationBase;
import ca.warp7.robotlib.robot.HardwareController;
import ca.warp7.robotlib.robot.ModuleController;
import ca.warp7.frc2014.util.RobotInfo;
import ca.warp7.robotlib.util.Util;
import edu.wpi.first.wpilibj.IterativeRobot;

public abstract class Warp7Robot extends IterativeRobot {
    public ModuleController modules;
    public DriverStationBase ds;
    public HardwareController hw;
    private static Warp7Robot instance;
    private String robotName; //hue

    protected Warp7Robot() {
        instance = this;
    }

    public static Warp7Robot getInstance() {
        return instance;
    } //Singleton-ing

    public void robotInit() {
        new RobotInfo();

        robotName = getRobotName();
        RobotInfo.readInfoFromFile();

        hw = new HardwareController();
        modules = new ModuleController();
        getWatchdog().setEnabled(false);

        loadHardware();
        hw.initHardware();
        loadModules();

        ds = getDriverStation();

        Util.log(this, robotName + " has booted, ready to go.");
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
        modules.initModules();
        Util.log(this, "Module threads starting.");
    }

    public void teleopPeriodic() {
        modules.tickModules();
        ds.sendSensorInfo();
    }


    public void disabledInit() {
        Util.log(this, "Robot Disabled!");
        ds.setMode("Disabled");

        Util.log(this, "Reloading info...");
        RobotInfo.readInfoFromFile();
        ds.loadModuleInfo();
        hw.reloadHardware();
        Util.log(this, "Info reloaded.");
    }

    public void disabledPeriodic() {
        ds.sendSensorInfo();
    }

    public void testInit() {
        // wat

    }

    public void testPeriodic() {
        ds.sendSensorInfo();
    }

    protected abstract void loadHardware();

    protected abstract void loadModules();

    protected abstract String getRobotName();

    protected abstract DriverStationBase getDriverStation();

}
