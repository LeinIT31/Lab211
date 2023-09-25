/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package business.service;

import business.entity.Receipt;

/**
 *
 * @author lyhai
 */
public interface IWareHouseService {
    void addProductToReceipt(Receipt r);
    void deleteProductToReceipt(String receiptID);
    void updateProductToReceipt(String receiptID);
    void printList();
    
}
