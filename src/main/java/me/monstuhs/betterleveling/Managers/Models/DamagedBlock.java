/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package me.monstuhs.betterleveling.Managers.Models;

/**
 *
 * @author James
 */
public class DamagedBlock {

    public int Id;
    public int PercentToNextExtraSwing;

    public DamagedBlock(int id) {
        Id = id;
        PercentToNextExtraSwing = 0;
    }
}
