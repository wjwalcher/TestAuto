package org.usfirst.frc.team4511.robot.commands;

import org.usfirst.frc.team4511.robot.Robot;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class AutoDriveLong extends Command {
	double angle;
	//int count = 0;
	boolean finished = false;
    public AutoDriveLong() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.soulTrain);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	//Robot.soulTrain.gyro.reset();
    	Robot.soulTrain.blEncoder.reset();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	int count = Robot.soulTrain.blEncoder.get();
    	//angle = Robot.soulTrain.gyro.getAngle();
    	while(count <= 2364){
    		/*if(-5 >= angle) Robot.soulTrain.robotD.tankDrive(.3, 0);
    		if(5 <= angle) Robot.soulTrain.robotD.tankDrive(0, .3);
    		if(5 >= angle && -5 <= angle){*/
    			Robot.soulTrain.robotD.tankDrive(.6, .6);
    			count++;
    	}
    	//}
    	finished = true;
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        if(finished) return true;
    	return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
