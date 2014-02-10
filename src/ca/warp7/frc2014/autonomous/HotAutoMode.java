package ca.warp7.frc2014.autonomous;

import ca.warp7.frc2014.autonomous.commands.TurnToHotTargetCommand;
import edu.wpi.first.wpilibj.command.CommandGroup;

public class HotAutoMode extends CommandGroup {
    public HotAutoMode() {
        addSequential(new TurnToHotTargetCommand());
    }
}
