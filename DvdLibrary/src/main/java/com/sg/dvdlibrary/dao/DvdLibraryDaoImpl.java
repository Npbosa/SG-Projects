/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.dvdlibrary.dao;

import com.sg.dvdlibrary.dto.Dvd;
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
public class DvdLibraryDaoImpl implements DvdLibraryDao{
    
    private Map<String, Dvd> dvds = new HashMap<>();
    public static final String LIBRARY_FILE = "dvdlibrary.txt";
    public static final String DELIMITER = "::";
    
    @Override
    public Dvd addDvd(String title, Dvd dvd)throws DvdLibraryDaoException {
        loadDvdLibrary();
        Dvd newDvd = dvds.put(title, dvd);
        writeDvdLibrary();
        return newDvd;
    }

    @Override
    public List<Dvd> getAllDvds() throws DvdLibraryDaoException {
        loadDvdLibrary();
        return new ArrayList<Dvd>(dvds.values());
    }

    @Override
    public Dvd getDvd(String title) throws DvdLibraryDaoException {
        loadDvdLibrary();
        return dvds.get(title);
    }

    @Override
    public Dvd removeDvd(String title) throws DvdLibraryDaoException {
        loadDvdLibrary();
        Dvd removedDvd = dvds.remove(title);
        writeDvdLibrary();
        return removedDvd;
    }
    public Dvd editDvd(String title) throws DvdLibraryDaoException{
        this.loadDvdLibrary();
        Dvd editedDvd = dvds.get(title);
        writeDvdLibrary();
        return editedDvd;
    }
    private void loadDvdLibrary() throws DvdLibraryDaoException {
	    Scanner scanner;
	    
	    try {
	        // Create Scanner for reading the file
	        scanner = new Scanner(
	                new BufferedReader(
	                        new FileReader(LIBRARY_FILE)));
	    } catch (FileNotFoundException e) {
	        throw new DvdLibraryDaoException(
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
	        currentTokens = currentLine.split(DELIMITER);
	        // Create a new Student object and put it into the map of students
	        // NOTE FOR APPRENTICES: We are going to use the student id
	        // which is currentTokens[0] as the map key for our student object.
	        // We also have to pass the student id into the Student constructor
	        Dvd currentDvd = new Dvd(currentTokens[0]);
	        // Set the remaining vlaues on currentStudent manually
	        currentDvd.setRating(currentTokens[1]);
	        currentDvd.setReleaseDate(currentTokens[2]);
	        currentDvd.setDirector(currentTokens[3]);
                currentDvd.setStudio(currentTokens[4]);
                currentDvd.setUserRating(currentTokens[5]);
	        
	        // Put currentStudent into the map using studentID as the key
	        dvds.put(currentDvd.getTitle(), currentDvd);
	    }
	    // close scanner
	    scanner.close();
	}
    /**
	 * Writes all students in the roster out to a ROSTER_FILE.  See loadRoster
	 * for file format.
	 * 
	 * @throws ClassRosterDaoException if an error occurs writing to the file
	 */
	private void writeDvdLibrary() throws DvdLibraryDaoException {
	    // NOTE FOR APPRENTICES: We are not handling the IOException - but
	    // we are translating it to an application specific exception and 
	    // then simple throwing it (i.e. 'reporting' it) to the code that
	    // called us.  It is the responsibility of the calling code to 
	    // handle any errors that occur.
	    PrintWriter out;
	    
	    try {
	        out = new PrintWriter(new FileWriter(LIBRARY_FILE));
	    } catch (IOException e) {
	        throw new DvdLibraryDaoException(
	                "Could not save student data.", e);
	    }
	    
	    // Write out the Student objects to the roster file.
	    // NOTE TO THE APPRENTICES: We could just grab the student map,
	    // get the Collection of Students and iterate over them but we've
	    // already created a method that gets a List of Students so
	    // we'll reuse it.
	    List<Dvd> DvdList = this.getAllDvds();
	    for (Dvd currentDvd : DvdList) {
	        // write the Student object to the file
	        out.println(currentDvd.getTitle() + DELIMITER
	                + currentDvd.getRating() + DELIMITER 
	                + currentDvd.getReleaseDate() + DELIMITER
	                + currentDvd.getDirector() + DELIMITER
                        + currentDvd.getStudio() + DELIMITER
                        + currentDvd.getUserRating());
	        // force PrintWriter to write line to the file
	        out.flush();
	    }
	    // Clean up
	    out.close();
	}
    

    
    
}
