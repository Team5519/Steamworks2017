package org.usfirst.frc.team5519.robot.subsystems;

import org.usfirst.frc.team5519.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Subsystem;

public class Intake extends Subsystem {

	@Override
	protected void initDefaultCommand() {
		// TODO Auto-generated method stub
	}
	
	// CY 1/29/2017
	// Here you can set what speed the intake motors run at. Suppose to run at low speed.
	public void IntakeBalls() {
		RobotMap.intakeMotor1.set(0.75);
	}
	
	public void Stop()	{
		RobotMap.intakeMotor1.set(0.0);
	}
	
}
