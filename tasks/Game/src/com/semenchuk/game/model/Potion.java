package com.semenchuk.game.model;



/**
 * Created by MrWhite_PRO on 03.02.2018.
 */
public class Potion implements IStackable {
    private String name="";
    private int amount=1;

    public Potion(String name) {

        this.name = name;
    }

    public void tryIt(){
        useIt();
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
        return stackable;
    }

    @Override
    public void useIt() {
        this.setAmount(this.getAmount()-1);
        System.out.println("Potion has been used");
    }

    @Override
    public void castOut() {
        System.out.println("Potion has been casted out");
    }


    @Override
    public void setName(String name) {
        this.name=name;
    }

    @Override
    public String getName() {
        return name;
    }

}
