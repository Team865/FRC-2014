package ca.warp7.frc2014.modules;

import ca.warp7.frc2014.robot.Robot;

/**
 * Created by Warp7 B on 3/2/14.
 */
public class Passer extends ModuleBase {
    public void periodic() {
        if(Robot.getInstance().ds.controller.getFunctionButton()) {
            Robot.getInstance().hw.backWing.rollersDown();
        } else {
            Robot.getInstance().hw.backWing.rollersOff();
        }
    }

    public String getName() {
        return "Shifter";
    }
}
