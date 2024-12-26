package org.firstinspires.ftc.teamcode.TeleOp;

import com.arcrobotics.ftclib.command.CommandOpMode;
import com.arcrobotics.ftclib.command.InstantCommand;
import com.arcrobotics.ftclib.command.ParallelCommandGroup;
import com.arcrobotics.ftclib.command.RunCommand;
import com.arcrobotics.ftclib.command.SequentialCommandGroup;
import com.arcrobotics.ftclib.command.WaitCommand;
import com.arcrobotics.ftclib.gamepad.GamepadEx;
import com.arcrobotics.ftclib.gamepad.GamepadKeys;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.Commands.MecanumDriveCommand;
import org.firstinspires.ftc.teamcode.NewCommands.ElevatorCommand;
import org.firstinspires.ftc.teamcode.NewCommands.IntakeArmCommand;
import org.firstinspires.ftc.teamcode.NewCommands.ServoLeaveCommand;
import org.firstinspires.ftc.teamcode.NewCommands.ServoReturnCommand;
import org.firstinspires.ftc.teamcode.Subsystem.Canasta;
import org.firstinspires.ftc.teamcode.Subsystem.ElevatorSystem;
import org.firstinspires.ftc.teamcode.Subsystem.Escalador;
import org.firstinspires.ftc.teamcode.Subsystem.IntakeSubsystem;
import org.firstinspires.ftc.teamcode.Subsystem.MecanumDriveSubsystem;
import org.firstinspires.ftc.teamcode.drive.SampleMecanumDrive;

@TeleOp
public class NOFieldCentricOp extends CommandOpMode {

    SampleMecanumDrive sampleMecanumDrive;
    MecanumDriveSubsystem m_drive;
    GamepadEx chassisDriver;
    GamepadEx subsystemsDriver;
    IntakeSubsystem m_intake;
    ElevatorSystem m_elevator;
    Canasta m_canasta;
    Escalador m_escalador;

    @Override
    public void initialize() {
        sampleMecanumDrive = new SampleMecanumDrive(hardwareMap);
        m_drive = new MecanumDriveSubsystem(sampleMecanumDrive, false);
        chassisDriver = new GamepadEx(gamepad1);
        subsystemsDriver = new GamepadEx(gamepad2);
        m_intake = new IntakeSubsystem(hardwareMap, telemetry);
        m_elevator = new ElevatorSystem(hardwareMap, telemetry);
        m_canasta = new Canasta(hardwareMap, telemetry);
        m_escalador = new Escalador(hardwareMap, telemetry);

   /* Driver 1 */
        /* Chassis*/
        m_drive.setDefaultCommand(
                new MecanumDriveCommand(
                        m_drive,
                        () -> -chassisDriver.getLeftY(),
                        chassisDriver::getLeftX,
                        chassisDriver::getRightX
        ));

        chassisDriver.getGamepadButton(
                GamepadKeys.Button.RIGHT_STICK_BUTTON)
                .whenPressed(
                        new InstantCommand(
                                ()->m_drive.toggleInverted()));

        /*
         Intake

         */
        chassisDriver.getGamepadButton(GamepadKeys.Button.RIGHT_BUMPER)
                .whileHeld(()-> m_intake.setPoint(-675,-1, 0.5))
                .whileHeld(m_canasta::regresar)
                .whenReleased(()-> m_intake.setPoint(0,0,0.5));//Intake

        chassisDriver.getGamepadButton(GamepadKeys.Button.LEFT_BUMPER)//Outake
                .whileHeld(()-> m_intake.agarrar(1))
                .whileHeld(()-> m_canasta.IvansFunction())

                .whenReleased(()-> m_intake.agarrar(0))
                .whenReleased(()-> m_intake.setArmPosition(-180))
                .whenReleased(()-> m_canasta.regresar());

        chassisDriver.getGamepadButton(GamepadKeys.Button.DPAD_RIGHT)//Outake
                .whileHeld(()-> m_intake.agarrar(1))
                .whileHeld(()-> m_intake.setArmPosition(-675))
                .whenReleased(()-> m_intake.agarrar(0))
                .whenReleased(()-> m_intake.setArmPosition(0));



        //m_intake.setDefaultCommand(new IntakeArmCommand(m_intake,chassisDriver,subsystemsDriver));

        chassisDriver.getGamepadButton(GamepadKeys.Button.DPAD_UP)
                        .whileHeld(()-> m_canasta.dejar()
                        );

        chassisDriver.getGamepadButton(GamepadKeys.Button.DPAD_DOWN)
                .whileHeld(()-> m_canasta.regresar());





        /* Driver 2 */
        /* Elevator */
        subsystemsDriver.getGamepadButton(GamepadKeys.Button.START)
                        .whenPressed(()-> m_elevator.resetTicks());

            /* Basket positions*/
        subsystemsDriver.getGamepadButton(GamepadKeys.Button.Y)
                .whenPressed(
                        new SequentialCommandGroup(
                                new ParallelCommandGroup(
                                        new ElevatorCommand(m_elevator,2150),
                                        new ServoLeaveCommand(m_canasta,m_elevator,1500, 2100)),
                                new SequentialCommandGroup(
                                        new WaitCommand(500),
                                        new ServoReturnCommand(m_canasta),
                                        new WaitCommand(400),
                                        new ElevatorCommand(m_elevator,0)
                                )

                        )
                );

        subsystemsDriver.getGamepadButton(GamepadKeys.Button.B)
                .whenPressed(
                        new SequentialCommandGroup(
                                new ParallelCommandGroup(
                                        new ElevatorCommand(m_elevator,960),
                                        new ServoLeaveCommand(m_canasta,m_elevator,359, 900)),
                                new SequentialCommandGroup(
                                        new WaitCommand(300),
                                        new ServoReturnCommand(m_canasta),
                                        new WaitCommand(400),
                                        new ElevatorCommand(m_elevator,0)
                                )

                        )
                );
        subsystemsDriver.getGamepadButton(GamepadKeys.Button.A)
                .whenPressed(()-> m_elevator.setPosition(0))
                        .whenPressed(m_canasta::regresar);

                /*Chamber positions */

        subsystemsDriver.getGamepadButton(GamepadKeys.Button.DPAD_UP)
                .whileHeld(()-> m_intake.setArmPosition(-180))
                .whileHeld(()-> m_elevator.setPosition(1350));

        subsystemsDriver.getGamepadButton(GamepadKeys.Button.DPAD_LEFT)
                .whileHeld(()-> m_intake.setArmPosition(-180))
                .whileHeld(()-> m_elevator.setPosition(300));

        subsystemsDriver.getGamepadButton(GamepadKeys.Button.DPAD_DOWN)
                .whileHeld(()-> m_intake.setArmPosition(-180))
                .whileHeld(()-> m_elevator.setPosition(900));

        /* Escalator */
        subsystemsDriver.getGamepadButton(GamepadKeys.Button.RIGHT_BUMPER)
                .whileHeld(()-> m_escalador.setVelocity(6000))
                .whenReleased(()-> m_escalador.setVelocity(0));

        subsystemsDriver.getGamepadButton(GamepadKeys.Button.LEFT_BUMPER)
                .whileHeld(()-> m_escalador.setVelocity(-6000))
                .whenReleased(()-> m_escalador.setVelocity(0));
        /* Basket manual */

        subsystemsDriver.getGamepadButton(GamepadKeys.Button.LEFT_STICK_BUTTON)
                        .whileHeld(()-> m_canasta.dejar())
                .whileHeld(()->m_intake.setArmPosition(-210))
                                .whenReleased(()-> m_canasta.regresar());

        schedule(new RunCommand(() -> {
            m_drive.update();
            m_drive.updatePoseEstimate();
            telemetry.addData("Heading", m_drive.getPoseEstimate().getHeading());
            telemetry.addData("Position", m_drive.getPoseEstimate());
            telemetry.update();
        }));
    }

    public boolean isJoystickMoving(){
        return Math.abs(chassisDriver.getLeftY()) > 0.1 || Math.abs(chassisDriver.getLeftX()) > 0.1 || Math.abs(chassisDriver.getRightX()) > 0.1;
    }
}