/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package application;

import business.entity.ItemReceipt;
import business.service.ReportService;
import business.utilities.DataInput;

/**
 *
 * @author lyhai
 */
public class ReportMenu {
    ReportService reportService = new ReportService();
    public void showMenu() throws Exception{
        int choice;
        
        do {            
            System.out.println("//--------------------------------------------//");
            System.out.println("1. Show product have expired!");
            System.out.println("2. Show all product is selling!");
            System.out.println("3. Show all product that are running out of stock!");
            System.out.println("4. Import/Export receipt of a product!");
            System.out.println("Other, exit!");
            System.out.println("//-------------------------------------------//");
            
            choice = DataInput.getInt("Enter your choice!");
            
            switch (choice) {
                case 1:{
                    reportService.isExpired();
                    break;
                }
                case 2:{
                    reportService.isSelling();
                    break;
                }
                case 3:{
                    reportService.isRunningOut();
                    break;
                }
                case 4:{
                    getItemReceipt();
                    break;
                }
            }
        } while (choice >= 1 && choice <= 4);
    }
    public void getItemReceipt(){
        String productCode = DataInput.getString("Enter code of product!");
         reportService.showProductByCode(productCode);
    }
}
