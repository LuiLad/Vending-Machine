package com.techelevator.view;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import com.techelevator.view.Menu;

import javax.management.ListenerNotFoundException;

public class VendingMachine{
    private Item item;
    private Map<String, Double> inventory;
    private List<String> itemList;
    private int quantity = 5;
    private double currentBalance = 0.00;
    private double moneyDeposited;
    private double moneySpent;
    private String refund;
//    private static final String PURCHASE_MENU_OPTION_FEED_MONEY = "Feed Money";
//	private static final String  PURCHASE_MENU_OPTION_SELECT_PRODUCT = "Select Product";
//	private static final String PURCHASE_MENU_OPTION_FINISH_TRANSACTION = "Finish Transaction";
//	private static final String[] PURCHASE_MENU_OPTIONS = { PURCHASE_MENU_OPTION_FEED_MONEY, PURCHASE_MENU_OPTION_SELECT_PRODUCT, PURCHASE_MENU_OPTION_FINISH_TRANSACTION };
//    private Menu menu;


    public void getInventory() {
        File vendingMachineList = new File("vendingmachine.csv");
        try (Scanner fileInput = new Scanner(vendingMachineList)) {

            while (fileInput.hasNextLine()) {
                String [] lineOfText = fileInput.nextLine().split("\\|");
                double price = Double.parseDouble(lineOfText[2]);
                System.out.println("Slot: " + lineOfText[0] + " | Item Name: " + lineOfText[1] + " | Price: " + price + " | Item Type: " + lineOfText[3] + " | Quantity: " + quantity);

            }

        }catch (FileNotFoundException e) {
                System.out.println("The file was not found");
        }catch (NumberFormatException e){
            System.out.println("Wrong Format");
        }
    }
    public double currentMoney(){
        return currentBalance;
    }
    public void feedMoney(){
        currentBalance += moneyDeposited;
        System.out.println(currentBalance);
    }
}
