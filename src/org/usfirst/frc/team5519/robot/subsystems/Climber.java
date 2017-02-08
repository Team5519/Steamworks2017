package org.usfirst.frc.team5519.robot.subsystems;

import org.usfirst.frc.team5519.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Subsystem;

public class Climber extends Subsystem {

	@Override
	protected void initDefaultCommand() {
		// TODO Auto-generated method stub
		
	}

	public void Climb()	{
		RobotMap.climberMotor1.set(-0.75);
	}
	
	public void Stop()	{
		RobotMap.climberMotor1.set(0.0);
	}
	
}
