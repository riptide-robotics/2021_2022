package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

@Autonomous(name = "SecondAutonomous")
public class SecondAutonomous extends LinearOpMode {

  private DcMotor l;
  private DcMotor r;
  private DcMotor l1;
  private DcMotor r1;

  
  @Override
  public void runOpMode() {
    r = hardwareMap.get(DcMotor.class, "motorTest1");
    l = hardwareMap.get(DcMotor.class, "motorTest2");
    r1 = hardwareMap.get(DcMotor.class, "motorTest3");
    l1 = hardwareMap.get(DcMotor.class, "motorTest4");
    

    
    waitForStart();
    r.setDirection(DcMotor.Direction.REVERSE);
    // autonomous block should be inside the <if>
    if (opModeIsActive()) {
     /*
      l.setPower(-0.5);
      l1.setPower(-0.5);
      r.setPower(-0.5);
      r1.setPower(-0.5);
      sleep(1500);
      l.setPower(0.5);
      l1.setPower(0.5);
      r.setPower(-0.5);
      r1.setPower(-0.5);
      sleep(500);
      l.setPower(-0.5);
      l1.setPower(-0.5);
      r.setPower(-0.5);
      r1.setPower(-0.5);
      sleep(1500);
      l.setPower(0.5);
      l1.setPower(0.5);
      r.setPower(-0.5);
      r1.setPower(-0.5);
      sleep(525);
      l.setPower(-0.5);
      l1.setPower(-0.5);
      r.setPower(-0.5);
      r1.setPower(-0.5);
      sleep(1500);
      l.setPower(0.5);
      l1.setPower(0.5);
      r.setPower(-0.5);
      r1.setPower(-0.5);
      sleep(525);
      l.setPower(-0.5);
      l1.setPower(-0.5);
      r.setPower(-0.5);
      r1.setPower(-0.5);
      sleep(1500);
      l.setPower(0.5);
      l1.setPower(0.5);
      r.setPower(-0.5);
      r1.setPower(-0.5);
      sleep(525);
      */
      double y = -0.5;
      l.setPower(y);
      r1.setPower(y);
      r.setPower(y);
      l1.setPower(y);
      sleep(1000);
      for(int x = 0; x < 74; x++)
      {
        y = y + 0.02;
        sleep(10);
        
      }
      
    }
    // end autonomous stuffs
  }
}
