package com.semenchuk.game.model;



/**
 * Created by MrWhite_PRO on 04.02.2018.
 */
public interface IStackable extends IInventory {
    boolean stackable=true;
    boolean isItStackable();
    void useIt();
}
