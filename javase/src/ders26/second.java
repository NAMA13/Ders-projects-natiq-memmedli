package ders26;

import java.util.Scanner;

public class second {
    public static void main(String[] args) {
        double bir = 2344.5;
        int iki = (int) bir;

        System.out.println(bir);
        System.out.println(iki);

        System.out.println("Dairenin Sahesini tapmaq ucun Radius girin: ");
        Scanner scn = new Scanner(System.in);
        int radius = scn.nextInt();
        double result = 2 * (Math.PI * radius);
        System.out.println(result);

        System.out.println("Dairenin Sahesini tapmaq ucun Radius girin: ");
        int eded = scn.nextInt();
        for (int i = 0; i < 100; i++) {
            if (i % eded == 0) {
                System.out.println(i);
            }
        }

    }
}
