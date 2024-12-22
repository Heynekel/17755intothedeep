package org.firstinspires.ftc.teamcode.Commands;

import com.arcrobotics.ftclib.command.CommandBase;

import org.firstinspires.ftc.teamcode.Subsystem.IntakeSubsystem;

public class IntakearmGoToPosition extends CommandBase {

    IntakeSubsystem intake;
    int setPoint;

    public  IntakearmGoToPosition(IntakeSubsystem intake, int setPoint){
        this.intake = intake;
        this.setPoint = setPoint;

        addRequirements(intake);
    }

    @Override
    public void  execute(){
        intake.setPoint(setPoint, 1, 0.5);
    }

    @Override
    public  boolean isFinished(){
        return  intake.isAtSetPoint();
    }
}


