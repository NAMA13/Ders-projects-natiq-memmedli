package ders2;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;

public class Mainperson {
    public static void main(String[] args) {
        ArrayList <person> arr = new ArrayList();

        arr.add(new person(1, "Natiq", LocalDate.of(2008, 7, 6)));
        arr.add(new person(2, "Uzeyir", LocalDate.of(2006, 7, 6)));
        arr.add(new person(3, "Nihad", LocalDate.of(2007, 7, 6)));

        arr.toString();
        Collections.sort(arr);
        arr.toString();

    }
}
