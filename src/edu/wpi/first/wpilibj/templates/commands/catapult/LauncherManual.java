/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.commands.catapult;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.templates.RobotMap;

/**
 *
 * @author kluo
 */
public class LauncherManual extends LauncherCommandBase {
    
    private Timer time;
    
    public LauncherManual() {
        requires(launcher);
    }

    protected void initialize() {
        enterState(4);
        time.start();
    }

    protected void execute() {
        if (state == 0) {
            enterState(TRANSITIONS[0][0]);
            time.reset();
        } else if (state == 1 && time.get() > 1) {
            enterState(TRANSITIONS[1][0]);
            time.reset();
        } else if (state == 2) {
            if (RobotMap.catapultArm.get()) {
                enterState(TRANSITIONS[2][0]);           // Transitions is an array of state movements [2][0] is the forwards transition from state 2 and [2][1] is the backwards transition
            } else if (time.get() > 3) {
                enterState(TRANSITIONS[2][1]);
            }
            time.reset();
        } else if (state == 3 && time.get() > 0.1) {
            enterState(TRANSITIONS[3][0]);
            time.reset();
        } else if (state == 4 && oi.advance.get()) {
            enterState(TRANSITIONS[4][0]);
            time.reset();
        } else if (state == 5 && oi.advance.get() && time.get() > 0.2) {
            enterState(TRANSITIONS[5][0]);
            time.reset();
        } else if (state == 6 && oi.advance.get() && time.get() > 0.2) {
            enterState(TRANSITIONS[6][0]);
            time.reset();
        } else if (state == 7 && time.get() > 0.4) {
            enterState(TRANSITIONS[7][0]);
            time.reset();
        } else if (state == 8) {
            enterState(TRANSITIONS[8][0]);
            time.reset();
        }
        
        SmartDashboard.putString("Launcher state:", stateDescribe(state));
        SmartDashboard.putString(" next Launcher state:", stateDescribe(TRANSITIONS[state][0]));
        System.out.println("" + TRANSITIONS[state][0] + " " + state + " " + TRANSITIONS[state][1] + "");
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
