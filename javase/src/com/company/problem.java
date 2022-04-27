package com.company;

import java.util.Scanner;

public class problem {
    public static void main(String[] args) {
//        Scanner scn = new Scanner(System.in);
//        System.out.print("Please enter Starter Number :");
//        long number = scn.nextLong();
        long number = 999999999;

        while (number > 1){
            number--;
            solver(number);
        }
    }

    static void solver(long number) {
        while (true) {
            if (number == 1) {
                System.out.println("Dongu bitdi reqem 1 - dir.");
                System.out.println("--------------------------");
                break;
            } else {
                if (number % 2 == 0) {
                    number = number / 2;
                    System.out.println("Number is now : " + number);
                } else if (number % 2 != 0) {
                    number = number * 3;
                    number = number + 1;
                    System.out.println("Number is now : " + number);
                }
            }
        }
    }
}
