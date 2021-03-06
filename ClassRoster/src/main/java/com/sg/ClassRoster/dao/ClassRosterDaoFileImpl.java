/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.ClassRoster.dao;

import com.sg.ClassRoster.dto.Student;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author noahbosa1
 */
public class ClassRosterDaoFileImpl implements ClassRosterDao {
    
    private void loadRoster() throws ClassRosterPersistenceException {
	    Scanner scanner;
	    
	    try {
	        // Create Scanner for reading the file
	        scanner = new Scanner(
	                new BufferedReader(
	                        new FileReader(Roster_File)));
	    } catch (FileNotFoundException e) {
	        throw new ClassRosterPersistenceException(
	                "-_- Could not load roster data into memory.", e);
	    }
	    // currentLine holds the most recent line read from the file
	    String currentLine;
	    // currentTokens holds each of the parts of the currentLine after it has
	    // been split on our DELIMITER
	    // NOTE FOR APPRENTICES: In our case we use :: as our delimiter.  If
	    // currentLine looks like this:
	    // 1234::Joe::Smith::Java-September2013
	    // then currentTokens will be a string array that looks like this:
	    //
	    // ___________________________________
	    // |    |   |     |                  |
	    // |1234|Joe|Smith|Java-September2013|
	    // |    |   |     |                  |
	    // -----------------------------------
	    //  [0]  [1]  [2]         [3]
	    String[] currentTokens;
	    // Go through ROSTER_FILE line by line, decoding each line into a 
	    // Student object.
	    // Process while we have more lines in the file
	    while (scanner.hasNextLine()) {
	        // get the next line in the file
	        currentLine = scanner.nextLine();
	        // break up the line into tokens
	        currentTokens = currentLine.split(Delimiter);
	        // Create a new Student object and put it into the map of students
	        // NOTE FOR APPRENTICES: We are going to use the student id
	        // which is currentTokens[0] as the map key for our student object.
	        // We also have to pass the student id into the Student constructor
	        Student currentStudent = new Student(currentTokens[0]);
	        // Set the remaining vlaues on currentStudent manually
	        currentStudent.setFirstName(currentTokens[1]);
	        currentStudent.setLastName(currentTokens[2]);
	        currentStudent.setCohort(currentTokens[3]);
	        
	        // Put currentStudent into the map using studentID as the key
	        students.put(currentStudent.getStudentId(), currentStudent);
	    }
	    // close scanner
	    scanner.close();
	}
    private void writeRoster() throws ClassRosterPersistenceException {
	    // NOTE FOR APPRENTICES: We are not handling the IOException - but
	    // we are translating it to an application specific exception and 
	    // then simple throwing it (i.e. 'reporting' it) to the code that
	    // called us.  It is the responsibility of the calling code to 
	    // handle any errors that occur.
	    PrintWriter out;
	    
	    try {
	        out = new PrintWriter(new FileWriter(Roster_File));
	    } catch (IOException e) {
	        throw new ClassRosterPersistenceException(
	                "Could not save student data.", e);
	    }
	    
	    // Write out the Student objects to the roster file.
	    // NOTE TO THE APPRENTICES: We could just grab the student map,
	    // get the Collection of Students and iterate over them but we've
	    // already created a method that gets a List of Students so
	    // we'll reuse it.
	    List<Student> studentList = this.getAllStudents();
	    for (Student currentStudent : studentList) {
	        // write the Student object to the file
	        out.println(currentStudent.getStudentId() + Delimiter
	                + currentStudent.getFirstName() + Delimiter 
	                + currentStudent.getLastName() + Delimiter
	                + currentStudent.getCohort());
	        // force PrintWriter to write line to the file
	        out.flush();
	    }
	    // Clean up
	    out.close();
	}
    private Map<String, Student> students = new HashMap<>();
    public static final String Roster_File = "roster.txt";
    public static final String Delimiter = "::";

    /**
     *
     * @param studentId
     * @param student
     * @return
     * @throws ClassRosterPersistenceException
     */
    @Override
    public Student addStudent(String studentId, Student student) 
            throws ClassRosterPersistenceException {
        Student newStudent = students.put(studentId, student);
        writeRoster();
        return newStudent;//To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Student> getAllStudents() throws ClassRosterPersistenceException {
        loadRoster();
        return new ArrayList<Student>(students.values()); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Student getStudent(String studentId) throws ClassRosterPersistenceException {
        loadRoster();
        return students.get(studentId);
    }

    @Override
    public Student removeStudent(String studentId) throws ClassRosterPersistenceException {
        Student removedStudent = students.remove(studentId);
        writeRoster();
        return removedStudent;
    }
    
}
