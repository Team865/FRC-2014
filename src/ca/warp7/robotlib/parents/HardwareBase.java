package ca.warp7.robotlib.parents;

public abstract class HardwareBase { //weep woop

    protected HardwareBase() {
        // to override name, override getName
    }

    protected abstract void init();

    protected abstract void free();

    public void reload() {
        free();
        init();
    }

    public String getName() {
        return this.getClass().getSimpleName();
    }
}
