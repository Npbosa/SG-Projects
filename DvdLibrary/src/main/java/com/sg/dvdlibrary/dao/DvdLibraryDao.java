/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.dvdlibrary.dao;

import com.sg.dvdlibrary.dto.Dvd;
import java.util.List;

/**
 *
 * @author noahbosa1
 */
public interface DvdLibraryDao {
    
    Dvd addDvd(String title, Dvd dvd) throws DvdLibraryDaoException;
    
    List<Dvd> getAllDvds() throws DvdLibraryDaoException;
    
    Dvd getDvd(String title) throws DvdLibraryDaoException;
    
    Dvd removeDvd(String title)throws DvdLibraryDaoException;
    
    
}
