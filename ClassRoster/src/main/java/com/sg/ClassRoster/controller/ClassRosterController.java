/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.ClassRoster.controller;

import com.sg.ClassRoster.dao.ClassRosterDao;
import com.sg.ClassRoster.dao.ClassRosterPersistenceException;
import com.sg.ClassRoster.dao.ClassRosterDaoFileImpl;
import com.sg.ClassRoster.dto.Student;
import com.sg.ClassRoster.service.ClassRosterDataValidationException;
import com.sg.ClassRoster.service.ClassRosterDuplicateIdException;
import com.sg.ClassRoster.service.ClassRosterServiceLayer;
import com.sg.ClassRoster.ui.ClassRosterView;
import com.sg.ClassRoster.ui.UserIO;
import com.sg.ClassRoster.ui.UserIOConsoleImpl;
import java.util.List;

/**
 *
 * @author noahbosa1
 */
public class ClassRosterController {

    ClassRosterView view;
    ClassRosterServiceLayer service;
    private UserIO io;

    private void unKnownCommand() {
        view.displayUnknownCommandBanner();
    }

    private void exitMessage() {
        view.displayExitBanner();
    }

    private void viewStudent() throws ClassRosterPersistenceException {
        view.displayDisplayStudentBanner();
        String studentId = view.getStudentIdChoice();
        Student student = service.getStudent(studentId);
        view.displayStudent(student);
    }

    private void createStudent() throws ClassRosterPersistenceException {
        view.displayCreateStudentBanner();
        boolean hasErrors = false;
        do {
            Student newStudent = view.getNewStudentInfo();
            try{
            service.createStudent(newStudent);
            view.displayCreateSuccessBanner();
            hasErrors = false;
            }catch (ClassRosterDuplicateIdException |
                    ClassRosterDataValidationException e){
                hasErrors = true;
                view.displayErrorMessage(e.getMessage());
            }
        }while (hasErrors);
    
    }

    private void listStudents() throws ClassRosterPersistenceException {
        view.displayDisplayAllBanner();
        List<Student> studentList = service.getAllStudents();
        view.displayStudentList(studentList);
    }

    private void removeStudent() throws ClassRosterPersistenceException {
        view.displayRemoveStudentBanner();
        String studentId = view.getStudentIdChoice();
        service.removeStudent(studentId);
        view.displayRemoveSuccessBanner();
    }

    private int getMenuSelection() {
        return view.printMenuAndGetSelection();
    }

    public ClassRosterController(ClassRosterServiceLayer service, ClassRosterView view) {
        this.service = service;
        this.view = view;
    }

    public void run() throws ClassRosterPersistenceException {
        boolean keepGoing = true;
        int menuSelection = 0;
        while (keepGoing) {

            menuSelection = getMenuSelection();

            switch (menuSelection) {
                case 1:
                    listStudents();
                    break;
                case 2:
                    createStudent();
                    break;
                case 3:
                    viewStudent();
                    break;
                case 4:
                    removeStudent();
                    break;
                case 5:
                    keepGoing = false;
                    break;
                default:
                    unKnownCommand();
            }
        }
        exitMessage();

    }
}
