/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.commands;

/**
 *
 * @author kluo
 */
public class ToggleCompressor extends CommandBase {
    
    
    protected void initialize() {
        if (compressor.isOn()) {
            compressor.stop();
        } else {
            compressor.start();
        }
    }

    protected void execute() {
        
    }

    protected boolean isFinished() {
        return !oi.toggle.get();
    }

    protected void end() {
    }

    protected void interrupted() {
    }
    
    
}
