package com.techelevator.view;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.*;
import com.techelevator.view.Menu;

import javax.management.ListenerNotFoundException;
import javax.print.DocFlavor;

public class VendingMachine {
    private Item item;
    private Map<String, Double> inventory;
    private List<String> itemList;
    private int quantity = 5;
    private double currentBalance = 0.00;
    private double moneyDeposited;
    private double moneySpent;
    private String refund;



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

    public void feedMoney(){
         += moneyDeposited;
        System.out.println(currentBalance);
    }
}
