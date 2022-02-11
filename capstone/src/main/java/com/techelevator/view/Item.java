package com.techelevator.view;

public abstract class Item {
    private String itemSlot;
    private String name;
    private double price;
    private String itemType;
    private int quantity;

    public String getItemSlot() {
        return itemSlot;
    }

    public void setItemSlot(String itemSlot) {
        this.itemSlot = itemSlot;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getItemType() {
        return itemType;
    }

    public void setItemType(String itemType) {
        this.itemType = itemType;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    public Item(String itemSlot, String name, double price, String itemType, int quantity) {
        this.itemSlot = itemSlot;
        this.name = name;
        this.price = price;
        this.itemType = itemType;
        this.quantity = quantity;
    }

    //    Method
    public abstract String getSound();

}
