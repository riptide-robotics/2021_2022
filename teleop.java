

package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.util.Range;
// blah blah blah



@TeleOp(name="workingTankDrive", group="Linear Opmode")
// decorator so the robot knows what mode to operate in 
public class MestingOnBot extends LinearOpMode {

    // Declare teleOp members.
    private ElapsedTime runtime = new ElapsedTime();
    private DcMotor leftDrive = null;
    private DcMotor rightDrive = null;
    private boolean x  = false;
    private DcMotor leftDrive1 = null;
    private DcMotor rightDrive1 = null;
    private DcMotor intake = null;

    @Override
    // related to inheritance: runOpMode is a necessary function as you NEED to override the runOpMode in the superclass
    public void runOpMode() {
        //System.out on the phones = telemetry
        telemetry.addData("Status", "Initialized");
        telemetry.update();

        
        leftDrive  = hardwareMap.get(DcMotor.class, "motorTest1");
        leftDrive1  = hardwareMap.get(DcMotor.class, "motorTest3");
        rightDrive = hardwareMap.get(DcMotor.class, "motorTest2");
        rightDrive1 = hardwareMap.get(DcMotor.class, "motorTest4");
        intake = hardwareMap.get(DcMotor.class, "intakeMotor");

        
        leftDrive.setDirection(DcMotor.Direction.FORWARD);
        rightDrive.setDirection(DcMotor.Direction.REVERSE);

        // only run when on lol
        waitForStart();
        runtime.reset();
        double leftPower;
        double rightPower;
        // while running
        while (opModeIsActive()) {

            // leftPower = gamePad y values
            leftPower = gamepad1.left_stick_y;
            rightPower = gamepad1.right_stick_y;
            // NOTE: X VALUE ON THE CONTROLLER IS IGNORED
        
            // power to wheels
            rightDrive1.setPower(0.35 * rightPower);
            rightDrive.setPower(0.35 * rightPower);
            leftDrive.setPower(0.35 * leftPower);
            leftDrive1.setPower(0.35 * leftPower);
            if (gamepad1.a)
            {
                intake.setPower(0.75);
            }
            
            

            // Show the elapsed game time and wheel power.
            telemetry.addData("Status", "Run Time: " + runtime.toString());
            if (gamepad1.right_stick_y != 0)
            {
                x = true;
            }
            else 
            {
                x = false;
            }
            telemetry.addData("input", x);
            
            telemetry.addData("Motors", "left (%.2f), right (%.2f)", leftPower, rightPower);
            telemetry.update();
        }
    }
}
