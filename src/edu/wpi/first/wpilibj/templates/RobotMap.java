package edu.wpi.first.wpilibj.templates;

import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.AnalogPotentiometer;
import edu.wpi.first.wpilibj.AnalogChannel;
import edu.wpi.first.wpilibj.camera.AxisCamera;
import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Relay;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.networktables.NetworkTable;
import edu.wpi.first.wpilibj.templates.commands.CommandBase;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
    
    // PWM Motor controllers, plugged into the digital sidecar
    public static Talon leftDrive = new Talon(9);
    public static Talon rightDrive = new Talon(8);
    public static Talon raiserMotor = new Talon(10);
    
    
    // Relays, plug into relay sections on digital sidecar
    public static Relay rightRoller = new Relay(2);
    public static Relay leftRoller = new Relay(1);
    public static Relay compressor = new Relay(3);
    
    // Analog Sensors, plug into analog module
    public static AnalogPotentiometer raiserAngle = new AnalogPotentiometer(3);
    public static AnalogChannel pressureSensor = new AnalogChannel(4);
    
    // Digital Sensors, plug into digital io module
    public static DigitalInput catapultArm = new DigitalInput(2);
    public static DigitalInput pressureSwitch = new DigitalInput(5);
    
    //Solenoid, plug into solenoid modules
    public static Solenoid vacuumA = new Solenoid(1);
    public static Solenoid vacuumB = new Solenoid(2);
    public static Solenoid pressureRelease = new Solenoid(3);
    public static Solenoid pressureLockA = new Solenoid(4);
    public static Solenoid pressureLockB = new Solenoid(5);
    public static Solenoid latchA = new Solenoid(6);
    public static Solenoid latchB = new Solenoid(7);
    
    // Camera
    public static AxisCamera camera = AxisCamera.getInstance("10.3.48.11");
    public static NetworkTable nettab = NetworkTable.getTable("");
    
    // diagnostic values
    public static void init() {
        SmartDashboard.putNumber("shooting pressure", pressureSensor.getVoltage());
        SmartDashboard.putBoolean("compressor status:", CommandBase.compressor.isOn());
        SmartDashboard.putBoolean("pressure switch", pressureSwitch.get());
        
        LiveWindow.addActuator("Raiser", "pid", CommandBase.raiser.getPIDController());
        LiveWindow.addSensor("Raiser", "Angle", CommandBase.raiser.armAngle);
    }
}
