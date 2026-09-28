package org.firstinspires.ftc.teamcode.Practice;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.Practice.mechanism.RoboLocationPract;

@TeleOp
public class UseRoboLocation extends OpMode {

    RoboLocationPract roboLocationPract = new RoboLocationPract(0);

    @Override
    public void init() {
        roboLocationPract.setAngle(0);

    }

    @Override
    public void loop() {
        if(gamepad1.a) {
            roboLocationPract.turnRobo(0.1);
        }
        else if (gamepad1.b) {
            roboLocationPract.turnRobo(-0.1);
        }

        telemetry.addData("Heading", roboLocationPract.getHeading());
        telemetry.addData("Angle", roboLocationPract.getAngle());
    }
}
