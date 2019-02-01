package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;

@Autonomous
public class Landing extends LinearOpMode {

    @Override
    public void runOpMode() throws InterruptedException {
     //init motor
        DcMotor arm = hardwareMap.get(DcMotor.class, "arm");

        //start the motorized descent
        arm.setPower(0.5);
        sleep(750);

        //stop descending
        arm.setPower(0);

        //driving?
    }
}
