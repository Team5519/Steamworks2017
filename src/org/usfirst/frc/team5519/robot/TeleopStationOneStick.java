package org.usfirst.frc.team5519.robot;

import edu.wpi.first.wpilibj.Joystick;

public class TeleopStationOneStick extends TeleopStation {
	
	
	public TeleopStationOneStick () {
		// driveStick = new Joystick(kDriveStickPort);		
	}
	
	public Joystick getDriveStick() {
		return OI.driveStick;
	}

}
