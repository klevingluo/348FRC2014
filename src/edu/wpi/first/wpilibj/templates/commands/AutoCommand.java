/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.wpi.first.wpilibj.templates.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.templates.commands.catapult.AutoShoot;
import edu.wpi.first.wpilibj.templates.commands.catapult.Reload;

/**
 *
 * @author programming
 */
public class AutoCommand extends CommandGroup {
    
    public AutoCommand() {
        addSequential(new DriveForwards(2));
        addSequential(new AutoShoot());
        addSequential(new Reload());
    }
}
