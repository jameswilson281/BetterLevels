/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package me.monstuhs.betterleveling.Utilities;

/**
 *
 * @author James
 */
public class ConfigConstants {

    public class MiningActivities {

        public static final String ACTIVITY_MINING_PpL_INSTABREAK = "activity.mining.PercentageChancePerLevelToInstaBreak";
        public static final String ACTIVITY_MINING_PpL_DOUBLE_DROP = "activity.mining.PercentageChancePerLevelToDoubleDrop";
    }

    public class CombatActivities {

        public static final String ACTIVITY_COMBAT_PpL_DODGE = "activity.combat.PercentageChancePerLevelToDodge";
        public static final String ACTIVITY_COMBAT_PpL_CRIT = "activity.combat.PercentageChancePerLevelToCrit";        
    }
    
    public class PassiveActivities {
        public static final String ACTIVITY_PASSIVE_REGEN_HH_PER_LEVEL = "activity.passive.regeneration.HalfheartsPerLevel";
        public static final String ACTIVITY_PASSIVE_REGEN_DELAY = "activity.passive.regeneration.RegenIntervalInSeconds";
    }
    
    public class GlobalSettings {
        
        public static final String WORLD_NAME = "settings.WorldName";
        public static final String SETTINGS_COMBAT_DODGE_MODIFIER = "settings.combat.PercentageDamageFromDodge";
        public static final String SETTINGS_COMBAT_CRIT_MODIFIER = "settings.combat.PercentageDamageFromCrit";
        public static final String SETTINGS_COMBAT_HEADSHOT_MODIFIER = "settings.combat.PercentageDamageFromHeadshot";
        public static final String SETTINGS_COMBAT_MAX_CRIT_CHANCE = "settings.combat.MaximumChanceForCrit";
        public static final String SETTINGS_COMBAT_MAX_DODGE_CHANCE = "settings.combat.MaximumChanceForDodge";
    }
}
