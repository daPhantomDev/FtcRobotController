package org.firstinspires.ftc.teamcode.Practice;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

@TeleOp
public class VarPractice extends OpMode {

    @Override
    public void init() {
        int teamNum = 654;
        double motSpd = 0.75;
        boolean bool = false;

        telemetry.addData("Team Num", teamNum);
        telemetry.addData("Moter Spd", motSpd);
        telemetry.addData("bool", false);
    }

    @Override
    public void loop() {

    }
}
