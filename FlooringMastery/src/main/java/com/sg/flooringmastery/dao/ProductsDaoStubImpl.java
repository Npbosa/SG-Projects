/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.flooringmastery.dao;

import com.sg.flooringmastery.dto.Product;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author noahbosa1
 */
public class ProductsDaoStubImpl implements ProductsDao{

    List<Product>products = new ArrayList<>();
    Product onlyProduct;
    public ProductsDaoStubImpl(){
        onlyProduct = new Product("Bamboo");
        onlyProduct.setCostPerSquareFoot(BigDecimal.TEN);
        onlyProduct.setLaborCostPerSquareFoot(new BigDecimal("1.50"));
        
        products.add(onlyProduct);
    }
    @Override
    public Product addProduct(String productType, Product product) throws ProductDaoException {
        if(productType.equals(onlyProduct.getProductType())){
            return onlyProduct;
        }else{
            return null;
        }
    }

    @Override
    public List<Product> getAllProducts() throws ProductDaoException {
        return products;
    }

    @Override
    public Product getProduct(String productType) throws ProductDaoException {
        if(productType.equals(onlyProduct.getProductType())){
            return onlyProduct;
        }else{
            return null;
        }
    }

    @Override
    public Product removeProduct(String productType) throws ProductDaoException {
        if(productType.equals(onlyProduct.getProductType())){
            return onlyProduct;
        }else{
            return null;
        }
    }

    @Override
    public void editProduct(String productType, Product ProductToEdit) throws ProductDaoException {

    }

    @Override
    public void loadProduct() throws ProductDaoException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void writeProduct() throws ProductDaoException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
