/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.vendingmachine.service;

import com.sg.vendingmachine.dao.VendingMachineAuditDao;
import com.sg.vendingmachine.dao.VendingMachineAuditDaoStubImpl;
import com.sg.vendingmachine.dao.VendingMachineDao;
import com.sg.vendingmachine.dao.VendingMachineDaoStubImpl;
import com.sg.vendingmachine.dto.Item;
import java.math.BigDecimal;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.fail;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author noahbosa1
 */
public class ServiceLayerTest {

    private ServiceLayer service;

    public ServiceLayerTest() {
        VendingMachineDao dao = new VendingMachineDaoStubImpl();
        VendingMachineAuditDao auditDao = new VendingMachineAuditDaoStubImpl();

        service = new ServiceLayerImpl(dao);
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
     * Test of addItem method, of class ServiceLayer.
     */
    @Test
    public void testAddItem() throws Exception {
    }

    /**
     * Test of listAllItems method, of class ServiceLayer.
     */
    @Test
    public void testListAllItems() throws Exception {
    }

    /**
     * Test of getItem method, of class ServiceLayer.
     */
    @Test
    public void testGetItem() throws Exception {
    }

    /**
     * Test of editItem method, of class ServiceLayer.
     */
    @Test
    public void testEditItem() throws Exception {
    }

    /**
     * Test of removeItem method, of class ServiceLayer.
     */
    @Test
    public void testRemoveItem() throws Exception {
    }

    /**
     * Test of loadInventory method, of class ServiceLayer.
     */
    @Test
    public void testLoadInventory() throws Exception {
    }

    /**
     * Test of writeInventory method, of class ServiceLayer.
     */
    @Test
    public void testWriteInventory() throws Exception {
    }

    /**
     * Test of getChange method, of class ServiceLayer.
     */
    @Test
    public void testGetChange() throws Exception {
    }

    /**
     * Test of vendItem method, of class ServiceLayer.
     */
    @Test
    public void testVendItemNotEnoughMoney() throws Exception {
        Item onlyItem;
        onlyItem = new Item("too expensive");
        onlyItem.setPrice(BigDecimal.TEN);
        onlyItem.setInventory(100);
        BigDecimal userMoney;
        userMoney = new BigDecimal("5");
        try {
            service.vendItem(userMoney, onlyItem, "too expensive");
            fail("expected InsufficientFundsException");
        } catch (InsufficientFundsException e) {
            return;

        }
    }

    @Test
    public void testVendItemNoInventory() throws Exception {
        Item noInv;
        BigDecimal userMoney = new BigDecimal("2.25");
        noInv = new Item("shouldnt have inventory");
        noInv.setPrice(BigDecimal.ONE);
        noInv.setInventory(0);
        try {
            service.vendItem(userMoney, noInv, "shouldnt have inventory");
            fail("expected NoItemInventoryException");
        } catch (NoItemInventoryException e) {
            return;
        }
    }

    @Test
    public void testVendItemNormalItem() throws Exception {
        Item normalItem;
        BigDecimal userMoney = new BigDecimal("7.24");
        normalItem = new Item("normal item");
        normalItem.setPrice(new BigDecimal("5.50"));
        normalItem.setInventory(10);

        service.vendItem(userMoney, normalItem, "normal item");
    }

}
