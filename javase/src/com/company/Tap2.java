package com.company;

import java.util.Scanner;

public class Tap2 {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        long bnum, decnum = 0, j = 1, re;
        System.out.print("Enter a binary number: ");
        bnum = scn.nextLong();

        while (bnum != 0) {
            re = bnum % 10;
            decnum = decnum + re * j;
            bnum = bnum / 10;
            j = j * 2;
        }
        System.out.println("Decimal Number: " + decnum);
    }
}