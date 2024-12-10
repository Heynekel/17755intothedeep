package org.firstinspires.ftc.teamcode.Subsystem;

import com.arcrobotics.ftclib.command.SubsystemBase;
import com.arcrobotics.ftclib.hardware.ServoEx;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.Telemetry;

public class Intake extends SubsystemBase {
    HardwareMap hardwareMap;
    Telemetry telemetry;
    CRServo ser1, ser2;
    DcMotorEx intakearm;

    public  Intake(HardwareMap hardwareMap, Telemetry telemetry){
        this.hardwareMap = hardwareMap;
        this.telemetry = telemetry;

        ser1 = hardwareMap.get(CRServo.class, "ser1");
        ser2 = hardwareMap.get(CRServo.class, "ser2");
        ser2.setDirection(DcMotorSimple.Direction.REVERSE);
        intakearm =  hardwareMap.get(DcMotorEx.class, "intakearm");
        intakearm.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

    }
    public  void agarrar (double power){
        ser2.setPower(power);
        ser1.setPower(power);

    }

    public  void resetintakearmtiks(){
        intakearm.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
    }
    public void setPosition(int pos){

        intakearm.setPower(1);
        intakearm.setTargetPosition(pos);
        intakearm.setMode(DcMotor.RunMode.RUN_TO_POSITION);
    }
    public  void SetPower(double power){
        intakearm.setPower(power);
    }

    @Override
    public  void periodic(){
        telemetry.addData("ser2", ser2.getPower());
        telemetry.addData("ser1", ser1.getPower());
       telemetry.addData("armintake", intakearm.getCurrentPosition());
    }


}
