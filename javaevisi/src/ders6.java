import java.util.Scanner;

public class ders6 {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        double dr;
        double l, s;

        System.out.print("Please enter an number: ");

        double radiuss = input.nextDouble();

        dr = 2 * radiuss;
        l = 2 * Math.PI * radiuss;
        s = Math.PI * radiuss * radiuss;

        System.out.println("Uzunluq " + l);
        System.out.println("Sahe " + s);

    }
}
