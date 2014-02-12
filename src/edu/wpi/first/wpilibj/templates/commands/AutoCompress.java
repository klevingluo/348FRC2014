/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.commands;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 * @author kluo
 */
public class AutoCompress extends CommandBase {

    public AutoCompress() {
        requires(airCompressor);
    }
    protected void initialize() {

    }

    protected void execute() {
        if (airCompressor.getSwitch() && airCompressor.isOn()) {
            airCompressor.on();
        } else {
            airCompressor.off();
        }
        SmartDashboard.putBoolean("compressor status:", airCompressor.isOn());
        SmartDashboard.putBoolean("pressure switch", airCompressor.getSwitch());
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {
    }

    protected void interrupted() {
    }
    
}
