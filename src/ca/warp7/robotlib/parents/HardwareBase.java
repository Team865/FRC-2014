package ca.warp7.robotlib.parents;

import ca.warp7.robotlib.util.Util;

public abstract class HardwareBase { //weep woop
    protected HardwareBase() {
        // to override name, override getName
    }

    public abstract void init();

    public abstract void free();

    public void reload() {
        free();
        init();
    }

    public String getName() {
        return Util.stripClassName(this.getClass().getName());
    }
}
