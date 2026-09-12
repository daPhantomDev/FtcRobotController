package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.mechanism.ServoPractice;

@TeleOp
public class ServoEx extends OpMode {

    ServoPractice c_Servo = new ServoPractice();
    double leftTrig, rightTrig;

    @Override
    public void init() {
        c_Servo.init(hardwareMap);
        leftTrig = 0.0;
        rightTrig = 0.0;
    }

    @Override
    public void loop() {
//        if(gamepad1.a) {
//            c_Servo.setServoPos(1.0);
//        }
//        else if(gamepad1.b) {
//            c_Servo.setServoPos(0.5);
//        }
//        else {
//            c_Servo.setServoPos(0.0);
//        }

        leftTrig = gamepad1.left_trigger;
        rightTrig = gamepad1.right_trigger;

        c_Servo.setServoPos(leftTrig);
        c_Servo.setServoPos(rightTrig);
    }
}
