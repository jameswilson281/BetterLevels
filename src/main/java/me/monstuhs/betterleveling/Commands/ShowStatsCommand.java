/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package me.monstuhs.betterleveling.Commands;

import me.monstuhs.betterleveling.BetterLeveling;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

/**
 *
 * @author James
 */
public class ShowStatsCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        
        if (sender instanceof Player){
            BetterLeveling.PlayerLvlManager.displayPlayerStats((Player)sender);
        }
        return true;
    }
    
}
