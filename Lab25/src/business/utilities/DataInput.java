/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package business.utilities;

import application.ProductMenu;
import business.entity.ItemReceipt;
import business.entity.Product;
import data.IProductDao;
import data.IWareHouseDao;
import data.ProductDaoImpl;
import data.WareHouseDaoImpl;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author lyhai
 */
public class DataInput {

    static IWareHouseDao rawItemList = WareHouseDaoImpl.getInstance();

    static Scanner sc = new Scanner(System.in);
    static Validation vIO = new Validation();

    public static String getStringCode(String message) {

        String var = "";
        boolean check = false;

        while (!check) {
            try {
                System.out.println(message);
                var = sc.nextLine();
                if (vIO.codeValid(var)) {
                    check = true;
                }
            } catch (Exception e) {
                System.out.println("Input invalid!");
            }
        }
        return var;
    }

    public static int getInt(String message) {
        int tmp;

        while (true) {
            try {
                System.out.println(message);
                tmp = Integer.parseInt(sc.nextLine());
                break;
            } catch (NumberFormatException e) {
                System.out.println("Enter again");
            }
        }
        return tmp;
    }
    public static int getIntForUpdate(String message){
        String var;
        int number = -1;
        System.out.println(message);
        var = sc.nextLine().trim();
        
        if (!var.isEmpty()){
            try {
               number = Integer.parseInt(var);
            } catch (Exception e) {
                System.out.println("Invalid number");
            }
        } else System.out.println("Skip input.");
        return number;
    }
    public static String getString(String message) {
        System.out.println(message);
        String var = sc.nextLine();

        return var;
    }
    public static String getTypeProduct(String message) {

        String var = "";
        boolean isCheck = false;
        while (isCheck == false) {
            try {
                System.out.println(message);
                var = sc.nextLine();
                isCheck = vIO.formType(var);
            } catch (Exception e) {
            }

        }
        return var;
    }

    public static String getDate(String message) {
        String date = "";
        boolean isCheck = false;
        while (isCheck == false) {
            try {
                System.out.println(message);
                date = sc.nextLine();
                isCheck = vIO.formDate(date);
            } catch (Exception e) {
            }
        }
        return date;

    }

    public static ItemReceipt getProductForImport(String message) throws Exception {
        System.out.println(message);
        String productID = sc.nextLine();
        List<ItemReceipt> listCheck = rawItemList.getItemReceipt();
        ItemReceipt item = null;
        for (ItemReceipt itemCheck : listCheck) {
            if (itemCheck.getCode().equalsIgnoreCase(productID)) {
                item = itemCheck;
            } else {
                System.out.println("The product not exist. Let's add new product");
                String id, productName;
                int quantity, price;

                id = productID;
                productName = getString("Enter name of product!");
                quantity = getInt("Enter quantity of product!");
                price = getInt("Enter price of product!");
                item = new ItemReceipt(id,null, productName, price, quantity); 
            }
        }
        return null;
    }

    public static ItemReceipt getProductForExport(String message) throws Exception {
        List<ItemReceipt> itemReceiptList = rawItemList.getItemReceipt();

        ItemReceipt itemReceipt = null;

        while (itemReceipt != null) {
            System.out.println(message);
            String productID = sc.nextLine();
            for (ItemReceipt item : itemReceiptList) {
                if (item.getCode().equalsIgnoreCase(productID)) {
                    itemReceipt = item;
                }
            }
        }

        return itemReceipt;
    }
}
