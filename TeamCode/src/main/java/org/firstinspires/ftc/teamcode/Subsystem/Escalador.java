package org.firstinspires.ftc.teamcode.Subsystem;

import com.arcrobotics.ftclib.command.SubsystemBase;
import com.arcrobotics.ftclib.hardware.ServoEx;
import com.arcrobotics.ftclib.hardware.SimpleServo;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;
import org.firstinspires.ftc.robotcore.external.navigation.CurrentUnit;

public class Escalador extends SubsystemBase {

    HardwareMap hardwareMap;

    Telemetry telemetry;

    DcMotorEx escalador;

    ServoEx servoescalador;

    public Escalador (HardwareMap hardwareMap, Telemetry telemetry){
        this.hardwareMap =  hardwareMap;
        this.telemetry = telemetry;

        escalador = hardwareMap.get(DcMotorEx.class, " escalador");
        escalador.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        escalador.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        escalador.setDirection(DcMotorSimple.Direction.FORWARD);


        servoescalador = new SimpleServo(hardwareMap, "servoescalador", 0, 180, AngleUnit.DEGREES);


        escalador.setCurrentAlert(4000, CurrentUnit.MILLIAMPS);


        //blockServo();
    }

    public  void setVelocity(int i){
        escalador.setVelocity(i);
    }

    public  void setPower( double power){

escalador.setPower(power);
    }

    public void blockServo(){
        servoescalador.turnToAngle(166);
    }


    public void releaseServo(){
        servoescalador.turnToAngle(50);
    }

    public int getPosition(){
        return escalador.getCurrentPosition();
    }



    public void moreTicks(int position, double escladorpower) {

        escalador.setTargetPosition(position);
        escalador.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        escalador.setPower(escladorpower);

    }


    public boolean isAtSetPoint(){
        boolean isAtSetPoint = escalador.getCurrentPosition() - escalador.getTargetPosition() < escalador.getTargetPositionTolerance();
        return isAtSetPoint;
    }


public void setPosition(int pos ){
        escalador.setPower(1);
        escalador.setTargetPosition(pos);
        escalador.setMode(DcMotor.RunMode.RUN_TO_POSITION);
}

    @Override
    public void periodic(){
        telemetry.addData("escalador", escalador.getCurrentPosition());
        telemetry.addData("Voltage escalador motor v ", escalador.getCurrent(CurrentUnit.MILLIAMPS));
        //telemetry.addData("Escalador voltage alert", escalador.isOverCurrent());


    }
}
