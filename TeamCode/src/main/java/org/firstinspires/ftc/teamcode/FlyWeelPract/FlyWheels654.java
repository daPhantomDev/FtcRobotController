package org.firstinspires.ftc.teamcode.FlyWeelPract;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class FlyWheels654 {
    //Flywheel stuff
    private DcMotorEx mNect;
    private DcMotorEx mPol;

    private double encoderCPM = 28;
    private double gearRatio = 5.1;
    private double kVNect = 0.00085, kSNect = 0.05, kPNect = 0.01;
    private double kVPol = 0.00085, kSPol = 0.05, kPPol = 0.01;
    public void init(HardwareMap hwMap) {
        mNect = hwMap.get(DcMotorEx.class, "nectMotor");
        mPol = hwMap.get(DcMotorEx.class, "polMotor");
        mNect.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        mPol.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
    }

    //Necture Motor
    public void setMotorPwrNect(double Pwr) {
        mNect.setPower(Pwr);
    }

    public void stopMoterNect() {mNect.setPower(0);}

    public void setMotorRPMNect(double tgtRpm) {
        //Call every loop
        double err = tgtRpm - getRPMNect();
        double feedFwd = (kVNect * tgtRpm) + kSNect;
        double feedBack = (err * kPNect);
        double pwr = feedFwd + feedBack;
        mNect.setPower(pwr);
    }

    public double getTPSNect() {
        return mNect.getVelocity();
    }

    public double getRPMNect() {
        return ((getTPSNect()/encoderCPM) * 60) / gearRatio;
    }

    //Polon Motor

    public void setMotorPwrPol(double Pwr) {
        mPol.setPower(Pwr);
    }

    public void stopMoterPol() {mPol.setPower(0);}

    public void setMotorRPMPol(double tgtRpm) {
        //Call every loop
        double err = tgtRpm - getRPMNect();
        double feedFwd = (kVPol * tgtRpm) + kSPol;
        double feedBack = (err * kPPol);
        double pwr = feedFwd + feedBack;
        mPol.setPower(pwr);
    }

    public double getTPSPol() {
        return mNect.getVelocity();
    }

    public double getRPMPol() {
        return ((getTPSNect()/encoderCPM) * 60) / gearRatio;
    }
}
