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
        if (airCompressor.isOn()) {
            airCompressor.stop();
        } else {
            airCompressor.start();
        }
        CommandBase.lights.setAlliance();
    }

    protected void execute() {
    }

    protected boolean isFinished() {
        return true;
    }

    protected void end() {
    }

    protected void interrupted() {
    }
    
}
