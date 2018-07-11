/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.vendingmachine.service;

import com.sg.vendingmachine.dao.VendingMachinePersistenceException;
import com.sg.vendingmachine.dto.Item;
import java.math.BigDecimal;
import java.util.List;

/**
 *
 * @author noahbosa1
 */
public interface ServiceLayer {

    Item addItem(String name, Item item) throws VendingMachinePersistenceException;

    List<Item> listAllItems() throws VendingMachinePersistenceException;

    Item getItem(String name) throws VendingMachinePersistenceException;

    void editItem(String name, Item item) throws VendingMachinePersistenceException;

    Item removeItem(String name) throws VendingMachinePersistenceException;

    void loadInventory() throws VendingMachinePersistenceException;

    void writeInventory() throws VendingMachinePersistenceException;

    Change getChange(BigDecimal change) throws InsufficientFundsException;

    BigDecimal vendItem(BigDecimal userMoney, Item item, String name) throws
            VendingMachinePersistenceException, InsufficientFundsException, NoItemInventoryException;
}
