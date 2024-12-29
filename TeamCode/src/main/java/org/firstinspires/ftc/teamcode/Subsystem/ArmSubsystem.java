package org.firstinspires.ftc.teamcode.Subsystem;

import com.arcrobotics.ftclib.command.SubsystemBase;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.Telemetry;

public class ArmSubsystem extends SubsystemBase {
    HardwareMap hardwareMap;
    Telemetry telemetry;
    DcMotorEx intakearm;

    public ArmSubsystem(HardwareMap hardwareMap, Telemetry telemetry) {
        this.hardwareMap = hardwareMap;
        this.telemetry = telemetry;

        intakearm =  hardwareMap.get(DcMotorEx.class, "intakearm");
        intakearm.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

        intakearm.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

    }

    public  void resetintakearmtiks(){
        intakearm.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
    }

    public void setArmPosition(int pos){
        intakearm.setPower(0.5);
        intakearm.setTargetPosition(pos);
        intakearm.setMode(DcMotor.RunMode.RUN_TO_POSITION);
    }


    public int getPosition(){
        return intakearm.getCurrentPosition();
    }

    public boolean isAtSetPoint() {
        boolean isAtSetPoint = intakearm.getCurrentPosition() - intakearm.getTargetPosition() < intakearm.getTargetPositionTolerance();
        return isAtSetPoint;
    }

    public void AtSetpoint(int position, double armPower) {
        intakearm.setTargetPosition(position);
        intakearm.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        intakearm.setPower(armPower);
    }


    @Override
    public  void periodic() {
        telemetry.addData("armintake", intakearm.getCurrentPosition());
    }
}
