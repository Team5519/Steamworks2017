package org.usfirst.frc.team5519.robot.subsystems;

import org.usfirst.frc.team5519.robot.RobotMap;

import edu.wpi.first.wpilibj.Counter;
import edu.wpi.first.wpilibj.command.Subsystem;

public class GearRelease extends Subsystem {
	
	private Counter gearReleaseTopLimitSwitch;
	private Counter gearReleaseBottomLimitSwitch;

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
    	if (gearReleaseBottomLimitSwitch == null) {
    		gearReleaseBottomLimitSwitch = new Counter(RobotMap.gearReleaseBottomLimitSwitch);
    	}
    	if (gearReleaseTopLimitSwitch == null) {
    		gearReleaseTopLimitSwitch = new Counter(RobotMap.gearReleaseTopLimitSwitch);
    	}
   	    gearReleaseBottomLimitSwitch.reset();
    	gearReleaseTopLimitSwitch.reset();
    	
	}
	public boolean isBottomLimitHit() {
		
    	if (gearReleaseBottom != null) {
    		return outerLimitCounter.get() > 0;
    	} else {
    		return true;
    	}

    }

    
    public void releaseGear()	{
    	RobotMap.gearReleaseMotor1.set(1.0);
    }
    
    public void resetReleaseGear()	{
    	RobotMap.gearReleaseMotor1.set(-1.0);
    }
    
    public void stop()	{
    	RobotMap.gearReleaseMotor1.set(0.0);
    }
    
}

