package org.firstinspires.ftc.teamcode.ROBOGO;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.opencv.core.Mat;

public class MechDriveChain {
    private DcMotor m_FL;
    private DcMotor m_FR;
    private DcMotor m_BL;
    private DcMotor m_BR;

    public void init(HardwareMap hwMap) {
        m_FL = hwMap.get(DcMotor.class, "frontLeft");
        m_FR = hwMap.get(DcMotor.class, "frontRight");
        m_BL = hwMap.get(DcMotor.class, "backLeft");
        m_BR = hwMap.get(DcMotor.class, "backRight");
        //Dietion tweaking
        m_FL.setDirection(DcMotorSimple.Direction.REVERSE);
        m_BL.setDirection(DcMotorSimple.Direction.REVERSE);
        m_FR.setDirection(DcMotorSimple.Direction.FORWARD);
        m_BR.setDirection(DcMotorSimple.Direction.FORWARD);
        //Stop when at 0
        m_FL.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        m_FR.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        m_BL.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        m_BR.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
    }

    public void drive(double drive, double strafe, double turn) {
        //Mechanicum formulas
        double flPwr = drive + strafe  + turn;
        double frPwr = drive - strafe - turn;
        double blPwr = drive - strafe + turn;
        double brPwr = drive + strafe - turn;
        //Maximum absolute power and normalize it
        double max = 1.0;
        max = Math.max(max, Math.abs(flPwr));
        max = Math.max(max, Math.abs(frPwr));
        max = Math.max(max, Math.abs(blPwr));
        max = Math.max(max, Math.abs(brPwr));

        if(max > 1.0) {
            flPwr /= max;
            frPwr /= max;
            blPwr /= max;
            brPwr /= max;
        }

        m_FL.setPower(flPwr);
        m_FR.setPower(frPwr);
        m_BL.setPower(brPwr);
        m_BL.setPower(brPwr);
    }

    public void stop() {
        drive(0, 0, 0);
    }
}
