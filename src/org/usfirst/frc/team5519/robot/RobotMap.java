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
	public static int kShooterMotorPort1;
	public static int kShooterMotorPort2;
	public static int kShooterMotorPort3;
	public static int kIntakeMotorPort;
	
	public static PWMSpeedController frontLeftMotor;
	public static PWMSpeedController rearLeftMotor;
	public static PWMSpeedController frontRightMotor;
	public static PWMSpeedController rearRightMotor;
	public static PWMSpeedController shooterMotor;
	public static PWMSpeedController shooterMotor1;
	public static PWMSpeedController shooterMotor2;
	public static PWMSpeedController shooterMotor3;
	public static PWMSpeedController intakeMotor;
	
	public static void init() {
		
		if (isLouise) {
			// Assign definitions for LOUISE (Test Bot)
			kFrontLeftMotorPort = 1;	
			kRearLeftMotorPort = 2;		
			kFrontRightMotorPort = 3;	
			kRearRightMotorPort = 4;	
			kShooterMotorPort = 5;
			kShooterMotorPort1 = 6;
			kShooterMotorPort2 = 7;
			kShooterMotorPort3 = 8;
			kIntakeMotorPort = 9;
			
			frontLeftMotor = new Talon(kFrontLeftMotorPort);
			rearLeftMotor = new Talon(kRearLeftMotorPort);
			frontRightMotor = new Talon(kFrontRightMotorPort);
			rearRightMotor = new Talon(kRearRightMotorPort);
			
			// Shooter
			shooterMotor = new Talon(kShooterMotorPort);
			shooterMotor1 = new Talon(kShooterMotorPort1);
			shooterMotor2 = new Talon(kShooterMotorPort2);
			shooterMotor3 = new Talon(kShooterMotorPort3);
			
			// Intake
			intakeMotor = new Talon(kIntakeMotorPort);
			
		} else {
			// Assign definitions for ARBOUR (Competition Bot)
			kFrontLeftMotorPort = 1;	
			kRearLeftMotorPort = 2;		
			kFrontRightMotorPort = 3;	
			kRearRightMotorPort = 4;	
			kShooterMotorPort = 5;	
			kShooterMotorPort1 = 6;
			kShooterMotorPort2 = 7;
			kShooterMotorPort3 = 8;
			kIntakeMotorPort = 9;  
			
			frontLeftMotor = new Talon(kFrontLeftMotorPort);
			rearLeftMotor = new Talon(kRearLeftMotorPort);
			frontRightMotor = new Talon(kFrontRightMotorPort);
			rearRightMotor = new Talon(kRearRightMotorPort);
			
			// Shooter
			shooterMotor = new Talon(kShooterMotorPort);
			shooterMotor1 = new Talon(kShooterMotorPort1);
			shooterMotor2 = new Talon(kShooterMotorPort2);
			shooterMotor3 = new Talon(kShooterMotorPort3);
			
			// Intake
			intakeMotor = new Talon(kIntakeMotorPort);
			
		}

		// CY 1/17/2017
		// Motors for left
		frontLeftMotor.enableDeadbandElimination(true);
		rearLeftMotor.enableDeadbandElimination(true);
		frontRightMotor.enableDeadbandElimination(true);
		rearRightMotor.enableDeadbandElimination(true);
			
	}
}
