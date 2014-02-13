/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.commands;

import edu.wpi.first.wpilibj.templates.commands.catapult.LauncherCommandBase;

/**
 *
 * @author programming
 */
public class RaiserPID extends CommandBase {
    
    public RaiserPID() {
        requires(raiser);
        requires(roller);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        raiser.setSetpoint(raiser.IDLE);
        raiser.enable();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        if (LauncherCommandBase.getState()== 6 || LauncherCommandBase.getState() == 7) {
            raiser.setSetpoint(raiser.FIRE);
        } else {
            raiser.setSetpoint(raiser.IDLE);
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