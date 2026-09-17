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

        Moter1.setTargetPosition((int)-yVel);
        Moter2.setTargetPosition((int)-xVel);
    }
}
