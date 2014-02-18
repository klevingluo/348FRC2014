/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.wpi.first.wpilibj.templates.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.networktables2.type.NumberArray;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.templates.RobotMap;

/**
 *
 * @author programming
 */
public class Aim extends CommandBase {

    NumberArray corners = new NumberArray();
    public static final double target = 4;
    Timer time = new Timer();
    
    public Aim() {
        //requires(driveTrain);
    }
    
    protected void initialize() {
        System.out.println("aiming started");
    }

    protected void execute() {
        try {
            RobotMap.TeleVision.retrieveValue("BFR_COORDINATES", corners);
        } catch(Exception e) {
            
        }
        SmartDashboard.putNumber("corner value", corners.get(0));
        System.out.println("corner: " + corners.get(0));
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {
        System.out.println("aiming ended");
    }

    protected void interrupted() {
        System.out.println("aiming ended");
        
    }
    
}
