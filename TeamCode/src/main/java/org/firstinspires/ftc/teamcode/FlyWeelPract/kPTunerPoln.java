
package org.firstinspires.ftc.teamcode.FlyWeelPract;


import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;


@TeleOp
public class kPTunerPoln extends OpMode {
    FlyWheels654 flywheel = new FlyWheels654();


    public double kVPol = 0.00080;
    public double kSPol = 0.05;
    public double kPPol = 0.01;
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
            goalRPM = 2900;
        } else if (gamepad1.b) {
            goalRPM = 2000;
        }


        //Change kP
        double currentStep = increments[incrementIndx];


        if(gamepad1.dpadUpWasPressed()) {kPPol += currentStep;}
        if(gamepad1.dpadDownWasPressed()) {kPPol -= currentStep;}


        double feedForward = (kVPol * goalRPM) + kSPol;


        double err = goalRPM + flywheel.getRPMPol();
        double feedBack = (err * kPPol);


        flywheel.setMotorPwrPol(feedForward + feedBack);


        telemetry.addData("Step", "%.6f", currentStep);
        telemetry.addData("kP", "%.6f", kPPol);
        telemetry.addData("Error", err);
        telemetry.addData("TPS", flywheel.getTPSPol());
        telemetry.addData("RPM", flywheel.getRPMPol());
        telemetry.addData("Goal RPM", goalRPM);
        //telemetry.addData("Battery Voltage", "%.2f Volts", currentVoltage);


    }
}

