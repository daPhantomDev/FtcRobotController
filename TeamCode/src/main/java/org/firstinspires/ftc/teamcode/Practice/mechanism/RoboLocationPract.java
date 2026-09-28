package org.firstinspires.ftc.teamcode.Practice.mechanism;

public class RoboLocationPract {

    double angle;

    //contructor method
    public RoboLocationPract(double angle) {
        this.angle = angle;
    }

    public double getHeading() {
        double angle = this.angle;
        while(angle > 180) {
            angle -= 360;
        }

//        while(angle <= -180) {
//            angle += 360;
//        }
        return angle;
    }

    public void turnRobo(double angleChange) {
        angle += angleChange;
    }

    public void setAngle(double angle) {
        this.angle = angle;
    }

    public double getAngle() {
        return this.angle;
    }
}
