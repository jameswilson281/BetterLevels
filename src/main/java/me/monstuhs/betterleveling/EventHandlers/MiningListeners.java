/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package me.monstuhs.betterleveling.EventHandlers;

import me.monstuhs.betterleveling.EventHandlers.CustomEvents.BonusBlockDamageEvent;
import me.monstuhs.betterleveling.Managers.MiningManager;
import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockDamageEvent;

/**
 *
 * @author James
 */
public class MiningListeners implements Listener {

    @EventHandler(priority = EventPriority.NORMAL, ignoreCancelled = true)
    public void onBlockDamage(BlockDamageEvent event) {
        if (event instanceof BonusBlockDamageEvent == false) {
            int extraSwings = MiningManager.getExtraSwingsForMining(event);
            for (int i = 0; i < extraSwings; i++) {
                Bukkit.getPluginManager().callEvent(new BonusBlockDamageEvent(event));
            }
        }
    }

    @EventHandler(priority = EventPriority.NORMAL, ignoreCancelled = false)
    public void onBlockBreak(BlockBreakEvent event) {
        MiningManager.removeBlockFromDamageTracker(event.getBlock());
    }
}
