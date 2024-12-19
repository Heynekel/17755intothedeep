package org.firstinspires.ftc.teamcode.Subsystem;

import com.arcrobotics.ftclib.command.Command;
import com.arcrobotics.ftclib.command.SubsystemBase;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.Telemetry;

public class Intake extends SubsystemBase {

        HardwareMap hardwareMap;
        Telemetry telemetry;
        CRServo ser1;
        DcMotorEx intakearm;

        public  Intake(HardwareMap hardwareMap, Telemetry telemetry){
            this.hardwareMap = hardwareMap;
            this.telemetry = telemetry;

            ser1 = hardwareMap.get(CRServo.class, "ser1");
            intakearm =  hardwareMap.get(DcMotorEx.class, "intakearm");
            intakearm.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
            intakearm.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        }
        public  void agarrar (double power){
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
        public void setPoint(int position, double power, double armPower) {
            intakearm.setTargetPosition(position);
            intakearm.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            intakearm.setPower(armPower);

            ser1.setPower(power);

        }

        public int getPosition(){
            return intakearm.getCurrentPosition();
        }

        public  void setPower(double power){
            ser1.setPower(power);
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
            telemetry.addData("ser1", ser1.getPower());
            telemetry.addData("armintake", intakearm.getCurrentPosition());
        }

}
