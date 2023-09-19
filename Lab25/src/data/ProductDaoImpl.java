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
 *
 * @author lyhai
 */
public class ProductDaoImpl implements IProductDao {

    public static final List<Product> pList = new ArrayList<>();
    static IFile fm = new FileManager();

    public ProductDaoImpl() {
    }

    public ProductDaoImpl(IFile fm) throws Exception {
        this.fm = fm;
    }

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
        if (pList.isEmpty() == true) {
            throw new Exception("Product list is empty");
        }

        return pList;
    }

    @Override
    public boolean printList() throws Exception {
        for (Product p : pList) {
            System.out.println(p);
        }
        return true;
    }

    public final List<Product> loadDataFromFile() throws Exception {
        if (!pList.isEmpty()) {
            for (String p : fm.readDataFromFile()) {
                pList.add(convertStringToProduct(p));
            }
        }
        return pList;
    }

    public Product convertStringToProduct(String rawProduct) {
        String code, name, manufacturingDate, expirationDate, types;
        int quantity;
        List<String> raw = Arrays.asList(rawProduct.split(","));

        code = raw.get(0).trim().toUpperCase();
        name = raw.get(1).trim();
        manufacturingDate = raw.get(2).trim();
        expirationDate = raw.get(3).trim();
        types = raw.get(4).trim();
        quantity = Integer.valueOf(raw.get(5).trim());

        return new Product(code, name, manufacturingDate, expirationDate, types, quantity);
    }
}
