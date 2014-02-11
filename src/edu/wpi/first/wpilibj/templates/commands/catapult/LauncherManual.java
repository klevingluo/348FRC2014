/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.commands.catapult;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 * @author kluo
 */
public class LauncherManual extends LauncherCommandBase {
    
    private boolean refreshed = false;
    
    public LauncherManual() {
        super();
    }

    protected void initialize() {
    }

    protected void execute() {
        SmartDashboard.putString("", null);
        if (oi.advance.get() && refreshed == true) {
            if (state == 0) {
                enterState(1);
            } else if (state == 1) {
                enterState(2);
            } else if (state == 2) {
                enterState(3);
            } else if (state == 3) {
                enterState(4);
            } else if (state == 4) {
                enterState(5);
            } else if (state == 5) {
                enterState(6);
            } else if (state == 6) {
                enterState(1);
            }
            
            refreshed = false;
        }
        
        if (!oi.advance.get()) {
            refreshed = true;
        }
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {
    }

    protected void interrupted() {
    }
    
}
