/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package data;

import java.util.List;

/**
 *
 * @author lyhai
 */
public interface DAO<T> {
    boolean add(T t) throws Exception;
    List<T> getList() throws Exception;
}
