/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.flooringmastery.ServiceLayer;

import com.sg.flooringmastery.dao.OrdersDao;
import com.sg.flooringmastery.dao.OrdersDaoStubImpl;
import com.sg.flooringmastery.dao.ProductsDao;
import com.sg.flooringmastery.dao.ProductsDaoStubImpl;
import com.sg.flooringmastery.dao.TaxDao;
import com.sg.flooringmastery.dao.TaxDaoStubImpl;
import com.sg.flooringmastery.dto.Order;
import java.math.BigDecimal;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author noahbosa1
 */
public class ServiceLayerTest {
    
    private ServiceLayer service;
    Order onlyOrder;
    public ServiceLayerTest() {
        OrdersDao orderDao = new OrdersDaoStubImpl();
        ProductsDao productDao = new ProductsDaoStubImpl();
        TaxDao taxDao = new TaxDaoStubImpl();
        service = new ServiceLayerImpl(orderDao,productDao,taxDao);
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of addOrder method, of class ServiceLayer.
     */
    @Test
    public void testAddOrder() throws Exception {
        
    }

    /**
     * Test of getAllOrders method, of class ServiceLayer.
     */
    @Test
    public void testGetAllOrders() throws Exception {
    }

    /**
     * Test of getOrder method, of class ServiceLayer.
     */
    @Test
    public void testGetOrder() throws Exception {
    }

    /**
     * Test of removeOrder method, of class ServiceLayer.
     */
    @Test
    public void testRemoveOrder() throws Exception {
    }

    /**
     * Test of editOrder method, of class ServiceLayer.
     */
    @Test
    public void testEditOrder() throws Exception {
    }

    /**
     * Test of loadOrder method, of class ServiceLayer.
     */
    @Test
    public void testLoadOrder() throws Exception {
    }

    /**
     * Test of writeOrder method, of class ServiceLayer.
     */
    @Test
    public void testWriteOrder() throws Exception {
    }

    /**
     * Test of getOrdersByDate method, of class ServiceLayer.
     */
    @Test
    public void testGetOrdersByDate() throws Exception {
    }

    /**
     * Test of getHighestOrderNumber method, of class ServiceLayer.
     */
    @Test
    public void testGetHighestOrderNumber() throws Exception {
    }

    /**
     * Test of writeAllOrdersToCorrectFile method, of class ServiceLayer.
     */
    @Test
    public void testWriteAllOrdersToCorrectFile() throws Exception {
    }

    /**
     * Test of addProduct method, of class ServiceLayer.
     */
    @Test
    public void testAddProduct() throws Exception {
    }

    /**
     * Test of getAllProducts method, of class ServiceLayer.
     */
    @Test
    public void testGetAllProducts() throws Exception {
    }

    /**
     * Test of getProduct method, of class ServiceLayer.
     */
    @Test
    public void testGetProduct() throws Exception {
    }

    /**
     * Test of removeProduct method, of class ServiceLayer.
     */
    @Test
    public void testRemoveProduct() throws Exception {
    }

    /**
     * Test of editProduct method, of class ServiceLayer.
     */
    @Test
    public void testEditProduct() throws Exception {
    }

    /**
     * Test of loadProduct method, of class ServiceLayer.
     */
    @Test
    public void testLoadProduct() throws Exception {
    }

    /**
     * Test of writeProduct method, of class ServiceLayer.
     */
    @Test
    public void testWriteProduct() throws Exception {
    }

    /**
     * Test of addTax method, of class ServiceLayer.
     */
    @Test
    public void testAddTax() {
    }

    /**
     * Test of getAllTaxes method, of class ServiceLayer.
     */
    @Test
    public void testGetAllTaxes() {
    }

    /**
     * Test of getTax method, of class ServiceLayer.
     */
    @Test
    public void testGetTax() {
    }

    /**
     * Test of removeTax method, of class ServiceLayer.
     */
    @Test
    public void testRemoveTax() {
    }

    /**
     * Test of editTax method, of class ServiceLayer.
     */
    @Test
    public void testEditTax() {
    }

    /**
     * Test of loadTax method, of class ServiceLayer.
     */
    @Test
    public void testLoadTax() throws Exception {
    }

    /**
     * Test of writeTax method, of class ServiceLayer.
     */
    @Test
    public void testWriteTax() throws Exception {
    }

    /**
     * Test of setAllOrderProperties method, of class ServiceLayer.
     */
    @Test
    public void testSetAllOrderProperties() throws Exception {
        Order onlyOrder = new Order("2");
        onlyOrder.setCustomerName("jane");
        onlyOrder.setState("Tx");
        onlyOrder.setTaxRate(new BigDecimal("4.45"));
        onlyOrder.setProductType("Bamboo");
        onlyOrder.setArea(new BigDecimal("50"));
        onlyOrder.setCostPerSquareFoot(BigDecimal.TEN);
        onlyOrder.setLaborCostPerSquareFoot(new BigDecimal("1.50"));
        onlyOrder.setMaterialCost(new BigDecimal("12"));
        onlyOrder.setLaborCost(new BigDecimal("9.50"));
        onlyOrder.setTax(new BigDecimal("6.00"));
        onlyOrder.setTotal(new BigDecimal("260.00"));
        onlyOrder.setDate("02/28/1997");
        service.setAllOrderProperties(onlyOrder);
    }

    
}
