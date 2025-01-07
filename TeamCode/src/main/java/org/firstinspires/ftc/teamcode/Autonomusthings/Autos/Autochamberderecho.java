package org.firstinspires.ftc.teamcode.Autonomusthings.Autos;

import com.arcrobotics.ftclib.command.ParallelCommandGroup;
import com.arcrobotics.ftclib.command.SequentialCommandGroup;
import com.arcrobotics.ftclib.command.WaitCommand;

import org.firstinspires.ftc.teamcode.Autonomusthings.Trejectories.ChambersRedTrajectories;
import org.firstinspires.ftc.teamcode.Commands.IntakeCommandforAutonomus;
import org.firstinspires.ftc.teamcode.Commands.TrajectoryFollowerCommand;
import org.firstinspires.ftc.teamcode.NewCommands.ElevatorCommand;
import org.firstinspires.ftc.teamcode.Subsystem.ArmSubsystem;
import org.firstinspires.ftc.teamcode.Subsystem.ElevatorSystem;
import org.firstinspires.ftc.teamcode.Subsystem.MecanumDriveSubsystem;

public class Autochamberderecho extends SequentialCommandGroup {

    ChambersRedTrajectories chambersRedTrajectories = new ChambersRedTrajectories();

    public Autochamberderecho(ArmSubsystem m_arm, MecanumDriveSubsystem m_drive, ElevatorSystem m_elevatorSystem){
        addCommands(new ParallelCommandGroup(
                new IntakeCommandforAutonomus( m_arm, -100),
                        new TrajectoryFollowerCommand(m_drive, chambersRedTrajectories.chamber1(m_drive.getDrive())),
                        new ElevatorCommand(m_elevatorSystem, 1575)
                ),
                new WaitCommand(600),
                new ParallelCommandGroup(
                        new ElevatorCommand(m_elevatorSystem, 750),
                        new IntakeCommandforAutonomus( m_arm, -100)
                ),
                new WaitCommand(600),
                new ParallelCommandGroup(
                        new ElevatorCommand(m_elevatorSystem, 0),
                        new TrajectoryFollowerCommand(m_drive, chambersRedTrajectories.chamber2(m_drive.getDrive()))
                ),
                new TrajectoryFollowerCommand(m_drive, chambersRedTrajectories.chamber3(m_drive.getDrive())),
                new WaitCommand(200),
                new TrajectoryFollowerCommand(m_drive, chambersRedTrajectories.chamber4(m_drive.getDrive())),
                new ElevatorCommand(m_elevatorSystem, 900),
        new WaitCommand(500),
        new TrajectoryFollowerCommand(m_drive, chambersRedTrajectories.chamber5(m_drive.getDrive())),
                new TrajectoryFollowerCommand(m_drive, chambersRedTrajectories.chamber6(m_drive.getDrive())),
                new ParallelCommandGroup(
                        new TrajectoryFollowerCommand(m_drive, chambersRedTrajectories.chamber7(m_drive.getDrive())),
                        new ElevatorCommand(m_elevatorSystem, 1575)
                ),
                new WaitCommand(850),

                        new ElevatorCommand(m_elevatorSystem, 750),

                new WaitCommand(350),
                new ParallelCommandGroup(
                        new ElevatorCommand(m_elevatorSystem, 0),
                        new TrajectoryFollowerCommand(m_drive, chambersRedTrajectories.chamber8(m_drive.getDrive())),
                             new IntakeCommandforAutonomus( m_arm, -80)
                ),
                new IntakeCommandforAutonomus( m_arm, 0)

                );



    }
}
