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

import org.firstinspires.ftc.teamcode.Commands.IntakeCommandforAutonomus;
import org.firstinspires.ftc.teamcode.Commands.MecanumDriveCommand;
import org.firstinspires.ftc.teamcode.NewCommands.ElevatorCommand;
import org.firstinspires.ftc.teamcode.NewCommands.LeaveCommandintake;
import org.firstinspires.ftc.teamcode.NewCommands.ServoLeaveCommand;
import org.firstinspires.ftc.teamcode.NewCommands.ServoReturnCommand;
import org.firstinspires.ftc.teamcode.Subsystem.ArmSubsystem;
import org.firstinspires.ftc.teamcode.Subsystem.Canasta;
import org.firstinspires.ftc.teamcode.Subsystem.ElevatorSystem;
import org.firstinspires.ftc.teamcode.Subsystem.Escalador;
import org.firstinspires.ftc.teamcode.Subsystem.IntakeSubsystem;
import org.firstinspires.ftc.teamcode.Subsystem.MecanumDriveSubsystem;
import org.firstinspires.ftc.teamcode.drive.SampleMecanumDrive;









@TeleOp
public class FieldCentricTeleOp extends CommandOpMode {

    SampleMecanumDrive sampleMecanumDrive;
    MecanumDriveSubsystem m_drive;
    GamepadEx chassisDriver;
    GamepadEx subsystemsDriver;
    IntakeSubsystem m_intake;
    ElevatorSystem m_elevator;
    Canasta m_canasta;
    Escalador m_escalador;
    ArmSubsystem m_arm;

    @Override
    public void initialize() {
        sampleMecanumDrive = new SampleMecanumDrive(hardwareMap);
        m_drive = new MecanumDriveSubsystem(sampleMecanumDrive, true, false);
        chassisDriver = new GamepadEx(gamepad1);
        subsystemsDriver = new GamepadEx(gamepad2);
        m_intake = new IntakeSubsystem(hardwareMap, telemetry);
        m_elevator = new ElevatorSystem(hardwareMap, telemetry);
        m_canasta = new Canasta(hardwareMap, telemetry);
        m_escalador = new Escalador(hardwareMap, telemetry);
        m_arm = new ArmSubsystem(hardwareMap, telemetry);

   /* Driver 1 */
        /* Chassis*/
        m_drive.setDefaultCommand(
                new MecanumDriveCommand(
                        m_drive,
                        () -> -chassisDriver.getLeftY(),
                        chassisDriver::getLeftX,
                        chassisDriver::getRightX
        ));

       /* chassisDriver.getGamepadButton(
                GamepadKeys.Button.RIGHT_STICK_BUTTON)
                .whenPressed(
                        new InstantCommand(

                                ()->m_drive.toggleInverted()));
                                */


  /* Intake*/
        chassisDriver.getGamepadButton(GamepadKeys.Button.RIGHT_BUMPER)
                .whileHeld(()-> m_intake.setPower(-1))
                .whileHeld(()-> m_arm.setArmPosition(-675))

                .whenReleased(()-> m_intake.setPower(0))
                .whenReleased(()-> m_arm.setArmPosition(3));//Intake

        chassisDriver.getGamepadButton(GamepadKeys.Button.LEFT_BUMPER)//Outake
                .whileHeld(()-> m_intake.agarrar(1))
                .whileHeld(()-> m_canasta.IvansFunction())

                .whenReleased(()-> m_intake.agarrar(0))
                .whenReleased(()-> m_arm.setArmPosition(-180))
                .whenReleased(()-> m_canasta.regresar());


        chassisDriver.getGamepadButton(GamepadKeys.Button.A)//Outake
                .whenPressed(new SequentialCommandGroup(
                        new IntakeCommandforAutonomus(m_arm, -600),
                        new WaitCommand(50),
                        new InstantCommand(()-> m_intake.agarrar(1))
                ))
                        .whenReleased(()-> m_intake.agarrar(0));


        chassisDriver.getGamepadButton(GamepadKeys.Button.B)
                        .whenPressed(()-> m_arm.setArmPosition(-300));


        //m_intake.setDefaultCommand(new IntakeArmCommand(m_intake,chassisDriver,subsystemsDriver));



        /* Driver 2 */
        /* Elevator */
        subsystemsDriver.getGamepadButton(GamepadKeys.Button.START)
                        .whenPressed(()-> m_elevator.resetTicks());


            /* Basket positions*/
        subsystemsDriver.getGamepadButton(GamepadKeys.Button.Y)
                .whenPressed(
                        new SequentialCommandGroup(
                                new ParallelCommandGroup(
                                        new ElevatorCommand(m_elevator,2000),
                                        new ServoLeaveCommand(m_canasta,m_elevator,1500, 1900)),
                                new SequentialCommandGroup(
                                        new WaitCommand(600),
                                        new ServoReturnCommand(m_canasta),
                                        new WaitCommand(450),
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
                .whileHeld(()-> m_arm.setArmPosition(-180))
                .whileHeld(()-> m_elevator.setPosition(1400));

        subsystemsDriver.getGamepadButton(GamepadKeys.Button.DPAD_RIGHT)
                .whileHeld(()-> m_arm.setArmPosition(-180))
                .whileHeld(()-> m_elevator.setPosition(300));

        subsystemsDriver.getGamepadButton(GamepadKeys.Button.DPAD_DOWN)
                .whileHeld(()-> m_arm.setArmPosition(-180))
                .whileHeld(()-> m_elevator.setPosition(900));

        /* Escalator */
        subsystemsDriver.getGamepadButton(GamepadKeys.Button.RIGHT_BUMPER)
                .whenPressed(()-> m_arm.setArmPosition(-675))
                .whenPressed(()-> m_escalador.setPosition(4900));

        subsystemsDriver.getGamepadButton(GamepadKeys.Button.LEFT_BUMPER)
                .whenPressed(()-> m_escalador.setPosition(0));


        /*Outake*/
        //m_intake.setDefaultCommand(new LeaveCommandintake(m_intake, m_arm, subsystemsDriver));

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