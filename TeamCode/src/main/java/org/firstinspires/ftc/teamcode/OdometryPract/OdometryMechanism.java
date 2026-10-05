package org.firstinspires.ftc.teamcode.OdometryPract;

import com.qualcomm.hardware.gobilda.GoBildaPinpointDriver;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class OdometryMechanism {

    private GoBildaPinpointDriver odoPin;

    public void init(HardwareMap hwMap) {
        odoPin = hwMap.get(GoBildaPinpointDriver.class,"pinpoint");
    }


}
