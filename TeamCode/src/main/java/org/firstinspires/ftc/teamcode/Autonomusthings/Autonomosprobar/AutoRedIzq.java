package org.firstinspires.ftc.teamcode.Autonomusthings.Autonomosprobar;

import com.arcrobotics.ftclib.command.Command;
import com.arcrobotics.ftclib.command.CommandOpMode;
import com.arcrobotics.ftclib.command.RunCommand;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

import org.firstinspires.ftc.teamcode.Autonomusthings.AutosChambers;
import org.firstinspires.ftc.teamcode.Autonomusthings.AutosRed;
import org.firstinspires.ftc.teamcode.Autonomusthings.Trejectories.Chambers;
import org.firstinspires.ftc.teamcode.Subsystem.ArmSubsystem;
import org.firstinspires.ftc.teamcode.Subsystem.Canasta;
import org.firstinspires.ftc.teamcode.Subsystem.ElevatorSystem;
import org.firstinspires.ftc.teamcode.Subsystem.IntakeSubsystem;
import org.firstinspires.ftc.teamcode.Subsystem.MecanumDriveSubsystem;
import org.firstinspires.ftc.teamcode.drive.SampleMecanumDrive;

@Autonomous
public class AutoRedIzq extends CommandOpMode {
IntakeSubsystem intake;
MecanumDriveSubsystem mecanumDriveSubsystem;
AutosRed autosRed;
SampleMecanumDrive sampleMecanumDrive;
ElevatorSystem elevatorSystem;
Canasta canasta;
ArmSubsystem m_arm;
AutosChambers chambers;

    @Override
    public void initialize() {
        sampleMecanumDrive = new SampleMecanumDrive(hardwareMap);/*siempre van al incio*/
        mecanumDriveSubsystem = new MecanumDriveSubsystem(sampleMecanumDrive, false, false);
        intake = new IntakeSubsystem(hardwareMap, telemetry);
        canasta = new Canasta(hardwareMap, telemetry);
         m_arm = new ArmSubsystem(hardwareMap, telemetry);
        elevatorSystem = new ElevatorSystem(hardwareMap, telemetry);
        chambers = new AutosChambers(mecanumDriveSubsystem, elevatorSystem, m_arm);

        schedule(new RunCommand(() -> {
            mecanumDriveSubsystem.update();
            mecanumDriveSubsystem.updatePoseEstimate();
            telemetry.addData("Heading", mecanumDriveSubsystem.getPoseEstimate().getHeading());
            telemetry.addData("Position", mecanumDriveSubsystem.getPoseEstimate());
            telemetry.update();
        }));
        autosRed = new AutosRed(mecanumDriveSubsystem, intake, m_arm, elevatorSystem, canasta);/*Siempre al final*/
        schedule(chambers);






    }




}
