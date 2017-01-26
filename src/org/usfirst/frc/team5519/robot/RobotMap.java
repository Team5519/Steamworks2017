package org.usfirst.frc.team5519.robot;

import edu.wpi.first.wpilibj.PWMSpeedController;
import edu.wpi.first.wpilibj.Talon;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
	
	public static boolean isLouise = true;
	
	// CY 1/16/2017
	// Started development on shooter motor.
	public static int kFrontLeftMotorPort;
	public static int kRearLeftMotorPort;	
	public static int kFrontRightMotorPort;
	public static int kRearRightMotorPort;
	public static int kShooterMotorPort;
	public static int kIntakeMotorPort;
	
	public static PWMSpeedController frontLeftMotor;
	public static PWMSpeedController rearLeftMotor;
	public static PWMSpeedController frontRightMotor;
	public static PWMSpeedController rearRightMotor;
	public static PWMSpeedController shooterMotor;
	public static PWMSpeedController IntakeMotor;
	
	public static void init() {
		
		if (isLouise) {
			// Assign definitions for LOUISE (Test Bot)
			kFrontLeftMotorPort = 1;	
			kRearLeftMotorPort = 2;		
			kFrontRightMotorPort = 3;	
			kRearRightMotorPort = 4;	
			kShooterMotorPort = 5;		
			kIntakeMotorPort = 6;  
			
			frontLeftMotor = new Talon(kFrontLeftMotorPort);
			rearLeftMotor = new Talon(kRearLeftMotorPort);
			frontRightMotor = new Talon(kFrontRightMotorPort);
			rearRightMotor = new Talon(kRearRightMotorPort);
			
			shooterMotor = new Talon(kShooterMotorPort);
			IntakeMotor = new Talon(kIntakeMotorPort);
			
		} else {
			// Assign definitions for ARBOUR (Competition Bot)
			kFrontLeftMotorPort = 1;	
			kRearLeftMotorPort = 2;		
			kFrontRightMotorPort = 3;	
			kRearRightMotorPort = 4;	
			kShooterMotorPort = 5;		
			kIntakeMotorPort = 6;  
			
			frontLeftMotor = new Talon(kFrontLeftMotorPort);
			rearLeftMotor = new Talon(kRearLeftMotorPort);
			frontRightMotor = new Talon(kFrontRightMotorPort);
			rearRightMotor = new Talon(kRearRightMotorPort);
			
			shooterMotor = new Talon(kShooterMotorPort);
			IntakeMotor = new Talon(kShooterMotorPort);
			
		}

		// CY 1/17/2017
		// Motors for left
		frontLeftMotor.enableDeadbandElimination(true);
		rearLeftMotor.enableDeadbandElimination(true);
		frontRightMotor.enableDeadbandElimination(true);
		rearRightMotor.enableDeadbandElimination(true);
			
	}
}
