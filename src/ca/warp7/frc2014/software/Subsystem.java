package ca.warp7.frc2014.software;// Time Created: 1/4/14 5:24 PM

import ca.warp7.frc2014.robot.Warp7Robot;

public abstract class Subsystem {
    public Subsystem() {
        setEnabled(true);
    }

    public abstract void periodic();

    public abstract String getName();

    public boolean isEnabled() {
        return enabled;
    }

    public Subsystem setEnabled(boolean enabled) {
        this.enabled = enabled;
        Warp7Robot.ds.sendSubsystemInfo();
        return this;
    }

    protected boolean enabled;
}
