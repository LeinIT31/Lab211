/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package data;

import business.entity.ItemReceipt;
import business.entity.Product;
import java.awt.event.ItemEvent;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

/**
 *
 * @author lyhai
 */
public class ReportDao implements IReportDao {

    IProductDao productDao = ProductDaoImpl.getInstance();
    IWareHouseDao warehouseDao = WareHouseDaoImpl.getInstance();
    
    public ReportDao() {
    }

    public List<Product> getList() throws Exception {
        return productDao.getList();
    }

    public boolean isExpired() throws Exception {
        boolean isCheck = false;
        for (Product product : getList()) {
            if (dateFormatResult(product.getManufacturingDate()).after(dateFormatResult(product.getExpirationDate()))) {
                System.out.println(product);
                isCheck = true;
            }
        }
        return isCheck;
    }
    //Format date
    private SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");

    public Date dateFormatResult(String raw) {
        Date tmp = null;
        try {
            tmp = dateFormat.parse(raw);
        } catch (ParseException ex) {
        }
        return tmp;
    }

    public boolean isSelling() throws Exception {
        boolean isCheck = false;
        for (Product product : getList()) {
            if (product.getQuantity() > 0
                    && (dateFormatResult(product.getManufacturingDate()).before(dateFormatResult(product.getExpirationDate())))) {

                System.out.println(product);
                isCheck = true;
            }
        }
        return isCheck;
    }

    public boolean isRunningOut() throws Exception {
        List<Product> list = productDao.getList();
        boolean isCheck = false;
        list.sort(
                new Comparator<Product>() {
            @Override
            public int compare(Product o1, Product o2) {
                return o1.getQuantity() - o2.getQuantity();
            }
        }
        );
        for (Product product : list) {
            if (product.getQuantity() <= 3) {
                System.out.println(product);
                isCheck = true;
            }
        }
        return isCheck;
    }
    public boolean showProductByCode(String code) throws Exception{
        List<ItemReceipt> list = warehouseDao.getItemReceipt();
        
        for (ItemReceipt item : list){
            if (item.getCode().equalsIgnoreCase(code)){
                System.out.println(item);
            }
        }
        return true;
    }

}
