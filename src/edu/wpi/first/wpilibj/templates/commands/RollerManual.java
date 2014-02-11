/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.commands;


/**
 *
 * @author programming
 */
public class RollerManual extends CommandBase {
    
    public RollerManual() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
        requires(roller);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        if(oi.roll.get()) {
            roller.rollLeft();
            roller.rollRight();
        } else if(oi.rollReverse.get()) {
            roller.rollLeftReverse();
            roller.rollRightReverse();
        } else {
            roller.stopLeft();
            roller.stopRight();
        }
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
        roller.stopLeft();
        roller.stopRight();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
        roller.stopLeft();
        roller.stopRight();
    }
}