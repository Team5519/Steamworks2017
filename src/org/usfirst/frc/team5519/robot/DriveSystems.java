package org.usfirst.frc.team5519.robot;

import edu.wpi.first.wpilibj.GenericHID;

// CY 1/13/2017
// Copied and pasted
public abstract class DriveSystems {

	abstract void Drive(GenericHID stick); 

	abstract void Drive(double moveValue, double rotateValue);
}
