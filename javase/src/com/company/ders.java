package com.company;

import jdk.swing.interop.SwingInterOpUtils;

public class ders {
    public static void main(String[] args) {

        int count = 0;

        for (int i = 0; i< 200; i++){
            count = 0;
            for (int j = 1; j <= 9; j++){
                if (i % j != 0 && i != j){
                    count++;
                }
            }
            if (count == 8){
                System.out.println(i);
            }
        }
    }
}
