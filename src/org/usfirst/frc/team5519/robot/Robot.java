 
package org.usfirst.frc.team5519.robot;


import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import org.usfirst.frc.team5519.robot.commands.AssistDeliverGear;
import org.usfirst.frc.team5519.robot.commands.AutoAlignToPegTarget;
import org.usfirst.frc.team5519.robot.commands.AutoCenterOne;
import org.usfirst.frc.team5519.robot.commands.AutoDeliverGear;
import org.usfirst.frc.team5519.robot.commands.AutoDriveStraightDistance;
import org.usfirst.frc.team5519.robot.commands.AutoDriveToPegTarget;
import org.usfirst.frc.team5519.robot.commands.AutoLeftOne;
import org.usfirst.frc.team5519.robot.commands.AutoRightOne;
import org.usfirst.frc.team5519.robot.subsystems.UsbVision;
import org.usfirst.frc.team5519.robot.subsystems.Climber;
import org.usfirst.frc.team5519.robot.subsystems.DriveBaseAutonomous;
import org.usfirst.frc.team5519.robot.subsystems.GearRelease;
import org.usfirst.frc.team5519.robot.subsystems.Intake;
import org.usfirst.frc.team5519.robot.subsystems.Shooter;
import org.usfirst.frc.team5519.robot.subsystems.ShooterCamera;


/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot {

	public static OI oi;
    public static Shooter shooter;
    //public static Intake intake;
    public static Climber climber;
    public static DriveBaseAutonomous driveBase;
    public static UsbVision usbVision;
    //public static ShooterCamera shooterCamera;
    public static GearRelease gearRelease;

    Command autonomousCommand;
    
	/**
	 * This function is run when the robot is first started up and should be
	 * used for any initialization code.
	 */
	@Override
	public void robotInit() {
		RobotMap.init ();
		
        shooter = new Shooter();
        //intake = new Intake();
        climber = new Climber();
        gearRelease = new GearRelease();
        gearRelease.initHardware();
        
        usbVision = new UsbVision();
        usbVision.initCameraHardware();
        //shooterCamera = new ShooterCamera();
        //shooterCamera.initCameraHardware();
        
        driveBase = new DriveBaseAutonomous();
        oi = new OI();
   
	}
	
	/**
	 * This function is called once each time the robot enters Disabled mode.
	 * You can use it to reset any subsystem information you want to clear when
	 * the robot is disabled.
	 */
	@Override
	public void disabledInit() {

	}

	@Override
	public void disabledPeriodic() {
		Scheduler.getInstance().run();
	}

	/**
	 * This autonomous (along with the chooser code above) shows how to select
	 * between different autonomous modes using the dashboard. The sendable
	 * chooser code works with the Java SmartDashboard. If you prefer the
	 * LabVIEW Dashboard, remove all of the chooser code and uncomment the
	 * getString code to get the auto name from the text box below the Gyro
	 *
	 * You can add additional auto modes by adding additional commands to the
	 * chooser code above (like the commented example) or additional comparisons
	 * to the switch structure below with additional strings & commands.
	 */
	@Override
	public void autonomousInit() {
		String autoSelected = SmartDashboard.getString("Auto Selector","Default");
        oi.messageDriverStation("AUTONOMOUS COMMAND = " + autoSelected);
		switch(autoSelected) { 
			case "Auto Left 1": 
			case "L1":
				autonomousCommand = new AutoLeftOne(RobotMap.START_POSITION_LEFT); 
				break; 
			case "Auto Right 1": 
			case "R1":
				autonomousCommand = new AutoRightOne(RobotMap.START_POSITION_RIGHT); 
				break; 
			case "Auto Centre 1": 
			case "C1":
				autonomousCommand = new AutoCenterOne(RobotMap.START_POSITION_CENTRE); 
				break; 
			case "Auto Align":
				autonomousCommand = new AutoAlignToPegTarget(RobotMap.START_POSITION_LEFT);
				break;
			case "Auto Drive 3m":
				autonomousCommand = new AutoDriveStraightDistance(3.0);
				break;
			case "Auto To Peg":
				autonomousCommand = new AutoDriveToPegTarget();
				break;
			case "Auto Default": 
			default:
				autonomousCommand = new AutoRightOne(RobotMap.START_POSITION_LEFT); 
				break; 
		}
		if (autonomousCommand != null)
			autonomousCommand.start();
		
	}

	/**
	 * This function is called periodically during autonomous
	 */
	@Override
	public void autonomousPeriodic() {
		Scheduler.getInstance().run();
	}
	
	@Override
	public void teleopInit() {
		// This makes sure that the autonomous stops running when
		// teleop starts running. If you want the autonomous to
		// continue until interrupted by another command, remove
		// this line or comment it out.
		if (autonomousCommand != null)
			autonomousCommand.cancel();
		
	}

	/**
	 * This function is called periodically during operator control
	 */
	@Override
	public void teleopPeriodic() {
		Scheduler.getInstance().run();
	}

	/**
	 * This function is called periodically during test mode
	 */
	@Override
	public void testPeriodic() {
		LiveWindow.run();
	}
	
}
