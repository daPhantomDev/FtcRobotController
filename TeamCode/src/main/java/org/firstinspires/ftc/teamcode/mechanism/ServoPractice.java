package org.firstinspires.ftc.teamcode.mechanism;

import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

public class ServoPractice {

    private Servo servo_pos;


    public void init(HardwareMap hwMap) {
        servo_pos = hwMap.get(Servo.class, "servo1_pos");
    }

    public void setServoPos(double angle) {
        servo_pos.setPosition(angle);
    }
}
