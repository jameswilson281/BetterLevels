/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package me.monstuhs.betterleveling.Managers;

import me.monstuhs.betterleveling.Utilities.ConfigConstants;
import me.monstuhs.betterleveling.Utilities.PlugginLogging;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

/**
 *
 * @author James
 */
public class ConfigurationManager {
    private static JavaPlugin _plugin;
    private static FileConfiguration _configFile;

    /**
     * @return the _configFile
     */
    public static FileConfiguration getConfigFile() {
        return _configFile;
    }
    
    public ConfigurationManager(JavaPlugin thisPlugin){
        _plugin = thisPlugin;
        _configFile = _plugin.getConfig();
        createOrLoadConfig();
    }
    
    private void createOrLoadConfig() {
        PlugginLogging.WriteMessageToConsole("Creating/loading config");        
        getConfigFile().options().copyDefaults(true);        

        getConfigFile().addDefault(ConfigConstants.ACTIVITY_MINING_PERCENTAGE_INCREASE_PER_LEVEL, 5);
        getConfigFile().addDefault(ConfigConstants.ACTIVITY_COMBAT_DODGE_CHANCE_PER_LEVEL, 2);
        
        _plugin.saveConfig();
    }
}
