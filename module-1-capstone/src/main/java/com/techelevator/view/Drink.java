package com.techelevator.view;

public class Drink extends Item {

    public Drink(String name, String price) {
        super(name, price);
    }

    @Override
    public String getSound() {
        return "\"Glug Glug, Yum!\"\n";
    }

}