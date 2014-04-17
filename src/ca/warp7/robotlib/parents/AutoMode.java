package ca.warp7.robotlib.parents;

public abstract class AutoMode {
    public abstract void init();
    public abstract void disable();
    public abstract void tick();
}
