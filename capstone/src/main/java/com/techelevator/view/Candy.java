package com.techelevator.view;

import java.math.BigDecimal;

<<<<<<< HEAD
    public Candy(String name, double price) {
        super(name, price);
=======
public class Candy extends Item {

    public Candy(String itemSlot, String name, BigDecimal price, String itemType) {
        super(itemSlot, name, price, itemType);
>>>>>>> d1b7eb9ee7481b9bac815182113582a32c7c38b3
    }

    @Override
    public String getSound() {
        return "Munch Munch, Yum!";
    }


}
