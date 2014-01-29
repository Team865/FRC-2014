package ca.warp7.frc2014.hardware;

import edu.wpi.first.wpilibj.Talon;

/**
 * Created with IntelliJ IDEA.
 * User: Marcus is dumb
 * Date: 1/29/14
 * Time: 3:16 PM
 */
public class Motor extends Hardware {

    private Talon t;
    boolean flipped;

    public Motor(int pin) {
        this.t = new Talon(1, pin);
    }

    public Motor(int pin, boolean flipped) {
        this.t = new Talon(1, pin);
    }

    public void stop() {
        t.set(0);
    }

    public void tick() {
        //why is this
    }

    public void set(double d) { //dem boobies
        if (flipped) {
            d *= -1;
        }
        t.set(d);
    }
}
