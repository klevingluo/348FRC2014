
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
    public Joystick leftStick = new Joystick(2);
    public Joystick rightStick = new Joystick(1);
    public Joystick coDriver = new Joystick(3);
    
    public JoystickButton stopComp = new JoystickButton(coDriver, 11);
    public JoystickButton dance = new JoystickButton(coDriver, 1);
    public JoystickButton startComp = new JoystickButton(coDriver, 12);
    
    public JoystickButton waiter = new JoystickButton(coDriver, 7);
    public JoystickButton aimer = new JoystickButton(coDriver, 8);
    
    // while pressed, the robot drives backwards
    public JoystickButton reverseDrive = new JoystickButton(leftStick, 4);
    // while pressed, the robot drives backwards
    public JoystickButton normalDrive = new JoystickButton(rightStick, 5);
    // lowers arms and picks up
    public JoystickButton pick = new JoystickButton(leftStick, 3);
    // raises arms and ejects
    public JoystickButton eject = new JoystickButton(rightStick, 3);
    //moves to the next stage of shooting
    public JoystickButton advance = new JoystickButton(rightStick, 1);
    
    public OI() {
        startComp.whenPressed(new CompressorON());
        stopComp.whenPressed(new CompressorOFF());
        reverseDrive.whenPressed(new ReverseTankDrive());
        normalDrive.whenPressed(new TankDrive());
        pick.whileHeld(new BallPickup());
        eject.whileHeld(new BallEject());
        dance.whileHeld(new CrazyDance());
        waiter.whileHeld(new Wait());
        aimer.whileHeld(new Aim());
    }
}