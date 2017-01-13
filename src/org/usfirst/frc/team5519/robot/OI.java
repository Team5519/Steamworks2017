package org.usfirst.frc.team5519.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.command.Command;

import org.usfirst.frc.team5519.commands.ExtendArm;
import org.usfirst.frc.team5519.commands.RetractArm;
import org.usfirst.frc.team5519.robot.commands.ExampleCommand;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
	//// CREATING BUTTONS
	// One type of button is a joystick button which is any button on a
	//// joystick.
	// You create one by telling it which joystick it's on and which button
	// number it is.
	// Joystick stick = new Joystick(port);
	// Button button = new JoystickButton(stick, buttonNumber);

	// There are a few additional built in buttons you can use. Additionally,
	// by subclassing Button you can create custom triggers and bind those to
	// commands the same as any other Button.

	//// TRIGGERING COMMANDS WITH BUTTONS
	// Once you have a button, it's trivial to bind it to a button in one of
	// three ways:

	// Start the command when the button is pressed and let it run the command
	// until it is finished as determined by it's isFinished method.
	// button.whenPressed(new ExampleCommand());

	// Run the command while the button is being held down and interrupt it once
	// the button is released.
	// button.whileHeld(new ExampleCommand());

	// Start the command when the button is released and let it run the command
	// until it is finished as determined by it's isFinished method.
	// button.whenReleased(new ExampleCommand());
	
	// CY 1/12/2017
		public static final int kDriveStickPort = 0; // Find correct joystick port
		public static Joystick driveStick;
		
<<<<<<< HEAD
	// TANVEER 1/13/17
		public static final int kExtendArmButtonNUmber = 0;  		// Find correct joystick port
		public static final int kCancelExtendArmButtonNumber = 0;  	// Find correct joystick port
		public static final int kRetractArmButtonNumber = 0; 		// Find correct joystick port
		public static final int kCancelRetractArmButtonNumber = 0;  // Find correct joystick port
		public static final int kToggleArmButtonNumber = 0;  		// Find correct joystick port
=======
		public static final int kExtendArmButtonNumber = 0;  //Find correct joystick port
		public static final int kCancelExtendArmButtonNumber = 0;  //Find correct joystick port
		public static final int kRetractArmButtonNumber = 0;  //Find correct joystick port
		public static final int kCancelRetractArmButtonNumber = 0;  //Find correct joystick port
		public static final int kToggleArmButtonNumber = 0;  //FInd correct joystick port
>>>>>>> origin/master
		
		public static Button extendArmButton;
		public static Button cancelExtendArmButton;
		public static Button retractArmButton;
		public static Button cancelRetractArmButton;
		public static Button toggleArmButton;
		
<<<<<<< HEAD
=======
		public OI() {
			OI.driveStick = new Joystick(kDriveStickPort);
			
			Command extendArm = new ExtendArm();	// Have code the commands for ExtendArm
			OI.extendArmButton = new JoystickButton(OI.driveStick,kExtendArmButtonNumber);
			OI.extendArmButton.whenPressed(extendArm);
			OI.cancelExtendArmButton = new JoystickButton(OI.driveStick,kCancelExtendArmButtonNumber);
			OI.cancelExtendArmButton.cancelWhenPressed(extendArm);
			
			Command retractArm = new RetractArm();	// Have to code the commands for RetractArm
			OI.retractArmButton = new JoystickButton(OI.driveStick,kRetractArmButtonNumber);
			OI.retractArmButton.whenPressed(retractArm);
			OI.cancelRetractArmButton = new JoystickButton(OI.driveStick,kCancelRetractArmButtonNumber);
			OI.cancelRetractArmButton.cancelWhenPressed(retractArm);
			OI.toggleArmButton = new JoystickButton(OI.driveStick,kToggleArmButtonNumber);
			OI.toggleArmButton.toggleWhenPressed(retractArm);
		}
			
>>>>>>> origin/master
}