package org.firstinspires.ftc.teamcode.Commands;

import com.arcrobotics.ftclib.command.CommandBase;

import org.firstinspires.ftc.teamcode.Subsystem.Canasta;

public class ServoReturnCommand extends CommandBase {

    Canasta m_servo;

    public ServoReturnCommand (Canasta m_servo){
        this.m_servo = m_servo;

        addRequirements(m_servo);
    }

    @Override
    public void execute() {
        m_servo.regresar();
    }

    @Override
    public boolean isFinished() {
        return m_servo.getPos() < 100;
    }
}
