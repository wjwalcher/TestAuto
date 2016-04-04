package org.usfirst.frc.team4511.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;

import org.usfirst.frc.team4511.robot.*;
import org.usfirst.frc.team4511.robot.commands.Drive;

import edu.wpi.first.wpilibj.ADXL362;
import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import edu.wpi.first.wpilibj.AnalogGyro;
import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.RobotDrive;

/**
 *
 */
public class DriveTrain extends Subsystem {
	CANTalon frontLeft = new CANTalon(RobotMap.frontLeft);
	CANTalon frontRight = new CANTalon(RobotMap.frontRight);
	CANTalon backLeft = new CANTalon(RobotMap.backLeft);
	CANTalon backRight = new CANTalon(RobotMap.backRight);

	public ADXRS450_Gyro gyro = new ADXRS450_Gyro();
	public RobotDrive robotD = new RobotDrive(frontLeft, backLeft, frontRight, backRight);

	public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    	robotD.setSafetyEnabled(false);
		setDefaultCommand(new Drive());
    }
	
	public void takeJoystick(double d, double e) {
		robotD.tankDrive(d, e);
	}
	
	public void stop() {
		robotD.drive(0, 0);
	}
	
	public void drive(double x) {
	    robotD.drive(.3, x);
    }
}