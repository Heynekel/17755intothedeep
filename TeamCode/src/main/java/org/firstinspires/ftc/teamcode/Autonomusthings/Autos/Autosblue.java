package org.firstinspires.ftc.teamcode.Autonomusthings.Autos;

import com.arcrobotics.ftclib.command.SequentialCommandGroup;

import org.firstinspires.ftc.teamcode.Commands.TrajectoryFollowerCommand;
import org.firstinspires.ftc.teamcode.Subsystem.MecanumDriveSubsystem;
import org.firstinspires.ftc.teamcode.Autonomusthings.Trejectories.BlueTrejectories;

public class Autosblue extends SequentialCommandGroup {
    BlueTrejectories blueTrejectories = new BlueTrejectories();

    public Autosblue(MecanumDriveSubsystem mecanumDriveSubsystem){
        addCommands(
                new TrajectoryFollowerCommand(mecanumDriveSubsystem, blueTrejectories.azulizq1(mecanumDriveSubsystem.getDrive()))



















        );
    }
}
