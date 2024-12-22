package org.firstinspires.ftc.teamcode.Commands;

import com.arcrobotics.ftclib.command.CommandBase;
import com.arcrobotics.ftclib.gamepad.GamepadEx;
import com.arcrobotics.ftclib.gamepad.GamepadKeys;

import org.firstinspires.ftc.teamcode.Subsystem.Escalador;

public class EscaladorDEfaulBajarTeleop extends CommandBase {
    Escalador escalador;
    GamepadEx gamepadEx;
    public EscaladorDEfaulBajarTeleop(Escalador escalador, GamepadEx gamepadEx){
        this.escalador = escalador;
        this.gamepadEx = gamepadEx;

        addRequirements(escalador);
    }

    @Override
    public void execute(){
        /*if (gamepadEx.getTrigger(GamepadKeys.Trigger.RIGHT_TRIGGER) >= .5){
            escalador.setVelocity(5000);
        }else if (gamepadEx.getTrigger(GamepadKeys.Trigger.RIGHT_TRIGGER)>=0){
            escalador.setVelocity(0);
        }*/
        if (gamepadEx.getTrigger(GamepadKeys.Trigger.LEFT_TRIGGER) >= .5){
            escalador.setVelocity(-5000);
        } else if (gamepadEx.getTrigger(GamepadKeys.Trigger.LEFT_TRIGGER)>=0){
            escalador.setVelocity(0);
        }
    }
}
