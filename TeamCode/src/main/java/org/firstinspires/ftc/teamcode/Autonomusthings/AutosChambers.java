package org.firstinspires.ftc.teamcode.Autonomusthings;

import com.arcrobotics.ftclib.command.InstantCommand;
import com.arcrobotics.ftclib.command.ParallelCommandGroup;
import com.arcrobotics.ftclib.command.SequentialCommandGroup;
import com.arcrobotics.ftclib.command.WaitCommand;

import org.firstinspires.ftc.teamcode.Autonomusthings.Trejectories.Chambers;
import org.firstinspires.ftc.teamcode.Commands.Commandforinitializem_intake;
import org.firstinspires.ftc.teamcode.Commands.IntakeCommandforAutonomus;
import org.firstinspires.ftc.teamcode.Commands.TrajectoryFollowerCommand;
import org.firstinspires.ftc.teamcode.NewCommands.ElevatorCommand;
import org.firstinspires.ftc.teamcode.Subsystem.ArmSubsystem;
import org.firstinspires.ftc.teamcode.Subsystem.ElevatorSystem;
import org.firstinspires.ftc.teamcode.Subsystem.IntakeSubsystem;
import org.firstinspires.ftc.teamcode.Subsystem.MecanumDriveSubsystem;

public class AutosChambers extends SequentialCommandGroup {

    Chambers chambers = new Chambers();

    public AutosChambers(MecanumDriveSubsystem m_drive, ElevatorSystem m_elevatorSystem, ArmSubsystem m_arm){
        addCommands(new ParallelCommandGroup(
                        new TrajectoryFollowerCommand(m_drive, chambers.chamber1(m_drive.getDrive())),
                        new ElevatorCommand(m_elevatorSystem, 1320)
                ),
                new WaitCommand(500),
                new ParallelCommandGroup(
                        new ElevatorCommand(m_elevatorSystem, 1000),
                        new IntakeCommandforAutonomus( m_arm, -180)
                ),
                new WaitCommand(500),
                new ParallelCommandGroup(
                        new ElevatorCommand(m_elevatorSystem, 0),
                        new TrajectoryFollowerCommand(m_drive, chambers.chamber2(m_drive.getDrive()))
                ),
                new TrajectoryFollowerCommand(m_drive, chambers.chamber3(m_drive.getDrive())),
                new WaitCommand(100),
                new TrajectoryFollowerCommand(m_drive, chambers.chamber4(m_drive.getDrive())),
                new ParallelCommandGroup(
                        new TrajectoryFollowerCommand(m_drive, chambers.chamber5(m_drive.getDrive())),
                        new ElevatorCommand(m_elevatorSystem, 900)
                ),
                new TrajectoryFollowerCommand(m_drive, chambers.chamber6(m_drive.getDrive())),
                new ParallelCommandGroup(
                        new TrajectoryFollowerCommand(m_drive, chambers.chamber7(m_drive.getDrive())),
                        new ElevatorCommand(m_elevatorSystem, 1320)
                ),
                new WaitCommand(500),
                new ParallelCommandGroup(
                        new ElevatorCommand(m_elevatorSystem, 1000)
                ),
                new WaitCommand(500),
                new ParallelCommandGroup(
                        new ElevatorCommand(m_elevatorSystem, 0),
                        new TrajectoryFollowerCommand(m_drive, chambers.chamber2(m_drive.getDrive()))
                )

        );
    }
}
