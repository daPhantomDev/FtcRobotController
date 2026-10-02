package org.firstinspires.ftc.teamcode.FlyWeelPract;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.VoltageSensor;

@TeleOp
public class kPTuner extends OpMode {
    FlyWheel flywheel = new FlyWheel();

    public double kV = 0.00080;
    public double kS = 0.05;
    public double kP = 0.01;
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
            goalRPM = 600;
        } else if (gamepad1.b) {
            goalRPM = 900;
        }

        //Change kP
        double currentStep = increments[incrementIndx];

        if(gamepad1.dpadUpWasPressed()) {kP += currentStep;}
        if(gamepad1.dpadDownWasPressed()) {kP -= currentStep;}

        double feedForward = (kV * goalRPM) + kS;

        double err = goalRPM + flywheel.getRPM();
        double feedBack = (err * kP);

        flywheel.setMotorPwr(feedForward + feedBack);

        telemetry.addData("Step", "%.6f", currentStep);
        telemetry.addData("kP", "%.6f", kP);
        telemetry.addData("Error", err);
        telemetry.addData("TPS", flywheel.getTPS());
        telemetry.addData("RPM", flywheel.getRPM());
        telemetry.addData("Goal RPM", goalRPM);
        //telemetry.addData("Battery Voltage", "%.2f Volts", currentVoltage);

    }
}
