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
        Pose2d firstpose = new Pose2d(-8.59, -64.81, Math.toRadians(-90.00));
        drive.setPoseEstimate(firstpose);
        return drive.trajectoryBuilder(firstpose)
                .lineToLinearHeading(new Pose2d(-4.33, -10, Math.toRadians(-90.00)))
                .build();


//va para dejar en chamber


    }

    public  Trajectory rojoizq2(SampleMecanumDrive drive){
      return   drive.trajectoryBuilder(new Pose2d(-4.33, -10, Math.toRadians(-90.00)))
              .forward(-5)
              .build();



//asegura el especimen

    }

    public  Trajectory rojoizq3(SampleMecanumDrive drive){
       return drive.trajectoryBuilder(new Pose2d(-4.77, -31.93, Math.toRadians(-90.00)))
                .splineTo(new Vector2d(-50, -28.62), Math.toRadians(130.00))
                .build();


//va por un sample

    }

    public Trajectory rojoizq4 (SampleMecanumDrive drive) {
    return     drive.trajectoryBuilder(new Pose2d(-50, -28, Math.toRadians(130)))
            .forward(15)
            .build();



    }

    public  Trajectory rojoizq5(SampleMecanumDrive drive){
       return drive.trajectoryBuilder(new Pose2d(-40.29, -36.48, Math.toRadians(90.00)))
                .lineToLinearHeading(new Pose2d(-108.79, -54.76, Math.toRadians(50.00)))
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
