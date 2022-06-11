package ders22;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Date;

public class main {
    public static void main(String[] args) {
        try {
            FileWriter flr = new FileWriter("C:\\Users\\KH/Desktop/natig.txt");
            int day = 1;
            for (int i = 0; i < 5; i++){

                LocalDate date1 = LocalDate.of(2014, 9, day);
                day += 7;
                flr.write(date1.toString() + "\n");
            }
            flr.close();
        } catch (Error error) {
            System.out.println("An error. \n" + error);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

