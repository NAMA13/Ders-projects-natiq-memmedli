package ders2;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;

public class MainTarixlerEvCalismasi {
    public static void main(String[] args) {
        ArrayList <person> array = new ArrayList();
        person a = new person();
        for (int i = 0; i < 5; i++){
            a.id = a.id + 1;
            a.name = "Blmm";
            array.add(a);

        }
        System.out.println(array.toString());

    }
}
