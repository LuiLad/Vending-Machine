package com.techelevator.view;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class VendingMachine {

    private Map<String, Double> itemList = new HashMap<>();
    public VendingMachine() {
    }

    public void getInventory() {
        File vendingMachineList = new File("vendingmachine.csv");
        try (Scanner fileInput = new Scanner(vendingMachineList)) {

            while (fileInput.hasNextLine()) {
                String [] lineOfText = fileInput.nextLine().split("\\|");
                double price = Double.parseDouble(lineOfText[2]);
                itemList.put(lineOfText[0], price);
                System.out.println("Slot: " + lineOfText[0] + " | Item Name: " + lineOfText[1] + " | Price: " + price);
            }

        }catch (FileNotFoundException e) {
                System.out.println("The file was not found");
        }catch (NumberFormatException e){
            System.out.println("Wrong Format");
        }
    }
    public void purchaseItem(){

    }
}
