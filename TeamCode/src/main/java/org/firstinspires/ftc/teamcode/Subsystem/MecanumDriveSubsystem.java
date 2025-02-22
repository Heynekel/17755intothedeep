package org.firstinspires.ftc.teamcode.Subsystem;

import com.acmerobotics.roadrunner.geometry.Pose2d;
import com.acmerobotics.roadrunner.geometry.Vector2d;
import com.acmerobotics.roadrunner.localization.Localizer;
import com.acmerobotics.roadrunner.trajectory.Trajectory;
import com.acmerobotics.roadrunner.trajectory.TrajectoryBuilder;
import com.arcrobotics.ftclib.command.Command;
import com.arcrobotics.ftclib.command.SubsystemBase;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.PIDFCoefficients;

import org.firstinspires.ftc.teamcode.drive.SampleMecanumDrive;

import java.util.List;

public class MecanumDriveSubsystem extends SubsystemBase {
    private final SampleMecanumDrive drive;
    private final boolean fieldCentric;
    private boolean isInverted = true;
    private final boolean isRedAlliance;


    public MecanumDriveSubsystem(SampleMecanumDrive drive, boolean isFieldCentric, boolean isRedAlliance) {
        this.drive = drive;
        fieldCentric = isFieldCentric;
        this.isRedAlliance = isRedAlliance;

    }

    public void setMode(DcMotor.RunMode mode) {
        drive.setMode(mode);
    }

    public void setPIDFCoefficients(DcMotor.RunMode mode, PIDFCoefficients coefficients) {
        drive.setPIDFCoefficients(mode, coefficients);
    }

    public void toggleInverted(){
        this.isInverted = !isInverted;
    }

    public void setPoseEstimate(Pose2d pose) {
        drive.setPoseEstimate(pose);
    }

    public SampleMecanumDrive getDrive() {
        return drive;
    }

    public void update() {
        drive.update();
    }

    public void updatePoseEstimate() {
        drive.updatePoseEstimate();
    }

    public boolean isOverCurrent(){

        return drive.isOverCurrent();

    }
    public void drive(double leftY, double leftX, double rightX) {
        Pose2d poseEstimate = getPoseEstimate();

        Vector2d input;
        if(!isRedAlliance) {
            input = new Vector2d(-leftY, -leftX).rotated(
                    fieldCentric ? -poseEstimate.getHeading() + 3.506 : 0
            );
        }else{
            input = new Vector2d(-leftY, -leftX).rotated(
                    fieldCentric ? -poseEstimate.getHeading() +3.14159 + 1.570795 : 0
            );
        }

        drive.setWeightedDrivePower(
                new Pose2d(
                        isInverted ? input.getX() : -input.getX(),
                        isInverted ? input.getY() : -input.getY(),
                        //input.getX(),
                        //input.getY(),
                        -rightX
                )
        );
    }

    public void setDrivePower(Pose2d drivePower) {
        drive.setDrivePower(drivePower);
    }

    public Pose2d getPoseEstimate() {
        return drive.getPoseEstimate().times(67.07/60.25);
    }

    public TrajectoryBuilder trajectoryBuilder(Pose2d startPose) {
        return drive.trajectoryBuilder(startPose);
    }

    public TrajectoryBuilder trajectoryBuilder(Pose2d startPose, boolean reversed) {
        return drive.trajectoryBuilder(startPose, reversed);
    }

    public TrajectoryBuilder trajectoryBuilder(Pose2d startPose, double startHeading) {
        return drive.trajectoryBuilder(startPose, startHeading);
    }

    public void followTrajectory(Trajectory trajectory) {
        drive.followTrajectoryAsync(trajectory);
    }

    public boolean isBusy() {
        return drive.isBusy();
    }

    public void turn(double radians) {
        drive.turnAsync(radians);
    }

    public List<Double> getWheelVelocities() {
        return drive.getWheelVelocities();
    }

    public void stop() {
        drive(0, 0, 0);
    }

    public Pose2d getPoseVelocity() {
        return drive.getPoseVelocity();
    }

    public Localizer getLocalizer() {
        return drive.getLocalizer();
    }

}
