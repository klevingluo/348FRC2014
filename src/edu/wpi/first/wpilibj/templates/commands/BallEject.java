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
public class BallEject extends CommandBase{
    
    public BallEject() {
        requires(roller);
        requires(raiser);        
    }

    protected void initialize() {
       raiser.setSetpoint(raiser.UP);
       raiser.enable();
    }

    protected void execute() {
        roller.rollLeftReverse();
        roller.rollRightReverse();
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
