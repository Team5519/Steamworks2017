package org.usfirst.frc.team5519.robot.commands;

import org.usfirst.frc.team5519.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class Climb extends Command {
<<<<<<< HEAD
	
	public Climb ()	{
		requires(Robot.climber);
=======

	public Climb()	{
		//requires(Robot.climber);
>>>>>>> origin/master
	}
	
	@Override
	protected void initialize() {
		// TODO Auto-generated method stub
		// Robot.climber.Climb();
	}
	
	@Override
	protected void execute() {
		// TODO Auto-generated method stub
		Robot.climber.Climb();
	}
	
	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
<<<<<<< HEAD
=======
	protected void end() {
		// TODO Auto-generated method stub
		Robot.climber.Climb();

	}
	
	@Override
>>>>>>> origin/master
	protected void interrupted() {
		// TODO Auto-generated method stub
		end();
	}
	
}
