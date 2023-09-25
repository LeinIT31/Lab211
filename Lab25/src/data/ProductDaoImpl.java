/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package data;

import business.entity.Product;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author lyhai
 */
public class ProductDaoImpl implements IProductDao {

    public final List<Product> pList = new ArrayList<>();
    private IManagerFile pFileManager;

    public ProductDaoImpl() {
        try {
            pFileManager = new FileManager("Product.txt");
            loadDataFromFile();
        } catch (Exception ignore) {

        }
    }

    @Override
    public boolean update(String code, Product newP) {
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

                
                if (newP.getQuantity() == -1) {
                    p.setQuantity(p.getQuantity());
                } else {
                    p.setQuantity(newP.getQuantity());
                }

                if (newP.getPrice() == -1) {
                    p.setPrice(p.getPrice());
                } else {
                    p.setPrice(newP.getPrice());
                }
            }
        }
        return true;
    }

    @Override
    public boolean delete(String id) {
        for (Product p : pList) {
            if (p.getCode().equalsIgnoreCase(id)) {
                pList.remove(p);
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean add(Product p) {
        pList.add(p);
        return true;
    }

    private void loadDataFromFile() throws Exception {
        for (String p : pFileManager.readDataFromFile()) {
            pList.add(convertStringToProduct(p));
        }
    }

    public Product convertStringToProduct(String rawProduct) {
        String code, name, manufacturingDate, expirationDate, types;
        int quantity, price;
        List<String> raw = Arrays.asList(rawProduct.split(","));

        code = raw.get(0).trim().toUpperCase();
        name = raw.get(1).trim();
        manufacturingDate = raw.get(2).trim();
        expirationDate = raw.get(3).trim();
        types = raw.get(4).trim();
        quantity = Integer.parseInt(raw.get(5).trim());
        price = Integer.parseInt(raw.get(6).trim());
        return new Product(code, name, manufacturingDate, expirationDate, types, quantity, price);
    }

    @Override
    public void saveFile() throws Exception {
        pFileManager.writeDataToFile(pList);
    }

    private static IProductDao INSTANCE = null;

    public static IProductDao getInstance() {
        if (INSTANCE == null) {
            synchronized (ProductDaoImpl.class) {
                INSTANCE = new ProductDaoImpl();
            }
        }
        return INSTANCE;
    }

    public List<Product> getList() {
        return pList;
    }
    
}
