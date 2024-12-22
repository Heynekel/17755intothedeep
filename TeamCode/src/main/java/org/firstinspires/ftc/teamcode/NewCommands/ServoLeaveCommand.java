package org.firstinspires.ftc.teamcode.NewCommands;

import com.arcrobotics.ftclib.command.CommandBase;

import org.firstinspires.ftc.teamcode.Subsystem.Canasta;
import org.firstinspires.ftc.teamcode.Subsystem.ElevatorSystem;

public class ServoLeaveCommand extends CommandBase {

    Canasta m_servo;
    ElevatorSystem m_elevator;
    int conditional = 0;

    public ServoLeaveCommand (Canasta m_servo, ElevatorSystem m_elevator, int limit){
        this.m_servo = m_servo;
        this.m_elevator = m_elevator;
        conditional = limit;

        addRequirements(m_servo);
    }

    @Override
    public void execute() {
        if(m_elevator.getElevatorPosition() > conditional){
            m_servo.dejar();
        }

    }

   @Override
    public boolean isFinished() {
        return m_elevator.getElevatorPosition() > conditional+590;   //true ya terminar
   }
}
