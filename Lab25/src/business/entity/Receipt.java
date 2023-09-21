/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package business.entity;

/**
 *
 * @author lyhai
 */
public class Receipt {

    private String receiptID;
    private String type;
    private Product product;
    private int quantity;
    private String time;
    private String customer;
    private String address;
    private String seller;

    public Receipt() {
    }

    public Receipt(String receiptID, String type, Product product, int quantity, String time, String customer, String address, String seller) {
        this.receiptID = receiptID;
        this.type = type;
        this.product = product;
        this.quantity = quantity;
        this.time = time;
        this.customer = customer;
        this.address = address;
        this.seller = seller;
    }

    public String getReceiptID() {
        return receiptID;
    }

    public void setReceiptID(String receiptID) {
        this.receiptID = receiptID;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getSeller() {
        return seller;
    }

    public void setSeller(String seller) {
        this.seller = seller;
    }

    @Override
    public String toString() {
        return receiptID + "," + type + "," + product + "," + quantity + "," + time + "," + customer + "," + address + "," + seller;
    }

}
