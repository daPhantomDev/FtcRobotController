package org.firstinspires.ftc.teamcode.Practice;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

@TeleOp
public class TeamMemPract extends OpMode {

    boolean initDone;

    @Override
    public void init() {
        telemetry.addData("Init", initDone);
        initDone = true;
    }

    double squareInpWSign(double inp) {
        double out = inp * inp;

        if(inp < 0) {
            out *= -1;
        }
        return out;
    }

    @Override
    public void loop() {
        telemetry.addData("Init", initDone);

        double yAxis = gamepad1.left_stick_y;
        telemetry.addData("Left Stick Norm", yAxis);

        yAxis = squareInpWSign(yAxis);
        telemetry.addData("New Left Stick", yAxis);


    }
}
