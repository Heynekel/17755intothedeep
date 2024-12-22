package org.firstinspires.ftc.teamcode.Autonomusthings.Autonomosprobar;

import com.arcrobotics.ftclib.command.CommandOpMode;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

import org.firstinspires.ftc.teamcode.Autonomusthings.AutosRed;
import org.firstinspires.ftc.teamcode.Subsystem.Canasta;
import org.firstinspires.ftc.teamcode.Subsystem.ElevatorSystem;
import org.firstinspires.ftc.teamcode.Subsystem.IntakeSubsystem;
import org.firstinspires.ftc.teamcode.Subsystem.MecanumDriveSubsystem;
import org.firstinspires.ftc.teamcode.drive.SampleMecanumDrive;

@Autonomous
public class RedPruebas extends CommandOpMode {
IntakeSubsystem intake;
MecanumDriveSubsystem mecanumDriveSubsystem;
AutosRed autosRed;
SampleMecanumDrive sampleMecanumDrive;
ElevatorSystem elevatorSystem;
Canasta canasta;

    @Override
    public void initialize() {
        intake = new IntakeSubsystem(hardwareMap, telemetry);
        sampleMecanumDrive = new SampleMecanumDrive(hardwareMap);
        mecanumDriveSubsystem = new MecanumDriveSubsystem(sampleMecanumDrive, true);
        autosRed = new AutosRed(mecanumDriveSubsystem, intake, elevatorSystem, canasta);
        elevatorSystem = new ElevatorSystem(hardwareMap, telemetry);
        schedule(autosRed);
        canasta = new Canasta(hardwareMap, telemetry);

    }
}
