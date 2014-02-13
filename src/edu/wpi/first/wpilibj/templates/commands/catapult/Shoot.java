/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.wpi.first.wpilibj.templates.commands.catapult;

import edu.wpi.first.wpilibj.templates.commands.CommandBase;

/**
 *
 * @author kluo
 */
public class Shoot extends LauncherCommandBase {

    protected void initialize() {
        enterState(6);
        time.reset();
        time.start();
    }

    protected void execute() {
        if (state == 5 && time.get() > 0.2) {    //charging cylinder to lock
            enterState(TRANSITIONS[5][0]);
            time.reset();
            CommandBase.lights.shoot();
        } else if (state == 6 && time.get() > 0.2) {  // locked to firing
            enterState(TRANSITIONS[6][0]);
            time.reset();
        } else if (state == 7 && time.get() > 0.4) {        // firing
            enterState(TRANSITIONS[7][0]);
            time.reset();
        }
    }

    protected boolean isFinished() {
        return state == 1;
    }

    protected void end() {
        CommandBase.lights.forwards();
    }

    protected void interrupted() {
        
    }
    
}
