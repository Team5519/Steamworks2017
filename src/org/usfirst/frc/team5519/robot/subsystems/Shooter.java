package org.usfirst.frc.team5519.robot.subsystems;

import org.usfirst.frc.team5519.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Shooter extends Subsystem {
	// Put methods for controlling this subsystem
	// here. Call these from Commands.

	public void initDefaultCommand() {
		// Set the default command for a subsystem here.
		// setDefaultCommand(new MySpecialCommand());
	}
	
	// CY 1/27/2017
	// Motor speed for shooting high goal.
	public void shoothigh() {
		RobotMap.shooterMotor.set(1.0);
		RobotMap.shooterMotor1.set(1.0);
		RobotMap.shooterMotor2.set(1.0);
		RobotMap.shooterMotor3.set(1.0);
	}
	
	// CY 1/27/2017
	// Motor speed for shooting low goal.
	public void shootlow()	{
		RobotMap.shooterMotor.set(0.4);
		RobotMap.shooterMotor1.set(0.4);
		RobotMap.shooterMotor2.set(0.4);
		RobotMap.shooterMotor3.set(0.4);
	}
	public void stop() {
		RobotMap.shooterMotor.set(0.0);
		RobotMap.shooterMotor1.set(0.0);
		RobotMap.shooterMotor2.set(0.0);
		RobotMap.shooterMotor3.set(0.0);
	}
}
