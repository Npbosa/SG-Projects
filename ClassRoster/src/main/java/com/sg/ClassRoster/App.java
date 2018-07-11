/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.ClassRoster;

import com.sg.ClassRoster.controller.ClassRosterController;
import com.sg.ClassRoster.dao.ClassRosterAuditDaoFileImpl;
import com.sg.ClassRoster.dao.ClassRosterDao;
import com.sg.ClassRoster.dao.ClassRosterPersistenceException;
import com.sg.ClassRoster.dao.ClassRosterDaoFileImpl;
import com.sg.ClassRoster.service.ClassRosterServiceLayer;
import com.sg.ClassRoster.service.ClassRosterServiceLayerImpl;
import com.sg.ClassRoster.ui.ClassRosterView;
import com.sg.ClassRoster.ui.UserIO;
import com.sg.ClassRoster.ui.UserIOConsoleImpl;

/**
 *
 * @author noahbosa1
 */
public class App {
     public static void main(String[] args) throws ClassRosterPersistenceException {
    UserIO myIo = new UserIOConsoleImpl();
    ClassRosterView myView = new ClassRosterView(myIo);
    ClassRosterDao myDao = new ClassRosterDaoFileImpl();
    ClassRosterAuditDaoFileImpl myAuditDao = new ClassRosterAuditDaoFileImpl();
    ClassRosterServiceLayer myService = new ClassRosterServiceLayerImpl(myDao,myAuditDao);
    ClassRosterController controller = new ClassRosterController(myService, myView);
    controller.run();
}
}
