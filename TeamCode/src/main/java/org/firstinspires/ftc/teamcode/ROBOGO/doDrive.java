package org.firstinspires.ftc.teamcode.ROBOGO;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

@TeleOp
public class doDrive extends OpMode {

    MechDriveChain mech = new MechDriveChain();
    double forward, strafe, rotate;

    @Override
    public void init() {
        mech.init(hardwareMap);
    }

    @Override
    public void loop() {
        forward = gamepad1.left_stick_y;
        strafe = gamepad1.left_stick_x;
        rotate = gamepad1.left_stick_x;

        mech.driveFieldReletive(forward, strafe, rotate);
    }
}
