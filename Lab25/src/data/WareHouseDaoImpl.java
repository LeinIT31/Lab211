/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package data;

import business.entity.ItemReceipt;
import business.entity.Product;
import business.entity.Receipt;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author lyhai
 */
public class WareHouseDaoImpl implements IWareHouseDao {

    private IManagerFile wManagerFile;
    private IManagerFile itemManagerFile;
    private final List<Receipt> receiptList = new ArrayList<>();
    private final HashMap<String, List<ItemReceipt>> itemReceiptMap = new HashMap<>();

    public WareHouseDaoImpl() {
        try {
            wManagerFile = new FileManager("wareHouse.txt");
            itemManagerFile = new FileManager("ItemReceipt.txt");
            loadItemReceiptFromFile();
            loadDataFromFile();
        } catch (Exception ignored) {
        }
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
        for (String r : wManagerFile.readDataFromFile()) {
            receiptList.add(convertStringToReceipt(r));
        }
    }

    private Receipt convertStringToReceipt(String rawReceipt) {
        String receiptID, type, customer, customerAddress, seller, sellerAddress;
        long time;
        List<String> raw = Arrays.asList(rawReceipt.split(","));

        receiptID = raw.get(0).trim();
        type = raw.get(1).trim();
        time = Integer.parseInt(raw.get(2).trim());
        customer = raw.get(3).trim();
        customerAddress = raw.get(4).trim();
        seller = raw.get(5).trim();
        sellerAddress = raw.get(6).trim();
        
        List<ItemReceipt> itemList = itemReceiptMap.get(receiptID);
        return new Receipt(receiptID, type, time, customer, customerAddress, seller, sellerAddress, itemList);
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

    private void loadItemReceiptFromFile() throws Exception {
        for (String r : itemManagerFile.readDataFromFile()) {
            ItemReceipt item = converStringToItemReceipt(r);
            List<ItemReceipt> list = itemReceiptMap.get(item.getReceiptId());
            if (list == null) {
                list = new ArrayList<>();
                itemReceiptMap.put(item.getReceiptId(), list);
            }
            list.add(item);
        }
    }

    private ItemReceipt converStringToItemReceipt(String rawItemReceipt) {
        String code, receiptID, productName;
        int price, quantity;

        List<String> raw = Arrays.asList(rawItemReceipt.split(","));

        code = raw.get(0).trim();
        receiptID = raw.get(1).trim();
        productName = raw.get(2).trim();
        price = Integer.parseInt(raw.get(3).trim());
        quantity = Integer.parseInt(raw.get(4).trim());

        return new ItemReceipt(code, receiptID, productName, 0, 0);
    }

}
