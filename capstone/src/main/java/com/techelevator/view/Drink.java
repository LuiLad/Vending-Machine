package com.techelevator.view;

public class Drink extends Item{

    public Drink(String itemSlot, String name, double price, String itemType, int quantity) {
        super(itemSlot, name, price, itemType, quantity);
    }

    @Override
    public String getSound() {
        return null;
    }

}
