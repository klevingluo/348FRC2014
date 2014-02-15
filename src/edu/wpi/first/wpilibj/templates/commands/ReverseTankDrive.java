/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.commands;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.templates.RobotMap;

/**
 *
 * @author kluo
 */
public class ReverseTankDrive extends CommandBase {

    public ReverseTankDrive() {
        requires(driveTrain);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        CommandBase.lights.backwards();
        RobotMap.forwards = false;
    }

    // Called repeatedly when this Command is scheduled to srun
    protected void execute() {
        driveTrain.driveLeft(oi.rightStick.getAxis(Joystick.AxisType.kY));
        driveTrain.driveRight(oi.leftStick.getAxis(Joystick.AxisType.kY));
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
