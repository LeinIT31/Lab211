/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package data;

import business.entity.Product;

/**
 *
 * @author lyhai
 */
public interface IProductDao extends DAO<Product> {
    int update(String id) throws Exception;
    int delete(String id) throws Exception;
    void printList() throws Exception;
}
