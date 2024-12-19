package org.firstinspires.ftc.teamcode.Autonomusthings.Autonomosprobar;

import com.arcrobotics.ftclib.command.CommandOpMode;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.teamcode.Autonomusthings.AutosRed;
import org.firstinspires.ftc.teamcode.Subsystem.Canasta;
import org.firstinspires.ftc.teamcode.Subsystem.ElevatorSystem;
import org.firstinspires.ftc.teamcode.Subsystem.Intake;
import org.firstinspires.ftc.teamcode.Subsystem.MecanumDriveSubsystem;
import org.firstinspires.ftc.teamcode.drive.SampleMecanumDrive;

@Autonomous
public class RedPruebas extends CommandOpMode {
Intake intake;
MecanumDriveSubsystem mecanumDriveSubsystem;
AutosRed autosRed;
SampleMecanumDrive sampleMecanumDrive;
ElevatorSystem elevatorSystem;
Canasta canasta;

    @Override
    public void initialize() {
        intake = new Intake(hardwareMap, telemetry);
        sampleMecanumDrive = new SampleMecanumDrive(hardwareMap);
        mecanumDriveSubsystem = new MecanumDriveSubsystem(sampleMecanumDrive, false, false);
        autosRed = new AutosRed(mecanumDriveSubsystem, intake, elevatorSystem, canasta);
        elevatorSystem = new ElevatorSystem(hardwareMap, telemetry);
        schedule(autosRed);
        canasta = new Canasta(hardwareMap, telemetry);

    }
}
