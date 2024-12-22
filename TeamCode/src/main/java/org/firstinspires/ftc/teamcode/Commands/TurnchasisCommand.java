package org.firstinspires.ftc.teamcode.Commands;

import com.arcrobotics.ftclib.command.CommandBase;
import com.arcrobotics.ftclib.gamepad.GamepadEx;

import org.firstinspires.ftc.teamcode.Subsystem.MecanumDriveSubsystem;
import org.firstinspires.ftc.teamcode.drive.SampleMecanumDrive;

public class TurnchasisCommand extends CommandBase {
    MecanumDriveSubsystem mecanumDriveSubsystem;
    SampleMecanumDrive sampleMecanumDrive;
    GamepadEx gamepadEx;

    public TurnchasisCommand(MecanumDriveSubsystem mecanumDriveSubsystem,GamepadEx gamepadEx, SampleMecanumDrive sampleMecanumDrive){

        this.gamepadEx = gamepadEx;
        this.sampleMecanumDrive  = sampleMecanumDrive;
        this.mecanumDriveSubsystem = mecanumDriveSubsystem;

        addRequirements(mecanumDriveSubsystem);
    }

    @Override

    public void execute(){
        mecanumDriveSubsystem.turn(Math.PI);
    }
}
