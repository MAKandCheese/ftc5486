package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

@TeleOp
public class MecanumDrive extends OpMode {

    private DcMotor frontleft, backLeft, frontRight, backRight;

    @Override
    public void init() {
        telemetry.addData("Starting up Mecanum Drive", "initializing");
        frontleft = hardwareMap.get(DcMotor.class, "front left");
        backLeft = hardwareMap.get(DcMotor.class, "back left");
        frontRight = hardwareMap.get(DcMotor.class, "front right");
        backRight = hardwareMap.get(DcMotor.class, "back right");
    }

    @Override
    public void loop() {
        double r = Math.hypot(gamepad1.left_stick_x, gamepad1.left_stick_y);
        double robotAngle = Math.atan2(gamepad1.left_stick_y, gamepad1.left_stick_x) - Math.PI / 4;
        double rightX = gamepad1.right_stick_x;
        final double v1 = r * Math.cos(robotAngle) + rightX;
        final double v2 = r * Math.sin(robotAngle) - rightX;
        final double v3 = r * Math.sin(robotAngle) + rightX;
        final double v4 = r * Math.cos(robotAngle) - rightX;

        frontleft.setPower(v1);
        frontRight.setPower(v2);
        backLeft.setPower(v3);
        backRight.setPower(v4);
    }
}
