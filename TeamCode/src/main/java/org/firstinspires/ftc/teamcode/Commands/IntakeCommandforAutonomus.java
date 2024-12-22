package org.firstinspires.ftc.teamcode.Commands;

import com.arcrobotics.ftclib.command.CommandBase;

import org.firstinspires.ftc.teamcode.Subsystem.IntakeSubsystem;

public class IntakeCommandforAutonomus extends CommandBase {
    IntakeSubsystem intake;
    int setPoint;

    public  IntakeCommandforAutonomus(IntakeSubsystem intake, int setPoint){
        this.intake = intake;
        this.setPoint = setPoint;

        addRequirements(intake);
    }

    @Override
    public void  execute(){
        intake.AtSetpoint(setPoint,  1);
    }

    @Override
    public  boolean isFinished(){
        return  intake.isAtSetPoint();
    }
}
