package org.firstinspires.ftc.teamcode.NewCommands;

import com.arcrobotics.ftclib.command.CommandBase;
import com.arcrobotics.ftclib.gamepad.GamepadEx;
import com.arcrobotics.ftclib.gamepad.GamepadKeys;

import org.firstinspires.ftc.teamcode.Subsystem.IntakeSubsystem;

public class IntakeArmCommand extends CommandBase {

    private final IntakeSubsystem m_intake;
    private final GamepadEx gamepad;
    private final GamepadEx gamepad2;

    public IntakeArmCommand (IntakeSubsystem m_intake, GamepadEx gamepad, GamepadEx gamepad2){
        this.m_intake = m_intake;
        this.gamepad = gamepad;
        this.gamepad2 = gamepad2;

        addRequirements(m_intake);
    }

    @Override
    public void execute() {
        if(gamepad.getTrigger(GamepadKeys.Trigger.LEFT_TRIGGER) > 0.2){
            m_intake.setPoint(-650,-1,0.5);
        }
        else{
            m_intake.agarrar(0);
        }

        if(gamepad.getTrigger(GamepadKeys.Trigger.RIGHT_TRIGGER) > 0.2){
            m_intake.setArmPosition(-500);
        }

        if(gamepad2.getTrigger(GamepadKeys.Trigger.LEFT_TRIGGER) > 0.2){
            m_intake.agarrar(1);
        }
    }

    @Override
    public void end(boolean interrupted) {

    }
}
