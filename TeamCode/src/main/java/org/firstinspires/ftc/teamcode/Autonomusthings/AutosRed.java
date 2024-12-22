package org.firstinspires.ftc.teamcode.Autonomusthings;

import com.arcrobotics.ftclib.command.ParallelCommandGroup;
import com.arcrobotics.ftclib.command.SequentialCommandGroup;
import com.arcrobotics.ftclib.command.WaitCommand;

import org.firstinspires.ftc.teamcode.Commands.IntakeCommand;
import org.firstinspires.ftc.teamcode.Commands.IntakeCommandforAutonomus;
import org.firstinspires.ftc.teamcode.Commands.IntakearmGoToPosition;
import org.firstinspires.ftc.teamcode.Commands.TrajectoryFollowerCommand;
import org.firstinspires.ftc.teamcode.Subsystem.Canasta;
import org.firstinspires.ftc.teamcode.Subsystem.ElevatorSystem;
import org.firstinspires.ftc.teamcode.Subsystem.Intake;
import org.firstinspires.ftc.teamcode.Subsystem.MecanumDriveSubsystem;
import org.firstinspires.ftc.teamcode.Trejectories.RedTrejectories;

public class AutosRed extends SequentialCommandGroup {

    RedTrejectories redTrejectories = new RedTrejectories();


    public AutosRed(MecanumDriveSubsystem mecanumDriveSubsystem, Intake intake, ElevatorSystem elevatorSystem, Canasta canasta) {
        /*
    }
        addCommands(
new TrajectoryFollowerCommand(mecanumDriveSubsystem, redTrejectories.reojoiz1(mecanumDriveSubsystem.getDrive())),
          new IntakearmGoToPosition(intake, -300),
          new ArmGoToPosition(elevatorSystem, 2150),
                new WaitCommand(700),
               // new InstantCommand(canasta::dejar),
                new ArmGoToPosition(elevatorSystem, 0),
                new WaitCommand(1000),
                new TrajectoryFollowerCommand(mecanumDriveSubsystem, redTrejectories.rojoizq2(mecanumDriveSubsystem.getDrive())),
                new IntakeCommandforAutonomus(intake, -560),
                new ParallelCommandGroup(
                        new IntakeCommand(intake, -1),
                        new TrajectoryFollowerCommand(mecanumDriveSubsystem, redTrejectories.rojoizq3(mecanumDriveSubsystem.getDrive()))
                ),
                new TrajectoryFollowerCommand(mecanumDriveSubsystem, redTrejectories.rojoizq4(mecanumDriveSubsystem.getDrive()))
        );

     */
    }
}


