package org.firstinspires.ftc.teamcode.Autonomusthings.Trejectories;

import com.acmerobotics.roadrunner.geometry.Pose2d;
import com.acmerobotics.roadrunner.geometry.Vector2d;
import com.acmerobotics.roadrunner.trajectory.Trajectory;

import org.firstinspires.ftc.teamcode.drive.SampleMecanumDrive;
//Ready
public class ChambersBlueTrajectories {

    public Trajectory chamber1(SampleMecanumDrive drive){
        Pose2d firstpose = new Pose2d(-11.18, -67.22, Math.toRadians(270));
        drive.setPoseEstimate(firstpose);
        return drive.trajectoryBuilder(firstpose)
                .back(55)
                .build();
//va para dejar en chamber
    }
    public Trajectory chamber2(SampleMecanumDrive drive){
        return drive.trajectoryBuilder(new Pose2d(-11.18, -17, Math.toRadians(270)))
                .lineToLinearHeading(new Pose2d(65, -40.89, Math.toRadians(270)))
                .build();
    }
//
    public Trajectory chamber3(SampleMecanumDrive drive){
        return drive.trajectoryBuilder(new Pose2d(65, -40.89, Math.toRadians(90)))
                .forward(1)
                .build();
    }

    public Trajectory chamber4(SampleMecanumDrive drive){
        return drive.trajectoryBuilder(new Pose2d(65, -40.89, Math.toRadians(90)))
                .back(42)
                .build();
    }

    public Trajectory chamber5(SampleMecanumDrive drive){
        return drive.trajectoryBuilder(new Pose2d(65, -70, Math.toRadians(90)))//y:40 //270 angulo
                .lineToConstantHeading(new Vector2d(-28, -65))
               // .lineToLinearHeading(new Pose2d(-28, -12, Math.toRadians(270)))
                // .forward(10)
                .build();
    }

    public Trajectory chamber6(SampleMecanumDrive drive){
        return drive.trajectoryBuilder(new Pose2d(-28, -65, Math.toRadians(270)))//y:40
                .forward(1)
                .build();
    }

    public Trajectory chamber7(SampleMecanumDrive drive){
        return drive.trajectoryBuilder(new Pose2d(-28.2, -65, Math.toRadians(270)))//y:40
                .lineToLinearHeading(new Pose2d(-28, -20, Math.toRadians(270)))
                .build();
    }


    public Trajectory gotosample(SampleMecanumDrive drive){
        return  drive.trajectoryBuilder(new Pose2d(-10, -65, Math.toRadians(270)))
                .lineToLinearHeading(new Pose2d(49, -40, Math.toRadians(270)))
                .build();
    }
    public Trajectory gotosample2(SampleMecanumDrive drive){
        return  drive.trajectoryBuilder(new Pose2d(49, -40, Math.toRadians(270)))
                .lineToLinearHeading(new Pose2d(49, 23, Math.toRadians(270)))
                // .forward(0.01)
                .build();
    }
    public Trajectory gotosample3(SampleMecanumDrive drive){
        return  drive.trajectoryBuilder(new Pose2d(51, 23, Math.toRadians(270)))
                .lineToLinearHeading(new Pose2d(67, 23, Math.toRadians(270)))
                // .forward(0.01)
                .build();
    }
    public Trajectory chamber8(SampleMecanumDrive drive){
        return  drive.trajectoryBuilder(new Pose2d(72, 20, Math.toRadians(270)))
                .lineToLinearHeading(new Pose2d(72, -62, Math.toRadians(270)))
                .build();    }

    public Trajectory gotosample4(SampleMecanumDrive drive){
        return  drive.trajectoryBuilder(new Pose2d(72, -62, Math.toRadians(270)))
                .lineToLinearHeading(new Pose2d(72, 23, Math.toRadians(270)))
                // .forward(0.01)
                .build();
    }
    public Trajectory gotosample5(SampleMecanumDrive drive){
        return  drive.trajectoryBuilder(new Pose2d(75, 23, Math.toRadians(270)))
                .lineToLinearHeading(new Pose2d(89, 18, Math.toRadians(270)))
                // .forward(0.01)
                .build();
    }
    public Trajectory gotosample6(SampleMecanumDrive drive){
        return  drive.trajectoryBuilder(new Pose2d(89, 18, Math.toRadians(270)))
                .lineToLinearHeading(new Pose2d(92, -60, Math.toRadians(270)))
                // .forward(0.01)
                .build();
    }


}

