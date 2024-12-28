package org.firstinspires.ftc.teamcode.Autonomusthings.Trejectories;

import com.acmerobotics.roadrunner.geometry.Pose2d;
import com.acmerobotics.roadrunner.geometry.Vector2d;
import com.acmerobotics.roadrunner.trajectory.Trajectory;

import org.firstinspires.ftc.teamcode.drive.SampleMecanumDrive;

public class BlueTrejectories {
    public Trajectory azulizq1(SampleMecanumDrive drive) {

        Pose2d firstPose = new Pose2d(9.47, 68.77, Math.toRadians(90.00));
        drive.setPoseEstimate(firstPose);
        return drive.trajectoryBuilder(new Pose2d(9.4, 68.77, Math.toRadians(90.00)))
                .lineToLinearHeading(new Pose2d(4.62, 31.63, Math.toRadians(90.00)))
                .build();

        //va al chamber
    }

   public Trajectory azulizq2(SampleMecanumDrive drive){
       return  drive.trajectoryBuilder(new Pose2d(7.27, 37.21, Math.toRadians(90.00)))
               .lineToLinearHeading(new Pose2d(39.27, 36.18, Math.toRadians(320.00)))
               .build();

       //va por un sample
   }

   public Trajectory azulizq4 (SampleMecanumDrive drive){

       return drive.trajectoryBuilder(new Pose2d(40.73, 40.73, Math.toRadians(-130.00)))
               .splineToLinearHeading(new Pose2d(58.79, 57.32, Math.toRadians(-130.00)), Math.toRadians(48.12))
               .build();

       //se dirije hacia las baskets
   }

   public Trajectory azulizq3(SampleMecanumDrive  drive){
       return  drive.trajectoryBuilder(new Pose2d(39.27, 36.18, Math.toRadians(320.00)))
               .forward(20)
               .build();
//avanza un poco para agarrar bien el sample

   }
    public Trajectory azulizq5(SampleMecanumDrive  drive){
        return drive.trajectoryBuilder(new Pose2d(59.08, 57.47, Math.toRadians(270.00)))
                .lineToLinearHeading(new Pose2d(52.33, 35.01, Math.toRadians(310.00)))
                .build();
//va por otro sample

    }
    public Trajectory azulizq6(SampleMecanumDrive  drive){
        return drive.trajectoryBuilder(new Pose2d(52.33, 35.01, Math.toRadians(310.00)))
                .forward(20)
                .build();
  //asegura el sample

    }
    public Trajectory azulizq7(SampleMecanumDrive  drive){

       return drive.trajectoryBuilder(new Pose2d(53.50, 39.41, Math.toRadians(310.00)))
                .lineToLinearHeading(new Pose2d(59.23, 57.32, Math.toRadians(230.00)))
                .build();
//se dirije a las baskets

    }
    public Trajectory azulizq8(SampleMecanumDrive  drive){
       return drive.trajectoryBuilder(new Pose2d(53.50, 39.41, Math.toRadians(310.00)))
                .lineToLinearHeading(new Pose2d(59.23, 57.32, Math.toRadians(230.00)))
                .build();
       //va por otro sample

    }

    public Trajectory azulizq9(SampleMecanumDrive  drive){
        return drive.trajectoryBuilder(new Pose2d(53.50, 39.41, Math.toRadians(310.00)))
                .forward(10)
                .build();

        //asegura el sample
    }
    public Trajectory azulizq10(SampleMecanumDrive  drive){


       return drive.trajectoryBuilder(new Pose2d(59.38, 38.09, Math.toRadians(-90.00)))
                .lineToLinearHeading(new Pose2d(59.67, 58.06, Math.toRadians(230.00)))
                .build();
//va hacia las baskets
    }
    public Trajectory azulizq11(SampleMecanumDrive  drive){

      return drive.trajectoryBuilder(new Pose2d(59.23, 58.06, Math.toRadians(270.00)))
                .splineTo(new Vector2d(22.53, 9.76), Math.toRadians(180.00))
                .build();
//va a estacionarse

    }





}
