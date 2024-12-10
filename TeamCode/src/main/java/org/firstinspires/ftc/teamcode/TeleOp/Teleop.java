package org.firstinspires.ftc.teamcode.TeleOp;

import static org.firstinspires.ftc.robotcore.external.BlocksOpModeCompanion.gamepad1;
import static org.firstinspires.ftc.robotcore.external.BlocksOpModeCompanion.hardwareMap;

import com.arcrobotics.ftclib.command.CommandOpMode;
import com.arcrobotics.ftclib.command.RunCommand;
import com.arcrobotics.ftclib.command.button.GamepadButton;
import com.arcrobotics.ftclib.gamepad.GamepadEx;
import com.arcrobotics.ftclib.gamepad.GamepadKeys;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.Commands.MecanumDriveCommand;
import org.firstinspires.ftc.teamcode.Subsystem.ElevatorSystem;
import org.firstinspires.ftc.teamcode.Subsystem.Intake;
import org.firstinspires.ftc.teamcode.Subsystem.MecanumDriveSubsystem;
import org.firstinspires.ftc.teamcode.drive.SampleMecanumDrive;

@TeleOp

public class Teleop extends CommandOpMode {
    @Override
    public void initialize() {
        SampleMecanumDrive sampleMecanumDrive = new SampleMecanumDrive(hardwareMap);
        MecanumDriveSubsystem driveSubsystem = new MecanumDriveSubsystem(sampleMecanumDrive, false, false);
        GamepadEx gamepadDriver = new GamepadEx(gamepad1);
        GamepadEx gamepadSecond = new GamepadEx(gamepad2);
        Intake intake = new Intake(hardwareMap, telemetry);
        ElevatorSystem elevatorSystem = new ElevatorSystem(hardwareMap, telemetry);

        new  GamepadButton(gamepadDriver, GamepadKeys.Button.RIGHT_STICK_BUTTON)
                .whenPressed(()->elevatorSystem.resetarmsystemticks());

        new GamepadButton(gamepadDriver, GamepadKeys.Button.RIGHT_BUMPER)
                .whileHeld(()-> intake.agarrar(-1))
                        .whenReleased(()->intake.agarrar(0));

        new GamepadButton(gamepadDriver, GamepadKeys.Button.LEFT_BUMPER)
                .whileHeld(()-> intake.agarrar(1))
                .whenReleased(()->intake.agarrar(0));

        new  GamepadButton(gamepadDriver, GamepadKeys.Button.Y)
                .whileHeld(()-> elevatorSystem.setPower(1))
                .whenReleased(()->elevatorSystem.setPower(0));

        new GamepadButton(gamepadDriver, GamepadKeys.Button.A)
                .whileHeld(()-> elevatorSystem.setPower(-1))
                .whenReleased(()->elevatorSystem.setPower(0));
///////////////////////////////////////////////////////////////////////////////////////////////////
        //////////////////////////////////////////////////////////////////////////////////////////
        new GamepadButton(gamepadSecond, GamepadKeys.Button.RIGHT_BUMPER)
                .whileHeld(()-> intake.SetPower(0.5))
                .whenReleased(()->intake.SetPower(0));

        new GamepadButton(gamepadSecond, GamepadKeys.Button.LEFT_BUMPER)
                .whileHeld(()-> intake.SetPower(-0.5))
                .whenReleased(()->intake.SetPower(0));


        new GamepadButton(gamepadSecond, GamepadKeys.Button.Y)
                .whenPressed(()-> elevatorSystem.setPosition(3800));

        new GamepadButton(gamepadSecond, GamepadKeys.Button.B)
                .whenPressed(()-> elevatorSystem.setPosition(1250));

        //1250 low basket

        new GamepadButton(gamepadSecond, GamepadKeys.Button.LEFT_STICK_BUTTON)
                .whenPressed(()->intake.resetintakearmtiks());



        new GamepadButton(gamepadSecond, GamepadKeys.Button.A)
                .whenPressed(()-> elevatorSystem.setPosition(0));

        driveSubsystem.setDefaultCommand(new MecanumDriveCommand(
                driveSubsystem, () -> -gamepadDriver.getLeftY(), gamepadDriver::getLeftX, gamepadDriver::getRightX
        ));
        schedule(new RunCommand(() -> {
            driveSubsystem.update();
            telemetry.addData("Heading", driveSubsystem.getPoseEstimate().getHeading());
            telemetry.update();
        }));

    }
}
