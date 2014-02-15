/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.subsystems;

import edu.wpi.first.wpilibj.Relay;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.templates.RobotMap;

/**
 *
 * @author programming
 */
public class Roller extends Subsystem { 
    
    Relay leftRoller = RobotMap.leftRoller;
    Relay rightRoller = RobotMap.rightRoller;
    
    public void rollLeft() {
        leftRoller.set(Relay.Value.kForward);
    }
    
    public void rollRight() {
        rightRoller.set(Relay.Value.kForward);
    }
    
    public void rollLeftReverse() {
        leftRoller.set(Relay.Value.kReverse);
    }
    
    public void rollRightReverse() {
        rightRoller.set(Relay.Value.kReverse);
    }
    
    public void stopRight() {
        rightRoller.set(Relay.Value.kOff);
    }
    
    public void stopLeft() {
        leftRoller.set(Relay.Value.kOff);
    }
    
    protected void initDefaultCommand() {
        
    }
    
}
