package com.semenchuk.game;


import com.semenchuk.game.core.Bag;
import com.semenchuk.game.model.*;

public class Main {

    public static void main(String[] args) {
        Bag smallBag=new Bag();
        Armor ar1=new Armor("Carmian boots");
        Weapon wp1=new Weapon("Draconnic Bow");
        Potion pt1=new ManaPotion(" Mana Potion");
        Potion pt4=new HeathPotion(" Health Potion");
        smallBag.addInv(pt1); //put in Potion
        smallBag.addInv(ar1); //put in Armor
        smallBag.addInv(wp1); //put in Weapon
        smallBag.addInv(pt4); //put in Health Potion
        smallBag.addInv(pt1); //put in Mana Potion
        smallBag.addInv(ar1); //put in Armor
        smallBag.addInv(wp1); //put in Weapon
        smallBag.addInv(pt4); //put in Health Potion
        smallBag.whatInTheBag();
        smallBag.replace(0,3);//change object position
        System.out.println("------------------------------------------");
        smallBag.whatInTheBag();
        smallBag.addInv(pt1); //put in Mana Potion
        System.out.println("------------------------------------------");
        smallBag.whatInTheBag();
        smallBag.tryIt(3);//try obj#3
        System.out.println("------------------------------------------");
        smallBag.whatInTheBag();
        smallBag.tryIt(3);//try obj#3
        System.out.println("------------------------------------------");
        smallBag.whatInTheBag();
    }
}
