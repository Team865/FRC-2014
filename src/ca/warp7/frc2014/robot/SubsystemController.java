package ca.warp7.frc2014.robot;

import ca.warp7.frc2014.software.SubsystemBase;

import java.util.Vector;

public class SubsystemController {
    public final Vector subsystemList = new Vector();

    public void add(SubsystemBase s) {
        subsystemList.addElement(s);
    }

    public void remove(SubsystemBase s) {
        subsystemList.removeElement(s); // This works because I'm awesome. Hopefully the garbage collector catches on.
    }

    public void runSubsystemsPeriodic() {
        for (int i = 0; i < subsystemList.size(); i++) {
            SubsystemBase s = (SubsystemBase) subsystemList.elementAt(i);
            if (s.isEnabled())
                s.periodic();
        }
    }

    public void runSubsystemsLoad() {
        for (int i = 0; i < subsystemList.size(); i++) {
            SubsystemBase s = (SubsystemBase) subsystemList.elementAt(i);
            if (s.isEnabled())
                s.load();
        }
    }

    public void runSubsystemsDisabled() {
        for (int i = 0; i < subsystemList.size(); i++) {
            SubsystemBase s = (SubsystemBase) subsystemList.elementAt(i);
            if (s.isEnabled())
                s.disable();
        }
    }
}
