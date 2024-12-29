package org.firstinspires.ftc.teamcode.NewCommands;

import com.arcrobotics.ftclib.command.CommandBase;
import com.arcrobotics.ftclib.command.CommandScheduler;
import com.arcrobotics.ftclib.command.InstantCommand;
import com.arcrobotics.ftclib.gamepad.GamepadEx;
import com.arcrobotics.ftclib.gamepad.GamepadKeys;

import org.firstinspires.ftc.teamcode.Subsystem.ArmSubsystem;
import org.firstinspires.ftc.teamcode.Subsystem.IntakeSubsystem;

import java.lang.reflect.Method;

public class IntakeArmCommand extends CommandBase {

    private final IntakeSubsystem m_intake;
    ArmSubsystem m_arm;
    private final GamepadEx gamepad;

    public IntakeArmCommand (IntakeSubsystem m_intake, ArmSubsystem m_arm, GamepadEx gamepad){
        this.m_intake = m_intake;
        this.gamepad = gamepad;


        addRequirements(m_intake, m_arm);
    }

    @Override
    public void execute() {
        if(gamepad.getTrigger(GamepadKeys.Trigger.LEFT_TRIGGER) > 0.2){
            CommandScheduler.getInstance().schedule(new InstantCommand(() -> m_arm.setArmPosition(-400)));
            CommandScheduler.getInstance().schedule(new InstantCommand(()->m_intake.agarrar(-1)));
        }
        else{
            m_intake.agarrar(0);
            CommandScheduler.getInstance().schedule(new InstantCommand(() -> m_arm.setArmPosition(0)));
        }

        if(gamepad.getTrigger(GamepadKeys.Trigger.RIGHT_TRIGGER) > 0.2){
            m_arm.setArmPosition(-500);
        }

        if(gamepad.getTrigger(GamepadKeys.Trigger.LEFT_TRIGGER) > 0.2){
            m_intake.agarrar(1);
        }
    }

    @Override
    public void end(boolean interrupted) {

    }
}
