/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package business.utilities;

import application.ProductMenu;
import business.entity.Product;
import data.IProductDao;
import data.ProductDaoImpl;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author lyhai
 */
public class DataInput {

    static IProductDao rawProduct = ProductDaoImpl.getInstance();

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

    public static Product getProductForImport(String message) {
        String productID = sc.nextLine();
        List<Product> listCheck = rawProduct.getList();

        boolean isCheck = vIO.checkProduct(productID);
        if (isCheck == false) {
            System.out.println("The product not exist. Let's add new product");
            ProductMenu pm = new ProductMenu();
            return pm.getNewProduct();
        }
        for (Product product : listCheck) {
            if (product.getCode().equalsIgnoreCase(productID)) {
                return product;
            }
        }
        return null;

    }

    public static Product getProductForExport(String message) {
        List<Product> listCheck = rawProduct.getList();
        
        Product p = null;
        
        while(p != null) {
            System.out.println(message);
            String productID = sc.nextLine();
            for (Product product : listCheck){
                if(product.getCode().equalsIgnoreCase(productID)){
                    p = product;
                }
            }
        }
        
        return p;
    }
}
