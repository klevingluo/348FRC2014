
package edu.wpi.first.wpilibj.templates;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.templates.commands.*;
import edu.wpi.first.wpilibj.templates.commands.catapult.ShootTest;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
    
    // the two joysticks
    public Joystick leftStick = new Joystick(1);
    public Joystick rightStick = new Joystick(2);
    
    
    // when pressed, the robot drives backwards
    public JoystickButton reverseDrive = new JoystickButton(leftStick, 1);
    
    // rolls the intake rollers 
    public JoystickButton roll = new JoystickButton(leftStick, 5);
    
    // rolls the intake rollers backwards
    public JoystickButton rollReverse = new JoystickButton(leftStick, 4);
    
    // raises the arms
    public JoystickButton raise = new JoystickButton(leftStick, 3);
    
    // lowers the arms
    public JoystickButton lower = new JoystickButton(leftStick, 2);
    
    // turns the compressor on/off
    public JoystickButton toggle = new JoystickButton(rightStick, 11);
    
    // advances the launcher through the steps of shooting (see documentation)
    public JoystickButton advance = new JoystickButton(leftStick, 8);

    // enters normal controll mode
    public JoystickButton normalControl = new JoystickButton(leftStick, 6);
    
    // enters autonomous test mode
    public JoystickButton test = new JoystickButton(leftStick,7);
    
    // enters launcher diagnostic mode
    public JoystickButton shooterTest = new JoystickButton(leftStick, 11);
    
    public void run() {
        test.whenPressed(new AutoShoot());
        normalControl.whenPressed(new teleopDefault());
        shooterTest.whenPressed(new ShootTest());
        toggle.whenPressed(new ToggleCompressor());
    }
}

