/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.flooringmastery.dao;

/**
 *
 * @author noahbosa1
 */
public class OrderDaoPersistenceException extends Exception {
    
    public OrderDaoPersistenceException(String message) {
        super(message);
    }
    public OrderDaoPersistenceException(String message, Throwable cause){
        super(message);
    }
}
