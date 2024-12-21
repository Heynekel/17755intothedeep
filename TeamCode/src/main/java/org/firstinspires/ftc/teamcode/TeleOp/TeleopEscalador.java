package org.firstinspires.ftc.teamcode.TeleOp;

import com.arcrobotics.ftclib.command.CommandOpMode;
import com.arcrobotics.ftclib.command.RunCommand;
import com.arcrobotics.ftclib.command.button.GamepadButton;
import com.arcrobotics.ftclib.gamepad.GamepadEx;
import com.arcrobotics.ftclib.gamepad.GamepadKeys;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.Commands.EscaladorDEfaulBajarTeleop;
import org.firstinspires.ftc.teamcode.Commands.EscaladorDefault;
import org.firstinspires.ftc.teamcode.Commands.SubirEscalador;
import org.firstinspires.ftc.teamcode.Subsystem.Escalador;

@TeleOp
public class TeleopEscalador extends CommandOpMode {
///
    @Override
    public void initialize() {
        Escalador escalador = new Escalador(hardwareMap, telemetry);
        GamepadEx gamepadSecond = new GamepadEx(gamepad2);
        //escalador.setDefaultCommand(new EscaladorDEfaulBajarTeleop(escalador, gamepadSecond));
       // escalador.setDefaultCommand(new SubirEscalador(escalador, gamepadSecond));

        new GamepadButton(gamepadSecond, GamepadKeys.Button.Y)
                .whileHeld(()-> escalador.setVelocity(6000))
                .whenReleased(()-> escalador.setVelocity(0));

        new GamepadButton(gamepadSecond, GamepadKeys.Button.A)
                .whileHeld(()-> escalador.setVelocity(-6000))
                .whenReleased(()-> escalador.setVelocity(0));

        schedule(new RunCommand(() -> {
            telemetry.update();
        }));
    }
}
