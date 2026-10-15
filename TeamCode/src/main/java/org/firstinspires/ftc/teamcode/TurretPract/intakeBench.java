package org.firstinspires.ftc.teamcode.TurretPract;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class intakeBench {
    private DcMotor intake1, intake2;

    public void init(HardwareMap hwMap) {
        intake1 = hwMap.get(DcMotor.class, "Placeholder1");
        intake2 = hwMap.get(DcMotor.class, "Placeholder2");

        intake1.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        intake2.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
    }

    public void activateIntakes(boolean btn) {
        if(btn) {
            intake1.setPower(0.3);
            intake2.setPower(0.3);
        }
        else {
            intake1.setPower(0);
            intake2.setPower(0);
        }
    }
}
