package org.firstinspires.ftc.teamcode.Trejectories;

import com.acmerobotics.roadrunner.geometry.Pose2d;
import com.acmerobotics.roadrunner.geometry.Vector2d;
import com.acmerobotics.roadrunner.trajectory.Trajectory;

import org.firstinspires.ftc.teamcode.drive.SampleMecanumDrive;

public class RedTrejectories {
  /*  public Trajectory rojoder1(SampleMecanumDrive drive){

        Pose2d firstpose = new Pose2d(-32.37, -64.95, Math.toRadians(90.00));
        drive.setPoseEstimate(firstpose);
        return drive.trajectoryBuilder(firstpose)
                .lineToLinearHeading(new Pose2d(-59.08, -58.50, Math.toRadians(50.00)))
                .build();

    }

    public Trajectory rojoder2(SampleMecanumDrive drive){
       return drive.trajectoryBuilder(new Pose2d(-58.35, -57.91, Math.toRadians(90.00)))
                .lineToLinearHeading(new Pose2d(-41.91, -35.60, Math.toRadians(130.00)))
                .build();



    }

    public  Trajectory rojoder3(SampleMecanumDrive drive){
      return drive.trajectoryBuilder(new Pose2d(-42.20, -35.16, Math.toRadians(90.00)))
                .lineToLinearHeading(new Pose2d(-58.06, -57.76, Math.toRadians(50.00)))
                .build();



    }

    public Trajectory rojoder4 (SampleMecanumDrive drive) {
        return  drive.trajectoryBuilder(new Pose2d(-57.91, -56.59, Math.toRadians(90.00)))
                .lineToLinearHeading(new Pose2d(-59.23, -37.50, Math.toRadians(90.00)))
                .build();


    }

    public  Trajectory rojoder5(SampleMecanumDrive drive){
        return drive.trajectoryBuilder(new Pose2d(-59.96, -37.21, Math.toRadians(90.00)))
                .lineToLinearHeading(new Pose2d(-57.61, -56.59, Math.toRadians(50.00)))
                .build();

    }
    public  Trajectory rojoder6(SampleMecanumDrive drive){
        return drive.trajectoryBuilder(new Pose2d(-57.61, -56.59, Math.toRadians(90.00)))
                .lineToLinearHeading(new Pose2d(-69.50, -37.65, Math.toRadians(90.00)))
                .build();

    }

    public  Trajectory rojoder7(SampleMecanumDrive drive){

        return   drive.trajectoryBuilder(new Pose2d(-69.50, -38.53, Math.toRadians(90.00)))
                .lineToLinearHeading(new Pose2d(-55.85, -57.47, Math.toRadians(50.00)))
                .build();

    }
    public  Trajectory rojoder8(SampleMecanumDrive drive){
        return  drive.trajectoryBuilder(new Pose2d(-56.15, -57.61, Math.toRadians(90.00)))
                .splineTo(new Vector2d(-49.69, -23.85), Math.toRadians(53.51))
                .lineToLinearHeading(new Pose2d(-24.88, -12.70, Math.toRadians(0.00)))
                .build();

    }*/
////////////////////////////////////////////////////////////////////////////////////////////////////
    ///////////////////////////////////////////////////////////////////////////////////////////////
    /////////////////////////////////////////////////////////////////////////////////////////////////

    public  Trajectory reojoiz1(SampleMecanumDrive drive){
        Pose2d firstpose = new Pose2d(-32.51, -64.37, Math.toRadians(90.00));
        drive.setPoseEstimate(firstpose);
        return drive.trajectoryBuilder(firstpose)
                .lineToLinearHeading(new Pose2d(-67.08, -55.61, Math.toRadians(47.00)))
                .build();

        //deja en low basket


    }

    public  Trajectory rojoizq2(SampleMecanumDrive drive){
      return   drive.trajectoryBuilder(new Pose2d(-58, -57, Math.toRadians(90.00)))
                .lineToLinearHeading(new Pose2d(-21, -22.25, Math.toRadians(146.00)))
             // .lineToLinearHeading(new Pose2d(-25, -23, Math.toRadians(145.00)))
                .build();



//va por un sample

    }

    public  Trajectory rojoizq3(SampleMecanumDrive drive){
        return drive.trajectoryBuilder(new Pose2d(-21, -20.25, Math.toRadians(146.00)))
                //.lineToLinearHeading(new Pose2d(-58.64, -57.76, Math.toRadians(47.00)))
                .forward(12.5)
                .build();

//AGARRA EL SAMPLE

    }

    public Trajectory rojoizq4 (SampleMecanumDrive drive) {
    return     drive.trajectoryBuilder(new Pose2d(-58.50, -56.88, Math.toRadians(90.00)))
                .lineToLinearHeading(new Pose2d(-54.24, -35.01, Math.toRadians(130.00)))
                .build();

//vapor otro sample en las marks

    }

    public  Trajectory rojoizq5(SampleMecanumDrive drive){
        return drive.trajectoryBuilder(new Pose2d(-54.09, -34.86, Math.toRadians(90.00)))
                .lineToLinearHeading(new Pose2d(-58.79, -56.88, Math.toRadians(50.00)))
                .build();
        //deja en high basket

    }
    public  Trajectory rojoizq6(SampleMecanumDrive drive){
        return drive.trajectoryBuilder(new Pose2d(-58.50, -56.73, Math.toRadians(90.00)))
                .lineToLinearHeading(new Pose2d(-63.63, -34.86, Math.toRadians(130.00)))
                .build();

        //va por un ultimo sample

    }

    public  Trajectory rojoizq7(SampleMecanumDrive drive){
      return drive.trajectoryBuilder(new Pose2d(-61.87, -35.45, Math.toRadians(90.00)))
                .lineToLinearHeading(new Pose2d(-58.20, -57.76, Math.toRadians(50.00)))
                .build();


    }
    public  Trajectory rojoizq8(SampleMecanumDrive drive){
         return drive.trajectoryBuilder(new Pose2d(-55.85, -54.83, Math.toRadians(50.00)))
                .splineTo(new Vector2d(-23.85, -12.26), Math.toRadians(0.00))
                .build();

    }
}
