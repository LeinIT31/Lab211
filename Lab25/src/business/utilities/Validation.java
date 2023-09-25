/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package business.utilities;

import business.entity.Product;
import data.IProductDao;
import data.ProductDaoImpl;
import java.util.List;

/**
 *
 * @author lyhai
 */
public class Validation {
    IProductDao rawProduct = ProductDaoImpl.getInstance();
    List<Product> listCheck = rawProduct.getList();

    public boolean formCode(String code) {
        return code.matches("^P\\d{3}");
    }

    public boolean checkCodeExist(String code) {
        for (Product p : listCheck) {
            if (p.getCode().equalsIgnoreCase(code)) {
                return false;
            }
        }
        return true;
    }

    public boolean codeValid(String code) {
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

    public boolean productCodeExist(String code) {
        return formCode(code) && !checkCodeExist(code);
    }
    public boolean checkProduct(String var){
        for (Product product : listCheck) {
            if (product.getCode().equalsIgnoreCase(var)){
                return true;
            }
        }
        return false;
    }
}
