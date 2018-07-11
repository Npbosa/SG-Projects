/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.vendingmachine.service;

import com.sg.vendingmachine.dao.VendingMachineAuditDao;
import com.sg.vendingmachine.dao.VendingMachineDao;
import com.sg.vendingmachine.dao.VendingMachinePersistenceException;
import com.sg.vendingmachine.dto.Item;
import java.math.BigDecimal;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author noahbosa1
 */
public class ServiceLayerImpl implements ServiceLayer {

    private VendingMachineDao dao;
    

    public ServiceLayerImpl(VendingMachineDao dao) {
        this.dao = dao;
    }

    @Override
    public Item addItem(String name, Item item) throws VendingMachinePersistenceException {
      //  auditDao.writeAuditEntry("item " + item.getName() + " added");
        return dao.addItem(name, item);
    }

    @Override
    public List<Item> listAllItems() throws VendingMachinePersistenceException {
       // auditDao.writeAuditEntry("all items listed");
        return dao.listAllItems();
    }

    @Override
    public Item getItem(String name) throws VendingMachinePersistenceException {
       // auditDao.writeAuditEntry("item" + name + "retreived");
        return dao.getItem(name);
    }

    @Override
    public Item removeItem(String name) throws VendingMachinePersistenceException {
       // auditDao.writeAuditEntry(name + " was removed");
        return dao.removeItem(name);
    }

    @Override
    public void loadInventory() throws VendingMachinePersistenceException {
        dao.loadInventory();
    }

    @Override
    public void writeInventory() throws VendingMachinePersistenceException {
        dao.writeInventory();
    }

    @Override
    public Change getChange(BigDecimal change) throws InsufficientFundsException {
        Change wallet = new Change();
        BigDecimal quarter = new BigDecimal("25");
        BigDecimal dime = new BigDecimal("10");
        BigDecimal nickel = new BigDecimal("5");

        final BigDecimal totalPennies = change.multiply(new BigDecimal("100"));

        BigDecimal quarters = totalPennies.divideToIntegralValue(quarter);
        wallet.setQuarters(quarters);
        BigDecimal quarterValue = quarters.multiply(quarter);

        BigDecimal dimes = totalPennies.subtract(quarters.multiply(quarter)).divideToIntegralValue(dime);
        wallet.setDimes(dimes);
        BigDecimal dimeValue = dimes.multiply(dime);

        BigDecimal nickels = totalPennies.subtract(quarterValue.add(dimeValue)).divideToIntegralValue(nickel);
        wallet.setNickles(nickels);
        BigDecimal nickelValue = nickels.multiply(nickel);

        BigDecimal pennies = totalPennies.subtract(quarterValue.add(dimeValue).add(nickelValue)).divideToIntegralValue(BigDecimal.ONE);
        wallet.setPennies(pennies);

       

        return wallet;
    }

    @Override
    public BigDecimal vendItem(BigDecimal userMoney, Item item, String name) throws VendingMachinePersistenceException, InsufficientFundsException, NoItemInventoryException {
        BigDecimal itemPrice = item.getPrice();
        BigDecimal changeValue = null;

        if (itemPrice.compareTo(userMoney) < 0) {
        } else {
            throw new InsufficientFundsException("you didnt put enough money in");
        }
        if (item.getInventory() > 0) {
            changeValue = userMoney.subtract(item.getPrice());
            item.setInventory(item.getInventory() - 1);
            dao.editItem(name, item);
            
        } else {
            throw new NoItemInventoryException("not in stock");
        }
        return changeValue;
    }

    @Override
    public void editItem(String name, Item item) throws VendingMachinePersistenceException {
        dao.editItem(name, item);
    }

    private void ValidateItemData(Item item) throws VendingMachinePersistenceException, NoItemInventoryException {
        if (item.getName() == null || item.getName().trim().length() == 0
                || item.getPrice() == null || item.getPrice().toString().trim().length() == 0
                || item.getInventory() == 0) {
            throw new NoItemInventoryException("ERROR: All fields [name,price, enough inventory]"
                    + " must be present in object");
        }

    }

}
