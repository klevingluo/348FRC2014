/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.subsystems;

import edu.wpi.first.wpilibj.AnalogPotentiometer;
import edu.wpi.first.wpilibj.command.PIDSubsystem;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.templates.commands.RaiserPID;
import edu.wpi.first.wpilibj.templates.RobotMap;
/**
 *
 * @author programming
 */
public class Raiser extends PIDSubsystem {
  
    public static final double DOWN = 4.57;
    public static final double UP = 3.07;
    public static final double IDLE = 3.38;
    public static final double FIRE = 3.95; // 2.81 is ideal but we can't get there without an I gain
    
    SpeedController armRaiser = RobotMap.raiserMotor;
    public AnalogPotentiometer armAngle = RobotMap.raiserAngle;
    
    public Raiser() {
        
        super("Raiser", -1.2, 0.0, -0.1);
        setAbsoluteTolerance(0.15);
        getPIDController().setContinuous(true);
    }
    
    public void raiseArm() {
        armRaiser.set(0.4);
    }
    
    public void lowerArm() {
        armRaiser.set(-0.4);
    }
    
    public void stopArm() {
        armRaiser.set(0);
    }
    
    public double getAngle() {
        return armAngle.get();
    }
    
    public void initDefaultCommand() {
        setDefaultCommand(new RaiserPID());
    }

    protected double returnPIDInput() {
        return armAngle.get();
    }

    protected void usePIDOutput(double d) {
        armRaiser.pidWrite(d);
    }
}
