package org.firstinspires.ftc.teamcode.FlyWeelPract;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.OdometryPract.OdometryMechanism;

@TeleOp
public class kVTunerPol extends OpMode {
    FlyWheel flywheel = new FlyWheel();

    public double kVPol = 0.00085;
    public double kSPol = 0.05;
    public double goalRPM = 2900;
    double[] increments = {0.000001, 0.00001, 0.0001, 0.001, 0.01};
    int incrementIndx = 4;

    @Override
    public void init() {
        flywheel.init(hardwareMap);
    }

    @Override
    public void loop() {
        if(gamepad1.dpadRightWasPressed() && incrementIndx < 4) {
            incrementIndx++;
        } else if(gamepad1.dpadLeftWasPressed() && incrementIndx > 0)  {
            incrementIndx--;
        }

        if(gamepad1.a) {
            goalRPM = 2000;
        } else if (gamepad1.b) {
            goalRPM = 2900;
        }

        double currentStep = increments[incrementIndx];

        if(gamepad1.dpadUpWasPressed()) {kVPol += currentStep;}
        if(gamepad1.dpadDownWasPressed()) {kVPol -= currentStep;}

        double pwr = (kVPol * goalRPM) + kSPol;

        flywheel.setMotorPwr(pwr);

        telemetry.addData("Step", "%.6f", currentStep);
        telemetry.addData("kV", "%.6f", kSPol);
        telemetry.addData("TPS", flywheel.getTPS());
        telemetry.addData("RPM", flywheel.getRPM());

    }
}
