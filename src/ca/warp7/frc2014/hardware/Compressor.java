package ca.warp7.frc2014.hardware;

public class Compressor {
    private final edu.wpi.first.wpilibj.Compressor c;

    public Compressor() {
        c = new edu.wpi.first.wpilibj.Compressor(1, 1);

    }

    public void start() {
        c.start();
    }
}