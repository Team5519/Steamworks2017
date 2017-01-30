package org.usfirst.frc.team5519.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.Joystick;
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
	  public void arcadeDrive(GenericHID stick, boolean squaredInputs) {
		    // simply call the full-featured arcadeDrive with the appropriate values
		    arcadeDrive(stick.getY(), stick.getX(), true);
		    
		    int speed;
		    speed = (int) stick.getY();
		    speed = (int) stick.getX();
		    
		    if (speed < 0) {
		    	speed = -1*speed;
		    }
		    
		    if (speed < 0.3) {
		    	squaredInputs = true;
		    }
		    else {
		    	squaredInputs = false;
		    }
		    
		    setLeftRightMotorOutputs(1.0, 0.6);
		    
		  }

	private void setLeftRightMotorOutputs(double d, double e) {
		// TODO Auto-generated method stub
		
	}

	private void arcadeDrive(double y, double x, boolean squaredInputs) {
		// TODO Auto-generated method stub
		
	}

	@Override
	void Drive(double moveValue, double rotateValue) {
		// TODO Auto-generated method stub
		
	}
}
