package org.firstinspires.ftc.teamcode.Autonomusthings;

import com.arcrobotics.ftclib.command.ParallelCommandGroup;
import com.arcrobotics.ftclib.command.SequentialCommandGroup;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.teamcode.Commands.IntakeCommand;
import org.firstinspires.ftc.teamcode.Commands.IntakeCommandforAutonomus;
import org.firstinspires.ftc.teamcode.Commands.TrajectoryFollowerCommand;
import org.firstinspires.ftc.teamcode.Subsystem.Canasta;
import org.firstinspires.ftc.teamcode.Subsystem.ElevatorSystem;
import org.firstinspires.ftc.teamcode.Subsystem.Intake;
import org.firstinspires.ftc.teamcode.Subsystem.MecanumDriveSubsystem;
import org.firstinspires.ftc.teamcode.Trejectories.RedTrejectories;

import java.util.function.BooleanSupplier;

public class AutosRed extends SequentialCommandGroup {

    RedTrejectories redTrejectories = new RedTrejectories();
    
    public AutosRed(MecanumDriveSubsystem mecanumDriveSubsystem, Intake intake){
        addCommands(
new TrajectoryFollowerCommand(mecanumDriveSubsystem, redTrejectories.reojoiz1(mecanumDriveSubsystem.getDrive())),
                new TrajectoryFollowerCommand(mecanumDriveSubsystem, redTrejectories.rojoizq2(mecanumDriveSubsystem.getDrive())),
                new IntakeCommandforAutonomus(intake, -580),
                new ParallelCommandGroup(
                        new IntakeCommand(intake, -1),
                        new TrajectoryFollowerCommand(mecanumDriveSubsystem, redTrejectories.rojoizq3(mecanumDriveSubsystem.getDrive()))
                )








        );
    }

}
