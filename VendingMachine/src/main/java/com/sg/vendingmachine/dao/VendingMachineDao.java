/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.vendingmachine.dao;

import com.sg.vendingmachine.dto.Item;
import java.util.List;

/**
 *
 * @author noahbosa1
 */
public interface VendingMachineDao{
    
    Item addItem(String name, Item item) throws VendingMachinePersistenceException;
    
    List<Item> listAllItems() throws VendingMachinePersistenceException;
    
    Item getItem(String name) throws VendingMachinePersistenceException;
    
    Item removeItem(String name) throws VendingMachinePersistenceException;
    
    void loadInventory() throws VendingMachinePersistenceException;
    
    void writeInventory() throws VendingMachinePersistenceException;
    
    void editItem(String name, Item item) throws VendingMachinePersistenceException;
}
