package org.firstinspires.ftc.teamcode.NewCode;

import com.arcrobotics.ftclib.command.CommandBase;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.teamcode.Subsystem.Canasta;
import org.firstinspires.ftc.teamcode.Subsystem.ElevatorSystem;

public class ElevatorCommand extends CommandBase {

    ElevatorSystem m_elevator;
    int goal;

    public ElevatorCommand (ElevatorSystem m_elevator, int position){
        this.m_elevator = m_elevator;
        goal = position;

        addRequirements(m_elevator);
    }

    @Override
    public void execute() {
        m_elevator.setPosition(goal);
    }

    @Override
    public void end(boolean interrupted) {

    }
    @Override
    public boolean isFinished(){
        return m_elevator.getElevatorPosition() > (goal - 12);
    }
}
