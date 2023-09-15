/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package data;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;

/**
 *
 * @author lyhai
 */
public class FileManager implements IFile{

    @Override
    public File createNewFile() throws Exception {
        File f = new File("Product.txt");
        try {
            f.createNewFile();
        } catch (IOException e) {
            
        }
        return f;
    }
    public void writeDataToFile() throws FileNotFoundException{
        File fTmp = new File("C:\\Users\\lyhai\\OneDrive\\Documents\\NetBeansProjects\\On pE\\Lab25Demo\\src\\lab25demo\\Product.txt");
        if (!fTmp.exists()){
            try {
                fTmp.createNewFile();
            } catch (IOException ex) {
            }
        }
        PrintWriter pw = new PrintWriter(fTmp);
 
    }
    
}
