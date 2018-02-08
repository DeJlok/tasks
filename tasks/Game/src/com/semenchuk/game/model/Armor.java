package com.semenchuk.game.model;

/**
 * Created by MrWhite_PRO on 03.02.2018.
 */
public class Armor implements IInventory {
    private String name = "";
    private int amount = 1;

    public Armor(String name) {
        this.name = name;
        System.out.println(name+" Armor has been created");
    }

    @Override
    public int getAmount() {
        return amount;
    }

    @Override
    public void setAmount(int amount) {
        this.amount = amount;
    }

    @Override
    public boolean isItStackable() {
        return IInventory.stackable;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void castOut() {
        System.out.println(name+" Armor has been casted out");
    }

    public void putOn() {
        System.out.println(name+" Armor has been putted on");
    }

    public void tryIt(){
        putOn();
    }
}
