/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.ClassRoster.service;

import com.sg.ClassRoster.dao.ClassRosterPersistenceException;
import com.sg.ClassRoster.dto.Student;
import java.util.List;

/**
 *
 * @author noahbosa1
 */
public interface ClassRosterServiceLayer {
    
    void createStudent(Student student) throws
            ClassRosterDuplicateIdException,
            ClassRosterDataValidationException,
            ClassRosterPersistenceException;
    
    List<Student> getAllStudents()
            throws ClassRosterPersistenceException;
    
    Student getStudent(String studentID)
            throws ClassRosterPersistenceException;
    
    Student removeStudent(String StudentId)
            throws ClassRosterPersistenceException;
}
