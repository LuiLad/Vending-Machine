package com.techelevator.view;

public class Gum extends Item{

    public Gum(String name, double price) {
        super(name, price);
    }

    @Override
    public String getSound() {

        return "Chew Chew, Yum!";
    }
}
