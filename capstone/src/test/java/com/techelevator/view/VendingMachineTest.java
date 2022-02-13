package com.techelevator.view;
import org.junit.*;
import org.junit.runners.MethodSorters;
import org.mockito.asm.util.ASMifiable;

import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigDecimal;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class VendingMachineTest {
    File vendingMachineList = new File("vendingmachine.csv");
    File badVendingMachineList = new File("vendingmachine2.csv");
    VendingMachine vm;
    @Before
    public void setup(){
        vm = new VendingMachine();
    }
    @Test
    public void testGetInventory() {
        try {
            vm.getInventory(vendingMachineList);
            Assert.assertTrue(vm.getItemList().size() > 0);
        }catch (Exception e){
            Assert.fail();
        }
    }
    @Test
    public void testGetInventory_numberException() {
        try {
            vm.getInventory(badVendingMachineList);
        }catch (NumberFormatException e){
            Assert.fail();
        }
    }

    @Test
    public void testFeedMoney() {

    }

    @Test
    public void testSelectProduct() {
    }

    @Test
    public void testFinishTransaction() {
    }
}
