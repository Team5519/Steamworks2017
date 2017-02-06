package org.usfirst.frc.team5519.robot.subsystems;

import org.usfirst.frc.team5519.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Subsystem;

public class Shooter extends Subsystem {

	@Override
	protected void initDefaultCommand() {
		// TODO Auto-generated method stub
		
	}
	
	// CY 1/29/2017
	// This is where you set motor speeds for shooter.
	public void ShootHigh()	{
		RobotMap.shooterMotor1.set(1.0);
		RobotMap.shooterMotor2.set(-1.0);
		RobotMap.shooterMotor3.set(-1.0);
		RobotMap.shooterMotor4.set(1.0);
	}
	
	public void ShootLow()	{
		RobotMap.shooterMotor1.set(0.4);
		RobotMap.shooterMotor2.set(-0.4);
		RobotMap.shooterMotor2.set(-0.4);
		RobotMap.shooterMotor3.set(0.4);
	}

	public void stop()	{
		RobotMap.shooterMotor1.set(0.0);
		RobotMap.shooterMotor2.set(0.0);
		RobotMap.shooterMotor3.set(0.0);
		RobotMap.shooterMotor4.set(0.0);
	}
	
}
