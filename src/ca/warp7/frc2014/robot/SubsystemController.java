package ca.warp7.frc2014.robot;

import ca.warp7.frc2014.software.Subsystem;

import java.util.Vector;

public class SubsystemController {
    private final Vector subsystemList = new Vector();

    public void add(Subsystem s) {
        subsystemList.addElement(s);
    }

    public void remove(Subsystem s) {
        subsystemList.removeElement(s); // This works because I'm awesome. Hopefully the garbage collector catches on.
    }

    public void runSubsystemsPeriodic() {
        for (int i = 0; i < subsystemList.size(); i++) {
            Subsystem s = (Subsystem) subsystemList.elementAt(i);
            if (s.enabled)
                s.periodic();
        }
    }
}
