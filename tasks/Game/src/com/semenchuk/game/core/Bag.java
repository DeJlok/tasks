package com.semenchuk.game.core;

import com.semenchuk.game.model.IInventory;

import java.util.ArrayList;
/**
 * Created by MrWhite_PRO on 03.02.2018.
 */
public class Bag {
    private ArrayList<IInventory> arr = new ArrayList<>();

    public void addInv(IInventory inventory) {
        if (inventory.isItStackable()) {
            if (getKey(inventory) >= 0) {
                arr.get(getKey(inventory)).setAmount(arr.get(getKey(inventory)).getAmount() + inventory.getAmount());
            } else
                arr.add(arr.size(), inventory);
        } else {
            arr.add(arr.size(), inventory);
        }
    }

    public int getKey(IInventory inventory) {
        int rezult = -1;
        for (int i = 0; i < arr.size(); i++) {
            if (arr.get(i).getClass() == inventory.getClass()) {
                rezult = i;
            }
        }
        return rezult;
    }

    public void whatInTheBag() {
        arr.forEach((v) -> System.out.println(v.getName() + " " + v.getAmount()));
    }

    public void replace(int el1, int el2) {
        if (el1 >= arr.size() || el2 >= arr.size()) {
            System.out.println("you chose empty cell");
        } else {
            if (el1 < el2) {
                switchPlaces(el1, el2);
            } else if (el2 < el1) {
                switchPlaces(el2, el1);
            }
        }
    }

    public void switchPlaces(int el1, int el2) {
        arr.add(el1, arr.get(el2));
        arr.add(el2 + 1, arr.get(el1 + 1));
        arr.remove(el1 + 1);
        arr.remove(el2 + 1);
    }
    public void tryIt(int el){
        if(el<arr.size()) {
            arr.get(el).tryIt();
        }else
            System.out.println("this cell cant be used because it empty");
        if(arr.get(el).getAmount()<1){
            castOut(el);
        }
    }

    public void castOut(int el){
        if(el<arr.size()) {
            arr.get(el).castOut();
            arr.remove(el);
        }
        else
            System.out.println("this cell cant be deleted because it empty");
    }

}
