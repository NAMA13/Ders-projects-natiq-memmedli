package com.company;

public class Call {
    public static void main(String[] args) {
        double agac = 20;
        double versu = 1;
        double gun = 0;
        while(agac < 3000){
            double rol = 2 * versu;
            agac+= rol;
            versu = versu * 1.5;
            System.out.println("-----------");
            System.out.println("Versu; " + versu);
            System.out.println("Agac; " + agac);
            gun += 1;
        }
        System.out.println("-----------");
        System.out.println(gun);
    }
}
//
//        Bağban bugün ağac əkdi.
//        Bu ağacın hündürlüyü 20 sm-dir.
//        Bu gün ona 1 lirt su verdi.
//        Ağac hər 1 lirt su veriləndə 2 sm uzanır.
//        Bağban hər sonrakı gündə əvvəlki günün suyundan 1.5 dəfə çox su verir.
//        Neçə günnən sonra ağar 30 metr hündürlüyü keçəcək?