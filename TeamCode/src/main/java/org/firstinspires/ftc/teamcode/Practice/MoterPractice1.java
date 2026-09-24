package org.firstinspires.ftc.teamcode.Practice;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.Practice.mechanism.m_MoterPractice1;

@TeleOp
public class MoterPractice1 extends OpMode {

    m_MoterPractice1 m_Moter = new m_MoterPractice1();

    @Override
    public void init() {
        m_Moter.init(hardwareMap);
    }

    @Override
    public void loop() {
        double yVel = -gamepad1.left_stick_y;
        m_Moter.setMoterSpd(yVel);
    }
}
