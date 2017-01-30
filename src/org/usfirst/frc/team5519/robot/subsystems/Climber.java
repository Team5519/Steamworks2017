package org.usfirst.frc.team5519.robot.subsystems;

import org.usfirst.frc.team5519.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Subsystem;

public class Climber extends Subsystem {

	@Override
	protected void initDefaultCommand() {
		// TODO Auto-generated method stub
		
	}

	public void Climb()	{
		RobotMap.shooterMotor.set(0.25);
		RobotMap.shooterMotor1.set(0.25);
		RobotMap.shooterMotor2.set(0.25);
		RobotMap.shooterMotor3.set(0.25);
	}
	
	public void Stop()	{
		RobotMap.shooterMotor.set(0.0);
		RobotMap.shooterMotor1.set(0.0);
		RobotMap.shooterMotor2.set(0.0);
		RobotMap.shooterMotor3.set(0.0);
	}
	
}
