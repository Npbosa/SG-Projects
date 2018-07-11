/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.ClassRoster.dao;

import com.sg.ClassRoster.dto.Student;
import java.util.List;

/**
 *
 * @author noahbosa1
 */
public interface ClassRosterDao {
    
    Student addStudent(String studentId, Student student)
            throws ClassRosterPersistenceException;
            
    List<Student> getAllStudents()
            throws ClassRosterPersistenceException;
    
    Student getStudent(String studentId)
            throws ClassRosterPersistenceException;
    
    Student removeStudent(String studentId)
            throws ClassRosterPersistenceException;
}
