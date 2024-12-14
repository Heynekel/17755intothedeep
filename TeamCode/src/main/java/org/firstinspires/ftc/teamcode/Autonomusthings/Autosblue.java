package org.firstinspires.ftc.teamcode.Autonomusthings;

import com.arcrobotics.ftclib.command.InstantCommand;
import com.arcrobotics.ftclib.command.SequentialCommandGroup;

import org.firstinspires.ftc.teamcode.Commands.TrajectoryFollowerCommand;
import org.firstinspires.ftc.teamcode.Subsystem.Canasta;
import org.firstinspires.ftc.teamcode.Subsystem.ElevatorSystem;
import org.firstinspires.ftc.teamcode.Subsystem.Intake;
import org.firstinspires.ftc.teamcode.Subsystem.MecanumDriveSubsystem;
import org.firstinspires.ftc.teamcode.Trejectories.BlueTrejectories;

public class Autosblue extends SequentialCommandGroup {
    BlueTrejectories blueTrejectories = new BlueTrejectories();

    public Autosblue(MecanumDriveSubsystem mecanumDriveSubsystem, Intake intake, ElevatorSystem elevatorSystem, Canasta canasta){
        addCommands(
                new TrajectoryFollowerCommand(mecanumDriveSubsystem, blueTrejectories.azulder1(mecanumDriveSubsystem.getDrive()))


















        );
    }
}
