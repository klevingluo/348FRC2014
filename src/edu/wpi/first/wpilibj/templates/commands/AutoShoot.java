/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.wpi.first.wpilibj.templates.commands;

import edu.wpi.first.wpilibj.templates.commands.catapult.Shoot;
import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.templates.commands.catapult.Load;

/**
 *
 * @author kluo
 */
public class AutoShoot extends CommandGroup {
    public AutoShoot() {
        addSequential(new Aim());
        addParallel(new Load());
        addSequential(new Shoot());
    }
}
