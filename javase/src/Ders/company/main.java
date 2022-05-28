package Ders.company;

public class main {
    public static void main(String[] args) {
        list <Integer> numbers = new list();
        numbers.add(103);
        numbers.add(98);
        numbers.add(23);
        numbers.add(232);
        numbers.add(35);
        numbers.add(55);
        numbers.add(78);
        System.out.println(numbers.toSTR());
        System.out.println(numbers.length());
        System.out.println(numbers.contains(100));
        numbers.Tremove(2);
        System.out.println(numbers.toSTR());
        numbers.replace(3, 300);
        System.out.println(numbers.toSTR());
        numbers.shuffle();
        numbers.sort("dcs");
        numbers.sort("res");
        numbers.clear();
        System.out.println(numbers.toSTR());

    }
}
