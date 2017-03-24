package org.usfirst.frc.team5519.robot.subsystems;

import java.util.ArrayList;

import org.opencv.core.Mat;
import org.opencv.core.MatOfPoint;
import org.usfirst.frc.team5519.robot.Robot;
import org.usfirst.frc.team5519.robot.vision.PegTarget;
import org.usfirst.frc.team5519.robot.vision.PegVisionPipeline;

import edu.wpi.cscore.AxisCamera;
import edu.wpi.cscore.CvSink;
import edu.wpi.cscore.CvSource;
import edu.wpi.cscore.UsbCamera;
import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class UsbVision extends Subsystem {

	private static final int IMG_WIDTH = 320;
	private static final int IMG_HEIGHT = 240;
	private static final int TELEOP_EXPOSURE_VALUE = 67;
	private static final int AUTONOMOUS_EXPOSURE_VALUE = 5;
	private static final int TELEOP_BRIGHTNESS_VALUE = 50;
	private static final int AUTONOMOUS_BRIGHTNESS_VALUE = 5;
	
	private static final boolean AUTONOMOUS_MODE = true;
	private static final boolean DRIVER_MODE = false;
	private boolean cameraMode;

	
	private UsbCamera camera;
	private Thread visionThread;
	
	private final Object imgLock = new Object();
	private double targetAngle = 0.0;
	private double targetDistance = 99.9;
	private boolean isTargetLocked = false;

    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    public void initCameraHardware() {
    	camera = CameraServer.getInstance().startAutomaticCapture("Peg View",0);
        //camera = CameraServer.getInstance().addAxisCamera("Target View","axis-camera");
    	setCameraForAutonomous();
    	
        visionThread = new Thread(() -> {
            Mat snapshot = new Mat();
            CvSink cvSink = CameraServer.getInstance().getVideo();
            CvSource outputStream = null;
            if (Robot.oi.doMessageDriverStation) {
                outputStream = CameraServer.getInstance().putVideo("Vision Thread", IMG_WIDTH, IMG_HEIGHT);
             }
            PegVisionPipeline pipeline = new PegVisionPipeline();    
            while(!Thread.interrupted()) {
                cvSink.grabFrame(snapshot);
                pipeline.process(snapshot);
                ArrayList<MatOfPoint> contourDetections = pipeline.filterContoursOutput();
                SmartDashboard.putNumber("Target/Number of Pipeline Contours", contourDetections.size());
                PegTarget pegTarget = new PegTarget(contourDetections);
                synchronized (imgLock) {
                    targetAngle = pegTarget.estimateAngle();
                    targetDistance = pegTarget.estimateDistance();
                    isTargetLocked = pegTarget.isEstablished();
                }
                if (Robot.oi.doMessageDriverStation) {
                    //snapshot = pipeline.hslThresholdOutput();
                    pegTarget.dumpStatistics();
                    pegTarget.drawBoxOnImage(snapshot);
                    outputStream.putFrame(snapshot);               	
                }
                Timer.delay(0.05);
            }
        });
        visionThread.start();
        CameraServer.getInstance().startAutomaticCapture("Shooter View",1);
    }
    
    
   public void setCameraForTeleop() {
    	camera.setResolution(IMG_WIDTH, IMG_HEIGHT); 
		camera.setExposureManual(TELEOP_EXPOSURE_VALUE);
		camera.setBrightness(TELEOP_BRIGHTNESS_VALUE);
    	cameraMode = DRIVER_MODE;
    }
   
    
    public void setCameraForAutonomous() {
    	camera.setResolution(IMG_WIDTH, IMG_HEIGHT); 
    	camera.setExposureManual(AUTONOMOUS_EXPOSURE_VALUE);
		camera.setBrightness(AUTONOMOUS_BRIGHTNESS_VALUE);
    	cameraMode = AUTONOMOUS_MODE;
    }
    
    public void toggelCameraSetting() {
        DriverStation.reportWarning("COMMAND toggleCamera." + cameraMode, false);
        if(cameraMode == AUTONOMOUS_MODE) {
    		setCameraForTeleop();
    	} else {
    		setCameraForAutonomous();
    	}
    }

    public double getTargetAngle() {
    	double angle = 0.0;
    	//angle =  targetAngle; 		// *** Synchronization Necessary?
        synchronized (imgLock) {
           angle =  targetAngle;
        }
    	return angle;
    }
    
    
    public double getTargetDistance() {
    	double distance = 99.9;
        synchronized (imgLock) {
        	distance =  targetDistance;
        }
    	return distance;
    }
    
    
    public boolean isTargetLocked() {
    	return isTargetLocked;
    }

}

