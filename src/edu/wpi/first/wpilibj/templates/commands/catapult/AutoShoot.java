/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.wpi.first.wpilibj.templates.commands.catapult;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.templates.RobotMap;

/**
 *
 * @author programming
 */
public class AutoShoot extends LauncherCommandBase {

    
    public AutoShoot() {
        requires(launcher);
    }

    
    protected void initialize() {
        time.reset();
        time.start();
    }

    protected void execute() {
        boolean isLauncherDown = !RobotMap.catapultArm.get();
        
        if (state == 0) {
            enterState(TRANSITIONS[0][0]);              // init
            time.reset();
        } else if (state == 1 && time.get() > 0.1) {    // evacuating
            enterState(TRANSITIONS[1][0]);
            time.reset();
        } else if (state == 2) {                        // resetting launcher
            if (isLauncherDown) {
                enterState(TRANSITIONS[2][0]);           // Transitions is an array of state movements [2][0] is the forwards transition from state 2 and [2][1] is the backwards transition
            } else if (time.get() > 3) {
                enterState(TRANSITIONS[2][0]);
            }
            time.reset();
        } else if (state == 3 && time.get() > 0.1) {    // at rest
            enterState(TRANSITIONS[3][0]);
            time.reset();
        } else if (state == 4 && time.get() > 0.2) {    // latched to charging
            enterState(TRANSITIONS[4][0]);
            time.reset();
        } else if (state == 5 && time.get() > 0.2) {    //charging cylinder to lock
            enterState(TRANSITIONS[5][0]);
            time.reset();
        } else if (state == 6 && time.get() > 0.2) {  // locked to firing
            enterState(TRANSITIONS[6][0]);
            time.reset();
        } else if (state == 7 && time.get() > 0.2) {        // firing
            enterState(TRANSITIONS[7][0]);
            time.reset();
        } else if (state == 8) {                        //aborting
            enterState(TRANSITIONS[8][0]);
            time.reset();
        }
        
        SmartDashboard.putString("Launcher state:", stateDescribe(state));
        SmartDashboard.putString(" next Launcher state:", stateDescribe(TRANSITIONS[state][0]));
        //System.out.println("In " + state + ", Next " + TRANSITIONS[state][0] + ", Abort " + TRANSITIONS[state][1] + ", Time " + time.get() + ", Arm Down " + isLauncherDown);
        SmartDashboard.putNumber("shooting pressure:", RobotMap.pressureSensor.getVoltage());
    }

    protected boolean isFinished() {
        return state==1;
    }

    protected void end() {
    }

    protected void interrupted() {
    }
    
}
