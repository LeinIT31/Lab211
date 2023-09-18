/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package business.service;

import business.entity.Product;
import java.util.List;

/**
 *
 * @author lyhai
 */
public interface IProductService {
    void addNew(Product p) throws Exception;
    void delete(String code) throws Exception;
    void update(String code, Product p) throws Exception;
    void printList() throws Exception;
    List<Product> getList() throws Exception;
}
