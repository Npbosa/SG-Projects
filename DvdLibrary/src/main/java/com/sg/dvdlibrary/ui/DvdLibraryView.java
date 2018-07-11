/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.dvdlibrary.ui;

import com.sg.dvdlibrary.dto.Dvd;
import static java.util.Collections.list;
import java.util.List;

/**
 *
 * @author noahbosa1
 */
public class DvdLibraryView {
    private UserIO io;
    public DvdLibraryView(UserIO io){
        this.io = io;
    }
    public void displayErrorMessage(String errorMsg){
        io.print("=== Error ===");
        io.print(errorMsg);
    }
    
    public int printMenuAndSelection(){
        io.print("Main Menu");
            io.print("1. Add A DVD ");
            io.print("2. Remove a DVD ");
            io.print("3. Edit info on existing DVD");
            io.print("4. List entire collection ");
            io.print("5. Display info on specific DVD");
            io.print("6. Search for DVD by title");
            io.print("7. Exit");
            
            return io.readInt("Please select from the above choices.",1,5);
    }
    public Dvd getNewDvdInfo(){
       String title = io.readString("Please enter the title of the dvd");
       String releaseDate = io.readString("PLease enter the release date of the dvd");
       String rating = io.readString("Please enter the MPAA rating");
       String director = io.readString("Please enter the director of the film");
       String studio = io.readString("Please enter the studio that produced the film");
       String userRating = io.readString("Please enter what you would rate the film");
       Dvd currentDvd = new Dvd(title);
       currentDvd.setRating(rating);
       currentDvd.setReleaseDate(releaseDate);
       currentDvd.setDirector(director);
       currentDvd.setStudio(studio);
       currentDvd.setUserRating(userRating);
       return currentDvd;
    }
    public void displayAddDvdBanner(){
        io.print("=== Add DVD ===");
    }
    public void displayAddDvdSuccessBanner(){
        io.readString("DVD successfully added. Hit Enter to continue");
    }
    public void displayDvdList(List<Dvd> dvdList){
        for (Dvd currentDvd : dvdList){
            io.print(currentDvd.getTitle() + ": "
                    + currentDvd.getReleaseDate() + ": "
                    + currentDvd.getRating() + ": "
                    + currentDvd.getDirector() + ": " 
                    + currentDvd.getStudio()+ ": " + currentDvd.getUserRating());
        }
        io.readString("Please hit enter to continue.");
    }
    public void displayAllBanner(){
        io.print("=== Displaying All DVD's ===");
    }
    public void displayDvdBanner(){
        io.print("=== View A Specific DVD ===");
    }
    public void defaultMenuAlert(){
        io.print("=== ERROR ===");
    }
    public void goodByeBanner(){
        io.print("Later Loser!");
    }
    public String getDvdTitle() {
        return io.readString("Please enter the title of the DVD");
    }
    public void displayDvd(Dvd dvd){
        if (dvd != null){
            io.print("=== Displaying info ===");
            io.print("Title:");
            io.print(dvd.getTitle());
            io.print("Release Date:");
            io.print(dvd.getReleaseDate());
            io.print("Rating:");
            io.print(dvd.getRating());
            io.print("Director:");
            io.print(dvd.getDirector());
            io.print("Studio:");
            io.print(dvd.getStudio());
            io.print("User Rating:");
            io.print(dvd.getUserRating());
        }else{
            io.print("No such DVD in collection");
        }
        io.readString("Please hit enter to continue");
    }
    public void displayRemoveSuccessBanner(){
        io.print("Dvd successfully removed. Please hit enter to continue");
    }
    public void displayRemoveDvdBanner(){
        io.print("=== Remove DVD ===");
    }
    public void editDvdBanner(){
        io.readString("Adjust the DVD's information to your liking");       
    }
    public void updatedDvdBannerSuccess(){
        io.print("DVD updated successfully");
    }
    public void searchDvdInput(List<Dvd> keyList){
        String userChoice = io.readString("What would you like to search for?");
        for(Dvd currentDvd : keyList){
            String currentTitle = currentDvd.getTitle();
            if(currentTitle.contains(userChoice)){
                io.print("Title:");
                io.print(currentDvd.getTitle());
                io.print("Release Date:");
                io.print(currentDvd.getReleaseDate());
                io.print("Rating:");
                io.print(currentDvd.getRating());
                io.print("Director:");
                io.print(currentDvd.getDirector());
                io.print("User Rating:");
                io.print(currentDvd.getUserRating());
            }
        }
        
    }

}
