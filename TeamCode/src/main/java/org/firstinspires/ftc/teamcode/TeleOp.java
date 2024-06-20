package org.firstinspires.ftc.teamcode;

import com.acmerobotics.roadrunner.geometry.Pose2d;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;

import org.firstinspires.ftc.teamcode.subsystems.Robot;

@com.qualcomm.robotcore.eventloop.opmode.TeleOp (group = "drive")
public class TeleOp extends LinearOpMode {
    @Override
    public void runOpMode() throws InterruptedException {
        /******* Initialization *******/
        Robot robot = new Robot(hardwareMap);
        robot.drive.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);

        /*** Wait for start button ***/
        waitForStart();

        // keep repeating this code until stop button is pressed
        while (!isStopRequested()) {
            /*** runtime code ***/
            // update drive
            robot.drive.setWeightedDrivePower(
                    new Pose2d(
                            -gamepad1.left_stick_y,
                            -gamepad1.left_stick_x,
                            -gamepad1.right_stick_x
                    )
            );
            robot.drive.update();

            // control servo with a/b
            if (gamepad1.a) {
                robot.arm.claw.close();
            } else if (gamepad1.b) {
                robot.arm.claw.open();
            }

            // update the telemetry
            telemetry.addData("Claw position", "%.3f", robot.arm.claw.getPosition());
            telemetry.update();
        }
    }
}
