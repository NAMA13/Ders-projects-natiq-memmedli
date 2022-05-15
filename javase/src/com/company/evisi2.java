package com.company;

import java.sql.SQLOutput;
import java.util.Scanner;

public class evisi2 {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        System.out.print("Enter your Text: ");
        String text = scn.nextLine();
        System.out.println(text + " : " + text.length());

        System.out.println("--------");
//      ------------
        System.out.print("Enter your Text: ");
        text = scn.nextLine();
        System.out.print("Enter What will you replace in text (****, ****): ");
        String text2 = scn.nextLine();

        System.out.println("Orginal text: " + text);
        String[] arrText =  text2.split(",");

        System.out.println("Edited text: " + text.replace(arrText[0].toString(), arrText[1].toString()));
        System.out.println("--------");
//      ------------
        System.out.println("To check whether a given string starts with the contents of another string.");
        String str1 = "Salam Necesen";
        String str2 = "Aleykum Salam Yaxsi Saqol Sen Necesen";

        System.out.println(str1);
        System.out.println(str2);

        System.out.print("Enter your Estimated word: ");
        String startStr = scn.nextLine();

        boolean starts1 = str1.startsWith(startStr);
        boolean starts2 = str2.startsWith(startStr);

        System.out.println("First is: " + (starts1));
        System.out.println("Second is: " + (starts2));
        System.out.println("--------");
        System.out.println("To get a substring of a given string between two specified positions.");

        System.out.print("Enter specified Text...");
        String str = scn.nextLine();

        System.out.print("Enter Positions will you substring in the text (****, ****): ");
        text2 = scn.nextLine();

        arrText =  text2.split(",");

        System.out.println("Old = " + str);
        System.out.println("New = " + str.substring(Integer.parseInt(arrText[0]), Integer.parseInt(arrText[1])));
//      ---------
        System.out.println("--------");
        str = scn.nextLine();

        char[] arr = str.toCharArray();

        System.out.println(arr);
//      ---------
        System.out.println("--------");
        System.out.println("Enter text to trim spaces");
        str = scn.nextLine();

        String new_str = str.trim();

        System.out.println("Original String: " + str);
        System.out.println("New String: " + new_str);
    }
}
