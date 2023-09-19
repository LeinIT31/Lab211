/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package data;

import business.entity.Product;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

/**
 *
 * @author lyhai
 */
public class FileManager implements IFile {
    
 

    public void writeDataToFile(List<Product> list) throws FileNotFoundException {
        File fTmp = new File("C:\\Users\\lyhai\\OneDrive\\Documents\\NetBeansProjects\\On pE\\Lab211\\Lab25\\src\\data\\Product.txt");
        PrintWriter pw = new PrintWriter(fTmp);
        for (Product e : list) {
            pw.println(e);
        }
        pw.close();
    }

    @Override
    public List<String> readDataFromFile() throws Exception {
        List<String> result;
        Path filePath = Paths.get("C:\\Users\\lyhai\\OneDrive\\Documents\\NetBeansProjects\\On pE\\Lab211\\Lab25\\src\\data\\Product.txt");
        
        result = Files.readAllLines(filePath, StandardCharsets.UTF_8);
        return result;
    }

}
