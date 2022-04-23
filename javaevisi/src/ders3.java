public class ders3 {
    public static void main(String[] args) {
        int result = 0;
        for (int i = 0; i < 50; i++){
            if (0 != (i % 2)){
                result += i;
                System.out.println(i);
            }
        }
        System.out.println(result);
    }
}
