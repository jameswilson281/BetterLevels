/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package me.monstuhs.betterleveling.Utilities;

/**
 *
 * @author James
 */
public class BukkitHelpers {
    private static final long TASK_TICKS_PER_SECOND = 20L;    
    
    public static long getDelay(long intervalInSeconds){
        return TASK_TICKS_PER_SECOND * intervalInSeconds;
    }
}
