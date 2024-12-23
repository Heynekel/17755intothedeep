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
        sampleMecanumDrive = new SampleMecanumDrive(hardwareMap);/*siempre van al incio*/
        mecanumDriveSubsystem = new MecanumDriveSubsystem(sampleMecanumDrive, false);

        intake = new IntakeSubsystem(hardwareMap, telemetry);
        canasta = new Canasta(hardwareMap, telemetry);
        elevatorSystem = new ElevatorSystem(hardwareMap, telemetry);


        autosRed = new AutosRed(mecanumDriveSubsystem, intake, elevatorSystem, canasta);/*Siempre al final*/
        schedule(autosRed);


    }
}
