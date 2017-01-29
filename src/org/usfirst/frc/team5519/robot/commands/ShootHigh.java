package org.usfirst.frc.team5519.robot.commands;

import org.usfirst.frc.team5519.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class ShootHigh extends Command	{
	
	public ShootHigh()	{
		requires(Robot.shooter);
	}
	
	@Override
	protected void initialize() {
		// TODO Auto-generated method stub
		Robot.shooter.ShootHigh();
	}
	
	@Override
	protected void execute() {
		// TODO Auto-generated method stub
		Robot.shooter.ShootHigh();
	}
	
	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return false;
	}
	
	@Override
	protected void end() {
		// TODO Auto-generated method stub
		Robot.shooter.stop();

	}
	
	@Override
	protected void interrupted() {
		// TODO Auto-generated method stub
		end();

	}
}
