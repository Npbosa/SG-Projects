/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.ClassRoster.service;

/**
 *
 * @author noahbosa1
 */
public class ClassRosterDataValidationException extends Exception{
    
    public ClassRosterDataValidationException(String message){
        super(message);
    }
    public ClassRosterDataValidationException(String message, Throwable cause){
        super(message);
    }
}