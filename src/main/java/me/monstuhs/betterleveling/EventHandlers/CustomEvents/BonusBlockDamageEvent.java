/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package me.monstuhs.betterleveling.EventHandlers.CustomEvents;

import org.bukkit.event.block.BlockDamageEvent;

/**
 *
 * @author James
 */
public class BonusBlockDamageEvent extends BlockDamageEvent {
    
    public BonusBlockDamageEvent(BlockDamageEvent event){
        super(event.getPlayer(), event.getBlock(), event.getItemInHand(), event.getInstaBreak());
    }    
}
