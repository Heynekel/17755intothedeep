package org.firstinspires.ftc.teamcode.Autonomusthings.Autos;

import com.arcrobotics.ftclib.command.ParallelCommandGroup;
import com.arcrobotics.ftclib.command.SequentialCommandGroup;
import com.arcrobotics.ftclib.command.WaitCommand;

import org.firstinspires.ftc.teamcode.Autonomusthings.Trejectories.ChambersBlueTrajectories;

import org.firstinspires.ftc.teamcode.Commands.IntakeCommandforAutonomus;
import org.firstinspires.ftc.teamcode.Commands.TrajectoryFollowerCommand;
import org.firstinspires.ftc.teamcode.Commands.ElevatorCommand;
import org.firstinspires.ftc.teamcode.Subsystem.ArmSubsystem;
import org.firstinspires.ftc.teamcode.Subsystem.ElevatorSystem;
import org.firstinspires.ftc.teamcode.Subsystem.MecanumDriveSubsystem;

public class AutochamberderechoBlue extends SequentialCommandGroup {

   ChambersBlueTrajectories chambersRedTrajectories = new ChambersBlueTrajectories();

    public AutochamberderechoBlue(ArmSubsystem m_arm, MecanumDriveSubsystem m_drive, ElevatorSystem m_elevatorSystem){
        addCommands(new ParallelCommandGroup(
                new IntakeCommandforAutonomus( m_arm, -150),
                        new TrajectoryFollowerCommand(m_drive, chambersRedTrajectories.chamber1(m_drive.getDrive())),
                        new ElevatorCommand(m_elevatorSystem, 1550)
                ),
                new WaitCommand(350),
                new ParallelCommandGroup(
                        new ElevatorCommand(m_elevatorSystem, 750),
                        new IntakeCommandforAutonomus( m_arm, -150)
                ),
                new WaitCommand(150),
                new ParallelCommandGroup(
                        new ElevatorCommand(m_elevatorSystem, 0),
                        new TrajectoryFollowerCommand(m_drive, chambersRedTrajectories.chamber2(m_drive.getDrive()))
                ),
                new TrajectoryFollowerCommand(m_drive, chambersRedTrajectories.chamber3(m_drive.getDrive())),
                new WaitCommand(100),
                new TrajectoryFollowerCommand(m_drive, chambersRedTrajectories.chamber4(m_drive.getDrive())),
                new ElevatorCommand(m_elevatorSystem, 900),
        new WaitCommand(400),
        new TrajectoryFollowerCommand(m_drive, chambersRedTrajectories.chamber5(m_drive.getDrive())),
                new TrajectoryFollowerCommand(m_drive, chambersRedTrajectories.chamber6(m_drive.getDrive())),
                new ParallelCommandGroup(
                        new TrajectoryFollowerCommand(m_drive, chambersRedTrajectories.chamber7(m_drive.getDrive())),
                        new ElevatorCommand(m_elevatorSystem, 1550)
                ),
                new WaitCommand(400),

                        new ElevatorCommand(m_elevatorSystem, 750),

                new WaitCommand(200),
                new ParallelCommandGroup(
                        new ElevatorCommand(m_elevatorSystem, 0),
                        new TrajectoryFollowerCommand(m_drive, chambersRedTrajectories.gotosample(m_drive.getDrive())),
                             new IntakeCommandforAutonomus( m_arm, -150)
                ),
                new ParallelCommandGroup(
                        new IntakeCommandforAutonomus( m_arm, 0),
                        new TrajectoryFollowerCommand(m_drive, chambersRedTrajectories.gotosample2(m_drive.getDrive()))
                ),
                new TrajectoryFollowerCommand(m_drive, chambersRedTrajectories.gotosample3(m_drive.getDrive())),
                new TrajectoryFollowerCommand(m_drive, chambersRedTrajectories.chamber8(m_drive.getDrive())),
                new TrajectoryFollowerCommand(m_drive, chambersRedTrajectories.gotosample4(m_drive.getDrive())),
                new TrajectoryFollowerCommand(m_drive, chambersRedTrajectories.gotosample5(m_drive.getDrive())),
        new TrajectoryFollowerCommand(m_drive, chambersRedTrajectories.gotosample6(m_drive.getDrive()))





        );



    }
}
