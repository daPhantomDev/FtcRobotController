package org.firstinspires.ftc.teamcode.ROBOGO;

import com.qualcomm.hardware.rev.RevHubOrientationOnRobot;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.IMU;

import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;
import org.opencv.core.Mat;

public class drvTrainMech {
    private DcMotor m_FL, m_BL, m_FR, m_BR;
    private IMU imu;

    public void init(HardwareMap hwMap) {
        m_FL = hwMap.get(DcMotorEx.class, "frontLeft_Drive");
        m_BL = hwMap.get(DcMotorEx.class, "backLeft_Drive");
        m_FR = hwMap.get(DcMotorEx.class, "frontRight_Drive");
        m_BR = hwMap.get(DcMotorEx.class, "backLeft_Drive");

        m_FL.setDirection(DcMotor.Direction.REVERSE);
        m_BL.setDirection(DcMotor.Direction.REVERSE);

        m_FL.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        m_BL.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        m_FR.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        m_BR.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

        imu = hwMap.get(IMU.class, "imu");

        RevHubOrientationOnRobot RevHubOrient = new RevHubOrientationOnRobot( RevHubOrientationOnRobot.LogoFacingDirection.UP, RevHubOrientationOnRobot.UsbFacingDirection.FORWARD);

        imu.initialize(new IMU.Parameters(RevHubOrient));
    }

    public void drive(double forward, double strafe, double rotate) {
        double flPwr = forward + strafe + rotate;
        double blPwr = forward - strafe + rotate;
        double frPwr = forward - strafe - rotate;
        double brPwr = forward + strafe - rotate;

        double maxPwr = 1.0;
        double maxSpd = 1.0;

        maxPwr = Math.max(maxPwr, Math.abs(flPwr));
        maxPwr = Math.max(maxPwr, Math.abs(blPwr));
        maxPwr = Math.max(maxPwr, Math.abs(frPwr));
        maxPwr = Math.max(maxPwr, Math.abs(brPwr));

        m_FL.setPower(maxSpd * (flPwr / maxPwr));
        m_BL.setPower(maxSpd * (blPwr / maxPwr));
        m_FR.setPower(maxSpd * (frPwr / maxPwr));
        m_BR.setPower(maxSpd * (brPwr / maxPwr));
    }

    public void driveFieldReletive(double forward, double strafe, double rotate) {
        double theda = Math.atan2(forward, strafe);
        double r = Math.hypot(strafe, rotate);

        theda = AngleUnit.normalizeRadians(theda - imu.getRobotYawPitchRollAngles().getYaw(AngleUnit.RADIANS));
        double newForward = r * Math.sin(theda);
        double newStrafe = r * Math.cos(theda);
        drive(newForward, newStrafe, rotate);
    }
}
