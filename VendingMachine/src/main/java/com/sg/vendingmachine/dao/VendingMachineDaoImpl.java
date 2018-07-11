/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.vendingmachine.dao;

import com.sg.vendingmachine.dto.Item;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author noahbosa1
 */
public class VendingMachineDaoImpl implements VendingMachineDao{
    private Map<String, Item> items = new HashMap<>();
    public static String INVENTORY_FILE;
    public static final String DELIMITER = "::";

    public VendingMachineDaoImpl(){
        INVENTORY_FILE = "inventory.txt";
    }
    public VendingMachineDaoImpl(String fileName){
        INVENTORY_FILE=fileName;
    }
    @Override
    public Item addItem(String name, Item item) throws VendingMachinePersistenceException {
        Item newItem = items.put(name, item);
        writeInventory();
        return newItem;
    }
    @Override
    public Item getItem(String name) throws VendingMachinePersistenceException{
        Item editedItem = items.get(name);
        writeInventory();
        return editedItem;
    }
    @Override
    public Item removeItem(String name) throws VendingMachinePersistenceException {
        Item removedItem = items.remove(name);
        writeInventory();
        return removedItem;
    }
    @Override
    public void editItem(String name,Item item) throws VendingMachinePersistenceException {
        if(name == item.getName()){
            this.items.replace(name, item);
        }else{
            Item oldItem = this.items.remove(name);
            this.items.put(item.getName(),item);
            
        }
        
        this.writeInventory();
    }
    @Override
    public List<Item> listAllItems() throws VendingMachinePersistenceException {
        loadInventory();
        return new ArrayList<>(items.values());
    }
    @Override
    public void loadInventory() throws VendingMachinePersistenceException {
        Scanner scanner;
        try{
            scanner = new Scanner( new BufferedReader(new FileReader(INVENTORY_FILE)));
        } catch (FileNotFoundException e) {
            throw new VendingMachinePersistenceException(
                    "Couldn't load inventory, you messed up somewhere",e);
        }
        String currentLine;
        String[] currentTokens;
        while (scanner.hasNextLine()) {
            currentLine = scanner.nextLine();
            currentTokens = currentLine.split(DELIMITER);
            Item currentItem = new Item(currentTokens[0]);
            
            BigDecimal priceDecimal = new BigDecimal(currentTokens[1]);
            currentItem.setPrice(priceDecimal);
            int inventoryInt = Integer.parseInt(currentTokens[2]);
            currentItem.setInventory(inventoryInt);
            
            items.put(currentItem.getName(), currentItem);
        }
        scanner.close();
    }
    @Override
	public void writeInventory() throws VendingMachinePersistenceException {
	    // NOTE FOR APPRENTICES: We are not handling the IOException - but
	    // we are translating it to an application specific exception and 
	    // then simple throwing it (i.e. 'reporting' it) to the code that
	    // called us.  It is the responsibility of the calling code to 
	    // handle any errors that occur.
	    PrintWriter out;
	    
	    try {
	        out = new PrintWriter(new FileWriter(INVENTORY_FILE));
	    } catch (IOException e) {
	        throw new VendingMachinePersistenceException(
	                "Of course the Print writer blew up, dumbass.", e);
	    }
	    
	    // Write out the Student objects to the roster file.
	    // NOTE TO THE APPRENTICES: We could just grab the student map,
	    // get the Collection of Students and iterate over them but we've
	    // already created a method that gets a List of Students so
	    // we'll reuse it.
	    List<Item> ArrayList = this.listAllItems();
	    for (Item currentItem : ArrayList) {
	        // write the Student object to the file
	        out.println(currentItem.getName() + DELIMITER
	                + currentItem.getPrice() + DELIMITER 
	                + currentItem.getInventory());
	                
	        // force PrintWriter to write line to the file
	        out.flush();
	    }
	    // Clean up
	    out.close();
	}    

}
