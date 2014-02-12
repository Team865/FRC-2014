package ca.warp7.frc2014.robot;

import java.util.Vector;

class AutoController {
    private final Vector autoModes = new Vector();

    public void addAutoCommand(String name, Class command) {
        autoModes.addElement(new AutoMode(name, command));
    }

    private static class AutoMode {
        public final String name;
        public final Class command;

        public AutoMode(String name, Class command) {
            this.name = name;
            this.command = command;
        }
    }
}
