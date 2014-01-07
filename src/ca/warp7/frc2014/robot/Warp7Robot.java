package ca.warp7.frc2014.robot;// Time Created: 1/4/14 4:57 PM

import ca.warp7.frc2014.software.Subsystem;
import edu.wpi.first.wpilibj.SimpleRobot;

public class Warp7Robot extends SimpleRobot {

    public Warp7Robot() {
        // Adding shit onto the robot
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

    public void teleOp() {
        getWatchdog().feed();
        Subsystem.runSubsystems();
    }

    public void disabled() {
        getWatchdog().setEnabled(false);
    }
}
