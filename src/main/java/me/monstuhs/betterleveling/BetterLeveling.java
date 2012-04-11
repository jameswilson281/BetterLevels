/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package me.monstuhs.betterleveling;

import me.monstuhs.betterleveling.EventHandlers.CombatListeners;
import me.monstuhs.betterleveling.EventHandlers.MiningListeners;
import me.monstuhs.betterleveling.Managers.ConfigurationManager;
import me.monstuhs.betterleveling.Managers.MiningManager;
import me.monstuhs.betterleveling.Managers.PlayerLevelManager;
import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

/**
 *
 * @author James
 */
public class BetterLeveling extends JavaPlugin {
    public static ConfigurationManager ConfigManager;
    public static PlayerLevelManager PlayerLvlManager;
    public static MiningManager MiningManager;
    
    private static PluginManager _pluginManager = Bukkit.getPluginManager();;
    
    @Override
    public void onDisable(){
        
    }
    
    @Override
    public void onEnable() {        
        ConfigManager = new ConfigurationManager(this);
        PlayerLvlManager = new PlayerLevelManager();
        MiningManager = new MiningManager();
        
        _pluginManager.registerEvents(new MiningListeners(), this);
        _pluginManager.registerEvents(new CombatListeners(), this);
    }
    
    public void saveConfigurationFile(){
        saveConfig();
    }
}
