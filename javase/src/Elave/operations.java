package Elave;

import java.util.ArrayList;

public class operations {
    private static ArrayList a = new ArrayList();
    private static char o = 'a';
    private static int i = 0;
    private static ArrayList numbers = new ArrayList();

    public int calculate(String problem) {
        split(problem);
        System.out.println(numbers.toString());

        return -1;
    }


    private static ArrayList split(String problem) {

        while (i < problem.length()) {
            o = problem.charAt(i);
            if (o == '/' || o == '*' || o == '+' || o == '-' || o == ')' || o == '(') {
                a.add(o);
            }
            if (isNumeric(String.valueOf(o))) {
                numbers.add(o);
                getFullNumber(problem, i);

            }
            i++;
        }
        return a;
    }

    private static void getFullNumber(String problem, int i2) {
        String number = String.valueOf(o);
        int j = i2 + 1;
        while (j <= problem.length()) {
            char d = problem.charAt(j);
            if (j < problem.length() - 1) {
                if (d == '/' || d == '*' || d == '+' || d == '-' || d == ')' || d == '(') {
                    a.add(number);
                    i = j;
                    a.add(d);
                    break;
                } else if (isNumeric(String.valueOf(d))) {
                    if (j < problem.length()) {
                        number += String.valueOf(d);
                    } else {
                        number += String.valueOf(d);
                        a.add(number);
                        i = j;
                        break;
                    }
                }
            } else {
                if (isNumeric(String.valueOf(problem.charAt(j)))) {
                    number += String.valueOf(problem.charAt(j));
                    a.add(number);
                    i = j;
                }else {
                    a.add(number);
                    a.add(d);
                    i = j;
                    break;
                }

                break;
            }
            j++;
        }
    }

    //    ---------------------------------------------------------------------------------------------------------
    private void breakedInter() {
        ArrayList clone = numbers;
        for (int i = 0; i < numbers.size(); i++) {
            String selected = (String) numbers.get(i);
            if (selected == "(") {

            }
        }
    }
    private int breakCalculate (int index) {

        return 0;
    }

    private static boolean isOperator(char o) {
        if (o == '/' || o == '*' || o == '+' || o == '-' || o == ')' || o == '(') {
            return true;
        } else {
            return false;
        }
    }

    private static boolean isNumeric(String strNum) {
        if (strNum == null) {
            return false;
        }
        try {
            double d = Double.parseDouble(strNum);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }
}
