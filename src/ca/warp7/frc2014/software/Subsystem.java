package ca.warp7.frc2014.software;// Time Created: 1/4/14 5:24 PM

public abstract class Subsystem {
    public abstract void periodic();

    public abstract String getName();

    public boolean isEnabled() {
        return enabled;
    }

    public Subsystem setEnabled(boolean enabled) {
        this.enabled = enabled;
        return this;
    }

    protected boolean enabled = true;
}
