package org.usfirst.frc.team4511.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.CounterBase;

import org.usfirst.frc.team4511.robot.*;
import org.usfirst.frc.team4511.robot.commands.Drive;

import edu.wpi.first.wpilibj.ADXL362;
import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import edu.wpi.first.wpilibj.AnalogGyro;
import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.RobotDrive;

/**
 *
 */
public class DriveTrain extends Subsystem {
	public CANTalon frontLeft = new CANTalon(RobotMap.frontLeft);
	public CANTalon frontRight = new CANTalon(RobotMap.frontRight);
	public CANTalon backLeft = new CANTalon(RobotMap.backLeft);
	public CANTalon backRight = new CANTalon(RobotMap.backRight);
	
	public Encoder blEncoder = new Encoder(0, 1, false, CounterBase.EncodingType.k4X);
	
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