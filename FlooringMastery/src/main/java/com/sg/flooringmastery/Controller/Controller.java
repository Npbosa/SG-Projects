/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.flooringmastery.Controller;

import com.sg.flooringmastery.ServiceLayer.ServiceLayer;
import com.sg.flooringmastery.dao.OrderDaoPersistenceException;
import com.sg.flooringmastery.dao.ProdPersistenceException;
import com.sg.flooringmastery.dao.ProductDaoException;
import com.sg.flooringmastery.dao.TaxDaoException;
import com.sg.flooringmastery.dto.Order;
import com.sg.flooringmastery.dto.Product;
import com.sg.flooringmastery.ui.FlooringView;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

/**
 *
 * @author noahbosa1
 */
public class Controller {
    private FlooringView view;
    private ServiceLayer service;
    
    public Controller(ServiceLayer service,FlooringView view){
        this.service = service;
        this.view = view;
    }
    private void displayOrdersByDate() throws OrderDaoPersistenceException{
        String date = view.showPromptAndGetDate();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        LocalDate ld = LocalDate.parse(date, formatter);
        String formatted = ld.format(formatter);
        List <Order> orders = service.getOrdersByDate(formatted);
        view.listMenu(orders);
    }
    private void addOrder() throws OrderDaoPersistenceException,ProductDaoException,ProdPersistenceException{
        String newOrderNum = service.getHighestOrderNumber();
        List<Product> products = service.getAllProducts();
        view.listProducts(products);
        Order newOrder = view.getNewOrderInfo(newOrderNum);
        Boolean save = view.saveOption();
        if(save != false){
            service.setAllOrderProperties(newOrder);
            service.addOrder(newOrder.getOrderNumber(), newOrder);
        }
    }
    private void removeOrder() throws OrderDaoPersistenceException{
        view.removeOrderBanner();
        String orderNum = view.getOrderToBeRemoved();
        Boolean save = view.saveOption();
        if(save != false){
        service.removeOrder(orderNum);
        view.removeSuccessBanner();
        }
    }
    private void editOrder() throws OrderDaoPersistenceException,ProductDaoException,ProdPersistenceException{
        String date = view.showPromptAndGetDate();//This is for later when ill have to search by date
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        LocalDate ld = LocalDate.parse(date, formatter);//This is for later when ill have to search by date
        String formatted = ld.format(formatter);//This is for later when ill have to search by date
        String orderNum = view.getOrderNumber();
        Order orderToEdit = service.getOrder(orderNum);
        view.showOrder(orderToEdit);
        Order editedOrder = view.editOrder(orderToEdit);//No need for save option method, its built into edit
        editedOrder.setDate(formatted);
        service.setAllOrderProperties(editedOrder);
        service.addOrder(editedOrder.getOrderNumber(), editedOrder);
    }
    private void saveEverything() throws OrderDaoPersistenceException,ProdPersistenceException{
        service.writeAllOrdersToCorrectFile();
    }
    public void run() throws OrderDaoPersistenceException, ProductDaoException,ProdPersistenceException, TaxDaoException{
        service.loadOrder();
        service.loadTax();
        service.loadProduct();
        boolean keepGoing = true;
        int menuSelection = 0;
        while(keepGoing){
           
           menuSelection = view.printMenuAndGetSelection();
           
           switch(menuSelection){
               case 1:
                   displayOrdersByDate();
                   break;
               case 2:
                   addOrder();//Add and Order
                   break;
               case 3:
                   editOrder();//Edit an Order
                   break;
               case 4:
                   removeOrder();//Remove An Order
                   break;
               case 5:
                   saveEverything();//Save Current Work
                   break;
               case 6://exit
                   keepGoing=false;
                   break;
               default:
                   view.defualtBanner();
                   break;
           }
        }
        view.goodByeMessage();
    }
    
    
}
