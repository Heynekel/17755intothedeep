package org.firstinspires.ftc.teamcode.Commands;
import com.arcrobotics.ftclib.command.CommandBase;
import com.arcrobotics.ftclib.util.Timing;

import org.firstinspires.ftc.teamcode.Subsystem.Intake;


import java.util.concurrent.TimeUnit;


public class IntakeCommand extends CommandBase{
    Intake intake;
    double power;
    Timing.Timer timer = new Timing.Timer(2, TimeUnit.SECONDS);

    public IntakeCommand(Intake intake, double power) {
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
        intake.SetPower(power);
    }

    @Override
    public boolean isFinished(){
        return timer.done();
    }

    @Override
    public void end(boolean interrupted) {
        intake.SetPower(0);
        super.end(interrupted);
    }


}


