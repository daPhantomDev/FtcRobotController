package org.firstinspires.ftc.teamcode.TurretPract;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;

@com.qualcomm.robotcore.eventloop.opmode.TeleOp
public class TeleOp extends OpMode {

    flyWheels wheel = new flyWheels();
    drvTrainMech mech = new drvTrainMech();
    @Override
    public void init() {
        wheel.init(hardwareMap);
        mech.init(hardwareMap);
    }

    @Override
    public void loop() {
        mech.drive(-gamepad1.left_stick_y, gamepad1.left_stick_x, gamepad1.right_stick_x);

        if(gamepad1.left_stick_y == 0 && gamepad1.left_stick_x == 0 && gamepad1.right_stick_x == 0) {
            mech.stop();
        }

        if(gamepad1.a) {
            wheel.setMotorRPMNect(900);
        } else if (gamepad1.b) {
            wheel.setMotorRPMPol(900);
        }
    }
}
