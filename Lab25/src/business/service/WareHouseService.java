/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package business.service;

import business.entity.ItemReceipt;
import business.entity.Receipt;
import data.IWareHouseDao;
import data.WareHouseDaoImpl;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


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
            for (Receipt receipt : getList()) {
                System.out.println(receipt);
            }
        } catch (Exception ex) {
        }
    }
    public List<Receipt> getList() throws Exception{
            return rawReceipt.getList();
       
    }
    public List<ItemReceipt> getItemList() throws Exception{
        return rawReceipt.getItemReceipt();
    }
    @Override
    public void addItemReceipt(ItemReceipt i) {
        try {
            rawReceipt.addItemReceipt(i);
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }
}
