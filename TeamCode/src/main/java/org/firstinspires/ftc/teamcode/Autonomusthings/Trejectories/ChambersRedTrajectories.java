package org.firstinspires.ftc.teamcode.Autonomusthings.Trejectories;

import com.acmerobotics.roadrunner.geometry.Pose2d;
import com.acmerobotics.roadrunner.geometry.Vector2d;
import com.acmerobotics.roadrunner.trajectory.Trajectory;

import org.firstinspires.ftc.teamcode.drive.SampleMecanumDrive;

public class ChambersRedTrajectories {

    public Trajectory chamber1(SampleMecanumDrive drive){
        Pose2d firstpose = new Pose2d(-11.18, -67.22, Math.toRadians(270));
        drive.setPoseEstimate(firstpose);
        return drive.trajectoryBuilder(firstpose)
                .back(52.5)
                .build();
//va para dejar en chamber
    }
    public Trajectory chamber2(SampleMecanumDrive drive){
        return drive.trajectoryBuilder(new Pose2d(-11.18, -17, Math.toRadians(270)))
                .lineToLinearHeading(new Pose2d(55.2, -40.89, Math.toRadians(270)))
                .build();
    }
//
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
        return drive.trajectoryBuilder(new Pose2d(55.2, -70, Math.toRadians(270)))//y:40
                .lineToConstantHeading(new Vector2d(-28, -70))
               // .lineToLinearHeading(new Pose2d(-28, -12, Math.toRadians(270)))
                // .forward(10)
                .build();
    }

    public Trajectory chamber6(SampleMecanumDrive drive){
        return drive.trajectoryBuilder(new Pose2d(-28, -70, Math.toRadians(270)))//y:40
                .forward(1)
                .build();
    }

    public Trajectory chamber7(SampleMecanumDrive drive){
        return drive.trajectoryBuilder(new Pose2d(-28.2, -70, Math.toRadians(270)))//y:40
                .lineToLinearHeading(new Pose2d(-28, -12, Math.toRadians(270)))
                .build();
    }

    public Trajectory chamber8(SampleMecanumDrive drive){
        return  drive.trajectoryBuilder(new Pose2d(-35, -18, Math.toRadians(270)))
                .lineToLinearHeading(new Pose2d(65, -61, Math.toRadians(270)))
                .build();    }

}

