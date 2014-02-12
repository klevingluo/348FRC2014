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
      // vac    release  lock    latch
        {false,  false,  false,  false}, // init
        {false,  true,   true,   false}, // evacuating launcher
        {true,   true,   true,   false}, // vacuum on
        {false,  false,  true,   false}, // rest
        {false,  false,  true,   true},  // latched
        {false,  false,  false,  true},  // charging
        {false,  false,  true,   true},  // charged
        {false,  false,  true,   false}, // firing
        {false,  true,   true,   true}   // aborting
    };
    /**
     * these are the valid transitions from each state
     */
    public static final int[][] TRANSITIONS = {
        {1,1},
        {2,1},
        {3,1},
        {4,2},
        {5,8},
        {6,8},
        {7,8},
        {1,8},
        {1,3},
    };
            
    public LauncherCommandBase() {
        requires(launcher);
    }
    
    /**
     * 
     * @param i the state to enter
     */
    protected void enterState(int i) {
        launcher.setVacuum(STATES[i][0]);
        launcher.setRelease(STATES[i][1]);
        launcher.setLock(STATES[i][2]);
        launcher.setLatch(STATES[i][3]);
        state = i;
    }
    
    public String stateDescribe(int i) {
        if (i == 0) {
            return "init: 0";
        } else if (i == 1) {
            return "evacuating cylinder: 1";
        } else if (i == 2) {
            return "resetting launcher: 2";
        } else if (i == 3) {
            return "at rest: 3";
        } else if (i == 4) {
            return "latched arm: 4";
        } else if (i == 5) {
            return "charging cylinder: 5";
        } else if (i == 6) {
            return "cylinder locked: 6";
        } else if (i == 7) {
            return "firing: 7";
        } else if (i == 8) {
            return "aborting: 8";
        } else {
            return "error";
        }

    }
}