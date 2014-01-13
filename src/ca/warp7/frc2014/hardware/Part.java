package ca.warp7.frc2014.hardware;// Time Created: 1/4/14 5:21 PM

import ca.warp7.frc2014.control.Controller;

public abstract class Part {
    Part() {
        // how do abstraction
    }

    public abstract void stop();

    public abstract void tick();

    public static Chassis chassis = new Chassis();
    public static Controller controller;
}
