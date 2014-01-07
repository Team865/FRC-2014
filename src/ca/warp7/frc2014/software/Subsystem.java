package ca.warp7.frc2014.software;// Time Created: 1/4/14 5:24 PM

import java.util.Vector;

public abstract class Subsystem {
    public static Vector subsystemList = new Vector();

    public void add(Subsystem s) {
        subsystemList.addElement(s);
    }

    public static void runSubsystems() {
        for (int i = 0; i < subsystemList.size(); i++) {
            Subsystem s = (Subsystem) subsystemList.elementAt(i);
            s.tick();
        }
    }

    public abstract void tick();

}
