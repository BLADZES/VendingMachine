package com.techelevator.view;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Menu  {

	private PrintWriter out;
	private Scanner in;
	private FileReader vendingMachineFileReader = new FileReader();
	private Inventory inventory = new Inventory(vendingMachineFileReader);
	private VendingMachine vendingMachine = new VendingMachine(inventory);

	public Menu(InputStream input, OutputStream output)throws IOException {
		this.out = new PrintWriter(output);
		this.in = new Scanner(input);
		inventory.vendingMachineStock();

	}

	public Object getChoiceFromOptions(Object[] options) {
		Object choice = null;
		while (choice == null) {
			displayMenuOptions(options);
			choice = getChoiceFromUserInput(options);
		}
		return choice;
	}

	private Object getChoiceFromUserInput(Object[] options) {
		Object choice = null;
		String userInput = in.nextLine().toUpperCase();
		try {
			int selectedOption = Integer.valueOf(userInput);

			if (selectedOption > 0 && selectedOption <= options.length) {
				choice = options[selectedOption - 1];
			}
		} catch (NumberFormatException e) {
		}
		if (choice == null) {
			out.println("\n*** " + userInput + " is not a valid option ***\n");
		}
		return choice;
	}

	private void displayMenuOptions(Object[] options) {
		out.println();
		for (int i = 0; i < options.length; i++) {
			int optionNum = i + 1;
			out.println(optionNum + ") " + options[i]);
		}
		out.print("\nPlease choose an option >>> ");
		out.flush();
	}


	public void diplayInventory() {
		for (String eachLine : vendingMachine.getInventoryString()) {
			System.out.println(eachLine);
		}
	}

	public void feedMoney() throws IOException {
		System.out.println("Please Insert U.S. Dollar Bills");
		try {
			int moneyInserted = in.nextInt();
			in.nextLine();
			if (moneyInserted == 1 || moneyInserted == 2 || moneyInserted == 5 || moneyInserted == 10
					|| moneyInserted == 20 || moneyInserted == 50 || moneyInserted == 100) {
				vendingMachine.feedMoney(moneyInserted);
				System.out.println("Thank You For inserting $" + moneyInserted + ".00");
			} else {
				System.out.println("Please Insert Valid Currency");
			}
		} catch (InputMismatchException e) {
			System.out.println("Please Insert Valid Currency");
		}

	}

	public void selectProduct() throws IOException {
		System.out.println("Please Select Product");
		String userSelection = in.nextLine();
		String returnString = vendingMachine.purchaseItem(userSelection);
		System.out.println(returnString);

	}

	public String displayCurrentBalance() {
		return vendingMachine.getBalanceAsString();

	}

	public void finishTransaction() throws IOException {
		System.out.println(vendingMachine.returnChangeInCoins());
	}

	public void returnSoundMessages() {
		for (String eachLine : vendingMachine.returnSounds()) {
			System.out.println(eachLine);
		}

	}
}