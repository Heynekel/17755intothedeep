package org.firstinspires.ftc.teamcode.Commands;

import com.arcrobotics.ftclib.command.CommandBase;

import org.firstinspires.ftc.teamcode.Subsystem.Intake;

public class IntakeCommandforAutonomus extends CommandBase {
    Intake intake;
    int setPoint;

    public  IntakeCommandforAutonomus(Intake intake, int setPoint){
        this.intake = intake;
        this.setPoint = setPoint;

        addRequirements(intake);
    }

    @Override
    public void  execute(){
        intake.AtSetpoint(setPoint,     0.5);
    }

    @Override
    public  boolean isFinished(){
        return  intake.isAtSetPoint();
    }
}
