package Collartz;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        printFile("Please enter Starter Number :");

        long number = scn.nextLong();
        printFile(String.valueOf(number));
//        long number = 999999999;

        while (number > 1) {
            number--;
            solver(number);
        }
    }

    static void solver(long number) {
        while (true) {
            if (number == 1) {
                printFile("Dongu bitdi reqem 1 - dir.");
                printFile("--------------------------");
                break;
            } else {
                if (number % 2 == 0) {
                    number = number / 2;
                    printFile("Number is now : " + number);
                } else if (number % 2 != 0) {
                    number = number * 3;
                    number = number + 1;
                    printFile("Number is now : " + number);
                }
            }
        }
    }

    public static void printFile(String a) {
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