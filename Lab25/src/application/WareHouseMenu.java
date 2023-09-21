/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package application;

import business.entity.Product;
import business.entity.Receipt;
import business.service.WareHouseService;
import business.utilities.DataInput;
import java.util.Scanner;

/**
 *
 * @author lyhai
 */
public class WareHouseMenu {

    private final WareHouseService wareHouseService = new WareHouseService();
    static Scanner sc = new Scanner(System.in);

    public void showMenu() throws Exception {
        int choice;

        do {
            System.out.println("//---------------------------------------------//");
            System.out.println("1.add import receipt!");
            System.out.println("2.add export receipt!");
            System.out.println("3.Save file");
            System.out.println("Other, exit.");
            System.out.println("//---------------------------------------------//");
            System.out.print("Select:");

            choice = DataInput.getInt("");

            switch (choice) {
                case 1: {
                    addImportReceipt();
                    break;
                }
                case 2: {
                    addExportReceipt();
                    break;
                }
                case 3: {
                    wareHouseService.saveFile();
                    break;
                }
                case 4: {
                    wareHouseService.printList();
                    break;
                }
            }

        } while (choice >= 1 && choice <= 4);
    }

    public void addImportReceipt() throws Exception {
        wareHouseService.addProductToReceipt(getImportReceipt());
        incrementingNumber++;
    }

    public  void addExportReceipt() throws Exception {
        wareHouseService.addProductToReceipt(getExportReceipt());
        incrementingNumber++;
    }

    public  Receipt getImportReceipt() throws Exception {
        String receiptID, type, customer, address, seller, productID;
        long time;
        int quantity;
        Product product;
        
        receiptID = getReceiptID();
        type = "IMPORT";
        productID = DataInput.getProduct("Enter code of product!");
        quantity = getQuantity();
        product = getProduct(productID, quantity);
        time = getTime();
        customer = getCustomer();
        address = getAddress();
        seller = getSeller();

        return null;

    }

    public  Receipt getExportReceipt() throws Exception {
        String receiptID, type, customer, address, seller, productID;
        int quantity;
        long time;

        Product product;
        
        receiptID = getReceiptID();
        type = "EXPORT";
        
        productID = DataInput.getProduct("Enter product id");
        quantity = getQuantity();
        product = getProduct(productID, quantity);
        time = getTime();
        customer = getCustomer();
        address = getAddress();
        seller = getSeller();

        return null;

    }

    private  int incrementingNumber = 0;

    private  String getReceiptID() throws Exception {
        int tmp;
        int lenght = wareHouseService.listCheck().size();
        if(lenght == 0){
            return "0000000";
        } 
        tmp = Integer.parseInt(wareHouseService.listCheck().get(lenght - 1).getReceiptID()) + 1;
        String id = String.format("%07d", tmp);
        return id;
    }

    private  long getTime() {
        return System.currentTimeMillis();
    }

    private  Product getProduct(String productID, int quantity) {
//        String code, name, manufacturingDate, expirationDate, type;
//        int newQuantity;
//        for (Product product : pList) {
//            if (product.getCode().equalsIgnoreCase(productID)) {
//                code = product.getCode();
//                name = product.getName();
//                manufacturingDate = product.getManufacturingDate();
//                expirationDate = product.getExpirationDate();
//                type = product.getTypes();
//                newQuantity = quantity;
//                Product p = new Product(code, name, manufacturingDate, expirationDate, type, quantity);
//                return p;
//            }
//        }
        return null;
    }

    private  String getCustomer() {
        String customer = DataInput.getString("Enter name of customer!");
        return customer;
    }

    private  String getAddress() {
        String address = DataInput.getString("Enter address of customer!!");
        return address;
    }

    private  String getSeller() {
        String seller = DataInput.getString("Enter name of seller!");
        return seller;
    }

    private  int getQuantity() {
        int quantity = DataInput.getInt("Enter the quantity of product to pick up");
        return quantity;
    }
}
