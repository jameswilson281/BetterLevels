/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package me.monstuhs.betterleveling.Runnables;

import org.bukkit.Bukkit;

/**
 *
 * @author James
 */
public class HeartBeatTask implements Runnable {

    public void run() {
        Bukkit.getServer().broadcastMessage("Tick");
    }
    
}
