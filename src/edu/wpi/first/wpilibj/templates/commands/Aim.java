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
        requires(driveTrain);
    }
    
    protected void initialize() {

    }

    protected void execute() {
        try{
            corners = (NumberArray) RobotMap.nettab.getValue("BFR_COORDINATES", corners);
        } catch(Exception e) {
            System.out.println("error");
        }
        SmartDashboard.putNumber("corner value", corners.get(2));
        System.out.println(corners.get(2));
    }

    protected boolean isFinished() {
        return time.get() > 3;
    }

    protected void end() {
        
    }

    protected void interrupted() {
        
    }
    
}
