/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package me.monstuhs.betterleveling.Utilities;

import java.text.DecimalFormat;

/**
 *
 * @author James
 */
public class BukkitHelpers {
    private static final long TASK_TICKS_PER_SECOND = 20L;    
    
    public static long getDelay(long intervalInSeconds){
        return TASK_TICKS_PER_SECOND * intervalInSeconds;
    }
    
    public static long getSecondsFromTics(long ticks){
        return ticks/TASK_TICKS_PER_SECOND;
    }
    
    public static String formatDouble(double number){
        DecimalFormat threeDec = new DecimalFormat("0.000");
        threeDec.setGroupingUsed(false);
        return threeDec.format(number);
    }
}
