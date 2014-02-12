package ca.warp7.frc2014.autonomous.commands;

import ca.warp7.frc2014.robot.Warp7Robot;
import edu.wpi.first.wpilibj.command.Command;

public class ResetDriveEncodersCommand extends Command {
    protected void initialize() {

    }

    protected void execute() {
        Warp7Robot.hw.drive.resetEncoders();
    }

    protected boolean isFinished() {
        return true;
    }

    protected void end() {

    }

    protected void interrupted() {

    }
}
