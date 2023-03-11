package com.techelevator.view;

import java.util.Map;
import java.util.TreeMap;

public class Inventory {

    private FileReader fileReaderObject;
    private TreeMap<String, Integer> inventoryList = new TreeMap<String, Integer>();

    public Inventory(FileReader fileReaderObject) {
        this.fileReaderObject = fileReaderObject;
        stocksVendingMachineAtStartup();
    }

    private void stocksVendingMachineAtStartup() {
        for (String[] item : fileReaderObject.inventoryAsArrayList()) {
            int initalStock = 5;
            inventoryList.put(item[0], initalStock);
        }
    }

    public Map<String, Item> vendingMachineStock() {
        return fileReaderObject.createMapOfLocationAndItems();
    }

    public void subtractFromInventory(String slotLocation) {
        inventoryList.put(slotLocation, inventoryList.get(slotLocation) - 1);
    }

    public int returnCurrentInventory(String slotLocation) {
        return inventoryList.get(slotLocation);
    }

    public Map<String, Integer> returnInventoryMap() {
        return inventoryList;
    }
}