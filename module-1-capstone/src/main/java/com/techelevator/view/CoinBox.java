package com.techelevator.view;

public class CoinBox {
    public int balance;

    public CoinBox() {
        balance = 0;
    }

    public void addMoney(int amountToDeposit) {
        balance = balance + (amountToDeposit * 100);
    }

    public void withdrawMoney(int amountToWithdraw) {
        balance = balance - (amountToWithdraw);
    }

    public int getBalanceInPennies() {
        return balance;
    }

    public String getBalanceAsString() {
        int currentBalanceAsInt = balance;
        double currentBalanceAsDouble = (currentBalanceAsInt / 100.00);
        String formattedDoubleAsString = "$" + String.format("%.2f", currentBalanceAsDouble);
        return formattedDoubleAsString;

    }

    public String returnChangeAsCoins(int balance) {
        int tracker = balance;

        int totalQuartersToReturn = 0;
        int totalDimesToReturn = 0;
        int totalNickelsToReturn = 0;

        int quarter = 25;
        int dime = 10;
        int nickel = 5;

        while (tracker > 0) {
            if (tracker >= quarter) {
                totalQuartersToReturn++;
                tracker -= quarter;
            } else if (tracker >= dime) {
                totalDimesToReturn++;
                tracker -= dime;
            } else if (tracker >= nickel) {
                totalNickelsToReturn++;
                tracker -= nickel;

            }

        }

        this.balance = 0;

        String returnString = "Your change is " + totalQuartersToReturn + " quarters, " + totalDimesToReturn
                + " dimes, " + "and " + totalNickelsToReturn + " nickels.";
        return returnString;
    }

}