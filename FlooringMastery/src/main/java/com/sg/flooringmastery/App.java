/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.flooringmastery;

import com.sg.flooringmastery.Controller.Controller;
import com.sg.flooringmastery.dao.OrderDaoPersistenceException;
import com.sg.flooringmastery.dao.ProdPersistenceException;
import com.sg.flooringmastery.dao.ProductDaoException;
import com.sg.flooringmastery.dao.TaxDaoException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author noahbosa1
 */
public class App {
    public static void main(String[] args) throws OrderDaoPersistenceException, ProductDaoException, ProdPersistenceException, TaxDaoException {
    //    UserIO myIO = new UserIOImpl();
    //    FlooringView view = new FlooringView(myIO);
    //    OrdersDao orderDao = new OrdersDaoImpl();
    //    ProductsDao productDao = new ProductsDaoImpl();
    //    TaxDao taxDao = new TaxDaoImpl();
    //   ServiceLayer service = new ServiceLayerImpl(orderDao,productDao,taxDao);
    //  Controller controller = new Controller(service,view);
    //  controller.run();
    
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        Controller controller = ctx.getBean("controller",Controller.class);
        controller.run();
        
    }
}
