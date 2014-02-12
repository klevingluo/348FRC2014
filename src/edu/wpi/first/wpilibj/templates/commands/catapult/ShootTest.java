/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.commands.catapult;

import edu.wpi.first.wpilibj.Joystick;

/**
 *
 * @author kluo
 */
public class ShootTest extends LauncherCommandBase {
    
    public ShootTest() {
        super();
    }

    protected void initialize() {
    }

    protected void execute() {
        Joystick joy = oi.rightStick;
        for (int i = 0; i < 9; i++) {
            if (joy.getRawButton(i) == true)
                enterState(i);
        }
        System.out.println("state:" + state + "here:" + TRANSITIONS[state]);
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {
    }

    protected void interrupted() {
    }

    
}
