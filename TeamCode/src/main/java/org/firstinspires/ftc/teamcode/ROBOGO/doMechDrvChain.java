package org.firstinspires.ftc.teamcode.ROBOGO;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

@TeleOp
public class doMechDrvChain extends OpMode {

    private DcMotor m_FL;
    private DcMotor m_FR;
    private DcMotor m_BL;
    private DcMotor m_BR;

    @Override
    public void init() {
        m_FL = hardwareMap.get(DcMotor.class, "frontLeft");
        m_FR = hardwareMap.get(DcMotor.class, "frontRight");
        m_BL = hardwareMap.get(DcMotor.class, "backLeft");
        m_BR = hardwareMap.get(DcMotor.class, "backRight");

        // Direction tweaking:
        // If a wheel still spins backward when given positive power,
        // flip its direction between FORWARD and REVERSE here.
        m_FL.setDirection(DcMotorSimple.Direction.REVERSE);
        m_BL.setDirection(DcMotorSimple.Direction.REVERSE);
        m_FR.setDirection(DcMotorSimple.Direction.FORWARD);
        m_BR.setDirection(DcMotorSimple.Direction.FORWARD);

        m_FL.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        m_BL.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        m_FR.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        m_BR.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
    }

    @Override
    public void loop() {
        // Corrected Mecanum formulas with proper operators
        double drive = -gamepad1.left_stick_y;  // Forward/Backward
        double strafe = gamepad1.left_stick_x;  // Left/Right strafe
        double rotate = gamepad1.right_stick_x; // Turning

        double flPwr = drive + strafe + rotate;
        double frPwr = drive - strafe - rotate;
        double blPwr = drive - strafe + rotate;
        double brPwr = drive + strafe - rotate;

        // Maximum absolute power normalization to prevent clipping past 1.0
        double maxPwr = 1.0;
        double maxSpd = 1.0;
        maxPwr = Math.max(maxPwr, Math.abs(flPwr));
        maxPwr = Math.max(maxPwr, Math.abs(frPwr));
        maxPwr = Math.max(maxPwr, Math.abs(blPwr));
        maxPwr = Math.max(maxPwr, Math.abs(brPwr));

        m_FL.setPower(maxSpd * (flPwr / maxPwr));
        m_BL.setPower(maxSpd * (flPwr / maxPwr));ff
        m_FR.setPower(maxSpd * (flPwr / maxPwr));
        m_BR.setPower(maxSpd * (flPwr / maxPwr));

//        if (max > 1.0) {
//            flPwr /= max;
//            frPwr /= max;
//            blPwr /= max;
//            brPwr /= max;
//        }

//        m_FL.setPower(flPwr);
//        m_FR.setPower(frPwr);
//        m_BL.setPower(blPwr);
//        m_BR.setPower(brPwr);
    }


}