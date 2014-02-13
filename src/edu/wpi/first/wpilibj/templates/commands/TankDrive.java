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
public class TankDrive extends CommandBase {
    
    public TankDrive() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
        requires(driveTrain);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        CommandBase.lights.forwards();
    }

    // Called repeatedly when this Command is scheduled to srun
    protected void execute() {
        driveTrain.driveLeft(-oi.leftStick.getAxis(Joystick.AxisType.kY));
        driveTrain.driveRight(-oi.rightStick.getAxis(Joystick.AxisType.kY));
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
        driveTrain.driveLeft(0);
        driveTrain.driveRight(0);
    }
}