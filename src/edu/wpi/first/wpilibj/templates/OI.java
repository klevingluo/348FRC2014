
package edu.wpi.first.wpilibj.templates;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.templates.commands.*;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
    
    // the two joysticks
    public Joystick leftStick = new Joystick(1);
    public Joystick rightStick = new Joystick(2);
    
    
    // while pressed, the robot drives backwards
    public JoystickButton reverseDrive = new JoystickButton(leftStick, 1);
    // rolls the intake rollers to take in a ball
    public JoystickButton roll = new JoystickButton(leftStick, 3);
    // rolls the intake rollers backwards to spit out a ball
    public JoystickButton rollReverse = new JoystickButton(leftStick, 2);
    // raises the arms
    public JoystickButton raise = new JoystickButton(rightStick, 3);
    // lowers the arms
    public JoystickButton lower = new JoystickButton(rightStick, 2);
    
    //moves to the next stage of shooting
    public JoystickButton advance = new JoystickButton(leftStick, 5);
    //moves to the previous state of shooting
    public JoystickButton abort = new JoystickButton(leftStick, 4);
    
    // turns the compressor on/off
    public JoystickButton toggle = new JoystickButton(rightStick, 10);
    public void run() {
        toggle.whenReleased(new ToggleCompressor());
        reverseDrive.whenActive(new ReverseTankDrive());
        reverseDrive.whenInactive(new TankDrive());
    }
}

