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

    public ElevatorSystem(HardwareMap hardwareMap, Telemetry telemetry) {
        this.telemetry = telemetry;
        this.hardwareMap = hardwareMap;
        brazoizq = hardwareMap.get(DcMotorEx.class, " brazoizq");
        brazoder = hardwareMap.get(DcMotorEx.class, " brazoder");

        brazoizq.setDirection(DcMotorEx.Direction.REVERSE);

        brazoizq.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        brazoder.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

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
        brazoizq.setVelocity(6000);
        brazoizq.setTargetPosition(pos);
        brazoizq.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        brazoder.setVelocity(6000);
        brazoder.setTargetPosition(pos);
        brazoder.setMode(DcMotor.RunMode.RUN_TO_POSITION);
    }

    @Override
    public  void periodic(){
        telemetry.addData("Elevator right position", brazoder.getCurrentPosition());
        telemetry.addData("Elevator left position", brazoizq.getCurrentPosition());
    }
}