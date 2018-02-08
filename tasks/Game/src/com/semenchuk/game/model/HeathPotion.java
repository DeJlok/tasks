package com.semenchuk.game.model;

/**
 * Created by MrWhite_PRO on 03.02.2018.
 */
public class HeathPotion extends Potion {

    public HeathPotion(String name) {
        super(name);
        System.out.println(name+" Health Potion has been created");
    }


    @Override
    public void useIt() {
        super.useIt();
        System.out.println(" +25HP");
    }
}
