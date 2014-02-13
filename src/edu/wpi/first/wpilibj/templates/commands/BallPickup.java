/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.wpi.first.wpilibj.templates.commands;

/**
 *
 * @author programming
 */
public class BallPickup extends CommandBase {
    
    public BallPickup() {
        requires(roller);
        requires(raiser);
        raiser.enable();
    }
    
    protected void initialize() {
        raiser.setSetpoint(raiser.DOWN);
    }

    protected void execute() {
        roller.rollLeft();
        roller.rollRight();
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {
        roller.stopLeft();
        roller.stopRight();
    }

    protected void interrupted() {
        roller.stopLeft();
        roller.stopRight();
    }
    
}
