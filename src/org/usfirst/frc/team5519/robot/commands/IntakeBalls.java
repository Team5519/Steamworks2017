package org.usfirst.frc.team5519.robot.commands;

import org.usfirst.frc.team5519.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class IntakeBalls extends Command {
	
	public IntakeBalls() {
		requires(Robot.intake);
	}
	
	@Override
	protected void initialize() {
		// TODO Auto-generated method stub
		Robot.intake.IntakeBalls();
	}
	
	@Override
	protected void execute() {
		// TODO Auto-generated method stub
		Robot.intake.IntakeBalls();
	}
	
	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	protected void interrupted() {
		// TODO Auto-generated method stub
		end();
	}
	
}
