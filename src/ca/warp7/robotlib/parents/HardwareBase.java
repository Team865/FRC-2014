package ca.warp7.robotlib.parents;

public abstract class HardwareBase { //weep woop

    public HardwareBase() {
        // to override name, override getName
    }

    public abstract void init();

    public abstract void free();

    public void reload() {
        free();
        init();
    }

    public String getName() {
        return this.getClass().getSimpleName();
    }
}
