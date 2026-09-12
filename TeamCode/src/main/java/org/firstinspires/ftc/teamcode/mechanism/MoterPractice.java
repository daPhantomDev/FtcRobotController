package org.firstinspires.ftc.teamcode.mechanism;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class MoterPractice {
    private DcMotor Moter1;


    public void init(HardwareMap hwMap){

        Moter1 = hwMap.get(DcMotor.class, "moter1");
        Moter1.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
    }
}
