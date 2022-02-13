package com.techelevator.view;

import java.math.BigDecimal;

<<<<<<< HEAD
    public Gum(String name, double price) {
        super(name, price);
    }
=======
public class Gum extends Item {
>>>>>>> d1b7eb9ee7481b9bac815182113582a32c7c38b3

    public Gum(String itemSlot, String name, BigDecimal price, String itemType) {
        super(itemSlot, name, price, itemType);
    }
    @Override
    public String getSound() {
        return "Chew Chew, Yum!";
    }
}
