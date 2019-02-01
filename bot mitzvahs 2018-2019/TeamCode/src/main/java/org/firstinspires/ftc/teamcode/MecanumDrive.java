package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;


@TeleOp
public class MecanumDrive extends OpMode {

    private DcMotor frontleft, backLeft, frontRight, backRight, arm;

    @Override
    public void init() {
        telemetry.addData("Starting up Mecanum Drive", "initializing");
        frontleft = hardwareMap.get(DcMotor.class, "front left");
        backLeft = hardwareMap.get(DcMotor.class, "back left");
        frontRight = hardwareMap.get(DcMotor.class, "front right");
        backRight = hardwareMap.get(DcMotor.class, "back right");
        arm = hardwareMap.get(DcMotor.class, "arm");
    }

    @Override
    public void loop() {

        double Vd = Math.hypot(gamepad1.left_stick_x, gamepad1.left_stick_y);
        double thetad = Math.atan2(gamepad1.left_stick_y, gamepad1.left_stick_x);
        double Vtheta = gamepad1.right_stick_x;

        frontleft.setPower(Vd * Math.sin(thetad + Math.PI / 4.0) + Vtheta);
        frontRight.setPower(Vd * Math.cos(thetad + Math.PI / 4.0) - Vtheta);
        backLeft.setPower(-1*(Vd * Math.cos(thetad + Math.PI / 4.0) + Vtheta));
        backRight.setPower(-1*(Vd * Math.sin(thetad + Math.PI / 4.0) - Vtheta ));

        if(gamepad1.dpad_up) {
            arm.setPower(0.5);
        } else if (gamepad1.dpad_down) {
            arm.setPower(-0.5);
        } else {
            arm.setPower(0);
        }
        telemetry.addData("arm position", arm.getCurrentPosition());
    }
}
