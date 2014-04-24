package ca.warp7.frc2014.autonomous;

import ca.warp7.robotlib.parents.AutoMode;
import ca.warp7.robotlib.util.Util;

public class NoAuton extends AutoMode {
    public void init() {
        // easiest. auton. ever.
    }

    public void disable() {
        Util.log(this, "Well, that was fun.");
    }

    public void tick() {

    }
}
