package ca.warp7.frc2014.hardware;

public class Compressor {
    private edu.wpi.first.wpilibj.Compressor c;
    public Compressor() {
        c = new edu.wpi.first.wpilibj.Compressor(1, 1);
        c.start(); // yay complience
    }
}
