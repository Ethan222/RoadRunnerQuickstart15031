package org.firstinspires.ftc.teamcode.subsystems;

import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

public class Claw {
    private final Servo claw;
    private static final double OPEN_POS = .12;
    private static final double CLOSE_POS = .86;

    public Claw(HardwareMap hardwareMap) {
        claw = hardwareMap.get(Servo.class, "wbgrab");
    }

    public void close() {
        claw.setPosition(CLOSE_POS);
    }
    public void open() {
        claw.setPosition(OPEN_POS);
    }

    public double getPosition() {
        return claw.getPosition();
    }
}
