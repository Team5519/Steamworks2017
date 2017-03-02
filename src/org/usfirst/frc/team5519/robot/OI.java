package org.usfirst.frc.team5519.robot;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.command.Command;

import org.usfirst.frc.team5519.robot.commands.AutoAlignToPegTarget;
import org.usfirst.frc.team5519.robot.commands.AutoDeliverGear;
import org.usfirst.frc.team5519.robot.commands.AutoDriveStraightDistance;
import org.usfirst.frc.team5519.robot.commands.AutoDriveToPegTarget;
import org.usfirst.frc.team5519.robot.commands.Climb;
import org.usfirst.frc.team5519.robot.commands.IntakeBalls;
import org.usfirst.frc.team5519.robot.commands.ShootHigh;
import org.usfirst.frc.team5519.robot.commands.ShootLow;
import org.usfirst.frc.team5519.robot.commands.ToggleFrontDrive;

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
	
	// CY 1/29/2017
	// Started development of assigning buttons.
	public static final int kDriveStickPort = 1;	
	public static final int kXboxControllerPort = 2;
	
	public static Joystick driveStick;
	public static XboxController controller;
	
	// These are the buttons on the controller.
	public static final int kToggleShootHighButtonNumber = 2;	// A
	public static final int kToggleShootLowButtonNumber = 3;	// B

	public static final int kToggleClimbButtonNumber = 1;		// X
	
	public static final int kToggleIntakeButtonNumber = 4;		// Y
	
	public static final int kDeliverGearButtonNumber = 1;
	public static Button deliverGearButton;
	public static final int kAlignToGearButtonNumber = 11;
	public static Button alignToGearButton;
	public static final int kDriveToGearButtonNumber = 10;
	public static Button driveToGearButton;
	public static final int kDriveStraightGearButtonNumber = 7;
	public static Button driveStraightGearButton;

	public static final int kToggleDriveFrontButtonNumber = 3;
	public static Button toggleDriveFrontButton;
	
	public static Button toggleShootHighButton;
	public static Button toggleShootLowButton;
	public static Button toggleClimbButton;
	public static Button toggleIntakeButton;

    public static boolean doMessageDriverStation = true;
    
    public void messageDriverStation(String message) {
    	if (doMessageDriverStation) {
    	       DriverStation.reportWarning(message, false);
    	}
     }
    

	public OI() {
		OI.driveStick = new Joystick(kDriveStickPort);
		OI.controller = new XboxController(kXboxControllerPort);
		
		Command ShootHigh = new ShootHigh();
		OI.toggleShootHighButton = new JoystickButton(OI.controller, kToggleShootHighButtonNumber);
		OI.toggleShootHighButton.toggleWhenPressed(ShootHigh);
		
		Command ShootLow = new ShootLow();
		OI.toggleShootLowButton = new JoystickButton(OI.controller, kToggleShootLowButtonNumber);
		OI.toggleShootLowButton.toggleWhenPressed(ShootLow);
		
		Command Climb = new Climb();
		OI.toggleClimbButton = new JoystickButton(OI.controller, kToggleClimbButtonNumber);
		OI.toggleClimbButton.toggleWhenPressed(Climb);
		
		Command IntakeBalls = new IntakeBalls();
		OI.toggleIntakeButton = new JoystickButton(OI.controller, kToggleIntakeButtonNumber);
		OI.toggleIntakeButton.toggleWhenPressed(IntakeBalls);
		
		// Auto buttons
		Command deliverGear = new AutoDeliverGear(RobotMap.START_POSITION_LEFT);
		OI.deliverGearButton = new JoystickButton(OI.driveStick,kDeliverGearButtonNumber);
		OI.deliverGearButton.toggleWhenPressed(deliverGear);

		Command alighToGear = new AutoAlignToPegTarget(RobotMap.START_POSITION_LEFT);
		OI.alignToGearButton = new JoystickButton(OI.driveStick,kAlignToGearButtonNumber);
		OI.alignToGearButton.toggleWhenPressed(alighToGear);

		Command driveToGear = new AutoDriveToPegTarget();
		OI.driveToGearButton = new JoystickButton(OI.driveStick,kDriveToGearButtonNumber);
		OI.driveToGearButton.toggleWhenPressed(driveToGear);

		Command driveStraight = new AutoDriveStraightDistance(2.0);
		OI.driveStraightGearButton = new JoystickButton(OI.driveStick,kDriveStraightGearButtonNumber);
		OI.driveStraightGearButton.toggleWhenPressed(driveStraight);

		Command toggleDriveFront = new ToggleFrontDrive();
		OI.toggleDriveFrontButton = new JoystickButton(OI.driveStick,kToggleDriveFrontButtonNumber);
		OI.toggleDriveFrontButton.whenPressed(toggleDriveFront);
	}
	
}
