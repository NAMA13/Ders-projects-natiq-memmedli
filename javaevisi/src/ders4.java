import java.util.Scanner;

public class ders4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("PLease Enter Last Number : ");
        int number = sc.nextInt();

        int sum = 0;

        for (int i = 1; i <= number; i++) {
            if (i % 3 == 0){
                System.out.println(i);
                sum += i;
            }
        }
    }
}
