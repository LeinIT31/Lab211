/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package business.utilities;

import java.util.Scanner;

/**
 *
 * @author lyhai
 */
public class DataInput {
    static Scanner sc = new Scanner(System.in);
    public static String getString(String message){
        String tmp;
        
        System.out.println(message);
        tmp = sc.nextLine();
        return tmp;
    }
    public static int getInt(String message){
        int tmp;
        
        while(true){
            try {
                System.out.println(message);
                tmp = Integer.parseInt(sc.nextLine());
                break;
            } catch (Exception e) {
                System.out.println("Enter again");
            }
        }
        return tmp;
    }
}
