package org.firstinspires.ftc.teamcode.Commands;

import com.arcrobotics.ftclib.command.CommandBase;

import org.firstinspires.ftc.teamcode.Subsystem.Intake;

public class IntakearmGoToPosition extends CommandBase {

    Intake intake;
    int setPoint;

    public  IntakearmGoToPosition(Intake intake, int setPoint){
        this.intake = intake;
        this.setPoint = setPoint;

        addRequirements(intake);
    }

    @Override
    public void  execute(){
        intake.setPoint(setPoint, 1, 0.05);
    }

    @Override
    public  boolean isFinished(){
        return  intake.isAtSetPoint();
    }
}


