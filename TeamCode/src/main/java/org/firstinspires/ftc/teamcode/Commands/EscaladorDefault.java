package org.firstinspires.ftc.teamcode.Commands;

import com.arcrobotics.ftclib.command.CommandBase;
import com.arcrobotics.ftclib.command.CommandScheduler;
import com.arcrobotics.ftclib.command.InstantCommand;
import com.arcrobotics.ftclib.gamepad.GamepadEx;
import com.arcrobotics.ftclib.gamepad.GamepadKeys;

import org.firstinspires.ftc.teamcode.Subsystem.Escalador;

public class EscaladorDefault extends CommandBase {
    Escalador escalador;
    GamepadEx gamepadEx;
    public EscaladorDefault(Escalador escalador, GamepadEx gamepadEx){
        this.escalador = escalador;
        this.gamepadEx = gamepadEx;

        addRequirements(escalador);
    }
    @Override
    public void execute(){
//Power
        /*if (gamepadEx.getTrigger(GamepadKeys.Trigger.RIGHT_TRIGGER) >= .5){
           escalador.setPower1(5000);
    }else if (gamepadEx.getTrigger(GamepadKeys.Trigger.RIGHT_TRIGGER)>=0){
            escalador.setPower1(0);
        }
        if (gamepadEx.getTrigger(GamepadKeys.Trigger.LEFT_TRIGGER) >= .5){
            escalador.setPower1(-5000);
        } else if (gamepadEx.getTrigger(GamepadKeys.Trigger.LEFT_TRIGGER)>=0){
            escalador.setPower1(0);
        }*/
//Posotions

        if (gamepadEx.getTrigger(GamepadKeys.Trigger.RIGHT_TRIGGER)> .5){
            CommandScheduler.getInstance().schedule(new InstantCommand(()->escalador.setPosition(2500)));
        }

        if (gamepadEx.getTrigger(GamepadKeys.Trigger.LEFT_TRIGGER)> .5){
            CommandScheduler.getInstance().schedule(new InstantCommand(()->escalador.setPosition(1800)));
        }

        if (gamepadEx.getButton(GamepadKeys.Button.DPAD_LEFT)) {

            CommandScheduler.getInstance().schedule(new InstantCommand(()->escalador.setPosition(0)));
        }





    }
}
