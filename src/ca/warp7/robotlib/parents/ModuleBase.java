package ca.warp7.robotlib.parents;

public abstract class ModuleBase /* implements Runnable  */ {// hella threading man
    //warning: not synchronized to input, bad things may happen
    private boolean enabled;

    protected ModuleBase() {
        setEnabled(false);
    }

    public void init() {

    }

    /*
    //Threading Disabled
    public final void run() {
        init();
        while(isEnabled()) {
            doPeriodicTick();
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    */

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
