package org.firstinspires.ftc.teamcode.Commands;

import com.arcrobotics.ftclib.command.CommandBase;
import com.arcrobotics.ftclib.util.Timing;

import org.firstinspires.ftc.teamcode.Subsystem.IntakeSubsystem;

import java.util.concurrent.TimeUnit;

public class Commandforinitializem_intake extends CommandBase {
    IntakeSubsystem intake;
    double power;
    Timing.Timer timer = new Timing.Timer(700, TimeUnit.MILLISECONDS);

    public Commandforinitializem_intake(IntakeSubsystem intake, double power) {
        this.power = power;
        this.intake = intake;
        addRequirements(intake);
    }

    @Override
    public void initialize() {
        timer.start();
    }
    @Override
    public void execute() {
        intake.setPower(power);
    }

    @Override
    public boolean isFinished(){
        return timer.done();
    }

    @Override
    public void end(boolean interrupted) {
        intake.setPower(0);
        super.end(interrupted);
    }
}
