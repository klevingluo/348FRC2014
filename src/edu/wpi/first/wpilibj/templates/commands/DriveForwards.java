/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.wpi.first.wpilibj.templates.commands;

import edu.wpi.first.wpilibj.Timer;

/**
 *
 * @author programming
 */
public class DriveForwards extends CommandBase {

    Timer time = new Timer();
    
    double timeout = 0;
    
    public DriveForwards(double time) {
        timeout = time;
        requires(driveTrain);
    }
            
    protected void initialize() {
        time.start();
        lights.forwards();
    }

    protected void execute() {
        driveTrain.driveLeft(-0.65);
        driveTrain.driveRight(-0.65);
    }

    protected boolean isFinished() {
        return  time.get() > timeout;
    }

    protected void end() {
        driveTrain.driveLeft(0);
        driveTrain.driveRight(0);
    }

    protected void interrupted() {
        driveTrain.driveLeft(0);
        driveTrain.driveRight(0);
    }
    
}
