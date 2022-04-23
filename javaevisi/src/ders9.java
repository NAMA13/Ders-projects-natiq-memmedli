

public class ders9 {
    public static void main(String[] args) {

        for (int i = 0; i < 12; i++) {
            if (i < 5) {
                for (int i1 = 0; i1 < 46; i1++) {
                    if (i1 < 13) {
                        System.out.print(" " + "* ");
                    }
                    if (i1 > 12) {
                        System.out.print("=");
                    }
                }
            }
            if (i > 4) {
                for (int i1 = 0; i1 < 59; i1++) {
                    System.out.print("=");
                }
            }
            System.out.println();
        }
    }

}
