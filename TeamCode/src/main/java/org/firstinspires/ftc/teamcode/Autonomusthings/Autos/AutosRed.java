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
                                new IntakeCommandforAutonomus( m_arm, -120),
                new TrajectoryFollowerCommand(m_drive, redTrejectories.reojoiz1(m_drive.getDrive())),
                new ElevatorCommand(m_elevatorSystem, 1575),
                 new Commandforinitializem_intake(m_intake, 1)
                        ),

new WaitCommand(300),
new ParallelCommandGroup(
        new ElevatorCommand(m_elevatorSystem, 850),
        new IntakeCommandforAutonomus( m_arm, -140)
),
                new WaitCommand(500),
                new ParallelCommandGroup(
                        new ElevatorCommand(m_elevatorSystem, 0),
                        new TrajectoryFollowerCommand(m_drive, redTrejectories.rojoizq3(m_drive.getDrive()))
                ),
                new IntakeCommandforAutonomus( m_arm, 0),
                new ParallelCommandGroup(
                        new TrajectoryFollowerCommand(m_drive, redTrejectories.girar(m_drive.getDrive())),
                        new IntakeCommandforAutonomus( m_arm, -685)
                ),

new ParallelCommandGroup(
        new IntakeCommand(m_intake, -1),
        new TrajectoryFollowerCommand(m_drive, redTrejectories.rojoizq4(m_drive.getDrive()))
),
                new IntakeCommandforAutonomus( m_arm,0),
                new WaitCommand(1000),
                new InstantCommand(m_canasta::IvansFunction),
                new WaitCommand(500),
                new Commandforinitializem_intake(m_intake, 1),
                new WaitCommand(200),
                new ServoReturnCommand(m_canasta),
                new WaitCommand(100),
                new ParallelCommandGroup(
                        new IntakeCommandforAutonomus( m_arm, -120),
                        new ElevatorCommand(m_elevatorSystem, 2500),
                        new TrajectoryFollowerCommand(m_drive, redTrejectories.rojoizq5(m_drive.getDrive()))
                ),
               new ServoLeaveCommand(m_canasta, m_elevatorSystem, 1500, 2400),
        new WaitCommand(800),
                new ServoReturnCommand(m_canasta),

                new ParallelCommandGroup(
                       new TrajectoryFollowerCommand(m_drive, redTrejectories.rojoford(m_drive.getDrive())),
                        new ElevatorCommand(m_elevatorSystem, 0)
       )
                /*new WaitCommand(250),
              new ParallelCommandGroup(
                       new TrajectoryFollowerCommand(m_drive, redTrejectories.rojoizq12(m_drive.getDrive())),
                       new IntakeCommandforAutonomus(m_arm, 0)
                       ),
                new TrajectoryFollowerCommand(m_drive, redTrejectories.girar2(m_drive.getDrive())),
        new TrajectoryFollowerCommand(m_drive, redTrejectories.girarfinal(m_drive.getDrive()))*/

        );

    }
    }



