package ders22;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class password_generetor {
    public static void main(String[] args) {
        String pass = generator();
        printFile(pass);
        printFile(String.valueOf(checker(pass)));

    }

    public static String generator() {
        Scanner scn = new Scanner(System.in);

        System.out.print("Please Enter password legth: ");
        int pass_leg = scn.nextInt();

        Random r = new Random();
        StringBuilder password = new StringBuilder();

        String[] spacarc = {"?", "!", "@", "#", "$", "%", "*", "(", ")", "|"};
        int[] sequence = new int[pass_leg];

        for (int i = 0; i < sequence.length; i++) {
            sequence[i] = (int) ((Math.random() * (3 - 1)) + 1);
        }

        for (int k : sequence) {
            if (k == 1) {
                password.append((int) ((Math.random() * (9 - 1)) + 1));
            } else if (k == 2) {
                password.append(spacarc[(int) ((Math.random() * (spacarc.length - 1)) + 1)]);
            } else if (k == 3) {
                int tf = (int) (Math.random() * (4 - 1) + 1);
                if (tf == 2) {
                    password.append(((char) (r.nextInt(26) + 'A')));
                } else if (tf == 3) {
                    password.append(((char) (r.nextInt(26) + 'a')));
                }
            }
        }
        printFile(String.valueOf(password));
        printFile("Points: " + checker(String.valueOf(password)));
        return String.valueOf(password);

    }

    public static boolean isNum(String strNum) {
        try {
            double d = Double.parseDouble(strNum);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }

    public static boolean isleter(String c) {
        char r = c.charAt(0);
        return (r >= 'a' && r <= 'z') || (r >= 'A' && r <= 'Z');
    }

    public static int checker(String password) {
        String[] spacarc = {"?", "!", "@", "#", "$", "%", "*", "(", ")", "|"};
        int points = 0;
        if (password.length() >= 8) {
            for (int i = 0; i < password.length(); i++) {
                String letter = String.valueOf(password.charAt(i));
                if (Arrays.asList(spacarc).contains(letter)) {
                    points += 5;
                } else if (isNum(letter)) {
                    points += 3;
                } else if (isleter(letter)) {
                    points += 6;
                }
            }
        } else {
            points = -1;
            printFile("This password isn't STRONG!: " + password + "Please change it ?!");
        }
        return points;
    }

    public static int indexOf(int pass, int[] arr) {
        int index = -1;
        for (int i = 0; i < arr.length; i++) {
            if (pass == arr[i]) {
                index = i;
            }
        }
        return index;
    }

    static String checkerArray(String[] password) {
        int[] points = new int[password.length];
        String BestPassword = "";
        for (int i = 0; i < password.length; i++) {
            points[i] = checker(password[i]);
        }
        int max = 0;
        for (int i = 0; i < password.length; i++) {
            if (points[i] > max) {
                max = points[i];
                BestPassword = password[indexOf(max, points)];
            }
        }
        System.out.println(max);
        return "Best Password is: " + BestPassword;
    }
    static void printFile(String a){
        try {
            File file = new File("C:\\Users\\KH/Desktop/console.txt");
            if (file.exists()) {
                FileWriter fw = new FileWriter(file, true);
                BufferedWriter bw = new BufferedWriter(fw);
                bw.write(a);
                bw.newLine();
                bw.write("----------------------------------------------");
                bw.newLine();
                bw.close();
            } else {
                LocalDate date = LocalDate.now();
                FileWriter flr = new FileWriter("C:\\Users\\KH/Desktop/console.txt");
                flr.write(a + "\n");
                printFile("----------------------------------------------");
                printFile(date.toString());
                printFile("----------------------------------------------");
                flr.close();
            }
        } catch (Error error) {
            System.out.println("An error. \n" + error);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}