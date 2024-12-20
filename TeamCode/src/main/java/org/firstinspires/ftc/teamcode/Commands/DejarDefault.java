package org.firstinspires.ftc.teamcode.Commands;

import com.arcrobotics.ftclib.command.CommandBase;
import com.arcrobotics.ftclib.command.CommandScheduler;
import com.arcrobotics.ftclib.command.InstantCommand;
import com.arcrobotics.ftclib.command.WaitCommand;
import com.arcrobotics.ftclib.gamepad.GamepadEx;
import com.arcrobotics.ftclib.gamepad.GamepadKeys;

import org.firstinspires.ftc.teamcode.Subsystem.Canasta;
import org.firstinspires.ftc.teamcode.Subsystem.ElevatorSystem;
import org.firstinspires.ftc.teamcode.Subsystem.Intake;

public class DejarDefault extends CommandBase {
    ElevatorSystem elevatorSystem;
    Canasta canasta;
    Intake intake;
    GamepadEx gamepadEx;
    public DejarDefault(ElevatorSystem elevatorSystem, Canasta canasta, Intake intake, GamepadEx gamepadEx) {
        this.elevatorSystem = elevatorSystem;
        this.canasta = canasta;
        this.intake = intake;
        this.gamepadEx = gamepadEx;
        addRequirements(elevatorSystem);
    }
    @Override
    public void execute() {
        if (gamepadEx.getButton(GamepadKeys.Button.Y)) {
            CommandScheduler.getInstance().schedule(new InstantCommand(()-> intake.setPosition(-256)));
            CommandScheduler.getInstance().schedule(new WaitCommand(10000));
            CommandScheduler.getInstance().schedule(new InstantCommand(() -> elevatorSystem.setPosition(2150)));
        }
        if (elevatorSystem.getArmsystemPosition()>2000 ){
            canasta.dejar();
        }

        if (elevatorSystem.getArmsystemPosition()>900 ){
            canasta.regresar();
        }
        if (gamepadEx.getButton(GamepadKeys.Button.B)) {
                CommandScheduler.getInstance().schedule(new InstantCommand(()-> intake.setPosition(-256)));
                CommandScheduler.getInstance().schedule(new WaitCommand(350));
                CommandScheduler.getInstance().schedule(new InstantCommand(() -> elevatorSystem.setPosition(950)));
                CommandScheduler.getInstance().schedule(new WaitCommand(20000));
                CommandScheduler.getInstance().schedule(new InstantCommand(() -> canasta.dejar()));
        }
        if (gamepadEx.getButton(GamepadKeys.Button.A)) {
            CommandScheduler.getInstance().schedule(new InstantCommand(() -> canasta.regresar()));
                CommandScheduler.getInstance().schedule(new InstantCommand(()-> intake.setPosition(-256)));
                CommandScheduler.getInstance().schedule(new InstantCommand(() -> elevatorSystem.setPosition(0)));
        }
        }
    }

