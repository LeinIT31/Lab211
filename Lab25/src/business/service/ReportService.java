/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package business.service;

import data.IProductDao;
import data.IReportDao;
import data.ReportDao;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author lyhai
 */
public class ReportService implements IReportService{
    IReportDao report = new ReportDao();

    @Override
    public void isExpired() {
        try {
            boolean isCheck = report.isExpired();
            if (isCheck){
                System.out.println("Show successfully!");
            } else System.out.println("Show failed!");
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }

    @Override
    public void isSelling() {
        try {
            boolean isCheck = report.isSelling();
            if(isCheck){
                System.out.println("Show successfully!");
            } else System.out.println("Show failed!");
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }

    @Override
    public void isRunningOut() {
        try {
            boolean isCheck = report.isRunningOut();
            if (isCheck){
                System.out.println("Show failed");
            } else System.out.println("Show failed");
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }

    @Override
    public void showProductByCode(String code) {
        try {
            boolean isCheck = report.showProductByCode(code);
            
            if (isCheck) {
                System.out.println("Show successfully!");
            } else System.out.println("Product does not exist!");
        } catch (Exception ex) {
            System.out.println(ex);
        }
        

    }
    
    
}
