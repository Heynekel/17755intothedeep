package org.firstinspires.ftc.teamcode.Subsystem;

import com.arcrobotics.ftclib.command.SubsystemBase;
import com.arcrobotics.ftclib.hardware.ServoEx;
import com.arcrobotics.ftclib.hardware.SimpleServo;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;

public class Canasta extends SubsystemBase {
    HardwareMap hardwareMap;
    Telemetry telemetry;

    ServoEx c1, c2;

    public  Canasta(HardwareMap hardwareMap, Telemetry telemetry){
        this.hardwareMap = hardwareMap;
        this.telemetry = telemetry;
        c1 = new SimpleServo(hardwareMap, "c1", 0, 180, AngleUnit.DEGREES);
        c2 = new SimpleServo(hardwareMap, "c2", 0, 180, AngleUnit.DEGREES);
    }
}