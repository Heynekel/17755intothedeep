package org.firstinspires.ftc.teamcode.NewCommands;

import com.arcrobotics.ftclib.command.CommandBase;

import org.firstinspires.ftc.teamcode.Subsystem.MecanumDriveSubsystem;

public class TurnCommand extends CommandBase {
MecanumDriveSubsystem m_mecanumSubsystem;
private static double radiansValue;

public TurnCommand( MecanumDriveSubsystem m_mecanumSubsystem, double radians) {
    radiansValue = radians;
    this.m_mecanumSubsystem = m_mecanumSubsystem;

    addRequirements(m_mecanumSubsystem);

}

@Override
    public void execute(){
    m_mecanumSubsystem.turn(radiansValue);
}

    @Override
    public void end(boolean interrupted) {
    }

}
