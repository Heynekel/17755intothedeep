package org.firstinspires.ftc.teamcode.Autonomusthings.Trejectories;

import com.acmerobotics.roadrunner.geometry.Pose2d;
import com.acmerobotics.roadrunner.trajectory.Trajectory;

import org.firstinspires.ftc.teamcode.drive.SampleMecanumDrive;

public class Chambers{

        public Trajectory chamber1(SampleMecanumDrive drive){
            Pose2d firstpose = new Pose2d(-11.18, -67.22, Math.toRadians(270));
            drive.setPoseEstimate(firstpose);
            return drive.trajectoryBuilder(firstpose)
                    .back(60)
                    .build();
//va para dejar en chamber
        }

        public Trajectory chamber2(SampleMecanumDrive drive){
            return drive.trajectoryBuilder(new Pose2d(-11.18, -11.22, Math.toRadians(270)))
                    .lineToLinearHeading(new Pose2d(50.2, -40.89, Math.toRadians(270)))
                    .build();
        }

        public Trajectory chamber3(SampleMecanumDrive drive){
            return drive.trajectoryBuilder(new Pose2d(50.2, -40.89, Math.toRadians(80)))
                    .forward(1)
                    .build();
        }

        public Trajectory chamber4(SampleMecanumDrive drive){
            return drive.trajectoryBuilder(new Pose2d(50.2, -40.89, Math.toRadians(90)))
                    .back(30)
                    .build();
        }

    public Trajectory chamber5(SampleMecanumDrive drive){
        return drive.trajectoryBuilder(new Pose2d(50.2, -70.89, Math.toRadians(90)))
                .forward(30)
                .build();
    }

    public Trajectory chamber6(SampleMecanumDrive drive){
        return drive.trajectoryBuilder(new Pose2d(50.2, -40.89, Math.toRadians(270)))
                .forward(1)
                .build();
    }

    public Trajectory chamber7(SampleMecanumDrive drive){
        return drive.trajectoryBuilder(new Pose2d(50.2, -40.89, Math.toRadians(270)))
                .lineToLinearHeading(new Pose2d(-5.18, -20.22, Math.toRadians(270)))
                .build();
    }


}
