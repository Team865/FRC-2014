package ca.warp7.robotlib.robot;

import ca.warp7.robotlib.Warp7Robot;

public abstract class ModuleBase {
    protected ModuleBase() {
        setEnabled(true);
    }

    public void load() {

    }

    public abstract void periodic();

    public String getName() {
        return this.getClass().getSimpleName();
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
        Warp7Robot.getInstance().ds.sendModuleInfo();
    }

    private boolean enabled;

}
