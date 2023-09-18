/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package data;

import business.entity.Product;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.Charset;
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
    
    
    @Override
    public File createNewFile() throws Exception {
        File f = new File("Product.txt");
        try {
            f.createNewFile();
        } catch (IOException e) {

        }
        return f;
    }

    public void writeDataToFile(List<Product> list) throws FileNotFoundException {
        File fTmp = new File("C:\\Users\\lyhai\\OneDrive\\Documents\\NetBeansProjects\\On pE\\Lab211\\Lab25\\src\\Product.txt");
        PrintWriter pw = new PrintWriter(fTmp);
        for (Product e : list) {
            pw.println(e);
        }
        pw.close();
    }

    @Override
    public List<String> readDateFromFile() throws Exception {
        List<String> result;
        Path filePath = Paths.get("C:\\Users\\lyhai\\OneDrive\\Documents\\NetBeansProjects\\On pE\\Lab211\\Lab25\\src\\Product.txt");
        
        result = Files.readAllLines(filePath, StandardCharsets.UTF_16);
        
        return result;
    }

}
