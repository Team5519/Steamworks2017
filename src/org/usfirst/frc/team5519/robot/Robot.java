
package org.usfirst.frc.team5519.robot;

import org.usfirst.frc.team5519.subsystems.CameraVision;
import org.usfirst.frc.team5519.subsystems.SimpleArm;

import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot {
    final String defaultAuto = "Default";
    final String customAuto = "My Auto";
    String autoSelected;
    SendableChooser chooser;
    
	//  GSN - 11/12/2016
	// 
	// Addition of basic drive capabilities using an abstracted driveBase.  
	// The intent is is to allow development of more sophisticated drive bases  
	// with minimal impact on the main robot code.
	// 
	// Same goes for operator station and joystick setup/
	//
    public static OI oi;    
    public static SimpleArm arm;
    public static DriveBase driveBase;
    public static TeleopStation teleopStation;
    //public static Joystick driveStick;
    private int driveCount;
    
	//  GSN - 12/03/2016
	// 
    public static CameraVision cameraVision;

	
    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
    public void robotInit() {
        // GSN - 11/12/2016
        RobotMap.init();
        
        chooser = new SendableChooser();
        chooser.addDefault("Default Auto", defaultAuto);
        chooser.addObject("My Auto", customAuto);
        SmartDashboard.putData("Auto choices", chooser);
    	
        // GSN - 11/12/2016
        arm = new SimpleArm();
        arm.initHardware();

        
        //  GSN - 12/03/2016
        //cameraVision = new CameraVision();
        //cameraVision.init();

        oi = new OI();
        
        driveBase = new DriveBaseTwoMotor();
        teleopStation = new TeleopStationOneStick();
        //driveStick = teleopStation.getDriveStick();
        driveCount = 0;
        
    }
    
	/**
	 * This autonomous (along with the chooser code above) shows how to select between different autonomous modes
	 * using the dashboard. The sendable chooser code works with the Java SmartDashboard. If you prefer the LabVIEW
	 * Dashboard, remove all of the chooser code and uncomment the getString line to get the auto name from the text box
	 * below the Gyro
	 *
	 * You can add additional auto modes by adding additional comparisons to the switch structure below with additional strings.
	 * If using the SendableChooser make sure to add them to the chooser code above as well.
	 */
    public void autonomousInit() {
    	autoSelected = (String) chooser.getSelected();
//		autoSelected = SmartDashboard.getString("Auto Selector", defaultAuto);
		System.out.println("Auto selected: " + autoSelected);
    }

    /**
     * This function is called periodically during autonomous
     */
    public void autonomousPeriodic() {
    	switch(autoSelected) {
    	case customAuto:
        //Put custom auto code here   
            break;
    	case defaultAuto:
    	default:
    	//Put default auto code here
            break;
    	}
    }

    /**
     * This function is called periodically during operator control
     * 
     * GSN - Periodically means about 50 times a second (or once every 20 ms or 0.020 s)
     */
    public void teleopPeriodic() {
    	
    	// GSN - 11/12/2016
    	driveBase.Drive(OI.driveStick);
    	
    	Scheduler.getInstance().run();
    	
    	//  GSN - 12/03/2016
    	//CameraServer.getInstance().startAutomaticCapture();
    	//cameraVision.sendImage();
    	
    }
    
    /**
     * This function is called periodically during test mode
     */
    public void testPeriodic() {
    
    }
    
}
