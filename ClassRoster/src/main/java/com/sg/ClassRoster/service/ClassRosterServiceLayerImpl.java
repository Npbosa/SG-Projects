/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.ClassRoster.service;

import com.sg.ClassRoster.dao.ClassRosterAuditDao;
import com.sg.ClassRoster.dao.ClassRosterDao;
import com.sg.ClassRoster.dao.ClassRosterPersistenceException;
import com.sg.ClassRoster.dto.Student;
import java.util.List;

/**
 *
 * @author noahbosa1
 */
public class ClassRosterServiceLayerImpl implements ClassRosterServiceLayer {
    
    private ClassRosterAuditDao auditDao;
    
    ClassRosterDao dao;
    public ClassRosterServiceLayerImpl(ClassRosterDao dao, ClassRosterAuditDao auditDao){
        this.dao = dao;
        this.auditDao = auditDao;
    }

    @Override
    public void createStudent(Student student)
            throws ClassRosterDuplicateIdException, 
            ClassRosterDataValidationException, 
            ClassRosterPersistenceException {
        if(dao.getStudent(student.getStudentId()) != null){
        throw new UnsupportedOperationException(
                "Error: couldn't create student. student ID "+
                student.getStudentId()+
                        " Already exists");
    }
        validateStudentData(student);
        
        dao.addStudent(student.getStudentId(), student);
        
        auditDao.writeAuditEntry(
                "Student " + student.getStudentId() + " Created.");
    }
    @Override
    public List<Student> getAllStudents()
            throws ClassRosterPersistenceException {
        return dao.getAllStudents();
    }

    @Override
    public Student getStudent(String studentID)
            throws ClassRosterPersistenceException {
        return dao.getStudent(studentID);
    }

    @Override
    public Student removeStudent(String studentId)
            throws ClassRosterPersistenceException {
        Student removedStudent = dao.removeStudent(studentId);
        auditDao.writeAuditEntry("Student "+ studentId + " Removed");
        return removedStudent;
    }
    
    private void validateStudentData(Student student) throws
            ClassRosterDataValidationException {
        
        if(student.getFirstName() == null
                || student.getFirstName().trim().length() == 0
                ||student.getLastName() == null
                || student.getLastName().trim().length() == 0
                ||student.getCohort() == null
                ||student.getCohort().trim().length() == 0){
            
            throw new ClassRosterDataValidationException(
                    "ERROR: All fields [First Name, Last Name, Cohort] are required");
        }
    }
}
