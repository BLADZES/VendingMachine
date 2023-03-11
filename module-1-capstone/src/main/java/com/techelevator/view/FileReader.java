package com.techelevator.view;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.TreeMap;

public class FileReader {

    private String fileName = "vendingmachine.csv";
    private File inventoryFile = new File(fileName);

    private List<String> getListOfAllLines() {
        List<String> listOfInputFileLines = new ArrayList<String>();
        try (Scanner fileScanner = new Scanner(inventoryFile)) {
            while (fileScanner.hasNextLine()) {
                listOfInputFileLines.add(fileScanner.nextLine());
            }
        } catch (FileNotFoundException e) {
        }
        return listOfInputFileLines;

    }

    public List<String[]> inventoryAsArrayList() {

        List<String[]> inventoryArray = new ArrayList<String[]>();

        for (String currentString : getListOfAllLines()) {
            inventoryArray.add(currentString.split("\\|"));
        }
        return inventoryArray;

    }

    public TreeMap<String, Item> createMapOfLocationAndItems() {
        TreeMap<String, Item> inventoryMap = new TreeMap<String, Item>();
        for (String currentString : getListOfAllLines()) {
            String[] tempSplitString = currentString.split("\\|");
            if (tempSplitString[3].equals("Candy")) {
                Candy candy = new Candy(tempSplitString[1], tempSplitString[2]);
                inventoryMap.put(tempSplitString[0], candy);
            } else if (tempSplitString[3].equals("Chip")) {
                Chip chip = new Chip(tempSplitString[1], tempSplitString[2]);
                inventoryMap.put(tempSplitString[0], chip);
            } else if (tempSplitString[3].equals("Drink")) {
                Drink drink = new Drink(tempSplitString[1], tempSplitString[2]);
                inventoryMap.put(tempSplitString[0], drink);
            } else if (tempSplitString[3].equals("Gum")) {
                Gum gum = new Gum(tempSplitString[1], tempSplitString[2]);
                inventoryMap.put(tempSplitString[0], gum);
            }
        }
        return inventoryMap;
    }

}