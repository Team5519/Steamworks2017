package org.usfirst.frc.team5519.robot;

import edu.wpi.first.wpilibj.PWMSpeedController;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.VictorSP;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
	
	public static boolean isLouise = true;		// BE SURE TO SET THIS TO FALSE IF RUNNING FARADAY!!!
	
	// CY 1/29/2017
	// Finished development on shooter motors on Robot Map.
	// Starting development on intake motors on Robot Map.
	public static int kFrontLeftMotorPort;
	public static int kFrontRightMotorPort;
	
	public static int kShooterMotorPort1;
	public static int kShooterMotorPort2;
	public static int kShooterMotorPort3;
	public static int kShooterMotorPort4;
	
	public static int kIntakeMotorPort1;
	public static int kIntakeMotorPort2;
	
	public static int kClimberMotorPort1;
	
	public static PWMSpeedController frontLeftMotor;
	public static PWMSpeedController frontRightMotor;
	
	public static PWMSpeedController shooterMotor1;
	public static PWMSpeedController shooterMotor2;
	public static PWMSpeedController shooterMotor3;
	public static PWMSpeedController shooterMotor4;
	
	public static PWMSpeedController intakeMotor1;
	public static PWMSpeedController intakeMotor2;
	
	public static PWMSpeedController climberMotor1;
	
	public static void init() {
		
		if (isLouise) {
			// Assign definitions for LOUISE (Test Bot)
			kFrontLeftMotorPort = 0;		
			kFrontRightMotorPort = 1;
			
			kShooterMotorPort1 = 5;
			kShooterMotorPort1 = 6;
			kShooterMotorPort2 = 7;
			kShooterMotorPort3 = 8;
			
			kShooterMotorPort1 = 5;
			kShooterMotorPort1 = 6;
			kShooterMotorPort2 = 7;
			kShooterMotorPort3 = 8;
			
			kIntakeMotorPort1 = 9;
			
			// Assuming all motors will be using Talons.
			frontLeftMotor = new Victor(kFrontLeftMotorPort);
			frontRightMotor = new Victor(kFrontRightMotorPort);
			
			shooterMotor1 = new Talon(kShooterMotorPort1);
			shooterMotor2 = new Talon(kShooterMotorPort2);
			shooterMotor3 = new Talon(kShooterMotorPort3);
			shooterMotor4 = new Talon(kShooterMotorPort4);
			
			intakeMotor1 = new VictorSP(kIntakeMotorPort1);
			
			// climberMotor1 = new Victor(kClimberMotorPort1);
			
		} else {
			// Assign definitions for FARADAY (Competition Bot)
			// FARADAY will be using VictorSPs and Sparks.
			kFrontLeftMotorPort = 0;	
			kFrontRightMotorPort = 1;	

			kShooterMotorPort1 = 2;
			kShooterMotorPort2 = 3;
			kShooterMotorPort3 = 4;
			kShooterMotorPort4 = 5;
			
			kIntakeMotorPort1 = 9;
			
			kClimberMotorPort1 = 8;
			
			frontLeftMotor = new VictorSP(kFrontLeftMotorPort);
			frontRightMotor = new VictorSP(kFrontRightMotorPort);
			
			shooterMotor1 = new VictorSP(kShooterMotorPort1);
			shooterMotor2 = new VictorSP(kShooterMotorPort2);
			shooterMotor3 = new VictorSP(kShooterMotorPort3);
			shooterMotor4 = new VictorSP(kShooterMotorPort4);
			
			intakeMotor1 = new VictorSP(kIntakeMotorPort1);
			
			climberMotor1 = new Spark(kClimberMotorPort1);
			
		}

		// CY 1/17/2017
		// Test to see if this makes a difference.
		frontLeftMotor.enableDeadbandElimination(true);
		frontRightMotor.enableDeadbandElimination(true);
			
	}
}
