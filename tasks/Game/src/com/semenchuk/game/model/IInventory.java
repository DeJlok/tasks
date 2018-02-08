package com.semenchuk.game.model;

/**
 * Created by MrWhite_PRO on 03.02.2018.
 */
public interface IInventory {
    boolean stackable=false;
    void castOut();
    void setName(String str);
    void setAmount(int amount);
    int getAmount();
    String getName();
    void tryIt();
    boolean isItStackable();


}
