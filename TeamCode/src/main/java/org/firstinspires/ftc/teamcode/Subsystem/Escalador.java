package org.firstinspires.ftc.teamcode.Subsystem;

import com.arcrobotics.ftclib.command.SubsystemBase;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.Telemetry;

public class Escalador extends SubsystemBase {

    HardwareMap hardwareMap;

    Telemetry telemetry;

    DcMotorEx escalador;

    public Escalador (HardwareMap hardwareMap, Telemetry telemetry){
        this.hardwareMap =  hardwareMap;
        this.telemetry = telemetry;

        escalador = hardwareMap.get(DcMotorEx.class, " escalador");
        escalador.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        escalador.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

    }

    public  void setPower1( int i){
        escalador.setVelocity(i);
    }

    public  void setPower( double power){

escalador.setPower(power);
    }

    public void setPoint(int position, double power) {

        escalador.setTargetPosition(position);
        escalador.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        escalador.setPower(power);

    }
    public boolean isAtSetPoint(){
        boolean isAtSetPoint = escalador.getCurrentPosition() - escalador.getTargetPosition() < escalador.getTargetPositionTolerance();
        return isAtSetPoint;
    }
public void setPosition(int pos ){
        escalador.setVelocity(5000);
        escalador.setTargetPosition(pos);
        escalador.setMode(DcMotor.RunMode.RUN_TO_POSITION);
}

    public void setPoint2(int position, double power) {
        escalador.setTargetPosition(position);
        escalador.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        escalador.setPower(power);


    }
    @Override
    public void periodic(){
        telemetry.addData("escalador", escalador.getCurrentPosition());

    }
}
