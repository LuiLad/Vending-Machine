package com.techelevator.view;

public abstract class Items {
    private String name;
    private double price;

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
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
