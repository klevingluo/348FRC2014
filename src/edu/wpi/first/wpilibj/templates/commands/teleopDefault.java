/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.commands;


import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.templates.commands.catapult.LauncherManual;

/**
 *
 * @author kluo
 */
public class teleopDefault extends CommandGroup{
    
    public teleopDefault() {
        addParallel(new TankDrive());
        addParallel(new RollerManual());
        addParallel(new RaiserManual());
        addParallel(new LauncherManual());
    }
}
