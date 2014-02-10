package ca.warp7.frc2014.driverstation;// Time Created: 1/4/14 5:28 PM

public abstract class Controller {

    // Don't forget to singleton.
    public abstract double getPrimaryX();

    public abstract double getPrimaryY();

    public abstract double getSecondaryX();

    public abstract double getSecondaryY();

    public abstract boolean getPrimaryAction();

    public abstract boolean getSecondaryAction();

    public abstract boolean getTertiaryAction();

    public abstract boolean getQuaternaryAction();
}
