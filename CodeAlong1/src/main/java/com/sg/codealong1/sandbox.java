/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.codealong1;

import java.math.BigDecimal;

/**
 *
 * @author noahbosa1
 */
public class sandbox {
    
    public static void main(String[] args){
    BigDecimal change = new BigDecimal("7.5");
    int dollars = 0;
        
        while(change.compareTo(BigDecimal.ONE) < 0){
            change.subtract(BigDecimal.ONE);
            dollars++;
        }
        System.out.println(dollars);
    } 
            
}