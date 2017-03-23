package org.usfirst.frc.team5519.robot.commands;

import org.usfirst.frc.team5519.robot.Robot;
import org.usfirst.frc.team5519.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class ReleaseGear extends Command {

    public ReleaseGear() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.gearRelease);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	//Robot.gearRelease.releaseGear();
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	//Robot.gearRelease.gearReleaseTopLimitSwitch();
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.gearRelease.stop();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
