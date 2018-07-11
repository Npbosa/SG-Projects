/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.vendingmachine.dao;

import com.sg.vendingmachine.dto.Item;
import java.math.BigDecimal;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author noahbosa1
 */
public class VendingMachineDaoTest {

    private VendingMachineDaoImpl dao = new VendingMachineDaoImpl("testinventory.txt");

    public VendingMachineDaoTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() throws Exception {
        List<Item> itemList = dao.listAllItems();
        for (Item item : itemList) {
            dao.removeItem(item.getName());
        }
    }

    @After
    public void tearDown() {
        
    }

    /**
     * Test of addItem method, of class VendingMachineDao.
     */
    @Test
    public void testAddItem() throws Exception {
        Item item = new Item("Milky Way");
        item.setPrice(BigDecimal.ONE);
        item.setInventory(10);

        dao.addItem(item.getName(), item);

        Item fromDao = dao.getItem(item.getName());

        assertEquals(item, fromDao);
    }

    /**
     * Test of listAllItems method, of class VendingMachineDao.
     */
    @Test
    public void testListAllItems() throws Exception {
        Item item1 = new Item("Milky Way");
        item1.setPrice(BigDecimal.ONE);
        item1.setInventory(10);

        dao.addItem(item1.getName(), item1);

        Item item2 = new Item("3 musketeers");
        item2.setPrice(BigDecimal.ONE);
        item2.setInventory(10);

        dao.addItem(item2.getName(), item2);

        assertEquals(2, dao.listAllItems().size());

    }

    /**
     * Test of getItem method, of class VendingMachineDao.
     */
    @Test
    public void testGetItem() throws Exception {
    }

    /**
     * Test of removeItem method, of class VendingMachineDao.
     */
    @Test
    public void testRemoveItem() throws Exception {
        Item item1 = new Item("Milky Way");
        item1.setPrice(BigDecimal.ONE);
        item1.setInventory(10);

        dao.addItem(item1.getName(), item1);

        Item item2 = new Item("3 musketeers");
        item2.setPrice(BigDecimal.ONE);
        item2.setInventory(10);

        dao.addItem(item2.getName(), item2);
        
        dao.removeItem(item1.getName());
        assertEquals(1, dao.listAllItems().size()); 
        assertNull(dao.getItem(item1.getName()));
        
        dao.removeItem(item2.getName());
        assertEquals(0, dao.listAllItems().size()); 
        assertNull(dao.getItem(item2.getName()));
    }

    /**
     * Test of loadInventory method, of class VendingMachineDao.
     */
    @Test
    public void testLoadInventory() throws Exception {
    }

    /**
     * Test of writeInventory method, of class VendingMachineDao.
     */
    @Test
    public void testWriteInventory() throws Exception {
    }

    /**
     * Test of editItem method, of class VendingMachineDao.
     */
    @Test
    public void testEditItem() throws Exception {
    }

}
