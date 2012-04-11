/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package me.monstuhs.betterleveling.Managers;

import java.util.Collections;
import java.util.HashMap;
import me.monstuhs.betterleveling.BetterLeveling;
import me.monstuhs.betterleveling.Managers.Models.DamagedBlock;
import me.monstuhs.betterleveling.Utilities.ConfigConstants;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.block.BlockDamageEvent;

/**
 *
 * @author James
 */
public class MiningManager {
    
    private static HashMap<Integer, DamagedBlock>  _blockDamageTracker;
    private static int _percentageIncreasePerLevel = 0;
    
    public MiningManager(){
        _blockDamageTracker = new HashMap<Integer,DamagedBlock>();
        _percentageIncreasePerLevel = BetterLeveling.ConfigManager.getConfigFile().getInt(ConfigConstants.ACTIVITY_MINING_PERCENTAGE_INCREASE_PER_LEVEL);
    }    
    
    public static int getExtraSwingsForMining(BlockDamageEvent miningEvent){        
        
        Block thisBlock = miningEvent.getBlock();
        Player miner = miningEvent.getPlayer();
        int blockHash = thisBlock.hashCode();       
        int playerHash = miner.hashCode();
        
        if(_blockDamageTracker.containsKey(playerHash) == false || 
           _blockDamageTracker.get(playerHash).Id != blockHash){
            _blockDamageTracker.put(blockHash, new DamagedBlock(blockHash));
        }
        
        
        
        DamagedBlock damagedBlock = _blockDamageTracker.get(blockHash);
        damagedBlock.PercentToNextExtraSwing += getAdditionalMiningDamage(miner);        
        
        
        int extraSwings = damagedBlock.PercentToNextExtraSwing / 100;
        
        if(damagedBlock.PercentToNextExtraSwing >= 100){
            damagedBlock.PercentToNextExtraSwing = 0;        
        }
        
        return extraSwings;
    }
    
    public static void removeBlockFromDamageTracker(Block block){
        //We need to remove this block from ALL player lists not just one player
        _blockDamageTracker.values().removeAll(Collections.singleton(block.hashCode()));
    }
    
    private static int getAdditionalMiningDamage(Player miner){
        return miner.getLevel() * _percentageIncreasePerLevel;
        
    }
}
