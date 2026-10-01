package org.firstinspires.ftc.teamcode.FlyWeelPract;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

@TeleOp
public class kVTuner extends OpMode {
    FlyWheel flywheel = new FlyWheel();

    public double kV = 0.00085;
    public double kS = 0.05;
    public double goalRPM = 900;
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
            goalRPM = 700;
        } else if (gamepad1.b) {
            goalRPM = 900;
        }

        double currentStep = increments[incrementIndx];

        if(gamepad1.dpadUpWasPressed()) {kV += currentStep;}
        if(gamepad1.dpadDownWasPressed()) {kV -= currentStep;}

        double pwr = (kV * goalRPM) + kS;

        flywheel.setMotorPwr(pwr);

        telemetry.addData("Step", "%.6f", currentStep);
        telemetry.addData("kV", "%.6f", kV);
        telemetry.addData("TPS", flywheel.getTPS());
        telemetry.addData("RPM", flywheel.getRPM());

    }
}
