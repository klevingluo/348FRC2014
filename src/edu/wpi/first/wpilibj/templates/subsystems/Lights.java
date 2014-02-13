/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.wpi.first.wpilibj.templates.subsystems;

import edu.wpi.first.wpilibj.DigitalOutput;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.templates.RobotMap;
import edu.wpi.first.wpilibj.DriverStation;

/**
 *
 * @author kluo
 */
public class Lights extends Subsystem {
    
    DigitalOutput[] signal = {RobotMap.lights1, RobotMap.lights2, RobotMap.lights3};
    
    public Lights() {
        if (RobotMap.station.getAlliance() == DriverStation.Alliance.kBlue) {
            signal[0].set(true);
        } else {
            signal[0].set(false);
        }
    }
    
    public void forwards() {
        signal[1].set(true);
        signal[2].set(false);
    }
    
    public void backwards() {
        signal[1].set(false);
        signal[2].set(true);
    }
    
    public void shoot() {
        signal[1].set(true);
        signal[2].set(true);
    }

    protected void initDefaultCommand() {
    }
    
}
