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
import org.firstinspires.ftc.teamcode.Subsystem.Canasta;
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
        Canasta canasta = new Canasta(hardwareMap, telemetry);


        /*new GamepadButton(gamepadDriver, GamepadKeys.Button.RIGHT_BUMPER)
                .whileHeld(()-> intake.agarrar(-1))
                        .whenReleased(()->intake.agarrar(0));*/


        new GamepadButton(gamepadDriver, GamepadKeys.Button.RIGHT_BUMPER)
                .whileHeld(()-> intake.setPoint(-550,-1,0.5))
                .whenReleased(()->intake.setPoint(0,0,0.3));

        /*new GamepadButton(gamepadDriver, GamepadKeys.Button.DPAD_UP)
                .whileHeld(()-> intake.setPoint(900, -1,0.5))
                .whenReleased(()->intake.setPoint(20, 0,0.5));*/

        new  GamepadButton(gamepadSecond, GamepadKeys.Button.DPAD_DOWN)
                .whenPressed(()->canasta.regresar());

        new  GamepadButton(gamepadSecond, GamepadKeys.Button.DPAD_UP)
                .whenPressed(()-> canasta.dejar());

        new GamepadButton(gamepadDriver, GamepadKeys.Button.LEFT_BUMPER)
                .whileHeld(()-> intake.agarrar(1))
                .whenReleased(()-> intake.agarrar(0))
                .whenReleased(()->intake.setPosition(-100));

        new  GamepadButton(gamepadDriver, GamepadKeys.Button.DPAD_UP)
                .whileHeld(()-> intake.setPoint(intake.getPosition()-100, 0, .3))
                .whenReleased(()-> intake.setPoint(intake.getPosition(), 0, .3));

        new  GamepadButton(gamepadDriver, GamepadKeys.Button.DPAD_DOWN)
                .whileHeld(()-> intake.setPoint(intake.getPosition()+100, 0, .3))
                .whenReleased(()-> intake.setPoint(intake.getPosition(), 0, .3));



       /* new  GamepadButton(gamepadDriver, GamepadKeys.Button.Y)
                .whileHeld(()-> elevatorSystem.setPower(1))
                .whenReleased(()->elevatorSystem.setPower(0));

        new GamepadButton(gamepadDriver, GamepadKeys.Button.A)
                .whileHeld(()-> elevatorSystem.setPower(-1))
                .whenReleased(()->elevatorSystem.setPower(0));*/
///////////////////////////////////////////////////////////////////////////////////////////////////
        //////////////////////////////////////////////////////////////////////////////////////////

       /* new GamepadButton(gamepadSecond, GamepadKeys.Button.LEFT_BUMPER)
                .whileHeld(()-> intake.SetPower(-0.5))
                .whenReleased(()->intake.SetPower(0));*/


        new GamepadButton(gamepadSecond, GamepadKeys.Button.Y)
                .whenPressed(()-> elevatorSystem.setPosition(2150));

        new GamepadButton(gamepadSecond, GamepadKeys.Button.B)
                .whenPressed(()-> elevatorSystem.setPosition(900));

        //1250 low basket

        new GamepadButton(gamepadDriver, GamepadKeys.Button.START)
                .whenPressed(()->intake.resetintakearmtiks());


        new GamepadButton(gamepadSecond, GamepadKeys.Button.A)
                .whenPressed(()-> elevatorSystem.setPosition(10));

        new  GamepadButton(gamepadSecond, GamepadKeys.Button.RIGHT_STICK_BUTTON)
                .whenPressed(()->elevatorSystem.resetarmsystemticks());

        /*new GamepadButton(gamepadSecond, GamepadKeys.Button.DPAD_UP)
                .whileHeld(()-> intake.setPoint(900, 1,0.5))
                        .whenReleased(()->intake.setPoint(20, 0,0.5));*/

        driveSubsystem.setDefaultCommand(new MecanumDriveCommand(
                driveSubsystem, () -> -gamepadDriver.getLeftY(), gamepadDriver::getLeftX, gamepadDriver::getRightX
        ));
        schedule(new RunCommand(() -> {
            driveSubsystem.update();
            driveSubsystem.updatePoseEstimate();
            telemetry.addData("Heading", driveSubsystem.getPoseEstimate().getHeading());
            telemetry.addData("Position", driveSubsystem.getPoseEstimate());
            telemetry.update();
  }));
    }
}
