/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.flooringmastery.dao;

import com.sg.flooringmastery.dto.Tax;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author noahbosa1
 */
public class TaxDaoStubImpl implements TaxDao{

    List<Tax> taxList = new ArrayList<>();
    Tax tax;
    
    public TaxDaoStubImpl (){
        tax = new Tax("Tx");
        tax.setTaxRate(new BigDecimal("4.45"));
        
        taxList.add(tax);
    }
    @Override
    public Tax addTax(String state, Tax tax) {
        if(state.equals(tax.getState())){
            return tax;
        }else{
            return null;
        }
    }

    @Override
    public List<Tax> getAllTaxes() {
        return taxList;
    }

    @Override
    public Tax getTax(String state) {
        if(state.equals(tax.getState())){
            return tax;
        }else{
            return null;
        }
    }

    @Override
    public Tax removeTax(String state) {
        if(state.equals(tax.getState())){
            return tax;
        }else{
            return null;
        }
    }

    @Override
    public void editTax(String state, Tax taxToEdit) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void loadTax() throws TaxDaoException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void writeTax() throws TaxDaoException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
