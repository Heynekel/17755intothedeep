package org.firstinspires.ftc.teamcode.TeleOp;

import com.arcrobotics.ftclib.command.CommandOpMode;
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
        Escalador m_escalador = new Escalador(hardwareMap, telemetry);
        GamepadEx subsystemsDriver = new GamepadEx(gamepad2);
        m_escalador.setDefaultCommand(new EscaladorDEfaulBajarTeleop(m_escalador, subsystemsDriver));
       // escalador.setDefaultCommand(new SubirEscalador(escalador, gamepadSecond));

        subsystemsDriver.getGamepadButton(GamepadKeys.Button.LEFT_BUMPER)
                .whileHeld(()-> m_escalador.setVelocity(-6000))
                .whenReleased(()-> m_escalador.setVelocity(0));

        subsystemsDriver.getGamepadButton(GamepadKeys.Button.RIGHT_BUMPER)
                .whileHeld(()-> m_escalador.setVelocity(6000))
                .whenReleased(()-> m_escalador.setVelocity(0));
    }



}
