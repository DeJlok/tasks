package com.semenchuk.game.model;

/**
 * Created by MrWhite_PRO on 03.02.2018.
 */
public class ManaPotion extends Potion {

    public ManaPotion(String name) {
        super(name);
        System.out.println(name+" Mana potion has been created");

    }
    @Override
    public void useIt() {
        super.useIt();
        System.out.println(" +25MP");
    }
}
