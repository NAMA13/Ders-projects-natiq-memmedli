package com.company;

import java.util.Scanner;

public class Call {
    public static void main(String[] args) {
        int agac = 22;
        double versu = 1;
        while(agac < 30){
            double rol = 2 * versu;
            agac+= rol;
            versu = versu * 1.5;
            System.out.println("Versu; " + versu);
            System.out.println("Agac; " + agac);
        }
    }
}
