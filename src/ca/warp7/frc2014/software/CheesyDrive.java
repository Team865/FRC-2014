package ca.warp7.frc2014.software;

import ca.warp7.frc2014.robot.Warp7Robot;
import ca.warp7.frc2014.util.RobotInfo;
import ca.warp7.frc2014.util.Util;

public class CheesyDrive extends Subsystem {
    private double oldWheel = 0.0;
    private double quickStopAccumulator;

    public CheesyDrive() {

    }

    public void periodic() { // Driving Method
        double wheelNonLinearity, wheel, throttle;

        boolean isQuickTurn = Warp7Robot.ds.controller.getPrimaryAction();
        double wheelDeadband = 0.02;
        wheel = handleDeadband(Warp7Robot.ds.controller.getSecondaryX(), wheelDeadband);
        double throttleDeadband = 0.02;
        throttle = handleDeadband(Warp7Robot.ds.controller.getPrimaryY(), throttleDeadband);


        double negInertia = wheel - oldWheel;
        oldWheel = wheel;

        // Low gear

        wheelNonLinearity = 0.5;

        // Apply a sin function that's scaled to make it feel better.
        wheel = Math.sin(Math.PI / 2.0 * wheelNonLinearity * wheel)
                / Math.sin(Math.PI / 2.0 * wheelNonLinearity);
        wheel = Math.sin(Math.PI / 2.0 * wheelNonLinearity * wheel)
                / Math.sin(Math.PI / 2.0 * wheelNonLinearity);
        wheel = Math.sin(Math.PI / 2.0 * wheelNonLinearity * wheel)
                / Math.sin(Math.PI / 2.0 * wheelNonLinearity);

        double leftPwm, rightPwm, overPower;
        double sensitivity;

        double angularPower;
        double linearPower;

        // Negative inertia!
        double negInertiaAccumulator = 0.0;
        double negInertiaScalar;

        if (wheel * negInertia > 0)
            negInertiaScalar = 2.5;
        else if (Math.abs(wheel) > 0.65)
            negInertiaScalar = 5.0;
        else
            negInertiaScalar = 3.0;

        sensitivity = RobotInfo.cheesyMod.getDouble();

        double negInertiaPower = negInertia * negInertiaScalar;
        negInertiaAccumulator += negInertiaPower; // what is this for please help TODO what is this

        wheel = wheel + negInertiaAccumulator;
        if (negInertiaAccumulator > 1)
            negInertiaAccumulator -= 1;
        else if (negInertiaAccumulator < -1)
            negInertiaAccumulator += 1;
        else
            negInertiaAccumulator = 0;
        linearPower = throttle;

        // Quickturn!
        if (isQuickTurn) {
            if (Math.abs(linearPower) < 0.2) {
                double alpha = 0.1;
                quickStopAccumulator = (1 - alpha) * quickStopAccumulator
                        + alpha * Util.limit(wheel, 1.0) * 5;
            }
            overPower = 1.0;
            sensitivity = 1.0;
            angularPower = wheel;
        } else {
            overPower = 0.0;
            angularPower = Math.abs(throttle) * wheel * sensitivity
                    - quickStopAccumulator;
            if (quickStopAccumulator > 1)
                quickStopAccumulator -= 1;
            else if (quickStopAccumulator < -1)
                quickStopAccumulator += 1;
            else
                quickStopAccumulator = 0.0;
        }

        rightPwm = leftPwm = linearPower;
        leftPwm += angularPower;
        rightPwm -= angularPower;

        if (leftPwm > 1.0) {
            rightPwm -= overPower * (leftPwm - 1.0);
            leftPwm = 1.0;
        } else if (rightPwm > 1.0) {
            leftPwm -= overPower * (rightPwm - 1.0);
            rightPwm = 1.0;
        } else if (leftPwm < -1.0) {
            rightPwm += overPower * (-1.0 - leftPwm);
            leftPwm = -1.0;
        } else if (rightPwm < -1.0) {
            leftPwm += overPower * (-1.0 - rightPwm);
            rightPwm = -1.0;
        }


        Warp7Robot.hw.drive.setLRPower(leftPwm, rightPwm);
    }

    double handleDeadband(double val, double deadband) {
        return (Math.abs(val) > Math.abs(deadband)) ? val : 0.0;
    }
}
