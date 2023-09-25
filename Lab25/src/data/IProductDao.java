/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package data;

import business.entity.Product;

import java.util.List;

/**
 *
 * @author lyhai
 */
public interface IProductDao extends DAO<Product> {
    boolean add(Product p) throws Exception;
    boolean update(String code, Product newP) throws Exception;
    boolean delete(String code) throws Exception;
    List<Product> getList() throws Exception;
    void saveFile() throws Exception;
}
