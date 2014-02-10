package ca.warp7.frc2014.hardware;

import edu.wpi.first.wpilibj.Talon;

public class Motor {

    private final Talon t;
    private boolean flipped;

    public Motor(int pin) {
        this.t = new Talon(1, pin);
    }

    public Motor(int pin, boolean flipped) {
        this.t = new Talon(1, pin);
        this.flipped = flipped;
    }

    public void stop() {
        t.set(0);
    }

    public void set(double d) { //dem boobies
        if (flipped) {
            d *= -1;
        }
        t.set(d);
    }
}
