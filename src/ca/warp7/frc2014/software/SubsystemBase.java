package ca.warp7.frc2014.software;// Time Created: 1/4/14 5:24 PM

import ca.warp7.frc2014.robot.Robot;

public abstract class SubsystemBase {
    public SubsystemBase() {
        setEnabled(true);
    }

    public void load() {

    }

    public abstract void periodic();

    public abstract String getName();

    public boolean isEnabled() {
        return enabled;
    }

    public SubsystemBase setEnabled(boolean enabled) {
        this.enabled = enabled;
        Robot.getInstance().ds.sendSubsystemInfo();
        return this;
    }

    private boolean enabled;

    public void disable() {

    }
}
