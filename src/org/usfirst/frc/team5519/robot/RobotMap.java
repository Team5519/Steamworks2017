package org.usfirst.frc.team5519.robot;

import edu.wpi.first.wpilibj.Talon;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
	// For example to map the left and right motors, you could define the
	// following variables to use with your drivetrain subsystem.
	// public static int leftMotor = 1;
	// public static int rightMotor = 2;

	// If you are using multiple modules, make sure to define both the port
	// number and the module. For example you with a rangefinder:
	// public static int rangefinderPort = 1;
	// public static int rangefinderModule = 1;
	
	// CY 1/16/2017
	// Started development on shooter motor.
	public static final int kFrontLeftMotorPort = 1;	// Need to find and set correct port
	public static final int kRearLeftMotorPort = 2;		// Need to find and set correct port
	public static final int kFrontRightMotorPort = 3;	// Need to find and set correct port
	public static final int kRearRightMotorPort = 4;	// Need to find and set correct port
	public static final int kShooterMotorPort = 5;		// Need to find and set correct port
	
	public static Talon frontLeftMotor;
	public static Talon rearLeftMotor;
	public static Talon frontRightMotor;
	public static Talon rearRightMotor;
	public static Talon shooterMotor;
	
	public static void init() {

		// CY 1/17/2017
		// HYPERDRIVE ON FULL POWER!!!
		// Remember to set front AND rear to the same value
		
		// Motors for left
		frontLeftMotor = new Talon(kFrontLeftMotorPort);
		frontLeftMotor.enableDeadbandElimination(true);
			frontLeftMotor.set(1.0);
			
		rearLeftMotor = new Talon(kRearLeftMotorPort);
		rearLeftMotor.enableDeadbandElimination(true);
			rearLeftMotor.set(1.0);
			
		// Motor for right
		frontRightMotor = new Talon(kFrontRightMotorPort);
		frontRightMotor.enableDeadbandElimination(true);
			frontRightMotor.set(0.6);
			
		rearRightMotor = new Talon(kRearRightMotorPort);
		rearRightMotor.enableDeadbandElimination(true);
			rearRightMotor.set(0.6);
		
		// There is where the robot functions motor code is.
		shooterMotor = new Talon(kShooterMotorPort);
	}
}
