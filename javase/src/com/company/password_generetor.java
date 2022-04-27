package com.company;

import java.util.Random;

public class password_generetor {
    public static void main(String[] args) {
        generator();
    }

    static void generator() {
        Random r = new Random();
        StringBuilder password = new StringBuilder();

        String[] spacarc = {
                "?", "!", "@", "#", "$", "%", "^"
        };
        int[] sequence = new int[(int) ((Math.random() * (12 - 8)) + 8)];

        for (int i = 0; i < sequence.length; i++){
            sequence[i] = (int) ((Math.random() * (4 - 1)) + 1);
        }

        for (int k : sequence) {
            if (k == 1) {
                password.append((int) ((Math.random() * (9 - 1)) + 1));
            } else if (k == 2) {
                password.append(spacarc[(int) ((Math.random() * (spacarc.length - 1)) + 1)]);
            } else if (k == 3) {
                password.append((char) (r.nextInt(26) + 'a'));
            }
//            System.out.println(password);
        }
        System.out.println("-------");
        System.out.println(password);

    }
}
