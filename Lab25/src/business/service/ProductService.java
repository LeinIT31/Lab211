/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package business.service;

import business.utilities.DataInput;
import business.entity.Product;
import data.ProductDaoImpl;

/**
 *
 * @author lyhai
 */
public class ProductService implements IProductService {
    ProductDaoImpl rawProduct = new ProductDaoImpl();
    
    @Override
    public void add() throws Exception {
        String newCode, newName, newManufacturingDate, newExpirationDate, newType;
        
        newCode = DataInput.getString("Enter code of product!");
        newName = DataInput.getString("Enter name of product!");
        newManufacturingDate = DataInput.getString("Enter manufacturing date of product!");
        newExpirationDate = DataInput.getString("Enter expiration date of product!");
        newType = DataInput.getString("Enter type of product!");
        
        Product t = new Product(newCode, newName, newManufacturingDate, newExpirationDate, newType);
        rawProduct.addNew(t);
    }

    @Override
    public void delete() throws Exception {
       String id;
       id = DataInput.getString("Enter id of product need to delete");
       
      int check = rawProduct.delete(id);
      
      if (check == 1){
          System.out.println("Delete successfull.");
      }
        System.out.println("The product does not exist.");
    }

    @Override
    public void update() throws Exception {
        String id;
        
        id = DataInput.getString("Enter id of product need to update");
        
        int check = rawProduct.update(id);
        
        if (check == 1){
            System.out.println("Update succesfull");
        } else System.out.println("The product does not exist");
    }

    @Override
    public void printList() throws Exception {
       rawProduct.printList();
    }
    
}
