package org.firstinspires.ftc.teamcode.tutorial;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;

/**
 * Created by Student on 8/14/2017.
 */

    @TeleOp (name="practice_Coding")
    @Disabled
public class practice_Coding extends OpMode {

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
    }
}
