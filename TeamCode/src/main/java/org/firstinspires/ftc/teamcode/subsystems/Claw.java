package org.firstinspires.ftc.teamcode.subsystems;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.ElapsedTime;

public class Claw {
    private final Servo claw;
    private static final double OPEN_POS = .12;
    private static final double CLOSE_POS = .86;
    private final ElapsedTime timer = new ElapsedTime();

    public Claw(HardwareMap hardwareMap) {
        claw = hardwareMap.get(Servo.class, "wbgrab");
    }

    public void close() {
        claw.setPosition(CLOSE_POS);
    }
    public void close(LinearOpMode opMode) {
        close();
        // wait for .5 sec
        timer.reset();
        while (timer.seconds() < .5 && opMode.opModeIsActive());
    }
    public void open() {
        claw.setPosition(OPEN_POS);
    }

    public double getPosition() {
        return claw.getPosition();
    }
}
