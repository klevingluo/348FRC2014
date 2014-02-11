/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.templates.RobotMap;
import edu.wpi.first.wpilibj.Relay;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.templates.commands.AutoCompress;
import edu.wpi.first.wpilibj.templates.commands.AutoCompress;

/**
 *
 * @author kluo
 */
public class Compressor extends Subsystem {
    
    Relay compressor = RobotMap.compressor;
    DigitalInput switcher = RobotMap.pressureSwitch;
    
    boolean active = true;
    
    public void on() {
        compressor.set(Relay.Value.kForward);
    }
    
    public void off() {
        compressor.set(Relay.Value.kOff);
    }
    
    public boolean getSwitch() {
        return switcher.get();
    }
    
    public boolean isOn() {
        return active;
    }
    
    public void start() {
        active = true;
    }
    
    public void stop() {
        active = false;
    }

    protected void initDefaultCommand() {
        setDefaultCommand(new AutoCompress());
    }
    
}
