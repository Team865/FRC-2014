package ca.warp7.frc2014.robot;

import java.util.Vector;

public class AutoController {
    private Vector autoModes;

    public void addAutoCommand(String name, Class command) {
        autoModes.add(new AutoMode(name, command));
    }

    private static class AutoMode {
        public String name;
        public Class command;

        public AutoMode(String name, Class command) {
            this.name = name;
            this.command = command;
        }
    }
}
