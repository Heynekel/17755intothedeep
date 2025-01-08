package org.firstinspires.ftc.teamcode.Autonomusthings.Trejectories;

import com.acmerobotics.roadrunner.geometry.Pose2d;
import com.acmerobotics.roadrunner.geometry.Vector2d;
import com.acmerobotics.roadrunner.trajectory.Trajectory;

import org.firstinspires.ftc.teamcode.drive.SampleMecanumDrive;

public class RedTrejectories {
    public  Trajectory reojoiz1(SampleMecanumDrive drive){
        Pose2d firstpose = new Pose2d(-8.59, -64.81, Math.toRadians(270));
        drive.setPoseEstimate(firstpose);
        return drive.trajectoryBuilder(firstpose)
               // .back(61)
                 .lineToLinearHeading(new Pose2d(1.7, -13.25, Math.toRadians(270)))
                .build();


//va para dejar en chamber

    }


    public  Trajectory rojoizq3(SampleMecanumDrive drive){
        return drive.trajectoryBuilder(new Pose2d(3, -20, Math.toRadians(270)))
                 .lineToConstantHeading(new Vector2d(-45,-36))//48
                .build();


//va por un sample

    }

    public  Trajectory girar(SampleMecanumDrive drive){
        return   drive.trajectoryBuilder(new Pose2d(-45, -37, Math.toRadians(139)))//139
                .forward(0.001)
                .build();
    }

    public Trajectory rojoizq4 (SampleMecanumDrive drive) {
        return     drive.trajectoryBuilder(new Pose2d(-45,-37, Math.toRadians(139)))//139
                .forward(35)
                .build();

    }//

    public  Trajectory rojoizq5(SampleMecanumDrive drive){
        return drive.trajectoryBuilder(new Pose2d(-58, -33, Math.toRadians(139)))//139
                .lineToLinearHeading(new Pose2d(-108, -63, Math.toRadians(50)))
                .build();


    }

    public  Trajectory rojoford(SampleMecanumDrive drive){
        return drive.trajectoryBuilder(new Pose2d(-104, -61.25, Math.toRadians(50)))//90
                .lineToLinearHeading(new Pose2d(-58, 18, Math.toRadians(50)))
                // .forward(30)
                .build();


    }
    public Trajectory rojoizq12(SampleMecanumDrive drive){
        return drive.trajectoryBuilder(new Pose2d(-94, -43, Math.toRadians(50)))
                .splineTo(new Vector2d(-55, 18), Math.toRadians(50))
                .build();

    }



    public  Trajectory girar2(SampleMecanumDrive drive){
        return drive.trajectoryBuilder(new Pose2d(-55, 18, Math.toRadians(270)))
                .forward(0.01)
                .build();


    }

    public  Trajectory girarfinal(SampleMecanumDrive drive){
        return drive.trajectoryBuilder(new Pose2d(-55, 18, Math.toRadians(270)))
                .forward(0.01)
                .build();


    }
    public  Trajectory rojoizq8(SampleMecanumDrive drive){
        return drive.trajectoryBuilder(new Pose2d(-52.18, -32.95, Math.toRadians(90.00)))
                .lineToLinearHeading(new Pose2d(-60.11, -57.32, Math.toRadians(50.00)))
                .build();

        //va a dejar a basket


    }

    public Trajectory rojoizq9(SampleMecanumDrive drive){
        return  drive.trajectoryBuilder(new Pose2d(-59.82, -57.03, Math.toRadians(90.00)))
                .lineToLinearHeading(new Pose2d(-60.11, -31.49, Math.toRadians(150.00)))
                .build();

    }
    public Trajectory rojoizq10(SampleMecanumDrive drive){
        return  drive.trajectoryBuilder(new Pose2d(-60.11, -31.49, Math.toRadians(150.00)))
                .forward(15)
                .build();
    }
    public Trajectory rojoizq11(SampleMecanumDrive drive){
        return drive.trajectoryBuilder(new Pose2d(-60.11, -31.05, Math.toRadians(90.00)))
                .lineToLinearHeading(new Pose2d(-58.94, -58.20, Math.toRadians(50.00)))
                .build();

    }



}
