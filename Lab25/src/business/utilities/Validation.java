/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package business.utilities;

import business.entity.Product;
import data.ProductDaoImpl;
import java.util.List;

/**
 *
 * @author lyhai
 */
public class Validation {

    static List<Product> listCheck = ProductDaoImpl.pList;


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
    public boolean codeValid(String code){
        if (formCode(code) && checkCodeExist(code)){
            return true;
        }
            return false;
    }

}
