/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.dvdlibrary.controller;

import com.sg.dvdlibrary.dao.DvdLibraryDao;
import com.sg.dvdlibrary.dao.DvdLibraryDaoException;
import com.sg.dvdlibrary.dto.Dvd;
import com.sg.dvdlibrary.ui.DvdLibraryView;
import com.sg.dvdlibrary.ui.UserIO;
import com.sg.dvdlibrary.ui.UserIOConsoleImpl;
import java.util.List;

/**
 *
 * @author noahbosa1
 */
public class DvdLibraryController {
    private DvdLibraryView view;
    private DvdLibraryDao dao;
    
    private void viewDvd() throws DvdLibraryDaoException {
        view.displayDvdBanner();
        String title = view.getDvdTitle();
        Dvd dvd = dao.getDvd(title);
        view.displayDvd(dvd);
    }
    private void removeDvd() throws DvdLibraryDaoException {
        view.displayRemoveDvdBanner();
        String title = view.getDvdTitle();
        dao.removeDvd(title);
        view.displayRemoveSuccessBanner();
    }
    
    private void createDvd() throws DvdLibraryDaoException{
        view.displayAddDvdBanner();
        Dvd newDvd = view.getNewDvdInfo();
        dao.addDvd(newDvd.getTitle(),newDvd);
        view.displayAddDvdSuccessBanner();
    }
    private void listAllDvds() throws DvdLibraryDaoException{
        view.displayAllBanner();
        List<Dvd> DvdList = dao.getAllDvds();
        view.displayDvdList(DvdList);
    }
    private void editDvd() throws DvdLibraryDaoException{
        String title = view.getDvdTitle();
        Dvd dvd = dao.getDvd(title);
        view.displayDvd(dvd);
        view.editDvdBanner();
        Dvd updatedDvd = view.getNewDvdInfo();
        dao.addDvd(updatedDvd.getTitle(), updatedDvd);
        view.updatedDvdBannerSuccess();
    }
    private void searchDvdLibrary() throws DvdLibraryDaoException{
        List<Dvd> keyList = dao.getAllDvds();
        view.searchDvdInput(keyList);
        
    }
    public DvdLibraryController(DvdLibraryDao dao, DvdLibraryView view){
        this.dao = dao;
        this.view = view;
    }
    private void defaultMenuAlert(){
        view.defaultMenuAlert();
    }
    private void goodByeBanner(){
        view.goodByeBanner();
    }
    
    
    public void run(){
        boolean keepGoing = true;
        int menuSelection = 0;
        try{
        while (keepGoing){
            view.printMenuAndSelection();
            
            switch(menuSelection){
                case 1:
                    createDvd();
                    break;
                case 2:
                    removeDvd();
                    break;
                case 3:
                    editDvd();
                    break;
                case 4:
                    listAllDvds();
                    break;
                case 5:
                    viewDvd();
                    break;
                case 6:
                    searchDvdLibrary();
                    break;
                case 7:
                    keepGoing = false;
                    break;
                default:
                    defaultMenuAlert();
                    break;
            }
            
        }
        goodByeBanner();
        }catch(DvdLibraryDaoException e){
            view.displayErrorMessage(e.getMessage());
        }
    }
    
}
