package com.techelevator.view;

import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.*;


public class VendingMachine {
    private Item item;
    private Map<String, Double> inventory;
    private List<Item> itemList = new ArrayList<Item>();
    private int quantity = 5;
    private BigDecimal currentBalance = BigDecimal.ZERO;

    public BigDecimal getCurrentBalance() {
        return currentBalance;
    }

    //Option 1
    public List<Item> getInventory() {
        File vendingMachineList = new File("vendingmachine.csv");
        try (Scanner fileInput = new Scanner(vendingMachineList)) {

            while (fileInput.hasNextLine()) {
                String[] lineOfText = fileInput.nextLine().split("\\|");
                BigDecimal price = BigDecimal.valueOf(Double.parseDouble(lineOfText[2]));
                String itemSlot = lineOfText[0];
                String name = lineOfText[1];
                String itemType = lineOfText[3];
                if (itemType.equals("Candy")) {
                    Item candy = new Candy(itemSlot, name, price, itemType);
                    itemList.add(candy);
                } else if (itemType.equals("Chip")) {
                    Item chip = new Chip(itemSlot, name, price, itemType);
                    itemList.add(chip);
                } else if (itemType.equals("Drink")) {
                    Item drink = new Drink(itemSlot, name, price, itemType);
                    itemList.add(drink);
                } else if (itemType.equals("Gum")) {
                    Item gum = new Gum(itemSlot, name, price, itemType);
                    itemList.add(gum);
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("The file was not found");
        } catch (NumberFormatException e) {
            System.out.println("Wrong Format");
        }
        return itemList;
    }

    //Purchase menu - Feed Menu Option
    public BigDecimal feedMoney() {
        Scanner userInput = new Scanner(System.in);
        System.out.println("---------------------------");
        System.out.println("Do you want to add money? \n 1) Yes \n 2) No");
        while (true) {
            int choice = userInput.nextInt();
            if (choice == 1) {
                while (true) {
                    System.out.print("Input U.S Currency amount in $1.00, $2.00, $5.00 and $10.00: ");
                    choice = userInput.nextInt();
                    System.out.println();
                    System.out.println("Do you want to add more money? \n 1) Yes \n 2) No");
                    if (choice == 1 || choice == 2 || choice == 5 || choice == 10) {
                        this.currentBalance = currentBalance.add(BigDecimal.valueOf(choice));
                        DecimalFormat df = new DecimalFormat("#.00");
                        System.out.println("\nCurrent Money Provided: " + "$" + df.format(currentBalance));
                        break;
                    } else {
                        System.out.println("Not valid input.");
                        break;
                    }
                }
            } else if (choice == 2) {
                break;
            } else {
                System.out.println("Not valid Input");
            }
        }
        return currentBalance;
    }

    public BigDecimal selectProduct() {
        List itemSlots = new ArrayList();
        while (true) {
            for (Item item : itemList) {
                itemSlots.add(item.getItemSlot());
                System.out.println("Slot: " + item.getItemSlot() + " | " + "Item Name: " + item.getName() + " | " + "Item Price: " + item.getPrice() + " | " + "Item Type: " + item.getItemType() + " | " + "Item Quantity: " + item.getQuantity());
            }
            Scanner userInput = new Scanner(System.in);
            System.out.println();
            DecimalFormat df = new DecimalFormat("0.00");
            System.out.println("Current Money Provided: " + "$" + df.format(currentBalance));
            System.out.println();
            System.out.print("Enter a slot to select a product: ");
            String choice = userInput.nextLine();
            if (!itemSlots.contains(choice)) {
                System.out.println();
                System.out.println("Not valid item slot");
                System.out.println();
                break;
            }
            for (int i = 0; i < itemList.size(); i++) {
                String itemSlot = itemList.get(i).getItemSlot();
                if ((itemSlot.equals(choice)) && (itemList.get(i).getQuantity() > 0) && (currentBalance.compareTo(itemList.get(i).getPrice()) > 0)) {
                    this.currentBalance = currentBalance.subtract(itemList.get(i).getPrice());
                    itemList.get(i).setQuantity(itemList.get(i).getQuantity() - 1);
                    System.out.println("Item Name: " + itemList.get(i).getName());
                    System.out.println("Item Price: " + itemList.get(i).getPrice());
                    System.out.println(itemList.get(i).getSound());
                } else if (itemSlot.equals(choice) && itemList.get(i).getQuantity() <= 0) {
                    System.out.println();
                    System.out.println("SOLD OUT");
                    System.out.println();
                    break;
                } else if (currentBalance.compareTo(BigDecimal.ZERO) <= 0 && currentBalance.compareTo(itemList.get(i).getPrice()) <= 0) {
                    System.out.println();
                    System.out.println("Not enough money provided");
                    System.out.println();
                    break;
                }
            }
            break;
        }
        return currentBalance;
    }

    public BigDecimal finishTransaction() {
        int quarterCount = 0;
        int dimeCount = 0;
        int nickelCount = 0;
//        double currentBalanceInt = Double.valueOf(currentBalance.doubleValue());
        while /*(currentBalanceInt - .25 >= 0 && currentBalanceInt % .25 >= 0)*/ (currentBalance.subtract(BigDecimal.valueOf(.25)).compareTo(BigDecimal.ZERO) == 0 || currentBalance.subtract(BigDecimal.valueOf(.25)).compareTo(BigDecimal.ZERO) == 1 && currentBalance.remainder(BigDecimal.valueOf(.25)).compareTo(BigDecimal.ZERO) >= 0) {
//            currentBalanceInt -= .25;
            quarterCount++;
            this.currentBalance = currentBalance.subtract(BigDecimal.valueOf(.25));
        }
        while /*(currentBalanceInt - .10 >= 0 && currentBalanceInt % .10 >= 0)*/ (currentBalance.subtract(BigDecimal.valueOf(.10)).compareTo(BigDecimal.ZERO) == 0 || currentBalance.subtract(BigDecimal.valueOf(.10)).compareTo(BigDecimal.ZERO) == 1 && currentBalance.remainder(BigDecimal.valueOf(.10)).compareTo(BigDecimal.ZERO) >= 0){
//            currentBalanceInt -= .10;
            dimeCount++;
            this.currentBalance = currentBalance.subtract(BigDecimal.valueOf(.10));
        }
        while /*(currentBalanceInt - .05 >= 0 && currentBalanceInt % .05 >= 0)*/ (currentBalance.subtract(BigDecimal.valueOf(.05)).compareTo(BigDecimal.ZERO) == 0 || currentBalance.subtract(BigDecimal.valueOf(.05)).compareTo(BigDecimal.ZERO) == 1 && currentBalance.remainder(BigDecimal.valueOf(.05)).compareTo(BigDecimal.ZERO) >= 0){
////            currentBalanceInt -= .05;
            nickelCount++;
            this.currentBalance = currentBalance.subtract(BigDecimal.valueOf(.05));
        }
        System.out.println("Here's your change: \nQuarter count: " + quarterCount + "\nDime count: " + dimeCount + "\nNickel count: " + nickelCount);
        return currentBalance;
    }
}

