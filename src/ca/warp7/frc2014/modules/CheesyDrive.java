package ca.warp7.frc2014.modules;

import ca.warp7.frc2014.TwoChainz;
import ca.warp7.frc2014.driverstation.MohitDriverStation;
import ca.warp7.frc2014.hardware.Drive;
import ca.warp7.robotlib.Warp7Robot;
import ca.warp7.robotlib.parents.ModuleBase;
import ca.warp7.frc2014.util.RobotInfo;
import ca.warp7.robotlib.util.Util;

public class CheesyDrive extends ModuleBase {
    private double oldWheel = 0.0;
    private double quickStopAccumulator;
    private final Drive drive;
    private final Warp7Robot robot = TwoChainz.getInstance();

    public CheesyDrive() {

        drive = (Drive) robot.hw.getHardware("Drive");
    }

    public void doPeriodicTick() { // Driving Method
        double wheelNonLinearity, wheel, throttle;

        boolean isQuickTurn = ((MohitDriverStation) robot.ds).getQuickTurnButton();
        double wheelDeadband = 0.02;
        wheel = Util.deadband(-((MohitDriverStation) robot.ds).getSecondaryX(), wheelDeadband);
        double throttleDeadband = 0.02;
        throttle = Util.deadband(((MohitDriverStation) robot.ds).getPrimaryY(), throttleDeadband); // *-1 depends on wiring I think
        double negInertia = wheel - oldWheel;
        oldWheel = wheel;

        if (drive.isHighGear()) {
            wheelNonLinearity = 0.6;
            // Apply a sin function that's scaled to make it feel better.
            wheel = Math.sin(Math.PI / 2.0 * wheelNonLinearity * wheel) /
                    Math.sin(Math.PI / 2.0 * wheelNonLinearity);
            wheel = Math.sin(Math.PI / 2.0 * wheelNonLinearity * wheel) /
                    Math.sin(Math.PI / 2.0 * wheelNonLinearity);
        } else {
            wheelNonLinearity = 0.5;
            // Apply a sin function that's scaled to make it feel better.
            wheel = Math.sin(Math.PI / 2.0 * wheelNonLinearity * wheel) /
                    Math.sin(Math.PI / 2.0 * wheelNonLinearity);
            wheel = Math.sin(Math.PI / 2.0 * wheelNonLinearity * wheel) /
                    Math.sin(Math.PI / 2.0 * wheelNonLinearity);
            wheel = Math.sin(Math.PI / 2.0 * wheelNonLinearity * wheel) /
                    Math.sin(Math.PI / 2.0 * wheelNonLinearity);
        }

        double leftPwm, rightPwm, overPower;
        double sensitivity;

        double angularPower;
        double linearPower;

        // Negative inertia!
        double negInertiaAccumulator = 0.0;
        double negInertiaScalar;
        if (drive.isHighGear()) {
            negInertiaScalar = 5.0;
            sensitivity = RobotInfo.cheesyHigh.getDouble();
        } else {
            if (wheel * negInertia > 0) {
                negInertiaScalar = 2.5;
            } else {
                if (Math.abs(wheel) > 0.65) {
                    negInertiaScalar = 5.0;
                } else {
                    negInertiaScalar = 3.0;
                }
            }
            sensitivity = RobotInfo.cheesyLow.getDouble();

            /*
            if (Math.abs(throttle) > 0.1) {
                 sensitivity = 1.0 - (1.0 - sensitivity) / Math.abs(throttle);
            }
            */
        }
        double negInertiaPower = negInertia * negInertiaScalar;
        negInertiaAccumulator += negInertiaPower;

        wheel = wheel + negInertiaAccumulator;
        linearPower = throttle;

        // Quickturn!
        if (isQuickTurn) {
            if (Math.abs(linearPower) < 0.2) {
                double alpha = 0.1;
                quickStopAccumulator = (1 - alpha) * quickStopAccumulator + alpha *
                        Util.limit(wheel, 1.0) * 5;
            }
            overPower = 1.0;
            angularPower = wheel;
        } else {
            overPower = 0.0;
            angularPower = Math.abs(throttle) * wheel * sensitivity - quickStopAccumulator;
            if (quickStopAccumulator > 1) {
                quickStopAccumulator -= 1;
            } else if (quickStopAccumulator < -1) {
                quickStopAccumulator += 1;
            } else {
                quickStopAccumulator = 0.0;
            }
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

        drive.setLRPower(rightPwm, leftPwm);
    }
}
