package com.techelevator.view;

public class Chip extends Item {

    public Chip(String name, String price) {
        super(name, price);
    }

    @Override
    public String getSound() {
        return "\"Crunch Crunch, Yum!\"\n";
    }

}