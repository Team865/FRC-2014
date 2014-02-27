package ca.warp7.frc2014.modules;

import edu.wpi.first.wpilibj.networktables.NetworkTable;

public class Vision {
    private boolean isHot = false;
    private final NetworkTable table;

    public Vision() {
        table = NetworkTable.getTable("Vision");
    }

    public boolean isHot() {
        return isHot;
    }

    public void run() {
        isHot = ((int) table.getNumber("BLOB_COUNT") == 1);
    }

}