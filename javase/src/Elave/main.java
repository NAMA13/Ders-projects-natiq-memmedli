package Elave;

import jdk.dynalink.Operation;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        operations a = new operations();
        Scanner scn = new Scanner(System.in);

        printFile("Please enter Math problem: ");
        String problem = scn.nextLine();
        printFile("Problem: " + problem);
        printFile(String.valueOf(a.calculate(problem)));
    }


    public static void printFile(String a){
        System.out.println(a);
        try {
            File file = new File("C:\\Users\\KH/Desktop/console.txt");
            FileWriter fw = new FileWriter(file, true);
            BufferedWriter bw = new BufferedWriter(fw);
            if (file.exists()) {
                bw.write(a);
                bw.newLine();
                bw.close();
            }
        } catch (Error error) {
            System.out.println("An error. \n" + error);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
