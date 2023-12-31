/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package application;

import business.entity.Product;
import business.utilities.DataInput;
import business.service.ProductService;
import data.FileManager;
import static data.ProductDaoImpl.pList;

/**
 *
 * @author lyhai
 */
public class ProductMenu {

    private static final ProductService productService = new ProductService();

    public static void showMenu() throws Exception {
        int choice;
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
                    productService.saveFile();
//                    fm.writeDataToFile(productService.getList());
                    break;
                }
            }

        } while (choice >= 1 && choice <= 5);
    }

    public static Product getNewProduct() {
        String newCode, newName, newManufacturingDate, newExpirationDate, newType;
        int newQuantity;

        newCode = getCodeProduct();
        newName = getNameProduct();
        newManufacturingDate = getManufacturingDate();
        newExpirationDate = getExpirationDate();
        newType = getType();
        newQuantity = getQuantity();

        Product newProduct = new Product(newCode, newName, newManufacturingDate, newExpirationDate, newType, newQuantity);
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
        for (Product p : pList) {
            if (p.getCode().equalsIgnoreCase(id)) {
                String choice = DataInput.getString("The product exist! Are you continue delete it? Y/N");
                if (choice.equalsIgnoreCase("y")) {
                    try {
                        productService.delete(id);
                    } catch (Exception e) {
                    }
                }
            }
        }
    }

    public static void updateProduct() {
        String id = DataInput.getString("Enter code of product you need to update!");
        for (Product p : pList) {
            if (p.getCode().equalsIgnoreCase(id)) {
                String choice = DataInput.getString("The product exist! Are you continue update it? Y/N");
                if (choice.equalsIgnoreCase("y")) {
                    try {
                        Product tmp = new Product(id, getNameProduct(), getManufacturingDate(), getExpirationDate(), getType(), getQuantity());
                        productService.update(id, tmp);
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
        String newManufacturingdate = DataInput.getDate("Enter manufacturing date of product!  ex. dd-mm-yy");
        return newManufacturingdate;
    }

    public static String getExpirationDate() {
        String newExpirationDate = DataInput.getDate("Enter expiration date of product!  ex. dd-mm-yy");
        return newExpirationDate;
    }

    public static String getType() {
        String tmp = DataInput.getTypeProduct("Enter type of product! 0 -> DAILY / 1 -> LONG-LIFE");
        String newType;
        if (tmp.equals("0")) {
            newType = "DAILY-USE";
        } else if (tmp.equals("1")) {
            newType = "LONG-LIFE-USE";
        } else {
            newType ="";
        }
        return newType;
    }
    public static int getQuantity(){
        int newQuantity = DataInput.getInt("Enter quantity of product!");
        return newQuantity;
    }
}
