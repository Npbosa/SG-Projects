/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.flooringmastery.dao;

import com.sg.flooringmastery.dto.Order;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author noahbosa1
 */
public class OrdersDaoStubImpl implements OrdersDao{

    Order onlyOrder;
    List<Order> orderList = new ArrayList<>();
    
    public OrdersDaoStubImpl(){
        onlyOrder = new Order("1");
        onlyOrder.setCustomerName("bob");
        onlyOrder.setState("Tx");
        onlyOrder.setTaxRate(new BigDecimal("4.45"));
        onlyOrder.setProductType("bamboo");
        onlyOrder.setArea(new BigDecimal("100"));
        onlyOrder.setCostPerSquareFoot(BigDecimal.ONE);
        onlyOrder.setLaborCostPerSquareFoot(new BigDecimal("5"));
        onlyOrder.setMaterialCost(new BigDecimal("10"));
        onlyOrder.setLaborCost(new BigDecimal("7.50"));
        onlyOrder.setTax(new BigDecimal("15.00"));
        onlyOrder.setTotal(new BigDecimal("200.00"));
        onlyOrder.setDate("02/28/1997");
        
        orderList.add(onlyOrder);
    }
    @Override
    public Order addOrder(String orderNumber, Order order) throws OrderDaoPersistenceException {
        if(orderNumber.equals(onlyOrder.getOrderNumber())){
            return onlyOrder;
        }else{
            return null;
        }
    }

    @Override
    public List<Order> getAllOrders() throws OrderDaoPersistenceException {
        return orderList;
    }

    @Override
    public Order getOrder(String orderNumber) throws OrderDaoPersistenceException {
        if(orderNumber.equals(onlyOrder.getOrderNumber())){
            return onlyOrder;
        }else{
            return null;
        }
    }

    @Override
    public Order removeOrder(String orderNumber) throws OrderDaoPersistenceException {
        if(orderNumber.equals(onlyOrder.getOrderNumber())){
            return onlyOrder;
        }else{
            return null;
        }
    }

    @Override
    public void editOrder(String oldOrderNumber, Order OrderToEdit) throws OrderDaoPersistenceException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void loadOrder() throws OrderDaoPersistenceException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void writeOrder() throws OrderDaoPersistenceException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Order> getOrdersByDate(String date) throws OrderDaoPersistenceException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getHighestOrderNumber() throws OrderDaoPersistenceException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void writeAllOrdersToCorrectFile() throws OrderDaoPersistenceException, ProdPersistenceException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
