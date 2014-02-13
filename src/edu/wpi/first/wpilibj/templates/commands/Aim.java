/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.wpi.first.wpilibj.templates.commands;

import edu.wpi.first.wpilibj.networktables2.type.NumberArray;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.templates.RobotMap;
import edu.wpi.first.wpilibj.templates.commands.catapult.LauncherCommandBase;

/**
 *
 * @author kluo
 */
public class Aim extends LauncherCommandBase {
    
    NumberArray corners = new NumberArray();
    
    public Aim() {
        requires(driveTrain);
    }

    protected void initialize() {
      
    }

    protected void execute() {
        try {
            RobotMap.nettab.getValue("BFR_COORDINATES", corners);
        } catch(Exception e) {
            SmartDashboard.putString("Vision Status:", "error");
        }
            corners.size();
    }

    protected boolean isFinished() {
        return true;
    }

    protected void end() {
        
    }

    protected void interrupted() {
        
    }
    
}
