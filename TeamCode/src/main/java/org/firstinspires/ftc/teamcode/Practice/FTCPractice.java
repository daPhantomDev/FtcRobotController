package org.firstinspires.ftc.teamcode.Practice;


import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;


//Ep1
@TeleOp
public class FTCPractice extends OpMode {


    private DcMotor Moter1;
    //private Servo Servo1;
    private final double tics =  5.2 * 28;
    final double TPD = (145.6)/360;


    @Override
    public void init() {
        Moter1 = hardwareMap.get(DcMotor.class, "moter1");
        //Servo1 = hardwareMap.get(Servo.class, "servo1");
        telemetry.addData("Hello", "Will ss");


        Moter1.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        Moter1.setTargetPosition(0);
        Moter1.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        Moter1.setPower(0.5);
    }


    @Override
    public void loop() {
        if(gamepad1.a) {
            Moter1.setTargetPosition((int)(TPD * 90));
        }
        else if(gamepad1.b) {
            Moter1.setTargetPosition((int)(TPD * 180));
        }
        else {
            Moter1.setTargetPosition(0);
        }    }
}







