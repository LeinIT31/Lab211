/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package business.utilities;

import business.entity.ItemReceipt;
import business.entity.Product;
import data.IProductDao;
import data.IWareHouseDao;
import data.ProductDaoImpl;
import data.WareHouseDaoImpl;
import java.util.List;

/**
 *
 * @author lyhai
 */
public class Validation {
    IProductDao rawProduct = ProductDaoImpl.getInstance();
    IWareHouseDao rawReceipt =  WareHouseDaoImpl.getInstance();

    public boolean formCode(String code) {
        return code.matches("^P\\d{3}");
    }

    public boolean checkCodeExist(String code) throws Exception {
        List<Product> listCheck = rawProduct.getList();
        for (Product p : listCheck) {
            if (p.getCode().equalsIgnoreCase(code)) {
                return false;
            }
        }
        return true;
    }

    public boolean codeValid(String code) throws Exception {
        if (formCode(code) && checkCodeExist(code)) {
            return true;
        }
        return false;
    }

    public boolean formType(String var) {
        if (var.equals("0") || var.equals("1") || var.isEmpty()) {
            return true;
        }
        return false;
    }

    public boolean formDate(String var) {
        return (var.matches("\\d{1,2}-\\d{1,2}-\\d{4}"));
    }

    public boolean productCodeExist(String code) throws Exception {
        return formCode(code) && !checkCodeExist(code);
    }
    public boolean checkProduct(String var) throws Exception{
        List<ItemReceipt> itemReceiptList = rawReceipt.getItemReceipt();
        for (ItemReceipt itemReceipt : itemReceiptList) {
            if (itemReceipt.getCode().equalsIgnoreCase(var)){
                return true;
            }
        }
        return false;
    }
    public boolean inputEmty(String var){
        return var.isEmpty();
    }
}
