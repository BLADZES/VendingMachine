package com.techelevator.view;
import java.io.File;
import java.io.IOException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class VendingMachineTest {
    private Inventory vendingMachineInventory;
    private CoinBox vendingMachineCoinBox;
    private FileReader vendingMachineFileReader;
    private VendingMachine vendingMachineTest;
    private Drink drinkTest;
    private Inventory inventoryTest;
    private CoinBox coinBoxTest;
    private ShoppingCart shoppingCartTest;

    @Before
    public void setup() throws IOException{
        vendingMachineFileReader = new FileReader();
        vendingMachineInventory = new Inventory(vendingMachineFileReader);
        vendingMachineTest = new VendingMachine(vendingMachineInventory);
        vendingMachineCoinBox = new CoinBox();
        drinkTest = new Drink("Mountain Melter", "1.50");
        inventoryTest = new Inventory(new FileReader());
        coinBoxTest = new CoinBox();
        shoppingCartTest = new ShoppingCart();
    }

    @Test
    public void RETURN_CORRECT_BALANCE(){
        vendingMachineCoinBox.addMoney(5);
        Assert.assertEquals("Money not added!",500, vendingMachineCoinBox.getBalanceInPennies());
    }
    @Test
    public void SOUND_RETURN_TEST(){
        Assert.assertEquals("Incorrect sound type","\"Glug Glug, Yum!\"", drinkTest.getSound());
    }

    @Test
    public void CHECK_INTIAL_INVENTORY(){
        Assert.assertEquals("Not the correct amount! Should be 5.",5, inventoryTest.returnCurrentInventory("A1"));
    }

    @Test
    public void SUBTRACT_FROM_INVENTORY(){
        inventoryTest.subtractFromInventory("A1");
        Assert.assertEquals("Should be 4", 4, inventoryTest.returnCurrentInventory("A1"));
    }

    @Test
    public void CORRECT_AMOUNT_DEPOSITED(){
        coinBoxTest.addMoney(1);
        Assert.assertEquals(100, coinBoxTest.getBalanceInPennies());
    }

    @Test
    public void CORRECT_AMOUNT_WITHDRAW(){
        coinBoxTest.addMoney(1);
        coinBoxTest.withdrawMoney(25);
        Assert.assertEquals(75, coinBoxTest.getBalanceInPennies());
    }

    @Test
    public void PURCHASE_ITEM_NOT_INVENTORY() throws IOException{
        Assert.assertEquals("Please Make A Valid Selection \n", vendingMachineTest.purchaseItem("B999"));
    }

    @Test
    public void PURCHASE_ITEM_IS_GREATER() throws IOException{
        vendingMachineTest.feedMoney(1);
        Assert.assertEquals("Please Insert Additional Funds \n", vendingMachineTest.purchaseItem("A1"));
    }
//    @Test
//    public void CORRECT_CHANGE(){
//        coinBoxTest.addMoney(1);
//        coinBoxTest.withdrawMoney(9);
//        //Assert.assertEquals("Your change is 1 quarters, 1 dimes, and 1 nickels.", coinBoxTest.returnChangeAsCoins(91).toString());
//        System.out.println(coinBoxTest.returnChangeAsCoins(41));
//
//    }
}
