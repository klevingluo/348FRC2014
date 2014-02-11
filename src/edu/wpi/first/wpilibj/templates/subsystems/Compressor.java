/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.templates.RobotMap;
import edu.wpi.first.wpilibj.Relay;
import edu.wpi.first.wpilibj.DigitalInput;

/**
 *
 * @author kluo
 */
public class Compressor extends Subsystem {
    
    Relay compressor = RobotMap.compressor;
    DigitalInput switchy = RobotMap.pressureSwitch;
            
    private boolean active = false;
    
    public void start() {
        active = true;
    }
    
    public void stop() {
        active = false;
    }
    
    public boolean isOn() {
        return active;
    }
    
    public void update() {
        if (active && switchy.get()) {
            compressor.set(Relay.Value.kForward);
        } else {
            compressor.set(Relay.Value.kOff);
        }
    }

    protected void initDefaultCommand() {
    }
    
}
