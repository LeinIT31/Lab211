/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package data;

import business.entity.ItemReceipt;
import business.entity.Receipt;
import java.util.List;

/**
 *
 * @author lyhai
 */
public interface IWareHouseDao extends DAO<Receipt>{
    boolean add(Receipt t) throws Exception;
    boolean update(String code, Receipt newR) throws Exception;
    boolean delete(String code) throws Exception;
    void saveFile() throws Exception;
    List<Receipt> getList() throws Exception;
    List<ItemReceipt> getItemReceipt() throws Exception;
    void addItemReceipt(ItemReceipt i) throws Exception;
}
