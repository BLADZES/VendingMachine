package com.techelevator.view;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {
    private List<String> itemsConsumed = new ArrayList<>();

    public void addSoundToList(String itemSound) {
        itemsConsumed.add(itemSound);
    }

    public List<String> returnListOfSounds() {
        List<String> returnList = itemsConsumed;
        itemsConsumed = new ArrayList<>();
        return returnList;

    }
}