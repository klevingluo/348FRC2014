/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.image.ColorImage;
import edu.wpi.first.wpilibj.templates.RobotMap;

/**
 *
 * @author programming
 */
public class Wait extends CommandBase {
    
    Timer time = new Timer();
    ColorImage feed;
    
    public Wait() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        time.start();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        try {
            feed = RobotMap.camera.getImage();
        } catch(Exception e) {

        }
        
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return (time.get() > 5);
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}