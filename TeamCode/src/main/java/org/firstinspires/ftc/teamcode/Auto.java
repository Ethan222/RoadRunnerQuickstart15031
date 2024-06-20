package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.teamcode.subsystems.Robot;

public class Auto extends LinearOpMode {
    @Override
    public void runOpMode() throws InterruptedException {
        // initialization
        Robot robot = new Robot(hardwareMap);
        ElapsedTime runTimer = new ElapsedTime();

        waitForStart();
        runTimer.reset();

        robot.arm.claw.close(this);
        robot.arm.up();

        telemetry.addData("Runtime", "%.1fs", runTimer.seconds());
        telemetry.update();
    }
}
