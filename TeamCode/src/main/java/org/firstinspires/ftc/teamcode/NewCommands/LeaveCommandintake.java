package org.firstinspires.ftc.teamcode.NewCommands;

import com.arcrobotics.ftclib.command.CommandBase;
import com.arcrobotics.ftclib.command.CommandScheduler;
import com.arcrobotics.ftclib.command.InstantCommand;
import com.arcrobotics.ftclib.gamepad.GamepadEx;
import com.arcrobotics.ftclib.gamepad.GamepadKeys;

import org.firstinspires.ftc.teamcode.Subsystem.ArmSubsystem;
import org.firstinspires.ftc.teamcode.Subsystem.IntakeSubsystem;

import java.util.concurrent.Callable;

public class LeaveCommandintake extends CommandBase {

    IntakeSubsystem m_intake;
    ArmSubsystem m_arm;
    GamepadEx gamepad;
    public LeaveCommandintake(IntakeSubsystem m_intake, ArmSubsystem m_arm, GamepadEx gamepad) {
        this.m_intake = m_intake;
        this.gamepad = gamepad;
        this.m_arm = m_arm;

        addRequirements(m_intake, m_arm);
    }
    @Override
    public void execute() {

        if (gamepad.getTrigger(GamepadKeys.Trigger.LEFT_TRIGGER) > 0.5) {
            m_intake.agarrar(1);
            }

        else  if (gamepad.getTrigger(GamepadKeys.Trigger.LEFT_TRIGGER) > 0){
            m_intake.agarrar(0);
            m_arm.setArmPosition(-180);
        }




        if (gamepad.getTrigger(GamepadKeys.Trigger.RIGHT_TRIGGER) > 0.5) {
            m_intake.agarrar(1);
           m_arm.setArmPosition(-675);
        }
        else  if (gamepad.getTrigger(GamepadKeys.Trigger.RIGHT_TRIGGER) > 0){
            m_intake.agarrar(0);
           m_arm.setArmPosition(0);

        }






    }
    }



