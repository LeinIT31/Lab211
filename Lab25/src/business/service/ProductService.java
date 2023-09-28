/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package business.service;

import business.entity.Product;
import data.IProductDao;
import data.ProductDaoImpl;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author lyhai
 */
public class ProductService implements IProductService {

    IProductDao rawProduct = ProductDaoImpl.getInstance();

    @Override
    public void addNew(Product p) {
        try {
            boolean isCheck = rawProduct.add(p);
            if (isCheck) {
                System.out.println("Add product successfully!");
                    
            } else {
                System.out.println("Add failed!");
            }
        } catch (Exception e) {
        }
    }

    @Override
    public void delete(String id) throws Exception {

        try {
            boolean status = rawProduct.delete(id);
            if (status) {
                System.out.println("Delete successfully!");
            } else {
                System.out.println("Delete failed!");
            }
        } catch (Exception e) {
        }
    }

    @Override
    public void update(String id, Product p) throws Exception {

        try {
            boolean status = rawProduct.update(id,p);
            
            if (status){
                System.out.println("Update successfully!");
            } else System.out.println("Update failed!");
        } catch (Exception e) {
        }
    }

    @Override
    public void printList() throws Exception {
        for (Product product : getList()) {
            System.out.println(product);
        }
    }

    @Override
    public List<Product> getList() throws Exception {
        return rawProduct.getList();
    }

    @Override
    public void saveFile() throws Exception {
        rawProduct.saveFile();
    }
    public void removeByQuantity(int quantity){
        try {
            boolean isCheck = rawProduct.removeByQuantity(quantity);
            if (isCheck){
                System.out.println("Successfull");
            } else System.out.println("Failed");
        } catch (Exception ex) {
            System.out.println(ex);
        }
        
 
    }
}
