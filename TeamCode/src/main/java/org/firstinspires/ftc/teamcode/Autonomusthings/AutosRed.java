package org.firstinspires.ftc.teamcode.Autonomusthings;

import com.arcrobotics.ftclib.command.InstantCommand;
import com.arcrobotics.ftclib.command.ParallelCommandGroup;
import com.arcrobotics.ftclib.command.SequentialCommandGroup;
import com.arcrobotics.ftclib.command.WaitCommand;

import org.firstinspires.ftc.teamcode.Commands.EscaladorDefault;
import org.firstinspires.ftc.teamcode.Commands.IntakeCommand;
import org.firstinspires.ftc.teamcode.Commands.IntakeCommandforAutonomus;
import org.firstinspires.ftc.teamcode.Commands.IntakearmGoToPosition;
import org.firstinspires.ftc.teamcode.Commands.TrajectoryFollowerCommand;
import org.firstinspires.ftc.teamcode.NewCommands.ElevatorCommand;
import org.firstinspires.ftc.teamcode.Subsystem.Canasta;
import org.firstinspires.ftc.teamcode.Subsystem.ElevatorSystem;
import org.firstinspires.ftc.teamcode.Subsystem.IntakeSubsystem;
import org.firstinspires.ftc.teamcode.Subsystem.MecanumDriveSubsystem;
import org.firstinspires.ftc.teamcode.Trejectories.RedTrejectories;

public class AutosRed extends SequentialCommandGroup {

    RedTrejectories redTrejectories = new RedTrejectories();


    public AutosRed(MecanumDriveSubsystem m_drive,  IntakeSubsystem m_intake, ElevatorSystem m_elevatorSystem, Canasta m_canasta) {
        addCommands(

                        new TrajectoryFollowerCommand(m_drive, redTrejectories.reojoiz1(m_drive.getDrive())),
                        new ElevatorCommand(m_elevatorSystem, 1310),
                        new TrajectoryFollowerCommand(m_drive, redTrejectories.rojoizq3(m_drive.getDrive())),
                new IntakeCommandforAutonomus(m_intake, -720),
                new ParallelCommandGroup(
                        new IntakeCommand(m_intake, -1),
                        new TrajectoryFollowerCommand(m_drive, redTrejectories.rojoizq4(m_drive.getDrive()))
                ),
                new IntakeCommandforAutonomus(m_intake, 0),
                new ParallelCommandGroup(
                        new IntakeCommand(m_intake, 1),
                        new TrajectoryFollowerCommand(m_drive, redTrejectories.rojoizq5(m_drive.getDrive()))
                )

        );


    }



    }



