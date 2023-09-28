/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package application;

import business.entity.Product;
import business.utilities.DataInput;
import business.service.ProductService;
import data.IProductDao;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author lyhai
 */
public class ProductMenu {

    private final ProductService productService = new ProductService();
    
    public void showMenu() throws Exception {
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
                    break;
                }
                case 6: {
                    remove();
                    break;
                }
            }

        } while (choice >= 1 && choice <= 5);
    }

    public Product getNewProduct() {
        String newCode, newName, newManufacturingDate, newExpirationDate, newType;
        int newQuantity, newPrice;

        newCode = getCodeProduct();
        newName = getNameProduct();
        newManufacturingDate = getManufacturingDate();
        newExpirationDate = getExpirationDate();
        newType = getType();
        newQuantity = getQuantity();
        newPrice = getPrice();

        
        return new Product(newCode, newName, newManufacturingDate, newExpirationDate, newType, newQuantity, newPrice);
    }

    public void addNewProduct() {

        try {
            productService.addNew(getNewProduct());

            System.out.println("Are you want to add countinous? Y/N");
            String choice = DataInput.getString("");

            while (choice.equalsIgnoreCase("y")) {
                productService.addNew(getNewProduct());
                System.out.println("Are you want to add countinous? Y/N");
                choice = DataInput.getString("");
            }
        } catch (Exception e) {
        }
    }

    public void deleteProduct() {
        String id = DataInput.getString("Enter code of product you need to delete!");
        try {
            for (Product p : productService.getList()) {
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
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }

    public void updateProduct() throws Exception {
        String id = DataInput.getString("Enter code of product you need to update!");
            for (Product p : productService.getList()) {
                if (p.getCode().equalsIgnoreCase(id)) {
                    String choice = DataInput.getString("The product exist! Are you continue update it? Y/N");
                    if (choice.equalsIgnoreCase("y")) {
                        String productName, manufacturingDate, expirationDate, type;
                        int quantity, price;
                        productName = getNameProduct();
                            manufacturingDate = DataInput.getString("Enter new manufacturingDate of product");
                            if(!manufacturingDate.isEmpty()){
                                manufacturingDate = getManufacturingDate();
                            }
                            expirationDate = DataInput.getString("Enter new expirationDate of product");
                            if(!expirationDate.isEmpty()){
                                expirationDate = getExpirationDate();
                            }
                            type = getType();
                            
                            quantity = DataInput.getIntForUpdate("Enter new quantity for product!");
                            price = DataInput.getIntForUpdate("Enter new price for product!");
                            
                            Product tmp = new Product(id, productName, manufacturingDate, expirationDate, type, quantity, price);
                            productService.update(id, tmp);
                    }
                }
            }
    }

    public String getCodeProduct() {
        String code;

        code = DataInput.getStringCode("Enter code of product!");

        return code;
    }

    public String getNameProduct() {
        String nameProduct = DataInput.getString("Enter name of product!");
        return nameProduct;
    }

    public String getManufacturingDate() {
        String newManufacturingdate = DataInput.getDate("Enter manufacturing date of product!  ex. dd-mm-yy");
        return newManufacturingdate;
    }

    public String getExpirationDate() {
        String newExpirationDate = DataInput.getDate("Enter expiration date of product!  ex. dd-mm-yy");
        return newExpirationDate;
    }

    public String getType() {
        String tmp = DataInput.getTypeProduct("Enter type of product! 0 -> DAILY / 1 -> LONG-LIFE");
        String newType;
        if (tmp.equals("0")) {
            newType = "DAILY-USE";
        } else if (tmp.equals("1")) {
            newType = "LONG-LIFE-USE";
        } else {
            newType = "";
        }
        return newType;
    }

    public int getQuantity() {
        int newQuantity = DataInput.getInt("Enter quantity of product!");
        return newQuantity;
    }
    public int getPrice(){
        int newPrice = DataInput.getInt("Enter price of product!");
        return newPrice;
    }   
    public void remove(){
       int quantity = DataInput.getInt("");
        productService.removeByQuantity(quantity);
    }
}
