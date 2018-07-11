/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.vendingmachine.controller;

import com.sg.vendingmachine.dao.VendingMachineDao;
import com.sg.vendingmachine.dao.VendingMachinePersistenceException;
import com.sg.vendingmachine.dto.Item;
import com.sg.vendingmachine.service.Change;
import com.sg.vendingmachine.service.InsufficientFundsException;
import com.sg.vendingmachine.service.NoItemInventoryException;
import com.sg.vendingmachine.service.ServiceLayer;
import com.sg.vendingmachine.ui.UserIO;
import com.sg.vendingmachine.ui.UserIOConsoleImpl;
import com.sg.vendingmachine.ui.VendingMachineView;
import java.math.BigDecimal;
import java.util.List;

/**
 *
 * @author noahbosa1
 */
public class VendingMachineController {
    VendingMachineView view;
    ServiceLayer serviceLayer;
    private UserIO io = (UserIO) new UserIOConsoleImpl();//to be removed later

    public VendingMachineController(ServiceLayer serviceLayer, VendingMachineView view) {
        this.serviceLayer = serviceLayer;
        this.view = view;
    }
    
    private void listAllItems() throws VendingMachinePersistenceException{
       view.displayAllItemsBanner();
       List<Item> items = serviceLayer.listAllItems();
       view.listMenu(items);
       view.displayAllItemsSuccess();
    }
    private void buyItem() throws InsufficientFundsException,NoItemInventoryException, VendingMachinePersistenceException{
        String itemName = view.getItemName();
        Item item = serviceLayer.getItem(itemName);
        view.displayItem(item);
        BigDecimal change = view.getCash();
        BigDecimal decimalChange = serviceLayer.vendItem(change,item,itemName);
        Change wallet = serviceLayer.getChange(decimalChange);
        view.DispenseChangeBanner();
        view.giveQuartersBanner();
        view.printBigDecimal(wallet.getQuarters());
        view.giveDimeBanner();
        view.printBigDecimal(wallet.getDimes());
        view.giveNickelsBanner();
        view.printBigDecimal(wallet.getNickles());
        view.givePenniesBanner();
        view.printBigDecimal(wallet.getPennies());
    }
    public void run() throws VendingMachinePersistenceException,NoItemInventoryException, InsufficientFundsException{
        boolean keepGoing = true;
        int menuSelection = 0;
        while(keepGoing){
           listAllItems();
           io.print("1. Enter money");
           io.print("2 Exit");
           
           menuSelection = io.readInt("Please select from " 
                   + " the above choices",1,2);
           
           switch(menuSelection){
               case 1:
                   buyItem();
                   break;
               case 2:
                   keepGoing = false;
                   break;
               default:
                   io.print("Unknown Command, don't try to break what isn't yours");
           }
        }
        io.print("See ya l8tr");
    }
    
   
}
