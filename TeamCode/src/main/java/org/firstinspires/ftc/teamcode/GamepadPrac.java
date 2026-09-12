package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

@TeleOp
public class GamepadPrac extends OpMode {

    @Override
    public void init() {

    }

    @Override
    public void loop() {

        double xDif = gamepad1.left_stick_x - gamepad1.left_stick_y;

        telemetry.addData("x", gamepad1.left_stick_x);
        telemetry.addData("y", gamepad1.left_stick_y);
        telemetry.addData("xR", gamepad1.right_stick_x);
        telemetry.addData("x differance", xDif);
        telemetry.addData("yR", gamepad1.right_stick_y);
        
        telemetry.addData("a", gamepad1.a);
        telemetry.addData("b", gamepad1.b);
    }
}