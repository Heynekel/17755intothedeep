
package org.firstinspires.ftc.teamcode.TeleOp;


import com.arcrobotics.ftclib.command.CommandOpMode;
import com.arcrobotics.ftclib.command.ParallelCommandGroup;
import com.arcrobotics.ftclib.command.RunCommand;
import com.arcrobotics.ftclib.command.SequentialCommandGroup;
import com.arcrobotics.ftclib.command.WaitCommand;
import com.arcrobotics.ftclib.command.button.GamepadButton;
import com.arcrobotics.ftclib.gamepad.GamepadEx;
import com.arcrobotics.ftclib.gamepad.GamepadKeys;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;


import org.firstinspires.ftc.teamcode.Commands.MecanumDriveCommand;
import org.firstinspires.ftc.teamcode.NewCommands.ElevatorCommand;
import org.firstinspires.ftc.teamcode.NewCommands.ServoLeaveCommand;
import org.firstinspires.ftc.teamcode.NewCommands.ServoReturnCommand;
import org.firstinspires.ftc.teamcode.Subsystem.Canasta;
import org.firstinspires.ftc.teamcode.Subsystem.ElevatorSystem;
import org.firstinspires.ftc.teamcode.Subsystem.Escalador;
import org.firstinspires.ftc.teamcode.Subsystem.IntakeSubsystem;
import org.firstinspires.ftc.teamcode.Subsystem.MecanumDriveSubsystem;
import org.firstinspires.ftc.teamcode.drive.SampleMecanumDrive;

@TeleOp
public class FieldCentricOP extends CommandOpMode {

    SampleMecanumDrive sampleMecanumDrive;
    MecanumDriveSubsystem driveSubsystem;
    GamepadEx chassisDriver;
    GamepadEx subsystemsDriver;
    IntakeSubsystem m_intake;
    ElevatorSystem m_elevator;
    Canasta m_canasta;
    Escalador m_escalador;

    @Override
    public void initialize() {
        sampleMecanumDrive = new SampleMecanumDrive(hardwareMap);
        driveSubsystem = new MecanumDriveSubsystem(sampleMecanumDrive, true);
        chassisDriver = new GamepadEx(gamepad1);
        subsystemsDriver = new GamepadEx(gamepad2);
        m_intake = new IntakeSubsystem(hardwareMap, telemetry);
        m_elevator = new ElevatorSystem(hardwareMap, telemetry);
        m_canasta = new Canasta(hardwareMap, telemetry);
        m_escalador = new Escalador(hardwareMap, telemetry);



        /*new GamepadButton(chassisDriver, GamepadKeys.Button.RIGHT_BUMPER)
                .whileHeld(()-> intake.agarrar(-1))
                        .whenReleased(()->intake.agarrar(0));*/

        new GamepadButton(chassisDriver, GamepadKeys.Button.START)
                .whenPressed(()-> m_intake.resetintakearmtiks());

        new GamepadButton(chassisDriver, GamepadKeys.Button.RIGHT_BUMPER)
                .whileHeld(()-> m_intake.setPoint(-720,-1, 0.5))
                .whenReleased(()-> m_intake.setPoint(0,0,0.5));

        /*new GamepadButton(chassisDriver, GamepadKeys.Button.DPAD_UP)
                .whileHeld(()-> intake.setPoint(900, -1,0.5))
                .whenReleased(()->intake.setPoint(20, 0,0.5));*/
        //raul gay


        new GamepadButton(chassisDriver, GamepadKeys.Button.LEFT_BUMPER)
                .whileHeld(()-> m_intake.agarrar(1))
                .whenReleased(()-> m_intake.agarrar(0))
                .whenReleased(()-> m_intake.setArmPosition(-256));

        new  GamepadButton(chassisDriver, GamepadKeys.Button.DPAD_UP)
                .whileHeld(()-> m_intake.setPoint(m_intake.getPosition()-100, 0, .3))
                .whenReleased(()-> m_intake.setPoint(m_intake.getPosition(), 0, .3));

        new  GamepadButton(chassisDriver, GamepadKeys.Button.DPAD_DOWN)
                .whileHeld(()-> m_intake.setPoint(m_intake.getPosition()+100, 0, .3))
                .whenReleased(()-> m_intake.setPoint(m_intake.getPosition(), 0, .3));

        //1250 low basket


                /* Elevator Commands */
        subsystemsDriver.getGamepadButton(GamepadKeys.Button.Y)
                .whenPressed(
                        new SequentialCommandGroup(
                                new ParallelCommandGroup(
                                new ElevatorCommand(m_elevator,2100),
                                 new ServoLeaveCommand(m_canasta,m_elevator,1500)),
                                      new SequentialCommandGroup(
                                              new ServoReturnCommand(m_canasta),
                                              new WaitCommand(500),
                                              new ElevatorCommand(m_elevator,0)
                                              )

                              )
                        );


        subsystemsDriver.getGamepadButton(GamepadKeys.Button.B)
                .whenPressed(
                        new SequentialCommandGroup(
                                new ParallelCommandGroup(
                                        new ElevatorCommand(m_elevator,960),
                                        new ServoLeaveCommand(m_canasta,m_elevator,359)),
                                new SequentialCommandGroup(
                                        new WaitCommand(400),
                                        new ServoReturnCommand(m_canasta),
                                        new WaitCommand(500),
                                        new ElevatorCommand(m_elevator,0)
                                )

                        )
                );


        new GamepadButton(subsystemsDriver, GamepadKeys.Button.DPAD_UP)
                .whileHeld(()-> m_intake.setArmPosition(-256))
                .whileHeld(()-> m_elevator.setPosition(400));

        new GamepadButton(subsystemsDriver, GamepadKeys.Button.RIGHT_BUMPER)
                .whileHeld(()-> m_intake.setArmPosition(-256))
                .whileHeld(()-> m_elevator.setPosition(900));
//

        new GamepadButton(subsystemsDriver, GamepadKeys.Button.LEFT_BUMPER)
                .whileHeld(()-> m_intake.setPoint(-305,1, 0.5))
                .whenReleased(()-> m_intake.setPoint(0,0,0.5));



       /* new GamepadButton(gamepadSecond, GamepadKeys.Button.LEFT_BUMPER)
                .whileHeld(()-> intake.agarrar(1))
                .whenReleased(()-> intake.agarrar(0))
                .whenReleased(()->intake.setPosition(-256));*/




        new  GamepadButton(subsystemsDriver, GamepadKeys.Button.DPAD_DOWN)
                .whenPressed(()-> m_canasta.regresar());

        new  GamepadButton(subsystemsDriver, GamepadKeys.Button.DPAD_UP)
                .whenPressed(()-> m_canasta.dejar());



        chassisDriver.getGamepadButton(GamepadKeys.Button.Y)
                .whileHeld(()-> m_escalador.setVelocity(6000))
                .whenReleased(()-> m_escalador.setVelocity(0));

        chassisDriver.getGamepadButton(GamepadKeys.Button.A)
                .whileHeld(()-> m_escalador.setVelocity(-6000))
                .whenReleased(()-> m_escalador.setVelocity(0));



        new  GamepadButton(subsystemsDriver, GamepadKeys.Button.START)
                .whenPressed(()-> m_elevator.resetTicks());


        driveSubsystem.setDefaultCommand(new MecanumDriveCommand(
                driveSubsystem, () -> -chassisDriver.getLeftY(), chassisDriver::getLeftX, chassisDriver::getRightX
        ));

        schedule(new RunCommand(() -> {
            driveSubsystem.update();
            driveSubsystem.updatePoseEstimate();
            telemetry.addData("Heading", driveSubsystem.getPoseEstimate().getHeading());
            telemetry.addData("Position", driveSubsystem.getPoseEstimate());
            telemetry.update();
        }));
    }

    public boolean isJoystickMoving(){
        return Math.abs(chassisDriver.getLeftY()) > 0.1 || Math.abs(chassisDriver.getLeftX()) > 0.1 || Math.abs(chassisDriver.getRightX()) > 0.1;
    }
}
