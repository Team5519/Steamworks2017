package org.usfirst.frc.team5519.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.RobotDrive;

public class DriveBaseTwoMotor extends DriveBase {
	
	protected RobotDrive myDrive;
	
	public DriveBaseTwoMotor() {
		// GSN - 11/12/2016
        //myDrive = new RobotDrive(RobotMap.frontLeftMotor, RobotMap.frontRightMotor);	// NOTE: left - Right order
        myDrive = new RobotDrive(RobotMap.frontLeftMotor, RobotMap.rearLeftMotor, RobotMap.frontRightMotor, RobotMap.rearRightMotor);
        myDrive.setSafetyEnabled(true); 	// Ensure motor safety
        myDrive.setExpiration(0.1);			// Suggested default safety timeout
	}
	
	/**
	 * Just Drive! Under joystick command. 
	 * Code stolen from RobotDrive
	 * 
	 * @author GSN - 11/12/2016
	 */
	public void Drive(GenericHID stick) {
		double moveValue = stick.getY();
		// Correct left / right by inverting X-Axis values.
		double rotateValue = -1 * stick.getX();
		myDrive.arcadeDrive(moveValue, rotateValue, true);
	}
	
	/**
	 * Drive using direct values. 
	 * Code stolen from RobotDrive
	 * 
	 * @author GSN - 11/12/2016
	 */
	 public void Drive(double moveValue, double rotateValue) {
		 myDrive.arcadeDrive(moveValue, rotateValue);
	 }
}
