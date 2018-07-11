/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.flooringmastery.dao;


import com.sg.flooringmastery.dto.Product;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author noahbosa1
 */
public class ProductsDaoImpl implements ProductsDao{
    
    private Map<String,Product> products = new HashMap<>();
    public static final String LIBRARY_FILE = "globallyUnique_basic/Data/Products.txt";
    public static final String DELIMITER = ",";
    
    @Override
    public Product addProduct(String productType, Product product) throws ProductDaoException{
        Product newProduct = products.put(productType, product);
        writeProduct();
        return newProduct;
    }

    @Override
    public List<Product> getAllProducts() throws ProductDaoException{
        loadProduct();
        return new ArrayList<>(products.values());
    }

    @Override
    public Product getProduct(String productType) throws ProductDaoException {
        Product product = products.get(productType);
        writeProduct();
        return product;
    }

    @Override
    public Product removeProduct(String productType) throws ProductDaoException{
        Product removedProduct = products.remove(productType);
        writeProduct();
        return removedProduct;
    }

    @Override
    public void editProduct(String oldProductType,Product productToEdit) throws ProductDaoException{
        if (oldProductType == productToEdit.getProductType()){
            this.products.replace(oldProductType, productToEdit);
        }else{
            Product oldProduct = this.products.remove(oldProductType);
            this.products.put(productToEdit.getProductType(), productToEdit);
        }
        this.writeProduct();
    }


    @Override
    public void loadProduct() throws ProductDaoException {
        Scanner scanner;

        try {
            // Create Scanner for reading the file
            scanner = new Scanner(
                    new BufferedReader(
                            new FileReader(LIBRARY_FILE)));
        } catch (FileNotFoundException e) {
            throw new ProductDaoException(
                    "-_- Could not load product data into memory.", e);
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
            Product currentProduct = new Product((currentTokens[0]));
            // Set the remaining vlaues on currentStudent manually
            BigDecimal costPerSquareFoot = (new BigDecimal(currentTokens[1]));
            currentProduct.setCostPerSquareFoot(costPerSquareFoot);
            BigDecimal setLaborCostPerFoot = new BigDecimal(currentTokens[2]);
            currentProduct.setLaborCostPerSquareFoot(setLaborCostPerFoot);

            // Put currentStudent into the map using studentID as the key
            products.put(currentProduct.getProductType(), currentProduct);
        }
        // close scanner
        scanner.close();
    }


    @Override
    public void writeProduct() throws ProductDaoException {
        // NOTE FOR APPRENTICES: We are not handling the IOException - but
        // we are translating it to an application specific exception and 
        // then simple throwing it (i.e. 'reporting' it) to the code that
        // called us.  It is the responsibility of the calling code to 
        // handle any errors that occur.
        PrintWriter out;

        try {
            out = new PrintWriter(new FileWriter(LIBRARY_FILE));
        } catch (IOException e) {
            throw new ProductDaoException(
                    "Could not save student data.", e);
        }

        // Write out the Student objects to the roster file.
        // NOTE TO THE APPRENTICES: We could just grab the student map,
        // get the Collection of Students and iterate over them but we've
        // already created a method that gets a List of Students so
        // we'll reuse it.
        List<Product> ProductList = this.getAllProducts();
        for (Product currentProduct : ProductList) {
            // write the Student object to the file
            out.println(currentProduct.getProductType()+ DELIMITER
                    + currentProduct.getCostPerSquareFoot() + DELIMITER
                    + currentProduct.getLaborCostPerSquareFoot());
            // force PrintWriter to write line to the file
            out.flush();
        }
        // Clean up
        out.close();
    }
}
