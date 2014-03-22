package ca.warp7.frc2014.driverstation;

import ca.warp7.frc2014.modules.WingController;
import edu.wpi.first.wpilibj.tables.ITable;
import edu.wpi.first.wpilibj.tables.ITableListener;

class DriverStationUpdateListener implements ITableListener {
    public void valueChanged(ITable src, String key, Object value, boolean isNew) {
        /*
        if(key == "gear") {
            TwoChainz.getInstance().hw.drive.shift(((Boolean) value).booleanValue());
        }
        */
        /*
        if (key.equals("wingMode")) {
            WingController.getInstance().setState(((Double) value).intValue());
        }
        */

    }
}
