package ca.warp7.frc2014.hardware;

import ca.warp7.robotlib.parents.HardwareBase;
import edu.wpi.first.wpilibj.Compressor;

public class CartCompressor extends HardwareBase {
    private edu.wpi.first.wpilibj.Compressor c;

    public void init() {
        c = new Compressor(1, 1);
        c.start();
    }

    public void free() {
        c.free();
        c = null; //yay garbage collection
    }

}
