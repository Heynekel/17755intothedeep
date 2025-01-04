package org.firstinspires.ftc.teamcode.Autonomusthings.Autos;


import com.arcrobotics.ftclib.command.InstantCommand;
import com.arcrobotics.ftclib.command.ParallelCommandGroup;
import com.arcrobotics.ftclib.command.SequentialCommandGroup;
import com.arcrobotics.ftclib.command.WaitCommand;

import org.firstinspires.ftc.teamcode.Commands.Commandforinitializem_intake;
import org.firstinspires.ftc.teamcode.Commands.IntakeCommand;
import org.firstinspires.ftc.teamcode.Commands.IntakeCommandforAutonomus;
import org.firstinspires.ftc.teamcode.Commands.TrajectoryFollowerCommand;
import org.firstinspires.ftc.teamcode.NewCommands.ElevatorCommand;
import org.firstinspires.ftc.teamcode.NewCommands.ServoLeaveCommand;
import org.firstinspires.ftc.teamcode.NewCommands.ServoReturnCommand;
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
                                new IntakeCommandforAutonomus( m_arm, -100),
                new TrajectoryFollowerCommand(m_drive, redTrejectories.reojoiz1(m_drive.getDrive())),
                new ElevatorCommand(m_elevatorSystem, 1320),
                 new Commandforinitializem_intake(m_intake, 1)
                        ),

new WaitCommand(600),
new ParallelCommandGroup(
        new ElevatorCommand(m_elevatorSystem, 950),
        new IntakeCommandforAutonomus( m_arm, -180)
),
                new WaitCommand(1000),
                new ParallelCommandGroup(
                        new ElevatorCommand(m_elevatorSystem, 0),
                        new TrajectoryFollowerCommand(m_drive, redTrejectories.rojoizq3(m_drive.getDrive()))
                ),
                new ParallelCommandGroup(
                        new TrajectoryFollowerCommand(m_drive, redTrejectories.girar(m_drive.getDrive())),
                        new IntakeCommandforAutonomus( m_arm, -680)
                ),

new ParallelCommandGroup(
        new IntakeCommand(m_intake, -1),
        new TrajectoryFollowerCommand(m_drive, redTrejectories.rojoizq4(m_drive.getDrive()))
),
                new IntakeCommandforAutonomus( m_arm,0),
                new WaitCommand(1000),
                new InstantCommand(m_canasta::IvansFunction),
        new Commandforinitializem_intake(m_intake, 1),
                new WaitCommand(500),
                new ServoReturnCommand(m_canasta),
                new WaitCommand(500),
                new ParallelCommandGroup(
                        new IntakeCommandforAutonomus( m_arm, -180),
                        new ElevatorCommand(m_elevatorSystem, 2000),
                        new TrajectoryFollowerCommand(m_drive, redTrejectories.rojoizq5(m_drive.getDrive()))
                ),
                new WaitCommand(500),
               new ServoLeaveCommand(m_canasta, m_elevatorSystem, 1500, 1900),

        new WaitCommand(1000),
       new ParallelCommandGroup(
                       new TrajectoryFollowerCommand(m_drive, redTrejectories.rojoford(m_drive.getDrive())),
               new ServoReturnCommand(m_canasta),
        new ElevatorCommand(m_elevatorSystem, 1700)
       ),
                new ElevatorCommand(m_elevatorSystem, 0),
              new ParallelCommandGroup(
                      // new TrajectoryFollowerCommand(m_drive, redTrejectories.rojoizq12(m_drive.getDrive())),
                       new IntakeCommandforAutonomus(m_arm, 0)
                       )
        );

    }
    }



