package ders23;

import java.util.ArrayList;

public class main {
    public static void main(String[] args) {

        try {
            int a = 40, b = 0;
            int c = a / b;
            System.out.println("Result = " + c);
        } catch (
                ArithmeticException e) {
            System.out.println("Can't divide a number by 0");
        }


        //NullPointerException
        try {
            String a = null; //null value
            System.out.println(a.charAt(0));
        } catch (NullPointerException e) {
            System.out.println("NullPointerException..");
        }

        //StringIndexOutOfBoundsException
        try {
            String a = "This is like chipping ";
            char c = a.charAt(24);
            System.out.println(c);
        } catch (StringIndexOutOfBoundsException e) {
            System.out.println("StringIndexOutOfBoundsException");
        }

        //ArrayIndexOutOfBoundsException
        try {
            int a[] = new int[5];
            a[6] = 9; // accessing 7th element in an array of
            // size 5
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Array Index is Out Of Bounds");
        }


        //IndexOutOfBoundsException
        try {
            ArrayList<String> a = new ArrayList<>();
            a.add("skljdvn");
            a.add("skljdvn");
            a.add("skljdvn");
            a.add("skljdvn");
            a.add("skljdvn");

            a.get(10);

        } catch (IndexOutOfBoundsException e) {
            System.out.println(e);
        }
    }
}
