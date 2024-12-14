package org.firstinspires.ftc.teamcode.Subsystem;

import com.arcrobotics.ftclib.command.SubsystemBase;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.Telemetry;

public class ElevatorSystem extends SubsystemBase {

    HardwareMap hardwareMap;
    Telemetry telemetry;
    DcMotorEx brazoizq, brazoder;
    public static int pos = 750;


    public ElevatorSystem(HardwareMap hardwareMap, Telemetry telemetry) {

        this.telemetry = telemetry;
        this.hardwareMap = hardwareMap;

        brazoizq = hardwareMap.get(DcMotorEx.class, " brazoizq");
        brazoder = hardwareMap.get(DcMotorEx.class, " brazoder");
       //* brazoder.setDirection(DcMotorSimple.Direction.REVERSE);
        brazoizq.setDirection(DcMotorEx.Direction.REVERSE);
/*brazoizq.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        */
        brazoder.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        brazoizq.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

    }

    public void setPower(double power) {
        brazoizq.setPower(power);
        brazoder.setPower(power);
    }

    public void resetarmsystemticks() {
        brazoder.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        brazoizq.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
    }

    public void setPoint(int position, double power) {
        brazoizq.setTargetPosition(position);
        brazoizq.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        brazoizq.setPower(power);
        brazoder.setTargetPosition(position);
        brazoder.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        brazoder.setPower(power);
    }

    public boolean isAtSetPoint() {
        boolean isAtSetPoint = brazoizq.getCurrentPosition() - brazoizq.getTargetPosition() < brazoizq.getTargetPositionTolerance();
        return isAtSetPoint;
    }

    public int getArmsystemPosition() {
       return brazoder.getCurrentPosition();

    }

    public void setPosition(int pos){
        brazoizq.setVelocity(6000);
        brazoizq.setTargetPosition(pos);
        brazoizq.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        brazoder.setVelocity(6000);
        brazoder.setTargetPosition(pos);
        brazoder.setMode(DcMotor.RunMode.RUN_TO_POSITION);
    }


   /* public  void ArmUP(double power ){
        brazoizq.setTargetPosition(pos);
        brazoizq.setPower(power);
        brazoizq.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        brazoder.setTargetPosition(pos);
        brazoder.setPower(power);
        brazoder.setMode(DcMotor.RunMode.RUN_TO_POSITION);


    }*/


    @Override
    public  void periodic(){
        telemetry.addData("elevadorder", brazoder.getCurrentPosition());
        telemetry.addData("elevadorizq", brazoizq.getCurrentPosition());
    }

}
