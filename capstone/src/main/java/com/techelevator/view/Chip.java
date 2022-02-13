package com.techelevator.view;

import java.math.BigDecimal;

<<<<<<< HEAD
    public Chip(String name, double price) {
        super(name, price);
=======
public class Chip extends Item {

    public Chip(String itemSlot, String name, BigDecimal price, String itemType) {
        super(itemSlot, name, price, itemType);
>>>>>>> d1b7eb9ee7481b9bac815182113582a32c7c38b3
    }

    @Override
    public String getSound() {
        return "Crunch Crunch, Yum!";
    }

}
