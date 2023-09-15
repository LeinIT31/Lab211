/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package business.entity;

/**
 *
 * @author lyhai
 */
public class Product {
    private String code;
    private String name;
    private String manufacturingDate;
    private String expirationDate;
    private String types;

    public Product(String code, String name, String manufacturingDate, String expirationDate, String types) {
        this.code = code;
        this.name = name;
        this.manufacturingDate = manufacturingDate;
        this.expirationDate = expirationDate;
        this.types = types;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getManufacturingDate() {
        return manufacturingDate;
    }

    public void setManufacturingDate(String manufacturingDate) {
        this.manufacturingDate = manufacturingDate;
    }

    public String getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(String expirationDate) {
        this.expirationDate = expirationDate;
    }

    public String getTypes() {
        return types;
    }

    public void setTypes(String types) {
        this.types = types;
    }

    @Override
    public String toString() {
        return "Product{" + "code=" + code + ", name=" + name + ", manufacturingDate=" + manufacturingDate + ", expirationDate=" + expirationDate + ", types=" + types + '}';
    }
    
    
}
