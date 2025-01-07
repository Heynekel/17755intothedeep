package org.firstinspires.ftc.teamcode.Autonomusthings.Trejectories;

import com.acmerobotics.roadrunner.geometry.Pose2d;
import com.acmerobotics.roadrunner.trajectory.Trajectory;

import org.firstinspires.ftc.teamcode.drive.SampleMecanumDrive;

public class ChambersRedTrajectories {

    public Trajectory chamber1(SampleMecanumDrive drive){
        Pose2d firstpose = new Pose2d(-11.18, -67.22, Math.toRadians(270));
        drive.setPoseEstimate(firstpose);
        return drive.trajectoryBuilder(firstpose)
                .back(54)
                .build();
//va para dejar en chamber
    }
    public Trajectory chamber2(SampleMecanumDrive drive){
        return drive.trajectoryBuilder(new Pose2d(-11.18, -11.22, Math.toRadians(270)))
                .lineToLinearHeading(new Pose2d(55.2, -40.89, Math.toRadians(270)))
                .build();
    }

    public Trajectory chamber3(SampleMecanumDrive drive){
        return drive.trajectoryBuilder(new Pose2d(55.2, -40.89, Math.toRadians(90)))
                .forward(1)
                .build();
    }

    public Trajectory chamber4(SampleMecanumDrive drive){
        return drive.trajectoryBuilder(new Pose2d(55.2, -40.89, Math.toRadians(90)))
                .back(40)
                .build();
    }

    public Trajectory chamber5(SampleMecanumDrive drive){
        return drive.trajectoryBuilder(new Pose2d(55.2, -70.89, Math.toRadians(90)))
                .forward(20)
                .build();
    }

    public Trajectory chamber6(SampleMecanumDrive drive){
        return drive.trajectoryBuilder(new Pose2d(55.2, -53, Math.toRadians(270)))//y:40
                .forward(1)
                .build();
    }

    public Trajectory chamber7(SampleMecanumDrive drive){
        return drive.trajectoryBuilder(new Pose2d(55.2, -57, Math.toRadians(270)))//y:40
                .lineToLinearHeading(new Pose2d(-30, -12.5, Math.toRadians(270)))
                .build();
    }

    public Trajectory chamber8(SampleMecanumDrive drive){
        return  drive.trajectoryBuilder(new Pose2d(-35, -18, Math.toRadians(270)))
                .lineToLinearHeading(new Pose2d(65, -61, Math.toRadians(270)))
                .build();    }


}

