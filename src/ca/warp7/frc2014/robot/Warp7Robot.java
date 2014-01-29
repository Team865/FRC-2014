package ca.warp7.frc2014.robot;// Time Created: 1/4/14 4:57 PM

import ca.warp7.frc2014.autonomous.SeekAndDestroy;
import ca.warp7.frc2014.control.ControllerXbox;
import ca.warp7.frc2014.hardware.Hardware;
import ca.warp7.frc2014.software.Subsystem;
import ca.warp7.frc2014.software.TankDrive;
import edu.wpi.first.wpilibj.SimpleRobot;

class Warp7Robot extends SimpleRobot {

    private boolean autoRan = false;

    public Warp7Robot() {
        // Adding shit onto the robot
        Hardware.controller = new ControllerXbox();

        Subsystem.add(new TankDrive());
        /*
        // Calibration routine.
        //TODO: dynamic subsystem switching
        Subsystem.add(new TalonCalibrate(Hardware.leftDrive));
        Subsystem.add(new TalonCalibrate(Hardware.rightDrive));
        */
    }

    public void robotMain() {
        getWatchdog().setEnabled(true);

        while (true) {
            if (isDisabled()) {
                disabled();
            } else if (isAutonomous()) {
                autonomous();
            } else {
                teleOp();
            }
        } // What are the delays for??? Timer.delay(.1); //Wat why do I see this everywhere
    }

    void teleOp() {
        getWatchdog().feed();
        Subsystem.runSubsystems();
    }

    public void disabled() {
        getWatchdog().setEnabled(false);
        autoRan = false;
    }

    public void autonomous() {
        if (!autoRan) {
            new SeekAndDestroy().run();
            autoRan = true;
        }
    }
}
