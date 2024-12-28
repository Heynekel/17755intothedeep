package org.firstinspires.ftc.teamcode.Subsystem;

import com.arcrobotics.ftclib.command.SubsystemBase;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.Telemetry;

public class IntakeSubsystem extends SubsystemBase {

        HardwareMap hardwareMap;
        Telemetry telemetry;
        CRServo ser1;

        public IntakeSubsystem(HardwareMap hardwareMap, Telemetry telemetry){
            this.hardwareMap = hardwareMap;
            this.telemetry = telemetry;

            ser1 = hardwareMap.get(CRServo.class, "ser1");
        }
        public  void agarrar (double power){
            ser1.setPower(power);
        }



        public void setPower(double power) {
            ser1.setPower(power);
        }


        @Override
        public  void periodic() {
            telemetry.addData("ser1", ser1.getPower());
        }

}
