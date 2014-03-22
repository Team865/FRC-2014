package ca.warp7.robotlib.robot;

import ca.warp7.robotlib.parents.ModuleBase;

import java.util.Vector;

public class ModuleController {
    public final Vector moduleList = new Vector(); // see poem in WingModes.class

    public void add(ModuleBase s) {
        moduleList.addElement(s);
    }

    public void tickModules() {
        for (int i = 0; i < moduleList.size(); i++) {
            ModuleBase s = (ModuleBase) moduleList.elementAt(i);
            s.setEnabled(true);
            //Thread t = new Thread(s);
            s.doPeriodicTick();
        }
    }

    public void initModules() {
        for (int i = 0; i < moduleList.size(); i++) {
            ModuleBase s = (ModuleBase) moduleList.elementAt(i);
            s.init();
        }
    }

}
