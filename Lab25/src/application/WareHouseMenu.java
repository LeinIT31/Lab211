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
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author lyhai
 */
public class WareHouseMenu {

    private final WareHouseService wareHouseService = new WareHouseService();
    static Scanner sc = new Scanner(System.in);
    IProductDao productDaotmp = ProductDaoImpl.getInstance();

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

    public void addExportReceipt() throws Exception {
        wareHouseService.addProductToReceipt(getExportReceipt());
        incrementingNumber++;
    }

    public Receipt getImportReceipt() throws Exception {
        String receiptID, type, customer, customerAddress, seller, sellerAddress;
        long time;
        List<ItemReceipt> itemReceiptList;
        Product product;

        receiptID = getReceiptID();
        type = "IMPORT";
        time = getTime();
        customer = getCustomer();
        customerAddress = getCustomerAddress();
        seller = getSeller();
        sellerAddress = getSellerAddress();
        itemReceiptList = getItemReceiptsListForImport();

        return new Receipt(receiptID, type, time, customer, customerAddress, seller, sellerAddress, itemReceiptList);
    }

    public Receipt getExportReceipt() throws Exception {
        String receiptID, type, customer, customerAddress, seller, sellerAddress;
        long time;
        List<ItemReceipt> itemReceiptList;
        Product product;

        receiptID = getReceiptID();
        type = "EXPORT";
        time = getTime();
        customer = getCustomer();
        customerAddress = getCustomerAddress();
        seller = getSeller();
        sellerAddress = getSellerAddress();
        itemReceiptList = getItemReceiptsListForExport();

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

    private ItemReceipt getItemReceiptForImport() {

        ItemReceipt itemReceipt = null;

        try {
           itemReceipt = DataInput.getProductForImport("Enter id of product!");
        } catch (Exception ex) {
            System.out.println(ex);
        }
        return itemReceipt;
    }

    private List<ItemReceipt> getItemReceiptsListForImport() {
        List<ItemReceipt> listTmp = new ArrayList<>();
        String choice = "y";
        
        while(choice.equals("y")){
                 listTmp.add(getItemReceiptForImport());  
                choice = DataInput.getString("Are you want to continue add product? Y/N").toLowerCase();
        }
        return listTmp;
    }

    private ItemReceipt getItemReceiptForExport() {
        ItemReceipt itemReceipt = null;
        try {
            itemReceipt = DataInput.getProductForExport("Enter id of product!");
        } catch (Exception ex) {
            System.out.println(ex);
        }
        return itemReceipt;
    }

    private List<ItemReceipt> getItemReceiptsListForExport() {
        List<ItemReceipt> itemReceiptList = new ArrayList<>();
        String choice;
        do {
            choice = DataInput.getString("Are you want to countinue add product? Y/N").toLowerCase();

            switch (choice) {
                case "y": {
                    itemReceiptList.add(getItemReceiptForImport());
                    break;
                }
            }

        } while (choice.equals("n"));
        return itemReceiptList;
    }
}
