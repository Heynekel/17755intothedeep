package org.firstinspires.ftc.teamcode.Commands;

import com.arcrobotics.ftclib.command.CommandBase;

import org.firstinspires.ftc.teamcode.Subsystem.ElevatorSystem;

public class ArmGoToPosition extends CommandBase {
    ElevatorSystem armsystem;
    int setPoint;

    public  ArmGoToPosition(ElevatorSystem armsystem, int setPoint){
        this.armsystem = armsystem ;
        this.setPoint =  setPoint;

addRequirements(armsystem);
    }
@Override
    public void  execute(){
armsystem.setPoint(1, setPoint);
}

@Override
    public  boolean isFinished(){
return  armsystem.isAtSetPoint();
}
}
