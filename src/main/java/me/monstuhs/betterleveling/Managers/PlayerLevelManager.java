/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package me.monstuhs.betterleveling.Managers;

import java.util.HashMap;
import java.util.Map.Entry;
import org.bukkit.entity.Player;

/**
 *
 * @author James
 */
public class PlayerLevelManager {
    
    public static void displayPlayerStats(Player player){
        HashMap<String, Integer> playerStats = new HashMap<String, Integer>();
        
        playerStats.put("Chance to Crit:  ", CombatManager.getChanceToCritPerLevel() * player.getLevel());
        playerStats.put("Chance to Dodge: ", CombatManager.getChanceToDodgePerLevel() * player.getLevel());
        playerStats.put("Chance to double-drop: ", MiningManager.getChanceToDoubleDropPerLevel() * player.getLevel());
        playerStats.put("Chance to insta-break: ", MiningManager.getChanceToBreakPerLevel() * player.getLevel());
        
        for(Entry<String, Integer> stat : playerStats.entrySet()){
            player.sendMessage(stat.getKey() + stat.getValue() + "%");
        }
    }
}
