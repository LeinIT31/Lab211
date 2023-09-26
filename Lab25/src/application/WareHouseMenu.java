/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package application;

import business.entity.ItemReceipt;
import business.entity.Product;
import business.entity.Receipt;
import business.service.WareHouseService;
import business.utilities.DataInput;
import data.IProductDao;
import data.ProductDaoImpl;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author lyhai
 */
public class WareHouseMenu {

    private final WareHouseService wareHouseService = new WareHouseService();
    IProductDao productDaotmp = ProductDaoImpl.getInstance();

    public void showMenu() throws Exception {
        int choice;

        do {
            System.out.println("//---------------------------------------------//");
            System.out.println("1.add import receipt!");
            System.out.println("2.add export receipt!");
            System.out.println("3.Save file");
            System.out.println("4. Show all receipt");
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

    public void addExportReceipt() throws Exception {
        wareHouseService.addProductToReceipt(getExportReceipt());
        incrementingNumber++;
    }

    public Receipt getImportReceipt() throws Exception {
        String receiptID, type, customer, customerAddress, seller, sellerAddress;
        long time;
        List<ItemReceipt> itemReceiptList = new ArrayList<>();
        Product product;

        receiptID = getReceiptID();
        type = "IMPORT";
        time = getTime();
        customer = getCustomer();
        customerAddress = getCustomerAddress();
        seller = getSeller();
        sellerAddress = getSellerAddress();

        //Allow input more product
        String choice = "y";
        while (choice.equalsIgnoreCase("y")) {
            ItemReceipt item = getItemReceiptForImport(receiptID);
            itemReceiptList.add(item);
            wareHouseService.addItemReceipt(item);
            choice = DataInput.getString("Are you want to add product? Y/N");
        }

        return new Receipt(receiptID, type, time, customer, customerAddress, seller, sellerAddress, itemReceiptList);
    }

    public Receipt getExportReceipt() throws Exception {
        String receiptID, type, customer, customerAddress, seller, sellerAddress;
        long time;
        List<ItemReceipt> itemReceiptList = new ArrayList<>();
        Product product;

        receiptID = getReceiptID();
        type = "EXPORT";
        time = getTime();
        customer = getCustomer();
        customerAddress = getCustomerAddress();
        seller = getSeller();
        sellerAddress = getSellerAddress();

        //Allow input more product
        String choice = "y";
        while (choice.equalsIgnoreCase("y")) {
            ItemReceipt item = getItemReceiptForExport(receiptID);
            itemReceiptList.add(item);
            wareHouseService.addItemReceipt(item);
            choice = DataInput.getString("Are you want to add product? Y/N");
        }

        return new Receipt(receiptID, type, time, customer, customerAddress, seller, sellerAddress, itemReceiptList);

    }

    private int incrementingNumber = 0;

    private String getReceiptID() throws Exception {
        int tmp;
        int lenght = wareHouseService.getList().size();
        if (lenght == 0) {
            return "0000000";
        }
        tmp = Integer.parseInt(wareHouseService.getList().get(lenght - 1).getReceiptID()) + 1;
        String id = String.format("%07d", tmp);
        return id;
    }

    private long getTime() {
        return System.currentTimeMillis();
    }

    private String getCustomer() {
        String customer = DataInput.getString("Enter name of customer!");
        return customer;
    }

    private String getCustomerAddress() {
        String address = DataInput.getString("Enter address of customer!!");
        return address;
    }

    private String getSeller() {
        String seller = DataInput.getString("Enter name of seller!");
        return seller;
    }

    private String getSellerAddress() {
        String address = DataInput.getString("Enter address of seller!");
        return address;
    }

    private int getQuantity() {
        int quantity = DataInput.getInt("Enter the quantity of product to pick up");
        return quantity;
    }

    private int getPrice() {
        int price = DataInput.getInt("Enter the price of product to pick up");
        return price;
    }

    public ItemReceipt getItemReceiptForImport(String id) throws Exception {
        String code, receiptID, productName;
        int price, quantityNeed;
        receiptID = id;
        Product p = DataInput.getProductForImport("Enter code of product!");
        if (p == null) {
            p = getNewProduct();
        }

        code = p.getCode();
        productName = p.getName();
        price = p.getPrice();
        quantityNeed = getQuantity();
        return new ItemReceipt(code, receiptID, productName, price, quantityNeed);
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

    public ItemReceipt getItemReceiptForExport(String id) throws Exception {
        String code, receiptID, productName;
        int price, quantityNeed;
        receiptID = id;
        Product p = DataInput.getProductForExport("Enter code of product!");
        if (p != null) {
            code = p.getCode();
            productName = p.getName();
            price = p.getPrice();
            quantityNeed = getQuantity();
            return new ItemReceipt(code, receiptID, productName, price, quantityNeed);
        }
        return null;
    }
}
