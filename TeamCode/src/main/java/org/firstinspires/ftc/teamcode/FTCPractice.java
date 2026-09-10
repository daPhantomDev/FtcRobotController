package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;

@Disabled
@TeleOp
public class FTCPractice extends OpMode {

    private DcMotor Moter1;
    private Servo Servo1;

    @Override
    public void init() {
        Moter1 = hardwareMap.get(DcMotor.class, "moter1");
        Servo1 = hardwareMap.get(Servo.class, "servo1");
        telemetry.addData("Hello", "Will");
    }

    @Override
    public void loop() {

    }
}