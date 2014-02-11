/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.commands;

import edu.wpi.first.wpilibj.networktables2.type.NumberArray;
import edu.wpi.first.wpilibj.templates.RobotMap;

/**
 *
 * @author programming
 */
public class AutoShoot extends CommandBase {
    
    
    
    public AutoShoot() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
        requires(driveTrain);
        requires(launcher);
        requires(raiser);
        requires(roller);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        
        double[] corners = new double[9];
        
        try {
            RobotMap.nettab.getValue("BFR_COORDINATES", corners);
            System.out.println(RobotMap.nettab.containsKey("FPS"));
            System.out.println(RobotMap.nettab.containsKey("BFR_COORDINATES"));
            System.out.println(RobotMap.nettab.getValue("FPS"));
        } catch (Exception e) {
            System.out.println("WARNING, you're screwed");
        }
        
        System.out.println(corners[0]);
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