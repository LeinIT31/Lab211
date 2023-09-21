/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package application;

/**
 *
 * @author lyhai
 */
public class Menu implements IMenu {

    @Override
    public void manageProduct() throws Exception {
        ProductMenu productMenu = new ProductMenu();
        productMenu.showMenu();
    }

    @Override
    public void managerWareHouse() throws Exception {
        WareHouseMenu wareHouseMenu = new WareHouseMenu();
        wareHouseMenu.showMenu();
    }

    @Override
    public void report() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
