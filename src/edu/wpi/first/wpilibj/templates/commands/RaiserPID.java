/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.commands;

import edu.wpi.first.wpilibj.Joystick;

/**
 *
 * @author programming
 */
public class RaiserPID extends CommandBase {
    
    public RaiserPID() {
        requires(raiser);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        raiser.enable();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        raiser.setSetpoint(oi.leftStick.getAxis(Joystick.AxisType.kZ));
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
        raiser.disable();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
        raiser.disable();
    }
}