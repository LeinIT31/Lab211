
import business.entity.Product;
import data.FileManager;
import data.ProductDaoImpl;
import data.ReportDao;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author lyhai
 */
public class Test1 {
    public static void main(String[] args) throws Exception {
          ReportDao report = new ReportDao();
          
        report.isExpired();
    }

    
    
            
}
