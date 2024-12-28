package org.firstinspires.ftc.teamcode.Commands;

import com.arcrobotics.ftclib.command.CommandBase;

import org.apache.commons.math3.analysis.function.Abs;
import org.firstinspires.ftc.teamcode.Subsystem.ArmSubsystem;
import org.firstinspires.ftc.teamcode.Subsystem.IntakeSubsystem;

public class IntakeCommandforAutonomus extends CommandBase {

    ArmSubsystem m_arm;
    int setPoint;

    public  IntakeCommandforAutonomus( ArmSubsystem m_arm, int setPoint){
        this.setPoint = setPoint;
        this.m_arm = m_arm;

        addRequirements(m_arm);
    }

    @Override
    public void  execute(){
        m_arm.AtSetpoint(setPoint,  1);
    }

    @Override
    public  boolean isFinished(){
        return  m_arm.isAtSetPoint();
    }
}
