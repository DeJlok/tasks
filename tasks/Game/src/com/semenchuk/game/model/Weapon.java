package com.semenchuk.game.model;



/**
 * Created by MrWhite_PRO on 03.02.2018.
 */
public class Weapon implements IInventory {
    private String name="";
    private int amount=1;

    public Weapon(String name) {
        this.name = name;
        System.out.println(name+" Weapon has been created");
    }

    public void tryIt(){
        putOn();
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
    public String getName() {
        return name;
    }

    @Override
    public boolean isItStackable() {
        return stackable;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }


    public void putOn() {
        System.out.println(name+" Weapon has been putted on");
    }

    @Override
    public void castOut() {
        System.out.println(name+" Weapon has been casted out");
    }


}
