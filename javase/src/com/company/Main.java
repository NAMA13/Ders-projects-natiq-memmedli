package com.company;

import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

public class Main {

    public static void main(String[] args) {

        System.out.println("1. Calisma");
        System.out.println("-----------------------");

        int[] nums = new int[15];

        for (int i = 0; i < nums.length; i++) {
            Random r = new Random();
            nums[i] = r.nextInt();
        }

        String[] ltrs = {"Natiq", "Nihad", "Uzeyir", "Huseyn", "Mehemmed", "Umid"};

        Arrays.sort(nums);
        System.out.println("Sorted array : " + Arrays.toString(nums));

        Arrays.sort(ltrs);
        System.out.println("Sorted array : " + Arrays.toString(ltrs));


        System.out.println("-----------------------");
        System.out.println("2. Calisma");
        System.out.println("-----------------------");

        int[] nums2 = new int[15];

        for (int i = 0; i < nums2.length; i++) {
            Random r = new Random();
            nums2[i] = r.nextInt();
        }

        int result = 0;

        for (int i = 1; i < nums2.length; i++) {
            result += nums2[i];
        }

        System.out.println("Array : " + Arrays.toString(nums2));

        System.out.println(result);

        System.out.println("-----------------------");
        System.out.println("3. Calisma");
        System.out.println("-----------------------");

        for (int i = 0; i < 10; i++) {
            for (int i1 = 0; i1 < 10; i1++) {
                if (i1 < 1) {
                    System.out.print("- ");
                } else {
                    System.out.print(" - ");
                }

            }
            System.out.println();
        }

        System.out.println("-----------------------");
        System.out.println("4. Calisma");
        System.out.println("-----------------------");

        int[] nums3 = new int[10];

        for (int i = 0; i < nums3.length; i++) {
            Random r = new Random();
            nums3[i] = r.nextInt();
        }

        int average = 0;

        for (int i = 1; i < nums3.length; i++) {
            average += nums3[i];
        }

        average = average / nums3.length;

        System.out.println("Average :" + average);

        System.out.println("-----------------------");
        System.out.println("5. Calisma");
        System.out.println("-----------------------");


        class evisi {
            public boolean contains(int[] arr, int reqem) {
                for (int n : arr) {
                    if (reqem == n) {
                        return true;
                    }
                }
                return false;
            }

            public void main() {
                int[] arr4 = {46462, 45264256, 1894256359, 2464526, 2455};
                System.out.println(contains(arr4, 2455));
                System.out.println(contains(arr4, 2015));
            }
        }
        var evisi = new evisi();
        evisi.main();

        System.out.println("-----------------------");
        System.out.println("6. Calisma");
        System.out.println("-----------------------");

        class evisis2 {
            public int findIndex(int[] arr, int target) {
                for (int i = 0; i < arr.length; i++) {
                    if (target == arr[i]) {
                        return i;
                    }
                }
                return -1;
            }

            public void main() {
                int[] arr5 = {45, 87, 54, 384, 3483, 483843, 4863, 483};
                System.out.println("Index is: " + findIndex(arr5, 45));
                System.out.println("Index is: " + findIndex(arr5, 77));
            }
        }
        var evisis2 = new evisis2();
        evisis2.main();

        System.out.println("-----------------------");
        System.out.println("7. Calisma");
        System.out.println("-----------------------");

        class evisis3 {
            public int[] remove(int[] arr, int target) {
                int index = 0;

                for (int i = 0; i < arr.length; i++) {
                    if (target == arr[i]) {
                        index = i;
                    }
                }

                for (int i = index; i < arr.length - 1; i++) {
                    arr[i] = arr[i + 1];
                }
                return arr;
            }

            public void main() {
                int[] arr3 = {45, 87, 54, 384, 3483, 483843, 4863, 483};
                System.out.println("Remove is: " + Arrays.toString(remove(arr3, 45)));
                System.out.println("Remove is: " + Arrays.toString(remove(arr3, 3483)));
            }
        }

        var evisis3 = new evisis3();
        evisis3.main();

        System.out.println("-----------------------");
        System.out.println("8. Calisma");
        System.out.println("-----------------------");

        int[] nums8 = {53, 453, 453, 453453, 453, 453, 543, 453, 453, 543, 5415, 414, 454, 544, 5414};
        int[] nums9 = new int[15];

        for (int i = 0; i < nums8.length; i++) {
            nums9[i] = nums8[i];
        }

        System.out.println(Arrays.toString(nums8));
        System.out.println(Arrays.toString(nums9));

        System.out.println("-----------------------");
        System.out.println("10. Calisma");
        System.out.println("-----------------------");

        int[] nums10 = new int[15];

        for (int i = 0; i < nums10.length; i++) {
            Random r = new Random();
            nums10[i] = r.nextInt();
        }

        int min = 0;
        int max = 0;

        for (int i = 0; i < nums10.length; i++) {
            if (nums10[i] < min) {
                min = nums10[i];
            }
            if (nums10[i] > max) {
                max = nums10[i];
            }
        }
        System.out.println(Arrays.toString(nums10));
        System.out.println(min);
        System.out.println(max);

        System.out.println("-----------------------");
        System.out.println("11. Calisma");
        System.out.println("-----------------------");

        int[] nums11 = {50, 2, 5, 5, 656, 50, 270};

        for (int i = 0; i < nums11.length; i++) {
            for (int j = 0; j < nums11.length; j++) {
                if (nums11[i] == nums11[j] && (i != j)) {
                    System.out.println("Fond Duplicaed Item ; " + nums11[i]);
                }

            }
        }

        System.out.println("-----------------------");
        System.out.println("12. Calisma");
        System.out.println("-----------------------");

        String[] string = {"n", "a", "t", "i", "q", "f", "n"};

        for (int i = 0; i < string.length; i++) {
            for (int j = 0; j < string.length; j++) {
                if (string[i].equals(string[j]) && (i != j)) {
                    System.out.println("Fond Duplicaed Item ; " + string[i]);
                }

            }
        }

        System.out.println("-----------------------");
        System.out.println("13  . Calisma");
        System.out.println("-----------------------");

        String[] ltrs2 = {"Natiq", "Nihad", "Uzeyir", "Huseyn", "Mehemmed", "Umid"};

        String[] ltrs3 = {"Natiq", "Nihad2", "Uzeyir", "Huseyn2", "Mehemmed2", "Umid2"};

        String[] ltrs4 = new String[ltrs3.length + ltrs2.length];

        for (int i = 0; i < ltrs2.length; i++) {
            for (int j = 0; j < ltrs3.length; j++) {
                if (ltrs2[i].equals(ltrs3[j])) {
                    System.out.println(ltrs2[i]);
                }
            }
        }

        System.out.println("-----------------------");
        System.out.println("14  . Calisma");
        System.out.println("-----------------------");

        int[] nums15 = {53, 453, 453, 453453, 453, 453, 543, 453, 453, 543, 5415, 414, 454, 544, 5414};

        int[] nums16 = {5324, 452, 245, 453453, 452, 254, 452, 453, 452, 452, 452, 245, 452, 452, 52};


        for (int i = 0; i < nums15.length; i++) {
            for (int j = 0; j < nums16.length; j++) {
                if (nums15[i] == nums16[j]) {
                    System.out.println(nums15[i]);
                }
            }
        }

        System.out.println("-----------------------");
        System.out.println("15  . Calisma");
        System.out.println("-----------------------");

        int[] nums17 = {53, 453, 752, 453453, 452, 453, 53, 25, 45, 543, 5415, 414, 454, 544, 5414};

        System.out.println(Arrays.toString(nums17));


        for (int i = 0; i < nums17.length; i++) {
            for (int j = 0; j < nums17.length; j++) {
                if (nums17[i] == nums17[j] && (i != j)) {
                    evisis3.remove(nums17, nums17[j]);
                }
            }
        }
        System.out.println(Arrays.toString(nums17));

        System.out.println("-----------------------");
        System.out.println("17  . Calisma iiksini birlikde");
        System.out.println("-----------------------");

        int[] nums19 = {53, 453, 752, 453453, 452, 453, 53, 25, 45, 543, 5415, 414, 454, 544, 5414};
        Arrays.sort(nums19);
        System.out.println(Arrays.toString(nums19));
        System.out.println("Secont Max : " + nums19[1]);
        System.out.println("Secont Min : " + nums19[nums19.length -2]);

        System.out.println("-----------------------");
        System.out.println("19  . Calisma");
        System.out.println("-----------------------");

    }
}