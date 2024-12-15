package org.firstinspires.ftc.teamcode.Autonomusthings;

import com.arcrobotics.ftclib.command.InstantCommand;
import com.arcrobotics.ftclib.command.SequentialCommandGroup;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

import org.firstinspires.ftc.teamcode.Commands.TrajectoryFollowerCommand;
import org.firstinspires.ftc.teamcode.Subsystem.Canasta;
import org.firstinspires.ftc.teamcode.Subsystem.ElevatorSystem;
import org.firstinspires.ftc.teamcode.Subsystem.Intake;
import org.firstinspires.ftc.teamcode.Subsystem.MecanumDriveSubsystem;
import org.firstinspires.ftc.teamcode.Trejectories.BlueTrejectories;
@Autonomous
public class Autosblue extends SequentialCommandGroup {
    BlueTrejectories blueTrejectories = new BlueTrejectories();

    public Autosblue(MecanumDriveSubsystem mecanumDriveSubsystem){
        addCommands(
                new TrajectoryFollowerCommand(mecanumDriveSubsystem, blueTrejectories.azulizq1(mecanumDriveSubsystem.getDrive()))



















        );
    }
}
