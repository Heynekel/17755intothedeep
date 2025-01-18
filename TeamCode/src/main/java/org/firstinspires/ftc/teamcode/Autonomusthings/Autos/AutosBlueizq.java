package org.firstinspires.ftc.teamcode.Autonomusthings.Autos;


import com.arcrobotics.ftclib.command.InstantCommand;
import com.arcrobotics.ftclib.command.ParallelCommandGroup;
import com.arcrobotics.ftclib.command.SequentialCommandGroup;
import com.arcrobotics.ftclib.command.WaitCommand;

import org.firstinspires.ftc.teamcode.Autonomusthings.Trejectories.BlueTrejectories;
import org.firstinspires.ftc.teamcode.Commands.Commandforinitializem_intake;
import org.firstinspires.ftc.teamcode.Commands.IntakeCommand;
import org.firstinspires.ftc.teamcode.Commands.IntakeCommandforAutonomus;
import org.firstinspires.ftc.teamcode.Commands.TrajectoryFollowerCommand;
import org.firstinspires.ftc.teamcode.Commands.ElevatorCommand;
import org.firstinspires.ftc.teamcode.Commands.ServoLeaveCommand;
import org.firstinspires.ftc.teamcode.Commands.ServoReturnCommand;
import org.firstinspires.ftc.teamcode.Subsystem.ArmSubsystem;
import org.firstinspires.ftc.teamcode.Subsystem.Canasta;
import org.firstinspires.ftc.teamcode.Subsystem.ElevatorSystem;
import org.firstinspires.ftc.teamcode.Subsystem.IntakeSubsystem;
import org.firstinspires.ftc.teamcode.Subsystem.MecanumDriveSubsystem;

public class AutosBlueizq extends SequentialCommandGroup {

 BlueTrejectories blueTrejectories = new BlueTrejectories();


    public AutosBlueizq(MecanumDriveSubsystem m_drive, IntakeSubsystem m_intake, ArmSubsystem m_arm, ElevatorSystem m_elevatorSystem, Canasta m_canasta) {
        addCommands(
                        new ParallelCommandGroup(
                                new IntakeCommandforAutonomus( m_arm, -150),
                new TrajectoryFollowerCommand(m_drive, blueTrejectories.reojoiz1(m_drive.getDrive())),
                new ElevatorCommand(m_elevatorSystem, 1550),
                 new Commandforinitializem_intake(m_intake, 1)
                        ),

new WaitCommand(300),
new ParallelCommandGroup(
        new ElevatorCommand(m_elevatorSystem, 850),
        new IntakeCommandforAutonomus( m_arm, -150)
),
                new WaitCommand(500),
                new ParallelCommandGroup(
                        new ElevatorCommand(m_elevatorSystem, 0),
                        new TrajectoryFollowerCommand(m_drive, blueTrejectories.rojoizq3(m_drive.getDrive()))
                ),
                new IntakeCommandforAutonomus( m_arm, 0),
                new ParallelCommandGroup(
                        new TrajectoryFollowerCommand(m_drive, blueTrejectories.girar(m_drive.getDrive())),
                        new IntakeCommandforAutonomus( m_arm, -1250)
                ),
                new TrajectoryFollowerCommand(m_drive, blueTrejectories.rojoizq4(m_drive.getDrive())),

new ParallelCommandGroup(
        new IntakeCommand(m_intake, -1),
        new TrajectoryFollowerCommand(m_drive, blueTrejectories.rojoizq5(m_drive.getDrive()))
),
                new IntakeCommandforAutonomus( m_arm,0),
                new WaitCommand(1000),
                new InstantCommand(m_canasta::IvansFunction),
                new WaitCommand(1220),
                new Commandforinitializem_intake(m_intake, 1),
                new WaitCommand(200),
                new ServoReturnCommand(m_canasta),
                new WaitCommand(100),
                new ParallelCommandGroup(
                        new IntakeCommandforAutonomus( m_arm, -120),
                        new ElevatorCommand(m_elevatorSystem, 2500),
                        new TrajectoryFollowerCommand(m_drive, blueTrejectories.rojoford(m_drive.getDrive()))
                ),
               new ServoLeaveCommand(m_canasta, m_elevatorSystem, 1500, 2400),
        new WaitCommand(800),
                new ServoReturnCommand(m_canasta),
                new WaitCommand(800),
                new ParallelCommandGroup(
                       new TrajectoryFollowerCommand(m_drive, blueTrejectories.rojoizq12(m_drive.getDrive())),
                        new ElevatorCommand(m_elevatorSystem, 0)
       ),
                new WaitCommand(800),
                new IntakeCommandforAutonomus(m_arm, 0)

               /* new WaitCommand(250),
              new ParallelCommandGroup(
                       new TrajectoryFollowerCommand(m_drive, redTrejectories.rojoizq12(m_drive.getDrive())),
                       new IntakeCommandforAutonomus(m_arm, 0)
                       ),
                new TrajectoryFollowerCommand(m_drive, redTrejectories.girar2(m_drive.getDrive())),
        new TrajectoryFollowerCommand(m_drive, redTrejectories.girarfinal(m_drive.getDrive()))*/

        );

    }
    }



