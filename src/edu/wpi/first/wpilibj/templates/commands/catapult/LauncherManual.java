/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.commands.catapult;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.templates.RobotMap;

/**
 *
 * @author kluo
 */
public class LauncherManual extends LauncherCommandBase {
    
    private boolean refreshed = false;
    
    public LauncherManual() {
        requires(launcher);
    }

    protected void initialize() {
    }

    protected void execute() {
        if (oi.advance.get() && refreshed == true) {
            enterState(VALID_TRANSITIONS[state][0]);
            refreshed = false;
            SmartDashboard.putString("abort state", stateDescribe(VALID_TRANSITIONS[state][1]));
            SmartDashboard.putString("launcher state:", stateDescribe(state));
            SmartDashboard.putString("next state:", stateDescribe(VALID_TRANSITIONS[state][0]));
        } else if (oi.abort.get()){
            enterState(VALID_TRANSITIONS[state][1]);
            refreshed = false;
            SmartDashboard.putString("abort state", stateDescribe(VALID_TRANSITIONS[state][1]));
            SmartDashboard.putString("launcher state:", stateDescribe(state));
            SmartDashboard.putString("next state:", stateDescribe(VALID_TRANSITIONS[state][0]));
        }
        System.out.println("" + VALID_TRANSITIONS[state][0] + " " + state + " " + VALID_TRANSITIONS[state][1] + "");
        if (!oi.advance.get()) {
            refreshed = true;
        }
        SmartDashboard.putNumber("shooting pressure:", RobotMap.pressureSensor.getVoltage());
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {
    }

    protected void interrupted() {
    }
    
}
