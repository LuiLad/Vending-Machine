package com.techelevator;

import com.techelevator.view.Item;
import com.techelevator.view.Menu;
import com.techelevator.view.VendingMachine;

public class VendingMachineCLI {

//    private final VendingMachine vm = new VendingMachine();

    private static final String MAIN_MENU_OPTION_DISPLAY_ITEMS = "Display Vending Machine Items";
    private static final String MAIN_MENU_OPTION_PURCHASE = "Purchase";
    private static final String MAIN_MENU_OPTION_EXIT = "Exit";


    private static final String PURCHASE_MENU_OPTION_FEED_MONEY = "Feed Money";
    private static final String PURCHASE_MENU_OPTION_SELECT_PRODUCT = "Select Product";
    private static final String PURCHASE_MENU_OPTION_FINISH_TRANSACTION = "Finish Transaction";

    private static final String[] MAIN_MENU_OPTIONS = {MAIN_MENU_OPTION_DISPLAY_ITEMS, MAIN_MENU_OPTION_PURCHASE, MAIN_MENU_OPTION_EXIT};
    private static final String[] PURCHASE_MENU_OPTIONS = {PURCHASE_MENU_OPTION_FEED_MONEY, PURCHASE_MENU_OPTION_SELECT_PRODUCT, PURCHASE_MENU_OPTION_FINISH_TRANSACTION};


    private Menu menu;
    private VendingMachine vm;

    public VendingMachineCLI(Menu menu) {
        this.menu = menu;
    }

    public void run() {
        vm = new VendingMachine();

        while (true) {
            String choice = (String) menu.getChoiceFromOptions(MAIN_MENU_OPTIONS);


            if (choice.equals(MAIN_MENU_OPTION_DISPLAY_ITEMS)) {
                // display vending machine items
                System.out.println();
                vm.getInventory();
            } else if (choice.equals(MAIN_MENU_OPTION_PURCHASE)) {
                // do purchase
//                System.out.println("\n\nCurrent Money Provided: " + vm.currentMoney());
                while (true) {
                    choice = (String) menu.getChoiceFromOptions(PURCHASE_MENU_OPTIONS);
                    if (choice.equals(PURCHASE_MENU_OPTIONS[0])) {

                    } else if (choice.equals(PURCHASE_MENU_OPTIONS[1])) {

                    } else if (choice.equals(PURCHASE_MENU_OPTIONS[2])) {
                        break;
                    }
                }
                System.out.println();
                System.out.println("Current Money Provided: " + vm.currentMoney());
            } else if (choice.equals(MAIN_MENU_OPTION_EXIT)) {
//                EXIT option needs to return change and also exit the system no break out
                System.out.println("Thank you, don't forget your change!");

                System.exit(0);
            }
        }
    }

    public static void main(String[] args) {
        Menu menu = new Menu(System.in, System.out);
        VendingMachineCLI cli = new VendingMachineCLI(menu);
        cli.run();

    }


}
