package ca.warp7.frc2014.modules;

import ca.warp7.frc2014.robot.Robot;

/**
 * Created by Warp7 B on 2/28/14.
 */
public class Compressor extends ModuleBase {
    public void load() {
        Robot.getInstance().hw.comp.start(); // yay complience
    }

    public void periodic() {

    }

    public String getName() {
        return "Compressor";
    }
}
