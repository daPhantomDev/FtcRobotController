package org.firstinspires.ftc.teamcode.Practice;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;

public class BasicMoterControl extends LinearOpMode {

    private DcMotor Moter1;
    private DcMotor Moter2;

    @Override
    public void runOpMode() throws InterruptedException {
        double yVel = gamepad1.left_stick_y;
        double xVel = gamepad1.left_stick_x;

        Moter1 = hardwareMap.get(DcMotor.class, "moter1");
        Moter2 = hardwareMap.get(DcMotor.class, "moter2");

        Moter1.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        if(gamepad1.aWasPressed()) {
            Moter1.setPower(-yVel);
            Moter2.setPower(-xVel);
        }
        else if(gamepad1.backWasPressed()) {
            Moter1.setPower(-yVel * 0.5);
            Moter2.setPower(-xVel * 0.5);
        }
    }
}
