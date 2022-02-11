package com.techelevator.view;

public class Gum extends Item{

    public Gum(String itemSlot, String name, double price, String itemType, int quantity) {
        super(itemSlot, name, price, itemType, quantity);
    }

    @Override
    public String getSound() {

        return "Chew Chew, Yum!";
    }
}
