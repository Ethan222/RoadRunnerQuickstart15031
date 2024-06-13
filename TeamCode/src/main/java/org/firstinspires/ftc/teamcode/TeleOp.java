package org.firstinspires.ftc.teamcode;

import com.acmerobotics.roadrunner.geometry.Pose2d;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.teamcode.roadrunner.drive.SampleMecanumDrive;

@com.qualcomm.robotcore.eventloop.opmode.TeleOp (group = "drive")
public class TeleOp extends LinearOpMode {
    private static final double CLAW_OPEN_POS = .12;
    private static final double CLAW_CLOSE_POS = .86;
    private Servo claw;

    @Override
    public void runOpMode() throws InterruptedException {
        /******* Initialization *******/
        // initialize drivetrain
        SampleMecanumDrive drive = new SampleMecanumDrive(hardwareMap);
        drive.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);

        // initialize servo
        claw = hardwareMap.get(Servo.class, "wbgrab");

        /*** Wait for start button ***/
        waitForStart();

        // keep repeating this code until stop button is pressed
        while (!isStopRequested()) {
            /*** runtime code ***/
            // update drive
            drive.setWeightedDrivePower(
                    new Pose2d(
                            -gamepad1.left_stick_y,
                            -gamepad1.left_stick_x,
                            -gamepad1.right_stick_x
                    )
            );
            drive.update();

            // control servo with a/b
            if (gamepad1.a) {
                closeClaw();
            } else if (gamepad1.b) {
                openClaw();
            }

            // close the claw
            closeClaw();

            // update the telemetry
            telemetry.addData("Claw position", "%.3f", claw.getPosition());
            telemetry.update();
        }
    }

    private void closeClaw() {
        claw.setPosition(CLAW_CLOSE_POS);
    }
    private void openClaw() {
        claw.setPosition(CLAW_OPEN_POS);
    }
}
