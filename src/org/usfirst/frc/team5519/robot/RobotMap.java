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
	
	// Edmond D. 1/27/2017
	// Added the shooterHigh and shooterLow port, as well as the intake and to stop.
	public static final int kFrontLeftMotorPort = 1;	// Need to find and set correct port
	public static final int kRearLeftMotorPort = 2;		// Need to find and set correct port
	public static final int kFrontRightMotorPort = 3;	// Need to find and set correct port
	public static final int kRearRightMotorPort = 4;	// Need to find and set correct port
	public static final int kShooterHighPort = 5;       // Need to find and set correct port
	public static final int kShooterLowPort = 6;        // Need to find and set correct port
	public static final int kShooterStopPort = 7;       // Need to find and set correct port
	public static final int kIntakeMotorPort = 8;       // Need to find and set correct port
	
	public static Talon frontLeftMotor;
	public static Talon rearLeftMotor;
	public static Talon frontRightMotor;
	public static Talon rearRightMotor;
	public static Talon shooterMotor;
	public static Talon IntakeMotor;
	public static Talon ShooterHighMotor;
	public static Talon ShooterLowMotor;
	public static Talon ShooterStopMotor;
	
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
		
		//Edmond D. 1/27/2017
		//This is the functions for the shooter's high motor.
		ShooterHighMotor = new Talon(kShooterHighPort);
		
		//Functions for the shooter's low motor.
		ShooterLowMotor = new Talon (kShooterLowPort);
		
		//Functions for stopping the shooter.
		ShooterStopMotor = new Talon (kShooterStopPort);
		
		// This is where the intake motor will go under.
		IntakeMotor = new Talon(kIntakeMotorPort);
	}
}
