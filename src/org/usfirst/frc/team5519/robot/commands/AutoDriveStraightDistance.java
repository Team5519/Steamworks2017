package org.usfirst.frc.team5519.robot.commands;

import org.usfirst.frc.team5519.robot.Robot;
import org.usfirst.frc.team5519.robot.RobotMap;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class AutoDriveStraightDistance extends Command {

	//private static final double kFMV = -0.6;		// FAST move value
	//private static final double kSMV = -0.30;	// SLOW move value
	
	private double requiredDistance;
	
    public AutoDriveStraightDistance(double distance) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.driveBase);
    	requiredDistance = distance;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.driveBase.stopDead();
    	Robot.driveBase.resetSensors();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.oi.messageDriverStation("COMMAND DriveStraightDistance reported distance is = " + Robot.driveBase.getDistanceTraveled());
        if (Math.abs(Robot.driveBase.getDistanceTraveled()) > (requiredDistance-0.25)) {
        	Robot.driveBase.driveStraight(RobotMap.AUTO_SLOW_SPEED);
        } else {
        	Robot.driveBase.driveStraight(RobotMap.AUTO_HIGH_SPEED);
        }
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	if (Math.abs(Robot.driveBase.getDistanceTraveled()) >= requiredDistance) {
    		Robot.oi.messageDriverStation("COMMAND DriveStraightDistance ARRIVED distance is = " + Robot.driveBase.getDistanceTraveled());
    		return true;
    	}
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.driveBase.stopDead();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}
