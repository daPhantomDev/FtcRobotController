package org.firstinspires.ftc.teamcode.Practice;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

@TeleOp
public class MoterPractice1 extends OpMode {

    DcMotor m_FL;
    DcMotor m_FR;
    DcMotor m_BL;
    DcMotor m_BR;

    @Override
    public void init() {

        m_FL = hardwareMap.get(DcMotor.class, "moter1");
        m_FR = hardwareMap.get(DcMotor.class, "moter2");
        m_BL = hardwareMap.get(DcMotor.class, "moter3");
        m_BR = hardwareMap.get(DcMotor.class, "moter4");
    }

    @Override
    public void loop() {
        double yVel = -gamepad1.left_stick_y;
        double xVel = gamepad1.left_stick_x;

        //Stick drift protection
        if(yVel <= 0.2 && yVel >= -0.2) {
            yVel = 0;
        }
        if(xVel <= 0.2 && xVel >= -0.2) {
            xVel = 0;
        }

        //Basic Forward
        if(yVel < 1 && yVel > -1) {
            m_FL.setPower(yVel);
            m_FR.setPower(yVel);
            m_BL.setPower(yVel);
            m_BR.setPower(yVel);
        }

        //Turning
        if(xVel < 1 && xVel > 1) {
            //Right
            if(xVel > 0) {
                m_FR.setPower(0.5);
            }
        }
    }
}
