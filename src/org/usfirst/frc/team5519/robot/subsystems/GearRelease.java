package org.usfirst.frc.team5519.robot.subsystems;

import org.usfirst.frc.team5519.robot.RobotMap;

import edu.wpi.first.wpilibj.Counter;
import edu.wpi.first.wpilibj.command.Subsystem;

public class GearRelease extends Subsystem {
	
	private Counter gearReleaseUpperLimitCounter;
	private Counter gearReleaseLowerLimitCounter;

    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
	public void initHardware() {
		/*
		if (motor == null) {
			motor = RobotMap.armMotor;
		}
		*/
    	if (gearReleaseLowerLimitCounter == null) {
    		gearReleaseLowerLimitCounter = new Counter(RobotMap.gearLowerLimitSwitchInput);
    	}
    	if (gearReleaseUpperLimitCounter == null) {
    		gearReleaseUpperLimitCounter = new Counter(RobotMap.gearUpperLimitSwitchInput);
    	}
    	gearReleaseLowerLimitCounter.reset();
   	    gearReleaseUpperLimitCounter.reset();
    	
	}
	
	public boolean isLowerLimitHit() {
		
    	if (gearReleaseLowerLimitCounter != null) {
    		return gearReleaseLowerLimitCounter.get() > 0;
    	} else {
    		return true;
    	}

    }
	
	public boolean isUpperLimitHit() {
		
    	if (gearReleaseUpperLimitCounter != null) {
    		return gearReleaseUpperLimitCounter.get() > 0;
    	} else {
    		return true;
    	}

    }
	
    private void resetLowerLimit() {
    	
    	if (gearReleaseLowerLimitCounter == null) {
    		gearReleaseLowerLimitCounter = new Counter(RobotMap.gearLowerLimitSwitchInput);
    	}
    	gearReleaseLowerLimitCounter.reset();
   	   
    }
    
    private void resetUpperLimit() {
    	
    	if (gearReleaseUpperLimitCounter == null) {
    		gearReleaseUpperLimitCounter = new Counter(RobotMap.gearUpperLimitSwitchInput);
    	}
    	gearReleaseUpperLimitCounter.reset();
   	   
    }
    
    public void lowerGear()	{
    	RobotMap.gearReleaseMotor.set(1.0);
    	this.resetUpperLimit();
    }
    
    public void raiseGear()	{
    	RobotMap.gearReleaseMotor.set(-1.0);
    	this.resetLowerLimit();
    }
    
    public void stop()	{
    	RobotMap.gearReleaseMotor.set(0.0);
    }
    
}

