/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.subsystems;

import com.sun.squawk.util.MathUtils;
import edu.wpi.first.wpilibj.AnalogPotentiometer;
import edu.wpi.first.wpilibj.command.PIDSubsystem;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.templates.commands.RaiserPID;
import edu.wpi.first.wpilibj.templates.commands.RaiserManual;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.templates.RobotMap;
/**
 *
 * @author programming
 */
public class Raiser extends PIDSubsystem {
  
    SpeedController armRaiser = RobotMap.raiserMotor;
    public AnalogPotentiometer armAngle = RobotMap.raiserAngle;
    
    public Raiser() {
        
        super("Raiser", 1.0, 0.0, 0.0);
        setAbsoluteTolerance(0.2);
        getPIDController().setContinuous(true);
    }
    
    public void raiseArm() {
        armRaiser.set(1);
    }
    
    public void lowerArm() {
        armRaiser.set(-1);
    }
    
    public void stopArm() {
        armRaiser.set(0);
    }
    
    public double getAngle() {
        return armAngle.get();
    }
    
    public void initDefaultCommand() {
        setDefaultCommand(new RaiserManual());
    }

    protected double returnPIDInput() {
        return armAngle.get();
    }

    protected void usePIDOutput(double d) {
        armRaiser.pidWrite(d);
    }
}