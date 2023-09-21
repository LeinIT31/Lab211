/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package business.service;

import business.entity.Receipt;
import data.IWareHouseDao;
import data.WareHouseDaoImpl;
import java.util.List;


/**
 *
 * @author lyhai
 */
public class WareHouseService implements IWareHouseService {

    IWareHouseDao rawReceipt = WareHouseDaoImpl.getInstance();

    public void addProductToReceipt(Receipt r)  {
        try {
            boolean isCheck = rawReceipt.add(r);
            if (isCheck){
                System.out.println("Add successfully!");
            } else System.out.println("Add failed");
        } catch (Exception ex) {
            
        }
    }
    public void saveFile(){
        try {
            rawReceipt.saveFile();
        } catch (Exception ex) {
        }
    }
    @Override
    public void deleteProductToReceipt(String receiptID) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void updateProductToReceipt(String receiptID) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void printList() {
        try {
            rawReceipt.printList();
        } catch (Exception ex) {
        }
    }
    public List<Receipt> listCheck() throws Exception{
            return rawReceipt.getList();
       
    }
 

}
