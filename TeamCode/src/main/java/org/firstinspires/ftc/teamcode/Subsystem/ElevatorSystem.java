package org.firstinspires.ftc.teamcode.Subsystem;
import static java.time.temporal.TemporalAdjusters.next;

import com.arcrobotics.ftclib.command.SubsystemBase;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.VoltageSensor;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.robotcore.external.navigation.CurrentUnit;

public class ElevatorSystem extends SubsystemBase {

    HardwareMap hardwareMap;
    Telemetry telemetry;
    DcMotorEx brazoizq, brazoder;

    public ElevatorSystem(HardwareMap hardwareMap, Telemetry telemetry) {
        this.telemetry = telemetry;
        this.hardwareMap = hardwareMap;
        brazoizq = hardwareMap.get(DcMotorEx.class, " brazoizq");
        brazoder = hardwareMap.get(DcMotorEx.class, " brazoder");

        brazoizq.setCurrentAlert(4000, CurrentUnit.MILLIAMPS);
        brazoder.setCurrentAlert(4000, CurrentUnit.MILLIAMPS);


/*Direccion del motor*/
        brazoizq.setDirection(DcMotorEx.Direction.REVERSE);//FORDWARD
        brazoder.setDirection(DcMotorSimple.Direction.FORWARD);//REVERSE


        /*Los tiks sean 0*/
        brazoizq.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        brazoder.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);


        /*Para mantener los motores fijos*/

        brazoder.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        brazoizq.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
    }



    public void resetTicks() {
        brazoder.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        brazoizq.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
    }



    public boolean isAtSetPoint() {
        boolean isAtSetPoint = brazoizq.getCurrentPosition() - brazoizq.getTargetPosition() < brazoizq.getTargetPositionTolerance();
        return isAtSetPoint;
    }

    public int getElevatorPosition() {
        return brazoder.getCurrentPosition();
    }

    public void setPosition(int pos){
        brazoizq.setPower(1);
        brazoizq.setTargetPosition(pos);
        brazoizq.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        brazoder.setPower(1);
        brazoder.setTargetPosition(pos);
        brazoder.setMode(DcMotor.RunMode.RUN_TO_POSITION);
    }

    public  void velocidad(int vel){
        brazoder.setVelocity(vel);
        brazoizq.setVelocity(vel);
    }

    public void setPower(double power){
        brazoder.setPower(power);
        brazoizq.setPower(power);
    }

    @Override
    public  void periodic(){
        telemetry.addData("Elevator right position", brazoder.getCurrentPosition());
        telemetry.addData("Elevator left position", brazoizq.getCurrentPosition());
        telemetry.addData("Voltage left elevator motor", brazoizq.getCurrent(CurrentUnit.MILLIAMPS));
        telemetry.addData("Voltage right elevator motor", brazoder.getCurrent(CurrentUnit.MILLIAMPS));

        //telemetry.addData("Elevator left v", brazoizq.isOverCurrent());
        //telemetry.addData("Elevator right v", brazoder.isOverCurrent());
    }
}