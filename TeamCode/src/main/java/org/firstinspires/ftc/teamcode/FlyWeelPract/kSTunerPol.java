package org.firstinspires.ftc.teamcode.FlyWeelPract;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

@TeleOp
public class kSTunerPol  extends OpMode {

    FlyWheel flywheel = new FlyWheel();

    public double kSPol = 0.05;
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

        double currentStep = increments[incrementIndx];

        if(gamepad1.dpadUpWasPressed()) {kSPol += currentStep;}
        if(gamepad1.dpadDownWasPressed()) {kSPol -= currentStep;}


        flywheel.setMotorPwr(kSPol);

        telemetry.addData("Step", "%.6f", currentStep);
        telemetry.addData("kS", "%.6f", kSPol);
        telemetry.addData("TPS", flywheel.getTPS());
        telemetry.addData("RPM", flywheel.getRPM());

    }
}
