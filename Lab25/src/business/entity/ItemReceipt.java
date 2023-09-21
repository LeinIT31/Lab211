package business.entity;

public class ItemReceipt {

    private String code;
    private String receiptId;
    private String productName;
    private int price;
    private int quantity;

    public ItemReceipt(
            String code,
            String receiptId,
            String productName,
            int price,
            int quantity
    ) {
        this.code = code;
        this.receiptId = receiptId;
        this.productName = productName;
        this.price = price;
        this.quantity = quantity;
    }

    public String getCode() {
        return code;
    }

    public String getProductName() {
        return productName;
    }

    public int getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public int getTotalAmount() {
        return price * quantity;
    }

}
