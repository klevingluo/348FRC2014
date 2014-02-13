/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.wpi.first.wpilibj.templates.commands.catapult;

import edu.wpi.first.wpilibj.templates.RobotMap;
import edu.wpi.first.wpilibj.templates.commands.CommandBase;

/**
 *
 * @author kluo
 */
public class Load extends LauncherCommandBase {
    
    public static final double limit = 4.0;
    private boolean finished;

    protected void initialize() {
        enterState(3);
        time.reset();
        time.start();
    }

    protected void execute() {

        if (state == 3 && time.get() > 4) {    // at rest
            enterState(TRANSITIONS[3][0]);
            time.reset();
        } else if (state == 4 && time.get() > 0.2) {    // latched to charging
            enterState(TRANSITIONS[4][0]);
            time.reset();
        } else if (state == 5 && time.get() > 0.2 && RobotMap.pressureSensor.getVoltage() > limit) {    //charging cylinder to lock
            time.reset();
            CommandBase.lights.shoot();
            finished = true;
        }
    }

    protected boolean isFinished() {
        return finished;
    }

    protected void end() {
       
    }

    protected void interrupted() {
        
    }
    
}
