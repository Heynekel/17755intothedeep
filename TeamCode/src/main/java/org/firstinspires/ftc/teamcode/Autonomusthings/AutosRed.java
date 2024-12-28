package org.firstinspires.ftc.teamcode.Autonomusthings;

import static org.firstinspires.ftc.robotcore.external.BlocksOpModeCompanion.telemetry;

import com.arcrobotics.ftclib.command.InstantCommand;
import com.arcrobotics.ftclib.command.ParallelCommandGroup;
import com.arcrobotics.ftclib.command.RunCommand;
import com.arcrobotics.ftclib.command.SequentialCommandGroup;
import com.arcrobotics.ftclib.command.WaitCommand;

import org.firstinspires.ftc.teamcode.Commands.Commandforinitializem_intake;
import org.firstinspires.ftc.teamcode.Commands.IntakeCommand;
import org.firstinspires.ftc.teamcode.Commands.IntakeCommandforAutonomus;
import org.firstinspires.ftc.teamcode.Commands.TrajectoryFollowerCommand;
import org.firstinspires.ftc.teamcode.NewCommands.ElevatorCommand;
import org.firstinspires.ftc.teamcode.NewCommands.ServoLeaveCommand;
import org.firstinspires.ftc.teamcode.NewCommands.ServoReturnCommand;
import org.firstinspires.ftc.teamcode.NewCommands.TurnCommand;
import org.firstinspires.ftc.teamcode.Subsystem.ArmSubsystem;
import org.firstinspires.ftc.teamcode.Subsystem.Canasta;
import org.firstinspires.ftc.teamcode.Subsystem.ElevatorSystem;
import org.firstinspires.ftc.teamcode.Subsystem.IntakeSubsystem;
import org.firstinspires.ftc.teamcode.Subsystem.MecanumDriveSubsystem;
import org.firstinspires.ftc.teamcode.Autonomusthings.Trejectories.RedTrejectories;

public class AutosRed extends SequentialCommandGroup {

    RedTrejectories redTrejectories = new RedTrejectories();


    public AutosRed(MecanumDriveSubsystem m_drive, IntakeSubsystem m_intake, ArmSubsystem m_arm, ElevatorSystem m_elevatorSystem, Canasta m_canasta) {
        addCommands(
                        new ParallelCommandGroup(
                new TrajectoryFollowerCommand(m_drive, redTrejectories.reojoiz1(m_drive.getDrive())),
                new ElevatorCommand(m_elevatorSystem, 1320),
                 new Commandforinitializem_intake(m_intake, -1)
                        ),

new WaitCommand(500),
new ParallelCommandGroup(
        new ElevatorCommand(m_elevatorSystem, 1000),
        new IntakeCommandforAutonomus( m_arm, -180)
),
                new WaitCommand(500),
                new ParallelCommandGroup(
                        new ElevatorCommand(m_elevatorSystem, 0),
                        new TrajectoryFollowerCommand(m_drive, redTrejectories.rojoizq3(m_drive.getDrive())),
                        new InstantCommand(m_canasta::IvansFunction)
                ),
                new ParallelCommandGroup(
                        new TrajectoryFollowerCommand(m_drive, redTrejectories.girar(m_drive.getDrive())),
                        new IntakeCommandforAutonomus( m_arm, -670)
                ),

new ParallelCommandGroup(
        new IntakeCommand(m_intake, -1),
        new TrajectoryFollowerCommand(m_drive, redTrejectories.rojoizq4(m_drive.getDrive()))
),
                new IntakeCommandforAutonomus( m_arm,0),

                new WaitCommand(750),
                new ServoReturnCommand(m_canasta),

                new ParallelCommandGroup(
                        new IntakeCommand(m_intake, 1),
                        new IntakeCommandforAutonomus( m_arm, -180),
                        new ElevatorCommand(m_elevatorSystem, 2100),
                        new TrajectoryFollowerCommand(m_drive, redTrejectories.rojoizq5(m_drive.getDrive()))
                ),
                new WaitCommand(500),
               new ServoLeaveCommand(m_canasta, m_elevatorSystem, 1500, 2000),

        new WaitCommand(1000),
       new ParallelCommandGroup(
               new SequentialCommandGroup(
                       new TrajectoryFollowerCommand(m_drive, redTrejectories.rojoford(m_drive.getDrive())),
                       new ElevatorCommand(m_elevatorSystem, 0
               ),
                       new WaitCommand(750),
               new ServoReturnCommand(m_canasta)

       )

        ));

    }
    }



