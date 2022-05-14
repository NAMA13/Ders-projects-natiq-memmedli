package com.company;

import java.util.Calendar;
import java.util.Objects;

public class evisi {
    public static void main(String[] args) {
        String str = "Salam";
        System.out.println("Original String = " + str);
        int index1 = str.charAt(0);
        int index2 = str.charAt(10);

        System.out.println("The character at position 0 is " +
                (char) index1);
        System.out.println("The character at position 10 is " +
                (char) index2);

        System.out.println("--------------");


        String str2 = "w3resource.com";
        System.out.println("Original String : " + str2);

        int val1 = str2.codePointAt(1);

        int val2 = str2.codePointAt(9);

        System.out.println("Character(unicode point) = " + val2);
        System.out.println("--------------");

        String str3 = "w3rsource.com";
        System.out.println("Original String : " + str3);

        int ctr = str3.codePointCount(1, 10);

        System.out.println("Codepoint count = " + ctr);

        System.out.println("--------------");

        String str1 = "This is Exercise 1";
        str2 = "This is Exercise 2";

        System.out.println("String 1: " + str1);
        System.out.println("String 2: " + str2);

        int result = str1.compareTo(str2);


        if (result < 0) {
            System.out.println("\"" + str1 + "\"" +
                    " is less than " +
                    "\"" + str2 + "\"");
        } else if (result == 0) {
            System.out.println("\"" + str1 + "\"" +
                    " is equal to " +
                    "\"" + str2 + "\"");
        } else {
            System.out.println("\"" + str1 + "\"" +
                    " is greater than " +
                    "\"" + str2 + "\"");
        }
        System.out.println("--------------");

        String str20 = "This is exercise 1";
        String str21 = "This is Exercise 1";

        System.out.println("String 1: " + str20);
        System.out.println("String 2: " + str2);

        int result2 = str1.compareToIgnoreCase(str21);

        if (result2 < 0) {
            System.out.println("\"" + str20 + "\"" +
                    " is less than " +
                    "\"" + str21 + "\"");
        } else if (result2 == 0) {
            System.out.println("\"" + str20 + "\"" +
                    " is equal to " +
                    "\"" + str21 + "\"");
        } else {
            System.out.println("\"" + str20 + "\"" +
                    " is greater than " +
                    "\"" + str21 + "\"");
        }
        System.out.println("--------------");
        String str6 = "PHP Exercises and ";
        String str5 = "Python Exercises";

        System.out.println("String 1: " + str6);
        System.out.println("String 2: " + str5);

        String str4 = str6.concat(str2);

        System.out.println("The concatenated string: " + str4);

        System.out.println("--------------");

        String str7 = "PHP Exercises and Python Exercises";
        String str8 = "and";
        System.out.println("Original String: " + str7);
        System.out.println("Specified sequence of char values: " + str8);
        System.out.println(str7.contains(str8));

        System.out.println("--------------");

        String str9 = "example.com", str10 = "Example.com";
        CharSequence cs = "example.com";
        System.out.println("Comparing " + str9 + " and " + cs + ": " + str9.contentEquals(cs));
        System.out.println("Comparing " + str10 + " and " + cs + ": " + str10.contentEquals(cs));

        System.out.println("--------------");


        String str11 = "example.com", str12 = "Example.com";
        StringBuffer strbuf = new StringBuffer(str1);

        System.out.println("Comparing " + str1 + " and " + strbuf + ": " + str1.contentEquals(strbuf));

        System.out.println("Comparing " + str2 + " and " + strbuf + ": " + str2.contentEquals(strbuf));

        System.out.println("--------------");

        String str16 = "Python Exercises";
        String str17 = "Python Exercise";


        String end_str = "se";

        boolean ends1 = str16.endsWith(end_str);
        boolean ends2 = str17.endsWith(end_str);

        System.out.println("\"" + str16 + "\" ends with " +
                "\"" + end_str + "\"? " + ends1);
        System.out.println("\"" + str17 + "\" ends with " +
                "\"" + end_str + "\"? " + ends2);

        System.out.println("--------------");

        String columnist1 = "Stephen Edwin King";
        String columnist2 = "Walter Winchell";
        String columnist3 = "Mike Royko";

        boolean equals1 = columnist1.equals(columnist2);
        boolean equals2 = columnist1.equals(columnist3);

        System.out.println("\"" + columnist1 + "\" equals \"" +
                columnist2 + "\"? " + equals1);
        System.out.println("\"" + columnist1 + "\" equals \"" +
                columnist3 + "\"? " + equals2);

        System.out.println("--------------");

        Calendar c = Calendar.getInstance();
        System.out.println("Current Date and Time :");
        System.out.format("%tB %te, %tY%n", c, c, c);
        System.out.format("%tl:%tM %tp%n", c, c, c);

        System.out.println("--------------");
        String str15 = "This is a sample string.";

        char[] arr = new char[]{' ', ' ', ' ', ' ',
                ' ', ' ', ' ', ' '};
        str15.getChars(4, 10, arr, 2);

        System.out.println("The char array equals \"" +
                arr + "\"");

        System.out.println("--------------");

        str1 = "Java Exercises";
        str2 = "Java";
        str3 = "Jara";
        System.out.println("str1 == str2? " + (Objects.equals(str1, str2)));
        System.out.println("str1 == str3? " + (Objects.equals(str1, str3)));
    }


}
