package com.company;

import java.util.Scanner;

public class Tap1 {
    public static void main(String[] args) {
        int dec_num, quot, i = 1, j;
        int[] oct_num = new int[100];
        Scanner scn = new Scanner(System.in);

        System.out.print("Enter a Decimal Number: ");
        dec_num = scn.nextInt();

        quot = dec_num;

        while (quot != 0) {
            oct_num[i++] = quot % 8;
            quot = quot / 8;
        }

        System.out.print("Octal number is: ");
        for (j = i - 1; j > 0; j--) {
            System.out.print(oct_num[j]);
        }
        System.out.print("\n");
    }
}