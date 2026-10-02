package org.firstinspires.ftc.teamcode.FlyWeelPract;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class FlyWheel {
    private DcMotorEx m1;

    private double encoderCPM = 28;
    //private double encoderCPR = 141.6;
    private double gearRatio = 5.1;
    private double kV = 0.00085, kS = 0.05, kP = 0.01;
    public void init(HardwareMap hwMap) {
        m1 = hwMap.get(DcMotorEx.class, "leftMotor");
        m1.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
    }

    public void setMotorPwr(double Pwr) {
        m1.setPower(Pwr);
    }

    public void stopMoter() {m1.setPower(0);}

    public void setMotorRPM(double tgtRpm) {
        //Call every loop
        double err = tgtRpm - getRPM();
        double feedFwd = (kV * tgtRpm) + kS;
        double feedBack = (err * kP);
        double pwr = feedFwd + feedBack;
        m1.setPower(pwr);
    }

    public double getTPS() {
        return m1.getVelocity();
    }

    public double getRPM() {
        return ((getTPS()/encoderCPM) * 60) / gearRatio;
    }
}
