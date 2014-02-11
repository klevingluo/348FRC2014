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
        {1},
        {2},
        {3,7},
        {2,4,7},
        {5,8},
        {6,8},
        {1},
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
        for(int j=0; j < VALID_TRANSITIONS[i].length; j++) {
            if(i == VALID_TRANSITIONS[i][j])
                break;
            return false;
        }
        launcher.setVacuum(STATES[i][0]);
        launcher.setRelease(STATES[i][1]);
        launcher.setLock(STATES[i][2]);
        launcher.setLatch(STATES[i][3]);
        return true;
    }
}