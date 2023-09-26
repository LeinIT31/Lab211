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
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author lyhai
 */
public class DataInput {

    static IProductDao rawProduct = ProductDaoImpl.getInstance();
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

    public static int getIntForUpdate(String message) {
        String var;
        int number = -1;
        System.out.println(message);
        var = sc.nextLine().trim();

        if (!var.isEmpty()) {
            try {
                number = Integer.parseInt(var);
            } catch (Exception e) {
                System.out.println("Invalid number");
            }
        } else {
            System.out.println("Skip input.");
        }
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

    public static Product getProductForImport(String message) throws Exception {
        System.out.println(message);
        String productID = sc.nextLine();

        List<Product> listCheck = rawProduct.getList();

        for (Product product : listCheck) {
            if (product.getCode().equalsIgnoreCase(productID)) {
                return product;
            }
        }
        System.out.println("Product not exist! Let't add new");
        return null;
    }

    public static Product getProductForExport(String message) throws Exception {
        List<Product> listCheck = rawProduct.getList();

        boolean isCheck = true;

        while (isCheck) {
            System.out.println(message);
            String productID = sc.nextLine();
            for (Product product : listCheck) {
                if (product.getCode().equalsIgnoreCase(productID)) {
                    return product;
                }
            }
            System.out.println("Product not exist. Let's enter again");
            isCheck = true;
        }
        return null;
    }
}
