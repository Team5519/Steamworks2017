package org.usfirst.frc.team5519.robot;

import edu.wpi.first.wpilibj.DigitalInput;
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
	
	/* 
	 * NOTE: 	Competition bot is LOUISE (Wifi Radio Config)
	 * 			Practice bot is ARBOUR (Wifi Radio Config)
	 */
	public static boolean isLouise = true;		// BE SURE TO SET THIS TO FALSE IF RUNNING FARADAY!!!
	
	public final static int START_POSITION_RIGHT = 0;
	public final static int START_POSITION_CENTRE = 1;
	public final static int START_POSITION_LEFT = 2;
	
	public final static double FOREWARD_BACK_MODIFIER = -1.0;
	public final static double LEFT_RIGHT_MODIFIER = 1.0;
	
	public final static double AUTO_HIGH_SPEED = 0.7;
	public final static double AUTO_MEDIUM_SPEED = 0.5;
	public final static double AUTO_SLOW_SPEED = 0.3;

	
	// CY 1/29/2017
	// Finished development on shooter motors on Robot Map.
	// Starting development on intake motors on Robot Map.
	public static int kFrontLeftMotorPort;
	public static int kFrontRightMotorPort;
	
	public static int kShooterMotorPort1;
	public static int kShooterMotorPort2;
	public static int kShooterMotorPort3;
	public static int kShooterMotorPort4;
	
	//public static int kIntakeMotorPort1;
	public static int kClimberMotorPort1;
	public static int kGearReleaseMotorPort;
	
	public static PWMSpeedController frontLeftMotor;
	public static PWMSpeedController frontRightMotor;
	
	public static PWMSpeedController shooterMotor1;
	public static PWMSpeedController shooterMotor2;
	public static PWMSpeedController shooterMotor3;
	public static PWMSpeedController shooterMotor4;
	
	public static PWMSpeedController intakeMotor1;
	public static PWMSpeedController climberMotor1;
	public static PWMSpeedController gearReleaseMotor;
	
	public static DigitalInput gearUpperLimitSwitchInput;
	public static DigitalInput gearLowerLimitSwitchInput;
	
	public final static int kCIMcoderDioPortA = 0;
	public final static int kCIMcoderDioPortB = 1;
	
	public final static int kGearUpperLimitSwitchDioPort = 2;
	public final static int kGearLowerLimitSwitchDioPort = 3;
	
	public static void init() {
		if (isLouise) {
			// Assign definitions for LOUISE (Competition Bot)
			// LOUISE will be using VictorSPs and Sparks.
			kFrontLeftMotorPort = 0;	
			kFrontRightMotorPort = 1;	

			kShooterMotorPort1 = 2;
			kShooterMotorPort2 = 3;
			kShooterMotorPort3 = 4;
			kShooterMotorPort4 = 5;
			
			//kIntakeMotorPort1 = 9;
			kClimberMotorPort1 = 8;
			kGearReleaseMotorPort = 9;
			
			frontLeftMotor = new VictorSP(kFrontLeftMotorPort);
			frontRightMotor = new VictorSP(kFrontRightMotorPort);
			
			shooterMotor1 = new VictorSP(kShooterMotorPort1);
			shooterMotor2 = new VictorSP(kShooterMotorPort2);
			shooterMotor3 = new VictorSP(kShooterMotorPort3);
			shooterMotor4 = new VictorSP(kShooterMotorPort4);
			
			//intakeMotor1 = new VictorSP(kIntakeMotorPort1);
			climberMotor1 = new Spark(kClimberMotorPort1);
			gearReleaseMotor = new VictorSP(kGearReleaseMotorPort);
			
			gearUpperLimitSwitchInput = new DigitalInput(kGearUpperLimitSwitchDioPort);
			gearLowerLimitSwitchInput = new DigitalInput(kGearLowerLimitSwitchDioPort);
			
		} else {
			// Assign definitions for ARBOUR (Test Bot)
			kFrontLeftMotorPort = 0;		
			kFrontRightMotorPort = 1;
			
			kShooterMotorPort1 = 2;
			kShooterMotorPort2 = 3;
			kShooterMotorPort3 = 4;
			kShooterMotorPort4 = 5;
			
			//kIntakeMotorPort1 = 9;
			kClimberMotorPort1 = 8;
			kGearReleaseMotorPort = 9;
			
			// Assuming all motors will be using Talons.
			frontLeftMotor = new Victor(kFrontLeftMotorPort);
			frontRightMotor = new Victor(kFrontRightMotorPort);
			
			shooterMotor1 = new Talon(kShooterMotorPort1);
			shooterMotor2 = new Talon(kShooterMotorPort2);
			shooterMotor3 = new Talon(kShooterMotorPort3);
			shooterMotor4 = new Talon(kShooterMotorPort4);
			
			//intakeMotor1 = new VictorSP(kIntakeMotorPort1);
			climberMotor1 = new Victor(kClimberMotorPort1);
			gearReleaseMotor = new VictorSP(kGearReleaseMotorPort);
			
			gearUpperLimitSwitchInput = new DigitalInput(kGearUpperLimitSwitchDioPort);
			gearLowerLimitSwitchInput = new DigitalInput(kGearLowerLimitSwitchDioPort);
				
		}

		// CY 1/17/2017
		// Test to see if this makes a difference.
		frontLeftMotor.enableDeadbandElimination(true);
		frontRightMotor.enableDeadbandElimination(true);
			
	}
}
