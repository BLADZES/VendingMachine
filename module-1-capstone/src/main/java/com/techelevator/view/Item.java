package com.techelevator.view;

public abstract class Item {

    private String name;
    private String price;

    public Item(String name, String price) {
        this.name = name;
        this.price = price;
    }

    public abstract String getSound();

    public String getName() {
        return name;
    }

    public String getPriceAsString() {
        return price;
    }

    public int getPriceAsIntInPennies() {
        price = price.replace("$", "").replace(".", "");
        return Integer.parseInt(price);
    }
}