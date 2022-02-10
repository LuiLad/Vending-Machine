package com.techelevator.view;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Scanner;

public class VendingMachine {


//    private String[] itemsList;
//    private List<String> itemList;

    public void getInventory() {

        File vendingMachineList = new File("C:\\Users\\Student\\workspace\\module-1-capstone-team-4\\capstone\\vendingmachine.csv");
        try (Scanner fileInput = new Scanner(vendingMachineList)) {

            while (fileInput.hasNextLine()) {
                String lineOfText = fileInput.nextLine();
                lineOfText.split("|");
            }

        } catch (FileNotFoundException e) {
            System.out.println("There file was not found");
        }

    }
}
