package org.firstinspires.ftc.teamcode.Autonomusthings.Autonomosprobar;

import com.arcrobotics.ftclib.command.CommandOpMode;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.teamcode.Autonomusthings.AutosRed;
import org.firstinspires.ftc.teamcode.Subsystem.Intake;
import org.firstinspires.ftc.teamcode.Subsystem.MecanumDriveSubsystem;
import org.firstinspires.ftc.teamcode.drive.SampleMecanumDrive;

@Autonomous
public class RedPruebas extends CommandOpMode {
Intake intake;
MecanumDriveSubsystem mecanumDriveSubsystem;
AutosRed autosRed;
SampleMecanumDrive sampleMecanumDrive;

    @Override
    public void initialize() {
        intake = new Intake(hardwareMap, telemetry);
        sampleMecanumDrive = new SampleMecanumDrive(hardwareMap);
        mecanumDriveSubsystem = new MecanumDriveSubsystem(sampleMecanumDrive, false, false);
        autosRed = new AutosRed(mecanumDriveSubsystem, intake);
        schedule(autosRed);

    }
}
