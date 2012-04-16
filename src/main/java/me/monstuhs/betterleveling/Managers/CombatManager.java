/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package me.monstuhs.betterleveling.Managers;

import java.util.Random;
import me.monstuhs.betterleveling.BetterLeveling;
import me.monstuhs.betterleveling.Utilities.ConfigConstants;
import me.monstuhs.betterleveling.Utilities.PlugginLogging;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;

/**
 *
 * @author James
 */
public class CombatManager {

    private static int _chanceToDodgePerLevel = 0;
    private static double _dodgeDamageModifier = 1;
    private static int _chanceToCritPerLevel = 0;
    private static double _critDamageModifier = 1;
    private static double _headshotDamageModifier = 1;
    private static int _maxCritChance = 100;
    private static int _maxDodgeChance = 100;
    

    public CombatManager() {
        _chanceToDodgePerLevel = BetterLeveling.ConfigManager.getConfigFile().getInt(ConfigConstants.CombatActivities.ACTIVITY_COMBAT_PpL_DODGE);
        _dodgeDamageModifier = BetterLeveling.ConfigManager.getConfigFile().getDouble(ConfigConstants.GlobalSettings.SETTINGS_COMBAT_DODGE_MODIFIER) / 100;
        
        _chanceToCritPerLevel = BetterLeveling.ConfigManager.getConfigFile().getInt(ConfigConstants.CombatActivities.ACTIVITY_COMBAT_PpL_CRIT);
        _critDamageModifier = BetterLeveling.ConfigManager.getConfigFile().getDouble(ConfigConstants.GlobalSettings.SETTINGS_COMBAT_CRIT_MODIFIER) / 100;
        _headshotDamageModifier = BetterLeveling.ConfigManager.getConfigFile().getDouble(ConfigConstants.GlobalSettings.SETTINGS_COMBAT_HEADSHOT_MODIFIER) / 100;
        _maxCritChance = BetterLeveling.ConfigManager.getConfigFile().getInt(ConfigConstants.GlobalSettings.SETTINGS_COMBAT_MAX_CRIT_CHANCE);
        _maxDodgeChance = BetterLeveling.ConfigManager.getConfigFile().getInt(ConfigConstants.GlobalSettings.SETTINGS_COMBAT_MAX_DODGE_CHANCE);
    }

    public static int getDamageAfterDodgeAttempt(Player defender, int originalDamage) {
        
        int roll = new Random().nextInt(100);
        int newDamage = originalDamage;
        boolean doesPlayerDodge = roll <= Math.min((defender.getLevel() * _chanceToDodgePerLevel), _maxDodgeChance);
        if (doesPlayerDodge) {
            newDamage = (int) (originalDamage * _dodgeDamageModifier);
            defender.sendMessage(ChatColor.DARK_PURPLE + "Dodge! (" + newDamage + " / " + originalDamage + ")");            
        }
        return newDamage;
    }
    
    public static int getDamageAfterCritAttempt(Player attacker, int originalDamage){
        int roll = new Random().nextInt(100);
        boolean doesPlayerCrit =  roll <= Math.min((attacker.getLevel() * _chanceToCritPerLevel), _maxCritChance);        
        if(doesPlayerCrit){
            attacker.sendMessage(ChatColor.BLUE + "Critical Hit! (x " + _critDamageModifier + ")");
            originalDamage *= _critDamageModifier;
            PlugginLogging.WriteMessageToConsole("CRIT: " + attacker.getName() + " crit'd and dealt " + originalDamage);
        }
        return originalDamage;
    }
    
    public static int getDamageAfterHeadshotAttempt(Arrow arrow, LivingEntity defender, int originalDamage){
        Location pointOfContact = arrow.getLocation();
        Location eyeLocation = defender.getEyeLocation();        
        
        double yOffset = pointOfContact.getY() - eyeLocation.getY();
//        double xOffset = pointOfContact.getX() - eyeLocation.getX();
//        double zOffset = pointOfContact.getZ() - eyeLocation.getZ();
        
        if (Math.abs(yOffset) >= 0.75) {
            
            ((Player)arrow.getShooter()).sendMessage(ChatColor.RED + "Headshot! (x " + _headshotDamageModifier + ")");
            originalDamage *= _headshotDamageModifier;
            PlugginLogging.WriteMessageToConsole("HEADSHOT: " + defender.toString() + " was headshot for " + originalDamage);
        }
        return originalDamage;
    }
}