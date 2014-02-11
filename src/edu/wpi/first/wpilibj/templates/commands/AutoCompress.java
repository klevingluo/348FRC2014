/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.commands;

/**
 *
 * @author kluo
 */
public class AutoCompress extends CommandBase {

    protected void initialize() {
        requires(compressor);
    }

    protected void execute() {
        if (compressor.getSwitch() && compressor.isOn()) {
            compressor.on();
        } else {
            compressor.off();
        }
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {
    }

    protected void interrupted() {
    }
    
}
