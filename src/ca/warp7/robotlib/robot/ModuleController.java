package ca.warp7.robotlib.robot;

import java.util.Vector;

public class ModuleController {
    public final Vector moduleList = new Vector(); // see poem in WingModes.class

    public void add(ModuleBase s) {
        moduleList.addElement(s);
    }

    public void runModulesPeriodic() {
        for (int i = 0; i < moduleList.size(); i++) {
            ModuleBase s = (ModuleBase) moduleList.elementAt(i);
            if (s.isEnabled())
                s.periodic();
        }
    }

    public void loadModules() {
        for (int i = 0; i < moduleList.size(); i++) {
            ModuleBase s = (ModuleBase) moduleList.elementAt(i);
            if (s.isEnabled())
                s.load();
        }
    }
}
