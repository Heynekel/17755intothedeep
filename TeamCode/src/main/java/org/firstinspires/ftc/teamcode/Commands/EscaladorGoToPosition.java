package org.firstinspires.ftc.teamcode.Commands;

import com.arcrobotics.ftclib.command.CommandBase;

import org.firstinspires.ftc.teamcode.Subsystem.ElevatorSystem;
import org.firstinspires.ftc.teamcode.Subsystem.Escalador;

public class EscaladorGoToPosition extends CommandBase {
Escalador escalador;
    int setPoint;

    public  EscaladorGoToPosition( int setPoint, Escalador escalador){
        this.escalador = escalador;
        this.setPoint =  setPoint;

        addRequirements(escalador);
    }

    @Override
    public void  execute(){
        escalador.setPoint(1, setPoint);
    }

    @Override
    public  boolean isFinished(){
        return  escalador.isAtSetPoint();
    }


}
