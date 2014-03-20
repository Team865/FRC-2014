package ca.warp7.frc2014.modules;

import ca.warp7.robotlib.util.Util;
import edu.wpi.first.wpilibj.networktables.NetworkTable;
import edu.wpi.first.wpilibj.tables.TableKeyNotDefinedException;

public class Vision {
    private final NetworkTable table;

    public Vision() {
        table = NetworkTable.getTable("Vision");
    }

    public boolean isHot() {
        try {
            return ((int) table.getNumber("BLOB_COUNT") == 1);
        } catch (TableKeyNotDefinedException e) {
            Util.log(this, "RoboRealm not started!");
        }
        return true; // might as well score asap
    }

}