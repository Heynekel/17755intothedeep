package org.firstinspires.ftc.teamcode.Commands;

import com.arcrobotics.ftclib.command.CommandBase;
import com.arcrobotics.ftclib.command.CommandScheduler;
import com.arcrobotics.ftclib.command.InstantCommand;
import com.arcrobotics.ftclib.command.WaitCommand;
import com.arcrobotics.ftclib.gamepad.GamepadEx;
import com.arcrobotics.ftclib.gamepad.GamepadKeys;

import org.firstinspires.ftc.teamcode.Subsystem.Canasta;
import org.firstinspires.ftc.teamcode.Subsystem.ElevatorSystem;

public class DejarDefault extends CommandBase {
    ElevatorSystem elevatorSystem;
    Canasta canasta;
    GamepadEx gamepadEx;

    public DejarDefault(ElevatorSystem elevatorSystem, Canasta canasta, GamepadEx gamepadEx) {
        this.elevatorSystem = elevatorSystem;
        this.canasta = canasta;
        this.gamepadEx = gamepadEx;

        addRequirements(elevatorSystem);
    }

    @Override
    public void execute() {

        if (gamepadEx.getButton(GamepadKeys.Button.Y)) {
            CommandScheduler.getInstance().schedule(new InstantCommand(() -> elevatorSystem.setPosition(900)));
            CommandScheduler.getInstance().schedule(new WaitCommand(2150));
            CommandScheduler.getInstance().schedule(new InstantCommand(() -> canasta.dejar()));


            if (gamepadEx.getButton(GamepadKeys.Button.B)) {
                CommandScheduler.getInstance().schedule(new InstantCommand(() -> elevatorSystem.setPosition(900)));
                CommandScheduler.getInstance().schedule(new WaitCommand(1000));
                CommandScheduler.getInstance().schedule(new InstantCommand(() -> canasta.dejar()));
            }

            if (gamepadEx.getButton(GamepadKeys.Button.A)) {
                CommandScheduler.getInstance().schedule(new InstantCommand(() -> canasta.dejar()));
                CommandScheduler.getInstance().schedule(new WaitCommand(500));
                CommandScheduler.getInstance().schedule(new InstantCommand(() -> elevatorSystem.setPosition(0)));
            }
        }

    }
}
