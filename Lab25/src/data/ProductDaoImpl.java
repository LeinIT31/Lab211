/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package data;

import business.utilities.DataInput;
import business.entity.Product;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author lyhai
 */
public class ProductDaoImpl implements IProductDao {

    private List<Product> list = new ArrayList<Product>();

    @Override
    public int update(String id) throws Exception {
        for (Product e : list){
            if (e.getCode().equalsIgnoreCase(id)){
                String choice =  DataInput.getString("Product exist! Are you continue update it? Y/N").toLowerCase();
                if (choice.equalsIgnoreCase("y")){
                    
                    String newName, newManufacturingDate, newExpirationDate, newType;
                    
                    newName = DataInput.getString("Enter new name.");
                    if (newName.isEmpty()){
                        newName = e.getName();
                    }
                    
                    newManufacturingDate = DataInput.getString("Enter new manufacturing date.");
                    if (newManufacturingDate.isEmpty()){
                        newManufacturingDate = e.getManufacturingDate();
                    }
                    
                    newExpirationDate = DataInput.getString("Enter new expiration date.");
                    if (newExpirationDate.isEmpty()){
                        newExpirationDate = e.getExpirationDate();
                    }
                    
                    newType = DataInput.getString("Enter new type.");
                    if (newType.isEmpty()){
                        newType = e.getTypes();
                    }
                    
                    e.setName(newName);
                    e.setManufacturingDate(newManufacturingDate);
                    e.setExpirationDate(newExpirationDate);
                    e.setTypes(newType);
                    
                    return 1;
                }
            }
        }
        return 0;
    }

    @Override
    public int delete(String id) throws Exception {
        for(Product e : list){
            if (e.getCode().equalsIgnoreCase(id)){
                String choice = DataInput.getString("Product exist! Are you want to delete it? Y/N").toLowerCase();
                if (choice.equalsIgnoreCase("y")){
                    list.remove(e);
                    return 1;
                }
            }
        }
        return 0;
    }

    @Override
    public int addNew(Product t) throws Exception {

        list.add(t);
        return 1;
    }

    @Override
    public List<Product> getList() throws Exception {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void printList() throws Exception {
        System.out.println(list.toString());

    }
}
