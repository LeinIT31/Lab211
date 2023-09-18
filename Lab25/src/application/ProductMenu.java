/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package application;

import business.entity.Product;
import business.utilities.DataInput;
import business.service.ProductService;
import data.FileManager;
import data.ProductDaoImpl;
import static data.ProductDaoImpl.pList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author lyhai
 */
public class ProductMenu {

    static ProductService productService = new ProductService();
    static ProductDaoImpl pd = new ProductDaoImpl();

    public static void showMenu() throws Exception {
        FileManager fm = new FileManager();

        int choice = 0;
        do {

            System.out.println("//---------------------------------------------------------//");
            System.out.println("1.Add new product.");
            System.out.println("2.Delete product.");
            System.out.println("3.Update product.");
            System.out.println("4.Print list.");
            System.out.println("5.Save file.");
            System.out.println("Other, exist!");
            System.out.println("//--------------------------------------------------------//");

            choice = DataInput.getInt("Enter your choice!");

            switch (choice) {
                case 1: {
                    addNewProduct();
                    break;
                }
                case 2: {
                    deleteProduct();
                    break;
                }
                case 3: {
                    updateProduct();
                    break;
                }
                case 4: {
                    productService.printList();
                    break;
                }
                case 5: {
                    fm.writeDataToFile(productService.getList());
                    break;
                }
            }

        } while (choice >= 1 && choice <= 5);
    }

    public static Product getNewProduct() {
        String newCode, newName, newManufacturingDate, newExpirationDate, newType;

        newCode = getCodeProduct();
        newName = getNameProduct();
        newManufacturingDate = getManufacturingDate();
        newExpirationDate = getExpirationDate();
        newType = getType();

        Product newProduct = new Product(newCode, newName, newManufacturingDate, newExpirationDate, newType);
        return newProduct;
    }

    public static void addNewProduct() {
        try {
            productService.addNew(getNewProduct());
        } catch (Exception e) {
        }
    }

    public static void deleteProduct() {
        String id = DataInput.getString("Enter code of product you need to delete!");
        try {
            productService.delete(id);
        } catch (Exception ex) {
        }
    }

    private static void updateProduct() {
        String id = DataInput.getString("Enter code of product you need to update!");
        for (Product p : pList) {
            if (p.getCode().equalsIgnoreCase(id)) {
                String choice = DataInput.getString("The product exist! Are you continue update it? Y/N");
                if (choice.equalsIgnoreCase("y")) {
                    try {
                        Product tmp = new Product(id, getNameProduct(), getManufacturingDate(), getExpirationDate(), getType());
                        productService.update(id,tmp);
                    } catch (Exception ex) {
                    }
                }
            }
        }
    }

    public static String getCodeProduct() {
        String code;

        code = DataInput.getStringCode("Enter code of product!");

        return code;
    }

    public static String getNameProduct() {
        String nameProduct = DataInput.getString("Enter name of product!");
        return nameProduct;
    }

    public static String getManufacturingDate() {
        String newManufacturingdate = DataInput.getString("Enter manufacturing date of product");
        return newManufacturingdate;
    }

    public static String getExpirationDate() {
        String newExpirationDate = DataInput.getString("Enter expiration date of product!");
        return newExpirationDate;
    }

    public static String getType() {
        String newType = DataInput.getString("Enter type of product!");
        return newType;
    }
}
