package ca.warp7.frc2014.modules;

import ca.warp7.frc2014.util.Util;
import edu.wpi.first.wpilibj.networktables.NetworkTable;

public class Vision {
    private final NetworkTable table;

    public Vision() {
        table = NetworkTable.getTable("Vision");
    }

    public boolean isHot() {
        try {
            return ((int) table.getNumber("BLOB_COUNT") == 1);
        } catch (Exception e) {
            Util.log("Vision", "RoboRealm not started!");
        }
        return true; // might as well score asap
    }

}