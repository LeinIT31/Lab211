/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package application;

import business.utilities.DataInput;
import business.service.ProductService;
import data.FileManager;
import data.ProductDaoImpl;

/**
 *
 * @author lyhai
 */
public class ProductMenu {

    public static void showMenu() throws Exception {
        ProductService productService = new ProductService();
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
                    productService.add();
                    break;
                }
                case 2: {
                    productService.delete();
                    break;
                }
                case 3: {
                    productService.update();
                }
                case 4: {
                    productService.printList();
                    break;
                }
                case 5: {
                   fm.writeDataToFile();
                    break;
                }
            }

        } while (choice >= 1 && choice <= 5);
    }

}
