/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.templates.commands.TankDrive;
import edu.wpi.first.wpilibj.templates.RobotMap;

/**
 *
 * @author programming
 */
public class DriveTrain extends Subsystem {

    Talon leftDrive = RobotMap.leftDrive;
    Talon rightDrive = RobotMap.rightDrive;
    
    public void driveLeft(double power) {
        leftDrive.set(-power);
    }
    
    public void driveRight(double power) {
        rightDrive.set(-power);
    }
   
    protected void initDefaultCommand() {
        setDefaultCommand(new TankDrive());
    }
}
    
