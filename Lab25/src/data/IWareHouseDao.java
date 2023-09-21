/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package data;

import business.entity.Receipt;

/**
 *
 * @author lyhai
 */
public interface IWareHouseDao extends DAO<Receipt>{
    boolean add(Receipt r) throws Exception;
    boolean update(String code, Receipt newR) throws Exception;
    boolean delete(String code) throws Exception;
    boolean printList() throws Exception;


    void saveFile() throws Exception;
}
