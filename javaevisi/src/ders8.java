import java.util.Scanner;

public class ders8 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter R : ");
        int r = sc.nextInt();

        double kurehecm =  (Math.PI * r) * (Math.PI * r) * (Math.PI * r) / 3 * 4;
        System.out.println(kurehecm);

    }
}
