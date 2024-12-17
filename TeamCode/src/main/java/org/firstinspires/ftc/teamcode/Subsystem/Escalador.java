package org.firstinspires.ftc.teamcode.Subsystem;

import com.arcrobotics.ftclib.command.SubsystemBase;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.Telemetry;

public class Escalador extends SubsystemBase {

    HardwareMap hardwareMap;

    Telemetry telemetry;

    DcMotorEx escalador, escalador2;

    public Escalador (HardwareMap hardwareMap, Telemetry telemetry){
        this.hardwareMap =  hardwareMap;
        this.telemetry = telemetry;

        escalador = hardwareMap.get(DcMotorEx.class, " escalador");
        escalador.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        escalador2 = hardwareMap.get(DcMotorEx.class, " escalador2");
        escalador2.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
    }

    public  void setPower(double power){
        escalador.setPower(power);
        escalador2.setPower(power);
    }

    @Override
    public void periodic(){
        telemetry.addData("escalador", escalador.getCurrentPosition());
        telemetry.addData("escalador", escalador2.getCurrentPosition());
    }
}
