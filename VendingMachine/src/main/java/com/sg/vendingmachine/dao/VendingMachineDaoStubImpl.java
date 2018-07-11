/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.vendingmachine.dao;

import com.sg.vendingmachine.dto.Item;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author noahbosa1
 */
public class VendingMachineDaoStubImpl implements VendingMachineDao{
    Item noInv;
    Item onlyItem;
    Item normalItem;
    List<Item> itemList = new ArrayList<>();
    
    
    public VendingMachineDaoStubImpl(){
        onlyItem = new Item("too expensive");
        onlyItem.setPrice(BigDecimal.TEN);
        onlyItem.setInventory(100);
        itemList.add(onlyItem); 
        
        noInv = new Item("shouldnt have inventory");
        noInv.setPrice(BigDecimal.ONE);
        noInv.setInventory(0);
        itemList.add(noInv);
        
        normalItem = new Item("normal item");
        normalItem.setPrice(new BigDecimal("5.50"));
        normalItem.setInventory(10);
        itemList.add(normalItem);
        
    }

    @Override
    public Item addItem(String name, Item item) throws VendingMachinePersistenceException {
        if (name.equals(onlyItem.getName())){
            return onlyItem;
        }else{
            return null;
        }
    }

    @Override
    public List<Item> listAllItems() throws VendingMachinePersistenceException {
        return itemList;
    }

    @Override
    public Item getItem(String name) throws VendingMachinePersistenceException {
        if (name.equals(onlyItem.getName())){
            return onlyItem;
        }else{
            return null;
        }
    }

    @Override
    public Item removeItem(String name) throws VendingMachinePersistenceException {
        if (name.equals(onlyItem.getName())){
            return onlyItem;
        }else{
            return null;
        }
    }

    @Override
    public void loadInventory() throws VendingMachinePersistenceException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void writeInventory() throws VendingMachinePersistenceException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void editItem(String name, Item item) throws VendingMachinePersistenceException {
    
    }
    
}
