package org.firstinspires.ftc.teamcode.tutorial;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.util.Range;

/**
 * Created by Student on 8/12/2017.
 */
@Autonomous(name="Autonomous_Tutorial")
@Disabled

public class Autonomous_Tutorial extends LinearOpMode {

    private DcMotor leftMotor;
    private DcMotor rightMotor;
    private ElapsedTime runtime = new ElapsedTime();
    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////"""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````
    @Override
    public void runOpMode() throws InterruptedException {

        leftMotor = hardwareMap.dcMotor.get("left_drive");
        rightMotor = hardwareMap.dcMotor.get("right_drive");
        leftMotor.setDirection(DcMotor.Direction.REVERSE);
// remember the reason why you reverse the code for the left motor?
        //after waitForStart(), the robot will run the code
        waitForStart();

        /* The robot's power is 0.4, it will go 48 inches forward, with a 3-second pause (timeoutS)
            before going to its next move */

        encoderDrive(0.5, 48, 48, 3);

        //set the power to 0.7, turn 30 inches to the left, with a four second timeout

        //set the power to 0.5, turn 40 inches to the right, with a 2 second timeout
    }
    public void arcadeDrive(double speed, double leftInches, double rightInches, double timeoutS) throws InterruptedException {
        int newLeftTarget;
        int newRightTarget;
        if (opModeIsActive()) {
            newLeftTarget = leftMotor.getCurrentPosition() * (int) (leftInches * 1440);
            newRightTarget = rightMotor.getCurrentPosition() * (int) (rightInches * 1440);
            leftMotor.setTargetPosition(newLeftTarget);
            rightMotor.setTargetPosition(newRightTarget);

            runtime.reset();
            leftMotor.setPower(speed);
            rightMotor.setPower(speed);
            //setting the program up so that the robot can use the encoders
            while (opModeIsActive() && (runtime.seconds() < timeoutS) &&
                    (leftMotor.isBusy() && rightMotor.isBusy())) {
                //^^ checks that all conditions are okay before proceeding
                idle();
            }
        }
    }


    public void encoderDrive(double speed, double leftInches, double rightInches, double timeoutS) throws InterruptedException {
        int newLeftTarget;
        int newRightTarget;
// using distance via encoders to control the length the motor runs
        if (opModeIsActive()) {
            newLeftTarget = leftMotor.getCurrentPosition() * (int) (leftInches * 1440);
            newRightTarget = rightMotor.getCurrentPosition() * (int) (rightInches * 1440);
            // 1440 ticks = 1 rotation on Tetrix
            // measure # of rotations
            leftMotor.setTargetPosition(newLeftTarget);
            rightMotor.setTargetPosition(newRightTarget);

            leftMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            rightMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);

            runtime.reset();
            leftMotor.setPower(speed);
            rightMotor.setPower(speed);
            //setting the program up so that the robot can use the encoders
            while (opModeIsActive() && (runtime.seconds() < timeoutS) &&
                    (leftMotor.isBusy() && rightMotor.isBusy())) {
                //^^ checks that all conditions are okay before proceeding
                idle();
            }

    /*
    // the robot will drive forward for 4 seconds
    arcadeDrive(0.5, 0);
    runtime.reset();
    while (opModeIsActive() && (runtime.seconds() < 4.0))  {
        telemetry.addData("Path", "1: Drive forward for 4 seconds", runtime.seconds());
        telemetry.update();
        // using time to control the length the motor runs
    }

    //The robot will drive backwards for 6 seconds
    arcadeDrive(-0.5, 0);
    runtime.reset();
    while (opModeIsActive() && (runtime.seconds() < 6.0))  {
        telemetry.addData("Path", "1: Drive forward for 6 seconds", runtime.seconds());
        telemetry.update();
    } */
            //Always put this at the end of this kind of statement
            //  idle();
        }/*

    public void arcadeDrive(double power, double turn) {
        double leftPower = Range.clip(power + turn, -1, 1);
        double rightPower = Range.clip(power + turn, -1, 1);
        //*the range clip makes sure that the robot runs within the values -1 and 1.
        leftMotor.setPower(leftPower);
        rightMotor.setPower(rightPower);
    }

    public void encoderDrive(double speed, double leftInches, double rightInches, double timeoutS) throws InterruptedException {
        int newLeftTarget;
        int newRightTarget;
// using distance via encoders to control the length the motor runs
        if(opModeIsActive()) {
            newLeftTarget = leftMotor.getCurrentPosition () * (int) (leftInches * 1440);
            newRightTarget = rightMotor.getCurrentPosition() * (int) (rightInches * 1440);
            // 1440 ticks = 1 rotation on Tetrix
            // measure # of rotations
            leftMotor.setTargetPosition(newLeftTarget);
            rightMotor.setTargetPosition(newRightTarget);

            leftMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            rightMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);

            runtime.reset();
            leftMotor.setPower(speed);
            rightMotor.setPower(speed);
            //setting the program up so that the robot can use the encoders
            while(opModeIsActive() && (runtime.seconds() < timeoutS) &&
                    (leftMotor.isBusy() && rightMotor.isBusy())) {
                //^^ checks that all conditions are okay before proceeding
                idle();
            } */
    }
}


