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
                 .lineToLinearHeading(new Pose2d(1.7, -12, Math.toRadians(270)))
                .build();


//va para dejar en chamber

    }


    public  Trajectory rojoizq3(SampleMecanumDrive drive){
        return drive.trajectoryBuilder(new Pose2d(3, -17, Math.toRadians(270)))
                 .lineToConstantHeading(new Vector2d(-48,-39))//48
                .build();


//va por un sample

    }

    public  Trajectory girar(SampleMecanumDrive drive){
        return   drive.trajectoryBuilder(new Pose2d(-48, -39, Math.toRadians(140)))
                .forward(0.001)
                .build();
    }

    public Trajectory rojoizq4 (SampleMecanumDrive drive) {
        return     drive.trajectoryBuilder(new Pose2d(-48,-39, Math.toRadians(140)))
                .forward(30)
                .build();

    }//

    public  Trajectory rojoizq5(SampleMecanumDrive drive){
        return drive.trajectoryBuilder(new Pose2d(-58, -33, Math.toRadians(140)))//90
                .lineToLinearHeading(new Pose2d(-104, -58, Math.toRadians(50)))
                .build();


    }

    public  Trajectory rojoford(SampleMecanumDrive drive){
        return drive.trajectoryBuilder(new Pose2d(-118, -61.25, Math.toRadians(50)))//90
                .forward(30)
                .build();


    }



    public  Trajectory rojoizq6(SampleMecanumDrive drive){
        return drive.trajectoryBuilder(new Pose2d(-60.40, -57.17, Math.toRadians(50)))
                .lineToLinearHeading(new Pose2d(-55, -33, Math.toRadians(130)))
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
        return drive.trajectoryBuilder(new Pose2d(-58.64, -58.20, Math.toRadians(50)))
                .splineTo(new Vector2d(-57, -6), Math.toRadians(270))
                .build();

    }


}
