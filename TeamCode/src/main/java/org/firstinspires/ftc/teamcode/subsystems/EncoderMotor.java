package org.firstinspires.ftc.teamcode.subsystems;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class EncoderMotor {
    protected final DcMotor motor;
    public static int DOWN_POSITION, UP_POSITION;

    public EncoderMotor(HardwareMap hardwareMap, String name, int downPsn, int upPsn) {
        motor = hardwareMap.get(DcMotor.class, name);
        motor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        DOWN_POSITION = downPsn;
        UP_POSITION = upPsn;
    }

    public int getPosition() {
        return motor.getCurrentPosition();
    }

    public void goToPosition(int targetPos, double power, LinearOpMode opMode) {
        while (Math.abs(getPosition() - targetPos) < 10 && opMode.opModeIsActive()) {
            if (getPosition() < targetPos)
                motor.setPower(power);
            else motor.setPower(-power);
        }
    }
    public void goToPosition(int targetPos, LinearOpMode opMode) {
        goToPosition(targetPos, 1, opMode);
    }
}
