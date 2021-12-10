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
public class TankDrive extends LinearOpMode {

    // Declare teleOp members.
    private ElapsedTime runtime = new ElapsedTime();
    private DcMotor leftDrive = null;
    private DcMotor rightDrive = null;
    private boolean x  = false;
    private DcMotor leftDrive1 = null;
    private DcMotor rightDrive1 = null;
    private DcMotor intake = null;
    private DcMotor arm = null;
    private DcMotor spinner = null;

    @Override
    // related to inheritance: runOpMode is a necessary function as you NEED to override the runOpMode in the superclass
    public void runOpMode() {
        //System.out on the phones = telemetry
        telemetry.addData("Status", "Initialized");
        telemetry.update();

        
        leftDrive  = hardwareMap.get(DcMotor.class, "motor1");
        leftDrive1  = hardwareMap.get(DcMotor.class, "motor2");
        rightDrive = hardwareMap.get(DcMotor.class, "motor3");
        rightDrive1 = hardwareMap.get(DcMotor.class, "motor4");
        arm = hardwareMap.get(DcMotor.class, "motor6");
        spinner = hardwareMap.get(DcMotor.class, "motor5");

        
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
            rightDrive1.setPower(0.7 * rightPower);
            rightDrive.setPower(0.7 * rightPower);
            leftDrive.setPower(0.7 * leftPower);
            leftDrive1.setPower(0.7 * leftPower);
            if (gamepad1.a)
            {
                spinner.setPower(0.75);
            }
            if (gamepad1.b)
            {
                spinner.setPower(-0.75);
            }
            if (!gamepad1.a && !gamepad1.b)
            {
                spinner.setPower(0);
            }
            
            if (gamepad1.dpad_up)
            {
                arm.setPower(-1);
            }
            if (gamepad1.dpad_down)
            {
                arm.setPower(0.2);
            }
            if (!gamepad1.dpad_down && !gamepad1.dpad_up)
            {
                arm.setPower(-0.01);
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
