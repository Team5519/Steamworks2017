package org.usfirst.frc.team5519.robot;

import edu.wpi.first.wpilibj.PWMSpeedController;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.VictorSP;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
	
	public static boolean isLouise = false;		// BE SURE TO SET THIS TO FALSE IF RUNNING FARADAY!!!
	
	// CY 1/29/2017
	// Finished development on shooter motors on Robot Map.
	// Starting development on intake motors on Robot Map.
	public static int kFrontLeftMotorPort;
	public static int kRearLeftMotorPort;	
	public static int kFrontRightMotorPort;
	public static int kRearRightMotorPort;
	
	public static int kShooterMotorPort1;
	public static int kShooterMotorPort2;
	public static int kShooterMotorPort3;
	public static int kShooterMotorPort4;
	public static int kIntakeMotorPort1;
	public static int kIntakeMotorPort2;
	
	public static PWMSpeedController frontLeftMotor;
	public static PWMSpeedController rearLeftMotor;
	public static PWMSpeedController frontRightMotor;
	public static PWMSpeedController rearRightMotor;
	
	// Shooter motors will be also used for climbing as well!!!
	public static PWMSpeedController shooterMotor1;
	public static PWMSpeedController shooterMotor2;
	public static PWMSpeedController shooterMotor3;
	public static PWMSpeedController shooterMotor4;
	public static PWMSpeedController intakeMotor1;
	public static PWMSpeedController intakeMotor2;
	
	public static void init() {
		
		if (isLouise) {
			// Assign definitions for LOUISE (Test Bot)
			kFrontLeftMotorPort = 1;	
			kRearLeftMotorPort = 2;		
			kFrontRightMotorPort = 3;	
			kRearRightMotorPort = 4;	
			kShooterMotorPort1 = 5;
			kShooterMotorPort1 = 6;
			kShooterMotorPort2 = 7;
			kShooterMotorPort3 = 8;
			
			kShooterMotorPort1 = 5;
			kShooterMotorPort1 = 6;
			kShooterMotorPort2 = 7;
			kShooterMotorPort3 = 8;
			
			kIntakeMotorPort1 = 9;
			kIntakeMotorPort2 = 0;		// Need to find out more about the expansion card. For now using port 0.
			
			// Assuming all motors will be using Talons.
			frontLeftMotor = new Talon(kFrontLeftMotorPort);
			rearLeftMotor = new Talon(kRearLeftMotorPort);
			frontRightMotor = new Talon(kFrontRightMotorPort);
			rearRightMotor = new Talon(kRearRightMotorPort);
			
			// Shooter
			shooterMotor1 = new Talon(kShooterMotorPort1);
			shooterMotor2 = new Talon(kShooterMotorPort2);
			shooterMotor3 = new Talon(kShooterMotorPort3);
			shooterMotor4 = new Talon(kShooterMotorPort4);
			
			// Intake
			intakeMotor1 = new Talon(kIntakeMotorPort1);
			
		} else {
			// Assign definitions for FARADAY (Competition Bot)
			// FARADAY will be using VictorSPs and Sparks.
			kFrontLeftMotorPort = 1;	
			kFrontRightMotorPort = 9;	

			kShooterMotorPort1 = 2;
			kShooterMotorPort2 = 7;		// REVERSE!!!
			kShooterMotorPort3 = 8;		// REVERSE!!!
			kShooterMotorPort4 = 3;
			
			kIntakeMotorPort1 = 6;
			
			frontLeftMotor = new VictorSP(kFrontLeftMotorPort);
			rearLeftMotor = new VictorSP(kRearLeftMotorPort);
			frontRightMotor = new VictorSP(kFrontRightMotorPort);
			rearRightMotor = new VictorSP(kRearRightMotorPort);
			
			shooterMotor1 = new VictorSP(kShooterMotorPort1);
			shooterMotor2 = new VictorSP(kShooterMotorPort2);
			shooterMotor3 = new VictorSP(kShooterMotorPort3);
			shooterMotor4 = new VictorSP(kShooterMotorPort4);
			
			intakeMotor1 = new Spark(kIntakeMotorPort1);
			intakeMotor2 = new Spark(kIntakeMotorPort2);
			
		}

		// CY 1/17/2017
		// Test to see if this makes a difference.
		frontLeftMotor.enableDeadbandElimination(true);
		rearLeftMotor.enableDeadbandElimination(true);
		frontRightMotor.enableDeadbandElimination(true);
		rearRightMotor.enableDeadbandElimination(true);
			
	}
}
