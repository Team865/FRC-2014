package ca.warp7.frc2014.robot;// Time Created: 1/4/14 4:57 PM

import ca.warp7.frc2014.control.ControllerTwoJoysticks;
import ca.warp7.frc2014.hardware.Part;
import ca.warp7.frc2014.software.Subsystem;
import ca.warp7.frc2014.software.TankDrive;
import ca.warp7.frc2014.util.RobotInfo;
import edu.wpi.first.wpilibj.SimpleRobot;

class Warp7Robot extends SimpleRobot {

    public Warp7Robot() {
        // Adding shit onto the robot
        if (RobotInfo.controller.getInt() == 0) { //2 Joysticks
            Part.controller = new ControllerTwoJoysticks();
        }

        Subsystem.add(new TankDrive());
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
    }
}