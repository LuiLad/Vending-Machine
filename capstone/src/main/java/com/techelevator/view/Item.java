package com.techelevator.view;

import java.math.BigDecimal;

public abstract class Item {

    private String name;
<<<<<<< HEAD
    private double price;
=======
    private BigDecimal price;
    private String itemType;
    private int quantity = 5;
>>>>>>> d1b7eb9ee7481b9bac815182113582a32c7c38b3



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }


<<<<<<< HEAD
    public Item(String name, double price) {
        this.name = name;
        this.price = price;

=======
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Item(String itemSlot, String name, BigDecimal price, String itemType) {
        this.itemSlot = itemSlot;
        this.name = name;
        this.price = price;
        this.itemType = itemType;
>>>>>>> d1b7eb9ee7481b9bac815182113582a32c7c38b3
    }

    //    Method
    public abstract String getSound();

}
