package ca.warp7.frc2014.modules;// Time Created: 1/4/14 5:24 PM

import ca.warp7.frc2014.robot.Robot;

public abstract class ModuleBase {
    ModuleBase() {
        setEnabled(true);
    }

    public void load() {

    }

    public abstract void periodic();

    public abstract String getName();

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
        Robot.getInstance().ds.sendModuleInfo();
    }

    private boolean enabled;

}
