/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.dvdlibrary.dto;

/**
 *
 * @author noahbosa1
 */
public class Dvd {
    private String title;
    private String releaseDate;
    private String rating;
    private String director;
    private String studio;
    private String userRating;
    
    public Dvd(String title){
        this.title = title;
    }
    
    public String getTitle(){
        return title;
    }
    
    public String getReleaseDate(){
        return releaseDate;
    }
    
    public void setReleaseDate(String releaseDate){
        this.releaseDate = releaseDate;
    }
    
    public String getRating(){
        return rating;
    }
    
    public void setRating(String rating){
        this.rating = rating;
    }
    
    public String getDirector(){
        return director;
    }
    
    public void setDirector(String director){
        this.director = director;
    }
    public String getStudio(){
        return studio;
    }
    
    public void setStudio(String studio){
        this.studio = studio;
    }
    
    public String getUserRating(){
        return userRating;
    }
    
    public void setUserRating(String userRating){
        this.userRating = userRating;
    }

    }
