package org.firstinspires.ftc.teamcode.tutorial;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.Range;

/**
 * Created by Student on 8/14/2017.
 */
@TeleOp (name="Tele_Op")
@Disabled
public class Tele_Op extends OpMode {

    private DcMotor leftMotor;
    private DcMotor rightMotor;
    private Servo arm;


    @Override
    public void init() {
        //initialize
        //hardware map
        //syntax: variable name = hardwareMap._____.get ("Name of Motor")
        leftMotor = hardwareMap.dcMotor.get("left_drive");
        rightMotor = hardwareMap.dcMotor.get("right_drive");
        arm = hardwareMap.servo.get("arm");
        //Reverses the motor so that the robot does not spin (direction of motor determines direction of movement)
        leftMotor.setDirection(DcMotor.Direction.REVERSE);

    }

    @Override
    public void start() {
        //setting the power of motors to zero
        leftMotor.setPower(0.0);
        rightMotor.setPower(0);
        arm.setPosition(0);

    }

    @Override
    public void loop() {
        arcadeDrive(-1*gamepad1.left_stick_y, gamepad1.right_stick_x);

    }

    @Override
    public void stop() {

    }
    //always put this at the end for some reason
    public void arcadeDrive(double power, double turn) {
        double leftPower = Range.clip(power + turn, -1, 1);
        double rightPower = Range.clip(power - turn, -1, 1);
        //
        leftMotor.setPower(leftPower);
        rightMotor.setPower(rightPower);
    }
}
