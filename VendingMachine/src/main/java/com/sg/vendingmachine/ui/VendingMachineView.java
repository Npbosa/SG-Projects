/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.vendingmachine.ui;

import com.sg.vendingmachine.dto.Item;
import java.math.BigDecimal;
import java.util.List;

/**
 *
 * @author noahbosa1
 */
public class VendingMachineView {
    private UserIO io;
    private Item item;
    public VendingMachineView(UserIO io){
        this.io = io;
    }
    public void displayAllItemsBanner(){
        io.print("=== Displaying All Items ===");
    }
    public void listMenu(List<Item> items){
        io.print("Item  :  Price  :  Qty  ");
        for (Item currentItem : items){
            io.print(currentItem.getName() 
                    + ": "+ currentItem.getPrice() 
                    + ": "+ currentItem.getInventory());
        }
    }
    public void displayAllItemsSuccess(){
        io.print("=== All Items Successfully loaded ===");
    }
    public String getItemName(){
       String response =io.readString("Please enter the name of the "
                +"item you wish to purchase");
        return response;
    }
    public void displayItem(Item item){
        if (item != null){
            io.print("=== Displaying info ===");
            io.print("Name:");
            io.print(item.getName());
            io.print("Price:");
            io.print(item.getPrice());
            io.print("Amount in Stock:");
            io.print(item.getInventory());
        }else{
            io.print("No such Item in machine");
        }
        io.readString("Please hit enter to continue");
    }    
    public BigDecimal getCash(){
        String cash = io.readString("Enter the amount of cash to be inserted ex: 5.00");
        BigDecimal bigCash = new BigDecimal(cash);
        return bigCash;
    }
    public void DispenseChangeBanner(){
        io.print("== Dispensing item and change ==");
    }
    public void giveDollarsBanner(){
        io.print("Dollars Back:");
    }
    public void printBigDecimal(BigDecimal value){
        io.print(value.toString());
    }
    public void giveQuartersBanner(){
        io.print("Quarters Back:");
    }
    public void giveDimeBanner(){
        io.print("Dimes Back:");
    }
    public void giveNickelsBanner(){
        io.print("Nickels Back:");
    }
    public void givePenniesBanner(){
        io.print("Pennies Back:");
    }
}
