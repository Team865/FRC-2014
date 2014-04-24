package ca.warp7.robotlib.parents;

public abstract class ModuleBase /* implements Runnable  */ {
    private boolean enabled;

    protected ModuleBase() {
        setEnabled(false);
    }

    public void init() {

    }

    public abstract void doPeriodicTick();

    public String getName() {
        return this.getClass().getName();
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }


}
