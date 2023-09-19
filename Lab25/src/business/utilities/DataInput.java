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
    static Validation vIO = new Validation();

    public static String getStringCode(String message) {

        String var = "";
        boolean check = false;

        while (!check) {
            try {
                System.out.println(message);
                var = sc.nextLine();
                if (vIO.codeValid(var)) {
                    check = true;
                }
            } catch (Exception e) {
                System.out.println("Input invalid!");
            }
        }
        return var;
    }

    public static int getInt(String message) {
        int tmp;

        while (true) {
            try {
                System.out.println(message);
                tmp = Integer.parseInt(sc.nextLine());
                break;
            } catch (NumberFormatException e) {
                System.out.println("Enter again");
            }
        }
        return tmp;
    }

    public static String getString(String message) {
        System.out.println(message);
        String var = sc.nextLine();

        return var;
    }

    public static String getTypeProduct(String message) {

        String var = "";
        boolean isCheck = false;
        while (isCheck == false) {
            try {
                System.out.println(message);
                var = sc.nextLine();
                isCheck = vIO.formType(var);
            } catch (Exception e) {
            }

        }
        return var;
    }

    public static String getDate(String message) {
        String date = "";
        boolean isCheck = false;
        while (isCheck == false) {
            try {
                System.out.println(message);
                date = sc.nextLine();
                isCheck = vIO.formDate(date);
            } catch (Exception e) {
            }
        }
        return date;

    }
}
