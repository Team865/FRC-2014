package ca.warp7.robotlib.parents;

import ca.warp7.robotlib.Warp7Robot;
import ca.warp7.robotlib.robot.ModuleBase;
import edu.wpi.first.wpilibj.networktables.NetworkTable;
import edu.wpi.first.wpilibj.tables.ITableListener;

import java.util.Vector;

public abstract class DriverStationBase {

    public final NetworkTable table;
    protected final Warp7Robot robot;

    public DriverStationBase(ITableListener updateListener, Warp7Robot robot) {
        this.robot = robot;

        table = NetworkTable.getTable("DriverStation");
        table.addTableListener(updateListener);
    }

    public void setMode(String mode) {
        table.putString("Robot Mode", mode);
    }

    public void sendModuleInfo() {
        Vector list = robot.modules.moduleList;
        NetworkTable modulesTable = (NetworkTable) table.getSubTable("Modules");

        for (int i = 0; i < list.size(); i++) {
            ModuleBase s = (ModuleBase) list.elementAt(i);
            modulesTable.putBoolean(s.getName(), s.isEnabled());
        }
    }

    public void loadModuleInfo() {
        Vector list = robot.modules.moduleList;
        NetworkTable modulesTable = (NetworkTable) table.getSubTable("Modules");

        for (int i = 0; i < list.size(); i++) {
            ModuleBase s = (ModuleBase) list.elementAt(i);
            if (modulesTable.containsKey(s.getName())) {
                s.setEnabled(modulesTable.getBoolean(s.getName()));
            }
        }
    }

    public abstract void sendSensorInfo();

}
