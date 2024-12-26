package org.firstinspires.ftc.teamcode.Trejectories;

import com.acmerobotics.roadrunner.geometry.Pose2d;
import com.acmerobotics.roadrunner.geometry.Vector2d;
import com.acmerobotics.roadrunner.trajectory.Trajectory;

import org.firstinspires.ftc.teamcode.drive.SampleMecanumDrive;

public class RedTrejectories {

    public  Trajectory reojoiz1(SampleMecanumDrive drive){
        Pose2d firstpose = new Pose2d(-8.59, -64.81, Math.toRadians(-90.00));
        drive.setPoseEstimate(firstpose);
        return drive.trajectoryBuilder(firstpose)
                .lineToLinearHeading(new Pose2d(2, -3.7, Math.toRadians(-90.00)))
                .build();


//va para dejar en chamber


    }

    public  Trajectory rojoizq2(SampleMecanumDrive drive){
      return   drive.trajectoryBuilder(new Pose2d(-4.33, -6, Math.toRadians(-90.00)))
              .forward(-5)
              .build();



//asegura el especimen

    }

    public  Trajectory rojoizq3(SampleMecanumDrive drive){
       return drive.trajectoryBuilder(new Pose2d(-4.77, -31.93, Math.toRadians(130.00)))
                .splineTo(new Vector2d(-48, -28), Math.toRadians(130.00))
                .build();



//va por un sample

    }

    public Trajectory rojoizq4 (SampleMecanumDrive drive) {
    return     drive.trajectoryBuilder(new Pose2d(-48,-28, Math.toRadians(130)))
            .forward(25)
            .build();



    }

    public  Trajectory rojoizq5(SampleMecanumDrive drive){
       return drive.trajectoryBuilder(new Pose2d(-40.29, -36.48, Math.toRadians(90.00)))
                .lineToLinearHeading(new Pose2d(-107.7, -45.9, Math.toRadians(50.00)))
                .build();


    }

    public  Trajectory rojoizq6(SampleMecanumDrive drive){
return drive.trajectoryBuilder(new Pose2d(-60.40, -57.17, Math.toRadians(50.00)))
                .lineToLinearHeading(new Pose2d(-52.04, -33.69, Math.toRadians(130.00)))
                .build();


    }

    public  Trajectory rojoizq7(SampleMecanumDrive drive){
      return drive.trajectoryBuilder(new Pose2d(-61.87, -35.45, Math.toRadians(90.00)))
              .forward(15)
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
    public Trajectory rojoizq12(SampleMecanumDrive drive){
       return drive.trajectoryBuilder(new Pose2d(-58.64, -58.20, Math.toRadians(90.00)))
                .splineTo(new Vector2d(-22.53, -12.26), Math.toRadians(0.00))
                .build();

    }



}
