/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.ClassRoster.dao;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;

/**
 *
 * @author noahbosa1
 */
public class ClassRosterAuditDaoFileImpl implements ClassRosterAuditDao{
    
    public static final String AUDIT_FILE = "audit.txt";
    
    /**
     *
     * @param entry
     * @throws ClassRosterPersistenceException
     */
    @Override
    public void writeAuditEntry(String entry) throws ClassRosterPersistenceException{
        PrintWriter out;
        
        try{
            out = new PrintWriter(new FileWriter(AUDIT_FILE, true));
        }catch (IOException e){
            throw new ClassRosterPersistenceException("Couldn't persist audit info.",e);
        }
        
        LocalDateTime timeStamp = LocalDateTime.now();
        out.println(timeStamp.toString() +" : "+ entry);
        out.flush();
    }
}
