/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package data;

import business.entity.Product;
import business.entity.Receipt;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author lyhai
 */
public class WareHouseDaoImpl implements IWareHouseDao {

    private IManagerFile wManagerFile;
    private IManagerFile itemManagerFile;
    private static final List<Receipt> receiptList = new ArrayList<>();

    public WareHouseDaoImpl() {
        try {
            wManagerFile = new FileManager("wareHouse.txt");
            itemManagerFile = new FileManager("ItemReceipt.txt");
            loadDataFromFile();
        } catch (Exception ignored) {}
    }

    private static IWareHouseDao INSTANCE = null;

    public static IWareHouseDao getInstance() {
        if (INSTANCE == null) {
            synchronized (WareHouseDaoImpl.class) {
                INSTANCE = new WareHouseDaoImpl();
            }
        }
        return INSTANCE;
    }

    @Override
    public boolean add(Receipt t) throws Exception {
        receiptList.add(t);
        return true;
    }

    @Override
    public List<Receipt> getList() {
        return receiptList;
    }

    private void loadDataFromFile() throws Exception {
        if (receiptList.isEmpty()) {
            for (String r : wManagerFile.readDataFromFile()) {
                receiptList.add(convertStringToReceipt(r));
            }
        }
    }

    private Receipt convertStringToReceipt(String rawReceipt) {
        String receiptID, typeReceipt, time, customer, address, seller;
        
        int quantity;

        List<String> raw = Arrays.asList(rawReceipt.split(","));

        receiptID = raw.get(0).trim();
        typeReceipt = raw.get(1).trim();
        
        //Convert product:
        
        String productID, name, manufacturingDate, expirationDate, types;
        productID = raw.get(2).trim();
        
        name = raw.get(3).trim();
        manufacturingDate = raw.get(4).trim();
        expirationDate = raw.get(5).trim();
        types = raw.get(6).trim();
        quantity = Integer.parseInt(raw.get(7).trim());
        Product product = new Product(productID, name, manufacturingDate, expirationDate, types, quantity);
        
        time = raw.get(3).trim();
        customer = raw.get(4).trim();
        address = raw.get(5).trim();
        seller = raw.get(6).trim();

//        return null
//        return new Receipt(receiptID, types, product, quantity, time, customer, address, seller);
    }

    @Override
    public boolean update(String code, Receipt newR) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean delete(String code) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean printList() throws Exception {
        for (Receipt receipt : receiptList) {
            System.out.println(receipt);
        }
        return true;
    }

    @Override
    public void saveFile() throws Exception {
        wManagerFile.writeReceiptToFile(receiptList);
    }
}
