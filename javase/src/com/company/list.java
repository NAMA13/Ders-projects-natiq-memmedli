package com.company;

import java.util.Arrays;
import java.util.Random;

public class list<T> {
    Object[] array = new Object[10];
    private int index = 0;


    public void add(T value) {
        if (index == array.length) {
            Object[] a = new Object[array.length + 10];
            for (int i = 0; i < array.length; i++) {
                a[i] = array[i];
            }
            array = a;
        }
        array[index] = value;
        index++;
    }

    public int length() {
        return index;
    }

    public boolean contains(T value) {
        for (int i = 0; i < index; i++) {
            if (array[i] == value) {
                return true;
            }
        }
        return false;
    }

    public void Tremove(int target) {
        if (target <= index) {
            for (int i = target - 1; i < index - 1; i++) {
                array[i] = array[i + 1];
            }
            index--;
        } else {
            System.err.println("Error: " + "Past the length of the array!");
        }
    }

    public void replace(int target, T value) {
        if (target <= index) {
            array[target - 1] = value;
        } else {
            System.err.println("Error: " + "Past the length of the array!");
        }
    }

    public void shuffle() {
        Random r = new Random();
        for (int i = index - 1; i > 0; i--) {
            int j = r.nextInt(i);
            Object rol = array[i];
            array[i] = array[j];
            array[j] = rol;
        }
    }


    public String toSTR() {
        String builder_str = "[";
        for (int i = 0; i < index; i++) {
            if (i + 1 == index) {
                builder_str += array[i];
            } else {
                builder_str += array[i] + ",";
            }
        }
        builder_str += "]";
        return builder_str;
    }

    //    public void sort(String rowtype) {
//        if (0 < index) {
//            Object[] sorted = new Object[index];
//            sorted[0] = array[0];
//            if (rowtype.equals("dcs")) {
//
//                for (int i = 1; i < index; i++) {
//                    for (int j = index; j < 0; j--){
//                        if (array[i] > sorted[i])
//                    }
//                }
//            } else if (rowtype.equals("ris")) {
//
//            }
//        }
//    }
    public void sort(String rowtype) {
        if (rowtype.equals("dcs")) {
            Arrays.sort(array);
        } else if (rowtype.equals("ris")) {
            Arrays.sort(array);
        }
    }

    public void clear() {
        index = 0;
    }
}
