package ca.warp7.frc2014.hardware;// Time Created: 1/4/14 5:21 PM

abstract class Part {
    Part() {
        // how do abstraction
    }

    public abstract void stop();

    public abstract void tick();

    public static Chassis chassis = new Chassis();
}
