/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.commands.catapult;

import edu.wpi.first.wpilibj.templates.commands.CommandBase;

/**
 *
 * @author programming
 */
public abstract class LauncherCommandBase extends CommandBase {
    
    protected static int state = 0;
    
    /**
     * these are the solenoid positions for all the states 
     * the solenoids are in this order: vacuum, launcher pressure release, launcher pressure lock, latch
     */
    public static final boolean[][] STATES = { 
        {false,  false,  false,  false},
        {false,  true,   true,   false},
        {true,   true,   true,   false},
        {false,  false,  true,   false},
        {false,  false,  true,   true},
        {false,  false,  false,  true},
        {false,  false,  true,   true},
        {false,  false,  true,   false},
        {false,  true,   true,   true}
    };
    /**
     * these are the valid transitions from each state
     */
    public static final int[][] VALID_TRANSITIONS = {
        {1,1},
        {2,1},
        {3,7},
        {4,2},
        {5,8},
        {6,8},
        {1,1},
        {2,3},
        {3,1},
    };
            
    public LauncherCommandBase() {
        requires(launcher);
    }
    
    /**
     * 
     * @param i the state to enter
     * @return true if successful, false if failed
     */
    protected boolean enterState(int i) {
        for(int j=0; j < VALID_TRANSITIONS[state].length; j++) {
            if(i == VALID_TRANSITIONS[state][j])
                break;
            return false;
        }
        launcher.setVacuum(STATES[i][0]);
        launcher.setRelease(STATES[i][1]);
        launcher.setLock(STATES[i][2]);
        launcher.setLatch(STATES[i][3]);
        state = i;
        return true;
    }
    
    public String stateDescribe(int i) {
        if (i == 0) {
            return "init: 0";
        } else if (i == 1) {
            return "evacuating launcher: 1";
        } else if (i == 2) {
            return "launcher at rest: 2";
        } else if (i == 3) {
            return "latched: 3";
        } else if (i == 4) {
            return "charging: 4";
        } else if (i == 5) {
            return "charged: 5";
        } else if (i == 6) {
            return "firing: 6";
        } else if (i == 7) {
            return "launcher at rest, unlatched: 7";
        } else if (i == 8) {
            return "aborting: 8";
        } else {
            return "error";
        }
    }
}