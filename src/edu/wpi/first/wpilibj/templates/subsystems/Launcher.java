/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.subsystems;

import edu.wpi.first.wpilibj.AnalogChannel;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.templates.RobotMap;
import edu.wpi.first.wpilibj.templates.commands.catapult.LauncherManual;


/**
 *
 * @author programming
 */
public class Launcher extends Subsystem {
    
    DigitalInput catapultArm = RobotMap.catapultArm;
    AnalogChannel pressureSensor = RobotMap.pressureSensor;
    Solenoid latchA = RobotMap.latchA;
    Solenoid latchB = RobotMap.latchB;
    Solenoid pressureLockA = RobotMap.pressureLockA;
    Solenoid pressureLockB = RobotMap.pressureLockB;
    Solenoid pressureRelease = RobotMap.pressureRelease;
    Solenoid vacuumA = RobotMap.vacuumA;
    Solenoid vacuumB = RobotMap.vacuumB;
        
    public boolean isLoaded() {
        return catapultArm.get();
    }
    
    public double getPressure() {
        return pressureSensor.getValue();
        // find the linear transform to pressure
    }
    
    public void setLock(boolean p) {
        pressureLockA.set(p);
        pressureLockB.set(!p);
    }
    
    public void setVacuum(boolean p) {
        vacuumA.set(p);
        vacuumB.set(!p);
    }

    public void setRelease(boolean p) {
        pressureRelease.set(p);
    }
    
    public void setLatch(boolean p) {
        latchA.set(p);
        latchB.set(!p);
    }
            
    public void initDefaultCommand() {
        setDefaultCommand(new LauncherManual());
    }
}