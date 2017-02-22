package org.usfirst.frc.team5519.robot;

import edu.wpi.first.wpilibj.AnalogGyro;
import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.interfaces.Gyro;

public class DriveBaseTwoMotor extends DriveBase {
	
	protected RobotDrive myDrive;
	protected double m_sensitivity;
	
	private Gyro gyro;
	
	double Kp = 0.3;
	
	public DriveBaseTwoMotor() {
		// GSN - 11/12/2016
        //myDrive = new RobotDrive(RobotMap.frontLeftMotor, RobotMap.frontRightMotor);	// NOTE: left - Right order
	    gyro = new AnalogGyro(1);
		myDrive = new RobotDrive(RobotMap.frontLeftMotor, RobotMap.frontRightMotor);
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
		double moveValue = 0.75 * stick.getY();
		// Correct left / right by inverting X-Axis values.
		double rotateValue = -0.7 * stick.getX();
		myDrive.arcadeDrive(moveValue, rotateValue, true);
	}
	
	  public void setSensitivity(double sensitivity) {
		    m_sensitivity = sensitivity;
	}

	@Override
	void Drive(double moveValue, double rotateValue) {
		// TODO Auto-generated method stub
	}

}
