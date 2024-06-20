package org.firstinspires.ftc.teamcode.subsystems;

import com.acmerobotics.dashboard.config.Config;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;

@Config
public class Arm extends EncoderMotor {
    public Claw claw;

    public Arm(HardwareMap hardwareMap) {
        super(hardwareMap, "motor", 0, 1000);
        motor.setDirection(DcMotorSimple.Direction.REVERSE);
        motor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        claw = new Claw(hardwareMap);
    }

    public void up(double power) {
        motor.setPower(power);
    }
    public void up() {
        up(1);
    }

    public void down(double power) {
        motor.setPower(-power);
    }
    public void down() {
        down(1);
    }

    public void goToUpPosition(LinearOpMode opMode, double power) {
        goToPosition(UP_POSITION, power, opMode);
    }

    public void goToDownPosition(LinearOpMode opMode, double pwr) {
        goToPosition(DOWN_POSITION, pwr, opMode);
    }
}
