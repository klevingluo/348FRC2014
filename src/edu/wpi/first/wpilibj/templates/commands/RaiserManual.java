/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.commands;

/**
 *
 * @author programming
 */
public class RaiserManual extends CommandBase {
    
    public RaiserManual() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
        requires(raiser);
    }
    

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        if(oi.raise.get()) {
            raiser.raiseArm();
        }
        else if(oi.lower.get()) {
            raiser.lowerArm();        
        } else {
            raiser.stopArm();
        }
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
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