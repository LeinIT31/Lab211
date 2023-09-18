/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package data;

import business.utilities.DataInput;
import business.entity.Product;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author lyhai
 */
public class ProductDaoImpl implements IProductDao {
    
    public static final List<Product> pList = new ArrayList<>();
    static FileManager fm = new FileManager();
    
    @Override
    public boolean update(String code, Product newP) throws Exception {
        for (Product p : pList) {
            if (p.getCode().equalsIgnoreCase(code)) {
                p.setCode(p.getCode());
                
                if (newP.getName().isEmpty()) {
                    p.setName(p.getName());
                } else {
                    p.setName(newP.getName());
                }
                
                if (newP.getManufacturingDate().isEmpty()) {
                    p.setManufacturingDate(p.getManufacturingDate());
                } else {
                    p.setManufacturingDate(newP.getManufacturingDate());
                }
                
                if (newP.getExpirationDate().isEmpty()) {
                    p.setExpirationDate(p.getExpirationDate());
                } else {
                    p.setExpirationDate(newP.getExpirationDate());
                }
                
                if (newP.getTypes().isEmpty()) {
                    p.setTypes(p.getTypes());
                } else {
                    p.setTypes(newP.getTypes());
                }

            }
        }
        return true;
    }
    
    @Override
    public boolean delete(String id) throws Exception {
        for (Product p : pList) {
            if (p.getCode().equalsIgnoreCase(id)) {
                pList.remove(p);
                return true;
            }
        }
        return false;
    }
    
    @Override
    public boolean add(Product p) throws Exception {
        pList.add(p);
        return true;
    }
    
    @Override
    public List<Product> getList() throws Exception {
        return pList;
    }
    
    @Override
    public boolean printList() throws Exception {
        System.out.println(pList.toString());
        return true;
    }
//    public List<Product> loadDataFromFile() throws Exception{
//        List<String> strList = fm.readDateFromFile();
//        List<Product> pList = new ArrayList<>();
//        
//        for (String p : strList){
//            Product product = (Product) rawDataToProduct(p);
//            pList.add(product);
//        }
//    }
//    public List<String> rawDataToProduct(String rawProduct){
//        List<String> raw = Arrays.asList(rawProduct.split(","));
//    }
}
