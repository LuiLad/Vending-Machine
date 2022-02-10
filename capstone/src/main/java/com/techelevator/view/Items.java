package com.techelevator.view;

public abstract class Items {
    private String name;
    private double price;
    private int quantity = 5;


    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }


    public int getQuantity() {
        return quantity;
    }

    public Items() {
    }

    public Items(String name, double price) {
        this.name = name;
        this.price = price;

    }

//    Method
    public abstract String getSound();



}
