package org.firstinspires.ftc.teamcode.TeleOp;

import com.arcrobotics.ftclib.command.CommandOpMode;
import com.arcrobotics.ftclib.command.InstantCommand;
import com.arcrobotics.ftclib.gamepad.GamepadEx;
import com.arcrobotics.ftclib.gamepad.GamepadKeys;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.Commands.EscaladorDEfaulBajarTeleop;
import org.firstinspires.ftc.teamcode.Commands.EscaladorDefault;
import org.firstinspires.ftc.teamcode.Commands.MecanumDriveCommand;
import org.firstinspires.ftc.teamcode.Commands.SubirEscalador;
import org.firstinspires.ftc.teamcode.Subsystem.ArmSubsystem;
import org.firstinspires.ftc.teamcode.Subsystem.Canasta;
import org.firstinspires.ftc.teamcode.Subsystem.ElevatorSystem;
import org.firstinspires.ftc.teamcode.Subsystem.Escalador;
import org.firstinspires.ftc.teamcode.Subsystem.IntakeSubsystem;
import org.firstinspires.ftc.teamcode.Subsystem.MecanumDriveSubsystem;
import org.firstinspires.ftc.teamcode.drive.SampleMecanumDrive;

@TeleOp
public class TeleopPorPoder extends CommandOpMode {

    SampleMecanumDrive sampleMecanumDrive;
    MecanumDriveSubsystem m_drive;
    GamepadEx chassisDriver;
    GamepadEx subsystemsDriver;
    IntakeSubsystem m_intake;
    ElevatorSystem m_elevator;
    Canasta m_canasta;
    Escalador m_escalador;
    ArmSubsystem m_arm;

    ///
    @Override
    public void initialize() {
        sampleMecanumDrive = new SampleMecanumDrive(hardwareMap);
        m_drive = new MecanumDriveSubsystem(sampleMecanumDrive, false, false);
        chassisDriver = new GamepadEx(gamepad1);
        subsystemsDriver = new GamepadEx(gamepad2);
        m_intake = new IntakeSubsystem(hardwareMap, telemetry);
        m_elevator = new ElevatorSystem(hardwareMap, telemetry);
        m_canasta = new Canasta(hardwareMap, telemetry);
        m_escalador = new Escalador(hardwareMap, telemetry);
        m_arm = new ArmSubsystem(hardwareMap, telemetry);

/*Escalador*/
        subsystemsDriver.getGamepadButton(GamepadKeys.Button.LEFT_BUMPER)
                .whileHeld(()-> m_escalador.setVelocity(-6000))
                .whenReleased(()-> m_escalador.setVelocity(0));

        subsystemsDriver.getGamepadButton(GamepadKeys.Button.RIGHT_BUMPER)
                .whileHeld(()-> m_escalador.setVelocity(6000))
                .whenReleased(()-> m_escalador.setVelocity(0));

        /*Elevador*/
        subsystemsDriver.getGamepadButton(GamepadKeys.Button.A)
                .whileHeld(()->m_elevator.velocidad(-6000))
                .whenReleased(()-> m_elevator.velocidad(0));

        subsystemsDriver.getGamepadButton(GamepadKeys.Button.Y)
                .whileHeld(()->m_elevator.velocidad(6000))
                .whenReleased(()-> m_elevator.velocidad(0));

           
        chassisDriver.getGamepadButton(GamepadKeys.Button.RIGHT_BUMPER)
                .whileHeld(()-> m_intake.setPower(-1))
                .whileHeld(()-> m_arm.setArmPosition(-675))

                .whenReleased(()-> m_intake.setPower(0))
                .whenReleased(()-> m_arm.setArmPosition(-1));//Intake

        chassisDriver.getGamepadButton(GamepadKeys.Button.LEFT_BUMPER)//Outake
                .whileHeld(()-> m_intake.agarrar(1))
                .whileHeld(()-> m_canasta.IvansFunction())

                .whenReleased(()-> m_intake.agarrar(0))
                .whenReleased(()-> m_arm.setArmPosition(-180))
                .whenReleased(()-> m_canasta.regresar());

        chassisDriver.getGamepadButton(GamepadKeys.Button.DPAD_RIGHT)//Outake
                .whileHeld(()-> m_intake.agarrar(1))
                .whileHeld(()-> m_arm.setArmPosition(-675))

                .whenReleased(()-> m_intake.agarrar(0))
                .whenReleased(()-> m_arm.setArmPosition(0));



        /*Chasis*/
        m_drive.setDefaultCommand(new MecanumDriveCommand(
                        m_drive,
                        () -> -chassisDriver.getLeftY(),
                        chassisDriver::getLeftX,
                        chassisDriver::getRightX));
    }

}
