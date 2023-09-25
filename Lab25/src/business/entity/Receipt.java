/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package business.entity;

import java.util.List;

/**
 *
 * @author lyhai
 */
public class Receipt {

    private String receiptID;
    private String type;
    private long time;
    private String customer;
    private String customAddress;
    private String seller;
    private String sellerAddress;
    private List<ItemReceipt> itemList;


    public Receipt(
            String receiptID,
            String type,
            long time,
            String customer,
            String customAddress,
            String seller,
            String sellerAddress,
            List<ItemReceipt> itemList
    ) {
        this.receiptID = receiptID;
        this.type = type;
        this.time = time;
        this.customer = customer;
        this.customAddress = customAddress;
        this.seller = seller;
        this.sellerAddress = sellerAddress;
        this.itemList = itemList;
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

    public String getCustomer() {
        return customer;
    }

    public String getCustomAddress() {
        return customAddress;
    }

    public String getSeller() {
        return seller;
    }

    @Override
    public String toString() {
        return receiptID + "," + type + "," + time + "," + customer + "," + customAddress + "," + seller + "," + sellerAddress + "," + itemList;
    }

}
