package org.firstinspires.ftc.teamcode.Commands;

import com.arcrobotics.ftclib.command.CommandBase;

import org.firstinspires.ftc.teamcode.Subsystem.ArmSubsystem;
import org.firstinspires.ftc.teamcode.Subsystem.IntakeSubsystem;

public class IntakearmGoToPosition extends CommandBase {

    IntakeSubsystem intake;
    ArmSubsystem m_arm;
    int setPoint;

    public  IntakearmGoToPosition(IntakeSubsystem intake, ArmSubsystem m_arm, int setPoint){
        this.intake = intake;
        this.setPoint = setPoint;
        this.m_arm = m_arm;

        addRequirements(intake, m_arm);
    }

    @Override
    public void  execute(){
        intake.setPower(1);
    }

    @Override
    public  boolean isFinished(){
        return  m_arm.isAtSetPoint();
    }
}


