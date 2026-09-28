package org.firstinspires.ftc.teamcode.Practice;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;
import org.firstinspires.ftc.teamcode.Practice.mechanism.RoboControlerIMU;

@TeleOp
public class IMUPractice extends OpMode {

    RoboControlerIMU m_imu = new RoboControlerIMU();

    @Override
    public void init() {
        m_imu.init(hardwareMap);
    }

    @Override
    public void loop() {
        telemetry.addData("Heading", m_imu.getHeading(AngleUnit.DEGREES));
    }
}
