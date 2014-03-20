package ca.warp7.robotlib.robot;

import ca.warp7.robotlib.exceptions.HardwareNotFoundException;
import ca.warp7.robotlib.parents.HardwareBase;

import java.util.Vector;

public class HardwareController {

    private final Vector hardwareList = new Vector();

    public HardwareController() {
        //prevent instanithing
    }

    public void add(HardwareBase h) {
        hardwareList.addElement(h);
    }

    public void reloadHardware() {
        for (int i = 0; i < hardwareList.size(); i++) {
            HardwareBase h = (HardwareBase) hardwareList.elementAt(i);
            h.reload();
        }
    }

    public HardwareBase getHardware(String name) {
        for (int i = 0; i < hardwareList.size(); i++) {
            HardwareBase h = (HardwareBase) hardwareList.elementAt(i);
            if (h.getName().equalsIgnoreCase(name)) {
                return h;
            }
        }
        throw new HardwareNotFoundException();
    }

}
