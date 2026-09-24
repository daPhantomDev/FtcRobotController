//package org.firstinspires.ftc.teamcode.Practice.mechanism;
//
//import com.qualcomm.robotcore.hardware.DcMotor;
//import com.qualcomm.robotcore.hardware.HardwareMap;
//
//public class m_MoterPractice1 {
//    private DcMotor Moter1;
//
//    public void init(HardwareMap hwMap, ) {
//
//        Moter1 = hwMap.get(DcMotor.class, "moter1");
//        Moter1.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
//    }
//
//    public void setMoterSpd(double spd) {
//        if (spd < 1 || spd > -1) {
//            Moter1.setPower(spd);
//        }
//        else {
//            throw new RuntimeException("A robots speed cannot be over 1 or -1");
//        }
//
//    }
//}