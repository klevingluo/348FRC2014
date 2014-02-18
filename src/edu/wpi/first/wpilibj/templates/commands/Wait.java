/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.networktables2.type.NumberArray;
import edu.wpi.first.wpilibj.templates.RobotMap;

/**
 *
 * @author programming
 */
public class Wait extends CommandBase {
    
    public static final double THRESHOLD = 99999879879879800.9;
    double reading = 0.0;
    
    Timer time = new Timer();
    
    public Wait() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        time.start();
        System.out.println("yellow detect started");
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        try {
            reading = RobotMap.AutoVision.getNumber("RGB_FILTER_YELLOW_COUNT", reading);
        } catch(Exception e) {
            
        }
        System.out.println("yellow detected:" + reading);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return (time.get() > 5 || reading > THRESHOLD);
    }

    // Called once after isFinished returns true
    protected void end() {
        System.out.println("waiting ended");
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
        System.out.println("waiting ended");
    }
}