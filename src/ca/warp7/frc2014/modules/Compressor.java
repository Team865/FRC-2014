package ca.warp7.frc2014.modules;

import ca.warp7.frc2014.robot.Robot;

public class Compressor extends ModuleBase {
    public void load() {
        Robot.getInstance().hw.comp.start(); // yay compliance
        // dumb rules make it so our compressor has to be crio controller.
        // this class exists because the system is dumb
        // fuck the system
        // fuk da police
    }

    public void periodic() {

    }

    public String getName() {
        return "Compressor";
    }
}
